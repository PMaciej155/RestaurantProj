/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Database.Dao;

import com.example.restaurantProj.Database.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Maciej
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

    @Override
    void delete(Role role);

}
