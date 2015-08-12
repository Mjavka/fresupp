package com.mjavka.fresupp.service;

import com.mjavka.fresupp.model.Order;
import java.util.List;

 
public interface OrderService {
 
    public void registerNewOrder(Order p);
    
    public List<Order> listOrder();
     
}