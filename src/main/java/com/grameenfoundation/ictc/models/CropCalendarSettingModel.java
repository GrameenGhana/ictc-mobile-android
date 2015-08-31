/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.CropCalendarSetting;
import com.grameenfoundation.ictc.domains.Meeting;
import com.grameenfoundation.ictc.wrapper.CropCalendarSettingWrapper;
import com.grameenfoundation.ictc.wrapper.MeetingWrapper;
import java.util.logging.Logger;
import org.neo4j.graphdb.Node;

/**
 *
 * @author skwakwa
 */
public class CropCalendarSettingModel {
    
    Logger log = Logger.getLogger(UserModel.class.getName());
     Node cropCalSetting;
    
    public CropCalendarSetting create(CropCalendarSettingWrapper setting)
    {
        return null;
    }

}
