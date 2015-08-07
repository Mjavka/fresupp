package com.mjavka.fresupp.dao;

import com.mjavka.fresupp.model.Role;
import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mjavka
 */
@Repository
public class RoleDAOImpl implements RoleDAO
{

    private static final Logger logger = LoggerFactory.getLogger(ManagerDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf)
    {
        this.sessionFactory = sf;
    }
    
    @Override
    public Role getRoleByUuid(UUID uuid)
    {
        Session session = this.sessionFactory.getCurrentSession();
        
        return (Role) session.load(Role.class, uuid);
        
    }
    
}
