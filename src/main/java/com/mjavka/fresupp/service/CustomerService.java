package com.mjavka.fresupp.service;

import com.mjavka.fresupp.model.Customer;
import java.util.List;

 
public interface CustomerService {
 
    public void addCustomer(Customer p);
    public List<Customer> listCustomer();
     
}