/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.core.api.rest.model.response;

import com.youngidea.pms.core.api.rest.model.AbstractBean;

/**
 *
 * @author sean
 */
public class ItemUnit extends AbstractBean {
    
    private String name;
    private String description;
    private ItemPriceResponseModel itemPriceResponseModel;
    private String imageURL;

    public ItemUnit() {
        
    }
    
    public ItemUnit(Long id, String name, String description, String imageURL) {
        super(id);
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
    }

    public ItemUnit(String name, String description, ItemPriceResponseModel itemPriceResponseModel, String imageURL, Long id) {
        super(id);
        this.name = name;
        this.description = description;
        this.itemPriceResponseModel = itemPriceResponseModel;
        this.imageURL = imageURL;
    }    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemPriceResponseModel getItemPriceResponseModel() {
        return itemPriceResponseModel;
    }

    public void setItemPriceResponseModel(ItemPriceResponseModel itemPriceResponseModel) {
        this.itemPriceResponseModel = itemPriceResponseModel;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

}
