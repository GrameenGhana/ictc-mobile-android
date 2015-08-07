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
