<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>活动--信息发布</title>
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
            $('#essay_contest').addClass('active');
            $('#essay_nav').show();
        </script>
        <!--内容区-->
        <div class="main_content">

            <div class="content_top">
                <i class="icon"></i>活动--信息发布
                <div class="back">返回</div>
            </div>
            <div class="publish_box">
                <div class="works_name works">
                    活动标题：<input type="text" id="title">
                </div>

                <div class="works_content">
                    活动内容：
                    <div><textarea name="" id="content" cols="30" rows="10"></textarea></div>
                </div>

                <%--<div class="works_name works">--%>
                    <%--评选类型：<select name="" id="approvalType">--%>
                    <%--<c:forEach items="${vo.enumSet}" var="typeSet">--%>
                        <%--<option value="${typeSet.typeId}">${typeSet.name}</option>--%>
                    <%--</c:forEach>--%>
                <%--</select>--%>
                <%--</div>--%>
                <%--<div class="works_name works date_select htmleaf-content bgcolor-3">--%>
                    <%--活动时间：<input type="text" placeholder="年/月/日" id="date-range1">--%>
                    <%--- ---%>
                    <%--<input type="text" placeholder="年/月/日" id="date-range2">--%>
                <%--</div>--%>
                <%--<div class=" work_crop">--%>
                    <%--&lt;%&ndash;<form id="imgSelection">&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<input type="file" name="file" id="file">&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<input type="button" value="上传图片" onclick="submitImg()">&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</form>&ndash;%&gt;--%>

                    <%--<button id="replaceImg" class="l-btn" style="height: 30px;margin-right: 10px">选择图片</button>--%>
                    <%--<div>--%>
                        <%--<img id="finalImg" src="" height="150px">--%>
                    <%--</div>--%>


                    <%--<!--图片裁剪框 start-->--%>
                    <%--<div style="display: none" class="tailoring-container">--%>
                        <%--<div class="black-cloth" onclick="closeTailor(this)"></div>--%>
                        <%--<div class="tailoring-content">--%>
                            <%--<div class="tailoring-content-one">--%>
                                <%--<label title="上传图片" for="chooseImg" class="l-btn choose-btn">--%>
                                    <%--<input type="file" accept="image/jpg,image/jpeg,image/png" name="file"--%>
                                           <%--id="chooseImg" class="hidden" onchange="selectImg(this)">--%>
                                    <%--选择图片--%>
                                <%--</label>--%>
                                <%--<div class="close-tailoring" onclick="closeTailor(this)">×</div>--%>
                            <%--</div>--%>
                            <%--<div class="tailoring-content-two">--%>
                                <%--<div class="tailoring-box-parcel">--%>
                                    <%--<img id="tailoringImg">--%>
                                <%--</div>--%>
                                <%--<div class="preview-box-parcel">--%>
                                    <%--<p>图片预览：</p>--%>
                                    <%--<div class="square previewImg"></div>--%>
                                    <%--<div class="circular previewImg"></div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="tailoring-content-three">--%>
                                <%--<button class="l-btn cropper-reset-btn">复位</button>--%>
                                <%--<button class="l-btn cropper-rotate-btn">旋转</button>--%>
                                <%--<button class="l-btn cropper-scaleX-btn">换向</button>--%>
                                <%--<button class="l-btn sureCut" id="sureCut">确定</button>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<!--图片裁剪框 end-->--%>

                <%--</div>--%>
                <%--<div class="works_name works">--%>
                    <%--发布范围：<select name="" id="range">--%>
                    <%--<option value="">常熟理工学院</option>--%>
                <%--</select>--%>
                <%--</div>--%>
                <div class="button works">
                    <input type="button" value="发布" onclick="publishOneEssay()">
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/pc/readingThought/date/demo.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/js/pc/readingThought/date/jquery.daterangepicker.js"></script>
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

    //弹出图片裁剪框
    $("#replaceImg").on("click", function () {
        $(".tailoring-container").toggle();
    });

    //图像上传
    function selectImg(file) {
        if (!file.files || !file.files[0]) {
            return;
        }
        var reader = new FileReader();
        reader.onload = function (evt) {
            var replaceSrc = evt.target.result;
            //更换cropper的图片
            $('#tailoringImg').cropper('replace', replaceSrc, false);//默认false，适应高度，不失真
        }
        reader.readAsDataURL(file.files[0]);
    }

    //cropper图片裁剪
    $('#tailoringImg').cropper({
        // aspectRatio: 5 / 6,//默认比例
        preview: '.previewImg',//预览视图
        guides: false,  //裁剪框的虚线(九宫格)
        autoCropArea: 0.5,  //0-1之间的数值，定义自动剪裁区域的大小，默认0.8
        movable: false, //是否允许移动图片
        dragCrop: true,  //是否允许移除当前的剪裁框，并通过拖动来新建一个剪裁框区域
        movable: true,  //是否允许移动剪裁框
        resizable: true,  //是否允许改变裁剪框的大小
        zoomable: false,  //是否允许缩放图片大小
        mouseWheelZoom: false,  //是否允许通过鼠标滚轮来缩放图片
        touchDragZoom: true,  //是否允许通过触摸移动来缩放图片
        rotatable: true,  //是否允许旋转图片
        crop: function (e) {
            // 输出结果数据裁剪图像。
        }
    });
    //旋转
    $(".cropper-rotate-btn").on("click", function () {
        $('#tailoringImg').cropper("rotate", 45);
    });
    //复位
    $(".cropper-reset-btn").on("click", function () {
        $('#tailoringImg').cropper("reset");
    });
    //换向
    var flagX = true;
    $(".cropper-scaleX-btn").on("click", function () {
        if (flagX) {
            $('#tailoringImg').cropper("scaleX", -1);
            flagX = false;
        } else {
            $('#tailoringImg').cropper("scaleX", 1);
            flagX = true;
        }
        flagX != flagX;
    });

    //裁剪后的处理
    $("#sureCut").on("click", function () {
        if ($("#tailoringImg").attr("src") == null) {
            return false;
        } else {
            var cas = $('#tailoringImg').cropper('getCroppedCanvas');//获取被裁剪后的canvas
            var base64url = cas.toDataURL('image/png'); //转换为base64地址形式
            $("#finalImg").prop("src", base64url);//显示为图片的形式
            uploadFile(encodeURIComponent(base64url));
            //console.log(encodeURIComponent(base64url))
            //关闭裁剪框
            closeTailor();
        }
    });

    //关闭裁剪框
    function closeTailor() {
        $(".tailoring-container").toggle();
    };

    //ajax请求上传
    function uploadFile(base64) {
        // console.log(base64)
        $.ajax({
            url: '/backendAdminController/uploadimg',
            type: 'POST',
            data: {base64: base64},
            async: true,
            success: function (data) {
                console.log(data)
                var result = eval("(" + data + ")");
                console.log(result);
                if (result.status === 200) {
                    layer.msg('上传成功', {time: 2000});
                    var objId = result.data;
                    //console.log("objId"+objId);
                    var imgUrl = "http://p.ananas.chaoxing.com/star3/origin/" + objId + ".jpg";
                    $('#imgurl').val(imgUrl);
                } else {
                    layer.msg('上传图片失败', {
                        time: 2000
                    });
                }
            }
        });
    }

