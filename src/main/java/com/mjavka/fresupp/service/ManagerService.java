package com.mjavka.fresupp.service;

import com.mjavka.fresupp.model.Manager;
import java.util.List;

 
public interface ManagerService {
 
    public void addManager(Manager p);
    public List<Manager> listManager();
     
}