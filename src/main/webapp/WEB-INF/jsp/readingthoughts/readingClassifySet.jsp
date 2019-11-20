<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>学科领域设置</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/readingThought/secondTableStyle.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/mobile/common/jquery-1.9.1.js"></script>
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
            <div class="content_top">
                <i class="icon"></i>学科领域
                <div class="back" onclick="back()">返回</div>
            </div>
            <div class="content_table">
                <div style="margin: 20px"><a href="#" onclick="addFirstClassify(1);">添加学科领域</a></div>

                <table cellpadding="0" cellspacing="0">
                    <tr>
                        <th width="160">学科领域名称</th>
                        <%--<th width="120">二级分类名称</th>--%>
                        <%--<th width="120">三级分类名称</th>--%>
                        <%--<th width="120">书目数量</th>--%>
                        <th width="120">操作</th>
                    </tr>
                    <c:forEach items="${bookClassificationBos}" var="bookClassification">
                        <tr>
                            <td align="center"><span
                                    style="font-weight: bold;">${bookClassification.firstBookClassificationName}</span>
                            </td>
                            <%--<td align="center">${bookClassification.secondBookClassificationName}</td>--%>
                            <%--<td align="center">${bookClassification.thirdBookClassificationName}</td>--%>
                            <%--<td align="center">${bookClassification.bookCounts}</td>--%>
                            <td align="center">
                                <%--<c:choose>--%>
                                    <%--<c:when test="${bookClassification.firstBookClassificationName != null}">--%>
                                        <%--<a href="javascript:void(0)"--%>
                                           <%--onclick="addFirstClassify(2,'${bookClassification.bookClassificationId}')"--%>
                                           <%--class="cor">添加二级分类</a>--%>
                                    <%--</c:when>--%>
                                    <%--<c:when test="${bookClassification.secondBookClassificationName != null}">--%>
                                        <%--<a href="javascript:void(0)"--%>
                                           <%--onclick="addFirstClassify(3,'${bookClassification.bookClassificationId}')"--%>
                                           <%--class="cor">添加三级分类</a>--%>
                                    <%--</c:when>--%>
                                <%--</c:choose>--%>
                                <a href="javascript:void(0)" class="cor addData"
                                   onclick="bookClassifyRename('${bookClassification.bookClassificationId}','${bookClassification.firstBookClassificationName}','${bookClassification.secondBookClassificationName}','${bookClassification.thirdBookClassificationName}')">设置</a>
                                <a href="javascript:void(0)" class="cor addData"
                                   onclick="bookClassifyDel('${bookClassification.bookClassificationId}')">删除</a>
                                    <%--显示和置顶功能暂时不做 --%> <%--<a href="javascript:void(0)" class="cor addData" onclick="bookClassifyDisplay('${bookClassification.bookClassificationId}')">是否显示</a>--%>
                                    <%--<a href="javascript:void(0)" class="cor addData" onclick="bookClassifyTop('${bookClassification.bookClassificationId}')">置顶</a>--%>
                            </td>
                        </tr>
                    </c:forEach>
                </table>

            </div>
        </div>
    </div>

    <c:import url="footer.jsp"/>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/mobile/common/CXJSBridge.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/mobile/common/urlJump.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/layer/layer.js"></script>
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
</script>

<script>
    function addFirstClassify(rank, bookClassificationId) {
        layer.prompt({
            formType: 2,
            value: '',
            title: '请输入：',
            area: ['200px', '35px'] //自定义文本域宽高
        }, function (value, index, elem) {
            // alert(value); //得到value,输入框里面的值
            var appCurUrl = getAppCurUrl();
            var url = appCurUrl + '/backendAdminController/addBookClassifyTrend?classificationName=' + value + "&classificationRank=" + rank + "&parentClassificationId=" + bookClassificationId;
            value = "";
            layer.close(index);
            return unifiedSkip("", 1, url);
        });
    }

    function back() {
        var appCurUrl = getAppCurUrl();
        var url = appCurUrl + '/backendAdminController/readingRecommend';
        return unifiedSkip("", 1, url);
    }
    function bookClassifyRename(bookClassificationId, firstBookClassificationName, secondBookClassificationName, thirdBookClassificationName) {
        var value = "";
        if (firstBookClassificationName.length > 0) {
            value = firstBookClassificationName;
        } else if (secondBookClassificationName.length > 0) {
            value = secondBookClassificationName;
        } else if (thirdBookClassificationName.length > 0) {
            value = thirdBookClassificationName;
        }

        layer.prompt({
            formType: 2,
            value: value,
            title: '请输入：',
            area: ['200px', '35px'] //自定义文本域宽高
        }, function (value, index, elem) {
            // alert(value); //得到value,输入框里面的值
            var appCurUrl = getAppCurUrl();
            var url = appCurUrl + '/backendAdminController/bookClassifyTrendModify?classificationName=' + value + "&classificationId=" + bookClassificationId;
            value = "";
            layer.close(index);
            return unifiedSkip("", 1, url);
        });
    }

    function bookClassifyDel(bookClassificationId) {
        var appCurUrl = getAppCurUrl();
        var url = appCurUrl + '/backendAdminController/bookClassifyTrendDel?classificationId=' + bookClassificationId;
        return unifiedSkip("", 1, url);
    }

    function bookClassifyDisplay(bookClassificationId) {
        var appCurUrl = getAppCurUrl();
        var url = appCurUrl + '/backendAdminController/bookClassifyTrendModify?classificationId=' + bookClassificationId;
        return unifiedSkip("", 1, url);
    }

    function bookClassifyTop(bookClassificationId) {
        var appCurUrl = getAppCurUrl();
        var url = appCurUrl + '/backendAdminController/bookClassifyTrendTop?classificationId=' + bookClassificationId;
        return unifiedSkip("", 1, url);
    }
</script>
</body>
</html>