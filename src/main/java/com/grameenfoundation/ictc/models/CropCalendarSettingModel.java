/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.CropCalendarSetting;
import com.grameenfoundation.ictc.domains.Meeting;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.ParentNode;
import com.grameenfoundation.ictc.wrapper.CropCalendarSettingWrapper;
import com.grameenfoundation.ictc.wrapper.MeetingWrapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

/**
 *
 * @author skwakwa
 */
public class CropCalendarSettingModel {
    
    Logger log = Logger.getLogger(UserModel.class.getName());
     Node cropCalSetting;
    
    public CropCalendarSetting create(CropCalendarSettingWrapper setting)
    {
          boolean created = true;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
              Node stNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.MEETING);

            CropCalendarSetting settings = new CropCalendarSetting(stNode);

            if (null == settings) {
                log.info("meeting is invalid");
                created = false;
            } else {
                cropCalSetting = ParentNode.CropCalendarSettingsNode();
                 settings.setActivity(setting.getActivity());
                 settings.setCrop(setting.getCrop());
                 settings.setStartWeek(setting.getStartWeek());
                 settings.setEndWeek(setting.getEndWeek());
                

                cropCalSetting.createRelationshipTo(stNode, ICTCRelationshipTypes.CROP_CALENDAR_SETTING);

                log.log(Level.INFO, "new node created. {0}", settings.getUnderlyingNode().getId());
                trx.success();
                return settings;

            }
        }
        
        return  null;
        
    }
    
    
    

}
