//package com.zephyr.gateway.configuration;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
//public class WebMvcConfig extends WebMvcConfigurerAdapter {
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//
//        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//
//        registry.addResourceHandler("/swagger/**").addResourceLocations("classpath:/static/swagger/");
//        registry.addResourceHandler("/swagger-resources/**").addResourceLocations("classpath:/static/swagger/");
//        registry.addResourceHandler("swagger-ui.html/swagger-resources/**").addResourceLocations("classpath:/static/swagger/");
//        registry.addResourceHandler("swagger-ui.html/swagger-resources/**").addResourceLocations("classpath:/META-INF/resources/");
//    }
//
//}
