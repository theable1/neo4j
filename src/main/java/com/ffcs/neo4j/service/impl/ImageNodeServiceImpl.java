package com.ffcs.neo4j.service.impl;

import com.ffcs.neo4j.entity.ImageNode;
import com.ffcs.neo4j.entity.PersonNode;
import com.ffcs.neo4j.repository.ImageNodeRepository;
import com.ffcs.neo4j.service.ImageNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageNodeServiceImpl implements ImageNodeService {
    @Autowired
    ImageNodeRepository imageNodeRepository;

    //CREATE
    @Override
    public void add(ImageNode imageNode) {
        boolean isExist = isExist(imageNode);
        if(isExist==false){
            imageNodeRepository.save(imageNode);
            System.out.println("添加成功！");
        }else {
            System.out.println("此图片节点已存在！添加失败！");
        }
    }

    @Override
    public void addList(List<ImageNode> imageNodeList) {
        for (ImageNode i : imageNodeList) {
            boolean isExist = isExist(i);
            if(isExist==false){
                imageNodeRepository.save(i);
                System.out.println("添加成功！");
            }else {
                System.out.println("此图片节点已存在！添加失败！");
            }
        }
    }
    //DELETE

    @Override
    public void deleteAll() {
        imageNodeRepository.deleteAll();
    }

    @Override
    public void delete(ImageNode imageNode) {
        imageNodeRepository.delete(imageNode);
    }
    //UPDATE

    @Override
    public ImageNode updateImageNode(long featureId, String imageId, String imageUrl, String saveTime) {
        ImageNode imageNode = imageNodeRepository.updateImageNode(featureId, imageId, imageUrl, saveTime);
        return imageNode;
    }

    @Override
    public ImageNode updateImageIdByFeatureId(long featureId, String imageId) {
        ImageNode imageNode = imageNodeRepository.updateImageIdByFeatureId(featureId, imageId);
        return imageNode;
    }

    @Override
    public ImageNode updateImageUrlByFeatureId(long featureId, String imageUrl) {
        ImageNode imageNode = imageNodeRepository.updateImageUrlByFeatureId(featureId, imageUrl);
        return imageNode;
    }

    @Override
    public ImageNode updateSaveTimeByFeatureId(long featureId, String saveTime) {
        ImageNode imageNode = imageNodeRepository.updateSaveTimeByFeatureId(featureId, saveTime);
        return imageNode;
    }

    //SEARCH
    @Override
    public Iterable<ImageNode> findAll() {
        Iterable<ImageNode> imageNodes = imageNodeRepository.findAll();
        return imageNodes;
    }

    @Override
    public ImageNode findImageNodeByFeatureId(long featureId) {
        ImageNode imageNode = imageNodeRepository.findImageNodeByFeatureId(featureId);
        return imageNode;
    }

    @Override
    public Boolean isExist(ImageNode imageNode) {
        Iterable<ImageNode> imageNodeList = findAll();
        for (ImageNode i : imageNodeList) {
            if (i.getFeatureId().equals(imageNode.getFeatureId())){
                return true;
            }
        }
        return false;
    }
}
