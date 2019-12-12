package com.ffcs.neo4j.repository;

import com.ffcs.neo4j.entity.OccurDateNode;
import com.ffcs.neo4j.entity.PersonNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OccurDateNodeRepository extends Neo4jRepository<OccurDateNode,Long> {
    @Query("MATCH (p:Person{featureId:{featureId}})-[r:LATEST]-(d:OccurDate) RETURN d")
    OccurDateNode getLatestOccurDateNodeByPersonNode(@Param("featureId") Long featureId);

    @Query("MATCH (a:OccurDate{date:{date}})-[r:NEXT*]-(b:OccurDate) RETURN b")
    List<OccurDateNode> getOccurDateListByLatestOccurDate(@Param("date") String date);

//    OccurDateNode getLatestOccurDateNodeByImageNode(ImageNode imageNode);
//
//    OccurDateNode getOccurDateNodeByImageNode(ImageNode imageNode);

    OccurDateNode getNextOccurDateNode(OccurDateNode occurDateNode);

    OccurDateNode getPreviousOccurDateNode(OccurDateNode occurDateNode);

    List<OccurDateNode> getOccurDateListByPersonNode(PersonNode personNode);
}
