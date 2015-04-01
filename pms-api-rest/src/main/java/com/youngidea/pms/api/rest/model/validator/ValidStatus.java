package com.youngidea.pms.api.rest.model.validator;

import com.youngidea.pms.api.rest.model.validator.constraint.ItemStatusValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by sean on 4/1/15.
 */
@Target({ METHOD, FIELD, PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ItemStatusValidator.class)
public @interface ValidStatus {
    String message() default "{Person}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
