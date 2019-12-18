package com.ffcs.neo4j.service.impl;

import com.ffcs.neo4j.entity.UploadImageInfo;
import com.ffcs.neo4j.entity.UploadImageInfoExample;
import com.ffcs.neo4j.repository.auto.UploadImageInfoMapper;
import com.ffcs.neo4j.service.UploadImageInfoService;
import com.ffcs.visionbigdata.mysql.service.UploaderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UploadImageInfoServiceImpl implements UploadImageInfoService {
    @Autowired
    UploadImageInfoMapper uploadImageInfoMapper;

    @Override
    public List<UploadImageInfo> listAll() {
        UploadImageInfoExample uploadImageInfoExample = new UploadImageInfoExample();

        return uploadImageInfoMapper.selectByExample(uploadImageInfoExample);
    }

    @Override
    public UploadImageInfo list(String featureId) {
        UploadImageInfoExample uploadImageInfoExample = new UploadImageInfoExample();
        UploadImageInfoExample.Criteria criteria = uploadImageInfoExample.createCriteria();
        if (!StringUtils.isEmpty(featureId)){
            criteria.andFaissFeatureIdEqualTo(featureId);
        }
        List<UploadImageInfo> uploadImageInfos = uploadImageInfoMapper.selectByExample(uploadImageInfoExample);
        return uploadImageInfos.get(0);
    }
}
