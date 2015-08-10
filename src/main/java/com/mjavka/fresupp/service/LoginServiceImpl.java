package com.mjavka.fresupp.service;

import com.mjavka.fresupp.actions.exceptions.EmailExistException;
import com.mjavka.fresupp.actions.exceptions.UsernameExistException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mjavka.fresupp.dao.LoginDAO;
import com.mjavka.fresupp.dto.LoginDTO;
import com.mjavka.fresupp.model.Login;
import org.springframework.beans.factory.annotation.Autowired;

@Service("loginService")
@Transactional(readOnly = true)
public class LoginServiceImpl implements LoginService
{

    @Autowired
    private LoginDAO loginDAO;

    public void setLoginDAO(LoginDAO loginDAO)
    {
        this.loginDAO = loginDAO;
    }

    @Override
    public List<Login> listLogin()
    {
        return this.loginDAO.listLogin();
    }

    @Override
    public Login getLogin(String username)
    {
        return this.loginDAO.findByUsername(username);
    }

    @Transactional(readOnly = false)
    @Override
    public void registerNewUserAccount(LoginDTO loginDto)  throws EmailExistException, UsernameExistException
    {
        if (emailExist(loginDto.getEmail()))
        {
            throw new EmailExistException(
            "There is an account with that email address:"
              + loginDto.getEmail());
        }   
        
        if (usernameExist(loginDto.getUsername()))
        {
            throw new EmailExistException(
            "There is an account with that username:"
              + loginDto.getUsername());
        } 

        Login login = new Login();

        login.setUsername(loginDto.getUsername());

        login.setPassword(loginDto.getPassword());

        login.setEmail(loginDto.getEmail());
        
        loginDAO.addLogin(login);
    }

    private boolean emailExist(String email)
    {
        Login login = loginDAO.findByEmail(email);

        if (login != null)
        {
            return true;
        }
        return false;
    }
    
    private boolean usernameExist(String username)
    {
        Login login = loginDAO.findByUsername(username);

        if (login != null)
        {
            return true;
        }
        return false;
    }

}
