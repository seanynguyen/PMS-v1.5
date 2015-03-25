package com.youngidea.pms.api.rest.dao.impl;

import com.youngidea.pms.api.rest.dao.ItemStatusDao;
import com.youngidea.pms.api.rest.dao.impl.converter.ItemStatusConverter;
import com.youngidea.pms.api.rest.model.request.ItemRequestModel;
import com.youngidea.pms.api.rest.model.response.ItemStatusModel;
import com.youngidea.pms.entity.item.ItemStatus;
import com.youngidea.pms.facade.GenericFacade;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by sean on 3/25/15.
 */
@Stateless
public class ItemStatusDaoImpl implements ItemStatusDao {

    @EJB
    private GenericFacade<ItemStatus> genericFacade;

    @Override
    public void create(ItemStatusModel itemStatusModel) {
        genericFacade.create(ItemStatusConverter.convertToEntity(itemStatusModel, null));
    }

    public void edit() {

    }


}
