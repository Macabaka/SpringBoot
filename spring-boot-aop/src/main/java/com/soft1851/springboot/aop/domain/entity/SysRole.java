package com.soft1851.springboot.aop.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jack
 * @Date: 2020/4/14 10:04
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SysRole {
    private Integer roleId;
    private String roleName;
    private  String description;
}
