package com.youngidea.pms.api.rest.service;

import com.youngidea.pms.api.rest.dao.AbstractDao;
import com.youngidea.pms.api.rest.model.ItemStatusModel;
import com.youngidea.pms.entity.item.ItemStatus;

import javax.ejb.Local;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Created by sean on 3/31/15.
 */
@Local
public interface ItemStatusService extends RestCRUIDService<ItemStatusModel> {

    Response find(@PathParam("id")
                  Long id);
}
