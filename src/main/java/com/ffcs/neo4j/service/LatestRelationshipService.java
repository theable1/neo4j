package com.ffcs.neo4j.service;

import com.ffcs.neo4j.entity.LatestRelationship;

public interface LatestRelationshipService {
    //CREATE
    void add(LatestRelationship latestRelationship);

    //DELETE
    void deleteAll();
    void deleteLatestRelationship(LatestRelationship latestRelationship);


}
