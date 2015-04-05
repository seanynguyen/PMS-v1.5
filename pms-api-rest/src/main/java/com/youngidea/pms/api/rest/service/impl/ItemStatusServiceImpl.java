package com.youngidea.pms.api.rest.service.impl;

import com.youngidea.pms.api.rest.dao.AbstractDao;
import com.youngidea.pms.api.rest.dao.ItemStatusDao;
import com.youngidea.pms.api.rest.dao.impl.ItemStatusDaoImpl;
import com.youngidea.pms.api.rest.model.AbstractModel;
import com.youngidea.pms.api.rest.model.ItemStatusModel;
import com.youngidea.pms.api.rest.model.error.NotFoundError;
import com.youngidea.pms.api.rest.model.validator.ValidStatus;
import com.youngidea.pms.api.rest.service.ItemStatusService;
import com.youngidea.pms.api.rest.ultility.RestApiHelper;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

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
