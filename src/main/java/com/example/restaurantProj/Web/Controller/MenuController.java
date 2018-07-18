/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Web.Controller;

import com.example.restaurantProj.Database.Model.Meal;
import com.example.restaurantProj.Database.Model.Meal.MealType;
import com.example.restaurantProj.Service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Maciej
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MealService mealservice;
    
    @GetMapping
    public ModelAndView getMenuView(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("breakfast", mealservice.getMealByType(MealType.BREAKFAST));
        mav.addObject("dinner", mealservice.getMealByType(MealType.DINNER));
        mav.addObject("brunch", mealservice.getMealByType(MealType.BRUNCH));
        mav.addObject("supper", mealservice.getMealByType(MealType.SUPPER));
        mav.setViewName("menu");
        return mav;
    }
    
    
}
