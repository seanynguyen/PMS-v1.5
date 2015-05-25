package com.youngidea.pms.core.service;

import com.youngidea.pms.core.entity.order.BillingOrder;

import javax.ejb.Local;

/**
 * Created by sean on 5/23/15.
 */
@Local
public interface BillingService {

    void addOrder(BillingOrder order);

    void removeOrder(BillingOrder order);

    void resetOrders();

    int getTotal();

}
