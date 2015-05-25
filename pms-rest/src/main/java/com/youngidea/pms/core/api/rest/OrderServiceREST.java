/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.core.api.rest;

import com.youngidea.pms.core.api.rest.model.OrderRequestModel;
import com.youngidea.pms.core.api.rest.model.response.OrdersInfoResponseModel;
import com.youngidea.pms.core.service.BillingService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author sean
 */
@Stateless
@Path("/orderService")
public class OrderServiceREST {
    
    @EJB
    private BillingService billingService;
    
    @POST
    @Path("/add")
    @Consumes({"application/xml", "application/json"}) // create then add prices
    public Response addOrder(OrderRequestModel orderModel) {
        billingService.addOrder(orderModel);
        return Response.status(Response.Status.OK)
                .entity(billingService.getCurrentOrders()).build();
    }
    
    @POST
    @Path("/remove")
    @Consumes({"application/xml", "application/json"}) // create then add prices
    public Response removeOrder(OrderRequestModel orderModel) {
        billingService.removeOrder(orderModel);
        return Response.status(Response.Status.OK)
                .entity(billingService.getCurrentOrders()).build();
    }
    
    @GET
    @Path("/reset")
    public Response clearOrders() {
        billingService.resetOrders();
        return Response.status(Response.Status.OK)
                .entity(billingService.getCurrentOrders()).build();
    }
    
    @GET
    @Path("/total")
    public Response getTotal() {
        return Response.status(Response.Status.FOUND)
                .entity(billingService.getCalculatedTotal()).build();
    }
    
    @GET
    @Path("/discountOrders")
    public Response getDiscountList() {
        return Response.status(Response.Status.FOUND)
                .entity(billingService.getDiscountOrders()).build();
    }
    
    @GET
    @Path("/extraOrders")
    public Response getExtraList() {
        return Response.status(Response.Status.FOUND)
                .entity(billingService.getExtraOrder()).build();
    }
    
    @GET
    @Path("/ordersInfo")
    public Response getOrderInfo() {
        OrdersInfoResponseModel ordersInfo = new OrdersInfoResponseModel();
        ordersInfo.setTotal(billingService.getTotal());
        ordersInfo.setCalculatedTotal(billingService.getCalculatedTotal());
        ordersInfo.setCurrentOrders(billingService.getCurrentOrders());
        ordersInfo.setDiscountOrders(billingService.getDiscountOrders());
        ordersInfo.setExtraOrders(billingService.getExtraOrder());
        return Response.status(Response.Status.FOUND)
                .entity(ordersInfo).build();
    }
    
}
