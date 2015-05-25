/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.core.api.rest.model.response;

import com.google.common.collect.Lists;
import com.youngidea.pms.core.api.rest.model.AbstractModel;

import java.util.List;

/**
 *
 * @author sean
 */
public class ItemGroupResponseModel extends AbstractModel {
    
    private String name;
    private String description;
    private int price;
    private List<OrderResponseModel> orderResponseModels = Lists.newArrayList();

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<OrderResponseModel> getOrderResponseModels() {
        return orderResponseModels;
    }

    public void setOrderResponseModels(List<OrderResponseModel> OrderResponseModels) {
        this.orderResponseModels = OrderResponseModels;
    }

}
