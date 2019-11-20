package com.example.demo.website.service;


import com.example.demo.website.po.MobilePassport;
import com.example.demo.reading.model.po.AdministratorPo;

import javax.servlet.http.HttpServletRequest;

/**
 * session 服务接口
 *
 * @author ayne
 * @date 2018-06-29 13:49:31
 */
public interface SessionService {

    /**
     * 获取管理员 session
     *
     * @return session 中的管理员信息
     */
    AdministratorPo getAdminSession();

    /**
     * 在 session 中设置管理员信息
     *
     * @param administratorPo 管理员信息
     */
    void setAdminSession(AdministratorPo administratorPo);

    /**
     * 在 session 中删除管理员信息
     */
    void removeAdminSession();

    /**
     * 获取用户 session
     *
     * @return session 中用户信息
     */
    MobilePassport getUserSession(HttpServletRequest request);

    /**
     * 在 session 中设置管理员信息
     *
     * @param request        请求
     * @param mobilePassport 要设置的内容
     */
    void setUserSession(HttpServletRequest request, MobilePassport mobilePassport);

    /**
     * 在 session 中删除用户信息
     *
     * @param request 请求
     */
    void removeUserSession(HttpServletRequest request);

}
