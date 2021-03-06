/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Database.Dao;

import com.example.restaurantProj.Database.Model.Order;
import com.example.restaurantProj.Database.Model.Order.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Maciej
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
    
    public Order findByStatus(OrderStatus status);
    
     @Override
    void delete(Order order);
}
