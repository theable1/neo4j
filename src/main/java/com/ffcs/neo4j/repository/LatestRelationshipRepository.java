package com.ffcs.neo4j.repository;

import com.ffcs.neo4j.entity.LatestRelationship;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface LatestRelationshipRepository extends Neo4jRepository<LatestRelationship,Long> {
}
