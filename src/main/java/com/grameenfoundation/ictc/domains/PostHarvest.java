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
 * @date Jul 22, 2015 12:31:59 PM description:
 */
public class PostHarvest extends Status implements GeneralInterface {

    public static String PORTIONHARVESTPROCESSED = "portionharvestprocessed";
    public static String PEELINGDATE = "peelingdate";
    public static String METHODOFPROCESSING = "methodofprocessing";
    public static String NOLABOURDEHUSKINGPEELINGTOTAL = "nolabourdehuskingpeelingtotal";
    public static String TIMECOMPLETIONDEHUSKINGPEELING = "timecompletiondehuskingpeeling";
    public static String NOFAMLABOURDEHUSKINGPEELING = "nofamlabourdehuskingpeeling";
    public static String NOHIREDLABOURDEHUSKINGPEELING = "nohiredlabourdehuskingpeeling";
    public static String COSTOFHIREDLABOURDEHUSKINGPEELING = "costofhiredlabourdehuskingpeeling";
    public static String METHODOFDRYING = "methodofdrying";
    public static String NOLABOURDRYINGTOTAL = "nolabourdryingtotal";
    public static String TIMECOMPLETIONDRYING = "timecompletiondrying";
    public static String NOFAMLABOURDRYING = "nofamlabourdrying";
    public static String NOHIREDLABOURDRYING = "nohiredlabourdrying";
    public static String COSTOFHIREDLABOURDRYING = "costofhiredlabourdrying";
    public static String METHODOFTHRESHING = "methodofthreshing";
    public static String TYPEOFMACHINEUSED = "typeofmachineused";
    public static String COSTMACHINETHRESHING = "costmachinethreshing";
    public static String METHODMANUALTHRESHING = "methodmanualthreshing";
    public static String NOLABOURTHRESHINGTOTAL = "nolabourthreshingtotal";
    public static String TIMECOMPLETIONTHRESHING = "timecompletionthreshing";
    public static String NOFAMLABOURTTHRESHING = "nofamlabourtthreshing";
    public static String NOHIREDLABOURTHRESHING = "nohiredlabourthreshing";
    public static String COSTOFHIREDLABOURTHRESHING = "costofhiredlabourthreshing";
    public static String METHODOFWINNOWING = "methodofwinnowing";
    public static String TYPEOFMACHINEWINNOWING = "typeofmachinewinnowing";
    public static String COSTMACHINEWINNOWING = "costmachinewinnowing";
    public static String NOLABOURWINNOWINGTOTAL = "nolabourwinnowingtotal";
    public static String TIMECOMPLETIONWINNOWING = "timecompletionwinnowing";
    public static String NOFAMLABOURWINNOWING = "nofamlabourwinnowing";
    public static String NOHIREDLABOURWINNOWING = "nohiredlabourwinnowing";
    public static String COSTOFHIREDLABOURWINNOWING = "costofhiredlabourwinnowing";
    public static String METHODOFDRYINGGRAIN = "methodofdryinggrain";
    public static String NOLABOURDRYINGGRAINTOTAL = "nolabourdryinggraintotal";
    public static String TIMECOMPLETIONDRYINGGRAIN = "timecompletiondryinggrain";
    public static String NOFAMLABOURDRYINGGRAIN = "nofamlabourdryinggrain";
    public static String NOHIREDLABOURDRYINGGRAIN = "nohiredlabourdryinggrain";
    public static String COSTOFHIREDLABOUR = "costofhiredlabour";
    public static String TYPEOFBAGSUSEDSTORINGPRODUCE = "typeofbagsusedstoringproduce";
    public static String NOOFSTORAGEBAGS = "noofstoragebags";
    public static String COSTPERUNITOFBAGS = "costperunitofbags";
    public static String TYPEOFSTORAGECHEMICAL = "typeofstoragechemical";
    public static String COSTPERUNITOFSTORAGECHEMICAL = "costperunitofstoragechemical";
    public static String NOUNITSTORAGECHEMICAL = "nounitstoragechemical";
    public static String APPLICATIONRATEOFSTORAGECHEMICAL = "applicationrateofstoragechemical";
    public static String NOLABOURBAGGING = "nolabourbagging";
    public static String TIMECOMPLETIONBAGGING = "timecompletionbagging";
    public static String NOFAMLABOURBAGGING = "nofamlabourbagging";
    public static String NOHIREDLABOURBAGGING = "nohiredlabourbagging";
    public static String COSTOFHIREDLABOURBAGGING = "costofhiredlabourbagging";

