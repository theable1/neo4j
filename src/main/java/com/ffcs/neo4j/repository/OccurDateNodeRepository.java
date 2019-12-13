package com.ffcs.neo4j.repository;

import com.ffcs.neo4j.entity.ImageNode;
import com.ffcs.neo4j.entity.OccurDateNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OccurDateNodeRepository extends Neo4jRepository<OccurDateNode, Long> {
    @Query("MATCH (p:Person{featureId:{featureId}})-[r:LATEST]-(d:OccurDate) RETURN d")
    OccurDateNode getLatestOccurDateNodeByPersonNode(@Param("featureId") Long featureId);

    @Query("MATCH (p:Person{featureId:{featureId}})-[*]-(d:OccurDate{date:{date}}) RETURN d")
    OccurDateNode getOccurDateNodeByPersonNode(@Param("featureId") Long featureId, @Param("date") String date);

    @Query("MATCH (a:OccurDate)-[r:NEXT]->(b:OccurDate) WHERE id(a)={id} RETURN b")
    OccurDateNode getNextOccurDateNode(@Param("id") Long id);

    @Query("MATCH (a:OccurDate)<-[r:NEXT]-(b:OccurDate)  WHERE id(a)={id} RETURN b")
    OccurDateNode getPreviousOccurDateNode(@Param("id") Long id);

}
