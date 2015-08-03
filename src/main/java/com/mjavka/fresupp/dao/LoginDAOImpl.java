package com.mjavka.fresupp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mjavka.fresupp.model.Login;

@Repository
public class LoginDAOImpl implements LoginDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(LoginDAOImpl.class);
	 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Override
    public void addLogin(Login p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Person saved successfully, Person Details="+p);
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<Login> listLogin() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Login> LoginsList = session.createQuery("from Login").list();
        for(Login p : LoginsList){
            logger.info("Login List::"+p);
        }
        return LoginsList;
    }
 
}
