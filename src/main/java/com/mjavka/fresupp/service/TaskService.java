package com.mjavka.fresupp.service;

import com.mjavka.fresupp.model.Task;
import java.util.List;

 
public interface TaskService {
 
    public void registerNewTask(Task p);
    
    public List<Task> listTask();
     
}