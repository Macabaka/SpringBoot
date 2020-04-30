package com.soft1851.springboot.verify.entity;

import com.soft1851.springboot.verify.annoatiation.Region;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.*;

/**
 * @author Johnny
 * @Date: 2020/4/30 16:31
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person  {
    @NotNull(message = "id不能为空")
//    @Size(min = 6,max = 10)
    private  String id;

    @Size(max = 30)
//    @Size(max = 10)
    private  String name ;

    @Min(18)
    private  Integer age;

    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "手机号码格式错误")
    private  String phone;

    @NotNull(message = "email不能为空")
    @Email(message = "邮箱格式错误")
    private  String email;

    @Pattern(regexp = "((^Man$|^Woman$|^UGM$))",message = "sex值不在可选范围")
    @NotNull(message = "sex不能为空")
    private  String sex;

    @Region
    private  String region;
}
