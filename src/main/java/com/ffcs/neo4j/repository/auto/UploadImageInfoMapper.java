package com.ffcs.neo4j.repository.auto;

import com.ffcs.neo4j.entity.UploadImageInfo;
import com.ffcs.neo4j.entity.UploadImageInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UploadImageInfoMapper {
    long countByExample(UploadImageInfoExample example);

    int deleteByExample(UploadImageInfoExample example);

    int deleteByPrimaryKey(String imageId);

    int insert(UploadImageInfo record);

    int insertSelective(UploadImageInfo record);

    List<UploadImageInfo> selectByExample(UploadImageInfoExample example);

    UploadImageInfo selectByPrimaryKey(String imageId);

    int updateByExampleSelective(@Param("record") UploadImageInfo record, @Param("example") UploadImageInfoExample example);

    int updateByExample(@Param("record") UploadImageInfo record, @Param("example") UploadImageInfoExample example);

    int updateByPrimaryKeySelective(UploadImageInfo record);

    int updateByPrimaryKey(UploadImageInfo record);
}