package com.youngidea.pms.facade.impl;

import com.youngidea.pms.entity.item.Item;
import com.youngidea.pms.entity.item.ItemPrice;
import com.youngidea.pms.facade.CategoryFacade;
import com.youngidea.pms.facade.ItemFacade;
import com.youngidea.pms.facade.ItemPriceFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by sean on 3/25/15.
 */
@Stateless
public class ItemFacadeImpl extends GenericFacadeImpl<Item> implements ItemFacade{

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemFacadeImpl.class);

    @EJB
    private ItemPriceFacade itemPriceFacade;

    @EJB
    private CategoryFacade categoryFacade;

    public ItemFacadeImpl() {
        super(Item.class);
    }

    @Override
    public void create(Item item) {
        // avoid sql error
        if (super.checkNameDuplication(item.getName())) {
            return;
        }
        setRootCategoryIfNeeded(item);
        super.create(item);
    }

    // To be defined
    @Override
    public void edit(Item item) {
        if (super.checkNameDuplication(item.getName())) {
            return;
        }
        for (ItemPrice itemPrice : super.find(item.getId()).getItemPrices()) {
            if (!item.getItemPrices().contains(itemPrice)) {
                itemPriceFacade.remove(itemPrice);
            }
        }
        setRootCategoryIfNeeded(item);
        super.edit(item);
    }

    private void setRootCategoryIfNeeded(Item item) {
        if (item.getCategory() == null) {
            item.setCategory(categoryFacade.findRootCategory());
        }
    }

}
