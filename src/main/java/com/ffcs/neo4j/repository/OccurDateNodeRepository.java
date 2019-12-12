package com.ffcs.neo4j.repository;

import com.ffcs.neo4j.entity.OccurDateNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OccurDateNodeRepository extends Neo4jRepository<OccurDateNode,Long> {
    @Query("match (n:OccurDate{date:{date}}) return n")
    OccurDateNode getOccurDateNodeByDate(@Param("date") String date);

    @Query("MATCH (n:Person{featureId:{featureId}})--(d:OccurDate) RETURN d")
    List<OccurDateNode> getOccurDateListByPersonNode(@Param("featureId") Long featureId);
}
