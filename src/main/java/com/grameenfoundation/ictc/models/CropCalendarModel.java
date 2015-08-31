/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.Biodata;
import com.grameenfoundation.ictc.domains.CropCalendar;
import com.grameenfoundation.ictc.domains.CropCalendarSetting;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import com.grameenfoundation.ictc.utils.ParentNode;
import com.grameenfoundation.ictc.wrapper.CropCalendarSettingWrapper;
import com.grameenfoundation.ictc.wrapper.CropCalendarWrapper;
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
public class CropCalendarModel {
    Logger log = Logger.getLogger(UserModel.class.getName());
     Node cropCal;
    
    public CropCalendar create(CropCalendarWrapper setting)
    {
          boolean created = true;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
              Node stNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.CROP_CALENDAR);

            CropCalendar settings = new CropCalendar(stNode);

            if (null != settings) {
                cropCal = ParentNode.CropCalendarSettingsNode();
                settings.setActivity(setting.getActivity());
                settings.setActivityIndex(setting.getActivityIndex());
                settings.setEarliestDate(setting.getEarliestDate());
                settings.setLatestDate(setting.getLatestDate());
                settings.setComment(setting.getComment());
                settings.setSeason(setting.getSeason());
                
                Node farmerNode = Neo4jServices.executeSingleQuery(" match (n:"+Labels.FARMER+") where n."+Biodata.ID+"='"+setting.getFarmerId()+"'", 
                        "n");

                cropCal.createRelationshipTo(stNode, ICTCRelationshipTypes.CROP_CALENDAR);
                farmerNode.createRelationshipTo(stNode, ICTCRelationshipTypes.HAS_CROP_CALENDAR);

                log.log(Level.INFO, "new node created. {0}", settings.getUnderlyingNode().getId());
                trx.success();
                return settings;

            } else {
                log.info("meeting is invalid");
                created = false;
            }
        }
        
        return  null;
        
    }
    
    
   public  List<CropCalendarWrapper> getCalendarByFarmer(String farmer){
 
     String q="MATCH (l:"+Labels.CROP_CALENDAR+")<-[:"+ICTCRelationshipTypes.HAS_CROP_CALENDAR+"]-f where l."+Biodata.ID+"= '"+farmer+"' return  l order by l."+CropCalendar.RELATIVE_WEEK+" asc";
   
     return getCropCalendar(q, "l");
    } 
   
   public  List<CropCalendarWrapper> getCropCalendar(String q, String returnItem){
       
       List<CropCalendarWrapper>  usrs = new ArrayList<>();
      try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            Iterator<Node> n_column = Neo4jServices.executeIteratorQuery(q, returnItem);
            while (n_column.hasNext()) {
                CropCalendar setting = new CropCalendar(n_column.next());
                CropCalendarWrapper settings = new CropCalendarWrapper();
              settings.setActivity(setting.getActivity());
                 settings.setActivityIndex(setting.getActivityIndex());
                 settings.setEarliestDate(setting.getEarliestDate());
                 settings.setLatestDate(setting.getLatestDate());
                 settings.setComment(setting.getComment());
                usrs.add(settings);
            }
        }
        return usrs;
    }
}
