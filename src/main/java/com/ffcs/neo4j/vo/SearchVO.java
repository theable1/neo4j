package com.ffcs.neo4j.vo;

import java.util.Date;

public class SearchVO  {
    private Long similarFeatureId;
    private Date startTime;
    private Date endTime;

    public Long getSimilarFeatureId() {
        return similarFeatureId;
    }

    public void setSimilarFeatureId(Long similarFeatureId) {
        this.similarFeatureId = similarFeatureId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "SearchVO{" +
                "similarFeatureId=" + similarFeatureId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
