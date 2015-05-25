/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.core.api.rest;

import com.google.common.collect.Lists;
import com.youngidea.pms.core.api.rest.model.AbstractBean;
import com.youngidea.pms.core.converter.AbstractConverter;
import com.youngidea.pms.core.entity.PMSEntity;
import com.youngidea.pms.core.facade.BaseEntityFacade;
import com.youngidea.pms.core.facade.GenericFacade;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.validation.ValidationError;

/**
 *
 * @author sean
 */
public abstract class CRUIDServiceREST<E extends PMSEntity, RequestModel extends AbstractBean, ResponseModel extends AbstractBean> {

    @EJB
    protected BaseEntityFacade<E> facade;

    @EJB
    protected GenericFacade genericFacade;

    protected Class<E> entityClass;
    protected Class<RequestModel> requestModelClass;
    protected Class<ResponseModel> responseModelClass;

    protected abstract <C extends AbstractConverter<E, RequestModel, ResponseModel>> C getConverter();

    public CRUIDServiceREST(Class<RequestModel> requestModelClass, Class<ResponseModel> responseModelClass, Class<E> entityClass) {
        this.entityClass = entityClass;
        this.requestModelClass = requestModelClass;
        this.responseModelClass = responseModelClass;
    }

    public CRUIDServiceREST(Class<RequestModel> requestModelClass, Class<E> entityClass) {
        this.entityClass = entityClass;
        this.requestModelClass = requestModelClass;
        this.responseModelClass = (Class<ResponseModel>) requestModelClass;
    }
    
    @PostConstruct
    public void initFacade() {
        facade.initEntity(entityClass);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") Long id) {
//        return getConverter().convert(dao.find(id), null);
        if (facade.find(id) == null) {
            return Response.status(Response.Status.BAD_REQUEST).
                entity(new ValidationError(entityClass.getSimpleName() + " not found", null, null, // will find the way to get path later
                        id.toString())).build();
        }
        return Response.status(Response.Status.OK).
                entity(getConverter().convert(facade.find(id), null)).build();
//        return new ItemResponseModel("blahbnlha");
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public Response findAll() {
        List<ResponseModel> models = Lists.newArrayList();
        for (E entity : facade.findAll()) {
            System.out.println(entity.getId());
            models.add(getConverter().convert(entity, null)); 
        }
        return Response.status(Response.Status.OK).
                entity(models).build();
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public Response create(@Valid RequestModel model) {
        // It's already worked ....
//        dao.create(getConverter().convertBack(model, null));
//        return Response.status(Response.Status.CREATED).
//                entity(model).build();
        E entity = getConverter().convertBack(model, null);
        facade.create(entity);
        return Response.status(Response.Status.CREATED).
                entity(getConverter().convert(entity, null)).build();
    }

//    @POST
//    @Consumes({"application/xml", "application/json"})
//    public Response testValidation(ItemRequestModel person) {
////        dao.create(getConverter().convertBack(model, null));
//        return Response.status(Response.Status.CREATED).
//                entity(person).build();
//    }
    
    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Long id) {
//        E entity = (E) modelValidator.validateEntity(entityClass, dao.find(id));
        // <!-- Experimental purpose
        if (facade.find(id) == null) {
            return Response.status(Response.Status.BAD_REQUEST).
                entity(new ValidationError(entityClass.getSimpleName() + " not found", null, null, // will find the way to get path later
                        id.toString())).build();
        }
        // -->
        ResponseModel model = getConverter().convert(facade.find(id), null);
        facade.remove(facade.find(id));
        return Response.status(Response.Status.OK).
                entity(model).build();
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public Response edit(RequestModel model, @PathParam("id") Long id) {
        // It's already worked ....
//        dao.edit(getConverter().convertBack(model, dao.find(model.getId())));
//        return Response.status(Response.Status.OK).
//                entity(model).build();
        E entity = getConverter().convertBack(model, facade.find(model.getId()));
        entity.setId(id);
        facade.edit(entity);
        return Response.status(Response.Status.OK).
                entity(getConverter().convert(entity, null)).build();
    }
   
}
