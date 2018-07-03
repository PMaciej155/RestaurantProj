/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Api;

import com.example.restaurantProj.Database.Model.Meal;
import com.example.restaurantProj.Database.Dao.MealRepository;
import com.example.restaurantProj.Service.MealService;
import com.example.restaurantProj.Web.Dto.MealDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/meal")
public class MealRESTapi {

    @Autowired
    MealService mealService;

    @RequestMapping("/hello")
    @ResponseBody
    public MealDTO hello() {
        return mealService.getMeal("Szakszuka");
    }

    @GetMapping
    @ResponseBody
    public List<MealDTO> getMeals() {
        return mealService.getMeals();
    }
    
    
    

//    @RequestMapping("/menuBy")
//    @ResponseBody
//    public List<Meal> filter(@RequestParam("vege") Boolean vegetarian,
//            @RequestParam("gluten") Boolean glutenfree) {
//        List<Meal> nList = new ArrayList<Meal>();
//        List<Meal> meals = mealrepo.getMealByLang("PL");
//
//        for (Meal m : meals) {
//            if (vegetarian == m.getCategory().contains(vege)
//                    && glutenfree == m.getCategory().contains(gluten)) {
//                nList.add(m);
//            }
//        }
//        return nList;
//    }
//    @RequestMapping("/countedMenu/{number}")
//    @ResponseBody
//    public List<MealDTO> countedMenu(@PathVariable("number") int number) {
//        return mealService.countedMenuTo(number);
//    }
    @PostMapping("/add")
    @ResponseBody
    public void requestBodyExample(@RequestBody MealDTO mealdto) {
        mealService.addMeal(mealdto);
    }

}
