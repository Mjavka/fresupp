package com.mjavka.fresupp.service;

import com.mjavka.fresupp.dao.FreelancerDAO;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mjavka.fresupp.model.Freelancer;
import com.mjavka.fresupp.model.Login;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@ManagedBean(name="freelancerService")
@SessionScoped
public class FreelancerServiceImpl implements FreelancerService {

    @Autowired
    private FreelancerDAO freelancerDAO;
	 
    public void setFreelancerDAO(FreelancerDAO freelancererDAO) {
        this.freelancerDAO = freelancererDAO;
    }
 
    @Override
    @Transactional
    public void addFreelancer(Freelancer p) {
        this.freelancerDAO.addFreelancer(p);
    }
 
    @Override
    @Transactional
    public List<Freelancer> listFreelancer() {
        return this.freelancerDAO.listFreelancer();
    }

    @Override
    public void addNewFreelancer(Login login)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
