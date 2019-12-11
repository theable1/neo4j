package com.hxx.neo4j.entity;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "ImageRelation")
public class ImageRelation {
    @Id
    @GeneratedValue
    private Long id;
    @StartNode
    private ImageNode startNode;
    @EndNode
    private ImageNode endNode;
    @Property
    private double distance;

    public ImageRelation() {
    }

    public ImageRelation(Long id, ImageNode startNode, ImageNode endNode, double distance) {
        this.id = id;
        this.startNode = startNode;
        this.endNode = endNode;
        this.distance = distance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ImageNode getStartNode() {
        return startNode;
    }

    public void setStartNode(ImageNode startNode) {
        this.startNode = startNode;
    }

    public ImageNode getEndNode() {
        return endNode;
    }

    public void setEndNode(ImageNode endNode) {
        this.endNode = endNode;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "ImageRelation{" +
                "id=" + id +
                ", startNode=" + startNode +
                ", endNode=" + endNode +
                ", distance=" + distance +
                '}';
    }
}
