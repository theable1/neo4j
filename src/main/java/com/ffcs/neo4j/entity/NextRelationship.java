package com.ffcs.neo4j.entity;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "NEXT")
public class NextRelationship {
    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private OccurDateNode startDateNode;

    @EndNode
    private OccurDateNode endDateNode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OccurDateNode getStartDateNode() {
        return startDateNode;
    }

    public void setStartDateNode(OccurDateNode startDateNode) {
        this.startDateNode = startDateNode;
    }

    public OccurDateNode getEndDateNode() {
        return endDateNode;
    }

    public void setEndDateNode(OccurDateNode endDateNode) {
        this.endDateNode = endDateNode;
    }

    @Override
    public String toString() {
        return "NextRelationship{" +
                "id=" + id +
                ", startDateNode=" + startDateNode +
                ", endDateNode=" + endDateNode +
                '}';
    }
}
