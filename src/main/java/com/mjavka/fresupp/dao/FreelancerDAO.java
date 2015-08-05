package com.mjavka.fresupp.dao;

import com.mjavka.fresupp.model.Freelancer;
import java.util.List;

 
public interface FreelancerDAO {
 
    public void addFreelancer(Freelancer p);
    public List<Freelancer> listFreelancer();
}