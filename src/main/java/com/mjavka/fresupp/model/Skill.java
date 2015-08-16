package com.mjavka.fresupp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import java.util.UUID;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author mjavka
 *
 */
@Entity
@Table(name = "WORK_TYPE_TB")
public class Skill implements Serializable
{

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "object_uuid", unique = true)
    @Type(type = "pg-uuid")
    private UUID uuid;

    
    @Column(name = "name", nullable = false, length = 15)
    private String role;

    public Skill()
    {
        
    }
    
    
    @ManyToOne(targetEntity = Login.class, fetch = FetchType.LAZY)
    @JoinTable(name="LOGIN_ROLE_REF",
        joinColumns = {
            
            @JoinColumn(name="role_uuid", referencedColumnName = "object_uuid")},
        
        inverseJoinColumns = {
            
            @JoinColumn(name="login_uuid", referencedColumnName = "object_uuid")
        }
    )
    private Login login;
    
    public Skill(String role, UUID uuid)
    {
        this.role = role;
        
        this.uuid = uuid;
    }
    
    public UUID getUuid()
    {
        return uuid;
    }

    public void setUuid(UUID uuid)
    {
        this.uuid = uuid;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
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
