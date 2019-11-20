package com.example.demo.website.manager.impl;

import com.example.demo.website.manager.MobilePassportUserInfoManager;
import com.example.demo.website.po.MobilePassport;
import com.example.demo.website.po.MobilePassportApiParam;
import org.springframework.stereotype.Service;

/**
 * @author gewu
 * @time$create 2017/6/21 15:21
 */
@Service
public class MobilePassportUserInfoManagerImpl implements MobilePassportUserInfoManager {

    /**
     * 获取学习通用户的Passport接口信息
     *
     * @param mobilePassportApiParam 请求接口参数封装成的对象
     * @return 预期 - 根据接口信息字段封装成的对象<br>null - 参数有空
     * @version v1.0.0.0.0 (feat, bug, doc, style, refactor)
     * @author gewu
     * @time$create 2017/6/5 14:49
     * @time$modify
     * @modifer
     * @log$change initial
     */
    private MobilePassport getPassportInfo(MobilePassportApiParam mobilePassportApiParam) {
        MobilePassport mobilePassport = null;
        if (mobilePassportApiParam == null) {
            throw new NullPointerException("学习通用户信息API调用前参数为null");
        }
        MobilePassportApiCallerCacheServiceImpl mobilePassportService = new MobilePassportApiCallerCacheServiceImpl();
        try {
            if (mobilePassportService.callApiAndCached(mobilePassportApiParam)) {
                if (mobilePassportApiParam.check()) {
                    mobilePassport = mobilePassportService.toBean(mobilePassportApiParam);
                    if (mobilePassport == null) {
                        System.err.println("json数据转换成了null！");
                    }
                }
            } else {
                System.err.println("学习通用户信息API调用后检查不通过");
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
        return mobilePassport;
    }

    /**
     * polymorphic
     *
     * @param xxtUid 学习通uid
     * @return 根据接口信息字段封装成的对象
     * @version v1.0.0.0.0 (feat, bug, doc, style, refactor)
     * @author gewu
     * @time$create 2017/6/5 15:58
     * @time$modify
     * @modifer
     * @log$change initial
     * @see #getPassportInfo(MobilePassportApiParam)
     */
    @Override
    public MobilePassport getPassportInfo(String xxtUid) {
        return getPassportInfo(new MobilePassportApiParam(xxtUid));
    }

    /**
     * polymorphic
     *
     * @param xxtUid   学习通uid
     * @param industry 行业id
     * @return 根据接口信息字段封装成的对象
     * @version v1.0.0.0.0 (feat, bug, doc, style, refactor)
     * @author gewu
     * @time$create 2017/6/5 16:04
     * @time$modify
     * @modifer
     * @log$change initial
     * @see #getPassportInfo(MobilePassportApiParam)
     */
    public MobilePassport getPassportInfo(String xxtUid, String industry) {
        return getPassportInfo(new MobilePassportApiParam(xxtUid, industry));
    }

    public static void main(String[] args) {
        MobilePassportUserInfoManagerImpl mobilePassportUseInfoManager = new MobilePassportUserInfoManagerImpl();
        // MobilePassport mobilePassport = mobilePassportService.getPassportInfo("22329789");
        // MobilePassport mobilePassport = mobilePassportService.getPassportInfo("27230884");
        MobilePassport mobilePassport = mobilePassportUseInfoManager.getPassportInfo("87420171");
        System.out.println(mobilePassport);
    }
}
