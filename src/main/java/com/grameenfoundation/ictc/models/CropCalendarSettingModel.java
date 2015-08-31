/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.CropCalendarSetting;
import com.grameenfoundation.ictc.domains.Meeting;
import com.grameenfoundation.ictc.domains.User;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import com.grameenfoundation.ictc.utils.ParentNode;
import com.grameenfoundation.ictc.wrapper.CropCalendarSettingWrapper;
import com.grameenfoundation.ictc.wrapper.MeetingWrapper;
import com.grameenfoundation.ictc.wrapper.UserWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import scala.collection.Iterator;

/**
 *
 * @author skwakwa
 */
public class CropCalendarSettingModel {

    Logger log = Logger.getLogger(UserModel.class.getName());
    Node cropCalSetting;

    public CropCalendarSetting create(CropCalendarSettingWrapper setting) {
        boolean created = true;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            Node stNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.CROP_CALENDAR_SETTING);

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

        return null;

    }

    public List<CropCalendarSettingWrapper> getCropSetting(String q, String returnItem) {
        List<CropCalendarSettingWrapper> usrs = new ArrayList<>();
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            Iterator<Node> n_column = Neo4jServices.executeIteratorQuery(q, returnItem);
            while (n_column.hasNext()) {
                CropCalendarSetting u = new CropCalendarSetting(n_column.next());
                CropCalendarSettingWrapper wr = new CropCalendarSettingWrapper();
                wr.setCrop(u.getCrop());
                wr.setActivity(u.getActivity());
                wr.setEndWeek(u.getEndWeek());
                wr.setStartWeek(u.getStartWeek());
                usrs.add(wr);
            }
        }
        return usrs;
    }

    public List<CropCalendarSettingWrapper> getSettingByCrop(String crop) {
        List<CropCalendarSettingWrapper> usrs = new ArrayList<>();
        String q = "MATCH (l:" + Labels.CROP_CALENDAR_SETTING + ") where l." + CropCalendarSetting.CROP + "= '" + crop + "' return  l order by l." + CropCalendarSetting.START_WEEK + " asc";
        return getCropSetting(q, "l");
    }

    public List<CropCalendarSettingWrapper> getAllSetting() {
//        List<CropCalendarSettingWrapper> usrs = new ArrayList<>();
        String q = "MATCH (l:" + Labels.CROP_CALENDAR_SETTING + ")  return  l order by l." + CropCalendarSetting.CROP + " , l." + CropCalendarSetting.START_WEEK + " asc";
        return getCropSetting(q, "l");
    }
    
    public void delete(){
    String q = "MATCH (l:" + Labels.CROP_CALENDAR_SETTING + ")  return  l";
    
    }

}
