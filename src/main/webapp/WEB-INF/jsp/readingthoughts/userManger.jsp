<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="multipart/form-data;charset=utf-8"/>
    <title>账号修改</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/readingThought/secondInputStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/readingThought/crop/cropper.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/readingThought/crop/ImgCropping.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/readingThought/essayContest.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/layer/layer.js"></script>

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
        <div class="main_content">
            <div class="content_top"><i class="icon"></i>经典书目</div>

            <div class="content_search">
                    <input type="button" value="新增管理员" onclick="addUser()">
            </div>
            <div class="content_table">
                <table cellpadding="0" cellspacing="0">
                    <tr>
                        <th width="160">用户名</th>
                        <th width="120">真实姓名</th>
                        <th width="120">状态</th>
                        <th width="120">操作</th>
                    </tr>
                    <c:forEach items="${adminList}" var="list">
                        <tr>
                            <td align="center"><span style="font-weight: bold;">${list.phone}</span></td>

                            <td align="center">${list.realName}</td>
                            <td align="center">已开通</td>

                            <td align="center">
                                <a href="javascript:void(0)" onclick="del(${list.id})"
                                   class="cor addData">删除</a>

                                <a href="javascript:void(0)" onclick="update(${list.id})"
                                   class="cor addData">修改</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <!--分页-->
                <%--<div class="pages">--%>
                    <%--<div class="">共${classicBooksPageBean.totalData}条记录</div>--%>
                    <%--<div class="">${classicBooksPageBean.currentPage}/${classicBooksPageBean.totalPage}</div>--%>
                    <%--<div class="first_page" onclick="skippage(1)">第一页</div>--%>
                    <%--<div class="pre_page" onclick="skippage(${classicBooksPageBean.currentPage-1})">上一页</div>--%>
                    <%--<ul class="pages_list" id="pages_list">--%>
                    <%--</ul>--%>
                    <%--<div class="next_page" onclick="skippage(${classicBooksPageBean.currentPage+1})">下一页</div>--%>
                    <%--<div class="last_page" onclick="skippage(${classicBooksPageBean.totalPage})">最后一页</div>--%>
                    <%--<div class="to_numpages">到第<input type="text" id="page">页</div>--%>
                    <%--<div class="sure_go" onclick="gopage()"><input type="button" value="GO" id="sure"></div>--%>
                <%--</div>--%>
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

        $("#procClassId").val("${classicBook.procClassId}")
    })

</script>
<script>
    function addUser() {
        var url = '${pageContext.request.contextPath}/backendAdminController/addUser';
        return unifiedSkip('', 1, url);

    }
    function del(id) {
        $.ajax({
            url: '${pageContext.request.contextPath}/backendAdminController/deleteUser',
            type: "POST",
            dataType: 'json',
            data: {
                id: id
            },
            success: function (data) {
                console.log(data)
                if(data == "1001"){
                    layer.msg("删除成功", {time: 2000});
                    setTimeout(function () {
                        var appurl = getAppCurUrl();
                        var url = appurl + '/backendAdminController/userManagePage';
                        return unifiedSkip('', 1, url)
                    }, 2000)
                }else if(data == "1002"){
                    layer.msg("删除失败",{time: 2000});
                    setTimeout(function () {
                        var appurl = getAppCurUrl();
                        var url = appurl + '/backendAdminController/userManagePage';
                        return unifiedSkip('', 1, url)
                    }, 2000)
                }
            }
        });
    }


    function update(id) {
        var url = '${pageContext.request.contextPath}/backendAdminController/toUpdateUser?id='+id;
        return unifiedSkip('',1,url);
    }
</script>
</body>
</html>