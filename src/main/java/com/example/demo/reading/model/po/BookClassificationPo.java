/*
 *
 * BookClassificationPo.java
 * Copyright(C) 1993-2018 超星公司
 * @date 2018-10-30
 */
package com.example.demo.reading.model.po;

import java.sql.Timestamp;

/**
 * @author admin
 */
public class BookClassificationPo {
    /**
     * 表字段 : book_classification.id
     */
    private Integer id;

    /**
     * 表字段 : book_classification.classification_id
     */
    private String classificationId;

    /**
     * 表字段 : book_classification.classification_name
     */
    private String classificationName;

    /**
     * 表字段 : book_classification.add_person_name
     */
    private String addPersonName;

    /**
     * 表字段 : book_classification.add_person_school
     */
    private String addPersonSchool;

    /**
     * 表字段 : book_classification.classification
     */
    private String classification;

    /**
     * 图书分类级别，1代表1级，依次
     * 表字段 : book_classification.classification_rank
     */
    private Integer classificationRank;

    /**
     * 表字段 : book_classification.parent_classification_id
     */
    private String parentClassificationId;

    /**
     * 0:显示1：不显示
     * 表字段 : book_classification.is_display
     */
    private Integer isDisplay;

    /**
     * 表字段 : book_classification.gmt_create
     */
    private Timestamp gmtCreate;

    /**
     * 表字段 : book_classification.gmt_modified
     */
    private Timestamp gmtModified;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(String classificationId) {
        this.classificationId = classificationId == null ? null : classificationId.trim();
    }

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName == null ? null : classificationName.trim();
    }

    public String getAddPersonName() {
        return addPersonName;
    }

    public void setAddPersonName(String addPersonName) {
        this.addPersonName = addPersonName == null ? null : addPersonName.trim();
    }

    public String getAddPersonSchool() {
        return addPersonSchool;
    }

    public void setAddPersonSchool(String addPersonSchool) {
        this.addPersonSchool = addPersonSchool == null ? null : addPersonSchool.trim();
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification == null ? null : classification.trim();
    }

    public Integer getClassificationRank() {
        return classificationRank;
    }

    public void setClassificationRank(Integer classificationRank) {
        this.classificationRank = classificationRank;
    }

    public String getParentClassificationId() {
        return parentClassificationId;
    }

    public void setParentClassificationId(String parentClassificationId) {
        this.parentClassificationId = parentClassificationId == null ? null : parentClassificationId.trim();
    }

    public Integer getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(Integer isDisplay) {
        this.isDisplay = isDisplay;
    }

    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Timestamp getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "BookClassificationPo{" +
                "id=" + id +
                ", classificationId='" + classificationId + '\'' +
                ", classificationName='" + classificationName + '\'' +
                ", addPersonName='" + addPersonName + '\'' +
                ", addPersonSchool='" + addPersonSchool + '\'' +
                ", classification='" + classification + '\'' +
                ", classificationRank=" + classificationRank +
                ", parentClassificationId='" + parentClassificationId + '\'' +
                ", isDisplay=" + isDisplay +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}