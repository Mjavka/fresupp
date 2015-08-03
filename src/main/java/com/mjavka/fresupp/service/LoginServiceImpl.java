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
public class LoginServiceImpl implements LoginService {

	private LoginDAO loginDAO;
	 
    public void setLoginDAO(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }
 
    @Override
    @Transactional
    public void addLogin(Login p) {
        this.loginDAO.addLogin(p);
    }
 
    @Override
    @Transactional
    public List<Login> listLogin() {
        return this.loginDAO.listLogin();
    }
 
}
