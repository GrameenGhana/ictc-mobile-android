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
 * @date Jul 22, 2015 5:04:28 PM description:
 */
public class TechnicalNeed extends Status implements GeneralInterface {

    Node underlyingNode;

    public static String FARMPLANNING = "farmplanning";
    public static String CROPVARIETYANDSEED = "cropvarietyandseed";
    public static String WEEDCONTROL = "weedcontrol";
    public static String CROPESTABLISHMENT="cropestablishment";
    public static String INTEGRATEDSOILFERTILITYMANAGEMENT="integratedsoilfertilitymanagement";
    public static String HARVESTANDPOSTHARVEST="harvestandpostharvest";
    public static String CROPVARIETYANDSEEDCASSAVA="cropvarietyandseedcassava";
    public static String CROVARIETYANDSEEDSYAM="crovarietyandseedsyam";
    
    
    
public void setCrovarietyandseedsyam(String crovarietyandseedsyam) {
underlyingNode.setProperty(CROVARIETYANDSEEDSYAM,crovarietyandseedsyam);
}

public String getCrovarietyandseedsyam(){
          try {
          return (String) underlyingNode.getProperty(CROVARIETYANDSEEDSYAM);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setCropvarietyandseedcassava(String cropvarietyandseedcassava) {
underlyingNode.setProperty(CROPVARIETYANDSEEDCASSAVA,cropvarietyandseedcassava);
}

public String getCropvarietyandseedcassava(){
          try {
          return (String) underlyingNode.getProperty(CROPVARIETYANDSEEDCASSAVA);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setHarvestAndPostHarvest(String harvestandpostharvest) {
underlyingNode.setProperty(HARVESTANDPOSTHARVEST,harvestandpostharvest);
}

public String getHarvestAndPostHarvest(){
          try {
          return (String) underlyingNode.getProperty(HARVESTANDPOSTHARVEST);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setIntegratedSoilFertilityManagement(String integratedsoilfertilitymanagement) {
underlyingNode.setProperty(INTEGRATEDSOILFERTILITYMANAGEMENT,integratedsoilfertilitymanagement);
}

public String getIntegratedSoilFertilityManagement(){
          try {
          return (String) underlyingNode.getProperty(INTEGRATEDSOILFERTILITYMANAGEMENT);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setCropEstablishment(String cropestablishment) {
underlyingNode.setProperty(CROPESTABLISHMENT,cropestablishment);
}

public String getCropEstablishment(){
          try {
          return (String) underlyingNode.getProperty(CROPESTABLISHMENT);

        } catch (Exception e) {
        }
        return null;
    }

    public void setWeedControl(String weedcontrol) {
        underlyingNode.setProperty(WEEDCONTROL, weedcontrol);
    }

    public String getWeedControl() {
        try {
            return (String) underlyingNode.getProperty(WEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setCropVarietyAndSeed(String cropvarietyandseed) {
        underlyingNode.setProperty(CROPVARIETYANDSEED, cropvarietyandseed);
    }

    public String getCropVarietyAndSeed() {
        try {
            return (String) underlyingNode.getProperty(CROPVARIETYANDSEED);

        } catch (Exception e) {
        }
        return null;
    }

    public void setFarmPlanning(String farmplanning) {
        underlyingNode.setProperty(FARMPLANNING, farmplanning);
    }

    public String getFarmPlanning() {
        try {
            return (String) underlyingNode.getProperty(FARMPLANNING);

        } catch (Exception e) {
        }
        return null;
    }

    public TechnicalNeed(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }

}
