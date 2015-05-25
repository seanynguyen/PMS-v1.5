/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.youngidea.pms.api.rest.model.response;

import com.youngidea.pms.api.rest.model.AbstractBean;

/**
 *
 * @author sean
 */
public class OrderResponseModel extends AbstractBean {
    private static final int DEFAULT_DISCOUNT_PERCENT = 0;
    private static final int DEFAULT_QUANTITY = 0;
    
//    private String itemName;
//    private String itemStatus;
    private ItemUnit itemUnit;
    private int quantity = DEFAULT_QUANTITY;
    private int discount = DEFAULT_DISCOUNT_PERCENT;
    
    public OrderResponseModel() {    
    }
    
    public OrderResponseModel(ItemUnit itemUnit, int quantity) {
        this.itemUnit = itemUnit;
        this.quantity = quantity;
    }
    
    public OrderResponseModel(ItemUnit itemUnit, int quantity, int discount) {
        this.itemUnit = itemUnit;
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

    public ItemUnit getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(ItemUnit itemUnit) {
        this.itemUnit = itemUnit;
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
