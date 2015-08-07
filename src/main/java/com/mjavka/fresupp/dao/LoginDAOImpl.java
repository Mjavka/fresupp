package com.mjavka.fresupp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mjavka.fresupp.model.Login;
import java.util.ArrayList;
import java.util.Calendar;

@Repository
public class LoginDAOImpl implements LoginDAO
{

    private static final Logger logger = LoggerFactory.getLogger(LoginDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf)
    {
        this.sessionFactory = sf;
    }

    @Override
    public void addLogin(Login p)
    {
        Session session = this.sessionFactory.getCurrentSession();
        p.setRegDate(Calendar.getInstance().getTime());
        session.persist(p);
        logger.info("Person saved successfully, Person Details=" + p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Login> listLogin()
    {
        Session session = this.sessionFactory.getCurrentSession();
        List<Login> loginsList = session.createQuery("from Login").list();
        for (Login p : loginsList)
        {
            logger.info("Login List::" + p);
        }
        return loginsList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Login getLogin(String username)
    {

        List<Login> logins = new ArrayList<Login>();

        logins = sessionFactory.getCurrentSession()
                .createQuery("from Login where username=?")
                .setParameter(0, username)
                .list();

        if (logins.size() > 0)
        {
            return logins.get(0);
        } else if (logins.size() > 1)
        {
            logger.error("found " + logins.size() + " users with username = "
                    + username);
            
            return null;
        } else

        {
            return null;
        }

    }

}
