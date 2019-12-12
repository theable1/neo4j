package com.ffcs.neo4j.service.impl;

import com.ffcs.neo4j.entity.LatestRelationship;
import com.ffcs.neo4j.entity.PersonNode;
import com.ffcs.neo4j.repository.LatestRelationshipRepository;
import com.ffcs.neo4j.service.LatestRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LatestRelationshipServiceImpl implements LatestRelationshipService {
    @Autowired
    LatestRelationshipRepository latestRelationshipRepository;
    @Override
    public void add(LatestRelationship latestRelationship) {
        latestRelationshipRepository.save(latestRelationship);
    }

    @Override
    public void deleteAll() {
        latestRelationshipRepository.deleteAll();
    }

    @Override
    public void deleteLatestRelationship(LatestRelationship latestRelationship) {
        latestRelationshipRepository.deleteLatestRelationship(latestRelationship.getOccurDateNode().getId(),latestRelationship.getPersonNode().getId());
    }
}
