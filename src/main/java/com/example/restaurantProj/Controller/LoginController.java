/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Maciej
 */
@Controller
public class LoginController {
    
    @RequestMapping("/")
    public ModelAndView createUserView() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("login");
    return mav;
  }
}
