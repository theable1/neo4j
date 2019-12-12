package com.ffcs.neo4j.service;

import com.ffcs.neo4j.entity.HangRelationship;

import java.util.List;

public interface HangRelationshipService {
    //CREATE
    void add(HangRelationship hangRelationship);

    //DELETE
    void deleteAll();
    void deleteHangRelationship(HangRelationship hangRelationship);


}
