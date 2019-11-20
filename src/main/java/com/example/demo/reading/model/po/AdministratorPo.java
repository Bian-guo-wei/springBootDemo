/*
*
* AdministratorPo.java
* Copyright(C) 1993-2018 超星公司
* @date 2019-10-15
*/
package com.example.demo.reading.model.po;

import java.io.Serializable;
import java.sql.Timestamp;

public class AdministratorPo implements Serializable {
    /**
     *
     * 主键，自增
     * 表字段 : administrator.id
     */
    private Integer id;

    /**
     *
     * 老师姓名
     * 表字段 : administrator.real_name
     */
    private String realName;

    /**
     *
     * passport uid，移动端用户ID
     * 表字段 : administrator.pp_uid
     */
    private Integer ppUid;

    /**
     *
     * passport 学习通登录名
     * 表字段 : administrator.pp_uname
     */
    private String ppUname;

    /**
     *
     * passport 密码
     * 表字段 : administrator.pp_pwd
     */
    private String ppPwd;

    /**
     *
     * 对学校而言,教师的角色
     * 表字段 : administrator.role
     */
    private Integer role;

    /**
     *
     * passport 角色 id
     * 表字段 : administrator.pp_role
     */
    private Integer ppRole;

    /**
     *
     * passport 学习通园所 id
     * 表字段 : administrator.pp_school_id
     */
    private Integer ppSchoolId;

    /**
     *
     * 工号
     * 表字段 : administrator.job_number
     */
    private Integer jobNumber;

    /**
     *
     * 性别 id;0:男；1：女；
     * 表字段 : administrator.sex
     */
    private Integer sex;

    /**
     *
     * 老师电话
     * 表字段 : administrator.phone
     */
    private String phone;

    /**
     *
     * 用户状态
     * 表字段 : administrator.status
     */
    private Integer status;

    /**
     *
     * 是否显示，0不显示，1显示
     * 表字段 : administrator.is_display
     */
    private Integer isDisplay;

    /**
     *
     * 学校
     * 表字段 : administrator.school_name
     */
    private String schoolName;

    /**
     *
     * 学院
     * 表字段 : administrator.school_college
     */
    private String schoolCollege;

    /**
     *
     * 职称
     * 表字段 : administrator.school_job
     */
    private String schoolJob;

    /**
     *
     * 创建时间
     * 表字段 : administrator.gmt_create
     */
    private Timestamp gmtCreate;

    /**
     *
     * 修改时间
     * 表字段 : administrator.gmt_modified
     */
    private Timestamp gmtModified;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public Integer getPpUid() {
        return ppUid;
    }

    public void setPpUid(Integer ppUid) {
        this.ppUid = ppUid;
    }

    public String getPpUname() {
        return ppUname;
    }

    public void setPpUname(String ppUname) {
        this.ppUname = ppUname == null ? null : ppUname.trim();
    }

    public String getPpPwd() {
        return ppPwd;
    }

    public void setPpPwd(String ppPwd) {
        this.ppPwd = ppPwd == null ? null : ppPwd.trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getPpRole() {
        return ppRole;
    }

    public void setPpRole(Integer ppRole) {
        this.ppRole = ppRole;
    }

    public Integer getPpSchoolId() {
        return ppSchoolId;
    }

    public void setPpSchoolId(Integer ppSchoolId) {
        this.ppSchoolId = ppSchoolId;
    }

    public Integer getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(Integer jobNumber) {
        this.jobNumber = jobNumber;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(Integer isDisplay) {
        this.isDisplay = isDisplay;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }

    public String getSchoolCollege() {
        return schoolCollege;
    }

    public void setSchoolCollege(String schoolCollege) {
        this.schoolCollege = schoolCollege == null ? null : schoolCollege.trim();
    }

    public String getSchoolJob() {
        return schoolJob;
    }

    public void setSchoolJob(String schoolJob) {
        this.schoolJob = schoolJob == null ? null : schoolJob.trim();
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
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", realName=").append(realName);
        sb.append(", ppUid=").append(ppUid);
        sb.append(", ppUname=").append(ppUname);
        sb.append(", ppPwd=").append(ppPwd);
        sb.append(", role=").append(role);
        sb.append(", ppRole=").append(ppRole);
        sb.append(", ppSchoolId=").append(ppSchoolId);
        sb.append(", jobNumber=").append(jobNumber);
        sb.append(", sex=").append(sex);
        sb.append(", phone=").append(phone);
        sb.append(", status=").append(status);
        sb.append(", isDisplay=").append(isDisplay);
        sb.append(", schoolName=").append(schoolName);
        sb.append(", schoolCollege=").append(schoolCollege);
        sb.append(", schoolJob=").append(schoolJob);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append("]");
        return sb.toString();
    }
}