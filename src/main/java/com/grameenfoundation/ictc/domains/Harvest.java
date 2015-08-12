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
 * @author Joseph George Davis
 * @date Jul 22, 2015 9:11:04 AM
 * description:
 */
public class Harvest extends Status implements GeneralInterface{
    
    
    
Node underlyingNode;
public static String TIMECROPREADYTOHARVEST="timecropreadytoharvest";
public static String TIMECROPHARVESTED="timecropharvested";
public static String TIMECOMPLETIONHARVEST="timecompletionharvest";
public static String NOFAMILYLABOUR="nofamilylabour";
public static String NOHIREDLABOUR="nohiredlabour";
public static String COSTOFHIREDLABOUR="costofhiredlabour";
public static String YIELDPERACRE="yieldperacre";
public static String NOLABOURTOTAL="nolabourtotal";



public void setNoLabourtotal(String nolabourtotal) {
underlyingNode.setProperty(NOLABOURTOTAL,nolabourtotal);
}

public String getNoLabourtotal(){
          try {
          return (String) underlyingNode.getProperty(NOLABOURTOTAL);

        } catch (Exception e) {
        }
        return null;
    }


public void setYieldPerAcre(String yieldperacre) {
underlyingNode.setProperty(YIELDPERACRE,yieldperacre);
}

public String getYieldPerAcre(){
          try {
          return (String) underlyingNode.getProperty(YIELDPERACRE);

        } catch (Exception e) {
        }
        return null;
    }



public void setCostOfHiredLabour(String costofhiredlabour) {
underlyingNode.setProperty(COSTOFHIREDLABOUR,costofhiredlabour);
}

public String getCostOfHiredLabour(){
          try {
          return (String) underlyingNode.getProperty(COSTOFHIREDLABOUR);

        } catch (Exception e) {
        }
        return null;
    }


public void setNoHiredLabour(String nohiredlabour) {
underlyingNode.setProperty(NOHIREDLABOUR,nohiredlabour);
}

public String getNoHiredLabour(){
          try {
          return (String) underlyingNode.getProperty(NOHIREDLABOUR);

        } catch (Exception e) {
        }
        return null;
    }


public void setNoFamilyLabour(String nofamilylabour) {
underlyingNode.setProperty(NOFAMILYLABOUR,nofamilylabour);
}

public String getNoFamilyLabour(){
          try {
          return (String) underlyingNode.getProperty(NOFAMILYLABOUR);

        } catch (Exception e) {
        }
        return null;
    }




public void setTimeCompletionHarvest(String timecompletionharvest) {
underlyingNode.setProperty(TIMECOMPLETIONHARVEST,timecompletionharvest);
}

public String getTimeCompletionHarvest(){
          try {
          return (String) underlyingNode.getProperty(TIMECOMPLETIONHARVEST);

        } catch (Exception e) {
        }
        return null;
    }


public void setTimeCropHarvested(String timecropharvested) {
underlyingNode.setProperty(TIMECROPHARVESTED,timecropharvested);
}

public String getTimeCropHarvested(){
          try {
          return (String) underlyingNode.getProperty(TIMECROPHARVESTED);

        } catch (Exception e) {
        }
        return null;
    }




public void setTimeCropReadyToHarvest(String timecropreadytoharvest) {
underlyingNode.setProperty(TIMECROPREADYTOHARVEST,timecropreadytoharvest);
}

public String getTimeCropReadyToHarvest(){
          try {
          return (String) underlyingNode.getProperty(TIMECROPREADYTOHARVEST);

        } catch (Exception e) {
        }
        return null;
    }
     
     
    public Harvest(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }

}
