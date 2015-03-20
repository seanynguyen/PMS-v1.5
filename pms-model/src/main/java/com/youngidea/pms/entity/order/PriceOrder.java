/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.entity.order;

import com.youngidea.pms.entity.promotion.PromotionPrice;

import javax.persistence.*;

/**
 *
 * @author sean
 */
@Entity
@Table(name="PriceOrder")
public class PriceOrder extends GeneralOrder {
    private static final long serialVersionUID = 1L;
    
    @JoinColumn(name = "promotionPriceID", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PromotionPrice promotionPrice;

    public PromotionPrice getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(PromotionPrice promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

}
