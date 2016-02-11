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
 * @date Sep 24, 2015 12:18:54 PM
 * description:
 */
public class ProductionUpdate extends Status implements GeneralInterface {
    
    Node underlyingNode ;
   

    public ProductionUpdate(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }
    
   
    public static String APPLICATIONOFBASALFERTILIZER="applicationofbasalfertilizer";
    public static String APPLICATIONOFHERBICIDEDATE="applicationofherbicidedate";
    public static String APPLICATIONOFTOPDRESSFERTILIZER="applicationoftopdressfertilizer";
    public static String CROPYIELD="cropyield";
    public static String DATEFIRSTMANUALWEEDCONTROL="datefirstmanualweedcontrol";
    public static String DATEOFBASALFERTILIZERAPPLICATION="dateofbasalfertilizerapplication";
    public static String DATEOFSECONDMANUALWEEDCONTROL="dateofsecondmanualweedcontrol";
    public static String DATETOPDRESSINGWASCOMPLETED="datetopdressingwascompleted";
    public static String FIRSTMANUALWEEDCONTROLDATE="firstmanualweedcontroldate";
    public static String FOURTHWEEDCONTROLDATE="fourthweedcontroldate";
    public static String HAVEYOUPLANTEDYOURCROP="haveyouplantedyourcrop";
    public static String LANDCLEARINGDATE="landclearingdate";
    public static String METHODOFBASALFERTILIZERAPPLICATION="methodofbasalfertilizerapplication";
    public static String METHODOFBASALFERTILIZERAPPLICATIONOTHER="methodofbasalfertilizerapplicationother";
    public static String METHODOFLANDCLEARING="methodoflandclearing";
    public static String METHODOFLANDPREPARATION="methodoflandpreparation";
    public static String METHODOFTOPDRESSERFERTILIZERAPPLICATION="methodoftopdresserfertilizerapplication";
    public static String NUMBERMANUALWEEDCONTROLOCCASIONS="numbermanualweedcontroloccasions";
    public static String OTHERFERTILIZER="otherfertilizer";
    public static String OTHERTOPDRESSERFERTILIZERTYPE="othertopdresserfertilizertype";
    public static String PLANTINGDATE="plantingdate";
    public static String PLANTINGDISTANCEANDPOPULATION="plantingdistanceandpopulation";
    public static String PLOUGHINGDATE="ploughingdate";
    public static String POSTPLANTHERBICIDEUSE="postplantherbicideuse";
    public static String QUANTITYOFBASALFERTILIZERAPPLIED="quantityofbasalfertilizerapplied";
    public static String QUANTITYOFTOPDRESSERFERTILIZERAPPLIED="quantityoftopdresserfertilizerapplied";
    public static String QUANTITYPOSTPLANTHERBICIDE="quantitypostplantherbicide";
    public static String REASONFORCHANGEOFLANDCLEARING="reasonforchangeoflandclearing";
    public static String REASONFORCHANGEOFLANDPREPARATION="reasonforchangeoflandpreparation";
    public static String REASONFORCHANGEOFVARIETY="reasonforchangeofvariety";
    public static String REASONFORDEVIATION="reasonfordeviation";
    public static String REASONFORNOTPLANTING="reasonfornotplanting";
    public static String REFILLINGGAPSOCCURENCE="refillinggapsoccurence";
    public static String SOURCEOFPLANTING="sourceofplanting";
    public static String THIRDMANUALWEEDCONTROLDATE="thirdmanualweedcontroldate";
    public static String TIMEOFHARVEST="timeofharvest";
    public static String TYPEOFBASALFERTILIZER="typeofbasalfertilizer";
    public static String TYPEOFCROPVARIETYCULTIVATED="typeofcropvarietycultivated";
    public static String TYPEOFHERBICIDEFORPOSTPLANTWEEDCONTROL="typeofherbicideforpostplantweedcontrol";
    public static String TYPEOFTOPDRESSFERTILIZER="typeoftopdressfertilizer";
    public static String WHENDIDYOUFININSHPALNTINGYOURCROP="whendidyoufininshpalntingyourcrop";
    public static String UPDATED="updated";
    public static String MANUALWEEDCONTROLOCCURRENCE="manualweedcontroloccurrence";
    public static String POST_PLANT_HERBICIDE_NO_UPDATE="post_plant_herbicide_no_update";
    public static String POSTPLANTHERBICIDEFIRST="postplantherbicidefirst";
    public static String POSTPLANTHERBICIDEFREQUENCY="postplantherbicidefrequency";
    public static String POSTPLANTHERBICIDESECOND="postplantherbicidesecond";
    public static String POSTPLANTHERBICIDETHIRD="postplantherbicidethird";
    public static String REASON_FOR_CHANGE_OF_PLANT_DISTANCES="reason_for_change_of_plant_distances";
    public static String REFILLEDPROPORTIONCURRENT="refilledproportioncurrent";
    
    
    
public void setRefilledproportioncurrent(String refilledproportioncurrent) {
underlyingNode.setProperty(REFILLEDPROPORTIONCURRENT,refilledproportioncurrent);
}

public String getRefilledproportioncurrent(){
          try {
          return (String) underlyingNode.getProperty(REFILLEDPROPORTIONCURRENT);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setReason_for_change_of_plant_distances(String reason_for_change_of_plant_distances) {
underlyingNode.setProperty(REASON_FOR_CHANGE_OF_PLANT_DISTANCES,reason_for_change_of_plant_distances);
}

public String getReason_for_change_of_plant_distances(){
          try {
          return (String) underlyingNode.getProperty(REASON_FOR_CHANGE_OF_PLANT_DISTANCES);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setPostplantherbicidethird(String postplantherbicidethird) {
underlyingNode.setProperty(POSTPLANTHERBICIDETHIRD,postplantherbicidethird);
}

public String getPostplantherbicidethird(){
          try {
          return (String) underlyingNode.getProperty(POSTPLANTHERBICIDETHIRD);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setPostplantherbicidesecond(String postplantherbicidesecond) {
underlyingNode.setProperty(POSTPLANTHERBICIDESECOND,postplantherbicidesecond);
}

public String getPostplantherbicidesecond(){
          try {
          return (String) underlyingNode.getProperty(POSTPLANTHERBICIDESECOND);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setPostplantherbicidefrequency(String postplantherbicidefrequency) {
underlyingNode.setProperty(POSTPLANTHERBICIDEFREQUENCY,postplantherbicidefrequency);
}

public String getPostplantherbicidefrequency(){
          try {
          return (String) underlyingNode.getProperty(POSTPLANTHERBICIDEFREQUENCY);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setPostplantherbicidefirst(String postplantherbicidefirst) {
underlyingNode.setProperty(POSTPLANTHERBICIDEFIRST,postplantherbicidefirst);
}

public String getPostplantherbicidefirst(){
          try {
          return (String) underlyingNode.getProperty(POSTPLANTHERBICIDEFIRST);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setPost_plant_herbicide_no_update(String post_plant_herbicide_no_update) {
underlyingNode.setProperty(POST_PLANT_HERBICIDE_NO_UPDATE,post_plant_herbicide_no_update);
}

public String getPost_plant_herbicide_no_update(){
          try {
          return (String) underlyingNode.getProperty(POST_PLANT_HERBICIDE_NO_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setManualweedcontroloccurrence(String manualweedcontroloccurrence) {
underlyingNode.setProperty(MANUALWEEDCONTROLOCCURRENCE,manualweedcontroloccurrence);
}

public String getManualweedcontroloccurrence(){
          try {
          return (String) underlyingNode.getProperty(MANUALWEEDCONTROLOCCURRENCE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
    
public void setWhendidyoufininshpalntingyourcrop(String whendidyoufininshpalntingyourcrop) {
underlyingNode.setProperty(WHENDIDYOUFININSHPALNTINGYOURCROP,whendidyoufininshpalntingyourcrop);
}

public String getWhendidyoufininshpalntingyourcrop(){
          try {
          return (String) underlyingNode.getProperty(WHENDIDYOUFININSHPALNTINGYOURCROP);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setTypeoftopdressfertilizer(String typeoftopdressfertilizer) {
underlyingNode.setProperty(TYPEOFTOPDRESSFERTILIZER,typeoftopdressfertilizer);
}

public String getTypeoftopdressfertilizer(){
          try {
          return (String) underlyingNode.getProperty(TYPEOFTOPDRESSFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }
    
    
    
public void setTypeofherbicideforpostplantweedcontrol(String typeofherbicideforpostplantweedcontrol) {
underlyingNode.setProperty(TYPEOFHERBICIDEFORPOSTPLANTWEEDCONTROL,typeofherbicideforpostplantweedcontrol);
}

public String getTypeofherbicideforpostplantweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(TYPEOFHERBICIDEFORPOSTPLANTWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setTypeofcropvarietycultivated(String typeofcropvarietycultivated) {
underlyingNode.setProperty(TYPEOFCROPVARIETYCULTIVATED,typeofcropvarietycultivated);
}

public String getTypeofcropvarietycultivated(){
          try {
          return (String) underlyingNode.getProperty(TYPEOFCROPVARIETYCULTIVATED);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setTypeofbasalfertilizer(String typeofbasalfertilizer) {
underlyingNode.setProperty(TYPEOFBASALFERTILIZER,typeofbasalfertilizer);
}

public String getTypeofbasalfertilizer(){
          try {
          return (String) underlyingNode.getProperty(TYPEOFBASALFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setTimeofharvest(String timeofharvest) {
underlyingNode.setProperty(TIMEOFHARVEST,timeofharvest);
}

public String getTimeofharvest(){
          try {
          return (String) underlyingNode.getProperty(TIMEOFHARVEST);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setThirdmanualweedcontroldate(String thirdmanualweedcontroldate) {
underlyingNode.setProperty(THIRDMANUALWEEDCONTROLDATE,thirdmanualweedcontroldate);
}

public String getThirdmanualweedcontroldate(){
          try {
          return (String) underlyingNode.getProperty(THIRDMANUALWEEDCONTROLDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setSourceofplanting(String sourceofplanting) {
underlyingNode.setProperty(SOURCEOFPLANTING,sourceofplanting);
}

public String getSourceofplanting(){
          try {
          return (String) underlyingNode.getProperty(SOURCEOFPLANTING);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setRefillinggapsoccurence(String refillinggapsoccurence) {
underlyingNode.setProperty(REFILLINGGAPSOCCURENCE,refillinggapsoccurence);
}

public String getRefillinggapsoccurence(){
          try {
          return (String) underlyingNode.getProperty(REFILLINGGAPSOCCURENCE);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setReasonfornotplanting(String reasonfornotplanting) {
underlyingNode.setProperty(REASONFORNOTPLANTING,reasonfornotplanting);
}

public String getReasonfornotplanting(){
          try {
          return (String) underlyingNode.getProperty(REASONFORNOTPLANTING);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setReasonfordeviation(String reasonfordeviation) {
underlyingNode.setProperty(REASONFORDEVIATION,reasonfordeviation);
}

public String getReasonfordeviation(){
          try {
          return (String) underlyingNode.getProperty(REASONFORDEVIATION);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setReasonforchangeofvariety(String reasonforchangeofvariety) {
underlyingNode.setProperty(REASONFORCHANGEOFVARIETY,reasonforchangeofvariety);
}

public String getReasonforchangeofvariety(){
          try {
          return (String) underlyingNode.getProperty(REASONFORCHANGEOFVARIETY);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setReasonforchangeoflandpreparation(String reasonforchangeoflandpreparation) {
underlyingNode.setProperty(REASONFORCHANGEOFLANDPREPARATION,reasonforchangeoflandpreparation);
}

public String getReasonforchangeoflandpreparation(){
          try {
          return (String) underlyingNode.getProperty(REASONFORCHANGEOFLANDPREPARATION);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setReasonforchangeoflandclearing(String reasonforchangeoflandclearing) {
underlyingNode.setProperty(REASONFORCHANGEOFLANDCLEARING,reasonforchangeoflandclearing);
}

public String getReasonforchangeoflandclearing(){
          try {
          return (String) underlyingNode.getProperty(REASONFORCHANGEOFLANDCLEARING);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setQuantitypostplantherbicide(String quantitypostplantherbicide) {
underlyingNode.setProperty(QUANTITYPOSTPLANTHERBICIDE,quantitypostplantherbicide);
}

public String getQuantitypostplantherbicide(){
          try {
          return (String) underlyingNode.getProperty(QUANTITYPOSTPLANTHERBICIDE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setQuantityoftopdresserfertilizerapplied(String quantityoftopdresserfertilizerapplied) {
underlyingNode.setProperty(QUANTITYOFTOPDRESSERFERTILIZERAPPLIED,quantityoftopdresserfertilizerapplied);
}

public String getQuantityoftopdresserfertilizerapplied(){
          try {
          return (String) underlyingNode.getProperty(QUANTITYOFTOPDRESSERFERTILIZERAPPLIED);

        } catch (Exception e) {
        }
        return null;
    }
    
    
    
public void setQuantityofbasalfertilizerapplied(String quantityofbasalfertilizerapplied) {
underlyingNode.setProperty(QUANTITYOFBASALFERTILIZERAPPLIED,quantityofbasalfertilizerapplied);
}

public String getQuantityofbasalfertilizerapplied(){
          try {
          return (String) underlyingNode.getProperty(QUANTITYOFBASALFERTILIZERAPPLIED);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setPostplantherbicideuse(String postplantherbicideuse) {
underlyingNode.setProperty(POSTPLANTHERBICIDEUSE,postplantherbicideuse);
}

public String getPostplantherbicideuse(){
          try {
          return (String) underlyingNode.getProperty(POSTPLANTHERBICIDEUSE);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setPloughingdate(String ploughingdate) {
underlyingNode.setProperty(PLOUGHINGDATE,ploughingdate);
}

public String getPloughingdate(){
          try {
          return (String) underlyingNode.getProperty(PLOUGHINGDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setPlantingdistanceandpopulation(String plantingdistanceandpopulation) {
underlyingNode.setProperty(PLANTINGDISTANCEANDPOPULATION,plantingdistanceandpopulation);
}

public String getPlantingdistanceandpopulation(){
          try {
          return (String) underlyingNode.getProperty(PLANTINGDISTANCEANDPOPULATION);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setPlantingdate(String plantingdate) {
underlyingNode.setProperty(PLANTINGDATE,plantingdate);
}

public String getPlantingdate(){
          try {
          return (String) underlyingNode.getProperty(PLANTINGDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
    
public void setOthertopdresserfertilizertype(String othertopdresserfertilizertype) {
underlyingNode.setProperty(OTHERTOPDRESSERFERTILIZERTYPE,othertopdresserfertilizertype);
}

public String getOthertopdresserfertilizertype(){
          try {
          return (String) underlyingNode.getProperty(OTHERTOPDRESSERFERTILIZERTYPE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setOtherfertilizer(String otherfertilizer) {
underlyingNode.setProperty(OTHERFERTILIZER,otherfertilizer);
}

public String getOtherfertilizer(){
          try {
          return (String) underlyingNode.getProperty(OTHERFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setNumbermanualweedcontroloccasions(String numbermanualweedcontroloccasions) {
underlyingNode.setProperty(NUMBERMANUALWEEDCONTROLOCCASIONS,numbermanualweedcontroloccasions);
}

public String getNumbermanualweedcontroloccasions(){
          try {
          return (String) underlyingNode.getProperty(NUMBERMANUALWEEDCONTROLOCCASIONS);

        } catch (Exception e) {
        }
        return null;
    }
    
    
    
public void setMethodoftopdresserfertilizerapplication(String methodoftopdresserfertilizerapplication) {
underlyingNode.setProperty(METHODOFTOPDRESSERFERTILIZERAPPLICATION,methodoftopdresserfertilizerapplication);
}

public String getMethodoftopdresserfertilizerapplication(){
          try {
          return (String) underlyingNode.getProperty(METHODOFTOPDRESSERFERTILIZERAPPLICATION);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setMethodoflandpreparation(String methodoflandpreparation) {
underlyingNode.setProperty(METHODOFLANDPREPARATION,methodoflandpreparation);
}

public String getMethodoflandpreparation(){
          try {
          return (String) underlyingNode.getProperty(METHODOFLANDPREPARATION);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setMethodoflandclearing(String methodoflandclearing) {
underlyingNode.setProperty(METHODOFLANDCLEARING,methodoflandclearing);
}

public String getMethodoflandclearing(){
          try {
          return (String) underlyingNode.getProperty(METHODOFLANDCLEARING);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setMethodofbasalfertilizerapplicationother(String methodofbasalfertilizerapplicationother) {
underlyingNode.setProperty(METHODOFBASALFERTILIZERAPPLICATIONOTHER,methodofbasalfertilizerapplicationother);
}

public String getMethodofbasalfertilizerapplicationother(){
          try {
          return (String) underlyingNode.getProperty(METHODOFBASALFERTILIZERAPPLICATIONOTHER);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setMethodofbasalfertilizerapplication(String methodofbasalfertilizerapplication) {
underlyingNode.setProperty(METHODOFBASALFERTILIZERAPPLICATION,methodofbasalfertilizerapplication);
}

public String getMethodofbasalfertilizerapplication(){
          try {
          return (String) underlyingNode.getProperty(METHODOFBASALFERTILIZERAPPLICATION);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setLandclearingdate(String landclearingdate) {
underlyingNode.setProperty(LANDCLEARINGDATE,landclearingdate);
}

public String getLandclearingdate(){
          try {
          return (String) underlyingNode.getProperty(LANDCLEARINGDATE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
    
public void setHaveyouplantedyourcrop(String haveyouplantedyourcrop) {
underlyingNode.setProperty(HAVEYOUPLANTEDYOURCROP,haveyouplantedyourcrop);
}

public String getHaveyouplantedyourcrop(){
          try {
          return (String) underlyingNode.getProperty(HAVEYOUPLANTEDYOURCROP);

        } catch (Exception e) {
        }
        return null;
    }
    
    
    
public void setFourthweedcontroldate(String fourthweedcontroldate) {
underlyingNode.setProperty(FOURTHWEEDCONTROLDATE,fourthweedcontroldate);
}

public String getFourthweedcontroldate(){
          try {
          return (String) underlyingNode.getProperty(FOURTHWEEDCONTROLDATE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
    
public void setFirstmanualweedcontroldate(String firstmanualweedcontroldate) {
underlyingNode.setProperty(FIRSTMANUALWEEDCONTROLDATE,firstmanualweedcontroldate);
}

public String getFirstmanualweedcontroldate(){
          try {
          return (String) underlyingNode.getProperty(FIRSTMANUALWEEDCONTROLDATE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setDatetopdressingwascompleted(String datetopdressingwascompleted) {
underlyingNode.setProperty(DATETOPDRESSINGWASCOMPLETED,datetopdressingwascompleted);
}

public String getDatetopdressingwascompleted(){
          try {
          return (String) underlyingNode.getProperty(DATETOPDRESSINGWASCOMPLETED);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setDateofsecondmanualweedcontrol(String dateofsecondmanualweedcontrol) {
underlyingNode.setProperty(DATEOFSECONDMANUALWEEDCONTROL,dateofsecondmanualweedcontrol);
}

public String getDateofsecondmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(DATEOFSECONDMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setDateofbasalfertilizerapplication(String dateofbasalfertilizerapplication) {
underlyingNode.setProperty(DATEOFBASALFERTILIZERAPPLICATION,dateofbasalfertilizerapplication);
}

public String getDateofbasalfertilizerapplication(){
          try {
          return (String) underlyingNode.getProperty(DATEOFBASALFERTILIZERAPPLICATION);

        } catch (Exception e) {
        }
        return null;
    }

    
    
    
public void setDatefirstmanualweedcontrol(String datefirstmanualweedcontrol) {
underlyingNode.setProperty(DATEFIRSTMANUALWEEDCONTROL,datefirstmanualweedcontrol);
}

public String getDatefirstmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(DATEFIRSTMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setCropyield(String cropyield) {
underlyingNode.setProperty(CROPYIELD,cropyield);
}

public String getCropyield(){
          try {
          return (String) underlyingNode.getProperty(CROPYIELD);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setApplicationoftopdressfertilizer(String applicationoftopdressfertilizer) {
underlyingNode.setProperty(APPLICATIONOFTOPDRESSFERTILIZER,applicationoftopdressfertilizer);
}

public String getApplicationoftopdressfertilizer(){
          try {
          return (String) underlyingNode.getProperty(APPLICATIONOFTOPDRESSFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }
    
    
    
public void setApplicationofherbicidedate(String applicationofherbicidedate) {
underlyingNode.setProperty(APPLICATIONOFHERBICIDEDATE,applicationofherbicidedate);
}

public String getApplicationofherbicidedate(){
          try {
          return (String) underlyingNode.getProperty(APPLICATIONOFHERBICIDEDATE);

        } catch (Exception e) {
        }
        return null;
    }
public void setApplicationofbasalfertilizer(String applicationofbasalfertilizer) {
underlyingNode.setProperty(APPLICATIONOFBASALFERTILIZER,applicationofbasalfertilizer);
}

public String getApplicationofbasalfertilizer(){
          try {
          return (String) underlyingNode.getProperty(APPLICATIONOFBASALFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }
    
   public void setUpdated(long date) {
   underlyingNode.setProperty(UPDATED,date);
}

public long getUpdated(){
          try {
          return (Long) underlyingNode.getProperty(UPDATED);

        } catch (Exception e) {
        }
        return 0l;
    } 

}
