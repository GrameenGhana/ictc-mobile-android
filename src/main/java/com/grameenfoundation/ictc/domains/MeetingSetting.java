/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.domains;

import com.grameenfoundation.ictc.domain.commons.GeneralInterface;
import com.grameenfoundation.ictc.domain.commons.Status;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import java.util.ArrayList;
import java.util.List;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

/**
 *
 * @author skwakwa
 */
public class MeetingSetting extends Status implements GeneralInterface {

    public static String TYPE = "type";
    public static String MEETING_INDEX = "index";
    public static String SEASON = "season";
    public static String CROP = "crop";
    public static String START_DATE = "startdate";
    public static String END_DATE = "enddate";

    Node underlyingNode;

    public MeetingSetting(Node underlyingNode) {
        super(underlyingNode);

        this.underlyingNode = underlyingNode;
    }

    public void setType(String type) {
        underlyingNode.setProperty(TYPE, type);
    }

    public String getType() {
        try {
            return (String) underlyingNode.getProperty(TYPE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setMeetingIndex(String index) {
        underlyingNode.setProperty(MEETING_INDEX, index);
    }

    public String getMeetingIndex() {
        try {
            return (String) underlyingNode.getProperty(MEETING_INDEX);

        } catch (Exception e) {
        }
        return null;
    }

    public void setSeason(String season) {
        underlyingNode.setProperty(SEASON, season);
    }

    public String getCrop() {
        try {
            return (String) underlyingNode.getProperty(CROP);

        } catch (Exception e) {
        }
        return null;
    }

    public void setCrop(String season) {
        underlyingNode.setProperty(CROP, season);
    }

    public String getSeason() {
        try {
            return (String) underlyingNode.getProperty(SEASON);

        } catch (Exception e) {
        }
        return null;
    }

    public void setStartdate(String startdate) {
        underlyingNode.setProperty(START_DATE, startdate);
    }

    public String getStartdate() {
        try {
            return (String) underlyingNode.getProperty(START_DATE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setEnddate(String enddate) {
        underlyingNode.setProperty(END_DATE, enddate);
    }

    public String getEnddate() {
        try {
            return (String) underlyingNode.getProperty(END_DATE);

        } catch (Exception e) {
        }
        return null;
    }

    public List<MeetingActivity> getMeetingActivities() {
        List<MeetingActivity> ma = new ArrayList<>();
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            List<Node> n = Neo4jServices.findNodeFromRelations(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.MEETING_ACTIVITY);

            for (Node n1 : n) {
                MeetingActivity m = new MeetingActivity(n1);
                ma.add(m);
            }
        }
        return ma;
    }
}
