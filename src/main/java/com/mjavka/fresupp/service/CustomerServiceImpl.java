package com.mjavka.fresupp.service;

import com.mjavka.fresupp.dao.CustomerDAO;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mjavka.fresupp.model.Customer;

@Service
@ManagedBean(name="customerService")
@SessionScoped
public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customerDAO;
	 
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
 
    @Override
    @Transactional
    public void addCustomer(Customer p) {
        this.customerDAO.addCustomer(p);
    }
 
    @Override
    @Transactional
    public List<Customer> listCustomer() {
        return this.customerDAO.listCustomer();
    }
 
}
