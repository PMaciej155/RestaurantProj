/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Maciej
 */
@Controller
public class LoginController {
    
    @RequestMapping("/login")
    public ModelAndView logInUserView() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("login");
    return mav;
  }
    @RequestMapping("/home")
    public ModelAndView homeView() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("home");
    return mav;
  }
}
