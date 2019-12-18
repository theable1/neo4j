package com.ffcs.neo4j.service;

import com.ffcs.neo4j.entity.UploadImageInfo;

import java.util.List;

public interface UploadImageInfoService {
    public List<UploadImageInfo> listAll() ;
    public UploadImageInfo list(String featureId);
}
