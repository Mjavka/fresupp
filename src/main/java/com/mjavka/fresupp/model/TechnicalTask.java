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
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 *
 * @author mjavka
 *
 */
@Entity
@Table(name = "TECHNICAL_TASK_TB")
public class TechnicalTask implements Serializable
{

    public TechnicalTask()
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_ref")
    private Order order;

    //@TODO File attachement
    
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

    public Order getOrder()
    {
        return order;
    }

    public void setOrder(Order order)
    {
        this.order = order;
    }

}
