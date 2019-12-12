package com.ffcs.neo4j.entity;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "HANG")
public class HangRelationship {
    @Id
    @GeneratedValue
    private Long id;
    @EndNode
    private OccurDateNode occurDateNode;

    @StartNode
    private ImageNode imageNode;

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

    public ImageNode getImageNode() {
        return imageNode;
    }

    public void setImageNode(ImageNode imageNode) {
        this.imageNode = imageNode;
    }

    @Override
    public String toString() {
        return "HangRelationship{" +
                "id=" + id +
                ", occurDateNode=" + occurDateNode +
                ", imageNode=" + imageNode +
                '}';
    }
}
