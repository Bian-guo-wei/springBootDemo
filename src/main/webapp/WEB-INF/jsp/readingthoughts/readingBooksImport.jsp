<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="multipart/form-data;charset=utf-8"/>
    <title>阅读推荐--书目导入</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/readingThought/secondInputStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/readingThought/crop/cropper.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/readingThought/crop/ImgCropping.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/layer/layer.js"></script>

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
            <div>

            </div>
            <div class="content_top">
                <i class="icon"></i>经典阅读--图书上传（书目导入）
                <div class="back">返回</div>
            </div>
            <div class="content_table">
                <div class="tab_head">
                    <%--<div class="tab_one active_tab">全部资源检索</div>--%>
                    <div class="tab_one active_tab">书目导入</div>
                    <div class="tab_one">单个上传</div>
                </div>

                <div class="publish_box">
                    <div class="input_box">
                        <div class="left_box">上传表格：</div>
                        <div class="right_box"><input type="file" name="excel" id="upfile"><a class="layui-form-label"
                                                                                              href="${pageContext.request.contextPath}/images/classicbooks.xls"
                                                                                              style="width: 200px;text-align: left"><span
                                style="color:#1E9FFF;cursor: pointer">下载模板</span>(请先下载excel模板)</a></div>
                    </div>

                    <div class="input_box">
                        <div class="left_box">上传图书封面：</div>
                        <div class="right_box"><input type="file" name="docu" id="zip"><a class="layui-form-label"
                                                                                          href="javascript:;"
                                                                                          style="width: 200px;text-align: left"><span
                                style="color:#1E9FFF;cursor: pointer">(文件格式仅限zip，此压缩文件为导入图书的封面图片压缩包，图片名称需要与表格中书名一致)</span></a>
                        </div>
                    </div>
                    <div class="input_box">
                        <div class="left_box">上传全文：</div>
                        <div class="right_box"><input type="file" name="pdf" id="pdfzip"><a class="layui-form-label"
                                                                                            href="javascript:;"
                                                                                            style="width: 200px;text-align: left"><span
                                style="color:#1E9FFF;cursor: pointer">(文件格式仅限zip，此压缩文件为导入图书的pdf压缩包，图书名称需要与表格中书名一致)</span></a>
                        </div>
                    </div>
                    <div class="input_box">
                        <div class="left_box">上传讲解材料：</div>
                        <div class="right_box"><input type="file" name="material" id="materialzip"><a
                                class="layui-form-label"
                                href="javascript:;"
                                style="width: 200px;text-align: left"><span
                                style="color:#1E9FFF;cursor: pointer">(文件格式仅限zip，此压缩文件为导入讲解材料的压缩包，材料名称需要与表格中书名一致)</span></a>
                        </div>
                    </div>
                    <div class="input_box">
                        <div class="left_box">上传导读课件：</div>
                        <div class="right_box"><input type="file" name="courseware" id="coursewarezip"><a
                                class="layui-form-label"
                                href="javascript:;"
                                style="width: 200px;text-align: left"><span
                                style="color:#1E9FFF;cursor: pointer">(文件格式仅限zip，此压缩文件为导入导读课件的压缩包，课件名称需要与表格中书名一致)</span></a>
                        </div>
                    </div>
                    <div class="button">
                        <input type="button" onclick="importExcelBooks()" value="导入">
                    </div>
                    <%--</form>--%>
                </div>
                <div class="publish_box" style="display:none;">
                    <form id="singleForm" method="post" action="/backendAdminController/importSingleBook"
                          enctype="multipart/form-data">
                        <div class="input_box">
                            <div class="left_box">书目分类：</div>
                            <div class="right_box">
                                <select id="bookClassification" name="bookClassification">
                                    <option value="">--请选择--</option>
                                    <option value="1">扩展书目</option>
                                    <option value="2">基本书目</option>
                                </select>
                            </div>
                            <div class="left_box">学科领域：</div>
                            <div class="right_box">
                                <select name="procClassId" id="procClassId">
                                    <c:forEach items="${map}" var="ele">
                                        <option value="${ele.key}">${ele.value}</option>
                                    </c:forEach>
                                </select>
                            </div>

                        </div>
                        <div class="input_box">
                            <div class="left_box">书名：</div>
                            <div class="right_box"><input type="text" value="" name="basicTitle" id="basicTitle">
                            </div>
                            <div class="left_box">作者：</div>
                            <div class="right_box"><input type="text" value="" name="basicCreator" id="basicCreator">
                            </div>
                            <%--<div class="left_box">作者单位：</div>--%>
                            <%--<div class="right_box"><input type="text" value="" name="basicContact" id="basicContact">--%>
                            <%--</div>--%>
                            <div class="left_box">中图分类号：</div>
                            <div class="right_box"><input type="text" value="" name="foundation" id="foundation">
                            </div>
                        </div>
                        <div class="input_box">
                            <div class="left_box">出版社：</div>
                            <div class="right_box"><input type="text" value="" name="basicPublisher"
                                                          id="basicPublisher">
                            </div>
                            <div class="left_box">出版年份：</div>
                            <div class="right_box"><input type="text" value="" name="basicDate" id="basicDate">
                            </div>
                            <div class="left_box">ISBN号：</div>
                            <div class="right_box"><input type="text" value="" name="originalProjectResId"
                                                          id="originalProjectResId">
                            </div>
                        </div>
                        <div class="input_box">
                            <div class="left_box">页数：</div>
                            <div class="right_box"><input type="text" value="" name="basicPage" id="basicPage">
                            </div>
                            <div class="left_box">书评：</div>
                            <div class="right_box"><input type="text" value="" name="basicDescription"
                                                          id="basicDescription">
                            </div>

                            <div class="left_box">全文链接：</div>
                            <div class="right_box"><input type="text" value="" name="procFileLink" id="procFileLink">
                            </div>
                        </div>
                        <div class="input_box">
                            <div class="left_box">丛书名：</div>
                            <div class="right_box"><input type="text" name="basicSourceName"
                                                          value=""></div>

                            <div class="left_box">摘要：</div>
                            <div class="right_box"><input type="text" name="viewElements"
                                                          value=""></div>
                            <div class="left_box">主题词：</div>
                            <div class="right_box"><input type="text" name="basicKeyword"
                                                          value=""></div>
                        </div>

                        <div class="input_box">
                            <div class="left_box">当当网址：</div>
                            <div class="right_box"><input type="text" value="" name="detaiurl" id="detaiurl">
                            </div>

                            <div class="left_box">亚马逊网址：</div>
                            <div class="right_box"><input type="text" value="" name="avenue"
                                                          id="avenue">
                            </div>
                            <div class="left_box">豆瓣网址：</div>
                            <div class="right_box"><input type="text" value="" name="warePageView"
                                                          id="warePageView">
                            </div>
                        </div>
                        <%--<div class="works_content">--%>
                        <%--活动内容：--%>
                        <%--<div><textarea name="" id="content" cols="30" rows="10"></textarea></div>--%>
                        <%--</div>--%>

                        <input type="hidden" id="imgurl" name="screenshot">
                        <div class="input_box">
                            <div class="left_box">
                                <div>
                                    <button type="button" id="replaceImg" class="l-btn"
                                            style="height: 30px;margin-right: 10px">选择图片
                                    </button>
                                </div>

                            </div>
                            <div class="right_box">
                                <div>
                                    <img id="finalImg" src="" height="150px">
                                </div>
                            </div>

                            <div class="right_box" style="margin-left: 50px">
                                <button type="button" class="l-btn" onclick="chooseEssay()"
                                        style="height: 30px;margin-right: 10px">活动选择
                                </button>
                            </div>
                            <div style="line-height: 30px;" id="essayName">
                            </div>
                            <div class="right_box"><input type="hidden" value="" name="essayId"
                                                          id="essayId">
                            </div>

                            <div class="right_box" style="margin-left: 50px">
                                <span>上传pdf附件</span>
                                <input type="file" name="singlepdf" id="singlepdf">
                            </div>

                            <!--图片裁剪框 start-->
                            <div style="display: none" class="tailoring-container">
                                <div class="black-cloth" onclick="closeTailor(this)"></div>
                                <div class="tailoring-content">
                                    <div class="tailoring-content-one">
                                        <label title="上传图片" for="chooseImg" class="l-btn choose-btn">
                                            <input type="file" accept="image/jpg,image/jpeg,image/png" name="file"
                                                   id="chooseImg" class="hidden" onchange="selectImg(this)">
                                            选择图片
                                        </label>
                                        <div class="close-tailoring" onclick="closeTailor(this)">×</div>
                                    </div>
                                    <div class="tailoring-content-two">
                                        <div class="tailoring-box-parcel">
                                            <img id="tailoringImg">
                                        </div>
                                        <div class="preview-box-parcel">
                                            <p>图片预览：</p>
                                            <div class="square previewImg"></div>
                                            <div class="circular previewImg"></div>
                                        </div>
                                    </div>
                                    <div class="tailoring-content-three">
                                        <button type="button" class="l-btn cropper-reset-btn">复位</button>
                                        <button type="button" class="l-btn cropper-rotate-btn">旋转</button>
                                        <button type="button" class="l-btn cropper-scaleX-btn">换向</button>
                                        <button type="button" class="l-btn sureCut" id="sureCut">确定</button>
                                    </div>
                                </div>
                            </div>
                            <!--图片裁剪框 end-->
                        </div>


                        <div class="input_box">
                            <div class="right_box" style="margin-left: 50px">
                                <span>上传讲解材料</span>
                                <input type="file" name="material" id="material">
                            </div>
                            <div class="right_box" style="margin-left: 50px">
                                <span>上传导读课件</span>
                                <input type="file" name="courseware" id="courseware">
                            </div>
                        </div>
                        <%--<div class="input_box">--%>
                        <%--<div class="left_box">全文电子图书链接：</div>--%>
                        <%--<div class="right_box"><input type="text" value=""></div>--%>
                        <%--</div>--%>
                        <div class="button" style="padding-left: 260px">
                            <input type="button" onclick="importSingleBook()" value="发布">
                        </div>
                </div>
                <div style="color: #fc2132;padding-left: 250px;padding-top: 50px;font-size: 15px">温馨提示：上传文件名称需要于书本名称相同！</div>
                </form>
            </div>
        </div>
    </div>

    <c:import url="footer.jsp"/>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/pc/readingThought/cropper.min.js"></script>
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
//            uploadFile(encodeURIComponent(base64url));
            $('#imgurl').val(base64url);
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
        $.ajax({
            url: '/backendAdminController/uploadimg',
            type: 'POST',
            data: {base64: base64},
            async: true,
            success: function (data) {
                var result = eval("(" + data + ")");
                if (result.status === 200) {
                    layer.msg('上传成功', {time: 2000});
                    var objId = result.data;
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
<script>
    $(".tab_one").each(function (i) {
        $(this).on("click", function () {
            var index = $(this).index();
            $(this).addClass("active_tab").siblings().removeClass("active_tab");
            $(".publish_box").eq(i).show();
            $(".publish_box").eq(i).siblings(".publish_box").hide();
        })
    });
    function add() {
        var len = $("#search>.input_box").length;
        if (len < 7) {
            $("#search").append('<div class="input_box">\n' +
                '                        <div class="left_box">\n' +
                '                            <select name="" id="">\n' +
                '                                <option value="">与</option>\n' +
                '                                <option value="">或</option>\n' +
                '                                <option value="">非</option>\n' +
                '                            </select>\n' +
                '                        </div>\n' +
                '                        <div class="right_box">\n' +
                '                            <select name="" id="">\n' +
                '                                <option value="">全部字段</option>\n' +
                '                                <option value="">主题</option>\n' +
                '                                <option value="">题名</option>\n' +
                '                                <option value="">作者</option>\n' +
                '                                <option value="">作者机构</option>\n' +
                '                                <option value="">关键词</option>\n' +
                '                                <option value="">摘要</option>\n' +
                '                                <option value="">书目分类</option>\n' +
                '                            </select>\n' +
                '                            <input type="text">\n' +
                '                            <select name="" id="">\n' +
                '                                <option value="">精确</option>\n' +
                '                                <option value="">模糊</option>\n' +
                '                            </select>\n' +
                '                        </div>\n' +
                '                    </div>')
        }
    }
    function del() {
        var sixe = $("#search>.input_box").length;
        if (sixe > 4) {
            $("#search>.input_box").last().remove();
        }


    }
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/mobile/common/CXJSBridge.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/mobile/common/urlJump.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/layer/layer.js"></script>
<script type="text/javascript">
    $("#essay").change(function () {
        var ele = '';

    });
    $("#second_classify").change(function () {
        var second_classify = $("#second_classify option:selected").val();
        var url = "/backendAdminController/getThirdClassify?classificationId=" + second_classify;
        $.ajax({
            url: url,
            type: "get",
            dataType: "json",
            success: function (data) {
                if (data.length > 0) {
                    $("#third_classify").empty();
//                    var list = JSON.parse(data);
                    var list = data;
                    var option = "<option value=''>-请选择-</option>";
                    for (var i = 0; i < list.length; i++) {
                        option += "<option value='" + list[i].classificationId + "'>" + list[i].classificationName + "</option>";
                    }
                    $("#third_classify").append(option);
                }
            }
        })
    });
</script>
<script type="text/javascript">

    function importSingleBook() {
        $('#essayId').val(essayId);
//        var firstValue = $("#first_classify").val();
//        var secondValue = $("#second_classify").val();
//        var thirdValue = $("#third_classify").val();
//        var booksHref = $("#procFileLink").val();
//        var singlepdf = $("#singlepdf").val();
        var book_classification = $("#book_classification").val();
        var procClassId = $("#procClassId").val();
        var basicTitle = $("#basicTitle").val();
        var basicCreator = $("#basicCreator").val();
        if (book_classification == '' || procClassId == '' || basicTitle == '' || basicCreator == '' ) {
            layer.msg("请将信息填写完整!", {time: 2000})
        }
//        else if (firstValue == '') {
//            layer.msg("书目分类不能为空!", {time: 2000})
//        }
        else {
            // layer.msg('发布成功', function(){
            //  $("#singleForm").submit();
            // });
//            if (thirdValue != "" && secondValue != "") {
//                $("#third_classify").attr("name", "procClassId");
//            }
//            if (thirdValue == "" && secondValue != "") {
//                $("#second_classify").attr("name", "procClassId");
//            }
//            if (thirdValue == "" && secondValue == "") {
//                $("#first_classify").attr("name", "procClassId");
//            }
            $("#singleForm").submit();

        }

    }

    function importExcelBooks() {
        var layerId = '';
        var fileName = $("#upfile").val();
        var zipFileName = $("#zip").val();
        if (null != fileName && fileName.length > 1) {
            var ldot = fileName.lastIndexOf(".");
            var type = fileName.substring(ldot + 1);
            if (type == "xls" || type == "xlsx") {
                var zipLdot = zipFileName.lastIndexOf(".");
                var zipType = zipFileName.substring(zipLdot + 1) + "";
                if (zipType == "zip" || "" == zipType) {
                    // var form1 = document.getElementById("form_query");
                    var file = document.querySelector('[name=excel]');
                    var file1 = document.querySelector('[name=docu]');
                    var file2 = document.querySelector('[name=pdf]');
                    var materialfile = document.querySelector('[name=material]');
                    var coursewarefile = document.querySelector('[name=courseware]');
                    var formData = new FormData();
                    // var files = $("[name=file]")[0].files[0];
                    formData.append("excel", file.files[0]);
                    formData.append("docu", file1.files[0]);
                    formData.append("pdf", file2.files[0]);
                    formData.append("material", materialfile.files[0]);
                    formData.append("courseware", coursewarefile.files[0]);
                    $.ajax({
                        url: "/backendAdminController/importExcelBooks",
                        type: "POST",
                        data: formData,
                        contentType: false,
                        processData: false,
                        beforeSend: function () {
                           layerId = layer.msg('loading.....', {
                                icon: 16,
                                shade: 0.4,
                                time: false
                            })
                        },
                        success: function (data) {
                            if (data.length > 0) {
                                layer.msg(data, {time: 2000});
                            } else {
                                var appCurUrl = getAppCurUrl();
                                var url = appCurUrl + '/backendAdminController/readingRecommend';
                                return unifiedSkip("", 1, url);
                            }
                            layer.close(layerId);
                        }
                    });
                } else {
                    alert("压缩文件格式不正确");
                }
                // $("form[name=form_query]").submit();
            } else {
                alert("excel文件格式不准确！");
            }
        }
    }

    var essayId = [];
    var essayName = [];

    function checkbox11(obj) {
        if (obj.checked) {
            essayId.push(obj.value)
            essayName.push($(obj).parent().text() + '，');
        } else {
            for (var i = essayId.length - 1; i >= 0; i--) {
                if (essayId[i] == obj.value) {
                    essayId.splice(i, 1);
                }
            }
            for (var i = essayName.length - 1; i >= 0; i--) {
                if (essayName[i] == $(obj).parent().text()) {
                    essayName.splice(i, 1);
                }
            }
        }
    }

    function chooseEssay() {
        essayId = [];
        var checkbox = '<div style="padding: 20px">';
        var checkbox2 = '</div>'
        $.ajax({
            url: '/backendAdminController/getEssays',
            type: 'POST',
            dataType: 'json',
            data: {},
            async: false,
            success: function (data) {
                var list = data;
                for (var i = 0; i < list.length; i++) {
                    var list = data;
                    for (var i = 0; i < list.length; i++) {
                        checkbox += '<span  style="margin: 0 10px" ><input type="checkbox"  onclick="checkbox11(this)" class="book_choose" name="essayInfo" ' +
                            'value="' + list[i].uuid + '" id="' + list[i].uuid + '">' + list[i].title + '</span>';
                    }
                }
            }
        })

        layer.open({
            type: 1,
            title: ['<span style="color:white;">活动添加</span> ',
                'background-color: #4898d5'],
            area: ['350px ,100px'],
            shade: 0.5,
            id: 'essayChoose',
            moveType: 1,
            content: checkbox + checkbox2,
            closeBtn: 1,
            btn: ['确认', '取消'],
            yes: function (index, layero) {
                $('#essayName').html('');
                $('#essayName').append(essayName);
                layer.close(index);
                essayName = [];
            }
        })
    }


</script>
</body>
</html>