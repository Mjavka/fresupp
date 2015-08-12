package com.mjavka.fresupp.service;

import com.mjavka.fresupp.exceptions.EmailExistException;
import com.mjavka.fresupp.exceptions.UsernameExistException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mjavka.fresupp.dao.LoginDAO;
import com.mjavka.fresupp.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional(readOnly = false)
    public Login registerNewLogin(Login login) throws EmailExistException, UsernameExistException
    {
        if (emailExist(login.getEmail()))
        {
            throw new EmailExistException(
                    "There is an account with that email address:"
                    + login.getEmail());
        }

        if (usernameExist(login.getUsername()))
        {
            throw new EmailExistException(
                    "There is an account with that username:"
                    + login.getUsername());
        }

        loginDAO.addLogin(login);

        return loginDAO.findByUsername(login.getUsername());
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
