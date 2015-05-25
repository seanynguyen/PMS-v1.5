/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.api.rest.model.response;

import com.youngidea.pms.api.rest.model.AbstractBean;

/**
 *
 * @author sean
 */
public class CategoryModel extends AbstractBean {
//    private static final Long ROOT_CATEGORY_ID = Long.parseLong("100");
    
    private String name;
    private String description;
    private Long parentId;
            
    
    public CategoryModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public CategoryModel() {}
        
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
