package com.mjavka.fresupp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import java.util.UUID;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author mjavka
 *
 */
@Entity
@Table(name = "TASK_TB")
public class Task implements Serializable
{
    public Task()
    {
        
    }

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "object_uuid", unique = true)
    @Type(type = "pg-uuid")
    private UUID uuid;

    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "creation_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date creationDate;
    
    @Column(name = "deadline_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date deadlineDate;
    
    
    @ManyToOne(targetEntity = Login.class)
    @JoinTable(name="ORDER_TASK_REF",
        joinColumns = {
            
            @JoinColumn(name="task_uuid", referencedColumnName = "object_uuid")},
        
        inverseJoinColumns = {
            
            @JoinColumn(name="order_uuid", referencedColumnName = "object_uuid")
        }
    )
    private Order order;
        
    public UUID getUuid()
    {
        return uuid;
    }

    public void setUuid(UUID uuid)
    {
        this.uuid = uuid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getCreationDate()
    {
        return creationDate;
    }

    public void setCreationDate(Date creationDate)
    {
        this.creationDate = creationDate;
    }

    public Date getDeadlineDate()
    {
        return deadlineDate;
    }

    public void setDeadlineDate(Date deadlineDate)
    {
        this.deadlineDate = deadlineDate;
    }

    public Order getOrder()
    {
        return order;
    }

    public void setOrder(Order order)
    {
        this.order = order;
    }



}
