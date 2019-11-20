/*
*
* ClassicBooksExample.java
* Copyright(C) 1993-2018 超星公司
* @date 2019-10-14
*/
package com.example.demo.reading.model.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClassicBooksExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClassicBooksExample() {
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

        public Criteria andResourceIdIsNull() {
            addCriterion("resource_id is null");
            return (Criteria) this;
        }

        public Criteria andResourceIdIsNotNull() {
            addCriterion("resource_id is not null");
            return (Criteria) this;
        }

        public Criteria andResourceIdEqualTo(String value) {
            addCriterion("resource_id =", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotEqualTo(String value) {
            addCriterion("resource_id <>", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdGreaterThan(String value) {
            addCriterion("resource_id >", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdGreaterThanOrEqualTo(String value) {
            addCriterion("resource_id >=", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdLessThan(String value) {
            addCriterion("resource_id <", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdLessThanOrEqualTo(String value) {
            addCriterion("resource_id <=", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdLike(String value) {
            addCriterion("resource_id like", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotLike(String value) {
            addCriterion("resource_id not like", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdIn(List<String> values) {
            addCriterion("resource_id in", values, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotIn(List<String> values) {
            addCriterion("resource_id not in", values, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdBetween(String value1, String value2) {
            addCriterion("resource_id between", value1, value2, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotBetween(String value1, String value2) {
            addCriterion("resource_id not between", value1, value2, "resourceId");
            return (Criteria) this;
        }

        public Criteria andBasicTitleIsNull() {
            addCriterion("basic_title is null");
            return (Criteria) this;
        }

        public Criteria andBasicTitleIsNotNull() {
            addCriterion("basic_title is not null");
            return (Criteria) this;
        }

        public Criteria andBasicTitleEqualTo(String value) {
            addCriterion("basic_title =", value, "basicTitle");
            return (Criteria) this;
        }

        public Criteria andBasicTitleNotEqualTo(String value) {
            addCriterion("basic_title <>", value, "basicTitle");
            return (Criteria) this;
        }

        public Criteria andBasicTitleGreaterThan(String value) {
            addCriterion("basic_title >", value, "basicTitle");
            return (Criteria) this;
        }

        public Criteria andBasicTitleGreaterThanOrEqualTo(String value) {
            addCriterion("basic_title >=", value, "basicTitle");
            return (Criteria) this;
        }

        public Criteria andBasicTitleLessThan(String value) {
            addCriterion("basic_title <", value, "basicTitle");
            return (Criteria) this;
        }

        public Criteria andBasicTitleLessThanOrEqualTo(String value) {
            addCriterion("basic_title <=", value, "basicTitle");
            return (Criteria) this;
        }

        public Criteria andBasicTitleLike(String value) {
            addCriterion("basic_title like", value, "basicTitle");
            return (Criteria) this;
        }

        public Criteria andBasicTitleNotLike(String value) {
            addCriterion("basic_title not like", value, "basicTitle");
            return (Criteria) this;
        }

        public Criteria andBasicTitleIn(List<String> values) {
            addCriterion("basic_title in", values, "basicTitle");
            return (Criteria) this;
        }

        public Criteria andBasicTitleNotIn(List<String> values) {
            addCriterion("basic_title not in", values, "basicTitle");
            return (Criteria) this;
        }

        public Criteria andBasicTitleBetween(String value1, String value2) {
            addCriterion("basic_title between", value1, value2, "basicTitle");
            return (Criteria) this;
        }

        public Criteria andBasicTitleNotBetween(String value1, String value2) {
            addCriterion("basic_title not between", value1, value2, "basicTitle");
            return (Criteria) this;
        }

        public Criteria andBasicCreatorIsNull() {
            addCriterion("basic_creator is null");
            return (Criteria) this;
        }

        public Criteria andBasicCreatorIsNotNull() {
            addCriterion("basic_creator is not null");
            return (Criteria) this;
        }

        public Criteria andBasicCreatorEqualTo(String value) {
            addCriterion("basic_creator =", value, "basicCreator");
            return (Criteria) this;
        }

        public Criteria andBasicCreatorNotEqualTo(String value) {
            addCriterion("basic_creator <>", value, "basicCreator");
            return (Criteria) this;
        }

        public Criteria andBasicCreatorGreaterThan(String value) {
            addCriterion("basic_creator >", value, "basicCreator");
            return (Criteria) this;
        }

        public Criteria andBasicCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("basic_creator >=", value, "basicCreator");
            return (Criteria) this;
        }

        public Criteria andBasicCreatorLessThan(String value) {
            addCriterion("basic_creator <", value, "basicCreator");
            return (Criteria) this;
        }

        public Criteria andBasicCreatorLessThanOrEqualTo(String value) {
            addCriterion("basic_creator <=", value, "basicCreator");
            return (Criteria) this;
        }

        public Criteria andBasicCreatorLike(String value) {
            addCriterion("basic_creator like", value, "basicCreator");
            return (Criteria) this;
        }

        public Criteria andBasicCreatorNotLike(String value) {
            addCriterion("basic_creator not like", value, "basicCreator");
            return (Criteria) this;
        }

        public Criteria andBasicCreatorIn(List<String> values) {
            addCriterion("basic_creator in", values, "basicCreator");
            return (Criteria) this;
        }

        public Criteria andBasicCreatorNotIn(List<String> values) {
            addCriterion("basic_creator not in", values, "basicCreator");
            return (Criteria) this;
        }

        public Criteria andBasicCreatorBetween(String value1, String value2) {
            addCriterion("basic_creator between", value1, value2, "basicCreator");
            return (Criteria) this;
        }

        public Criteria andBasicCreatorNotBetween(String value1, String value2) {
            addCriterion("basic_creator not between", value1, value2, "basicCreator");
            return (Criteria) this;
        }

        public Criteria andBasicPublisherIsNull() {
            addCriterion("basic_publisher is null");
            return (Criteria) this;
        }

        public Criteria andBasicPublisherIsNotNull() {
            addCriterion("basic_publisher is not null");
            return (Criteria) this;
        }

        public Criteria andBasicPublisherEqualTo(String value) {
            addCriterion("basic_publisher =", value, "basicPublisher");
            return (Criteria) this;
        }

        public Criteria andBasicPublisherNotEqualTo(String value) {
            addCriterion("basic_publisher <>", value, "basicPublisher");
            return (Criteria) this;
        }

        public Criteria andBasicPublisherGreaterThan(String value) {
            addCriterion("basic_publisher >", value, "basicPublisher");
            return (Criteria) this;
        }

        public Criteria andBasicPublisherGreaterThanOrEqualTo(String value) {
            addCriterion("basic_publisher >=", value, "basicPublisher");
            return (Criteria) this;
        }

        public Criteria andBasicPublisherLessThan(String value) {
            addCriterion("basic_publisher <", value, "basicPublisher");
            return (Criteria) this;
        }

        public Criteria andBasicPublisherLessThanOrEqualTo(String value) {
            addCriterion("basic_publisher <=", value, "basicPublisher");
            return (Criteria) this;
        }

        public Criteria andBasicPublisherLike(String value) {
            addCriterion("basic_publisher like", value, "basicPublisher");
            return (Criteria) this;
        }

        public Criteria andBasicPublisherNotLike(String value) {
            addCriterion("basic_publisher not like", value, "basicPublisher");
            return (Criteria) this;
        }

        public Criteria andBasicPublisherIn(List<String> values) {
            addCriterion("basic_publisher in", values, "basicPublisher");
            return (Criteria) this;
        }

        public Criteria andBasicPublisherNotIn(List<String> values) {
            addCriterion("basic_publisher not in", values, "basicPublisher");
            return (Criteria) this;
        }

        public Criteria andBasicPublisherBetween(String value1, String value2) {
            addCriterion("basic_publisher between", value1, value2, "basicPublisher");
            return (Criteria) this;
        }

        public Criteria andBasicPublisherNotBetween(String value1, String value2) {
            addCriterion("basic_publisher not between", value1, value2, "basicPublisher");
            return (Criteria) this;
        }

        public Criteria andBasicKeywordIsNull() {
            addCriterion("basic_keyword is null");
            return (Criteria) this;
        }

        public Criteria andBasicKeywordIsNotNull() {
            addCriterion("basic_keyword is not null");
            return (Criteria) this;
        }

        public Criteria andBasicKeywordEqualTo(String value) {
            addCriterion("basic_keyword =", value, "basicKeyword");
            return (Criteria) this;
        }

        public Criteria andBasicKeywordNotEqualTo(String value) {
            addCriterion("basic_keyword <>", value, "basicKeyword");
            return (Criteria) this;
        }

        public Criteria andBasicKeywordGreaterThan(String value) {
            addCriterion("basic_keyword >", value, "basicKeyword");
            return (Criteria) this;
        }

        public Criteria andBasicKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("basic_keyword >=", value, "basicKeyword");
            return (Criteria) this;
        }

        public Criteria andBasicKeywordLessThan(String value) {
            addCriterion("basic_keyword <", value, "basicKeyword");
            return (Criteria) this;
        }

        public Criteria andBasicKeywordLessThanOrEqualTo(String value) {
            addCriterion("basic_keyword <=", value, "basicKeyword");
            return (Criteria) this;
        }

        public Criteria andBasicKeywordLike(String value) {
            addCriterion("basic_keyword like", value, "basicKeyword");
            return (Criteria) this;
        }

        public Criteria andBasicKeywordNotLike(String value) {
            addCriterion("basic_keyword not like", value, "basicKeyword");
            return (Criteria) this;
        }

        public Criteria andBasicKeywordIn(List<String> values) {
            addCriterion("basic_keyword in", values, "basicKeyword");
            return (Criteria) this;
        }

        public Criteria andBasicKeywordNotIn(List<String> values) {
            addCriterion("basic_keyword not in", values, "basicKeyword");
            return (Criteria) this;
        }

        public Criteria andBasicKeywordBetween(String value1, String value2) {
            addCriterion("basic_keyword between", value1, value2, "basicKeyword");
            return (Criteria) this;
        }

        public Criteria andBasicKeywordNotBetween(String value1, String value2) {
            addCriterion("basic_keyword not between", value1, value2, "basicKeyword");
            return (Criteria) this;
        }

        public Criteria andBasicContactIsNull() {
            addCriterion("basic_contact is null");
            return (Criteria) this;
        }

        public Criteria andBasicContactIsNotNull() {
            addCriterion("basic_contact is not null");
            return (Criteria) this;
        }

        public Criteria andBasicContactEqualTo(String value) {
            addCriterion("basic_contact =", value, "basicContact");
            return (Criteria) this;
        }

        public Criteria andBasicContactNotEqualTo(String value) {
            addCriterion("basic_contact <>", value, "basicContact");
            return (Criteria) this;
        }

        public Criteria andBasicContactGreaterThan(String value) {
            addCriterion("basic_contact >", value, "basicContact");
            return (Criteria) this;
        }

        public Criteria andBasicContactGreaterThanOrEqualTo(String value) {
            addCriterion("basic_contact >=", value, "basicContact");
            return (Criteria) this;
        }

        public Criteria andBasicContactLessThan(String value) {
            addCriterion("basic_contact <", value, "basicContact");
            return (Criteria) this;
        }

        public Criteria andBasicContactLessThanOrEqualTo(String value) {
            addCriterion("basic_contact <=", value, "basicContact");
            return (Criteria) this;
        }

        public Criteria andBasicContactLike(String value) {
            addCriterion("basic_contact like", value, "basicContact");
            return (Criteria) this;
        }

        public Criteria andBasicContactNotLike(String value) {
            addCriterion("basic_contact not like", value, "basicContact");
            return (Criteria) this;
        }

        public Criteria andBasicContactIn(List<String> values) {
            addCriterion("basic_contact in", values, "basicContact");
            return (Criteria) this;
        }

        public Criteria andBasicContactNotIn(List<String> values) {
            addCriterion("basic_contact not in", values, "basicContact");
            return (Criteria) this;
        }

        public Criteria andBasicContactBetween(String value1, String value2) {
            addCriterion("basic_contact between", value1, value2, "basicContact");
            return (Criteria) this;
        }

        public Criteria andBasicContactNotBetween(String value1, String value2) {
            addCriterion("basic_contact not between", value1, value2, "basicContact");
            return (Criteria) this;
        }

        public Criteria andBasicSourceNameIsNull() {
            addCriterion("basic_source_name is null");
            return (Criteria) this;
        }

        public Criteria andBasicSourceNameIsNotNull() {
            addCriterion("basic_source_name is not null");
            return (Criteria) this;
        }

        public Criteria andBasicSourceNameEqualTo(String value) {
            addCriterion("basic_source_name =", value, "basicSourceName");
            return (Criteria) this;
        }

        public Criteria andBasicSourceNameNotEqualTo(String value) {
            addCriterion("basic_source_name <>", value, "basicSourceName");
            return (Criteria) this;
        }

        public Criteria andBasicSourceNameGreaterThan(String value) {
            addCriterion("basic_source_name >", value, "basicSourceName");
            return (Criteria) this;
        }

        public Criteria andBasicSourceNameGreaterThanOrEqualTo(String value) {
            addCriterion("basic_source_name >=", value, "basicSourceName");
            return (Criteria) this;
        }

        public Criteria andBasicSourceNameLessThan(String value) {
            addCriterion("basic_source_name <", value, "basicSourceName");
            return (Criteria) this;
        }

        public Criteria andBasicSourceNameLessThanOrEqualTo(String value) {
            addCriterion("basic_source_name <=", value, "basicSourceName");
            return (Criteria) this;
        }

        public Criteria andBasicSourceNameLike(String value) {
            addCriterion("basic_source_name like", value, "basicSourceName");
            return (Criteria) this;
        }

        public Criteria andBasicSourceNameNotLike(String value) {
            addCriterion("basic_source_name not like", value, "basicSourceName");
            return (Criteria) this;
        }

        public Criteria andBasicSourceNameIn(List<String> values) {
            addCriterion("basic_source_name in", values, "basicSourceName");
            return (Criteria) this;
        }

        public Criteria andBasicSourceNameNotIn(List<String> values) {
            addCriterion("basic_source_name not in", values, "basicSourceName");
            return (Criteria) this;
        }

        public Criteria andBasicSourceNameBetween(String value1, String value2) {
            addCriterion("basic_source_name between", value1, value2, "basicSourceName");
            return (Criteria) this;
        }

        public Criteria andBasicSourceNameNotBetween(String value1, String value2) {
            addCriterion("basic_source_name not between", value1, value2, "basicSourceName");
            return (Criteria) this;
        }

        public Criteria andBasicDateIsNull() {
            addCriterion("basic_date is null");
            return (Criteria) this;
        }

        public Criteria andBasicDateIsNotNull() {
            addCriterion("basic_date is not null");
            return (Criteria) this;
        }

        public Criteria andBasicDateEqualTo(String value) {
            addCriterion("basic_date =", value, "basicDate");
            return (Criteria) this;
        }

        public Criteria andBasicDateNotEqualTo(String value) {
            addCriterion("basic_date <>", value, "basicDate");
            return (Criteria) this;
        }

        public Criteria andBasicDateGreaterThan(String value) {
            addCriterion("basic_date >", value, "basicDate");
            return (Criteria) this;
        }

        public Criteria andBasicDateGreaterThanOrEqualTo(String value) {
            addCriterion("basic_date >=", value, "basicDate");
            return (Criteria) this;
        }

        public Criteria andBasicDateLessThan(String value) {
            addCriterion("basic_date <", value, "basicDate");
            return (Criteria) this;
        }

        public Criteria andBasicDateLessThanOrEqualTo(String value) {
            addCriterion("basic_date <=", value, "basicDate");
            return (Criteria) this;
        }

        public Criteria andBasicDateLike(String value) {
            addCriterion("basic_date like", value, "basicDate");
            return (Criteria) this;
        }

        public Criteria andBasicDateNotLike(String value) {
            addCriterion("basic_date not like", value, "basicDate");
            return (Criteria) this;
        }

        public Criteria andBasicDateIn(List<String> values) {
            addCriterion("basic_date in", values, "basicDate");
            return (Criteria) this;
        }

        public Criteria andBasicDateNotIn(List<String> values) {
            addCriterion("basic_date not in", values, "basicDate");
            return (Criteria) this;
        }

        public Criteria andBasicDateBetween(String value1, String value2) {
            addCriterion("basic_date between", value1, value2, "basicDate");
            return (Criteria) this;
        }

        public Criteria andBasicDateNotBetween(String value1, String value2) {
            addCriterion("basic_date not between", value1, value2, "basicDate");
            return (Criteria) this;
        }

        public Criteria andBasicIdentifier1IsNull() {
            addCriterion("basic_identifier_1 is null");
            return (Criteria) this;
        }

        public Criteria andBasicIdentifier1IsNotNull() {
            addCriterion("basic_identifier_1 is not null");
            return (Criteria) this;
        }

        public Criteria andBasicIdentifier1EqualTo(String value) {
            addCriterion("basic_identifier_1 =", value, "basicIdentifier1");
            return (Criteria) this;
        }

        public Criteria andBasicIdentifier1NotEqualTo(String value) {
            addCriterion("basic_identifier_1 <>", value, "basicIdentifier1");
            return (Criteria) this;
        }

        public Criteria andBasicIdentifier1GreaterThan(String value) {
            addCriterion("basic_identifier_1 >", value, "basicIdentifier1");
            return (Criteria) this;
        }

        public Criteria andBasicIdentifier1GreaterThanOrEqualTo(String value) {
            addCriterion("basic_identifier_1 >=", value, "basicIdentifier1");
            return (Criteria) this;
        }

        public Criteria andBasicIdentifier1LessThan(String value) {
            addCriterion("basic_identifier_1 <", value, "basicIdentifier1");
            return (Criteria) this;
        }

        public Criteria andBasicIdentifier1LessThanOrEqualTo(String value) {
            addCriterion("basic_identifier_1 <=", value, "basicIdentifier1");
            return (Criteria) this;
        }

        public Criteria andBasicIdentifier1Like(String value) {
            addCriterion("basic_identifier_1 like", value, "basicIdentifier1");
            return (Criteria) this;
        }

        public Criteria andBasicIdentifier1NotLike(String value) {
            addCriterion("basic_identifier_1 not like", value, "basicIdentifier1");
            return (Criteria) this;
        }

        public Criteria andBasicIdentifier1In(List<String> values) {
            addCriterion("basic_identifier_1 in", values, "basicIdentifier1");
            return (Criteria) this;
        }

        public Criteria andBasicIdentifier1NotIn(List<String> values) {
            addCriterion("basic_identifier_1 not in", values, "basicIdentifier1");
            return (Criteria) this;
        }

        public Criteria andBasicIdentifier1Between(String value1, String value2) {
            addCriterion("basic_identifier_1 between", value1, value2, "basicIdentifier1");
            return (Criteria) this;
        }

        public Criteria andBasicIdentifier1NotBetween(String value1, String value2) {
            addCriterion("basic_identifier_1 not between", value1, value2, "basicIdentifier1");
            return (Criteria) this;
        }

        public Criteria andBasicDescriptionIsNull() {
            addCriterion("basic_description is null");
            return (Criteria) this;
        }

        public Criteria andBasicDescriptionIsNotNull() {
            addCriterion("basic_description is not null");
            return (Criteria) this;
        }

        public Criteria andBasicDescriptionEqualTo(String value) {
            addCriterion("basic_description =", value, "basicDescription");
            return (Criteria) this;
        }

        public Criteria andBasicDescriptionNotEqualTo(String value) {
            addCriterion("basic_description <>", value, "basicDescription");
            return (Criteria) this;
        }

        public Criteria andBasicDescriptionGreaterThan(String value) {
            addCriterion("basic_description >", value, "basicDescription");
            return (Criteria) this;
        }

        public Criteria andBasicDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("basic_description >=", value, "basicDescription");
            return (Criteria) this;
        }

        public Criteria andBasicDescriptionLessThan(String value) {
            addCriterion("basic_description <", value, "basicDescription");
            return (Criteria) this;
        }

        public Criteria andBasicDescriptionLessThanOrEqualTo(String value) {
            addCriterion("basic_description <=", value, "basicDescription");
            return (Criteria) this;
        }

        public Criteria andBasicDescriptionLike(String value) {
            addCriterion("basic_description like", value, "basicDescription");
            return (Criteria) this;
        }

        public Criteria andBasicDescriptionNotLike(String value) {
            addCriterion("basic_description not like", value, "basicDescription");
            return (Criteria) this;
        }

        public Criteria andBasicDescriptionIn(List<String> values) {
            addCriterion("basic_description in", values, "basicDescription");
            return (Criteria) this;
        }

        public Criteria andBasicDescriptionNotIn(List<String> values) {
            addCriterion("basic_description not in", values, "basicDescription");
            return (Criteria) this;
        }

        public Criteria andBasicDescriptionBetween(String value1, String value2) {
            addCriterion("basic_description between", value1, value2, "basicDescription");
            return (Criteria) this;
        }

        public Criteria andBasicDescriptionNotBetween(String value1, String value2) {
            addCriterion("basic_description not between", value1, value2, "basicDescription");
            return (Criteria) this;
        }

        public Criteria andBasicSourceNoIsNull() {
            addCriterion("basic_source_no is null");
            return (Criteria) this;
        }

        public Criteria andBasicSourceNoIsNotNull() {
            addCriterion("basic_source_no is not null");
            return (Criteria) this;
        }

        public Criteria andBasicSourceNoEqualTo(String value) {
            addCriterion("basic_source_no =", value, "basicSourceNo");
            return (Criteria) this;
        }

        public Criteria andBasicSourceNoNotEqualTo(String value) {
            addCriterion("basic_source_no <>", value, "basicSourceNo");
            return (Criteria) this;
        }

        public Criteria andBasicSourceNoGreaterThan(String value) {
            addCriterion("basic_source_no >", value, "basicSourceNo");
            return (Criteria) this;
        }

        public Criteria andBasicSourceNoGreaterThanOrEqualTo(String value) {
            addCriterion("basic_source_no >=", value, "basicSourceNo");
            return (Criteria) this;
        }

        public Criteria andBasicSourceNoLessThan(String value) {
            addCriterion("basic_source_no <", value, "basicSourceNo");
            return (Criteria) this;
        }

        public Criteria andBasicSourceNoLessThanOrEqualTo(String value) {
            addCriterion("basic_source_no <=", value, "basicSourceNo");
            return (Criteria) this;
        }

        public Criteria andBasicSourceNoLike(String value) {
            addCriterion("basic_source_no like", value, "basicSourceNo");
            return (Criteria) this;
        }

        public Criteria andBasicSourceNoNotLike(String value) {
            addCriterion("basic_source_no not like", value, "basicSourceNo");
            return (Criteria) this;
        }

        public Criteria andBasicSourceNoIn(List<String> values) {
            addCriterion("basic_source_no in", values, "basicSourceNo");
            return (Criteria) this;
        }

        public Criteria andBasicSourceNoNotIn(List<String> values) {
            addCriterion("basic_source_no not in", values, "basicSourceNo");
            return (Criteria) this;
        }

        public Criteria andBasicSourceNoBetween(String value1, String value2) {
            addCriterion("basic_source_no between", value1, value2, "basicSourceNo");
            return (Criteria) this;
        }

        public Criteria andBasicSourceNoNotBetween(String value1, String value2) {
            addCriterion("basic_source_no not between", value1, value2, "basicSourceNo");
            return (Criteria) this;
        }

        public Criteria andBasicPageIsNull() {
            addCriterion("basic_page is null");
            return (Criteria) this;
        }

        public Criteria andBasicPageIsNotNull() {
            addCriterion("basic_page is not null");
            return (Criteria) this;
        }

        public Criteria andBasicPageEqualTo(String value) {
            addCriterion("basic_page =", value, "basicPage");
            return (Criteria) this;
        }

        public Criteria andBasicPageNotEqualTo(String value) {
            addCriterion("basic_page <>", value, "basicPage");
            return (Criteria) this;
        }

        public Criteria andBasicPageGreaterThan(String value) {
            addCriterion("basic_page >", value, "basicPage");
            return (Criteria) this;
        }

        public Criteria andBasicPageGreaterThanOrEqualTo(String value) {
            addCriterion("basic_page >=", value, "basicPage");
            return (Criteria) this;
        }

        public Criteria andBasicPageLessThan(String value) {
            addCriterion("basic_page <", value, "basicPage");
            return (Criteria) this;
        }

        public Criteria andBasicPageLessThanOrEqualTo(String value) {
            addCriterion("basic_page <=", value, "basicPage");
            return (Criteria) this;
        }

        public Criteria andBasicPageLike(String value) {
            addCriterion("basic_page like", value, "basicPage");
            return (Criteria) this;
        }

        public Criteria andBasicPageNotLike(String value) {
            addCriterion("basic_page not like", value, "basicPage");
            return (Criteria) this;
        }

        public Criteria andBasicPageIn(List<String> values) {
            addCriterion("basic_page in", values, "basicPage");
            return (Criteria) this;
        }

        public Criteria andBasicPageNotIn(List<String> values) {
            addCriterion("basic_page not in", values, "basicPage");
            return (Criteria) this;
        }

        public Criteria andBasicPageBetween(String value1, String value2) {
            addCriterion("basic_page between", value1, value2, "basicPage");
            return (Criteria) this;
        }

        public Criteria andBasicPageNotBetween(String value1, String value2) {
            addCriterion("basic_page not between", value1, value2, "basicPage");
            return (Criteria) this;
        }

        public Criteria andProcYearIsNull() {
            addCriterion("proc_year is null");
            return (Criteria) this;
        }

        public Criteria andProcYearIsNotNull() {
            addCriterion("proc_year is not null");
            return (Criteria) this;
        }

        public Criteria andProcYearEqualTo(String value) {
            addCriterion("proc_year =", value, "procYear");
            return (Criteria) this;
        }

        public Criteria andProcYearNotEqualTo(String value) {
            addCriterion("proc_year <>", value, "procYear");
            return (Criteria) this;
        }

        public Criteria andProcYearGreaterThan(String value) {
            addCriterion("proc_year >", value, "procYear");
            return (Criteria) this;
        }

        public Criteria andProcYearGreaterThanOrEqualTo(String value) {
            addCriterion("proc_year >=", value, "procYear");
            return (Criteria) this;
        }

        public Criteria andProcYearLessThan(String value) {
            addCriterion("proc_year <", value, "procYear");
            return (Criteria) this;
        }

        public Criteria andProcYearLessThanOrEqualTo(String value) {
            addCriterion("proc_year <=", value, "procYear");
            return (Criteria) this;
        }

        public Criteria andProcYearLike(String value) {
            addCriterion("proc_year like", value, "procYear");
            return (Criteria) this;
        }

        public Criteria andProcYearNotLike(String value) {
            addCriterion("proc_year not like", value, "procYear");
            return (Criteria) this;
        }

        public Criteria andProcYearIn(List<String> values) {
            addCriterion("proc_year in", values, "procYear");
            return (Criteria) this;
        }

        public Criteria andProcYearNotIn(List<String> values) {
            addCriterion("proc_year not in", values, "procYear");
            return (Criteria) this;
        }

        public Criteria andProcYearBetween(String value1, String value2) {
            addCriterion("proc_year between", value1, value2, "procYear");
            return (Criteria) this;
        }

        public Criteria andProcYearNotBetween(String value1, String value2) {
            addCriterion("proc_year not between", value1, value2, "procYear");
            return (Criteria) this;
        }

        public Criteria andProcEnbodyIsNull() {
            addCriterion("proc_enbody is null");
            return (Criteria) this;
        }

        public Criteria andProcEnbodyIsNotNull() {
            addCriterion("proc_enbody is not null");
            return (Criteria) this;
        }

        public Criteria andProcEnbodyEqualTo(String value) {
            addCriterion("proc_enbody =", value, "procEnbody");
            return (Criteria) this;
        }

        public Criteria andProcEnbodyNotEqualTo(String value) {
            addCriterion("proc_enbody <>", value, "procEnbody");
            return (Criteria) this;
        }

        public Criteria andProcEnbodyGreaterThan(String value) {
            addCriterion("proc_enbody >", value, "procEnbody");
            return (Criteria) this;
        }

        public Criteria andProcEnbodyGreaterThanOrEqualTo(String value) {
            addCriterion("proc_enbody >=", value, "procEnbody");
            return (Criteria) this;
        }

        public Criteria andProcEnbodyLessThan(String value) {
            addCriterion("proc_enbody <", value, "procEnbody");
            return (Criteria) this;
        }

        public Criteria andProcEnbodyLessThanOrEqualTo(String value) {
            addCriterion("proc_enbody <=", value, "procEnbody");
            return (Criteria) this;
        }

        public Criteria andProcEnbodyLike(String value) {
            addCriterion("proc_enbody like", value, "procEnbody");
            return (Criteria) this;
        }

        public Criteria andProcEnbodyNotLike(String value) {
            addCriterion("proc_enbody not like", value, "procEnbody");
            return (Criteria) this;
        }

        public Criteria andProcEnbodyIn(List<String> values) {
            addCriterion("proc_enbody in", values, "procEnbody");
            return (Criteria) this;
        }

        public Criteria andProcEnbodyNotIn(List<String> values) {
            addCriterion("proc_enbody not in", values, "procEnbody");
            return (Criteria) this;
        }

        public Criteria andProcEnbodyBetween(String value1, String value2) {
            addCriterion("proc_enbody between", value1, value2, "procEnbody");
            return (Criteria) this;
        }

        public Criteria andProcEnbodyNotBetween(String value1, String value2) {
            addCriterion("proc_enbody not between", value1, value2, "procEnbody");
            return (Criteria) this;
        }

        public Criteria andProcClassIdIsNull() {
            addCriterion("proc_class_id is null");
            return (Criteria) this;
        }

        public Criteria andProcClassIdIsNotNull() {
            addCriterion("proc_class_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcClassIdEqualTo(String value) {
            addCriterion("proc_class_id =", value, "procClassId");
            return (Criteria) this;
        }

        public Criteria andProcClassIdNotEqualTo(String value) {
            addCriterion("proc_class_id <>", value, "procClassId");
            return (Criteria) this;
        }

        public Criteria andProcClassIdGreaterThan(String value) {
            addCriterion("proc_class_id >", value, "procClassId");
            return (Criteria) this;
        }

        public Criteria andProcClassIdGreaterThanOrEqualTo(String value) {
            addCriterion("proc_class_id >=", value, "procClassId");
            return (Criteria) this;
        }

        public Criteria andProcClassIdLessThan(String value) {
            addCriterion("proc_class_id <", value, "procClassId");
            return (Criteria) this;
        }

        public Criteria andProcClassIdLessThanOrEqualTo(String value) {
            addCriterion("proc_class_id <=", value, "procClassId");
            return (Criteria) this;
        }

        public Criteria andProcClassIdLike(String value) {
            addCriterion("proc_class_id like", value, "procClassId");
            return (Criteria) this;
        }

        public Criteria andProcClassIdNotLike(String value) {
            addCriterion("proc_class_id not like", value, "procClassId");
            return (Criteria) this;
        }

        public Criteria andProcClassIdIn(List<String> values) {
            addCriterion("proc_class_id in", values, "procClassId");
            return (Criteria) this;
        }

        public Criteria andProcClassIdNotIn(List<String> values) {
            addCriterion("proc_class_id not in", values, "procClassId");
            return (Criteria) this;
        }

        public Criteria andProcClassIdBetween(String value1, String value2) {
            addCriterion("proc_class_id between", value1, value2, "procClassId");
            return (Criteria) this;
        }

        public Criteria andProcClassIdNotBetween(String value1, String value2) {
            addCriterion("proc_class_id not between", value1, value2, "procClassId");
            return (Criteria) this;
        }

        public Criteria andProcChannelIsNull() {
            addCriterion("proc_channel is null");
            return (Criteria) this;
        }

        public Criteria andProcChannelIsNotNull() {
            addCriterion("proc_channel is not null");
            return (Criteria) this;
        }

        public Criteria andProcChannelEqualTo(Integer value) {
            addCriterion("proc_channel =", value, "procChannel");
            return (Criteria) this;
        }

        public Criteria andProcChannelNotEqualTo(Integer value) {
            addCriterion("proc_channel <>", value, "procChannel");
            return (Criteria) this;
        }

        public Criteria andProcChannelGreaterThan(Integer value) {
            addCriterion("proc_channel >", value, "procChannel");
            return (Criteria) this;
        }

        public Criteria andProcChannelGreaterThanOrEqualTo(Integer value) {
            addCriterion("proc_channel >=", value, "procChannel");
            return (Criteria) this;
        }

        public Criteria andProcChannelLessThan(Integer value) {
            addCriterion("proc_channel <", value, "procChannel");
            return (Criteria) this;
        }

        public Criteria andProcChannelLessThanOrEqualTo(Integer value) {
            addCriterion("proc_channel <=", value, "procChannel");
            return (Criteria) this;
        }

        public Criteria andProcChannelIn(List<Integer> values) {
            addCriterion("proc_channel in", values, "procChannel");
            return (Criteria) this;
        }

        public Criteria andProcChannelNotIn(List<Integer> values) {
            addCriterion("proc_channel not in", values, "procChannel");
            return (Criteria) this;
        }

        public Criteria andProcChannelBetween(Integer value1, Integer value2) {
            addCriterion("proc_channel between", value1, value2, "procChannel");
            return (Criteria) this;
        }

        public Criteria andProcChannelNotBetween(Integer value1, Integer value2) {
            addCriterion("proc_channel not between", value1, value2, "procChannel");
            return (Criteria) this;
        }

        public Criteria andProcDxidIsNull() {
            addCriterion("proc_dxid is null");
            return (Criteria) this;
        }

        public Criteria andProcDxidIsNotNull() {
            addCriterion("proc_dxid is not null");
            return (Criteria) this;
        }

        public Criteria andProcDxidEqualTo(String value) {
            addCriterion("proc_dxid =", value, "procDxid");
            return (Criteria) this;
        }

        public Criteria andProcDxidNotEqualTo(String value) {
            addCriterion("proc_dxid <>", value, "procDxid");
            return (Criteria) this;
        }

        public Criteria andProcDxidGreaterThan(String value) {
            addCriterion("proc_dxid >", value, "procDxid");
            return (Criteria) this;
        }

        public Criteria andProcDxidGreaterThanOrEqualTo(String value) {
            addCriterion("proc_dxid >=", value, "procDxid");
            return (Criteria) this;
        }

        public Criteria andProcDxidLessThan(String value) {
            addCriterion("proc_dxid <", value, "procDxid");
            return (Criteria) this;
        }

        public Criteria andProcDxidLessThanOrEqualTo(String value) {
            addCriterion("proc_dxid <=", value, "procDxid");
            return (Criteria) this;
        }

        public Criteria andProcDxidLike(String value) {
            addCriterion("proc_dxid like", value, "procDxid");
            return (Criteria) this;
        }

        public Criteria andProcDxidNotLike(String value) {
            addCriterion("proc_dxid not like", value, "procDxid");
            return (Criteria) this;
        }

        public Criteria andProcDxidIn(List<String> values) {
            addCriterion("proc_dxid in", values, "procDxid");
            return (Criteria) this;
        }

        public Criteria andProcDxidNotIn(List<String> values) {
            addCriterion("proc_dxid not in", values, "procDxid");
            return (Criteria) this;
        }

        public Criteria andProcDxidBetween(String value1, String value2) {
            addCriterion("proc_dxid between", value1, value2, "procDxid");
            return (Criteria) this;
        }

        public Criteria andProcDxidNotBetween(String value1, String value2) {
            addCriterion("proc_dxid not between", value1, value2, "procDxid");
            return (Criteria) this;
        }

        public Criteria andProcFileLinkIsNull() {
            addCriterion("proc_file_link is null");
            return (Criteria) this;
        }

        public Criteria andProcFileLinkIsNotNull() {
            addCriterion("proc_file_link is not null");
            return (Criteria) this;
        }

        public Criteria andProcFileLinkEqualTo(String value) {
            addCriterion("proc_file_link =", value, "procFileLink");
            return (Criteria) this;
        }

        public Criteria andProcFileLinkNotEqualTo(String value) {
            addCriterion("proc_file_link <>", value, "procFileLink");
            return (Criteria) this;
        }

        public Criteria andProcFileLinkGreaterThan(String value) {
            addCriterion("proc_file_link >", value, "procFileLink");
            return (Criteria) this;
        }

        public Criteria andProcFileLinkGreaterThanOrEqualTo(String value) {
            addCriterion("proc_file_link >=", value, "procFileLink");
            return (Criteria) this;
        }

        public Criteria andProcFileLinkLessThan(String value) {
            addCriterion("proc_file_link <", value, "procFileLink");
            return (Criteria) this;
        }

        public Criteria andProcFileLinkLessThanOrEqualTo(String value) {
            addCriterion("proc_file_link <=", value, "procFileLink");
            return (Criteria) this;
        }

        public Criteria andProcFileLinkLike(String value) {
            addCriterion("proc_file_link like", value, "procFileLink");
            return (Criteria) this;
        }

        public Criteria andProcFileLinkNotLike(String value) {
            addCriterion("proc_file_link not like", value, "procFileLink");
            return (Criteria) this;
        }

        public Criteria andProcFileLinkIn(List<String> values) {
            addCriterion("proc_file_link in", values, "procFileLink");
            return (Criteria) this;
        }

        public Criteria andProcFileLinkNotIn(List<String> values) {
            addCriterion("proc_file_link not in", values, "procFileLink");
            return (Criteria) this;
        }

        public Criteria andProcFileLinkBetween(String value1, String value2) {
            addCriterion("proc_file_link between", value1, value2, "procFileLink");
            return (Criteria) this;
        }

        public Criteria andProcFileLinkNotBetween(String value1, String value2) {
            addCriterion("proc_file_link not between", value1, value2, "procFileLink");
            return (Criteria) this;
        }

        public Criteria andProcQuoteIsNull() {
            addCriterion("proc_quote is null");
            return (Criteria) this;
        }

        public Criteria andProcQuoteIsNotNull() {
            addCriterion("proc_quote is not null");
            return (Criteria) this;
        }

        public Criteria andProcQuoteEqualTo(Integer value) {
            addCriterion("proc_quote =", value, "procQuote");
            return (Criteria) this;
        }

        public Criteria andProcQuoteNotEqualTo(Integer value) {
            addCriterion("proc_quote <>", value, "procQuote");
            return (Criteria) this;
        }

        public Criteria andProcQuoteGreaterThan(Integer value) {
            addCriterion("proc_quote >", value, "procQuote");
            return (Criteria) this;
        }

        public Criteria andProcQuoteGreaterThanOrEqualTo(Integer value) {
            addCriterion("proc_quote >=", value, "procQuote");
            return (Criteria) this;
        }

        public Criteria andProcQuoteLessThan(Integer value) {
            addCriterion("proc_quote <", value, "procQuote");
            return (Criteria) this;
        }

        public Criteria andProcQuoteLessThanOrEqualTo(Integer value) {
            addCriterion("proc_quote <=", value, "procQuote");
            return (Criteria) this;
        }

        public Criteria andProcQuoteIn(List<Integer> values) {
            addCriterion("proc_quote in", values, "procQuote");
            return (Criteria) this;
        }

        public Criteria andProcQuoteNotIn(List<Integer> values) {
            addCriterion("proc_quote not in", values, "procQuote");
            return (Criteria) this;
        }

        public Criteria andProcQuoteBetween(Integer value1, Integer value2) {
            addCriterion("proc_quote between", value1, value2, "procQuote");
            return (Criteria) this;
        }

        public Criteria andProcQuoteNotBetween(Integer value1, Integer value2) {
            addCriterion("proc_quote not between", value1, value2, "procQuote");
            return (Criteria) this;
        }

        public Criteria andDetaiurlIsNull() {
            addCriterion("detaiurl is null");
            return (Criteria) this;
        }

        public Criteria andDetaiurlIsNotNull() {
            addCriterion("detaiurl is not null");
            return (Criteria) this;
        }

        public Criteria andDetaiurlEqualTo(String value) {
            addCriterion("detaiurl =", value, "detaiurl");
            return (Criteria) this;
        }

        public Criteria andDetaiurlNotEqualTo(String value) {
            addCriterion("detaiurl <>", value, "detaiurl");
            return (Criteria) this;
        }

        public Criteria andDetaiurlGreaterThan(String value) {
            addCriterion("detaiurl >", value, "detaiurl");
            return (Criteria) this;
        }

        public Criteria andDetaiurlGreaterThanOrEqualTo(String value) {
            addCriterion("detaiurl >=", value, "detaiurl");
            return (Criteria) this;
        }

        public Criteria andDetaiurlLessThan(String value) {
            addCriterion("detaiurl <", value, "detaiurl");
            return (Criteria) this;
        }

        public Criteria andDetaiurlLessThanOrEqualTo(String value) {
            addCriterion("detaiurl <=", value, "detaiurl");
            return (Criteria) this;
        }

        public Criteria andDetaiurlLike(String value) {
            addCriterion("detaiurl like", value, "detaiurl");
            return (Criteria) this;
        }

        public Criteria andDetaiurlNotLike(String value) {
            addCriterion("detaiurl not like", value, "detaiurl");
            return (Criteria) this;
        }

        public Criteria andDetaiurlIn(List<String> values) {
            addCriterion("detaiurl in", values, "detaiurl");
            return (Criteria) this;
        }

        public Criteria andDetaiurlNotIn(List<String> values) {
            addCriterion("detaiurl not in", values, "detaiurl");
            return (Criteria) this;
        }

        public Criteria andDetaiurlBetween(String value1, String value2) {
            addCriterion("detaiurl between", value1, value2, "detaiurl");
            return (Criteria) this;
        }

        public Criteria andDetaiurlNotBetween(String value1, String value2) {
            addCriterion("detaiurl not between", value1, value2, "detaiurl");
            return (Criteria) this;
        }

        public Criteria andYycountIsNull() {
            addCriterion("yycount is null");
            return (Criteria) this;
        }

        public Criteria andYycountIsNotNull() {
            addCriterion("yycount is not null");
            return (Criteria) this;
        }

        public Criteria andYycountEqualTo(Integer value) {
            addCriterion("yycount =", value, "yycount");
            return (Criteria) this;
        }

        public Criteria andYycountNotEqualTo(Integer value) {
            addCriterion("yycount <>", value, "yycount");
            return (Criteria) this;
        }

        public Criteria andYycountGreaterThan(Integer value) {
            addCriterion("yycount >", value, "yycount");
            return (Criteria) this;
        }

        public Criteria andYycountGreaterThanOrEqualTo(Integer value) {
            addCriterion("yycount >=", value, "yycount");
            return (Criteria) this;
        }

        public Criteria andYycountLessThan(Integer value) {
            addCriterion("yycount <", value, "yycount");
            return (Criteria) this;
        }

        public Criteria andYycountLessThanOrEqualTo(Integer value) {
            addCriterion("yycount <=", value, "yycount");
            return (Criteria) this;
        }

        public Criteria andYycountIn(List<Integer> values) {
            addCriterion("yycount in", values, "yycount");
            return (Criteria) this;
        }

        public Criteria andYycountNotIn(List<Integer> values) {
            addCriterion("yycount not in", values, "yycount");
            return (Criteria) this;
        }

        public Criteria andYycountBetween(Integer value1, Integer value2) {
            addCriterion("yycount between", value1, value2, "yycount");
            return (Criteria) this;
        }

        public Criteria andYycountNotBetween(Integer value1, Integer value2) {
            addCriterion("yycount not between", value1, value2, "yycount");
            return (Criteria) this;
        }

        public Criteria andImpactFactorChIsNull() {
            addCriterion("impact_factor_ch is null");
            return (Criteria) this;
        }

        public Criteria andImpactFactorChIsNotNull() {
            addCriterion("impact_factor_ch is not null");
            return (Criteria) this;
        }

        public Criteria andImpactFactorChEqualTo(String value) {
            addCriterion("impact_factor_ch =", value, "impactFactorCh");
            return (Criteria) this;
        }

        public Criteria andImpactFactorChNotEqualTo(String value) {
            addCriterion("impact_factor_ch <>", value, "impactFactorCh");
            return (Criteria) this;
        }

        public Criteria andImpactFactorChGreaterThan(String value) {
            addCriterion("impact_factor_ch >", value, "impactFactorCh");
            return (Criteria) this;
        }

        public Criteria andImpactFactorChGreaterThanOrEqualTo(String value) {
            addCriterion("impact_factor_ch >=", value, "impactFactorCh");
            return (Criteria) this;
        }

        public Criteria andImpactFactorChLessThan(String value) {
            addCriterion("impact_factor_ch <", value, "impactFactorCh");
            return (Criteria) this;
        }

        public Criteria andImpactFactorChLessThanOrEqualTo(String value) {
            addCriterion("impact_factor_ch <=", value, "impactFactorCh");
            return (Criteria) this;
        }

        public Criteria andImpactFactorChLike(String value) {
            addCriterion("impact_factor_ch like", value, "impactFactorCh");
            return (Criteria) this;
        }

        public Criteria andImpactFactorChNotLike(String value) {
            addCriterion("impact_factor_ch not like", value, "impactFactorCh");
            return (Criteria) this;
        }

        public Criteria andImpactFactorChIn(List<String> values) {
            addCriterion("impact_factor_ch in", values, "impactFactorCh");
            return (Criteria) this;
        }

        public Criteria andImpactFactorChNotIn(List<String> values) {
            addCriterion("impact_factor_ch not in", values, "impactFactorCh");
            return (Criteria) this;
        }

        public Criteria andImpactFactorChBetween(String value1, String value2) {
            addCriterion("impact_factor_ch between", value1, value2, "impactFactorCh");
            return (Criteria) this;
        }

        public Criteria andImpactFactorChNotBetween(String value1, String value2) {
            addCriterion("impact_factor_ch not between", value1, value2, "impactFactorCh");
            return (Criteria) this;
        }

        public Criteria andImpactFactorEnIsNull() {
            addCriterion("impact_factor_en is null");
            return (Criteria) this;
        }

        public Criteria andImpactFactorEnIsNotNull() {
            addCriterion("impact_factor_en is not null");
            return (Criteria) this;
        }

        public Criteria andImpactFactorEnEqualTo(String value) {
            addCriterion("impact_factor_en =", value, "impactFactorEn");
            return (Criteria) this;
        }

        public Criteria andImpactFactorEnNotEqualTo(String value) {
            addCriterion("impact_factor_en <>", value, "impactFactorEn");
            return (Criteria) this;
        }

        public Criteria andImpactFactorEnGreaterThan(String value) {
            addCriterion("impact_factor_en >", value, "impactFactorEn");
            return (Criteria) this;
        }

        public Criteria andImpactFactorEnGreaterThanOrEqualTo(String value) {
            addCriterion("impact_factor_en >=", value, "impactFactorEn");
            return (Criteria) this;
        }

        public Criteria andImpactFactorEnLessThan(String value) {
            addCriterion("impact_factor_en <", value, "impactFactorEn");
            return (Criteria) this;
        }

        public Criteria andImpactFactorEnLessThanOrEqualTo(String value) {
            addCriterion("impact_factor_en <=", value, "impactFactorEn");
            return (Criteria) this;
        }

        public Criteria andImpactFactorEnLike(String value) {
            addCriterion("impact_factor_en like", value, "impactFactorEn");
            return (Criteria) this;
        }

        public Criteria andImpactFactorEnNotLike(String value) {
            addCriterion("impact_factor_en not like", value, "impactFactorEn");
            return (Criteria) this;
        }

        public Criteria andImpactFactorEnIn(List<String> values) {
            addCriterion("impact_factor_en in", values, "impactFactorEn");
            return (Criteria) this;
        }

        public Criteria andImpactFactorEnNotIn(List<String> values) {
            addCriterion("impact_factor_en not in", values, "impactFactorEn");
            return (Criteria) this;
        }

        public Criteria andImpactFactorEnBetween(String value1, String value2) {
            addCriterion("impact_factor_en between", value1, value2, "impactFactorEn");
            return (Criteria) this;
        }

        public Criteria andImpactFactorEnNotBetween(String value1, String value2) {
            addCriterion("impact_factor_en not between", value1, value2, "impactFactorEn");
            return (Criteria) this;
        }

        public Criteria andAvenueIsNull() {
            addCriterion("avenue is null");
            return (Criteria) this;
        }

        public Criteria andAvenueIsNotNull() {
            addCriterion("avenue is not null");
            return (Criteria) this;
        }

        public Criteria andAvenueEqualTo(String value) {
            addCriterion("avenue =", value, "avenue");
            return (Criteria) this;
        }

        public Criteria andAvenueNotEqualTo(String value) {
            addCriterion("avenue <>", value, "avenue");
            return (Criteria) this;
        }

        public Criteria andAvenueGreaterThan(String value) {
            addCriterion("avenue >", value, "avenue");
            return (Criteria) this;
        }

        public Criteria andAvenueGreaterThanOrEqualTo(String value) {
            addCriterion("avenue >=", value, "avenue");
            return (Criteria) this;
        }

        public Criteria andAvenueLessThan(String value) {
            addCriterion("avenue <", value, "avenue");
            return (Criteria) this;
        }

        public Criteria andAvenueLessThanOrEqualTo(String value) {
            addCriterion("avenue <=", value, "avenue");
            return (Criteria) this;
        }

        public Criteria andAvenueLike(String value) {
            addCriterion("avenue like", value, "avenue");
            return (Criteria) this;
        }

        public Criteria andAvenueNotLike(String value) {
            addCriterion("avenue not like", value, "avenue");
            return (Criteria) this;
        }

        public Criteria andAvenueIn(List<String> values) {
            addCriterion("avenue in", values, "avenue");
            return (Criteria) this;
        }

        public Criteria andAvenueNotIn(List<String> values) {
            addCriterion("avenue not in", values, "avenue");
            return (Criteria) this;
        }

        public Criteria andAvenueBetween(String value1, String value2) {
            addCriterion("avenue between", value1, value2, "avenue");
            return (Criteria) this;
        }

        public Criteria andAvenueNotBetween(String value1, String value2) {
            addCriterion("avenue not between", value1, value2, "avenue");
            return (Criteria) this;
        }

        public Criteria andCnkiYycountIsNull() {
            addCriterion("cnki_yycount is null");
            return (Criteria) this;
        }

        public Criteria andCnkiYycountIsNotNull() {
            addCriterion("cnki_yycount is not null");
            return (Criteria) this;
        }

        public Criteria andCnkiYycountEqualTo(String value) {
            addCriterion("cnki_yycount =", value, "cnkiYycount");
            return (Criteria) this;
        }

        public Criteria andCnkiYycountNotEqualTo(String value) {
            addCriterion("cnki_yycount <>", value, "cnkiYycount");
            return (Criteria) this;
        }

        public Criteria andCnkiYycountGreaterThan(String value) {
            addCriterion("cnki_yycount >", value, "cnkiYycount");
            return (Criteria) this;
        }

        public Criteria andCnkiYycountGreaterThanOrEqualTo(String value) {
            addCriterion("cnki_yycount >=", value, "cnkiYycount");
            return (Criteria) this;
        }

        public Criteria andCnkiYycountLessThan(String value) {
            addCriterion("cnki_yycount <", value, "cnkiYycount");
            return (Criteria) this;
        }

        public Criteria andCnkiYycountLessThanOrEqualTo(String value) {
            addCriterion("cnki_yycount <=", value, "cnkiYycount");
            return (Criteria) this;
        }

        public Criteria andCnkiYycountLike(String value) {
            addCriterion("cnki_yycount like", value, "cnkiYycount");
            return (Criteria) this;
        }

        public Criteria andCnkiYycountNotLike(String value) {
            addCriterion("cnki_yycount not like", value, "cnkiYycount");
            return (Criteria) this;
        }

        public Criteria andCnkiYycountIn(List<String> values) {
            addCriterion("cnki_yycount in", values, "cnkiYycount");
            return (Criteria) this;
        }

        public Criteria andCnkiYycountNotIn(List<String> values) {
            addCriterion("cnki_yycount not in", values, "cnkiYycount");
            return (Criteria) this;
        }

        public Criteria andCnkiYycountBetween(String value1, String value2) {
            addCriterion("cnki_yycount between", value1, value2, "cnkiYycount");
            return (Criteria) this;
        }

        public Criteria andCnkiYycountNotBetween(String value1, String value2) {
            addCriterion("cnki_yycount not between", value1, value2, "cnkiYycount");
            return (Criteria) this;
        }

        public Criteria andWfYycountIsNull() {
            addCriterion("wf_yycount is null");
            return (Criteria) this;
        }

        public Criteria andWfYycountIsNotNull() {
            addCriterion("wf_yycount is not null");
            return (Criteria) this;
        }

        public Criteria andWfYycountEqualTo(String value) {
            addCriterion("wf_yycount =", value, "wfYycount");
            return (Criteria) this;
        }

        public Criteria andWfYycountNotEqualTo(String value) {
            addCriterion("wf_yycount <>", value, "wfYycount");
            return (Criteria) this;
        }

        public Criteria andWfYycountGreaterThan(String value) {
            addCriterion("wf_yycount >", value, "wfYycount");
            return (Criteria) this;
        }

        public Criteria andWfYycountGreaterThanOrEqualTo(String value) {
            addCriterion("wf_yycount >=", value, "wfYycount");
            return (Criteria) this;
        }

        public Criteria andWfYycountLessThan(String value) {
            addCriterion("wf_yycount <", value, "wfYycount");
            return (Criteria) this;
        }

        public Criteria andWfYycountLessThanOrEqualTo(String value) {
            addCriterion("wf_yycount <=", value, "wfYycount");
            return (Criteria) this;
        }

        public Criteria andWfYycountLike(String value) {
            addCriterion("wf_yycount like", value, "wfYycount");
            return (Criteria) this;
        }

        public Criteria andWfYycountNotLike(String value) {
            addCriterion("wf_yycount not like", value, "wfYycount");
            return (Criteria) this;
        }

        public Criteria andWfYycountIn(List<String> values) {
            addCriterion("wf_yycount in", values, "wfYycount");
            return (Criteria) this;
        }

        public Criteria andWfYycountNotIn(List<String> values) {
            addCriterion("wf_yycount not in", values, "wfYycount");
            return (Criteria) this;
        }

        public Criteria andWfYycountBetween(String value1, String value2) {
            addCriterion("wf_yycount between", value1, value2, "wfYycount");
            return (Criteria) this;
        }

        public Criteria andWfYycountNotBetween(String value1, String value2) {
            addCriterion("wf_yycount not between", value1, value2, "wfYycount");
            return (Criteria) this;
        }

        public Criteria andCqvipYycountIsNull() {
            addCriterion("cqvip_yycount is null");
            return (Criteria) this;
        }

        public Criteria andCqvipYycountIsNotNull() {
            addCriterion("cqvip_yycount is not null");
            return (Criteria) this;
        }

        public Criteria andCqvipYycountEqualTo(String value) {
            addCriterion("cqvip_yycount =", value, "cqvipYycount");
            return (Criteria) this;
        }

        public Criteria andCqvipYycountNotEqualTo(String value) {
            addCriterion("cqvip_yycount <>", value, "cqvipYycount");
            return (Criteria) this;
        }

        public Criteria andCqvipYycountGreaterThan(String value) {
            addCriterion("cqvip_yycount >", value, "cqvipYycount");
            return (Criteria) this;
        }

        public Criteria andCqvipYycountGreaterThanOrEqualTo(String value) {
            addCriterion("cqvip_yycount >=", value, "cqvipYycount");
            return (Criteria) this;
        }

        public Criteria andCqvipYycountLessThan(String value) {
            addCriterion("cqvip_yycount <", value, "cqvipYycount");
            return (Criteria) this;
        }

        public Criteria andCqvipYycountLessThanOrEqualTo(String value) {
            addCriterion("cqvip_yycount <=", value, "cqvipYycount");
            return (Criteria) this;
        }

        public Criteria andCqvipYycountLike(String value) {
            addCriterion("cqvip_yycount like", value, "cqvipYycount");
            return (Criteria) this;
        }

        public Criteria andCqvipYycountNotLike(String value) {
            addCriterion("cqvip_yycount not like", value, "cqvipYycount");
            return (Criteria) this;
        }

        public Criteria andCqvipYycountIn(List<String> values) {
            addCriterion("cqvip_yycount in", values, "cqvipYycount");
            return (Criteria) this;
        }

        public Criteria andCqvipYycountNotIn(List<String> values) {
            addCriterion("cqvip_yycount not in", values, "cqvipYycount");
            return (Criteria) this;
        }

        public Criteria andCqvipYycountBetween(String value1, String value2) {
            addCriterion("cqvip_yycount between", value1, value2, "cqvipYycount");
            return (Criteria) this;
        }

        public Criteria andCqvipYycountNotBetween(String value1, String value2) {
            addCriterion("cqvip_yycount not between", value1, value2, "cqvipYycount");
            return (Criteria) this;
        }

        public Criteria andWarePageViewIsNull() {
            addCriterion("ware_page_view is null");
            return (Criteria) this;
        }

        public Criteria andWarePageViewIsNotNull() {
            addCriterion("ware_page_view is not null");
            return (Criteria) this;
        }

        public Criteria andWarePageViewEqualTo(String value) {
            addCriterion("ware_page_view =", value, "warePageView");
            return (Criteria) this;
        }

        public Criteria andWarePageViewNotEqualTo(String value) {
            addCriterion("ware_page_view <>", value, "warePageView");
            return (Criteria) this;
        }

        public Criteria andWarePageViewGreaterThan(String value) {
            addCriterion("ware_page_view >", value, "warePageView");
            return (Criteria) this;
        }

        public Criteria andWarePageViewGreaterThanOrEqualTo(String value) {
            addCriterion("ware_page_view >=", value, "warePageView");
            return (Criteria) this;
        }

        public Criteria andWarePageViewLessThan(String value) {
            addCriterion("ware_page_view <", value, "warePageView");
            return (Criteria) this;
        }

        public Criteria andWarePageViewLessThanOrEqualTo(String value) {
            addCriterion("ware_page_view <=", value, "warePageView");
            return (Criteria) this;
        }

        public Criteria andWarePageViewLike(String value) {
            addCriterion("ware_page_view like", value, "warePageView");
            return (Criteria) this;
        }

        public Criteria andWarePageViewNotLike(String value) {
            addCriterion("ware_page_view not like", value, "warePageView");
            return (Criteria) this;
        }

        public Criteria andWarePageViewIn(List<String> values) {
            addCriterion("ware_page_view in", values, "warePageView");
            return (Criteria) this;
        }

        public Criteria andWarePageViewNotIn(List<String> values) {
            addCriterion("ware_page_view not in", values, "warePageView");
            return (Criteria) this;
        }

        public Criteria andWarePageViewBetween(String value1, String value2) {
            addCriterion("ware_page_view between", value1, value2, "warePageView");
            return (Criteria) this;
        }

        public Criteria andWarePageViewNotBetween(String value1, String value2) {
            addCriterion("ware_page_view not between", value1, value2, "warePageView");
            return (Criteria) this;
        }

        public Criteria andDownloadCountIsNull() {
            addCriterion("download_count is null");
            return (Criteria) this;
        }

        public Criteria andDownloadCountIsNotNull() {
            addCriterion("download_count is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadCountEqualTo(String value) {
            addCriterion("download_count =", value, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountNotEqualTo(String value) {
            addCriterion("download_count <>", value, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountGreaterThan(String value) {
            addCriterion("download_count >", value, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountGreaterThanOrEqualTo(String value) {
            addCriterion("download_count >=", value, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountLessThan(String value) {
            addCriterion("download_count <", value, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountLessThanOrEqualTo(String value) {
            addCriterion("download_count <=", value, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountLike(String value) {
            addCriterion("download_count like", value, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountNotLike(String value) {
            addCriterion("download_count not like", value, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountIn(List<String> values) {
            addCriterion("download_count in", values, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountNotIn(List<String> values) {
            addCriterion("download_count not in", values, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountBetween(String value1, String value2) {
            addCriterion("download_count between", value1, value2, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountNotBetween(String value1, String value2) {
            addCriterion("download_count not between", value1, value2, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andViewElementsIsNull() {
            addCriterion("view_elements is null");
            return (Criteria) this;
        }

        public Criteria andViewElementsIsNotNull() {
            addCriterion("view_elements is not null");
            return (Criteria) this;
        }

        public Criteria andViewElementsEqualTo(String value) {
            addCriterion("view_elements =", value, "viewElements");
            return (Criteria) this;
        }

        public Criteria andViewElementsNotEqualTo(String value) {
            addCriterion("view_elements <>", value, "viewElements");
            return (Criteria) this;
        }

        public Criteria andViewElementsGreaterThan(String value) {
            addCriterion("view_elements >", value, "viewElements");
            return (Criteria) this;
        }

        public Criteria andViewElementsGreaterThanOrEqualTo(String value) {
            addCriterion("view_elements >=", value, "viewElements");
            return (Criteria) this;
        }

        public Criteria andViewElementsLessThan(String value) {
            addCriterion("view_elements <", value, "viewElements");
            return (Criteria) this;
        }

        public Criteria andViewElementsLessThanOrEqualTo(String value) {
            addCriterion("view_elements <=", value, "viewElements");
            return (Criteria) this;
        }

        public Criteria andViewElementsLike(String value) {
            addCriterion("view_elements like", value, "viewElements");
            return (Criteria) this;
        }

        public Criteria andViewElementsNotLike(String value) {
            addCriterion("view_elements not like", value, "viewElements");
            return (Criteria) this;
        }

        public Criteria andViewElementsIn(List<String> values) {
            addCriterion("view_elements in", values, "viewElements");
            return (Criteria) this;
        }

        public Criteria andViewElementsNotIn(List<String> values) {
            addCriterion("view_elements not in", values, "viewElements");
            return (Criteria) this;
        }

        public Criteria andViewElementsBetween(String value1, String value2) {
            addCriterion("view_elements between", value1, value2, "viewElements");
            return (Criteria) this;
        }

        public Criteria andViewElementsNotBetween(String value1, String value2) {
            addCriterion("view_elements not between", value1, value2, "viewElements");
            return (Criteria) this;
        }

        public Criteria andViewElementsJsonIsNull() {
            addCriterion("view_elements_json is null");
            return (Criteria) this;
        }

        public Criteria andViewElementsJsonIsNotNull() {
            addCriterion("view_elements_json is not null");
            return (Criteria) this;
        }

        public Criteria andViewElementsJsonEqualTo(String value) {
            addCriterion("view_elements_json =", value, "viewElementsJson");
            return (Criteria) this;
        }

        public Criteria andViewElementsJsonNotEqualTo(String value) {
            addCriterion("view_elements_json <>", value, "viewElementsJson");
            return (Criteria) this;
        }

        public Criteria andViewElementsJsonGreaterThan(String value) {
            addCriterion("view_elements_json >", value, "viewElementsJson");
            return (Criteria) this;
        }

        public Criteria andViewElementsJsonGreaterThanOrEqualTo(String value) {
            addCriterion("view_elements_json >=", value, "viewElementsJson");
            return (Criteria) this;
        }

        public Criteria andViewElementsJsonLessThan(String value) {
            addCriterion("view_elements_json <", value, "viewElementsJson");
            return (Criteria) this;
        }

        public Criteria andViewElementsJsonLessThanOrEqualTo(String value) {
            addCriterion("view_elements_json <=", value, "viewElementsJson");
            return (Criteria) this;
        }

        public Criteria andViewElementsJsonLike(String value) {
            addCriterion("view_elements_json like", value, "viewElementsJson");
            return (Criteria) this;
        }

        public Criteria andViewElementsJsonNotLike(String value) {
            addCriterion("view_elements_json not like", value, "viewElementsJson");
            return (Criteria) this;
        }

        public Criteria andViewElementsJsonIn(List<String> values) {
            addCriterion("view_elements_json in", values, "viewElementsJson");
            return (Criteria) this;
        }

        public Criteria andViewElementsJsonNotIn(List<String> values) {
            addCriterion("view_elements_json not in", values, "viewElementsJson");
            return (Criteria) this;
        }

        public Criteria andViewElementsJsonBetween(String value1, String value2) {
            addCriterion("view_elements_json between", value1, value2, "viewElementsJson");
            return (Criteria) this;
        }

        public Criteria andViewElementsJsonNotBetween(String value1, String value2) {
            addCriterion("view_elements_json not between", value1, value2, "viewElementsJson");
            return (Criteria) this;
        }

        public Criteria andFoundationIsNull() {
            addCriterion("foundation is null");
            return (Criteria) this;
        }

        public Criteria andFoundationIsNotNull() {
            addCriterion("foundation is not null");
            return (Criteria) this;
        }

        public Criteria andFoundationEqualTo(String value) {
            addCriterion("foundation =", value, "foundation");
            return (Criteria) this;
        }

        public Criteria andFoundationNotEqualTo(String value) {
            addCriterion("foundation <>", value, "foundation");
            return (Criteria) this;
        }

        public Criteria andFoundationGreaterThan(String value) {
            addCriterion("foundation >", value, "foundation");
            return (Criteria) this;
        }

        public Criteria andFoundationGreaterThanOrEqualTo(String value) {
            addCriterion("foundation >=", value, "foundation");
            return (Criteria) this;
        }

        public Criteria andFoundationLessThan(String value) {
            addCriterion("foundation <", value, "foundation");
            return (Criteria) this;
        }

        public Criteria andFoundationLessThanOrEqualTo(String value) {
            addCriterion("foundation <=", value, "foundation");
            return (Criteria) this;
        }

        public Criteria andFoundationLike(String value) {
            addCriterion("foundation like", value, "foundation");
            return (Criteria) this;
        }

        public Criteria andFoundationNotLike(String value) {
            addCriterion("foundation not like", value, "foundation");
            return (Criteria) this;
        }

        public Criteria andFoundationIn(List<String> values) {
            addCriterion("foundation in", values, "foundation");
            return (Criteria) this;
        }

        public Criteria andFoundationNotIn(List<String> values) {
            addCriterion("foundation not in", values, "foundation");
            return (Criteria) this;
        }

        public Criteria andFoundationBetween(String value1, String value2) {
            addCriterion("foundation between", value1, value2, "foundation");
            return (Criteria) this;
        }

        public Criteria andFoundationNotBetween(String value1, String value2) {
            addCriterion("foundation not between", value1, value2, "foundation");
            return (Criteria) this;
        }

        public Criteria andScreenshotIsNull() {
            addCriterion("screenshot is null");
            return (Criteria) this;
        }

        public Criteria andScreenshotIsNotNull() {
            addCriterion("screenshot is not null");
            return (Criteria) this;
        }

        public Criteria andScreenshotEqualTo(String value) {
            addCriterion("screenshot =", value, "screenshot");
            return (Criteria) this;
        }

        public Criteria andScreenshotNotEqualTo(String value) {
            addCriterion("screenshot <>", value, "screenshot");
            return (Criteria) this;
        }

        public Criteria andScreenshotGreaterThan(String value) {
            addCriterion("screenshot >", value, "screenshot");
            return (Criteria) this;
        }

        public Criteria andScreenshotGreaterThanOrEqualTo(String value) {
            addCriterion("screenshot >=", value, "screenshot");
            return (Criteria) this;
        }

        public Criteria andScreenshotLessThan(String value) {
            addCriterion("screenshot <", value, "screenshot");
            return (Criteria) this;
        }

        public Criteria andScreenshotLessThanOrEqualTo(String value) {
            addCriterion("screenshot <=", value, "screenshot");
            return (Criteria) this;
        }

        public Criteria andScreenshotLike(String value) {
            addCriterion("screenshot like", value, "screenshot");
            return (Criteria) this;
        }

        public Criteria andScreenshotNotLike(String value) {
            addCriterion("screenshot not like", value, "screenshot");
            return (Criteria) this;
        }

        public Criteria andScreenshotIn(List<String> values) {
            addCriterion("screenshot in", values, "screenshot");
            return (Criteria) this;
        }

        public Criteria andScreenshotNotIn(List<String> values) {
            addCriterion("screenshot not in", values, "screenshot");
            return (Criteria) this;
        }

        public Criteria andScreenshotBetween(String value1, String value2) {
            addCriterion("screenshot between", value1, value2, "screenshot");
            return (Criteria) this;
        }

        public Criteria andScreenshotNotBetween(String value1, String value2) {
            addCriterion("screenshot not between", value1, value2, "screenshot");
            return (Criteria) this;
        }

        public Criteria andBasicIdCreatorIsNull() {
            addCriterion("basic_id_creator is null");
            return (Criteria) this;
        }

        public Criteria andBasicIdCreatorIsNotNull() {
            addCriterion("basic_id_creator is not null");
            return (Criteria) this;
        }

        public Criteria andBasicIdCreatorEqualTo(String value) {
            addCriterion("basic_id_creator =", value, "basicIdCreator");
            return (Criteria) this;
        }

        public Criteria andBasicIdCreatorNotEqualTo(String value) {
            addCriterion("basic_id_creator <>", value, "basicIdCreator");
            return (Criteria) this;
        }

        public Criteria andBasicIdCreatorGreaterThan(String value) {
            addCriterion("basic_id_creator >", value, "basicIdCreator");
            return (Criteria) this;
        }

        public Criteria andBasicIdCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("basic_id_creator >=", value, "basicIdCreator");
            return (Criteria) this;
        }

        public Criteria andBasicIdCreatorLessThan(String value) {
            addCriterion("basic_id_creator <", value, "basicIdCreator");
            return (Criteria) this;
        }

        public Criteria andBasicIdCreatorLessThanOrEqualTo(String value) {
            addCriterion("basic_id_creator <=", value, "basicIdCreator");
            return (Criteria) this;
        }

        public Criteria andBasicIdCreatorLike(String value) {
            addCriterion("basic_id_creator like", value, "basicIdCreator");
            return (Criteria) this;
        }

        public Criteria andBasicIdCreatorNotLike(String value) {
            addCriterion("basic_id_creator not like", value, "basicIdCreator");
            return (Criteria) this;
        }

        public Criteria andBasicIdCreatorIn(List<String> values) {
            addCriterion("basic_id_creator in", values, "basicIdCreator");
            return (Criteria) this;
        }

        public Criteria andBasicIdCreatorNotIn(List<String> values) {
            addCriterion("basic_id_creator not in", values, "basicIdCreator");
            return (Criteria) this;
        }

        public Criteria andBasicIdCreatorBetween(String value1, String value2) {
            addCriterion("basic_id_creator between", value1, value2, "basicIdCreator");
            return (Criteria) this;
        }

        public Criteria andBasicIdCreatorNotBetween(String value1, String value2) {
            addCriterion("basic_id_creator not between", value1, value2, "basicIdCreator");
            return (Criteria) this;
        }

        public Criteria andBasicIdKeywordIsNull() {
            addCriterion("basic_id_keyword is null");
            return (Criteria) this;
        }

        public Criteria andBasicIdKeywordIsNotNull() {
            addCriterion("basic_id_keyword is not null");
            return (Criteria) this;
        }

        public Criteria andBasicIdKeywordEqualTo(String value) {
            addCriterion("basic_id_keyword =", value, "basicIdKeyword");
            return (Criteria) this;
        }

        public Criteria andBasicIdKeywordNotEqualTo(String value) {
            addCriterion("basic_id_keyword <>", value, "basicIdKeyword");
            return (Criteria) this;
        }

        public Criteria andBasicIdKeywordGreaterThan(String value) {
            addCriterion("basic_id_keyword >", value, "basicIdKeyword");
            return (Criteria) this;
        }

        public Criteria andBasicIdKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("basic_id_keyword >=", value, "basicIdKeyword");
            return (Criteria) this;
        }

        public Criteria andBasicIdKeywordLessThan(String value) {
            addCriterion("basic_id_keyword <", value, "basicIdKeyword");
            return (Criteria) this;
        }

        public Criteria andBasicIdKeywordLessThanOrEqualTo(String value) {
            addCriterion("basic_id_keyword <=", value, "basicIdKeyword");
            return (Criteria) this;
        }

        public Criteria andBasicIdKeywordLike(String value) {
            addCriterion("basic_id_keyword like", value, "basicIdKeyword");
            return (Criteria) this;
        }

        public Criteria andBasicIdKeywordNotLike(String value) {
            addCriterion("basic_id_keyword not like", value, "basicIdKeyword");
            return (Criteria) this;
        }

        public Criteria andBasicIdKeywordIn(List<String> values) {
            addCriterion("basic_id_keyword in", values, "basicIdKeyword");
            return (Criteria) this;
        }

        public Criteria andBasicIdKeywordNotIn(List<String> values) {
            addCriterion("basic_id_keyword not in", values, "basicIdKeyword");
            return (Criteria) this;
        }

        public Criteria andBasicIdKeywordBetween(String value1, String value2) {
            addCriterion("basic_id_keyword between", value1, value2, "basicIdKeyword");
            return (Criteria) this;
        }

        public Criteria andBasicIdKeywordNotBetween(String value1, String value2) {
            addCriterion("basic_id_keyword not between", value1, value2, "basicIdKeyword");
            return (Criteria) this;
        }

        public Criteria andBasicIdContactIsNull() {
            addCriterion("basic_id_contact is null");
            return (Criteria) this;
        }

        public Criteria andBasicIdContactIsNotNull() {
            addCriterion("basic_id_contact is not null");
            return (Criteria) this;
        }

        public Criteria andBasicIdContactEqualTo(String value) {
            addCriterion("basic_id_contact =", value, "basicIdContact");
            return (Criteria) this;
        }

        public Criteria andBasicIdContactNotEqualTo(String value) {
            addCriterion("basic_id_contact <>", value, "basicIdContact");
            return (Criteria) this;
        }

        public Criteria andBasicIdContactGreaterThan(String value) {
            addCriterion("basic_id_contact >", value, "basicIdContact");
            return (Criteria) this;
        }

        public Criteria andBasicIdContactGreaterThanOrEqualTo(String value) {
            addCriterion("basic_id_contact >=", value, "basicIdContact");
            return (Criteria) this;
        }

        public Criteria andBasicIdContactLessThan(String value) {
            addCriterion("basic_id_contact <", value, "basicIdContact");
            return (Criteria) this;
        }

        public Criteria andBasicIdContactLessThanOrEqualTo(String value) {
            addCriterion("basic_id_contact <=", value, "basicIdContact");
            return (Criteria) this;
        }

        public Criteria andBasicIdContactLike(String value) {
            addCriterion("basic_id_contact like", value, "basicIdContact");
            return (Criteria) this;
        }

        public Criteria andBasicIdContactNotLike(String value) {
            addCriterion("basic_id_contact not like", value, "basicIdContact");
            return (Criteria) this;
        }

        public Criteria andBasicIdContactIn(List<String> values) {
            addCriterion("basic_id_contact in", values, "basicIdContact");
            return (Criteria) this;
        }

        public Criteria andBasicIdContactNotIn(List<String> values) {
            addCriterion("basic_id_contact not in", values, "basicIdContact");
            return (Criteria) this;
        }

        public Criteria andBasicIdContactBetween(String value1, String value2) {
            addCriterion("basic_id_contact between", value1, value2, "basicIdContact");
            return (Criteria) this;
        }

        public Criteria andBasicIdContactNotBetween(String value1, String value2) {
            addCriterion("basic_id_contact not between", value1, value2, "basicIdContact");
            return (Criteria) this;
        }

        public Criteria andAvenueTypeIsNull() {
            addCriterion("avenue_type is null");
            return (Criteria) this;
        }

        public Criteria andAvenueTypeIsNotNull() {
            addCriterion("avenue_type is not null");
            return (Criteria) this;
        }

        public Criteria andAvenueTypeEqualTo(Byte value) {
            addCriterion("avenue_type =", value, "avenueType");
            return (Criteria) this;
        }

        public Criteria andAvenueTypeNotEqualTo(Byte value) {
            addCriterion("avenue_type <>", value, "avenueType");
            return (Criteria) this;
        }

        public Criteria andAvenueTypeGreaterThan(Byte value) {
            addCriterion("avenue_type >", value, "avenueType");
            return (Criteria) this;
        }

        public Criteria andAvenueTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("avenue_type >=", value, "avenueType");
            return (Criteria) this;
        }

        public Criteria andAvenueTypeLessThan(Byte value) {
            addCriterion("avenue_type <", value, "avenueType");
            return (Criteria) this;
        }

        public Criteria andAvenueTypeLessThanOrEqualTo(Byte value) {
            addCriterion("avenue_type <=", value, "avenueType");
            return (Criteria) this;
        }

        public Criteria andAvenueTypeIn(List<Byte> values) {
            addCriterion("avenue_type in", values, "avenueType");
            return (Criteria) this;
        }

        public Criteria andAvenueTypeNotIn(List<Byte> values) {
            addCriterion("avenue_type not in", values, "avenueType");
            return (Criteria) this;
        }

        public Criteria andAvenueTypeBetween(Byte value1, Byte value2) {
            addCriterion("avenue_type between", value1, value2, "avenueType");
            return (Criteria) this;
        }

        public Criteria andAvenueTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("avenue_type not between", value1, value2, "avenueType");
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

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
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

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andProcChannelIdIsNull() {
            addCriterion("proc_channel_id is null");
            return (Criteria) this;
        }

        public Criteria andProcChannelIdIsNotNull() {
            addCriterion("proc_channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcChannelIdEqualTo(String value) {
            addCriterion("proc_channel_id =", value, "procChannelId");
            return (Criteria) this;
        }

        public Criteria andProcChannelIdNotEqualTo(String value) {
            addCriterion("proc_channel_id <>", value, "procChannelId");
            return (Criteria) this;
        }

        public Criteria andProcChannelIdGreaterThan(String value) {
            addCriterion("proc_channel_id >", value, "procChannelId");
            return (Criteria) this;
        }

        public Criteria andProcChannelIdGreaterThanOrEqualTo(String value) {
            addCriterion("proc_channel_id >=", value, "procChannelId");
            return (Criteria) this;
        }

        public Criteria andProcChannelIdLessThan(String value) {
            addCriterion("proc_channel_id <", value, "procChannelId");
            return (Criteria) this;
        }

        public Criteria andProcChannelIdLessThanOrEqualTo(String value) {
            addCriterion("proc_channel_id <=", value, "procChannelId");
            return (Criteria) this;
        }

        public Criteria andProcChannelIdLike(String value) {
            addCriterion("proc_channel_id like", value, "procChannelId");
            return (Criteria) this;
        }

        public Criteria andProcChannelIdNotLike(String value) {
            addCriterion("proc_channel_id not like", value, "procChannelId");
            return (Criteria) this;
        }

        public Criteria andProcChannelIdIn(List<String> values) {
            addCriterion("proc_channel_id in", values, "procChannelId");
            return (Criteria) this;
        }

        public Criteria andProcChannelIdNotIn(List<String> values) {
            addCriterion("proc_channel_id not in", values, "procChannelId");
            return (Criteria) this;
        }

        public Criteria andProcChannelIdBetween(String value1, String value2) {
            addCriterion("proc_channel_id between", value1, value2, "procChannelId");
            return (Criteria) this;
        }

        public Criteria andProcChannelIdNotBetween(String value1, String value2) {
            addCriterion("proc_channel_id not between", value1, value2, "procChannelId");
            return (Criteria) this;
        }

        public Criteria andBasicContactIdIsNull() {
            addCriterion("basic_contact_id is null");
            return (Criteria) this;
        }

        public Criteria andBasicContactIdIsNotNull() {
            addCriterion("basic_contact_id is not null");
            return (Criteria) this;
        }

        public Criteria andBasicContactIdEqualTo(String value) {
            addCriterion("basic_contact_id =", value, "basicContactId");
            return (Criteria) this;
        }

        public Criteria andBasicContactIdNotEqualTo(String value) {
            addCriterion("basic_contact_id <>", value, "basicContactId");
            return (Criteria) this;
        }

        public Criteria andBasicContactIdGreaterThan(String value) {
            addCriterion("basic_contact_id >", value, "basicContactId");
            return (Criteria) this;
        }

        public Criteria andBasicContactIdGreaterThanOrEqualTo(String value) {
            addCriterion("basic_contact_id >=", value, "basicContactId");
            return (Criteria) this;
        }

        public Criteria andBasicContactIdLessThan(String value) {
            addCriterion("basic_contact_id <", value, "basicContactId");
            return (Criteria) this;
        }

        public Criteria andBasicContactIdLessThanOrEqualTo(String value) {
            addCriterion("basic_contact_id <=", value, "basicContactId");
            return (Criteria) this;
        }

        public Criteria andBasicContactIdLike(String value) {
            addCriterion("basic_contact_id like", value, "basicContactId");
            return (Criteria) this;
        }

        public Criteria andBasicContactIdNotLike(String value) {
            addCriterion("basic_contact_id not like", value, "basicContactId");
            return (Criteria) this;
        }

        public Criteria andBasicContactIdIn(List<String> values) {
            addCriterion("basic_contact_id in", values, "basicContactId");
            return (Criteria) this;
        }

        public Criteria andBasicContactIdNotIn(List<String> values) {
            addCriterion("basic_contact_id not in", values, "basicContactId");
            return (Criteria) this;
        }

        public Criteria andBasicContactIdBetween(String value1, String value2) {
            addCriterion("basic_contact_id between", value1, value2, "basicContactId");
            return (Criteria) this;
        }

        public Criteria andBasicContactIdNotBetween(String value1, String value2) {
            addCriterion("basic_contact_id not between", value1, value2, "basicContactId");
            return (Criteria) this;
        }

        public Criteria andBasicCreatorIdIsNull() {
            addCriterion("basic_creator_id is null");
            return (Criteria) this;
        }

        public Criteria andBasicCreatorIdIsNotNull() {
            addCriterion("basic_creator_id is not null");
            return (Criteria) this;
        }

        public Criteria andBasicCreatorIdEqualTo(String value) {
            addCriterion("basic_creator_id =", value, "basicCreatorId");
            return (Criteria) this;
        }

        public Criteria andBasicCreatorIdNotEqualTo(String value) {
            addCriterion("basic_creator_id <>", value, "basicCreatorId");
            return (Criteria) this;
        }

        public Criteria andBasicCreatorIdGreaterThan(String value) {
            addCriterion("basic_creator_id >", value, "basicCreatorId");
            return (Criteria) this;
        }

        public Criteria andBasicCreatorIdGreaterThanOrEqualTo(String value) {
            addCriterion("basic_creator_id >=", value, "basicCreatorId");
            return (Criteria) this;
        }

        public Criteria andBasicCreatorIdLessThan(String value) {
            addCriterion("basic_creator_id <", value, "basicCreatorId");
            return (Criteria) this;
        }

        public Criteria andBasicCreatorIdLessThanOrEqualTo(String value) {
            addCriterion("basic_creator_id <=", value, "basicCreatorId");
            return (Criteria) this;
        }

        public Criteria andBasicCreatorIdLike(String value) {
            addCriterion("basic_creator_id like", value, "basicCreatorId");
            return (Criteria) this;
        }

        public Criteria andBasicCreatorIdNotLike(String value) {
            addCriterion("basic_creator_id not like", value, "basicCreatorId");
            return (Criteria) this;
        }

        public Criteria andBasicCreatorIdIn(List<String> values) {
            addCriterion("basic_creator_id in", values, "basicCreatorId");
            return (Criteria) this;
        }

        public Criteria andBasicCreatorIdNotIn(List<String> values) {
            addCriterion("basic_creator_id not in", values, "basicCreatorId");
            return (Criteria) this;
        }

        public Criteria andBasicCreatorIdBetween(String value1, String value2) {
            addCriterion("basic_creator_id between", value1, value2, "basicCreatorId");
            return (Criteria) this;
        }

        public Criteria andBasicCreatorIdNotBetween(String value1, String value2) {
            addCriterion("basic_creator_id not between", value1, value2, "basicCreatorId");
            return (Criteria) this;
        }

        public Criteria andBasicKeywordIdIsNull() {
            addCriterion("basic_keyword_id is null");
            return (Criteria) this;
        }

        public Criteria andBasicKeywordIdIsNotNull() {
            addCriterion("basic_keyword_id is not null");
            return (Criteria) this;
        }

        public Criteria andBasicKeywordIdEqualTo(String value) {
            addCriterion("basic_keyword_id =", value, "basicKeywordId");
            return (Criteria) this;
        }

        public Criteria andBasicKeywordIdNotEqualTo(String value) {
            addCriterion("basic_keyword_id <>", value, "basicKeywordId");
            return (Criteria) this;
        }

        public Criteria andBasicKeywordIdGreaterThan(String value) {
            addCriterion("basic_keyword_id >", value, "basicKeywordId");
            return (Criteria) this;
        }

        public Criteria andBasicKeywordIdGreaterThanOrEqualTo(String value) {
            addCriterion("basic_keyword_id >=", value, "basicKeywordId");
            return (Criteria) this;
        }

        public Criteria andBasicKeywordIdLessThan(String value) {
            addCriterion("basic_keyword_id <", value, "basicKeywordId");
            return (Criteria) this;
        }

        public Criteria andBasicKeywordIdLessThanOrEqualTo(String value) {
            addCriterion("basic_keyword_id <=", value, "basicKeywordId");
            return (Criteria) this;
        }

        public Criteria andBasicKeywordIdLike(String value) {
            addCriterion("basic_keyword_id like", value, "basicKeywordId");
            return (Criteria) this;
        }

        public Criteria andBasicKeywordIdNotLike(String value) {
            addCriterion("basic_keyword_id not like", value, "basicKeywordId");
            return (Criteria) this;
        }

        public Criteria andBasicKeywordIdIn(List<String> values) {
            addCriterion("basic_keyword_id in", values, "basicKeywordId");
            return (Criteria) this;
        }

        public Criteria andBasicKeywordIdNotIn(List<String> values) {
            addCriterion("basic_keyword_id not in", values, "basicKeywordId");
            return (Criteria) this;
        }

        public Criteria andBasicKeywordIdBetween(String value1, String value2) {
            addCriterion("basic_keyword_id between", value1, value2, "basicKeywordId");
            return (Criteria) this;
        }

        public Criteria andBasicKeywordIdNotBetween(String value1, String value2) {
            addCriterion("basic_keyword_id not between", value1, value2, "basicKeywordId");
            return (Criteria) this;
        }

        public Criteria andBasicIdDateIsNull() {
            addCriterion("basic_id_date is null");
            return (Criteria) this;
        }

        public Criteria andBasicIdDateIsNotNull() {
            addCriterion("basic_id_date is not null");
            return (Criteria) this;
        }

        public Criteria andBasicIdDateEqualTo(String value) {
            addCriterion("basic_id_date =", value, "basicIdDate");
            return (Criteria) this;
        }

        public Criteria andBasicIdDateNotEqualTo(String value) {
            addCriterion("basic_id_date <>", value, "basicIdDate");
            return (Criteria) this;
        }

        public Criteria andBasicIdDateGreaterThan(String value) {
            addCriterion("basic_id_date >", value, "basicIdDate");
            return (Criteria) this;
        }

        public Criteria andBasicIdDateGreaterThanOrEqualTo(String value) {
            addCriterion("basic_id_date >=", value, "basicIdDate");
            return (Criteria) this;
        }

        public Criteria andBasicIdDateLessThan(String value) {
            addCriterion("basic_id_date <", value, "basicIdDate");
            return (Criteria) this;
        }

        public Criteria andBasicIdDateLessThanOrEqualTo(String value) {
            addCriterion("basic_id_date <=", value, "basicIdDate");
            return (Criteria) this;
        }

        public Criteria andBasicIdDateLike(String value) {
            addCriterion("basic_id_date like", value, "basicIdDate");
            return (Criteria) this;
        }

        public Criteria andBasicIdDateNotLike(String value) {
            addCriterion("basic_id_date not like", value, "basicIdDate");
            return (Criteria) this;
        }

        public Criteria andBasicIdDateIn(List<String> values) {
            addCriterion("basic_id_date in", values, "basicIdDate");
            return (Criteria) this;
        }

        public Criteria andBasicIdDateNotIn(List<String> values) {
            addCriterion("basic_id_date not in", values, "basicIdDate");
            return (Criteria) this;
        }

        public Criteria andBasicIdDateBetween(String value1, String value2) {
            addCriterion("basic_id_date between", value1, value2, "basicIdDate");
            return (Criteria) this;
        }

        public Criteria andBasicIdDateNotBetween(String value1, String value2) {
            addCriterion("basic_id_date not between", value1, value2, "basicIdDate");
            return (Criteria) this;
        }

        public Criteria andBasicDateSortIsNull() {
            addCriterion("basic_date_sort is null");
            return (Criteria) this;
        }

        public Criteria andBasicDateSortIsNotNull() {
            addCriterion("basic_date_sort is not null");
            return (Criteria) this;
        }

        public Criteria andBasicDateSortEqualTo(Integer value) {
            addCriterion("basic_date_sort =", value, "basicDateSort");
            return (Criteria) this;
        }

        public Criteria andBasicDateSortNotEqualTo(Integer value) {
            addCriterion("basic_date_sort <>", value, "basicDateSort");
            return (Criteria) this;
        }

        public Criteria andBasicDateSortGreaterThan(Integer value) {
            addCriterion("basic_date_sort >", value, "basicDateSort");
            return (Criteria) this;
        }

        public Criteria andBasicDateSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("basic_date_sort >=", value, "basicDateSort");
            return (Criteria) this;
        }

        public Criteria andBasicDateSortLessThan(Integer value) {
            addCriterion("basic_date_sort <", value, "basicDateSort");
            return (Criteria) this;
        }

        public Criteria andBasicDateSortLessThanOrEqualTo(Integer value) {
            addCriterion("basic_date_sort <=", value, "basicDateSort");
            return (Criteria) this;
        }

        public Criteria andBasicDateSortIn(List<Integer> values) {
            addCriterion("basic_date_sort in", values, "basicDateSort");
            return (Criteria) this;
        }

        public Criteria andBasicDateSortNotIn(List<Integer> values) {
            addCriterion("basic_date_sort not in", values, "basicDateSort");
            return (Criteria) this;
        }

        public Criteria andBasicDateSortBetween(Integer value1, Integer value2) {
            addCriterion("basic_date_sort between", value1, value2, "basicDateSort");
            return (Criteria) this;
        }

        public Criteria andBasicDateSortNotBetween(Integer value1, Integer value2) {
            addCriterion("basic_date_sort not between", value1, value2, "basicDateSort");
            return (Criteria) this;
        }

        public Criteria andSsidIsNull() {
            addCriterion("ssid is null");
            return (Criteria) this;
        }

        public Criteria andSsidIsNotNull() {
            addCriterion("ssid is not null");
            return (Criteria) this;
        }

        public Criteria andSsidEqualTo(String value) {
            addCriterion("ssid =", value, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidNotEqualTo(String value) {
            addCriterion("ssid <>", value, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidGreaterThan(String value) {
            addCriterion("ssid >", value, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidGreaterThanOrEqualTo(String value) {
            addCriterion("ssid >=", value, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidLessThan(String value) {
            addCriterion("ssid <", value, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidLessThanOrEqualTo(String value) {
            addCriterion("ssid <=", value, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidLike(String value) {
            addCriterion("ssid like", value, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidNotLike(String value) {
            addCriterion("ssid not like", value, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidIn(List<String> values) {
            addCriterion("ssid in", values, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidNotIn(List<String> values) {
            addCriterion("ssid not in", values, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidBetween(String value1, String value2) {
            addCriterion("ssid between", value1, value2, "ssid");
            return (Criteria) this;
        }

        public Criteria andSsidNotBetween(String value1, String value2) {
            addCriterion("ssid not between", value1, value2, "ssid");
            return (Criteria) this;
        }

        public Criteria andMagidIsNull() {
            addCriterion("magid is null");
            return (Criteria) this;
        }

        public Criteria andMagidIsNotNull() {
            addCriterion("magid is not null");
            return (Criteria) this;
        }

        public Criteria andMagidEqualTo(String value) {
            addCriterion("magid =", value, "magid");
            return (Criteria) this;
        }

        public Criteria andMagidNotEqualTo(String value) {
            addCriterion("magid <>", value, "magid");
            return (Criteria) this;
        }

        public Criteria andMagidGreaterThan(String value) {
            addCriterion("magid >", value, "magid");
            return (Criteria) this;
        }

        public Criteria andMagidGreaterThanOrEqualTo(String value) {
            addCriterion("magid >=", value, "magid");
            return (Criteria) this;
        }

        public Criteria andMagidLessThan(String value) {
            addCriterion("magid <", value, "magid");
            return (Criteria) this;
        }

        public Criteria andMagidLessThanOrEqualTo(String value) {
            addCriterion("magid <=", value, "magid");
            return (Criteria) this;
        }

        public Criteria andMagidLike(String value) {
            addCriterion("magid like", value, "magid");
            return (Criteria) this;
        }

        public Criteria andMagidNotLike(String value) {
            addCriterion("magid not like", value, "magid");
            return (Criteria) this;
        }

        public Criteria andMagidIn(List<String> values) {
            addCriterion("magid in", values, "magid");
            return (Criteria) this;
        }

        public Criteria andMagidNotIn(List<String> values) {
            addCriterion("magid not in", values, "magid");
            return (Criteria) this;
        }

        public Criteria andMagidBetween(String value1, String value2) {
            addCriterion("magid between", value1, value2, "magid");
            return (Criteria) this;
        }

        public Criteria andMagidNotBetween(String value1, String value2) {
            addCriterion("magid not between", value1, value2, "magid");
            return (Criteria) this;
        }

        public Criteria andJouridIsNull() {
            addCriterion("jourid is null");
            return (Criteria) this;
        }

        public Criteria andJouridIsNotNull() {
            addCriterion("jourid is not null");
            return (Criteria) this;
        }

        public Criteria andJouridEqualTo(String value) {
            addCriterion("jourid =", value, "jourid");
            return (Criteria) this;
        }

        public Criteria andJouridNotEqualTo(String value) {
            addCriterion("jourid <>", value, "jourid");
            return (Criteria) this;
        }

        public Criteria andJouridGreaterThan(String value) {
            addCriterion("jourid >", value, "jourid");
            return (Criteria) this;
        }

        public Criteria andJouridGreaterThanOrEqualTo(String value) {
            addCriterion("jourid >=", value, "jourid");
            return (Criteria) this;
        }

        public Criteria andJouridLessThan(String value) {
            addCriterion("jourid <", value, "jourid");
            return (Criteria) this;
        }

        public Criteria andJouridLessThanOrEqualTo(String value) {
            addCriterion("jourid <=", value, "jourid");
            return (Criteria) this;
        }

        public Criteria andJouridLike(String value) {
            addCriterion("jourid like", value, "jourid");
            return (Criteria) this;
        }

        public Criteria andJouridNotLike(String value) {
            addCriterion("jourid not like", value, "jourid");
            return (Criteria) this;
        }

        public Criteria andJouridIn(List<String> values) {
            addCriterion("jourid in", values, "jourid");
            return (Criteria) this;
        }

        public Criteria andJouridNotIn(List<String> values) {
            addCriterion("jourid not in", values, "jourid");
            return (Criteria) this;
        }

        public Criteria andJouridBetween(String value1, String value2) {
            addCriterion("jourid between", value1, value2, "jourid");
            return (Criteria) this;
        }

        public Criteria andJouridNotBetween(String value1, String value2) {
            addCriterion("jourid not between", value1, value2, "jourid");
            return (Criteria) this;
        }

        public Criteria andOriginalProjectResIdIsNull() {
            addCriterion("original_project_res_id is null");
            return (Criteria) this;
        }

        public Criteria andOriginalProjectResIdIsNotNull() {
            addCriterion("original_project_res_id is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalProjectResIdEqualTo(String value) {
            addCriterion("original_project_res_id =", value, "originalProjectResId");
            return (Criteria) this;
        }

        public Criteria andOriginalProjectResIdNotEqualTo(String value) {
            addCriterion("original_project_res_id <>", value, "originalProjectResId");
            return (Criteria) this;
        }

        public Criteria andOriginalProjectResIdGreaterThan(String value) {
            addCriterion("original_project_res_id >", value, "originalProjectResId");
            return (Criteria) this;
        }

        public Criteria andOriginalProjectResIdGreaterThanOrEqualTo(String value) {
            addCriterion("original_project_res_id >=", value, "originalProjectResId");
            return (Criteria) this;
        }

        public Criteria andOriginalProjectResIdLessThan(String value) {
            addCriterion("original_project_res_id <", value, "originalProjectResId");
            return (Criteria) this;
        }

        public Criteria andOriginalProjectResIdLessThanOrEqualTo(String value) {
            addCriterion("original_project_res_id <=", value, "originalProjectResId");
            return (Criteria) this;
        }

        public Criteria andOriginalProjectResIdLike(String value) {
            addCriterion("original_project_res_id like", value, "originalProjectResId");
            return (Criteria) this;
        }

        public Criteria andOriginalProjectResIdNotLike(String value) {
            addCriterion("original_project_res_id not like", value, "originalProjectResId");
            return (Criteria) this;
        }

        public Criteria andOriginalProjectResIdIn(List<String> values) {
            addCriterion("original_project_res_id in", values, "originalProjectResId");
            return (Criteria) this;
        }

        public Criteria andOriginalProjectResIdNotIn(List<String> values) {
            addCriterion("original_project_res_id not in", values, "originalProjectResId");
            return (Criteria) this;
        }

        public Criteria andOriginalProjectResIdBetween(String value1, String value2) {
            addCriterion("original_project_res_id between", value1, value2, "originalProjectResId");
            return (Criteria) this;
        }

        public Criteria andOriginalProjectResIdNotBetween(String value1, String value2) {
            addCriterion("original_project_res_id not between", value1, value2, "originalProjectResId");
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

        public Criteria andActivityIdIsNull() {
            addCriterion("activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(Integer value) {
            addCriterion("activity_id =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(Integer value) {
            addCriterion("activity_id <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(Integer value) {
            addCriterion("activity_id >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_id >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(Integer value) {
            addCriterion("activity_id <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(Integer value) {
            addCriterion("activity_id <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<Integer> values) {
            addCriterion("activity_id in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<Integer> values) {
            addCriterion("activity_id not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(Integer value1, Integer value2) {
            addCriterion("activity_id between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_id not between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andBookClassificationIsNull() {
            addCriterion("book_classification is null");
            return (Criteria) this;
        }

        public Criteria andBookClassificationIsNotNull() {
            addCriterion("book_classification is not null");
            return (Criteria) this;
        }

        public Criteria andBookClassificationEqualTo(Integer value) {
            addCriterion("book_classification =", value, "bookClassification");
            return (Criteria) this;
        }

        public Criteria andBookClassificationNotEqualTo(Integer value) {
            addCriterion("book_classification <>", value, "bookClassification");
            return (Criteria) this;
        }

        public Criteria andBookClassificationGreaterThan(Integer value) {
            addCriterion("book_classification >", value, "bookClassification");
            return (Criteria) this;
        }

        public Criteria andBookClassificationGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_classification >=", value, "bookClassification");
            return (Criteria) this;
        }

        public Criteria andBookClassificationLessThan(Integer value) {
            addCriterion("book_classification <", value, "bookClassification");
            return (Criteria) this;
        }

        public Criteria andBookClassificationLessThanOrEqualTo(Integer value) {
            addCriterion("book_classification <=", value, "bookClassification");
            return (Criteria) this;
        }

        public Criteria andBookClassificationIn(List<Integer> values) {
            addCriterion("book_classification in", values, "bookClassification");
            return (Criteria) this;
        }

        public Criteria andBookClassificationNotIn(List<Integer> values) {
            addCriterion("book_classification not in", values, "bookClassification");
            return (Criteria) this;
        }

        public Criteria andBookClassificationBetween(Integer value1, Integer value2) {
            addCriterion("book_classification between", value1, value2, "bookClassification");
            return (Criteria) this;
        }

        public Criteria andBookClassificationNotBetween(Integer value1, Integer value2) {
            addCriterion("book_classification not between", value1, value2, "bookClassification");
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