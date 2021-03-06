/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Database.Dao;

import com.example.restaurantProj.Database.Model.Address;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Maciej
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{
    
   public List<Address> findByCity(String city);

}
