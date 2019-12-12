package com.ffcs.neo4j.repository;

import com.ffcs.neo4j.entity.ImageNode;
import com.ffcs.neo4j.entity.PersonNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface PersonNodeRepository extends Neo4jRepository<PersonNode, Long> {
    @Query("MATCH (n:Person{featureId:{featureId}}) RETURN n")
    PersonNode getPersonNodeByFeatureId(@Param("featureId") Long featureId);

    //search  通过featureId查找到Person节点
    @Query("match (i:Image{featureId:{featureId}})-[*]-(p:Person) return p")
    PersonNode getPersonNodeByImageNode(@Param("featureId") Long featureId);
}
