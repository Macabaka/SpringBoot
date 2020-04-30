package com.soft1851.springboot.aop.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jack
 * @Date: 2020/4/13 21:16
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVo {
    private  String userAccount;
    private  String userPassword;
}
