<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <title>拓展阅读书目</title>
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
            <div class="nyTil">拓展阅读书目</div>
            <a href="javascript:void(0);" onclick="return unifiedSkip('',1,'/test/toIndex')" class="ny-exit">返回</a>
            <div class="clear"></div>
        </div>
        <div class="clearfix">
            <c:import url="left.jsp"></c:import>
            <div class="right clearfix nyRigh">
                <ul class="smList">
                    <c:forEach items="${booksList}" var="list">
                        <li>
                            <div class="smList-til"><a href="javascript:void(0)" onclick="toEssayDetail('${list.uuid}');">${list.title}</a></div>
                            <div class="smList-time">
                                [<fmt:formatDate value="${list.gmtCreate}" pattern="YYYY-MM-dd HH:mm"/>]
                            </div>
                            <p class="smList-txt">
                                ${list.claim}</p>
                        </li>
                    </c:forEach>
                </ul>
                <div class="page">
                    <a href="javascript:void(0)" onclick="skippage(1)">首页</a>
                    <a href="javascript:void(0)" onclick ="skippage(${pageBean.currentPage-1})">上一页</a>
                    <a href="javascript:void (0)" onclick="skippage(${pageBean.currentPage+1})">下一页>></a>
                    <a href="javascript:void (0)" onclick="skippage(${pageBean.totalPage})">尾页</a>
                    <input type="text" id="page" class="pageInput"><a href="javascript:void (0)" onclick="gopage()">跳转</a>
                    <span>${pageBean.currentPage}页/共${pageBean.totalPage}页</span>
                </div>
            </div>
        </div>
    </div>
</div>
<c:import url="tail.jsp"></c:import>
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
<script>
    function skippage(pageNum) {
        if (pageNum > 0 && pageNum <=${pageBean.totalPage}) {
            var appCurUrl = getAppCurUrl();
            var kw = '${kw}';
            var url = appCurUrl + '/test/toExpandedList' + "?currentPage=" + pageNum ;
            return unifiedSkip("", 1, url);
        }

    }

    function gopage() {
        var pageNum = $("#page").val();
        if (pageNum > 0 && pageNum <=${pageBean.totalPage}) {
            var appCurUrl = getAppCurUrl();
            var kw = '${kw}';
            var url = appCurUrl + '/test/toExpandedList' + "?currentPage=" + pageNum;
            return unifiedSkip("", 1, url);
        }

    }

    function  toEssayDetail(uuid) {
       var url = getAppCurUrl() + '/test/getEssayDetail' + '?uuid='+ uuid;
       return unifiedSkip('', 1, url);
    }

</script>
</body>
</html>