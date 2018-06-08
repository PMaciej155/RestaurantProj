/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 *
 * @author Maciej
 */
//database layer representation of Meal
@Entity
@Table(name = "Meals")
public class Meal implements Serializable{

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public float getPrice() {
        return price;
    }


    public void setPrice(float price) {
        this.price = price;
    }

     public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    private String name;
    private float price;
    private String lang;

    
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "post_category",
            joinColumns = { @JoinColumn(name = "meals_id") },
            inverseJoinColumns = { @JoinColumn(name = "category_id") })
    private List<Category> category;

    
    public Meal(String name, float price, String lang){
        this.name = name;
        this.price = price;
        this.lang = lang;
        category = new ArrayList<Category>();
    }
    public Meal(){
        category = new ArrayList<Category>();
    }
    @Override
    public String toString(){
        return getName()+" = "+getPrice();
    }

    /**
     * @return the category
     */
    public List<Category> getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(ArrayList<Category> category) {
        this.setCategory(category);
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

    /**
     * @param category the category to set
     */
    public void setCategory(List<Category> category) {
        this.category = category;
    }
      
}
