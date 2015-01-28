/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.entity.order;

import com.youngidea.pms.entity.Bill;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author sean
 */
@Entity
@Table(name="BillingOrder")
public class BillingOrder extends GeneralOrder{
    
    // OrderList or Bill
    @JoinColumn(name = "billID", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Bill bill;

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
    
}
