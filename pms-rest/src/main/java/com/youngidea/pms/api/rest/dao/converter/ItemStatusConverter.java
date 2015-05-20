/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.api.rest.dao.converter;

import com.youngidea.pms.api.rest.model.response.ItemStatusModel;
import com.youngidea.pms.entity.item.ItemStatus;


/**
 *
 * @author sean
 */

public class ItemStatusConverter extends
        AbstractConverter<ItemStatus, ItemStatusModel, ItemStatusModel> {
    private static final ItemStatusConverter INSTANCE = new ItemStatusConverter();

    public static ItemStatusModel convertToModel(ItemStatus input, ItemStatusModel output) {
        return INSTANCE.convert(input, output);
    }

    public static ItemStatus convertToEntity(ItemStatusModel input, ItemStatus output) {
        return INSTANCE.convertBack(input, output);
    }

    @Override
    public ItemStatusModel convert(ItemStatus input, ItemStatusModel output) {
        ItemStatusModel itemStatusBean = output == null ? new ItemStatusModel() : output;
        super.convert(input, itemStatusBean);
        itemStatusBean.setStatusName(input.getName());
        itemStatusBean.setImageURL(input.getImageURL());
        itemStatusBean.setDescription(input.getDescription());
        return itemStatusBean;
    }

    @Override
    public ItemStatus convertBack(ItemStatusModel input, ItemStatus output) {
        // Precondition check required, throw exception... etc
        ItemStatus itemStatus = output == null ? new ItemStatus() : output;
        if (input.getId() != null) {
            itemStatus.setId(input.getId());
        }
        itemStatus.setName(input.getStatusName());
        itemStatus.setDescription(input.getDescription());
        itemStatus.setImageURL(input.getImageURL());
        //System.out.println(itemStatus.getName());
        return itemStatus;
    }

}
