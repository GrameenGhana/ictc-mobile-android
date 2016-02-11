/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.BaselinePostHarvest;
import com.grameenfoundation.ictc.domains.BaselineProductionBudget;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Joseph George Davis
 * @date Oct 19, 2015 3:13:22 PM
 * description:
 */
public class BaselinePostHarvestModel {
    
      public BaselinePostHarvest getBaselinePostHarvest(String field, String value) {
        String q = "Start root=node(0) "
                + " MATCH root-[:" + ICTCRelationshipTypes.ENTITY + "]->parent-[:" + ICTCRelationshipTypes.FARMER + "]->f-[:"+ICTCRelationshipTypes.HAS_BASELINE_POSTHARVEST+
                "]->p"
                + " where f." + field + "='" + value + "'"
                + " return p";

        System.out.println("Query " + q);
        try {
            Node node = Neo4jServices.executeCypherQuerySingleResult(q, "p");
            if (null != node) {
                return new BaselinePostHarvest(node);
            }
        } catch (Exception e) {
            System.out.println("Unable to Find geofence");
        }

        return null;
    }

}
