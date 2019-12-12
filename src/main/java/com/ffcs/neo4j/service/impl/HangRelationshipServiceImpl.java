package com.ffcs.neo4j.service.impl;

import com.ffcs.neo4j.entity.HangRelationship;
import com.ffcs.neo4j.repository.HangRelationshipRepository;
import com.ffcs.neo4j.service.HangRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HangRelationshipServiceImpl implements HangRelationshipService {
    @Autowired
    HangRelationshipRepository hangRelationshipRepository;
    @Override
    public void add(HangRelationship hangRelationship) {
        hangRelationshipRepository.save(hangRelationship);
    }

    @Override
    public void deleteAll() {
        hangRelationshipRepository.deleteAll();
    }

    @Override
    public void deleteHangRelationship(HangRelationship hangRelationship) {
        hangRelationshipRepository.delete(hangRelationship);
    }

}
