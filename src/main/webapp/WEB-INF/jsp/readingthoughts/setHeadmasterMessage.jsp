<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>校长寄语设置</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/readingThought/essayMessagePubilsh.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/readingThought/daterangepicker.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/readingThought/crop/cropper.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/readingThought/crop/ImgCropping.css">
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/js/mobile/common/jquery-1.9.1.js"></script>--%>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/js/pc/readingThought/jquery-2.1.1.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/js/ckeditor/ckeditor.js"></script>
    <script type="text/javascript">

        CKEDITOR.on('instanceReady', function (e) {
            var $windowH = window.innerHeight,
                $headH = $('#header').outerHeight(),
                $footH = $('#footer').height();
            var $menuW = $('.navigation_menu').width(),
                $bodyW = $('body').width();
            if ($('.main_content').height() < ($windowH - $headH - $footH)) {
                $('#navigation_menu').height(($windowH - $headH - $footH) + 'px');
            }

            $('.main_content').width(($bodyW - 165) + 'px');
        });
        //        $(document).ready(function () {
        //            var $windowH = window.innerHeight,
        //                $headH = $('#header').outerHeight(),
        //                $footH = $('#footer').height();
        //            var $menuW = $('.navigation_menu').width(),
        //                $bodyW = $('body').width();
        //            if ($('.main_content').height() < ($windowH - $headH - $footH)) {
        //                $('#navigation_menu').height(($windowH - $headH - $footH) + 'px');
        //            }
        //
        //            $('.main_content').width(($bodyW - 165) + 'px');
        ////            $('.main_content').height(($windowH-$headH-$footH)+'px');
        //        })
    </script>
    <script type="text/javascript">
        CKEDITOR.replace('content');
    </script>
</head>
<body>
<div class="reading_wrap">
    <c:import url="header.jsp"/>
    <div class="content_wrap">
        <c:import url="navBar.jsp"/>
        <script>
            $('#message_exchange').addClass('active');
            $('#Headmaster_nav').show();
        </script>
        <!--内容区-->
        <div class="main_content">

            <div class="content_top">
                <i class="icon"></i>校长寄语设置
                <%--<div class="back">返回</div>--%>
            </div>
            <div class="publish_box">
                <div class="works_content">
                    <form action="${pageContext.request.contextPath}/backendAdminController/updateHeadmasterMessage"
                          method="post" id="newsTableFrom">
                        校长寄语：
                        <%--<div><textarea name="" id="content" cols="60" rows="20">${headmasterMessage.headmasterMessage}</textarea>--%>
                        <%--</div>--%>
                        <div><textarea rows="50" cols="100" name="HeadmasterMessageMessage"
                                       id="HeadmasterMessageMessage" class="ckeditor">${headmasterMessage.headmasterMessage}</textarea>
                        </div>
                        <input type="hidden" value="${headmasterMessage.id}" id="HeadmasterMessageId" name="HeadmasterMessageId">
                    </form>
                </div>


                <div class="button works">
                    <input type="button" value="发布" onclick="publishOneGuide()">
                </div>
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


</script>
<script type="text/javascript">


    function publishOneGuide() {
        var headmasterMessage = CKEDITOR.instances.HeadmasterMessageMessage.getData();
        var headmasterMessageId = $("#HeadmasterMessageId").val();

        console.log(headmasterMessage);
        console.log(headmasterMessageId)
        var headmasterMessagePo = {
            headmasterMessage: headmasterMessage,
            id: headmasterMessageId
        }
//        var essayInfoPoStr = escape(escape(JSON.stringify(essayInfo)));
        $.ajax({
            url: '${pageContext.request.contextPath}/backendAdminController/updateHeadmasterMessage',
            type: "POST",
            dataType: 'json',
            data: {
                headmasterMessageStr:  escape(escape(JSON.stringify(headmasterMessagePo)))

            },
            success: function (data) {
                if(data == 200){
                    var appurl = getAppCurUrl();
                    var url = appurl + '/backendAdminController/toSetHeadmasterMessage';
                    layer.msg('修改成功', {time: 2000}, function () {
                        return unifiedSkip('', 1, url)
                    });
                }
            }
        });
//        $("#newsTableFrom").submit();
    }

</script>

</body>
</html>