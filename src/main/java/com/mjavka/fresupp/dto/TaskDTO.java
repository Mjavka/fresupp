package com.mjavka.fresupp.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import java.util.UUID;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author mjavka
 *
 */
public class TaskDTO implements Serializable
{
    public TaskDTO()
    {
        
    }

    private UUID uuid;

    private String name;
    
    private String description;
    
    private Date creationDate;
    
    private Date deadlineDate;
    
    private Integer status;
    
    private String type;
    
    private UUID orderUuid;
    
    private List<UUID> taskUuidList;
        
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

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public UUID getOrderUuid()
    {
        return orderUuid;
    }

    public void setOrderUuid(UUID orderUuid)
    {
        this.orderUuid = orderUuid;
    }

    public List<UUID> getTaskUuidList()
    {
        return taskUuidList;
    }

    public void setTaskUuidList(List<UUID> taskUuidList)
    {
        this.taskUuidList = taskUuidList;
    }



}
