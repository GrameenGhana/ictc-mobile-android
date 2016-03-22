/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.TechnicalNeed;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import com.grameenfoundation.ictc.utils.ParentNode;
import com.grameenfoundation.ictc.wrapper.TechnicalNeedsWrapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

/**
 *
 * @author Joseph George Davis
 * @date Jul 23, 2015 10:14:40 AM
 * description:
 */
public class TechnicalNeedsModel {
    
    
     Logger log = Logger.getLogger(TechnicalNeedsModel.class.getName());
     Node TechNeedsParent;
    
    public TechnicalNeed createTechNeeds(TechnicalNeedsWrapper tech)
    {
        boolean created = true;
           
        try(Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            
            Node techNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.TECHNICAL_NEEDS);
            
             TechnicalNeed techNeed = new TechnicalNeed(techNode);
            
            if(null == tech)
            {
                log.info("Biodata is invalid");
                created = false;
            }
            else
            {
              TechNeedsParent  = ParentNode.TechNeedParentNode();
              
             
        
              techNeed.setCropEstablishment(tech.getCropEstablishment());
              techNeed.setCropVarietyAndSeed(tech.getCropVarietyAndSeed());
              techNeed.setFarmPlanning(tech.getFarmPlanning());
              techNeed.setHarvestAndPostHarvest(tech.getFarmPlanning());
              techNeed.setIntegratedSoilFertilityManagement(tech.getIntegratedSoilFertilityManagement());
              techNeed.setWeedControl(tech.getWeedControl());
              
              
             TechNeedsParent.createRelationshipTo(techNode,ICTCRelationshipTypes.TECHNICAL_NEED);
              
              log.log(Level.INFO, "new node created {0}", techNeed.getUnderlyingNode().getId());
              trx.success();
              
              return techNeed;
            }
           
        
            
            
        } catch (Exception e) {
            
            created = false;
            log.severe("Creation of Farmer Failed");
            e.printStackTrace();
        }
        
        return null;
    }
    
    
       public TechnicalNeed getTechnicalNeed(String field, String value) {
//        String q = "Start root=node(0) "
//                + " MATCH root-[:" + ICTCRelationshipTypes.ENTITY + "]->parent-[:" + ICTCRelationshipTypes.FARMER + "]->f-[:"+ICTCRelationshipTypes.HAS_TECHNEEDS+
//                "]->p"
//                + " where f." + field + "='" + value + "'"
//                + " return p";
         String q = "match (f:FARMER)-[:"+ICTCRelationshipTypes.HAS_TECHNEEDS+"]->p"+ 
                " where f." + field + "='" + value + "'"
                + " return p";
        

        System.out.println("Query " + q);
        try {
            Node node = Neo4jServices.executeCypherQuerySingleResult(q, "p");
            if (null != node) {
                return new TechnicalNeed(node);
            }
        } catch (Exception e) {
            System.out.println("Unable to Find Technical Need");
        }

        return null;
    }
    
    
    

}
