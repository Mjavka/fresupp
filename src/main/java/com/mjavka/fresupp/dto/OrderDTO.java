package com.mjavka.fresupp.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    
    private TechnicalTaskDTO tt;
    
    private String customerUUID;

    private List<TaskDTO> taskList = new ArrayList<TaskDTO>(0);

    public void addTask(TaskDTO b)
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

    public void removeTask(TaskDTO b)
    {
        getTaskList().remove(b);
        b.setOrder(null);
    }
    
    private List<FreelancerDTO> freelancersList = new ArrayList<FreelancerDTO>();
    
    private List<ManagerDTO> managerList = new ArrayList<ManagerDTO>();
    
    
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

    public TechnicalTaskDTO getTt()
    {
        return tt;
    }

    public void setTt(TechnicalTaskDTO tt)
    {
        this.tt = tt;
    }

    public List<TaskDTO> getTaskList()
    {
        return taskList;
    }

    public void setTaskList(List<TaskDTO> taskList)
    {
        this.taskList = taskList;
    }

    public List<FreelancerDTO> getFreelancersList()
    {
        return freelancersList;
    }

    public void setFreelancersList(List<FreelancerDTO> freelancersList)
    {
        this.freelancersList = freelancersList;
    }

    public List<ManagerDTO> getManagerList()
    {
        return managerList;
    }

    public void setManagerList(List<ManagerDTO> managerList)
    {
        this.managerList = managerList;
    }

    public String getCustomerUUID()
    {
        return customerUUID;
    }

    public void setCustomerUUID(String customerUUID)
    {
        this.customerUUID = customerUUID;
    }

    
}
