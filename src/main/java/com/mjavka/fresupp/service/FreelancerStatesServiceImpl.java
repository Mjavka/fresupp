package com.mjavka.fresupp.service;

import com.mjavka.fresupp.dto.FreelancerDTO;
import com.mjavka.fresupp.dto.LoginDTO;
import com.mjavka.fresupp.dto.RoleDTO;
import com.mjavka.fresupp.model.Freelancer;
import com.mjavka.fresupp.model.Login;
import com.mjavka.fresupp.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mjavka
 */
@Service("freelancerStatesService")
public class FreelancerStatesServiceImpl implements AccountStatesService, FreelancerStatesService
{

    @Autowired
    private FreelancerService freelancerService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private RoleService roleService;

    @Override
    @Transactional
    public boolean register(LoginDTO loginDTO)
    {
        Login login = new Login(); //@TODO use LoginFactory instead

        login.setUsername(loginDTO.getUsername());

        login.setPassword(loginDTO.getPassword());

        login.setEmail(loginDTO.getEmail());

        login.setActive(false);

        Role role = roleService.getRoleByUuid(RoleDTO.USER);

        login.addRole(role);
        
        login = getLoginService().registerNewLogin(login);

        Freelancer freelancer = new Freelancer(login);
        
        getFreelancerService().addFreelancer(freelancer);

        return true;
    }

    @Override
    public boolean unregister(LoginDTO loginDTO)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean activate(LoginDTO loginDTO)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deactivate(LoginDTO loginDTO)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean makePremium(FreelancerDTO freelancerDTO)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean makeUnPremium(FreelancerDTO freelancerDTO)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public FreelancerService getFreelancerService()
    {
        return freelancerService;
    }

    public void setFreelancerService(FreelancerService freelancerService)
    {
        this.freelancerService = freelancerService;
    }

    public LoginService getLoginService()
    {
        return loginService;
    }

    public void setLoginService(LoginService loginService)
    {
        this.loginService = loginService;
    }

    public RoleService getRoleService()
    {
        return roleService;
    }

    public void setRoleService(RoleService roleService)
    {
        this.roleService = roleService;
    }

}
