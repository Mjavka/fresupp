package com.mjavka.fresupp.actions;

import com.mjavka.fresupp.dto.TaskDTO;
import com.mjavka.fresupp.service.TaskManipulationService;
import java.util.UUID;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author mjavka
 */
@ManagedBean(name = "taskRegistrationAction")
@ViewScoped
public class TaskRegistrationAction
{
    
    private static final Logger logger = LoggerFactory.getLogger(TaskRegistrationAction.class);
    
    @ManagedProperty(value = "#{taskManipulationService}")
    private TaskManipulationService taskManipulationService;

    private TaskDTO taskDTO = new TaskDTO();
    
    private String orderUuidString;

    public String register()
    {
        try
        {
            getTaskDTO().setOrderUuid(UUID.fromString(orderUuidString));
            
            getTaskManipulationService().registerNewTask(getTaskDTO());
        } catch (Exception ex)
        {
            logger.error("error registering ", ex);
            
            return "incorrect";
        }
        return "correct";
    }

    public String cancel()
    {
        return null;
    }

    public String logout()
    {
        SecurityContextHolder.clearContext();
        return "loggedout";
    }

    public TaskManipulationService getTaskManipulationService()
    {
        return taskManipulationService;
    }

    public void setTaskManipulationService(TaskManipulationService taskManipulationService)
    {
        this.taskManipulationService = taskManipulationService;
    }

    public TaskDTO getTaskDTO()
    {
        return taskDTO;
    }

    public void setTaskDTO(TaskDTO taskDTO)
    {
        this.taskDTO = taskDTO;
    }

    public String getOrderUuidString()
    {
        return orderUuidString;
    }

    public void setOrderUuidString(String orderUuidString)
    {
        this.orderUuidString = orderUuidString;
    }

}
