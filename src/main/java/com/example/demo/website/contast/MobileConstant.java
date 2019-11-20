package com.example.demo.website.contast;

/**
 * @author gewu
 * @time$create 2017/6/26 13:59
 */
public final class MobileConstant {

    public static final int INT_0 = 0;
    public static final String STR_0 = "0";

    /*
     * mobileUid是在前台通过协议设置的，不是直接从域名取的。
     */
    public static final String MOBILE_UID_COOKIE_NAME = "mobileUid";

    public static final int MOBILE_UID_0 = INT_0;
    public static final int MOBILE_PUID_0 = INT_0;

    public static final String MOBILE_UID_COOKIE_DEFAULT = STR_0;
    public static final String MOBILE_PUID_COOKIE_DEFAULT = STR_0;
    public static final String MOBILE_APP_CUSTOM_COOKIE_DEFAULT = STR_0;

    /*
     * _uid是直接从chaoxing.com域名取的。
     */
    public static final String MOBILE_PUID_COOKIE_NAME = "_uid";
    public static final String MOBILE_TID_COOKIE_NAME = "_tid";
    public static final String MOBILE_APP_CUSTOM_COOKIE_NAME = "app_custom";
    public static final String MOBILE_FID_COOKIE_NAME = "fid";//cookie中schoolid的字段

    // public static final String MOBILE_PUID_COOKIE_DEFAULT = "23009210";

    public static final String GROUP_INTERFACE_KEY = "Z(AfY@XS";
    //机构前缀
    public final static String YZIR_DQS_UNIT_SUBSCRIBE_PREFIX = "mooc_";

    public final static String YUNZHOU_SN_TRANSFER_CATAID = "100000015";

    //课程前缀
    public final static String coures_prefix = "400010003_";
}
