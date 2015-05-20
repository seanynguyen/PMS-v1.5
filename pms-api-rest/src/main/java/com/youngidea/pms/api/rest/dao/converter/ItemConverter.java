package com.youngidea.pms.api.rest.dao.converter;

import com.youngidea.pms.api.rest.model.request.ItemRequestModel;
import com.youngidea.pms.api.rest.model.response.ItemResponseModel;
import com.youngidea.pms.entity.item.Item;

/**
 * Created by sean on 5/3/15.
 */
public interface ItemConverter extends GenericConverter<Item, ItemRequestModel, ItemResponseModel>{

}
