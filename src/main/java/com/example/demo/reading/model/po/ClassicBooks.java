/*
*
* ClassicBooks.java
* Copyright(C) 1993-2018 超星公司
* @date 2019-10-14
*/
package com.example.demo.reading.model.po;

import java.io.Serializable;
import java.util.Date;

public class ClassicBooks implements Serializable {
    /**
     *
     * 
     * 表字段 : classic_books.id
     */
    private Integer id;

    /**
     *
     * 资源id，唯一标识
     * 表字段 : classic_books.resource_id
     */
    private String resourceId;

    /**
     *
     * 题名
     * 表字段 : classic_books.basic_title
     */
    private String basicTitle;

    /**
     *
     * 作者
     * 表字段 : classic_books.basic_creator
     */
    private String basicCreator;

    /**
     *
     * 出版社
     * 表字段 : classic_books.basic_publisher
     */
    private String basicPublisher;

    /**
     *
     * 关键词
     * 表字段 : classic_books.basic_keyword
     */
    private String basicKeyword;

    /**
     *
     * 现暂定为批量导入活动字段，原为作者单位
     * 表字段 : classic_books.basic_contact
     */
    private String basicContact;

    /**
     *
     * 期刊名
     * 表字段 : classic_books.basic_source_name
     */
    private String basicSourceName;

    /**
     *
     * 年份
     * 表字段 : classic_books.basic_date
     */
    private String basicDate;

    /**
     *
     * isbn issn
     * 表字段 : classic_books.basic_identifier_1
     */
    private String basicIdentifier1;

    /**
     *
     * 书评
     * 表字段 : classic_books.basic_description
     */
    private String basicDescription;

    /**
     *
     * 期号（special_col_one）
     * 表字段 : classic_books.basic_source_no
     */
    private String basicSourceNo;

    /**
     *
     * 页数（special_col_two）
     * 表字段 : classic_books.basic_page
     */
    private String basicPage;

    /**
     *
     * 年份，用于聚类检索
     * 表字段 : classic_books.proc_year
     */
    private String procYear;

    /**
     *
     * 核心期刊编号
     * 表字段 : classic_books.proc_enbody
     */
    private String procEnbody;

    /**
     *
     * 超星学科分类
     * 表字段 : classic_books.proc_class_id
     */
    private String procClassId;

    /**
     *
     * 频道号
     * 表字段 : classic_books.proc_channel
     */
    private Integer procChannel;

    /**
     *
     * 读秀号
     * 表字段 : classic_books.proc_dxid
     */
    private String procDxid;

    /**
     *
     * 全文链接
     * 表字段 : classic_books.proc_file_link
     */
    private String procFileLink;

    /**
     *
     * 
     * 表字段 : classic_books.proc_quote
     */
    private Integer procQuote;

    /**
     *
     * 当当网址
     * 表字段 : classic_books.detaiurl
     */
    private String detaiurl;

    /**
     *
     * 暂时不用
     * 表字段 : classic_books.yycount
     */
    private Integer yycount;

    /**
     *
     * 载体形态
     * 表字段 : classic_books.impact_factor_ch
     */
    private String impactFactorCh;

    /**
     *
     * 丛编项
     * 表字段 : classic_books.impact_factor_en
     */
    private String impactFactorEn;

    /**
     *
     * 亚马逊网址
     * 表字段 : classic_books.avenue
     */
    private String avenue;

    /**
     *
     * 下载全文链接
     * 表字段 : classic_books.cnki_yycount
     */
    private String cnkiYycount;

    /**
     *
     * 导读课件链接
     * 表字段 : classic_books.wf_yycount
     */
    private String wfYycount;

    /**
     *
     * 讲解材料链接
     * 表字段 : classic_books.cqvip_yycount
     */
    private String cqvipYycount;

    /**
     *
     * 豆瓣网址
     * 表字段 : classic_books.ware_page_view
     */
    private String warePageView;

    /**
     *
     * 一般附注
     * 表字段 : classic_books.download_count
     */
    private String downloadCount;

    /**
     *
     * 摘要
     * 表字段 : classic_books.view_elements
     */
    private String viewElements;

    /**
     *
     * view_elements的 json 格式
     * 表字段 : classic_books.view_elements_json
     */
    private String viewElementsJson;

    /**
     *
     * 中图分类号
     * 表字段 : classic_books.foundation
     */
    private String foundation;

    /**
     *
     * 
     * 表字段 : classic_books.screenshot
     */
    private String screenshot;

    /**
     *
     * 处理过的作者字段
     * 表字段 : classic_books.basic_id_creator
     */
    private String basicIdCreator;

    /**
     *
     * 处理过的关键字字段
     * 表字段 : classic_books.basic_id_keyword
     */
    private String basicIdKeyword;

