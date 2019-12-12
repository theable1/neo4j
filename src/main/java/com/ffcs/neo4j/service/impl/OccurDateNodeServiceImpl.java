package com.ffcs.neo4j.service.impl;

import com.ffcs.neo4j.entity.OccurDateNode;
import com.ffcs.neo4j.entity.PersonNode;
import com.ffcs.neo4j.repository.OccurDateNodeRepository;
import com.ffcs.neo4j.service.OccurDateNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OccurDateNodeServiceImpl implements OccurDateNodeService {
    @Autowired
    OccurDateNodeRepository occurDateNodeRepository;


    @Override
    public void add(OccurDateNode occurDateNode) {
        occurDateNodeRepository.save(occurDateNode);
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Iterable<OccurDateNode> findAll() {
        return null;
    }

    @Override
    public OccurDateNode getLatestOccurDateNodeByPersonNode(PersonNode personNode) {
        OccurDateNode latestOccurDateNode = occurDateNodeRepository.getLatestOccurDateNodeByPersonNode(personNode.getFeatureId());
        return latestOccurDateNode;
    }

//    @Override
//    public OccurDateNode getLatestOccurDateNodeByImageNode(ImageNode imageNode) {
//        return null;
//    }
//
//    @Override
//    public OccurDateNode getOccurDateNodeByImageNode(ImageNode imageNode) {
//        return null;
//    }

    @Override
    public OccurDateNode getNextOccurDateNode(OccurDateNode occurDateNode) {
        return null;
    }

    @Override
    public OccurDateNode getPreviousOccurDateNode(OccurDateNode occurDateNode) {
        return null;
    }

    @Override
    public List<OccurDateNode> getOccurDateListByPersonNode(PersonNode personNode) {
        return null;
    }

    @Override
    public boolean isExist(PersonNode personNode, OccurDateNode occurDateNode) {
        return false;
    }
}
