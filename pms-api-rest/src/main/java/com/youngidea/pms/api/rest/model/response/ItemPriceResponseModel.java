/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.api.rest.model.response;

import com.youngidea.pms.api.rest.model.AbstractModel;
import com.youngidea.pms.api.rest.model.ItemStatusModel;

/**
 *
 * @author sean
 */
public class ItemPriceResponseModel extends AbstractModel {
    
   private ItemStatusModel itemStatusModel;
   private int price;
   
   public ItemPriceResponseModel(Long id, ItemStatusModel itemStatusBean, int price) {
       super(id);
       this.itemStatusModel = itemStatusBean;
       this.price = price;
   }

   public ItemPriceResponseModel() {}
           
    public ItemStatusModel getItemStatusBean() {
        return itemStatusModel;
    }

    public void setItemStatusBean(ItemStatusModel itemStatusBean) {
        this.itemStatusModel = itemStatusBean;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
   
}
