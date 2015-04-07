package com.youngidea.pms.api.rest.dao.impl;

import com.youngidea.pms.api.rest.dao.impl.converter.AbstractConverter;
import com.youngidea.pms.api.rest.model.AbstractModel;
import com.youngidea.pms.entity.PMSEntity;
import com.youngidea.pms.facade.AbstractFacade;
import com.youngidea.pms.facade.GenericFacade;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by sean on 3/25/15.
 */
public abstract class AbstractDaoImpl<E extends PMSEntity, RequestModel extends AbstractModel, ResponseModel extends AbstractModel>  {
    private AbstractConverter<E, RequestModel, ResponseModel> CONVERTER;

    protected abstract <Facade extends AbstractFacade<E>> Facade getFacade();

    private Class<ResponseModel> responseModelClass;

    public AbstractDaoImpl(Class<ResponseModel> responseModelClass) {
        this.responseModelClass = responseModelClass;
    }

    // The first method to be executed
    @PostConstruct
    public void initializeConverter() {
        CONVERTER = new AbstractConverter(this.responseModelClass, getFacade().getEntityClass()); // do cho nay
    }


    public ResponseModel create(RequestModel requestModel) {
        // let the child class does some shit ...
        //...
        getFacade().create(CONVERTER.convertBack(requestModel));
        return CONVERTER.convertResToResp(requestModel);
    };

    public ResponseModel edit(RequestModel requestModel) {
        getFacade().edit(CONVERTER.convertBack(requestModel));
        return CONVERTER.convertResToResp(requestModel);
    };

    public ResponseModel remove(Object id) {
        E tobeRemoved = getFacade().find(id);
        getFacade().remove(tobeRemoved);
        return CONVERTER.convert(tobeRemoved);
    };

    public List<ResponseModel> findAll() {

        return null;
    };

    public ResponseModel find(Object id) {
        return CONVERTER.convert(getFacade().find(id));
    };
}
