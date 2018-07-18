/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Web.Controller;

import java.util.List;
import com.example.restaurantProj.Service.OrderService;
import com.example.restaurantProj.Web.Dto.AddressDTO;
import com.example.restaurantProj.Web.Dto.OrderDTO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.json.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Maciej
 */
@Controller
@RequestMapping("/myorder")
public class MyOrderController {

    @Autowired
    OrderService orderService;

    @PostMapping()
    @ResponseStatus(value = HttpStatus.OK)
    public void addOrder(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        Gson gson = new Gson();
        AddressDTO adress = gson.fromJson(request.getParameter("address"), AddressDTO.class);
        JSONArray jsonArr = new JSONArray(request.getParameter("cart"));
        float price = Float.parseFloat(request.getParameter("totalPrice"));
        Map<Long, Integer> orderedMeals = new HashMap<>();

        jsonArr.forEach(item -> {
            JSONObject obj = (JSONObject) item;
            Long type = obj.getLong("id");
            Integer quantity = obj.getInt("quantity");
            orderedMeals.put(type, quantity);
        });
        OrderDTO order = new OrderDTO();
        order.setClient(principal.getName());
        order.setMeal(orderedMeals);
        order.setAddress(adress);
        order.setPrice(price);
        orderService.makeOrder(order);
    }

    @GetMapping()
    public ModelAndView showMyOrderDetails() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("myOrder");
        return mav;
    }
    
    @GetMapping("/success")
    public ModelAndView showOrderSuccess() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("myordersuccess");
        return mav;
    }

}
