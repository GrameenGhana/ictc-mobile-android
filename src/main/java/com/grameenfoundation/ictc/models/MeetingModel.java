/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.Biodata;
import com.grameenfoundation.ictc.domains.Meeting;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import com.grameenfoundation.ictc.utils.ParentNode;
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
 * @author Joseph George Davis
 * @date Aug 30, 2015 5:44:44 PM description:
 */
public class MeetingModel {

    Logger log = Logger.getLogger(UserModel.class.getName());
    Node meetingParent;

    public Meeting create(MeetingWrapper mw) {

        boolean created = true;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Node stNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.MEETING);

            Meeting meet = new Meeting(stNode);

            if (null == meet) {
                log.info("meeting is invalid");
                created = false;
            } else {
                meetingParent = ParentNode.MeetingParentNode();
                meet.setType(mw.getType());
                meet.setMeetingIndex(mw.getMeetingIndex());
                meet.setSeason(mw.getSeason());
                meet.setStartdate(mw.getStartDate());
                meet.setEnddate(mw.getEndDate());
                meet.setAttended(mw.getAttended());

                meetingParent.createRelationshipTo(stNode, ICTCRelationshipTypes.MEETING);

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

    public List<MeetingWrapper> findAll() {

        return meetingQuery("match (l:MEETING) return  l", "l");
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

    public List<MeetingWrapper> findFarmerMeeting(String farmerId) {

        return meetingQuery("match (l:MEETING)<-[:HAS_MEETING]-f where f.Id ='" + farmerId + "' return  l", "l");
    }

    public MeetingWrapper findMeetingById(String meetingId) {
        return meetingQuery("match (l:MEETING) where l.Id ='" + meetingId + "' return  l", "l").get(0);
    }

    public void updateMeetings(String meetingIndex, String meetingType, String inAttendance) {
        int mt = getMeetingPosition(Integer.parseInt(meetingIndex), meetingType);

        meetingQuery("match (l:MEETING)<-[:HAS_MEETING]-f  where l." + Meeting.MEETING_INDEX + " ='" + mt + "'  and l." + Meeting.TYPE + "= '" + meetingType.toLowerCase() + "'  and f." + Biodata.ID + " IN [" + inAttendance + "] set l." + Meeting.ATTENDED + "=1 return  l", "l");

    }

    public static int getMeetingPosition(int index, String type) {
    
        int item=1;
        switch (index) {
            case 1: item=1; //1 group

                break;
            case 2:item=1;//1st individua;
                break;
            case 3:item=2;//2nd group
                break;
            case 4:item=2;//2nd individual
                break;
            case 5:item=3;//3rd group
                break;
            case 6:item=4;//4th group
                break;

        }
    
        return item;

    }

    private List<MeetingWrapper> meetingQuery(String q, String returnedItem) {
        List<MeetingWrapper> mtg = new ArrayList<>();
        System.out.println("Query Meeting : " + q);
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            Iterator<Node> n_column = Neo4jServices.executeIteratorQuery(q, returnedItem);
            while (n_column.hasNext()) {
                Meeting m = new Meeting(n_column.next());
                MeetingWrapper mr = new MeetingWrapper();

                mr.setType(m.getType());
                mr.setMeetingIndex(m.getMeetingIndex());
                mr.setSeason(m.getSeason());
                mr.setStartDate(m.getStartdate());
                mr.setEndDate(m.getEnddate());
                mr.setAttended(m.getAttended());

                mtg.add(mr);
                //todo Find relationship to farmer to replace

//               wr.(u.getFirstname());
            }

        }
        return mtg;
    }
    
    
    private List<MeetingWrapper> meetingNodeToer(Node n) {
        List<MeetingWrapper> mtg = new ArrayList<>();
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
        
                Meeting m = new Meeting(n);
                MeetingWrapper mr = new MeetingWrapper();

                mr.setType(m.getType());
                mr.setMeetingIndex(m.getMeetingIndex());
                mr.setSeason(m.getSeason());
                mr.setStartDate(m.getStartdate());
                mr.setEndDate(m.getEnddate());
                mr.setAttended(m.getAttended());

                mtg.add(mr);
                //todo Find relationship to farmer to replace

//               wr.(u.getFirstname());
        
        }
        return mtg;
    }
    private List<MeetingWrapper> meetingNodeToer(List<Node> n) {
        List<MeetingWrapper> mtg = new ArrayList<>();
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            for (Node  node: n) {
                
        
                Meeting m = new Meeting(node);
                MeetingWrapper mr = new MeetingWrapper();

                mr.setType(m.getType());
                mr.setMeetingIndex(m.getMeetingIndex());
                mr.setSeason(m.getSeason());
                mr.setStartDate(m.getStartdate());
                mr.setEndDate(m.getEnddate());
                mr.setAttended(m.getAttended());

                mtg.add(mr);
                //todo Find relationship to farmer to replace

//               wr.(u.getFirstname());
        
            }
        }
        return mtg;
    }

    public Meeting getMeeting(String field, String value) {
        String q = "Start root=node(0) "
                + " MATCH root-[:" + ICTCRelationshipTypes.ENTITY + "]->parent-[:" + ICTCRelationshipTypes.MEETING + "]->p"
                + " where p." + field + "='" + value + "'"
                + " return p";

        System.out.println("Query " + q);
        try {
            Node node = Neo4jServices.executeCypherQuerySingleResult(q, "p");
            if (null != node) {
                return new Meeting(node);
            }
        } catch (Exception e) {
            System.out.println("Unable to find Meeting");
        }

        return null;
    }

    public boolean MeetingUpdate(String id, Map<String, String> data) {
        Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx();
        Meeting mtg = getMeeting(Meeting.ID, id);

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
                    if (fieldName.equalsIgnoreCase(Meeting.ATTENDED)) {
                        if (null != fieldValue) {
                            mtg.setAttended(fieldValue);
                        }
                    }

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
