/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Database.Model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
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
    
    
    @ManyToOne
    private Address address;
    
    @ManyToOne
    private User client;
    private float price;
    
    @ElementCollection
    @CollectionTable(name="MEAL_QUANTITY")
    @MapKeyJoinColumn(name="MEAL_ID")
    @Column(name="QUANTITY")
    private Map<Meal, Integer> meals = new HashMap<Meal, Integer>();
    
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public static enum OrderStatus{
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
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public Order withAddress(Address address) {
        this.address = address;
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
    public Map<Meal, Integer> getMeal() {
        return meals;
    }

    /**
     * @param meal the meal to set
     */
    public Order withMeal(Map<Meal, Integer> meals) {
        this.meals = meals;
        return this;
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
    public Order withStatus(OrderStatus status) {
        this.status = status;
        return this;
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
