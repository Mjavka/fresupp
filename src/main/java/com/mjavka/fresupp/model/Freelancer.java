package com.mjavka.fresupp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
 
/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author mjavka
 *
 */
@Entity
@Table(name="FREELANCE_TB")
public class Freelancer implements Serializable 
{
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "object_uuid", unique = true)
    @Type(type="pg-uuid")
    private java.util.UUID uuid;
    
    @Column(name = "login_ref")
    private java.util.UUID loginUuid;
    
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "freelancersList")
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
    
    public List<Order> getOrderList()
    {
        return orderList;
    }

    public void setOrderList(List<Order> orderList)
    {
        this.orderList = orderList;
    }
    
    @Override
    public String toString(){
        return "uuid="+uuid+", freelancerUuid="+loginUuid;
    }

   

    
}