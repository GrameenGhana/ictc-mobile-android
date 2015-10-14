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

    public static Node FMPlanParentNode() {
        return Neo4jServices.getReferenceNodeCreatIfNotExist(ICTCKonstants.FMP);
    }

    public static Node AgentParentNode() {
        return Neo4jServices.getReferenceNodeCreatIfNotExist(ICTCKonstants.USER);
    }

    public static Node MeetingParentNode() {
        return Neo4jServices.getReferenceNodeCreatIfNotExist(ICTCKonstants.MEETING);
    }

    public static Node MeetingSettingParentNode() {
        return Neo4jServices.getReferenceNodeCreatIfNotExist(ICTCKonstants.MEETING_SETTING);
    }

    public static Node MeetingActivityParentNode() {
        return Neo4jServices.getReferenceNodeCreatIfNotExist(ICTCKonstants.MEETING_ACTIVITY);
    }

    public static Node CropCalendarSettingsNode() {
        return Neo4jServices.getReferenceNodeCreatIfNotExist(ICTCKonstants.CROP_CALENDAR_SETTINGS);
    }

    public static Node FarmInputReceivedNode() {
        return Neo4jServices.getReferenceNodeCreatIfNotExist(ICTCKonstants.FARMER_INPUT_RECEIVED);
    }

    public static Node ProductionParentNode() {
        return Neo4jServices.getReferenceNodeCreatIfNotExist(ICTCKonstants.PRODUCTION);
    }  
     
     public static Node  QuestionParentNode() {
        return Neo4jServices.getReferenceNodeCreatIfNotExist(ICTCKonstants.PROFILING);
    }  
     
     public static Node  BPBParentNode() {
        return Neo4jServices.getReferenceNodeCreatIfNotExist(ICTCKonstants.BASELINE_PRODUCTION_BUDGET);
    }  
     
   public static Node  BPParentNode() {
        return Neo4jServices.getReferenceNodeCreatIfNotExist(ICTCKonstants.BASELINE_PRODUCTION);
    }  
    public static Node  BPHParentNode() {
        return Neo4jServices.getReferenceNodeCreatIfNotExist(ICTCKonstants.BASELINE_POST_HARVEST);
    }  
   
   public static Node  BPHBParentNode() {
        return Neo4jServices.getReferenceNodeCreatIfNotExist(ICTCKonstants.BASELINE_POST_HARVEST_BUDGET);
    } 
   
   public static Node  FMPPBparentNode() {
        return Neo4jServices.getReferenceNodeCreatIfNotExist(ICTCKonstants.FMP_PRODUCTION_BUDGET);
    }  
   
    public static Node   FMPPBUparentNode() {
        return Neo4jServices.getReferenceNodeCreatIfNotExist(ICTCKonstants.FMP_PRODUCTION_BUDGET_UPDATE);
    }  
}
