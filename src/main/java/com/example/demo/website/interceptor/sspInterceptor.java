package com.example.demo.website.interceptor;

/**
 * ssp登录拦截器
 *
 * @author qing song dai
 * 2015-1
 */

import java.io.*;
import java.util.Properties;
import javax.security.auth.login.AccountException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.demo.website.contast.SessionConstant;
import com.example.demo.reading.manager.AdministratorManger;
import com.example.demo.reading.model.po.AdministratorPo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@SuppressWarnings("unused")
public class sspInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(sspInterceptor.class);

    @Autowired
    private AdministratorManger administratorManger;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        try {
//            BufferedReader bufferedReader = new BufferedReader(new FileReader("/config/login.properties"));
            AdministratorPo administratorPo = (AdministratorPo) session.getAttribute(SessionConstant.ADMIN_LOGIN_SESSION_KEY);
            if(administratorPo == null){
                return returnUserFalse(response, request);
            }else {
                return true;
            }
        } catch (Exception e) {
            log.error("error", e);
            throw new IllegalArgumentException(e);
        }
//        return false;
    }

    /**
     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在DispatcherServlet完全处理完请求后被调用
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @return void
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }


    public boolean returnUserFalse(HttpServletResponse response, HttpServletRequest request) throws IOException {
//        String SYSTEM_URL = (String) request.getSession().getAttribute("SYSTEM_URL");
        response.sendRedirect("/login");
        return false;
    }
}
