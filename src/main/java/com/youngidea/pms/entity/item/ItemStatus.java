/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.entity.item;

import com.youngidea.pms.entity.PMSEntity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author sean
 */
@Entity
@Table(name="ItemStatus")
public class ItemStatus extends PMSEntity {
    private static final long serialVersionUID = 1L;
    private static final int NAME_MAX_LENGTH = 200;
    private static final int DESCRIPTIOM_MAX_LENGTH = 4000;
    
    @Column(name="name", length = NAME_MAX_LENGTH, unique = true)
    private String name;
    
    @Column(name="description", length = DESCRIPTIOM_MAX_LENGTH) 
    private String description;
    
    @Column(name="imageURL")
    private String imageURL;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemStatus", fetch = FetchType.LAZY)
    private List<ItemPrice> itemPrices;
    
    
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public List<ItemPrice> getItemPrices() {
        return itemPrices;
    }

    public void setItemPrices(List<ItemPrice> itemPrices) {
        this.itemPrices = itemPrices;
    }


}
