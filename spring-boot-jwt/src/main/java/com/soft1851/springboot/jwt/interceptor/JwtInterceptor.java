package com.soft1851.springboot.jwt.interceptor;

import com.soft1851.springboot.jwt.common.ResultCode;
import com.soft1851.springboot.jwt.exception.JwtException;
import com.soft1851.springboot.jwt.service.AdminService;
import com.soft1851.springboot.jwt.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jack
 * @Date: 2020/4/15 16:42
 * @Description:
 */
@Slf4j
@Component
public class JwtInterceptor implements HandlerInterceptor {
    @Resource
    private AdminService adminService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token == null) {
            log.info("用户未登录");
            throw new JwtException("用户未登录，请先登录", ResultCode.USER_NOT_SIGN_IN);
        }else{
            System.out.println(1);
            if(!adminService.checkRole(JwtTokenUtil.getUserRole(token))){
                log.info("###token={}",token);
                log.info("###用户权限不足");
                throw new JwtException("用户权限不足", ResultCode.USER_NO_AUTH);
            }else{
//                System.out.println(2);
//                if(JwtTokenUtil.isExpiration(token)){
//                    System.out.println(3);
//                    throw new JwtException("token失效", ResultCode.USER_NO_AUTH);
//                }else{
//                    //通过认证
//                    return false;
//                }
                return true;
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
