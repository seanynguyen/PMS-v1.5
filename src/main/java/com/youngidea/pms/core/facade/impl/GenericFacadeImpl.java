/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.core.facade.impl;

import com.youngidea.pms.core.facade.GenericFacade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sean
 */
@Stateless
public class GenericFacadeImpl implements GenericFacade {
    
    @PersistenceContext(unitName = "PMS-v1PU")
    protected EntityManager em;
    
    public GenericFacadeImpl() {
    }

    public EntityManager getEntityManager() {
        return em;
    }
    
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
    
/*
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
*/    
}
