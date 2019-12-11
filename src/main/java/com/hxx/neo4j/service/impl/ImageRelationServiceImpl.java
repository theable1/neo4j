package com.hxx.neo4j.service.impl;

import com.hxx.neo4j.entity.HangRelation;
import com.hxx.neo4j.repository.ImageRelationRepository;
import com.hxx.neo4j.service.ImageRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageRelationServiceImpl implements ImageRelationService {
    @Autowired
    ImageRelationRepository imageRelationRepository;
    @Override
    public void addImageRelation(HangRelation hangRelation) {
        imageRelationRepository.save(hangRelation);
    }
}
