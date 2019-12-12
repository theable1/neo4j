package com.ffcs.neo4j.entity;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "LATEST")
public class LatestRelationship {
    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private OccurDateNode occurDateNode;

    @EndNode
    private PersonNode personNode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OccurDateNode getOccurDateNode() {
        return occurDateNode;
    }

    public void setOccurDateNode(OccurDateNode occurDateNode) {
        this.occurDateNode = occurDateNode;
    }

    public PersonNode getPersonNode() {
        return personNode;
    }

    public void setPersonNode(PersonNode personNode) {
        this.personNode = personNode;
    }

    @Override
    public String toString() {
        return "LatestRelationship{" +
                "id=" + id +
                ", occurDateNode=" + occurDateNode +
                ", personNode=" + personNode +
                '}';
    }
}
