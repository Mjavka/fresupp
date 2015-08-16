package com.mjavka.fresupp.service;


import com.mjavka.fresupp.dto.TaskDTO;
import com.mjavka.fresupp.model.Task;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service("taskManipulationService")
@Transactional(readOnly = true)
public class TaskManipulationServiceImpl implements TaskManipulationService
{

    @Autowired
    private TaskService taskService;
    

    @Override
    @Transactional(readOnly = false)
    public void registerNewTask(TaskDTO p)
    {
        Task task = new Task();
        
        task.setName(p.getName());
        
        task.setDescription(p.getDescription());
        
        task.setStatus(p.getStatus());
        
        task.setType(p.getType()); //@TODO set other task fields
        
        //@TODO preprocess and final validation
        
        getTaskService().registerNewTask(task);
    }

    public TaskService getTaskService()
    {
        return taskService;
    }

    public void setTaskService(TaskService taskService)
    {
        this.taskService = taskService;
    }

        

   

}
