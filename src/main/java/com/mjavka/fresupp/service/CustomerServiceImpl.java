package com.mjavka.fresupp.service;

import com.mjavka.fresupp.dao.CustomerDAO;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mjavka.fresupp.model.Customer;
import java.util.UUID;

@Service
@ManagedBean(name="customerService")
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customerDAO;
	 
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
 
    @Override
    @Transactional(readOnly = false)
    public void addCustomer(Customer p) {
        this.customerDAO.addCustomer(p);
    }

    @Override
    @Transactional(readOnly = false)
    public void updateCustomer(Customer p)
    {
        this.customerDAO.updateCustomer(p);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteCustomer(Customer p)
    {
        this.customerDAO.deleteCustomer(p);
    }

    @Override
    public Customer getCustomerByUuid(UUID uuid)
    {
        return this.customerDAO.getCustomerByUuid(uuid);
    }
    
    @Override
    public List<Customer> listCustomer() {
        return this.customerDAO.listCustomer();
    }
 
}
