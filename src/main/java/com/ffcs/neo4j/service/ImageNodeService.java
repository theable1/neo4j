package com.ffcs.neo4j.service;

import com.ffcs.neo4j.entity.ImageNode;

import java.util.List;

public interface ImageNodeService {
    //CREATE
    void add(ImageNode imageNode);

    void addList(List<ImageNode> imageNodeList);

    //DELETE
    void deleteAll();

    void delete(ImageNode imageNode);

    //UPDATE
    ImageNode updateImageNode(long featureId, String imageId, String imageUrl, String saveTime);

    ImageNode updateImageIdByFeatureId(long featureId, String imageId);

    ImageNode updateImageUrlByFeatureId(long featureId, String imageUrl);

    ImageNode updateSaveTimeByFeatureId(long featureId, String saveTime);
    //SEARCH
    ImageNode findImageNodeByFeatureId(long featureId);
    Iterable<ImageNode> findAll();
    Boolean isExist(ImageNode imageNode);
}
