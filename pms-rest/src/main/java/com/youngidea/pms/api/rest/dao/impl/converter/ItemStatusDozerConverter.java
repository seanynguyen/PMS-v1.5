package com.youngidea.pms.api.rest.dao.impl.converter;

import com.google.common.collect.Lists;
import com.youngidea.pms.api.rest.model.response.ItemStatusModel;
import com.youngidea.pms.entity.item.ItemStatus;

import java.util.List;

/**
 * Created by sean on 3/26/15.
 */
public class ItemStatusDozerConverter extends AbstractDozerConverter<ItemStatus, ItemStatusModel, ItemStatusModel> {
    private static final List<String> mappingFilesNames = Lists.newArrayList();
    private static final String MAPPING_FILE = "dozer.xml";

    @Override
    protected List<String> getMappingFilesNames() {
        mappingFilesNames.add("dozer.xml");
        return mappingFilesNames;
    }



}
