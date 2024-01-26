/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.test.dao;

import com.project.test.entity.Login;
import com.project.test.facade.AbstractFacade;
import com.project.test.validator.ValidatorEjb;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author USER
 */
@Stateless
public class LoginDao extends AbstractFacade<Login> implements ILoginDao{

    public LoginDao() {
        super(Login.class);
    }

    @Inject
    private ValidatorEjb validatorEjb;

    @PersistenceContext(unitName = "ExampleDS")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Login getLoginByEmail(final String email) {
        final TypedQuery<Login> query
                = this.em.createNamedQuery("Login.findByEmail", Login.class);
        query.setParameter("email", email);
        return validatorEjb.getSingleResult(query);

    }
    
    @Override
    public void save(final Login login){
       em.persist(login);
    }

}
