package com.mjavka.fresupp.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name="CUSTOMER_TB")
public class Customer implements Serializable 
{
    public Customer(Login login)
    {
        this.login = login;
    }
    
    public Customer()
    {
        
    }
    
    
    private java.util.UUID uuid;
    
    private Login login;
    
    private Set<Order> orders;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "object_uuid", unique = true)
    @Type(type="pg-uuid")
    public java.util.UUID getUuid()
    {
        return uuid;
    }

    public void setUuid(java.util.UUID uuid)
    {
        this.uuid = uuid;
    }
     
    @Override
    public String toString(){
        return "uuid="+uuid;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    public Set<Order> getOrders()
    {
        return orders;
    }

    public void setOrders(Set<Order> orders)
    {
        this.orders = orders;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "login_ref")
    public Login getLogin()
    {
        return login;
    }

    public void setLogin(Login login)
    {
        this.login = login;
    }

    
}