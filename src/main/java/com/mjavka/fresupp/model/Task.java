package com.mjavka.fresupp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

    private UUID uuid;

    private String name;
    
    private String description;
    
    private String type;
    
    private Integer status;
    
    private Date creationDate;
    
    private Date deadlineDate;
    
    private Order order;
    
    private List<Solution> solutions;
    
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "object_uuid", unique = true)
    @Type(type = "pg-uuid")
    public UUID getUuid()
    {
        return uuid;
    }

    public void setUuid(UUID uuid)
    {
        this.uuid = uuid;
    }

    @Column(name = "name")
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Column(name = "creation_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getCreationDate()
    {
        return creationDate;
    }

    public void setCreationDate(Date creationDate)
    {
        this.creationDate = creationDate;
    }

    @Column(name = "deadline_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getDeadlineDate()
    {
        return deadlineDate;
    }

    public void setDeadlineDate(Date deadlineDate)
    {
        this.deadlineDate = deadlineDate;
    }

    @ManyToOne(targetEntity = Order.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_ref")
    public Order getOrder()
    {
        return order;
    }

    public void setOrder(Order order)
    {
        this.order = order;
    }

    @Column(name = "task_type")
    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    @Column(name = "status")
    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "task", cascade = CascadeType.ALL)
    public List<Solution> getSolutions()
    {
        return solutions;
    }

    public void setSolutions(List<Solution> solutions)
    {
        this.solutions = solutions;
    }



}
