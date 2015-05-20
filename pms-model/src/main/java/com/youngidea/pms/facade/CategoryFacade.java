package com.youngidea.pms.facade;

import com.youngidea.pms.entity.item.Category;

import javax.ejb.Local;

/**
 * Created by sean on 5/16/15.
 */
@Local
public interface CategoryFacade extends AbstractFacade<Category> {

    Category findRootCategory();

    void createRootCategory();

}
