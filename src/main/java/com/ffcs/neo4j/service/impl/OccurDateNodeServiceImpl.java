package com.ffcs.neo4j.service.impl;

import com.ffcs.neo4j.entity.OccurDateNode;
import com.ffcs.neo4j.repository.OccurDateNodeRepository;
import com.ffcs.neo4j.service.OccurDateNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OccurDateNodeServiceImpl implements OccurDateNodeService {
    @Autowired
    OccurDateNodeRepository occurDateNodeRepository;



}
