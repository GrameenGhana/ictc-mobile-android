/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.wrapper;

import java.util.Date;

/**
 *
 * @author skwakwa
 */
public class FarmerInputReceivedWrapper {
    
    
    private String name;
    private Date dateReceived;
    private String status;
    private double qty;
    private String farmer;

    public FarmerInputReceivedWrapper() {
    }

    
    public FarmerInputReceivedWrapper(String name, Date dateReceived, String status, double qty) {
        this.name = name;
        this.dateReceived = dateReceived;
        this.status = status;
        this.qty = qty;
    }

    public FarmerInputReceivedWrapper(String name, Date dateReceived, String status, double qty, String farmer) {
        this.name = name;
        this.dateReceived = dateReceived;
        this.status = status;
        this.qty = qty;
        this.farmer = farmer;
    }
    
    

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the dateReceived
     */
    public Date getDateReceived() {
        return dateReceived;
    }

    /**
     * @param dateReceived the dateReceived to set
     */
    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the qty
     */
    public double getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(double qty) {
        this.qty = qty;
    }

    /**
     * @return the farmer
     */
    public String getFarmer() {
        return farmer;
    }

    /**
     * @param farmer the farmer to set
     */
    public void setFarmer(String farmer) {
        this.farmer = farmer;
    }
    
    
}
