package com.youngidea.pms.api.rest.dao.impl.converter.impl;

import com.youngidea.pms.api.rest.dao.ItemPriceRestDao;
import com.youngidea.pms.api.rest.model.request.ItemPriceRequestModel;
import com.youngidea.pms.api.rest.model.request.ItemRequestModel;
import com.youngidea.pms.api.rest.model.response.ItemResponseModel;
import com.youngidea.pms.entity.item.Item;
import com.youngidea.pms.entity.item.ItemPrice;

import javax.ejb.EJB;

/**
 * Created by sean on 4/12/15.
 */
public class ItemConverterImpl extends GenericConverterImpl<Item, ItemRequestModel, ItemResponseModel> {

    @EJB
    private ItemPriceRestDao itemPriceRestDao;
    

    @Override
    public Item convertBack(ItemRequestModel input, Class<Item> entityClass) {
        Item output = super.convertBack(input, entityClass);
        for (ItemPriceRequestModel itemPrice : input.getItemPrices()) {

        }
        return output;
    }

    @Override
    public ItemResponseModel convertResToResp(ItemRequestModel input) {
//        return convert(convertBack(input));
        return null;
    }

}
