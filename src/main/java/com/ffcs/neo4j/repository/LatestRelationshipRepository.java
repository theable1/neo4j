package com.ffcs.neo4j.repository;

import com.ffcs.neo4j.entity.LatestRelationship;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface LatestRelationshipRepository extends Neo4jRepository<LatestRelationship,Long> {
    @Query("MATCH (a:OccurDate)-[r:LATEST]->(b:Person) WHERE id(a)={start} AND id(b)={end} DELETE r")
    void deleteLatestRelationship(@Param("start")Long dateId,@Param("end")Long personId);
}
