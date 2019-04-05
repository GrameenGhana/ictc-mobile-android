/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.domains;

import com.grameenfoundation.ictc.domain.commons.GeneralInterface;
import com.grameenfoundation.ictc.domain.commons.Status;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCUtil;
import java.util.Date;
import org.neo4j.graphdb.Node;

/**
 *
 * @author skwakwa
 */
public class FarmerInputReceived extends Status implements GeneralInterface {
    Node underlyingNode;
    
     public static String NAME = "name";
     public static String QTY ="qty";
    public static String DATE_RECEIVED ="date_received";
    
  

    public FarmerInputReceived(Node underlyingNode) {
         super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }
    
    
    
    public String getName(){
     
        try {
             return  (String)  underlyingNode.getProperty(NAME);
        } catch (Exception e) {
        }
       return  "";
    }
    
    
   public void setName(String name){
        underlyingNode.setProperty(NAME, name);
    }
    
   
   public double getQty(){
     
        try {
             return  (Double)  underlyingNode.getProperty(NAME);
        } catch (Exception e) {
        }
       return  0.0;
    }
    
    
   public void setQty(double name){
        underlyingNode.setProperty(QTY, name);
    }
   
    public Date getDateReceived(){
     
        try {
             return  ICTCUtil.LongToDate((Long)  underlyingNode.getProperty(DATE_RECEIVED));
        } catch (Exception e) {
        }
       return  null;
    }
    
    
   public void setDateReceived(Date date){
        underlyingNode.setProperty(DATE_RECEIVED,ICTCUtil.dateToLong(date));
    }
   
    
}
