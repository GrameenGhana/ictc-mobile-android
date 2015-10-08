/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.wrapper;

import com.grameenfoundation.ictc.domains.MeetingActivity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skwakwa
 */
public class MeetingSettingWrapper {

    String type;
    String meetingIndex;
    String season;
    String startDate;
    String endDate;
    String crop;

    List<MeetingActivityWrapper> meetingActivities = new ArrayList<MeetingActivityWrapper>();

    public MeetingSettingWrapper() {
    }

    public MeetingSettingWrapper(String type, String meetingIndex, String season, String startDate, String endDate) {
        this.type = type;
        this.meetingIndex = meetingIndex;
        this.season = season;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public MeetingSettingWrapper(String crop,String type, String meetingIndex, String season, String startDate, String endDate, List<MeetingActivityWrapper> meetingActivities) {
        this.type = type;
        this.meetingIndex = meetingIndex;
        this.season = season;
        this.startDate = startDate;
        this.endDate = endDate;
        this.meetingActivities = meetingActivities;
        this.crop = crop;
    }

    public MeetingSettingWrapper(String crop,String type, String meetingIndex, String season, String startDate, String endDate, String acts) {
        this.type = type;
        this.meetingIndex = meetingIndex;
        this.season = season;
        this.startDate = startDate;
        this.crop = crop;
        this.endDate = endDate;
        String[] strings = acts.split(",");
        int indx = 1;
        for (String string : strings) {
            MeetingActivityWrapper ma = new MeetingActivityWrapper(indx, string);
            indx++;
            meetingActivities.add(ma);
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
    
     public String getCrop() {
        return crop;
    }

    public void setCrop(String type) {
        this.crop = type;
    }
    public String getMeetingIndex() {
        return meetingIndex;
    }

    public void setMeetingIndex(String meeting) {
        this.meetingIndex = meeting;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the meetingActivities
     */
    public List<MeetingActivityWrapper> getMeetingActivities() {
        return meetingActivities;
    }

    /**
     * @param meetingActivities the meetingActivities to set
     */
    public void setMeetingActivities(List<MeetingActivityWrapper> meetingActivities) {
        this.meetingActivities = meetingActivities;
    }

}
