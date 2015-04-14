package com.youngidea.pms.api.rest.service.impl;

import com.youngidea.pms.api.rest.dao.ItemStatusRestDao;
import com.youngidea.pms.api.rest.model.ItemStatusModel;
import com.youngidea.pms.api.rest.model.error.ErrorModel;
import com.youngidea.pms.api.rest.service.ItemStatusService;
import com.youngidea.pms.api.rest.ultility.RestApiHelper;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by sean on 3/31/15.
 */
@LocalBean
@Path("/status")
@Stateless
public class ItemStatusServiceImpl extends RestCRUIDServiceImpl<ItemStatusRestDao, ItemStatusModel> implements ItemStatusService{

    @EJB
    private ItemStatusRestDao itemStatusDao;

    @Override
    protected ItemStatusRestDao getDao() {
        return this.itemStatusDao;
    }

    @Override
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response create(@Valid ItemStatusModel itemStatusModel) {
        if (itemStatusDao.checkNameDuplication(itemStatusModel.getStatusName())) {
            return RestApiHelper.buildResponse(Response.Status.BAD_REQUEST, new ErrorModel(itemStatusModel, "statusName",
                    itemStatusModel.getStatusName(), " is duplicated"));
        }
        return super.create(itemStatusModel);
    };

    @Override
    @PUT
    @Consumes({"application/xml", "application/json"})
    public Response edit(@Valid ItemStatusModel itemStatusModel, @PathParam("id") Long id) {
        Response response = super.edit(itemStatusModel, id);
        if (itemStatusDao.checkNameDuplication(itemStatusModel.getStatusName())) {
            return RestApiHelper.buildResponse(Response.Status.BAD_REQUEST, new ErrorModel(itemStatusModel, "statusName",
                    itemStatusModel.getStatusName(), " is duplicated"));
        }
        return response;
    }

}
