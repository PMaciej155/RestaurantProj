/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Service;

import com.example.restaurantProj.Database.Dao.AddressRepository;
import com.example.restaurantProj.Database.Dao.MealRepository;
import com.example.restaurantProj.Database.Dao.OrderRepository;
import com.example.restaurantProj.Database.Dao.UserRepository;
import com.example.restaurantProj.Database.Model.Address;
import com.example.restaurantProj.Database.Model.Meal;
import com.example.restaurantProj.Database.Model.Order;
import com.example.restaurantProj.Database.Model.Order.OrderStatus;
import com.example.restaurantProj.Web.Dto.MealDTO;
import com.example.restaurantProj.Web.Dto.OrderDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
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

public class OrderService {
    
    @Autowired
    AddressRepository addressrepository;
    
    @Autowired
    UserRepository userrepository;
    
    @Autowired
    OrderRepository orderrepository;
    
    @Autowired
    MealRepository mealrepository;
    
    @Transactional
    public void makeOrder(OrderDTO orderdto) {
        Address adr = Address.fromDto(orderdto.getAddress());
//        if(addressrepository.existsByFisrtLineAndSecondLineAndCity(adr.getFirstLine(), adr.getSecondLine(), adr.getCity()))
        addressrepository.save(adr);
        Order order = new Order()
                .withClient(userrepository.findByUsername(orderdto.getClient()))
                .withMeal(getMapMeal(orderdto.getMeal()))
                .withAddress(adr)
                .withStatus(Order.OrderStatus.ACCEPTED);
        order.setPrice(orderdto.getPrice());
        orderrepository.save(order);   
    }
    
    @Transactional
    public List<OrderDTO> getAllOrders(){
        List<OrderDTO> orders = new ArrayList<>();
        orders = orderrepository.findAll().stream()
                .map(order -> OrderDTO.fromOrder(order))
        .collect(Collectors.toList());
        return orders;
    }
    
    @Transactional
    public OrderDTO getOrderDetails(long id){
        Optional<Order> order = orderrepository.findById(id);
        return OrderDTO.fromOrder(order.get());
    }
    
    @Transactional
    private Map<Meal, Integer> getMapMeal(Map<Long, Integer> mapdto){
        Map<Meal, Integer> mapMeals = new HashMap<Meal, Integer>();
        mapMeals = mapdto
                .entrySet().stream()
                .collect(Collectors.toMap(e -> mealrepository.findId(e.getKey()), Map.Entry::getValue));
        return mapMeals;
    }
    
    @Transactional
    public Map<MealDTO, Integer> getMapMealDTO(Map<Long, Integer> mapdto){
        Map<MealDTO, Integer> mapMeals = new HashMap<MealDTO, Integer>();
        mapMeals = mapdto
                .entrySet().stream()
                .collect(Collectors.toMap(e -> MealDTO.fromMeal(mealrepository.findId(e.getKey())), Map.Entry::getValue));
        return mapMeals;
    }
    
    @Transactional
    public void modifyOrderStatus(Long id, OrderStatus status) {
       Optional<Order> order = orderrepository.findById(id);
        orderrepository.save(order.get()
                .withStatus(status));
    }
    
    @Transactional
    public void deleteOrder(Long id) {
        Optional<Order> order = orderrepository.findById(id);
        orderrepository.delete(order.get());
    }
    
    
    
}
