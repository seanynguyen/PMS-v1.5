/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.entity.item;

import com.google.common.collect.Lists;
import com.youngidea.pms.entity.PMSEntity;

import javax.persistence.*;
import java.util.Iterator;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "category", fetch = FetchType.LAZY)
    private List<Item> items = Lists.newArrayList();
    
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

    public void addItem(Item item) {
        items.add(item);
        item.setCategory(this);
    }

    public void removeItem(Item item) {
        items.remove(item);
        item.setCategory(null);
    }

    public void setItems(List<Item> items) {
        for (Item item : items) {
            if (!this.items.contains(item)) {
                item.setCategory(this);
            }
        }
        for (Item currentItem : this.items) {
            if (!items.contains(currentItem)) {
                currentItem.setCategory(null);
            }
        }
        this.items = items;
    }

}
