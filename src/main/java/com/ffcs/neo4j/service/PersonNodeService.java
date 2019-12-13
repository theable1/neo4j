package com.ffcs.neo4j.service;

import com.ffcs.neo4j.entity.PersonNode;

import java.util.List;

public interface PersonNodeService {
    //CREATE
    PersonNode add(PersonNode personNode);

    void addPersonNodeList(List<PersonNode> personNodeList);

    //DELETE
    void deleteAll();

    void deletePerson(PersonNode personNode);

    //UPDATE
    PersonNode updatePersonNode(Long featureId, Long newFeatureId, String name);

    PersonNode updateFeatureIdByFeatureId(Long featureId, Long newFeatureId);

    PersonNode updateNameByFeatureId(Long featureId, String name);

    //SELECT
    Iterable<PersonNode> findAll();
    PersonNode findPersonNodeByFeatureId(Long featureId);
    PersonNode findPersonNodeByImageFeatureId(Long featureId);


    boolean isExist(PersonNode personNode);
}
