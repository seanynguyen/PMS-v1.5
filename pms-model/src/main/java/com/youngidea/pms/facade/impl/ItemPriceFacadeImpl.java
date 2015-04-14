package com.youngidea.pms.facade.impl;

import com.youngidea.pms.entity.item.ItemPrice;
import com.youngidea.pms.facade.ItemPriceFacade;

import javax.ejb.Stateless;

/**
 * Created by sean on 4/12/15.
 */
@Stateless
public class ItemPriceFacadeImpl extends GenericFacadeImpl<ItemPrice> implements ItemPriceFacade{

    public ItemPriceFacadeImpl() {
        super(ItemPrice.class);
    }
}
