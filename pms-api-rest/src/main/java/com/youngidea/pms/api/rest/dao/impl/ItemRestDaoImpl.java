package com.youngidea.pms.api.rest.dao.impl;

import com.youngidea.pms.api.rest.dao.ItemRestDao;
import com.youngidea.pms.api.rest.dao.impl.converter.ItemConverter1;
import com.youngidea.pms.api.rest.model.request.ItemRequestModel;
import com.youngidea.pms.api.rest.model.response.ItemResponseModel;
import com.youngidea.pms.entity.item.Item;
import com.youngidea.pms.facade.ItemFacade;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by sean on 3/25/15.
 */
@Stateless
public class ItemRestDaoImpl extends AbstractRestDaoImpl<Item, ItemRequestModel, ItemResponseModel> implements ItemRestDao {

    @EJB
    private ItemFacade itemFacade;

    @EJB
    private ItemConverter1 itemConverter1;

    public ItemRestDaoImpl() {
        super(ItemResponseModel.class);
    }

    @Override
    protected ItemFacade getFacade() {
        return this.itemFacade;
    }

    protected ItemConverter1 getConverter() {
        return itemConverter1;
    }
}
