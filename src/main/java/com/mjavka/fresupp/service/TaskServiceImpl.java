package com.mjavka.fresupp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mjavka.fresupp.dao.TaskDAO;
import com.mjavka.fresupp.model.Task;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service("taskService")
@Transactional(readOnly = true)
public class TaskServiceImpl implements TaskService
{

    @Autowired
    private TaskDAO taskDAO;

    @Override
    public void registerNewTask(Task p)
    {
        
        //@TODO preprocess and final validation
        p.setCreationDate(new Date());
        taskDAO.addTask(p);
    }
    
    @Override
    public List<Task> listTask()
    {
        return this.taskDAO.listTask();
    }

    public TaskDAO getTaskDAO()
    {
        return taskDAO;
    }

    public void setTaskDAO(TaskDAO taskDAO)
    {
        this.taskDAO = taskDAO;
    }

}
