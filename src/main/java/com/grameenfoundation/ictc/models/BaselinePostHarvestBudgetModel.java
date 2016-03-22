/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.BaselinePostHarvest;
import com.grameenfoundation.ictc.domains.BaselinePostHarvestBudget;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Joseph George Davis
 * @date Oct 20, 2015 10:55:14 AM
 * description:
 */
public class BaselinePostHarvestBudgetModel {
    
    
    public BaselinePostHarvestBudget getBaselinePostHarvestBudget(String field, String value) {
//        String q = "Start root=node(0) "
//                + " MATCH root-[:" + ICTCRelationshipTypes.ENTITY + "]->parent-[:" + ICTCRelationshipTypes.FARMER + "]->f-[:"+ICTCRelationshipTypes.HAS_BASELINE_POSTHARVEST_BUDGET+
//                "]->p"
//                + " where f." + field + "='" + value + "'"
//                + " return p";
        
        
         String q = "match (f:FARMER)-[:"+ICTCRelationshipTypes.HAS_BASELINE_POSTHARVEST_BUDGET+"]->p"+ 
                " where f." + field + "='" + value + "'"
                + " return p";

        System.out.println("Query " + q);
        try {
            Node node = Neo4jServices.executeCypherQuerySingleResult(q, "p");
            if (null != node) {
                return new BaselinePostHarvestBudget(node);
            }
        } catch (Exception e) {
            System.out.println("Unable to Find geofence");
        }

        return null;
    }

}
