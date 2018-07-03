/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Api;

import com.example.restaurantProj.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Maciej
 */
@RestController
@RequestMapping("/api/order")
public class OrderRESTapi {
    
    @Autowired
    OrderService service;
    
    @PostMapping("/add")
    public void addOrder(){
        
    }
    @DeleteMapping("/{numberOrder}")
    public void deleteOrder(@PathVariable("numberOrder") Long numberOrder){
        
    }
    
    @GetMapping("/{numberOrder}")
    public void getDetailsOrder(@PathVariable("numberOrder") Long numberOrder){
        
    }
    
    @GetMapping()
    public void getOrders(){
        
    }
    
    @PutMapping("/{numberOrder}")
    public void changeStatusOrder(@PathVariable("numberOrder") Long numberOrder){
        
    }
}
