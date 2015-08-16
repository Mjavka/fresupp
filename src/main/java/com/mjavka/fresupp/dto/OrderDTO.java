package com.mjavka.fresupp.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 *
 * @author mjavka
 *
 */
public class OrderDTO implements Serializable
{

    public OrderDTO()
    {

    }

    private java.util.UUID uuid;

    private String name;

    private String description;
    
    private String type;
    
    private Date creationDate;
    
    private Date deadlineDate;

    private Integer status;
    
    private UUID ttUuid;
    
    private UUID customerUUID;

    private List<UUID> taskUUIDList = new ArrayList<UUID>(0);
    
    private List<UUID> freelancersUUIDList = new ArrayList<UUID>();
    
    private List<UUID> managerUUIDList = new ArrayList<UUID>();
    
    
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

    public UUID getTtUuid()
    {
        return ttUuid;
    }

    public void setTtUuid(UUID ttUuid)
    {
        this.ttUuid = ttUuid;
    }

    public List<UUID> getTaskUUIDList()
    {
        return taskUUIDList;
    }

    public void setTaskUUIDList(List<UUID> taskUUIDList)
    {
        this.taskUUIDList = taskUUIDList;
    }

    public List<UUID> getFreelancersUUIDList()
    {
        return freelancersUUIDList;
    }

    public void setFreelancersUUIDList(List<UUID> freelancersUUIDList)
    {
        this.freelancersUUIDList = freelancersUUIDList;
    }

    public List<UUID> getManagerUUIDList()
    {
        return managerUUIDList;
    }

    public void setManagerUUIDList(List<UUID> managerUUIDList)
    {
        this.managerUUIDList = managerUUIDList;
    }

    public UUID getCustomerUUID()
    {
        return customerUUID;
    }

    public void setCustomerUUID(UUID customerUUID)
    {
        this.customerUUID = customerUUID;
    }

    
}
