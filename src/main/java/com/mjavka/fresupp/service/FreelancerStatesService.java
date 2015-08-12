package com.mjavka.fresupp.service;

import com.mjavka.fresupp.dto.FreelancerDTO;

/**
 *
 * @author mjavka
 */
public interface FreelancerStatesService
{
    public boolean makePremium(FreelancerDTO freelancerDTO);
    
    public boolean makeUnPremium(FreelancerDTO freelancerDTO);
    
}
