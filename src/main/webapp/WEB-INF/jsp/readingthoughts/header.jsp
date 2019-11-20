<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>header</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/readingThought/header.css">
</head>
<body>
<div class="header" id="header">
    <img id="topImg" src="${pageContext.request.contextPath}/images/readingThought/admin_logo.jpg" alt="">
    <div class="fr">
        <%--<a href="javascript:void(0)" target="_blank" onclick="toIndex()">查看前台</a>--%>
        <span class="welcome">欢迎您
            <%--<c:choose>--%>
                <%--<c:when test="${sessionScope.adminLoginSessionKey.realName == 'admin' ||sessionScope.adminLoginSessionKey.realName == 'gw'}">--%>
                    <%--JALIS阅读推广平台管理员--%>
                <%--</c:when>--%>
                <%--<c:otherwise>--%>
                    ${sessionScope.adminLoginSessionKey.realName}
                <%--</c:otherwise>--%>
            <%--</c:choose>--%>
        </span>
        <a href="javascript:void(0)" onclick="adminLoginOut()">退出</a>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/commonJs/jquery-1.9.0.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/js/pc/readingThoughtsFront/toIndex.js"></script>
<script type="text/javascript">
    var adminLoginOutUrl = "${pageContext.request.contextPath}/backendAdminController/toLoginBackend";

    //session释放
    function adminLoginOut() {
        window.location.href = adminLoginOutUrl;
    }
</script>
</body>
</html>