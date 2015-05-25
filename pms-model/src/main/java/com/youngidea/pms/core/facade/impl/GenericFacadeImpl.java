/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.core.facade.impl;

import com.youngidea.pms.core.facade.AbstractFacade;
import com.youngidea.pms.core.entity.PMSEntity;
import com.youngidea.pms.core.facade.GenericFacade;
import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author sean
 */
@Stateless
public class GenericFacadeImpl<E extends PMSEntity> implements GenericFacade<E>, AbstractFacade<E> {
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
        em.persist(entity);
    }

    @Override
    public void edit(E entity) {
        em.merge(entity);
    }

    @Override
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

    @Override
    public Class<E> getEntityClass() {
        return this.entityClass;
    }

    public List<E> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<E> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public List<E> findByName(String name) {
        Query q1 = em.createQuery("SELECT s FROM " + entityClass.getSimpleName()
                + " s WHERE s.name= :name").setParameter("name", name);
        return q1.getResultList();
    }

    public boolean checkNameDuplication(String name) {
        return findByName(name).isEmpty() ? false : true;
    }

    // To be used independently ---------------------------

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

    public <T> List<T> findByName(String name, Class<T> entityClass) {
        Query q1 = em.createQuery("SELECT s FROM " + entityClass.getSimpleName() + " s WHERE s.name= :name").setParameter("name", name);
        return q1.getResultList();
    }
}
