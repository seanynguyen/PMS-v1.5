/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.api.rest.model;

import java.io.Serializable;

/**
 *
 * @author sean
 */
public class AbstractBean implements Serializable {

    private Long id;

    public AbstractBean(Long id) {
        this.id = id;
    }

    public AbstractBean() {

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

        AbstractBean that = (AbstractBean) o;

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
