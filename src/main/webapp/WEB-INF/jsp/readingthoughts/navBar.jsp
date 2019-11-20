<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>导航栏</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/readingThought/navBar.css">
</head>
<body>
<!--导航菜单-->
<div class="navigation_menu" id="navigation_menu">
    <div class="menu_title">导航菜单</div>
    <div class="tit">
        <a href="javascript:;">经典阅读活动管理</a>
    </div>
    <ul style="display: none" id="redaing_nav">
        <li><a href="javascript:;" id="readingRecommend" onclick="readingRecommend()">书目管理</a></li>
        <%--<li><a href="javascript:;" id="reading_thoughts" onclick="readingThoughts()">.阅读感悟</a></li>--%>
        <%--<li><a href="javascript:;" id="readingCount" onclick="tothoughtCount()">.阅读感悟统计</a></li>--%>
    </ul>
    <div class="tit">
        <a href="javascript:;">线下活动</a>
    </div>
    <ul style="display: none" id="essay_nav">
        <li><a href="javascript:;" id="essay_contest" onclick="toManagerEssay()">活动</a></li>
        <%--<li><a href="javascript:;" id="manage_charge" onclick="workReview()">.管理员评审</a></li>--%>
        <%--<li><a href="javascript:;" id="works_classify" onclick="toEssaySystematics()">.作品分类</a></li>--%>
        <%--<li><a href="javascript:;" id="registrationStatistics" onclick="toEssaySignInInfo()">.报名信息统计</a></li>--%>
        <%--&lt;%&ndash;<li><a href="javascript:;" id="memberStatistics" onclick="toMemberStatistic()">.参赛人员统计</a></li>&ndash;%&gt;--%>
        <%--<li><a href="javascript:;" id="awards_list" onclick="toEssayWInnerList()">.获奖名单 </a></li>--%>
    </ul>
    <div class="tit">
        <a href="javascript:;">专家导读</a>
    </div>
    <ul style="display: none" id="tutor_nav">
        <li><a href="javascript:;" id="tutor_contest" onclick="toManageTutor()">专家导读设置</a></li>
    </ul>
    <div class="tit">
        <a href="javascript:;">校长寄语</a>
    </div>
    <ul style="display: none" id="Headmaster_nav">
        <li><a href="javascript:;" id="message_exchange" onclick="HeadmasterMessage()">校长寄语设置</a></li>
    </ul>
    <div class="tit">
        <a href="javascript:;">拓展阅读书目</a>
    </div>
    <ul style="display: none" id="Expanding_nav">
        <li><a href="javascript:;" id="Expanding_reading" onclick="ExpandingReading()">拓展阅读书目</a></li>
    </ul>
    <div class="tit">
        <a href="javascript:;" id="userManage">系统管理</a>
    </div>
    <ul style="display: none" id="manage_nav">
        <li><a href="javascript:;" id="manage" onclick="userManage()">账号管理</a></li>
    </ul>
    <div class="shrink">
        <a href="javascript:;" id="switchPoint"><img
                src="${pageContext.request.contextPath}/images/readingThought/shousuo.png" alt=""></a>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/commonJs/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/commonJs/CXJSBridge.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/commonJs/urlJump.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/pc/readingThought/pooling.js"></script>
<script type="text/javascript">
    function otherManage() {
        var url = '${pageContext.request.contextPath}/backendAdminController/otherManage';
        return unifiedSkip('', 1, url);
    }
    function readingRecommend() {
        var url = '${pageContext.request.contextPath}/backendAdminController/readingRecommend';
        return unifiedSkip('', 1, url);
    }
    function toEssaySignInInfo() {
        var url = '${pageContext.request.contextPath}/backendAdminController/toEssaySignInInfo';
        return unifiedSkip('', 1, url);
    }
    function tothoughtCount() {
        var url = '${pageContext.request.contextPath}/backendAdminController/toReadingThoughtsStatistics';
        return unifiedSkip('', 1, url);
    }
    function toManagerEssay() {
        var url = '${pageContext.request.contextPath}/backendAdminController/toManageEssay';
        return unifiedSkip('', 1, url);
    }
    function toEssayWInnerList() {
        var appurl = getAppCurUrl();
        var url = appurl + '/backendAdminController/toEssayWinnerList';
        return unifiedSkip('', 1, url);
    }


    function toManageTutor() {
        var url = '${pageContext.request.contextPath}/backendAdminController/toGuideReading';
        return unifiedSkip('', 1, url);
    }

    function toManagerTutorBook() {
        var url = '${pageContext.request.contextPath}/backendAdminController/toManageTutorBook';
        return unifiedSkip('', 1, url);
    }

    function toMemberStatistic() {
        var appurl = getAppCurUrl();
        var url = appurl + '/backendAdminController/toMemberStatistic';
        return unifiedSkip('', 1, url);
    }
    function readingThoughts() {
        var appCurUrl = getAppCurUrl();
        var url = appCurUrl + '/backendAdminController/toPcDayaEssayReadingBooks';
        return unifiedSkip("", 1, url);
    }

    function HeadmasterMessage() {
        var appCurUrl = getAppCurUrl();
        var url = appCurUrl + '/backendAdminController/toSetHeadmasterMessage';
        return unifiedSkip("", 1, url);
    }

    function ExpandingReading() {
        var appCurUrl = getAppCurUrl();
        var url = appCurUrl + '/backendAdminController/toExpandingReading';
        return unifiedSkip("", 1, url);
    }

    function bookDonate() {
        var appCurUrl = getAppCurUrl();
        var url = appCurUrl + '/backendAdminController/toApprovalBookDonation';
        return unifiedSkip("", 1, url);
    }

    function workReview() {
        var url = '${pageContext.request.contextPath}/backendAdminController/toListEssay';
        return unifiedSkip("", 1, url);
    }

    function userManage() {
        var appCurUrl = getAppCurUrl();
        var url = appCurUrl + '/backendAdminController/userManagePage';
        return unifiedSkip("", 1, url);
    }

    function toEssaySystematics() {
        var url = '${pageContext.request.contextPath}/backendAdminController/toEssaySystematics';
        return unifiedSkip('', 1, url);
    }
</script>
</body>
</html>