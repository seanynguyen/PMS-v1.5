package com.youngidea.pms.facade;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by sean on 4/5/15.
 */
@Local
public interface AbstractFacade<E> {

    public void create(E entity);

    public void edit(E entity);

    public void remove(E entity);

    public List<E> findAll();

    public E find(Object id);

    public Class<E> getEntityClass();
}
