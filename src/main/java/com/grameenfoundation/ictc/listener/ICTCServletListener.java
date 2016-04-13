/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.listener;

import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

/**
 * Web application lifecycle listener.
 *
 * @author grameen
 */
public class ICTCServletListener implements ServletContextListener {
// GraphDatabaseService db = null;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        
       
              System.out.println("-----------------------------Starting Database-------------------------------------");
               ICTCDBUtil.getInstance().startDB();
  //checks if root node exists            
 try (Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
              if(Neo4jServices.getRootNode())
              {
                  System.out.println("Root Node Already Exists");
              }
              else
              {
                  
                      Node node = ICTCDBUtil.getInstance().getGraphDB().createNode(DynamicLabel.label("root"));
                      node.setProperty("name", "ICTCROOT");
                     

                      System.out.println("Node Added");

                      System.out.println("node Added" + node.getId());
                      System.out.println("node Added" + node.getProperty("name"));
                       tx.success();
              }
            
              } catch (Exception e) {

                      System.out.println("Unable to create root node");
                      e.printStackTrace();
              }
             System.out.println("-----------------------------DB Started-------------------------------------");
             
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
       System.out.println("-------------listener done-------------------");
        
    }
}
