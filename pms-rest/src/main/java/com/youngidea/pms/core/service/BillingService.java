/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.core.service;

import com.youngidea.pms.api.rest.model.OrderRequestModel;
import com.youngidea.pms.api.rest.model.response.OrderResponseModel;

import javax.ejb.Local;
import java.util.List;

/**
 *
 * @author sean
 */
@Local
public interface BillingService {
    
    void addOrder(OrderRequestModel order);
    
    void resetOrders();
    
    void removeOrder(OrderRequestModel order);
    
    // just to test
    int getTotal();
    
    int getCalculatedTotal(); 
    
    List<OrderResponseModel> getCurrentOrders();
    
    List<OrderResponseModel> getDiscountOrders();
    
    List<OrderResponseModel> getExtraOrder();
    
    String testQuartz();
    
    String testQuartz2();
    //
}