    public void setCostOFHiredLabourBagging(String costofhiredlabourbagging) {
        underlyingNode.setProperty(COSTOFHIREDLABOURBAGGING, costofhiredlabourbagging);
    }

    public String getCostOFHiredLabourBagging() {
        try {
            return (String) underlyingNode.getProperty(COSTOFHIREDLABOURBAGGING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoHiredLabourBagging(String nohiredlabourbagging) {
        underlyingNode.setProperty(NOHIREDLABOURBAGGING, nohiredlabourbagging);
    }

    public String getNoHiredLabourBagging() {
        try {
            return (String) underlyingNode.getProperty(NOHIREDLABOURBAGGING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoFamLabourBagging(String nofamlabourbagging) {
        underlyingNode.setProperty(NOFAMLABOURBAGGING, nofamlabourbagging);
    }

    public String getNoFamLabourBagging() {
        try {
            return (String) underlyingNode.getProperty(NOFAMLABOURBAGGING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setTimeCompletionBagging(String timecompletionbagging) {
        underlyingNode.setProperty(TIMECOMPLETIONBAGGING, timecompletionbagging);
    }

    public String getTimeCompletionBagging() {
        try {
            return (String) underlyingNode.getProperty(TIMECOMPLETIONBAGGING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoLabourBagging(String nolabourbagging) {
        underlyingNode.setProperty(NOLABOURBAGGING, nolabourbagging);
    }

    public String getNoLabourBagging() {
        try {
            return (String) underlyingNode.getProperty(NOLABOURBAGGING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setApplicationRateOfStorageChemical(String applicationrateofstoragechemical) {
        underlyingNode.setProperty(APPLICATIONRATEOFSTORAGECHEMICAL, applicationrateofstoragechemical);
    }

    public String getApplicationRateOfStorageChemical() {
        try {
            return (String) underlyingNode.getProperty(APPLICATIONRATEOFSTORAGECHEMICAL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoUnitStorageChemical(String nounitstoragechemical) {
        underlyingNode.setProperty(NOUNITSTORAGECHEMICAL, nounitstoragechemical);
    }

    public String getNoUnitStorageChemical() {
        try {
            return (String) underlyingNode.getProperty(NOUNITSTORAGECHEMICAL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setCostPerUnitOfStorageChemical(String costperunitofstoragechemical) {
        underlyingNode.setProperty(COSTPERUNITOFSTORAGECHEMICAL, costperunitofstoragechemical);
    }

    public String getCostPerUnitOfStorageChemical() {
        try {
            return (String) underlyingNode.getProperty(COSTPERUNITOFSTORAGECHEMICAL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setTypeOfStorageChemical(String typeofstoragechemical) {
        underlyingNode.setProperty(TYPEOFSTORAGECHEMICAL, typeofstoragechemical);
    }

    public String getTypeOfStorageChemical() {
        try {
            return (String) underlyingNode.getProperty(TYPEOFSTORAGECHEMICAL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setCostPerUnitOfBags(String costperunitofbags) {
        underlyingNode.setProperty(COSTPERUNITOFBAGS, costperunitofbags);
    }

    public String getCostPerUnitOfBags() {
        try {
            return (String) underlyingNode.getProperty(COSTPERUNITOFBAGS);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoOfStorageBags(String noofstoragebags) {
        underlyingNode.setProperty(NOOFSTORAGEBAGS, noofstoragebags);
    }

    public String getNoOfStorageBags() {
        try {
            return (String) underlyingNode.getProperty(NOOFSTORAGEBAGS);

        } catch (Exception e) {
        }
        return null;
    }

    public void setTypeOfBagsUsedStoringProduce(String typeofbagsusedstoringproduce) {
        underlyingNode.setProperty(TYPEOFBAGSUSEDSTORINGPRODUCE, typeofbagsusedstoringproduce);
    }

    public String getTypeOfBagsUsedStoringProduce() {
        try {
            return (String) underlyingNode.getProperty(TYPEOFBAGSUSEDSTORINGPRODUCE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setCostOfHiredLabour(String costofhiredlabour) {
        underlyingNode.setProperty(COSTOFHIREDLABOUR, costofhiredlabour);
    }

    public String getCostOfHiredLabour() {
        try {
            return (String) underlyingNode.getProperty(COSTOFHIREDLABOUR);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoHiredLabourDryingGrain(String nohiredlabourdryinggrain) {
        underlyingNode.setProperty(NOHIREDLABOURDRYINGGRAIN, nohiredlabourdryinggrain);
    }

    public String getNoHiredLabourDryingGrain() {
        try {
            return (String) underlyingNode.getProperty(NOHIREDLABOURDRYINGGRAIN);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoFamLabourDryingGrain(String nofamlabourdryinggrain) {
        underlyingNode.setProperty(NOFAMLABOURDRYINGGRAIN, nofamlabourdryinggrain);
    }

    public String getNoFamLabourDryingGrain() {
        try {
            return (String) underlyingNode.getProperty(NOFAMLABOURDRYINGGRAIN);

        } catch (Exception e) {
        }
        return null;
    }

    public void setTimeCompletionDryingGrain(String timecompletiondryinggrain) {
        underlyingNode.setProperty(TIMECOMPLETIONDRYINGGRAIN, timecompletiondryinggrain);
    }

    public String getTimeCompletionDryingGrain() {
        try {
            return (String) underlyingNode.getProperty(TIMECOMPLETIONDRYINGGRAIN);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoLabourDryingGrainTotal(String nolabourdryinggraintotal) {
        underlyingNode.setProperty(NOLABOURDRYINGGRAINTOTAL, nolabourdryinggraintotal);
    }

    public String getNoLabourDryingGrainTotal() {
        try {
            return (String) underlyingNode.getProperty(NOLABOURDRYINGGRAINTOTAL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setMethodOfDryingGrain(String methodofdryinggrain) {
        underlyingNode.setProperty(METHODOFDRYINGGRAIN, methodofdryinggrain);
    }

    public String getMethodOfDryingGrain() {
        try {
            return (String) underlyingNode.getProperty(METHODOFDRYINGGRAIN);

        } catch (Exception e) {
        }
        return null;
    }

    public void setCostOfHiredLabourWinnowing(String costofhiredlabourwinnowing) {
        underlyingNode.setProperty(COSTOFHIREDLABOURWINNOWING, costofhiredlabourwinnowing);
    }

    public String getCostOfHiredLabourWinnowing() {
        try {
            return (String) underlyingNode.getProperty(COSTOFHIREDLABOURWINNOWING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoHiredLabourWinnowing(String nohiredlabourwinnowing) {
        underlyingNode.setProperty(NOHIREDLABOURWINNOWING, nohiredlabourwinnowing);
    }

    public String getNoHiredLabourWinnowing() {
        try {
            return (String) underlyingNode.getProperty(NOHIREDLABOURWINNOWING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoFamLabourWinnowing(String nofamlabourwinnowing) {
        underlyingNode.setProperty(NOFAMLABOURWINNOWING, nofamlabourwinnowing);
    }

    public String getNoFamLabourWinnowing() {
        try {
            return (String) underlyingNode.getProperty(NOFAMLABOURWINNOWING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setTimeCompletionWinnowing(String timecompletionwinnowing) {
        underlyingNode.setProperty(TIMECOMPLETIONWINNOWING, timecompletionwinnowing);
    }

    public String getTimeCompletionWinnowing() {
        try {
            return (String) underlyingNode.getProperty(TIMECOMPLETIONWINNOWING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoLabourWinnowingTotal(String nolabourwinnowingtotal) {
        underlyingNode.setProperty(NOLABOURWINNOWINGTOTAL, nolabourwinnowingtotal);
    }

    public String getNoLabourWinnowingTotal() {
        try {
            return (String) underlyingNode.getProperty(NOLABOURWINNOWINGTOTAL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setCostMachineWinnowing(String costmachinewinnowing) {
        underlyingNode.setProperty(COSTMACHINEWINNOWING, costmachinewinnowing);
    }

    public String getCostMachineWinnowing() {
        try {
            return (String) underlyingNode.getProperty(COSTMACHINEWINNOWING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setTypeOfMachineWinnowing(String typeofmachinewinnowing) {
        underlyingNode.setProperty(TYPEOFMACHINEWINNOWING, typeofmachinewinnowing);
    }

    public String getTypeOfMachineWinnowing() {
        try {
            return (String) underlyingNode.getProperty(TYPEOFMACHINEWINNOWING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setMethodOfWinnowing(String methodofwinnowing) {
        underlyingNode.setProperty(METHODOFWINNOWING, methodofwinnowing);
    }

    public String getMethodOfWinnowing() {
        try {
            return (String) underlyingNode.getProperty(METHODOFWINNOWING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setCostOfHiredLabourThreshing(String costofhiredlabourthreshing) {
        underlyingNode.setProperty(COSTOFHIREDLABOURTHRESHING, costofhiredlabourthreshing);
    }

    public String getCostOfHiredLabourThreshing() {
        try {
            return (String) underlyingNode.getProperty(COSTOFHIREDLABOURTHRESHING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoHiredLabourThreshing(String nohiredlabourthreshing) {
        underlyingNode.setProperty(NOHIREDLABOURTHRESHING, nohiredlabourthreshing);
    }

    public String getNoHiredLabourThreshing() {
        try {
            return (String) underlyingNode.getProperty(NOHIREDLABOURTHRESHING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoFamLabourtThreshing(String nofamlabourtthreshing) {
        underlyingNode.setProperty(NOFAMLABOURTTHRESHING, nofamlabourtthreshing);
    }

    public String getNoFamLabourtThreshing() {
        try {
            return (String) underlyingNode.getProperty(NOFAMLABOURTTHRESHING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setTimeCompletionThreshing(String timecompletionthreshing) {
        underlyingNode.setProperty(TIMECOMPLETIONTHRESHING, timecompletionthreshing);
    }

    public String getTimeCompletionThreshing() {
        try {
            return (String) underlyingNode.getProperty(TIMECOMPLETIONTHRESHING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoLabourThreshingTotal(String nolabourthreshingtotal) {
        underlyingNode.setProperty(NOLABOURTHRESHINGTOTAL, nolabourthreshingtotal);
    }

    public String getNoLabourThreshingTotal() {
        try {
            return (String) underlyingNode.getProperty(NOLABOURTHRESHINGTOTAL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setMethodManualThreshing(String methodmanualthreshing) {
        underlyingNode.setProperty(METHODMANUALTHRESHING, methodmanualthreshing);
    }

    public String getMethodManualThreshing() {
        try {
            return (String) underlyingNode.getProperty(METHODMANUALTHRESHING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setCostMachineThreshing(String costmachinethreshing) {
        underlyingNode.setProperty(COSTMACHINETHRESHING, costmachinethreshing);
    }

    public String getCostMachineThreshing() {
        try {
            return (String) underlyingNode.getProperty(COSTMACHINETHRESHING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setTypeOfMachineUsed(String typeofmachineused) {
        underlyingNode.setProperty(TYPEOFMACHINEUSED, typeofmachineused);
    }

    public String getTypeOfMachineUsed() {
        try {
            return (String) underlyingNode.getProperty(TYPEOFMACHINEUSED);

        } catch (Exception e) {
        }
        return null;
    }

    public void setMethodOfThreshing(String methodofthreshing) {
        underlyingNode.setProperty(METHODOFTHRESHING, methodofthreshing);
    }

    public String getMethodOfThreshing() {
        try {
            return (String) underlyingNode.getProperty(METHODOFTHRESHING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setCostOfHiredLabourDrying(String costofhiredlabourdrying) {
        underlyingNode.setProperty(COSTOFHIREDLABOURDRYING, costofhiredlabourdrying);
    }

    public String getCostOfHiredLabourDrying() {
        try {
            return (String) underlyingNode.getProperty(COSTOFHIREDLABOURDRYING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoHiredLabourDrying(String nohiredlabourdrying) {
        underlyingNode.setProperty(NOHIREDLABOURDRYING, nohiredlabourdrying);
    }

    public String getNoHiredLabourDrying() {
        try {
            return (String) underlyingNode.getProperty(NOHIREDLABOURDRYING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoFamLabourDrying(String nofamlabourdrying) {
        underlyingNode.setProperty(NOFAMLABOURDRYING, nofamlabourdrying);
    }

    public String getNoFamLabourDrying() {
        try {
            return (String) underlyingNode.getProperty(NOFAMLABOURDRYING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setTimeCompletionDrying(String timecompletiondrying) {
        underlyingNode.setProperty(TIMECOMPLETIONDRYING, timecompletiondrying);
    }

    public String getTimeCompletionDrying() {
        try {
            return (String) underlyingNode.getProperty(TIMECOMPLETIONDRYING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoLabourDryingTotal(String nolabourdryingtotal) {
        underlyingNode.setProperty(NOLABOURDRYINGTOTAL, nolabourdryingtotal);
    }

    public String getNoLabourDryingTotal() {
        try {
            return (String) underlyingNode.getProperty(NOLABOURDRYINGTOTAL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setMethodOfDrying(String methodofdrying) {
        underlyingNode.setProperty(METHODOFDRYING, methodofdrying);
    }

    public String getMethodOfDrying() {
        try {
            return (String) underlyingNode.getProperty(METHODOFDRYING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setCostOfHiredLabourDehuskingPeeling(String costofhiredlabourdehuskingpeeling) {
        underlyingNode.setProperty(COSTOFHIREDLABOURDEHUSKINGPEELING, costofhiredlabourdehuskingpeeling);
    }

    public String getCostOfHiredLabourDehuskingPeeling() {
        try {
            return (String) underlyingNode.getProperty(COSTOFHIREDLABOURDEHUSKINGPEELING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoHiredLabourDehuskingPeeling(String nohiredlabourdehuskingpeeling) {
        underlyingNode.setProperty(NOHIREDLABOURDEHUSKINGPEELING, nohiredlabourdehuskingpeeling);
    }

    public String getNoHiredLabourDehuskingPeeling() {
        try {
            return (String) underlyingNode.getProperty(NOHIREDLABOURDEHUSKINGPEELING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoFamLabourDehuskingPeeling(String nofamlabourdehuskingpeeling) {
        underlyingNode.setProperty(NOFAMLABOURDEHUSKINGPEELING, nofamlabourdehuskingpeeling);
    }

    public String getNoFamLabourDehuskingPeeling() {
        try {
            return (String) underlyingNode.getProperty(NOFAMLABOURDEHUSKINGPEELING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setTimeCompletionDehuskingPeeling(String timecompletiondehuskingpeeling) {
        underlyingNode.setProperty(TIMECOMPLETIONDEHUSKINGPEELING, timecompletiondehuskingpeeling);
    }

    public String getTimeCompletionDehuskingPeeling() {
        try {
            return (String) underlyingNode.getProperty(TIMECOMPLETIONDEHUSKINGPEELING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoLabourDehuskingPeelingTotal(String nolabourdehuskingpeelingtotal) {
        underlyingNode.setProperty(NOLABOURDEHUSKINGPEELINGTOTAL, nolabourdehuskingpeelingtotal);
    }

    public String getNoLabourDehuskingPeelingTotal() {
        try {
            return (String) underlyingNode.getProperty(NOLABOURDEHUSKINGPEELINGTOTAL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setMethodOfProcessing(String methodofprocessing) {
        underlyingNode.setProperty(METHODOFPROCESSING, methodofprocessing);
    }

    public String getMethodOfProcessing() {
        try {
            return (String) underlyingNode.getProperty(METHODOFPROCESSING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setPeelingDate(String peelingdate) {
        underlyingNode.setProperty(PEELINGDATE, peelingdate);
    }

    public String getPeelingDate() {
        try {
            return (String) underlyingNode.getProperty(PEELINGDATE);

        } catch (Exception e) {
        }
        return null;
    }

    Node underlyingNode;

    public PostHarvest(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }

    public void setPortionHarvestProcessed(String portionharvestprocessed) {
        underlyingNode.setProperty(PORTIONHARVESTPROCESSED, portionharvestprocessed);
    }

    public String getPortionHarvestProcessed() {
        try {
            return (String) underlyingNode.getProperty(PORTIONHARVESTPROCESSED);

        } catch (Exception e) {
        }
        return null;
    }

}
