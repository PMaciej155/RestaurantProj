/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Web.Controller;

import com.example.restaurantProj.Database.Model.User;
import com.example.restaurantProj.Service.Error.EmailExistsException;
import com.example.restaurantProj.Service.UserService;
import com.example.restaurantProj.Web.Dto.UserDTO;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Maciej
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
    
    @Autowired
    UserService service;
    
    @PostMapping
    public ModelAndView createUserView(@ModelAttribute("user") @Valid UserDTO accountDto,
            BindingResult result, 
            WebRequest request, 
            Errors errors){
        System.out.println(accountDto.getPassword());
        System.out.println(accountDto.getConfirmpassword());
    User registered = createUserAccount(accountDto, result);
    ModelAndView mav = new ModelAndView();
    UserDTO userdto = new UserDTO();
    mav.addObject("user", userdto);
    mav.setViewName("login");
    return mav; 
    }
    
    private User createUserAccount(UserDTO accountDto, BindingResult result) {
    User registered = null;
    try {
        registered = service.registerNewUserAccount(accountDto);
    } catch (EmailExistsException e) {
        return null;
    }
    return registered;
}
}
