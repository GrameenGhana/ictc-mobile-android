/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.utils;

import com.grameenfoundation.ictc.wrapper.MeetingWrapper;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Joseph George Davis
 * @date Aug 31, 2015 9:46:12 AM
 * description:
 */
public class MeetingSchedule {
    
    MeetingWrapper initialGroupMeeting = new MeetingWrapper();
    MeetingWrapper firstIndvMeeting = new MeetingWrapper();
    MeetingWrapper secondGroupMeeting = new MeetingWrapper();
    MeetingWrapper secondIndvMeeting = new MeetingWrapper();
    MeetingWrapper thirdGroupMeeting = new MeetingWrapper();
    MeetingWrapper fourthGroupMeeting = new MeetingWrapper();
    
    public Map<String,MeetingWrapper> maizeFarmerMeeting(String season)
    {
         
        Map<String,MeetingWrapper> meetings = new HashMap<>();
        if(season.equals("1"))
        {
            //Initial Group meeting
           initialGroupMeeting.setType("group");
           initialGroupMeeting.setMeetingIndex("1");
           initialGroupMeeting.setStartDate("01/02/2015");
           initialGroupMeeting.setEndDate("28/02/2015");
           initialGroupMeeting.setSeason("1");
           
           meetings.put("firstgroup",initialGroupMeeting);
           
           //Second Group meeting
           secondGroupMeeting.setType("group");
           secondGroupMeeting.setMeetingIndex("2");
           secondGroupMeeting.setStartDate("01/05/2015");
           secondGroupMeeting.setEndDate("31/05/2015");
           secondGroupMeeting.setSeason("1");
           
           meetings.put("secondgroup",secondGroupMeeting);
            
           //Third Group Meeting
           thirdGroupMeeting.setType("group");
           thirdGroupMeeting.setMeetingIndex("3");
           thirdGroupMeeting.setStartDate("01/07/2015");
           thirdGroupMeeting.setEndDate("31/07/2015");
           thirdGroupMeeting.setSeason("1");
           meetings.put("thirdgroup", initialGroupMeeting);
           
           //Fourth Group Meeting
           fourthGroupMeeting.setType("group");
           fourthGroupMeeting.setMeetingIndex("4");
           fourthGroupMeeting.setStartDate("01/08/2015");
           fourthGroupMeeting.setEndDate("31/08/2015");
           fourthGroupMeeting.setSeason("1");
           meetings.put("fourthgroup", fourthGroupMeeting);
           
           
           //First Individual meeting
           firstIndvMeeting.setType("individual");
           firstIndvMeeting.setMeetingIndex("1");
           firstIndvMeeting.setStartDate("01/03/2105");
           firstIndvMeeting.setEndDate("30/03/2015");
           firstIndvMeeting.setSeason("1");
           meetings.put("firstindividual", firstIndvMeeting);
           
            //Second Individual meeting
           secondIndvMeeting.setType("individual");
           secondIndvMeeting.setMeetingIndex("2");
           secondIndvMeeting.setStartDate("01/06/2015");
           secondIndvMeeting.setEndDate("30/06/2015");
           secondIndvMeeting.setSeason("1");
           meetings.put("secondindividual",secondIndvMeeting);
           
           
           
           return meetings;
        }
        if(season.equals("2"))
        {
            //Initial Group meeting
           initialGroupMeeting.setType("group");
           initialGroupMeeting.setMeetingIndex("1");
           initialGroupMeeting.setStartDate("01/04/2015");
           initialGroupMeeting.setEndDate("30/04/2015");
           initialGroupMeeting.setSeason("2");
           
           meetings.put("firstgroup",initialGroupMeeting);
           
           //Second Group meeting
           secondGroupMeeting.setType("group");
           secondGroupMeeting.setMeetingIndex("2");
           secondGroupMeeting.setStartDate("01/08/2015");
           secondGroupMeeting.setEndDate("31/08/2015");
           secondGroupMeeting.setSeason("2");
           
           meetings.put("secondgroup",secondGroupMeeting);
            
           //Third Group Meeting
           thirdGroupMeeting.setType("group");
           thirdGroupMeeting.setMeetingIndex("3");
           thirdGroupMeeting.setStartDate("01/11/2015");
           thirdGroupMeeting.setEndDate("30/11/2015");
           thirdGroupMeeting.setSeason("2");
           meetings.put("thirdgroup", initialGroupMeeting);
           
           //Fourth Group Meeting
           fourthGroupMeeting.setType("group");
           fourthGroupMeeting.setMeetingIndex("4");
           fourthGroupMeeting.setStartDate("01/12/2015");
           fourthGroupMeeting.setEndDate("31/12/2015");
           fourthGroupMeeting.setSeason("1");
           meetings.put("fourthgroup", fourthGroupMeeting);
           
           
           //First Individual meeting
           firstIndvMeeting.setType("individual");
           firstIndvMeeting.setMeetingIndex("1");
           firstIndvMeeting.setStartDate("01/06/2105");
           firstIndvMeeting.setEndDate("30/06/2015");
           firstIndvMeeting.setSeason("1");
           meetings.put("firstindividual", firstIndvMeeting);
           
            //Second Individual meeting
           secondIndvMeeting.setType("individual");
           secondIndvMeeting.setMeetingIndex("2");
           secondIndvMeeting.setStartDate("01/09/2015");
           secondIndvMeeting.setEndDate("31/09/2015");
           secondIndvMeeting.setSeason("1");
           meetings.put("secondindividual",secondIndvMeeting);
           
           
           
           return meetings; 
        }
        
        return null;
    }
    
    
    
    
    public Map<String,MeetingWrapper> riceFarmerMeeting(String season)
    {
        
         Map<String,MeetingWrapper> meetings = new HashMap<>();
         
             //Initial Group meeting
           initialGroupMeeting.setType("group");
           initialGroupMeeting.setMeetingIndex("1");
           initialGroupMeeting.setStartDate("01/03/2015");
           initialGroupMeeting.setEndDate("31/03/2015");
           initialGroupMeeting.setSeason(season);
           
           meetings.put("firstgroup",initialGroupMeeting);
           
           //Second Group meeting
           secondGroupMeeting.setType("group");
           secondGroupMeeting.setMeetingIndex("2");
           secondGroupMeeting.setStartDate("01/06/2015");
           secondGroupMeeting.setEndDate("31/06/2015");
           secondGroupMeeting.setSeason(season);
           
           meetings.put("secondgroup",secondGroupMeeting);
            
           //Third Group Meeting
           thirdGroupMeeting.setType("group");
           thirdGroupMeeting.setMeetingIndex("3");
           thirdGroupMeeting.setStartDate("01/11/2015");
           thirdGroupMeeting.setEndDate("31/11/2015");
           thirdGroupMeeting.setSeason(season);
           meetings.put("thirdgroup", initialGroupMeeting);
           
           //Fourth Group Meeting
           fourthGroupMeeting.setType("group");
           fourthGroupMeeting.setMeetingIndex("4");
           fourthGroupMeeting.setStartDate("01/12/2015");
           fourthGroupMeeting.setEndDate("31/12/2015");
           fourthGroupMeeting.setSeason(season);
           meetings.put("fourthgroup", fourthGroupMeeting);
           
           
           //First Individual meeting
           firstIndvMeeting.setType("individual");
           firstIndvMeeting.setMeetingIndex("1");
           firstIndvMeeting.setStartDate("01/05/2105");
           firstIndvMeeting.setEndDate("30/05/2015");
           firstIndvMeeting.setSeason(season);
           meetings.put("firstindividual", firstIndvMeeting);
           
            //Second Individual meeting
           secondIndvMeeting.setType("individual");
           secondIndvMeeting.setMeetingIndex("2");
           secondIndvMeeting.setStartDate("01/08/2015");
           secondIndvMeeting.setEndDate("30/08/2015");
           secondIndvMeeting.setSeason(season);
           meetings.put("secondindividual",secondIndvMeeting);
           
           
           
           return meetings;
    
    
    }
    
    
     public Map<String,MeetingWrapper> yamFarmerMeeting(String season)
     {
         
          Map<String,MeetingWrapper> meetings = new HashMap<>();
         
             //Initial Group meeting
           initialGroupMeeting.setType("group");
           initialGroupMeeting.setMeetingIndex("1");
           initialGroupMeeting.setStartDate("01/10/2015");
           initialGroupMeeting.setEndDate("31/10/2015");
           initialGroupMeeting.setSeason(season);
           
           meetings.put("firstgroup",initialGroupMeeting);
           
           //Second Group meeting
           secondGroupMeeting.setType("group");
           secondGroupMeeting.setMeetingIndex("2");
           secondGroupMeeting.setStartDate("01/05/2016");
           secondGroupMeeting.setEndDate("31/05/2016");
           secondGroupMeeting.setSeason(season);
           
           meetings.put("secondgroup",secondGroupMeeting);
            
           //Third Group Meeting
           thirdGroupMeeting.setType("group");
           thirdGroupMeeting.setMeetingIndex("3");
           thirdGroupMeeting.setStartDate("01/09/2015");
           thirdGroupMeeting.setEndDate("31/09/2015");
           thirdGroupMeeting.setSeason(season);
           meetings.put("thirdgroup", initialGroupMeeting);
           
           //Fourth Group Meeting
           fourthGroupMeeting.setType("group");
           fourthGroupMeeting.setMeetingIndex("4");
           fourthGroupMeeting.setStartDate("01/12/2016");
           fourthGroupMeeting.setEndDate("31/12/2016");
           fourthGroupMeeting.setSeason(season);
           meetings.put("fourthgroup", fourthGroupMeeting);
           
           
           //First Individual meeting
           firstIndvMeeting.setType("individual");
           firstIndvMeeting.setMeetingIndex("1");
           firstIndvMeeting.setStartDate("01/01/2106");
           firstIndvMeeting.setEndDate("01/31/2016");
           firstIndvMeeting.setSeason(season);
           meetings.put("firstindividual", firstIndvMeeting);
           
            //Second Individual meeting
           secondIndvMeeting.setType("individual");
           secondIndvMeeting.setMeetingIndex("2");
           secondIndvMeeting.setStartDate("01/07/2016");
           secondIndvMeeting.setEndDate("31/07/2016");
           secondIndvMeeting.setSeason(season);
           meetings.put("secondindividual",secondIndvMeeting);
           
           
           
           return meetings;
         
     }
      
    
    public Map<String,MeetingWrapper> cassavaFarmerMeeting(String season)
    {
           Map<String,MeetingWrapper> meetings = new HashMap<>();
         
             //Initial Group meeting
           initialGroupMeeting.setType("group");
           initialGroupMeeting.setMeetingIndex("1");
           initialGroupMeeting.setStartDate("01/01/2015");
           initialGroupMeeting.setEndDate("31/01/2015");
           initialGroupMeeting.setSeason(season);
           
           meetings.put("firstgroup",initialGroupMeeting);
           
           //Second Group meeting
           secondGroupMeeting.setType("group");
           secondGroupMeeting.setMeetingIndex("2");
           secondGroupMeeting.setStartDate("01/06/2015");
           secondGroupMeeting.setEndDate("31/06/2015");
           secondGroupMeeting.setSeason(season);
           
           meetings.put("secondgroup",secondGroupMeeting);
            
           //Third Group Meeting
           thirdGroupMeeting.setType("group");
           thirdGroupMeeting.setMeetingIndex("3");
           thirdGroupMeeting.setStartDate("01/07/2016");
           thirdGroupMeeting.setEndDate("31/07/2016");
           thirdGroupMeeting.setSeason(season);
           meetings.put("thirdgroup", thirdGroupMeeting);
           
           //Fourth Group Meeting
           fourthGroupMeeting.setType("group");
           fourthGroupMeeting.setMeetingIndex("4");
           fourthGroupMeeting.setStartDate("01/08/2016");
           fourthGroupMeeting.setEndDate("31/08/2016");
           fourthGroupMeeting.setSeason(season);
           meetings.put("fourthgroup", fourthGroupMeeting);
           
           
           //First Individual meeting
           firstIndvMeeting.setType("individual");
           firstIndvMeeting.setMeetingIndex("1");
           firstIndvMeeting.setStartDate("01/02/2105");
           firstIndvMeeting.setEndDate("28/02/2015");
           firstIndvMeeting.setSeason(season);
           meetings.put("firstindividual", firstIndvMeeting);
           
            //Second Individual meeting
           secondIndvMeeting.setType("individual");
           secondIndvMeeting.setMeetingIndex("2");
           secondIndvMeeting.setStartDate("01/10/2015");
           secondIndvMeeting.setEndDate("30/10/2015");
           secondIndvMeeting.setSeason(season);
           meetings.put("secondindividual",secondIndvMeeting);
           
           
           
           return meetings;
    
    
    }
    
    
  
    
    

}
