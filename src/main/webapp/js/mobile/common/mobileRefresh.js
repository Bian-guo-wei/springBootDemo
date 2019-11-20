function jsBridgeRefresh() {
    try {
        jsBridge.bind('CLIENT_REFRESH_EVENT', function (object) {//本页面刷新
            // toDisplayMobileMsg("object:" + JSON.stringify(object));
            //解决ios首页不断刷新的问题
            if ((object.mesage != null && object.mesage === "") ||//ios,注意属性名为mesage
                object.type === 1) {//android
                window.location.reload();
            }
        });
    } catch (e) {

    }
    jsBridge.postNotification("CLIENT_REFRESH_STATUS", {//通知前一页面刷新
        "status": 1
    });
}

