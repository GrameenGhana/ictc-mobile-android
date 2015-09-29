/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.ProductionUpdate;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Neo4jServices;

/**
 *
 * @author Joseph George Davis
 * @date Sep 29, 2015 11:05:18 AM
 * description:
 */
public class ProductionUpdateModel {
    
    
//    
//     public ProductionUpdate getBiodata(String field, String value) {
//        String q = "Start root=node(0) "
//                + " MATCH root-[:" + ICTCRelationshipTypes.ENTITY + "]->parent-[:" + ICTCRelationshipTypes.FARMER + "]->p-{:"+ICTCRelationshipTypes.HAS_PRODUCTION
//                + " where p." + field + "='" + value + "'"
//                + " return p";
//
//        System.out.println("Query " + q);
//        try {
//            Node node = Neo4jServices.executeCypherQuerySingleResult(q, "p");
//            if (null != node) {
//                return new ProductionUpdate(node);
//            }
//        } catch (Exception e) {
//            System.out.println("Unable to Find geofence");
//        }
//
//        return null;
//    }

}
