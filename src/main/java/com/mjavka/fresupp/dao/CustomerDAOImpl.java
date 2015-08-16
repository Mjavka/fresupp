package com.mjavka.fresupp.dao;

import com.mjavka.fresupp.model.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CustomerDAOImpl implements CustomerDAO
{

    private static final Logger logger = LoggerFactory.getLogger(CustomerDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf)
    {
        this.sessionFactory = sf;
    }
    
    public Session getCurrentSession()
    {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void addCustomer(Customer p)
    {
        getCurrentSession().persist(p);
        
        logger.info("Customer saved successfully, Customer Details=" + p);
    }
    
    @Override
    public void updateCustomer(Customer p)
    {
        getCurrentSession().update(p);
        
        logger.info("Customer updated successfully, Customer Details=" + p);
    }
    
    @Override
    public void deleteCustomer(Customer p)
    {
        getCurrentSession().delete(p);
    }
    
    @Override 
    public Customer getCustomerByUuid(UUID uuid)
    {
        return (Customer) sessionFactory.getCurrentSession().get(Customer.class, uuid);
        
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Customer> listCustomer()
    {
        List<Customer> customerList = getCurrentSession().createQuery("from Customer").list();
        for (Customer p : customerList)
        {
            logger.info("Customer List::" + p);
        }
        return customerList;
    }

}
