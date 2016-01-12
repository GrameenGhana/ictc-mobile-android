/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.wrapper;

/**
 *
 * @author Joseph George Davis
 * @date Oct 29, 2015 4:34:45 PM
 * description:
 */
public class AgentWrapper {
    
    
    private String agenttype = "agenttype";
    private String agentid = "";
    private String lastname = "lastname";
    private String firstname = "firstname";
    private String email = "email";
    private String username = "username";
    private String agentcode = "agentcode";
    private String password = "password";
    
    

    public String getAgentId() {
        return agentid;
    }

    public void setAgentId(String password) {
        this.agentid = password;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
