//客户端统一跳转(解决返回按钮失效问题)
function unifiedSkip(title, loadType, url) {
    // var userAgentInfo = navigator.userAgent;
    // //alert(userAgentInfo+"*");
    // var Agents = ["Android", "iPhone", "ios",
    //     "SymbianOS", "Windows Phone",
    //     "iPad", "iPod"];
    // var flag = true;
    // for (var v = 0; v < Agents.length; v++) {
    //     if (userAgentInfo.indexOf(Agents[v]) > 0) {
    //         flag = false;
    //         break;
    //     }
    // }
    //
    // var wechat = "micromessenger";
    // //是微信客户端
    // if (userAgentInfo.toLowerCase().indexOf(wechat) > 0) {
    //     flag = true;
    //     //alert('是微信内置浏览器');
    // }
    //
    // //alert(userAgentInfo);
    // if (flag) {
    //     window.location.href = url;
    // }
    // if (loadType === 0) {
    //     jsBridge.postNotification('CLIENT_OPEN_URL', {
    //         'tabBarShowFlag': 1,
    //         'title': title,
    //         'loadType': loadType,
    //         'toolbarType': 2,
    //         'webUrl': url + '#INNER'
    //     });
    // } else {
    //     jsBridge.postNotification('CLIENT_OPEN_URL', {
    //         'tabBarShowFlag': 1,
    //         'title': title,
    //         'loadType': loadType,
    //         'toolbarType': 2,
    //         'webUrl': url
    //     });
    // }
    //alert('111111');
    if (isFromCXApp()) {
        //alert('是客户端');
        if (loadType === 0) {
            jsBridge.postNotification('CLIENT_OPEN_URL', {
                'tabBarShowFlag': 1,
                'title': title,
                'loadType': loadType,
                'toolbarType': 2,
                'webUrl': url + '#INNER'
            });
        } else {
            jsBridge.postNotification('CLIENT_OPEN_URL', {
                'tabBarShowFlag': 1,
                'title': title,
                'loadType': loadType,
                'toolbarType': 2,
                'webUrl': url
            });
        }
    } else {
        //alert('不是客户端');
        window.location.href = url
    }

}

// 获取当前Url
function getAppCurUrl() {
    // var current_url = window.location.protocol + '//' + window.location.host + ':' + window.location.port;
    var current_url = window.location.protocol + '//' + window.location.host;
    return current_url;
}

function isSkipExternalLink(originalLink, nodeTypeId, externalLink) {
    return nodeTypeId == 4 && externalLink != null && externalLink != "" ? externalLink : originalLink;
}

function isWeixinBrowser() {
    var ua = navigator.userAgent.toLowerCase();
    return (/micromessenger/.test(ua));
}

function isFromCXApp() {
    var ua = navigator.userAgent.toLowerCase();
    return (/chaoxingstudy/.test(ua));
}
