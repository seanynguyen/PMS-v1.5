package com.youngidea.pms.api.rest.service.impl;

import com.youngidea.pms.api.rest.dao.AbstractDao;
import com.youngidea.pms.api.rest.model.AbstractModel;
import com.youngidea.pms.api.rest.model.error.NotFoundError;
import com.youngidea.pms.api.rest.service.RestCRUIDService;
import com.youngidea.pms.api.rest.ultility.RestApiHelper;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by sean on 4/4/15.
 */
public abstract class RestCRUIDServiceImpl<Dao extends AbstractDao, Model extends AbstractModel> {

    protected abstract Dao getDao();

    @POST
    @Consumes({"application/xml", "application/json"})
    public Response create(@Valid Model model) {
        return RestApiHelper.buildResponse(Response.Status.CREATED, getDao().create(model));
    };

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public Response edit(@Valid Model model, @PathParam("id") Long id) {
        if (getDao().find(id) == null) {
            return RestApiHelper.buildResponse(Response.Status.NOT_FOUND,
                    new NotFoundError(model.getClass().getSimpleName(), id));
        }
        model.setId(id);
        return RestApiHelper.buildResponse(Response.Status.OK, getDao().edit(model));
    };

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Long id) {
        if (getDao().find(id) == null) {
            return RestApiHelper.buildResponse(Response.Status.NOT_FOUND,
                    new NotFoundError("Item status", id));
        }
        return RestApiHelper.buildResponse(Response.Status.OK, getDao().remove(id));
    };

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id")
                         Long id) {
        if (getDao().find(id) == null) {
            return RestApiHelper.buildResponse(Response.Status.NOT_FOUND,
                    new NotFoundError("Item Status", id));
        }
        return Response.status(Response.Status.FOUND).entity(getDao().find(id)).build();
    };

}
