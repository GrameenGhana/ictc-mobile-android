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
 * @date Oct 13, 2015 12:57:45 PM
 * description:
 */
public class BaselinePostHarvest extends Status implements GeneralInterface {
    
    Node underlyingNode = null;
   

    public BaselinePostHarvest(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
        
    }
    public static String APPLICATIONRATEOFSTORAGECHEMICAL = "applicationrateofstoragechemical";
    public static String COMPLETIONOFPRODUCEMARKETING = "completionofproducemarketing";
    public static String COMPLETIONOFTHRESHING="completionofthreshing";
    public static String DATEOFCOMPLETINGDRYING="dateofcompletingdrying";
    public static String DATETOCOMPLETEDRYING="datetocompletedrying";
    public static String DEHUSKINGDATE="dehuskingdate";
    public static String FIRSTSALEDATE="firstsaledate";
    public static String MAINPOINTOFSALEORCONTACT="mainpointofsaleorcontact";
    public static String MANUALTHRESHING="manualthreshing";
    public static String MANUALWINNOWING="manualwinnowing";
    public static String MARKETINGOCCASIONS="marketingoccasions";
    public static String METHODOFDRYINGCOBSPANICLESCHIPSCHU="methodofdryingcobspanicleschipschu";
    public static String METHODOFDRYINGGRAIN="methodofdryinggrain";
    public static String METHODOFPROCESSINGDEHUSKING="methodofprocessingdehusking";
    public static String METHODOFTHRESHING="methodofthreshing";
    public static String METHODOFWINNOWING="methodofwinnowing";
    public static String MOSTPRODUCESALEDATE="mostproducesaledate";
    public static String OTHERAPPLICATIONRATEOFSTORAGECHEMICA="otherapplicationrateofstoragechemica";
    public static String OTHERMETHODFORDRYING="othermethodfordrying";
    public static String OTHERMETHODOFDRYINGGRAIN="othermethodofdryinggrain";
    public static String OTHERMETHODSOFDEHUSKING="othermethodsofdehusking";
    public static String OTHERSALECONTACT="othersalecontact";
    public static String OTHERSTORAGECHEMICAL="otherstoragechemical";
    public static String OWNERSHIPORCONDITIONSFORSTORAGE="ownershiporconditionsforstorage";
    public static String POSTHARVESTLOSSES="postharvestlosses";
    public static String PRICEATFIRSTSALEDATE="priceatfirstsaledate";
    public static String PRICEATMOSTSALEDATE="priceatmostsaledate";
    public static String PROCESSINGOFCASSAVA="processingofcassava";
    public static String PROPORTIONOFCASSAVA="proportionofcassava";
    public static String PROPORTIONOFPRODUCESOLD="proportionofproducesold";
    public static String TYPEOFBAGCONTAINERUSED="typeofbagcontainerused";
    public static String TYPEOFMACHINE="typeofmachine";
    public static String TYPEOFMACHINEWINONOWING="typeofmachinewinonowing";
    public static String TYPEOFSTORAGECHEMICAL="typeofstoragechemical";
    public static String TYPEOFSTORAGESTRUCTURE="typeofstoragestructure";
    public static String WHATCROPAREYOUPLANNINGTOCULTIVATE="Whatcropareyouplanningtocultivate";
    public static String DATE_WINNOWING_COMPLETED="date_winnowing_completed";
    public static String PRODUCESTOREDPROPORTION="producestoredproportion";
    public static String REFERENCE_SEASON="reference_season";
    public static String REFERENCE_YEAR="reference_year";
    public static String BAGSPOSTPROCESSING="bagspostprocessing";
    public static String BUYERNUMBER="buyernumber";
    public static String DRYINGCOBS="dryingcobs";
    public static String HARVESTMETHOD="harvestmethod";
    public static String PROCESSINGCOMBINATION="processingcombination";
    public static String PROCESSINGCOMPLETED="processingcompleted";
    public static String SHELLINGMETHOD="shellingmethod";
    public static String SHELLINGMETHODOTHER="shellingmethodother";
    
    
    
public void setShellingmethodother(String shellingmethodother) {
underlyingNode.setProperty(SHELLINGMETHODOTHER,shellingmethodother);
}

public String getShellingmethodother(){
          try {
          return (String) underlyingNode.getProperty(SHELLINGMETHODOTHER);

        } catch (Exception e) {
        }
        return null;
    }
public void setShellingmethod(String shellingmethod) {
underlyingNode.setProperty(SHELLINGMETHOD,shellingmethod);
}

public String getShellingmethod(){
          try {
          return (String) underlyingNode.getProperty(SHELLINGMETHOD);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setProcessingcompleted(String processingcompleted) {
underlyingNode.setProperty(PROCESSINGCOMPLETED,processingcompleted);
}

public String getProcessingcompleted(){
          try {
          return (String) underlyingNode.getProperty(PROCESSINGCOMPLETED);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setProcessingcombination(String processingcombination) {
underlyingNode.setProperty(PROCESSINGCOMBINATION,processingcombination);
}

public String getProcessingcombination(){
          try {
          return (String) underlyingNode.getProperty(PROCESSINGCOMBINATION);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setHarvestmethod(String harvestmethod) {
underlyingNode.setProperty(HARVESTMETHOD,harvestmethod);
}

public String getHarvestmethod(){
          try {
          return (String) underlyingNode.getProperty(HARVESTMETHOD);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setDryingcobs(String dryingcobs) {
underlyingNode.setProperty(DRYINGCOBS,dryingcobs);
}

public String getDryingcobs(){
          try {
          return (String) underlyingNode.getProperty(DRYINGCOBS);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setBuyernumber(String buyernumber) {
underlyingNode.setProperty(BUYERNUMBER,buyernumber);
}

public String getBuyernumber(){
          try {
          return (String) underlyingNode.getProperty(BUYERNUMBER);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setBagspostprocessing(String bagspostprocessing) {
underlyingNode.setProperty(BAGSPOSTPROCESSING,bagspostprocessing);
}

public String getBagspostprocessing(){
          try {
          return (String) underlyingNode.getProperty(BAGSPOSTPROCESSING);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setReference_year(String reference_year) {
underlyingNode.setProperty(REFERENCE_YEAR,reference_year);
}

public String getReference_year(){
          try {
          return (String) underlyingNode.getProperty(REFERENCE_YEAR);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setReference_season(String reference_season) {
underlyingNode.setProperty(REFERENCE_SEASON,reference_season);
}

public String getReference_season(){
          try {
          return (String) underlyingNode.getProperty(REFERENCE_SEASON);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setProducestoredproportion(String producestoredproportion) {
underlyingNode.setProperty(PRODUCESTOREDPROPORTION,producestoredproportion);
}

public String getProducestoredproportion(){
          try {
          return (String) underlyingNode.getProperty(PRODUCESTOREDPROPORTION);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setDate_winnowing_completed(String date_winnowing_completed) {
underlyingNode.setProperty(DATE_WINNOWING_COMPLETED,date_winnowing_completed);
}

public String getDate_winnowing_completed(){
          try {
          return (String) underlyingNode.getProperty(DATE_WINNOWING_COMPLETED);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setWhatcropareyouplanningtocultivate(String whatcropareyouplanningtocultivate) {
underlyingNode.setProperty(WHATCROPAREYOUPLANNINGTOCULTIVATE,whatcropareyouplanningtocultivate);
}

public String getWhatcropareyouplanningtocultivate(){
          try {
          return (String) underlyingNode.getProperty(WHATCROPAREYOUPLANNINGTOCULTIVATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setTypeofstoragestructure(String typeofstoragestructure) {
underlyingNode.setProperty(TYPEOFSTORAGESTRUCTURE,typeofstoragestructure);
}

public String getTypeofstoragestructure(){
          try {
          return (String) underlyingNode.getProperty(TYPEOFSTORAGESTRUCTURE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setTypeofstoragechemical(String typeofstoragechemical) {
underlyingNode.setProperty(TYPEOFSTORAGECHEMICAL,typeofstoragechemical);
}

public String getTypeofstoragechemical(){
          try {
          return (String) underlyingNode.getProperty(TYPEOFSTORAGECHEMICAL);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setTypeofmachinewinonowing(String typeofmachinewinonowing) {
underlyingNode.setProperty(TYPEOFMACHINEWINONOWING,typeofmachinewinonowing);
}

public String getTypeofmachinewinonowing(){
          try {
          return (String) underlyingNode.getProperty(TYPEOFMACHINEWINONOWING);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setTypeofmachine(String typeofmachine) {
underlyingNode.setProperty(TYPEOFMACHINE,typeofmachine);
}

public String getTypeofmachine(){
          try {
          return (String) underlyingNode.getProperty(TYPEOFMACHINE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
    
public void setTypeofbagcontainerused(String typeofbagcontainerused) {
underlyingNode.setProperty(TYPEOFBAGCONTAINERUSED,typeofbagcontainerused);
}

public String getTypeofbagcontainerused(){
          try {
          return (String) underlyingNode.getProperty(TYPEOFBAGCONTAINERUSED);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setProportionofproducesold(String proportionofproducesold) {
underlyingNode.setProperty(PROPORTIONOFPRODUCESOLD,proportionofproducesold);
}

public String getProportionofproducesold(){
          try {
          return (String) underlyingNode.getProperty(PROPORTIONOFPRODUCESOLD);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setProportionofcassava(String proportionofcassava) {
underlyingNode.setProperty(PROPORTIONOFCASSAVA,proportionofcassava);
}

public String getProportionofcassava(){
          try {
          return (String) underlyingNode.getProperty(PROPORTIONOFCASSAVA);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setProcessingofcassava(String processingofcassava) {
underlyingNode.setProperty(PROCESSINGOFCASSAVA,processingofcassava);
}

public String getProcessingofcassava(){
          try {
          return (String) underlyingNode.getProperty(PROCESSINGOFCASSAVA);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setPriceatmostsaledate(String priceatmostsaledate) {
underlyingNode.setProperty(PRICEATMOSTSALEDATE,priceatmostsaledate);
}

public String getPriceatmostsaledate(){
          try {
          return (String) underlyingNode.getProperty(PRICEATMOSTSALEDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setPriceatfirstsaledate(String priceatfirstsaledate) {
underlyingNode.setProperty(PRICEATFIRSTSALEDATE,priceatfirstsaledate);
}

public String getPriceatfirstsaledate(){
          try {
          return (String) underlyingNode.getProperty(PRICEATFIRSTSALEDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setPostharvestlosses(String postharvestlosses) {
underlyingNode.setProperty(POSTHARVESTLOSSES,postharvestlosses);
}

public String getPostharvestlosses(){
          try {
          return (String) underlyingNode.getProperty(POSTHARVESTLOSSES);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setOwnershiporconditionsforstorage(String ownershiporconditionsforstorage) {
underlyingNode.setProperty(OWNERSHIPORCONDITIONSFORSTORAGE,ownershiporconditionsforstorage);
}

public String getOwnershiporconditionsforstorage(){
          try {
          return (String) underlyingNode.getProperty(OWNERSHIPORCONDITIONSFORSTORAGE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setOtherstoragechemical(String otherstoragechemical) {
underlyingNode.setProperty(OTHERSTORAGECHEMICAL,otherstoragechemical);
}

public String getOtherstoragechemical(){
          try {
          return (String) underlyingNode.getProperty(OTHERSTORAGECHEMICAL);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setOthersalecontact(String othersalecontact) {
underlyingNode.setProperty(OTHERSALECONTACT,othersalecontact);
}

public String getOthersalecontact(){
          try {
          return (String) underlyingNode.getProperty(OTHERSALECONTACT);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setOthermethodsofdehusking(String othermethodsofdehusking) {
underlyingNode.setProperty(OTHERMETHODSOFDEHUSKING,othermethodsofdehusking);
}

public String getOthermethodsofdehusking(){
          try {
          return (String) underlyingNode.getProperty(OTHERMETHODSOFDEHUSKING);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setOthermethodofdryinggrain(String othermethodofdryinggrain) {
underlyingNode.setProperty(OTHERMETHODOFDRYINGGRAIN,othermethodofdryinggrain);
}

public String getOthermethodofdryinggrain(){
          try {
          return (String) underlyingNode.getProperty(OTHERMETHODOFDRYINGGRAIN);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setOthermethodfordrying(String othermethodfordrying) {
underlyingNode.setProperty(OTHERMETHODFORDRYING,othermethodfordrying);
}

public String getOthermethodfordrying(){
          try {
          return (String) underlyingNode.getProperty(OTHERMETHODFORDRYING);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setOtherapplicationrateofstoragechemica(String otherapplicationrateofstoragechemica) {
underlyingNode.setProperty(OTHERAPPLICATIONRATEOFSTORAGECHEMICA,otherapplicationrateofstoragechemica);
}

public String getOtherapplicationrateofstoragechemica(){
          try {
          return (String) underlyingNode.getProperty(OTHERAPPLICATIONRATEOFSTORAGECHEMICA);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setMostproducesaledate(String mostproducesaledate) {
underlyingNode.setProperty(MOSTPRODUCESALEDATE,mostproducesaledate);
}

public String getMostproducesaledate(){
          try {
          return (String) underlyingNode.getProperty(MOSTPRODUCESALEDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setMethodofwinnowing(String methodofwinnowing) {
underlyingNode.setProperty(METHODOFWINNOWING,methodofwinnowing);
}

public String getMethodofwinnowing(){
          try {
          return (String) underlyingNode.getProperty(METHODOFWINNOWING);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setMethodofthreshing(String methodofthreshing) {
underlyingNode.setProperty(METHODOFTHRESHING,methodofthreshing);
}

public String getMethodofthreshing(){
          try {
          return (String) underlyingNode.getProperty(METHODOFTHRESHING);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setMethodofprocessingdehusking(String methodofprocessingdehusking) {
underlyingNode.setProperty(METHODOFPROCESSINGDEHUSKING,methodofprocessingdehusking);
}

public String getMethodofprocessingdehusking(){
          try {
          return (String) underlyingNode.getProperty(METHODOFPROCESSINGDEHUSKING);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setMethodofdryinggrain(String methodofdryinggrain) {
underlyingNode.setProperty(METHODOFDRYINGGRAIN,methodofdryinggrain);
}

public String getMethodofdryinggrain(){
          try {
          return (String) underlyingNode.getProperty(METHODOFDRYINGGRAIN);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setMethodofdryingcobspanicleschipschu(String methodofdryingcobspanicleschipschu) {
underlyingNode.setProperty(METHODOFDRYINGCOBSPANICLESCHIPSCHU,methodofdryingcobspanicleschipschu);
}

public String getMethodofdryingcobspanicleschipschu(){
          try {
          return (String) underlyingNode.getProperty(METHODOFDRYINGCOBSPANICLESCHIPSCHU);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setMarketingoccasions(String marketingoccasions) {
underlyingNode.setProperty(MARKETINGOCCASIONS,marketingoccasions);
}

public String getMarketingoccasions(){
          try {
          return (String) underlyingNode.getProperty(MARKETINGOCCASIONS);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setManualwinnowing(String manualwinnowing) {
underlyingNode.setProperty(MANUALWINNOWING,manualwinnowing);
}

public String getManualwinnowing(){
          try {
          return (String) underlyingNode.getProperty(MANUALWINNOWING);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setManualthreshing(String manualthreshing) {
underlyingNode.setProperty(MANUALTHRESHING,manualthreshing);
}

public String getManualthreshing(){
          try {
          return (String) underlyingNode.getProperty(MANUALTHRESHING);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setMainpointofsaleorcontact(String mainpointofsaleorcontact) {
underlyingNode.setProperty(MAINPOINTOFSALEORCONTACT,mainpointofsaleorcontact);
}

public String getMainpointofsaleorcontact(){
          try {
          return (String) underlyingNode.getProperty(MAINPOINTOFSALEORCONTACT);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setFirstsaledate(String firstsaledate) {
underlyingNode.setProperty(FIRSTSALEDATE,firstsaledate);
}

public String getFirstsaledate(){
          try {
          return (String) underlyingNode.getProperty(FIRSTSALEDATE);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setDehuskingdate(String dehuskingdate) {
underlyingNode.setProperty(DEHUSKINGDATE,dehuskingdate);
}

public String getDehuskingdate(){
          try {
          return (String) underlyingNode.getProperty(DEHUSKINGDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
    
public void setDatetocompletedrying(String datetocompletedrying) {
underlyingNode.setProperty(DATETOCOMPLETEDRYING,datetocompletedrying);
}

public String getDatetocompletedrying(){
          try {
          return (String) underlyingNode.getProperty(DATETOCOMPLETEDRYING);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setDateofcompletingdrying(String dateofcompletingdrying) {
underlyingNode.setProperty(DATEOFCOMPLETINGDRYING,dateofcompletingdrying);
}

public String getDateofcompletingdrying(){
          try {
          return (String) underlyingNode.getProperty(DATEOFCOMPLETINGDRYING);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setCompletionofthreshing(String completionofthreshing) {
underlyingNode.setProperty(COMPLETIONOFTHRESHING,completionofthreshing);
}

public String getCompletionofthreshing(){
          try {
          return (String) underlyingNode.getProperty(COMPLETIONOFTHRESHING);

        } catch (Exception e) {
        }
        return null;
    }
    public void setCompletionofproducemarketing(String completionofproducemarketing) {
        underlyingNode.setProperty(COMPLETIONOFPRODUCEMARKETING, completionofproducemarketing);
    }

    public String getCompletionofproducemarketing() {
        try {
            return (String) underlyingNode.getProperty(COMPLETIONOFPRODUCEMARKETING);

        } catch (Exception e) {
        }
        return null;
    }


     
public void setApplicationrateofstoragechemical(String applicationrateofstoragechemical) {
underlyingNode.setProperty(APPLICATIONRATEOFSTORAGECHEMICAL,applicationrateofstoragechemical);
}

public String getApplicationrateofstoragechemical(){
          try {
          return (String) underlyingNode.getProperty(APPLICATIONRATEOFSTORAGECHEMICAL);

        } catch (Exception e) {
        }
        return null;
    }


}
