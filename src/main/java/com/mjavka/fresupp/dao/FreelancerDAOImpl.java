package com.mjavka.fresupp.dao;

import com.mjavka.fresupp.model.Freelancer;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class FreelancerDAOImpl implements FreelancerDAO
{

    private static final Logger logger = LoggerFactory.getLogger(FreelancerDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void addFreelancer(Freelancer p)
    {
        Session session = this.getSessionFactory().getCurrentSession();
        
        session.persist(p);
        
        logger.info("Freelancer saved successfully, Customer Details=" + p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Freelancer> listFreelancer()
    {
        Session session = this.getSessionFactory().getCurrentSession();
        List<Freelancer> freelancerList = session.createQuery("from Freelancer").list();
        for (Freelancer p : freelancerList)
        {
            logger.info("Freelancer List::" + p);
        }
        return freelancerList;
    }

    public SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

}
