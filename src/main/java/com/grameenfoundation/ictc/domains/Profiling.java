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
    public static String REGFAMILYLABOR_NO = "regfamilylabor_no";
    public static String RISKDISPOSITIONBORROW = "riskdispositionborrow";
    public static String SOILFERTILITYPRACTICES = "soilfertilitypractices";
    
    
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
