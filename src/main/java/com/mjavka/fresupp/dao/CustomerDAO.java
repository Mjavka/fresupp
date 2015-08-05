package com.mjavka.fresupp.dao;

import com.mjavka.fresupp.model.Customer;
import java.util.List;

 
public interface CustomerDAO {
 
    public void addCustomer(Customer p);
    public List<Customer> listCustomer();
}