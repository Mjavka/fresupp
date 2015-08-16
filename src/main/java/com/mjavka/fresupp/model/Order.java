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

    
    private java.util.UUID uuid;

    
    private String name;

    private String description;
    
    
    private String type;
    
    private Date creationDate;
    
    private Date deadlineDate;

    
    private Integer status;
    
    private TechnicalTask tt;

    
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
    
    
    private List<Freelancer> freelancersList = new ArrayList<Freelancer>();
    
    private List<Manager> managerList = new ArrayList<Manager>();
    
    private Customer customer;
    
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "object_uuid", unique = true)
    @Type(type = "pg-uuid")
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

    @Column(name = "type")
    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
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

    @Column(name = "status")
    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

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
    public List<Task> getTaskList()
    {
        return taskList;
    }

    public void setTaskList(List<Task> taskList)
    {
        this.taskList = taskList;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
    public TechnicalTask getTt()
    {
        return tt;
    }

    public void setTt(TechnicalTask tt)
    {
        this.tt = tt;
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
    public List<Freelancer> getFreelancersList()
    {
        return freelancersList;
    }

    public void setFreelancersList(List<Freelancer> freelancersList)
    {
        this.freelancersList = freelancersList;
    }

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
    public List<Manager> getManagerList()
    {
        return managerList;
    }

    public void setManagerList(List<Manager> managerList)
    {
        this.managerList = managerList;
    }

    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_ref")
    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    
}
