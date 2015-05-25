/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.api.rest.item;

import com.google.common.collect.Lists;
import com.youngidea.pms.api.rest.CRUIDServiceREST;
import com.youngidea.pms.api.rest.model.OrderRequestModel;
import com.youngidea.pms.api.rest.model.request.ItemGroupRequestModel;
import com.youngidea.pms.api.rest.model.response.ItemGroupResponseModel;
import com.youngidea.pms.api.rest.model.response.OrderResponseModel;
import com.youngidea.pms.core.converter.ItemGroupConverter;
import com.youngidea.pms.core.converter.OrdersConverter;
import com.youngidea.pms.core.entity.item.ItemGroup;
import com.youngidea.pms.core.entity.order.GroupedOrder;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
@Path("/group")
public class ItemGroupServiceREST extends CRUIDServiceREST<ItemGroup, ItemGroupRequestModel, ItemGroupResponseModel> {

    @EJB
    private ItemGroupConverter itemGroupConverter;
    
    @EJB
    private OrdersConverter ordersConverter;
    
    
    public ItemGroupServiceREST() {
        super(ItemGroupRequestModel.class, ItemGroupResponseModel.class, ItemGroup.class);
    }

//    @POST
//    @Consumes({"application/xml", "application/json"})
//    @Override
//    public Response create(ItemGroupRequestModel itemGroupRequestModel) {
//        ItemGroup itemGroup = new ItemGroup();
//        itemGroup.addGroupedOrder(null);
//    }
    
    
    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    @Override
    public Response edit(ItemGroupRequestModel itemGroupRequestModel, @PathParam("id") Long id) {
        clearGroupedOrders(itemGroupRequestModel.getId());
        super.edit(itemGroupRequestModel, id);
        return Response.status(Response.Status.OK)
                .entity(itemGroupRequestModel).build();
    }
    
    @POST
    @Path("/{id}/item")
    public Response addItems(@PathParam("id") Long groupId, List<OrderRequestModel> orderRequestModels) {
        ItemGroup itemGroup = super.facade.find(groupId);
        List<OrderResponseModel> tobeReturned = Lists.newArrayList();
        for (OrderRequestModel orderRequestModel : orderRequestModels) {
            GroupedOrder groupedOrder = (GroupedOrder) ordersConverter.convertBack(orderRequestModel, new GroupedOrder());
            itemGroup.addGroupedOrder(groupedOrder);
            tobeReturned.add(ordersConverter.convert(groupedOrder, null));
        }
        super.facade.edit(itemGroup);
        return Response.status(Response.Status.CREATED).
                entity(tobeReturned).build();
    }
    
    @GET
    @Path("/{id}/item")
    public Response getItems(@PathParam("id") Long groupId) {
        ItemGroup itemGroup = super.facade.find(groupId);
        List<OrderResponseModel> orderResponseModels = Lists.newArrayList();
        for (GroupedOrder groupOrder : itemGroup.getGroupedOrders()) {
            orderResponseModels.add(ordersConverter.convert(groupOrder, null));
        }
        return Response.status(Response.Status.FOUND).
                entity(orderResponseModels).build();
    }
    
    @DELETE
    @Path("/{id}/item")
    public Response clearGroupedOrders(@PathParam("id") Long groupId) {
        ItemGroup itemGroup = super.facade.find(groupId);
        for (GroupedOrder groupedOrder : itemGroup.getGroupedOrders()) {
            super.genericFacade.remove(GroupedOrder.class, groupedOrder);
        }
        itemGroup.clearGroupedOrder();
        super.facade.edit(itemGroup);
        return Response.status(Response.Status.OK).
                entity(itemGroupConverter.convert(super.facade.find(groupId), null)).build();
    }
    
    @DELETE
    @Path("{groupId}/item/{orderId}")
    public Response removeItem(@PathParam("groupId") Long groupId, @PathParam("itemId") Long orderId) {
        ItemGroup itemGroup = super.facade.find(groupId);
        GroupedOrder tobeRemoved = super.genericFacade.find(GroupedOrder.class, orderId);
        itemGroup.removeGroupedOrder(tobeRemoved);
        super.genericFacade.remove(GroupedOrder.class, tobeRemoved);
        super.facade.edit(itemGroup);
        return Response.status(Response.Status.OK)
                .entity(itemGroupConverter.convert(super.facade.find(groupId), null)).build();
    }
    
    @Override
    protected ItemGroupConverter getConverter() {
        return itemGroupConverter;
    }
    
}
