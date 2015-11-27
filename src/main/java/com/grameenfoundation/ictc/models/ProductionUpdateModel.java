/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.ProductionUpdate;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Joseph George Davis
 * @date Sep 29, 2015 11:05:18 AM
 * description:
 */
public class ProductionUpdateModel {
    
    
    
     public ProductionUpdate getProductionUpdate(String field, String value) {
        String q = "match (n:PARENT)-[:FARMER]->(f)-[:"+ICTCRelationshipTypes.HAS_PRODUCTION+"]->(p)-[:"+ICTCRelationshipTypes.UPDATE+"]->m "
                + " where f." + field + "='" + value + "'"
                + " return m";

        System.out.println("Query " + q);
        try {
            Node node = Neo4jServices.executeCypherQuerySingleResult(q,"m");
            if (null != node) {
                return new ProductionUpdate(node);
            }
        } catch (Exception e) {
            System.out.println("Unable to Find Production Update");
        }

        return null;
    }

}
