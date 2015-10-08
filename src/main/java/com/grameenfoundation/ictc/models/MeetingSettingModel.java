/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.Meeting;
import com.grameenfoundation.ictc.domains.MeetingActivity;
import com.grameenfoundation.ictc.domains.MeetingSetting;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import com.grameenfoundation.ictc.utils.ParentNode;
import com.grameenfoundation.ictc.wrapper.MeetingActivityWrapper;
import com.grameenfoundation.ictc.wrapper.MeetingSettingWrapper;
import com.grameenfoundation.ictc.wrapper.MeetingWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import scala.collection.Iterator;

/**
 *
 * @author skwakwa
 */
public class MeetingSettingModel {

    Logger log = Logger.getLogger(UserModel.class.getName());
    Node meetingParent;

    public MeetingSetting create(MeetingSettingWrapper mw) {

        boolean created = true;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Node stNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.MEETING_SETTING);

            MeetingSetting meet = new MeetingSetting(stNode);

            if (null == meet) {
                log.info("meeting is invalid");
                created = false;
            } else {
                meetingParent = ParentNode.MeetingSettingParentNode();
                meet.setType(mw.getType());
                meet.setMeetingIndex(mw.getMeetingIndex());
                meet.setSeason(mw.getSeason());
                meet.setCrop(mw.getCrop());
                meet.setStartdate(mw.getStartDate());
                meet.setEnddate(mw.getEndDate());

                Node nd = ParentNode.MeetingActivityParentNode();
                List<MeetingActivityWrapper> activities = mw.getMeetingActivities();

//                for (MeetingActivityWrapper activity : activities) {
//                    Node act = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.MEETING_ACTIVITY);
//                    MeetingActivity ma = new MeetingActivity(act);
//                    ma.setName(activity.getName());
//                    ma.setActivityIndex(activity.getIndex());
//
//                }

                meetingParent.createRelationshipTo(stNode, ICTCRelationshipTypes.MEETING_SETTING);

                for (MeetingActivityWrapper activity : activities) {
                    Node act = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.MEETING_ACTIVITY);
                    MeetingActivity ma = new MeetingActivity(act);
                    ma.setName(activity.getName());
                    ma.setActivityIndex(activity.getIndex());
                    stNode.createRelationshipTo(act, ICTCRelationshipTypes.MEETING_ACTIVITY);
                }

                log.log(Level.INFO, "new node created. {0}", meet.getUnderlyingNode().getId());
                trx.success();
                return meet;

            }

        } catch (Exception e) {

            created = false;
            log.severe("Creation of Meeting Failed");
            e.printStackTrace();
        }

        return null;
    }

    public List<MeetingSettingWrapper> findAll() {

        return meetingQuery("match (l:" + ICTCRelationshipTypes.MEETING_SETTING + ") return  l", "l");
    }

    public List<MeetingSettingWrapper> findPerCrop(String crop) {

        return meetingQuery("match (l:" + ICTCRelationshipTypes.MEETING_SETTING + ") where l." + MeetingSetting.CROP + "='" + crop + "'"
                + " return  l", "l");
    }

    public List<MeetingActivityWrapper> findPerCrop(String crop, int index, String type) {

        return meetingActivityQuery("match (l:" + ICTCRelationshipTypes.MEETING_ACTIVITY + ")<-[:" + ICTCRelationshipTypes.MEETING_SETTING + "]-m "
                + "where m." + MeetingSetting.CROP + "='" + crop + "' AND "
                + " m." + MeetingSetting.MEETING_INDEX + "=" + index + " and  "
                + "m." + MeetingSetting.TYPE + "='" + type + "'"
                + " return  l", "l");
    }

    public List<Meeting> findMeetingByFarmerCrop(String farmerId, String index, String crop) {
        List<Meeting> mtg = new ArrayList<>();

        String query = "match (l:MEETING)<-[:HAS_MEETING]-f where f.majorcrop='" + crop + "' AND l.index='" + index + "' AND l.type='group' return l";

        System.out.println("Query : " + query);

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            Iterator<Node> n_column = Neo4jServices.executeIteratorQuery(query, "l");
            while (n_column.hasNext()) {

                mtg.add(new Meeting(n_column.next()));
            }
            trx.success();
        }

        return mtg;
    }

    public void deleteAll(){
    
     try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
       Neo4jServices.executeVoidQuery("match(t:MEETING_SETTING) delete t");
     }}
    private List<MeetingSettingWrapper> meetingQuery(String q, String returnedItem) {
        List<MeetingSettingWrapper> mtg = new ArrayList<>();
        System.out.println("Query Meeting : " + q);
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            Iterator<Node> n_column = Neo4jServices.executeIteratorQuery(q, returnedItem);
            while (n_column.hasNext()) {
                MeetingSetting m = new MeetingSetting(n_column.next());
                MeetingSettingWrapper mr = new MeetingSettingWrapper();

                mr.setType(m.getType());
                mr.setMeetingIndex(m.getMeetingIndex());
                mr.setSeason(m.getSeason());
                mr.setStartDate(m.getStartdate());
                mr.setEndDate(m.getEnddate());
                mr.setCrop(m.getCrop());
                List<MeetingActivity> mts = m.getMeetingActivities();
                List<MeetingActivityWrapper> maw = new ArrayList<>();
                for (MeetingActivity mt : mts) {
                    maw.add(new MeetingActivityWrapper(mt.getActivityIndex(), mt.getName()));
                }

                mr.setMeetingActivities(maw);
                mtg.add(mr);

            }

        }
        return mtg;
    }

    private List<MeetingActivityWrapper> meetingActivityQuery(String q, String returnedItem) {
        List<MeetingActivityWrapper> mtg = new ArrayList<>();
        System.out.println("Query Meeting : " + q);
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            Iterator<Node> n_column = Neo4jServices.executeIteratorQuery(q, returnedItem);
            while (n_column.hasNext()) {
                MeetingActivity m = new MeetingActivity(n_column.next());
                MeetingActivityWrapper mr = new MeetingActivityWrapper();

                mr.setName(m.getName());
                mr.setIndex(m.getActivityIndex());

                mtg.add(mr);
            }

        }
        return mtg;
    }

    public MeetingSetting getMeeting(String field, String value) {
        String q = "Start root=node(0) "
                + " MATCH root-[:" + ICTCRelationshipTypes.ENTITY + "]->parent-[:" + ICTCRelationshipTypes.MEETING_SETTING + "]->p"
                + " where p." + field + "='" + value + "'"
                + " return p";

        System.out.println("Query " + q);
        try {
            Node node = Neo4jServices.executeCypherQuerySingleResult(q, "p");
            if (null != node) {
                return new MeetingSetting(node);
            }
        } catch (Exception e) {
            System.out.println("Unable to find Meeting");
        }

        return null;
    }

    public boolean MeetingSettingUpdate(String id, Map<String, String> data) {
        Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx();
        MeetingSetting mtg = getMeeting(Meeting.ID, id);

        boolean updated = false;
        try {
            //If the setting is not null
            if (null != mtg) {

                for (Map.Entry<String, String> dataEntry : data.entrySet()) {

                    // get the field name
                    String fieldName = dataEntry.getKey();
                    // get the field value
                    String fieldValue = dataEntry.getValue();
                    // Assigning the alias

                }

                trx.success();

                updated = true;
                log.info("Bio Data Successfully Updated");
            } else {
                trx.success();
                log.info("Unable to update Bio Data");
            }
        } catch (Exception e) {
            log.info("Unable to find Bio Data");

        } finally {
            trx.finish();
        }
        return updated;
    }

}
