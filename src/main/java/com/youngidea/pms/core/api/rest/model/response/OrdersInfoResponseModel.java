/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.youngidea.pms.core.api.rest.model.response;

import java.util.List;

/**
 *
 * @author sean
 */
public class OrdersInfoResponseModel {
    
    private List<OrderResponseModel> currentOrders;
    private List<OrderResponseModel> extraOrders;
    private List<OrderResponseModel> discountOrders;
    private int total;
    private int calculatedTotal;
    
    public OrdersInfoResponseModel(){}

    public List<OrderResponseModel> getCurrentOrders() {
        return currentOrders;
    }

    public void setCurrentOrders(List<OrderResponseModel> currentOrders) {
        this.currentOrders = currentOrders;
    }

    public List<OrderResponseModel> getExtraOrders() {
        return extraOrders;
    }

    public void setExtraOrders(List<OrderResponseModel> extraOrders) {
        this.extraOrders = extraOrders;
    }

    public List<OrderResponseModel> getDiscountOrders() {
        return discountOrders;
    }

    public void setDiscountOrders(List<OrderResponseModel> discountOrders) {
        this.discountOrders = discountOrders;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCalculatedTotal() {
        return calculatedTotal;
    }

    public void setCalculatedTotal(int calculatedTotal) {
        this.calculatedTotal = calculatedTotal;
    }
    
}
