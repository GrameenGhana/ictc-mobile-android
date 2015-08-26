/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.wrapper;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joseph George Davis
 * @date Jul 22, 2015 5:03:56 PM description:
 */
public class TechnicalNeedsWrapper {

    private String farmPlanning = "farmplanning";
    private String cropVarietyAndSeed = "cropvarietyandseed";
    private String weedControl = "weedcontrol";
    private String cropEstablishment = "cropestablishment";
    private String integratedSoilFertilityManagement = "integratedsoilfertilitymanagement";
    private String HarvestAndPostHarvest = "harvestandpostharvest";

    public TechnicalNeedsWrapper(String fm, String variety, String weedControl, String cropEst, String intsol, String harvesAnsPst) {
        this.farmPlanning = fm;
        this.cropVarietyAndSeed = variety;
        this.weedControl = weedControl;
        this.cropEstablishment = cropEst;
        this.integratedSoilFertilityManagement = intsol;
        this.HarvestAndPostHarvest = harvesAnsPst;
    }

    public List<String> getInterest() {
        List<String> interest = new ArrayList<String>();
        if (!farmPlanning.equalsIgnoreCase("farmplanning")) {
            interest.add(farmPlanning);
        }
        if (!HarvestAndPostHarvest.equalsIgnoreCase("HarvestAndPostHarvest")) {
            interest.add(HarvestAndPostHarvest);
        }
        if (!integratedSoilFertilityManagement.equalsIgnoreCase("integratedSoilFertilityManagement")) {
            interest.add(integratedSoilFertilityManagement);
        }
        if (!cropEstablishment.equalsIgnoreCase("cropEstablishment")) {
            interest.add(cropEstablishment);
        }
        if (!cropVarietyAndSeed.equalsIgnoreCase("cropVarietyAndSeed")) {
            interest.add(cropVarietyAndSeed);
        }
        if (!weedControl.equalsIgnoreCase("weedControl")) {
            interest.add(weedControl);
        }
        return interest;
    }

    public void setHarvestAndPostHarvest(String HarvestAndPostHarvest) {
        this.HarvestAndPostHarvest = HarvestAndPostHarvest;
    }

    public String getHarvestAndPostHarvest() {
        return HarvestAndPostHarvest;

    }

    public void setIntegratedSoilFertilityManagement(String integratedSoilFertilityManagement) {
        this.integratedSoilFertilityManagement = integratedSoilFertilityManagement;
    }

    public String getIntegratedSoilFertilityManagement() {
        return integratedSoilFertilityManagement;

    }

    public void setCropEstablishment(String cropEstablishment) {
        this.cropEstablishment = cropEstablishment;
    }

    public String getCropEstablishment() {
        return cropEstablishment;

    }

    public void setWeedControl(String weedControl) {
        this.weedControl = weedControl;
    }

    public String getWeedControl() {
        return weedControl;

    }

    public void setCropVarietyAndSeed(String cropVarietyAndSeed) {
        this.cropVarietyAndSeed = cropVarietyAndSeed;
    }

    public String getCropVarietyAndSeed() {
        return cropVarietyAndSeed;

    }

    public void setFarmPlanning(String farmPlanning) {
        this.farmPlanning = farmPlanning;
    }

    public String getFarmPlanning() {
        return farmPlanning;

    }

}
