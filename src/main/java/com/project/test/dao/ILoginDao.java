/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.test.dao;

import com.project.test.entity.Login;
import javax.ejb.Local;

/**
 *
 * @author andresmendez
 */
@Local
public interface ILoginDao {
    
    Login getLoginByEmail(final String email);
    
    void save(final Login login);
    
}
