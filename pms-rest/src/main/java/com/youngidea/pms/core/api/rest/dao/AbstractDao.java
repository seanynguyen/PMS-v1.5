package com.youngidea.pms.core.api.rest.dao;

import com.youngidea.pms.core.api.rest.model.AbstractModel;
import com.youngidea.pms.core.entity.PMSEntity;

import java.util.List;

/**
 * Created by sean on 3/26/15.
 */
public interface AbstractDao<E extends PMSEntity, RequestModel extends AbstractModel, ResponseModel extends AbstractModel> {

    public void create(RequestModel requestModel);

    public void edit(RequestModel requestModel);

    public void remove(RequestModel requestModel);

    public List<ResponseModel> findAll();

    public ResponseModel find(Object id);
}
