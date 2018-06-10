/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Web.Controller;

import com.example.restaurantProj.Web.Dto.UserDTO;
import javax.validation.Valid;
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
    
    @PostMapping
    public ModelAndView createUserView(@ModelAttribute("user") @Valid UserDTO accountDto,
            BindingResult result, 
            WebRequest request, 
            Errors errors){
    System.out.println(accountDto.getUsername());
    ModelAndView mav = new ModelAndView();
    UserDTO userdto = new UserDTO();
    mav.addObject("user", userdto);
    mav.setViewName("login");
    return mav; 
    }
}
