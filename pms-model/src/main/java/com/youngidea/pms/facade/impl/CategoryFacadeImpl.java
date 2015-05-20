package com.youngidea.pms.facade.impl;

import com.youngidea.pms.entity.item.Category;
import com.youngidea.pms.facade.CategoryFacade;
import com.youngidea.pms.ultilities.FacadeHelper;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.util.Properties;

/**
 * Created by sean on 5/16/15.
 */
@Stateless
public class CategoryFacadeImpl extends GenericFacadeImpl<Category> implements CategoryFacade{

    public static final Long ROOT_CATEGORY_ID = 1L;

    public CategoryFacadeImpl() {
        super(Category.class);
    }

    @Override
    public void create(Category category) {
        setParentCategoryIfNeed(category);
        super.create(category);
    }

    @Override
    public void edit(Category category) {
        setParentCategoryIfNeed(category);
        super.edit(category);
    }

    @Override
    public void remove(Category category) {
        // to avoid root category deletion
        if (category.getId() != Category.ROOT_CATEGORY_ID) {
            super.remove(category);
        }
    }

    public Category findRootCategory() {
        return super.find(Category.ROOT_CATEGORY_ID);
    }

    private void setParentCategoryIfNeed(Category category) {
        if (category.getParentCategory() == null) {
            category.setParentCategory(findRootCategory());
        }
    }

    public void createRootCategory() {
        if (findRootCategory() == null) {
            Category category = new Category();
            category.setId(Category.ROOT_CATEGORY_ID);
            category.setName("Uncategoried");
            category.setDescription("Uncategoried is the root category");
            category.setParentCategory(null);
            super.create(category);
        }
    }

}
