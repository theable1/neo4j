package com.ffcs.neo4j.service;

import com.ffcs.neo4j.entity.OccurDateNode;

import java.util.List;

public interface OccurDateNodeService {
    //CREATE
    void add(OccurDateNode occurDateNode);
    void addOccurDateNodeList(List<OccurDateNode> occurDateNodeList);
    OccurDateNode getOccurDateNodeByDate(String date);

    //DELETE
    void deleteAll();
    void deleteOccurDateNodeByDate(String date);

    //UPDATE
    OccurDateNode updateOccurDateNodeByDate(String date);

    //SELECT
    Iterable<OccurDateNode> findAll();

    boolean isExist(OccurDateNode occurDateNode);
}
