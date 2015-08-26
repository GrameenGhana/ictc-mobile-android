/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.Operations;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import com.grameenfoundation.ictc.utils.ParentNode;
import com.grameenfoundation.ictc.wrapper.OperationsWrapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

/**
 *
 * @author Joseph George Davis
 * @date Jul 21, 2015 7:47:27 PM
 * description:
 */
public class OperationsModel {
    
    
    Logger log = Logger.getLogger(OperationsModel.class.getName());
    Node operationParent;
    
    
     public Operations createOperation(OperationsWrapper op)
    {
        boolean created = true;
           
        try(Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            
            Node opNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.FARM_OPERATION);
            
            Operations ops = new Operations(opNode);
            
            
            if(null == ops)
            {
                log.info("operation is invalid");
                created = false;
            }
            else
            {
              operationParent  = ParentNode.OperationsParentNode();
              
              ops.setLandSize(OperationsWrapper.getLandSize());
              ops.setLandRent(OperationsWrapper.getLandRent());
              ops.setApplicationMonthOfHerbicide(OperationsWrapper.getApplicationMonthOfHerbicide());
              ops.setApplicationOfTopdressFertilizer(OperationsWrapper.getApplicationOfTopdressFertilizer());
              ops.setCompensationPlanting(OperationsWrapper.getCompensationPlanting());
              ops.setCompensationPloughingHoe(OperationsWrapper.getCompensationPloughingHoe());
              ops.setCompensationRefillingGaps(OperationsWrapper.getCompensationRefillingGaps());
              ops.setCompensationSeedBedTypePrep(OperationsWrapper.getCompensationSeedBedTypePrep());
              ops.setCostApplicationOfHerbicide(OperationsWrapper.getCostApplicationOfHerbicide());
              ops.setCostHiredLabourFifthWeedControl(op.getCostHiredLabourFifthWeedControl());
              ops.setCostHiredLabourFourthWeedControl(op.getCostHiredLabourFourthWeedControl());
              ops.setCostHiredLabourManualWeedControl(op.getCostHiredLabourManualWeedControl());
              ops.setCostHiredLabourSecondManualWeedControl(op.getCostHiredLabourSecondManualWeedControl());
              ops.setCostHiredLabourThirdManualWeedControl(op.getCostHiredLabourThirdManualWeedControl());
              ops.setCostHiredLabourTopDressFertilizer(op.getCostHiredLabourTopDressFertilizer());
              ops.setCostOfHarrowingMachinery(OperationsWrapper.getCostOfHarrowingMachinery());
              ops.setCostOfHiredLabourBasal(OperationsWrapper.getCostOfHiredLabourBasal());
              ops.setCostOfPloughingMachinery(OperationsWrapper.getCostOfPloughingMachinery());
              ops.setCostPerUnit(OperationsWrapper.getCostPerUnit());
              ops.setCostPerUnitBasalFertilizer(OperationsWrapper.getCostPerUnitBasalFertilizer());
              ops.setEntrepreneurship(op.getEntrepreneurship());
              ops.setFamLabourBasalFertilizer(OperationsWrapper.getFamLabourBasalFertilizer());
              
              
              
              
              
              
              
              
              
              
              
              
             
            
              
              
              operationParent.createRelationshipTo(opNode,ICTCRelationshipTypes.FARM_OPERATION);
              
              
              log.log(Level.INFO, "new node created {0}", ops.getUnderlyingNode().getId());
              trx.success();
              return ops;
              
            }
           
        
            
            
        } catch (Exception e) {
            
            created = false;
            log.severe("Creation of Farmer Failed");
            e.printStackTrace();
        }
        
        return null;
    }
     
  
   public Operations getUserOperations(String userId) {
        String q = "Start root=node(0) "
                + " MATCH root-[:" + ICTCRelationshipTypes.ENTITY + "]->parent-[:" + ICTCRelationshipTypes.FARMER + "]->f-[:"+
                ICTCRelationshipTypes.HAS_FARM_OPERATION+"]->p"
                + " where f.Id="+ "'" + userId + "'"
                + " return p";

        System.out.println("Query " + q);
        try {
            Node node = Neo4jServices.executeCypherQuerySingleResult(q, "p");
            if (null != node) {
                return new Operations(node);
            }
        } catch (Exception e) {
            System.out.println("Unable to Find Farm managent");
        }

        return null;
    }
   
     
     

}
