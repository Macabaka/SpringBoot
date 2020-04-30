package com.soft1851.springboot.jwt.controller;

import com.soft1851.springboot.jwt.common.ResponseResult;
import com.soft1851.springboot.jwt.service.AdminService;
import com.soft1851.springboot.jwt.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.lang.model.type.TypeKind;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

/**
 * @author Jack
 * @Date: 2020/4/15 18:18
 * @Description:
 */
@Slf4j
@RestController
public class AdminController {

    @Resource
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseResult adminLogin(String username, String password) {
        //模拟登录成功
        log.info(username,password);
        //模拟从数据中取得用户id和角色信息
        String userId = UUID.randomUUID().toString();
        String token = JwtTokenUtil.getToken("superAdmin", "hanyuan", "null");
        log.info("登录成功，token={}",token);
        //获取httpServletResponse对象
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert sra != null;
        HttpServletResponse response = sra.getResponse();
        //将token放在响应头里返回，此处需要在跨域中配置allowedHeaders和allowedExposeHeaders
        response.setHeader("Authorization",token);
        return ResponseResult.success();
    }

    @GetMapping("/permisson")
    public ResponseResult getPerMission() {
        log.info("查询角色权限");
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        String token = request.getHeader("Authorization");
        String userRole = JwtTokenUtil.getUserRole(token);
        List<String> permissionByRole = adminService.getPermissionsByRole(userRole);
        return ResponseResult.success(permissionByRole);
    }

}
