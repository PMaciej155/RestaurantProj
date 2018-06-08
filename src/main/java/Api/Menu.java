/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api;

import Database.Category;
import Database.CategoryRepository;
import Database.Meal;
import Database.MealRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/API")
public class Menu {

//    @Autowired
//    public MealManager mManager;
    @Autowired
    private CategoryRepository catrepo;

    @Autowired
    private MealRepository mealrepo;

    Category vege = new Category();
    Category gluten = new Category();

    @RequestMapping("/init")
    @ResponseBody
    public void makeDatabase() {

        vege.setName("Vegetarian");
        gluten.setName("Gluten Free");

        Meal m1 = new Meal("Schabowy", (float) 13.54, "PL");
        Meal m2 = new Meal("Fasolka po bretońsku", (float) 65.43, "PL");
        Meal m3 = new Meal("Sałatka", (float) 13.54, "PL");
        Meal m4 = new Meal("Ciastko", (float) 13.54, "PL");

        m1.getCategory().add(gluten);
        m2.getCategory().add(vege);
        m3.getCategory().add(gluten);
        m4.getCategory().add(vege);

//        vege.getMeals().add(m2);
//        vege.getMeals().add(m4);
//        gluten.getMeals().add(m1);
//        gluten.getMeals().add(m3);
        catrepo.save(gluten);
        catrepo.save(vege);
        mealrepo.save(m1);
        mealrepo.save(m2);
        mealrepo.save(m3);
        mealrepo.save(m4);

        Meal m1EN = new Meal("Schabowy", (float) 13.54, "EN");
        Meal m2EN = new Meal("Baked beans", (float) 65.43, "EN");
        Meal m3EN = new Meal("Salad", (float) 13.54, "EN");
        Meal m4EN = new Meal("Cake", (float) 13.54, "EN");
        m1EN.getCategory().add(gluten);
        m2EN.getCategory().add(vege);
        m3EN.getCategory().add(gluten);
        m4EN.getCategory().add(vege);

        mealrepo.save(m1EN);
        mealrepo.save(m2EN);
        mealrepo.save(m3EN);
        mealrepo.save(m4EN);

        Meal m1IN = new Meal("Schabowy", (float) 13.54, "IN");
        Meal m2IN = new Meal("Baked beans/Fasolka po bretońsku", (float) 65.43, "IN");
        Meal m3IN = new Meal("Salad/Sałatka", (float) 13.54, "IN");
        Meal m4IN = new Meal("Cake/Ciastko", (float) 13.54, "IN");

        m1IN.getCategory().add(gluten);
        m2IN.getCategory().add(vege);
        m3IN.getCategory().add(gluten);
        m4IN.getCategory().add(vege);

        mealrepo.save(m1IN);
        mealrepo.save(m2IN);
        mealrepo.save(m3IN);
        mealrepo.save(m4IN);
    }

    @RequestMapping("/hello")
    @ResponseBody
    public Meal hello() {
        return mealrepo.getMealByLang("PL").get(1);
    }

    @RequestMapping("/menu")
    @ResponseBody
    public List<Meal> showMenu(@RequestHeader("lang") String lang) {
        return mealrepo.getMealByLang(lang);
    }

    @RequestMapping("/menuBy")
    @ResponseBody
    public List<Meal> filter(@RequestParam("vege") Boolean vegetarian,
            @RequestParam("gluten") Boolean glutenfree) {
        List<Meal> nList = new ArrayList<Meal>();
        List<Meal> meals = mealrepo.getMealByLang("PL");

        for (Meal m : meals) {
            if (vegetarian == m.getCategory().contains(vege)
                    && glutenfree == m.getCategory().contains(gluten)) {
                nList.add(m);
            }
        }
        return nList;
    }

    @RequestMapping("/countedMenu/{number}")
    @ResponseBody
    public ArrayList<Meal> countedMenu(@PathVariable("number") int number) {
        ArrayList<Meal> nList = new ArrayList<Meal>();
//        for (int i = 0; i < number; i++) {
//            nList.add(mealrepo.getNoteByLang("PL").get(i));
//        }
        nList.addAll(mealrepo.getMealminID(number));
        return nList;
    }

    @RequestMapping(value = "/menuList", method = RequestMethod.POST)
    @ResponseBody
    public List<Meal> requestBodyExample(@RequestBody List<Meal> nlist) {
        List<Meal> n = mealrepo.getMealByLang("PL");
        for (Meal m : nlist) {
            n.add(m);
            mealrepo.save(m);
        }
        return n;
    }

}
