/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.wrapper;

/**
 *
 * @author Joseph George Davis
 * @date Jul 22, 2015 9:10:23 AM
 * description:
 */
public class HarvestWrapper {
    
    
String timeCropReadyToHarvest="timecropreadytoharvest";
String timeCropHarvested="timecropharvested";
String timeCompletionHarvest="timecompletionharvest";
String noFamilyLabour="nofamilylabour";
String noHiredLabour="nohiredlabour";
String costOfHiredLabour="costofhiredlabour";
String yieldPerAcre="yieldperacre";
String noLabourtotal="nolabourtotal";


 public  void setNoLabourtotal(String noLabourtotal) {
      this.noLabourtotal=noLabourtotal;
    }
 public  String getNoLabourtotal() {
        return noLabourtotal;

    }

 public  void setYieldPerAcre(String yieldPerAcre) {
      this.yieldPerAcre=yieldPerAcre;
    }
 public  String getYieldPerAcre() {
        return yieldPerAcre;

    }


 public  void setCostOfHiredLabour(String costOfHiredLabour) {
      this.costOfHiredLabour=costOfHiredLabour;
    }
 public  String getCostOfHiredLabour() {
        return costOfHiredLabour;

    }

 public  void setNoHiredLabour(String noHiredLabour) {
      this.noHiredLabour=noHiredLabour;
    }
 public  String getNoHiredLabour() {
        return noHiredLabour;

    }
 public  void setNoFamilyLabour(String noFamilyLabour) {
      this.noFamilyLabour=noFamilyLabour;
    }
 public  String getNoFamilyLabour() {
        return noFamilyLabour;

    }


 public  void setTimeCompletionHarvest(String timeCompletionHarvest) {
      this.timeCompletionHarvest=timeCompletionHarvest;
    }
 public  String getTimeCompletionHarvest() {
        return timeCompletionHarvest;

    }


 public  void setTimeCropHarvested(String timeCropHarvested) {
      this.timeCropHarvested=timeCropHarvested;
    }
 public  String getTimeCropHarvested() {
        return timeCropHarvested;

    }


 public  void setTimeCropReadyToHarvest(String timeCropReadyToHarvest) {
      this.timeCropReadyToHarvest=timeCropReadyToHarvest;
    }
 public  String getTimeCropReadyToHarvest() {
        return timeCropReadyToHarvest;

    }

}
