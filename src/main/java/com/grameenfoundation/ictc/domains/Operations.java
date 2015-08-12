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
 * @date Jul 21, 2015 2:50:21 PM description:
 */
public class Operations extends Status implements GeneralInterface {

    Node underlyingNode;

    public static String LANDSIZE = "landsize";
    public static String PAYFORLAND = "payforland";
    public static String LANDRENT = "landrent";
    public static String TYPEOFVARIETY = "typeofvariety";
    public static String NAMEOFVARIETY = "nameofvariety";
    public static String PAYSEEDMATERIAL = "payseedmaterial";
    public static String COSTPERUNIT = "costperunit";
    public static String PURCHASEOFSTAKES = "purchaseofstakes";
    public static String SOURCEOFPLANTINGMATERIAL = "sourceofplantingmaterial";
    public static String QUANTITYOFBUNDLES = "quantityofbundles";
    public static String WEIGHTOFSEED = "weightofseed";
    public static String QUANTITYOFPLANTINGMATERIAL = "quantityofplantingmaterial";
    public static String LANDCLEARANCE = "landclearance";
    public static String HERBICIDEUSE = "herbicideuse";
    public static String LANDCLEARANCEHERBICIDE = "landclearanceherbicide";
    public static String QUANTITYOFHERBICIDE = "quantityofherbicide";
    public static String PRICEOFHERBICIDE = "priceofherbicide";
    public static String PURCHASEMONTHOFHERBICIDE = "purchasemonthofherbicide";
    public static String APPLICATIONMONTHOFHERBICIDE = "applicationmonthofherbicide";
    public static String COSTAPPLICATIONOFHERBICIDE = "costapplicationofherbicide";
    public static String METHODOFLANDPREP = "methodoflandprep";
    public static String METHODOFLANDPREPMACHINERY = "methodoflandprepmachinery";
    public static String MONTHOFPLOUGHINGMACHINERY = "monthofploughingmachinery";
    public static String COSTOFPLOUGHINGMACHINERY = "costofploughingmachinery";
    public static String MONTHOFHARROWINGMACHINERY = "monthofharrowingmachinery";
    public static String COSTOFHARROWINGMACHINERY = "costofharrowingmachinery";
    public static String MONTHOFPLOUGHINGHOE = "monthofploughinghoe";
    public static String NOOFLABOURHANDPLOUGHINGHOE = "nooflabourhandploughinghoe";
    public static String TIMEFORPLOUGHINGHOE = "timeforploughinghoe";
    public static String HIREDLABOURPLOUGHINGHOE = "hiredlabourploughinghoe";
    public static String FAMILYLABOURPLOUGHINGHOE = "familylabourploughinghoe";
    public static String COMPENSATIONPLOUGHINGHOE = "compensationploughinghoe";
    public static String SPECIALSEEDBEDTYPE = "specialseedbedtype";
    public static String NOOFLABOURSEEDBEDTYPEPREP = "nooflabourseedbedtypeprep";
    public static String TIMEFORSEEDBEDTYPEPREP = "timeforseedbedtypeprep";
    public static String NOHIREDABOURSEEDBEDTYPEPREP = "nohiredabourseedbedtypeprep";
    public static String FAMLABOURSEEDBEDTYPEPREP = "famlabourseedbedtypeprep";
    public static String COMPENSATIONSEEDBEDTYPEPREP = "compensationseedbedtypeprep";
    public static String MONTHPLANTINGMATERIALPREP = "monthplantingmaterialprep";
    public static String MONTHCOMPLETEPLANTING = "monthcompleteplanting";
    public static String SIZEOFCUTTINGS = "sizeofcuttings";
    public static String PLANTARRANGEMENT = "plantarrangement";
    public static String PLANTINGDISTANCEROWS = "plantingdistancerows";
    public static String PLANTINGDISTANCEPLANT = "plantingdistanceplant";
    public static String COMPENSATIONPLANTING = "compensationplanting";
    public static String REFILLINGGAPSOCCURENCE = "refillinggapsoccurence";
    public static String REFILLINGPROPORTION = "refillingproportion";
    public static String NOOFLABOURREFILLINGGAPS = "nooflabourrefillinggaps";
    public static String TIMEREFILLINGGAPS = "timerefillinggaps";
    public static String FAMLABOURREFILLINGGAPS = "famlabourrefillinggaps";
    public static String HIREDLABOURREFILLINGGAPS = "hiredlabourrefillinggaps";
    public static String COMPENSATIONREFILLINGGAPS = "compensationrefillinggaps";
    public static String POSTPLANTHERBICIDE = "postplantherbicide";
    public static String POSTPLANTHERBICIDETYPE = "postplantherbicidetype";
    public static String MONTHPURCHASEHERBICIDE = "monthpurchaseherbicide";
    public static String QTYPOSTPLANTHERBICIDE = "qtypostplantherbicide";
    public static String COSTPERUNITBASALFERTILIZER = "costperunitbasalfertilizer";
    public static String METHODOFBASALAPPLICATION = "methodofbasalapplication";
    public static String MONTHBASALAPPLICATION = "monthbasalapplication";
    public static String NOLABOURBASALAPPLICATION = "nolabourbasalapplication";
    public static String TIMECOMPLETIONBASALFERTILIZER = "timecompletionbasalfertilizer";
    public static String FAMLABOURBASALFERTILIZER = "famlabourbasalfertilizer";
    public static String NOHIREDLABOURBASALFERTILIZER = "nohiredlabourbasalfertilizer";
    public static String APPLICATIONOFTOPDRESSFERTILIZER = "applicationoftopdressfertilizer";
    public static String ENTREPRENEURSHIP = "entrepreneurship";
    public static String QUANTITYOFFERTILIZERTOPDRESSING = "quantityoffertilizertopdressing";
    public static String MONTHPURCHASETOPDRESSFERTILIZER = "monthpurchasetopdressfertilizer";
    public static String PRICETOPDRESSFERTILIZER = "pricetopdressfertilizer";
    public static String METHODTOPDRESSFERTILIZERAPP = "methodtopdressfertilizerapp";
    public static String TIMEAPPLICATIONTOPDRESSING = "timeapplicationtopdressing";
    public static String NOLABOURTOPDRESSFERTILIZERAPP = "nolabourtopdressfertilizerapp";
    public static String TIMECOMPLETIONOFTOPDRESSERFERTILIZER = "timecompletionoftopdresserfertilizer";
    public static String FAMLABOURTOPDRESSERFERTILIZER = "famlabourtopdresserfertilizer";
    public static String HIREDLABOURTOPDRESSERFERTILIZER = "hiredlabourtopdresserfertilizer";
    public static String COSTHIREDLABOURTOPDRESSFERTILIZER = "costhiredlabourtopdressfertilizer";
    public static String OCCASIONMANUALWEEDCONTROL = "occasionmanualweedcontrol";
    public static String FIRSTMANUALWEEDCONTROLDATE = "firstmanualweedcontroldate";
    public static String NOLABOURFIRSTWEEDCONTROL = "nolabourfirstweedcontrol";
    public static String TIMECOMPLETIONFIRSTWEEDCONTROL = "timecompletionfirstweedcontrol";
    public static String FAMLABOURFIRSTWEEDCONTROL = "famlabourfirstweedcontrol";
    public static String NOHIREDLABOURFIRSTWEEDCONTROL = "nohiredlabourfirstweedcontrol";
    public static String COSTHIREDLABOURMANUALWEEDCONTROL = "costhiredlabourmanualweedcontrol";
    public static String SECONDMANUALWEEDCONTROLDATE = "secondmanualweedcontroldate";
    public static String NOLABOURSECONDMANUALWEEDCONTROL = "nolaboursecondmanualweedcontrol";
    public static String TIMECOMPLETIONSECONDMANUALWEEDCONTROL = "timecompletionsecondmanualweedcontrol";
    public static String FAMLABOURSECONDMANUALWEEDCONTROL = "famlaboursecondmanualweedcontrol";
    public static String COSTHIREDLABOURSECONDMANUALWEEDCONTROL = "costhiredlaboursecondmanualweedcontrol";
    public static String THIRDMANUALWEEDCONTROLDATE = "thirdmanualweedcontroldate";
    public static String NOLABOURTHIRDWEEDCONTROL = "nolabourthirdweedcontrol";
    public static String TIMECOMPLETIONTHIRDMANUALWEEDCONTROL = "timecompletionthirdmanualweedcontrol";
    public static String FAMLABOURTHIRDWEEDCONTROL = "famlabourthirdweedcontrol";
    public static String NOHIREDLABOURTHIRDMANUALWEEDCONTROL = "nohiredlabourthirdmanualweedcontrol";
    public static String COSTHIREDLABOURTHIRDMANUALWEEDCONTROL = "costhiredlabourthirdmanualweedcontrol";
    public static String FOURTHWEEDCONTROLDATE = "fourthweedcontroldate";
    public static String NOLABOURFOURTHWEEDCONTROL = "nolabourfourthweedcontrol";
    public static String TIMECOMPLETIONFOURTHWEEDCONTROL = "timecompletionfourthweedcontrol";
    public static String FAMLABOURFOURTHWEEDCONTROL = "famlabourfourthweedcontrol";
    public static String NOHIREDLABOURFOURTHWEEDCONTRO = "nohiredlabourfourthweedcontrol";
    public static String COSTHIREDLABOURFOURTHWEEDCONTROL = "costhiredlabourfourthweedcontrol";
    public static String FIFTHWEEDCONTROLDATE = "fifthweedcontroldate";
    public static String NOLABOURFIFTHWEEDCONTROL = "nolabourfifthweedcontrol";
    public static String TIMECOMPLETIONFIFTHWEEDCONTROL = "timecompletionfifthweedcontrol";
    public static String FAMLABOURFIFTHWEEDCONTROL = "famlabourfifthweedcontrol";
    public static String NOHIREDLABOURFIFTHWEEDCONTROL = "nohiredlabourfifthweedcontrol";
    public static String COSTHIREDLABOURFIFTHWEEDCONTROL = "costhiredlabourfifthweedcontrol";

