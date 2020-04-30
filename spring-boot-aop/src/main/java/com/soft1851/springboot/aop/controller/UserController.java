package com.soft1851.springboot.aop.controller;

import com.soft1851.springboot.aop.annotation.AuthToken;

import com.soft1851.springboot.aop.domain.entity.SysUser;
import com.soft1851.springboot.aop.domain.vo.UserVo;
import com.soft1851.springboot.aop.mapper.RolePermissonMapper;
import com.soft1851.springboot.aop.mapper.SysPermissionMapper;
import com.soft1851.springboot.aop.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jack
 * @Date: 2020/4/13 16:31
 * @Description:
 */
@RestController
@Slf4j
public class UserController {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysPermissionMapper sysPermissionMapper;


    @Resource
    private RolePermissonMapper rolePermissonMapper;

    /**
     * 无需鉴权，也无需登录
     * @param name
     * @return
     */
//    @GetMapping("hello")
//    public String hello(String name) {
//        log.info("hello()方法无需鉴权，也无需登录");
//        return "hello"+name;
//    }

    /**
     * 需要登录，无需鉴权
     * @param name
     * @return
     */
//    @GetMapping("user")
//    @AuthToken
//    public String user(String name) {
//        return "user()方法访问成功";
//    }

//    /**
//     * 需要登录，需要鉴权
//     * @param name
//     * @return
//     */
//    @GetMapping("admin")
//    @AuthToken(role_name = {"admin","Admin"})
//    public String admin(String name) {
//        return "admin()方法访问成功";
//    }

    @GetMapping("login")
    public String login(UserVo userVo){
        SysUser sysUser = sysUserMapper.getLogin(userVo);
        if(sysUser !=null){
//            getToken(sysUser);
            return "登录成功" + userVo.getUserAccount();
        }
        return "登录失败";
    }

    @GetMapping("/admin")
    @AuthToken(role_name = "超级管理员")
    public Object selectAll() {
        return sysPermissionMapper.getParentPermission();
    }

    @GetMapping("/sysAdmin")
    @AuthToken(role_name = {"超级管理员","系统管理员"})
    public Object getBySysId(@Param("id") int id) {
        return rolePermissonMapper.getRoleById(id);
    }


//    @GetMapping("text")
//    @AuthToken(role_name = {"admin"})
//    public String getMessage(){
//        return "恭喜你，查看成功";
//    }




    public static  void getToken(SysUser sysUser){
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        assert sra != null;
        Cookie cookie = new Cookie("token", "123456");
        response.addCookie(cookie);
    }
}
