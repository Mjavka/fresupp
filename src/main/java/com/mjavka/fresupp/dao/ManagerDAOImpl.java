package com.mjavka.fresupp.dao;

import com.mjavka.fresupp.model.Manager;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository
public class ManagerDAOImpl implements ManagerDAO
{

    private static final Logger logger = LoggerFactory.getLogger(ManagerDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf)
    {
        this.sessionFactory = sf;
    }

    @Override
    public void addManager(Manager p)
    {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Person saved successfully, Manager Details=" + p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Manager> listManager()
    {
        Session session = this.sessionFactory.getCurrentSession();
        List<Manager> managerList = session.createQuery("from Manager").list();
        for (Manager p : managerList)
        {
            logger.info("Manager List::" + p);
        }
        return managerList;
    }

}
