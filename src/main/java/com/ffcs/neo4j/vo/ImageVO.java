package com.ffcs.neo4j.vo;

import com.ffcs.neo4j.entity.ImageNode;

public class ImageVO extends ImageNode {
    private Long similarFeatureId;
    private String OccurDateTime;

    public String getOccurDateTime() {
        return OccurDateTime;
    }

    public void setOccurDateTime(String occurDateTime) {
        OccurDateTime = occurDateTime;
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
                ", OccurDateTime='" + OccurDateTime + '\'' +
                "} " + super.toString();
    }
}
