package com.mjavka.fresupp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mjavka.fresupp.dao.OrderDAO;
import com.mjavka.fresupp.model.Order;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service("orderService")
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService
{

    @Autowired
    private OrderDAO orderDAO;

    @Override
    public void registerNewOrder(Order p)
    {
        
        //@TODO preprocess and final validation
        p.setCreationDate(new Date());
        orderDAO.addOrder(p);
    }
    
    @Override
    public List<Order> listOrder()
    {
        return this.orderDAO.listOrder();
    }

    public OrderDAO getOrderDAO()
    {
        return orderDAO;
    }

    public void setOrderDAO(OrderDAO orderDAO)
    {
        this.orderDAO = orderDAO;
    }

}
