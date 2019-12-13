package com.ffcs.neo4j.service;

import com.ffcs.neo4j.entity.ImageNode;

import java.util.List;

public interface ImageNodeService {
    //CREATE
    ImageNode add(ImageNode imageNode);

    void addList(List<ImageNode> imageNodeList);

    //DELETE
    void deleteAll();

    void delete(ImageNode imageNode);

    //UPDATE
    ImageNode updateImageNode(Long featureId, String imageId, String imageUrl, String saveTime);

    ImageNode updateImageIdByFeatureId(Long featureId, String imageId);

    ImageNode updateImageUrlByFeatureId(Long featureId, String imageUrl);

    ImageNode updateSaveTimeByFeatureId(Long featureId, String saveTime);
    //SEARCH
    ImageNode findImageNodeByFeatureId(Long featureId);
    Iterable<ImageNode> findAll();
    Boolean isExist(ImageNode imageNode);
}
