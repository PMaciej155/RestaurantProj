/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Web.Dto;

import com.example.restaurantProj.Database.Model.Address;

/**
 *
 * @author Maciej
 */
public class AddressDTO {
    
        private String firstLine;
    private String secondLine;
    private String city;
    private String postCode;
    private String state;
    
    public static AddressDTO fromAddress(Address address){
        AddressDTO dto = null;
        if(address != null){
                dto = new AddressDTO();
                dto.setFirstLine(address.getFirstLine());
                dto.setSecondLine(address.getSecondLine());
                dto.setCity(address.getCity());
                dto.setPostCode(address.getPostCode());
                dto.setState(address.getState());
        }
        return dto;
    }

    /**
     * @return the firstLine
     */
    public String getFirstLine() {
        return firstLine;
    }

    /**
     * @param firstLine the firstLine to set
     */
    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine;
    }

    /**
     * @return the secondLine
     */
    public String getSecondLine() {
        return secondLine;
    }

    /**
     * @param secondLine the secondLine to set
     */
    public void setSecondLine(String secondLine) {
        this.secondLine = secondLine;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the postCode
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * @param postCode the postCode to set
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }
    
}
