/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.api.rest.dao.impl.converter.impl.dozer;

import com.youngidea.pms.entity.PMSEntity;
import com.youngidea.pms.entity.item.Item;
import com.youngidea.pms.entity.item.ItemStatus;

import javax.persistence.*;

/**
 *
 * @author sean
 */
@Entity
@Table(name="ItemPrice")
public class ItemPriceDestDozerTest extends PMSEntity{
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

    public ItemPriceDestDozerTest() {

    }

    public ItemPriceDestDozerTest(ItemStatus itemStatus, int price) {
        this.itemStatus = itemStatus;
        this.price = price;
    }

    public ItemPriceDestDozerTest(Long id, ItemStatus itemStatus, int price) {
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
