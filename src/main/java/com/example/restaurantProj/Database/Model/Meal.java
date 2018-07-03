/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Database.Model;

import com.example.restaurantProj.Web.Dto.MealDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Maciej
 */
//database layer representation of Meal
@Entity
@Table(name = "meals")
public class Meal implements Serializable {

    public static enum MealType {
        BREAKFAST,
        DINNER,
        SOUP,
        SUPPER;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private float price;
    
    @Enumerated(EnumType.STRING)
    private MealType type;
    

    

    public Meal(String name, float price, MealType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public static Meal fromMealDTO(MealDTO mealdto) {
        return new Meal(mealdto.getName(),
                mealdto.getPrice(),
                mealdto.getType());
    }

    public Meal() {
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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

    /**
     * @return the type
     */
    public MealType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(MealType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return getName() + " = " + getPrice();
    }

}
