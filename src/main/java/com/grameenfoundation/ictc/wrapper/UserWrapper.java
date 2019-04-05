/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.wrapper;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joseph George Davis
 * @date Aug 24, 2015 4:15:52 PM
 * description:
 */
public class UserWrapper {
    
    
     
     
     String ID  = "userID";
     String firstName = "firstname";
     String lastName = "lastname";
     String agentType = "usertype";
     String organisation = "organisation";
     String agentCode = "usercode";
     String username = "username";
     String password = "password";
     

     private List<BiodataWrapper> myFarmers = new ArrayList<>() ;
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAgentType() {
        return agentType;
    }

    public void setAgentType(String agentType) {
        this.agentType = agentType;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
    /**
     * @return the myFarmers
     */
    public List<BiodataWrapper> getMyFarmers() {
        return myFarmers;
    }

    /**
     * @param myFarmers the myFarmers to set
     */
    public void setMyFarmers(List<BiodataWrapper> myFarmers) {
        this.myFarmers = myFarmers;
    }
     
     
     

}
