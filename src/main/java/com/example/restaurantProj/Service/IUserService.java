/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Service;

import com.example.restaurantProj.Database.Model.User;
import com.example.restaurantProj.Service.Error.EmailExistsException;
import com.example.restaurantProj.Web.Dto.UserDTO;

/**
 *
 * @author Maciej
 */
public interface IUserService {
     User registerNewUserAccount(UserDTO accountDto)     
      throws EmailExistsException;
}
