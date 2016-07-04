/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.models;


import com.grameenfoundation.ictc.domains.FarmCreditUpdate;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Joseph George Davis
 * @date Jun 8, 2016 11:38:15 AM
 * description:
 */
public class FarmCreditUpdateModel {
    
    
       public FarmCreditUpdate getFarmCreditUpdate(String field, String value) {
       
          String q = "match (f:FARMER)-[:"+ICTCRelationshipTypes.HAS_FARMCREDIT_UPDATE+"]->p"+ 
                " where f." + field + "='" + value + "'"
                + " return p";


        System.out.println("Query " + q);
        try {
            Node node = Neo4jServices.executeCypherQuerySingleResult(q, "p");
            if (null != node) {
                return new FarmCreditUpdate(node);
            }
        } catch (Exception e) {
            System.out.println("Unable to Farm Credit Update");
        }

        return null;
    }

}
