package com.youngidea.pms.core.api.rest.service.impl;

import com.youngidea.pms.core.api.rest.dao.CategoryRestDao;
import com.youngidea.pms.core.api.rest.model.CategoryModel;
import com.youngidea.pms.core.api.rest.service.CategoryService;

import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 * Created by sean on 5/17/15.
 */
@Path("/category")
public class CategoryServiceImpl extends RestCRUIDServiceImpl<CategoryRestDao, CategoryModel> implements CategoryService {

    @EJB
    private CategoryRestDao categoryRestDao;

    @Override
    protected CategoryRestDao getDao() {
        return this.categoryRestDao;
    }

}
