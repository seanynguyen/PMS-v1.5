package com.youngidea.pms.facade;

import com.youngidea.pms.entity.item.Item;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by sean on 3/25/15.
 */
@Local
public interface ItemFacade extends GenericFacade<Item> {

    public void create(Item entity);

    public void edit(Item entity);

    public void remove(Item entity);

    public List<Item> findAll();

    public Item find(Object id);
}
