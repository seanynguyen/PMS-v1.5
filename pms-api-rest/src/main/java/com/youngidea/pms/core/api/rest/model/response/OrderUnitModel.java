/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.core.api.rest.model.response;

import com.youngidea.pms.core.api.rest.model.AbstractModel;

/**
 *
 * @author sean
 */
public class OrderUnitModel extends AbstractModel {
    
    private String itemName;
    private String itemDescription;
    private ItemPriceResponseModel itemPriceResponseModel;
    private String itemImageURL;

    public OrderUnitModel() {
        
    }
    
    public OrderUnitModel(Long id, String name, String description, String imageURL) {
        super(id);
        this.itemName = name;
        this.itemDescription = description;
        this.itemImageURL = imageURL;
    }

    public OrderUnitModel(String name, String description, ItemPriceResponseModel itemPriceResponseModel, String imageURL, Long id) {
        super(id);
        this.itemName = name;
        this.itemDescription = description;
        this.itemPriceResponseModel = itemPriceResponseModel;
        this.itemImageURL = imageURL;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public ItemPriceResponseModel getItemPriceResponseModel() {
        return itemPriceResponseModel;
    }

    public void setItemPriceResponseModel(ItemPriceResponseModel itemPriceResponseModel) {
        this.itemPriceResponseModel = itemPriceResponseModel;
    }

    public String getItemImageURL() {
        return itemImageURL;
    }

    public void setItemImageURL(String itemImageURL) {
        this.itemImageURL = itemImageURL;
    }
}
