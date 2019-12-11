package com.ffcs.neo4j.service.impl;

import com.ffcs.neo4j.entity.LatestRelationship;
import com.ffcs.neo4j.service.LatestRelationshipService;
import org.springframework.stereotype.Service;

@Service
public class LatestRelationshipServiceImpl implements LatestRelationshipService {
    @Override
    public void add(LatestRelationship latestRelationship) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteLatestRelationshipByFeatureId(String featureId) {

    }

    @Override
    public LatestRelationship updateLatestRelationshipByFeatureId(String featureId, String imageId, String imageShowPath) {
        return null;
    }

    @Override
    public LatestRelationship updateImageIdByFeatureId(String featureId, String imageId) {
        return null;
    }

    @Override
    public LatestRelationship updateImageShowPathByFeatureId(String featureId, String imageShowPath) {
        return null;
    }

    @Override
    public Iterable<LatestRelationship> findAll() {
        return null;
    }

    @Override
    public boolean isExist(LatestRelationship latestRelationship) {
        return false;
    }
}
