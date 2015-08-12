package com.mjavka.fresupp.actions;

import com.mjavka.fresupp.dto.LoginDTO;
import com.mjavka.fresupp.service.AccountStatesService;
import com.mjavka.fresupp.service.FreelancerStatesService;
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
    
    @ManagedProperty(value = "#{freelancerStatesService}")
    
    private AccountStatesService accountStatesService;

    private LoginDTO loginDTO = new LoginDTO();

    public String register()
    {
        loginDTO.setEmail(getEmail());
        loginDTO.setUsername(getUserName());
        loginDTO.setPassword(getPassword());
        
        try
        {
            getAccountStatesService().register(loginDTO);
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

    public LoginDTO getLoginDTO()
    {
        return loginDTO;
    }

    public void setLoginDTO(LoginDTO loginDTO)
    {
        this.loginDTO = loginDTO;
    }

    public AccountStatesService getAccountStatesService()
    {
        return accountStatesService;
    }

    public void setAccountStatesService(AccountStatesService accountStatesService)
    {
        this.accountStatesService = accountStatesService;
    }

}
