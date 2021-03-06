package com.ffcs.neo4j.entity;

import org.neo4j.ogm.annotation.*;

@NodeEntity(label = "Image")
public class ImageNode {
    @Id
    @GeneratedValue
    private Long id;
    @Property
    private Long featureId;
    @Property
    private String imageId;
    @Property
    private String imageUrl;
    @Property
    private String saveTime;

    public ImageNode() {

    }

    public ImageNode(Long featureId, String imageId, String imageUrl, String saveTime) {
        this.featureId = featureId;
        this.imageId = imageId;
        this.imageUrl = imageUrl;
        this.saveTime = saveTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFeatureId() {
        return featureId;
    }

    public void setFeatureId(Long featureId) {
        this.featureId = featureId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(String saveTime) {
        this.saveTime = saveTime;
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
                "id=" + id +
                ", featureId=" + featureId +
                ", imageId='" + imageId + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", saveTime='" + saveTime + '\'' +
                '}';
    }
}
