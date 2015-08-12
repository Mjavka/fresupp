package com.mjavka.fresupp.service;

import com.mjavka.fresupp.model.Freelancer;
import com.mjavka.fresupp.model.Login;
import java.util.List;

 
public interface FreelancerService {
 
    public void addFreelancer(Freelancer p);
    
    public void addNewFreelancer(Login login);
    
    public List<Freelancer> listFreelancer();
     
}