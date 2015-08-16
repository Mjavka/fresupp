package com.mjavka.fresupp.service;

import com.mjavka.fresupp.dto.LoginDTO;
import com.mjavka.fresupp.dto.RoleDTO;
import com.mjavka.fresupp.model.Customer;
import com.mjavka.fresupp.model.Login;
import com.mjavka.fresupp.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mjavka
 */
@Service("customerStatesService")
public class CustomerStatesServiceImpl implements AccountStatesService, CustomerStatesService
{

    @Autowired
    private CustomerService customerService;

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

        Role role = getRoleService().getRoleByUuid(RoleDTO.USER);

        login.addRole(role);

        login = getLoginService().registerNewLogin(login);

        Customer customer = new Customer(login);

        getCustomerService().addCustomer(customer);

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

    public CustomerService getCustomerService()
    {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService)
    {
        this.customerService = customerService;
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
