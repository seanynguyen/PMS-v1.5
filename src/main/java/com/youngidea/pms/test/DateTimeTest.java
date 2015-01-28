/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.youngidea.pms.test;

import com.youngidea.pms.entity.PMSEntity;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author sean
 */
@Entity
public class DateTimeTest extends PMSEntity implements Auditable {
    private static final int MAX_PERIODIC_START = 24;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "created", updatable = false, insertable = true)
    private Date created;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "modified", updatable = true, insertable = true)
    private Date modified;

    @Column(name = "TIME_FIELD", length = MAX_PERIODIC_START) 
    private java.sql.Time timeField;
    
    @Override
    public Date getCreated() {
        return created;
    }

    @Override
    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public Date getModified() {
        return modified;
    }

    @Override
    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Time getTimeField() {
        return timeField;
    }

    public void setTimeField(Time timeField) {
        this.timeField = timeField;
    }

}
