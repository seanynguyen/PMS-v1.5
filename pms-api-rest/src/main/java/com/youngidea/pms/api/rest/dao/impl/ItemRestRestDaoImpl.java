package com.youngidea.pms.api.rest.dao.impl;

import com.youngidea.pms.api.rest.dao.ItemRestDao;
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
public class ItemRestRestDaoImpl extends AbstractRestDaoImpl<Item, ItemRequestModel, ItemResponseModel> implements ItemRestDao {

    @EJB
    private ItemFacade itemFacade;

    public ItemRestRestDaoImpl() {
        super(ItemResponseModel.class);
    }

    @Override
    protected ItemFacade getFacade() {
        return this.itemFacade;
    }
}
