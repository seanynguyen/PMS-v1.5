/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.core.entity.item;

import com.google.common.collect.Lists;
import com.youngidea.pms.core.entity.PMSEntity;
import com.youngidea.pms.core.entity.order.GroupedOrder;

import javax.persistence.*;
import java.util.List;

/**
 *
 * @author sean
 */
@Entity
@Table(name = "ItemGroup")
public class ItemGroup extends PMSEntity {

    private static final long serialVersionUID = 1L;
    private static final int NAME_MAX_LENGTH = 200;
    private static final int DESCRIPTION_MAX_LENGTH = 4000;

    @Column(name = "name", length = NAME_MAX_LENGTH, nullable = false)
    private String name;

    @Column(name = "description", length = DESCRIPTION_MAX_LENGTH)
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "groupedOrder_group", 
            joinColumns = {
                @JoinColumn(name = "groupID", referencedColumnName = "id")}, 
            inverseJoinColumns = {
                @JoinColumn(name = "groupedOrderID", referencedColumnName = "id")}
    )
    protected List<GroupedOrder> groupedOrders = Lists.newArrayList();
   
    @Column(name = "price")
    private int price;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<GroupedOrder> getGroupedOrders() {
        return groupedOrders;
    }

    public void setGroupedOrders(List<GroupedOrder> groupedOrders) {
        this.groupedOrders = groupedOrders;
    }

    public void addGroupedOrder(GroupedOrder groupedOrder) {
        this.groupedOrders.add(groupedOrder);
        groupedOrder.getItemGroups().add(this);
    }
    
    public void removeGroupedOrder(GroupedOrder groupedOrder) {
        this.groupedOrders.remove(groupedOrder);
        groupedOrder.getItemGroups().remove(this);
    }
    
    public void clearGroupedOrder() {
        this.groupedOrders.clear();
    }
}
