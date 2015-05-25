/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.core.entity.promotion;

import com.google.common.collect.Lists;
import com.youngidea.pms.core.entity.order.DiscountOrder;
import com.youngidea.pms.core.entity.order.PriceOrder;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author sean
 */
@Entity
@Table(name="PromotionPrice")
public class PromotionPrice implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final int DESCRIPTION_MAX_LENGTH = 6000;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Description", length = DESCRIPTION_MAX_LENGTH)
    private String description;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "promotionPrice", fetch = FetchType.LAZY)
    private List<DiscountOrder> discountOrders;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "promotionPrice", fetch = FetchType.LAZY)
    private List<PriceOrder> priceOrders = Lists.newArrayList();
    
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

    public List<DiscountOrder> getDiscountOrders() {
        return discountOrders;
    }

    public void setDiscountOrders(List<DiscountOrder> discountOrders) {
        this.discountOrders = discountOrders;
    }

    public List<PriceOrder> getExtraOrders() {
        return priceOrders;
    }

    public void addExtraOrder(PriceOrder priceOrder) {
        priceOrders.add(priceOrder);
        priceOrder.setPromotionPrice(this);
    }
    
    public void setExtraOrders(List<PriceOrder> priceOrders) {
        this.priceOrders = priceOrders;
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
        if (!(object instanceof PromotionPrice)) {
            return false;
        }
        PromotionPrice other = (PromotionPrice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PromotionPrice[ id=" + id + " ]";
    }
    
}
