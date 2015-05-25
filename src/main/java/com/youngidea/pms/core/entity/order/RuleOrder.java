/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.core.entity.order;

import com.youngidea.pms.core.entity.item.ItemPrice;
import com.youngidea.pms.core.entity.promotion.PromotionRule;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author sean
 */
@Entity
@Table(name="RuleOrder")
public class RuleOrder extends GeneralOrder {
    private static final long serialVersionUID = 1L;
    
    @JoinColumn(name = "promotionRuleID", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PromotionRule promotionRule;

    public RuleOrder() {
        
    }
    
    public RuleOrder(ItemPrice itemPrice, int quantity) {
        super(itemPrice, quantity);
    }
    
    public RuleOrder(ItemPrice itemPrice, int quantity, PromotionRule promotionRule) {
        super(itemPrice, quantity);
        this.promotionRule = promotionRule;
    }
    
    public PromotionRule getPromotionRule() {
        return promotionRule;
    }

    public void setPromotionRule(PromotionRule promotionRule) {
        this.promotionRule = promotionRule;
    }
}
