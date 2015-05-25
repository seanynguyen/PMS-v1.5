package com.youngidea.pms.core.api.rest.dao;

import com.youngidea.pms.core.api.rest.model.request.ItemRequestModel;
import com.youngidea.pms.core.api.rest.model.response.ItemResponseModel;
import com.youngidea.pms.core.entity.item.Item;

/**
 * Created by sean on 3/25/15.
 */
public interface ItemRestDao extends AbstractRestDao<Item, ItemRequestModel, ItemResponseModel> {

}
