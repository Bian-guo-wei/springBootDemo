<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>系统--修改账号</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/readingThought/essayMessagePubilsh.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/readingThought/daterangepicker.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/readingThought/crop/cropper.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/readingThought/crop/ImgCropping.css">
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/js/mobile/common/jquery-1.9.1.js"></script>--%>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/js/pc/readingThought/jquery-2.1.1.js"></script>
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
</head>
<body>
<div class="reading_wrap">
    <c:import url="header.jsp"/>
    <div class="content_wrap">
        <c:import url="navBar.jsp"/>
        <script>
            $('#manage').addClass('active');
            $('#manage_nav').show();
        </script>
        <!--内容区-->
        <div class="main_content">

            <div class="content_top">
                <i class="icon"></i>系统--修改账号
                <div class="back">返回</div>
            </div>
            <div class="UserAdminbox">
                <input type="hidden" id="userId" value="${administratorPo.id}">
                <div class="right">
                    <span style="color: red;">*</span>
                    用户名：<input type="text" id="name" value="${administratorPo.phone}">
                </div>

                <div class="right">
                    <span style="color: red;">*</span>
                    密码：<input type="password" id="password" value="${administratorPo.ppPwd}">
                </div>
                <div class="right">
                    <span style="color: red;">*</span>
                    请再次输入密码：<input type="password" id="password2">
                </div>
                <div class="right">
                    <span style="color: red;">*</span>
                    真实姓名：<input type="text" id="realName" value="${administratorPo.realName}">
                </div>

                <div class="adminButton">
                    <input type="button" value="修改" onclick="publish()">
                </div>
            </div>
            <div style="color: #fc2132;padding-left: 250px;padding-top: 50px;font-size: 15px">
                温馨提示：密码的长度须大于8位，含字母（大小写）、数字及符号组合
            </div>
        </div>
    </div>
    <input type="hidden" id="imgurl">
    <c:import url="footer.jsp"/>
</div>
<%--<script type="text/javascript" src="${pageContext.request.contextPath}/js/mobile/common/jquery-1.9.1.js"></script>--%>
<script type='text/javascript' src='${pageContext.request.contextPath}/js/mobile/common/CXJSBridge.js'></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/mobile/common/urlJump.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/js/pc/readingThought/date/moment.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/layer/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/pc/readingThought/cropper.min.js"></script>
<script>

    //弹出框水平垂直居中
    (window.onresize = function () {
        var win_height = $(window).height();
        var win_width = $(window).width();
        if (win_width <= 768) {
            $(".tailoring-content").css({
                "top": (win_height - $(".tailoring-content").outerHeight()) / 2,
                "left": 0
            });
        } else {
            $(".tailoring-content").css({
                "top": (win_height - $(".tailoring-content").outerHeight()) / 2,
                "left": (win_width - $(".tailoring-content").outerWidth()) / 2
            });
        }
    })();


</script>
<script type="text/javascript">




    function publish() {
        var userId = $("#userId").val();
        var name = $("#name").val();
        var password = $("#password").val();
        var password2 = $("#password2").val();
        var realName = $("#realName").val();
        if (name === ''){
            layer.msg('请输入用户名', {time: 2000});
            return;
        }

        if (password === ''){
            layer.msg('请输入密码', {time: 2000});
            return;
        }
        if (password2 === ''){
            layer.msg('请输入确认密码', {time: 2000});
            return;
        }
        if (realName === ''){
            layer.msg('请输入真实姓名', {time: 2000});
            return;
        }

        if(password2 == password){
            var userInfo = {
                id:userId,
               phone:name,
                ppPwd:password,
                realName:realName
            }
        }else {
            layer.msg('两次密码输入不同', {time: 2000});
            return;
        }

        if(password.length < 8){
            layer.msg('密码长度需要大于8位', {time: 2000});
            return;
        }

            var userStr = escape(escape(JSON.stringify(userInfo)));
            $.ajax({
                url: '${pageContext.request.contextPath}/backendAdminController/updateUser',
                type: "POST",
                dataType: 'json',
                data: {
                    userInfoStr: userStr
                },
                success: function (data) {
                    console.log(data)
                    if(data == "1001"){
                        layer.msg("修改成功", {time: 2000});
                        setTimeout(function () {
                            var appurl = getAppCurUrl();
                            var url = appurl + '/backendAdminController/userManagePage';
                            return unifiedSkip('', 1, url)
                        }, 2000)
                    }else if(data == "1002"){
                        layer.msg("修改失败",{time: 2000});
                        setTimeout(function () {
                            var appurl = getAppCurUrl();
                            var url = appurl + '/backendAdminController/userManagePage';
                            return unifiedSkip('', 1, url)
                        }, 2000)
                    }else if(data == "1004"){
                        layer.msg("密码的长度须大于8位，含字母（大小写）、数字及符号组合",{time: 2000});
                    }
                }
            });
        }


</script>

</body>
</html>