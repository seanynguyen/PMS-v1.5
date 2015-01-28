/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.m;

import com.youngidea.m.Person;
import com.youngidea.pms.api.rest.CRUIDServiceREST;
import com.youngidea.pms.converter.ItemConverter;
import com.youngidea.pms.entity.item.Category;
import com.youngidea.pms.entity.item.Item;
import com.youngidea.pms.entity.item.ItemPrice;
import com.youngidea.pms.entity.item.ItemStatus;
import com.youngidea.pms.model.request.ItemPriceRequestModel;
import com.youngidea.pms.model.request.ItemRequestModel;
import com.youngidea.pms.model.response.ItemResponseModel;
import java.util.List;
import javax.ejb.EJB;
import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author sean
 */
@Path("/item1")
public class ItemServiceREST1 extends CRUIDServiceREST<Item, ItemRequestModel, ItemResponseModel> {

    @EJB
    protected ItemConverter itemConverter;

    public ItemServiceREST1() {
        super(ItemRequestModel.class, ItemResponseModel.class, Item.class);
    }

    @POST
    @Consumes({"application/xml", "application/json"}) // create then add prices
    @Override
    public Response create(ItemRequestModel itemRequestModel) {
        super.facade.create(itemConverter.convertBack(itemRequestModel, addPrices(new Item(),
                itemRequestModel.getItemPrices())));
        return Response.status(Response.Status.CREATED).
                entity(itemRequestModel).build();
    }

    private Item addPrices(Item item, List<ItemPriceRequestModel> itemPriceModels) {
        for (ItemPriceRequestModel priceBean : itemPriceModels) {
            ItemStatus status = genericFacade.find(ItemStatus.class, priceBean.getStatusId());
            item.addPrice(new ItemPrice(status, priceBean.getPrice()));
        }
        return item;
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    @Override
    public Response edit(ItemRequestModel itemRequestModel) {
        clearItemPrices(itemRequestModel.getId());
        for (ItemPriceRequestModel priceBean : itemRequestModel.getItemPrices()) {
            addItemPrice(itemRequestModel.getId(), priceBean);
        }
        super.facade.edit(itemConverter.convertBack(itemRequestModel,
                super.facade.find(itemRequestModel.getId())));
        return Response.status(Response.Status.OK).
                entity(itemRequestModel).build();
    }

    @POST
    @Path("{itemId}/price")
    @Consumes({"application/xml", "application/json"})
    public Response addItemPrice(@PathParam("itemId") Long itemId, ItemPriceRequestModel itemPriceBean) {
        Item item = super.facade.find(itemId);
        ItemPrice itemPrice = new ItemPrice(super.genericFacade.find(ItemStatus.class, itemPriceBean.getStatusId()),
                itemPriceBean.getPrice());
        super.genericFacade.create(ItemPrice.class, itemPrice);
        item.addPrice(itemPrice);
        super.facade.edit(item);
        return Response.status(Response.Status.OK).
                entity(itemConverter.convert(super.facade.find(itemId), null)).build();
    }

    @DELETE
    @Path("{itemId}/price")
    @Produces({"application/xml", "application/json"})
    public Response clearItemPrices(@PathParam("itemId") Long itemId) throws ValidationException {
        Item item = super.facade.find(itemId);
        for (ItemPrice itemPrice : item.getItemPrices()) {
            super.genericFacade.remove(ItemPrice.class, itemPrice);
        }
        item.clearPrices();
        super.facade.edit(item);
        return Response.status(Response.Status.OK).
                entity(itemConverter.convert(super.facade.find(itemId), null)).build();
    }

    @DELETE
    @Path("{itemId}/price/{itemPriceId}")
    public Response removeItemPrice(@PathParam("itemId") Long itemId, @PathParam("itemPriceId") Long itemPriceId) throws ValidationException {
        Item item = super.facade.find(itemId);
        ItemPrice tobeRemoved = super.genericFacade.find(ItemPrice.class, itemPriceId);
        item.removePrice(tobeRemoved); //  
        super.genericFacade.remove(ItemPrice.class, tobeRemoved); // remove from database, avoid reload after reploy app
        super.facade.edit(item); // 
        return Response.status(Response.Status.OK).
                entity(itemConverter.convert(super.facade.find(itemId), null)).build();
    }

    @GET
    @Path("{itemId}/category/{categoryId}")
    public Response setCategory(@PathParam("itemId") Long itemId, @PathParam("categoryId") Long categoryId) throws ValidationException {
        Item item = super.facade.find(itemId);
        item.setCategory(super.genericFacade.find(Category.class, categoryId));
        super.facade.edit(item);
        return Response.status(Response.Status.OK).
                entity(itemConverter.convert(super.facade.find(itemId), null)).build();
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    @Path("/testValidation")
    public Response testValidation(@Valid ItemRequestModel item) {
//        facade.create(getConverter().convertBack(model, null));
        return Response.status(Response.Status.CREATED).
                entity(item).build();
    }

    @Override
    protected ItemConverter getConverter() {
        return itemConverter;
    }
}
