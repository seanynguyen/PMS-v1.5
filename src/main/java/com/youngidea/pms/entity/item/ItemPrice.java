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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author sean
 */
@Entity
@Table(name="ItemPrice")

public class ItemPrice extends PMSEntity{
    private static final long serialVersionUID = 1L;
    private static final int MIN_PRICE_VALUE = 0;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="statusID", referencedColumnName="id")
    private ItemStatus itemStatus;
    
    @JoinColumn(name = "itemID", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Item item; // thang nho add thagn lon thi ok, nguoc lai thi ko
    
    @Column(name="price")
    private int price = MIN_PRICE_VALUE;
    
    public ItemPrice() {
        
    }
    
    public ItemPrice(ItemStatus itemStatus, int price) {
        this.itemStatus = itemStatus;
        this.price = price;
    }
     
    public ItemPrice(Long id, ItemStatus itemStatus, int price) {
        this.id = id;
        this.itemStatus = itemStatus;
        this.price = price;
    }
    
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }
}
