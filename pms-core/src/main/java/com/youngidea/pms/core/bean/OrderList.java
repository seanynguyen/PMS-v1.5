package com.youngidea.pms.core.bean;

import com.youngidea.pms.core.entity.order.GeneralOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sean on 5/23/15.
 */
public class OrderList<Order extends GeneralOrder> extends ArrayList<Order> {

    public OrderList() {
        super();
    }

    public OrderList(List<Order> orders) {
        super(orders);
    }

    public OrderList(OrderList orderList) {
        super(orderList);
    }

    @Override
    public boolean add(Order order) {
        if (super.contains(order)) {
            Order addedOrder = super.get(indexOf(order));
            addedOrder.setQuantity(addedOrder.getQuantity() + order.getQuantity());
        } else {
            super.add(order);
        }
        return true;
    }

    @Override
    public boolean remove(Object object) {
        Order order = (Order) object;
        int tobeSubtracted = order.getQuantity();
        Order addedOrder = super.get(indexOf(order));
        // if to be removed order has larger quantity value than the current one, just remove it from the order list.
        if (tobeSubtracted >= addedOrder.getQuantity()) {
            this.remove(addedOrder);
        } else {
            addedOrder.setQuantity(addedOrder.getQuantity() - order.getQuantity());
        }
        return false;
    }

    @Override
    public int indexOf(Object object) {
        if (object == null) {
            for (int i = 0; i < super.size(); i++) {
                if (super.get(i) == null) {
                    return i;
                }
            }
        } else {
            Order order = (Order) object;
            for (int i = 0; i < super.size(); i++) {
                if (order.is(super.get(i))) {
                    return i;
                }
            }
        }
        return -1;
    }

}
