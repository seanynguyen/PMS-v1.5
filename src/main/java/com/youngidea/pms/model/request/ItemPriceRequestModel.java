/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.model.request;

import com.youngidea.pms.model.AbstractBean;

/**
 *
 * @author sean
 */
public class ItemPriceRequestModel extends AbstractBean{
    private static final int DEFAULT_PRICE_VALUE = 0;
    
    private Long statusId;
    private int price = DEFAULT_PRICE_VALUE;
    
    public ItemPriceRequestModel() {
        
    }
    
    public ItemPriceRequestModel(int price, Long statusId) {
        this.price = price;
        this.statusId = statusId;
    }
    
    public ItemPriceRequestModel(Long id, int price, Long statusId) {
        super(id);
        this.price = price;
        this.statusId = statusId;
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

}
