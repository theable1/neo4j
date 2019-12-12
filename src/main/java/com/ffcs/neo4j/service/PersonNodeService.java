package com.ffcs.neo4j.service;

import com.ffcs.neo4j.entity.PersonNode;

import java.util.List;

public interface PersonNodeService {
    //CREATE
    void add(PersonNode personNode);
    void addPersonNodeList(List<PersonNode> personNodeList);
    PersonNode getPersonNodeByFeatureId(String featureId);

    //DELETE
    void deleteAll();
    void deletePersonNodeByFeatureId(String featureId);

    //UPDATE
    PersonNode updatePersonNodeByFeatureId(String featureId);

    //SELECT
    Iterable<PersonNode> findAll();
    PersonNode findPersonNodeByImageNode(String featureId);


    boolean isExist(PersonNode personNode);
}
