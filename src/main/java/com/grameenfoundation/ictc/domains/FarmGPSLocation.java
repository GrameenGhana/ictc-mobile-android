/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.domains;

import com.grameenfoundation.ictc.domain.commons.GeneralInterface;
import com.grameenfoundation.ictc.domain.commons.Status;
import org.neo4j.graphdb.Node;

/**
 *
 * @author skwakwa
 */
public class FarmGPSLocation extends Status implements GeneralInterface {

    public static String ID = "id";
    public static String LATITUDE = "latitude";
    public static String LONGITUDE = "longitude";
    public static String FARMER_ID = "farmerId";

    Node underlyingNode;
    public FarmGPSLocation(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }
    
    
    
    public long getGPSId() {
        try {
            return (Long) underlyingNode.getProperty(ID);
        } catch (Exception e) {
        }
        return  0l;
   
    }

    public void setGPSId(long id) {
        underlyingNode.setProperty(ID, id);
    }

    public String getLatitude() {
        try {
            return (String) underlyingNode.getProperty(LATITUDE);
        } catch (Exception e) {
        }
        return  "0";
    }

    public void setLatitude(String latitude) {
       underlyingNode.setProperty(LATITUDE, latitude );
    }

    public String getLongitude() {
        try {
            return (String) underlyingNode.getProperty(LONGITUDE);
        } catch (Exception e) {
        }
        return  "0";
    }

    public void setLongitude(String longitude) {
       
       underlyingNode.setProperty(LONGITUDE, longitude );
    }

    public String getFarmerId() {
        try {
            return (String) underlyingNode.getProperty(FARMER_ID);
        } catch (Exception e) {
        }
        return  "";
    }

    public void setFarmerId(String farmerId) {
        underlyingNode.setProperty(FARMER_ID, farmerId);
    }

}
