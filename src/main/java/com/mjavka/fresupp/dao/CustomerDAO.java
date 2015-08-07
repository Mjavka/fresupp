package com.mjavka.fresupp.dao;

import com.mjavka.fresupp.model.Customer;
import java.util.List;
import java.util.UUID;

 
public interface CustomerDAO {
 
    public void addCustomer(Customer p);
    public void updateCustomer(Customer p);
    public void deleteCustomer(Customer p);
    public Customer getCustomerByUuid(UUID uuid);
    public List<Customer> listCustomer();
}