<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/swiper.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/commonJs/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/swiper.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/mobile/common/CXJSBridge.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/mobile/common/urlJump.js"></script>
</head>
<body>
<div class="header">
    <div class="center clearfix">
        <div class="logo"><img src="${pageContext.request.contextPath}/images/logo.png"></div>
        <div class="nav">
            <a href="javascript:void(0);" onclick="return unifiedSkip('',1,'/test/toWeilcome')">校长寄语</a>
            <a href="javascript:void(0);" onclick="return unifiedSkip('',1,'/test/toTextBooks')">哈工大读本</a>
            <a href="javascript:void(0);" onclick="return unifiedSkip('',1,'/test/toExpertIntroduction')">专家导读</a>
            <a href="javascript:void(0);" onclick="return unifiedSkip('',1,'/test/toExpandedList')">拓展阅读书目</a>
        </div>
    </div>
</div>
<div class="banner"></div>
<div class="center main">
    <div class="wrap">
        <div class="title clearfix">
            <div class="pull-left til-left">经典导读</div>
            <a href="javascript:void(0)" onclick="return unifiedSkip('',1,'/test/toTextBooks')"
               class="pull-right til-more">更多</a>
            <div class="clear"></div>
            <%--<div class="til-nav" style="height: 25px;overflow: hidden;">--%>
            <div class="til-nav" >
                <c:forEach items="${map}" var="map">
                    <a href="javascript:void(0)" onclick="getBooks('${map.key}')">${ fn:length(map.value ) >6 ? fn:substring(map.value ,0,6) : map.value } ${ fn:length(map.value ) >6 ? '....':''}</a>
                </c:forEach>
            </div>
        </div>
        <c:if test="${list1.size() > 0 }">
            <div class="slideCont">
                <div class="swiper-father">
                    <div class="swiper-container">

                        <div class="swiper-wrapper">
                            <c:forEach begin="0" end="8" items="${list1}" var="list">
                                <div class="swiper-slide">
                                    <div class="bookInfo clearfix">
                                        <a href="javascript:void(0)"
                                           onclick="toBookDetail('${list.id}','${list.procClassId}')">
                                            <div class="pull-left booInfo-img">
                                                <c:choose>
                                                    <c:when test="${list.screenshot !='' && list.screenshot != null}">
                                                        <img src="${pageContext.request.contextPath}/images/uploadImg/${list.screenshot}">
                                                    </c:when>
                                                    <c:otherwise>
                                                        <img src="${pageContext.request.contextPath}/images/defaultPic.jpg">
                                                    </c:otherwise>
                                                </c:choose>
                                            </div>
                                            <div class="pull-left bookInfo-txt">
                                                <div class="bookName"><a href="javascript:void(0)"
                                                                         onclick="toBookDetail('${list.id}','${list.procClassId}')">${list.basicTitle}</a>
                                                </div>
                                                <p class="bookJs">作者：${list.basicCreator}</p>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>

                        <!-- Add Pagination -->
                        <div class="swiper-pagination"></div>

                    </div>
                    <!-- Add Arrows -->
                    <div class="swiper-button-next"></div>
                    <div class="swiper-button-prev"></div>
                </div>

            </div>
        </c:if>
        <c:if test="${list2.size() > 0}">
            <div class="index_list clearfix">
                <c:forEach begin="0" end="11" items="${list2}" var="list2">
                    <div class="col-md-2 col-xs-6 boox_cont">
                        <div class="bookBox">
                            <a href="javascript:void(0)" onclick="toBookDetail('${list2.id}','${list2.procClassId}')">
                                <div class="bookPic">
                                    <c:choose>
                                        <c:when test="${list2.screenshot !='' && list2.screenshot != null}">
                                            <img src="${pageContext.request.contextPath}/images/uploadImg/${list2.screenshot}">
                                        </c:when>
                                        <c:otherwise>
                                            <img src="${pageContext.request.contextPath}/images/defaultPic.jpg">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <p class="bookTxt">${list2.basicTitle}</p>
                            </a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:if>
    </div>
</div>
<c:import url="tail.jsp"></c:import>
<script>
    var one = 1;
    var three = 3;
    var num;
    var flag;
    var screenWidth = $(window).width();
    if (screenWidth < 980) {
        num = one;
        flag = false;
    } else {
        num = three;
        flag = true;
    }
    ;
    var swiper = new Swiper('.swiper-container', {
        slidesPerView: num,
        spaceBetween: 20,
        slidesPerGroup: num,
        loop: false,
        loopFillGroupWithBlank: true,
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
        },
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',

        },
    });

    if (screenWidth < 980) {
        swiper.navigation.$nextEl.addClass('hide');
        swiper.navigation.$prevEl.addClass('hide');
    } else {
        swiper.navigation.$nextEl.removeClass('hide');
        swiper.navigation.$prevEl.removeClass('hide');
    }
    ;


</script>

<script>
    function getBooks(obj) {
        var url = getAppCurUrl() + '/test/toTextBooks?classfiyId=' + obj;
        return unifiedSkip('', 1, url);
    }

    function toBookDetail(id, classfiyId) {
        var url = getAppCurUrl() + '/test/toBookDetail?id=' + id + '&classfiyId=' + classfiyId;
        return unifiedSkip('', 1, url);
    }

</script>
</body>
</html>