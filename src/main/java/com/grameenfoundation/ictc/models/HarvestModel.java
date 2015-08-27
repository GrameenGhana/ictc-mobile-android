/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.Harvest;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import com.grameenfoundation.ictc.utils.ParentNode;
import com.grameenfoundation.ictc.wrapper.HarvestWrapper;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

/**
 *
 * @author Joseph George Davis
 * @date Jul 22, 2015 9:55:39 AM
 * description:
 */
public class HarvestModel {

    
     Logger log = Logger.getLogger( HarvestModel.class.getName());
     Node HarvestParent;
    
    public Harvest createFM(HarvestWrapper hw)
    {
        boolean created = true;
           
        try(Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            
            Node hvNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.HARVEST);
            
             Harvest hv  = new Harvest(hvNode);
            
            if(null == hv)
            {
                log.info("harvest is invalid");
                created = false;
            }
            else
            {
              HarvestParent  = ParentNode.HarvestParentNode();
              
              hv.setNoFamilyLabour(hw.getNoFamilyLabour());
              hv.setTimeCropReadyToHarvest(hw.getTimeCropReadyToHarvest());
              hv.setTimeCropHarvested(hw.getTimeCropHarvested());
              hv.setTimeCompletionHarvest(hw.getTimeCompletionHarvest());
              hv.setNoHiredLabour(hw.getNoHiredLabour());
              hv.setYieldPerAcre(hw.getYieldPerAcre());
              hv.setCostOfHiredLabour(hw.getCostOfHiredLabour());
              hv.setLastModifiedDate(new Date());
              
              
              
              HarvestParent.createRelationshipTo(hvNode,ICTCRelationshipTypes.HARVEST);
              
              log.log(Level.INFO, "new node created {0}", hv.getUnderlyingNode().getId());
              trx.success();
              return hv;
              
            }
           
        
            
            
        } catch (Exception e) {
            
            created = false;
            log.severe("Creation of Farmer Failed");
            e.printStackTrace();
        }
        
        return null;
    }
    
    
    
    
    public Harvest getHarvest(String field, String value) {
        String q = "Start root=node(0) "
                + " MATCH root-[:" + ICTCRelationshipTypes.ENTITY + "]->parent-[:" + ICTCRelationshipTypes.HARVEST + "]->p"
                + " where p." + field + "='" + value + "'"
                + " return p";

        System.out.println("Query " + q);
        try {
            Node node = Neo4jServices.executeCypherQuerySingleResult(q, "p");
            if (null != node) {
                return new Harvest(node);
            }
        } catch (Exception e) {
            System.out.println("Unable to Find geofence");
        }

        return null;
    }
    
    
    public Harvest getUserHarvest(String userId) {
        String q = "Start root=node(0) "
                + " MATCH root-[:" + ICTCRelationshipTypes.ENTITY + "]->parent-[:" + ICTCRelationshipTypes.FARMER + "]->f-[:"+
                ICTCRelationshipTypes.HAS_HARVEST+"]->p"
                + " where f.Id="+ "'" + userId + "'"
                + " return p";

        System.out.println("Query " + q);
        try {
            Node node = Neo4jServices.executeCypherQuerySingleResult(q, "p");
            if (null != node) {
                return new Harvest(node);
            }
        } catch (Exception e) {
            System.out.println("Unable to Find Farm managent");
        }

        return null;
    }
    
}
