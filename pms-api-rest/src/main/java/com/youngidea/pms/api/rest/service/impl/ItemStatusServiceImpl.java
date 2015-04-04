package com.youngidea.pms.api.rest.service.impl;

import com.youngidea.pms.api.rest.dao.impl.ItemStatusDaoImpl;
import com.youngidea.pms.api.rest.model.ItemStatusModel;
import com.youngidea.pms.api.rest.model.error.NotFoundError;
import com.youngidea.pms.api.rest.model.validator.ValidStatus;
import com.youngidea.pms.api.rest.service.ItemStatusService;
import com.youngidea.pms.api.rest.ultility.RestApiHelper;

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
    public Response createStatus(@Valid @ValidStatus ItemStatusModel itemStatusModel) {
        return RestApiHelper.buildResponse(Response.Status.CREATED, super.create(itemStatusModel));
    };

//    @GET
//    @Path("/testArrayList")
//    public Response testArrayList() {
//        return Response.status(Response.Status.FOUND).entity(new ArrayList()).build();
//    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public Response editStatus(ItemStatusModel itemStatusModel, @PathParam("id") Long id) {
        if (super.find(id) == null) {
            return RestApiHelper.buildResponse(Response.Status.NOT_FOUND,
                    new NotFoundError(ItemStatusModel.class.getSimpleName(), id));
        }
        itemStatusModel.setId(id);
        return RestApiHelper.buildResponse(Response.Status.OK, super.edit(itemStatusModel));
    };
//
    @DELETE
    @Path("{id}")
    public Response removeStatus(@PathParam("id") Long id) {
        if (super.find(id) == null) {
            return RestApiHelper.buildResponse(Response.Status.NOT_FOUND,
                    new NotFoundError(ItemStatusModel.class.getSimpleName(), id));
        }
        return RestApiHelper.buildResponse(Response.Status.OK, super.remove(id));
    };
//
//    @Override
//    public List<ItemStatusModel> findAll() {
//
//    };

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id")
                             Long id) {
        if (super.find(id) == null) {
            return RestApiHelper.buildResponse(Response.Status.NOT_FOUND,
                    new NotFoundError(ItemStatusModel.class.getSimpleName(), id));
        }
        return Response.status(Response.Status.FOUND).entity(super.find(id)).build();
    };

}
