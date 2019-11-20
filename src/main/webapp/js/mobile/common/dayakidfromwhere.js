function isFromMobileClient() {
    var userAgentInfo = navigator.userAgent;
    //alert(userAgentInfo+"*");
    var Agents = ["Android", "iPhone", "ios",
        "SymbianOS", "Windows Phone",
        "iPad", "iPod"];
    var flag = false;
    for (var v = 0; v < Agents.length; v++) {
        if (userAgentInfo.indexOf(Agents[v]) > 0) {
            flag = true;
            break;
        }
    }
    return flag;
}

function isFromWebsite() {

    var userAgentInfo = navigator.userAgent;
    //alert(userAgentInfo+"*");
    var Agents = ["Android", "iPhone", "ios",
        "SymbianOS", "Windows Phone",
        "iPad", "iPod"];
    var flag = true;
    for (var v = 0; v < Agents.length; v++) {
        if (userAgentInfo.indexOf(Agents[v]) > 0) {
            flag = false;
            break;
        }
    }
    return flag;
}