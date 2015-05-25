/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.api.rest.item;

import com.youngidea.pms.api.rest.CRUIDServiceREST;
import com.youngidea.pms.api.rest.model.response.ItemStatusModel;
import com.youngidea.pms.core.converter.ItemStatusConverter;
import com.youngidea.pms.core.entity.item.ItemStatus;

import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 *
 * @author sean
 */
@Path("/status")
public class ItemStatusServiceREST extends CRUIDServiceREST<ItemStatus, ItemStatusModel, ItemStatusModel> {

    @EJB
    private ItemStatusConverter itemStatusConverter;
    
    public ItemStatusServiceREST() {
        super(ItemStatusModel.class, ItemStatus.class);
    }
    
    
//    @GET
//    @Path("{id}")
//    @Produces({"application/json"})
//    @Override
//    public ItemStatusBean find(@PathParam("id") Long id) throws ValidationException {
//        try {
//            return super.find(id);
//        } catch (ValidationException e) {
//            return new ItemStatusBean(e.getMessage());
//        }
//    }
//    
//    @GET
//    @Produces({"application/xml", "application/json"})
//    public List<ItemStatusBean> findAll() {
//        return super.findAll();
//    }
    
//    @POST
//    @Consumes({"application/xml", "application/json"})
//    @Override
//    public String create(ItemStatusBean statusModel) {
////        itemFacade.create(itemConverter.convertBack(itemModel, null));
//        try {
//            return super.create(statusModel);
//        } catch (ValidationException e) {
//            return e.getMessage();
//        }
//    }
//    
//    @PUT
//    @Consumes({"application/xml", "application/json"})
//    @Override
//    public String edit(ItemStatusBean statusModel) {
//        try {
//            return super.edit(statusModel);
//        } catch (ValidationException e) {
//            return e.getMessage();
//        }
//    }
//    
//    @DELETE
//    @Path("{id}")
//    @Override
//    public String remove(@PathParam("id") Long id) {
//        //super.remove(super.find(id));
//        try {
//            return super.remove(id);
//        } catch (ValidationException e) {
//            return e.getMessage();
//        }
//    }

    @Override
    protected ItemStatusConverter getConverter() {
        return itemStatusConverter;
    }
}
