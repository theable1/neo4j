package com.ffcs.neo4j.repository;


import com.ffcs.neo4j.entity.ImageNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface ImageNodeRepository extends Neo4jRepository<ImageNode, Long> {
    @Query("match (n:Image{featureId:{featureId}}) return n")
    ImageNode getImageNodeByFeatureId(@Param("featureId") String featureId);

    @Query("match (n:Image{featureId:{featureId}}) set n.imageId={imageId} set n.imageShowPath={imageShowPath} return n")
    ImageNode updateImageNodeByFeatureId(@Param("featureId") String featureId, @Param("imageId") String imageId, @Param("imageShowPath") String imageShowPath);

    @Query("match (n:Image{featureId:{featureId}}) set n.imageId={imageId} return n")
    ImageNode updateImageIdByFeatureId(@Param("featureId") String featureId, @Param("imageId") String imageId);

    @Query("match (n:Image{featureId:{featureId}}) set n.imageShowPath={imageShowPath} return n")
    ImageNode updateImageShowPathByFeatureId(@Param("featureId") String featureId, @Param("imageShowPath") String imageShowPath);
}
