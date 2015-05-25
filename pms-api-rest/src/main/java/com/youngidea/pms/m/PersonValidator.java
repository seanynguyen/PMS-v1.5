/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.m;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author sean
 */
public class PersonValidator implements ConstraintValidator<ValidPerson, Person> {

    @Override
    public void initialize(ValidPerson constraintAnnotation) {
        System.out.println("------------------------------------------------------ initialize" );
    }

    @Override
    public boolean isValid(Person value, ConstraintValidatorContext context) {
        return false;
    }
}
