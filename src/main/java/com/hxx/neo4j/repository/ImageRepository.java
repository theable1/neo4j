package com.hxx.neo4j.repository;


import com.hxx.neo4j.entity.ImageNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends Neo4jRepository<ImageNode, Long> {
    @Query("match (n:Image{featureId:{featureId}}) return n")
    ImageNode getImageNodeByFeatureId(@Param("featureId") String featureId);

    @Query("match (n:Image{featureId:{featureId}}) set n.imageId={imageId} set n.imageShowPath={imageShowPath} return n")
    ImageNode updateImageNodeByFeatureId(@Param("featureId") String featureId, @Param("imageId") String imageId, @Param("imageShowPath") String imageShowPath);

    @Query("match (n:Image{featureId:{featureId}}) set n.imageId={imageId} return n")
    ImageNode updateImageIdByFeatureId(@Param("featureId") String featureId, @Param("imageId") String imageId);

    @Query("match (n:Image{featureId:{featureId}}) set n.imageShowPath={imageShowPath} return n")
    ImageNode updateImageShowPathByFeatureId(@Param("featureId") String featureId, @Param("imageShowPath") String imageShowPath);
//    @Query("match (n:Image) return n")
//    Iterable<ImageNode> findAllImageNodes();
//
//    @Query("create(n:Image{featureId:{featureId},imageShowPath:{imageShowPath},imageId:{imageId}}) return n")
//    List<ImageNode> addImageNodeList(@Param("featureId") String featureId, @Param("imageShowPath") String imageShowPath, @Param("imageId") String imageId);
}
