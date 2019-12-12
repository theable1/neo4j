package com.ffcs.neo4j.repository;

import com.ffcs.neo4j.entity.ImageNode;
import com.ffcs.neo4j.entity.PersonNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface PersonNodeRepository extends Neo4jRepository<PersonNode, Long> {
    @Query("MATCH (n:Person{id:{id}}) SET n.featureId={featureId} RETURN n")
    ImageNode updatePersonFeatureIdById(@Param("id") String id, @Param("featureId") String featureId);
    //search  通过featureId查找到Person节点
    @Query("match (i:Image{featureId:{featureId}}),(i)-[*..100]-(p:Person) return p")
    PersonNode findPersonNodeByImageNode(@Param("featureId") Long featureId);
}
