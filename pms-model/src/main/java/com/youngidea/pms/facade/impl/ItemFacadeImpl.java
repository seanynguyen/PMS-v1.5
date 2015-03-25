package com.youngidea.pms.facade.impl;

import com.youngidea.pms.entity.item.Item;
import com.youngidea.pms.facade.ItemFacade;

import javax.ejb.Stateless;

/**
 * Created by sean on 3/25/15.
 */
@Stateless
public class ItemFacadeImpl extends GenericFacadeImpl<Item> implements ItemFacade{

    public ItemFacadeImpl() {
        super(Item.class);
    }

    // To be defined

}
