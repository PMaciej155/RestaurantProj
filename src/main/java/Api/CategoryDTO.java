/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api;

import Database.Category;

/**
 *
 * @author Maciej
 */
//rest layer representation of Category
public class CategoryDTO {
    private String name;

    public static CategoryDTO fromCategory(Category category){
        CategoryDTO dto = new CategoryDTO();
        dto.setName(category.getName());
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
}
