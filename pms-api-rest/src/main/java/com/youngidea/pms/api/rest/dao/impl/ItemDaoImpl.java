package com.youngidea.pms.api.rest.dao.impl;

import com.youngidea.pms.api.rest.dao.ItemDao;
import com.youngidea.pms.api.rest.model.ItemStatusModel;
import com.youngidea.pms.api.rest.model.request.ItemRequestModel;
import com.youngidea.pms.api.rest.model.response.ItemResponseModel;
import com.youngidea.pms.entity.item.Item;
import com.youngidea.pms.facade.AbstractFacade;
import com.youngidea.pms.facade.ItemFacade;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by sean on 3/25/15.
 */
@Stateless
public class ItemDaoImpl extends AbstractDaoImpl<Item, ItemRequestModel, ItemResponseModel> implements ItemDao {

    @EJB
    private ItemFacade itemFacade;

    public ItemDaoImpl() {
        super(ItemResponseModel.class);
    }

    @Override
    protected ItemFacade getFacade() {
        return this.itemFacade;
    }
}
