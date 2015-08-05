package com.mjavka.fresupp.dao;

import com.mjavka.fresupp.model.Manager;
import java.util.List;

 
public interface ManagerDAO {
 
    public void addManager(Manager p);
    public List<Manager> listManager();
}