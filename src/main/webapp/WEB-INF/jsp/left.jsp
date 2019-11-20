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
<div class="left">
    <ul class="lftNav">
        <li>
            <div class="lftnav-f"><a href="javascript:void(0);" onclick="return unifiedSkip('',1,'/test/toWeilcome')">校长寄语</a></div>
        </li>
        <li>
            <div class="lftnav-f"><a href="javascript:void(0);" onclick="return unifiedSkip('',1,'/test/toExpertIntroduction')">专家导读</a></div>
        </li>
        <li>
            <div class="lftnav-f"><a href="javascript:void(0);" onclick="return unifiedSkip('',1,'/test/toExpandedList')">拓展阅读书目</a></div>
        </li>
    </ul>
</div>

<script type="text/javascript">
//    $(function(){
//        $(".lftnav-f").click(function(){
//            if ($(this).parent().hasClass("current")) {
//                $(this).next(".lftnav-sub").hide();
//                $(this).parent().removeClass("current");
//            }else{
//                $(this).next(".lftnav-sub").show();
//                $(".lftNav li").removeClass("current");
//                $(this).parent().addClass("current");
//            }
//        })
//    })
</script>
<script>
    $(function() {
        $('#dowebok').simplerSidebar({
            opener: '#toggle-sidebar',
            sidebar: {
                align: 'right',
                width: 200
            }
        });
    });
</script>
</body>
</html>