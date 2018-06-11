/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Web.Controller;

import com.example.restaurantProj.Web.Dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Maciej
 */
@Controller
public class MainController {
    
    @RequestMapping("/login")
    public ModelAndView logInUserView() {
   ModelAndView mav = new ModelAndView();
    UserDTO userdto = new UserDTO();
    mav.addObject("user", userdto);
    mav.setViewName("login");
    return mav; 
  }
    
     
}
