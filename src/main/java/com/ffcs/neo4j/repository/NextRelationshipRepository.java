package com.ffcs.neo4j.repository;

import com.ffcs.neo4j.entity.NextRelationship;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface NextRelationshipRepository extends Neo4jRepository<NextRelationship,Long> {
    @Query("MATCH (a:OccurDate)-[r:NEXT]->(b:OccurDate) WHERE id(a)={start} AND id(b)={end} DELETE r")
    void deleteNextRelationship(@Param("start")Long startId,@Param("end")Long endId);
}
