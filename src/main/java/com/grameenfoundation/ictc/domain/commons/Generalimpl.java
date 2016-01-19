/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.domain.commons;


import com.grameenfoundation.ictc.utils.ICTCKonstants;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.ICTCUtil;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import java.util.Date;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

/**
 *
 * @author Spomega
 * @Date Mar 6, 2015{time}
 * @Email spomegasys@gmail.com
 * @Description 
 */
public class Generalimpl implements GeneralInterface {
    
    public static String CREATION_DATE = ICTCKonstants.CREATED_ON;
    public static String ID = ICTCKonstants.ID;
    public static String CREATION_BY = ICTCKonstants.CREATED_BY;
    public static String LAST_MODIFIED = ICTCKonstants.LAST_MODIFIED_DATE;
    public static String UPDATED_BY = ICTCKonstants.UPDATED_BY;
    
    Node underlyingNode = null;

    public Generalimpl(Node node) {
        
        this.underlyingNode = node;
        
        
    }
    
    
     @Override
    public void setCreatedOn(Date creationDate) {
        underlyingNode.setProperty(CREATION_DATE,
                ICTCUtil.dateToLong(creationDate));
    }

    @Override
    public Date getCreatedOn() {
        try {
            return  ICTCUtil.LongToDate((Long) underlyingNode.getProperty(CREATION_DATE));
        } catch (Exception e) {
        }
        return null;

    }

    @Override
    public void setLastModifiedDate(Date lastModificationDate) {
        underlyingNode.setProperty(LAST_MODIFIED,   ICTCUtil.dateToLong(lastModificationDate));
    } 
    
    
    @Override
    public void setLastModifiedDate(long lastModificationDate) {
        underlyingNode.setProperty(LAST_MODIFIED,  (lastModificationDate));
    }

    @Override
    public Date getLastModifiedDate() {
        return   ICTCUtil.LongToDate((Long) getUnderlyingNode().getProperty(LAST_MODIFIED));
    }

    @Override
    public Node getLastModifiedBy() {
       Iterable<Relationship> relationships = 
                underlyingNode.getRelationships(Direction.OUTGOING, ICTCRelationshipTypes.LAST_MODIFIED_BY);
        
         for (Relationship relationship : relationships) {
             return relationship.getEndNode();
         }
        return null;
    }

    @Override
    public void setLastModifiedBy(Node updatedBy) {
        try {
            Neo4jServices.deleteRelationship(updatedBy,  ICTCRelationshipTypes.LAST_MODIFIED_BY);
        } catch (Exception e) {
        }
        underlyingNode.createRelationshipTo(updatedBy,ICTCRelationshipTypes.LAST_MODIFIED_BY);
    }

    public Node getUnderlyingNode() {
        return underlyingNode;
    }

    @Override
    public void setId(String id) {
        underlyingNode.setProperty(ID, id);

    }

    @Override
    public String getId() {

        try {
            return (String) underlyingNode.getProperty(ID);
        } catch (Exception e) {
        }

        return null;
    }

    
     @Override
    public Node getCreatedBy() {
//        Iterable<Relationship> relationships = 
//                underlyingNode.getRelationships(Direction.OUTGOING, KnoxxiRelationshipType.CREATED_BY);
//        
//         for (Relationship relationship : relationships) {
//             return relationship.getEndNode();
//         }
//   
//         
         return null;
     //return NeoUtil.findRelationFromNode(underlyingNode, Direction.OUTGOING, KnoxxiRelationshipType.CREATED_BY); 
    }

    @Override
    public void setCreatedBy(Node created) {
        try {
             Neo4jServices.deleteARelation(created, ICTCRelationshipTypes.CREATED_BY);
        } catch (Exception e) {
        }
        underlyingNode.createRelationshipTo(created, ICTCRelationshipTypes.CREATED_BY);
    }

   

   


    
    
    
    
    
    

}
