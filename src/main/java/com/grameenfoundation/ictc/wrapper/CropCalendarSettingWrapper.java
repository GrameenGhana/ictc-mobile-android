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
public class CropCalendarSettingWrapper {
    private String crop;
    private int startWeek;
    private int endWeek;
    private String activity;

    public CropCalendarSettingWrapper() {
    }

    
    
    public CropCalendarSettingWrapper(String crop, int startWeek, int endWeek, String activity) {
        this.crop = crop;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.activity = activity;
    }

    
    /**
     * @return the crop
     */
    public String getCrop() {
        return crop;
    }

    /**
     * @param crop the crop to set
     */
    public void setCrop(String crop) {
        this.crop = crop;
    }

    /**
     * @return the startWeek
     */
    public int getStartWeek() {
        return startWeek;
    }

    /**
     * @param startWeek the startWeek to set
     */
    public void setStartWeek(int startWeek) {
        this.startWeek = startWeek;
    }

    /**
     * @return the endWeek
     */
    public int getEndWeek() {
        return endWeek;
    }

    /**
     * @param endWeek the endWeek to set
     */
    public void setEndWeek(int endWeek) {
        this.endWeek = endWeek;
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
}
