package com.mjavka.fresupp.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mjavka.fresupp.dao.LoginDAO;
import com.mjavka.fresupp.model.Login;

@Service
@ManagedBean(name="loginService")
@SessionScoped
@Transactional(readOnly = true)
public class LoginServiceImpl implements LoginService {

	private LoginDAO loginDAO;
	 
    public void setLoginDAO(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }
 
    @Override
    public List<Login> listLogin() {
        return this.loginDAO.listLogin();
    }

    @Override
    public Login getLogin(String username)
    {
        return this.loginDAO.getLogin(username);
    }
    
}
