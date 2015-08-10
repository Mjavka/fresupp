package com.mjavka.fresupp.dao;

import com.mjavka.fresupp.actions.exceptions.EmailExistException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mjavka.fresupp.model.Login;
import com.mjavka.fresupp.model.Role;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class LoginDAOImpl implements LoginDAO
{

    private static final Logger logger = LoggerFactory.getLogger(LoginDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf)
    {
        this.sessionFactory = sf;
    }

    @Override
    public void addLogin(Login p)
    {
        Session session = this.sessionFactory.getCurrentSession();
        
        Role role = (Role) session.get(Role.class, UUID.fromString("a390e388-3ce6-11e5-a808-cfc3b31c6443"));
        
        p.addRole(role);
        
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
    public Login findByUsername(String username)
    {

        List<Login> logins = new ArrayList<Login>();

        logins = sessionFactory.getCurrentSession()
                .createQuery("FROM Login WHERE username=?")
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

    @Override
    public Login findByEmail(String email)
    {
        List<Login> logins = new ArrayList<Login>();

        logins = sessionFactory.getCurrentSession()
                .createQuery("FROM Login WHERE email=?")
                .setParameter(0, email)
                .list();

        if (logins.size() > 0)
        {
            return logins.get(0);
        } else if (logins.size() > 1)
        {
            logger.error("found " + logins.size() + " users with email = "
                    + email);
            
            return null;
        } else

        {
            return null;
        }
    }

}
