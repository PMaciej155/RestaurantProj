package com.example.restaurantProj;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.example.restaurantProj.Database.Category;
import com.example.restaurantProj.Database.MealRepository;
import com.example.restaurantProj.Database.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Maciej
 */
//@Service 
public class MealManager {

    

    //@Autowired
    private CategoryRepository catrepo;
    
    //@Autowired
    private MealRepository mealrepoPL;
    
    //@Autowired
    private MealRepository mealrepoEN;
    
    //@Autowired
    private MealRepository mealrepoIN;

    public MealManager() {
        Category vege = new Category();
        vege.setName("Vegetarian");
        catrepo.save(vege);
        Category notvege = new Category();
        vege.setName("Not Vegetarian");
        catrepo.save(vege);
        Category gluten = new Category();
        vege.setName("Gluten Free");
        catrepo.save(gluten);
        Category notgluten = new Category();
        vege.setName("Not Gluten Free");
        catrepo.save(gluten);
        
//        mealrepoPL.save(new Meal("Schabowy", (float) 13.54, notvege, gluten));
//        mealrepoPL.save(new Meal("Fasolka po bretońsku", (float) 65.43, notvege, notgluten));
//        mealrepoPL.save(new Meal("Sałatka", (float) 13.54, vege, notgluten));
//        mealrepoPL.save(new Meal("Ciastko", (float) 13.54, vege, notgluten));
//
//        mealrepoEN.save(new Meal("Schabowy", (float) 13.54, notvege, gluten));
//        mealrepoEN.save(new Meal("Baked beans", (float) 65.43, notvege, notgluten));
//        mealrepoEN.save(new Meal("Salad", (float) 13.54, vege, notgluten));
//        mealrepoEN.save(new Meal("Cake", (float) 13.54, vege, notgluten));
//
//        mealrepoIN.save(new Meal("Schabowy", (float) 13.54, notvege, gluten));
//        mealrepoIN.save(new Meal("Baked beans/Fasolka po bretońsku", (float) 65.43, notvege, notgluten));
//        mealrepoIN.save(new Meal("Salad/Sałatka", (float) 13.54, vege, notgluten));
//        mealrepoIN.save(new Meal("Cake/Ciastko", (float) 13.54, vege, notgluten));
    }

}
