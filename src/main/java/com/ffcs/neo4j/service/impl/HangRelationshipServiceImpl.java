package com.ffcs.neo4j.service.impl;

import com.ffcs.neo4j.entity.HangRelationship;
import com.ffcs.neo4j.service.HangRelationshipService;
import org.springframework.stereotype.Service;

@Service
public class HangRelationshipServiceImpl implements HangRelationshipService {
    @Override
    public void add(HangRelationship hangRelationship) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteHangRelationshipByFeatureId(String featureId) {

    }

    @Override
    public HangRelationship updateHangRelationshipByFeatureId(String featureId, String imageId, String imageShowPath) {
        return null;
    }

    @Override
    public HangRelationship updateImageIdByFeatureId(String featureId, String imageId) {
        return null;
    }

    @Override
    public HangRelationship updateImageShowPathByFeatureId(String featureId, String imageShowPath) {
        return null;
    }

    @Override
    public Iterable<HangRelationship> findAll() {
        return null;
    }

    @Override
    public boolean isExist(HangRelationship hangRelationship) {
        return false;
    }
}
