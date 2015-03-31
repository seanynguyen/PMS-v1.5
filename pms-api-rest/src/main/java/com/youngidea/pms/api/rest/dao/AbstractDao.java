package com.youngidea.pms.api.rest.dao;

import com.youngidea.pms.api.rest.model.AbstractModel;
import com.youngidea.pms.entity.PMSEntity;

import java.util.List;

/**
 * Created by sean on 3/26/15.
 */
public interface AbstractDao<E extends PMSEntity, RequestModel extends AbstractModel, ResponseModel extends AbstractModel> {

    public ResponseModel create(RequestModel requestModel);

    public void edit(RequestModel requestModel);

    public void remove(RequestModel requestModel);

    public List<ResponseModel> findAll();

    public ResponseModel find(Object id);
}
