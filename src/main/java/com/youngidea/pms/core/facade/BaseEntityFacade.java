/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.core.facade;

import java.util.List;

/**
 *
 * @author sean
 */
public interface BaseEntityFacade<T> {
    
    void initEntity(Class<T> entityClass);
    
    void create(T entity);
    
    void edit(T entity);
    
    void remove(T entity);
    
    List<T> findAll();
    
    // To be fixed later
//    <T> List<T> findAllWhere(String property);
    
    T find(Object id);
    
}
