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
public class CommunityCounterWrapper {
    private String community;
    private long noOfFarmers;

    public CommunityCounterWrapper() {
    }

    
    public CommunityCounterWrapper(String community, long noOfFarmers) {
        this.community = community;
        this.noOfFarmers = noOfFarmers;
    }
    
    

    /**
     * @return the community
     */
    public String getCommunity() {
        return community;
    }

    /**
     * @param community the community to set
     */
    public void setCommunity(String community) {
        this.community = community;
    }

    /**
     * @return the noOfFarmers
     */
    public long getNoOfFarmers() {
        return noOfFarmers;
    }

    /**
     * @param noOfFarmers the noOfFarmers to set
     */
    public void setNoOfFarmers(long noOfFarmers) {
        this.noOfFarmers = noOfFarmers;
    }
}
