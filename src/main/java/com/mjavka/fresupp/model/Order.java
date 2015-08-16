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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "ORDER_TB")
public class Order implements Serializable
{

    public Order()
    {

    }

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "object_uuid", unique = true)
    @Type(type = "pg-uuid")
    private java.util.UUID uuid;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
    
    @Column(name = "type")
    private String type;
    
    @Column(name = "creation_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date creationDate;
    
    @Column(name = "deadline_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date deadlineDate;

    @Column(name = "status")
    private Integer status;
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
    private TechnicalTask tt;

    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "ORDER_TASK_REF",
            joinColumns =
            {

                @JoinColumn(name = "order_uuid", referencedColumnName = "object_uuid")
            },
            inverseJoinColumns =
            {

                @JoinColumn(name = "task_uuid", referencedColumnName = "object_uuid")
            }
    )
    private List<Task> taskList = new ArrayList<Task>(0);

    public void addTask(Task b)
    {
        if (b != null)
        {
            if (getTaskList().contains(b))
            {
                getTaskList().set(getTaskList().indexOf(b), b);
            } else
            {
                getTaskList().add(b);
            }
        }
    }

    public void removeTask(Task b)
    {
        getTaskList().remove(b);
        b.setOrder(null);
    }
    
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "ORDER_FREELANCER_REF",
            joinColumns =
            {

                @JoinColumn(name = "order_uuid", referencedColumnName = "object_uuid")
            },
            inverseJoinColumns =
            {

                @JoinColumn(name = "freelancer_uuid", referencedColumnName = "object_uuid")
            }
    )
    private List<Freelancer> freelancersList = new ArrayList<Freelancer>();
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "ORDER_MANAGER_REF",
            joinColumns =
            {

                @JoinColumn(name = "order_uuid", referencedColumnName = "object_uuid")
            },
            inverseJoinColumns =
            {

                @JoinColumn(name = "manager_uuid", referencedColumnName = "object_uuid")
            }
    )
    private List<Manager> managerList = new ArrayList<Manager>();
    
    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
    @JoinTable(name="CUSTOMER_ORDER_REF",
        joinColumns = {
            
            @JoinColumn(name="order_uuid", referencedColumnName = "object_uuid")},
        
        inverseJoinColumns = {
            
            @JoinColumn(name="customer_uuid", referencedColumnName = "object_uuid")
        }
    )
    private Customer customer;
    
    
    public java.util.UUID getUuid()
    {
        return uuid;
    }

    public void setUuid(java.util.UUID uuid)
    {
        this.uuid = uuid;
    }

    @Override
    public String toString()
    {
        return "uuid=" + uuid + ", name=" + getName();
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

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
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

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public List<Task> getTaskList()
    {
        return taskList;
    }

    public void setTaskList(List<Task> taskList)
    {
        this.taskList = taskList;
    }

    public TechnicalTask getTt()
    {
        return tt;
    }

    public void setTt(TechnicalTask tt)
    {
        this.tt = tt;
    }

    public List<Freelancer> getFreelancersList()
    {
        return freelancersList;
    }

    public void setFreelancersList(List<Freelancer> freelancersList)
    {
        this.freelancersList = freelancersList;
    }

    public List<Manager> getManagerList()
    {
        return managerList;
    }

    public void setManagerList(List<Manager> managerList)
    {
        this.managerList = managerList;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    
}
