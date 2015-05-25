package com.youngidea.pms.core.api.rest.model.validator.constraint;

import com.youngidea.pms.core.api.rest.model.ItemStatusModel;
import com.youngidea.pms.core.api.rest.model.validator.ValidStatus;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by sean on 4/1/15.
 */
public class ItemStatusValidator implements ConstraintValidator<ValidStatus, ItemStatusModel> {

//    @EJB
//    private ItemStatusDao itemStatusDao;

    @Override
    public void initialize(ValidStatus validStatus) {

    }

    @Override
    public boolean isValid(ItemStatusModel itemStatusModel, ConstraintValidatorContext constraintValidatorContext) {
//        System.out.println(itemStatusDao.findAll());
        return true;
    }

}
