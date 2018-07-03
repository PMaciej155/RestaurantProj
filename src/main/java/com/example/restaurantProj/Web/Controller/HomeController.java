/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Web.Controller;

import com.example.restaurantProj.Service.MealService;
import com.example.restaurantProj.Web.Dto.MealDTO;
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
    private MealService mealService;
    
      @RequestMapping("/home")
    public ModelAndView homeView() {
    ModelAndView mav = new ModelAndView();
    mav.addObject("meals", getMeals());
    mav.setViewName("home");
    return mav;
  }
    
    private List<MealDTO> getMeals(){
        return mealService.getMeals();
    }
    
    
}
