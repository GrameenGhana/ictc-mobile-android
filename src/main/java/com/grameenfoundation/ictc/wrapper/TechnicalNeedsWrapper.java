/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.wrapper;

/**
 *
 * @author Joseph George Davis
 * @date Jul 22, 2015 5:03:56 PM
 * description:
 */
public class TechnicalNeedsWrapper {
    
    String farmPlanning="farmplanning";
    String cropVarietyAndSeed="cropvarietyandseed";
    String weedControl="weedcontrol";
    String cropEstablishment="cropestablishment";
    String integratedSoilFertilityManagement="integratedsoilfertilitymanagement";
    String HarvestAndPostHarvest="harvestandpostharvest";
    
    
 public  void setHarvestAndPostHarvest(String HarvestAndPostHarvest) {
      this.HarvestAndPostHarvest=HarvestAndPostHarvest;
    }
 public  String getHarvestAndPostHarvest() {
        return HarvestAndPostHarvest;

    }
    
 public  void setIntegratedSoilFertilityManagement(String integratedSoilFertilityManagement) {
      this.integratedSoilFertilityManagement=integratedSoilFertilityManagement;
    }
 public  String getIntegratedSoilFertilityManagement() {
        return integratedSoilFertilityManagement;

    }
    
 public  void setCropEstablishment(String cropEstablishment) {
      this.cropEstablishment=cropEstablishment;
    }
 public  String getCropEstablishment() {
        return cropEstablishment;

    }
    
 public  void setWeedControl(String weedControl) {
      this.weedControl=weedControl;
    }
 public  String getWeedControl() {
        return weedControl;

    }
    
 public  void setCropVarietyAndSeed(String cropVarietyAndSeed) {
      this.cropVarietyAndSeed=cropVarietyAndSeed;
    }
 public  String getCropVarietyAndSeed() {
        return cropVarietyAndSeed;

    }
 public  void setFarmPlanning(String farmPlanning) {
      this.farmPlanning=farmPlanning;
    }
 public  String getFarmPlanning() {
        return farmPlanning;

    }

}
