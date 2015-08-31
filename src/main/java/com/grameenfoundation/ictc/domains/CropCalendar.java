/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.domains;

import com.grameenfoundation.ictc.domain.commons.GeneralInterface;
import com.grameenfoundation.ictc.domain.commons.Status;
import static com.grameenfoundation.ictc.domains.CropCalendarSetting.CROP;
import com.grameenfoundation.ictc.utils.ICTCUtil;
import java.util.Date;
import org.neo4j.graphdb.Node;

/**
 *
 * @author skwakwa
 */
public class CropCalendar extends Status implements GeneralInterface {

    public static String ACTUAL_DATE_OF_ACTION = "action_date";
    public static String EARLIEST_DATE = "earliest_day";
    public static String LASTEST_DATE = "latest_date";
    public static String ACTIVITY = "activity";
    public static String ACTIVITY_INDEX= "activity_index";
    public static String COMMENT= "activity";
    public static String RELATIVE_WEEK = "week_from_planting";
    public static String SEASON = "season";

    
    Node underlyingNode;

    public CropCalendar(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }

    /**
     * @return the actualDate
     */
    public Date getActualDate() {
        try {
                    Long l =(Long) underlyingNode.getProperty(ACTUAL_DATE_OF_ACTION);

                    return ICTCUtil.LongToDate(l);
        } catch (Exception e) {
        }
        
        return null;
    }

    /**
     * @param actualDate the actualDate to set
     */
    public void setActualDate(Date actualDate) {
        underlyingNode.setProperty(ACTUAL_DATE_OF_ACTION, ICTCUtil.dateToLong(actualDate));
    }

    /**
     * @return the earliestDate
     */
    public Date getEarliestDate() {
       try {
                    Long l =(Long) underlyingNode.getProperty(EARLIEST_DATE);

                    return ICTCUtil.LongToDate(l);
        } catch (Exception e) {
        }
        
        return null;
    }

    /**
     * @param earliestDate the earliestDate to set
     */
    public void setEarliestDate(Date earliestDate) {
  underlyingNode.setProperty(EARLIEST_DATE, ICTCUtil.dateToLong(earliestDate));   
    }

    /**
     * @return the latestDate
     */
    public Date getLatestDate() {
       try {
                    Long l =(Long) underlyingNode.getProperty(LASTEST_DATE);

                    return ICTCUtil.LongToDate(l);
        } catch (Exception e) {
        }
        
        return null;
    }

    /**
     * @param latestDate the latestDate to set
     */
    public void setLatestDate(Date latestDate) {

  underlyingNode.setProperty(LASTEST_DATE, ICTCUtil.dateToLong(latestDate));     }

    /**
     * @return the activity
     */
    public String getActivity() {
try {
            return (String) getUnderlyingNode().getProperty(ACTIVITY);
        } catch (Exception e) {
        }
        return  "";    }

    /**
     * @param activity the activity to set
     */
    public void setActivity(String activity) {
         underlyingNode.setProperty(ACTIVITY, activity);
    }

    /**
     * @return the activityIndex
     */
    public int getActivityIndex() {
      try {
            return (Integer) getUnderlyingNode().getProperty(ACTIVITY_INDEX);
        } catch (Exception e) {
        }
        return  0;
    }

    /**
     * @param activityIndex the activityIndex to set
     */
    public void setActivityIndex(int activityIndex) {
       underlyingNode.setProperty(ACTIVITY_INDEX, activityIndex);
    }

    /**
     * @return the weeksFromPlanting
     */
    public int getWeeksFromPlanting() {
         try {
            return (Integer) getUnderlyingNode().getProperty(RELATIVE_WEEK);
        } catch (Exception e) {
        }
        return  0;
    }

    /**
     * @param weeksFromPlanting the weeksFromPlanting to set
     */
    public void setWeeksFromPlanting(int weeksFromPlanting) {
       underlyingNode.setProperty(RELATIVE_WEEK, weeksFromPlanting);
    }

    /**
     * @return the comment
     */
    public String getComment() {
     try {
            return (String) getUnderlyingNode().getProperty(COMMENT);
        } catch (Exception e) {
        }
        return  "";
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
 underlyingNode.setProperty(COMMENT, comment);    } /**
     * @return the comment
     */
    public String getSeason() {
     try {
            return (String) getUnderlyingNode().getProperty(SEASON);
        } catch (Exception e) {
        }
        return  "";
    }

    /**
     * @param comment the comment to set
     */
    public void setSeason(String season) {
 underlyingNode.setProperty(SEASON,season);}
    
    
}
