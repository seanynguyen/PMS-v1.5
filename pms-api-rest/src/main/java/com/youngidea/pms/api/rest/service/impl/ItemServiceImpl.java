package com.youngidea.pms.api.rest.service.impl;

import com.youngidea.pms.api.rest.dao.ItemRestDao;
import com.youngidea.pms.api.rest.model.request.ItemRequestModel;
import com.youngidea.pms.api.rest.service.ItemService;

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
public class ItemServiceImpl extends RestCRUIDServiceImpl<ItemRestDao, ItemRequestModel> implements ItemService {

    @EJB
    private ItemRestDao itemDao;

    @Override
    protected ItemRestDao getDao() {
        return this.itemDao;
    }

}
