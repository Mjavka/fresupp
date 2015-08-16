package com.mjavka.fresupp.dto;

import com.mjavka.fresupp.model.Order;
import java.util.ArrayList;
import java.util.List;
 
/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author mjavka
 *
 */
public class ManagerDTO
{
    private java.util.UUID uuid;
    
    private java.util.UUID loginUuid;
    
    private List<Order> orderList = new ArrayList<Order>();

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

    public List<Order> getOrderList()
    {
        return orderList;
    }

    public void setOrderList(List<Order> orderList)
    {
        this.orderList = orderList;
    }

    
}