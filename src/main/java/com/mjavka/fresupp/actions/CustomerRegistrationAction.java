package com.mjavka.fresupp.actions;

import com.mjavka.fresupp.dto.LoginDTO;
import com.mjavka.fresupp.service.AccountStatesService;
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
@ManagedBean(name = "customerRegistrationAction")
@ViewScoped
public class CustomerRegistrationAction extends AbstractRegistrationAction
{
    
    private static final Logger logger = LoggerFactory.getLogger(CustomerRegistrationAction.class);
    
    @ManagedProperty(value = "#{customerStatesService}")
    
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
