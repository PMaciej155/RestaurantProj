/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Web.Controller;

import com.example.restaurantProj.Database.Model.Order;
import com.example.restaurantProj.Database.Model.Order.OrderStatus;
import com.example.restaurantProj.Service.MealService;
import com.example.restaurantProj.Service.OrderService;
import com.example.restaurantProj.Web.Dto.MealDTO;
import com.example.restaurantProj.Web.Dto.OrderDTO;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Maciej
 */
@Controller
@RequestMapping("/order")
public class OrderListController {

    @Autowired
    OrderService service;
    
    @Autowired
    MealService mealService;

    @GetMapping
    public ModelAndView getOrderList() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("orders", service.getAllOrders());
        mav.setViewName("orders");
        return mav;
    }
    
//    @GetMapping("/{id}")
//    public ModelAndView getDetails(@PathVariable("id") Long id) {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("order", service.getOrderDetails(id));
//        mav.addObject("meals", service.getMapMealDTO(service.getOrderDetails(id).getMeal()));
//        mav.setViewName("order");
//        return mav;
//    }

    @DeleteMapping("/{id}/delete")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteOrder(@PathVariable("id") Long id) {
        service.deleteOrder(id);
    }

    @PutMapping("/{numberOrder}")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateOrder(@PathVariable("numberOrder") Long numberOrder,
            @RequestParam("status") String status) {
        service.modifyOrderStatus(numberOrder, OrderStatus.valueOf(status.toUpperCase()));
    }
}
