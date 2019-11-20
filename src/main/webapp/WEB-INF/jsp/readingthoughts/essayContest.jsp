<!DOCTYPE html>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>活动</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/readingThought/essayContest.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/commonJs/jquery-1.9.0.min.js"></script>
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

            $("#adminLoginOut").click(function () {
                var url = "${pageContext.request.contextPath}/backendAdminController/adminLoginOut";
                window.location.href = url;
            });
        })
    </script>
    <style type="text/css">
        *{ margin: 0; padding: 0; }

        /*所需样式*/
        .clear{ clear: both; }
        .lyer{ width: 100%; padding: 10px 15px; box-sizing: border-box;  }
        .lyer-delt { float: right; cursor: pointer; }
        .lyerCnt{ width: 100%; overflow: hidden; margin-top: 15px; }
        .lyerLabel{ width: 20%; text-align: right;display: block; float: left; font-size: 14px; line-height: 32px; }
        .lyerInput{ width: 73%; height: 30px; line-height: 30px border:1px solid #a8a8a8; padding: 0 10px; outline: none; }
        .lyerTxea{ width: 73%; border:1px solid #d5d5d5; resize: none; outline: none; padding: 10px; height: 100px; background:transparent; font-family: '微软雅黑'; }
        .lyerBtn{ text-align: center; }
        .lyerBtn input { margin: 0 8px; height: 30px; line-height: 30px; border: 0; width: 70px; cursor: pointer; text-align: center; color: #fff; outline: none; }
        .btnCancle{ background: #9e9e9e; }
        .btnEnter{ background: #3572e3; }
    </style>
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
            <div class="content_top"><i class="icon"></i>活动</div>
            <div class="content_search">
                <div class="college">
                    活动名称：<input id="essayname" type="text" value="${kw}"  onkeypress="if (event.keyCode == 13) listEssayInfoByKw();">
                </div>
                <div class="button">
                    <input type="button" value="查找" onclick="listEssayInfoByKw()">
                </div>
                <div class="button">
                    <input type="button" value="重置" onclick="resetEssayIndex()">
                </div>
                <div class="button">
                    <input type="button" value="新建" onclick="toPublishPage()">
                </div>
            </div>
            <div class="content_table">
                <table cellpadding="0" cellspacing="0" id="table_list">
                    <tr>
                        <th width="120">活动名称</th>
                        <%--<th width="120">主办方</th>--%>
                        <%--<th width="120">状态</th>--%>
                        <%--<th width="60">评选类型</th>--%>
                        <%--<th width="120">活动期间</th>--%>


                        <th width="120">创建时间</th>
                        <th width="120">修改时间</th>
                        <th width="120">操作</th>
                    </tr>
                    <c:forEach items="${pageBean.list}" var="bean">
                        <tr class="dataContent">
                            <td data-essay="${bean.claim}" align="center" ><span style="font-weight: bold;">${bean.title}</span></td>
                            <td align="center">
                                <fmt:formatDate value="${bean.gmtCreate}" pattern="YYYY-MM-dd HH:mm"/>
                            </td>
                            <td align="center">
                                <fmt:formatDate value="${bean.gmtModified}" pattern="YYYY-MM-dd HH:mm"/>
                            </td>
                            <td align="center">
                                <%--<c:if test="${bean.approvalType==1}">--%>
                                    <%--<a href="javascript:void(0)"--%>
                                       <%--onclick="toEssaySettingPage('${bean.uuid}','${bean.duration}')"--%>
                                       <%--class="cor">设置</a>--%>
                                <%--</c:if>--%>
                                    <c:choose>
                                        <c:when test="${bean.status==0}"><a href="javascript:void(0)" onclick="setShow('${bean.id}','${bean.title}','${bean.claim}','${bean.uuid}')" class="cor">设置前台展示</a></c:when>
                                        <c:otherwise><a href="javascript:void(0)" style="color:grey">前台展示中</a></c:otherwise>
                                    </c:choose>
                                <a href="javascript:void(0)"
                                   onclick="toModifyPage('${bean.id}','${bean.title}','${bean.claim}')"
                                   class="cor">修改</a>
                                <%--<a href="javascript:void(0)"--%>
                                   <%--onclick="deleteOneEssay('${bean.uuid}',${bean.adminId},'${bean.duration}')"--%>
                                   <%--class="cor addData">删除</a>--%>
                                <%--<a href="javascript:void(0)"--%>
                                   <%--onclick="toImportWinnerList('${bean.uuid}',${bean.adminId})"--%>
                                   <%--class="cor addData">导入获奖名单</a>--%>
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
        var pageP=${pageBean.currentPage};
        //pageInit(totalP,pageP);
        toPage(totalP,pageP);
    });
    // $(document).keyup(function (e) {
    //     if (e.keyCode == 13) {
    //         listEssayInfoByKw();
    //     }
    // });
    function toImportWinnerList(essayId) {
        //alert(11111);
        var appCurUrl = getAppCurUrl();
        var url = appCurUrl + '/backendAdminController/toImportWinnerList?essayId=' + essayId;
        return unifiedSkip("", 1, url);
    }

    function toEssaySettingPage(essayId, duration) {
        var essayTime = getJsTimeStampByJavaTimeStamp(duration);
        var curtime = new Date().getTime();
        //console.info("活动时间 = " + essayTime + ", 当前时间 = " + curtime);
        if (essayTime < curtime) {//已结束
            layer.msg('活动已结束,不能进行该操作!', {time: 2000});
        } else {
            var appCurUrl = getAppCurUrl();
            var url = appCurUrl + '/backendAdminController/toEssaySettingPage?essayId=' + essayId;
            return unifiedSkip("", 1, url);
        }
    }
    function resetEssayIndex() {
        var appCurUrl = getAppCurUrl();
        var url = appCurUrl + '/backendAdminController/toManageEssay';
        return unifiedSkip("", 1, url);
    }

    function skippage(pageNum) {
        if (pageNum > 0 && pageNum <=${pageBean.totalPage}) {
            var appCurUrl = getAppCurUrl();
            var kw = '${kw}';
            var url = appCurUrl + '/backendAdminController/toManageEssay' + "?currentPage=" + pageNum + "&kw=" + kw;
            return unifiedSkip("", 1, url);
        }

    }
    function gopage() {
        var pageNum = $("#page").val();
        if (pageNum > 0 && pageNum <=${pageBean.totalPage}) {
            var appCurUrl = getAppCurUrl();
            var kw = '${kw}';
            var url = appCurUrl + '/backendAdminController/toManageEssay' + "?currentPage=" + pageNum + "&kw=" + kw;
            return unifiedSkip("", 1, url);
        }

    }

    function toModifyPage(id, title, claim) {
        /*// var essayTime = getJsTimeStampByJavaTimeStamp(duration);
        // var curtime = new Date().getTime();
        // //console.info("活动时间 = " + essayTime + ", 当前时间 = " + curtime);
        // if (essayTime < curtime) {//已结束
        //     layer.msg('活动已结束,不能进行该操作!', {time: 2000});
        // } else {
            var url = getAppCurUrl();
            url += "/backendAdminController/toModifyPage?id=" + id + "&adminId=" + adminId;
            //return unifiedSkip('修改大賽信息', 1, url);
        // }*/

        console.log(claim)
        layer.open({
            id:1,
            type: 1,
            title:'活动内容修改',
            skin:'layui-layer-rim',
            area:['450px', 'auto'],

            content: '<div class="lyer">\n' +
            //'        <div class="lyer-delt"><img src="zjdelt.jpg"></div>\n' +
            '        <div class="clear"></div>\n' +
            '        <div class="lyerCnt">\n' +
            '            <label class="lyerLabel">活动名称：</label>\n' +
            '            <input type="text" name="" class="lyerInput" placeholder="请输入名称" id="title" value="'+title+'">\n' +
            '        </div>\n' +
            '        <div class="lyerCnt">\n' +
            '            <label class="lyerLabel">活动介绍：</label>\n' +
            '            <textarea placeholder="请输入内容" class="lyerTxea" id="content">'+claim+'</textarea>\n' +
            '        </div>\n' +
            '        <div class="lyerCnt">\n' +
            '            <label class="lyerLabel">&nbsp;</label>\n' +
            '            <div class="lyerBtn">\n' +
            //'                <input type="button" name="" value="取消" class="btnCancle"><input type="button" name="" class="btnEnter" value="确定">\n' +
            '            </div>\n' +
            '        </div>\n' +
            '    </div>'
            ,
            btn:['保存','取消'],
            btn1: function (index,layero) {
                var title = $('#title').val();
                var content = $('#content').val();
                console.log(title,content);
                modify(id,title,content);
            },
            btn2:function (index,layero) {
                layer.close(index);
            }

        });
    }
    function modify(id,title,content){
        var essayInfo = {
            id : id,
            title: title,
            claim: content

        };
        console.log(essayInfo);
        var essayInfoPoStr = escape(escape(JSON.stringify(essayInfo)));
        if(title != null && title !=''){
            $.ajax({
                url: '${pageContext.request.contextPath}/backendAdminController/modifyEssay',
                type: "POST",
                dataType: 'json',
                data: {
                    essayInfoPoStr: essayInfoPoStr
                },
                success: function (data) {
                    console.log(data);
                    //var databean = JSON.parse(data);
                    if (data.status === 200) {
                        var appurl = getAppCurUrl();
                        var url = appurl + '/backendAdminController/toManageEssay';
                        layer.msg('修改成功', {time: 2000}, function () {
                            return unifiedSkip('', 1, url)
                        });

                    }
                }
            });
        }else{
            layer.msg("请输入活动名称",{
                time:1500
            })
        }
    }
    function listEssayInfoByKw() {
        var kw = $("#essayname").val();
        var appurl = getAppCurUrl();
        var url = appurl + '/backendAdminController/toManageEssay?kw=' + kw;
        return unifiedSkip('', 1, url);
    }
    function toPublishPage() {
        var appurl = getAppCurUrl();
        var url = appurl + '/backendAdminController/toPublishPage';
        return unifiedSkip('', 1, url)
    }

    function deleteOneEssay(uuid, creatorPuid, duration) {
        var essayTime = getJsTimeStampByJavaTimeStamp(duration);
        var curtime = new Date().getTime();
        //console.info("活动时间 = " + essayTime + ", 当前时间 = " + curtime);
        if (essayTime < curtime) {//已结束
            layer.msg('活动已结束,不能进行该操作!', {time: 2000});
        } else {
            layer.open({
                content: '是否确定删除',
                btn: ['确认', '取消'],
                yes: function (index, layero) {
                    var essayInfoPo = {
                        uuid: uuid,
                        creatorPuid: creatorPuid
                    };
                    var essayInfoPoStr = escape(escape(JSON.stringify(essayInfoPo)));
                    $.ajax({
                        url: '${pageContext.request.contextPath}/backendAdminController/deleteEssay',
                        type: "POST",
                        dataType: 'json',
                        data: {
                            essayInfoPoStr: essayInfoPoStr
                        },
                        success: function (data) {
                            //var databean = JSON.parse(data);
                            if (data.status == 200) {
                                layer.msg('删除成功', {time: 2000 , end :function(){
                                        layer.close(index); //如果设定了yes回调，需进行手工关闭
                                        window.location.reload();
                                    }});

                            }
                        }
                    });
                }
            });
        }


    }

</script>
<script type="text/javascript">
    function setShow(id,title,content,uuid){

        var essayInfoHistoryPo = {
            title: title,
            claim: content,
            uuid: uuid
        }
        var essayInfoHistoryPoStr = escape(escape(JSON.stringify(essayInfoHistoryPo)));

        $.ajax({
            url: '${pageContext.request.contextPath}/backendAdminController/setShow',
            type: "POST",
            dataType: 'json',
            data: {
                id: id,
                essayInfoHistoryPoStr:essayInfoHistoryPoStr
            },
            success: function (data) {
                console.log(data)
                //var databean = JSON.parse(data);
                if (data== 200) {
                    layer.msg('设置成功!', {time: 2000 , end :function(){
                            window.location.reload();
                        }});

                }
            }
        });
    }
    function readingThought() {
        var appCurUrl = getAppCurUrl();
        var app_title = '';
        var url;
        url = appCurUrl + '/backendAdminController/toPcDayaEssayReadingBooks';
        return unifiedSkip(app_title, 1, url);
    }

    function toWorkJudge() {
        var url = "${pageContext.request.contextPath}/backendAdminController/toWorkJudge";
        return unifiedSkip('', 1, url);
    }
    function essayDetail(obj){
        var title=$(obj).text();
        var data=$(obj).data("essay");
        var essayHtml=' <p class="data-p"><span>大赛名称：</span>'+title+'</p>' +
                '<p class="data-p"><span>大赛要求：</span>'+data+'</p>';
        layer.open({
            type: 1,
            skin: 'layui-layer-rim', //加上边框
            area: ['420px', 'auto'], //宽高
            content: essayHtml
        });
    }
</script>

</body>
</html>