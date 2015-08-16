package com.mjavka.fresupp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mjavka.fresupp.model.Task;
import java.util.Date;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class TaskDAOImpl implements TaskDAO
{

    private static final Logger logger = LoggerFactory.getLogger(TaskDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addTask(Task p)
    {
        Session session = this.sessionFactory.getCurrentSession();
        
        p.setCreationDate(new Date());
        
        session.persist(p);
        
        logger.info("order saved successfully, Task Details=" + p);
    }

    @Override
    public List<Task> listTask()
    {
        Session session = this.sessionFactory.getCurrentSession();
        
        List<Task> ordersList = session.createQuery("from Task").list();
        
        for (Task p : ordersList)
        {
            logger.info("Task List::" + p);
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
