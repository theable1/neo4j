package com.ffcs.neo4j.service.impl;

import com.ffcs.neo4j.entity.PersonNode;
//import com.ffcs.neo4j.repository.ImageNodeRepository;
import com.ffcs.neo4j.repository.PersonNodeRepository;
//import com.ffcs.neo4j.service.ImageNodeService;
import com.ffcs.neo4j.service.PersonNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonNodeServiceImpl implements PersonNodeService {
    @Autowired
    PersonNodeRepository personNodeRepository;

    @Override
    public void add(PersonNode personNode) {

    }

    @Override
    public void addPersonNodeList(List<PersonNode> personNodeList) {

    }

    @Override
    public PersonNode getPersonNodeByFeatureId(String featureId) {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deletePersonNodeByFeatureId(String featureId) {

    }

    @Override
    public PersonNode updatePersonNodeByFeatureId(String featureId) {
        return null;
    }

    @Override
    public Iterable<PersonNode> findAll() {
        return null;
    }

    @Override
    public PersonNode findPersonNodeByImageNode(String featureId) {
        return null;
    }

    @Override
    public boolean isExist(PersonNode personNode) {
        return false;
    }
}
