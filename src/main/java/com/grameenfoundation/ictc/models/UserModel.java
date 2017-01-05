/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.Agent;
import com.grameenfoundation.ictc.domains.Storage;
import com.grameenfoundation.ictc.domains.User;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import com.grameenfoundation.ictc.utils.ParentNode;
import com.grameenfoundation.ictc.utils.security.CryptoLibrary;
import com.grameenfoundation.ictc.wrapper.AgentWrapper;
import com.grameenfoundation.ictc.wrapper.StorageWrapper;
import com.grameenfoundation.ictc.wrapper.UserWrapper;
import java.util.ArrayList;
import org.json.*;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;
import scala.collection.Iterator;

/**
 *
 * @author skwakwa
 * @Edited Joseph George Davis
 */
public class UserModel {

    Logger log = Logger.getLogger(UserModel.class.getName());
    Node userParent;

    public User create(UserWrapper st) {
        boolean created = true;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Node stNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.USER);

            User stg = new User(stNode);

            if (null == st) {
                log.info("user is invalid");
                created = false;
            } else {
               // userParent = ParentNode.AgentParentNode();

                stg.setAgentCode(st.getAgentCode());
                stg.setAgentID(st.getID());
                stg.setAgentType(st.getAgentType());
                stg.setFirstname(st.getFirstName());
                stg.setLastname(st.getLastName());
                stg.setUsername(st.getUsername());
                stg.setPassword(st.getPassword());

                stg.setStatus("Active");
                stg.setCreatedOn(new Date());

               //userParent.createRelationshipTo(stNode, ICTCRelationshipTypes.USER);

                log.log(Level.INFO, "new node created. {0}", stg.getUnderlyingNode().getId());
                trx.success();
                return stg;

            }

        } catch (Exception e) {

            created = false;
            log.severe("Creation of Farmer Failed");
            e.printStackTrace();
        }

        return null;
    }
    
      public User getUser(String field, String value) {
//        String q = "Start root=node(0) "
//                + " MATCH root-[:" + ICTCRelationshipTypes.ENTITY + "]->parent-[:" + ICTCRelationshipTypes.AGENT + "]->p"
//                + " where p." + field + "='" + value + "'"
//                + " return p";
        
         String q = "match (p:USER)"+" where p." + field + "='" + value + "'" +" return p";

        System.out.println("Query " + q);
        try {
            Node node = Neo4jServices.executeCypherQuerySingleResult(q, "p");
            if (null != node) {
                return new User(node);
            }
        } catch (Exception e) {
            System.out.println("Unable to Find User");
        }

        return null;
    }
    
       public List<User> findAllUsers() {
        List<User> aglist = new ArrayList<>();

        String q = "match (l:USER) where l.usertype='acdivoca_ob' return  l";

        try (Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            Result result = Neo4jServices.executeCypherQuery(q);

            ResourceIterator<Node> n_column = result.columnAs("l");
            while (n_column.hasNext()) {
                // aglist.add(new Agent(n_column.next()));
               User b = new User(n_column.next());

                aglist.add(b);
                tx.success();

            }
            tx.success();
        }
        
        
        return aglist;
     }
       
     
     public List<AgentWrapper> getObAgent(String userId)
     {
         //System.out.println("obId  " + userId);
         List<AgentWrapper> aglist = new ArrayList<>();
         
         String q ="match (f:USER)-[:HAS_AGENT]->(l) where f.Id='"+userId+"' return l";
         
           try (Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            Result result = Neo4jServices.executeCypherQuery(q);

            ResourceIterator<Node> n_column = result.columnAs("l");
            while (n_column.hasNext()) {
                // aglist.add(new Agent(n_column.next()));
               Agent b = new Agent(n_column.next());
                AgentWrapper wr = new AgentWrapper();
             
                wr.setAgentId(b.getAgentId());
                wr.setAgentcode(b.getAgentcode());
                wr.setFirstname(b.getFirstname());
                wr.setLastname(b.getLastname());
                
               aglist.add(wr);

            }
            tx.success();
        }
        
         System.out.println("agli " + aglist.size());
        return aglist;
         
         
     }
    
     
        public List<AgentWrapper> getAPOAgent(String userId)
     {
         //System.out.println("obId  " + userId);
         List<AgentWrapper> aglist = new ArrayList<>();
         
         String q ="match (f:USER)-[:"+ICTCRelationshipTypes.MANAGES+"]->(l) where f.Id='"+userId+"' return l";
         
         System.out.println("query " + q );
         
           try (Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            Result result = Neo4jServices.executeCypherQuery(q);

            ResourceIterator<Node> n_column = result.columnAs("l");
            while (n_column.hasNext()) {
                // aglist.add(new Agent(n_column.next()));
               Agent b = new Agent(n_column.next());
                AgentWrapper wr = new AgentWrapper();
             
                wr.setAgentId(b.getAgentId());
                wr.setAgentcode(b.getAgentcode());
                wr.setFirstname(b.getFirstname());
                wr.setLastname(b.getLastname());
                
               aglist.add(wr);

            }
            tx.success();
        }
        
         System.out.println("agli " + aglist.size());
        return aglist;
         
         
     }
    
     public List<User> findUserAgents() {
        List<User> aglist = new ArrayList<>();

        String q = "match (u:USER)-[:HAS_AGENT]->(l) where l.usertype='acdivoca_ob' return  l";

        try (Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            Result result = Neo4jServices.executeCypherQuery(q);

            ResourceIterator<Node> n_column = result.columnAs("l");
            while (n_column.hasNext()) {
                // aglist.add(new Agent(n_column.next()));
               User b = new User(n_column.next());

                aglist.add(b);

            }
            tx.success();
        }
        
        
        return aglist;
     }

    public List<UserWrapper> findAll() {

        return userQuery("match (l:USER) return  l", "l");
    }
    
    

    public List<UserWrapper> findByType(String userType) {

        return userQuery("match (l:USER) where l." + User.AGENT_TYPE + "='" + userType + "' return  l", "l");
    }

    public List<UserWrapper> findByTypeStatus(String userType, String status) {

        return userQuery("match (l:USER) where l." + User.AGENT_TYPE + "='" + userType + "' and l." + User.AGENT_TYPE + "='" + status + "' return  l", "l");
    }

    public UserWrapper findUser(String username, String password) {
        CryptoLibrary crypt = new CryptoLibrary();
        String q = "match (l:USER) WHERE l." + User.USERNAME + "= '" + username + "'  "
                //+ "and  l." + User.PASSWORD + "='" + (password) + "'"
                + "  return l";
        System.out.println("login : "+q);
        List<UserWrapper> usr = userQuery(q, "l");
        if (null != usr && !usr.isEmpty()) {
            return usr.get(0);
        }
        return null;
    }

