package com.mjavka.fresupp.dao;

import java.util.List;

import com.mjavka.fresupp.model.Order;
 
public interface OrderDAO {
 
    public void addOrder(Order p);
    
    public List<Order> listOrder();
    
}