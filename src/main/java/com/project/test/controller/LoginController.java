package com.project.test.controller;

import com.project.test.dto.LoginDto;
import com.project.test.facade.LoginFacade;
import com.project.test.util.JsfUtility;
import com.project.test.util.MessageUtil;
import com.project.test.util.Validator;
import com.project.test.util.ValidatorEncrypt;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author andresmendez
 */
@Named
@SessionScoped
public class LoginController implements Serializable {

    @Inject
    private LoginFacade loginFacade;

    private LoginDto loginDto;

    @PostConstruct
    public void init() {
        loginDto = new LoginDto();
    }

    public String iniciarSesion() {
        if (Validator.isNull(this.loginDto.getEmail())
                || Validator.isNull(this.loginDto.getPassword())) {
            MessageUtil.addMessageError("¡oops!", "Email y contraseña son obligatorios");
        } else {
             /*final String passwordChangue = ValidatorEncrypt
                    .hashPassword(this.loginDto.getPassword());
             this.loginDto.setPassword(passwordChangue);
            loginFacade.save(loginDto);*/
            final LoginDto loginDb = loginFacade.getLoginByEmail(this.loginDto.getEmail());
            if (loginDb == null) {
                MessageUtil.addMessageError("¡oops!", "El usuario no existe con ese email");
                return StringUtils.EMPTY;
            } else if (!ValidatorEncrypt.checkPass(this.loginDto.getPassword(),
                    loginDb.getPassword())) {
                this.loginDto.setName(loginDb.getName());
                MessageUtil.addMessageError("¡oops!", "Contraseña invalida");
                return StringUtils.EMPTY;
            }
        }
        JsfUtility.setAtttributeLogin(this.loginDto);
        return "pretty:reader";
    }

    public void cerrarSesion() throws IOException {
        final FacesContext context = FacesContext.getCurrentInstance();
        final ExternalContext externalContext = context.getExternalContext();
        final Object session = externalContext.getSession(false);
        final HttpSession httpSession = (HttpSession) session;
        httpSession.invalidate();
        externalContext.redirect(((HttpServletRequest) externalContext.getRequest()).getRequestURI());
    }

    public void resetInput() {
        this.loginDto = new LoginDto();
    }

   
    /**
     * @return the loginDto
     */
    public LoginDto getLoginDto() {
        return loginDto;
    }

    /**
     * @param loginDto the loginDto to set
     */
    public void setLoginDto(LoginDto loginDto) {
        this.loginDto = loginDto;
    }

}
