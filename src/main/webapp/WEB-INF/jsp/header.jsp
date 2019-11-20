<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/swiper.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/commonJs/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/simpler-sidebar.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/mobile/common/CXJSBridge.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/mobile/common/urlJump.js"></script>
</head>
<body>
<div class="header">
    <div class="center clearfix">
        <div class="sidebar-icn">
            <span id="toggle-sidebar"></span>
        </div>
        <div class="logo"  onclick="return unifiedSkip('',1,'/test/toIndex')"><img src="../../images/logo.png"></div>
        <div class="nav">
            <a href="javascript:void(0);" onclick="return unifiedSkip('',1,'/test/toWeilcome')">校长寄语</a>
            <a href="javascript:void(0);" onclick="return unifiedSkip('',1,'/test/toTextBooks')">哈工大读本</a>
            <a href="javascript:void(0);" onclick="return unifiedSkip('',1,'/test/toExpertIntroduction')">专家导读</a>
            <a href="javascript:void(0);" onclick="return unifiedSkip('',1,'/test/toExpandedList')">拓展阅读书目</a>
        </div>
    </div>
</div>

<script type="text/javascript">

</script>
<script>
</script>
</body>
</html>