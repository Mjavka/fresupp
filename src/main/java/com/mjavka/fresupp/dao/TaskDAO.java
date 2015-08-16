package com.mjavka.fresupp.dao;

import java.util.List;

import com.mjavka.fresupp.model.Task;
 
public interface TaskDAO {
 
    public void addTask(Task p);
    
    public List<Task> listTask();
    
}