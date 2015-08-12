package com.mjavka.fresupp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 *
 * @author mjavka
 *
 */
@Entity
@Table(name = "LOGIN_TB")
public class Login implements Serializable
{

    public Login()
    {

    }

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "object_uuid", unique = true)
    @Type(type = "pg-uuid")
    private java.util.UUID uuid;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "reg_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date regDate;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "last_login")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastLogin;

    @Column(name = "status")
    private String status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "LOGIN_ROLE_REF",
            joinColumns =
            {

                @JoinColumn(name = "login_uuid", referencedColumnName = "object_uuid")
            },
            inverseJoinColumns =
            {

                @JoinColumn(name = "role_uuid", referencedColumnName = "object_uuid")
            }
    )
    private List<Role> roles = new ArrayList<Role>(0);

    public void addRole(Role b)
    {
        if (b != null)
        {
            if (getRoles().contains(b))
            {
                getRoles().set(getRoles().indexOf(b), b);
            } else
            {
                getRoles().add(b);
            }
        }
    }
    
    public void removeRole(Role b)
    {
        getRoles().remove(b);
        b.setLogin(null);
    }
    
//    @OneToOne(fetch = FetchType.LAZY, mappedBy = "login", cascade = CascadeType.ALL)
//    private Freelancer freelancer;
    
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

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
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
    public String toString()
    {
        return "uuid=" + uuid + ", username=" + username;
    }

    public List<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(List<Role> roles)
    {
        this.roles = roles;
    }

//    public Freelancer getFreelancer()
//    {
//        return freelancer;
//    }
//
//    public void setFreelancer(Freelancer freelancer)
//    {
//        this.freelancer = freelancer;
//    }
}