    public void setCostHiredLabourFifthWeedControl(String costhiredlabourfifthweedcontrol) {
        underlyingNode.setProperty(COSTHIREDLABOURFIFTHWEEDCONTROL, costhiredlabourfifthweedcontrol);
    }

    public String getCostHiredLabourFifthWeedControl() {
        try {
            return (String) underlyingNode.getProperty(COSTHIREDLABOURFIFTHWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoHiredLabourFifthWeedControl(String nohiredlabourfifthweedcontrol) {
        underlyingNode.setProperty(NOHIREDLABOURFIFTHWEEDCONTROL, nohiredlabourfifthweedcontrol);
    }

    public String getNoHiredLabourFifthWeedControl() {
        try {
            return (String) underlyingNode.getProperty(NOHIREDLABOURFIFTHWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setFamLabourFifthWeedControl(String famlabourfifthweedcontrol) {
        underlyingNode.setProperty(FAMLABOURFIFTHWEEDCONTROL, famlabourfifthweedcontrol);
    }

    public String getFamLabourFifthWeedControl() {
        try {
            return (String) underlyingNode.getProperty(FAMLABOURFIFTHWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setTimeCompletionFifthWeedControl(String timecompletionfifthweedcontrol) {
        underlyingNode.setProperty(TIMECOMPLETIONFIFTHWEEDCONTROL, timecompletionfifthweedcontrol);
    }

    public String getTimeCompletionFifthWeedControl() {
        try {
            return (String) underlyingNode.getProperty(TIMECOMPLETIONFIFTHWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoLabourFifthWeedControl(String nolabourfifthweedcontrol) {
        underlyingNode.setProperty(NOLABOURFIFTHWEEDCONTROL, nolabourfifthweedcontrol);
    }

    public String getNoLabourFifthWeedControl() {
        try {
            return (String) underlyingNode.getProperty(NOLABOURFIFTHWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setFifthWeedControlDate(String fifthweedcontroldate) {
        underlyingNode.setProperty(FIFTHWEEDCONTROLDATE, fifthweedcontroldate);
    }

    public String getFifthWeedControlDate() {
        try {
            return (String) underlyingNode.getProperty(FIFTHWEEDCONTROLDATE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setCostHiredLabourFourthWeedControl(String costhiredlabourfourthweedcontrol) {
        underlyingNode.setProperty(COSTHIREDLABOURFOURTHWEEDCONTROL, costhiredlabourfourthweedcontrol);
    }

    public String getCostHiredLabourFourthWeedControl() {
        try {
            return (String) underlyingNode.getProperty(COSTHIREDLABOURFOURTHWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoHiredLabourFourthWeedContro(String nohiredlabourfourthweedcontro) {
        underlyingNode.setProperty(NOHIREDLABOURFOURTHWEEDCONTRO, nohiredlabourfourthweedcontro);
    }

    public String getNoHiredLabourFourthWeedContro() {
        try {
            return (String) underlyingNode.getProperty(NOHIREDLABOURFOURTHWEEDCONTRO);

        } catch (Exception e) {
        }
        return null;
    }

    public void setFamLabourFourthWeedControl(String famlabourfourthweedcontrol) {
        underlyingNode.setProperty(FAMLABOURFOURTHWEEDCONTROL, famlabourfourthweedcontrol);
    }

    public String getFamLabourFourthWeedControl() {
        try {
            return (String) underlyingNode.getProperty(FAMLABOURFOURTHWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setTimeCompletionFourthWeedControl(String timecompletionfourthweedcontrol) {
        underlyingNode.setProperty(TIMECOMPLETIONFOURTHWEEDCONTROL, timecompletionfourthweedcontrol);
    }

    public String getTimeCompletionFourthWeedControl() {
        try {
            return (String) underlyingNode.getProperty(TIMECOMPLETIONFOURTHWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoLabourFourthWeedcontrol(String nolabourfourthweedcontrol) {
        underlyingNode.setProperty(NOLABOURFOURTHWEEDCONTROL, nolabourfourthweedcontrol);
    }

    public String getNoLabourFourthWeedcontrol() {
        try {
            return (String) underlyingNode.getProperty(NOLABOURFOURTHWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setFourthWeedControlDate(String fourthweedcontroldate) {
        underlyingNode.setProperty(FOURTHWEEDCONTROLDATE, fourthweedcontroldate);
    }

    public String getFourthWeedControlDate() {
        try {
            return (String) underlyingNode.getProperty(FOURTHWEEDCONTROLDATE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setCostHiredLabourThirdManualWeedControl(String costhiredlabourthirdmanualweedcontrol) {
        underlyingNode.setProperty(COSTHIREDLABOURTHIRDMANUALWEEDCONTROL, costhiredlabourthirdmanualweedcontrol);
    }

    public String getCostHiredLabourThirdManualWeedControl() {
        try {
            return (String) underlyingNode.getProperty(COSTHIREDLABOURTHIRDMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoHiredLabourThirdManualWeedControl(String nohiredlabourthirdmanualweedcontrol) {
        underlyingNode.setProperty(NOHIREDLABOURTHIRDMANUALWEEDCONTROL, nohiredlabourthirdmanualweedcontrol);
    }

    public String getNoHiredLabourThirdManualWeedControl() {
        try {
            return (String) underlyingNode.getProperty(NOHIREDLABOURTHIRDMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setFamLabourThirdWeedControl(String famlabourthirdweedcontrol) {
        underlyingNode.setProperty(FAMLABOURTHIRDWEEDCONTROL, famlabourthirdweedcontrol);
    }

    public String getFamLabourThirdWeedControl() {
        try {
            return (String) underlyingNode.getProperty(FAMLABOURTHIRDWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setTimeCompletionThirdManualWeedControl(String timecompletionthirdmanualweedcontrol) {
        underlyingNode.setProperty(TIMECOMPLETIONTHIRDMANUALWEEDCONTROL, timecompletionthirdmanualweedcontrol);
    }

    public String getTimeCompletionThirdManualWeedControl() {
        try {
            return (String) underlyingNode.getProperty(TIMECOMPLETIONTHIRDMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoLabourThirdWeedControl(String nolabourthirdweedcontrol) {
        underlyingNode.setProperty(NOLABOURTHIRDWEEDCONTROL, nolabourthirdweedcontrol);
    }

    public String getNoLabourThirdWeedControl() {
        try {
            return (String) underlyingNode.getProperty(NOLABOURTHIRDWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setThirdManualWeedControlDate(String thirdmanualweedcontroldate) {
        underlyingNode.setProperty(THIRDMANUALWEEDCONTROLDATE, thirdmanualweedcontroldate);
    }

    public String getThirdManualWeedControlDate() {
        try {
            return (String) underlyingNode.getProperty(THIRDMANUALWEEDCONTROLDATE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setCostHiredLabourSecondManualWeedControl(String costhiredlaboursecondmanualweedcontrol) {
        underlyingNode.setProperty(COSTHIREDLABOURSECONDMANUALWEEDCONTROL, costhiredlaboursecondmanualweedcontrol);
    }

    public String getCostHiredLabourSecondManualWeedControl() {
        try {
            return (String) underlyingNode.getProperty(COSTHIREDLABOURSECONDMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

    public static String NOHIREDLABOURSECONDMANUALWEEDCONTROL = "nohiredlaboursecondmanualweedcontrol";

    public void setNoHiredLabourSecondManualWeedControl(String nohiredlaboursecondmanualweedcontrol) {
        underlyingNode.setProperty(NOHIREDLABOURSECONDMANUALWEEDCONTROL, nohiredlaboursecondmanualweedcontrol);
    }

    public String getNoHiredLabourSecondManualWeedControl() {
        try {
            return (String) underlyingNode.getProperty(NOHIREDLABOURSECONDMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setFamLabourSecondManualWeedControl(String famlaboursecondmanualweedcontrol) {
        underlyingNode.setProperty(FAMLABOURSECONDMANUALWEEDCONTROL, famlaboursecondmanualweedcontrol);
    }

    public String getFamLabourSecondManualWeedControl() {
        try {
            return (String) underlyingNode.getProperty(FAMLABOURSECONDMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setTimeCompletionSecondManualWeedControl(String timecompletionsecondmanualweedcontrol) {
        underlyingNode.setProperty(TIMECOMPLETIONSECONDMANUALWEEDCONTROL, timecompletionsecondmanualweedcontrol);
    }

    public String getTimeCompletionSecondManualWeedControl() {
        try {
            return (String) underlyingNode.getProperty(TIMECOMPLETIONSECONDMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoLabourSecondManualWeedControl(String nolaboursecondmanualweedcontrol) {
        underlyingNode.setProperty(NOLABOURSECONDMANUALWEEDCONTROL, nolaboursecondmanualweedcontrol);
    }

    public String getNoLabourSecondManualWeedControl() {
        try {
            return (String) underlyingNode.getProperty(NOLABOURSECONDMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setSecondManualWeedControlDate(String secondmanualweedcontroldate) {
        underlyingNode.setProperty(SECONDMANUALWEEDCONTROLDATE, secondmanualweedcontroldate);
    }

    public String getSecondManualWeedControlDate() {
        try {
            return (String) underlyingNode.getProperty(SECONDMANUALWEEDCONTROLDATE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setCostHiredLabourManualWeedControl(String costhiredlabourmanualweedcontrol) {
        underlyingNode.setProperty(COSTHIREDLABOURMANUALWEEDCONTROL, costhiredlabourmanualweedcontrol);
    }

    public String getCostHiredLabourManualWeedControl() {
        try {
            return (String) underlyingNode.getProperty(COSTHIREDLABOURMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoHiredLabourFirstWeedControl(String nohiredlabourfirstweedcontrol) {
        underlyingNode.setProperty(NOHIREDLABOURFIRSTWEEDCONTROL, nohiredlabourfirstweedcontrol);
    }

    public String getNoHiredLabourFirstWeedControl() {
        try {
            return (String) underlyingNode.getProperty(NOHIREDLABOURFIRSTWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setFamLabourFirstWeedControl(String famlabourfirstweedcontrol) {
        underlyingNode.setProperty(FAMLABOURFIRSTWEEDCONTROL, famlabourfirstweedcontrol);
    }

    public String getFamLabourFirstWeedControl() {
        try {
            return (String) underlyingNode.getProperty(FAMLABOURFIRSTWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setTimeCompletionFirstWeedControl(String timecompletionfirstweedcontrol) {
        underlyingNode.setProperty(TIMECOMPLETIONFIRSTWEEDCONTROL, timecompletionfirstweedcontrol);
    }

    public String getTimeCompletionFirstWeedControl() {
        try {
            return (String) underlyingNode.getProperty(TIMECOMPLETIONFIRSTWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoLabourFirstWeedControl(String nolabourfirstweedcontrol) {
        underlyingNode.setProperty(NOLABOURFIRSTWEEDCONTROL, nolabourfirstweedcontrol);
    }

    public String getNoLabourFirstWeedControl() {
        try {
            return (String) underlyingNode.getProperty(NOLABOURFIRSTWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setFirstManualWeedControlDate(String firstmanualweedcontroldate) {
        underlyingNode.setProperty(FIRSTMANUALWEEDCONTROLDATE, firstmanualweedcontroldate);
    }

    public String getFirstManualWeedControlDate() {
        try {
            return (String) underlyingNode.getProperty(FIRSTMANUALWEEDCONTROLDATE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setOccasionManualWeedControl(String occasionmanualweedcontrol) {
        underlyingNode.setProperty(OCCASIONMANUALWEEDCONTROL, occasionmanualweedcontrol);
    }

    public String getOccasionManualWeedControl() {
        try {
            return (String) underlyingNode.getProperty(OCCASIONMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setCostHiredLabourTopDressFertilizer(String costhiredlabourtopdressfertilizer) {
        underlyingNode.setProperty(COSTHIREDLABOURTOPDRESSFERTILIZER, costhiredlabourtopdressfertilizer);
    }

    public String getCostHiredLabourTopDressFertilizer() {
        try {
            return (String) underlyingNode.getProperty(COSTHIREDLABOURTOPDRESSFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }

    public void setHiredLabourTopDresserFertilizer(String hiredlabourtopdresserfertilizer) {
        underlyingNode.setProperty(HIREDLABOURTOPDRESSERFERTILIZER, hiredlabourtopdresserfertilizer);
    }

    public String getHiredLabourTopDresserFertilizer() {
        try {
            return (String) underlyingNode.getProperty(HIREDLABOURTOPDRESSERFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }

    public void setFamLabourTopDresserFertilizer(String famlabourtopdresserfertilizer) {
        underlyingNode.setProperty(FAMLABOURTOPDRESSERFERTILIZER, famlabourtopdresserfertilizer);
    }

    public String getFamLabourTopDresserFertilizer() {
        try {
            return (String) underlyingNode.getProperty(FAMLABOURTOPDRESSERFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }

    public void setTimeCompletionOfTopDresserFertilizer(String timecompletionoftopdresserfertilizer) {
        underlyingNode.setProperty(TIMECOMPLETIONOFTOPDRESSERFERTILIZER, timecompletionoftopdresserfertilizer);
    }

    public String getTimeCompletionOfTopDresserFertilizer() {
        try {
            return (String) underlyingNode.getProperty(TIMECOMPLETIONOFTOPDRESSERFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoLabourTopDressFertilizerApp(String nolabourtopdressfertilizerapp) {
        underlyingNode.setProperty(NOLABOURTOPDRESSFERTILIZERAPP, nolabourtopdressfertilizerapp);
    }

    public String getNoLabourTopDressFertilizerApp() {
        try {
            return (String) underlyingNode.getProperty(NOLABOURTOPDRESSFERTILIZERAPP);

        } catch (Exception e) {
        }
        return null;
    }

    public void setTimeApplicationTopDressing(String timeapplicationtopdressing) {
        underlyingNode.setProperty(TIMEAPPLICATIONTOPDRESSING, timeapplicationtopdressing);
    }

    public String getTimeApplicationTopDressing() {
        try {
            return (String) underlyingNode.getProperty(TIMEAPPLICATIONTOPDRESSING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setMethodTopDressFertilizerApp(String methodtopdressfertilizerapp) {
        underlyingNode.setProperty(METHODTOPDRESSFERTILIZERAPP, methodtopdressfertilizerapp);
    }

    public String getMethodTopDressFertilizerApp() {
        try {
            return (String) underlyingNode.getProperty(METHODTOPDRESSFERTILIZERAPP);

        } catch (Exception e) {
        }
        return null;
    }

    public void setPriceTopDressFertilizer(String pricetopdressfertilizer) {
        underlyingNode.setProperty(PRICETOPDRESSFERTILIZER, pricetopdressfertilizer);
    }

    public String getPriceTopDressFertilizer() {
        try {
            return (String) underlyingNode.getProperty(PRICETOPDRESSFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }

    public void setMonthPurchaseTopDressFertilizer(String monthpurchasetopdressfertilizer) {
        underlyingNode.setProperty(MONTHPURCHASETOPDRESSFERTILIZER, monthpurchasetopdressfertilizer);
    }

    public String getMonthPurchaseTopDressFertilizer() {
        try {
            return (String) underlyingNode.getProperty(MONTHPURCHASETOPDRESSFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }

    public void setQuantityOfFertilizerTopDressing(String quantityoffertilizertopdressing) {
        underlyingNode.setProperty(QUANTITYOFFERTILIZERTOPDRESSING, quantityoffertilizertopdressing);
    }

    public String getQuantityOfFertilizerTopDressing() {
        try {
            return (String) underlyingNode.getProperty(QUANTITYOFFERTILIZERTOPDRESSING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setEntrepreneurship(String entrepreneurship) {
        underlyingNode.setProperty(ENTREPRENEURSHIP, entrepreneurship);
    }

    public String getEntrepreneurship() {
        try {
            return (String) underlyingNode.getProperty(ENTREPRENEURSHIP);

        } catch (Exception e) {
        }
        return null;
    }

    public void setApplicationOfTopdressFertilizer(String applicationoftopdressfertilizer) {
        underlyingNode.setProperty(APPLICATIONOFTOPDRESSFERTILIZER, applicationoftopdressfertilizer);
    }

    public String getApplicationOfTopdressFertilizer() {
        try {
            return (String) underlyingNode.getProperty(APPLICATIONOFTOPDRESSFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }

    public static String COSTOFHIREDLABOURBASAL = "costofhiredlabourbasal";

    public void setCostOfHiredLabourBasal(String costofhiredlabourbasal) {
        underlyingNode.setProperty(COSTOFHIREDLABOURBASAL, costofhiredlabourbasal);
    }

    public String getCostOfHiredLabourBasal() {
        try {
            return (String) underlyingNode.getProperty(COSTOFHIREDLABOURBASAL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoHiredLabourBasalFertilizer(String nohiredlabourbasalfertilizer) {
        underlyingNode.setProperty(NOHIREDLABOURBASALFERTILIZER, nohiredlabourbasalfertilizer);
    }

    public String getNoHiredLabourBasalFertilizer() {
        try {
            return (String) underlyingNode.getProperty(NOHIREDLABOURBASALFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }

    public void setFamLabourBasalFertilizer(String famlabourbasalfertilizer) {
        underlyingNode.setProperty(FAMLABOURBASALFERTILIZER, famlabourbasalfertilizer);
    }

    public String getFamLabourBasalFertilizer() {
        try {
            return (String) underlyingNode.getProperty(FAMLABOURBASALFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }

    public void setTimeCompletionBasalFertilizer(String timecompletionbasalfertilizer) {
        underlyingNode.setProperty(TIMECOMPLETIONBASALFERTILIZER, timecompletionbasalfertilizer);
    }

    public String getTimeCompletionBasalFertilizer() {
        try {
            return (String) underlyingNode.getProperty(TIMECOMPLETIONBASALFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoLabourBasalApplication(String nolabourbasalapplication) {
        underlyingNode.setProperty(NOLABOURBASALAPPLICATION, nolabourbasalapplication);
    }

    public String getNoLabourBasalApplication() {
        try {
            return (String) underlyingNode.getProperty(NOLABOURBASALAPPLICATION);

        } catch (Exception e) {
        }
        return null;
    }

    public void setMonthBasalApplication(String monthbasalapplication) {
        underlyingNode.setProperty(MONTHBASALAPPLICATION, monthbasalapplication);
    }

    public String getMonthBasalApplication() {
        try {
            return (String) underlyingNode.getProperty(MONTHBASALAPPLICATION);

        } catch (Exception e) {
        }
        return null;
    }

    public void setMethodOfBasalApplication(String methodofbasalapplication) {
        underlyingNode.setProperty(METHODOFBASALAPPLICATION, methodofbasalapplication);
    }

    public String getMethodOfBasalApplication() {
        try {
            return (String) underlyingNode.getProperty(METHODOFBASALAPPLICATION);

        } catch (Exception e) {
        }
        return null;
    }

    public void setCostPerUnitBasalFertilizer(String costperunitbasalfertilizer) {
        underlyingNode.setProperty(COSTPERUNITBASALFERTILIZER, costperunitbasalfertilizer);
    }

    public String getCostPerUnitBasalFertilizer() {
        try {
            return (String) underlyingNode.getProperty(COSTPERUNITBASALFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }

    public void setQtyPostPlantHerbicide(String qtypostplantherbicide) {
        underlyingNode.setProperty(QTYPOSTPLANTHERBICIDE, qtypostplantherbicide);
    }

    public String getQtyPostPlantHerbicide() {
        try {
            return (String) underlyingNode.getProperty(QTYPOSTPLANTHERBICIDE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setMonthPurchaseHerbicide(String monthpurchaseherbicide) {
        underlyingNode.setProperty(MONTHPURCHASEHERBICIDE, monthpurchaseherbicide);
    }

    public String getMonthPurchaseHerbicide() {
        try {
            return (String) underlyingNode.getProperty(MONTHPURCHASEHERBICIDE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setPostPlantHerbicideType(String postplantherbicidetype) {
        underlyingNode.setProperty(POSTPLANTHERBICIDETYPE, postplantherbicidetype);
    }

    public String getPostPlantHerbicideType() {
        try {
            return (String) underlyingNode.getProperty(POSTPLANTHERBICIDETYPE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setPostPlantHerbicide(String postplantherbicide) {
        underlyingNode.setProperty(POSTPLANTHERBICIDE, postplantherbicide);
    }

    public String getPostPlantHerbicide() {
        try {
            return (String) underlyingNode.getProperty(POSTPLANTHERBICIDE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setCompensationRefillingGaps(String compensationrefillinggaps) {
        underlyingNode.setProperty(COMPENSATIONREFILLINGGAPS, compensationrefillinggaps);
    }

    public String getCompensationRefillingGaps() {
        try {
            return (String) underlyingNode.getProperty(COMPENSATIONREFILLINGGAPS);

        } catch (Exception e) {
        }
        return null;
    }

    public void setHiredLabourRefillingGaps(String hiredlabourrefillinggaps) {
        underlyingNode.setProperty(HIREDLABOURREFILLINGGAPS, hiredlabourrefillinggaps);
    }

    public String getHiredLabourRefillingGaps() {
        try {
            return (String) underlyingNode.getProperty(HIREDLABOURREFILLINGGAPS);

        } catch (Exception e) {
        }
        return null;
    }

    public void setFamlabourRefillingGaps(String famlabourrefillinggaps) {
        underlyingNode.setProperty(FAMLABOURREFILLINGGAPS, famlabourrefillinggaps);
    }

    public String getFamlabourRefillingGaps() {
        try {
            return (String) underlyingNode.getProperty(FAMLABOURREFILLINGGAPS);

        } catch (Exception e) {
        }
        return null;
    }

    public void setTimeRefillingGaps(String timerefillinggaps) {
        underlyingNode.setProperty(TIMEREFILLINGGAPS, timerefillinggaps);
    }

    public String getTimeRefillingGaps() {
        try {
            return (String) underlyingNode.getProperty(TIMEREFILLINGGAPS);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoOfLabourRefillingGaps(String nooflabourrefillinggaps) {
        underlyingNode.setProperty(NOOFLABOURREFILLINGGAPS, nooflabourrefillinggaps);
    }

    public String getNoOfLabourRefillingGaps() {
        try {
            return (String) underlyingNode.getProperty(NOOFLABOURREFILLINGGAPS);

        } catch (Exception e) {
        }
        return null;
    }

    public void setRefillingProportion(String refillingproportion) {
        underlyingNode.setProperty(REFILLINGPROPORTION, refillingproportion);
    }

    public String getRefillingProportion() {
        try {
            return (String) underlyingNode.getProperty(REFILLINGPROPORTION);

        } catch (Exception e) {
        }
        return null;
    }

    public void setRefillingGapsOccurence(String refillinggapsoccurence) {
        underlyingNode.setProperty(REFILLINGGAPSOCCURENCE, refillinggapsoccurence);
    }

    public String getRefillingGapsOccurence() {
        try {
            return (String) underlyingNode.getProperty(REFILLINGGAPSOCCURENCE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setCompensationPlanting(String compensationplanting) {
        underlyingNode.setProperty(COMPENSATIONPLANTING, compensationplanting);
    }

    public String getCompensationPlanting() {
        try {
            return (String) underlyingNode.getProperty(COMPENSATIONPLANTING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setPlantingDistancePlant(String plantingdistanceplant) {
        underlyingNode.setProperty(PLANTINGDISTANCEPLANT, plantingdistanceplant);
    }

    public String getPlantingDistancePlant() {
        try {
            return (String) underlyingNode.getProperty(PLANTINGDISTANCEPLANT);

        } catch (Exception e) {
        }
        return null;
    }

    public void setPlantingDistanceRows(String plantingdistancerows) {
        underlyingNode.setProperty(PLANTINGDISTANCEROWS, plantingdistancerows);
    }

    public String getPlantingDistanceRows() {
        try {
            return (String) underlyingNode.getProperty(PLANTINGDISTANCEROWS);

        } catch (Exception e) {
        }
        return null;
    }

    public void setPlantarrangement(String plantarrangement) {
        underlyingNode.setProperty(PLANTARRANGEMENT, plantarrangement);
    }

    public String getPlantarrangement() {
        try {
            return (String) underlyingNode.getProperty(PLANTARRANGEMENT);

        } catch (Exception e) {
        }
        return null;
    }

    public void setSizeOfCuttings(String sizeofcuttings) {
        underlyingNode.setProperty(SIZEOFCUTTINGS, sizeofcuttings);
    }

    public String getSizeOfCuttings() {
        try {
            return (String) underlyingNode.getProperty(SIZEOFCUTTINGS);

        } catch (Exception e) {
        }
        return null;
    }

    public void setMonthCompletePlanting(String monthcompleteplanting) {
        underlyingNode.setProperty(MONTHCOMPLETEPLANTING, monthcompleteplanting);
    }

    public String getMonthCompletePlanting() {
        try {
            return (String) underlyingNode.getProperty(MONTHCOMPLETEPLANTING);

        } catch (Exception e) {
        }
        return null;
    }

    public void setMonthPlantingMaterialPrep(String monthplantingmaterialprep) {
        underlyingNode.setProperty(MONTHPLANTINGMATERIALPREP, monthplantingmaterialprep);
    }

    public String getMonthPlantingMaterialPrep() {
        try {
            return (String) underlyingNode.getProperty(MONTHPLANTINGMATERIALPREP);

        } catch (Exception e) {
        }
        return null;
    }

    public void setCompensationSeedBedTypePrep(String compensationseedbedtypeprep) {
        underlyingNode.setProperty(COMPENSATIONSEEDBEDTYPEPREP, compensationseedbedtypeprep);
    }

    public String getCompensationSeedBedTypePrep() {
        try {
            return (String) underlyingNode.getProperty(COMPENSATIONSEEDBEDTYPEPREP);

        } catch (Exception e) {
        }
        return null;
    }

    public void setFamLabourSeedBedTypePrep(String famlabourseedbedtypeprep) {
        underlyingNode.setProperty(FAMLABOURSEEDBEDTYPEPREP, famlabourseedbedtypeprep);
    }

    public String getFamLabourSeedBedTypePrep() {
        try {
            return (String) underlyingNode.getProperty(FAMLABOURSEEDBEDTYPEPREP);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoHiredabourSeedBedTypePrep(String nohiredabourseedbedtypeprep) {
        underlyingNode.setProperty(NOHIREDABOURSEEDBEDTYPEPREP, nohiredabourseedbedtypeprep);
    }

    public String getNoHiredabourSeedBedTypePrep() {
        try {
            return (String) underlyingNode.getProperty(NOHIREDABOURSEEDBEDTYPEPREP);

        } catch (Exception e) {
        }
        return null;
    }

    public void setTimeForSeedBedTypePrep(String timeforseedbedtypeprep) {
        underlyingNode.setProperty(TIMEFORSEEDBEDTYPEPREP, timeforseedbedtypeprep);
    }

    public String getTimeForSeedBedTypePrep() {
        try {
            return (String) underlyingNode.getProperty(TIMEFORSEEDBEDTYPEPREP);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoOfLabourSeedBedTypePrep(String nooflabourseedbedtypeprep) {
        underlyingNode.setProperty(NOOFLABOURSEEDBEDTYPEPREP, nooflabourseedbedtypeprep);
    }

    public String getNoOfLabourSeedBedTypePrep() {
        try {
            return (String) underlyingNode.getProperty(NOOFLABOURSEEDBEDTYPEPREP);

        } catch (Exception e) {
        }
        return null;
    }

    public void setSpecialSeedBedType(String specialseedbedtype) {
        underlyingNode.setProperty(SPECIALSEEDBEDTYPE, specialseedbedtype);
    }

    public String getSpecialSeedBedType() {
        try {
            return (String) underlyingNode.getProperty(SPECIALSEEDBEDTYPE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setCompensationPloughingHoe(String compensationploughinghoe) {
        underlyingNode.setProperty(COMPENSATIONPLOUGHINGHOE, compensationploughinghoe);
    }

    public String getCompensationPloughingHoe() {
        try {
            return (String) underlyingNode.getProperty(COMPENSATIONPLOUGHINGHOE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setFamilyLabourPloughingHoe(String familylabourploughinghoe) {
        underlyingNode.setProperty(FAMILYLABOURPLOUGHINGHOE, familylabourploughinghoe);
    }

    public String getFamilyLabourPloughingHoe() {
        try {
            return (String) underlyingNode.getProperty(FAMILYLABOURPLOUGHINGHOE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setHiredLabourPloughingHoe(String hiredlabourploughinghoe) {
        underlyingNode.setProperty(HIREDLABOURPLOUGHINGHOE, hiredlabourploughinghoe);
    }

    public String getHiredLabourPloughingHoe() {
        try {
            return (String) underlyingNode.getProperty(HIREDLABOURPLOUGHINGHOE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setTimeforPloughingHoe(String timeforploughinghoe) {
        underlyingNode.setProperty(TIMEFORPLOUGHINGHOE, timeforploughinghoe);
    }

    public String getTimeforPloughingHoe() {
        try {
            return (String) underlyingNode.getProperty(TIMEFORPLOUGHINGHOE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNoOfLabourHandPloughingHoe(String nooflabourhandploughinghoe) {
        underlyingNode.setProperty(NOOFLABOURHANDPLOUGHINGHOE, nooflabourhandploughinghoe);
    }

    public String getNoOfLabourHandPloughingHoe() {
        try {
            return (String) underlyingNode.getProperty(NOOFLABOURHANDPLOUGHINGHOE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setMonthOfPloughingHoe(String monthofploughinghoe) {
        underlyingNode.setProperty(MONTHOFPLOUGHINGHOE, monthofploughinghoe);
    }

    public String getMonthOfPloughingHoe() {
        try {
            return (String) underlyingNode.getProperty(MONTHOFPLOUGHINGHOE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setCostOfHarrowingMachinery(String costofharrowingmachinery) {
        underlyingNode.setProperty(COSTOFHARROWINGMACHINERY, costofharrowingmachinery);
    }

    public String getCostOfHarrowingMachinery() {
        try {
            return (String) underlyingNode.getProperty(COSTOFHARROWINGMACHINERY);

        } catch (Exception e) {
        }
        return null;
    }

    public void setMonthOfHarrowingMachinery(String monthofharrowingmachinery) {
        underlyingNode.setProperty(MONTHOFHARROWINGMACHINERY, monthofharrowingmachinery);
    }

    public String getMonthOfHarrowingMachinery() {
        try {
            return (String) underlyingNode.getProperty(MONTHOFHARROWINGMACHINERY);

        } catch (Exception e) {
        }
        return null;
    }

    public void setCostOfPloughingMachinery(String costofploughingmachinery) {
        underlyingNode.setProperty(COSTOFPLOUGHINGMACHINERY, costofploughingmachinery);
    }

    public String getCostOfPloughingMachinery() {
        try {
            return (String) underlyingNode.getProperty(COSTOFPLOUGHINGMACHINERY);

        } catch (Exception e) {
        }
        return null;
    }

    public void setMonthOfPloughingMachinery(String monthofploughingmachinery) {
        underlyingNode.setProperty(MONTHOFPLOUGHINGMACHINERY, monthofploughingmachinery);
    }

    public String getMonthOfPloughingMachinery() {
        try {
            return (String) underlyingNode.getProperty(MONTHOFPLOUGHINGMACHINERY);

        } catch (Exception e) {
        }
        return null;
    }

    public void setMethodOfLandPrepMachinery(String methodoflandprepmachinery) {
        underlyingNode.setProperty(METHODOFLANDPREPMACHINERY, methodoflandprepmachinery);
    }

    public String getMethodOfLandPrepMachinery() {
        try {
            return (String) underlyingNode.getProperty(METHODOFLANDPREPMACHINERY);

        } catch (Exception e) {
        }
        return null;
    }

    public void setMethodOfLandPrep(String methodoflandprep) {
        underlyingNode.setProperty(METHODOFLANDPREP, methodoflandprep);
    }

    public String getMethodOfLandPrep() {
        try {
            return (String) underlyingNode.getProperty(METHODOFLANDPREP);

        } catch (Exception e) {
        }
        return null;
    }

    public void setCostApplicationOfHerbicide(String costapplicationofherbicide) {
        underlyingNode.setProperty(COSTAPPLICATIONOFHERBICIDE, costapplicationofherbicide);
    }

    public String getCostApplicationOfHerbicide() {
        try {
            return (String) underlyingNode.getProperty(COSTAPPLICATIONOFHERBICIDE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setApplicationMonthOfHerbicide(String applicationmonthofherbicide) {
        underlyingNode.setProperty(APPLICATIONMONTHOFHERBICIDE, applicationmonthofherbicide);
    }

    public String getApplicationMonthOfHerbicide() {
        try {
            return (String) underlyingNode.getProperty(APPLICATIONMONTHOFHERBICIDE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setPurchaseMonthOfHerbicide(String purchasemonthofherbicide) {
        underlyingNode.setProperty(PURCHASEMONTHOFHERBICIDE, purchasemonthofherbicide);
    }

    public String getPurchaseMonthOfHerbicide() {
        try {
            return (String) underlyingNode.getProperty(PURCHASEMONTHOFHERBICIDE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setPriceofherbicide(String priceofherbicide) {
        underlyingNode.setProperty(PRICEOFHERBICIDE, priceofherbicide);
    }

    public String getPriceofherbicide() {
        try {
            return (String) underlyingNode.getProperty(PRICEOFHERBICIDE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setQuantityOfHerbicide(String quantityofherbicide) {
        underlyingNode.setProperty(QUANTITYOFHERBICIDE, quantityofherbicide);
    }

    public String getQuantityOfHerbicide() {
        try {
            return (String) underlyingNode.getProperty(QUANTITYOFHERBICIDE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setLandClearanceHerbicide(String landclearanceherbicide) {
        underlyingNode.setProperty(LANDCLEARANCEHERBICIDE, landclearanceherbicide);
    }

    public String getLandClearanceHerbicide() {
        try {
            return (String) underlyingNode.getProperty(LANDCLEARANCEHERBICIDE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setHerbicideUse(String herbicideuse) {
        underlyingNode.setProperty(HERBICIDEUSE, herbicideuse);
    }

    public String getHerbicideUse() {
        try {
            return (String) underlyingNode.getProperty(HERBICIDEUSE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setLandClearance(String landclearance) {
        underlyingNode.setProperty(LANDCLEARANCE, landclearance);
    }

    public String getLandClearance() {
        try {
            return (String) underlyingNode.getProperty(LANDCLEARANCE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setQuantityOfPlantingMaterial(String quantityofplantingmaterial) {
        underlyingNode.setProperty(QUANTITYOFPLANTINGMATERIAL, quantityofplantingmaterial);
    }

    public String getQuantityOfPlantingMaterial() {
        try {
            return (String) underlyingNode.getProperty(QUANTITYOFPLANTINGMATERIAL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setWeightOfSeed(String weightofseed) {
        underlyingNode.setProperty(WEIGHTOFSEED, weightofseed);
    }

    public String getWeightOfSeed() {
        try {
            return (String) underlyingNode.getProperty(WEIGHTOFSEED);

        } catch (Exception e) {
        }
        return null;
    }

    public void setQuantityOfBundles(String quantityofbundles) {
        underlyingNode.setProperty(QUANTITYOFBUNDLES, quantityofbundles);
    }

    public String getQuantityOfBundles() {
        try {
            return (String) underlyingNode.getProperty(QUANTITYOFBUNDLES);

        } catch (Exception e) {
        }
        return null;
    }

    public void setSourceOfPlantingMaterial(String sourceofplantingmaterial) {
        underlyingNode.setProperty(SOURCEOFPLANTINGMATERIAL, sourceofplantingmaterial);
    }

    public String getSourceOfPlantingMaterial() {
        try {
            return (String) underlyingNode.getProperty(SOURCEOFPLANTINGMATERIAL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setPurchaseOfStakes(String purchaseofstakes) {
        underlyingNode.setProperty(PURCHASEOFSTAKES, purchaseofstakes);
    }

    public String getPurchaseOfStakes() {
        try {
            return (String) underlyingNode.getProperty(PURCHASEOFSTAKES);

        } catch (Exception e) {
        }
        return null;
    }

    public void setCostPerUnit(String costperunit) {
        underlyingNode.setProperty(COSTPERUNIT, costperunit);
    }

    public String getCostPerUnit() {
        try {
            return (String) underlyingNode.getProperty(COSTPERUNIT);

        } catch (Exception e) {
        }
        return null;
    }

    public void setPaySeedMaterial(String payseedmaterial) {
        underlyingNode.setProperty(PAYSEEDMATERIAL, payseedmaterial);
    }

    public String getPaySeedMaterial() {
        try {
            return (String) underlyingNode.getProperty(PAYSEEDMATERIAL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNameOfVariety(String nameofvariety) {
        underlyingNode.setProperty(NAMEOFVARIETY, nameofvariety);
    }

    public String getNameOfVariety() {
        try {
            return (String) underlyingNode.getProperty(NAMEOFVARIETY);

        } catch (Exception e) {
        }
        return null;
    }

    public void setTypeOfVariety(String typeofvariety) {
        underlyingNode.setProperty(TYPEOFVARIETY, typeofvariety);
    }

    public String getTypeOfVariety() {
        try {
            return (String) underlyingNode.getProperty(TYPEOFVARIETY);

        } catch (Exception e) {
        }
        return null;
    }

    public void setLandRent(String landrent) {
        underlyingNode.setProperty(LANDRENT, landrent);
    }

    public String getLandRent() {
        try {
            return (String) underlyingNode.getProperty(LANDRENT);

        } catch (Exception e) {
        }
        return null;
    }

    public void setPayForLand(String payforland) {
        underlyingNode.setProperty(PAYFORLAND, payforland);
    }

    public String getPayForLand() {
        try {
            return (String) underlyingNode.getProperty(PAYFORLAND);

        } catch (Exception e) {
        }
        return null;
    }

    public void setLandSize(String landsize) {
        underlyingNode.setProperty(LANDSIZE, landsize);
    }

    public String getLandSize() {
        try {
            return (String) underlyingNode.getProperty(LANDSIZE);

        } catch (Exception e) {
        }
        return null;
    }

    public Operations(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }

}
