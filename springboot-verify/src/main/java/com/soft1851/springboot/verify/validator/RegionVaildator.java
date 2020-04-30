package com.soft1851.springboot.verify.validator;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;

/**
 * @author Johnny
 * @Date: 2020/4/30 17:52
 * @Description:
 */
public class RegionVaildator implements ConstraintValidator<com.soft1851.springboot.verify.annoatiation.Region,String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        HashSet<Object> regions = new HashSet<>();
        regions.add("china");
        regions.add("china-taiwan");
        regions.add("china-hongkong");
        return regions.contains(s);
    }
}
