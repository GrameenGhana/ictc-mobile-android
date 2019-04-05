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
public class Weather extends Status implements GeneralInterface {

    Node underlyingNode;
    /**
     *
     * private String location; private String longitude; private String ;
     *
     * private String icon; private float temperature; private String detail;
     * private long time;
     */

    public static String LOCATION = "location";
    public static String LOCATION_ID = "locationId";
    public static String LONGITUDE = "longitude";
    public static String LATITUDE = "latitude";
    public static String ICON = "icon";
    public static String TEMPERATUR = "temperature";
    public static String MIN_TEMPERATUR = "max_temperature";
    public static String MAX_TEMPERATUR = "min_temperature";
    public static String DETAIL = "detail";
    public static String TIME = "time";

    public Weather(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        try {

            return (String) underlyingNode.getProperty(LOCATION);
        } catch (Exception e) {
        }
        return "";
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        underlyingNode.setProperty(LOCATION, location);
    }

    public String getLocationId() {
        try {

            return (String) underlyingNode.getProperty(LOCATION_ID);
        } catch (Exception e) {
        }
        return "";
    }

    /**
     * @param location the location to set
     */
    public void setLocationId(String location) {
        underlyingNode.setProperty(LOCATION_ID, location);
    }

    public String getDetail() {
        try {

            return (String) underlyingNode.getProperty(DETAIL);
        } catch (Exception e) {
        }
        return "";
    }

    /**
     * @param location the location to set
     */
    public void setDetail(String detail) {
        underlyingNode.setProperty(DETAIL, detail);
    }

    /**
     * @return the longitude
     */
    public String getLongitude() {
        try {

            return (String) underlyingNode.getProperty(LONGITUDE);
        } catch (Exception e) {
        }
        return "";
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(String longitude) {
        underlyingNode.setProperty(LONGITUDE, longitude);
    }

    /**
     * @return the latitude
     */
    public String getLatitude() {
        try {

            return (String) underlyingNode.getProperty(LATITUDE);
        } catch (Exception e) {
        }
        return "";
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(String latitude) {
        underlyingNode.setProperty(LATITUDE, latitude);
    }

    /**
     * @return the icon
     */
    public String getIcon() {
        try {

            return (String) underlyingNode.getProperty(ICON);
        } catch (Exception e) {
        }
        return "";
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(String icon) {
        underlyingNode.setProperty(ICON, icon);
    }

    /**
     * @return the temprature
     */
    public float getTemprature() {
        try {

            return (Float) underlyingNode.getProperty(TEMPERATUR);
        } catch (Exception e) {
        }
        return 0;
    }

    /**
     * @param temprature the temprature to set
     */
    public void setTemprature(float temprature) {
        underlyingNode.setProperty(TEMPERATUR, temprature);
    }

    
    
     /**
     * @return the temprature
     */
    public float getMaxTemprature() {
        try {

            return (Float) underlyingNode.getProperty(MAX_TEMPERATUR);
        } catch (Exception e) {
        }
        return 0;
    }

    /**
     * @param temprature the temprature to set
     */
    public void setMaxTemprature(float temprature) {
        underlyingNode.setProperty(MAX_TEMPERATUR, temprature);
    }
    
    
    
     /**
     * @return the temprature
     */
    public float getMinTemprature() {
        try {

            return (float) underlyingNode.getProperty(MIN_TEMPERATUR);
        } catch (Exception e) {
        }
        return 0;
    }

    /**
     * @param temprature the temprature to set
     */
    public void setMinTemprature(float temprature) {
        underlyingNode.setProperty(MIN_TEMPERATUR, temprature);
    }
    /**
     * @return the time
     */
    public long getTime() {
        try {

            return (Long) underlyingNode.getProperty(TIME);
        } catch (Exception e) {
        }
        return 0;
    }

    /**
     * @param time the time to set
     */
    public void setTime(long time) {
        underlyingNode.setProperty(TIME, time);
    }

}
