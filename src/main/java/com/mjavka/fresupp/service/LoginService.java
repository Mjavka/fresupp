package com.mjavka.fresupp.service;

import com.mjavka.fresupp.exceptions.EmailExistException;
import java.util.List;

import com.mjavka.fresupp.model.Login;
 
public interface LoginService {
 
    public List<Login> listLogin();
    
    public Login getLogin(String username);
    
    public Login registerNewLogin(Login login) throws EmailExistException; 
}