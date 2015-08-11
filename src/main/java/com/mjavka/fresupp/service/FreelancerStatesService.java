package com.mjavka.fresupp.service;

import com.mjavka.fresupp.dao.FreelancerDAO;

/**
 *
 * @author mjavka
 */
public interface FreelancerStatesService
{
    public boolean makePremium(FreelancerDAO freelancerDAO);
    
    public boolean makeUnPremium(FreelancerDAO freelancerDAO);
    
}
