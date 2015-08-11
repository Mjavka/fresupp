package com.mjavka.fresupp.service;

import com.mjavka.fresupp.dao.FreelancerDAO;
import com.mjavka.fresupp.dao.LoginDAO;
import org.springframework.stereotype.Service;

/**
 *
 * @author mjavka
 */
@Service("freelancerRegistration")
public class FreelancerStatesServiceImpl extends AbstractStatesService implements FreelancerStatesService 
{

    @Override
    public boolean register(LoginDAO loginDAO)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean unregister(LoginDAO loginDAO)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean activate(LoginDAO loginDAO)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deactivate(LoginDAO loginDAO)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean makePremium(FreelancerDAO freelancerDAO)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean makeUnPremium(FreelancerDAO freelancerDAO)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
