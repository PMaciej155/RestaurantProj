/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api;

import Database.Meal;

/**
 *
 * @author Maciej
 */
//REST layer representation of Meal
public class MealDTO {

    private String name;
    private float price;
    private String lang;
    

    public static MealDTO fromMeal(Meal meal){
        MealDTO dto = new MealDTO();
        dto.setName(meal.getName());
        dto.setLang(meal.getLang());
        dto.setPrice(meal.getPrice());
        return dto;
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
     * @return the lang
     */
    public String getLang() {
        return lang;
    }

    /**
     * @param lang the lang to set
     */
    public void setLang(String lang) {
        this.lang = lang;
    }
    
   
    
}
