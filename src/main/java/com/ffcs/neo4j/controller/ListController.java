package com.ffcs.neo4j.controller;

import com.ffcs.neo4j.entity.HangRelationship;
import com.ffcs.neo4j.entity.ImageNode;
import com.ffcs.neo4j.entity.OccurDateNode;
import com.ffcs.neo4j.entity.PersonNode;
import com.ffcs.neo4j.service.HangRelationshipService;
import com.ffcs.neo4j.service.ImageNodeService;
import com.ffcs.neo4j.service.OccurDateNodeService;
import com.ffcs.neo4j.service.PersonNodeService;
import com.ffcs.neo4j.util.DateUtils;
import com.ffcs.neo4j.vo.ImageVO;
import com.ffcs.neo4j.vo.SearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/neo4j/")
public class ListController {
    @Autowired
    PersonNodeService personNodeServiceImpl;
    @Autowired
    OccurDateNodeService occurDateNodeServiceImpl;
    @Autowired
    ImageNodeService imageNodeServiceImpl;
    @Autowired
    HangRelationshipService hangRelationshipServiceImpl;

    @RequestMapping("add")
    public void add(@RequestBody ImageVO imageVO) {
        if (imageVO.getSimilarFeatureId() == null) {
            //没有Person节点
            //创建Person节点
            PersonNode personNode = new PersonNode();
            personNode.setFeatureId(imageVO.getFeatureId());
            PersonNode newPersonNode = personNodeServiceImpl.add(personNode);
            //创建OccurDate节点，和Date关系。
            OccurDateNode occurDateNode = new OccurDateNode();
            occurDateNode.setDate(imageVO.getOccurDateTime());
            OccurDateNode newOccurDateNode = occurDateNodeServiceImpl.add(newPersonNode, occurDateNode);
            //创建Image节点
            ImageNode imageNode = new ImageNode();
            imageNode.setFeatureId(imageVO.getFeatureId());
            imageNode.setImageUrl(imageVO.getImageUrl());
            imageNode.setImageId(imageVO.getImageId());
            SimpleDateFormat saveTime = new SimpleDateFormat("yyyy-MM-dd");
            imageNode.setSaveTime(saveTime.format(new Date()));
            ImageNode newImageNode = imageNodeServiceImpl.add(imageNode);
            //创建HANG关系
            HangRelationship hangRelationship = new HangRelationship();
            hangRelationship.setImageNode(newImageNode);
            hangRelationship.setOccurDateNode(newOccurDateNode);
            hangRelationshipServiceImpl.add(hangRelationship);
        } else {
            //有Person节点
            PersonNode personNode = personNodeServiceImpl.findPersonNodeByImageFeatureId(imageVO.getSimilarFeatureId());
            OccurDateNode occurDateNode = occurDateNodeServiceImpl.getOccurDateNodeByPersonNode(personNode, imageVO.getOccurDateTime());
            if (occurDateNode == null) {
                //不存在此时间节点，添加时间关系，图片，关系
                OccurDateNode newOccurDateNode = new OccurDateNode(imageVO.getOccurDateTime());
                OccurDateNode occurDateNode1 = occurDateNodeServiceImpl.add(personNode, newOccurDateNode);
                ImageNode imageNode = new ImageNode(imageVO.getFeatureId(), imageVO.getImageId(), imageVO.getImageUrl(), new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                HangRelationship hangRelationship = new HangRelationship(occurDateNode1, imageNode);
                hangRelationshipServiceImpl.add(hangRelationship);
            } else {
                //存在此时间节点，添加图片和关系
                ImageNode imageNode = new ImageNode(imageVO.getFeatureId(), imageVO.getImageId(), imageVO.getImageUrl(), new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                HangRelationship hangRelationship = new HangRelationship(occurDateNode, imageNode);
                hangRelationshipServiceImpl.add(hangRelationship);
            }
        }

    }

    @RequestMapping("search")
    public Object search(@RequestBody SearchVO searchVO) {
        if (searchVO.getSimilarFeatureId() == null) {
            //没有相似图片
            return null;
        } else {
            PersonNode personNode = personNodeServiceImpl.findPersonNodeByImageFeatureId(searchVO.getSimilarFeatureId());
            List<OccurDateNode> occurDateNodeList = occurDateNodeServiceImpl.getOccurDateListByPersonNode(personNode);
            List<Map<String,Object>> resultList = new ArrayList<>();

            for (OccurDateNode occurDateNode : occurDateNodeList) {
                Date date = new Date();
                try {
                     date = DateUtils.strToDate(occurDateNode.getDate());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if((date.before(searchVO.getEndTime()) && date.after(searchVO.getStartTime())) || date.equals(searchVO.getStartTime()) || date.equals(searchVO.getEndTime()) ){
                    Map<String,Object> map = new HashMap<>();
                    map.put("date",occurDateNode.getDate());
                    List<ImageNode> imageNodeList = imageNodeServiceImpl.findAllByOccurDate(occurDateNode.getId());
                    List<String> imageUrlList = new ArrayList<>();
                    for (ImageNode imageNode : imageNodeList) {
                        imageUrlList.add(imageNode.getImageUrl());
                    }
                    map.put("imageUrlList",imageUrlList);
                    resultList.add(map);
                }
            }
            return resultList;
        }
    }

}
