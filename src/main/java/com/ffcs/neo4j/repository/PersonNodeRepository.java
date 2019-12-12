package com.ffcs.neo4j.repository;

import com.ffcs.neo4j.entity.ImageNode;
import com.ffcs.neo4j.entity.PersonNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface PersonNodeRepository extends Neo4jRepository<PersonNode, Long> {
    //UPDATA
    @Query("match (p:Person{featureId:{featureID}}) set p.featureId={newFeatureId}, p.name={name}")
    PersonNode updatePersonNode(@Param("featureId") long featureId, @Param("newFeatureId") long newFeatureId, @Param("name") String name);

    @Query("match (p:Person{featureId:{featureID}}) set p.featureId={newFeatureId}")
    PersonNode updateFeatureIdByFeatureId(@Param("featureId") long featureId, @Param("newFeatureId") long newFeatureId);

    @Query("match (p:Person{featureId:{featureID}}) set p.name={name}")
    PersonNode updateNameByFeatureId(@Param("featureId") long featureId, @Param("name") String name);

    //search  通过featureId查找到Person节点
    @Query("match (i:Image{featureId:{featureId}}),(i)-[*..100]-(p:Person) return p")
    PersonNode findPersonNodeByImageNode(@Param("featureId") long featureId);

    @Query("match (p:Person{featureId:{featureId}}) return p")
    PersonNode findPersonNodeByFeatureId(@Param("featureId") long featureId);
}
