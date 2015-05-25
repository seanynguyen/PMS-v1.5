/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.youngidea.pms.core.entity;

import javax.persistence.Column;
import javax.persistence.Temporal;
import java.util.Date;

/**
 *
 * @author sean
 */
public class AuditableEntity extends PMSEntity {
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "created", updatable = false, insertable = true)
    private Date created;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "modified", updatable = true, insertable = true)
    private Date modified;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
    
}
