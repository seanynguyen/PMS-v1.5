package com.youngidea.pms.api.rest.service.impl;

import com.wordnik.swagger.annotations.Api;
import com.youngidea.pms.api.rest.service.ItemService;
import com.youngidea.pms.api.rest.dao.ItemRestDao;
import com.youngidea.pms.api.rest.model.request.ItemRequestModel;

import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 * Created by sean on 4/11/15.
 */
@Path("/item")
@Api(value = "/item", description = "Item services")
public class ItemServiceImpl extends RestCRUIDServiceImpl<ItemRestDao, ItemRequestModel> implements ItemService {

    @EJB
    private ItemRestDao itemDao;

    @Override
    protected ItemRestDao getDao() {
        return this.itemDao;
    }

}
