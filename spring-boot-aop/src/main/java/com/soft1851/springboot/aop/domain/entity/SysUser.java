package com.soft1851.springboot.aop.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jack
 * @Date: 2020/4/13 20:07
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysUser {
    private  Integer userId;
    private  String userAccount;
    private  String userPassword;
    private  String userIdentify;
}
