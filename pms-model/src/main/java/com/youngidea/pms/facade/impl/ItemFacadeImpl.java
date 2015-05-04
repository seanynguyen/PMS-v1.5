package com.youngidea.pms.facade.impl;

import com.youngidea.pms.entity.item.Item;
import com.youngidea.pms.entity.item.ItemPrice;
import com.youngidea.pms.facade.ItemFacade;
import com.youngidea.pms.facade.ItemPriceFacade;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by sean on 3/25/15.
 */
@Stateless
public class ItemFacadeImpl extends GenericFacadeImpl<Item> implements ItemFacade{

    @EJB
    private ItemPriceFacade itemPriceFacade;

    public ItemFacadeImpl() {
        super(Item.class);
    }

    // To be defined
    @Override
    public void edit(Item item) {
        super.edit(item);
        List<ItemPrice> nonUsedPrices = item.getNonUsedPrices();
        for (ItemPrice nonUsedPrice : nonUsedPrices) {
            itemPriceFacade.remove(nonUsedPrice);
        }
        nonUsedPrices.clear();
    }

//    for (ItemPrice itemPrice : itemPrices) {
//        if (!this.itemPrices.contains(itemPrice)) {
//            itemPrice.setItem(this);
//        }
//    }
//    for (ItemPrice currentItemPrice : this.itemPrices) {
//        if (!itemPrices.contains(currentItemPrice)) {
//            System.out.println(currentItemPrice.getId());
//            currentItemPrice.setItem(null);
//        }
//    }

}
