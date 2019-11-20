//相当于jquery的ready方法，客户端会自动调用这个方法
function _jsBridgeReady() {
//此行代码是在学习通页面的顶部条右边，放一个按钮，点击按钮后，会运行forwardUrl方法
    jsBridge.postNotification('CLIENT_CUSTOM_MENU', {
        show: 1,
        width: 30,
        height: 18,
        icon: 'http://home.yd.chaoxing.com/res/images/tools/forward.png',
        menu: '',
        option: "forwardUrl()"
    });
}

function forwardUrl() {
    var name = document.title;
    var resUrl = self.location.href;
    var coverUrl = "";     //logo
    var key = md5(resUrl);  //md5.js里面的方法
    jsBridge.postNotification('CLIENT_TRANSFER_INFO', {
        "cataid": "100000015",
        "cataName": "网页",
        "key": key,
        "content": {
            "toolbarType": 2,
            "resTitle": name,
            "resUrl": resUrl,
            "resUid": key,
            "resLogo": coverUrl,
            "_source": "",
            "sourceConfig": "",
            "showContent": 1,  //是否显示描述
            "resContent": "学习通分享页面" //描述
        }
    });
}


