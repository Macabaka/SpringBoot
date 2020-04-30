package com.soft1851.springboot.aop.mapper;

import com.soft1851.springboot.aop.domain.vo.UserVo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SysSysUserMapperTest {
    @Resource
    private SysUserMapper sysUserMapper;
    @Test
    void selectAll() {
        sysUserMapper.selectAll().forEach(System.out::println);
    }

    @Test
    void getUserByUserId() {
        System.out.println(sysUserMapper.getUserByUserId(1));
    }

    @Test
    void getLogin() {
        System.out.println(sysUserMapper.getLogin(UserVo.builder().userAccount("admin").userPassword("admin").build()));
    }
}