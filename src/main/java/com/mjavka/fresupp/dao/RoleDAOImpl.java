package com.mjavka.fresupp.dao;

import com.mjavka.fresupp.model.Role;
import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mjavka
 */
@Repository
public class RoleDAOImpl implements RoleDAO
{

    private static final Logger logger = LoggerFactory.getLogger(ManagerDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public Role getRoleByUuid(UUID uuid)
    {
        Session session = this.getSessionFactory().getCurrentSession();
        
        return (Role) session.get(Role.class, uuid);
        
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
