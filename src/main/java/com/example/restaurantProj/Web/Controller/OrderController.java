/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Web.Controller;

import com.example.restaurantProj.Service.OrderService;
import com.example.restaurantProj.Web.Dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Maciej
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    
    @DeleteMapping("/{numberOrder}/delete")
    public void deleteOrder(@PathVariable("numberOrder") Long numberOrder) {
        orderService.deleteOrder(numberOrder);

    }
    
    @PutMapping("/{numberOrder}/update")
    public void updateOrder(@PathVariable("numberOrder") Long numberOrder,
            @RequestParam("status") String status){
        orderService.modifyOrderStatus(numberOrder, status);
    }

    @PostMapping()
    public ModelAndView addOrder() {
        ModelAndView mav = new ModelAndView();
        //mav.addObject("order",);
        return mav;
    }

    @GetMapping("/{numberOrder}")
    public ModelAndView showOrderDetails(@PathVariable("numberOrder") Long numberOrder) {
        ModelAndView mav = new ModelAndView();
        return mav;
    }

}
