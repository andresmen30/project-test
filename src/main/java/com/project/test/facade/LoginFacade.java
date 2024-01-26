/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.test.facade;

import com.project.test.entity.Login;
import com.project.test.dto.LoginDto;
import com.project.test.conversor.LoginConversor;
import com.project.test.dao.ILoginDao;
import javax.ejb.Stateless;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author USER
 */
@Stateless
public class LoginFacade implements Serializable {

    @EJB
    private ILoginDao iLoginDao;

    @EJB
    private LoginConversor loginConversor;

    public LoginDto getLoginByEmail(final String email) {
        final Login login = iLoginDao.getLoginByEmail(email);
        if (login != null) {
            return loginConversor.getLoginFromEntity(login);
        }
        return null;

    }

    public void save(final LoginDto loginDto) {
        iLoginDao.save(loginConversor.getLoginFromDto(loginDto));

    }

}
