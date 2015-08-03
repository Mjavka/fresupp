package com.mjavka.fresupp.model;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
 
/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author mjavka
 *
 */
@Entity
@Table(name="LOGIN_TB")
@ManagedBean(name="login")
public class Login implements Serializable 
{
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "object_uuid", unique = true)
    @Type(type="pg-uuid")
    private java.util.UUID uuid;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "password_h")
    private String password_hash;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "reg_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date regDate;
    
    @Column(name= "active")
    private Boolean active;
    
    @Column(name = "last_login")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastLogin;
    
    @Column(name = "status")
    private String status;

    public java.util.UUID getUuid()
    {
        return uuid;
    }

    public void setUuid(java.util.UUID uuid)
    {
        this.uuid = uuid;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword_hash()
    {
        return password_hash;
    }

    public void setPassword_hash(String password_hash)
    {
        this.password_hash = password_hash;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public Date getRegDate()
    {
        return regDate;
    }

    public void setRegDate(Date regDate)
    {
        this.regDate = regDate;
    }

    public Boolean getActive()
    {
        return active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    public Date getLastLogin()
    {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin)
    {
        this.lastLogin = lastLogin;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
     
    @Override
    public String toString(){
        return "uuid="+uuid+", username="+username;
    }
}