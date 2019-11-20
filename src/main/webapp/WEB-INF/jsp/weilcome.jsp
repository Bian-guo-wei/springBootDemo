<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <title>校长寄语</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/swiper.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/commonJs/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/simpler-sidebar.min.js"></script>
</head>
<body>
    <c:import url="header.jsp"></c:import>
    <div class="ny-banner"></div>
    <div class="center ny-main">
        <div class="wrap">
            <div class="title nyTil clearfix">
                <div class="nyTil">校长寄语</div>
                <a href="javascript:void(0);" onclick="return unifiedSkip('',1,'/test/toIndex')" class="ny-exit">返回</a>
                <div class="clear"></div>
            </div>
            <div class="clearfix">
                <c:import url="left.jsp"></c:import>
                <div class="right clearfix nyRigh">
                    <p class="ydTxt">${headmasterMessage.headmasterMessage}</p>
                 </div>
            </div>
        </div>
    </div>
   <c:import url="tail.jsp"></c:import>
    <!-- 侧边导航 -->
    <div class="sidebar" id="dowebok">
        <div class="sidebar-wrapper" id="sidebar-wrapper">
            <ul class="sildernav">
                <li>
                    <div class="sildernav-til"><a href="#">哲学与伦理</a></div>
                </li>
                <li>
                    <div class="sildernav-til"><a href="#">经济与社会</a></div>
                </li>
                <li>
                    <div class="sildernav-til"><a href="#">数理与工程</a></div>
                </li>
                <li>
                    <div class="sildernav-til"><a href="#">跨文化视野与领导力</a></div>
                </li>
            </ul>
        </div>
    </div>
    <script type="text/javascript">
        $(function(){
            $(".lftnav-f").click(function(){
                if ($(this).parent().hasClass("current")) {
                    $(this).next(".lftnav-sub").hide();
                    $(this).parent().removeClass("current");
                }else{
                    $(this).next(".lftnav-sub").show();
                    $(".lftNav li").removeClass("current");
                    $(this).parent().addClass("current");
                }
            })
        })
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