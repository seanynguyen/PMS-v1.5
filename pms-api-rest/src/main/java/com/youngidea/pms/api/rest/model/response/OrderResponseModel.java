/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.youngidea.pms.api.rest.model.response;

import com.youngidea.pms.api.rest.model.AbstractModel;

/**
 *
 * @author sean
 */
public class OrderResponseModel extends AbstractModel {
    private static final int DEFAULT_DISCOUNT_PERCENT = 0;
    private static final int DEFAULT_QUANTITY = 0;
    
//    private String itemName;
//    private String itemStatus;
    private OrderUnitModel orderUnitModel;
    private int quantity = DEFAULT_QUANTITY;
    private int discount = DEFAULT_DISCOUNT_PERCENT;
    
    public OrderResponseModel() {    
    }
    
    public OrderResponseModel(OrderUnitModel orderUnitModel, int quantity) {
        this.orderUnitModel = orderUnitModel;
        this.quantity = quantity;
    }
    
    public OrderResponseModel(OrderUnitModel orderUnitModel, int quantity, int discount) {
        this.orderUnitModel = orderUnitModel;
        this.quantity = quantity;
        this.discount = discount;
    }

//    public String getItemName() {
//        return itemName;
//    }
//
//    public void setItemName(String itemName) {
//        this.itemName = itemName;
//    }
//
//    public String getItemStatus() {
//        return itemStatus;
//    }
//
//    public void setItemStatus(String itemStatus) {
//        this.itemStatus = itemStatus;
//    }

    public OrderUnitModel getOrderUnitModel() {
        return orderUnitModel;
    }

    public void setOrderUnitModel(OrderUnitModel orderUnitModel) {
        this.orderUnitModel = orderUnitModel;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
    
}
