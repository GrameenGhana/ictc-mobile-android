/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.wrapper;

import static com.grameenfoundation.ictc.domains.Agent.PHONENUMBER;

/**
 *
 * @author Joseph George Davis
 * @date Oct 29, 2015 4:34:45 PM
 * description:
 */
public class AgentWrapper {
    
    
    private String agenttype = "agenttype";
    private String agentid = "Id";
    private String lastname = "lastname";
    private String firstname = "firstname";
    private String email = "email";
    private String username = "username";
    private String agentcode = "agentcode";
    private String password = "password";
    private String phonenumber = "phonenumber";
    private String region = "region";
    private String apo = "sapo";

    public String getApo() {
        return apo;
    }

    public void setApo(String apo) {
        this.apo = apo;
    }
    
    
     
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    

    public String getAgentId() {
        return agentid;
    }

    public void setAgentId(String id) {
        this.agentid = id;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

   
    
    
    
 public  void setAgentcode(String agentcode) {
      this.agentcode=agentcode;
    }
 public  String getAgentcode() {
        return agentcode;

    }
    
 public  void setUsername(String username) {
      this.username=username;
    }
 public  String getUsername() {
        return username;

    }
    
 public  void setEmail(String email) {
      this.email=email;
    }
 public  String getEmail() {
        return email;

    }
    
 public  void setFirstname(String firstname) {
      this.firstname=firstname;
    }
 public  String getFirstname() {
        return firstname;

    }
    
 public  void setLastname(String lastname) {
      this.lastname=lastname;
    }
 public  String getLastname() {
        return lastname;

    }
 public  void setAgenttype(String agenttype) {
      this.agenttype=agenttype;
    }
 public  String getAgenttype() {
        return agenttype;

    }
 
 
 

}
