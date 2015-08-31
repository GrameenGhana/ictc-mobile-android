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
public class CropCalendarSetting extends Status implements GeneralInterface {

    public static String CROP = "crop";
    public static String START_WEEK = "start_week";
    public static String END_WEEK = "end_week";
    public static String ACTIVITY = "activity";

    String crop;
    int startWeek;
    int endWeek;
    String activity;

    public CropCalendarSetting(Node underlyingNode) {
        super(underlyingNode);
    }

}
