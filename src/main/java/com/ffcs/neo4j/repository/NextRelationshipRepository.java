package com.ffcs.neo4j.repository;

import com.ffcs.neo4j.entity.NextRelationship;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface NextRelationshipRepository extends Neo4jRepository<NextRelationship,Long> {
    void delete(NextRelationship nextRelationship);
}
