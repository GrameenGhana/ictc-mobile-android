/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.domains;

import com.grameenfoundation.ictc.domain.commons.GeneralInterface;
import com.grameenfoundation.ictc.domain.commons.Status;
import org.neo4j.graphdb.Node;

/**
 *
 * @author skwakwa
 */
public class MeetingActivity extends Status implements GeneralInterface {

    public static String NAME = "name";
    public static String ACTIVITY_INDEX = "actIndex";

    Node underlyingNode;

    public MeetingActivity(Node underlyingNode) {
        super(underlyingNode);

        this.underlyingNode = underlyingNode;
    }

    public String getName() {

        try {
            return (String) underlyingNode.getProperty(NAME);
        } catch (Exception e) {
        }

        return "";
    }

    public void setActivityIndex(int act) {
        underlyingNode.setProperty(ACTIVITY_INDEX, act);
    }

    public int getActivityIndex() {

        try {
            return (Integer) underlyingNode.getProperty(ACTIVITY_INDEX);
        } catch (Exception e) {
        }

        return 0;
    }

    public void setName(String name) {
        underlyingNode.setProperty(NAME, name);
    }
}
