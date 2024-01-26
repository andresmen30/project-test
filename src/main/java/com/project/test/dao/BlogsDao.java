/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.test.dao;

import com.project.test.entity.Blogs;
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
public class BlogsDao extends AbstractFacade<Blogs> implements IBlogsDao {

    public BlogsDao() {
        super(Blogs.class);
    }

    @PersistenceContext(unitName = "ExampleDS")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Blogs> getAll() {
        final TypedQuery<Blogs> query
                = this.em.createQuery("SELECT b FROM Blogs b",
                        Blogs.class);
        return query.getResultList();
    }

    @Override
    public void save(final Blogs blogs) {
        if (blogs.getId() == null) {
            this.em.persist(blogs);
        } else {
            this.em.merge(blogs);
        }

    }

    @Override
    public void delete(final Long id) {
        em.remove(em.find(Blogs.class, id));
    }
    
    @Override
    public List<Blogs> getBlogs(final Long readerId) {
        final TypedQuery<Blogs> query
                = this.em.createQuery("SELECT b FROM Blogs b WHERE b.id NOT IN (SELECT br.blog.id FROM BlogsReaders br WHERE br.reader.id = :readerId)",
                        Blogs.class);
        query.setParameter("readerId", readerId);
        return query.getResultList();
    }

}
