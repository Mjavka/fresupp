package com.mjavka.fresupp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mjavka.fresupp.model.Solution;
import java.util.Date;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class SolutionDAOImpl implements SolutionDAO
{

    private static final Logger logger = LoggerFactory.getLogger(SolutionDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addSolution(Solution p)
    {
        Session session = this.sessionFactory.getCurrentSession();
        
        p.setCreationDate(new Date());
        
        session.persist(p);
        
        logger.info("order saved successfully, Solution Details=" + p);
    }

    @Override
    public List<Solution> listSolution()
    {
        Session session = this.sessionFactory.getCurrentSession();
        
        List<Solution> ordersList = session.createQuery("from Solution").list();
        
        for (Solution p : ordersList)
        {
            logger.info("Solution List::" + p);
        }
        
        return ordersList;
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
