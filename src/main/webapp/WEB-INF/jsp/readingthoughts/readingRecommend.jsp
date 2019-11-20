<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<head>
    <meta charset="UTF-8">
    <title>书目管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/readingThought/essayContest.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/commonJs/jquery-1.9.1.js"></script>
</head>
<body>
<div class="reading_wrap">
    <c:import url="header.jsp"/>
    <div class="content_wrap">
        <c:import url="navBar.jsp"/>
        <script>
            $('#readingRecommend').addClass('active');
            $('#redaing_nav').show();
        </script>
        <!--内容区-->
        <div class="main_content">
            <div class="content_top"><i class="icon"></i>经典书目</div>
            <div class="content_search">
                <div >
                    选择活动：
                    <select name="" id="essayChoose" class="essayChoose">
                        <c:forEach items="${essayList}" var="list">
                            <%--<c:choose>--%>
                                <%--<c:when test="${list.uuid} = ${uuid}">--%>
                                    <%--<option value="${list.uuid}" selected="selected">${list.title}</option>--%>
                                <%--</c:when>--%>
                                <%--<c:otherwise>--%>
                                    <%--<option value="${list.uuid}">${list.title}</option>--%>
                                <%--</c:otherwise>--%>
                            <%--</c:choose>--%>
                            <option value="${list.uuid}" id="${list.uuid}">${list.title}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="button">
                    <input type="button" value="查找" onclick="lookUpByEssay()">
                </div>
            </div>
            <div class="content_search">
                <div class="college">
                    书名<input type="text" value="" id="bookName">
                </div>
                <div class="classify bgcolor-3">
                    类型：
                    <select name="" id="select">
                        <option value="">全部</option>
                        <option value="1">扩展书目</option>
                        <option value="2">基本书目</option>
                    </select>
                </div>
                <div class="button">
                    <input type="button" value="查找" onclick="lookUpByClassify()">
                </div>
                <div class="button">
                    <input type="button" value="导入" onclick="importClassicBooksPage()">
                </div>
                <div class="button">
                <input type="button" value="添加分类" onclick="addBookClassify()">
                </div>
            </div>
            <div class="content_table">
                <table cellpadding="0" cellspacing="0">
                    <tr>
                        <th width="160">作品名称</th>
                        <th width="120">类型</th>
                        <th width="120">学科领域</th>
                        <th width="120">作者</th>
                        <th width="120">状态</th>
                        <th width="120">操作</th>
                    </tr>
                    <c:forEach items="${classicBooksPageBean.list}" var="classicBook">
                        <tr>
                            <td align="center"><span style="font-weight: bold;">${classicBook.basicTitle}</span></td>
                            <c:choose>
                                <c:when test="${classicBook.bookClassification == 1}">
                                    <td align="center">扩展书目</td>
                                </c:when>
                                <c:otherwise>
                                    <td align="center">基本书目</td>
                                </c:otherwise>
                            </c:choose>
                            <td align="center">${classicBook.procClassId}</td>
                            <td align="center">${classicBook.basicCreator}</td>
                            <c:choose>
                                <c:when test="${classicBook.isDisplay == 0}">
                                    <td id="diplay${classicBook.id}" align="center">展示</td>
                                </c:when>
                                <c:otherwise>
                                    <td id="display${classicBook.id}" align="center">不展示</td>
                                </c:otherwise>
                            </c:choose>

                            <td align="center">
                                <a href="javascript:void(0)" onclick="delClassiclBookDisplay(${classicBook.id})"
                                   class="cor addData">删除</a>
                                <c:choose>
                                    <c:when test="${classicBook.isDisplay == 1}">
                                        <a href="javascript:void(0)"
                                           onclick="updateClassiclBookDisplay(${classicBook.id},0)"
                                           class="cor">展示</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="javascript:void(0)"
                                           onclick="updateClassiclBookDisplay(${classicBook.id},1)"
                                           class="cor">不展示</a>
                                    </c:otherwise>
                                </c:choose>

                                <a href="javascript:void(0)" onclick="updateClassiclBook(${classicBook.id})"
                                   class="cor addData">修改</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <!--分页-->
                <div class="pages">
                    <div class="">共${classicBooksPageBean.totalData}条记录</div>
                    <div class="">${classicBooksPageBean.currentPage}/${classicBooksPageBean.totalPage}</div>
                    <div class="first_page" onclick="skippage(1)">第一页</div>
                    <div class="pre_page" onclick="skippage(${classicBooksPageBean.currentPage-1})">上一页</div>
                    <ul class="pages_list" id="pages_list">
                    </ul>
                    <div class="next_page" onclick="skippage(${classicBooksPageBean.currentPage+1})">下一页</div>
                    <div class="last_page" onclick="skippage(${classicBooksPageBean.totalPage})">最后一页</div>
                    <div class="to_numpages">到第<input type="text" id="page">页</div>
                    <div class="sure_go" onclick="gopage()"><input type="button" value="GO" id="sure"></div>
                </div>
            </div>
        </div>
    </div>

    <c:import url="footer.jsp"/>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        var $windowH = window.innerHeight,
            $headH = $('#header').outerHeight(),
            $footH = $('#footer').height();
        var $menuW = $('.navigation_menu').width(),
            $bodyW = $('body').width();
        if ($('.main_content').height() < ($windowH - $headH - $footH)) {
            $('#navigation_menu').height(($windowH - $headH - $footH) + 'px');
        }

        $('.main_content').width(($bodyW - 165) + 'px');
