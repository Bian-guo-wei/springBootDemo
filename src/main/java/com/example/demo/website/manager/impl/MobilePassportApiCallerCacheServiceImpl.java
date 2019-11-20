package com.example.demo.website.manager.impl;

import com.dayainfo.common.util.HttpUtil;
import com.dayainfo.common.util.JsonMapper;
import com.dayainfo.lib.search.AbstractWebApiCallerCache;
import com.dayainfo.lib.search.Beany;
import com.example.demo.website.contast.MobilePassportUserInfoConstant;
import com.example.demo.website.po.MobilePassport;
import com.example.demo.website.po.MobilePassportApiParam;

/**
 * @author gewu
 * @time$create 2017/6/2 16:41
 */
public class MobilePassportApiCallerCacheServiceImpl
        extends AbstractWebApiCallerCache<MobilePassportApiParam>
        implements Beany<MobilePassport, MobilePassportApiParam> {

    /**
     * 请求api
     *
     * @param mobilePassportApiParam 将请求api的参数封装起来的业务对象
     * @return utf8编码的接口信息
     * @version v1.0.0.0.0 (feat, bug, doc, style, refactor)
     * @author gewu
     * @time$create 2017/6/5 9:29
     * @time$modify
     * @modifer
     * @log$change initial
     */
    @Override
    public String callApi(MobilePassportApiParam mobilePassportApiParam) {
        String apiUrl = String.format(MobilePassportUserInfoConstant.MOBILE_PASSPORT_API, mobilePassportApiParam.getXxtUid(),
                mobilePassportApiParam.getEnc(), mobilePassportApiParam.getIndustry());
        return HttpUtil.getMethod(apiUrl, "utf-8");
    }

    @Override
    public boolean callApiAndCached(MobilePassportApiParam mobilePassportApiParam) {
        return super.callApiAndCached(mobilePassportApiParam);
    }

    @Override
    public boolean checkApiInfo(String apiInfo) {
        return super.checkApiInfo(apiInfo);
    }

    @Override
    public MobilePassport toBean(MobilePassportApiParam mobilePassportApiParam) {
        MobilePassport mobilePassport = null;
        if (mobilePassportApiParam == null) {
            throw new NullPointerException("toBean时参数为空");
        }
        if (callApiAndCached(mobilePassportApiParam)) {
            JsonMapper jsonMapper = new JsonMapper();
            mobilePassport = jsonMapper.fromJson(getApiInfoCache(), MobilePassport.class);
        }
        return mobilePassport;
    }

    /**
     * 判断发现API缓存信息是否存在<br>
     * 即是否请求过发现API
     *
     * @return true - 存在，即请求过发现API / false - 不存在，即没请求过发现API
     * @version v1.0.0.0.0 (feat, bug, doc, style, refactor)
     * @author gewu
     * @time$create 2017/6/9 14:49
     * @time$modify
     * @modifer
     * @log$change initial
     */
    @Override
    protected boolean isApiInfoCacheExist() {
        return super.isApiInfoCacheExist();
    }

    @Override
    public boolean cached(String apiInfo) {
        return super.cached(apiInfo);
    }

    @Override
    public String getApiInfoCache() {
        return super.getApiInfoCache();
    }

    @Override
    public void setApiInfoCache(String apiInfoCache) {
        super.setApiInfoCache(apiInfoCache);
    }

    public static void main(String[] args) {
        MobilePassportApiCallerCacheServiceImpl mobilePassportApiCallerService = new MobilePassportApiCallerCacheServiceImpl();
        String mobileUid = "54233444";
        MobilePassportApiParam mobilePassportApiParam = new MobilePassportApiParam(mobileUid);
        if (mobilePassportApiCallerService.callApiAndCached(mobilePassportApiParam)) {
            JsonMapper jsonMapper = new JsonMapper();
            MobilePassport mobilePassport = jsonMapper.fromJson(mobilePassportApiCallerService.getApiInfoCache(), MobilePassport.class);
            System.out.println(mobilePassport.toString());
        }
    }
}
