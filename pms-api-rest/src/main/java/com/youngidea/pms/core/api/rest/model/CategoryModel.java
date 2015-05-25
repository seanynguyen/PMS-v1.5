/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.core.api.rest.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author sean
 */
public class CategoryModel extends AbstractModel {
    
    @NotNull(message="{category.name.notnull}")
    private String name;
    private String description;
    @Pattern(regexp = "[0-9]+", message = "{model.id.pattern}")
    private Long parentId;

    public CategoryModel() {}
    
    public CategoryModel(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public CategoryModel(String name, String description, Long parentId) {
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
