/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.entity.promotion;

import com.youngidea.pms.entity.order.RuleOrder;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author sean
 */
@Entity
@Table(name="PromotionRule")
public class PromotionRule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "promotionRule", fetch = FetchType.LAZY)
    private List<RuleOrder> ruleOrders;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="promotionPrice", referencedColumnName = "id") // should be promotionPriceId
    private PromotionPrice promotionPrice;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "promotionRule", fetch = FetchType.LAZY)
    private List<Promotion> promotions;

    public List<RuleOrder> getRuleOrders() {
        return ruleOrders;
    }

    public void addRuleOrder(RuleOrder ruleOrder) {
        ruleOrders.add(ruleOrder);
        ruleOrder.setPromotionRule(this);
    }
    
    public void setRuleOrders(List<RuleOrder> ruleOrders) {
        this.ruleOrders = ruleOrders;
    }

    public PromotionPrice getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(PromotionPrice promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PromotionRule)) {
            return false;
        }
        PromotionRule other = (PromotionRule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.youngidea.pms.entity.promotion.PromotionRule[ id=" + id + " ]";
    }
    
}
