package com.youngidea.pms.api.rest.service.impl;

import com.youngidea.pms.api.rest.dao.ItemDao;
import com.youngidea.pms.api.rest.model.request.ItemRequestModel;
import com.youngidea.pms.api.rest.service.ItemService;
import com.youngidea.pms.facade.ItemFacade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Path;

/**
 * Created by sean on 4/11/15.
 */
@LocalBean
@Path("/item")
@Stateless
public class ItemServiceImpl extends RestCRUIDServiceImpl<ItemDao, ItemRequestModel> implements ItemService {

    @EJB
    private ItemDao itemDao;

    @Override
    protected ItemDao getDao() {
        return this.itemDao;
    }

}
