/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Service;

import com.example.restaurantProj.Database.Dao.MealRepository;
import com.example.restaurantProj.Database.Dao.OrderRepository;
import com.example.restaurantProj.Database.Dao.TableRepository;
import com.example.restaurantProj.Database.Dao.UserRepository;
import com.example.restaurantProj.Database.Model.Order;
import com.example.restaurantProj.Web.Dto.OrderDTO;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Maciej
 */
@Service
public class OrderService {
    
    @Autowired
    TableRepository tablerepository;
    
    @Autowired
    UserRepository userrepository;
    
    @Autowired
    OrderRepository orderrepository;
    
    @Autowired
    MealRepository mealrepository;
    
    @Transactional
    public void makeOrder(OrderDTO orderdto) {
        
        Order order = new Order()
                .withClient(userrepository.findByUsername(orderdto.getClient()))
                .withMeal(mealrepository.findByName(orderdto.getMeal()))
                .withQuantity(orderdto.getQuantity())
                .withTable(tablerepository.findByNumberTable(orderdto.getTable()))
                .withStatus(Order.Status.ACCEPTED);
        orderrepository.save(order);
        
    }
    
    @Transactional
    public void modifyOrderStatus(Long numbrOrder, String status) {
        Order order = orderrepository.findByNumberOrder(numbrOrder);
        orderrepository.save(order
                .withStatus(Order.Status.valueOf(status)));
    }
    
    @Transactional
    public void deleteOrder(Long numbrOrder) {
        Order order = orderrepository.findByNumberOrder(numbrOrder);
        orderrepository.delete(order);
    }
    
}
