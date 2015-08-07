package com.mjavka.fresupp.service;

import com.mjavka.fresupp.model.Customer;
import java.util.List;
import java.util.UUID;

 
public interface CustomerService {
 
    public void addCustomer(Customer p);
    public void updateCustomer(Customer p);
    public void deleteCustomer(Customer p);
    public Customer getCustomerByUuid(UUID uuid);
    public List<Customer> listCustomer();
     
}