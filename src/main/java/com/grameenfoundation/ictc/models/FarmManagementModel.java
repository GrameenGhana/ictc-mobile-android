/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.FarmManagement;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.ParentNode;
import com.grameenfoundation.ictc.wrapper.FarmManagementWrapper;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

/**
 *
 * @author Joseph George Davis
 * @date Jul 17, 2015 12:06:00 PM
 * description:
 */
public class FarmManagementModel {
    
    
    
     Logger log = Logger.getLogger(FarmManagementModel.class.getName());
     Node ManageParent;
    
    public FarmManagement createFM(FarmManagementWrapper fm)
    {
        boolean created = true;
           
        try(Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            
            Node fmNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.FARM_MANAGEMENT);
            
             FarmManagement f  = new FarmManagement(fmNode);
            
            if(null == fm)
            {
                log.info("farm management is invalid");
                created = false;
            }
            else
            {
              ManageParent  = ParentNode.FMParentNode();
              
             
              f.setFamilyLabor(fm.getFamilyLabor());
              f.setFboMember(fm.getFboMember());
              f.setFboName(fm.getFboName());
              f.setReferenceLeadFarmer(fm.getReferenceLeadFarmer());
              f.setBankAccount(fm.getBankAccount());
              f.setFarmRecordKeeping(fm.getFarmRecordKeeping());
              f.setProductionObjective(fm.getProductionObjective());
              f.setDispostionToRisk(fm.getDispostionToRisk());
              f.setEntrepreneurship(fm.getEntrepreneurship());
              f.setLabourUse(fm.getLabourUse());
              f.setLastModifiedDate(new Date());
              
              
              ManageParent.createRelationshipTo(fmNode,ICTCRelationshipTypes.FARM_MANAGEMENT);
              
              log.log(Level.INFO, "new node created {0}", f.getUnderlyingNode().getId());
              trx.success();
              return f;
              
            }
           
        
            
            
        } catch (Exception e) {
            
            created = false;
            log.severe("Creation of Farmer Failed");
            e.printStackTrace();
        }
        
        return null;
    }
    
    
    

}
