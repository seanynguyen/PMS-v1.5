package com.youngidea.pms.api.rest.dao.impl;

import com.youngidea.pms.api.rest.dao.ItemStatusDao;
import com.youngidea.pms.api.rest.dao.impl.converter.AbstractConverter;
import com.youngidea.pms.api.rest.dao.impl.converter.ItemStatusConverter;
import com.youngidea.pms.api.rest.model.ItemStatusModel;
import com.youngidea.pms.entity.item.ItemStatus;
import com.youngidea.pms.facade.ItemStatusFacade;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by sean on 3/25/15.
 */
@Stateless
public class ItemStatusDaoImpl extends AbstractDaoImpl<ItemStatus, ItemStatusModel, ItemStatusModel> implements ItemStatusDao {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ItemStatusDaoImpl.class);

    @EJB
    private ItemStatusFacade itemStatusFacade;

    public ItemStatusDaoImpl() {
        super(ItemStatusModel.class);
    }

    @Override
    protected ItemStatusFacade getFacade() {
        return itemStatusFacade;
    }

    @Override
    protected ItemStatusConverter getConverter() {
        return new ItemStatusConverter();
    }

//    @Override
//    public void create(ItemStatusModel itemStatusModel) {
////        genericFacade.create(ItemStatusConverter.convertToEntity(itemStatusModel, null));
//    }
//
//    @Override
//    public void edit(ItemStatusModel itemStatusModel) {
//
//    }
//

}
