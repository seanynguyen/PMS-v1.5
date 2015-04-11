package com.youngidea.pms.facade;

import com.youngidea.pms.entity.item.Item;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by sean on 3/25/15.
 */
@Local
public interface ItemFacade extends AbstractFacade<Item> {

}
