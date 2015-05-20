package com.youngidea.pms.api.rest.dao.impl;

import com.youngidea.pms.api.rest.dao.ItemStatusDao;
import com.youngidea.pms.api.rest.dao.converter.ItemStatusConverter;
import com.youngidea.pms.api.rest.model.response.ItemStatusModel;
import com.youngidea.pms.entity.item.ItemStatus;
import com.youngidea.pms.facade.GenericFacade;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

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

    @Override
    public void edit(ItemStatusModel itemStatusModel) {

    }

    @Override
    public void remove(ItemStatusModel itemStatusModel) {

    }

    @Override
    public List<ItemStatusModel> findAll() {
        return null;
    }

    @Override
    public ItemStatusModel find(Object id) {
        return null;
    }



}
