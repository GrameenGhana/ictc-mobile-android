/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.Marketing;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.ParentNode;
import com.grameenfoundation.ictc.wrapper.MarketingWrapper;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

/**
 *
 * @author Joseph George Davis
 * @date Jul 23, 2015 9:56:44 AM
 * description:
 */
public class MarketingModel {
    
    

 Logger log = Logger.getLogger(MarketingModel.class.getName());
     Node MarketingParent;
    
    public Marketing  createMarketing(MarketingWrapper mk)
    {
        boolean created = true;
           
        try(Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            
            Node mkNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.MARKETING);
            
            Marketing mrk  = new Marketing(mkNode);
            
            if(null == mk)
            {
                log.info("storage is invalid");
                created = false;
            }
            else
            {
              MarketingParent  = ParentNode.MarketingParentNode();
              
              mrk.setMainPointOfContact(mk.getMainPointOfContact());
              mrk.setMonthFinalBatchSold(mk.getMonthFinalBatchSold());
              mrk.setMonthLastBatchDriedChipChunksSold(mk.getMonthLastBatchDriedChipChunksSold());
              mrk.setMonthMostDriedChipsChunksSold(mk.getMonthMostDriedChipsChunksSold());
              mrk.setMonthMostHarvestProduceSold(mk.getMonthMostHarvestProduceSold());
              mrk.setMonthSellingBegins(mk.getMonthSellingBegins());
              mrk.setMonthSellingDriedChipChicks(mk.getMonthSellingDriedChipChicks());
              mrk.setPriceFinalBatchDriedChipsChunksSold(mk.getPriceFinalBatchDriedChipsChunksSold());
              mrk.setPriceFinalBatchSold(mk.getPriceFinalBatchSold());
              mrk.setPriceMostDriedChipsChunksSold(mk.getPriceMostDriedChipsChunksSold());
              mrk.setPriceFinalBatchSold(mk.getPriceFinalBatchSold());
              mrk.setPriceFirstDriedChipChunk(mk.getPriceFirstDriedChipChunk());
              mrk.setPriceMostDriedChipsChunksSold(mk.getPriceMostDriedChipsChunksSold());
              mrk.setPriceMostHarvestProduceSold(mk.getPriceMostHarvestProduceSold());
              mrk.setPriceOfFirstHarvestProduce(mk.getPriceOfFirstHarvestProduce());
              mrk.setLastModifiedDate(new Date());
              
              
              MarketingParent.createRelationshipTo(mkNode,ICTCRelationshipTypes.MARKETING);
              
              log.log(Level.INFO, "new node created. {0}", mrk.getUnderlyingNode().getId());
              trx.success();
              return mrk;
              
            }
           
        
            
            
        } catch (Exception e) {
            
            created = false;
            log.severe("Creation of Farmer Failed");
            e.printStackTrace();
        }
        
        return null;
    }
}
