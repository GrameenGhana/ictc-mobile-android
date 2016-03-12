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
 * @date Oct 1, 2015 3:19:37 PM
 * description:
 */
public class Profiling extends Status implements GeneralInterface {

   
    Node underlyingNode = null;

    public static String FARMRECORDKEEPINGSTATUS = "farmrecordkeepingstatus";
    public static String FBOMEMBERSHIP = "fbomembership";
    public static String FBONAME = "fboname";
    public static String INNOVATIVENESSBYTRYING = "innovativenessbytrying";
    public static String NAMETRUSTEDMENTOR = "nametrustedmentor";
    public static String OPERATEBANKACCOUNT = "operatebankaccount";
    public static String POSTHARVESTLOSSES = "postharvestlosses";
    public static String PRODUCESOLDPROPORTION = "producesoldproportion";
    public static String REGFAMILYLABOR_NO = " Regfamilylabor_No";
    public static String RISKDISPOSITIONBORROW = "riskdispositionborrow";
    public static String SOILFERTILITYPRACTICES = "soilfertilitypractices";
    public static String SECOND_CONSTRAINT_AFTER_FARM_PLANNING="Second_constraint_after_farm_planning";
    public static String SECOND_CONSTRAINT_AFTER_MARKETING="Second_constraint_after_marketing";
    public static String SECOND_CONSTRAINT_AFTER_POST_HARVEST="Second_constraint_after_post_harvest";
    public static String MAIN_CONSTRAINT_FARMPLANNING="main_constraint_farmplanning";
    public static String MAIN_CONSTRAINT_FIELD_PRODUCTION="main_constraint_field_production";
    public static String MAIN_CONSTRAINT_GENERAL="main_constraint_general";
    public static String MAIN_CONSTRAINT_MARKETING="main_constraint_marketing";
    public static String MAIN_CONSTRAINT_POST_HARVEST="main_constraint_post_harvest";
    public static String OTHER_CONSTRAINT_FARM_PLANNING="other_constraint_farm_planning";
    public static String OTHER_CONSTRAINT_FIELD_PRODUCTION="other_constraint_field_production";
    public static String OTHER_CONSTRAINT_MARKETING="other_constraint_marketing";
    public static String OTHER_CONSTRAINT_POST_HARVEST="other_constraint_post_harvest";
    public static String SECOND_CONSTRAINT_AFTER_FIELD_PRODUCTION="Second_constraint_after_field_production";
    
    
public void setSecond_constraint_after_field_production(String second_constraint_after_field_production) {
underlyingNode.setProperty(SECOND_CONSTRAINT_AFTER_FIELD_PRODUCTION,second_constraint_after_field_production);
}

public String getSecond_constraint_after_field_production(){
          try {
          return (String) underlyingNode.getProperty(SECOND_CONSTRAINT_AFTER_FIELD_PRODUCTION);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setOther_constraint_post_harvest(String other_constraint_post_harvest) {
underlyingNode.setProperty(OTHER_CONSTRAINT_POST_HARVEST,other_constraint_post_harvest);
}

public String getOther_constraint_post_harvest(){
          try {
          return (String) underlyingNode.getProperty(OTHER_CONSTRAINT_POST_HARVEST);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setOther_constraint_marketing(String other_constraint_marketing) {
underlyingNode.setProperty(OTHER_CONSTRAINT_MARKETING,other_constraint_marketing);
}

public String getOther_constraint_marketing(){
          try {
          return (String) underlyingNode.getProperty(OTHER_CONSTRAINT_MARKETING);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setOther_constraint_field_production(String other_constraint_field_production) {
underlyingNode.setProperty(OTHER_CONSTRAINT_FIELD_PRODUCTION,other_constraint_field_production);
}

public String getOther_constraint_field_production(){
          try {
          return (String) underlyingNode.getProperty(OTHER_CONSTRAINT_FIELD_PRODUCTION);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setOther_constraint_farm_planning(String other_constraint_farm_planning) {
underlyingNode.setProperty(OTHER_CONSTRAINT_FARM_PLANNING,other_constraint_farm_planning);
}

public String getOther_constraint_farm_planning(){
          try {
          return (String) underlyingNode.getProperty(OTHER_CONSTRAINT_FARM_PLANNING);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setMain_constraint_post_harvest(String main_constraint_post_harvest) {
underlyingNode.setProperty(MAIN_CONSTRAINT_POST_HARVEST,main_constraint_post_harvest);
}

public String getMain_constraint_post_harvest(){
          try {
          return (String) underlyingNode.getProperty(MAIN_CONSTRAINT_POST_HARVEST);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setMain_constraint_marketing(String main_constraint_marketing) {
underlyingNode.setProperty(MAIN_CONSTRAINT_MARKETING,main_constraint_marketing);
}

public String getMain_constraint_marketing(){
          try {
          return (String) underlyingNode.getProperty(MAIN_CONSTRAINT_MARKETING);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setMain_constraint_general(String main_constraint_general) {
underlyingNode.setProperty(MAIN_CONSTRAINT_GENERAL,main_constraint_general);
}

public String getMain_constraint_general(){
          try {
          return (String) underlyingNode.getProperty(MAIN_CONSTRAINT_GENERAL);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setMain_constraint_field_production(String main_constraint_field_production) {
underlyingNode.setProperty(MAIN_CONSTRAINT_FIELD_PRODUCTION,main_constraint_field_production);
}

public String getMain_constraint_field_production(){
          try {
          return (String) underlyingNode.getProperty(MAIN_CONSTRAINT_FIELD_PRODUCTION);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setMain_constraint_farmplanning(String main_constraint_farmplanning) {
underlyingNode.setProperty(MAIN_CONSTRAINT_FARMPLANNING,main_constraint_farmplanning);
}

public String getMain_constraint_farmplanning(){
          try {
          return (String) underlyingNode.getProperty(MAIN_CONSTRAINT_FARMPLANNING);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setSecond_constraint_after_post_harvest(String second_constraint_after_post_harvest) {
underlyingNode.setProperty(SECOND_CONSTRAINT_AFTER_POST_HARVEST,second_constraint_after_post_harvest);
}

public String getSecond_constraint_after_post_harvest(){
          try {
          return (String) underlyingNode.getProperty(SECOND_CONSTRAINT_AFTER_POST_HARVEST);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setSecond_constraint_after_marketing(String second_constraint_after_marketing) {
underlyingNode.setProperty(SECOND_CONSTRAINT_AFTER_MARKETING,second_constraint_after_marketing);
}

public String getSecond_constraint_after_marketing(){
          try {
          return (String) underlyingNode.getProperty(SECOND_CONSTRAINT_AFTER_MARKETING);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setSecond_constraint_after_farm_planning(String second_constraint_after_farm_planning) {
underlyingNode.setProperty(SECOND_CONSTRAINT_AFTER_FARM_PLANNING,second_constraint_after_farm_planning);
}

public String getSecond_constraint_after_farm_planning(){
          try {
          return (String) underlyingNode.getProperty(SECOND_CONSTRAINT_AFTER_FARM_PLANNING);

        } catch (Exception e) {
        }
        return null;
    }
    
     public Profiling(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }


    public void setSoilfertilitypractices(String soilfertilitypractices) {
        underlyingNode.setProperty(SOILFERTILITYPRACTICES, soilfertilitypractices);
    }

    public String getSoilfertilitypractices() {
        try {
            return (String) underlyingNode.getProperty(SOILFERTILITYPRACTICES);

        } catch (Exception e) {
        }
        return null;
    }

    public void setRiskdispositionborrow(String riskdispositionborrow) {
        underlyingNode.setProperty(RISKDISPOSITIONBORROW, riskdispositionborrow);
    }

public String getRiskdispositionborrow(){
          try {
          return (String) underlyingNode.getProperty(RISKDISPOSITIONBORROW);

        } catch (Exception e) {
        }
        return null;
    }

 
 
 
 
public void setRegfamilylabor_No(String regfamilylabor_no) {
underlyingNode.setProperty(REGFAMILYLABOR_NO,regfamilylabor_no);
}

public String getRegfamilylabor_No(){
          try {
          return (String) underlyingNode.getProperty(REGFAMILYLABOR_NO);

        } catch (Exception e) {
        }
        return null;
    }
 
 
 
public void setProducesoldproportion(String producesoldproportion) {
underlyingNode.setProperty(PRODUCESOLDPROPORTION,producesoldproportion);
}

public String getProducesoldproportion(){
          try {
          return (String) underlyingNode.getProperty(PRODUCESOLDPROPORTION);

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
 
 
public void setOperatebankaccount(String operatebankaccount) {
underlyingNode.setProperty(OPERATEBANKACCOUNT,operatebankaccount);
}

public String getOperatebankaccount(){
          try {
          return (String) underlyingNode.getProperty(OPERATEBANKACCOUNT);

        } catch (Exception e) {
        }
        return null;
    }

 
 
public void setNametrustedmentor(String nametrustedmentor) {
underlyingNode.setProperty(NAMETRUSTEDMENTOR,nametrustedmentor);
}

public String getNametrustedmentor(){
          try {
          return (String) underlyingNode.getProperty(NAMETRUSTEDMENTOR);

        } catch (Exception e) {
        }
        return null;
    }
 
 
 
public void setInnovativenessbytrying(String innovativenessbytrying) {
underlyingNode.setProperty(INNOVATIVENESSBYTRYING,innovativenessbytrying);
}

public String getInnovativenessbytrying(){
          try {
          return (String) underlyingNode.getProperty(INNOVATIVENESSBYTRYING);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setFboname(String fboname) {
underlyingNode.setProperty(FBONAME,fboname);
}

public String getFboname(){
          try {
          return (String) underlyingNode.getProperty(FBONAME);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setFbomembership(String fbomembership) {
underlyingNode.setProperty(FBOMEMBERSHIP,fbomembership);
}

public String getFbomembership(){
          try {
          return (String) underlyingNode.getProperty(FBOMEMBERSHIP);

        } catch (Exception e) {
        }
        return null;
    }
 
 
 
public void setFarmrecordkeepingstatus(String farmrecordkeepingstatus) {
underlyingNode.setProperty(FARMRECORDKEEPINGSTATUS,farmrecordkeepingstatus);
}

public String getFarmrecordkeepingstatus(){
          try {
          return (String) underlyingNode.getProperty(FARMRECORDKEEPINGSTATUS);

        } catch (Exception e) {
        }
        return null;
    }
    
    
    
    
}
