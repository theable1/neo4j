package com.ffcs.neo4j.service;


import com.ffcs.neo4j.entity.ImageNode;

import java.util.List;

public interface ImageNodeService {
    //CREATE
    void add(ImageNode imageNode);
    void addImageNodeList(List<ImageNode> imageNodeList);
    ImageNode getImageNodeByFeatureId(String featureId);

    //DELETE
    void deleteAll();
    void deleteImageNodeByFeatureId(String featureId);

    //UPDATE
    ImageNode updateImageNodeByFeatureId(String featureId,String imageId,String imageShowPath);
    ImageNode updateImageIdByFeatureId(String featureId,String imageId);
    ImageNode updateImageShowPathByFeatureId(String featureId,String imageShowPath);

    //SELECT
    Iterable<ImageNode> findAll();

    boolean isExist(ImageNode imageNode);
}
