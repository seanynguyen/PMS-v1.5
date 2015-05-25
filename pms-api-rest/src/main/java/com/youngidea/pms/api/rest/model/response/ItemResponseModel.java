/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.api.rest.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.youngidea.pms.api.rest.model.AbstractModel;
import com.youngidea.pms.api.rest.model.CategoryModel;

import java.util.List;


/**
 *
 * @author sean
 */
public class ItemResponseModel extends AbstractModel {
    
    private String name;
    private String description;
    @JsonProperty("itemPrices")
    private List<ItemPriceResponseModel> itemPriceResponseModels;
    private String imageURL;
    @JsonProperty("category")
    private CategoryModel categoryModel;
    
    // Use when errors come
    public ItemResponseModel() {
        
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

    public List<ItemPriceResponseModel> getItemPriceResponseModels() {
        return itemPriceResponseModels;
    }

    public void setItemPriceResponseModels(List<ItemPriceResponseModel> itemPriceResponseModels) {
        this.itemPriceResponseModels = itemPriceResponseModels;
    }
    
    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

//    public CategoryModel getCategoryId() {
//        return categoryModel;
//    }
//
//    public void setCategoryModel(CategoryModel categoryModel) {
//        this.categoryModel = categoryModel;
//    }

    public CategoryModel getCategoryModel() {
        return categoryModel;
    }

    public void setCategoryModel(CategoryModel testModel4) {
        this.categoryModel = testModel4;
    }

}
