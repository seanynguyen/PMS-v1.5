/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.entity.promotion;

import com.youngidea.pms.ultilities.PeriodicType;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author sean
 */
@Entity
@Table(name="PeriodicSchedule")
public class PeriodicSchedule extends Schedule {

    private static final int TYPE_MAX_LENGTH = 15;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "periodicStartTime", updatable = true, insertable = true)
    private Date periodicStartTime;

    @Column(name = "type", length = TYPE_MAX_LENGTH)
    @Enumerated(value = EnumType.STRING)
    private PeriodicType type;

    public PeriodicSchedule() {
        
    }
    
    // copy constructor    
    public PeriodicSchedule(PeriodicSchedule another) {
        super(another.getStartTime(), another.getEndTime(), another.isIsActive());
        this.periodicStartTime = another.getPeriodicStartTime();
        this.type = another.getType();
    }
    
    // copy contructor with different periodic Start time
    public PeriodicSchedule(PeriodicSchedule another, Date periodicStartTime) {
        super(another.getStartTime(), another.getEndTime(), another.isIsActive());
        this.periodicStartTime = periodicStartTime;
        this.type = another.getType();
    }

    public Date getPeriodicStartTime() {
        return periodicStartTime;
    }

    public void setPeriodicStartTime(Date periodicStartTime) {
        this.periodicStartTime = periodicStartTime;
    }

    public PeriodicType getType() {
        return type;
    }

    public void setType(PeriodicType type) {
        this.type = type;
    }

}
