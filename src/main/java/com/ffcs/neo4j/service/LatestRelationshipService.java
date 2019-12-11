package com.ffcs.neo4j.service;

import com.ffcs.neo4j.entity.LatestRelationship;

public interface LatestRelationshipService {
    //CREATE
    void add(LatestRelationship latestRelationship);

    //DELETE
    void deleteAll();
    void deleteLatestRelationshipByFeatureId(String featureId);

    //UPDATE
    LatestRelationship updateLatestRelationshipByFeatureId(String featureId,String imageId,String imageShowPath);
    LatestRelationship updateImageIdByFeatureId(String featureId,String imageId);
    LatestRelationship updateImageShowPathByFeatureId(String featureId,String imageShowPath);

    //SELECT
    Iterable<LatestRelationship> findAll();

    boolean isExist(LatestRelationship latestRelationship);
}
