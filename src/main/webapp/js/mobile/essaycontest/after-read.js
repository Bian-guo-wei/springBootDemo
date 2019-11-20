$(".btn").on("click", function () {
    var $title = $(".title-inp").val(),
        $content = $(".content-text").val(),
        //FIXME:做非空判断
        $resourceId = $("#resourceId").val();
    var appCurUrl = getAppCurUrl();
    var $url = appCurUrl + "/api/v1/readingId/" + $resourceId + "/reading_thought";
    $url = encodeURI($url);
    $.ajax({
        type: "post",
        url: $url,
        data: {title: $title, content: $content},
        dataType: "json",
        success: function (data) {
            var _data = JSON.parse(data);
            console.log(_data);
            console.log(typeof(_data.status), _data.status);
            if (_data.status === 200) {
                layer.msg("提交成功", {time: 2000});
                setTimeout(function () {
                    window.location.href = appCurUrl + '/mobileEssayController/toReadingThought?resourceId=' + $resourceId;
                }, 1500)
            }
        }
    });
});