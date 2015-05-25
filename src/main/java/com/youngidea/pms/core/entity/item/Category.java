/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.core.entity.item;

import com.youngidea.pms.core.entity.PMSEntity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author sean
 */
@Entity
@Table(name="Category")
public class Category extends PMSEntity {
    private static final long serialVersionUID = 1L;
    private static final int NAME_MAX_LENGTH = 200;
    private static final int DESCRIPTON_MAX_LENGTH = 4000;

    
    @Column(name="name", length = NAME_MAX_LENGTH, nullable = false)
    private String name;
    
    @Column(name="description", length = DESCRIPTON_MAX_LENGTH)
    private String description;
    
    @OneToMany(mappedBy = "parentCategory", fetch = FetchType.EAGER)
    private List<Category> childrenCategory;
    
    @JoinColumn(name = "parentId", referencedColumnName = "id", nullable = true)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Category parentCategory;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "category", fetch = FetchType.LAZY)
    private List<Item> items;
    
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

    public List<Category> getChildrenCategory() {
        return childrenCategory;
    }

    public void setChildrenCategory(List<Category> childrenCategory) {
        this.childrenCategory = childrenCategory;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    
}
