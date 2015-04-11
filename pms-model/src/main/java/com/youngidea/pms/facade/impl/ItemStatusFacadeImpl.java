package com.youngidea.pms.facade.impl;

import com.youngidea.pms.entity.item.ItemStatus;
import com.youngidea.pms.facade.ItemStatusFacade;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;


/**
 * Created by sean on 4/4/15.
 */
@Stateless
public class ItemStatusFacadeImpl extends GenericFacadeImpl<ItemStatus> implements ItemStatusFacade{

    public ItemStatusFacadeImpl() {
        super(ItemStatus.class);
    }

    public boolean checkNameDuplication(String name) {
        return super.findByName(name).isEmpty() ? false : true;
    }

}
