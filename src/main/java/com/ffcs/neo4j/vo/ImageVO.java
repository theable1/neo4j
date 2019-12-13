package com.ffcs.neo4j.vo;

import com.ffcs.neo4j.entity.ImageNode;

public class ImageVO extends ImageNode {
    private Long similarFeatureId;
    private String OccurDate;

    public String getOccurDate() {
        return OccurDate;
    }

    public void setOccurDate(String occurDate) {
        OccurDate = occurDate;
    }

    public Long getSimilarFeatureId() {
        return similarFeatureId;
    }

    public void setSimilarFeatureId(Long similarFeatureId) {
        this.similarFeatureId = similarFeatureId;
    }

    @Override
    public String toString() {
        return "ImageVO{" +
                "similarFeatureId=" + similarFeatureId +
                ", OccurDateTime='" + OccurDate + '\'' +
                "} " + super.toString();
    }
}
