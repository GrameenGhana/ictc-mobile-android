/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.FieldCropAssessment;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Joseph George Davis
 * @date Oct 26, 2015 11:23:46 AM
 * description:
 */
public class FieldCropAssessmentModel {
    
    
     public FieldCropAssessment getFieldCropAssessment(String field, String value) {
        String q = "Start root=node(0) "
                + " MATCH root-[:" + ICTCRelationshipTypes.ENTITY + "]->parent-[:" + ICTCRelationshipTypes.FARMER + "]->f-[:"+ICTCRelationshipTypes.HAS_FIELD_CROP_ASSESSMENT+
                "]->p"
                + " where f." + field + "='" + value + "'"
                + " return p";

        System.out.println("Query " + q);
        try {
            Node node = Neo4jServices.executeCypherQuerySingleResult(q, "p");
            if (null != node) {
                return new FieldCropAssessment(node);
            }
        } catch (Exception e) {
            System.out.println("Unable to Find geofence");
        }

        return null;
    }

}
