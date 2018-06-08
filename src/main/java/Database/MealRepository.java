/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Maciej
 */
@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {


    public List<Meal> getMealByLang(String lang);


    
    @Query(value = "SELECT * FROM  Meal meal WHERE meal.id > :id", nativeQuery = true)
    public List<Meal> getMealminID(@Param("id") int id);

}
