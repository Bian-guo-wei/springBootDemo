//跳转到学习通内通知详细页
function toMobileNoticeCard(noticeId) {
    jsBridge.postNotification('CLIENT_OPEN_NOTICE_BYID',
        {"NoticeID": noticeId});
}

function toDisplayMobileMsg(msg) {
    if (isFromCXApp()) {
        //alert('是客户端');
        jsBridge.postNotification('CLIENT_DISPLAY_MESSAGE', {'message': msg});

    } else {
        //alert('不是客户端');
        alert(msg);
    }
}