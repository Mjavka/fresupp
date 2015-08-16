package com.mjavka.fresupp.service;

import com.mjavka.fresupp.dao.CustomerDAO;
import java.util.List;


import org.springframework.transaction.annotation.Transactional;

import com.mjavka.fresupp.model.Customer;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerService")
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;
 
    @Override
    @Transactional(readOnly = false)
    public void addCustomer(Customer p) {
        getCustomerDAO().addCustomer(p);
    }

    @Override
    @Transactional(readOnly = false)
    public void updateCustomer(Customer p)
    {
        getCustomerDAO().updateCustomer(p);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteCustomer(Customer p)
    {
        getCustomerDAO().deleteCustomer(p);
    }

    @Override
    public Customer getCustomerByUuid(UUID uuid)
    {
        return getCustomerDAO().getCustomerByUuid(uuid);
    }
    
    @Override
    public List<Customer> listCustomer() {
        return getCustomerDAO().listCustomer();
    }
    
    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }
    	 
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
 
}
