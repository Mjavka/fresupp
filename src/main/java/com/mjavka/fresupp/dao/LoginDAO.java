package com.mjavka.fresupp.dao;

import java.util.List;

import com.mjavka.fresupp.model.Login;
 
public interface LoginDAO {
 
    public void addLogin(Login p);
    public List<Login> listLogin();
    
    Login getLogin(String username);
}