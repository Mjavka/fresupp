package com.mjavka.fresupp.service;

import com.mjavka.fresupp.dto.LoginDTO;

/**
 *
 * @author mjavka
 */
public interface AccountStatesService 
{
    public boolean register(LoginDTO loginDTO);
    
    public boolean unregister(LoginDTO loginDTO);
    
    public boolean activate(LoginDTO loginDTO);
    
    public boolean deactivate(LoginDTO loginDTO);
    
}
