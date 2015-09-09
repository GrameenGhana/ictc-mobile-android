/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.utils;

import org.neo4j.graphdb.Node;

/**
 *
 * @author Spomega
 * @Date Mar 8, 2015
 * @Email spomegasys@gmail.com
 * @Description 
 */
public class ParentNode {
    
    
   
    
    public static Node FarmerParentNode() {
        return Neo4jServices.getReferenceNodeCreatIfNotExist(ICTCKonstants.FARMER);
    }
   
      public static Node FMParentNode() {
        return Neo4jServices.getReferenceNodeCreatIfNotExist(ICTCKonstants.FM);
    }
      
       public static Node OperationsParentNode() {
        return Neo4jServices.getReferenceNodeCreatIfNotExist(ICTCKonstants.OPERATIONS);
    }
    
         public static Node HarvestParentNode() {
        return Neo4jServices.getReferenceNodeCreatIfNotExist(ICTCKonstants.HARVEST);
    }
    
         public static Node PostHarvestParentNode() {
        return Neo4jServices.getReferenceNodeCreatIfNotExist(ICTCKonstants.POST_HARVEST);
    }
         
      public static Node StorageParentNode() {
        return Neo4jServices.getReferenceNodeCreatIfNotExist(ICTCKonstants.STORAGE);
    }
      
     public static Node MarketingParentNode() {
        return Neo4jServices.getReferenceNodeCreatIfNotExist(ICTCKonstants.MARKETING);
    }  
    
      public static Node TechNeedParentNode() {
        return Neo4jServices.getReferenceNodeCreatIfNotExist(ICTCKonstants.TECHNICAL_NEED);
    }  
      
       public static Node  FMPlanParentNode() {
        return Neo4jServices.getReferenceNodeCreatIfNotExist(ICTCKonstants.FMP);
    }  
       
           public static Node  AgentParentNode() {
        return Neo4jServices.getReferenceNodeCreatIfNotExist(ICTCKonstants.USER);
    }  
           
           
   public static Node  MeetingParentNode() {
        return Neo4jServices.getReferenceNodeCreatIfNotExist(ICTCKonstants.MEETING);
    }  public static Node  CropCalendarSettingsNode() {
        return Neo4jServices.getReferenceNodeCreatIfNotExist(ICTCKonstants.CROP_CALENDAR_SETTINGS);
    }  
    public static Node  FarmInputReceivedNode() {
        return Neo4jServices.getReferenceNodeCreatIfNotExist(ICTCKonstants.FARMER_INPUT_RECEIVED);
    }  
}
