/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.wrapper;

import org.json.JSONObject;

/**
 *
 * @author skwakwa
 */
public class MobileTrackerWrapper {

    private String id;
    private String userId;
    private String module;
    private String data;
    private String page;
    private String section;
    private long startTime;
    private long endTime;
    private long timeSpent;
    private String imei;
    private String version;
    private long battery;

    public MobileTrackerWrapper() {
    }

    
    public MobileTrackerWrapper(String id, String userId, String module, String data, String page, String section, long startTime, long endTime, long timeSpent, String imei, String version, long battery) {
        this.id = id;
        this.userId = userId;
        this.module = module;
        this.data = data;
        this.page = page;
        this.section = section;
        this.startTime = startTime;
        this.endTime = endTime;
        this.timeSpent = timeSpent;
        this.imei = imei;
        this.version = version;
        this.battery = battery;
    }

    public MobileTrackerWrapper(String id, String userId, String module, String data, long startTime, long endTime) {
        this.id = id;
        this.userId = userId;
        this.module = module;
        this.data = data;

        this.startTime = startTime;
        this.endTime = endTime;
        this.timeSpent = endTime - startTime;
        JSONObject obj = new JSONObject(data);
        if (obj != null) {
            this.page = obj.getString("page");
            this.section = obj.getString("section");
            this.imei = obj.getString("imei");
            this.version = obj.getString("version");
            this.battery = Integer.parseInt(obj.getString("battery"));
        }else{
            this.page=data;
            this.section="";
            this.battery=0;
            this.version="";
        }
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the module
     */
    public String getModule() {
        return module;
    }

    /**
     * @param module the module to set
     */
    public void setModule(String module) {
        this.module = module;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the page
     */
    public String getPage() {
        return page;
    }

    /**
     * @param page the page to set
     */
    public void setPage(String page) {
        this.page = page;
    }

    /**
     * @return the section
     */
    public String getSection() {
        return section;
    }

    /**
     * @param section the section to set
     */
    public void setSection(String section) {
        this.section = section;
    }

    /**
     * @return the startTime
     */
    public long getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endTime
     */
    public long getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    /**
     * @return the timeSpent
     */
    public long getTimeSpent() {
        return timeSpent;
    }

    /**
     * @param timeSpent the timeSpent to set
     */
    public void setTimeSpent(long timeSpent) {
        this.timeSpent = timeSpent;
    }

    /**
     * @return the imei
     */
    public String getImei() {
        return imei;
    }

    /**
     * @param imei the imei to set
     */
    public void setImei(String imei) {
        this.imei = imei;
    }

    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * @return the battery
     */
    public long getBattery() {
        return battery;
    }

    /**
     * @param battery the battery to set
     */
    public void setBattery(long battery) {
        this.battery = battery;
    }

}
