package com.mjavka.fresupp.service;

import com.mjavka.fresupp.dao.LoginDAO;

/**
 *
 * @author mjavka
 */
public abstract class AbstractStatesService 
{
    public abstract boolean register(LoginDAO loginDAO);
    
    public abstract boolean unregister(LoginDAO loginDAO);
    
    public abstract boolean activate(LoginDAO loginDAO);
    
    public abstract boolean deactivate(LoginDAO loginDAO);
    
}
