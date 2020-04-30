package com.soft1851.springboot.aop.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * @author Jack
 */
public interface SysRoleMapper {
    /**
     * 查询用户角色
     * @return 角色名称数组
     */
    @Select("SELECT role_name FROM sys_role WHERE role_id=(SELECT role_id FROM role_user WHERE user_id=#{userId})")
    String[] selectRoleByUserId(String userId);
 }
