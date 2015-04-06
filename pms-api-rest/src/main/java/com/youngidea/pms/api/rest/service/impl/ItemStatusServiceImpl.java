package com.youngidea.pms.api.rest.service.impl;

import com.youngidea.pms.api.rest.dao.ItemStatusDao;
import com.youngidea.pms.api.rest.model.ItemStatusModel;
import com.youngidea.pms.api.rest.service.ItemStatusService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;

/**
 * Created by sean on 3/31/15.
 */
@Path("/status")
@Stateless
public class ItemStatusServiceImpl extends RestCRUIDServiceImpl<ItemStatusDao, ItemStatusModel> implements ItemStatusService{

    @EJB
    private ItemStatusDao itemStatusDao;

    @Override
    protected ItemStatusDao getDao() {
        return this.itemStatusDao;
    }

}
