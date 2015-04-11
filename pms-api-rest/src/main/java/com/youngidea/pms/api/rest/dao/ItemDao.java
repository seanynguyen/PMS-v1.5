package com.youngidea.pms.api.rest.dao;

import com.youngidea.pms.api.rest.model.request.ItemRequestModel;
import com.youngidea.pms.api.rest.model.response.ItemResponseModel;
import com.youngidea.pms.entity.item.Item;

/**
 * Created by sean on 3/25/15.
 */
public interface ItemDao extends AbstractDao<Item, ItemRequestModel, ItemResponseModel>{

}
