package com.youngidea.pms.api.rest.service.impl;

import com.youngidea.pms.api.rest.dao.impl.ItemStatusDaoImpl;
import com.youngidea.pms.api.rest.model.response.ItemStatusModel;
import com.youngidea.pms.api.rest.service.ItemStatusService;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by sean on 3/31/15.
 */
@Path("/status")
public class ItemStatusServiceImpl extends ItemStatusDaoImpl implements ItemStatusService{


    @POST
    @Consumes({"application/xml", "application/json"})
    public ItemStatusModel create(@Valid ItemStatusModel itemStatusModel) {
        return super.create(itemStatusModel);
    };

//    @Override
//    public void edit(ItemStatusModel itemStatusModel) {
//
//    };
//
//    @Override
//    public void remove(ItemStatusModel itemStatusModel) {
//
//    };
//
//    @Override
//    public List<ItemStatusModel> findAll() {
//
//    };


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ItemStatusModel find(@PathParam("id") Long id) {
        return super.find(id);
    };

}
