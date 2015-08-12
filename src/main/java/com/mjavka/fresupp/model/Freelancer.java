package com.mjavka.fresupp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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
public class Freelancer implements Serializable //@TODO add freelancer specific info
{
    public Freelancer(Login login)
    {
        this.login = login;
    }
    
    public Freelancer()
    {
        
    }
    
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "object_uuid", unique = true)
    @Type(type="pg-uuid")
    private java.util.UUID uuid;    
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "freelancersList")
    private List<Order> orderList = new ArrayList<Order>();
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "login_ref")
    private Login login;
    

    public java.util.UUID getUuid()
    {
        return uuid;
    }

    public void setUuid(java.util.UUID uuid)
    {
        this.uuid = uuid;
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
        return "uuid=" + uuid;
    }

    public Login getLogin()
    {
        return login;
    }

    public void setLogin(Login login)
    {
        this.login = login;
    }
}