/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.core.entity.promotion;

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
@Table(name="PromotionCondition")
public class PromotionCondition implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column ( name = "priceBound" )
    private int priceBound;
    
//    Will be implemented in the future    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventCondition", fetch = FetchType.LAZY)
//    private List<CustomCondition> otherConditions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPriceBound() {
        return priceBound;
    }

    public void setPriceBound(int priceBound) {
        this.priceBound = priceBound;
    }
    
}
