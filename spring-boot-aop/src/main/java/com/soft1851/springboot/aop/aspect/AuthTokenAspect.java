package com.soft1851.springboot.aop.aspect;

import com.soft1851.springboot.aop.annotation.AuthToken;
import com.soft1851.springboot.aop.domain.entity.SysRole;
import com.soft1851.springboot.aop.mapper.SysRoleMapper;
import com.soft1851.springboot.aop.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Jack
 * @Date: 2020/4/13 16:40
 * @Description:
 */
@Aspect
@Component
@Slf4j
public class AuthTokenAspect {
    @Resource
    private SysRoleMapper sysRoleMapper;

    @Pointcut("@annotation(authToken)")
    public void doAuthToken(AuthToken authToken){

    }

    @Around(value = "doAuthToken(authToken)", argNames = "pjp,authToken")
    public Object doAround(ProceedingJoinPoint pjp,AuthToken authToken) throws Throwable {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert sra != null;
        HttpServletRequest request = sra.getRequest();
        //获得注解中的role_name的值
        String[] roleNames = authToken.role_name();
//        try {
//            Cookie[] cookies = request.getCookies();
//            String mytoken=null;
//            String[]  userRole=sysRoleMapper.selectRoleByUserId(Integer.parseInt(request.getParameter("id")));
//            for (Cookie cookie : cookies) {
//                if(cookie.getName().equals("token")){
//                    mytoken=cookie.getValue();
//                }
//            }
//            if(mytoken!=null){
//                for (String roleName : roleNames) {
//                    for(String role :userRole){
//                        if(roleName.equals(role)){
//                            return pjp.proceed();
//                        }
//                    }
//                }
//                return "没有权限访问";
//            }
//        }catch (NullPointerException e){
//            System.out.println("没有cookie");
//        }

        //首先判断用户是不是已经登录，如果已经登录，再判断所访问得资源是不是有权限设置
        String  id= request.getHeader("id");
        if(id!=null){
            //如果没有权限设置
            if(roleNames.length<1){
                return pjp.proceed();
            }
            //如果有权限设置
            else{
                //从后台查询到本用户的权限数组
                String[] role = sysRoleMapper.selectRoleByUserId(id);
                //对资源的权限集合和用户的权限数组进行遍历，如果有相等情况，则认为用户具备权限
                for (String roleName : roleNames) {
                    for(String userRole:role){
                        if(roleName.equals(userRole)){
                            return pjp.proceed();
                        }
                    }
                }
                return "没有权限访问";
            }
        }
        return "请先登录";
    }
}
