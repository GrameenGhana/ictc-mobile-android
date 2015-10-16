/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.utils;

import org.neo4j.graphdb.RelationshipType;

/**
 *
 * @author Joseph George Davis
 * @date Jul 16, 2015 10:49:08 AM
 * @description-
 */
public enum ICTCRelationshipTypes implements RelationshipType{

    //A
     AGENT,
     
     //
     BASELINE_PRODUCTION_BUDGET,
     BASELINE_PRODUCTION,
     BASELINE_POSTHARVEST_BUDGET,
     BASELINE_POSTHARVEST,
     //C
    CREATED_BY,
    CROP_CALENDAR_SETTING,
    CROP_CALENDAR,
    
    //E
    ENTITY,
    
    //F
    FARMER,
    FARM_MANAGEMENT,
    FARM_OPERATION,
    FARM_MANAGEMENT_PLAN,
    FARM_INPUT_RECEIVED,
    FMP_PRODUCTION_BUDGET,
    FMP_PRODUCTION_BUDGET_UPDATE,
    FMP_POSTHARVEST_BUDGET,
    //H
    HAS_FARM_MANAGEMENT_PLAN,
    HAS_FARM_MANAGEMENT,
    HAS_FARM_OPERATION,
    HAS_HARVEST,
    HAS_POSTHARVEST,
    HAS_PRODUCTION,
    HAS_PROFILING,
    HAS_STORAGE,
    HAS_MARKETING,
    HAS_TECHNEEDS,
    HARVEST,
    HAS_CROP_CALENDAR,
    HAS_MEETING,
    HAS_FARMER,
    HAS_FARM_INPUT,
    HAS_BASELINE_PRODUCTION_BUDGET,
    HAS_BASELINE_POSTHARVEST_BUDGET,
    HAS_BASELINE_POSTHARVEST,
    HAS_PRODUCTION_BUDGET_UPDATE, 
    HAS_PRODUCTION_BUDGET,
    HAS_POSTHARVEST_BUDGET,
    //L
    LAST_MODIFIED_BY,
    
    //O
  
    //M
    MARKETING,
    MEETING,
    MEETING_SETTING,
    MEETING_ACTIVITY,
    MOBILE_TACKER,
    //P
    POST_HARVEST,
    PRODUCTION,
    
    //Q
    QUESTION,
    //S
    STORAGE,
    
    //R
     ROLE,
    
    //
     TECHNICAL_NEED,
    //U
    USER,
    UPDATE,  
}
