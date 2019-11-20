<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="multipart/form-data;charset=utf-8"/>
    <title>书目管理--书目信息修改</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/readingThought/secondInputStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/readingThought/crop/cropper.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/readingThought/crop/ImgCropping.css">
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
                <i class="icon"></i>经典书目--信息修改
                <div class="back">返回</div>
            </div>
            <form id="singleForm" method="post" action="/backendAdminController/updateClassiclBookInfo"
                  enctype="multipart/form-data">
                <div class="content_table">
                    <div class="publish_box">
                        <div class="input_box">
                            <div class="left_box">书目分类：</div>
                            <input type="hidden" name="id" value="${classicBook.id}">
                            <div class="right_box">
                                <select name="book_classification" id="">
                                    <c:choose>
                                        <c:when test="${classicBook.bookClassification == 1}">
                                            <option value="1" selected="selected">扩展书目</option>
                                            <option value="2">基本书目</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="1">扩展书目</option>
                                            <option value="2" selected="selected">基本书目</option>
                                        </c:otherwise>
                                    </c:choose>
                                </select>
                            </div>
                            <div class="left_box">学科领域：</div>
                            <div class="right_box">
                                <select name="procClassId" id="procClassId">
                                    <c:forEach items="${bookMap}" var="ele">
                                        <option value="${ele.key}">${ele.value}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="left_box">对应活动：</div>
                            <div class="right_box" id="essayName">${EssayInfos}</div>
                        </div>
                        <div class="input_box">
                            <div class="left_box">书名：</div>
                            <div class="right_box"><input type="text" name="basicTitle"
                                                          value="${classicBook.basicTitle}"></div>
                            <div class="left_box">作者：</div>
                            <div class="right_box"><input type="text" name="basicCreator"
                                                          value="${classicBook.basicCreator}"></div>

                            <%--<div class="left_box">作者单位：</div>--%>
                            <%--<div class="right_box"><input type="text" name="basicContact"--%>
                            <%--value="${classicBook.basicContact}"></div>--%>
                            <div class="left_box">中图分类号：</div>
                            <div class="right_box"><input type="text" name="foundation"
                                                          value="${classicBook.foundation}"></div>
                        </div>

                        <div class="input_box">
                            <div class="left_box">出版社：</div>
                            <div class="right_box"><input type="text" name="basicPublisher"
                                                          value="${classicBook.basicPublisher}"></div>

                            <div class="left_box">出版年份：</div>
                            <div class="right_box"><input type="text" name="basicDate" value="${classicBook.basicDate}">
                            </div>
                            <div class="left_box">ISBN号：</div>
                            <div class="right_box"><input type="text" value="${classicBook.originalProjectResId}"
                                                          name="originalProjectResId">
                            </div>
                        </div>

                        <div class="input_box">
                            <div class="left_box">页数：</div>
                            <div class="right_box"><input type="text" name="basicPage"
                                                          value="${classicBook.basicPage}"></div>
                            <div class="left_box">书评：</div>
                            <div class="right_box"><input type="text"
                                                          value="${classicBook.basicDescription}"
                                                          name="basicDescription"></div>
                            <div class="left_box">全文链接：</div>
                            <div class="right_box"><input type="text" name="procFileLink"
                                                          value="${classicBook.procFileLink}"></div>

                        </div>
                        <div class="input_box">
                            <div class="left_box">丛书名：</div>
                            <div class="right_box"><input type="text" name="basicSourceName"
                                                          value="${classicBook.basicSourceName}"></div>

                            <div class="left_box">摘要：</div>
                            <div class="right_box"><input type="text" name="viewElements"
                                                          value="${classicBook.viewElements}"></div>
                            <div class="left_box">主题词：</div>
                            <div class="right_box"><input type="text" name="basicKeyword"
                                                          value="${classicBook.basicKeyword}"></div>
                        </div>
                        <div class="input_box">
                            <div class="left_box">当当网址：</div>
                            <div class="right_box"><input type="text" value="${classicBook.detaiurl}" name="detaiurl">
                            </div>

                            <div class="left_box">亚马逊网址：</div>
                            <div class="right_box"><input type="text" value="${classicBook.avenue}" name="avenue">
                            </div>
                            <div class="left_box">豆瓣网址：</div>
                            <div class="right_box"><input type="text" value="${classicBook.warePageView}"
                                                          name="warePageView">
                            </div>
                        </div>
                        <input type="hidden" id="imgurl" name="base64">
                        <div class="input_box">

                        </div>
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
                                    <img id="finalImg" src="${pageContext.request.contextPath}/images/uploadImg/${classicBook.screenshot}" height="150px">
                                </div>
                            </div>

                            <div class="right_box" style="margin-left: 50px">
                                <button type="button" class="l-btn" onclick="chooseEssay()"
                                        style="height: 30px;margin-right: 10px">活动选择
                                </button>
                            </div>
                            <div class="right_box"><input type="hidden" value="" name="essayId"
                                                          id="essayId">
                            </div>

                            <div class="right_box" style="margin-left: 50px">
                                <c:choose>
                                    <c:when test="${classicBook.cnkiYycount !=null && classicBook.cnkiYycount !=''}">
                                        <span style="color: #00aaf5">附件已上传</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span>上传附件</span>
                                    </c:otherwise>
                                </c:choose>
                                <input type="file" name="singlepdf" id="singlepdf">
                            </div>


                            <!--图片裁剪框 start-->
                            <div style="display: none" class="tailoring-container">
                                <div class="black-cloth" onclick="closeTailor(this)"></div>
                                <div class="tailoring-content">
                                    <div class="tailoring-content-one">
                                        <label title="上传图片" for="chooseImg" class="l-btn choose-btn">
                                            <input type="file" accept="image/jpg,image/jpeg,image/png" name="chooseImg"
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
                                <c:choose>
                                    <c:when test="${classicBook.wfYycount !=null && classicBook.wfYycount !=''}">
                                        <span style="color: #00aaf5">讲解材料已上传</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span>上传讲解材料</span>
                                    </c:otherwise>
                                </c:choose>
                                <input type="file" name="material" id="material">
                            </div>
                            <div class="right_box" style="margin-left: 50px">
                                <c:choose>
                                    <c:when test="${classicBook.cqvipYycount !=null && classicBook.cqvipYycount !=''}">
                                        <span style="color: #00aaf5">导读课件已上传</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span>上传导读课件</span>
                                    </c:otherwise>
                                </c:choose>
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
                    <div style="color: #fc2132;padding-left: 250px;padding-top: 50px;font-size: 15px">
                        温馨提示：上传文件名称需要于书本名称相同！新上传的文件将会覆盖原文件
                    </div>
                </div>
            </form>
        </div>

    </div>

    <c:import url="footer.jsp"/>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/pc/readingThought/cropper.min.js"></script>
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

        $("#procClassId").val("${classicBook.procClassId}")
    })

    function importSingleBook() {
        $('#essayId').val(essayId);
        $("#singleForm").submit();
    }

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

    function dataURLtoFile(dataurl, filename) {//将base64转换为文件
        var arr = dataurl.split(','), mime = arr[0].match(/:(.*?);/)[1],
            bstr = atob(arr[1]), n = bstr.length, u8arr = new Uint8Array(n);
        while(n--){
            u8arr[n] = bstr.charCodeAt(n);
        }
        return new File([u8arr], filename, {type:mime});
    }

</script>
<script>
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