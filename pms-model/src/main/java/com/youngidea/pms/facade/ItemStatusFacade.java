package com.youngidea.pms.facade;

import com.youngidea.pms.entity.item.ItemStatus;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by sean on 4/4/15.
 */
@Local
public interface ItemStatusFacade extends AbstractFacade<ItemStatus>{
    public boolean checkNameDuplication(String name);
}
