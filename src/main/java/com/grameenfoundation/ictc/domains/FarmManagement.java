/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.domains;

import com.grameenfoundation.ictc.domain.commons.GeneralInterface;
import com.grameenfoundation.ictc.domain.commons.Status;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Joseph George Davis
 * @date Jul 17, 2015 10:53:19 AM
 * description:
 */
public class FarmManagement extends Status implements GeneralInterface{
    
   public static String familyLabor = "familylabor";
   public static String fboMember ="fbomember";
   public static String fboName = "fboname";
   public static String referenceLeadFarmer ="referenceleadfarmer";
   public static String bankAccount = "bankaccount";
   public static String farmRecordKeeping = "farmrecordkeeping";
   public static String productionObjective ="productionobjective";
   public static String dispostionToRisk ="dispositiontorisk";
   public static String entrepreneurship = "entrepreneurship";
   public static String labourUse="labourUse";
   
   Node underlyingNode;

    public String getLabourUse() {
      try {
            return (String) underlyingNode.getProperty(labourUse);

        } catch (Exception e) {
        }
        return null;
    }

    public  void setLabourUse(String labourUse) {
       underlyingNode.setProperty(this.labourUse,labourUse);
    }
   

    public  String getFamilyLabor() {
        try {
            return (String) underlyingNode.getProperty(familyLabor);

        } catch (Exception e) {
        }
        return null;
    }

    public  void setFamilyLabor(String familyLabor) {
       underlyingNode.setProperty(this.familyLabor,familyLabor);
    }

    public  String getFboMember() {
         try {
            return (String) underlyingNode.getProperty(fboMember);

        } catch (Exception e) {
        }
        return null;
    }

    public  void setFboMember(String fboMember) {
       underlyingNode.setProperty(this.fboMember,fboMember);
    }

    public String getFboName() {
        try {
            return (String) underlyingNode.getProperty(fboName);

        } catch (Exception e) {
        }
        return null;
    }

    public  void setFboName(String fboName) {
        underlyingNode.setProperty(this.fboName,fboName);
    }

    public  String getReferenceLeadFarmer() {
        try {
            return (String) underlyingNode.getProperty(referenceLeadFarmer);

        } catch (Exception e) {
        }
        return null;
    }

    public  void setReferenceLeadFarmer(String referenceLeadFarmer) {
        underlyingNode.setProperty(this.referenceLeadFarmer,referenceLeadFarmer);
    }

    public  String getBankAccount() {
         try {
            return (String) underlyingNode.getProperty(bankAccount);

        } catch (Exception e) {
        }
        return null;
    }

    public  void setBankAccount(String bankAccount) {
         underlyingNode.setProperty(this.bankAccount,bankAccount);
    }

    public  String getFarmRecordKeeping() {
        try {
            return (String) underlyingNode.getProperty(farmRecordKeeping);

        } catch (Exception e) {
        }
        return null;
    }

    public  void setFarmRecordKeeping(String farmRecordKeeping) {
        underlyingNode.setProperty(this.farmRecordKeeping,farmRecordKeeping);
    }

    public  String getProductionObjective() {
        try {
            return (String) underlyingNode.getProperty(productionObjective);

        } catch (Exception e) {
        }
        return null;
    }

    public  void setProductionObjective(String productionObjective) {
        underlyingNode.setProperty(this.productionObjective,productionObjective);
    }

    public  String getDispostionToRisk() {
         try {
            return (String) underlyingNode.getProperty(dispostionToRisk);

        } catch (Exception e) {
        }
        return null;
    }

    public  void setDispostionToRisk(String dispostionToRisk) {
        underlyingNode.setProperty(this.dispostionToRisk,dispostionToRisk);
    }

    public  String getEntrepreneurship() {
         try {
            return (String) underlyingNode.getProperty(entrepreneurship);

        } catch (Exception e) {
        }
        return null;
    }

    public  void setEntrepreneurship(String entrepreneurship) {
          underlyingNode.setProperty(this.entrepreneurship,entrepreneurship);
    }

    public FarmManagement(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }
   
   
   

}
