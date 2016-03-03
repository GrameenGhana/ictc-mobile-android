/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.listener;

import com.grameenfoundation.ictc.utils.ICTCDBUtil;
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
 GraphDatabaseService db = null;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        
       
              System.out.println("-----------------------------Starting Database-------------------------------------");
              db =  ICTCDBUtil.getInstance().startDB();
              
             
/***
 * uncomment the following lines of code on first run to create ROOT node in db
 * comment it out after first run and redeploy application.
 **/
              
//             try (Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
//                 Node node =ICTCDBUtil.getInstance().getGraphDB().createNode(DynamicLabel.label("root"));
//                 node.setProperty("name", "ICTCROOT");
//                 tx.success();
//                 
//                 System.out.println("Node Added");
//                 
//                 System.out.println("node Added" + node.getId());
//                 System.out.println("node Added" + node.getProperty("name"));
//                 
//             } catch (Exception e) {
//                 
//                 System.out.println("Unable to create root node");
//             }
//             
            
             System.out.println("-----------------------------DB Started-------------------------------------");
             
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
       System.out.println("-------------listener done-------------------");
        try {
            System.out.println("Shut Down About to Start Started");
            //Shut Down the server on exit
            ICTCDBUtil.getInstance().shutdown(db);
            //log.info("Shut Down done");
             System.out.println(" Database Shut Down done");
        } catch (Exception e) {
            System.out.println("Unable to Shut Down");

        }
    }
}
