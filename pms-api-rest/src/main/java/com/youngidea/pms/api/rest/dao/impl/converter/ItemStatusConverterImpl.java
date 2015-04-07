package com.youngidea.pms.api.rest.dao.impl.converter;

import com.youngidea.pms.api.rest.model.ItemStatusModel;
import com.youngidea.pms.entity.item.ItemStatus;

/**
* Created by sean on 3/26/15.
*/
public class ItemStatusConverterImpl extends GenericConverterImpl<ItemStatus, ItemStatusModel, ItemStatusModel> {
    private static final String[] MAPPING_FILES = {"dozer.xml"};

    // Can override convert methods in some special cases.
}
