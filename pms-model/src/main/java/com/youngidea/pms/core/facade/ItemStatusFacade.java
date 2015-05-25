package com.youngidea.pms.core.facade;

import com.youngidea.pms.core.entity.item.ItemStatus;

import javax.ejb.Local;

/**
 * Created by sean on 4/4/15.
 */
@Local
public interface ItemStatusFacade extends AbstractFacade<ItemStatus>{
    public boolean checkNameDuplication(String name);
}
