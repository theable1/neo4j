package com.ffcs.neo4j.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UploadImageInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UploadImageInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andImageIdIsNull() {
            addCriterion("image_id is null");
            return (Criteria) this;
        }

        public Criteria andImageIdIsNotNull() {
            addCriterion("image_id is not null");
            return (Criteria) this;
        }

        public Criteria andImageIdEqualTo(String value) {
            addCriterion("image_id =", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotEqualTo(String value) {
            addCriterion("image_id <>", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdGreaterThan(String value) {
            addCriterion("image_id >", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdGreaterThanOrEqualTo(String value) {
            addCriterion("image_id >=", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLessThan(String value) {
            addCriterion("image_id <", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLessThanOrEqualTo(String value) {
            addCriterion("image_id <=", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLike(String value) {
            addCriterion("image_id like", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotLike(String value) {
            addCriterion("image_id not like", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdIn(List<String> values) {
            addCriterion("image_id in", values, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotIn(List<String> values) {
            addCriterion("image_id not in", values, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdBetween(String value1, String value2) {
            addCriterion("image_id between", value1, value2, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotBetween(String value1, String value2) {
            addCriterion("image_id not between", value1, value2, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageAbsolutePathIsNull() {
            addCriterion("image_absolute_path is null");
            return (Criteria) this;
        }

        public Criteria andImageAbsolutePathIsNotNull() {
            addCriterion("image_absolute_path is not null");
            return (Criteria) this;
        }

        public Criteria andImageAbsolutePathEqualTo(String value) {
            addCriterion("image_absolute_path =", value, "imageAbsolutePath");
            return (Criteria) this;
        }

        public Criteria andImageAbsolutePathNotEqualTo(String value) {
            addCriterion("image_absolute_path <>", value, "imageAbsolutePath");
            return (Criteria) this;
        }

        public Criteria andImageAbsolutePathGreaterThan(String value) {
            addCriterion("image_absolute_path >", value, "imageAbsolutePath");
            return (Criteria) this;
        }

        public Criteria andImageAbsolutePathGreaterThanOrEqualTo(String value) {
            addCriterion("image_absolute_path >=", value, "imageAbsolutePath");
            return (Criteria) this;
        }

        public Criteria andImageAbsolutePathLessThan(String value) {
            addCriterion("image_absolute_path <", value, "imageAbsolutePath");
            return (Criteria) this;
        }

        public Criteria andImageAbsolutePathLessThanOrEqualTo(String value) {
            addCriterion("image_absolute_path <=", value, "imageAbsolutePath");
            return (Criteria) this;
        }

        public Criteria andImageAbsolutePathLike(String value) {
            addCriterion("image_absolute_path like", value, "imageAbsolutePath");
            return (Criteria) this;
        }

        public Criteria andImageAbsolutePathNotLike(String value) {
            addCriterion("image_absolute_path not like", value, "imageAbsolutePath");
            return (Criteria) this;
        }

        public Criteria andImageAbsolutePathIn(List<String> values) {
            addCriterion("image_absolute_path in", values, "imageAbsolutePath");
            return (Criteria) this;
        }

        public Criteria andImageAbsolutePathNotIn(List<String> values) {
            addCriterion("image_absolute_path not in", values, "imageAbsolutePath");
            return (Criteria) this;
        }

        public Criteria andImageAbsolutePathBetween(String value1, String value2) {
            addCriterion("image_absolute_path between", value1, value2, "imageAbsolutePath");
            return (Criteria) this;
        }

        public Criteria andImageAbsolutePathNotBetween(String value1, String value2) {
            addCriterion("image_absolute_path not between", value1, value2, "imageAbsolutePath");
            return (Criteria) this;
        }

        public Criteria andImageShowPathIsNull() {
            addCriterion("image_show_path is null");
            return (Criteria) this;
        }

        public Criteria andImageShowPathIsNotNull() {
            addCriterion("image_show_path is not null");
            return (Criteria) this;
        }

        public Criteria andImageShowPathEqualTo(String value) {
            addCriterion("image_show_path =", value, "imageShowPath");
            return (Criteria) this;
        }

        public Criteria andImageShowPathNotEqualTo(String value) {
            addCriterion("image_show_path <>", value, "imageShowPath");
            return (Criteria) this;
        }

        public Criteria andImageShowPathGreaterThan(String value) {
            addCriterion("image_show_path >", value, "imageShowPath");
            return (Criteria) this;
        }

        public Criteria andImageShowPathGreaterThanOrEqualTo(String value) {
            addCriterion("image_show_path >=", value, "imageShowPath");
            return (Criteria) this;
        }

        public Criteria andImageShowPathLessThan(String value) {
            addCriterion("image_show_path <", value, "imageShowPath");
            return (Criteria) this;
        }

        public Criteria andImageShowPathLessThanOrEqualTo(String value) {
            addCriterion("image_show_path <=", value, "imageShowPath");
            return (Criteria) this;
        }

        public Criteria andImageShowPathLike(String value) {
            addCriterion("image_show_path like", value, "imageShowPath");
            return (Criteria) this;
        }

        public Criteria andImageShowPathNotLike(String value) {
            addCriterion("image_show_path not like", value, "imageShowPath");
            return (Criteria) this;
        }

        public Criteria andImageShowPathIn(List<String> values) {
            addCriterion("image_show_path in", values, "imageShowPath");
            return (Criteria) this;
        }

        public Criteria andImageShowPathNotIn(List<String> values) {
            addCriterion("image_show_path not in", values, "imageShowPath");
            return (Criteria) this;
        }

        public Criteria andImageShowPathBetween(String value1, String value2) {
            addCriterion("image_show_path between", value1, value2, "imageShowPath");
            return (Criteria) this;
        }

        public Criteria andImageShowPathNotBetween(String value1, String value2) {
            addCriterion("image_show_path not between", value1, value2, "imageShowPath");
            return (Criteria) this;
        }

        public Criteria andFaissIdIsNull() {
            addCriterion("faiss_id is null");
            return (Criteria) this;
        }

        public Criteria andFaissIdIsNotNull() {
            addCriterion("faiss_id is not null");
            return (Criteria) this;
        }

        public Criteria andFaissIdEqualTo(String value) {
            addCriterion("faiss_id =", value, "faissId");
            return (Criteria) this;
        }

        public Criteria andFaissIdNotEqualTo(String value) {
            addCriterion("faiss_id <>", value, "faissId");
            return (Criteria) this;
        }

        public Criteria andFaissIdGreaterThan(String value) {
            addCriterion("faiss_id >", value, "faissId");
            return (Criteria) this;
        }

        public Criteria andFaissIdGreaterThanOrEqualTo(String value) {
            addCriterion("faiss_id >=", value, "faissId");
            return (Criteria) this;
        }

        public Criteria andFaissIdLessThan(String value) {
            addCriterion("faiss_id <", value, "faissId");
            return (Criteria) this;
        }

        public Criteria andFaissIdLessThanOrEqualTo(String value) {
            addCriterion("faiss_id <=", value, "faissId");
            return (Criteria) this;
        }

        public Criteria andFaissIdLike(String value) {
            addCriterion("faiss_id like", value, "faissId");
            return (Criteria) this;
        }

        public Criteria andFaissIdNotLike(String value) {
            addCriterion("faiss_id not like", value, "faissId");
            return (Criteria) this;
        }

        public Criteria andFaissIdIn(List<String> values) {
            addCriterion("faiss_id in", values, "faissId");
            return (Criteria) this;
        }

        public Criteria andFaissIdNotIn(List<String> values) {
            addCriterion("faiss_id not in", values, "faissId");
            return (Criteria) this;
        }

        public Criteria andFaissIdBetween(String value1, String value2) {
            addCriterion("faiss_id between", value1, value2, "faissId");
            return (Criteria) this;
        }

        public Criteria andFaissIdNotBetween(String value1, String value2) {
            addCriterion("faiss_id not between", value1, value2, "faissId");
            return (Criteria) this;
        }

        public Criteria andFaissGroupNameIsNull() {
            addCriterion("faiss_group_name is null");
            return (Criteria) this;
        }

        public Criteria andFaissGroupNameIsNotNull() {
            addCriterion("faiss_group_name is not null");
            return (Criteria) this;
        }

        public Criteria andFaissGroupNameEqualTo(String value) {
            addCriterion("faiss_group_name =", value, "faissGroupName");
            return (Criteria) this;
        }

        public Criteria andFaissGroupNameNotEqualTo(String value) {
            addCriterion("faiss_group_name <>", value, "faissGroupName");
            return (Criteria) this;
        }

        public Criteria andFaissGroupNameGreaterThan(String value) {
            addCriterion("faiss_group_name >", value, "faissGroupName");
            return (Criteria) this;
        }

        public Criteria andFaissGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("faiss_group_name >=", value, "faissGroupName");
            return (Criteria) this;
        }

        public Criteria andFaissGroupNameLessThan(String value) {
            addCriterion("faiss_group_name <", value, "faissGroupName");
            return (Criteria) this;
        }

        public Criteria andFaissGroupNameLessThanOrEqualTo(String value) {
            addCriterion("faiss_group_name <=", value, "faissGroupName");
            return (Criteria) this;
        }

        public Criteria andFaissGroupNameLike(String value) {
            addCriterion("faiss_group_name like", value, "faissGroupName");
            return (Criteria) this;
        }

        public Criteria andFaissGroupNameNotLike(String value) {
            addCriterion("faiss_group_name not like", value, "faissGroupName");
            return (Criteria) this;
        }

        public Criteria andFaissGroupNameIn(List<String> values) {
            addCriterion("faiss_group_name in", values, "faissGroupName");
            return (Criteria) this;
        }

        public Criteria andFaissGroupNameNotIn(List<String> values) {
            addCriterion("faiss_group_name not in", values, "faissGroupName");
            return (Criteria) this;
        }

        public Criteria andFaissGroupNameBetween(String value1, String value2) {
            addCriterion("faiss_group_name between", value1, value2, "faissGroupName");
            return (Criteria) this;
        }

        public Criteria andFaissGroupNameNotBetween(String value1, String value2) {
            addCriterion("faiss_group_name not between", value1, value2, "faissGroupName");
            return (Criteria) this;
        }

        public Criteria andFaissFeatureIdIsNull() {
            addCriterion("faiss_feature_id is null");
            return (Criteria) this;
        }

        public Criteria andFaissFeatureIdIsNotNull() {
            addCriterion("faiss_feature_id is not null");
            return (Criteria) this;
        }

        public Criteria andFaissFeatureIdEqualTo(String value) {
            addCriterion("faiss_feature_id =", value, "faissFeatureId");
            return (Criteria) this;
        }

        public Criteria andFaissFeatureIdNotEqualTo(String value) {
            addCriterion("faiss_feature_id <>", value, "faissFeatureId");
            return (Criteria) this;
        }

        public Criteria andFaissFeatureIdGreaterThan(String value) {
            addCriterion("faiss_feature_id >", value, "faissFeatureId");
            return (Criteria) this;
        }

        public Criteria andFaissFeatureIdGreaterThanOrEqualTo(String value) {
            addCriterion("faiss_feature_id >=", value, "faissFeatureId");
            return (Criteria) this;
        }

        public Criteria andFaissFeatureIdLessThan(String value) {
            addCriterion("faiss_feature_id <", value, "faissFeatureId");
            return (Criteria) this;
        }

        public Criteria andFaissFeatureIdLessThanOrEqualTo(String value) {
            addCriterion("faiss_feature_id <=", value, "faissFeatureId");
            return (Criteria) this;
        }

        public Criteria andFaissFeatureIdLike(String value) {
            addCriterion("faiss_feature_id like", value, "faissFeatureId");
            return (Criteria) this;
        }

        public Criteria andFaissFeatureIdNotLike(String value) {
            addCriterion("faiss_feature_id not like", value, "faissFeatureId");
            return (Criteria) this;
        }

        public Criteria andFaissFeatureIdIn(List<String> values) {
            addCriterion("faiss_feature_id in", values, "faissFeatureId");
            return (Criteria) this;
        }

        public Criteria andFaissFeatureIdNotIn(List<String> values) {
            addCriterion("faiss_feature_id not in", values, "faissFeatureId");
            return (Criteria) this;
        }

        public Criteria andFaissFeatureIdBetween(String value1, String value2) {
            addCriterion("faiss_feature_id between", value1, value2, "faissFeatureId");
            return (Criteria) this;
        }

        public Criteria andFaissFeatureIdNotBetween(String value1, String value2) {
            addCriterion("faiss_feature_id not between", value1, value2, "faissFeatureId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUploaderIdIsNull() {
            addCriterion("uploader_id is null");
            return (Criteria) this;
        }

        public Criteria andUploaderIdIsNotNull() {
            addCriterion("uploader_id is not null");
            return (Criteria) this;
        }

        public Criteria andUploaderIdEqualTo(String value) {
            addCriterion("uploader_id =", value, "uploaderId");
            return (Criteria) this;
        }

        public Criteria andUploaderIdNotEqualTo(String value) {
            addCriterion("uploader_id <>", value, "uploaderId");
            return (Criteria) this;
        }

        public Criteria andUploaderIdGreaterThan(String value) {
            addCriterion("uploader_id >", value, "uploaderId");
            return (Criteria) this;
        }

        public Criteria andUploaderIdGreaterThanOrEqualTo(String value) {
            addCriterion("uploader_id >=", value, "uploaderId");
            return (Criteria) this;
        }

        public Criteria andUploaderIdLessThan(String value) {
            addCriterion("uploader_id <", value, "uploaderId");
            return (Criteria) this;
        }

        public Criteria andUploaderIdLessThanOrEqualTo(String value) {
            addCriterion("uploader_id <=", value, "uploaderId");
            return (Criteria) this;
        }

        public Criteria andUploaderIdLike(String value) {
            addCriterion("uploader_id like", value, "uploaderId");
            return (Criteria) this;
        }

        public Criteria andUploaderIdNotLike(String value) {
            addCriterion("uploader_id not like", value, "uploaderId");
            return (Criteria) this;
        }

        public Criteria andUploaderIdIn(List<String> values) {
            addCriterion("uploader_id in", values, "uploaderId");
            return (Criteria) this;
        }

        public Criteria andUploaderIdNotIn(List<String> values) {
            addCriterion("uploader_id not in", values, "uploaderId");
            return (Criteria) this;
        }

        public Criteria andUploaderIdBetween(String value1, String value2) {
            addCriterion("uploader_id between", value1, value2, "uploaderId");
            return (Criteria) this;
        }

        public Criteria andUploaderIdNotBetween(String value1, String value2) {
            addCriterion("uploader_id not between", value1, value2, "uploaderId");
            return (Criteria) this;
        }

        public Criteria andImagePositionIsNull() {
            addCriterion("image_position is null");
            return (Criteria) this;
        }

        public Criteria andImagePositionIsNotNull() {
            addCriterion("image_position is not null");
            return (Criteria) this;
        }

        public Criteria andImagePositionEqualTo(String value) {
            addCriterion("image_position =", value, "imagePosition");
            return (Criteria) this;
        }

        public Criteria andImagePositionNotEqualTo(String value) {
            addCriterion("image_position <>", value, "imagePosition");
            return (Criteria) this;
        }

        public Criteria andImagePositionGreaterThan(String value) {
            addCriterion("image_position >", value, "imagePosition");
            return (Criteria) this;
        }

        public Criteria andImagePositionGreaterThanOrEqualTo(String value) {
            addCriterion("image_position >=", value, "imagePosition");
            return (Criteria) this;
        }

        public Criteria andImagePositionLessThan(String value) {
            addCriterion("image_position <", value, "imagePosition");
            return (Criteria) this;
        }

        public Criteria andImagePositionLessThanOrEqualTo(String value) {
            addCriterion("image_position <=", value, "imagePosition");
            return (Criteria) this;
        }

        public Criteria andImagePositionLike(String value) {
            addCriterion("image_position like", value, "imagePosition");
            return (Criteria) this;
        }

        public Criteria andImagePositionNotLike(String value) {
            addCriterion("image_position not like", value, "imagePosition");
            return (Criteria) this;
        }

        public Criteria andImagePositionIn(List<String> values) {
            addCriterion("image_position in", values, "imagePosition");
            return (Criteria) this;
        }

        public Criteria andImagePositionNotIn(List<String> values) {
            addCriterion("image_position not in", values, "imagePosition");
            return (Criteria) this;
        }

        public Criteria andImagePositionBetween(String value1, String value2) {
            addCriterion("image_position between", value1, value2, "imagePosition");
            return (Criteria) this;
        }

        public Criteria andImagePositionNotBetween(String value1, String value2) {
            addCriterion("image_position not between", value1, value2, "imagePosition");
            return (Criteria) this;
        }

        public Criteria andImageTimeIsNull() {
            addCriterion("image_time is null");
            return (Criteria) this;
        }

        public Criteria andImageTimeIsNotNull() {
            addCriterion("image_time is not null");
            return (Criteria) this;
        }

        public Criteria andImageTimeEqualTo(Date value) {
            addCriterion("image_time =", value, "imageTime");
            return (Criteria) this;
        }

        public Criteria andImageTimeNotEqualTo(Date value) {
            addCriterion("image_time <>", value, "imageTime");
            return (Criteria) this;
        }

        public Criteria andImageTimeGreaterThan(Date value) {
            addCriterion("image_time >", value, "imageTime");
            return (Criteria) this;
        }

        public Criteria andImageTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("image_time >=", value, "imageTime");
            return (Criteria) this;
        }

        public Criteria andImageTimeLessThan(Date value) {
            addCriterion("image_time <", value, "imageTime");
            return (Criteria) this;
        }

        public Criteria andImageTimeLessThanOrEqualTo(Date value) {
            addCriterion("image_time <=", value, "imageTime");
            return (Criteria) this;
        }

        public Criteria andImageTimeIn(List<Date> values) {
            addCriterion("image_time in", values, "imageTime");
            return (Criteria) this;
        }

        public Criteria andImageTimeNotIn(List<Date> values) {
            addCriterion("image_time not in", values, "imageTime");
            return (Criteria) this;
        }

        public Criteria andImageTimeBetween(Date value1, Date value2) {
            addCriterion("image_time between", value1, value2, "imageTime");
            return (Criteria) this;
        }

        public Criteria andImageTimeNotBetween(Date value1, Date value2) {
            addCriterion("image_time not between", value1, value2, "imageTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}