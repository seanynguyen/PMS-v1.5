package com.youngidea.pms.core.api.rest.service;

import com.youngidea.pms.core.api.rest.exception.ModelNameDuplicationException;
import com.youngidea.pms.core.api.rest.model.request.ItemRequestModel;

import javax.ejb.Local;
import javax.validation.Valid;
import javax.ws.rs.core.Response;

/**
 * Created by sean on 4/11/15.
 */
@Local
public interface ItemService extends RestCRUIDService<ItemRequestModel>{

    public Response create(@Valid ItemRequestModel model) throws ModelNameDuplicationException;

}
