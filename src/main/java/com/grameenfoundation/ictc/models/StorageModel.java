/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.Storage;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.ParentNode;
import com.grameenfoundation.ictc.wrapper.StorageWrapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

/**
 *
 * @author Joseph George Davis
 * @date Jul 23, 2015 9:41:29 AM
 * description:
 */
public class StorageModel {
    
    
    
     Logger log = Logger.getLogger( HarvestModel.class.getName());
     Node StorageParent;
    
    public Storage  createFM(StorageWrapper st)
    {
        boolean created = true;
           
        try(Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            
            Node stNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.STORAGE);
            
            Storage stg  = new Storage(stNode);
            
            if(null == st)
            {
                log.info("storage is invalid");
                created = false;
            }
            else
            {
              StorageParent  = ParentNode.StorageParentNode();
              
             stg.setBasisForCharging(st.getBasisForCharging());
             stg.setChargeStorageServices(st.getChargeStorageServices());
             stg.setCostPerUnitOfStorage(st.getCostPerUnitOfStorage());
             stg.setOwnershipOfStorage(st.getOwnershipOfStorage());
             stg.setPostHarvestLosses(st.getPostHarvestLosses());
             stg.setQntyUserPerUnitProduceStorageChemical(st.getQntyUserPerUnitProduceStorageChemical());
             stg.setTypeOfChemicalStorage(st.getTypeOfChemicalStorage());
             stg.setTypeOfStorageStructure(st.getTypeOfStorageStructure());
             stg.setUseOfChemicalStorage(st.getUseOfChemicalStorage());
              
              
              
              StorageParent.createRelationshipTo(stNode,ICTCRelationshipTypes.HARVEST);
              
              log.log(Level.INFO, "new node created. {0}", stg.getUnderlyingNode().getId());
              trx.success();
              return stg;
              
            }
           
        
            
            
        } catch (Exception e) {
            
            created = false;
            log.severe("Creation of Farmer Failed");
            e.printStackTrace();
        }
        
        return null;
    }

}
