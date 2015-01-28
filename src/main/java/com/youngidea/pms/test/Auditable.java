/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.youngidea.pms.test;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author sean
 */
public interface Auditable {

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false, updatable = false, insertable = true)
    public Date getCreated();
    
    public void setCreated(Date date);

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "modified", nullable = false, updatable = true, insertable = true)
    public Date getModified();

    public void setModified(Date date);
}

