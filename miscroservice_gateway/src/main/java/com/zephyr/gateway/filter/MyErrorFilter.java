package com.zephyr.gateway.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.client.IResponse;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.constants.ZuulConstants;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//自己的错误过滤器要生效需要禁用默认过滤器
//@Component
public class MyErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.ERROR_TYPE;
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
        System.out.println("进入自定义异常过滤器");
        //1.补货异常
        RequestContext current = RequestContext.getCurrentContext();
        HttpServletResponse respo = current.getResponse();
        ZuulException exception =  (ZuulException) current.get("throwable");

        //2.把信息输出给前端
        Result result = new Result(false, "Failure: "+exception.getMessage());
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            String jsonString = objectMapper.writeValueAsString(result);
            respo.setContentType("text/json;charset=utf-8");
            respo.getWriter().write(jsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
