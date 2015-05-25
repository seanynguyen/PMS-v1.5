package com.youngidea.pms.api.rest.dao.converter.impl;

import com.google.common.collect.Lists;
import com.youngidea.pms.api.rest.dao.ItemPriceRestDao;
import com.youngidea.pms.api.rest.dao.converter.ItemConverter;
import com.youngidea.pms.api.rest.model.request.ItemPriceRequestModel;
import com.youngidea.pms.api.rest.model.request.ItemRequestModel;
import com.youngidea.pms.api.rest.model.response.ItemResponseModel;
import com.youngidea.pms.core.entity.item.Item;
import com.youngidea.pms.core.entity.item.ItemPrice;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by sean on 4/12/15.
 */
@Stateless
public class ItemConverterImpl extends GenericConverterImpl<Item, ItemRequestModel, ItemResponseModel> implements ItemConverter {

    @EJB
    private ItemPriceRestDao itemPriceRestDao;

    @Override
    public Item convertBack(ItemRequestModel input, Class<Item> entityClass) {
        // Normal dozer mapping
        Item output = super.convertBack(input, entityClass);
        // Item Price list mapping
        List<ItemPrice> itemPrices = Lists.newArrayList();
        for (ItemPriceRequestModel itemPriceRequestModel : input.getItemPrices()) {
            itemPrices.add(super.mapper.map(itemPriceRequestModel, ItemPrice.class));
        }
        output.setItemPrices(itemPrices);
        return output;
    }

    @Override
    public ItemResponseModel convertResToResp(ItemRequestModel input) {
//        return convert(convertBack(input));
        return null;
    }

}
