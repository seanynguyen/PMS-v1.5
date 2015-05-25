package com.youngidea.pms.core.api.rest.dao.impl;

import com.google.common.collect.Lists;
import com.youngidea.pms.core.api.rest.dao.converter.GenericConverter;
import com.youngidea.pms.core.api.rest.exception.ModelNameDuplicationException;
import com.youngidea.pms.core.api.rest.model.AbstractModel;
import com.youngidea.pms.core.facade.AbstractFacade;
import com.youngidea.pms.core.entity.PMSEntity;

import javax.ejb.EJB;
import java.util.List;

/**
 * Created by sean on 3/25/15.
 */
public abstract class AbstractRestDaoImpl<E extends PMSEntity, RequestModel extends AbstractModel, ResponseModel extends AbstractModel>  {

    @EJB
    private GenericConverter<E, RequestModel, ResponseModel> genericConverter;

    protected abstract <Facade extends AbstractFacade<E>> Facade getFacade();

    protected <Converter extends GenericConverter<E, RequestModel, ResponseModel>> Converter getConverter() {
        return (Converter) this.genericConverter;
    }

    private Class<ResponseModel> responseModelClass;

    public AbstractRestDaoImpl(Class<ResponseModel> responseModelClass) {
        this.responseModelClass = responseModelClass;
    }

    // The first method to be executed
//    @PostConstruct
//    public void initializeConverter() {
//        CONVERTER = new AbstractConverter(this.responseModelClass, getFacade().getEntityClass()); // do cho nay
//    }


    public ResponseModel create(RequestModel requestModel) throws ModelNameDuplicationException {
        // let the child class does some shit ...
        //...
        System.out.println("FUCKKKKKKKKKKKKKKK");
        getFacade().create(getConverter().convertBack(requestModel, getFacade().getEntityClass()));
        return getConverter().convertResToResp(requestModel);
    };

    public ResponseModel edit(RequestModel requestModel) {
        getFacade().edit(getConverter().convertBack(requestModel, getFacade().getEntityClass()));
        return getConverter().convertResToResp(requestModel);
    };

    public ResponseModel remove(Object id) {
        E tobeRemoved = getFacade().find(id);
        getFacade().remove(tobeRemoved);
        return getConverter().convert(tobeRemoved, responseModelClass);
    };

    public List<ResponseModel> findAll() {
        return convertList(getFacade().findAll());
    };

    public List<ResponseModel> findByPage(int amountPerPage, int pageIndex) {
        int startIndex = amountPerPage * (pageIndex - 1);
        return convertList(getFacade().findRange(new int[]{startIndex, startIndex - 1 + amountPerPage}));
    }

    private List<ResponseModel> convertList(List<E> entityList) {
        List<ResponseModel> responseModels = Lists.newArrayList();
        for (E entity : entityList) {
            responseModels.add(getConverter().convert(entity, responseModelClass));
        }
        return responseModels;
    }

    public ResponseModel find(Object id) {
        return getConverter().convert(getFacade().find(id), responseModelClass);
    };
}
