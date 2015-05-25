package com.youngidea.pms.core.facade.impl;

import com.youngidea.pms.core.entity.item.ItemStatus;
import com.youngidea.pms.core.facade.ItemStatusFacade;

import javax.ejb.Stateless;


/**
 * Created by sean on 4/4/15.
 */
@Stateless
public class ItemStatusFacadeImpl extends GenericFacadeImpl<ItemStatus> implements ItemStatusFacade {

    public ItemStatusFacadeImpl() {
        super(ItemStatus.class);
    }

    @Override
    public void create(ItemStatus itemStatus) {
        if (super.checkNameDuplication(itemStatus.getName())) {
            return;
        }
        super.create(itemStatus);
    }

    @Override
    public void edit(ItemStatus itemStatus) {
        if (super.checkNameDuplication(itemStatus.getName())) {
            return;
        }
        super.edit(itemStatus);
    }

}