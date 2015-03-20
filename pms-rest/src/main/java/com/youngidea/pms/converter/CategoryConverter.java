/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.converter;

import com.youngidea.pms.entity.item.Category;
import com.youngidea.pms.api.rest.model.response.CategoryModel1;

import javax.ejb.Stateless;

/**
 *
 * @author sean
 */
@Stateless
public class CategoryConverter extends AbstractConverter<Category, CategoryModel1, CategoryModel1> {
    
    @Override
    public CategoryModel1 convert(Category input, CategoryModel1 output) {
        CategoryModel1 categoryBean = output == null ? new CategoryModel1() : output;
        super.convert(input, categoryBean);
        categoryBean.setName(input.getName());
        categoryBean.setDescription(input.getDescription());
        if (input.getParentCategory() != null) {
            categoryBean.setParentId(input.getParentCategory().getId());
        }
        return categoryBean;
    }
    
    @Override
    public Category convertBack(CategoryModel1 input, Category output) {
        Category category = output == null ? new Category() : output;
        if (input.getId() != null) {
            category.setId(input.getId());
        }
        category.setName(input.getName());
        category.setDescription(input.getDescription());
        //
        return category;
    }
}
