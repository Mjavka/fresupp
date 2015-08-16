package com.mjavka.fresupp.service;


import com.mjavka.fresupp.dto.OrderDTO;
import com.mjavka.fresupp.model.Customer;
import com.mjavka.fresupp.model.Order;
import java.util.UUID;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service("orderManipulationService")
@Transactional(readOnly = true)
public class OrderManipulationServiceImpl implements OrderManipulationService
{

    @Autowired
    private OrderService orderService;
    
    @Autowired
    private CustomerService customerService;

    @Override
    @Transactional(readOnly = false)
    public void registerNewOrder(OrderDTO p)
    {
        Order order = new Order();
        
        order.setName(p.getName());
        
        order.setDescription(p.getDescription());
        
        order.setStatus(p.getStatus());
        
        order.setType(p.getType()); //@TODO set other order fields
        
        Customer customer = getCustomerService().getCustomerByUuid(UUID.fromString(p.getCustomerUUID()));
        
        order.setCustomer(customer);
        
        //@TODO preprocess and final validation
        
        orderService.registerNewOrder(order);
    }

    public OrderService getOrderService()
    {
        return orderService;
    }

    public void setOrderService(OrderService orderService)
    {
        this.orderService = orderService;
    }

    public CustomerService getCustomerService()
    {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService)
    {
        this.customerService = customerService;
    }

   

}
