function _jsBridgeReady() {
    //通过客户端协议获取用户信息
    //	 	绑定获取学习通登录状态
    try {
        jsBridge.bind('CLIENT_LOGIN_STATUS', function (object) {
            var loginStatus = object.status;
            if (loginStatus == '1' || loginStatus == 1) {

            } else if (loginStatus == '0' || loginStatus == 0) {
//	 							使用学习通但未登录则显示
                $(".onload").show();
            }
        });
    } catch (e) {
    }
//	 			获取学习通登录状态
    jsBridge.postNotification('CLIENT_LOGIN_STATUS', {
        "accountKey": ""
    });


    // //  绑定获取学习通登录人信息
    // 	try {
    // 		jsBridge.bind('CLIENT_GET_USERINFO', function(object) {
    // 			var userStatus = object.status;
    // 			var mobileUid = object.uid;
    // 			var mobilePuid = object.puid;
    // 			var mobileUidName = 'mobileUid';
    // 			var mobilePuidName = 'mobilePuid';
    // 			// 学习通用户信息在此设置到cookie中
    // 			if (existCookie(mobileUidName)) {
    // 				removeAppCookie(mobileUidName);
    // 				setAppCookie(mobileUidName, mobileUid);
    // 				// 登录学习通则显示评论
    // 				if (userStatus == "1" || userStatus == '1') {
    // 					jsBridge.postNotification('CLIENT_DISPLAY_MESSAGE', {
    // 						'message' : '欢迎登录'        //应该是'message' : '欢迎登录${appWelcomeMsg}'
    // 					});
    // 					$("#topicPl").css("display", "block");
    // 				} else if (userStatus == "0" || userStatus == '0') {
    // 					window.location.reload();
    // 				}
    // 			} else {
    // 				$(".onload").hide();
    // 				jsBridge.postNotification('CLIENT_DISPLAY_MESSAGE', {
    // 					'message' : '正在获取您的登录信息'
    // 				});
    // 				setAppCookie(mobileUidName, mobileUid);
    // 				window.location.reload();
    // 			}
    // 			if (existCookie(mobilePuidName)) {
    // 				removeAppCookie(mobilePuidName);
    // 				setAppCookie(mobilePuidName, mobilePuid);
    // 				// 登录学习通则显示评论
    // 				if (userStatus == "1" || userStatus == '1') {
    // 					jsBridge.postNotification('CLIENT_DISPLAY_MESSAGE', {
    // 						//'message' : '欢迎登录${appWelcomeMsg}'
    // 					});
    // 					$("#topicPl").css("display", "block");
    // 				} else if (userStatus == "0" || userStatus == '0') {
    // 					window.location.reload();
    // 				}
    // 			} else {
    // 				$(".onload").hide();
    // 				jsBridge.postNotification('CLIENT_DISPLAY_MESSAGE', {
    // 					'message' : '正在获取您的登录信息'
    // 				});
    // 				setAppCookie(mobilePuidName, mobilePuid);
    // 				window.location.reload();
    // 			}
    // 			// 删除'appUnitName'的cookie
    // 			var appSchoolName = 'appUnitName';
    // 			removeAppCookie(appSchoolName);
    // 			// 获取进入学习通的机构名，并设置在cookie中
    // 			var unit_name = window.info.unit_name;
    // 			var escape_name = escape(escape(unit_name));
    // 			setAppCookie(appSchoolName, escape_name);
    //
    // 		});
    // 	} catch (e) {
    //
    // 	}

    // //获取登录人信息
    // jsBridge.postNotification('CLIENT_GET_USERINFO', {
    // 	"accountKey" : ""
    // });
    try {
        jsBridge.bind('CLIENT_SUBSCRIBE_RES', function (object) {
            var appResSub = object.status;
            if (appResSub == "1" || appResSub == '1') {
                window.location.reload();
            }
        });
    } catch (e) {

    }

    //绑定res订阅状态
    try {
        jsBridge
            .bind(
                'CLIENT_RES_SUBSCRIPTION_STATUS',
                function (object) {
                    var appSubStatus = object.status;
                    if (appSubStatus == "1" || appSubStatus == '1') {
                        jsBridge
                            .postNotification(
                                'CLIENT_CUSTOM_MENU',
                                {
                                    show: 1,
                                    icon: 'http://zhuanti.chaoxing.com/res/images/special/yidingyue.png',
                                    menu: '',
                                    option: 'resRemove()'
                                });
                        jsBridge.postNotification(
                            'CLIENT_REFRESH_EVENT', function (
                                object) {
                                window.location.reload();
                            });
                    } else {
                        //未订阅
                        //res订阅功能
                        //定制顶部条右侧菜单--在_jsBridgeReady（）里调用，为了是让客户端将资源协议准备好，再通知客户端在顶部条右侧加菜单，这样才能添加成功。
                        jsBridge
                            .postNotification(
                                'CLIENT_CUSTOM_MENU',
                                {
                                    show: 1,
                                    icon: 'http://zhuanti.chaoxing.com/res/images/special/dingyue.png',
                                    menu: '',
                                    option: 'subWeb()'
                                });
                    }

                });
    } catch (e) {

    }

    //绑定取消res订阅
    try {
        jsBridge.bind('CLIENT_REMOVE_RES', function (object) {
            var removeStatus = object.status;
            if (removeStatus == "1" || removeStatus == '1') {
                window.location.reload();
            }
        });
    } catch (e) {

    }

    //res订阅状态
    jsBridge.postNotification('CLIENT_RES_SUBSCRIPTION_STATUS', {
        "cataid": 100000015,
        "key": window.info.subscribeSid
    });

    /*	$("#specialCreater").click(function() {
            var url = '${unitTopicInfo.transferDescLink}';
            var name = '${unitTopicInfo.originalName}';
            return unifiedSkip(name, 1, url);
        });
*/
    $("#subScribeDetail")
        .click(
            function () {
                var subNum = $("#subScribeDetail").attr(
                    "subScribeNumber");
                if (subNum == 0 || subNum == '0' || subNum == null) {

                } else {
                    var libId = window.info.libId;
                    var nodeUid = window.info.nodeUid;
                    var name = window.info.name;
                    var appCurUrl = getAppCurUrl();
                    var url = appCurUrl
                        + '/resWarehouseLibController/toSubscribeDetail?libId='
                        + libId + '&nodeUid=' + nodeUid;
                    return unifiedSkip(name, 1, url);
                    //     	window.location.href=url;
                }
            });

    //RecScribe.article_jsBridgeReady();
}

function subWeb() {
    var currentUrl = window.location.href;
    var appKey = window.info.subscribeSid;
    var appResTitle = window.info.appResTitle;
    var appResLogo = window.info.appResLogo;
    jsBridge.postNotification("CLIENT_SUBSCRIBE_RES", {
        "cataid": 100000015,
        "cataName": "网址",
        "key": appKey,
        "content": {
            "toolbarType": 2,
            "resTitle": appResTitle,
            "resUrl": currentUrl,
            "resUid": appKey,
            "resLogo": appResLogo
        }
    });
}

//实际取消订阅
function resRemove() {
    jsBridge.postNotification('CLIENT_REMOVE_RES', {
        "cataid": 100000015,
        "key": window.info.subscribeSid
    });
}
