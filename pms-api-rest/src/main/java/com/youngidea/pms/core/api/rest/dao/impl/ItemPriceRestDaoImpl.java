package com.youngidea.pms.core.api.rest.dao.impl;

import com.youngidea.pms.core.api.rest.dao.ItemPriceRestDao;
import com.youngidea.pms.core.api.rest.model.request.ItemPriceRequestModel;
import com.youngidea.pms.core.api.rest.model.response.ItemPriceResponseModel;
import com.youngidea.pms.core.entity.item.ItemPrice;
import com.youngidea.pms.core.facade.ItemPriceFacade;

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
