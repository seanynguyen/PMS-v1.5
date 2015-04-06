package com.youngidea.pms.api.rest.dao.impl.converter;

import com.youngidea.pms.api.rest.model.ItemStatusModel;
import com.youngidea.pms.entity.item.ItemStatus;

import java.util.Arrays;

/**
* Created by sean on 3/26/15.
*/
public class ItemStatusConverter extends AbstractConverter<ItemStatus, ItemStatusModel, ItemStatusModel> {
    private static final String[] MAPPING_FILES = {"dozer.xml"};

    public ItemStatusConverter() {
        super(ItemStatusModel.class, ItemStatus.class);
    }

    // Can override convert methods in some special cases.
}
