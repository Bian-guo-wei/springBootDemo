<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <title>拓展阅读书目内容</title>
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
            <div class="nyTil">${essayInfoHistoryPo.title}</div>
            <a href="javascript:void(0);" onclick="history.back(-1)" class="ny-exit">返回</a>
            <div class="clear"></div>
        </div>
        <div class="clearfix">
            <%--<c:import url="left.jsp"></c:import>--%>
            <div class="right clearfix" id="books">
                <c:forEach items="${list}" var="list">
                    <div class="col-md-2 col-xs-6 boox_cont">
                        <div class="bookBox">
                            <a href="javascript:void(0)" onclick="toBookDetail('${list.id}','${list.procClassId}')">
                                <div class="bookPic">
                                    <c:choose>
                                        <c:when test="${list.screenshot !='' && list.screenshot != null}">
                                            <img src="${pageContext.request.contextPath}/images/uploadImg/${list.screenshot}">
                                        </c:when>
                                        <c:otherwise>
                                            <img src="${pageContext.request.contextPath}/images/defaultPic.jpg">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <p class="bookTxt">${list.basicTitle}</p>
                            </a>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="right clearfix nyRigh">
                <p class="ydTxt">
                ${essayInfoHistoryPo.detail}
                </p>
            </div>
        </div>
    </div>
</div>
<!-- footer -->
<c:import url="tail.jsp"></c:import>
<!-- 侧边导航 -->

<script type="text/javascript">
    $(function () {
        $(".lftnav-f").click(function () {
            if ($(this).parent().hasClass("current")) {
                $(this).next(".lftnav-sub").hide();
                $(this).parent().removeClass("current");
            } else {
                $(this).next(".lftnav-sub").show();
                $(".lftNav li").removeClass("current");
                $(this).parent().addClass("current");
            }
        })
    })
</script>
<script>
    $(function () {
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