    /**
     *
     * 处理过的来源字段
     * 表字段 : classic_books.basic_id_contact
     */
    private String basicIdContact;

    /**
     *
     * 全文排序
     * 表字段 : classic_books.avenue_type
     */
    private Byte avenueType;

    /**
     *
     * 创建时间，采用格林威治标准，默认使用gmt+8时区
     * 表字段 : classic_books.gmt_create
     */
    private Date gmtCreate;

    /**
     *
     * 修改时间，采用格林威治标准，默认使用gmt+8时区
     * 表字段 : classic_books.gmt_modified
     */
    private Date gmtModified;

    /**
     *
     * 
     * 表字段 : classic_books.proc_channel_id
     */
    private String procChannelId;

    /**
     *
     * 暂用于定价字段
     * 表字段 : classic_books.basic_contact_id
     */
    private String basicContactId;

    /**
     *
     * 
     * 表字段 : classic_books.basic_creator_id
     */
    private String basicCreatorId;

    /**
     *
     * 
     * 表字段 : classic_books.basic_keyword_id
     */
    private String basicKeywordId;

    /**
     *
     * 
     * 表字段 : classic_books.basic_id_date
     */
    private String basicIdDate;

    /**
     *
     * 按照时间排序的字段
     * 表字段 : classic_books.basic_date_sort
     */
    private Integer basicDateSort;

    /**
     *
     * super star id;每个全文都有一个ssid
     * 表字段 : classic_books.ssid
     */
    private String ssid;

    /**
     *
     * 刊 id
     * 表字段 : classic_books.magid
     */
    private String magid;

    /**
     *
     * 刊种 id
     * 表字段 : classic_books.jourid
     */
    private String jourid;

    /**
     *
     * 现存放ISBN号
     * 表字段 : classic_books.original_project_res_id
     */
    private String originalProjectResId;

    /**
     *
     * 是否显示：0：显示，1：不显示
     * 表字段 : classic_books.is_display
     */
    private Integer isDisplay;

    /**
     *
     * 
     * 表字段 : classic_books.activity_id
     */
    private Integer activityId;

    /**
     *
     * 1为扩展书目   2为基本书目
     * 表字段 : classic_books.book_classification
     */
    private Integer bookClassification;

