/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Web.Dto;

import com.example.restaurantProj.Database.Model.Order;

/**
 *
 * @author Maciej
 */
public class OrderDTO {

    private Long numberOrder;

    private Long table;

    private String client;

    private String meal;

    private long quantity;
    
    private String status;
    
    public static OrderDTO fromOrder(Order order){
        OrderDTO orderdto = new OrderDTO();
        orderdto.setNumberOrder(order.getNumberOrder());
        orderdto.setTable(order.getTable().getNumberTable());
        orderdto.setClient(order.getClient().getUsername());
        orderdto.setMeal(order.getMeal().getName());
        orderdto.setQuantity(order.getQuantity());
        orderdto.setStatus(order.getStatus().name());
        return orderdto;
    }

    /**
     * @return the numberOrder
     */
    public Long getNumberOrder() {
        return numberOrder;
    }

    /**
     * @param numberOrder the numberOrder to set
     */
    public void setNumberOrder(Long numberOrder) {
        this.numberOrder = numberOrder;
    }

    /**
     * @return the table
     */
    public Long getTable() {
        return table;
    }

    /**
     * @param table the table to set
     */
    public void setTable(Long table) {
        this.table = table;
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
    public String getMeal() {
        return meal;
    }

    /**
     * @param meal the meal to set
     */
    public void setMeal(String meal) {
        this.meal = meal;
    }

    /**
     * @return the quantity
     */
    public long getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
