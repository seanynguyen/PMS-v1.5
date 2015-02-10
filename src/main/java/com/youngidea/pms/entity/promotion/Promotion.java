/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.entity.promotion;

import com.youngidea.pms.entity.PMSEntity;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "promotion", fetch = FetchType.LAZY)
    private List<PromotionRule> promotionRules;

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

    public List<PromotionRule> getPromotionRules() {
        return promotionRules;
    }

    public void setPromotionRules(List<PromotionRule> promotionRules) {
        this.promotionRules = promotionRules;
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
