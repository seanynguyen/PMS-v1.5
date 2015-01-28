/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.m;

import java.lang.annotation.ElementType;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author sean
 */
@Target({ METHOD, FIELD, PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = PersonValidator.class)
public @interface ValidPerson {
    String message() default "{Person}";
 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
}
