package com.youngidea.pms.api.rest.service.impl;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import com.youngidea.pms.api.rest.exception.ModelNameDuplicationException;
import com.youngidea.pms.api.rest.model.AbstractModel;
import com.youngidea.pms.api.rest.model.error.NotFoundError;
import com.youngidea.pms.api.rest.model.response.ItemResponseModel;
import com.youngidea.pms.api.rest.service.RestCRUIDService;
import com.youngidea.pms.api.rest.dao.AbstractRestDao;
import com.youngidea.pms.api.rest.ultility.RestApiHelper;
import com.youngidea.pms.core.entity.item.Item;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by sean on 4/4/15.
 */
public abstract class RestCRUIDServiceImpl<Dao extends AbstractRestDao, Model extends AbstractModel> implements RestCRUIDService<Model> {

    protected abstract Dao getDao();

    @POST
    @Consumes({"application/xml", "application/json"})
    public Response create(@Valid Model model) throws ModelNameDuplicationException {
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
    @Produces(MediaType.APPLICATION_JSON)
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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Say Hello World",
            notes = "Anything Else?", response = Item.class, responseContainer="List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Something wrong in Server")})
    public Response findAll() {
        return RestApiHelper.buildResponse((Response.Status.FOUND), getDao().findAll());
    };

    @GET
    @Path("{amountPerPage}/{pageIndex}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByPage(@Pattern(regexp = "[0-9]+", message = "{person.id.pattern}") @PathParam ("amountPerPage") String amountPerPage,
                               @Pattern(regexp = "[0-9]+", message = "{person.id.pattern}") @PathParam("pageIndex") String pageIndex) {
        return Response.status(Response.Status.FOUND).entity(getDao().findByPage(Integer.parseInt(amountPerPage),
                Integer.parseInt(pageIndex))).build();
    };

}
