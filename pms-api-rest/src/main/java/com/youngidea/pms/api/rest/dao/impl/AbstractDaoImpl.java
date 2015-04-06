package com.youngidea.pms.api.rest.dao.impl;

import com.youngidea.pms.api.rest.dao.impl.converter.AbstractConverter;
import com.youngidea.pms.api.rest.model.AbstractModel;
import com.youngidea.pms.entity.PMSEntity;
import com.youngidea.pms.facade.AbstractFacade;
import com.youngidea.pms.facade.GenericFacade;

import java.util.List;

/**
 * Created by sean on 3/25/15.
 */
public abstract class AbstractDaoImpl<E extends PMSEntity, RequestModel extends AbstractModel, ResponseModel extends AbstractModel>  {
    private AbstractConverter<E, RequestModel, ResponseModel> CONVERTER;

    protected abstract <Facade extends AbstractFacade<E>> Facade getFacade();

    protected abstract <C extends AbstractConverter<E, RequestModel, ResponseModel>> C getConverter();

    private Class<ResponseModel> responseModelClass;

    public AbstractDaoImpl(Class<ResponseModel> responseModelClass) {
        this.responseModelClass = responseModelClass;
//        CONVERTER = new AbstractConverter(responseModelClass, getFacade().getEntityClass()); // do cho nay
//        System.out.println(getFacade().toString()); // getFacade().getEntityClass  --> fail
    }

    public ResponseModel create(RequestModel requestModel) {
        // let the child class does some shit ...
        //...
        getFacade().create(getConverter().convertBack(requestModel));
        return getConverter().convertResToResp(requestModel);
    };

    public ResponseModel edit(RequestModel requestModel) {
        getFacade().edit(getConverter().convertBack(requestModel));
        return getConverter().convertResToResp(requestModel);
    };

    public ResponseModel remove(Object id) {
        E tobeRemoved = getFacade().find(id);
        getFacade().remove(tobeRemoved);
        return getConverter().convert(tobeRemoved);
    };

    public List<ResponseModel> findAll() {

        return null;
    };

    public ResponseModel find(Object id) {
        return getConverter().convert(getFacade().find(id));
    };
}
