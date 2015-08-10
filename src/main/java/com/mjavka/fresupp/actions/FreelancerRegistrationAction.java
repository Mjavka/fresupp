package com.mjavka.fresupp.actions;

import com.mjavka.fresupp.dto.LoginDTO;
import com.mjavka.fresupp.service.LoginService;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author mjavka
 */
@ManagedBean(name = "freelancerRegistrationAction")
@ViewScoped
public class FreelancerRegistrationAction extends AbstractRegistrationAction implements Serializable
{
    private static final Logger logger = LoggerFactory.getLogger(FreelancerRegistrationAction.class);
    
    @ManagedProperty(value = "#{loginService}")
    private LoginService loginService = null;

    private LoginDTO loginDTO = new LoginDTO();

    public String register()
    {
        loginDTO.setEmail(getEmail());
        loginDTO.setUsername(getUserName());
        loginDTO.setPassword(getPassword());
        
        try
        {
            loginService.registerNewUserAccount(loginDTO);
        } catch (Exception ex)
        {
            logger.error("error registering ", ex);
            
            return "incorrect";
        }
        return "correct";
    }

    public String cancel()
    {
        return null;
    }

    public String logout()
    {
        SecurityContextHolder.clearContext();
        return "loggedout";
    }

    public LoginService getLoginService()
    {
        return loginService;
    }

    public void setLoginService(LoginService loginService)
    {
        this.loginService = loginService;
    }

    public LoginDTO getLoginDTO()
    {
        return loginDTO;
    }

    public void setLoginDTO(LoginDTO loginDTO)
    {
        this.loginDTO = loginDTO;
    }

}
