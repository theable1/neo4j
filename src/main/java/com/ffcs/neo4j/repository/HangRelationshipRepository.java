package com.ffcs.neo4j.repository;

import com.ffcs.neo4j.entity.HangRelationship;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface HangRelationshipRepository extends Neo4jRepository<HangRelationship,Long> {
}
