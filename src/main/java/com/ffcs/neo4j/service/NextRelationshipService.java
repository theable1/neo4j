package com.ffcs.neo4j.service;

import com.ffcs.neo4j.entity.NextRelationship;

public interface NextRelationshipService {
    //CREATE
    void add(NextRelationship nextRelationship);

    //DELETE
    void deleteAll();
    void deleteNextRelationship(NextRelationship nextRelationship);
}