private List<UserWrapper> userQuery(String q, String returnedItem) {
List<UserWrapper> usrs = new ArrayList<>();
        System.out.println("Query : "+q);
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
             ResourceIterator<Node> n_column = Neo4jServices.executeIteratorQuery(q, returnedItem);
            while (n_column.hasNext()) {
                User u = new User(n_column.next());
                UserWrapper wr = new UserWrapper();
                wr.setAgentCode(u.getAgentCode());
                wr.setAgentType(u.getAgenttype());
                wr.setFirstName(u.getFirstname());
                wr.setLastName(u.getLastname());
                wr.setUsername(u.getUsername());
                wr.setID(u.getAgentID());
                wr.setOrganisation(u.getOrganisation());
                usrs.add(wr);
               //todo Find relationship to farmer to replace
              //  wr.setMyFarmers(Neo4jServices.findByLabel(Labels.FARMER, ICTCRelationshipTypes.USER, "id", wr.getID()));
//               wr.(u.getFirstname());
            }
           
        }
        return usrs;
    }


 public boolean AgentToPostFarmer(String agent, Node farmer) {
        boolean created = false;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

             User user = new UserModel().getUser(User.ID,agent);

            System.out.println("biodata :" + user.getUnderlyingNode().getId());
            if (null != user) {

               user.setFarmer(farmer);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }
 
 public boolean ObToAggent(String ob, Node agent) {
        boolean created = false;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

             User user = new UserModel().getUser(User.ID,ob);

            System.out.println("biodata :" + user.getUnderlyingNode().getId());
            if (null != user) {

               user.setAgent(agent);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }
 
 
 public boolean APOToAggent(String ob, Node agent) {
        boolean created = false;
       ;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            User user = new UserModel().getUser(User.ID,ob);

            System.out.println("biodata :" + user.getUnderlyingNode().getId());
            if (null != user) {

                agent.setProperty(Agent.APO, user.getFirstname()+ " " + user.getLastname());
                agent.setProperty("sapoId", user.getAgentID());
                created = true;
                
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

      
        return created;
    }
 
 public JSONObject  getOb()
   {
      JSONObject x = new JSONObject();
      JSONArray ja = new JSONArray();
      
      
      List<UserWrapper> ob = new UserModel().findByType("acdivoca_ob");
      
       for (UserWrapper ob1 : ob) {
           JSONObject y = new JSONObject();
           
           y.put("ob",ob1.getID());
           y.put("name",ob1.getFirstName() + " "+ ob1.getLastName());
           
           ja.put(y);
       }
      
        x.put("obs",ja);
      // System.out.println("json " + x);
      return x;
      
      
       
             
   }
 
 
 public JSONObject getAPO()
 {
      JSONObject x = new JSONObject();
      JSONArray ja = new JSONArray();
      
      
      List<UserWrapper> ob = new UserModel().findByType("acdivoca_apo");
      
       for (UserWrapper ob1 : ob) {
           JSONObject y = new JSONObject();
           
           y.put("apo",ob1.getID());
           y.put("name",ob1.getFirstName() + " "+ ob1.getLastName());
           
           ja.put(y);
       }
      
        x.put("apo",ja);
      // System.out.println("json " + x);
      return x;
 }
 
 
 public JSONObject getObUser()
 {
      JSONObject x = new JSONObject();
      JSONArray ja = new JSONArray();
      Agent a = null;
     
     List<AgentWrapper> agg = new ArrayList<>();
     Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx();
     try {
         List<User> users = findAllUsers();
         System.out.print("user " + users.size());

         for (User ag : users) {
              agg = getObAgent(ag.getAgentID());
        for (AgentWrapper at : agg) {
              JSONObject y = new JSONObject();
             
                 y.put("ob", ag.getFirstname() + " " + ag.getLastname());
                 y.put("ag", at.getFirstname() + " " + at.getLastname());
             

             ja.put(y); 
             }
            
         }

         tx.success();

 }
  catch( Exception ex)
  {
      ex.printStackTrace();
      tx.failure();
  }
  finally
  {
      tx.finish();
  }
    x.put("obagent",ja);
    System.out.println("json " + x);
    return x;
 }
 
 public JSONObject getApoUser()
 {JSONObject x = new JSONObject();
      JSONArray ja = new JSONArray();
      
      
      List<AgentWrapper> ags = new AgentModel().findAllACDIAgents();
      
       for (AgentWrapper ag : ags) {
           JSONObject y = new JSONObject();
           
          
           y.put("ag",ag.getAgentId());
           y.put("name",ag.getFirstname() + " " + ag.getLastname());
           y.put("sapo", ag.getApo());
          
           
           ja.put(y);
       }
      
      x.put("apoagent",ja);
       // System.out.println("json " + x);
      return x; 

 
  
    
 }
 
 public JSONObject getAgent()
 {
     JSONObject x = new JSONObject();
      JSONArray ja = new JSONArray();
      
      
      List<AgentWrapper> ags = new AgentModel().findAllACDIAgents();
      
       for (AgentWrapper ag : ags) {
           JSONObject y = new JSONObject();
           
           y.put("ag",ag.getAgentId());
           y.put("name",ag.getFirstname() + " " + ag.getLastname());
           
           ja.put(y);
       }
      
      x.put("ags",ja);
       // System.out.println("json " + x);
      return x; 
 }
 
 
 public List<String> getAgents(String user)
 {
     

     List<AgentWrapper> ags = new ArrayList<>();
          ags= new UserModel().getObAgent(user);
     
     List<String> agents = new ArrayList<>();
     
     for (AgentWrapper agent : new UserModel().getObAgent(user)) {
        agents.add(agent.getAgentId());
     }
     
     
    return agents; 
 }
 
 
 
}
