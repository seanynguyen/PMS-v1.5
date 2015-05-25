/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.api.rest.model.request;

import com.youngidea.pms.api.rest.model.AbstractBean;
import com.youngidea.pms.api.rest.model.OrderRequestModel;

import java.util.List;
import com.google.common.collect.Lists;

/**
 *
 * @author sean
 */
public class ItemGroupRequestModel extends AbstractBean {
    
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
