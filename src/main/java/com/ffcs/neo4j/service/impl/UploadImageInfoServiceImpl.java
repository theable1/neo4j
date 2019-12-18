package com.ffcs.neo4j.service.impl;

import com.ffcs.neo4j.entity.UploadImageInfo;
import com.ffcs.neo4j.entity.UploadImageInfoExample;
import com.ffcs.neo4j.repository.auto.UploadImageInfoMapper;
import com.ffcs.neo4j.service.UploadImageInfoService;
import com.ffcs.visionbigdata.mysql.service.UploaderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UploadImageInfoServiceImpl implements UploadImageInfoService {
    @Autowired
    UploadImageInfoMapper uploadImageInfoMapper;

    @Override
    public List<UploadImageInfo> list() {
        UploadImageInfoExample uploadImageInfoExample = new UploadImageInfoExample();

        return uploadImageInfoMapper.selectByExample(uploadImageInfoExample);
    }
}
