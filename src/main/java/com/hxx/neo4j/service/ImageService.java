package com.hxx.neo4j.service;


import com.hxx.neo4j.entity.ImageNode;

import java.util.List;

public interface ImageService {
    void addImageNodeList(List<ImageNode> imageNodeList);
    //deleteAll会把全部节点和关系全部删除，慎用。
    void deleteAll();
    ImageNode deleteImageNodeByFeatureId(String featureId);
    ImageNode getImageNodeByFeatureId(String featureId);
    Iterable<ImageNode> findAll();
    ImageNode updateImageNodeByFeatureId(String featureId,String imageId,String imageShowPath);
    ImageNode updateImageIdByFeatureId(String featureId,String imageId);
    ImageNode updateImageShowPathByFeatureId(String featureId,String imageShowPath);
    boolean isexist(ImageNode imageNode);
}
