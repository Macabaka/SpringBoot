package com.soft1851.springboot.aop.mapper;


import com.soft1851.springboot.aop.domain.entity.SysUser;
import com.soft1851.springboot.aop.domain.vo.UserVo;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Jack
 * @Date: 2020/4/13 20:17
 * @Description:
 */

public interface SysUserMapper {

    /**
     * 查找所有用户
     * @return
     */
    @Select("SELECT * FROM sys_user")
    List<SysUser> selectAll();

    /**
     * 根据用户id查找用户
     * @param userId
     * @return
     */
    @Select("SELECT * FROM sys_user WHERE user_account = #{userId}")
    SysUser getUserByUserId(int userId);

    /**
     * 根据用户账号和密码查找用户
     * @param userVo
     * @return
     */
    @Select("SELECT * FROM sys_user WHERE user_account=#{userAccount} AND user_password=#{userPassword}")
    SysUser getLogin(UserVo userVo);
}
