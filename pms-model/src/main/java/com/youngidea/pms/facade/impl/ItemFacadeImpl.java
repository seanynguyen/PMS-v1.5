package com.youngidea.pms.facade.impl;

import com.youngidea.pms.entity.item.Category;
import com.youngidea.pms.entity.item.Item;
import com.youngidea.pms.entity.item.ItemPrice;
import com.youngidea.pms.exception.EntityNameDuplicationException;
import com.youngidea.pms.facade.CategoryFacade;
import com.youngidea.pms.facade.ItemFacade;
import com.youngidea.pms.facade.ItemPriceFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

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
        if (super.checkNameDuplication(item.getName())) {
            return;
        }
//        System.out.println("FUCK ---------------------->" + categoryFacade.findRootCategory().getName());
//        categoryFacade.find(Long.parseLong("1"));
//        setRootCategoryIfNeeded(item);
//        super.create(item);
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
        if (item.getCategory() == null || item.getCategory().getId() == null) { // work around with dozer converter framework. It's automatically create a category object
            System.out.println("--------------------------------------------> FUCK THAT SHIT 2");
            item.setCategory(categoryFacade.find(Long.parseLong("1")));
        }
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
