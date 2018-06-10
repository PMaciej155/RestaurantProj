/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Database.Dao;

import com.example.restaurantProj.Database.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Maciej
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
    User findByEmail(String email);
    
//    User findbyUsername(String username);
    
    @Override
    void delete(User user);
    
}
