package com.youngidea.pms.core.api.rest.dao;

import com.youngidea.pms.core.api.rest.exception.ModelNameDuplicationException;
import com.youngidea.pms.core.api.rest.model.AbstractModel;
import com.youngidea.pms.core.entity.PMSEntity;

import java.util.List;

/**
 * Created by sean on 3/26/15.
 */
public interface AbstractRestDao<E extends PMSEntity, RequestModel extends AbstractModel, ResponseModel extends AbstractModel> {

    public ResponseModel create(RequestModel requestModel) throws ModelNameDuplicationException;

    public ResponseModel edit(RequestModel requestModel);

    public ResponseModel remove(Object id);

    public List<ResponseModel> findAll();

    public ResponseModel find(Object id);

    public List<ResponseModel> findByPage(int amountPerPage, int pageIndex);
}
