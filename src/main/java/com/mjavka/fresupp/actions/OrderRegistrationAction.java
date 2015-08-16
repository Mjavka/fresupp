package com.mjavka.fresupp.actions;

import com.mjavka.fresupp.dto.OrderDTO;
import com.mjavka.fresupp.service.OrderManipulationService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author mjavka
 */
@ManagedBean(name = "orderRegistrationAction")
@ViewScoped
public class OrderRegistrationAction
{
    
    private static final Logger logger = LoggerFactory.getLogger(OrderRegistrationAction.class);
    
    @ManagedProperty(value = "#{orderManipulationService}")
    private OrderManipulationService orderManipulationService;

    private OrderDTO orderDTO = new OrderDTO();

    public String register()
    {
        try
        {
            getOrderManipulationService().registerNewOrder(orderDTO);
        } catch (Exception ex)
        {
            logger.error("error registering ", ex);
            
            return "incorrect";
        }
        return "correct";
    }

    public String cancel()
    {
        return null;
    }

    public String logout()
    {
        SecurityContextHolder.clearContext();
        return "loggedout";
    }

    public OrderDTO getOrderDTO()
    {
        return orderDTO;
    }

    public void setOrderDTO(OrderDTO orderDTO)
    {
        this.orderDTO = orderDTO;
    }

    public OrderManipulationService getOrderManipulationService()
    {
        return orderManipulationService;
    }

    public void setOrderManipulationService(OrderManipulationService orderManipulationService)
    {
        this.orderManipulationService = orderManipulationService;
    }

}
