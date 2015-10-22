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
 * @date Oct 22, 2015 11:31:27 AM
 * description:
 */
public class FieldCropAssessment extends Status implements GeneralInterface{
    
    Node underlyingNode = null;
    
    
    public static String CROP_ESTABLISHMENT_SCORE="crop_establishment_score";
    public static String DISEASE_MANAGEMENT_SCORES="disease_management_scores";
    public static String GPS_LOCATION="gps_location";
    public static String PEST_MANAGEMENT_SCORE="pest_management_score";
    public static String PHOTO_CROP_ESTABLISHMENT_STATUS="photo_crop_establishment_status";
    public static String PHOTO_DISEASE_MANGEMENT_STATUS="photo_disease_mangement_status";
    public static String PHOTO_PEST_MANAGEMENT_STATUS="photo_pest_management_status";
    public static String PHOTO_SOIL_FERTILITY_STATUS="photo_soil_fertility_status";
    public static String PHOTO_WEED_MANAGEMENT_STATUS="photo_weed_management_status";
    public static String SOIL_FERTILITY_SCORE="soil_fertility_score";
    public static String WEED_MANAGEMENT_SCORE_="weed_management_score_";
    
    
    
public void setWeed_management_score_(String weed_management_score_) {
underlyingNode.setProperty(WEED_MANAGEMENT_SCORE_,weed_management_score_);
}

public String getWeed_management_score_(){
          try {
          return (String) underlyingNode.getProperty(WEED_MANAGEMENT_SCORE_);

        } catch (Exception e) {
        }
        return null;
    }
    
    
    
public void setSoil_fertility_score(String soil_fertility_score) {
underlyingNode.setProperty(SOIL_FERTILITY_SCORE,soil_fertility_score);
}

public String getSoil_fertility_score(){
          try {
          return (String) underlyingNode.getProperty(SOIL_FERTILITY_SCORE);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setPhoto_weed_management_status(String photo_weed_management_status) {
underlyingNode.setProperty(PHOTO_WEED_MANAGEMENT_STATUS,photo_weed_management_status);
}

public String getPhoto_weed_management_status(){
          try {
          return (String) underlyingNode.getProperty(PHOTO_WEED_MANAGEMENT_STATUS);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setPhoto_soil_fertility_status(String photo_soil_fertility_status) {
underlyingNode.setProperty(PHOTO_SOIL_FERTILITY_STATUS,photo_soil_fertility_status);
}

public String getPhoto_soil_fertility_status(){
          try {
          return (String) underlyingNode.getProperty(PHOTO_SOIL_FERTILITY_STATUS);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setPhoto_pest_management_status(String photo_pest_management_status) {
underlyingNode.setProperty(PHOTO_PEST_MANAGEMENT_STATUS,photo_pest_management_status);
}

public String getPhoto_pest_management_status(){
          try {
          return (String) underlyingNode.getProperty(PHOTO_PEST_MANAGEMENT_STATUS);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setPhoto_disease_mangement_status(String photo_disease_mangement_status) {
underlyingNode.setProperty(PHOTO_DISEASE_MANGEMENT_STATUS,photo_disease_mangement_status);
}

public String getPhoto_disease_mangement_status(){
          try {
          return (String) underlyingNode.getProperty(PHOTO_DISEASE_MANGEMENT_STATUS);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setPhoto_crop_establishment_status(String photo_crop_establishment_status) {
underlyingNode.setProperty(PHOTO_CROP_ESTABLISHMENT_STATUS,photo_crop_establishment_status);
}

public String getPhoto_crop_establishment_status(){
          try {
          return (String) underlyingNode.getProperty(PHOTO_CROP_ESTABLISHMENT_STATUS);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setPest_management_score(String pest_management_score) {
underlyingNode.setProperty(PEST_MANAGEMENT_SCORE,pest_management_score);
}

public String getPest_management_score(){
          try {
          return (String) underlyingNode.getProperty(PEST_MANAGEMENT_SCORE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setGPS_Location(String gps_location) {
underlyingNode.setProperty(GPS_LOCATION,gps_location);
}

public String getGPS_Location(){
          try {
          return (String) underlyingNode.getProperty(GPS_LOCATION);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setDisease_management_scores(String disease_management_scores) {
underlyingNode.setProperty(DISEASE_MANAGEMENT_SCORES,disease_management_scores);
}

public String getDisease_management_scores(){
          try {
          return (String) underlyingNode.getProperty(DISEASE_MANAGEMENT_SCORES);

        } catch (Exception e) {
        }
        return null;
    }

    public FieldCropAssessment(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }
public void setCrop_establishment_score(String crop_establishment_score) {
underlyingNode.setProperty(CROP_ESTABLISHMENT_SCORE,crop_establishment_score);
}

public String getCrop_establishment_score(){
          try {
          return (String) underlyingNode.getProperty(CROP_ESTABLISHMENT_SCORE);

        } catch (Exception e) {
        }
        return null;
    }

}
