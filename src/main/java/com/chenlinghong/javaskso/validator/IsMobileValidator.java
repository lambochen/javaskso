package com.chenlinghong.javaskso.validator;

import com.chenlinghong.javaskso.util.ValidatorUtil;
import com.mysql.jdbc.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created with IntelliJ IDEA
 * Created By Mr.Chen
 * Date: 18/09/10
 * Time: 13:16
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {

    private boolean required = false;

    @Override
    public void initialize(IsMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (required){
            return ValidatorUtil.isMobile(s);
        } else {
            if (StringUtils.isEmptyOrWhitespaceOnly(s)){
                return true;
            } else {
                return ValidatorUtil.isMobile(s);
            }
        }
    }
}
