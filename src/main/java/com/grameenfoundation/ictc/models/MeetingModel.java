/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.Meeting;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import com.grameenfoundation.ictc.utils.ParentNode;
import com.grameenfoundation.ictc.wrapper.MeetingWrapper;
import java.util.ArrayList;
import java.util.List;
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

    public List<MeetingWrapper> findFarmerMeeting(String farmerId) {

        return meetingQuery("match (l:MEETING)<-[:HAS_MEETING]-f where f.Id ='"+farmerId+"' return  l", "l");
    }

    private List<MeetingWrapper> meetingQuery(String q, String returnedItem) {
        List<MeetingWrapper> mtg = new ArrayList<>();
        System.out.println("Query : " + q);
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

                mtg.add(mr);
               //todo Find relationship to farmer to replace

//               wr.(u.getFirstname());
            }

        }
        return mtg;
    }
}
