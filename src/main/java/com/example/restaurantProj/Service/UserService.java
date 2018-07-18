/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Service;

import com.example.restaurantProj.Database.Dao.UserRepository;
import com.example.restaurantProj.Database.Model.User;
import com.example.restaurantProj.Service.Error.EmailExistsException;
import com.example.restaurantProj.Web.Dto.UserDTO;
import java.util.Arrays;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

/**
 *
 * @author Maciej
 */
@Service

public class UserService implements IUserService {

    @Autowired
    UserRepository userrepository;

    @Transactional
    @Override
    public User registerNewUserAccount(UserDTO userDto)
            throws EmailExistsException {

        if (emailExist(userDto.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email adress: "
                    + userDto.getEmail());
        }
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(hashPassword(userDto.getPassword()));
        user.setRoles(Arrays.asList("ROLE_USER"));
        return userrepository.save(user);
    }

    private boolean emailExist(String email) {
        User user = userrepository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
    
    private String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
}
