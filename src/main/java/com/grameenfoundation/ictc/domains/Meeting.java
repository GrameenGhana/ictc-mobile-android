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
 * @author Joseph George Davis
 * @date Aug 30, 2015 2:08:10 PM
 * description:
 */
public class Meeting extends Status implements  GeneralInterface
{

    public static String TYPE = "type";
    public static String MEETING_INDEX = "index";
    public static String SEASON ="season";
    public static String START_DATE ="startdate";
    public static String END_DATE = "enddate";
    public static String ATTENDED = "attended";
    
    Node underlyingNode;

    public Meeting(Node underlyingNode) {
        super(underlyingNode);
        
        this.underlyingNode = underlyingNode;
    }
   
    
     public String getAttended() {
         try {
            return (String) underlyingNode.getProperty(ATTENDED);

        } catch (Exception e) {
        }
        return null;
         
    }

    public void setAttended(String attended) {
         underlyingNode.setProperty(ATTENDED, attended);
    }
    
    public void setType(String type) {
        underlyingNode.setProperty(TYPE, type);
    }

    public String getType() {
        try {
            return (String) underlyingNode.getProperty(TYPE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setMeetingIndex(String index) {
        underlyingNode.setProperty(MEETING_INDEX, index);
    }

    public String getMeetingIndex() {
        try {
            return (String) underlyingNode.getProperty(MEETING_INDEX);

        } catch (Exception e) {
        }
        return null;
    }

    public void setSeason(String season) {
        underlyingNode.setProperty(SEASON, season);
    }

    public String getSeason() {
        try {
            return (String) underlyingNode.getProperty(SEASON);

        } catch (Exception e) {
        }
        return null;
    }

    public void setStartdate(String startdate) {
        underlyingNode.setProperty(START_DATE, startdate);
    }

    public String getStartdate() {
        try {
            return (String) underlyingNode.getProperty(START_DATE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setEnddate(String enddate) {
        underlyingNode.setProperty(END_DATE, enddate);
    }

    public String getEnddate() {
        try {
            return (String) underlyingNode.getProperty(END_DATE);

        } catch (Exception e) {
        }
        return null;
    }

}
