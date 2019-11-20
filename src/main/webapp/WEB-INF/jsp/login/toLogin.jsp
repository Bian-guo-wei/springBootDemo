<%--
  Created by IntelliJ IDEA.
  User: ayne
  Date: 12/12/17
  Time: 下午2:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>后台</title>
</head>
<body>
<div class="test">
    <div class="superAdminLogin">
        管理员后台登录
    </div>
    <%--<div class="pcFront">--%>
    <%--pc 端前台--%>
    <%--</div>--%>
    <div class="mobile">
        前台展示
    </div>

</div>
<script type='text/javascript' src='${pageContext.request.contextPath}/js/jquery-1.9.0.min.js' charset='utf-8'></script>
<script type='text/javascript' src='${pageContext.request.contextPath}/js/mobile/common/urlJump.js'
        charset='utf-8'></script>
<script type='text/javascript' src='${pageContext.request.contextPath}/js/mobile/common/CXJSBridge.js'
        charset='utf-8'></script>
<script type="text/javascript">
    $(function () {
        $(".superAdminLogin").click(function () {
            var webUrl = getAppCurUrl();
            var url = "http://passport2.chaoxing.com/wlogin?refer=" + webUrl + "/backendAdminController/loginBackend";
            return unifiedSkip("", 1, url);
        });

        $(".pcFront").click(function () {
            var webUrl = getAppCurUrl();
            var url = webUrl + '/publicController/toReadingPlatformIndex';
            return unifiedSkip("", 1, url);
        });
        $(".mobile").click(function () {
            var webUrl = getAppCurUrl();
            var url = webUrl + '/test/toIndex';
            return unifiedSkip("", 1, url);
        });
    });
</script>
</body>
</html>
