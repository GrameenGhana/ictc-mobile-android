/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.Aisdashboard;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import static com.grameenfoundation.ictc.utils.SalesforceMessageParser.log;
import com.grameenfoundation.ictc.wrapper.AisdashboardWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Transaction;

/**
 *
 * @author Joseph George Davis
 * @date Nov 30, 2016 11:38:18 AM
 * description:
 */
public class AisDashboardModel {
    
    
     public boolean createIndicator( String dashboard,String type) {
        boolean created = true;

        Node AISParent;
        GraphDatabaseService db = ICTCDBUtil.getInstance().getGraphDB();
        Transaction trx = db.beginTx();
        try{

            Node AISNode = db.createNode(Labels.INDICATOR);

           Aisdashboard dash = new Aisdashboard(AISNode);

            if (null == dashboard) {
                log.info("Indicator is invalid");
                created = false;
            } else {
               
              dash.setData(dashboard);
              dash.setType(type);
              dash.setLastModifiedDate(new Date().getTime());
              

              log.log(Level.INFO, "new node created {0}", dash.getUnderlyingNode().getId());
                
                

            }
          trx.success();
        } catch (Exception e) {

            created = false;
            log.severe("Creation of Indicator Failed");
            e.printStackTrace();
           trx.failure();
            
        }
        finally
        {
            trx.close();
           
        }

        return created;
    }
     
     
     
      private List<AisdashboardWrapper> userQuery(String q, String returnedItem) {
        List<AisdashboardWrapper> usrs = new ArrayList<>();
        System.out.println("Query : " + q);
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            ResourceIterator<Node> n_column = Neo4jServices.executeIteratorQuery(q, returnedItem);
            while (n_column.hasNext()) {
                Aisdashboard aisdashboard = new Aisdashboard(n_column.next());
                AisdashboardWrapper wr = new AisdashboardWrapper();
                wr.setData(aisdashboard.getData());
                wr.setType(aisdashboard.getType());
              
                usrs.add(wr);
             
              trx.success();
            }

        }
        return usrs;
    }
      
      
   public AisdashboardWrapper findIndicator(String type) {
       
        String q = "match (l:"+Labels.INDICATOR+" WHERE l." + Aisdashboard.TYPE + "= '" + type + "'  "
                //+ "and  l." + User.PASSWORD + "='" + (password) + "'"
                + "  return l";
        System.out.println("query---------------------- : " + q);
        List<AisdashboardWrapper> usr = userQuery(q, "l");
        if (null != usr && !usr.isEmpty()) {
            return usr.get(0);
        }
        return null;
    }
        
    
        
      public Aisdashboard getIndicator(String field, String value) {
       
         
       try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) { 
        String q = "match (l:INDICATOR)"+" where l." + field + "='" + value + "'" +" return l";

        System.out.println("Query " + q);
        try {
            Node node = Neo4jServices.executeCypherQuerySingleResult(q, "l");
          if (null != node) {
              AisdashboardWrapper aw = new AisdashboardWrapper();
               return new Aisdashboard(node);
           }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to Find Dashboard Indicator");
        }
        
        trx.success();
       }
       return null;
      

        
    }
    
      
      
      
   public AisdashboardWrapper getIndicatorWrapper(String field, String value) {
       
         
       try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) { 
        String q = "match (l:INDICATOR)"+" where l." + field + "='" + value + "'" +" return l";

        System.out.println("Query " + q);
        try {
            Node node = Neo4jServices.executeCypherQuerySingleResult(q, "l");
          if (null != node) {
              AisdashboardWrapper aw = new AisdashboardWrapper();
              Aisdashboard ais = new Aisdashboard(node);
              aw.setData(ais.getData());
              aw.setType(ais.getType());
               
              return  aw;
           }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to Find Dashboard Indicator");
        }
        
        trx.success();
       }
       return null;
      

        
    }
        
    public boolean IndicatorUpdate(String id, Map<String, String> data) {
         
        boolean updated = false;
          Aisdashboard d  = getIndicator(Aisdashboard.TYPE, id);
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
             System.out.println("dash " + d.getData());
            //If the setting is not null
            if (null != d) {

                for (Map.Entry<String, String> dataEntry : data.entrySet()) {

                    // get the field name
                    String fieldName = dataEntry.getKey();
                    // get the field value
                    String fieldValue = dataEntry.getValue();
                    System.out.println("Updating : "+fieldName+" <> "+fieldValue);
                    // Assigning the alias
                    if (fieldName.equalsIgnoreCase(Aisdashboard.DATA)) {
                        if (null != fieldValue) {
                            d.setData(fieldValue);
                        }
                    }
                   
                    
                    
                }
               

                updated = true;
                log.log(Level.INFO, "Bio Data Successfully Updated {0}", updated);
                 trx.success();
               
            } else {

                log.info("Unable to update Agent");
                 trx.success();
            }
        }
        return updated;
    }

}
