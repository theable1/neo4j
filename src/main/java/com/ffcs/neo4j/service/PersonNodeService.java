package com.ffcs.neo4j.service;

import com.ffcs.neo4j.entity.ImageNode;
import com.ffcs.neo4j.entity.PersonNode;

import java.util.List;

public interface PersonNodeService {
    //CREATE
    void add(PersonNode personNode);

    void addPersonNodeList(List<PersonNode> personNodeList);

    //DELETE
    void deleteAll();

    void deletePerson(PersonNode personNode);

    //UPDATE
    PersonNode updatePersonNode(long featureId, long newFeatureId, String name);

    PersonNode updateFeatureIdByFeatureId(long featureId, long newFeatureId);

    PersonNode updateNameByFeatureId(long featureId, String name);

    //SELECT
    Iterable<PersonNode> findAll();
    PersonNode findPersonNodeByFeatureId(long featureId);
    PersonNode findPersonNodeByImageFeatureId(long featureId);


    boolean isExist(PersonNode personNode);
}
