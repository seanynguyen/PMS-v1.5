/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.core.converter;

import com.google.common.collect.Lists;
import com.youngidea.pms.api.rest.model.request.ItemPriceRequestModel;
import com.youngidea.pms.api.rest.model.request.ItemRequestModel;
import com.youngidea.pms.api.rest.model.response.*;
import com.youngidea.pms.core.entity.item.Item;
import com.youngidea.pms.core.entity.item.ItemPrice;
import com.youngidea.pms.core.entity.item.ItemStatus;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 *
 * @author sean
 */
@Stateless
public class ItemConverter extends AbstractConverter<Item, ItemRequestModel, ItemResponseModel> {

    @EJB
    private ItemStatusConverter itemStatusConverter;

    @Override
    public ItemResponseModel convert(Item input, ItemResponseModel output) /* throws ValidationException */ { // Item -> ItemRequestModel: load data from database to view model
        ItemResponseModel itemBean = output == null ? new ItemResponseModel() : output;
        super.convert(input, itemBean);

        itemBean.setName(input.getName());
        itemBean.setDescription(input.getDescription());
        if (input.getCategory() != null) {
            System.out.println("----------------------------------------------################" + itemBean.getName());
            itemBean.setCategoryModel1(
                    new CategoryModel1(
                            input.getCategory().getName(),
                            input.getCategory().getDescription())); // parent no bi null roi
            if (input.getCategory().getParentCategory() != null) {
                itemBean.getCategoryModel1()
                        .setParentId(input.getCategory().getParentCategory().getId());
            }
        }
        itemBean.setImageURL(input.getImageURL());
        List<ItemPriceResponseModel> priceBeans = Lists.newArrayList();
        for (ItemPrice itemPrice : input.getItemPrices()) { // incase of update the price
            ItemStatus itemStatus = itemPrice.getItemStatus();
            ItemPriceResponseModel priceBean = new ItemPriceResponseModel(itemPrice.getId(), new ItemStatusModel(itemStatus.getName(),
                    itemStatus.getDescription(), itemStatus.getImageURL()), itemPrice.getPrice());
            priceBeans.add(priceBean);
        }
        itemBean.setItemPriceResponseModels(priceBeans);
        return itemBean;
    }

    @Override
    public Item convertBack(ItemRequestModel input, Item output) {
        Item item = output == null ? new Item() : output;
        item.setName(input.getName());
        item.setDescription(input.getDescription());
        item.setImageURL(input.getImageURL());
        return item;
    }

    public ItemUnit convertToItemUnit(ItemPrice input, ItemUnit output) {
        ItemUnit itemUnit = output == null ? new ItemUnit() : output;
        Item item = input.getItem();
        itemUnit.setId(item.getId());
        itemUnit.setName(item.getName());
        itemUnit.setDescription(item.getDescription());
        itemUnit.setImageURL(item.getImageURL());
        ItemPriceResponseModel itemPriceResponseModel = new ItemPriceResponseModel();
        itemPriceResponseModel.setId(input.getId());
        itemPriceResponseModel.setItemStatusBean(itemStatusConverter.convert(input.getItemStatus(), null));
        itemPriceResponseModel.setPrice(input.getPrice());
        itemUnit.setItemPriceResponseModel(itemPriceResponseModel);
        return itemUnit;
    }

    public static class ItemPriceConverter {

        public static final ItemPriceConverter INSTANCE = new ItemPriceConverter();

        public static ItemPriceRequestModel convert(ItemPrice input) {
            if (input != null) {
                ItemPriceRequestModel output = new ItemPriceRequestModel();
                output.setId(input.getId());
                output.setPrice(input.getPrice());
                output.setStatusId(input.getItemStatus().getId());
                return output;
            }
            return null;
        }

//        public static ItemPriceResponseModel convertResponse(ItemPrice input, ItemPriceResponseModel output) {
//            ItemPriceResponseModel itemPriceResponseModel = output == null ? new ItemPriceResponseModel() : output;
//            itemPriceResponseModel.setId(input.getId());
//            itemPriceResponseModel.setPrice(input.getPrice());
////            itemPriceResponseModel.setItemStatusBean(itemStatusConverter.convert(null, null));
//            return output;
//        }
    }

}
