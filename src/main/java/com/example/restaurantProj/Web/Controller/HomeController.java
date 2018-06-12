/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Web.Controller;

import com.example.restaurantProj.Database.Dao.MealRepository;
import com.example.restaurantProj.Database.Model.Meal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Maciej
 */
@Controller
public class HomeController {
    @Autowired
    private MealRepository mealrepo;
    
      @RequestMapping("/home")
    public ModelAndView homeView() {
    ModelAndView mav = new ModelAndView();
    mav.addObject("mealsPl", getMealsByLang("PL"));
    mav.addObject("mealsEN", getMealsByLang("EN"));
    mav.setViewName("home");
    return mav;
  }
    
    private List<Meal> getMealsByLang(String lang){
        return mealrepo.getMealByLang(lang);
    }
    
    
}
