package com.ffcs.neo4j.service;

import com.ffcs.neo4j.entity.OccurDateNode;
import com.ffcs.neo4j.entity.PersonNode;

import java.util.List;

public interface PersonNodeService {
    //CREATE
    void add(PersonNode personNode);

    //DELETE
    void deleteAll();
    void deletePersonNodeByFeatureId(String featureId);

    //UPDATE
    PersonNode updatePersonNodeByFeatureId(String featureId);

    //SELECT
    Iterable<PersonNode> findAll();
    PersonNode getPersonNodeByFeatureId(String featureId);

}
