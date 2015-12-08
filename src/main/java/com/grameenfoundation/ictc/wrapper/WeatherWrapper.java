/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.wrapper;

/**
 *
 * @author skwakwa
 */
public class WeatherWrapper {
    private String location;
    private String locationId;
    private String longitude;
    private String latitude;
    
    private String icon;
    private float temprature;
    private float minTemprature;
    private float maxTemprature;
    private String detail;
    private long time;

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * @return the temprature
     */
    public float getTemprature() {
        return temprature;
    }

    /**
     * @param temprature the temprature to set
     */
    public void setTemprature(float temprature) {
        this.temprature = temprature;
    }

    /**
     * @return the time
     */
    public long getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(long time) {
        this.time = time;
    }

    /**
     * @return the minTemprature
     */
    public float getMinTemprature() {
        return minTemprature;
    }

    /**
     * @param minTemprature the minTemprature to set
     */
    public void setMinTemprature(float minTemprature) {
        this.minTemprature = minTemprature;
    }

    /**
     * @return the maxTemprature
     */
    public float getMaxTemprature() {
        return maxTemprature;
    }

    /**
     * @param maxTemprature the maxTemprature to set
     */
    public void setMaxTemprature(float maxTemprature) {
        this.maxTemprature = maxTemprature;
    }

    /**
     * @return the detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * @param detail the detail to set
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * @return the locationId
     */
    public String getLocationId() {
        return locationId;
    }

    /**
     * @param locationId the locationId to set
     */
    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }
    
    
    
    
}
