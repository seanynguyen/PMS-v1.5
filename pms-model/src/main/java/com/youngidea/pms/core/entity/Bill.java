package com.youngidea.pms.core.entity;

import com.youngidea.pms.core.entity.order.BillingOrder;

import javax.persistence.*;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sean
 */
@Entity
@Table(name="Bill")
public class Bill extends PMSEntity{
    
    @OneToMany(mappedBy = "bill", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BillingOrder> billingOrders;

    public List<BillingOrder> getBillingOrders() {
        return billingOrders;
    }

    public void setBillingOrders(List<BillingOrder> billingOrders) {
        this.billingOrders = billingOrders;
    }
    
}
