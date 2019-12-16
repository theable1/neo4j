package com.ffcs.neo4j.vo;

import com.ffcs.neo4j.entity.ImageNode;

public class ImageVO {
    private Long featureId;
    private Long similarFeatureId;
    private String imageId;
    private String imageUrl;
    private String OccurDate;

    public Long getFeatureId() {
        return featureId;
    }

    public void setFeatureId(Long featureId) {
        this.featureId = featureId;
    }

    public Long getSimilarFeatureId() {
        return similarFeatureId;
    }

    public void setSimilarFeatureId(Long similarFeatureId) {
        this.similarFeatureId = similarFeatureId;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getOccurDate() {
        return OccurDate;
    }

    public void setOccurDate(String occurDate) {
        OccurDate = occurDate;
    }

    @Override
    public String toString() {
        return "ImageVO{" +
                "featureId=" + featureId +
                ", similarFeatureId=" + similarFeatureId +
                ", imageId='" + imageId + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", OccurDate='" + OccurDate + '\'' +
                '}';
    }
}
