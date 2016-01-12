/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.domains;

import com.grameenfoundation.ictc.domain.commons.GeneralInterface;
import com.grameenfoundation.ictc.domain.commons.Status;
import static com.grameenfoundation.ictc.domains.Storage.POSTHARVESTLOSSES;
import com.grameenfoundation.ictc.utils.ICTCUtil;
import java.util.Date;
import org.neo4j.graphdb.Node;

/**
 *
 * @author skwakwa
 */
public class Survey extends Status implements GeneralInterface {

    Node underlyingNode;
    public static String SURVEY_IDX = "surveyIdx";
    public static String SURVEY_NAME = "surveyName";
    public static String SURVEY_CODE = "surveyCode";
    public static String DATE_TAKEN = "dateTaken";
    public static String TIME_TAKEN = "timeTaken";
    public static String REMARK = "remark";

    public Survey(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }

    public void setSurveyIndex(long idx) {
        underlyingNode.setProperty(SURVEY_IDX, idx);
    }

    public long getSurveyIndex() {
        try {
            return (Long) underlyingNode.getProperty(SURVEY_IDX);

        } catch (Exception e) {
        }
        return 0l;
    }

    public void setSurveyName(String survey) {
        underlyingNode.setProperty(SURVEY_NAME, survey);
    }

    public String getSurveyName() {
        try {
            return (String) underlyingNode.getProperty(SURVEY_NAME);

        } catch (Exception e) {
        }
        return "";
    }

    public void setSurveyCode(String survey) {
        underlyingNode.setProperty(SURVEY_CODE, survey);
    }

    public String getSurveyCode() {
        try {
            return (String) underlyingNode.getProperty(SURVEY_CODE);

        } catch (Exception e) {
        }
        return "";
    }

    public void setTimeTaken(long survey) {
        underlyingNode.setProperty(TIME_TAKEN, survey);
    }

    public long getTimeTaken() {
        try {
            return (Long) underlyingNode.getProperty(TIME_TAKEN);
        } catch (Exception e) {
        }
        return 0l;
    }

    public void setDateTaken(Date survey) {
        underlyingNode.setProperty(DATE_TAKEN, ICTCUtil.dateToLong(survey));
    }

    public Date getDateTaken() {
        try {
            return new Date((Long) underlyingNode.getProperty(DATE_TAKEN));

        } catch (Exception e) {
        }
        return null;
    }

    public void setRemark(String survey) {
        underlyingNode.setProperty(REMARK, survey);
    }

    public String getRemark() {
        try {
            return (String) underlyingNode.getProperty(REMARK);
        } catch (Exception e) {
        }
        return "";
    }
}
