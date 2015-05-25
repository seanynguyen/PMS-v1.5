/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.core.facade;

import javax.ejb.Local;
import java.util.List;

/**
 *
 * @author sean
 * @param <T>
 *     This class is to independently use JPA service
 */
@Local
public interface GenericFacade<E> {
    
    public void create(E entity);
    
    public void edit(E entity);
    
    public void remove(E entity);

    public List<E> findAll();

    public E find(Object id);

    public <T> List<T> findAll(Class<T> entityClass);

    public <T> T find(Class<T> entityClass, Object id);
}
