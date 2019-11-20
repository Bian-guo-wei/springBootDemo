/*
*
* AdministratorPoExample.java
* Copyright(C) 1993-2018 超星公司
* @date 2019-10-15
*/
package com.example.demo.reading.model.po;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AdministratorPoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdministratorPoExample() {
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

        public Criteria andRealNameIsNull() {
            addCriterion("real_name is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("real_name is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("real_name =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("real_name <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("real_name >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("real_name >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("real_name <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("real_name <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("real_name like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("real_name not like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("real_name in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("real_name not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("real_name between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("real_name not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andPpUidIsNull() {
            addCriterion("pp_uid is null");
            return (Criteria) this;
        }

        public Criteria andPpUidIsNotNull() {
            addCriterion("pp_uid is not null");
            return (Criteria) this;
        }

        public Criteria andPpUidEqualTo(Integer value) {
            addCriterion("pp_uid =", value, "ppUid");
            return (Criteria) this;
        }

        public Criteria andPpUidNotEqualTo(Integer value) {
            addCriterion("pp_uid <>", value, "ppUid");
            return (Criteria) this;
        }

        public Criteria andPpUidGreaterThan(Integer value) {
            addCriterion("pp_uid >", value, "ppUid");
            return (Criteria) this;
        }

        public Criteria andPpUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pp_uid >=", value, "ppUid");
            return (Criteria) this;
        }

        public Criteria andPpUidLessThan(Integer value) {
            addCriterion("pp_uid <", value, "ppUid");
            return (Criteria) this;
        }

        public Criteria andPpUidLessThanOrEqualTo(Integer value) {
            addCriterion("pp_uid <=", value, "ppUid");
            return (Criteria) this;
        }

        public Criteria andPpUidIn(List<Integer> values) {
            addCriterion("pp_uid in", values, "ppUid");
            return (Criteria) this;
        }

        public Criteria andPpUidNotIn(List<Integer> values) {
            addCriterion("pp_uid not in", values, "ppUid");
            return (Criteria) this;
        }

        public Criteria andPpUidBetween(Integer value1, Integer value2) {
            addCriterion("pp_uid between", value1, value2, "ppUid");
            return (Criteria) this;
        }

        public Criteria andPpUidNotBetween(Integer value1, Integer value2) {
            addCriterion("pp_uid not between", value1, value2, "ppUid");
            return (Criteria) this;
        }

        public Criteria andPpUnameIsNull() {
            addCriterion("pp_uname is null");
            return (Criteria) this;
        }

        public Criteria andPpUnameIsNotNull() {
            addCriterion("pp_uname is not null");
            return (Criteria) this;
        }

        public Criteria andPpUnameEqualTo(String value) {
            addCriterion("pp_uname =", value, "ppUname");
            return (Criteria) this;
        }

        public Criteria andPpUnameNotEqualTo(String value) {
            addCriterion("pp_uname <>", value, "ppUname");
            return (Criteria) this;
        }

        public Criteria andPpUnameGreaterThan(String value) {
            addCriterion("pp_uname >", value, "ppUname");
            return (Criteria) this;
        }

        public Criteria andPpUnameGreaterThanOrEqualTo(String value) {
            addCriterion("pp_uname >=", value, "ppUname");
            return (Criteria) this;
        }

        public Criteria andPpUnameLessThan(String value) {
            addCriterion("pp_uname <", value, "ppUname");
            return (Criteria) this;
        }

        public Criteria andPpUnameLessThanOrEqualTo(String value) {
            addCriterion("pp_uname <=", value, "ppUname");
            return (Criteria) this;
        }

        public Criteria andPpUnameLike(String value) {
            addCriterion("pp_uname like", value, "ppUname");
            return (Criteria) this;
        }

        public Criteria andPpUnameNotLike(String value) {
            addCriterion("pp_uname not like", value, "ppUname");
            return (Criteria) this;
        }

        public Criteria andPpUnameIn(List<String> values) {
            addCriterion("pp_uname in", values, "ppUname");
            return (Criteria) this;
        }

        public Criteria andPpUnameNotIn(List<String> values) {
            addCriterion("pp_uname not in", values, "ppUname");
            return (Criteria) this;
        }

        public Criteria andPpUnameBetween(String value1, String value2) {
            addCriterion("pp_uname between", value1, value2, "ppUname");
            return (Criteria) this;
        }

        public Criteria andPpUnameNotBetween(String value1, String value2) {
            addCriterion("pp_uname not between", value1, value2, "ppUname");
            return (Criteria) this;
        }

        public Criteria andPpPwdIsNull() {
            addCriterion("pp_pwd is null");
            return (Criteria) this;
        }

        public Criteria andPpPwdIsNotNull() {
            addCriterion("pp_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andPpPwdEqualTo(String value) {
            addCriterion("pp_pwd =", value, "ppPwd");
            return (Criteria) this;
        }

        public Criteria andPpPwdNotEqualTo(String value) {
            addCriterion("pp_pwd <>", value, "ppPwd");
            return (Criteria) this;
        }

        public Criteria andPpPwdGreaterThan(String value) {
            addCriterion("pp_pwd >", value, "ppPwd");
            return (Criteria) this;
        }

        public Criteria andPpPwdGreaterThanOrEqualTo(String value) {
            addCriterion("pp_pwd >=", value, "ppPwd");
            return (Criteria) this;
        }

        public Criteria andPpPwdLessThan(String value) {
            addCriterion("pp_pwd <", value, "ppPwd");
            return (Criteria) this;
        }

        public Criteria andPpPwdLessThanOrEqualTo(String value) {
            addCriterion("pp_pwd <=", value, "ppPwd");
            return (Criteria) this;
        }

        public Criteria andPpPwdLike(String value) {
            addCriterion("pp_pwd like", value, "ppPwd");
            return (Criteria) this;
        }

        public Criteria andPpPwdNotLike(String value) {
            addCriterion("pp_pwd not like", value, "ppPwd");
            return (Criteria) this;
        }

        public Criteria andPpPwdIn(List<String> values) {
            addCriterion("pp_pwd in", values, "ppPwd");
            return (Criteria) this;
        }

        public Criteria andPpPwdNotIn(List<String> values) {
            addCriterion("pp_pwd not in", values, "ppPwd");
            return (Criteria) this;
        }

        public Criteria andPpPwdBetween(String value1, String value2) {
            addCriterion("pp_pwd between", value1, value2, "ppPwd");
            return (Criteria) this;
        }

        public Criteria andPpPwdNotBetween(String value1, String value2) {
            addCriterion("pp_pwd not between", value1, value2, "ppPwd");
            return (Criteria) this;
        }

        public Criteria andRoleIsNull() {
            addCriterion("role is null");
            return (Criteria) this;
        }

        public Criteria andRoleIsNotNull() {
            addCriterion("role is not null");
            return (Criteria) this;
        }

        public Criteria andRoleEqualTo(Integer value) {
            addCriterion("role =", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotEqualTo(Integer value) {
            addCriterion("role <>", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThan(Integer value) {
            addCriterion("role >", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThanOrEqualTo(Integer value) {
            addCriterion("role >=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThan(Integer value) {
            addCriterion("role <", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThanOrEqualTo(Integer value) {
            addCriterion("role <=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleIn(List<Integer> values) {
            addCriterion("role in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotIn(List<Integer> values) {
            addCriterion("role not in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleBetween(Integer value1, Integer value2) {
            addCriterion("role between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotBetween(Integer value1, Integer value2) {
            addCriterion("role not between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andPpRoleIsNull() {
            addCriterion("pp_role is null");
            return (Criteria) this;
        }

        public Criteria andPpRoleIsNotNull() {
            addCriterion("pp_role is not null");
            return (Criteria) this;
        }

        public Criteria andPpRoleEqualTo(Integer value) {
            addCriterion("pp_role =", value, "ppRole");
            return (Criteria) this;
        }

        public Criteria andPpRoleNotEqualTo(Integer value) {
            addCriterion("pp_role <>", value, "ppRole");
            return (Criteria) this;
        }

        public Criteria andPpRoleGreaterThan(Integer value) {
            addCriterion("pp_role >", value, "ppRole");
            return (Criteria) this;
        }

        public Criteria andPpRoleGreaterThanOrEqualTo(Integer value) {
            addCriterion("pp_role >=", value, "ppRole");
            return (Criteria) this;
        }

        public Criteria andPpRoleLessThan(Integer value) {
            addCriterion("pp_role <", value, "ppRole");
            return (Criteria) this;
        }

        public Criteria andPpRoleLessThanOrEqualTo(Integer value) {
            addCriterion("pp_role <=", value, "ppRole");
            return (Criteria) this;
        }

        public Criteria andPpRoleIn(List<Integer> values) {
            addCriterion("pp_role in", values, "ppRole");
            return (Criteria) this;
        }

        public Criteria andPpRoleNotIn(List<Integer> values) {
            addCriterion("pp_role not in", values, "ppRole");
            return (Criteria) this;
        }

        public Criteria andPpRoleBetween(Integer value1, Integer value2) {
            addCriterion("pp_role between", value1, value2, "ppRole");
            return (Criteria) this;
        }

        public Criteria andPpRoleNotBetween(Integer value1, Integer value2) {
            addCriterion("pp_role not between", value1, value2, "ppRole");
            return (Criteria) this;
        }

        public Criteria andPpSchoolIdIsNull() {
            addCriterion("pp_school_id is null");
            return (Criteria) this;
        }

        public Criteria andPpSchoolIdIsNotNull() {
            addCriterion("pp_school_id is not null");
            return (Criteria) this;
        }

        public Criteria andPpSchoolIdEqualTo(Integer value) {
            addCriterion("pp_school_id =", value, "ppSchoolId");
            return (Criteria) this;
        }

        public Criteria andPpSchoolIdNotEqualTo(Integer value) {
            addCriterion("pp_school_id <>", value, "ppSchoolId");
            return (Criteria) this;
        }

        public Criteria andPpSchoolIdGreaterThan(Integer value) {
            addCriterion("pp_school_id >", value, "ppSchoolId");
            return (Criteria) this;
        }

        public Criteria andPpSchoolIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pp_school_id >=", value, "ppSchoolId");
            return (Criteria) this;
        }

        public Criteria andPpSchoolIdLessThan(Integer value) {
            addCriterion("pp_school_id <", value, "ppSchoolId");
            return (Criteria) this;
        }

        public Criteria andPpSchoolIdLessThanOrEqualTo(Integer value) {
            addCriterion("pp_school_id <=", value, "ppSchoolId");
            return (Criteria) this;
        }

        public Criteria andPpSchoolIdIn(List<Integer> values) {
            addCriterion("pp_school_id in", values, "ppSchoolId");
            return (Criteria) this;
        }

        public Criteria andPpSchoolIdNotIn(List<Integer> values) {
            addCriterion("pp_school_id not in", values, "ppSchoolId");
            return (Criteria) this;
        }

        public Criteria andPpSchoolIdBetween(Integer value1, Integer value2) {
            addCriterion("pp_school_id between", value1, value2, "ppSchoolId");
            return (Criteria) this;
        }

        public Criteria andPpSchoolIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pp_school_id not between", value1, value2, "ppSchoolId");
            return (Criteria) this;
        }

        public Criteria andJobNumberIsNull() {
            addCriterion("job_number is null");
            return (Criteria) this;
        }

        public Criteria andJobNumberIsNotNull() {
            addCriterion("job_number is not null");
            return (Criteria) this;
        }

        public Criteria andJobNumberEqualTo(Integer value) {
            addCriterion("job_number =", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberNotEqualTo(Integer value) {
            addCriterion("job_number <>", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberGreaterThan(Integer value) {
            addCriterion("job_number >", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("job_number >=", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberLessThan(Integer value) {
            addCriterion("job_number <", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberLessThanOrEqualTo(Integer value) {
            addCriterion("job_number <=", value, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberIn(List<Integer> values) {
            addCriterion("job_number in", values, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberNotIn(List<Integer> values) {
            addCriterion("job_number not in", values, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberBetween(Integer value1, Integer value2) {
            addCriterion("job_number between", value1, value2, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andJobNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("job_number not between", value1, value2, "jobNumber");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andSchoolNameIsNull() {
            addCriterion("school_name is null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameIsNotNull() {
            addCriterion("school_name is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEqualTo(String value) {
            addCriterion("school_name =", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotEqualTo(String value) {
            addCriterion("school_name <>", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameGreaterThan(String value) {
            addCriterion("school_name >", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameGreaterThanOrEqualTo(String value) {
            addCriterion("school_name >=", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLessThan(String value) {
            addCriterion("school_name <", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLessThanOrEqualTo(String value) {
            addCriterion("school_name <=", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLike(String value) {
            addCriterion("school_name like", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotLike(String value) {
            addCriterion("school_name not like", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameIn(List<String> values) {
            addCriterion("school_name in", values, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotIn(List<String> values) {
            addCriterion("school_name not in", values, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameBetween(String value1, String value2) {
            addCriterion("school_name between", value1, value2, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotBetween(String value1, String value2) {
            addCriterion("school_name not between", value1, value2, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolCollegeIsNull() {
            addCriterion("school_college is null");
            return (Criteria) this;
        }

        public Criteria andSchoolCollegeIsNotNull() {
            addCriterion("school_college is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolCollegeEqualTo(String value) {
            addCriterion("school_college =", value, "schoolCollege");
            return (Criteria) this;
        }

        public Criteria andSchoolCollegeNotEqualTo(String value) {
            addCriterion("school_college <>", value, "schoolCollege");
            return (Criteria) this;
        }

        public Criteria andSchoolCollegeGreaterThan(String value) {
            addCriterion("school_college >", value, "schoolCollege");
            return (Criteria) this;
        }

        public Criteria andSchoolCollegeGreaterThanOrEqualTo(String value) {
            addCriterion("school_college >=", value, "schoolCollege");
            return (Criteria) this;
        }

        public Criteria andSchoolCollegeLessThan(String value) {
            addCriterion("school_college <", value, "schoolCollege");
            return (Criteria) this;
        }

        public Criteria andSchoolCollegeLessThanOrEqualTo(String value) {
            addCriterion("school_college <=", value, "schoolCollege");
            return (Criteria) this;
        }

        public Criteria andSchoolCollegeLike(String value) {
            addCriterion("school_college like", value, "schoolCollege");
            return (Criteria) this;
        }

        public Criteria andSchoolCollegeNotLike(String value) {
            addCriterion("school_college not like", value, "schoolCollege");
            return (Criteria) this;
        }

        public Criteria andSchoolCollegeIn(List<String> values) {
            addCriterion("school_college in", values, "schoolCollege");
            return (Criteria) this;
        }

        public Criteria andSchoolCollegeNotIn(List<String> values) {
            addCriterion("school_college not in", values, "schoolCollege");
            return (Criteria) this;
        }

        public Criteria andSchoolCollegeBetween(String value1, String value2) {
            addCriterion("school_college between", value1, value2, "schoolCollege");
            return (Criteria) this;
        }

        public Criteria andSchoolCollegeNotBetween(String value1, String value2) {
            addCriterion("school_college not between", value1, value2, "schoolCollege");
            return (Criteria) this;
        }

        public Criteria andSchoolJobIsNull() {
            addCriterion("school_job is null");
            return (Criteria) this;
        }

        public Criteria andSchoolJobIsNotNull() {
            addCriterion("school_job is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolJobEqualTo(String value) {
            addCriterion("school_job =", value, "schoolJob");
            return (Criteria) this;
        }

        public Criteria andSchoolJobNotEqualTo(String value) {
            addCriterion("school_job <>", value, "schoolJob");
            return (Criteria) this;
        }

        public Criteria andSchoolJobGreaterThan(String value) {
            addCriterion("school_job >", value, "schoolJob");
            return (Criteria) this;
        }

        public Criteria andSchoolJobGreaterThanOrEqualTo(String value) {
            addCriterion("school_job >=", value, "schoolJob");
            return (Criteria) this;
        }

        public Criteria andSchoolJobLessThan(String value) {
            addCriterion("school_job <", value, "schoolJob");
            return (Criteria) this;
        }

        public Criteria andSchoolJobLessThanOrEqualTo(String value) {
            addCriterion("school_job <=", value, "schoolJob");
            return (Criteria) this;
        }

        public Criteria andSchoolJobLike(String value) {
            addCriterion("school_job like", value, "schoolJob");
            return (Criteria) this;
        }

        public Criteria andSchoolJobNotLike(String value) {
            addCriterion("school_job not like", value, "schoolJob");
            return (Criteria) this;
        }

        public Criteria andSchoolJobIn(List<String> values) {
            addCriterion("school_job in", values, "schoolJob");
            return (Criteria) this;
        }

        public Criteria andSchoolJobNotIn(List<String> values) {
            addCriterion("school_job not in", values, "schoolJob");
            return (Criteria) this;
        }

        public Criteria andSchoolJobBetween(String value1, String value2) {
            addCriterion("school_job between", value1, value2, "schoolJob");
            return (Criteria) this;
        }

        public Criteria andSchoolJobNotBetween(String value1, String value2) {
            addCriterion("school_job not between", value1, value2, "schoolJob");
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