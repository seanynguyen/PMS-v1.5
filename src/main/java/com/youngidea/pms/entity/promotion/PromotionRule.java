/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.entity.promotion;

import com.youngidea.pms.entity.order.RuleOrder;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author sean
 */
@Entity
@Table(name="PromotionRule")
public class PromotionRule implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final int DESCRIPTION_MAX_LENGTH = 4000;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "promotionRule", fetch = FetchType.LAZY)
    private List<RuleOrder> ruleOrders;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="promotionPrice", referencedColumnName = "id") // should be promotionPriceId
    private PromotionPrice promotionPrice;

    @JoinColumn(name = "promotionID", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Promotion promotion;

    @Column(name = "description", length = DESCRIPTION_MAX_LENGTH)
    private String description;

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

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
