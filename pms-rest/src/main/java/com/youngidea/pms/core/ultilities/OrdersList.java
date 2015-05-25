/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.core.ultilities;

import com.youngidea.pms.api.rest.model.OrderRequestModel;

import java.util.ArrayList;

/**
 *
 * @author sean
 */
public class OrdersList extends ArrayList<OrderRequestModel> {

    public OrdersList() {
        super();
    }

    public boolean containOrder(OrderRequestModel order) {
        return indexOfOrder(order) >= 0;
    }

    public int indexOfOrder(OrderRequestModel order) {
        if (order == null) {
            for (int i = 0; i < super.size(); i++) {
                if (super.get(i) == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < super.size(); i++) {
                if (order.is((OrderRequestModel) super.get(i))) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    // auto add
    public void addOrder(OrderRequestModel order) {
        if (containOrder(order)) {
            OrderRequestModel addedOrder = retrieveOrder(order);
            addedOrder.setQuantity(addedOrder.getQuantity() + order.getQuantity());
        } else {
            super.add(order);
        }
    }

    public void removeOrder(OrderRequestModel order) {
        int tobeRemovedQuan = order.getQuantity();
        OrderRequestModel addedOrder = retrieveOrder(order);

        if (tobeRemovedQuan >= addedOrder.getQuantity()) {
            this.remove(retrieveOrder(order));
        } else {
            addedOrder.setQuantity(addedOrder.getQuantity() - order.getQuantity());
        }
    }

    public OrderRequestModel retrieveOrder(OrderRequestModel order) {
        return super.get(indexOfOrder(order));
    }

}
