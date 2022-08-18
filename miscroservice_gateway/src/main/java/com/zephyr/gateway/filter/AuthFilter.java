package com.zephyr.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Component
public class AuthFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //1. 获取当前请求的参数： token-user
        RequestContext current = RequestContext.getCurrentContext();
        HttpServletRequest requeset = current.getRequest();
        HttpServletResponse response = current.getResponse();
        String token = requeset.getParameter("token");
        if(!"user".equals((token))){
            current.setSendZuulResponse(false);
            response.setStatus(401);
            return null;
        }

        return null;
    }
}
