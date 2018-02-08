package com.miduodai.loanService.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: Kane
 * @Description:
 * @Date: Create in 下午3:28 18-1-25
 */

@Target(ElementType.PARAMETER)
@Retention (RetentionPolicy.RUNTIME)
public @interface CurrentUser {
}
