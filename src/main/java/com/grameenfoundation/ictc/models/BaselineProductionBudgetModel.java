/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.BaselineProductionBudget;
import com.grameenfoundation.ictc.domains.FmpProductionBudget;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Joseph George Davis
 * @date Oct 19, 2015 12:07:00 PM
 * description:
 */
public class BaselineProductionBudgetModel {
    
    
      public BaselineProductionBudget getBaselineProductionBudget(String field, String value) {
//      String q = "Start root=node(0) "
//                + " MATCH root-[:" + ICTCRelationshipTypes.ENTITY + "]->parent-[:" + ICTCRelationshipTypes.FARMER + "]->f-[:"+ICTCRelationshipTypes.HAS_BASELINE_PRODUCTION_BUDGET+
//                "]->p"
//                + " where f." + field + "='" + value + "'"
//                + " return p";
      
          String q = "match (f:FARMER)-[:"+ICTCRelationshipTypes.HAS_BASELINE_PRODUCTION_BUDGET+"]->p"+ 
                " where f." + field + "='" + value + "'"
                + " return p";

        System.out.println("Query " + q);
        try {
            Node node = Neo4jServices.executeCypherQuerySingleResult(q, "p");
            if (null != node) {
                return new BaselineProductionBudget(node);
            }
        } catch (Exception e) {
            System.out.println("Unable to Find Baseline Production Budget");
            e.printStackTrace();
        }

        return null;
    }

}