    private static final long serialVersionUID = 1L;

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
        this.resourceId = resourceId == null ? null : resourceId.trim();
    }

    public String getBasicTitle() {
        return basicTitle;
    }

    public void setBasicTitle(String basicTitle) {
        this.basicTitle = basicTitle == null ? null : basicTitle.trim();
    }

    public String getBasicCreator() {
        return basicCreator;
    }

    public void setBasicCreator(String basicCreator) {
        this.basicCreator = basicCreator == null ? null : basicCreator.trim();
    }

    public String getBasicPublisher() {
        return basicPublisher;
    }

    public void setBasicPublisher(String basicPublisher) {
        this.basicPublisher = basicPublisher == null ? null : basicPublisher.trim();
    }

    public String getBasicKeyword() {
        return basicKeyword;
    }

    public void setBasicKeyword(String basicKeyword) {
        this.basicKeyword = basicKeyword == null ? null : basicKeyword.trim();
    }

    public String getBasicContact() {
        return basicContact;
    }

    public void setBasicContact(String basicContact) {
        this.basicContact = basicContact == null ? null : basicContact.trim();
    }

    public String getBasicSourceName() {
        return basicSourceName;
    }

    public void setBasicSourceName(String basicSourceName) {
        this.basicSourceName = basicSourceName == null ? null : basicSourceName.trim();
    }

    public String getBasicDate() {
        return basicDate;
    }

    public void setBasicDate(String basicDate) {
        this.basicDate = basicDate == null ? null : basicDate.trim();
    }

    public String getBasicIdentifier1() {
        return basicIdentifier1;
    }

    public void setBasicIdentifier1(String basicIdentifier1) {
        this.basicIdentifier1 = basicIdentifier1 == null ? null : basicIdentifier1.trim();
    }

    public String getBasicDescription() {
        return basicDescription;
    }

    public void setBasicDescription(String basicDescription) {
        this.basicDescription = basicDescription == null ? null : basicDescription.trim();
    }

    public String getBasicSourceNo() {
        return basicSourceNo;
    }

    public void setBasicSourceNo(String basicSourceNo) {
        this.basicSourceNo = basicSourceNo == null ? null : basicSourceNo.trim();
    }

    public String getBasicPage() {
        return basicPage;
    }

    public void setBasicPage(String basicPage) {
        this.basicPage = basicPage == null ? null : basicPage.trim();
    }

    public String getProcYear() {
        return procYear;
    }

    public void setProcYear(String procYear) {
        this.procYear = procYear == null ? null : procYear.trim();
    }

    public String getProcEnbody() {
        return procEnbody;
    }

    public void setProcEnbody(String procEnbody) {
        this.procEnbody = procEnbody == null ? null : procEnbody.trim();
    }

    public String getProcClassId() {
        return procClassId;
    }

    public void setProcClassId(String procClassId) {
        this.procClassId = procClassId == null ? null : procClassId.trim();
    }

    public Integer getProcChannel() {
        return procChannel;
    }

    public void setProcChannel(Integer procChannel) {
        this.procChannel = procChannel;
    }

    public String getProcDxid() {
        return procDxid;
    }

    public void setProcDxid(String procDxid) {
        this.procDxid = procDxid == null ? null : procDxid.trim();
    }

    public String getProcFileLink() {
        return procFileLink;
    }

    public void setProcFileLink(String procFileLink) {
        this.procFileLink = procFileLink == null ? null : procFileLink.trim();
    }

    public Integer getProcQuote() {
        return procQuote;
    }

    public void setProcQuote(Integer procQuote) {
        this.procQuote = procQuote;
    }

    public String getDetaiurl() {
        return detaiurl;
    }

    public void setDetaiurl(String detaiurl) {
        this.detaiurl = detaiurl == null ? null : detaiurl.trim();
    }

    public Integer getYycount() {
        return yycount;
    }

    public void setYycount(Integer yycount) {
        this.yycount = yycount;
    }

    public String getImpactFactorCh() {
        return impactFactorCh;
    }

    public void setImpactFactorCh(String impactFactorCh) {
        this.impactFactorCh = impactFactorCh == null ? null : impactFactorCh.trim();
    }

    public String getImpactFactorEn() {
        return impactFactorEn;
    }

    public void setImpactFactorEn(String impactFactorEn) {
        this.impactFactorEn = impactFactorEn == null ? null : impactFactorEn.trim();
    }

    public String getAvenue() {
        return avenue;
    }

    public void setAvenue(String avenue) {
        this.avenue = avenue == null ? null : avenue.trim();
    }

    public String getCnkiYycount() {
        return cnkiYycount;
    }

    public void setCnkiYycount(String cnkiYycount) {
        this.cnkiYycount = cnkiYycount == null ? null : cnkiYycount.trim();
    }

    public String getWfYycount() {
        return wfYycount;
    }

    public void setWfYycount(String wfYycount) {
        this.wfYycount = wfYycount == null ? null : wfYycount.trim();
    }

    public String getCqvipYycount() {
        return cqvipYycount;
    }

    public void setCqvipYycount(String cqvipYycount) {
        this.cqvipYycount = cqvipYycount == null ? null : cqvipYycount.trim();
    }

    public String getWarePageView() {
        return warePageView;
    }

    public void setWarePageView(String warePageView) {
        this.warePageView = warePageView == null ? null : warePageView.trim();
    }

    public String getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(String downloadCount) {
        this.downloadCount = downloadCount == null ? null : downloadCount.trim();
    }

    public String getViewElements() {
        return viewElements;
    }

    public void setViewElements(String viewElements) {
        this.viewElements = viewElements == null ? null : viewElements.trim();
    }

    public String getViewElementsJson() {
        return viewElementsJson;
    }

    public void setViewElementsJson(String viewElementsJson) {
        this.viewElementsJson = viewElementsJson == null ? null : viewElementsJson.trim();
    }

    public String getFoundation() {
        return foundation;
    }

    public void setFoundation(String foundation) {
        this.foundation = foundation == null ? null : foundation.trim();
    }

    public String getScreenshot() {
        return screenshot;
    }

    public void setScreenshot(String screenshot) {
        this.screenshot = screenshot == null ? null : screenshot.trim();
    }

    public String getBasicIdCreator() {
        return basicIdCreator;
    }

    public void setBasicIdCreator(String basicIdCreator) {
        this.basicIdCreator = basicIdCreator == null ? null : basicIdCreator.trim();
    }

    public String getBasicIdKeyword() {
        return basicIdKeyword;
    }

    public void setBasicIdKeyword(String basicIdKeyword) {
        this.basicIdKeyword = basicIdKeyword == null ? null : basicIdKeyword.trim();
    }

    public String getBasicIdContact() {
        return basicIdContact;
    }

    public void setBasicIdContact(String basicIdContact) {
        this.basicIdContact = basicIdContact == null ? null : basicIdContact.trim();
    }

    public Byte getAvenueType() {
        return avenueType;
    }

    public void setAvenueType(Byte avenueType) {
        this.avenueType = avenueType;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getProcChannelId() {
        return procChannelId;
    }

    public void setProcChannelId(String procChannelId) {
        this.procChannelId = procChannelId == null ? null : procChannelId.trim();
    }

    public String getBasicContactId() {
        return basicContactId;
    }

    public void setBasicContactId(String basicContactId) {
        this.basicContactId = basicContactId == null ? null : basicContactId.trim();
    }

    public String getBasicCreatorId() {
        return basicCreatorId;
    }

    public void setBasicCreatorId(String basicCreatorId) {
        this.basicCreatorId = basicCreatorId == null ? null : basicCreatorId.trim();
    }

    public String getBasicKeywordId() {
        return basicKeywordId;
    }

    public void setBasicKeywordId(String basicKeywordId) {
        this.basicKeywordId = basicKeywordId == null ? null : basicKeywordId.trim();
    }

    public String getBasicIdDate() {
        return basicIdDate;
    }

    public void setBasicIdDate(String basicIdDate) {
        this.basicIdDate = basicIdDate == null ? null : basicIdDate.trim();
    }

    public Integer getBasicDateSort() {
        return basicDateSort;
    }

    public void setBasicDateSort(Integer basicDateSort) {
        this.basicDateSort = basicDateSort;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid == null ? null : ssid.trim();
    }

    public String getMagid() {
        return magid;
    }

    public void setMagid(String magid) {
        this.magid = magid == null ? null : magid.trim();
    }

    public String getJourid() {
        return jourid;
    }

    public void setJourid(String jourid) {
        this.jourid = jourid == null ? null : jourid.trim();
    }

    public String getOriginalProjectResId() {
        return originalProjectResId;
    }

    public void setOriginalProjectResId(String originalProjectResId) {
        this.originalProjectResId = originalProjectResId == null ? null : originalProjectResId.trim();
    }

    public Integer getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(Integer isDisplay) {
        this.isDisplay = isDisplay;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getBookClassification() {
        return bookClassification;
    }

    public void setBookClassification(Integer bookClassification) {
        this.bookClassification = bookClassification;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", resourceId=").append(resourceId);
        sb.append(", basicTitle=").append(basicTitle);
        sb.append(", basicCreator=").append(basicCreator);
        sb.append(", basicPublisher=").append(basicPublisher);
        sb.append(", basicKeyword=").append(basicKeyword);
        sb.append(", basicContact=").append(basicContact);
        sb.append(", basicSourceName=").append(basicSourceName);
        sb.append(", basicDate=").append(basicDate);
        sb.append(", basicIdentifier1=").append(basicIdentifier1);
        sb.append(", basicDescription=").append(basicDescription);
        sb.append(", basicSourceNo=").append(basicSourceNo);
        sb.append(", basicPage=").append(basicPage);
        sb.append(", procYear=").append(procYear);
        sb.append(", procEnbody=").append(procEnbody);
        sb.append(", procClassId=").append(procClassId);
        sb.append(", procChannel=").append(procChannel);
        sb.append(", procDxid=").append(procDxid);
        sb.append(", procFileLink=").append(procFileLink);
        sb.append(", procQuote=").append(procQuote);
        sb.append(", detaiurl=").append(detaiurl);
        sb.append(", yycount=").append(yycount);
        sb.append(", impactFactorCh=").append(impactFactorCh);
        sb.append(", impactFactorEn=").append(impactFactorEn);
        sb.append(", avenue=").append(avenue);
        sb.append(", cnkiYycount=").append(cnkiYycount);
        sb.append(", wfYycount=").append(wfYycount);
        sb.append(", cqvipYycount=").append(cqvipYycount);
        sb.append(", warePageView=").append(warePageView);
        sb.append(", downloadCount=").append(downloadCount);
        sb.append(", viewElements=").append(viewElements);
        sb.append(", viewElementsJson=").append(viewElementsJson);
        sb.append(", foundation=").append(foundation);
        sb.append(", screenshot=").append(screenshot);
        sb.append(", basicIdCreator=").append(basicIdCreator);
        sb.append(", basicIdKeyword=").append(basicIdKeyword);
        sb.append(", basicIdContact=").append(basicIdContact);
        sb.append(", avenueType=").append(avenueType);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", procChannelId=").append(procChannelId);
        sb.append(", basicContactId=").append(basicContactId);
        sb.append(", basicCreatorId=").append(basicCreatorId);
        sb.append(", basicKeywordId=").append(basicKeywordId);
        sb.append(", basicIdDate=").append(basicIdDate);
        sb.append(", basicDateSort=").append(basicDateSort);
        sb.append(", ssid=").append(ssid);
        sb.append(", magid=").append(magid);
        sb.append(", jourid=").append(jourid);
        sb.append(", originalProjectResId=").append(originalProjectResId);
        sb.append(", isDisplay=").append(isDisplay);
        sb.append(", activityId=").append(activityId);
        sb.append(", bookClassification=").append(bookClassification);
        sb.append("]");
        return sb.toString();
    }
}