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
public class CropCalendarWrapper {
    
    
    private Date actualDate;
    private Date earliestDate;
    private Date latestDate;
    private String activity;
    private int activityIndex;
    private int weeksFromPlanting;
    private String comment;
    private String season;
    private String farmerId;

    public CropCalendarWrapper() {
    }

    
    
    public CropCalendarWrapper(Date actualDate, Date earliestDate, Date latestDate, String activity, int activityIndex, int weeksFromPlanting, String comment) {
        this.actualDate = actualDate;
        this.earliestDate = earliestDate;
        this.latestDate = latestDate;
        this.activity = activity;
        this.activityIndex = activityIndex;
        this.weeksFromPlanting = weeksFromPlanting;
        this.comment = comment;
    }

    
    
    /**
     * @return the actualDate
     */
    public Date getActualDate() {
        return actualDate;
    }

    /**
     * @param actualDate the actualDate to set
     */
    public void setActualDate(Date actualDate) {
        this.actualDate = actualDate;
    }

    /**
     * @return the earliestDate
     */
    public Date getEarliestDate() {
        return earliestDate;
    }

    /**
     * @param earliestDate the earliestDate to set
     */
    public void setEarliestDate(Date earliestDate) {
        this.earliestDate = earliestDate;
    }

    /**
     * @return the latestDate
     */
    public Date getLatestDate() {
        return latestDate;
    }

    /**
     * @param latestDate the latestDate to set
     */
    public void setLatestDate(Date latestDate) {
        this.latestDate = latestDate;
    }

    /**
     * @return the activity
     */
    public String getActivity() {
        return activity;
    }

    /**
     * @param activity the activity to set
     */
    public void setActivity(String activity) {
        this.activity = activity;
    }

    /**
     * @return the activityIndex
     */
    public int getActivityIndex() {
        return activityIndex;
    }

    /**
     * @param activityIndex the activityIndex to set
     */
    public void setActivityIndex(int activityIndex) {
        this.activityIndex = activityIndex;
    }

    /**
     * @return the weeksFromPlanting
     */
    public int getWeeksFromPlanting() {
        return weeksFromPlanting;
    }

    /**
     * @param weeksFromPlanting the weeksFromPlanting to set
     */
    public void setWeeksFromPlanting(int weeksFromPlanting) {
        this.weeksFromPlanting = weeksFromPlanting;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the season
     */
    public String getSeason() {
        return season;
    }

    /**
     * @param season the season to set
     */
    public void setSeason(String season) {
        this.season = season;
    }

    /**
     * @return the farmerId
     */
    public String getFarmerId() {
        return farmerId;
    }

    /**
     * @param farmerId the farmerId to set
     */
    public void setFarmerId(String farmerId) {
        this.farmerId = farmerId;
    }
}
