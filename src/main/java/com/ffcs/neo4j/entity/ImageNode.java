package com.ffcs.neo4j.entity;

import org.neo4j.ogm.annotation.*;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

@NodeEntity(label = "Image")
public class ImageNode {
    @Id
    @GeneratedValue
    private Long id;
    @Property
    private String featureId;
    @Property
    private String imageShowPath;
    @Property
    private String imageId;
    @Property
    private String saveTime;
    @Labels
    private Set<String> labels = new HashSet<>();

    public void addLabel(String label) {
        if (!StringUtils.isEmpty(label)) {
            this.labels.add(label);
        }
    }

    public String getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(String saveTime) {
        this.saveTime = saveTime;
    }

    public void setLabels(Set<String> labels) {
        this.labels = labels;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<String> getLabels() {
        return labels;
    }

    @Override
    public String toString() {
        return "ImageNode{" +
                "id=" + id +
                ", featureId='" + featureId + '\'' +
                ", imageShowPath='" + imageShowPath + '\'' +
                ", imageId='" + imageId + '\'' +
                ", saveTime='" + saveTime + '\'' +
                ", labels=" + labels +
                '}';
    }
}
