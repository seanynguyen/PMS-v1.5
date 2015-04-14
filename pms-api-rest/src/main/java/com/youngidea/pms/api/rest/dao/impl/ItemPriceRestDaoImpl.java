package com.youngidea.pms.api.rest.dao.impl;

import com.youngidea.pms.api.rest.dao.ItemPriceRestDao;
import com.youngidea.pms.api.rest.model.request.ItemPriceRequestModel;
import com.youngidea.pms.api.rest.model.response.ItemPriceResponseModel;
import com.youngidea.pms.entity.item.ItemPrice;
import com.youngidea.pms.facade.ItemPriceFacade;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by sean on 4/12/15.
 */
@Stateless
public class ItemPriceRestDaoImpl extends AbstractRestDaoImpl<ItemPrice, ItemPriceRequestModel, ItemPriceResponseModel> implements ItemPriceRestDao {

    @EJB
    private ItemPriceFacade itemPriceFacade;

    public ItemPriceRestDaoImpl() {
        super(ItemPriceResponseModel.class);
    }

    @Override
    protected ItemPriceFacade getFacade() {
        return itemPriceFacade;
    }

}
