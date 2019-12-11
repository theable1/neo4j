package com.hxx.neo4j.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity(label = "Image")
public class ImageNode {
    @Id
    @GeneratedValue
    private Long nodeId;
    @Property
    private String featureId;
    @Property
    private String imageShowPath;
    @Property
    private String imageId;

    public ImageNode() {
    }

    public ImageNode(Long nodeId, String featureId, String imageShowPath, String imageId) {
        this.nodeId = nodeId;
        this.featureId = featureId;
        this.imageShowPath = imageShowPath;
        this.imageId = imageId;
    }
    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public String getFeatureId() {
        return featureId;
    }

    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }

    public String getImageShowPath() {
        return imageShowPath;
    }

    public void setImageShowPath(String imageShowPath) {
        this.imageShowPath = imageShowPath;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }



    @Override
    public String toString() {
        return "ImageNode{" +
                "nodeId=" + nodeId +
                ", featureId='" + featureId + '\'' +
                ", imageShowPath='" + imageShowPath + '\'' +
                ", imageId='" + imageId + '\'' +
                '}';
    }
}
