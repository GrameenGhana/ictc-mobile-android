/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.utils;

import org.apache.log4j.Logger;
import org.neo4j.cypher.ExecutionEngine;
import org.neo4j.cypher.ExecutionResult;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.neo4j.kernel.impl.util.StringLogger;
import scala.collection.Iterator;

/**
 *
 * @author Spomega
 * @Date Mar 6, 2015 
 * @Email jdavis@grameenfoundation.org
 * @Description 
 */
public class Neo4jServices {
    
    private final static Logger log = Logger.getRootLogger();
    
     /**
     *
     * @param node
     * @param relations
     * @return
     */
    public static boolean deleteRelationship(Node node, RelationshipType relations) {
        // Begin the transaction
      
        try(  Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            // Deletes the relations of the node
            Iterable<Relationship> relationships = node.getRelationships();

            for (Relationship relationship : relationships) {

                if (relationship.getType().equals(relations)) {
                    relationship.delete();
                   // log.warn("Deleted : " + relationship.getType());
                } else {
                    log.info("Relationship Not deleted : " + relationship.getType());
                }
            }
            trx.success();
            return true;
        } catch (Exception e) {
            // When an error occur
            e.printStackTrace();
            log.warn("tx.failure() [Delete Rel] : " + e);
        }

        return false;
    }
    
    
     public static boolean deleteARelation(Node node, RelationshipType relations) {
            return deleteARelation(node, relations, Direction.OUTGOING);
    }
     
     
      public static boolean deleteARelation(Node node, RelationshipType relations, Direction direct) {
      
        // log.warn("Relation to be deleted : "+relations);
        // Begin the transaction
        
        try(Transaction trx =ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            // Deletes the relations of the node
            String q = "";
            if(direct.equals(Direction.OUTGOING)){
            q="start n=node(" + node.getId() + ") match n-[r:" + relations + "]->s"
                    + " delete r ";
            }else if(direct.equals(Direction.INCOMING)){
            q="start n=node(" + node.getId() + ") match n<-[r:" + relations + "]-s"
                    + " delete r ";
            
            }else{
            q="start n=node(" + node.getId() + ") match n<-[r:" + relations + "]->s"
                    + " delete r ";
            }
            log.info("Query : qu ");
            executeCypherQuery(q);
            trx.success();
            return true;
        } catch (Exception e) {
            // When an error occurs
            log.error("deleting Relationship failed");
        }

        return false;
      }
      
      
       /**
     *
     * This function creates a new reference Node to the root node
     *
     * @param refNode
     */
    public static Node createReferenceNode(String refNode) {
        

        try(Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            //Get the root Node
            Node rootNode = executeCypherQuerySingleResult("start rt=node(0) return rt", "rt");

            //Create the new node
            Node neoNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.PARENT);
            //Set the name for that node
            neoNode.setProperty(ICTCKonstants.NAME, refNode);

            //relate the new node to the parent node
            rootNode.createRelationshipTo(neoNode,ICTCRelationshipTypes.ENTITY);
            tx.success();
            return getReferenceNode(refNode);
        } catch (Exception e) {
           
            log.warn("Error creating Reference Node");
        } 
        return getReferenceNode(refNode);
    }
      
      
       /**
     *
     * Executives a given cypher Query
     *
     * @param q the cypher query be executed
     * @return executionResult the result of execution of that query
     *
     *
     */
    public static ExecutionResult executeCypherQuery(String q) {
        // let's execute a query now

        // Transaction tx = DataSource.getGraphDBAPI().beginTx();
        ExecutionResult result = null;
        try {
            ExecutionEngine engine = new ExecutionEngine(
                   ICTCDBUtil.getInstance().getGraphDB(), StringLogger.SYSTEM);
            result = engine.execute(q);
            // tx.success();
        } catch (Exception e) {
            // tx.failure();
            log.warn("Error Executing Cypher Query : " + q);
            log.warn("Exception : " + e);
        } finally {
            // tx.finish();
        }
        return result;
    }
    
    
     /**
     * Returns a node this is the result of a given query
     *
     * @param q
     * @param column
     * @return
     */
    public static Node executeCypherQuerySingleResult(String q, String column) {
        // let's execute a query now
        //System.out.println("Get Single Instance");
        //Transaction tx = DataSource.getGraphDBAPI().beginTx();
        ExecutionResult result = null;
        try {
            ExecutionEngine engine = new ExecutionEngine(
                   ICTCDBUtil.getInstance().getGraphDB(), StringLogger.SYSTEM);
            result = engine.execute(q);
            //  tx.success();
        } catch (Exception e) {
            e.printStackTrace();
            //tx.failure();
            log.warn("Error Executing Cypher Query : " + q);
            log.warn("Exception : " + e);
        } finally {
            //tx.finish();
        }
        //  log.warn("After Find");

        return nodeFromResult(result, column);
    }
    
    
    /**
     * This function gets the node form a query that only returns a single
     * result
     *
     * @param result
     * @param column
     * @return
     */
    public static Node nodeFromResult(ExecutionResult result, String column) {

//		@SuppressWarnings("unchecked")
        Iterator<Node> n_column = result.columnAs(column);
        while (n_column.hasNext()) {
            return n_column.next();
        }
        //  log.warn("Nothing found");
        return null;
    }


    /**
     * Get a reference node
     *
     * @param nodeName
     * @return
     */
    public static Node getReferenceNode(String nodeName) {
        return getReferenceNode(nodeName, false);
    }
    
    
    /**
     *
     * @param nodeName
     * @param recreateIfNotExist recreates the node if it does not exist
     * @return if true the node would be recreated when you not found and other
     * wise if false
     */
    public static Node getReferenceNode(String nodeName, boolean recreateIfNotExist) {
        try {
            String q = "Start root=node(0) " + " MATCH root-[:" + ICTCRelationshipTypes.ENTITY + "]->en "
                    + " where en.name='" + nodeName + "' " + " return en";

            ExecutionResult result = executeCypherQuery(q);

            Iterator<Node> n_column = result.columnAs("en");
            while (n_column.hasNext()) {
                Node n = n_column.next();
                return n;
            }
            if (recreateIfNotExist) {
                log.warn("Creating New Node from recreate");
                return createReferenceNode(nodeName);
            }

        } catch (Exception e) {
            log.warn("Unable to find " + nodeName);
            e.printStackTrace();


            log.warn("Creating Node " + nodeName);
            if (recreateIfNotExist) {
                log.warn("Creating New");
                return createReferenceNode(nodeName);
            }
        }

        return null;
    }

  
    /**
     * Get a reference node
     *
     * @param nodeName
     * @return 
     */
    public static Node getReferenceNodeCreatIfNotExist(String nodeName) {
        return getReferenceNode(nodeName, true);
    }
    
    
    public static Node findNodeFromRelation(Node underlyingNode, Direction direction, ICTCRelationshipTypes relationType) {
        Iterable<Relationship> relationships = underlyingNode.getRelationships(direction, relationType);
        for (Relationship relationshp : relationships) {
            if (direction.equals(Direction.OUTGOING)) {
                return relationshp.getEndNode();
            } else {
                return relationshp.getStartNode();
            }
        }
        return null;
    }
    
}
