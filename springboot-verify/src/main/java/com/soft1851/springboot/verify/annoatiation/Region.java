package com.soft1851.springboot.verify.annoatiation;

import com.soft1851.springboot.verify.validator.RegionVaildator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Johnny
 * @Date: 2020/4/30 17:54
 * @Description:
 */
@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = RegionVaildator.class)
@Documented
public @interface Region {

    String message() default "Region 值不在可选范围内";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
