package com.ffcs.neo4j.service.impl;

import com.ffcs.neo4j.entity.*;
import com.ffcs.neo4j.repository.LatestRelationshipRepository;
import com.ffcs.neo4j.repository.NextRelationshipRepository;
import com.ffcs.neo4j.repository.OccurDateNodeRepository;
import com.ffcs.neo4j.repository.PersonNodeRepository;
import com.ffcs.neo4j.service.LatestRelationshipService;
import com.ffcs.neo4j.service.NextRelationshipService;
import com.ffcs.neo4j.service.OccurDateNodeService;
import com.ffcs.neo4j.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class OccurDateNodeServiceImpl implements OccurDateNodeService {
    @Autowired
    OccurDateNodeRepository occurDateNodeRepository;
    @Autowired
    LatestRelationshipRepository latestRelationshipRepository;
    @Autowired
    NextRelationshipRepository nextRelationshipRepository;
    @Autowired
    PersonNodeRepository personNodeRepository;

    @Override
    public void add(PersonNode person, OccurDateNode occurDateNode) {
        //防止person节点id为null，无法删除相关关系
        PersonNode personNode = personNodeRepository.findPersonNodeByImageNode(person.getFeatureId());
        if (!this.isExist(personNode, occurDateNode)) {
            //新添日期节点不存在，可添加
            OccurDateNode dateNode = occurDateNodeRepository.save(occurDateNode);
            OccurDateNode latestDateNode = this.getLatestOccurDateNodeByPersonNode(personNode);
            List<OccurDateNode> list = this.getOccurDateListByPersonNode(personNode);
            OccurDateNode minDateNode = list.get(list.size() - 1);
            Date latest = null;
            Date newDate = null;
            Date minDate = null;
            try {
                latest = DateUtils.strToDate(latestDateNode.getDate());
                newDate = DateUtils.strToDate(occurDateNode.getDate());
                minDate = DateUtils.strToDate(minDateNode.getDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (latest.before(newDate)) {
                //新添加的时间在目前的最新时间之后
                //1、删除原本的LATEST关系
                LatestRelationship latestRelationship = new LatestRelationship();
                latestRelationship.setPersonNode(personNode);
                latestRelationship.setOccurDateNode(latestDateNode);
                latestRelationshipRepository.delete(latestRelationship);
                //2、原本的最新时间节点指向新添时间节点
                NextRelationship nextRelationship = new NextRelationship();
                nextRelationship.setStartDateNode(latestDateNode);
                nextRelationship.setEndDateNode(dateNode);
                nextRelationshipRepository.save(nextRelationship);
                //3、新时间节点指向Person节点
                latestRelationship.setPersonNode(personNode);
                latestRelationship.setOccurDateNode(dateNode);
                latestRelationshipRepository.save(latestRelationship);
                System.out.println(dateNode.getDate()+"日期节点为最新日期");
            } else if (minDate.after(newDate)) {
                //新添日期在最早日期之前
                //新添时间节点指向原本的最早日期节点
                NextRelationship nextRelationship = new NextRelationship();
                nextRelationship.setStartDateNode(dateNode);
                nextRelationship.setEndDateNode(minDateNode);
                nextRelationshipRepository.save(nextRelationship);
                System.out.println(dateNode.getDate()+"日期节点为最小日期");
            } else {
                //新添加的时间插入时间节点之间
                //1、遍历person节点的所有日期节点,比较日期，找出新添日期节点的前后日期节点
                OccurDateNode nextNode = null;
                OccurDateNode previousNode = null;
                //list的时间节点是从大到小排序
                for (int i = 0; i < list.size() ; i++) {
                    Date date = null;
                    try {
                        date = DateUtils.strToDate(list.get(i).getDate());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if (date.before(newDate)) {
                        previousNode = list.get(i);
                        nextNode = list.get(i-1);
                        break;
                    }
                }
                //3、删除前后日期节点的next关系
                NextRelationship nextRelationship = new NextRelationship();
                nextRelationship.setStartDateNode(previousNode);
                nextRelationship.setEndDateNode(nextNode);
                nextRelationshipRepository.delete(nextRelationship);
                //4、新建新添节点和前后节点的关系
                nextRelationship.setStartDateNode(previousNode);
                nextRelationship.setEndDateNode(dateNode);
                nextRelationshipRepository.save(nextRelationship);
                nextRelationship.setStartDateNode(dateNode);
                nextRelationship.setEndDateNode(nextNode);
                nextRelationshipRepository.save(nextRelationship);
                System.out.println(dateNode.getDate()+"日期节点插入到"+previousNode.getDate()+"节点和"+nextNode.getDate()+"节点之间");
            }
        } else {
            System.out.println("featureId为"+personNode.getFeatureId() + "的Person节点" + occurDateNode.getDate() + "时间节点已存在");
        }
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Iterable<OccurDateNode> findAll() {
        return null;
    }

    @Override
    public OccurDateNode getLatestOccurDateNodeByPersonNode(PersonNode personNode) {
        OccurDateNode latestOccurDateNode = occurDateNodeRepository.getLatestOccurDateNodeByPersonNode(personNode.getFeatureId());
        return latestOccurDateNode;
    }

//    @Override
//    public OccurDateNode getLatestOccurDateNodeByImageNode(ImageNode imageNode) {
//        return null;
//    }
//
//    @Override
//    public OccurDateNode getOccurDateNodeByImageNode(ImageNode imageNode) {
//        return null;
//    }

    @Override
    public OccurDateNode getNextOccurDateNode(OccurDateNode occurDateNode) {
        OccurDateNode nextOccurDateNode = occurDateNodeRepository.getNextOccurDateNode(occurDateNode.getId());
        return nextOccurDateNode;
    }

    @Override
    public OccurDateNode getPreviousOccurDateNode(OccurDateNode occurDateNode) {
        OccurDateNode previousOccurDateNode = occurDateNodeRepository.getPreviousOccurDateNode(occurDateNode.getId());
        return previousOccurDateNode;
    }

    @Override
    public List<OccurDateNode> getOccurDateListByPersonNode(PersonNode personNode) {
        OccurDateNode latestDate = this.getLatestOccurDateNodeByPersonNode(personNode);
        List<OccurDateNode> list = new ArrayList<>();
        list.add(latestDate);
        OccurDateNode previousOccurDateNode = this.getPreviousOccurDateNode(latestDate);
        while (previousOccurDateNode != null) {
            list.add(previousOccurDateNode);
            previousOccurDateNode = this.getPreviousOccurDateNode(previousOccurDateNode);
        }
        return list;
    }

    @Override
    public boolean isExist(PersonNode personNode, OccurDateNode occurDateNode) {
        List<OccurDateNode> list = this.getOccurDateListByPersonNode(personNode);
        for (OccurDateNode dateNode : list) {
            if (dateNode.getDate().equals(occurDateNode.getDate())) {
                return true;
            }
        }
        return false;
    }
}
