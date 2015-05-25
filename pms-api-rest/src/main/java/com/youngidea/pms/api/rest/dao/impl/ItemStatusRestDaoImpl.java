package com.youngidea.pms.api.rest.dao.impl;

import com.youngidea.pms.api.rest.dao.ItemStatusRestDao;
import com.youngidea.pms.api.rest.model.ItemStatusModel;
import com.youngidea.pms.core.entity.item.ItemStatus;
import com.youngidea.pms.core.facade.ItemStatusFacade;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by sean on 3/25/15.
 */
@Stateless
public class ItemStatusRestDaoImpl extends AbstractRestDaoImpl<ItemStatus, ItemStatusModel, ItemStatusModel> implements ItemStatusRestDao {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ItemStatusRestDaoImpl.class);

//    private AbstractConverter<ItemStatus, ItemStatusModel, ItemStatusModel> CONVERTER;

    @EJB
    private ItemStatusFacade itemStatusFacade;

    public ItemStatusRestDaoImpl() {
        super(ItemStatusModel.class);
    }

    @Override
    protected ItemStatusFacade getFacade() {
        return itemStatusFacade;
    }


    public boolean checkNameDuplication(String name) {
        return itemStatusFacade.checkNameDuplication(name);
    }

}
