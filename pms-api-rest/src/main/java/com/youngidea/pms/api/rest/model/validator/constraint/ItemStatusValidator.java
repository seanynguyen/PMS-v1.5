package com.youngidea.pms.api.rest.model.validator.constraint;

import com.youngidea.pms.api.rest.dao.ItemStatusDao;
import com.youngidea.pms.api.rest.model.ItemStatusModel;
import com.youngidea.pms.api.rest.model.validator.ValidStatus;

import javax.ejb.EJB;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by sean on 4/1/15.
 */
public class ItemStatusValidator implements ConstraintValidator<ValidStatus, ItemStatusModel> {

    @EJB
    private ItemStatusDao itemStatusDao;

    @Override
    public void initialize(ValidStatus validStatus) {

    }

    @Override
    public boolean isValid(ItemStatusModel itemStatusModel, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }

}
