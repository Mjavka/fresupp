package com.mjavka.fresupp.dto;

import com.mjavka.fresupp.model.*;
import java.io.Serializable;
import java.util.Set;
 
/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author mjavka
 *
 */
public class CustomerDTO implements Serializable 
{
    private java.util.UUID uuid;
    
    private java.util.UUID loginUuid;
    
    private Set<Order> orders;

    public java.util.UUID getUuid()
    {
        return uuid;
    }

    public void setUuid(java.util.UUID uuid)
    {
        this.uuid = uuid;
    }

    public java.util.UUID getLoginUuid()
    {
        return loginUuid;
    }

    public void setLoginUuid(java.util.UUID loginUuid)
    {
        this.loginUuid = loginUuid;
    }
     
    @Override
    public String toString(){
        return "uuid="+uuid+", loginUuid="+loginUuid;
    }

    public Set<Order> getOrders()
    {
        return orders;
    }

    public void setOrders(Set<Order> orders)
    {
        this.orders = orders;
    }

    
}