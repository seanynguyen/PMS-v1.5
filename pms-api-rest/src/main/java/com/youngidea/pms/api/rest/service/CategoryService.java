package com.youngidea.pms.api.rest.service;

import com.youngidea.pms.api.rest.model.CategoryModel;

import javax.ejb.Local;

/**
 * Created by sean on 5/17/15.
 */
@Local
public interface CategoryService extends RestCRUIDService<CategoryModel> {
}
