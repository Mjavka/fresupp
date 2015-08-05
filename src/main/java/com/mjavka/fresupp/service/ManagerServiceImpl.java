package com.mjavka.fresupp.service;

import com.mjavka.fresupp.dao.ManagerDAO;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mjavka.fresupp.model.Manager;

@Service
@ManagedBean(name="managerService")
@SessionScoped
public class ManagerServiceImpl implements ManagerService {

	private ManagerDAO managerDAO;
	 
    public void setManagerDAO(ManagerDAO customerDAO) {
        this.managerDAO = customerDAO;
    }
 
    @Override
    @Transactional
    public void addManager(Manager p) {
        this.managerDAO.addManager(p);
    }
 
    @Override
    @Transactional
    public List<Manager> listManager() {
        return this.managerDAO.listManager();
    }
 
}
