/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.core.entity.order;

import com.youngidea.pms.core.entity.item.ItemPrice;
import com.youngidea.pms.core.entity.PMSEntity;

import javax.persistence.*;

/**
 *
 * @author sean
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class GeneralOrder extends PMSEntity {

//    @JoinColumn(name = "itemID", referencedColumnName = "id", nullable = false)
//    @ManyToOne(cascade = CascadeType.REFRESH)
//    private Item item;
//
//    @JoinColumn(name = "statusID", referencedColumnName = "id", nullable = false)
//    @ManyToOne(cascade = CascadeType.REFRESH)
//    private ItemStatus status;

    @JoinColumn(name = "priceID", referencedColumnName = "id", nullable = false)
    @ManyToOne(cascade = CascadeType.REFRESH)
    private ItemPrice itemPrice;
    
    @Column(name = "quantity", nullable = false)
    private int quantity;

    public GeneralOrder() {
    }

    public GeneralOrder(ItemPrice itemPrice, int quantity) {
        this.itemPrice = itemPrice;
        this.quantity = quantity;
    }

    public ItemPrice getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(ItemPrice itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean is(GeneralOrder that) {

        if (this == that) {
            return true;
        }

        if (that == null || getClass() != that.getClass() ||
                !this.getItemPrice().getId().equals(that.getItemPrice().getId())) {
            return false;
        }

        return true;
    }
}
