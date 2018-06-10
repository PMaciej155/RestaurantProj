/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Database.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.restaurantProj.Database.Model.Privilege;


/**
 *
 * @author Maciej
 */
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    Privilege findByName(String name);

    @Override
    void delete(Privilege privilege);

}
