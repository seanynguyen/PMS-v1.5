/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.core.api.rest.model;

/**
 *
 * @author sean
 */
public class OrderRequestModel extends AbstractBean {
    private static final int DEFAULT_DISCOUNT_PERCENT = 0;
    private static final int DEFAULT_QUANTITY = 0;
    
    private Long priceId;
    private int quantity = DEFAULT_QUANTITY;
    private int discount = DEFAULT_DISCOUNT_PERCENT;

    public OrderRequestModel() {
    }

    public OrderRequestModel(Long priceId, int quantity) {
        this.priceId = priceId;
        this.quantity = quantity;
    }
    
    public OrderRequestModel(Long priceId, int quantity, int discount) {
        this.priceId = priceId;
        this.quantity = quantity;
        this.discount = discount;
    }

    public Long getPriceId() {
        return priceId;
    }

    public void setPriceId(Long priceId) {
        this.priceId = priceId;
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
     

    public boolean is(OrderRequestModel that) {
        
        if (this == that) {
            return true;
        }
        
        if (that == null || getClass() != that.getClass() || 
                !this.priceId.equals(that.getPriceId())) {
            return false;
        }

//        if (!this.itemId.equals(that.getItemId()) || 
//                !this.priceId.equals(that.getPriceId())) {
//            return false;
//        }

        return true;
    }
    
}
