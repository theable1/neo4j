package com.ffcs.neo4j.service.impl;

import com.ffcs.neo4j.entity.NextRelationship;
import com.ffcs.neo4j.repository.NextRelationshipRepository;
import com.ffcs.neo4j.service.NextRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NextRelationshipServiceImpl implements NextRelationshipService {
    @Autowired
    NextRelationshipRepository nextRelationshipRepository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Throwable.class)
    public void add(NextRelationship nextRelationship) {
        nextRelationshipRepository.save(nextRelationship);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Throwable.class)
    public void deleteAll() {
        nextRelationshipRepository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Throwable.class)
    public void deleteNextRelationship(NextRelationship nextRelationship) {
        nextRelationshipRepository.deleteNextRelationship(nextRelationship.getStartDateNode().getId(), nextRelationship.getEndDateNode().getId());
    }


}
