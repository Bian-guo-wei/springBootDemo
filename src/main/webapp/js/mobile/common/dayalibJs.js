/*$(function() {
    setTimeout(tipHide, 5000);
  });*/
// 未使用学习通打开则显示
/*$(window).load(function() {//此部分已单独提出去(web/js/windowonload.js),用以解决window.onload重复多次的问题
	if (!$.cookie('mobileUid')) {
		$(".onload").show();
	}
});*/
function tipHide() {
    $(".readTip").hide();
}

function closeBox() {
    $(".onload").hide();
}

//cookie操作
function existCookie(cookieName) {
    if ($.cookie(cookieName)) {
        return true;
    } else if (!$.cookie(cookieName)) {
        return false;
    }
}

function setAppCookie(setName, setValue) {
    $.cookie(setName, setValue, {
        expires: 1,
        path: '/',
        domain: 'dayainfo.com',
        secure: false,
        raw: true
    });
}

function removeAppCookie(removeName) {
    $.removeCookie(removeName);
    $.removeCookie(removeName, {
        path: '/',
        domain: 'dayainfo.com',
        secure: false,
        raw: true
    });
}
