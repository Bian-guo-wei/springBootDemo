(function (W, $, B) {

    if (typeof W.AppUtils != 'undefined') {
        return;
    }

    function AppUtils() {
    }

    /**
     * 退出客户端
     *
     * @param tips 退出时的提示信息
     */
    AppUtils.prototype.exit = function (tips) {
        var cmd = 'CLIENT_EXIT_WEBAPP';

        B.postNotification(cmd, {
            message: tips || ''
        });
    };

    /**
     * 退回到首页
     * @param tips 退出时的提示信息
     */
    AppUtils.prototype.backHome = function (tips) {
        var cmd = 'CLIENT_BACK_HOME';

        B.postNotification(cmd, {
            message: tips || ''
        });
    }

    /**
     * 退出当前webview
     *
     * @param tips 退出时的提示信息
     */
    AppUtils.prototype.closeView = function (tips) {
        var cmd = 'CLIENT_EXIT_LEVEL';

        B.postNotification(cmd, {
            message: tips || ''
        });
    };

    /**
     * 打开语音识别
     *
     * @param tips 打开语音识别时的提示信息
     * @param callBack 接收语音识别回调方法
     */
    AppUtils.prototype.openSpeech = function (tips, callBack) {
        var cmd = 'CLIENT_SPEECH_RECOGNIZER';

        B.unbind(cmd);

        callBack && B.bind(cmd, callBack);

        B.postNotification('CLIENT_SPEECH_RECOGNIZER', {
            message: tips || ''
        });
    };

    /**
     * 打开条形码
     *
     * @param tips 打开条形码时的提示信息
     * @param callBack 条形码识别后的回调方法
     */
    AppUtils.prototype.openScanner = function (tips, callBack) {
        var cmd = 'CLIENT_BARCODE_SCANNER';

        B.unbind(cmd);

        callBack && B.bind(cmd, callBack);

        B.postNotification(cmd, {
            manualInputTitle: tips || ''
        });
    };

    /**
     * 打开视频播放器
     *
     * @param option 可以是数组或一个object对象（视频信息）
     */
    AppUtils.prototype.openVideoPlayer = function (option) {

        if ($.isEmptyObject(option)) {
            return;
        }

        var cmd = 'CLIENT_VIDEO_PLAYER';

        var defultOpt = {
            seriesid: 0, // 系列id
            title: '', // 视频标题
            videopathm3u8: '', // m3u8视频播放地址
            videopathmp4: '', // mp4播放地址
            candownload: 0 // 是否允许下载,默认不允许下载  (1可以下载，0不可下载)
        };

        var videos = new Array();

        if ($.isArray(option)) {
            for (var i = 0, o; o = option[i++];) {
                if (!$.isEmptyObject(o)) {
                    videos.push($.extend(defultOpt, o));
                }
            }
        } else {
            videos.push($.extend(defultOpt, option));
        }

        B.postNotification(cmd, {videolist: videos});
    };

    /**
     * 打开图书
     *
     * @param option 图书信息， obejct对象
     */
    AppUtils.prototype.openBook = function (option) {

        if ($.isEmptyObject(option)) {
            return;
        }

        var cmd = 'CLIENT_READ_BOOK';

        B.postNotification(cmd, $.extend({
            type: 'pdz', // 图书类型， 默认是pdz
            uniqueID: '', // 唯一id, 这里是ssid
            remoteUrl: '', // 图书下载地址，book协议地址
            bookName: '', // 图书名
            message: '', // 信息
            coverUrl: '' // 封面地址
        }, option));
    };

    /**
     * 下载图书
     *
     * @param option 图书信息， obejct对象
     */
    AppUtils.prototype.downloadBook = function (option) {

        if ($.isEmptyObject(option)) {
            return;
        }

        var cmd = 'CLIENT_DOWNLOAD_BOOK';

        B.postNotification(cmd, $.extend({
            type: 'pdz', // 图书类型， 默认是pdz
            uniqueID: '', // 唯一id, 这里是ssid
            remoteUrl: '', // 图书下载地址，book协议地址
            bookName: '', // 图书名
            message: '', // 信息
            coverUrl: '' // 封面地址
        }, option));
    };

    /**
     * 定制菜单 (注：此方法必须放在 _jsBridgeReady方法中执行)
     *
     * @param option 数组或obejct对象，菜单信息
     */
    AppUtils.prototype.customMenu = function (option) {

        if ($.isEmptyObject(option)) {
            return;
        }

        var cmd = 'CLIENT_CUSTOM_MENU';

        B.postNotification(cmd, $.extend({
            index: 0,
            show: 1, //是否显示  1显示，0不显示
            width: '',
            height: '',
            icon: '', //菜单图标，为空或没有此属性，则不显示
            menu: '', //菜单名称，为空或没有此属性，则不显示
            option: '', //操作，实际类型为js方法，在客户端上调用webapp内的js方法
            children: [] //为子菜单列表，如上述属性
        }, option));
    };


    /**
     * 打开讨论组
     * @param type  类型（专题类型值为3000）
     * @param name 专题名称
     * @param sid  专题编号
     * @param puid 生成小组时指定小组创建者为puid；如果不需要为空默认创建者为小星
     */
    AppUtils.prototype.clientOpenGroup = function (type, name, sid, puid) {

        var cmd = 'CLIENT_OPEN_GROUP';

        B.postNotification(cmd, {
            GroupInfo: {
                type: type,
                name: name,
                sid: sid,
                puid: puid
            }
        });
    };
    /**
     * 打开话题列表
     * @param GroupId
     * @param Groupbbsid
     * @param needRecord
     */
    AppUtils.prototype.clientOpenTopicList = function (GroupId, Groupbbsid) {
        if ($.trim(GroupId) == '' && $.trim(Groupbbsid) == '') return;
        var cmd = 'CLIENT_OPEN_GROUP';
        B.postNotification(cmd, {
            GroupId: GroupId,
            Groupbbsid: Groupbbsid,
            needRecord: 'true'
        });
    }
    /**
     * 获取登录状态
     *
     * @param accountKey 账户类型的key, "" (空字符串)为统一认证用户信息, "cx_fanya"为泛雅用户信息， "cx_opac"为opac用户信息
     * @param callback 获取登录状态的回调方法
     */
    AppUtils.prototype.getLoginState = function (accountKey, callback) {

        if (accountKey == null) {
            return;
        }

        var cmd = 'CLIENT_LOGIN_STATUS';

        B.unbind(cmd);

        callback && B.bind(cmd, callback);

        B.postNotification(cmd, {
            accountKey: accountKey
        });
    };

    /**
     * 客户端打开链接地址，可以是webview或客户端浏览器, 默认使用webview打开，默认不检查是否登录
     *
     * @param option object对象
     */
    AppUtils.prototype.openUrl = function (option) {

        if ($.isEmptyObject(option)) {
            return;
        }

        var cmd = 'CLIENT_OPEN_URL';

        if (/.*[\u4e00-\u9fa5]+.*$/.test(option.webUrl)) {//有中文进行编码
            option.webUrl = encodeURI(option.webUrl);
        }
        B.postNotification(cmd, $.extend({
            tabBarShowFlag: 0,
            title: '', //标题
            loadType: 1, //打开方式，0在本页面打开，1使用客户端webview打开新页面，2打开系统浏览器
            webUrl: '' //要打开的url
        }, option));
    };

    /**
     * 分享
     *
     * @param option object, 分享内容
     */
    AppUtils.prototype.share = function (option) {

        if ($.isEmptyObject(option)) {
            return;
        }

        var cmd = 'CLIENT_SHARE_ITEM';

        B.postNotification(cmd, $.extend({
            url: '',  //网页地址
            imgUrl: '', //图片地址
            type: 0, //类型，目前只有0表示网页
            title: '', //标题
            content: '' //文字描述
        }, option));
    };

    /**
     * 获取书架图书
     *
     * @param ids ids id 或 id数组
     * @param callback 获取到图书后的回调方法
     */
    AppUtils.prototype.getShelfBooks = function (ids, callback) {

        if (ids == null) {
            return;
        }

        var cmd = 'CLIENT_BOOKS_ON_SHELF';
        var bookIds = null;

        if ($.isArray(ids)) {
            bookIds = ids;
        } else {
            bookIds = new Array();
            bookIds.push(ids);
        }

        B.unbind(cmd);

        callback && B.bind(cmd, callback);

        B.postNotification(cmd, bookIds);
    };

    /**
     * 打开图书详情
     *
     * @param option object对象
     */
    AppUtils.prototype.getBookDetail = function (option) {

        if ($.isEmptyObject(option)) {
            return;
        }

        var cmd = 'CLIENT_OPEN_BOOK_DETAIL';

        B.postNotification(cmd, $.extent({
            dxNumber: '', //图书读秀号
            d: '', //读秀加密串
            languageType: 0 //语言类型，0：中文，1:外文
        }, option));
    };

    /**
     * 打开指定app
     *
     * @param option object对象
     */
    AppUtils.prototype.openApp = function (option) {

        if ($.isEmptyObject(option)) {
            return;
        }

        var cmd = 'CLIENT_OPEN_APP';

        B.postNotification(cmd, $.extent({
            appid: '', //应用id
            appname: '' //应用名称
        }, option));
    };

    /**
     * 打开不同类型的资源管理器
     *
     * @param type file:打开文件管理器, image:打开图库，相机, image_file：打开图库，相机，文件管理器
     */
    AppUtils.prototype.openResourceMgr = function (type, callback) {

        if (typeof type == 'undefined') {
            return;
        }

        var cmd = 'CLIENT_FILEINPUTTYPE';

        B.unbind(cmd);

        callback && B.bind(cmd, callback);

        B.postNotification(cmd, {
            type: type
        });
    };

    /**
     * 获取用户登录信息
     *
     * @param accountKey 账户类型的key, "" (空字符串)为统一认证用户信息, "cx_fanya"为泛雅用户信息， "cx_opac"为opac用户信息
     * @param callback 获取到用户信息的回调方法
     */
    AppUtils.prototype.getUserInfo = function (accountKey, callback) {

        if (typeof accountKey == 'undefined') {
            return;
        }

        var cmd = 'CLIENT_GET_USERINFO';

        B.unbind(cmd);

        callback && B.bind(cmd, callback);

        B.postNotification(cmd, {
            accountKey: accountKey
        });
    };


    /**
     * 调用客户端登录
     *
     * @param accountKey 账户类型的key, "" (空字符串)为统一认证用户信息, "cx_fanya"为泛雅用户信息， "cx_opac"为opac用户信息
     * @param callback 客户端登录后的回调方法
     */
    AppUtils.prototype.doAppLogin = function (accountKey, callback) {

        if (typeof accountKey == 'undefined') {
            return;
        }

        var cmd = 'CLIENT_LOGIN';

        B.unbind(cmd);

        callback && B.bind(cmd, callback);

        B.postNotification(cmd, {
            accountKey: accountKey
        });
    };

    /**
     * 调用手机通讯录，选择联系人
     *
     * @param callback
     */
    AppUtils.prototype.openContacts = function (callback) {

        var cmd = 'CLIENT_OPEN_CONTACTS';

        B.unbind(cmd);

        callback && B.bind(cmd, callback);

        B.postNotification(cmd);
    };
    /**
     * 调用客户端消息提示
     * @param message
     */
    AppUtils.prototype.clientMessageDisplay = function (message) {
        B.postNotification('CLIENT_DISPLAY_MESSAGE', {
            message: message
        });
    };
    AppUtils.prototype.clientOpenUserInfo = function (userId, loginUserFid) {
        var url = "http://group.yd.chaoxing.com/zt/" + userId + "/getUserInfo?callback=?";
        $.getJSON(url, function (data) {
            var status = data.status;
            if (status) {
                var user = data.data;
                if (undefined == user) return;
                var uid = user.uid || 0;
                var fid = user.fid || 0;
                var param = "";
                if (uid == 0) {
                    param = {UserID: '', passportID: '' + userId + ''};
                    //如果查看的人的单位是超星集团并且当前登陆人的单位不是超星集团则隐藏单位
                    if (fid == 1385 && loginUserFid != 1385) {
                        param.source = 'zhuanti';

                    }
                    B.postNotification('CLIENT_OPEN_USERINFO', param);
                } else {
                    param = {UserID: '' + uid + '', passportID: ''};
                    if (fid == 1385 && loginUserFid != 1385) {
                        param.source = 'zhuanti';
                    }
                    B.postNotification('CLIENT_OPEN_USERINFO', param);
                }

            }
        });

    };

    AppUtils.prototype.clientOpenXXTUserInfo = function (userId) {
        B.postNotification('CLIENT_OPEN_USERINFO', {
            UserID: '' + userId + '',
            passportID: ''
        });

    };
    /**
     * 转发
     * @param content
     * @param quoteInfo
     */
    AppUtils.prototype.clientTransferInfo = function (content, quoteInfo) {
        B.postNotification('CLIENT_TRANSFER_INFO', {
            cataid: "100000001",
            content: content,
            quoteInfo: quoteInfo
//			docContent:docContent
        });
    };
    /**
     * 发表话题
     * @param circleId 小组id
     * @param TopicId 话题id
     * @param rights
     */
    AppUtils.prototype.addBBSTopic = function (bbsid, circleId, TopicId, rights, inputType, flagInfo) {
        var cmd = 'CLIENT_WRITE_TOPIC';
        B.postNotification(cmd, {
            Groupbbsid: bbsid,
            GroupId: circleId,
            TopicId: TopicId,
            rights: rights,
            inputType: 0,
            flagInfo: flagInfo
        });
    };
    /**
     * 打开话题详情
     * @param bbsid
     * @param circleId
     * @param TopicId
     * @param rights
     */
    AppUtils.prototype.clientOpenTopicDieail = function (bbsid, circleId, rights, THIS) {
        var TopicId = $(THIS).attr("_attr");
        var cmd = 'CLIENT_OPEN_TOPIC';
        B.postNotification(cmd, {
            Groupbbsid: bbsid,
            GroupId: circleId,
            TopicId: TopicId,
            rights: rights
        });
    }
    AppUtils.prototype.clientSendNotice = function (id, name) {
        var cmd = 'CLIENT_OPEN_SEND_NOTICE';
        B.postNotification(cmd, {
            subject: [{
                id: id,
                name: name
            }]
        });
    };
    //打开资源
    AppUtils.prototype.openRes = function (appid, appname, appurl, author, cover, puid) {
        if (appid.indexOf("mooc_") == -1) {
            appid = "mooc_" + appid;
        }
        var cataid = "100000001";//订阅分类号
        var cataName = "专题";//订阅分类名称
        var content = {
            "accountKey": "cx_fanya", //对应loginId相应的key值
            "aid": appid, //同上面的otherConfig.id
            "appid": $.md5(appurl), //md5(appurl)，appurl的md5值
            "appname": appname, //订阅源名称
            "appurl": appurl, //订阅源地址
            "available": 1, //是否可用，10不可用，1可用，默认为1
            "bind": 1,
            "cataid": cataid,
            "clientType": 127,
            "description": "", //说明信息
            "focus": 0,
            "id": -1,
            "isPrivate": 1,
            "isWebapp": 1, //是否是webapp，1是，0不是，默认为1
            "loginId": 2, //认证类型，1、opac，2、passport，0、统一认证。默认为0
            "loginUrl": "", //登录认证地址
            "logopath": cover, //图标地址
            "logoshowtype": 1, //首页图标显示方式：1、通用app显示方式，2、rss订阅源显示方式
            "needLogin": 0, //是否需要登录，1需要，0不需要，默认为0
            "needRegist": 0, //是否需要注册，1需要，0不需要，默认为0
            "norder": 0, //排序值，默认为int最大值
            "otherConfig": {
                "author": author,//创建者
                "id": appid,//专题id，专题有两种，mooc专题和云盘专题，如果是mooc专题需要在专题id前加"mooc_"前缀，如果是云盘专题需要在专题id前加“yp_”前缀
                "authorPuid": puid
            },//扩展信息
            "productId": 3,
            "properties": "", //登录提示语
            "rights": 1, //订阅源权限，默认为1
            "usable": "", //是否可订阅的验证地址
            "useClientTool": 2, //是否启用客户端工具条，1启用，0不自定义工具条，2，自定义分层结构的工具条，默认为1
            "res_src": "market"
        };
        B.postNotification("CLIENT_OPEN_RES", {
            "cataid": 100000001,
            "cataName": cataName,
            "key": appid,
            "content": content
        });
    }
////////////////////////////////////////订阅新协议start////////////////////////////////////////////////////////////
    //专题订阅
    AppUtils.prototype.recScribeImp = function (appid, appname, appurl, author, cover, callback, puid, level) {
        appid = appid + "";
        if (appid.indexOf("mooc_") == -1) {
            appid = "mooc_" + appid;
        }

        var cataid = "100000001";//订阅分类号
        var cataName = "专题";//订阅分类名称
        var content = {
            "accountKey": "cx_fanya", //对应loginId相应的key值
            "aid": appid, //同上面的otherConfig.id
            "appid": $.md5(appurl), //md5(appurl)，appurl的md5值
            "appname": appname, //订阅源名称
            "appurl": appurl, //订阅源地址
            "available": 1, //是否可用，10不可用，1可用，默认为1
            "bind": 1,
            "cataid": cataid,
            "clientType": 127,
            "description": "", //说明信息
            "focus": 0,
            "id": -1,
            "isPrivate": 1,
            "isWebapp": 1, //是否是webapp，1是，0不是，默认为1
            "loginId": 2, //认证类型，1、opac，2、passport，0、统一认证。默认为0
            "loginUrl": "", //登录认证地址
            "logopath": cover, //图标地址
            "logoshowtype": 1, //首页图标显示方式：1、通用app显示方式，2、rss订阅源显示方式
            "needLogin": 0, //是否需要登录，1需要，0不需要，默认为0
            "needRegist": 0, //是否需要注册，1需要，0不需要，默认为0
            "norder": 0, //排序值，默认为int最大值
            "otherConfig": {
                "author": author,//创建者
                "id": appid,//专题id，专题有两种，mooc专题和云盘专题，如果是mooc专题需要在专题id前加"mooc_"前缀，如果是云盘专题需要在专题id前加“yp_”前缀
                "authorPuid": puid,
                "level": level
            },//扩展信息
            "productId": 3,
            "properties": "", //登录提示语
            "rights": 1, //订阅源权限，默认为1
            "usable": "", //是否可订阅的验证地址
            "useClientTool": 2, //是否启用客户端工具条，1启用，0不自定义工具条，2，自定义分层结构的工具条，默认为1
            "res_src": "market"
        };
        // alert(JSON.stringify(content));
        //console.log(JSON.stringify(content));content);
        AppUtils.prototype.recScribe(cataid, cataName, appid, content, function (data) {
            if (callback == 0) {
                if (data.status == 1) {
                    //AppUtils.prototype.clientMessageDisplay('收藏成功！');
                    $("[name='" + appid + "']").addClass("addGroupC");
                    $("[name='" + appid + "']").attr("status", "1");
                    //$.post('/mobile/ajax/updateTagName.json',{id:"mooc_"+specialId,tagName:"热门"},function(data){});
                } else {
                    //AppUtils.prototype.clientMessageDisplay('收藏失败,请稍后重试!');
                }
            } else {
                callback(data);
            }
        });
    }


    //获取状态
    AppUtils.prototype.getSubRssscribeStateImp = function (appid, callback) {
        appid = appid + "";
        if (appid.indexOf("mooc_") == -1) {
            appid = "mooc_" + appid;
        }
        AppUtils.prototype.getSubRssscribeState("100000001", "专题", appid, function (data) {
            if (callback == 0) {
                if (data.status == 1) {
                    $("[name='" + appid + "']").addClass("addGroupC");
                    $("[name='" + appid + "']").attr("status", "1");
                }
            } else {
                callback(data);
            }
        });
    }

    //取消订阅
    AppUtils.prototype.cancelRecScribeImp = function (appid, callback) {
        appid = appid + "";
        if (appid.indexOf("mooc_") == -1) {
            appid = "mooc_" + appid;
        }
        AppUtils.prototype.cancelRecScribe("100000001", "专题", appid, function (data) {
            if (callback == 0) {
                if (data.status == 1) {
                    //AppUtils.prototype.clientMessageDisplay('取消收藏成功！');
                    $("[name='" + appid + "']").removeClass("addGroupC");
                    $("[name='" + appid + "']").attr("status", 0);
                } else {
                    //AppUtils.prototype.clientMessageDisplay('取消收藏失败,请稍后重试!');
                }
            } else {
                callback(data);
            }
        });
    }

    /**
     * 获取资源订阅状态
     * @param appurl url地址
     * @param callback 订阅状态回调方法
     */

    AppUtils.prototype.getSubRssscribeState = function (cataid, cataName, key, callback) {
        if ((typeof key == 'undefined') || (typeof cataid == 'undefined')) {
            return;
        }

        var cmd = 'CLIENT_RES_SUBSCRIPTION_STATUS';

        B.unbind(cmd);

        callback && B.bind(cmd, callback);
        B.postNotification(cmd, {
            "cataid": cataid,
            "cataName": cataName,
            "key": key
        });
    };


    /**
     * 资料市场订阅
     * @param cataid
     * @param cataName
     * @param key
     * @param content
     * @param callback
     */

    AppUtils.prototype.recScribe = function (cataid, cataName, key, content, callback) {
        if ((typeof key == 'undefined') || (typeof cataid == 'undefined') || (typeof cataName == 'undefined') || (typeof content == 'undefined')) {
            return;
        }
        var cmd = 'CLIENT_SUBSCRIBE_RES';
        B.unbind(cmd);
        callback && B.bind(cmd, callback);
        B.postNotification(cmd, {
            cataid: cataid,
            cataName: cataName,
            key: key,
            content: content
        });
    };

    /**
     * 下载专题
     * @param appid
     * @param appname
     * @param appurl
     * @param author
     * @param cover
     * @param puid
     * @param downUrl
     * @param abscissa
     * @param ordinate
     */
    AppUtils.prototype.downSpecial = function (appid, appname, appurl, author, cover, puid, downUrl, packageSize, abscissa, ordinate) {
        appid = appid + "";
        if (appid.indexOf("mooc_") == -1) {
            appid = "mooc_" + appid;
        }
        var cataid = "100000001";//订阅分类号
        var cataName = "专题";//订阅分类名称
        var content = {
            "accountKey": "cx_fanya", //对应loginId相应的key值
            "aid": appid, //同上面的otherConfig.id
            "appid": $.md5(appurl), //md5(appurl)，appurl的md5值
            "appname": appname, //订阅源名称
            "appurl": appurl, //订阅源地址
            "available": 1, //是否可用，10不可用，1可用，默认为1
            "bind": 1,
            "cataid": cataid,
            "clientType": 127,
            "description": "", //说明信息
            "focus": 0,
            "id": -1,
            "isPrivate": 1,
            "isWebapp": 1, //是否是webapp，1是，0不是，默认为1
            "loginId": 2, //认证类型，1、opac，2、passport，0、统一认证。默认为0
            "loginUrl": "", //登录认证地址
            "logopath": cover, //图标地址
            "logoshowtype": 1, //首页图标显示方式：1、通用app显示方式，2、rss订阅源显示方式
            "needLogin": 0, //是否需要登录，1需要，0不需要，默认为0
            "needRegist": 0, //是否需要注册，1需要，0不需要，默认为0
            "norder": 0, //排序值，默认为int最大值
            "otherConfig": {
                "author": author,//创建者
                "id": appid,//专题id，专题有两种，mooc专题和云盘专题，如果是mooc专题需要在专题id前加"mooc_"前缀，如果是云盘专题需要在专题id前加“yp_”前缀
                "authorPuid": puid
            },//扩展信息
            "productId": 3,
            "properties": "", //登录提示语
            "rights": 1, //订阅源权限，默认为1
            "usable": "", //是否可订阅的验证地址
            "useClientTool": 2, //是否启用客户端工具条，1启用，0不自定义工具条，2，自定义分层结构的工具条，默认为1
            "res_src": "market"
        };
        AppUtils.prototype.showDownloadButton(cataid, cataName, appid, downUrl, packageSize, abscissa, ordinate, content);
    }
    /**
     * 显示专题下载按钮
     * @param cataid
     * @param cataName
     * @param key
     * @param downUrl 下载地址
     * @param abscissa 横坐标
     * @param ordinate 纵坐标
     * @param content
     */
    AppUtils.prototype.showDownloadButton = function (cataid, cataName, key, downUrl, packageSize, abscissa, ordinate, content) {
        if ((typeof key == 'undefined') || (typeof cataid == 'undefined') || (typeof cataName == 'undefined') || (typeof content == 'undefined') || (typeof downUrl == 'undefined')) {
            return;
        }
        var cmd = 'CLIENT_DOWNLOAD_RES';
        B.unbind(cmd);
        B.postNotification(cmd, {
            cataid: cataid,
            cataName: cataName,
            key: key,
            downUrl: downUrl,
            packageSize: packageSize,
            abscissa: abscissa,
            ordinate: ordinate,
            content: content
        });
    }
    /**
     * 资料市场取消订阅
     * @param cataid
     * @param cataName
     * @param key
     */
    AppUtils.prototype.cancelRecScribe = function (cataid, cataName, key, callback) {
        if ((typeof key == 'undefined') || (typeof cataid == 'undefined')) {
            return;
        }
        var cmd = 'CLIENT_REMOVE_RES';
        B.unbind(cmd);
        callback && B.bind(cmd, callback);
        B.postNotification(cmd, {
            cataid: cataid,
            cataName: cataName,
            key: key
        });
    };

///////////////////////////////////////////订阅新协议end/////////////////////////////////////////////////////////////

    /**
     * 获取订阅状态
     * @param appurl url地址
     * @param callback 订阅状态回调方法
     */
    //老的订阅协议
    /*
	AppUtils.prototype.getSubscribeState = function(appurl, callback) {
		
		if (typeof appurl == 'undefined') {
			return;
		}
		
		var cmd = 'CLIENT_APP_SUBSCRIPTION_STATUS';
		
		B.unbind(cmd);
		
		callback && B.bind(cmd, callback);
		
		B.postNotification(cmd, {
			appurl: appurl
		});
	};
	*/
    /**
     * 将网页订阅到首页
     *
     * @param option object对象
     */
    //老的订阅协议
    /*
	AppUtils.prototype.subscribe = function(option,callback) {
		if ($.isEmptyObject(option)) {
			return;
		}
		var cmd = 'CLIENT_SUBSCRIBE_APP';

		B.unbind(cmd);
		
		callback && B.bind(cmd, callback);
		
		B.postNotification(cmd, $.extend({
			appname: '', //订阅源名称
			loginId: 0, //认证类型，1、opac，2、passport，0、统一认证。默认为0
			appurl: '', //订阅源地址
			available: 1, //是否可用，10不可用，1可用，默认为1
			logoPath: '', //图标地址
			isWebapp: 1, //是否是webapp，1是，0不是，默认为1
			useClientTool: 2, //是否启用客户端工具条，1启用，0不自定义工具条，2，自定义分层结构的工具条，默认为1
			needLogin: 0, //是否需要登录，1需要，0不需要，默认为0
			needRegist: 0, //是否需要注册，1需要，0不需要，默认为0
			norder: 0, //排序值，默认为int最大值
			loginUrl: '', //登录认证地址
			properties: '', //登录提示语
			extendField: '', //扩展信息
			description: '', //说明信息
			usable: '', //是否可订阅的验证地址
			logoshowtype: 1, //首页图标显示方式：1、通用app显示方式，2、rss订阅源显示方式
			rights: 1, //订阅源权限，默认为1
			loginkey: '' //对应loginId相应的key值
		}, option));
	};
	*/
    /**
     * 取消专题订阅
     * @param cataid
     * @param cataName
     * @param key
     */
    //老的订阅协议
    /*
	AppUtils.prototype.cancelSpecialSubscribe = function(cataName,key,callback){
		var cmd = 'CLIENT_REMOVE_RES';
		B.unbind(cmd);
		callback && B.bind(cmd, callback);
		
		B.postNotification(cmd,{
				cataid:'100000001',
				cataName:cataName,
				key:key
		});
	}
	*/
    /**
     * 打开和保存图片
     * @param img_url
     * @param index
     */
    AppUtils.prototype.clientPreviewImages = function (img_urlArray, index) {
        var cmd = 'CLIENT_PREVIEW_IMAGES';
        B.postNotification(cmd, {
            imageUrls: img_urlArray,
            showIndex: index
        });
    };

    /**
     * 显示话题回复框
     * @param groupId
     * @param topicInfo
     * @param imgageWidht
     */
    AppUtils.prototype.showTopicReplyBar = function (flagInfo, groupId, topicInfo, imageWidth) {
        if (undefined == groupId || groupId == '') return;
        var cmd = 'CLIENT_SHOW_TOPIC_REPLY_BAR';

        B.postNotification(cmd, {
            flagInfo: flagInfo,
            groupId: groupId,
            topicInfo: topicInfo,
            imageWidth: imageWidth
        });
    }

    /**
     * 打开话题回复框
     * @param replyInfo
     * @param replyLevel
     * @param imgageWidht
     * @param callback
     */
    AppUtils.prototype.triggerReplyInput = function (inputType, groupId, topicInfo, flagInfo, replyInfo, replyLevel, imageWidth) {
        var cmd = "CLIENT_TRIGGER_REPLY_INPUT";
        B.postNotification(cmd, {
            inputType: inputType,
            groupId: groupId,
            topicInfo: topicInfo,
            flagInfo: flagInfo,
            replyInfo: replyInfo,
            replyLevel: replyLevel,
            imageWidth: imageWidth
        });
    }
    /**
     * 打开客户端花瓣 + 星星
     * @param type
     * @param petalInfo  如：{"count": {"friendsCount": 48,"myStarCount": 0.2,"mySpecialsSubCount": 5,"noteCount": 12,"opendNoteCount": 1,"pv": 24816,"subCount": 44,"topicCount": 139},
	 * "userInfo": {"sex": 1,"isFriend": 1,"right": 8,"name": "王峰（研发）","uid": 20970448}}
     */
    AppUtils.prototype.clientShowPetal = function (type, petalInfo) {
        B.postNotification('CLIENT_SHOW_PETAL', {
            "type": type,
            "petalInfo": petalInfo
        });
    };

    /**
     * 添加/删除好友
     * @param friendid
     * @param operate 0：添加好友 1：删除好友(默认0)
     */
    AppUtils.prototype.clientOperateFriend = function (friendid, operate, callback) {

        var cmd = 'CLIENT_OPERATE_FRIEND';
        B.unbind(cmd);

        callback && B.bind(cmd, callback);

        B.postNotification(cmd, {
            "friendid": friendid,
            "operate": operate
        });
    };
    /**
     * 支付
     * @param sid
     * @param money
     */
    AppUtils.prototype.pay = function (sid, money) {
        if ($.trim(sid) == "" || $.trim(money) == "") return;
        var cmd = 'CLIENT_OPEN_PAY';
        B.unbind(cmd);
        B.postNotification(cmd, {
            "sid": sid,
            "money": money
        });
    }
    W['AppUtils'] = new AppUtils();
})(window, jQuery, jsBridge);