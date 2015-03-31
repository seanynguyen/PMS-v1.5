/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.api.rest.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author sean
 */
@XmlRootElement
public abstract class AbstractModel implements Serializable {

    private Long id;

    public AbstractModel(Long id) {
        this.id = id;
    }

    public AbstractModel() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractModel that = (AbstractModel) o;

        if (id == null ? that.id != null : !id.equals(that.id)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }

}
