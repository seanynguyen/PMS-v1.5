/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.youngidea.pms.core.entity.order;

import com.google.common.collect.Lists;
import com.youngidea.pms.core.entity.item.ItemGroup;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author sean
 */
@Entity
@Table(name="GroupedOrder")
public class GroupedOrder extends GeneralOrder{
    
    // OrderList or Bill
    @ManyToMany(mappedBy = "groupedOrders")
    protected List<ItemGroup> itemGroups = Lists.newArrayList();

    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }

    public void setItemGroups(List<ItemGroup> itemGroups) {
        this.itemGroups = itemGroups;
    }
    
}
