/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.FarmCreditPlan;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

/**
 *
 * @author Joseph George Davis
 * @date Mar 11, 2016 4:08:07 PM
 * description:
 */
public class FarmCreditPlanModel {
    
     public FarmCreditPlan getFarmCreditPlan(String field, String value) {
       
          String q = "match (f:FARMER)-[:"+ICTCRelationshipTypes.HAS_FARMCREDIT_PLAN+"]->p"+ 
                " where f." + field + "='" + value + "'"
                + " return p";


        System.out.println("Query " + q);
        try {
            Node node = Neo4jServices.executeCypherQuerySingleResult(q, "p");
            if (null != node) {
                return new FarmCreditPlan(node);
            }
        } catch (Exception e) {
            System.out.println("Unable to Farm Plan Credit");
        }

        return null;
    }
     
     
      public boolean CreditPlanToUpdate(FarmCreditPlan fcp, Node update) {
        boolean created = false;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

         

            System.out.println("biodata :" + fcp.getUnderlyingNode().getId());
            if (null != fcp) {

               fcp.setUpdate(update);
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
