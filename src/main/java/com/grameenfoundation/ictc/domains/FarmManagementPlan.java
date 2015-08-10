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
 * @date Aug 7, 2015 9:59:18 AM
 * description:
 */
public class FarmManagementPlan extends Status implements GeneralInterface{

    Node underlyingNode;
    
    public FarmManagementPlan(Node underlyingNode) {
        super(underlyingNode);
    }
    
    
public static String DATEOFLANDIDENTIFICATION="dateoflandidentification";
public static String LOCATIONOFLAND="locationofland";
public static String TARGETAREAOFLAND="targetareaofland";
public static String COSTOFRENTINGLAND="costofrentingland";
public static String TARGETYIELDPERACRE="targetyieldperacre";
public static String EXPECTEDPRICEPERTON="expectedpriceperton";
public static String TARGETPRODUCTION="targetproduction";
public static String NAMEOFVARIETY="nameofvariety";
public static String PURCHASEOFSTAKESDATE="purchaseofstakesdate";
public static String QUANTITYOFPLANTINGMATERIAL="quantityofplantingmaterial";
public static String WEIGHTOFPLANTINGMATERIALPERACRE="weightofplantingmaterialperacre";
public static String QUANTITYOFPLANTINGMATERIALPERACRE="quantityofplantingmaterialperacre";
public static String COSTPERUNITOFPLANTINGMATERIAL="costperunitofplantingmaterial";
public static String METHODOFLANDCLEARING="methodoflandclearing";
public static String TYPEOFHERBICIDEFORPREPLANTING="typeofherbicideforpreplanting";
public static String QUANTITYOFHERBICIDE="quantityofherbicide";
public static String PURCHASEOFHERBICIDEDATE="purchaseofherbicidedate";
public static String APPLICATIONOFHERBICIDEDATE="applicationofherbicidedate";
public static String COSTOFAPPLICATIONOFHERBICIDE="costofapplicationofherbicide";
public static String PLOUGHINGDATE="ploughingdate";
public static String PLOUGHINGCOSTPERACRE="ploughingcostperacre";
public static String HARROWINGDATE="harrowingdate";
public static String HARROWINGCOSTPERACRE="harrowingcostperacre";
public static String HOEPLOUGHINGDATE="hoeploughingdate";
public static String HOEPLOUGHINGNUMBEROFLABORHANDS="hoeploughingnumberoflaborhands";
public static String HOEPLOUGHINGNUMBEROFHIREDLABOR="hoeploughingnumberofhiredlabor";
public static String HOEPLOUGHINGNUMBEROFFAMILYLABOR="hoeploughingnumberoffamilylabor";
public static String HOEPLOUGHINGCOMPENSATION="hoeploughingcompensation";
public static String SEEDBEDFORMTYPE="seedbedformtype";
public static String SEEDBEDPREPARATIONDATE="seedbedpreparationdate";
public static String SEEDBEDPREPERATIONNUMBEROFLABORHANDS="seedbedpreperationnumberoflaborhands";
public static String SEEDBEDPREPARATIONTIME="seedbedpreparationtime";
public static String SEEDBEDPREPARATIONHIREDLABOR="seedbedpreparationhiredlabor";
public static String SEEDBEDPREPARATIONFAMILYLABOR="seedbedpreparationfamilylabor";
public static String SEEDBEDPREPARATIONCOMPENSATION="seedbedpreparationcompensation";
public static String PLANTINGDATE="plantingdate";
public static String LENGTHOFCUTTINGSUSED="lengthofcuttingsused";
public static String PLANTINGDISTANCEBETWEENROWS="plantingdistancebetweenrows";
public static String PLANTINGDISTANCEBETWEENPLANTS="plantingdistancebetweenplants";
public static String PLANTINGNUMBEROFLABORHANDS="plantingnumberoflaborhands";
public static String PLANTINGTIME="plantingtime";
public static String PLANTINGHIREDLABOR="plantinghiredlabor";
public static String PLANTINGCOMPENSATION="plantingcompensation";
public static String REFILLINGGAPSNUMBEROFLABORHANDS="refillinggapsnumberoflaborhands";
public static String REFILLINGGAPSTIME="refillinggapstime";
public static String REFILLINGGAPSHIREDLABOR="refillinggapshiredlabor";
public static String REFILLINGGAPSCOMPENSATION="refillinggapscompensation";
public static String PURCHASEOFHERBICIDEPOSTPLANT="purchaseofherbicidepostplant";
public static String TYPEOFHERBICIDEFORPOSTPLANTWEEDCONTROL="typeofherbicideforpostplantweedcontrol";
public static String QUANTITYOFPOSTPLANTHERBICIDE="quantityofpostplantherbicide";
public static String PRICEOFHERBICIDEPOSTPLANT="priceofherbicidepostplant";
public static String SEEDBEDFORMTYPEPOSTPLANT="seedbedformtypepostplant";
public static String COSTOFAPPLICATIONOFHERBICIDEPOSTPLANT="costofapplicationofherbicidepostplant";
public static String TYPEOFBASALFERTILIZER="typeofbasalfertilizer";
public static String PURCHASEOFBASALFERTILIZERDATE="purchaseofbasalfertilizerdate";
public static String QUANTITYOFBASALFERTILIZERPURCHASED="quantityofbasalfertilizerpurchased";
public static String COSTPERUNITOFFERTILIZERAPPLIED="costperunitoffertilizerapplied";
public static String METHODOFBASALFERTILIZERAPPLICATION="methodofbasalfertilizerapplication";
public static String TIMEAPPLICATIONOFBASALFERTILIZER="timeapplicationofbasalfertilizer";
public static String TOTALNUMBEROFLABORBASALFERTILIZER="totalnumberoflaborbasalfertilizer";
public static String TIMEFORCOMPLETIONBASALAPPLICATION="timeforcompletionbasalapplication";
public static String NUMBEROFFAMILYLABORBASALFERTILIZER="numberoffamilylaborbasalfertilizer";
public static String NUMBEROFHIREDLABORBASALFERTILIZER="numberofhiredlaborbasalfertilizer";
public static String TOTALCOSTOFHIREDLABORBASALFERTILIZER="totalcostofhiredlaborbasalfertilizer";
public static String TYPEOFTOPDRESSFERTILIZER="typeoftopdressfertilizer";
public static String QUANTITYOFTOPDRESSERFERTILIZER="quantityoftopdresserfertilizer";
public static String PURCHASEOFTOPDRESSFERTILIZERDATE="purchaseoftopdressfertilizerdate";
public static String PRICEOFTOPDRESSERFERTILIZER="priceoftopdresserfertilizer";
public static String METHODOFTOPDRESSERFERTILIZERAPPLICATION="methodoftopdresserfertilizerapplication";
public static String TIMEAPPLICATIONTOPDRESSING="timeapplicationtopdressing";
public static String NUMBEROFLABORTOPDRESSINGFERTILIZER="numberoflabortopdressingfertilizer";
public static String TIMEFORCOMPLETIONTOPDRESSERFERTILIZER="timeforcompletiontopdresserfertilizer";
public static String NUMBEROFFAMILYLABOURTOPDRESSER="numberoffamilylabourtopdresser";
public static String NUMBEROFHIREDLABORTOPDRESS="numberofhiredlabortopdress";
public static String COSTOFHIREDLABORTOPDRESSERFERTILIZER="costofhiredlabortopdresserfertilizer";
public static String NUMBEROCCASIONMANUALWEEDCONTROL="numberoccasionmanualweedcontrol";
public static String DATEFIRSTOCCASIONMANUALWEEDCONTROL="datefirstoccasionmanualweedcontrol";
public static String NUMBEROFLABORFIRSTOCCASIONWEEDCONTROL="numberoflaborfirstoccasionweedcontrol";
public static String TIMECOMPLETIONFIRSTMANUALWEEDCONTROL="timecompletionfirstmanualweedcontrol";
public static String NUMBERFAMILYLABORFIRSTMANUALWEEDCONTROL="numberfamilylaborfirstmanualweedcontrol";
public static String NUMBERHIREDLABORFIRSTMANUALWEEDCONTROL="numberhiredlaborfirstmanualweedcontrol";
public static String COSTHIREDLABORFIRSTMANUALWEEDCONTROL="costhiredlaborfirstmanualweedcontrol";
public static String NUMBEROFLABORSECONDWEEDCONTROL="numberoflaborsecondweedcontrol";
public static String TIMECOMPLETIONSECONDMANUALWEENCONTROL="timecompletionsecondmanualweencontrol";
public static String NUMBERFAMILYLABORSECONDMANUALWEEDCONTROL="numberfamilylaborsecondmanualweedcontrol";
public static String NUMBERHIREDLABORSECONDMANUALWEEDCONTROL="numberhiredlaborsecondmanualweedcontrol";
public static String COSTOFHIREDLABORSECONDMANUALWEEDCONTROL="costofhiredlaborsecondmanualweedcontrol";
public static String DATEOFTHIRDMANUALWEEDCONTROL="dateofthirdmanualweedcontrol";
public static String NUMBEROFLABORTHIRDMANUALWEEDCONTROL="numberoflaborthirdmanualweedcontrol";
public static String TIMECOMPLETIONTHIRDMANUALWEEDCONTROL="timecompletionthirdmanualweedcontrol";
public static String NUMBERFAMILYLABORTHIRDMANUALWEEDCONTROL="numberfamilylaborthirdmanualweedcontrol";
public static String NUMBERHIREDLABORTHIRDMANUALWEEDCONTROL="numberhiredlaborthirdmanualweedcontrol";
public static String COSTOFHIREDLABOURTHIRDMANUALWEEDCONTROL="costofhiredlabourthirdmanualweedcontrol";
public static String DATEFOURTHMANUALWEEDCONTROL="datefourthmanualweedcontrol";
public static String NUMBERLABORFOURTHMANUALWEEDCONTROL="numberlaborfourthmanualweedcontrol";
public static String TIMECOMPLETIONFOURTHMANUALWEEDCONTROL="timecompletionfourthmanualweedcontrol";
public static String NUMBERFAMILYLABORFOURTHMANUALWEEDCONTROL="numberfamilylaborfourthmanualweedcontrol";
public static String NUMBERHIREDLABORFOURTHMANUALWEEDCONTROL="numberhiredlaborfourthmanualweedcontrol";
public static String COSTHIREDLABORFOURTHMANUALWEEDCONTROL="costhiredlaborfourthmanualweedcontrol";
public static String DATEFIFTHMANUALWEEDCONTROL="datefifthmanualweedcontrol";
public static String NUMBERLABORFIFTHWEEDCONTROL="numberlaborfifthweedcontrol";
public static String TIMECOMPLETIONFIFTHMANUALWEEDCONTROL="timecompletionfifthmanualweedcontrol";
public static String NUMBERFAMILYLABORFIFTHMANUALWEEDCONTROL="numberfamilylaborfifthmanualweedcontrol";
public static String NUMBERHIREDLABOURFIFTHMANUAWEEDCONTROL="numberhiredlabourfifthmanuaweedcontrol";
public static String COSTHIREDLABORFIFTHMANUALWEEDCONTROL="costhiredlaborfifthmanualweedcontrol";
public static String HARVESTDATE="harvestdate";
public static String NUMBEROFLABORHARVEST="numberoflaborharvest";
public static String TIMECOMPLETIONHARVEST="timecompletionharvest";
public static String SEEDBEDFORMTYPEHARVEST="seedbedformtypeharvest";
public static String NUMBEROFHIREDLABORHARVEST="numberofhiredlaborharvest";
public static String YIELDPERACRE="yieldperacre";
public static String QUANTITYCASSAVAHARVESTEDPROCESSED="quantitycassavaharvestedprocessed";
public static String PEELINGSTARTOFDRYINGDATE="peelingstartofdryingdate";
public static String METHODOFPROCESSINGDEHUSKINGPEELING="methodofprocessingdehuskingpeeling";
public static String NUMBEROFLABORDEHUSKINPEELING="numberoflabordehuskinpeeling";



public void setNumberoflabordehuskinpeeling(String numberoflabordehuskinpeeling) {
underlyingNode.setProperty(NUMBEROFLABORDEHUSKINPEELING,numberoflabordehuskinpeeling);
}

public String getNumberoflabordehuskinpeeling(){
          try {
          return (String) underlyingNode.getProperty(NUMBEROFLABORDEHUSKINPEELING);

        } catch (Exception e) {
        }
        return null;
    }



public void setMethodofprocessingdehuskingpeeling(String methodofprocessingdehuskingpeeling) {
underlyingNode.setProperty(METHODOFPROCESSINGDEHUSKINGPEELING,methodofprocessingdehuskingpeeling);
}

public String getMethodofprocessingdehuskingpeeling(){
          try {
          return (String) underlyingNode.getProperty(METHODOFPROCESSINGDEHUSKINGPEELING);

        } catch (Exception e) {
        }
        return null;
    }

public void setPeelingstartofdryingdate(String peelingstartofdryingdate) {
underlyingNode.setProperty(PEELINGSTARTOFDRYINGDATE,peelingstartofdryingdate);
}

public String getPeelingstartofdryingdate(){
          try {
          return (String) underlyingNode.getProperty(PEELINGSTARTOFDRYINGDATE);

        } catch (Exception e) {
        }
        return null;
    }



public void setQuantitycassavaharvestedprocessed(String quantitycassavaharvestedprocessed) {
underlyingNode.setProperty(QUANTITYCASSAVAHARVESTEDPROCESSED,quantitycassavaharvestedprocessed);
}

public String getQuantitycassavaharvestedprocessed(){
          try {
          return (String) underlyingNode.getProperty(QUANTITYCASSAVAHARVESTEDPROCESSED);

        } catch (Exception e) {
        }
        return null;
    }


public void setYieldperacre(String yieldperacre) {
underlyingNode.setProperty(YIELDPERACRE,yieldperacre);
}

public String getYieldperacre(){
          try {
          return (String) underlyingNode.getProperty(YIELDPERACRE);

        } catch (Exception e) {
        }
        return null;
    }

public void setNumberofhiredlaborharvest(String numberofhiredlaborharvest) {
underlyingNode.setProperty(NUMBEROFHIREDLABORHARVEST,numberofhiredlaborharvest);
}

public String getNumberofhiredlaborharvest(){
          try {
          return (String) underlyingNode.getProperty(NUMBEROFHIREDLABORHARVEST);

        } catch (Exception e) {
        }
        return null;
    }


public void setSeedbedformtypeharvest(String seedbedformtypeharvest) {
underlyingNode.setProperty(SEEDBEDFORMTYPEHARVEST,seedbedformtypeharvest);
}

public String getSeedbedformtypeharvest(){
          try {
          return (String) underlyingNode.getProperty(SEEDBEDFORMTYPEHARVEST);

        } catch (Exception e) {
        }
        return null;
    }


public void setTimecompletionharvest(String timecompletionharvest) {
underlyingNode.setProperty(TIMECOMPLETIONHARVEST,timecompletionharvest);
}

public String getTimecompletionharvest(){
          try {
          return (String) underlyingNode.getProperty(TIMECOMPLETIONHARVEST);

        } catch (Exception e) {
        }
        return null;
    }


public void setNumberoflaborharvest(String numberoflaborharvest) {
underlyingNode.setProperty(NUMBEROFLABORHARVEST,numberoflaborharvest);
}

public String getNumberoflaborharvest(){
          try {
          return (String) underlyingNode.getProperty(NUMBEROFLABORHARVEST);

        } catch (Exception e) {
        }
        return null;
    }



public void setHarvestdate(String harvestdate) {
underlyingNode.setProperty(HARVESTDATE,harvestdate);
}

public String getHarvestdate(){
          try {
          return (String) underlyingNode.getProperty(HARVESTDATE);

        } catch (Exception e) {
        }
        return null;
    }

public void setCosthiredlaborfifthmanualweedcontrol(String costhiredlaborfifthmanualweedcontrol) {
underlyingNode.setProperty(COSTHIREDLABORFIFTHMANUALWEEDCONTROL,costhiredlaborfifthmanualweedcontrol);
}

public String getCosthiredlaborfifthmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(COSTHIREDLABORFIFTHMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }



public void setNumberhiredlabourfifthmanuaweedcontrol(String numberhiredlabourfifthmanuaweedcontrol) {
underlyingNode.setProperty(NUMBERHIREDLABOURFIFTHMANUAWEEDCONTROL,numberhiredlabourfifthmanuaweedcontrol);
}

public String getNumberhiredlabourfifthmanuaweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(NUMBERHIREDLABOURFIFTHMANUAWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

public void setNumberfamilylaborfifthmanualweedcontrol(String numberfamilylaborfifthmanualweedcontrol) {
underlyingNode.setProperty(NUMBERFAMILYLABORFIFTHMANUALWEEDCONTROL,numberfamilylaborfifthmanualweedcontrol);
}

public String getNumberfamilylaborfifthmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(NUMBERFAMILYLABORFIFTHMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }



public void setTimecompletionfifthmanualweedcontrol(String timecompletionfifthmanualweedcontrol) {
underlyingNode.setProperty(TIMECOMPLETIONFIFTHMANUALWEEDCONTROL,timecompletionfifthmanualweedcontrol);
}

public String getTimecompletionfifthmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(TIMECOMPLETIONFIFTHMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }


public void setNumberlaborfifthweedcontrol(String numberlaborfifthweedcontrol) {
underlyingNode.setProperty(NUMBERLABORFIFTHWEEDCONTROL,numberlaborfifthweedcontrol);
}

public String getNumberlaborfifthweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(NUMBERLABORFIFTHWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }


public void setDatefifthmanualweedcontrol(String datefifthmanualweedcontrol) {
underlyingNode.setProperty(DATEFIFTHMANUALWEEDCONTROL,datefifthmanualweedcontrol);
}

public String getDatefifthmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(DATEFIFTHMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }



public void setCosthiredlaborfourthmanualweedcontrol(String costhiredlaborfourthmanualweedcontrol) {
underlyingNode.setProperty(COSTHIREDLABORFOURTHMANUALWEEDCONTROL,costhiredlaborfourthmanualweedcontrol);
}

public String getCosthiredlaborfourthmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(COSTHIREDLABORFOURTHMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }


public void setNumberhiredlaborfourthmanualweedcontrol(String numberhiredlaborfourthmanualweedcontrol) {
underlyingNode.setProperty(NUMBERHIREDLABORFOURTHMANUALWEEDCONTROL,numberhiredlaborfourthmanualweedcontrol);
}

public String getNumberhiredlaborfourthmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(NUMBERHIREDLABORFOURTHMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

public void setNumberfamilylaborfourthmanualweedcontrol(String numberfamilylaborfourthmanualweedcontrol) {
underlyingNode.setProperty(NUMBERFAMILYLABORFOURTHMANUALWEEDCONTROL,numberfamilylaborfourthmanualweedcontrol);
}

public String getNumberfamilylaborfourthmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(NUMBERFAMILYLABORFOURTHMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }



public void setTimecompletionfourthmanualweedcontrol(String timecompletionfourthmanualweedcontrol) {
underlyingNode.setProperty(TIMECOMPLETIONFOURTHMANUALWEEDCONTROL,timecompletionfourthmanualweedcontrol);
}

public String getTimecompletionfourthmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(TIMECOMPLETIONFOURTHMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }







public void setNumberlaborfourthmanualweedcontrol(String numberlaborfourthmanualweedcontrol) {
underlyingNode.setProperty(NUMBERLABORFOURTHMANUALWEEDCONTROL,numberlaborfourthmanualweedcontrol);
}

public String getNumberlaborfourthmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(NUMBERLABORFOURTHMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }




public void setDatefourthmanualweedcontrol(String datefourthmanualweedcontrol) {
underlyingNode.setProperty(DATEFOURTHMANUALWEEDCONTROL,datefourthmanualweedcontrol);
}

public String getDatefourthmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(DATEFOURTHMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

public void setCostofhiredlabourthirdmanualweedcontrol(String costofhiredlabourthirdmanualweedcontrol) {
underlyingNode.setProperty(COSTOFHIREDLABOURTHIRDMANUALWEEDCONTROL,costofhiredlabourthirdmanualweedcontrol);
}

public String getCostofhiredlabourthirdmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(COSTOFHIREDLABOURTHIRDMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }




public void setNumberhiredlaborthirdmanualweedcontrol(String numberhiredlaborthirdmanualweedcontrol) {
underlyingNode.setProperty(NUMBERHIREDLABORTHIRDMANUALWEEDCONTROL,numberhiredlaborthirdmanualweedcontrol);
}

public String getNumberhiredlaborthirdmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(NUMBERHIREDLABORTHIRDMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }


public void setNumberfamilylaborthirdmanualweedcontrol(String numberfamilylaborthirdmanualweedcontrol) {
underlyingNode.setProperty(NUMBERFAMILYLABORTHIRDMANUALWEEDCONTROL,numberfamilylaborthirdmanualweedcontrol);
}

public String getNumberfamilylaborthirdmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(NUMBERFAMILYLABORTHIRDMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }



public void setTimecompletionthirdmanualweedcontrol(String timecompletionthirdmanualweedcontrol) {
underlyingNode.setProperty(TIMECOMPLETIONTHIRDMANUALWEEDCONTROL,timecompletionthirdmanualweedcontrol);
}

public String getTimecompletionthirdmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(TIMECOMPLETIONTHIRDMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }


public void setNumberoflaborthirdmanualweedcontrol(String numberoflaborthirdmanualweedcontrol) {
underlyingNode.setProperty(NUMBEROFLABORTHIRDMANUALWEEDCONTROL,numberoflaborthirdmanualweedcontrol);
}

public String getNumberoflaborthirdmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(NUMBEROFLABORTHIRDMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }




public void setDateofthirdmanualweedcontrol(String dateofthirdmanualweedcontrol) {
underlyingNode.setProperty(DATEOFTHIRDMANUALWEEDCONTROL,dateofthirdmanualweedcontrol);
}

public String getDateofthirdmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(DATEOFTHIRDMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }




public void setCostofhiredlaborsecondmanualweedcontrol(String costofhiredlaborsecondmanualweedcontrol) {
underlyingNode.setProperty(COSTOFHIREDLABORSECONDMANUALWEEDCONTROL,costofhiredlaborsecondmanualweedcontrol);
}

public String getCostofhiredlaborsecondmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(COSTOFHIREDLABORSECONDMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }



public void setNumberhiredlaborsecondmanualweedcontrol(String numberhiredlaborsecondmanualweedcontrol) {
underlyingNode.setProperty(NUMBERHIREDLABORSECONDMANUALWEEDCONTROL,numberhiredlaborsecondmanualweedcontrol);
}

public String getNumberhiredlaborsecondmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(NUMBERHIREDLABORSECONDMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }


public void setNumberfamilylaborsecondmanualweedcontrol(String numberfamilylaborsecondmanualweedcontrol) {
underlyingNode.setProperty(NUMBERFAMILYLABORSECONDMANUALWEEDCONTROL,numberfamilylaborsecondmanualweedcontrol);
}

public String getNumberfamilylaborsecondmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(NUMBERFAMILYLABORSECONDMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }



public void setTimecompletionsecondmanualweencontrol(String timecompletionsecondmanualweencontrol) {
underlyingNode.setProperty(TIMECOMPLETIONSECONDMANUALWEENCONTROL,timecompletionsecondmanualweencontrol);
}

public String getTimecompletionsecondmanualweencontrol(){
          try {
          return (String) underlyingNode.getProperty(TIMECOMPLETIONSECONDMANUALWEENCONTROL);

        } catch (Exception e) {
        }
        return null;
    }



public void setNumberoflaborsecondweedcontrol(String numberoflaborsecondweedcontrol) {
underlyingNode.setProperty(NUMBEROFLABORSECONDWEEDCONTROL,numberoflaborsecondweedcontrol);
}

public String getNumberoflaborsecondweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(NUMBEROFLABORSECONDWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

public void setCosthiredlaborfirstmanualweedcontrol(String costhiredlaborfirstmanualweedcontrol) {
underlyingNode.setProperty(COSTHIREDLABORFIRSTMANUALWEEDCONTROL,costhiredlaborfirstmanualweedcontrol);
}

public String getCosthiredlaborfirstmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(COSTHIREDLABORFIRSTMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }



public void setNumberhiredlaborfirstmanualweedcontrol(String numberhiredlaborfirstmanualweedcontrol) {
underlyingNode.setProperty(NUMBERHIREDLABORFIRSTMANUALWEEDCONTROL,numberhiredlaborfirstmanualweedcontrol);
}

public String getNumberhiredlaborfirstmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(NUMBERHIREDLABORFIRSTMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }


public void setNumberfamilylaborfirstmanualweedcontrol(String numberfamilylaborfirstmanualweedcontrol) {
underlyingNode.setProperty(NUMBERFAMILYLABORFIRSTMANUALWEEDCONTROL,numberfamilylaborfirstmanualweedcontrol);
}

public String getNumberfamilylaborfirstmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(NUMBERFAMILYLABORFIRSTMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }



public void setTimecompletionfirstmanualweedcontrol(String timecompletionfirstmanualweedcontrol) {
underlyingNode.setProperty(TIMECOMPLETIONFIRSTMANUALWEEDCONTROL,timecompletionfirstmanualweedcontrol);
}

public String getTimecompletionfirstmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(TIMECOMPLETIONFIRSTMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }


public void setNumberoflaborfirstoccasionweedcontrol(String numberoflaborfirstoccasionweedcontrol) {
underlyingNode.setProperty(NUMBEROFLABORFIRSTOCCASIONWEEDCONTROL,numberoflaborfirstoccasionweedcontrol);
}

public String getNumberoflaborfirstoccasionweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(NUMBEROFLABORFIRSTOCCASIONWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }


public void setDatefirstoccasionmanualweedcontrol(String datefirstoccasionmanualweedcontrol) {
underlyingNode.setProperty(DATEFIRSTOCCASIONMANUALWEEDCONTROL,datefirstoccasionmanualweedcontrol);
}

public String getDatefirstoccasionmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(DATEFIRSTOCCASIONMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }



public void setNumberoccasionmanualweedcontrol(String numberoccasionmanualweedcontrol) {
underlyingNode.setProperty(NUMBEROCCASIONMANUALWEEDCONTROL,numberoccasionmanualweedcontrol);
}

public String getNumberoccasionmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(NUMBEROCCASIONMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }


public void setCostofhiredlabortopdresserfertilizer(String costofhiredlabortopdresserfertilizer) {
underlyingNode.setProperty(COSTOFHIREDLABORTOPDRESSERFERTILIZER,costofhiredlabortopdresserfertilizer);
}

public String getCostofhiredlabortopdresserfertilizer(){
          try {
          return (String) underlyingNode.getProperty(COSTOFHIREDLABORTOPDRESSERFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }


public void setNumberofhiredlabortopdress(String numberofhiredlabortopdress) {
underlyingNode.setProperty(NUMBEROFHIREDLABORTOPDRESS,numberofhiredlabortopdress);
}

public String getNumberofhiredlabortopdress(){
          try {
          return (String) underlyingNode.getProperty(NUMBEROFHIREDLABORTOPDRESS);

        } catch (Exception e) {
        }
        return null;
    }


public void setNumberoffamilylabourtopdresser(String numberoffamilylabourtopdresser) {
underlyingNode.setProperty(NUMBEROFFAMILYLABOURTOPDRESSER,numberoffamilylabourtopdresser);
}

public String getNumberoffamilylabourtopdresser(){
          try {
          return (String) underlyingNode.getProperty(NUMBEROFFAMILYLABOURTOPDRESSER);

        } catch (Exception e) {
        }
        return null;
    }


public void setTimeforcompletiontopdresserfertilizer(String timeforcompletiontopdresserfertilizer) {
underlyingNode.setProperty(TIMEFORCOMPLETIONTOPDRESSERFERTILIZER,timeforcompletiontopdresserfertilizer);
}

public String getTimeforcompletiontopdresserfertilizer(){
          try {
          return (String) underlyingNode.getProperty(TIMEFORCOMPLETIONTOPDRESSERFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }



public void setNumberoflabortopdressingfertilizer(String numberoflabortopdressingfertilizer) {
underlyingNode.setProperty(NUMBEROFLABORTOPDRESSINGFERTILIZER,numberoflabortopdressingfertilizer);
}

public String getNumberoflabortopdressingfertilizer(){
          try {
          return (String) underlyingNode.getProperty(NUMBEROFLABORTOPDRESSINGFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }



public void setTimeapplicationtopdressing(String timeapplicationtopdressing) {
underlyingNode.setProperty(TIMEAPPLICATIONTOPDRESSING,timeapplicationtopdressing);
}

public String getTimeapplicationtopdressing(){
          try {
          return (String) underlyingNode.getProperty(TIMEAPPLICATIONTOPDRESSING);

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


public void setPriceoftopdresserfertilizer(String priceoftopdresserfertilizer) {
underlyingNode.setProperty(PRICEOFTOPDRESSERFERTILIZER,priceoftopdresserfertilizer);
}

public String getPriceoftopdresserfertilizer(){
          try {
          return (String) underlyingNode.getProperty(PRICEOFTOPDRESSERFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }





public void setPurchaseoftopdressfertilizerdate(String purchaseoftopdressfertilizerdate) {
underlyingNode.setProperty(PURCHASEOFTOPDRESSFERTILIZERDATE,purchaseoftopdressfertilizerdate);
}

public String getPurchaseoftopdressfertilizerdate(){
          try {
          return (String) underlyingNode.getProperty(PURCHASEOFTOPDRESSFERTILIZERDATE);

        } catch (Exception e) {
        }
        return null;
    }

public void setQuantityoftopdresserfertilizer(String quantityoftopdresserfertilizer) {
underlyingNode.setProperty(QUANTITYOFTOPDRESSERFERTILIZER,quantityoftopdresserfertilizer);
}

public String getQuantityoftopdresserfertilizer(){
          try {
          return (String) underlyingNode.getProperty(QUANTITYOFTOPDRESSERFERTILIZER);

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


public void setTotalcostofhiredlaborbasalfertilizer(String totalcostofhiredlaborbasalfertilizer) {
underlyingNode.setProperty(TOTALCOSTOFHIREDLABORBASALFERTILIZER,totalcostofhiredlaborbasalfertilizer);
}

public String getTotalcostofhiredlaborbasalfertilizer(){
          try {
          return (String) underlyingNode.getProperty(TOTALCOSTOFHIREDLABORBASALFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }


public void setNumberofhiredlaborbasalfertilizer(String numberofhiredlaborbasalfertilizer) {
underlyingNode.setProperty(NUMBEROFHIREDLABORBASALFERTILIZER,numberofhiredlaborbasalfertilizer);
}

public String getNumberofhiredlaborbasalfertilizer(){
          try {
          return (String) underlyingNode.getProperty(NUMBEROFHIREDLABORBASALFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }



public void setNumberoffamilylaborbasalfertilizer(String numberoffamilylaborbasalfertilizer) {
underlyingNode.setProperty(NUMBEROFFAMILYLABORBASALFERTILIZER,numberoffamilylaborbasalfertilizer);
}

public String getNumberoffamilylaborbasalfertilizer(){
          try {
          return (String) underlyingNode.getProperty(NUMBEROFFAMILYLABORBASALFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }



public void setTimeforcompletionbasalapplication(String timeforcompletionbasalapplication) {
underlyingNode.setProperty(TIMEFORCOMPLETIONBASALAPPLICATION,timeforcompletionbasalapplication);
}

public String getTimeforcompletionbasalapplication(){
          try {
          return (String) underlyingNode.getProperty(TIMEFORCOMPLETIONBASALAPPLICATION);

        } catch (Exception e) {
        }
        return null;
    }



public void setTotalnumberoflaborbasalfertilizer(String totalnumberoflaborbasalfertilizer) {
underlyingNode.setProperty(TOTALNUMBEROFLABORBASALFERTILIZER,totalnumberoflaborbasalfertilizer);
}

public String getTotalnumberoflaborbasalfertilizer(){
          try {
          return (String) underlyingNode.getProperty(TOTALNUMBEROFLABORBASALFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }





public void setTimeapplicationofbasalfertilizer(String timeapplicationofbasalfertilizer) {
underlyingNode.setProperty(TIMEAPPLICATIONOFBASALFERTILIZER,timeapplicationofbasalfertilizer);
}

public String getTimeapplicationofbasalfertilizer(){
          try {
          return (String) underlyingNode.getProperty(TIMEAPPLICATIONOFBASALFERTILIZER);

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


public void setCostperunitoffertilizerapplied(String costperunitoffertilizerapplied) {
underlyingNode.setProperty(COSTPERUNITOFFERTILIZERAPPLIED,costperunitoffertilizerapplied);
}

public String getCostperunitoffertilizerapplied(){
          try {
          return (String) underlyingNode.getProperty(COSTPERUNITOFFERTILIZERAPPLIED);

        } catch (Exception e) {
        }
        return null;
    }



public void setQuantityofbasalfertilizerpurchased(String quantityofbasalfertilizerpurchased) {
underlyingNode.setProperty(QUANTITYOFBASALFERTILIZERPURCHASED,quantityofbasalfertilizerpurchased);
}

public String getQuantityofbasalfertilizerpurchased(){
          try {
          return (String) underlyingNode.getProperty(QUANTITYOFBASALFERTILIZERPURCHASED);

        } catch (Exception e) {
        }
        return null;
    }



public void setPurchaseofbasalfertilizerdate(String purchaseofbasalfertilizerdate) {
underlyingNode.setProperty(PURCHASEOFBASALFERTILIZERDATE,purchaseofbasalfertilizerdate);
}

public String getPurchaseofbasalfertilizerdate(){
          try {
          return (String) underlyingNode.getProperty(PURCHASEOFBASALFERTILIZERDATE);

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








public void setCostofapplicationofherbicidepostplant(String costofapplicationofherbicidepostplant) {
underlyingNode.setProperty(COSTOFAPPLICATIONOFHERBICIDEPOSTPLANT,costofapplicationofherbicidepostplant);
}

public String getCostofapplicationofherbicidepostplant(){
          try {
          return (String) underlyingNode.getProperty(COSTOFAPPLICATIONOFHERBICIDEPOSTPLANT);

        } catch (Exception e) {
        }
        return null;
    }


public void setSeedbedformtypepostplant(String seedbedformtypepostplant) {
underlyingNode.setProperty(SEEDBEDFORMTYPEPOSTPLANT,seedbedformtypepostplant);
}

public String getSeedbedformtypepostplant(){
          try {
          return (String) underlyingNode.getProperty(SEEDBEDFORMTYPEPOSTPLANT);

        } catch (Exception e) {
        }
        return null;
    }






public void setPriceofherbicidepostplant(String priceofherbicidepostplant) {
underlyingNode.setProperty(PRICEOFHERBICIDEPOSTPLANT,priceofherbicidepostplant);
}

public String getPriceofherbicidepostplant(){
          try {
          return (String) underlyingNode.getProperty(PRICEOFHERBICIDEPOSTPLANT);

        } catch (Exception e) {
        }
        return null;
    }


public void setQuantityofpostplantherbicide(String quantityofpostplantherbicide) {
underlyingNode.setProperty(QUANTITYOFPOSTPLANTHERBICIDE,quantityofpostplantherbicide);
}

public String getQuantityofpostplantherbicide(){
          try {
          return (String) underlyingNode.getProperty(QUANTITYOFPOSTPLANTHERBICIDE);

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



public void setPurchaseofherbicidepostharvest(String purchaseofherbicidepostharvest) {
underlyingNode.setProperty(PURCHASEOFHERBICIDEPOSTPLANT,purchaseofherbicidepostharvest);
}

public String getPurchaseofherbicidepostharvest(){
          try {
          return (String) underlyingNode.getProperty(PURCHASEOFHERBICIDEPOSTPLANT);

        } catch (Exception e) {
        }
        return null;
    }


public void setRefillinggapscompensation(String refillinggapscompensation) {
underlyingNode.setProperty(REFILLINGGAPSCOMPENSATION,refillinggapscompensation);
}

public String getRefillinggapscompensation(){
          try {
          return (String) underlyingNode.getProperty(REFILLINGGAPSCOMPENSATION);

        } catch (Exception e) {
        }
        return null;
    }

public void setRefillinggapshiredlabor(String refillinggapshiredlabor) {
underlyingNode.setProperty(REFILLINGGAPSHIREDLABOR,refillinggapshiredlabor);
}

public String getRefillinggapshiredlabor(){
          try {
          return (String) underlyingNode.getProperty(REFILLINGGAPSHIREDLABOR);

        } catch (Exception e) {
        }
        return null;
    }

public void setRefillinggapstime(String refillinggapstime) {
underlyingNode.setProperty(REFILLINGGAPSTIME,refillinggapstime);
}

public String getRefillinggapstime(){
          try {
          return (String) underlyingNode.getProperty(REFILLINGGAPSTIME);

        } catch (Exception e) {
        }
        return null;
    }


public void setRefillinggapsnumberoflaborhands(String refillinggapsnumberoflaborhands) {
underlyingNode.setProperty(REFILLINGGAPSNUMBEROFLABORHANDS,refillinggapsnumberoflaborhands);
}

public String getRefillinggapsnumberoflaborhands(){
          try {
          return (String) underlyingNode.getProperty(REFILLINGGAPSNUMBEROFLABORHANDS);

        } catch (Exception e) {
        }
        return null;
    }



public void setPlantingcompensation(String plantingcompensation) {
underlyingNode.setProperty(PLANTINGCOMPENSATION,plantingcompensation);
}

public String getPlantingcompensation(){
          try {
          return (String) underlyingNode.getProperty(PLANTINGCOMPENSATION);

        } catch (Exception e) {
        }
        return null;
    }



public void setPlantinghiredlabor(String plantinghiredlabor) {
underlyingNode.setProperty(PLANTINGHIREDLABOR,plantinghiredlabor);
}

public String getPlantinghiredlabor(){
          try {
          return (String) underlyingNode.getProperty(PLANTINGHIREDLABOR);

        } catch (Exception e) {
        }
        return null;
    }

public void setPlantingtime(String plantingtime) {
underlyingNode.setProperty(PLANTINGTIME,plantingtime);
}

public String getPlantingtime(){
          try {
          return (String) underlyingNode.getProperty(PLANTINGTIME);

        } catch (Exception e) {
        }
        return null;
    }



public void setPlantingnumberoflaborhands(String plantingnumberoflaborhands) {
underlyingNode.setProperty(PLANTINGNUMBEROFLABORHANDS,plantingnumberoflaborhands);
}

public String getPlantingnumberoflaborhands(){
          try {
          return (String) underlyingNode.getProperty(PLANTINGNUMBEROFLABORHANDS);

        } catch (Exception e) {
        }
        return null;
    }



public void setPlantingdistancebetweenplants(String plantingdistancebetweenplants) {
underlyingNode.setProperty(PLANTINGDISTANCEBETWEENPLANTS,plantingdistancebetweenplants);
}

public String getPlantingdistancebetweenplants(){
          try {
          return (String) underlyingNode.getProperty(PLANTINGDISTANCEBETWEENPLANTS);

        } catch (Exception e) {
        }
        return null;
    }



public void setPlantingdistancebetweenrows(String plantingdistancebetweenrows) {
underlyingNode.setProperty(PLANTINGDISTANCEBETWEENROWS,plantingdistancebetweenrows);
}

public String getPlantingdistancebetweenrows(){
          try {
          return (String) underlyingNode.getProperty(PLANTINGDISTANCEBETWEENROWS);

        } catch (Exception e) {
        }
        return null;
    }



public void setLengthofcuttingsused(String lengthofcuttingsused) {
underlyingNode.setProperty(LENGTHOFCUTTINGSUSED,lengthofcuttingsused);
}

public String getLengthofcuttingsused(){
          try {
          return (String) underlyingNode.getProperty(LENGTHOFCUTTINGSUSED);

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





public void setSeedbedpreparationcompensation(String seedbedpreparationcompensation) {
underlyingNode.setProperty(SEEDBEDPREPARATIONCOMPENSATION,seedbedpreparationcompensation);
}

public String getSeedbedpreparationcompensation(){
          try {
          return (String) underlyingNode.getProperty(SEEDBEDPREPARATIONCOMPENSATION);

        } catch (Exception e) {
        }
        return null;
    }





public void setSeedbedpreparationfamilylabor(String seedbedpreparationfamilylabor) {
underlyingNode.setProperty(SEEDBEDPREPARATIONFAMILYLABOR,seedbedpreparationfamilylabor);
}

public String getSeedbedpreparationfamilylabor(){
          try {
          return (String) underlyingNode.getProperty(SEEDBEDPREPARATIONFAMILYLABOR);

        } catch (Exception e) {
        }
        return null;
    }


public void setSeedbedpreparationhiredlabor(String seedbedpreparationhiredlabor) {
underlyingNode.setProperty(SEEDBEDPREPARATIONHIREDLABOR,seedbedpreparationhiredlabor);
}

public String getSeedbedpreparationhiredlabor(){
          try {
          return (String) underlyingNode.getProperty(SEEDBEDPREPARATIONHIREDLABOR);

        } catch (Exception e) {
        }
        return null;
    }



public void setSeedbedpreparationtime(String seedbedpreparationtime) {
underlyingNode.setProperty(SEEDBEDPREPARATIONTIME,seedbedpreparationtime);
}

public String getSeedbedpreparationtime(){
          try {
          return (String) underlyingNode.getProperty(SEEDBEDPREPARATIONTIME);

        } catch (Exception e) {
        }
        return null;
    }


public void setSeedbedpreperationnumberoflaborhands(String seedbedpreperationnumberoflaborhands) {
underlyingNode.setProperty(SEEDBEDPREPERATIONNUMBEROFLABORHANDS,seedbedpreperationnumberoflaborhands);
}

public String getSeedbedpreperationnumberoflaborhands(){
          try {
          return (String) underlyingNode.getProperty(SEEDBEDPREPERATIONNUMBEROFLABORHANDS);

        } catch (Exception e) {
        }
        return null;
    }




public void setSeedbedpreparationdate(String seedbedpreparationdate) {
underlyingNode.setProperty(SEEDBEDPREPARATIONDATE,seedbedpreparationdate);
}

public String getSeedbedpreparationdate(){
          try {
          return (String) underlyingNode.getProperty(SEEDBEDPREPARATIONDATE);

        } catch (Exception e) {
        }
        return null;
    }



public void setSeedbedformtype(String seedbedformtype) {
underlyingNode.setProperty(SEEDBEDFORMTYPE,seedbedformtype);
}

public String getSeedbedformtype(){
          try {
          return (String) underlyingNode.getProperty(SEEDBEDFORMTYPE);

        } catch (Exception e) {
        }
        return null;
    }




public void setHoeploughingcompensation(String hoeploughingcompensation) {
underlyingNode.setProperty(HOEPLOUGHINGCOMPENSATION,hoeploughingcompensation);
}

public String getHoeploughingcompensation(){
          try {
          return (String) underlyingNode.getProperty(HOEPLOUGHINGCOMPENSATION);

        } catch (Exception e) {
        }
        return null;
    }



public void setHoeploughingnumberoffamilylabor(String hoeploughingnumberoffamilylabor) {
underlyingNode.setProperty(HOEPLOUGHINGNUMBEROFFAMILYLABOR,hoeploughingnumberoffamilylabor);
}

public String getHoeploughingnumberoffamilylabor(){
          try {
          return (String) underlyingNode.getProperty(HOEPLOUGHINGNUMBEROFFAMILYLABOR);

        } catch (Exception e) {
        }
        return null;
    }




public void setHoeploughingnumberofhiredlabor(String hoeploughingnumberofhiredlabor) {
underlyingNode.setProperty(HOEPLOUGHINGNUMBEROFHIREDLABOR,hoeploughingnumberofhiredlabor);
}

public String getHoeploughingnumberofhiredlabor(){
          try {
          return (String) underlyingNode.getProperty(HOEPLOUGHINGNUMBEROFHIREDLABOR);

        } catch (Exception e) {
        }
        return null;
    }



public void setHoeploughingnumberoflaborhands(String hoeploughingnumberoflaborhands) {
underlyingNode.setProperty(HOEPLOUGHINGNUMBEROFLABORHANDS,hoeploughingnumberoflaborhands);
}

public String getHoeploughingnumberoflaborhands(){
          try {
          return (String) underlyingNode.getProperty(HOEPLOUGHINGNUMBEROFLABORHANDS);

        } catch (Exception e) {
        }
        return null;
    }



public void setHoeploughingdate(String hoeploughingdate) {
underlyingNode.setProperty(HOEPLOUGHINGDATE,hoeploughingdate);
}

public String getHoeploughingdate(){
          try {
          return (String) underlyingNode.getProperty(HOEPLOUGHINGDATE);

        } catch (Exception e) {
        }
        return null;
    }




public void setHarrowingcostperacre(String harrowingcostperacre) {
underlyingNode.setProperty(HARROWINGCOSTPERACRE,harrowingcostperacre);
}

public String getHarrowingcostperacre(){
          try {
          return (String) underlyingNode.getProperty(HARROWINGCOSTPERACRE);

        } catch (Exception e) {
        }
        return null;
    }


public void setHarrowingdate(String harrowingdate) {
underlyingNode.setProperty(HARROWINGDATE,harrowingdate);
}

public String getHarrowingdate(){
          try {
          return (String) underlyingNode.getProperty(HARROWINGDATE);

        } catch (Exception e) {
        }
        return null;
    }



public void setPloughingcostperacre(String ploughingcostperacre) {
underlyingNode.setProperty(PLOUGHINGCOSTPERACRE,ploughingcostperacre);
}

public String getPloughingcostperacre(){
          try {
          return (String) underlyingNode.getProperty(PLOUGHINGCOSTPERACRE);

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



public void setCostofapplicationofherbicide(String costofapplicationofherbicide) {
underlyingNode.setProperty(COSTOFAPPLICATIONOFHERBICIDE,costofapplicationofherbicide);
}

public String getCostofapplicationofherbicide(){
          try {
          return (String) underlyingNode.getProperty(COSTOFAPPLICATIONOFHERBICIDE);

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


public void setPurchaseofherbicide(String purchaseofherbicide) {
underlyingNode.setProperty(PURCHASEOFHERBICIDEDATE,purchaseofherbicide);
}

public String getPurchaseofherbicide(){
          try {
          return (String) underlyingNode.getProperty(PURCHASEOFHERBICIDEDATE);

        } catch (Exception e) {
        }
        return null;
    }


public void setQuantityOfherbicide(String quantityofherbicide) {
underlyingNode.setProperty(QUANTITYOFHERBICIDE,quantityofherbicide);
}

public String getQuantityOfherbicide(){
          try {
          return (String) underlyingNode.getProperty(QUANTITYOFHERBICIDE);

        } catch (Exception e) {
        }
        return null;
    }



public void setTypeofherbicideforpreplanting(String typeofherbicideforpreplanting) {
underlyingNode.setProperty(TYPEOFHERBICIDEFORPREPLANTING,typeofherbicideforpreplanting);
}

public String getTypeofherbicideforpreplanting(){
          try {
          return (String) underlyingNode.getProperty(TYPEOFHERBICIDEFORPREPLANTING);

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



public void setCostperunitofplantingmaterial(String costperunitofplantingmaterial) {
underlyingNode.setProperty(COSTPERUNITOFPLANTINGMATERIAL,costperunitofplantingmaterial);
}

public String getCostperunitofplantingmaterial(){
          try {
          return (String) underlyingNode.getProperty(COSTPERUNITOFPLANTINGMATERIAL);

        } catch (Exception e) {
        }
        return null;
    }


public void setQuantityofplantingmaterialperacre(String quantityofplantingmaterialperacre) {
underlyingNode.setProperty(QUANTITYOFPLANTINGMATERIALPERACRE,quantityofplantingmaterialperacre);
}

public String getQuantityofplantingmaterialperacre(){
          try {
          return (String) underlyingNode.getProperty(QUANTITYOFPLANTINGMATERIALPERACRE);

        } catch (Exception e) {
        }
        return null;
    }


public void setWeightofplantingmaterialperacre(String weightofplantingmaterialperacre) {
underlyingNode.setProperty(WEIGHTOFPLANTINGMATERIALPERACRE,weightofplantingmaterialperacre);
}

public String getWeightofplantingmaterialperacre(){
          try {
          return (String) underlyingNode.getProperty(WEIGHTOFPLANTINGMATERIALPERACRE);

        } catch (Exception e) {
        }
        return null;
    }


public void setQuantityofplantingmaterial(String quantityofplantingmaterial) {
underlyingNode.setProperty(QUANTITYOFPLANTINGMATERIAL,quantityofplantingmaterial);
}

public String getQuantityofplantingmaterial(){
          try {
          return (String) underlyingNode.getProperty(QUANTITYOFPLANTINGMATERIAL);

        } catch (Exception e) {
        }
        return null;
    }




public void setPurchaseofstakesdate(String purchaseofstakesdate) {
underlyingNode.setProperty(PURCHASEOFSTAKESDATE,purchaseofstakesdate);
}

public String getPurchaseofstakesdate(){
          try {
          return (String) underlyingNode.getProperty(PURCHASEOFSTAKESDATE);

        } catch (Exception e) {
        }
        return null;
    }

public void setNameofvariety(String nameofvariety) {
underlyingNode.setProperty(NAMEOFVARIETY,nameofvariety);
}

public String getNameofvariety(){
          try {
          return (String) underlyingNode.getProperty(NAMEOFVARIETY);

        } catch (Exception e) {
        }
        return null;
    }


public void setTargetproduction(String targetproduction) {
underlyingNode.setProperty(TARGETPRODUCTION,targetproduction);
}

public String getTargetproduction(){
          try {
          return (String) underlyingNode.getProperty(TARGETPRODUCTION);

        } catch (Exception e) {
        }
        return null;
    }

public void setExpectedpriceperton(String expectedpriceperton) {
underlyingNode.setProperty(EXPECTEDPRICEPERTON,expectedpriceperton);
}

public String getExpectedpriceperton(){
          try {
          return (String) underlyingNode.getProperty(EXPECTEDPRICEPERTON);

        } catch (Exception e) {
        }
        return null;
    }




public void setTargetyieldperacre(String targetyieldperacre) {
underlyingNode.setProperty(TARGETYIELDPERACRE,targetyieldperacre);
}

public String getTargetyieldperacre(){
          try {
          return (String) underlyingNode.getProperty(TARGETYIELDPERACRE);

        } catch (Exception e) {
        }
        return null;
    }



public void setCostofrentingland(String costofrentingland) {
underlyingNode.setProperty(COSTOFRENTINGLAND,costofrentingland);
}

public String getCostofrentingland(){
          try {
          return (String) underlyingNode.getProperty(COSTOFRENTINGLAND);

        } catch (Exception e) {
        }
        return null;
    }


public void setTargetareaofland(String targetareaofland) {
underlyingNode.setProperty(TARGETAREAOFLAND,targetareaofland);
}

public String getTargetareaofland(){
          try {
          return (String) underlyingNode.getProperty(TARGETAREAOFLAND);

        } catch (Exception e) {
        }
        return null;
    }






public void setLocationofland(String locationofland) {
underlyingNode.setProperty(LOCATIONOFLAND,locationofland);
}

public String getLocationofland(){
          try {
          return (String) underlyingNode.getProperty(LOCATIONOFLAND);

        } catch (Exception e) {
        }
        return null;
    }




public void setDateoflandidentification(String dateoflandidentification) {
underlyingNode.setProperty(DATEOFLANDIDENTIFICATION,dateoflandidentification);
}

public String getDateoflandidentification(){
          try {
          return (String) underlyingNode.getProperty(DATEOFLANDIDENTIFICATION);

        } catch (Exception e) {
        }
        return null;
    }
    

}
