/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.PostHarvest;
import com.grameenfoundation.ictc.domains.PostHarvest2;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import com.grameenfoundation.ictc.utils.ParentNode;
import com.grameenfoundation.ictc.wrapper.PostHarvestWrapper;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

/**
 *
 * @author Joseph George Davis
 * @date Jul 22, 2015 9:11:02 PM
 * description:
 */
public class PostHarvestModel {
    
     Logger log = Logger.getLogger( PostHarvestModel.class.getName());
     Node PostHarvestParent;
    
    public PostHarvest createPostHarvest(PostHarvestWrapper ph)
    {
        boolean created = true;
           
        try(Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            
            Node phNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.POSTHARVEST);
            
             PostHarvest phv  = new PostHarvest(phNode);
            
            if(null == ph)
            {
                log.info("harvest is invalid");
                created = false;
            }
            else
            {
             PostHarvestParent  = ParentNode.PostHarvestParentNode();
             
             phv.setApplicationRateOfStorageChemical(ph.getApplicationRateOfStorageChemical());
             phv.setCostMachineThreshing(ph.getCostMachineThreshing());
             phv.setCostMachineWinnowing(ph.getCostMachineWinnowing());
             phv.setCostOFHiredLabourBagging(ph.getCostOfHiredLabour());
             phv.setCostOfHiredLabour(ph.getCostOfHiredLabour());
             phv.setCostOfHiredLabourDehuskingPeeling(ph.getCostOfHiredLabourDehuskingPeeling());
             phv.setCostOfHiredLabourDrying(ph.getCostOfHiredLabourDrying());
             phv.setCostOfHiredLabourThreshing(ph.getCostOfHiredLabourThreshing());
             phv.setCostOfHiredLabourWinnowing(ph.getCostOfHiredLabourWinnowing());
             phv.setCostPerUnitOfBags(ph.getCostPerUnitOfBags());
             phv.setCostPerUnitOfStorageChemical(ph.getCostPerUnitOfStorageChemical());
             phv.setMethodManualThreshing(ph.getMethodManualThreshing());
             phv.setMethodOfDrying(ph.getMethodOfDrying());
             phv.setMethodOfDryingGrain(ph.getMethodOfDryingGrain());
             phv.setMethodOfProcessing(ph.getMethodOfProcessing());
             phv.setMethodOfThreshing(ph.getMethodOfThreshing());
             phv.setMethodOfWinnowing(ph.getMethodOfWinnowing());
             phv.setNoFamLabourBagging(ph.getNoFamLabourBagging());
             phv.setNoFamLabourDehuskingPeeling(ph.getNoFamLabourDehuskingPeeling());
             phv.setNoHiredLabourDrying(ph.getNoFamLabourDrying());
             phv.setNoFamLabourDryingGrain(ph.getNoFamLabourDryingGrain());
             phv.setNoFamLabourWinnowing(ph.getNoHiredLabourWinnowing());
             phv.setNoFamLabourtThreshing(ph.getNoFamLabourtThreshing());
             phv.setNoLabourBagging(ph.getNoLabourBagging());
             phv.setNoLabourDehuskingPeelingTotal(ph.getNoLabourDehuskingPeelingTotal());
             phv.setNoLabourDryingGrainTotal(ph.getNoLabourDryingGrainTotal());
             phv.setNoLabourDryingTotal(ph.getNoLabourDryingTotal());
             phv.setNoLabourThreshingTotal(ph.getNoLabourThreshingTotal());
             phv.setNoLabourWinnowingTotal(ph.getNoLabourWinnowingTotal());
             phv.setNoOfStorageBags(ph.getNoOfStorageBags());
             phv.setNoUnitStorageChemical(ph.getNoUnitStorageChemical());
             phv.setPeelingDate(ph.getPeelingDate());
             phv.setPortionHarvestProcessed(ph.getPeelingDate());
             phv.setTimeCompletionBagging(ph.getTimeCompletionBagging());
             phv.setTimeCompletionDehuskingPeeling(ph.getTimeCompletionDehuskingPeeling());
             phv.setTimeCompletionDrying(ph.getTimeCompletionDrying());
             phv.setTimeCompletionDryingGrain(ph.getTimeCompletionDryingGrain());
             phv.setTimeCompletionWinnowing(ph.getTimeCompletionWinnowing());
             phv.setTimeCompletionThreshing(ph.getTimeCompletionThreshing());
             phv.setTypeOfBagsUsedStoringProduce(ph.getTypeOfBagsUsedStoringProduce());
             phv.setTypeOfMachineUsed(ph.getTypeOfMachineUsed());
             phv.setTypeOfMachineWinnowing(ph.getTypeOfMachineWinnowing());
             phv.setTypeOfStorageChemical(ph.getTypeOfStorageChemical());
             phv.setLastModifiedDate(new Date());
            
              
             
              
              
              
             PostHarvestParent.createRelationshipTo(phNode,ICTCRelationshipTypes.POST_HARVEST);
              
              log.log(Level.INFO, "new node created {0}", phv.getUnderlyingNode().getId());
              trx.success();
              return phv;
              
            }
           
        
            
            
        } catch (Exception e) {
            
            created = false;
            log.severe("Creation of Farmer Failed");
            e.printStackTrace();
        }
        
        return null;
    }
    
    
       public PostHarvest2 getPostHarvest(String field, String value) {
        String q = "Start root=node(0) "
                + " MATCH root-[:" + ICTCRelationshipTypes.ENTITY + "]->parent-[:" + ICTCRelationshipTypes.FARMER + "]->f-[:"+ICTCRelationshipTypes.HAS_POSTHARVEST+
                "]->p"
                + " where f." + field + "='" + value + "'"
                + " return p";

        System.out.println("Query " + q);
        try {
            Node node = Neo4jServices.executeCypherQuerySingleResult(q, "p");
            if (null != node) {
                return new PostHarvest2(node);
            }
        } catch (Exception e) {
            System.out.println("Unable to Find geofence");
        }

        return null;
    }
    
         public boolean PostHarvestToUpdate(PostHarvest2 p, Node update) {
        boolean created = false;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            System.out.println("biodata :" + p.getUnderlyingNode().getId());
            if (null != p) {

               p.setUpdate(update);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

}
