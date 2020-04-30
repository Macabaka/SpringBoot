package com.soft1851.springboot.aop.annotation;


import java.lang.annotation.*;

/**
 * @author Jack
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthToken {

    /**
     *访问接口所需要的身份，默认为空
     * @return String[]
     */
    String[] role_name() default "";
}
