/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.domains;

import com.grameenfoundation.ictc.domain.commons.GeneralInterface;
import com.grameenfoundation.ictc.domain.commons.Status;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Joseph George Davis
 * @date Aug 24, 2015 3:51:37 PM
 * description:
 */
public class User extends Status implements GeneralInterface{
    
    
    public static String ID = "Id";
    public static String LAST_NAME = "lastname";
    public static String FIRST_NAME = "firstname";
    public static String AGENT_TYPE = "usertype";
    public static String ORGANISATION ="organisation";
    public static String AGENT_CODE = "usercode";
     public static String USERNAME = "username";
    public static String PASSWORD = "password";
   
    
    Node underlyingNode;

    public User(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }
    
    
     public String getFirstname() {
        try {
            return (String) underlyingNode.getProperty(FIRST_NAME);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setFirstname(String firstname) {
        underlyingNode.setProperty(FIRST_NAME,firstname);
    }

    public String getLastname() {
          try {
            return (String) underlyingNode.getProperty(LAST_NAME);

        } catch (Exception e) {
        }
        return null;
    }

    public void setLastname(String lastname) {
        underlyingNode.setProperty(LAST_NAME,lastname);
    }
    
    
     public void setAgentID(String agentID) {
        underlyingNode.setProperty(ID,agentID);
    }
    
      public String getAgentID() {
          try {
            return (String) underlyingNode.getProperty(ID);

        } catch (Exception e) {
        }
        return "";
    }
      
      
       public void setAgentType(String agentType) {
        underlyingNode.setProperty(AGENT_TYPE,agentType);
    }
       
       
        public String getAgenttype() {
          try {
            return (String) underlyingNode.getProperty(AGENT_TYPE);

        } catch (Exception e) {
        }
        return "";
    }
        
     public void setAgentCode(String agentCode) {
        underlyingNode.setProperty(AGENT_CODE,agentCode);
    }

      public String getAgentCode() {
          try {
            return (String) underlyingNode.getProperty(AGENT_CODE);

        } catch (Exception e) {
        }
        return "";
    }
      
      public void setOrganisation(String organisation) {
        underlyingNode.setProperty(ORGANISATION,organisation);
    }
      
      
      public String getOrganisation() {
          try {
            return (String) underlyingNode.getProperty(ORGANISATION);

        } catch (Exception e) {
        }
        return "";
    }
      
      
       public void setUsername(String username) {
        underlyingNode.setProperty(USERNAME,username);
    }

      public String getUsername() {
          try {
            return (String) underlyingNode.getProperty(USERNAME);

        } catch (Exception e) {
        }
        return null;
    }
      
      public void getPassword(String pwd) {
        underlyingNode.setProperty(PASSWORD,pwd);
    }
      
      
      public String getPassword() {
          try {
            return (String) underlyingNode.getProperty(PASSWORD);

        } catch (Exception e) {
        }
        return null;
    }
      
      
      
      public void setFarmer(Node farmer)
   {
       underlyingNode.createRelationshipTo(farmer, ICTCRelationshipTypes.HAS_FARMER);
   } 
    
     public Biodata getFarmer()
   {
       return new Biodata(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_FARMER));
   }
}
