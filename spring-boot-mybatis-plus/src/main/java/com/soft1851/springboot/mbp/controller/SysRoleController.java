package com.soft1851.springboot.mbp.controller;


import com.soft1851.springboot.mbp.common.ResponseResult;
import com.soft1851.springboot.mbp.service.RolePermissionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Johnny
 * @since 2020-04-16
 */
@RestController
@RequestMapping("/sysRole")
@Slf4j
public class SysRoleController {
    @Resource
    private RolePermissionService rolePermissionService;

    @GetMapping("role")
    public ResponseResult getRole(@Param("id") int id) {
        log.info("查询用户角色");
        return ResponseResult.success(rolePermissionService.getRoleById(id));
    }
}
