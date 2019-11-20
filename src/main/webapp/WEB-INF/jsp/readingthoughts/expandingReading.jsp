<!DOCTYPE html>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>拓展阅读书目</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/readingThought/essayContest.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/commonJs/jquery-1.9.0.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/js/ckeditor/ckeditor.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/js/zebra_dialog.js"></script>
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
//            $('.main_content').height(($windowH-$headH-$footH)+'px');

            $("#adminLoginOut").click(function () {
                var url = "${pageContext.request.contextPath}/backendAdminController/adminLoginOut";
                window.location.href = url;
            });
        })

        <%--$(document).ready(function () {--%>
        <%--var $windowH = window.innerHeight,--%>
        <%--$headH = $('#header').outerHeight(),--%>
        <%--$footH = $('#footer').height();--%>
        <%--var $menuW = $('.navigation_menu').width(),--%>
        <%--$bodyW = $('body').width();--%>
        <%--if ($('.main_content').height() < ($windowH - $headH - $footH)) {--%>
        <%--$('#navigation_menu').height(($windowH - $headH - $footH) + 'px');--%>
        <%--}--%>

        <%--$('.main_content').width(($bodyW - 165) + 'px');--%>
        <%--//            $('.main_content').height(($windowH-$headH-$footH)+'px');--%>

        <%--$("#adminLoginOut").click(function () {--%>
        <%--var url = "${pageContext.request.contextPath}/backendAdminController/adminLoginOut";--%>
        <%--window.location.href = url;--%>
        <%--});--%>
        <%--})--%>
    </script>
    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
        }

        /*所需样式*/
        .clear {
            clear: both;
        }

        .lyer {
            width: 100%;
            padding: 10px 15px;
            box-sizing: border-box;
        }

        .lyer-delt {
            float: right;
            cursor: pointer;
        }

        .lyerCnt {
            width: 100%;
            overflow: hidden;
            margin-top: 15px;
        }

        .lyerLabel {
            width: 20%;
            text-align: right;
            display: block;
            float: left;
            font-size: 14px;
            line-height: 32px;
        }

        .lyerInput {
            width: 73%;
            height: 30px;
            line-height: 30px
            border: 1px solid #a8a8a8;
            padding: 0 10px;
            outline: none;
        }

        .lyerTxea {
            width: 73%;
            border: 1px solid #d5d5d5;
            resize: none;
            outline: none;
            padding: 10px;
            height: 100px;
            background: transparent;
            font-family: '微软雅黑';
        }

        .lyerBtn {
            text-align: center;
        }

        .lyerBtn input {
            margin: 0 8px;
            height: 30px;
            line-height: 30px;
            border: 0;
            width: 70px;
            cursor: pointer;
            text-align: center;
            color: #fff;
            outline: none;
        }

        .btnCancle {
            background: #9e9e9e;
        }

        .btnEnter {
            background: #3572e3;
        }
    </style>
</head>
<body>
<div class="reading_wrap">
    <c:import url="header.jsp"/>

    <div class="content_wrap">
        <c:import url="navBar.jsp"/>

        <script>
            $('#Expanding_reading').addClass('active');
            $('#Expanding_nav').show();
        </script>
        <!--内容区-->

        <div class="main_content">
            <div class="content_top"><i class="icon"></i>活动</div>

            <div class="content_table">
                <table cellpadding="0" cellspacing="0" id="table_list">
                    <tr>
                        <th width="120">活动名称</th>


                        <th width="120">创建时间</th>
                        <%--<th width="120">修改时间</th>--%>
                        <th width="120">操作</th>
                    </tr>
                    <c:forEach items="${pageBean.list}" var="bean">
                        <tr class="dataContent">
                            <td data-essay="${bean.claim}" align="center"><span
                                    style="font-weight: bold;">${bean.title}</span></td>
                            <td align="center">
                                <fmt:formatDate value="${bean.gmtCreate}" pattern="YYYY-MM-dd HH:mm"/>
                            </td>
                                <%--<td align="center">--%>
                                <%--<fmt:formatDate value="${bean.gmtModified}" pattern="YYYY-MM-dd HH:mm"/>--%>
                                <%--</td>--%>
                            <td align="center">
                                    <%--<c:if test="${bean.approvalType==1}">--%>
                                    <%--<a href="javascript:void(0)"--%>
                                    <%--onclick="toEssaySettingPage('${bean.uuid}','${bean.duration}')"--%>
                                    <%--class="cor">设置</a>--%>
                                    <%--</c:if>--%>

                                <a href="javascript:void(0)"
                                   onclick="toModifyPage('${bean.uuid}')"
                                   class="cor">修改</a>
                                <a href="javascript:void(0)"
                                   onclick="deleteOneEssay('${bean.uuid}')"
                                   class="cor">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>


                <!--分页-->
                <div class="pages">
                    <div class="">共${pageBean.totalData}条记录</div>
                    <div class="">${pageBean.currentPage}/${pageBean.totalPage}</div>
                    <div class="first_page" onclick="skippage(1)">第一页</div>
                    <div class="pre_page" onclick="skippage(${pageBean.currentPage-1})">上一页</div>
                    <ul class="pages_list" id="pages_list">
                    </ul>
                    <div class="next_page" onclick="skippage(${pageBean.currentPage+1})">下一页</div>
                    <div class="last_page" onclick="skippage(${pageBean.totalPage})">最后一页</div>
                    <div class="to_numpages">到第<input type="text" id="page">页</div>
                    <div class="sure_go" onclick="gopage()"><input type="button" value="GO" id="sure"></div>
                </div>

            </div>

            <form  action="${pageContext.request.contextPath}/backendAdminController/updateExpandingReadingDetail"
                    method="post" id="newsTableFrom">
                <input type="hidden" id="new_id"
                       name="new_id" value="${newsModule_update.id}"/>
                <table cellpadding="0" cellspacing="0" class="newsTable">
                    <tr>
                        <td width="80" align="right"><label> 活动名称： </label></td>
                        <td>${essayInfoHistoryPo.title } </td>
                        <td><input type="hidden" name="uuid" id="uuid" value="${essayInfoHistoryPo.uuid}"></td>
                    </tr>
                    <tr>
                        <td width="80" align="right"><label> 内容： </label></td>
                        <td><textarea rows="50" cols="100" name="detail"
                                      id="detail" class="ckeditor">${essayInfoHistoryPo.detail}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="hidden"
                                                              class="fcknewsId" value=""/>

                            <input type="button" class="dealBtn submit" value="提交"
                                   style="margin-right: 10px;" onclick="fromsubmitnewsTable()"/>
                        </td>
                    </tr>
                </table>
                <br/>

            </form>

        </div>
    </div>


    <c:import url="footer.jsp"/>
