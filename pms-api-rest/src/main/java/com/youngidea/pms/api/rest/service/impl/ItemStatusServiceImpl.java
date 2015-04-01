package com.youngidea.pms.api.rest.service.impl;

import com.youngidea.pms.api.rest.dao.impl.ItemStatusDaoImpl;
import com.youngidea.pms.api.rest.model.ItemStatusModel;
import com.youngidea.pms.api.rest.service.ItemStatusService;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

/**
 * Created by sean on 3/31/15.
 */
@Path("/status")
public class ItemStatusServiceImpl extends ItemStatusDaoImpl implements ItemStatusService{

    @POST
    @Consumes({"application/xml", "application/json"})
    public Response createStatus(@Valid ItemStatusModel itemStatusModel) {
        return Response.status(Response.Status.CREATED).entity(super.create(itemStatusModel)).build();
    };

    @GET
    @Path("/testArrayList")
    public Response testArrayList() {
        return Response.status(Response.Status.FOUND).entity(new ArrayList()).build();
    }

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
    public Response find(@Pattern(regexp = "[0-9]+", message = "{person.id.pattern}") @PathParam("id")
                                    Long id) {
        return Response.status(Response.Status.FOUND).entity(super.find(id)).build();
    };

}
