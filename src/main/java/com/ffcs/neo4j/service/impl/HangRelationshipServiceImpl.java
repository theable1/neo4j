package com.ffcs.neo4j.service.impl;

import com.ffcs.neo4j.entity.HangRelationship;
import com.ffcs.neo4j.repository.HangRelationshipRepository;
import com.ffcs.neo4j.service.HangRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HangRelationshipServiceImpl implements HangRelationshipService {
    @Autowired
    HangRelationshipRepository hangRelationshipRepository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Throwable.class)
    public void add(HangRelationship hangRelationship) {
        hangRelationshipRepository.save(hangRelationship);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Throwable.class)
    public void deleteAll() {
        hangRelationshipRepository.deleteAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Throwable.class)
    public void deleteHangRelationship(HangRelationship hangRelationship) {
        hangRelationshipRepository.delete(hangRelationship);
    }

}
