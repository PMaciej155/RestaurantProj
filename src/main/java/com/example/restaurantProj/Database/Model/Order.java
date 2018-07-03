/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Database.Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Maciej
 */
@Entity
@Table(name = "orders")
public class Order implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private Long numberOrder;
    
    @ManyToOne
    private RestaurantTable table;
    
    @ManyToOne
    private User client;
    
    @ManyToOne
    private Meal meal;
    
    private long quantity;
    
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status{
       ACCEPTED, WAITING, DONE;
    }
    
    public Order(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public Order withNumberOrder(Long numberOrder) {
        this.numberOrder = numberOrder;
        return this;
    }

    /**
     * @return the table
     */
    public RestaurantTable getTable() {
        return table;
    }

    /**
     * @param table the table to set
     */
    public Order withTable(RestaurantTable table) {
        this.table = table;
        return this;
    }

    /**
     * @return the client
     */
    public User getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public Order withClient(User client) {
        this.client = client;
        return this;
    }

    /**
     * @return the meal
     */
    public Meal getMeal() {
        return meal;
    }

    /**
     * @param meal the meal to set
     */
    public Order withMeal(Meal meal) {
        this.meal = meal;
        return this;
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
    public Order withQuantity(long quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public Order withStatus(Status status) {
        this.status = status;
        return this;
    }
    
}
