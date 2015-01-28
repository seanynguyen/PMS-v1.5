/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.entity.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author sean
 */
@Entity
@Table(name="DiscountOrder")
public class DiscountOrder extends PriceOrder{
    private static final long serialVersionUID = 1L;
    private static final int DISCOUNT_PERCENT_MAX = 100;
    
    @Column (name = "discountPercent", length = DISCOUNT_PERCENT_MAX)
    private int discountPercent;

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }
    
}
