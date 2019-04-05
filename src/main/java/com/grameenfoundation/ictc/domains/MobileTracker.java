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
public class MobileTracker extends Status implements GeneralInterface {

    public static String ID = "id";
    public static String USER_ID = "id";
    public static String MODULE = "module";
    public static String PAGE = "page";
    public static String DATA = "data";
    public static String START_DATE = "startdate";
    public static String END_DATE = "enddate";
    public static String SECTION = "section";
    public static String VERSION = "version";
    public static String IMEI = "imei";
    public static String BATTERY = "battery";
    public static String TIME_SPENT = "time_spent";

    Node underlyingNode;

    public MobileTracker(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }

    public long getTrackerId() {
        try {
            return (Long) underlyingNode.getProperty(ID);
        } catch (Exception e) {
        }
        return 0l;
    }

    public void setTrackerId(long id) {
        underlyingNode.setProperty(ID, id);
    }

    public long getTimeSpent() {
        try {
            return (Long) underlyingNode.getProperty(TIME_SPENT);
        } catch (Exception e) {
        }
        return 0l;
    }

    public void setTimeSpent(long id) {
        underlyingNode.setProperty(TIME_SPENT, id);
    }
    
    
     public long getEndDate() {
        try {
            return (Long) underlyingNode.getProperty(END_DATE);
        } catch (Exception e) {
        }
        return 0l;
    }

    public void setEndDate(long id) {
        underlyingNode.setProperty(END_DATE, id);
    }

    
    
    public long getStartDate() {
        try {
            return (Long) underlyingNode.getProperty(START_DATE);
        } catch (Exception e) {
        }
        return 0l;
    }

    public void setStartDate(long id) {
        underlyingNode.setProperty(START_DATE, id);
    }
    public String getModule() {
        try {
            return (String) underlyingNode.getProperty(MODULE);
        } catch (Exception e) {
        }
        return "";
    }

    public void setModule(String module) {
        underlyingNode.setProperty(MODULE, module);
    }

    public String getData() {
        try {
            return (String) underlyingNode.getProperty(DATA);
        } catch (Exception e) {
        }
        return "";
    }

    public void setData(String module) {
        underlyingNode.setProperty(DATA, module);
    }

    public String getSection() {
        try {
            return (String) underlyingNode.getProperty(SECTION);
        } catch (Exception e) {
        }
        return "";
    }

    public void setSection(String module) {
        underlyingNode.setProperty(SECTION, module);
    }

    public String getPage() {
        try {
            return (String) underlyingNode.getProperty(PAGE);
        } catch (Exception e) {
        }
        return "";
    }

    public void setPage(String module) {
        underlyingNode.setProperty(PAGE, module);
    }

    public String getVersion() {
        try {
            return (String) underlyingNode.getProperty(VERSION);
        } catch (Exception e) {
        }
        return "";
    }

    public void setVersion(String module) {
        underlyingNode.setProperty(VERSION, module);
    }
    
    
    
    public String getUserId() {
        try {
            return (String) underlyingNode.getProperty(USER_ID);
        } catch (Exception e) {
        }
        return "";
    }

    public void setUserId(String module) {
        underlyingNode.setProperty(USER_ID, module);
    }


    public String getImei() {
        try {
            return (String) underlyingNode.getProperty(IMEI);
        } catch (Exception e) {
        }
        return "";
    }

    public void setImei(String module) {
        underlyingNode.setProperty(IMEI, module);
    }

    public long getBattery() {
        try {
            return (Long) underlyingNode.getProperty(BATTERY);
        } catch (Exception e) {
        }
        return 0l;
    }

    public void setBattery(long module) {
        underlyingNode.setProperty(BATTERY, module);
    }

}
