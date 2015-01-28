/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.facade;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sean
 * @param <T>
 */
@Local
public interface GenericFacade {
    
    public <T> void create(Class<T> entityClass, T entity);
    
    public <T> void edit(Class<T> entityClass, T entity);
    
    public <T> void remove(Class<T> entityClass, T entity);
    
    public <T> List<T> findAll(Class<T> entityClass);
    
    public <T> T find(Class<T> entityClass, Object id);
}
