/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.persistence.Table;


//database layer representation of Category
@Entity
@Table(name="Categories")
public class Category implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;
    
//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                CascadeType.PERSIST,
//                CascadeType.MERGE
//            },
//            mappedBy = "category")
//    private List<Meal> meals;


    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Category(){
//        meals = new ArrayList<Meal>();
//    }
//
//    /**
//     * @return the meals
//     */
//    public List<Meal> getMeals() {
//        return meals;
//    }
//
//    /**
//     * @param meals the meals to set
//     */
//    public void setMeals(ArrayList<Meal> meals) {
//        this.meals = meals;
//    }

@Override
public boolean equals(Object object)
{
    boolean isEqual= false;

    if (object != null && object instanceof Category)
    {
        isEqual = (this.id == ((Category) object).id);
    }

    return isEqual;
}



   
    
}
