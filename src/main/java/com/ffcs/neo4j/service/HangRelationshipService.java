package com.ffcs.neo4j.service;

import com.ffcs.neo4j.entity.HangRelationship;

import java.util.List;

public interface HangRelationshipService {
    //CREATE
    void add(HangRelationship hangRelationship);

    //DELETE
    void deleteAll();
    void deleteHangRelationshipByFeatureId(String featureId);

    //UPDATE
    HangRelationship updateHangRelationshipByFeatureId(String featureId,String imageId,String imageShowPath);
    HangRelationship updateImageIdByFeatureId(String featureId,String imageId);
    HangRelationship updateImageShowPathByFeatureId(String featureId,String imageShowPath);

    //SELECT
    Iterable<HangRelationship> findAll();

    boolean isExist(HangRelationship hangRelationship);
}