//            $('.main_content').height(($windowH-$headH-$footH)+'px');
    })

    $(document).ready(function (){
        $("#essayChoose option[value= '${uuid}']").attr("selected","selected");
    })
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/commonJs/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/commonJs/CXJSBridge.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/commonJs/urlJump.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/layer/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/pageTabs.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        var totalP =${classicBooksPageBean.totalPage};
        var pageP =${classicBooksPageBean.currentPage};
        pageInit(totalP, pageP);
        toPage(totalP, pageP);
    });
    function skippage(pageNum) {
        if (pageNum > 0 && pageNum <=${classicBooksPageBean.totalPage}) {
            var appCurUrl = getAppCurUrl();
            var url = appCurUrl + '/backendAdminController/readingRecommend'
                + "?currentPage=" + pageNum + "&totalPage=${classicBooksPageBean.totalPage}&totalData=${classicBooksPageBean.totalData}";
            return unifiedSkip("", 1, url);
        }
    };
    function gopage() {
        var pageNum = $("#page").val();
        if (pageNum > 0 && pageNum <=${classicBooksPageBean.totalPage}) {
            var appCurUrl = getAppCurUrl();
            var url = appCurUrl + '/backendAdminController/readingRecommend'
                + "?currentPage=" + pageNum + "&totalPage=${classicBooksPageBean.totalPage}&totalData=${classicBooksPageBean.totalData}";
            return unifiedSkip("", 1, url);
        }
    }
</script>
<script type="text/javascript">
    function delClassiclBookDisplay(id) {
        var url = '${pageContext.request.contextPath}/backendAdminController/delClassiclBookDisplay?currentPage=${classicBooksPageBean.currentPage}&id=' + id;
        if (confirm("确认删除")) {
            return unifiedSkip('', 1, url);
        }
    }
    function lookUpByClassify() {
        var bookClassify = $("#select option:selected").val();
        var bookName = $("#bookName").val();
        var url = '${pageContext.request.contextPath}/backendAdminController/readingRecommend?book_classification=' + bookClassify + '&book_name=' + bookName;
        return unifiedSkip('', 1, url);
    }

    function lookUpByEssay(){
        var essayId = $("#essayChoose option:selected").val();
        var url = '${pageContext.request.contextPath}/backendAdminController/readingRecommend?uuid=' + essayId;
        return unifiedSkip('', 1, url);
    }

    function addBookClassify() {
    var url = '${pageContext.request.contextPath}/backendAdminController/addBookClassify';
    return unifiedSkip('', 1, url);
    }

    function importClassicBooksPage() {
        var url = '${pageContext.request.contextPath}/backendAdminController/importBooksPage';
        return unifiedSkip('', 1, url);
    }

    function updateClassiclBookDisplay(id, display) {
        var url = '${pageContext.request.contextPath}/backendAdminController/modifyClassiclBookDisplay?id=' + id + "&isDisplay=" + display;
        $.ajax({
            url: url,
            type: "post",
            dataType: "json",
            success: function (data) {
                window.location.reload();
                // alert(data);
                // if("1" == data) {
                //     $("#display"+id).html("不展示");
                // } else if("0" == data) {
                //     $("#display"+id).html("展示");
                // } else {
                //     alert("错误");
                // }
            }
        });
    }

    function updateClassiclBook(id) {
        var url = '${pageContext.request.contextPath}/backendAdminController/toUpdateClassiclBookPage?id=' + id;
        return unifiedSkip('', 1, url);
    }
</script>
</body>
</html>