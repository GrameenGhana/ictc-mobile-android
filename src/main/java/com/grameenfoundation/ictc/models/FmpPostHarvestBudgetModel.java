/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.FmpPostHarvestBudget;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

/**
 *
 * @author Joseph George Davis
 * @date Oct 15, 2015 1:06:53 PM
 * description:
 */
public class FmpPostHarvestBudgetModel {
    
    
      public FmpPostHarvestBudget getFmpPostHarvestBudget(String field, String value) {
//        String q = "Start root=node(0) "
//                + " MATCH root-[:" + ICTCRelationshipTypes.ENTITY + "]->parent-[:" + ICTCRelationshipTypes.FARMER + "]->f-[:"+ICTCRelationshipTypes.HAS_POSTHARVEST_BUDGET+
//                "]->p"
//                + " where f." + field + "='" + value + "'"
//                + " return p";
        
        
          String q = "match (f:FARMER)-[:"+ICTCRelationshipTypes.HAS_POSTHARVEST_BUDGET+"]->p"+ 
                " where f." + field + "='" + value + "'"
                + " return p";


        System.out.println("Query " + q);
        try {
            Node node = Neo4jServices.executeCypherQuerySingleResult(q, "p");
            if (null != node) {
                return new FmpPostHarvestBudget(node);
            }
        } catch (Exception e) {
            System.out.println("Unable to FmpPostHarvestBudget");
        }

        return null;
    }
      
      
      
      public boolean FmpPostHarvestBudgetToUpdate(FmpPostHarvestBudget p, Node update) {
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
