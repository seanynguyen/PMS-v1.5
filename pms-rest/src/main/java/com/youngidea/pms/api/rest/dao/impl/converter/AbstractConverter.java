/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.api.rest.dao.impl.converter;


import com.youngidea.pms.api.rest.model.AbstractModel;
import com.youngidea.pms.entity.PMSEntity;
import com.youngidea.pms.facade.GenericFacade;

/**
 *
 * @author sean
 */
public abstract class AbstractConverter<E extends PMSEntity, RequestModel extends AbstractModel, ResponseModel extends AbstractModel>  {


    public ResponseModel convert(E input, ResponseModel output) /* throws ValidationException */ {
        output.setId(input.getId()); // input bi null
        return output;
    }


    // have just removed throw ValidationException
    public E convertBack(RequestModel input, E output) {
        // nothing to do on id
        return output;
    }


}
