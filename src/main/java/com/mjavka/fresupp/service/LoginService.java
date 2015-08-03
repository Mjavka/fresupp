package com.mjavka.fresupp.service;

import java.util.List;

import com.mjavka.fresupp.model.Login;
 
public interface LoginService {
 
    public void addLogin(Login p);
    public List<Login> listLogin();
     
}