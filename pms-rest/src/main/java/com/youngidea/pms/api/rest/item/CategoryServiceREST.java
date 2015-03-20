/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.api.rest.item;

import com.youngidea.pms.api.rest.CRUIDServiceREST;
import com.youngidea.pms.converter.CategoryConverter;
import com.youngidea.pms.entity.item.Category;
import com.youngidea.pms.api.rest.model.response.CategoryModel1;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 *
 * @author sean
 */
@Path("/category")
public class CategoryServiceREST extends CRUIDServiceREST<Category, CategoryModel1, CategoryModel1> {

    @EJB
    private CategoryConverter categoryConverter;

    public CategoryServiceREST() {
        super(CategoryModel1.class, CategoryModel1.class, Category.class);
    }

    @GET
    @Consumes({"application/xml", "application/json"})
    @Path("{categoryId}/parent/{parentId}")
    public Response setParent(@PathParam("categoryId") Long categoryId, @PathParam("parentId") Long parentId) {
        Category category = super.facade.find(categoryId);
        category.setParentCategory(category.getParentCategory());
        super.facade.edit(category);
        return Response.status(Response.Status.OK).
                entity(categoryConverter.convert(category.getParentCategory(), null)).build();
    }

    @GET
    @Path("/test")
    public String testCategory() {
        return "Hello World";
        
    }
    
    @POST
    @Consumes({"application/xml", "application/json"}) // create then add prices
    @Override
    public Response create(CategoryModel1 categoryModel) {
        Category category = categoryConverter.convertBack(categoryModel, null);
        super.facade.create(category);
        setParent(categoryModel.getId(), categoryModel.getParentId());
        return Response.status(Response.Status.CREATED).
                entity(categoryModel).build();
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    @Override
    public Response edit(CategoryModel1 categoryModel, @PathParam("id") Long id) {

        super.facade.edit(categoryConverter.convertBack(categoryModel,
                super.facade.find(id)));
        setParent(categoryModel.getId(), categoryModel.getParentId());
        return Response.status(Response.Status.OK).
                entity(categoryModel).build();
    }

    @Override
    protected CategoryConverter getConverter() {
        return categoryConverter;
    }
}
