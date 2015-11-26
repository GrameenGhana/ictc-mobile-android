/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.domains;

import com.grameenfoundation.ictc.domain.commons.GeneralInterface;
import com.grameenfoundation.ictc.domain.commons.Status;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Joseph George Davis
 * @date Oct 29, 2015 4:34:25 PM
 * description:
 */
public class Agent extends Status implements GeneralInterface {
    
    Node underlyingNode = null;

    public Agent(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }
    
    
    public static String AGENTTYPE="agenttype";
    public static String FIRSTNAME="firstname";
    public static String LASTNAME="lastname";
    public static String EMAIL="email";
    public static String USERNAME="username";
    public static String AGENTCODE="agentcode";
    public static String PASSWORD ="password";
    

public void setPassword(String agentcode) {
underlyingNode.setProperty(PASSWORD,agentcode);
}


public String getPassword(){
          try {
          return (String) underlyingNode.getProperty(PASSWORD);

        } catch (Exception e) {
        }
        return null;
    }



public void setAgentcode(String agentcode) {
underlyingNode.setProperty(AGENTCODE,agentcode);
}

public String getAgentcode(){
          try {
          return (String) underlyingNode.getProperty(AGENTCODE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setUsername(String username) {
underlyingNode.setProperty(USERNAME,username);
}

public String getUsername(){
          try {
          return (String) underlyingNode.getProperty(USERNAME);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setEmail(String email) {
underlyingNode.setProperty(EMAIL,email);
}

public String getEmail(){
          try {
          return (String) underlyingNode.getProperty(EMAIL);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setLastname(String lastname) {
underlyingNode.setProperty(LASTNAME,lastname);
}

public String getLastname(){
          try {
          return (String) underlyingNode.getProperty(LASTNAME);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setFirstname(String firstname) {
underlyingNode.setProperty(FIRSTNAME,firstname);
}

public String getFirstname(){
          try {
          return (String) underlyingNode.getProperty(FIRSTNAME);

        } catch (Exception e) {
        }
        return null;
    }

public void setAgenttype(String agenttype) {
underlyingNode.setProperty(AGENTTYPE,agenttype);
}

public String getAgenttype(){
          try {
          return (String) underlyingNode.getProperty(AGENTTYPE);

        } catch (Exception e) {
        }
        return null;
    }

}
