<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
    <meta charset=utf-8"/>
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <title>${classicBooks.basicTitle}</title>
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
            <div class="nyTil">${classfiyName}</div>
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
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="right clearfix nyRigh" id="detail">
                <div class="clearfix tsny-hd">
                    <c:choose>
                        <c:when test="${classicBooks.screenshot != '' && classicBooks.screenshot != null}">
                            <div class="tsny-lft"><img src="${pageContext.request.contextPath}/images/uploadImg/${classicBooks.screenshot}"></div>
                        </c:when>
                        <c:otherwise>
                            <div class="tsny-lft"><img src="${pageContext.request.contextPath}/images/defaultPic.jpg">
                            </div>
                        </c:otherwise>
                    </c:choose>
                    <div class="tsny-rg">
                        <div class="tsny-bookname">${classicBooks.basicTitle}</div>
                        <c:if test="${classicBooks.basicCreator !=null && classicBooks.basicCreator != ''}">
                            <dl class="tsny-info">
                                <dt>［作者］</dt>
                                <dd>${classicBooks.basicCreator}</dd>
                            </dl>
                        </c:if>
                        <c:if test="${classicBooks.basicTitle !=null && classicBooks.basicTitle != ''}">
                            <dl class="tsny-info">
                                <dt>［丛书名］</dt>
                                <dd>${classicBooks.basicTitle}</dd>
                            </dl>
                        </c:if>
                        <c:if test="${classicBooks.basicDate !=null && classicBooks.basicDate != ''}">
                            <dl class="tsny-info">
                                <dt>［出版日期］</dt>
                                <dd>${classicBooks.basicDate}</dd>
                            </dl>
                        </c:if>
                        <c:if test="${classicBooks.basicPublisher !=null && classicBooks.basicPublisher != ''}">
                            <dl class="tsny-info">
                                <dt>［出版社］</dt>
                                <dd>${classicBooks.basicPublisher}</dd>
                            </dl>
                        </c:if>
                        <c:if test="${classicBooks.basicPage !=null && classicBooks.basicPage != ''}">
                            <dl class="tsny-info">
                                <dt>［页码］</dt>
                                <dd>${classicBooks.basicPage}</dd>
                            </dl>
                        </c:if>
                        <c:if test="${classicBooks.basicKeyword !=null && classicBooks.basicKeyword != ''}">
                            <dl class="tsny-info">
                                <dt>［主题词］</dt>
                                <dd>${classicBooks.basicKeyword}</dd>
                            </dl>
                        </c:if>
                        <c:if test="${classicBooks.originalProjectResId !=null && classicBooks.originalProjectResId != ''}">
                            <dl class="tsny-info">
                                <dt>［ISBN］</dt>
                                <dd>${classicBooks.originalProjectResId}</dd>
                            </dl>
                        </c:if>
                        <c:if test="${classicBooks.viewElements != null && classicBooks.viewElements != ''}">
                            <dl class="tsny-info">
                                <dt>［摘要］</dt>
                                <dd>${classicBooks.viewElements}</dd>
                            </dl>
                        </c:if>

                    </div>
                    <div class="clear"></div>
                    <div class="tsny-op">
                        <c:if test="${classicBooks.cnkiYycount!=null && classicBooks.cnkiYycount!=''}">
                            <a href="/test/fileDownload?fileName=${classicBooks.cnkiYycount}" id="down"  download="${classicBooks.basicTitle}">下载全文</a>
                        </c:if>
                        <a href="${classicBooks.procFileLink}">全文链接</a>
                        <a href="${classicBooks.detaiurl}">去当当购买</a>
                        <a href="${classicBooks.avenue}">去亚马逊购买</a>
                        <a href="${classicBooks.warePageView}">去豆瓣看</a>
                    </div>
                </div>
                <p class="ydTxt">${classicBooks.basicDescription}</p>
                <div class="tsny-op">
                    <c:if test="${classicBooks.wfYycount!=null && classicBooks.wfYycount!=''}">
                        <a href="/test/fileDownload?fileName=${classicBooks.wfYycount}">导读课件</a>
                    </c:if>
                    <c:if test="${classicBooks.cqvipYycount!=null && classicBooks.cqvipYycount!=''}">
                        <a href="/test/fileDownload?fileName=${classicBooks.cqvipYycount}">讲解材料</a>
                    </c:if>

                </div>
            </div>

            <div class="right clearfix" id="books">

            </div>

        </div>
    </div>
</div>
<!-- footer -->
<c:import url="tail.jsp"></c:import>

<script type="text/javascript">
    //    $(function () {
    //        $(".lftnav-f").click(function () {
    //            if ($(this).parent().hasClass("current")) {
    //                $(this).next(".lftnav-sub").hide();
    //                $(this).parent().removeClass("current");
    //            } else {
    //                $(this).next(".lftnav-sub").show();
    //                $(".lftNav li").removeClass("current");
    //                $(this).parent().addClass("current");
    //            }
    //        })
    //    })

    $(".lftnav-f").click(function () {

        var bookClassfiy = $(this).find('input').attr('value');
        console.log(bookClassfiy)
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

                    if (list[i].screenshot != '' && list[i].screenshot != null) {
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
                    } else {
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

                $("#detail").html("")
                $("#books").html("");
                $("#books").append(ele);
            }
        })

        var name = $(this).find('a').attr('title');
        console.log(name)
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

                    if (list[i].screenshot != '' && list[i].screenshot != null) {
                        ele += '<div class="col-md-2 col-xs-6 boox_cont" >' +
                            '<div class="bookBox">' +
                            '<a href="javascript:void(0)" onclick="toBookDetail(\'' + list[i].id +'\',\''+ list[i].procClassId +'\')">' +
                            '<div class="bookPic">' +
                            '<img src="'+'../../images/uploadImg/' + list[i].screenshot + '">' +
                            '</div>' +
                            '<p class="bookTxt">' + list[i].basicTitle + '</p>' +
                            '</a>' +
                            '</div>' +
                            '</div>'
                    } else {
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

                $("#detail").html("")
                $("#books").html("");
                $("#books").append(ele);
            }
        })
    }

    function toBookDetail(id,classfiyId) {
        var url = getAppCurUrl() + '/test/toBookDetail?id=' + id +'&classfiyId='+classfiyId;
        return unifiedSkip('', 1, url);
    }

    <%--function downLoad(obj) {--%>
        <%--window.location.href = '/test/fileDownload?fileName=${classicBooks.cnkiYycount}';--%>

    <%--}--%>

</script>
</body>
</html>