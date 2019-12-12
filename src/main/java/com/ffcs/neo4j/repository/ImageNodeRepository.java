package com.ffcs.neo4j.repository;

import com.ffcs.neo4j.entity.ImageNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface ImageNodeRepository extends Neo4jRepository<ImageNode,Long> {
    //SEARCH
    @Query("match (i:Image{featureId:{featureId}}) return i")
    ImageNode findImageNodeByFeatureId(@Param("featureId") long featureID);
    //UPDATE
    @Query("match (i:Image{featureId:{featureId}}) set i.imageId={imageId},i.imageUrl={imageUrl},i.saveTime={saveTime} return i")
    ImageNode updateImageNode(@Param("featureId" ) long featureId,@Param("imageId") String imageId,@Param("imageUrl") String imageUrl,@Param("saveTime") String saveTime);

    @Query("match (i:Image{featureId:{featureId}}) set i.imageId={imageId} return i")
    ImageNode updateImageIdByFeatureId(@Param("featureId" ) long featureId,@Param("imageId") String imageId);

    @Query("match (i:Image{featureId:{featureId}}) set i.imageUrl={imageUrl} return i")
    ImageNode updateImageUrlByFeatureId(@Param("featureId" ) long featureId,@Param("imageUrl") String imageUrl);

    @Query("match (i:Image{featureId:{featureId}}) set i.saveTime={saveTime} return i")
    ImageNode updateSaveTimeByFeatureId(@Param("featureId" ) long featureId,@Param("saveTime") String saveTime);


}
