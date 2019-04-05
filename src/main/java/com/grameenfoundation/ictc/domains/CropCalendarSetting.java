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
public class CropCalendarSetting extends Status implements GeneralInterface {

    public static String CROP = "crop";
    public static String START_WEEK = "start_week";
    public static String END_WEEK = "end_week";
    public static String ACTIVITY = "activity";


private Node underlyingNode;
    public CropCalendarSetting(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }

    /**
     * @return the crop
     */
    public String getCrop() {
        try {
            return (String) getUnderlyingNode().getProperty(CROP);
        } catch (Exception e) {
        }
        return  "";
    }

    /**
     * @param crop the crop to set
     */
    public void setCrop(String crop) {
        getUnderlyingNode().setProperty(CROP, crop);
                
    }

    /**
     * @return the startWeek
     */
    public int getStartWeek() {
        try {
            return (Integer) getUnderlyingNode().getProperty(START_WEEK);
        } catch (Exception e) {
        }
        return  0;
    }

    /**
     * @param startWeek the startWeek to set
     */
    public void setStartWeek(int startWeek) {
        getUnderlyingNode().setProperty(START_WEEK, startWeek);
    }

    /**
     * @return the endWeek
     */
    public int getEndWeek() {
          try {
            return (Integer) getUnderlyingNode().getProperty(END_WEEK);
        } catch (Exception e) {
        }
        return  0;
    }

    /**
     * @param endWeek the endWeek to set
     */
    public void setEndWeek(int endWeek) {
        getUnderlyingNode().setProperty(END_WEEK, endWeek);
    }

    /**
     * @return the activity
     */
    public String getActivity() {
        try {
            return (String) getUnderlyingNode().getProperty(ACTIVITY);
        } catch (Exception e) {
        }
        return  "";
    }

    /**
     * @param activity the activity to set
     */
    public void setActivity(String activity) {
         getUnderlyingNode().setProperty(ACTIVITY, activity);
    }

    /**
     * @return the underlyingNode
     */
    public Node getUnderlyingNode() {
        return underlyingNode;
    }

    /**
     * @param underlyingNode the underlyingNode to set
     */
    public void setUnderlyingNode(Node underlyingNode) {
        this.underlyingNode = underlyingNode;
    }

}
