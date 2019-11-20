package com.example.demo.website.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IllegalCharacterFilter implements Filter {

	@Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
        
    	HttpServletRequest request = (HttpServletRequest)req;
    	//添加X-Frame-Options响应头
        HttpServletResponse resp = (HttpServletResponse) res;
        resp.addHeader("X-Frame-Options","SAMEORIGIN"); 
        
        request = new MHttpServletRequest(request);
        chain.doFilter(request, res);
    }

    @Override
    public void destroy() {

    }

}
