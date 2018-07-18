/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Database.Dao;

import com.example.restaurantProj.Database.Model.Meal;
import com.example.restaurantProj.Database.Model.Meal.MealType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Maciej
 */
@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

    Meal findByName(String name);
    
    List<Meal> findByType(MealType type);
    
    @Query("SELECT m FROM Meal m WHERE m.id = ?1 ")
    Meal findId(Long id);

    @Override
    void delete(Meal meal);
}
