<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/commonJs/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/online.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/zebra_dialog.css" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/zebra_dialog.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/layer/layer.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/mobile/common/urlJump.js"></script>
    <title>后台登录</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/login.css"/>
    <script type="text/javascript">
        //<![CDATA[
        var pcpath = '${pageContext.request.contextPath}';
        var basicURL = "${ADMIN_URL}/publicUser/sspLogin";
        var managerURL = "${pageContext.request.contextPath}/NECBSTaskPool/NECBSTaskPool_toNoveltyEntrustList";
        var financeURL = "${pageContext.request.contextPath}/finance/finance_toNoveltyEntrustFinance";
        var loginOut = "${pageContext.request.contextPath}/publicUser/loginOut";
        var isLogin = "${loginUserINFO}";
        var roleId = "${loginUserINFO.roleId}";
        $(function () {

            $("#login").click(function () {


                if($.trim($("#username").val()) == '' || $.trim($("#password").val()) == ''){
                    layer.msg("请输入用户名和密码")
                }else if($.trim($("#randomCode").val()) == ''){
                    layer.msg("请输入验证码")
                }else {
                    $.ajax({
                        type: "post",
                        dataType: "json",
                        url: "${pageContext.request.contextPath}/backendAdminController/loginBackend",
                        data: {
                            userName: $.trim($("#username").val()),
                            password: $.trim($("#password").val()),
                            userType: 2,
                            randomCode: $.trim($("#randomCode").val()),
                        },
                        success: function (data) {
                            var appurl = getAppCurUrl();
                            var url = appurl + '/backendAdminController/toLoginBackend';
                            var url2 =appurl + '/backendAdminController/readingRecommend';
                            if ("1001" == data) {
                                layer.msg('用户名密码输入错误', {time: 2000}, function () {
                                    return unifiedSkip('', 1, url)
                                });
                            }else if ("1002" == data){
                                layer.msg('验证码输入错误', {time: 2000}, function () {
                                    return unifiedSkip('', 1, url)
                                });
                            }else if("1003" == data) {
                                layer.msg('登录成功', {time: 2000}, function () {
                                    return unifiedSkip('', 1, url2)
                                });
                            }else {
                                layer.msg('登录错误次数达到上限，请稍后登录！')
                            }
                        }
                    });
                }
            });
            //session释放
            $("#loginOut").click(function () {
                window.location.href = loginOut;
            });

            $('#username').focus();
            $('#username').keydown(function (event) {
                if (event.keyCode == 13) {
                    $('#password').focus();
                    return;
                }
            });
            $('#password').keydown(function (event) {
                if (event.keyCode == 13 || event.keyCode == 9) {
                    $('#randomCode').focus();
                }
            });
            $('#randomCode').keydown(function (event) {
                if (event.keyCode == 13 || event.keyCode == 9) {
                    $('#login').focus();
                }
            });
        });

        function changeImg() {
            $("#validatecodeimg").attr("src", Math.round(Math.random() * 10000) + ".RandomCode");
        }
        function doEnableLink() {
            var link = document.getElementById("login");
            link.disabled = false;
            link.onclick = doClick;
        }
        //]]>
    </script>
</head>

<body style="font:12px/1.5 宋体, Arial, Helvetica, sans-serif;color:#333;background:#0094da;">
<div align="center" style="background:url(${pageContext.request.contextPath}/images/body_bg.gif) repeat-x left bottom">
    <div class="box" style="background:url(/images/login_bg.png) repeat;">
        <h1></h1>

        <div class="con">
            <b class="icons"></b>

            <div class="login" style="font-family: '宋体'">
                <table cellpadding="0" cellspacing="0">
                    <tr>
                        <td width="65" align="center">用户名：</td>
                        <td align="left"><input type="text" class="txt" name="username" id="username"/></td>
                    </tr>
                    <tr>
                        <td width="65" align="center">密 码：</td>
                        <td align="left"><input type="password" class="txt" name="password" id="password"/></td>
                    </tr>
                    <tr>
                        <td width="65" align="center">验证码：</td>
                        <td align="left"><input type="text" class="txt" id="randomCode" style="width:80px;float:left;"/>
                            <img id="validatecodeimg" alt="看不清？刷新" onclick="javascript:changeImg()"
                                 src="first.RandomCode" align="top"/> <a href="javascript:changeImg()">看不清？刷新</a></td>
                    </tr>
                    <tr>
                        <td width="65" align="right"><br/> <br/></td>
                        <td align="left"><input type="button" class="btn" value="登 录" id="login"/></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <c:import url="/WEB-INF/jsp/login/tail.jsp"/>
</div>

</body>
</html>
