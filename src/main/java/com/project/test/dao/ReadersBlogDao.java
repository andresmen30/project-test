/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.test.dao;

import com.project.test.entity.BlogsReaders;
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
public class ReadersBlogDao extends AbstractFacade<ReadersBlogDao> implements IReadersBlogDao {

    public ReadersBlogDao() {
        super(ReadersBlogDao.class);
    }

    @PersistenceContext(unitName = "ExampleDS")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<BlogsReaders> getAll() {
        final TypedQuery<BlogsReaders> query
                = this.em.createQuery("SELECT r FROM BlogsReaders r",
                        BlogsReaders.class);
        return query.getResultList();
    }

    @Override
    public void save(final BlogsReaders blogsReaders) {
        if (blogsReaders.getId() == null) {
            this.em.persist(blogsReaders);
        } else {
            this.em.merge(blogsReaders);
        }

    }

    @Override
    public void delete(final Long id) {
        em.remove(em.find(BlogsReaders.class, id));
    }
    
    
    
    
   
    
    
  
    
}
