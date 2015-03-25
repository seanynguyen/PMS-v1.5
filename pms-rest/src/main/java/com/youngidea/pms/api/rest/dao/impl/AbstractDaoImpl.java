package com.youngidea.pms.api.rest.dao.impl;

import com.youngidea.pms.api.rest.model.AbstractModel;
import com.youngidea.pms.converter.AbstractConverter;
import com.youngidea.pms.entity.PMSEntity;
import com.youngidea.pms.facade.GenericFacade;

import java.util.List;

/**
 * Created by sean on 3/25/15.
 */
public abstract class AbstractDaoImpl<E extends PMSEntity, RequestModel extends AbstractModel, ResponseModel extends AbstractModel>  {

    protected abstract <Facade extends GenericFacade<E>> Facade getFacade();

    protected abstract <C extends AbstractConverter<E, RequestModel, ResponseModel>> C getConverter();

    public void create(E preparedEntity) {
        // let the child class does some shit ...
        //...
        getFacade().create(preparedEntity);
    };

    public void edit(RequestModel requestModel) {

    };

    public void remove(RequestModel requestModel) {

    };

    public List<ResponseModel> findAll() {

        return null;
    };

    public ResponseModel find(Object id) {

        return null;
    };
}
