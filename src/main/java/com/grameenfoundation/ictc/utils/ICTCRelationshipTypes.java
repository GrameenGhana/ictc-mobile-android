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
    //H
    HAS_FARM_MANAGEMENT_PLAN,
    HAS_FARM_MANAGEMENT,
    HAS_FARM_OPERATION,
    HAS_HARVEST,
    HAS_POSTHARVEST,
    HAS_STORAGE,
    HAS_MARKETING,
    HAS_TECHNEEDS,
    HARVEST,
    HAS_CROP_CALENDAR,
    HAS_MEETING,
    HAS_FARMER,
    HAS_FARM_INPUT,
    //L
    LAST_MODIFIED_BY,
    
    //O
  
    //M
    MARKETING,
    MEETING,
    //P
    POST_HARVEST,
    //S
    STORAGE,
    
    //R
     ROLE,
    
    //
     TECHNICAL_NEED,
    //U
    USER
}
