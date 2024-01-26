/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.test.dao;

import com.project.test.entity.Blogs;
import com.project.test.entity.Readers;
import com.project.test.facade.AbstractFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author andresmendez
 */
@Stateless
public class ReadersDao extends AbstractFacade<Readers> implements IReadersDao {

    public ReadersDao() {
        super(Readers.class);
    }

    @PersistenceContext(unitName = "ExampleDS")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Readers> getAll() {
        final TypedQuery<Readers> query
                = this.em.createQuery("SELECT r FROM Readers r",
                        Readers.class);
        return query.getResultList();
    }

    @Override
    public void save(final Readers readers) {
        if (readers.getId() == null) {
            this.em.persist(readers);
        } else {
            this.em.merge(readers);
        }

    }

    @Override
    public void delete(final Long id) {
        em.remove(em.find(Readers.class, id));
    }
    
 
}
