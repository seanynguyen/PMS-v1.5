/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.api.rest.item;

import com.youngidea.pms.api.rest.CRUIDServiceREST;
import com.youngidea.pms.converter.CategoryConverter;
import com.youngidea.pms.entity.item.Category;
import com.youngidea.pms.model.response.CategoryModel1;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    @Consumes({"application/xml", "application/json"})
    @Override
    public Response edit(CategoryModel1 categoryModel) {
        super.facade.edit(categoryConverter.convertBack(categoryModel,
                super.facade.find(categoryModel.getId())));
        setParent(categoryModel.getId(), categoryModel.getParentId());
        return Response.status(Response.Status.OK).
                entity(categoryModel).build();
    }

    @Override
    protected CategoryConverter getConverter() {
        return categoryConverter;
    }
}