</script>
<script type="text/javascript">

    function submitImg() {
        var form = new FormData($("#imgSelection")[0]);
        // console.log($("#imgSelection")[0]);
        $.ajax({
            url: "/backendAdminController/uploadimg",
            type: "post",
            data: form,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function (data) {
                var result = eval("(" + data + ")");
                if (result.status === 200) {
                    layer.msg('上传成功', {time: 2000});
                    var objId = result.data;
                    //console.log("objId:"+objId);
                    var imgUrl = "http://p.ananas.chaoxing.com/star3/origin/" + objId + ".jpg";
                    $('#imgurl').val(imgUrl);
                } else {
                    layer.msg('上传图片失败', {
                        time: 2000
                    });
                }
            },
        });
    }

    function getByteLen(val) {
        var len = 0;
        for (var i = 0; i < val.length; i++) {
            var a = val.charAt(i);
            if (a.match(/[^\x00-\xff]/ig) != null) {
                len += 2;
            }
            else {
                len += 1;
            }
        }
        return len;
    }
    function publishOneEssay() {
        var claim = $("#content").val();
        var title = $("#title").val();
        var imgUrl = $("#imgurl").val();
        var approvalType = $("#approvalType").val();
        if (imgUrl.trim() === '') {
            imgUrl = null;
        }
        console.log('图片url为:' + imgUrl);
        if (title.trim() === '') {
            layer.msg('请输入大赛标题', {time: 2000});
            return;
        }
        if (claim.trim() === '') {
            layer.msg('请输入大赛内容', {time: 2000});
            return;
        }

        var $Syear = $('#date-range1').val()+" "+"00:00:00";
        var Syear = new Date($Syear);
        var start = Syear.getTime();
        var $Eyear = $('#date-range2').val()+" "+"00:00:00";
        var Eyear = new Date($Eyear);
        var duration = Eyear.getTime();
        var sponsor = $('#sponsor').val();
        //console.log($Syear);
        if (!$Syear) {
            layer.msg('请选择开始时间', {time: 2000});
            return;
        }
        if (!$Eyear) {
            layer.msg('请选择结束时间', {time: 2000});
            return;
        }
        if ((duration - start) <= 0) {
            layer.msg('截止时间必须大于开始时间', {time: 2000});
            return;
        }
        //alert(getByteLen(claim));
        if (getByteLen(claim) > 10000000) {
            layer.msg('字符个数过长,应不大于10000000', {time: 2000});
        } else {
            var essayInfo = {
                title: title,
                claim: claim,
                //sponsor : sponsor,
                //start: start,
                //duration: duration,
                //screenshot: imgUrl,
                //creatorOrgId: 1385,
                //creatorPuid: Math.ceil(Math.random() * 10000000),
                //creatorName: '管理员',
                //gmtCreate:,
                display: 1,
                //status: 1,
                // approvalType: approvalType,
                //FIXME:页面缺少主题输入框
                theme: '主题'
            };
            console.log(essayInfo);
            //console.log(start, duration);
            var essayInfoPoStr = escape(escape(JSON.stringify(essayInfo)));
            console.log(essayInfoPoStr);
            $.ajax({
                url: '${pageContext.request.contextPath}/backendAdminController/orderEssay',
                type: "POST",
                dataType: 'json',
                data: {
                    essayInfoPoStr: essayInfoPoStr
                },
                success: function (data) {
                    console.log(data);
                    //var databean = JSON.parse(data);
                    if (data.status === 200) {
                        layer.msg('创建成功', {time: 2000});
                        setTimeout(function () {
                            var appurl = getAppCurUrl();
                            var url = appurl + '/backendAdminController/toManageEssay';
                            return unifiedSkip('', 1, url)
                        }, 1000)
                    }
                }
            });
        }

    }
</script>

</body>
</html>