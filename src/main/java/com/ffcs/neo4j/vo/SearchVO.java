package com.ffcs.neo4j.vo;

import java.util.Date;

public class SearchVO extends ImageVO {
    private Date startTime;
    private Date endTime;

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
                "startTime=" + startTime +
                ", endTime=" + endTime +
                "} " + super.toString();
    }
}
