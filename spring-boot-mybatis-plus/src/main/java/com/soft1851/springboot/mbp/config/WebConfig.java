package com.soft1851.springboot.mbp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author Jack
 * @Date: 2020/4/15 18:54
 * @Description:
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
//    @Resource
//    private JwtInterceptor jwtInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(jwtInterceptor).addPathPatterns("/**").excludePathPatterns("/login").excludePathPatterns("/static/**");
//    }
}
