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
 * @author Joseph George Davis
 * @date Sep 14, 2015 5:43:53 PM
 * description:
 */
public class Cordinates extends Status implements GeneralInterface{

    public static String LONGITUDE = "longitude";
    public static String LATITUDE = "latitude";
    
    public Cordinates(Node underlyingNode) {
        super(underlyingNode);
    }
    
     Node underlyingNode;
    
    public double getLongitude() {
        try {
            return (Double) underlyingNode.getProperty(LONGITUDE);

        } catch (Exception e) {
        }
        return 0l;
    }

    public void setLongitude(double longitude) {
         underlyingNode.setProperty(LONGITUDE,longitude);
    }

    public double getLatitude() {
          try {
            return (Double) underlyingNode.getProperty(LATITUDE);

        } catch (Exception e) {
        }
        return 0l;
    }

    public void setLatitude(double latitude) {
         underlyingNode.setProperty(LATITUDE,latitude);
    }
    

}
