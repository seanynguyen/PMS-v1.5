/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.model.response;

import com.youngidea.pms.model.AbstractBean;
import java.util.List;


/**
 *
 * @author sean
 */
public class ItemResponseModel extends AbstractBean {
    
    private String name;
    private String description;
    private List<ItemPriceResponseModel> itemPriceResponseModels;
//    private CategoryModel categoryModel = new CategoryModel();
    private String imageURL;
    private CategoryModel1 categoryModel1;
    
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

    public CategoryModel1 getCategoryModel1() {
        return categoryModel1;
    }

    public void setCategoryModel1(CategoryModel1 testModel4) {
        this.categoryModel1 = testModel4;
    }

}
