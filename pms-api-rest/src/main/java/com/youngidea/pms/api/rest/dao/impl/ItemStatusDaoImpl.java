package com.youngidea.pms.api.rest.dao.impl;

import com.youngidea.pms.api.rest.dao.ItemStatusDao;
import com.youngidea.pms.api.rest.dao.impl.converter.AbstractDozerConverter;
import com.youngidea.pms.api.rest.dao.impl.converter.ItemStatusDozerConverter;
import com.youngidea.pms.api.rest.model.response.ItemStatusModel;
import com.youngidea.pms.entity.item.ItemStatus;
import com.youngidea.pms.facade.GenericFacade;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by sean on 3/25/15.
 */
@Stateless
public class ItemStatusDaoImpl extends AbstractDaoImpl<ItemStatus, ItemStatusModel, ItemStatusModel> implements ItemStatusDao {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ItemStatusDaoImpl.class);
    
    private static final ItemStatusDozerConverter itemStatusDozerConverter = new ItemStatusDozerConverter();

    @EJB
    private GenericFacade<ItemStatus> genericFacade;

    @Override
    protected GenericFacade<ItemStatus> getFacade() {
        return genericFacade;
    }

    @Override
    protected ItemStatusDozerConverter getConverter() {
        return itemStatusDozerConverter;
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
//    @Override
//    public void remove(ItemStatusModel itemStatusModel) {
//
//    }
//
//    @Override
//    public List<ItemStatusModel> findAll() {
//        return null;
//    }
//
    @Override
    public ItemStatusModel find(Object id) {
        LOGGER.info("-------------------------->" + itemStatusDozerConverter.convert(genericFacade.find(ItemStatus.class, id)).getStatusName());
        return itemStatusDozerConverter.convert(genericFacade.find(ItemStatus.class, id));
    }
//

}
