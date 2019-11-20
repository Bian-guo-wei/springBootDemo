<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <title>哈工大读本</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/swiper.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/commonJs/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/simpler-sidebar.min.js"></script>
    <script type='text/javascript' src='${pageContext.request.contextPath}/js/mobile/common/CXJSBridge.js'></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/mobile/common/urlJump.js"></script>
</head>
<body>
<c:import url="header.jsp"></c:import>
<div class="ny-banner"></div>
<div class="center ny-main">
    <div class="wrap">
        <div class="title nyTil clearfix">
            <div class="nyTil">哈工大读本</div>
            <a href="javascript:void(0)" onclick="history.back(-1)" class="ny-exit">返回</a>
            <div class="clear"></div>
        </div>
        <div class="clearfix">
            <div class="left">
                <div class="lftTil">经典导读</div>
                <ul class="lftNav">
                    <c:forEach items="${map}" var="map">
                        <li>
                            <div class="lftnav-f">
                                <input type="hidden" value="${map.key}">
                                <a title="${map.value}" href="javascript:void(0);">
                                    ${ fn:length(map.value ) >7 ? fn:substring(map.value ,0,7) : map.value } ${ fn:length(map.value ) >7 ? '.....':''}</a>
                            </div>
                            <div class="lftnav-sub">
                                <a href="javascript:void(0);" onclick="getBooks('${map.key}',2)">基本书目</a>
                                <a href="javascript:void(0);" onclick="getBooks('${map.key}',1)">扩展书目</a>
                            </div>
                                <%--<div class="lftnav-f"><a href="javacript:;">文学与艺术</a></div>--%>
                                <%--<div class="lftnav-sub">--%>
                                <%--<a href="#">基本书目</a>--%>
                                <%--<a href="#">扩展书目</a>--%>
                                <%--</div>--%>
                        </li>
                    </c:forEach>
                </ul>
            </div>
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
        </div>
    </div>
</div>
<c:import url="tail.jsp"></c:import>

<!-- 侧边导航 -->
<div class="sidebar" id="dowebok">
    <div class="sidebar-wrapper" id="sidebar-wrapper">
        <ul class="sildernav">
            <c:forEach items="${map}" var="map">
                <li>
                    <div class="sildernav-til">
                        <input type="hidden" value="${map.key}">
                        <a title="${map.value}" href="javascript:void(0);">
                                ${ fn:length(map.value ) >7 ? fn:substring(map.value ,0,7) : map.value } ${ fn:length(map.value ) >7 ? '.....':''}</a>
                    </div>
                    <div class="sildernav-sub">
                        <a href="javascript:void(0);" onclick="getBooks('${map.key}',2)">基本书目</a>
                        <a href="javascript:void(0);" onclick="getBooks('${map.key}',1)">扩展书目</a>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>

<script type="text/javascript">
    $(".lftnav-f").click(function () {
        var bookClassfiy = $(this).find('input').attr('value');
        var ele = '';
        $.ajax({
            url: getAppCurUrl() + '/test/getBooks',
            type: "POST",
            cache: false,
            dataType: "json",//json--返回json数据类型；xml--返回xml

            data: {
                bookClassify: bookClassfiy,
                book_classification: 0
            },
            success: function (data) {
                var list = data;
//                console.log()
                for (var i = 0; i < list.length; i++) {
                    if(list[i].screenshot !='' && list[i].screenshot != null){
                        ele += '<div class="col-md-2 col-xs-6 boox_cont" >' +
                            '<div class="bookBox">' +
                            '<a href="javascript:void(0)" onclick="toBookDetail(\'' + list[i].id +'\',\''+ list[i].procClassId +'\')">' +
                            '<div class="bookPic">' +
                            '<img src="'+'../../images/uploadImg/'+list[i].screenshot + '">' +
                            '</div>' +
                            '<p class="bookTxt">' + list[i].basicTitle + '</p>' +
                            '</a>' +
                            '</div>' +
                            '</div>'
                    }else {
                        ele += '<div class="col-md-2 col-xs-6 boox_cont" >' +
                            '<div class="bookBox">' +
                            '<a href="javascript:void(0)" onclick="toBookDetail(\'' + list[i].id +'\',\''+ list[i].procClassId +'\')">' +
                            '<div class="bookPic">' +
                            '<img src="../../images/defaultPic.jpg">' +
                            '</div>' +
                            '<p class="bookTxt">' + list[i].basicTitle + '</p>' +
                            '</a>' +
                            '</div>' +
                            '</div>'
                    }

                }
                console.log(ele)

                $("#books").html("");
                $("#books").append(ele);
            }
        })

        var name = $(this).find('a').attr('title');
        if ($(this).parent().hasClass("current")) {
            $(this).next(".lftnav-sub").hide();
            $(this).parent().removeClass("current");
        } else {
            $(".nyTil").html("");
            $(".nyTil").append(name);
            $(this).next(".lftnav-sub").show();
            $(".lftNav li").removeClass("current");
            $(this).parent().addClass("current");
        }
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

    function getBooks(bookClassfiy, book_classification) {
        var ele = '';
        $.ajax({
            url: getAppCurUrl() + '/test/getBooks',
            type: "POST",
            cache: false,
            dataType: "json",//json--返回json数据类型；xml--返回xml

            data: {
                bookClassify: bookClassfiy,
                book_classification: book_classification
            },
            success: function (data) {
                var list = data;
//                console.log()
                for (var i = 0; i < list.length; i++) {
                    if(list[i].screenshot !='' && list[i].screenshot != null){
                        ele += '<div class="col-md-2 col-xs-6 boox_cont" >' +
                            '<div class="bookBox">' +
                            '<a href="javascript:void(0)" onclick="toBookDetail(\'' + list[i].id +'\',\''+ list[i].procClassId +'\')">' +
                            '<div class="bookPic">' +
                            '<img src="'+'../../images/uploadImg/'+ list[i].screenshot + '">' +
                            '</div>' +
                            '<p class="bookTxt">' + list[i].basicTitle + '</p>' +
                            '</a>' +
                            '</div>' +
                            '</div>'
                    }else {
                        ele += '<div class="col-md-2 col-xs-6 boox_cont" >' +
                            '<div class="bookBox">' +
                            '<a href="javascript:void(0)" onclick="toBookDetail(\'' + list[i].id +'\',\''+ list[i].procClassId +'\')">' +
                            '<div class="bookPic">' +
                            '<img src="../../images/defaultPic.jpg">' +
                            '</div>' +
                            '<p class="bookTxt">' + list[i].basicTitle + '</p>' +
                            '</a>' +
                            '</div>' +
                            '</div>'
                    }

                }
                console.log(ele)

                $("#books").html("");
                $("#books").append(ele);
            }
        })
    }

    function toBookDetail(id, classfiyId) {
        var url = getAppCurUrl() + '/test/toBookDetail?id=' + id +'&classfiyId='+classfiyId;
       return unifiedSkip('',1,url);
    }
</script>
</body>
</html>