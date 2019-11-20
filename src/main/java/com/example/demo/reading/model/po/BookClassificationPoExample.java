/*
 *
 * BookClassificationPoExample.java
 * Copyright(C) 1993-2018 超星公司
 * @date 2018-10-30
 */
package com.example.demo.reading.model.po;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BookClassificationPoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookClassificationPoExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andClassificationIdIsNull() {
            addCriterion("classification_id is null");
            return (Criteria) this;
        }

        public Criteria andClassificationIdIsNotNull() {
            addCriterion("classification_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassificationIdEqualTo(String value) {
            addCriterion("classification_id =", value, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationIdNotEqualTo(String value) {
            addCriterion("classification_id <>", value, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationIdGreaterThan(String value) {
            addCriterion("classification_id >", value, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationIdGreaterThanOrEqualTo(String value) {
            addCriterion("classification_id >=", value, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationIdLessThan(String value) {
            addCriterion("classification_id <", value, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationIdLessThanOrEqualTo(String value) {
            addCriterion("classification_id <=", value, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationIdLike(String value) {
            addCriterion("classification_id like", value, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationIdNotLike(String value) {
            addCriterion("classification_id not like", value, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationIdIn(List<String> values) {
            addCriterion("classification_id in", values, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationIdNotIn(List<String> values) {
            addCriterion("classification_id not in", values, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationIdBetween(String value1, String value2) {
            addCriterion("classification_id between", value1, value2, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationIdNotBetween(String value1, String value2) {
            addCriterion("classification_id not between", value1, value2, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationNameIsNull() {
            addCriterion("classification_name is null");
            return (Criteria) this;
        }

        public Criteria andClassificationNameIsNotNull() {
            addCriterion("classification_name is not null");
            return (Criteria) this;
        }

        public Criteria andClassificationNameEqualTo(String value) {
            addCriterion("classification_name =", value, "classificationName");
            return (Criteria) this;
        }

        public Criteria andClassificationNameNotEqualTo(String value) {
            addCriterion("classification_name <>", value, "classificationName");
            return (Criteria) this;
        }

        public Criteria andClassificationNameGreaterThan(String value) {
            addCriterion("classification_name >", value, "classificationName");
            return (Criteria) this;
        }

        public Criteria andClassificationNameGreaterThanOrEqualTo(String value) {
            addCriterion("classification_name >=", value, "classificationName");
            return (Criteria) this;
        }

        public Criteria andClassificationNameLessThan(String value) {
            addCriterion("classification_name <", value, "classificationName");
            return (Criteria) this;
        }

        public Criteria andClassificationNameLessThanOrEqualTo(String value) {
            addCriterion("classification_name <=", value, "classificationName");
            return (Criteria) this;
        }

        public Criteria andClassificationNameLike(String value) {
            addCriterion("classification_name like", value, "classificationName");
            return (Criteria) this;
        }

        public Criteria andClassificationNameNotLike(String value) {
            addCriterion("classification_name not like", value, "classificationName");
            return (Criteria) this;
        }

        public Criteria andClassificationNameIn(List<String> values) {
            addCriterion("classification_name in", values, "classificationName");
            return (Criteria) this;
        }

        public Criteria andClassificationNameNotIn(List<String> values) {
            addCriterion("classification_name not in", values, "classificationName");
            return (Criteria) this;
        }

        public Criteria andClassificationNameBetween(String value1, String value2) {
            addCriterion("classification_name between", value1, value2, "classificationName");
            return (Criteria) this;
        }

        public Criteria andClassificationNameNotBetween(String value1, String value2) {
            addCriterion("classification_name not between", value1, value2, "classificationName");
            return (Criteria) this;
        }

        public Criteria andAddPersonNameIsNull() {
            addCriterion("add_person_name is null");
            return (Criteria) this;
        }

        public Criteria andAddPersonNameIsNotNull() {
            addCriterion("add_person_name is not null");
            return (Criteria) this;
        }

        public Criteria andAddPersonNameEqualTo(String value) {
            addCriterion("add_person_name =", value, "addPersonName");
            return (Criteria) this;
        }

        public Criteria andAddPersonNameNotEqualTo(String value) {
            addCriterion("add_person_name <>", value, "addPersonName");
            return (Criteria) this;
        }

        public Criteria andAddPersonNameGreaterThan(String value) {
            addCriterion("add_person_name >", value, "addPersonName");
            return (Criteria) this;
        }

        public Criteria andAddPersonNameGreaterThanOrEqualTo(String value) {
            addCriterion("add_person_name >=", value, "addPersonName");
            return (Criteria) this;
        }

        public Criteria andAddPersonNameLessThan(String value) {
            addCriterion("add_person_name <", value, "addPersonName");
            return (Criteria) this;
        }

        public Criteria andAddPersonNameLessThanOrEqualTo(String value) {
            addCriterion("add_person_name <=", value, "addPersonName");
            return (Criteria) this;
        }

        public Criteria andAddPersonNameLike(String value) {
            addCriterion("add_person_name like", value, "addPersonName");
            return (Criteria) this;
        }

        public Criteria andAddPersonNameNotLike(String value) {
            addCriterion("add_person_name not like", value, "addPersonName");
            return (Criteria) this;
        }

        public Criteria andAddPersonNameIn(List<String> values) {
            addCriterion("add_person_name in", values, "addPersonName");
            return (Criteria) this;
        }

        public Criteria andAddPersonNameNotIn(List<String> values) {
            addCriterion("add_person_name not in", values, "addPersonName");
            return (Criteria) this;
        }

        public Criteria andAddPersonNameBetween(String value1, String value2) {
            addCriterion("add_person_name between", value1, value2, "addPersonName");
            return (Criteria) this;
        }

        public Criteria andAddPersonNameNotBetween(String value1, String value2) {
            addCriterion("add_person_name not between", value1, value2, "addPersonName");
            return (Criteria) this;
        }

        public Criteria andAddPersonSchoolIsNull() {
            addCriterion("add_person_school is null");
            return (Criteria) this;
        }

        public Criteria andAddPersonSchoolIsNotNull() {
            addCriterion("add_person_school is not null");
            return (Criteria) this;
        }

        public Criteria andAddPersonSchoolEqualTo(String value) {
            addCriterion("add_person_school =", value, "addPersonSchool");
            return (Criteria) this;
        }

        public Criteria andAddPersonSchoolNotEqualTo(String value) {
            addCriterion("add_person_school <>", value, "addPersonSchool");
            return (Criteria) this;
        }

        public Criteria andAddPersonSchoolGreaterThan(String value) {
            addCriterion("add_person_school >", value, "addPersonSchool");
            return (Criteria) this;
        }

        public Criteria andAddPersonSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("add_person_school >=", value, "addPersonSchool");
            return (Criteria) this;
        }

        public Criteria andAddPersonSchoolLessThan(String value) {
            addCriterion("add_person_school <", value, "addPersonSchool");
            return (Criteria) this;
        }

        public Criteria andAddPersonSchoolLessThanOrEqualTo(String value) {
            addCriterion("add_person_school <=", value, "addPersonSchool");
            return (Criteria) this;
        }

        public Criteria andAddPersonSchoolLike(String value) {
            addCriterion("add_person_school like", value, "addPersonSchool");
            return (Criteria) this;
        }

        public Criteria andAddPersonSchoolNotLike(String value) {
            addCriterion("add_person_school not like", value, "addPersonSchool");
            return (Criteria) this;
        }

        public Criteria andAddPersonSchoolIn(List<String> values) {
            addCriterion("add_person_school in", values, "addPersonSchool");
            return (Criteria) this;
        }

        public Criteria andAddPersonSchoolNotIn(List<String> values) {
            addCriterion("add_person_school not in", values, "addPersonSchool");
            return (Criteria) this;
        }

        public Criteria andAddPersonSchoolBetween(String value1, String value2) {
            addCriterion("add_person_school between", value1, value2, "addPersonSchool");
            return (Criteria) this;
        }

        public Criteria andAddPersonSchoolNotBetween(String value1, String value2) {
            addCriterion("add_person_school not between", value1, value2, "addPersonSchool");
            return (Criteria) this;
        }

        public Criteria andClassificationIsNull() {
            addCriterion("classification is null");
            return (Criteria) this;
        }

        public Criteria andClassificationIsNotNull() {
            addCriterion("classification is not null");
            return (Criteria) this;
        }

        public Criteria andClassificationEqualTo(String value) {
            addCriterion("classification =", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationNotEqualTo(String value) {
            addCriterion("classification <>", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationGreaterThan(String value) {
            addCriterion("classification >", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationGreaterThanOrEqualTo(String value) {
            addCriterion("classification >=", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationLessThan(String value) {
            addCriterion("classification <", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationLessThanOrEqualTo(String value) {
            addCriterion("classification <=", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationLike(String value) {
            addCriterion("classification like", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationNotLike(String value) {
            addCriterion("classification not like", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationIn(List<String> values) {
            addCriterion("classification in", values, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationNotIn(List<String> values) {
            addCriterion("classification not in", values, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationBetween(String value1, String value2) {
            addCriterion("classification between", value1, value2, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationNotBetween(String value1, String value2) {
            addCriterion("classification not between", value1, value2, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationRankIsNull() {
            addCriterion("classification_rank is null");
            return (Criteria) this;
        }

        public Criteria andClassificationRankIsNotNull() {
            addCriterion("classification_rank is not null");
            return (Criteria) this;
        }

        public Criteria andClassificationRankEqualTo(Integer value) {
            addCriterion("classification_rank =", value, "classificationRank");
            return (Criteria) this;
        }

        public Criteria andClassificationRankNotEqualTo(Integer value) {
            addCriterion("classification_rank <>", value, "classificationRank");
            return (Criteria) this;
        }

        public Criteria andClassificationRankGreaterThan(Integer value) {
            addCriterion("classification_rank >", value, "classificationRank");
            return (Criteria) this;
        }

        public Criteria andClassificationRankGreaterThanOrEqualTo(Integer value) {
            addCriterion("classification_rank >=", value, "classificationRank");
            return (Criteria) this;
        }

        public Criteria andClassificationRankLessThan(Integer value) {
            addCriterion("classification_rank <", value, "classificationRank");
            return (Criteria) this;
        }

        public Criteria andClassificationRankLessThanOrEqualTo(Integer value) {
            addCriterion("classification_rank <=", value, "classificationRank");
            return (Criteria) this;
        }

        public Criteria andClassificationRankIn(List<Integer> values) {
            addCriterion("classification_rank in", values, "classificationRank");
            return (Criteria) this;
        }

        public Criteria andClassificationRankNotIn(List<Integer> values) {
            addCriterion("classification_rank not in", values, "classificationRank");
            return (Criteria) this;
        }

        public Criteria andClassificationRankBetween(Integer value1, Integer value2) {
            addCriterion("classification_rank between", value1, value2, "classificationRank");
            return (Criteria) this;
        }

        public Criteria andClassificationRankNotBetween(Integer value1, Integer value2) {
            addCriterion("classification_rank not between", value1, value2, "classificationRank");
            return (Criteria) this;
        }

        public Criteria andParentClassificationIdIsNull() {
            addCriterion("parent_classification_id is null");
            return (Criteria) this;
        }

        public Criteria andParentClassificationIdIsNotNull() {
            addCriterion("parent_classification_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentClassificationIdEqualTo(String value) {
            addCriterion("parent_classification_id =", value, "parentClassificationId");
            return (Criteria) this;
        }

        public Criteria andParentClassificationIdNotEqualTo(String value) {
            addCriterion("parent_classification_id <>", value, "parentClassificationId");
            return (Criteria) this;
        }

        public Criteria andParentClassificationIdGreaterThan(String value) {
            addCriterion("parent_classification_id >", value, "parentClassificationId");
            return (Criteria) this;
        }

        public Criteria andParentClassificationIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_classification_id >=", value, "parentClassificationId");
            return (Criteria) this;
        }

        public Criteria andParentClassificationIdLessThan(String value) {
            addCriterion("parent_classification_id <", value, "parentClassificationId");
            return (Criteria) this;
        }

        public Criteria andParentClassificationIdLessThanOrEqualTo(String value) {
            addCriterion("parent_classification_id <=", value, "parentClassificationId");
            return (Criteria) this;
        }

        public Criteria andParentClassificationIdLike(String value) {
            addCriterion("parent_classification_id like", value, "parentClassificationId");
            return (Criteria) this;
        }

        public Criteria andParentClassificationIdNotLike(String value) {
            addCriterion("parent_classification_id not like", value, "parentClassificationId");
            return (Criteria) this;
        }

        public Criteria andParentClassificationIdIn(List<String> values) {
            addCriterion("parent_classification_id in", values, "parentClassificationId");
            return (Criteria) this;
        }

        public Criteria andParentClassificationIdNotIn(List<String> values) {
            addCriterion("parent_classification_id not in", values, "parentClassificationId");
            return (Criteria) this;
        }

        public Criteria andParentClassificationIdBetween(String value1, String value2) {
            addCriterion("parent_classification_id between", value1, value2, "parentClassificationId");
            return (Criteria) this;
        }

        public Criteria andParentClassificationIdNotBetween(String value1, String value2) {
            addCriterion("parent_classification_id not between", value1, value2, "parentClassificationId");
            return (Criteria) this;
        }

        public Criteria andIsDisplayIsNull() {
            addCriterion("is_display is null");
            return (Criteria) this;
        }

        public Criteria andIsDisplayIsNotNull() {
            addCriterion("is_display is not null");
            return (Criteria) this;
        }

        public Criteria andIsDisplayEqualTo(Integer value) {
            addCriterion("is_display =", value, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andIsDisplayNotEqualTo(Integer value) {
            addCriterion("is_display <>", value, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andIsDisplayGreaterThan(Integer value) {
            addCriterion("is_display >", value, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andIsDisplayGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_display >=", value, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andIsDisplayLessThan(Integer value) {
            addCriterion("is_display <", value, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andIsDisplayLessThanOrEqualTo(Integer value) {
            addCriterion("is_display <=", value, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andIsDisplayIn(List<Integer> values) {
            addCriterion("is_display in", values, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andIsDisplayNotIn(List<Integer> values) {
            addCriterion("is_display not in", values, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andIsDisplayBetween(Integer value1, Integer value2) {
            addCriterion("is_display between", value1, value2, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andIsDisplayNotBetween(Integer value1, Integer value2) {
            addCriterion("is_display not between", value1, value2, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Timestamp value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Timestamp value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Timestamp value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Timestamp value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Timestamp value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Timestamp> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Timestamp> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Timestamp value1, Timestamp value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Timestamp value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Timestamp value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Timestamp value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Timestamp value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Timestamp value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Timestamp> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Timestamp> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Timestamp value1, Timestamp value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
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