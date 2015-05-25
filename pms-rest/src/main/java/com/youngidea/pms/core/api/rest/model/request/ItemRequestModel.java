/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.core.api.rest.model.request;

import com.google.common.collect.Lists;
import com.youngidea.pms.core.api.rest.model.AbstractModel;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 *
 * @author sean
 */
public class ItemRequestModel extends AbstractModel {
    private static final String DEFAULT_IMAGE_URL= "/home/sean/Pictures/15395506730_5b94003d67_m.jpg";
    
    
    @NotNull(message="{entity.item.name.notnull}")
    private String name;
    private String description;
    private List<ItemPriceRequestModel> itemPrices = Lists.newArrayList();
    private Long categoryId;
    private String imageURL = DEFAULT_IMAGE_URL;
    
    
    // Use when errors come
    public ItemRequestModel() {
        
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

    public List<ItemPriceRequestModel> getItemPrices() {
        return itemPrices;
    }

    public void setItemPrices(List<ItemPriceRequestModel> itemPrices) {
        this.itemPrices = itemPrices;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

}
