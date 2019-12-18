package com.ffcs.neo4j.entity;

import java.io.Serializable;
import java.util.Date;

public class UploadImageInfo implements Serializable {
    private String imageId;

    private String imageAbsolutePath;

    private String imageShowPath;

    private String faissId;

    private String faissGroupName;

    private String faissFeatureId;

    private Date createTime;

    private String uploaderId;

    private String imagePosition;

    private Date imageTime;

    private static final long serialVersionUID = 1L;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId == null ? null : imageId.trim();
    }

    public String getImageAbsolutePath() {
        return imageAbsolutePath;
    }

    public void setImageAbsolutePath(String imageAbsolutePath) {
        this.imageAbsolutePath = imageAbsolutePath == null ? null : imageAbsolutePath.trim();
    }

    public String getImageShowPath() {
        return imageShowPath;
    }

    public void setImageShowPath(String imageShowPath) {
        this.imageShowPath = imageShowPath == null ? null : imageShowPath.trim();
    }

    public String getFaissId() {
        return faissId;
    }

    public void setFaissId(String faissId) {
        this.faissId = faissId == null ? null : faissId.trim();
    }

    public String getFaissGroupName() {
        return faissGroupName;
    }

    public void setFaissGroupName(String faissGroupName) {
        this.faissGroupName = faissGroupName == null ? null : faissGroupName.trim();
    }

    public String getFaissFeatureId() {
        return faissFeatureId;
    }

    public void setFaissFeatureId(String faissFeatureId) {
        this.faissFeatureId = faissFeatureId == null ? null : faissFeatureId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUploaderId() {
        return uploaderId;
    }

    public void setUploaderId(String uploaderId) {
        this.uploaderId = uploaderId == null ? null : uploaderId.trim();
    }

    public String getImagePosition() {
        return imagePosition;
    }

    public void setImagePosition(String imagePosition) {
        this.imagePosition = imagePosition == null ? null : imagePosition.trim();
    }

    public Date getImageTime() {
        return imageTime;
    }

    public void setImageTime(Date imageTime) {
        this.imageTime = imageTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", imageId=").append(imageId);
        sb.append(", imageAbsolutePath=").append(imageAbsolutePath);
        sb.append(", imageShowPath=").append(imageShowPath);
        sb.append(", faissId=").append(faissId);
        sb.append(", faissGroupName=").append(faissGroupName);
        sb.append(", faissFeatureId=").append(faissFeatureId);
        sb.append(", createTime=").append(createTime);
        sb.append(", uploaderId=").append(uploaderId);
        sb.append(", imagePosition=").append(imagePosition);
        sb.append(", imageTime=").append(imageTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}