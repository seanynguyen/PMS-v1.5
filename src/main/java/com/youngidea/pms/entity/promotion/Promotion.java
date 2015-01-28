/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.entity.promotion;

import com.youngidea.pms.entity.PMSEntity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author sean
 */
@Entity
@Table(name = "Promotion")
public class Promotion extends PMSEntity {

    private static final long serialVersionUID = 1L;
    private static final int NAME_MAX_LENGTH = 500;
    private static final int DESCRIPTION_MAX_LENGTH = 6000;

    @Column(name = "name", length = NAME_MAX_LENGTH)
    private String name;

    @Column(name = "description", length = DESCRIPTION_MAX_LENGTH)
    private String description;

    @JoinColumn(name = "promotionRuleID", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.MERGE, optional = false, fetch = FetchType.LAZY)
    private PromotionRule promotionRule;

    // Condition
    // Schedule
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "scheduleId", referencedColumnName = "id")
    private PeriodicSchedule periodicSchedule;

    @Column(name = "period")
    private Long period;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PromotionRule getPromotionRule() {
        return promotionRule;
    }

    public void setPromotionRule(PromotionRule promotionRule) {
        this.promotionRule = promotionRule;
    }

    public PeriodicSchedule getPeriodicSchedule() {
        return periodicSchedule;
    }

    public void setPeriodicSchedule(PeriodicSchedule periodicSchedule) {
        this.periodicSchedule = periodicSchedule;
    }

    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }
    
}
