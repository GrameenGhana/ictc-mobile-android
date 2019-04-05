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
public class FarmGPSLocationWrapper {

    private long id;
    private String latitude;
    private String longitude;
    private String farmerId;

    public  FarmGPSLocationWrapper(int id,String latitude,String longitude,String farmerId){

        this.setId(id);
        this.setLatitude(latitude);
        this.setLongitude(longitude);
        this.setFarmerId(farmerId);
    }

    public  FarmGPSLocationWrapper(String latitude,String longitude,String farmerId){

        this.setLatitude(latitude);
        this.setLongitude(longitude);
        this.setFarmerId(farmerId);
    }

    
    public FarmGPSLocationWrapper() {
    }
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(String farmerId) {
        this.farmerId = farmerId;
    }
}