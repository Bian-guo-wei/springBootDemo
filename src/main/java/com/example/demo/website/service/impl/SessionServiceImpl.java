package com.example.demo.website.service.impl;

import com.example.demo.website.contast.SessionConstant;
import com.example.demo.website.po.MobilePassport;
import com.example.demo.website.service.SessionService;
import com.example.demo.reading.model.po.AdministratorPo;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author ayne
 * @date 2019-04-02 16:30:32
 */
@Service
public class SessionServiceImpl implements SessionService {

    private static final Logger logger = LoggerFactory.getLogger(SessionServiceImpl.class);

    @Override
    public AdministratorPo getAdminSession() {
        return (AdministratorPo) SecurityUtils.getSubject().getSession().getAttribute(SessionConstant.ADMIN_LOGIN_SESSION_KEY);
    }

    @Override
    public void setAdminSession(AdministratorPo administratorPo) {
        SecurityUtils.getSubject().getSession().setAttribute(SessionConstant.ADMIN_LOGIN_SESSION_KEY, administratorPo);
    }

    @Override
    public void removeAdminSession() {
        SecurityUtils.getSubject().getSession().removeAttribute(SessionConstant.ADMIN_LOGIN_SESSION_KEY);
    }

    @Override
    public MobilePassport getUserSession(HttpServletRequest request) {
        return (MobilePassport) request.getSession().getAttribute(SessionConstant.USER_LOGIN_SESSION_KEY);
    }

    @Override
    public void setUserSession(HttpServletRequest request, MobilePassport mobilePassport) {
        request.getSession().setAttribute(SessionConstant.USER_LOGIN_SESSION_KEY, mobilePassport);
    }

    @Override
    public void removeUserSession(HttpServletRequest request) {
        request.getSession().removeAttribute(SessionConstant.USER_LOGIN_SESSION_KEY);
        //jalis cas
        request.getSession().removeAttribute("_const_cas_assertion_");
    }
}
