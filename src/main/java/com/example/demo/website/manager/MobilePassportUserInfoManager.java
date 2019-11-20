package com.example.demo.website.manager;

import com.example.demo.website.po.MobilePassport;

/**
 * 移动端登录服务
 *
 * @author ayne
 * @date 2018-07-02 11:04:56
 */
public interface MobilePassportUserInfoManager {

    /**
     * 获取 passprot 信息
     *
     * @param xxtUid 学习通中的 uid，因为在 passport 接口中，所以应该叫 puid
     * @return 信息
     */
    MobilePassport getPassportInfo(String xxtUid);
}
