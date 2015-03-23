/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.facade.impl;

import com.youngidea.pms.facade.BaseEntityFacade;
import com.youngidea.pms.facade.GenericFacade;
import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author sean
 */
@Stateless
public class GenericFacadeImpl<E> implements GenericFacade, BaseEntityFacade<E>{
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(GenericFacadeImpl.class);

    @PersistenceContext(unitName = "PMS-v1PU")
    protected EntityManager em;
    
    private Class<E> entityClass;

    public GenericFacadeImpl() {}

    public GenericFacadeImpl(Class<E> entityClass) {
        initEntity(entityClass);
    }

    public void initEntity(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void create(E entity) {
//            LOGGER.info(entity.getClass().toString());
        System.out.println(entity.getClass().toString());
            em.persist(entity);

    }

    public void edit(E entity) {
        em.merge(entity);
    }

    public void remove(E entity) {
        em.remove(em.merge(entity));
    }

    public List<E> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }

    public E find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    protected List<E> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    protected int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<E> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    // To be used independently
    @Override
    public <T> void create(Class<T> entityClass, T entity) {
        em.persist(entity);
    }

    @Override
    public <T> void edit(Class<T> entityClass, T entity) {
        em.merge(entity);
    }

    @Override
    public <T> void remove(Class<T> entityClass, T entity) {
        em.remove(em.merge(entity));
    }

    @Override
    public <T> List<T> findAll(Class<T> entityClass) {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }

    // to be improve later...
    public <T> List<T> findAllWhere(Class<T> entityClass, String property, String value) {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        cq.where(getEntityManager().getCriteriaBuilder()
                .equal(cq.from(entityClass).get(property), value));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public <T> T find(Class<T> entityClass, Object id) {
        return em.find(entityClass, id);
    }


}
