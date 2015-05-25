package com.youngidea.pms.api.rest.dao.impl;

import com.youngidea.pms.api.rest.exception.ModelNameDuplicationException;
import com.youngidea.pms.api.rest.dao.ItemRestDao;
import com.youngidea.pms.api.rest.dao.converter.ItemConverter;
import com.youngidea.pms.api.rest.model.request.ItemRequestModel;
import com.youngidea.pms.api.rest.model.response.ItemResponseModel;
import com.youngidea.pms.core.entity.item.Item;
import com.youngidea.pms.core.facade.ItemFacade;

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
    private ItemConverter itemConverter;

    public ItemRestDaoImpl() {
        super(ItemResponseModel.class);
    }

    // Common CRUID method:
    @Override
    public ItemResponseModel create(ItemRequestModel itemRequestModel) throws ModelNameDuplicationException {
        if (!itemFacade.checkNameDuplication(itemRequestModel.getName())) {
            return super.create(itemRequestModel);
        } else {
            throw new ModelNameDuplicationException(itemRequestModel, itemRequestModel.getName());
        }
    }

    // Override procedure
    @Override
    protected ItemFacade getFacade() {
        return this.itemFacade;
    }

    @Override
    protected ItemConverter getConverter() {
        return itemConverter;
    }
}
