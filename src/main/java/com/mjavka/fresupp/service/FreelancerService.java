package com.mjavka.fresupp.service;

import com.mjavka.fresupp.model.Freelancer;
import java.util.List;

 
public interface FreelancerService {
 
    public void addFreelancer(Freelancer p);
    public List<Freelancer> listFreelancer();
     
}