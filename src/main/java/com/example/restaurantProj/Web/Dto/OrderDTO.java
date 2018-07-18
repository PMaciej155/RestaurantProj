/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Web.Dto;

import com.example.restaurantProj.Database.Model.Order;
import com.example.restaurantProj.Database.Model.Order.OrderStatus;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Maciej
 */
public class OrderDTO {
    
    private Long id;
    
    private String client;
    
    private Map<Long, Integer> meals = new HashMap<Long, Integer>();
    
    private OrderStatus status;
    
    private AddressDTO address;
    private float price;
    
    public static OrderDTO fromOrder(Order order) {
        OrderDTO orderdto = new OrderDTO();
        orderdto.setId(order.getId());
        orderdto.setAddress(AddressDTO.fromAddress(order.getAddress()));
        orderdto.setClient(order.getClient().getUsername());
        orderdto.setMeal(order.getMeal().entrySet().stream()
                .collect(Collectors.toMap(
                        e -> e.getKey().getId(),
                        e -> e.getValue())));
        orderdto.setStatus(order.getStatus());
        orderdto.setPrice(order.getPrice());
        return orderdto;
    }

    public boolean isSelected(OrderStatus status) {
    return status.equals(this.status);
    }
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the client
     */
    public String getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(String client) {
        this.client = client;
    }

    /**
     * @return the meal
     */
    public Map<Long, Integer> getMeal() {
        return meals;
    }

    /**
     * @param meal the meal to set
     */
    public void setMeal(Map<Long, Integer> meals) {
        this.meals = meals;
    }

    /**
     * @return the status
     */
    public OrderStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    /**
     * @return the address
     */
    public AddressDTO getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }
}
