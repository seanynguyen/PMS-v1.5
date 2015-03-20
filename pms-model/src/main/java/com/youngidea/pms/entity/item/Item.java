/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.entity.item;

import com.google.common.collect.Lists;
import com.youngidea.pms.entity.PMSEntity;

import javax.persistence.*;
import java.util.List;

/**
 *
 * @author sean
 */
@Entity
@Table(name = "Item")

public class Item extends PMSEntity {

    private static final long serialVersionUID = 1L;
    private static final int NAME_MAX_LENGTH = 200;
    private static final int DESCRIPTION_MAX_LENGTH = 4000;

    @Column(name = "name", length = NAME_MAX_LENGTH, nullable = false)
    private String name;

    @Column(name = "description", length = DESCRIPTION_MAX_LENGTH)
    private String description;

    @JoinColumn(name = "categoryID", referencedColumnName = "id")
//    @ManyToOne(cascade = CascadeType.ALL) - Khi tao ra item -> tao ra category theo chieu tiep tuc
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Category category;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item", fetch = FetchType.EAGER)
    private List<ItemPrice> itemPrices = Lists.newArrayList();
    
    @Column(name="imageURL")
    private String imageURL;
    
//    @ManyToMany(mappedBy = "items", cascade = CascadeType.ALL)
//    protected List<ItemGroup> itemGroups;

    
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

    public List<ItemPrice> getItemPrices() {
        return itemPrices;
    }

    public void setItemPrices(List<ItemPrice> itemPrices) {
        this.itemPrices = itemPrices;
    }

//    public List<ItemGroup> getItemGroups() {
//        return itemGroups;
//    }

//    public void addGroup(ItemGroup itemGroup) {
//        this.itemGroups.add(itemGroup);
//        itemGroup.getItemPrices().add(this);
//    }
    
//    public void setItemGroups(List<ItemGroup> itemGroups) {
//        this.itemGroups = itemGroups;
//    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    
    public void addPrice(ItemPrice itemPrice) {
        itemPrices.add(itemPrice);
        itemPrice.setItem(this);
    }

    public void removePrice(ItemPrice itemPrice) {
        itemPrices.remove(itemPrice);
    }
    
    public void clearPrices() {
        itemPrices.clear();
    }
}
