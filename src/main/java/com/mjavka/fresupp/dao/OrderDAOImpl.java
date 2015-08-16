package com.mjavka.fresupp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mjavka.fresupp.model.Order;
import java.util.Date;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class OrderDAOImpl implements OrderDAO
{

    private static final Logger logger = LoggerFactory.getLogger(OrderDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addOrder(Order p)
    {
        Session session = this.sessionFactory.getCurrentSession();
        
        p.setCreationDate(new Date());
        
        session.persist(p);
        
        logger.info("order saved successfully, Order Details=" + p);
    }

    @Override
    public List<Order> listOrder()
    {
        Session session = this.sessionFactory.getCurrentSession();
        
        List<Order> ordersList = session.createQuery("from Order").list();
        
        for (Order p : ordersList)
        {
            logger.info("Login List::" + p);
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
