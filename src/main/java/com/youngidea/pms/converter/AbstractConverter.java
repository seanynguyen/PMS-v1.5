/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.converter;


import com.youngidea.pms.entity.PMSEntity;
import com.youngidea.pms.model.AbstractBean;

/**
 *
 * @author sean
 */
public class AbstractConverter<E extends PMSEntity, RequestModel extends AbstractBean, ResponseModel extends AbstractBean> implements IConverter<E,RequestModel,ResponseModel> {
    
    @Override
    public ResponseModel convert(E input, ResponseModel output) /* throws ValidationException */ {
        output.setId(input.getId()); // input bi null
        return output;
    }


    @Override
    // have just removed throw ValidationException
    public E convertBack(RequestModel input, E output) {
        // nothing to do on id
        return output;
    }
}
