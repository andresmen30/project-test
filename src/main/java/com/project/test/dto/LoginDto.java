/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.test.dto;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class LoginDto implements Serializable {

    private Long idLogin;
    private String email;
    private String name;
    private String password;
    
    public LoginDto(){
      super();
    }

    public LoginDto(Long idLogin, String email, String name, String password) {
        this.idLogin = idLogin;
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public Long getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Long idLogin) {
        this.idLogin = idLogin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
