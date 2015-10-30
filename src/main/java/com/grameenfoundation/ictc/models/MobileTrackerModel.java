/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.MeetingActivity;
import com.grameenfoundation.ictc.domains.MeetingSetting;
import com.grameenfoundation.ictc.domains.MobileTracker;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.ICTCUtil;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import com.grameenfoundation.ictc.utils.ParentNode;
import com.grameenfoundation.ictc.wrapper.MeetingActivityWrapper;
import com.grameenfoundation.ictc.wrapper.MeetingSettingWrapper;
import com.grameenfoundation.ictc.wrapper.MobileTrackerWrapper;
import java.util.ArrayList;
import java.util.Date;
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
public class MobileTrackerModel {

    Logger log = Logger.getLogger(MobileTrackerModel.class.getName());
    Node trackerParent;

    public boolean create(MobileTrackerWrapper mw) {

        boolean created = true;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
       
            Node stNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.MOBILE_TRACKER);

            MobileTracker meet = new MobileTracker(stNode);

            if (null == meet) {
                log.info("tracker is invalid");
                created = false;
            } else {
                trackerParent = ParentNode.TrackerParentNode();
                meet.setBattery(mw.getBattery());
                meet.setData(mw.getData());
                meet.setEndDate(mw.getEndTime());
                meet.setImei(mw.getImei());
                meet.setModule(mw.getModule());
                meet.setPage(mw.getPage());
                meet.setSection(mw.getSection());
                meet.setStartDate(mw.getStartTime());
                meet.setEndDate(mw.getEndTime());
                meet.setUserId(mw.getUserId());
                meet.setVersion(mw.getVersion());
                meet.setTimeSpent(mw.getTimeSpent());
                meet.setId(String.valueOf(stNode.getId()) + new Date().getTime());

                trackerParent.createRelationshipTo(stNode, ICTCRelationshipTypes.MOBILE_TRACKER);

                log.log(Level.INFO, "new node created tracker. {0}", meet.getUnderlyingNode().getId());
                trx.success();
                return true;

            }

        } catch (Exception e) {

            created = false;
            log.severe("Creation of tRACKER Failed");
            e.printStackTrace();
        }

        return false;
    }

    public List<MobileTrackerWrapper> findAll() {

        return meetingQuery("match (l:" + ICTCRelationshipTypes.MOBILE_TRACKER + ") return  l", "l");
    }

    public List<MobileTrackerWrapper> findPerUser(String user) {

        return meetingQuery("match (l:" + ICTCRelationshipTypes.MOBILE_TRACKER + ") where l." + MobileTracker.USER_ID + "='" + user + "'"
                + " return  l", "l");
    }

    private List<MobileTrackerWrapper> meetingQuery(String q, String returnedItem) {
        List<MobileTrackerWrapper> mtg = new ArrayList<>();
        System.out.println("Query Meeting : " + q);
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            Iterator<Node> n_column = Neo4jServices.executeIteratorQuery(q, returnedItem);
            while (n_column.hasNext()) {
                MobileTracker m = new MobileTracker(n_column.next());
                MobileTrackerWrapper mr = new MobileTrackerWrapper();

                mr.setId(m.getId());
                mr.setBattery(m.getBattery());
                mr.setData(m.getData());
                mr.setEndTime(m.getEndDate());
                mr.setStartTime(m.getStartDate());
                mr.setImei(m.getImei());
                mr.setModule(m.getModule());
                mr.setPage(m.getPage());
                mr.setSection(m.getSection());
                mr.setUserId(m.getUserId());
                mr.setVersion(m.getVersion());

                mtg.add(mr);
            }

        }
        return mtg;
    }

}
