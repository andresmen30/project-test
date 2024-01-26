package com.project.test.conversor;


import com.project.test.entity.Login;
import com.project.test.dto.LoginDto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import org.apache.commons.collections4.CollectionUtils;

@Stateless
public class LoginConversor implements Serializable {

    public LoginDto getLoginFromEntity(final Login loginEntity) {
        final LoginDto loginDto = new LoginDto();
        loginDto.setEmail(loginEntity.getEmail());
        loginDto.setPassword(loginEntity.getPassword());
        loginDto.setName(loginEntity.getName());
        loginDto.setIdLogin(loginEntity.getIdLogin());
        return loginDto;
    }
    
    public Login getLoginFromDto(final LoginDto LoginDto) {
        final Login login = new Login();
        login.setEmail("andresmen30@gmail.com");
        login.setPassword(LoginDto.getPassword());
        login.setName("Andres Mendez");
        login.setIdLogin(LoginDto.getIdLogin());
        return login;
    }

    public List<LoginDto> getLoginListFromDto(final List<Login> loginListEntity) {
        final List<LoginDto> listLoginDto = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(loginListEntity)) {
            loginListEntity.stream().forEach(loginEntity -> {
                listLoginDto.add(getLoginFromEntity(loginEntity));
            });
        }
        return listLoginDto;
    }
}
