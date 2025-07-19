package com.tfswufe.resume.utils.mybatisplus.annos;

import com.tfswufe.resume.utils.mybatisplus.Logic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Between {
    /**
     * 逻辑关系
     * @return
     */
    Logic logic() default Logic.AND;
}
