/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.model.response;

import com.youngidea.pms.model.AbstractBean;
import javax.validation.constraints.NotNull;

/**
 *
 * @author sean
 */
public class CategoryModel1 extends AbstractBean {
    
    @NotNull(message="{entity.category.name.notnull}")
    private String name;
    private String description;
    private Long parentId;

    public CategoryModel1() {}
    
    public CategoryModel1(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public CategoryModel1(String name, String description, Long parentId) {
        this.name = name;
        this.description = description;
        this.parentId = parentId;
    }

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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    
}
