/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Web.Dto;

import com.example.restaurantProj.Database.Model.Meal;
import com.example.restaurantProj.Database.Model.Meal.MealType;

/**
 *
 * @author Maciej
 */
//REST layer representation of Meal
public class MealDTO {

    
    private Long Id;
    private String name;
    private String description;
    private float price;
    private MealType type;

    public static MealDTO fromMeal(Meal meal){
        MealDTO dto = new MealDTO();
        dto.setId(meal.getId());
        dto.setName(meal.getName());
        dto.setDescription(meal.getDescription());
        dto.setType(meal.getType());
        dto.setPrice(meal.getPrice());
        return dto;
    }
     /**
     * @return the Id
     */
    public Long getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(Long Id) {
        this.Id = Id;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

}
