package com.youngidea.pms.api.rest.dao.impl;

import com.youngidea.pms.api.rest.dao.CategoryRestDao;
import com.youngidea.pms.api.rest.model.CategoryModel;
import com.youngidea.pms.entity.item.Category;
import com.youngidea.pms.facade.CategoryFacade;
import com.youngidea.pms.facade.impl.CategoryFacadeImpl;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by sean on 5/17/15.
 */
@Stateless
public class CategoryRestDaoImpl extends AbstractRestDaoImpl<Category, CategoryModel, CategoryModel> implements CategoryRestDao {

    @EJB
    private CategoryFacade categoryFacade;

    public CategoryRestDaoImpl() {
        super(CategoryModel.class);
    }

    @PostConstruct
    private void initialize() {
        createRootCategory();
    }

    @Override
    protected CategoryFacade getFacade() {
        return categoryFacade;
    }

    @Override
    public CategoryModel remove(Long id) {
        if (!id.equals(Category.ROOT_CATEGORY_ID)) {

        }
    }

    private void createRootCategory() { // should be created in some where else
        if (categoryFacade.findRootCategory() == null) {
            Category category = new Category();
            category.setId(CategoryFacadeImpl.ROOT_CATEGORY_ID);
            category.setName("Uncategoried");
            category.setDescription("Uncategoried is the root category");
            category.setParentCategory(null);
            categoryFacade.create(category);
        }
    }

}
