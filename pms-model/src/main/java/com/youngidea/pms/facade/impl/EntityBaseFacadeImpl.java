/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.facade.impl;

import com.youngidea.pms.facade.BaseEntityFacade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author sean
 */
@Stateless
public class EntityBaseFacadeImpl<T> implements BaseEntityFacade<T>{

    @PersistenceContext(unitName = "PMS-v1PU")
    private EntityManager em;
    
    private Class<T> entityClass;

    
    
    public EntityBaseFacadeImpl() {
        
    } 
    
    
    public void refreshEntity(T entity) {
        em.refresh(entity);
    }
    
    
    public EntityBaseFacadeImpl(Class<T> entityClass) {
        initEntity(entityClass);
    }

    
    @Override
    public void initEntity(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    
    @Override
    public void create(T entity) {
        em.persist(entity);
    }

    
    public void edit(T entity) {
        em.merge(entity);
    }

    
    @Override
    public void remove(T entity) {
        em.remove(em.merge(entity));
    }

    
    @Override
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }

    // To be fixed later
//    public <T> List<T> findAllWhere(String property) {
//        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
//        cq.select(cq.from(entityClass));
//        cq.where(em.getCriteriaBuilder()
//                .equal(cq.from(entityClass).get(property), "c"));
//        return em.createQuery(cq).getResultList();
//    }
    
    @Override
    public T find(Object id) {
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
