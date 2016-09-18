/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.listener;

import com.grameenfoundation.ictc.utils.*;

import javax.jms.JMSException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Web application lifecycle listener.
 *
 * @author grameen
 */
public class ICTCServletListener implements ServletContextListener {

    private ScheduledExecutorService queueScheduler;
    private ScheduledExecutorService biUpdaterScheduler;

    @Override
    public void contextInitialized(ServletContextEvent sce) {


        System.out.println("-----------------------------Starting Database-------------------------------------");
        ICTCDBUtil.getInstance().startDB();

        //checks if root node exists
        try (Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
              if(Neo4jServices.getRootNode()) {
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


        System.out.println("-----------------------------Initializing MySQL Database-------------------------------------");
        try {
            ICTCDBUtil.getInstance().startMysqlDB();
            //if (!BIServices.databaseExist()) { BIServices.createDatabase(); }
            if (!BIUtil.tablesExist()) { BIUtil.createTables(true); }
        } catch (Exception e) {
            System.out.println("Unable to initialize MySQL DB");
            e.printStackTrace();
        }
        System.out.println("-----------------------------MySQL Database Initialized-------------------------------------");

        System.out.println("-----------------------------Starting Queue Listener-------------------------------------");
        queueScheduler = Executors.newSingleThreadScheduledExecutor();
        Runnable ob =  (new Runnable() {
                             @Override
                             public void run() {
                                deQueue();
                             }
                        });
        queueScheduler.scheduleAtFixedRate(ob, 10, 60, TimeUnit.SECONDS);
        System.out.println("-----------------------------Queue Listener Started-------------------------------------");
    
        
        

        System.out.println("-----------------------------Starting BI table Updater-------------------------------------");
        biUpdaterScheduler = Executors.newSingleThreadScheduledExecutor();
        Runnable o =  (new Runnable() {
            @Override
            public void run() {
              updateBITables();
            }
        });
        biUpdaterScheduler.scheduleAtFixedRate(o, 10, 86400, TimeUnit.SECONDS);
        
        System.out.println("-----------------------------BI table Updater Started-------------------------------------");
    }

    public void deQueue() {
        QueueManager qm = new QueueManager();
        try {
            qm.createConsumer("ICTCServletListener");
            qm.openConnection();
            String payload = qm.get();
            if (!payload.equals(qm.NO_MESSAGE)) {
                SalesforceMessageParser.processXMLString(payload);
            }
        } catch (JMSException ex) {
            ex.printStackTrace();
        } finally {
            try {
                qm.closeConnection();
            }catch(JMSException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateBITables() {
        try {
            BIDataManager.getInstance("all").update();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
          queueScheduler.shutdownNow();
          biUpdaterScheduler.shutdownNow();
          ICTCDBUtil.getInstance().closeMysqlConnection();
          ICTCDBUtil.getInstance().shutdown(ICTCDBUtil.getInstance().getGraphDB());
        } catch (Exception e) {
          e.printStackTrace();
          ICTCDBUtil.getInstance().shutdown(ICTCDBUtil.getInstance().getGraphDB());
        }
    }
}
