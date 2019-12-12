package com.ffcs.neo4j.service;

import com.ffcs.neo4j.entity.NextRelationship;

public interface NextRelationshipService {
    //CREATE
    void add(NextRelationship nextRelationship);

    //DELETE
    void deleteAll();
    void deleteNextRelationshipByFeatureId(String featureId);

    //UPDATE
    NextRelationship updateNextRelationshipByFeatureId(String featureId,String imageId,String imageShowPath);
    NextRelationship updateImageIdByFeatureId(String featureId,String imageId);
    NextRelationship updateImageShowPathByFeatureId(String featureId,String imageShowPath);

    //SELECT
    Iterable<NextRelationship> findAll();

    boolean isExist(NextRelationship nextRelationship);
}
