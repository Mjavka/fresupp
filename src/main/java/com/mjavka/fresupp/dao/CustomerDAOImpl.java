package com.mjavka.fresupp.dao;

import com.mjavka.fresupp.model.Customer;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository
public class CustomerDAOImpl implements CustomerDAO
{

    private static final Logger logger = LoggerFactory.getLogger(CustomerDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf)
    {
        this.sessionFactory = sf;
    }

    @Override
    public void addCustomer(Customer p)
    {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Person saved successfully, Customer Details=" + p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Customer> listCustomer()
    {
        Session session = this.sessionFactory.getCurrentSession();
        List<Customer> customerList = session.createQuery("from Customer").list();
        for (Customer p : customerList)
        {
            logger.info("Customer List::" + p);
        }
        return customerList;
    }

}