</div>
<script type='text/javascript' src='${pageContext.request.contextPath}/js/mobile/common/CXJSBridge.js'></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/mobile/common/urlJump.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/layer/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/mobile/common/jsDate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/pc/pageTabs.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        var totalP =${pageBean.totalPage};
        var pageP =${pageBean.currentPage};
        //pageInit(totalP,pageP);
        toPage(totalP, pageP);
    });





    function skippage(pageNum) {
        if (pageNum > 0 && pageNum <=${pageBean.totalPage}) {
            var appCurUrl = getAppCurUrl();
            var kw = '${kw}';
            var url = appCurUrl + '/backendAdminController/toExpandingReading' + "?currentPage=" + pageNum + "&kw=" + kw;
            return unifiedSkip("", 1, url);
        }

    }
    function gopage() {
        var pageNum = $("#page").val();
        if (pageNum > 0 && pageNum <=${pageBean.totalPage}) {
            var appCurUrl = getAppCurUrl();
            var kw = '${kw}';
            var url = appCurUrl + '/backendAdminController/toExpandingReading' + "?currentPage=" + pageNum + "&kw=" + kw;
            return unifiedSkip("", 1, url);
        }

    }

    function toModifyPage(uuid) {
        var appCurUrl = getAppCurUrl();
        var url = appCurUrl + '/backendAdminController/getExpandingReadingDetail?Uuid=' + uuid;
        return unifiedSkip("", 1, url);
    }

    function deleteOneEssay(uuid) {
//        var appCurUrl = getAppCurUrl();
//        var url = appCurUrl + '/backendAdminController/deleteExpandingReading?Uuid=' + uuid;
//        return unifiedSkip("", 1, url);
        $.ajax({
            url: '${pageContext.request.contextPath}/backendAdminController/deleteExpandingReading',
            type: "POST",
            dataType: 'json',
            data: {
                Uuid: uuid
            },
            success: function (data) {
                if(data == 200){
                    var appurl = getAppCurUrl();
                    var url = appurl + '/backendAdminController/toExpandingReading';
                    layer.msg('删除成功', {time: 2000}, function () {
                        return unifiedSkip('', 1, url)
                    });
                }
            }
        });
    }

    function fromsubmitnewsTable(){
        var uuid = $("#uuid").val();
        var detail = CKEDITOR.instances.detail.getData();
//        console.log(detail);
        var essayInfoHistoryPo = {
            uuid: uuid,
            detail: detail
        }

        $.ajax({
            url: '${pageContext.request.contextPath}/backendAdminController/updateExpandingReadingDetail',
            type: "POST",
            dataType: 'json',
            data: {
                essayInfoHistoryPoStr: JSON.stringify(essayInfoHistoryPo)
            },
            success: function (data) {
                if(data == 200){
                    var appurl = getAppCurUrl();
                    var url = appurl + '/backendAdminController/toExpandingReading';
                    layer.msg('修改成功', {time: 2000}, function () {
                        return unifiedSkip('', 1, url)
                    });
                }
            }
        });
    }

</script>
<script type="text/javascript">


</script>

</body>
</html>