/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.core.api.rest.model.request;

import com.google.common.collect.Lists;
import com.youngidea.pms.core.api.rest.model.AbstractModel;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 *
 * @author sean
 */
public class ItemRequestModel extends AbstractModel {
    private static final String DEFAULT_IMAGE_URL= "/home/sean/Pictures/15395506730_5b94003d67_m.jpg";

    @NotNull(message="{model.notfound}")
    @Size(min = 2, max = 50, message = "{item.name.size}")
    private String name;
    @Size(min = 5, max = 2000, message = "{item.description.size}")
    private String description;
    private List<ItemPriceRequestModel> itemPrices = Lists.newArrayList();
//    @Pattern(regexp = "[0-9]+", message = "{model.id.pattern}")
    private Long categoryId;
    private String imageURL = DEFAULT_IMAGE_URL;

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
