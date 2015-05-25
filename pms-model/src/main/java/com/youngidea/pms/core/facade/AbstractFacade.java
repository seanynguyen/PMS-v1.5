package com.youngidea.pms.core.facade;

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

    public List<E> findByName(String name);

    public List<E> findRange(int[] range);

    boolean checkNameDuplication(String name);
}
