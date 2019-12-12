package com.ffcs.neo4j.service.impl;

import com.ffcs.neo4j.entity.NextRelationship;
import com.ffcs.neo4j.repository.NextRelationshipRepository;
import com.ffcs.neo4j.service.NextRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NextRelationshipServiceImpl implements NextRelationshipService {
    @Autowired
    NextRelationshipRepository nextRelationshipRepository;

    @Override
    public void add(NextRelationship nextRelationship) {
        nextRelationshipRepository.save(nextRelationship);
    }

    @Override
    public void deleteAll() {
        nextRelationshipRepository.deleteAll();
    }

    @Override
    public void deleteNextRelationship(NextRelationship nextRelationship) {
        nextRelationshipRepository.deleteNextRelationship(nextRelationship.getStartDateNode().getId(),nextRelationship.getEndDateNode().getId());
    }


}
