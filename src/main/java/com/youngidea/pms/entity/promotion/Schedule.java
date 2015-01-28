/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.youngidea.pms.entity.promotion;

import com.youngidea.pms.entity.PMSEntity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;

/**
 *
 * @author sean
 */
@MappedSuperclass
public class Schedule extends PMSEntity {
    private static final boolean DEFAULT_ACTIVATE_STATUS = true;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "start", updatable = true, insertable = true)
    private Date startTime;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "end", updatable = true, insertable = true)
    private Date endTime;

    @Column(name="isActive")
    private boolean isActive = DEFAULT_ACTIVATE_STATUS;

    public Schedule(){
        
    }
    
    public Schedule(Date startTime, Date endTime, boolean isActive) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.isActive = isActive;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

}
