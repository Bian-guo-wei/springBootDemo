var num = 1;
var pageNum = 2;
var is_running = 1;
var pageSize = 15;
var main = $("#content");
var totalPage = window.courseObj.totalPage;
var appCurUrl = getAppCurUrl();

$(window).scroll(function () {
    if ($(document).scrollTop() > $(window).height()) {
        $("#movetop").fadeIn(500);
    } else {
        $("#movetop").fadeOut(500);
    }
    var srollPos = $(window).scrollTop(); //滚动条距顶部距离(页面超出窗口的高度)
    var totalheight = parseFloat($(window).height()) + parseFloat(srollPos);
    is_running = 0;
    if (srollPos >= ($(document).height() - $(window).height()) && totalPage >= (pageNum + 1)) {
        is_running = 1;
        num = num + 2;
        $.getJSON(
            appCurUrl + "/dayaKidNoticeController/getMoreNotices?pageSize=" + pageSize + "&page=" + pageNum + "&typeId=" + window.courseObj.typeId + "&circleId=" + window.courseObj.circleId + "&schoolId=" + window.courseObj.schoolId,
            {},
            function (data) {
                if (data.length != 0) {
                    for (var i = 0; i < data.length; i++) {
                        var ele = "<div class='item'>";
                        ele += "<span class='atr'><img src='${pageContext.request.contextPath}/images/kid/round-person.jpg' width='50%'></span>";
                        ele += "<div class='info'>";
                        ele += "<p class='tit'>" + data[i].msg.createrName + "</p>";
                        ele += "<div class='finder word clearfix' onclick='toMobileNoticeCard('" + data[i].msg.id + "');'>";
                        ele += "<img src='${pageContext.request.contextPath}/images/kid/newsandnotice.png' width='34'>";
                        ele += data[i].msg.sendTime + "<br>" + data[i].msg.content;
                        ele += "</div>";
                        ele += "<div class='btarea clearfix'>";
                        ele += "<span class='date'>10-16</span>";
                        ele += "<span class='time'>17:01</span>";
                        ele += "</div>";
                        ele += "</div>";
                        ele += "</div>";
                        main.append(ele);
                    }
                    if (totalPage == (pageNum + 1)) {
                        $(".scrollMore").html("已经到底啦~");
                    }
                    pageNum++;
                }
            }
        );
    }
});