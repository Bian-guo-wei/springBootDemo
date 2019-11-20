package com.example.demo.essay.model.po;


import java.sql.Timestamp;

/**
 * @author admin
 */
public class ReadingThoughtPo {
    /**
     * 主键
     */
    private Integer id;
    /**
     *resource_id值和resource_info中的resource_id对应
     */
    private String resourceId;
    /**
     *感悟标题
     */
    private String thoughtTitle;
    /**
     *感悟内容
     */
    private String thoughtContent;
    /**
     *作者姓名
     */
    private String authorName;
    /**
     *作者的puid
     */
    private int authorPuid;
    /**
     *排序id值
     */
    private int sortId;
    /**
     *创建时间
     */
    private Timestamp gmtCreate;
    /**
     *修改时间
     */
    private Timestamp gmtModified;
    /**
     * 图书名称
     */
    private String bookName;
    /**
     * 图书分类
     */
    private String bookClassification;
    /**
     * 所属学校
     */
    private String schoolName;
    /**
     * 所属学院
     */
    private String academy;
    /**
     * 发布状态
     */
    private int approvalStatus;
    /**
     * 发布状态
     */
    private int isDisplay;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getThoughtTitle() {
        return thoughtTitle;
    }

    public void setThoughtTitle(String thoughtTitle) {
        this.thoughtTitle = thoughtTitle;
    }

    public String getThoughtContent() {
        return thoughtContent;
    }

    public void setThoughtContent(String thoughtContent) {
        this.thoughtContent = thoughtContent;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getAuthorPuid() {
        return authorPuid;
    }

    public void setAuthorPuid(int authorPuid) {
        this.authorPuid = authorPuid;
    }

    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
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

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookClassification() {
        return bookClassification;
    }

    public void setBookClassification(String bookClassification) {
        this.bookClassification = bookClassification;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public int getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(int approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public int getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(int isDisplay) {
        this.isDisplay = isDisplay;
    }

    @Override
    public String toString() {
        return "ReadingThoughtPo{" +
                "id=" + id +
                ", resourceId='" + resourceId + '\'' +
                ", thoughtTitle='" + thoughtTitle + '\'' +
                ", thoughtContent='" + thoughtContent + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorPuid=" + authorPuid +
                ", sortId=" + sortId +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", bookName='" + bookName + '\'' +
                ", bookClassification='" + bookClassification + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", academy='" + academy + '\'' +
                ", approvalStatus=" + approvalStatus +
                ", isDisplay=" + isDisplay +
                '}';
    }
}

