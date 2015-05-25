/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.api.rest.model.request;

import com.google.common.collect.Lists;
import com.youngidea.pms.api.rest.model.AbstractModel;
import com.youngidea.pms.api.rest.model.OrderRequestModel;

import java.util.List;

/**
 *
 * @author sean
 */
public class ItemGroupRequestModel extends AbstractModel {
    
    private String name;
    private String description;
    private List<OrderRequestModel> orderRequestModels = Lists.newArrayList();
    private int price;

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

    public List<OrderRequestModel> getOrderRequestModels() {
        return orderRequestModels;
    }

    public void setOrderRequestModels(List<OrderRequestModel> orderRequestModels) {
        this.orderRequestModels = orderRequestModels;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
