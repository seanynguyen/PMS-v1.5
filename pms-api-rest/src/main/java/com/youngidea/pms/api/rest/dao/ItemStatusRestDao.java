package com.youngidea.pms.api.rest.dao;

import com.youngidea.pms.api.rest.model.ItemStatusModel;
import com.youngidea.pms.entity.item.ItemStatus;

/**
 * Created by sean on 3/25/15.
 */
public interface ItemStatusRestDao extends AbstractRestDao<ItemStatus, ItemStatusModel, ItemStatusModel> {
    public boolean checkNameDuplication(String name);
}
