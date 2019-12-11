package com.ffcs.neo4j.service.impl;

import com.ffcs.neo4j.entity.NextRelationship;
import com.ffcs.neo4j.service.NextRelationshipService;
import org.springframework.stereotype.Service;

@Service
public class NextRelationshipServiceImpl implements NextRelationshipService {
    @Override
    public void add(NextRelationship nextRelationship) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteNextRelationshipByFeatureId(String featureId) {

    }

    @Override
    public NextRelationship updateNextRelationshipByFeatureId(String featureId, String imageId, String imageShowPath) {
        return null;
    }

    @Override
    public NextRelationship updateImageIdByFeatureId(String featureId, String imageId) {
        return null;
    }

    @Override
    public NextRelationship updateImageShowPathByFeatureId(String featureId, String imageShowPath) {
        return null;
    }

    @Override
    public Iterable<NextRelationship> findAll() {
        return null;
    }

    @Override
    public boolean isExist(NextRelationship nextRelationship) {
        return false;
    }
}
