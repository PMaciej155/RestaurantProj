/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Service;

import com.example.restaurantProj.Database.Dao.MealRepository;
import com.example.restaurantProj.Database.Model.Meal;
import com.example.restaurantProj.Database.Model.Meal.MealType;
import com.example.restaurantProj.Web.Dto.MealDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

/**
 *
 * @author Maciej
 */
@Service

public class MealService {

    @Autowired
    private MealRepository mealrepo;
    
    @Transactional
    public MealDTO getMeal(Long id) {
        return MealDTO.fromMeal(mealrepo.findById(id).get());
    }
    
    @Transactional
    public List<MealDTO> getMealByType(MealType type) {
        List<MealDTO> meals = mealrepo.findByType(type).stream()
                .map(x -> MealDTO.fromMeal(x))
                .collect(Collectors.toList());
        return meals;
    }

    @Transactional
    public List<MealDTO> getMeals(){
        return mealrepo.findAll().stream()
                .map(x -> MealDTO.fromMeal(x))
               .collect(Collectors.toList());
    }

    @Transactional
    public void addMeal(MealDTO mealdto) {
        mealrepo.save(Meal.fromMealDTO(mealdto));
    }
}
