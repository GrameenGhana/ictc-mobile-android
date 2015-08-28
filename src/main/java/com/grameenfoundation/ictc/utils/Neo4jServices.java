/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.utils;

import com.grameenfoundation.ictc.domains.Biodata;
import com.grameenfoundation.ictc.domains.FarmManagement;
import com.grameenfoundation.ictc.domains.FarmManagementPlan;
import com.grameenfoundation.ictc.domains.Harvest;
import com.grameenfoundation.ictc.domains.Marketing;
import com.grameenfoundation.ictc.domains.Operations;
import com.grameenfoundation.ictc.domains.PostHarvest;
import com.grameenfoundation.ictc.domains.Storage;
import com.grameenfoundation.ictc.domains.TechnicalNeed;
import com.grameenfoundation.ictc.wrapper.BiodataWrapper;
import com.grameenfoundation.ictc.wrapper.FarmManagementPlanWrapper;
import com.grameenfoundation.ictc.wrapper.FarmManagementWrapper;
import com.grameenfoundation.ictc.wrapper.HarvestWrapper;
import com.grameenfoundation.ictc.wrapper.MarketingWrapper;
import com.grameenfoundation.ictc.wrapper.OperationsWrapper;
import com.grameenfoundation.ictc.wrapper.PostHarvestWrapper;
import com.grameenfoundation.ictc.wrapper.StorageWrapper;
import com.grameenfoundation.ictc.wrapper.TechnicalNeedsWrapper;
import java.util.ArrayList;
import java.util.List;
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

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
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
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            // Deletes the relations of the node
            String q = "";
            if (direct.equals(Direction.OUTGOING)) {
                q = "start n=node(" + node.getId() + ") match n-[r:" + relations + "]->s"
                        + " delete r ";
            } else if (direct.equals(Direction.INCOMING)) {
                q = "start n=node(" + node.getId() + ") match n<-[r:" + relations + "]-s"
                        + " delete r ";

            } else {
                q = "start n=node(" + node.getId() + ") match n<-[r:" + relations + "]->s"
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

        try (Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            //Get the root Node
            Node rootNode = executeCypherQuerySingleResult("start rt=node(0) return rt", "rt");

            //Create the new node
            Node neoNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.PARENT);
            //Set the name for that node
            neoNode.setProperty(ICTCKonstants.NAME, refNode);

            //relate the new node to the parent node
            rootNode.createRelationshipTo(neoNode, ICTCRelationshipTypes.ENTITY);
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
        ExecutionResult result = null;
        // let's execute a query now
        try (Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            ExecutionEngine engine = new ExecutionEngine(
                    ICTCDBUtil.getInstance().getGraphDB(), StringLogger.SYSTEM);
            result = engine.execute(q);
            tx.success();
        } catch (Exception e) {
            log.warn("Error creating Executing Query : " + e.getLocalizedMessage());
        }
        return result;
    }

    public static List<BiodataWrapper> getIterativeNode(String q) {
        Iterator<Node> n_column = null;
        List<Biodata> bdata = new ArrayList<>();
        List<BiodataWrapper> bdatac = new ArrayList<>();
        ExecutionResult result = null;
        // let's execute a query now
        try (Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            ExecutionEngine engine = new ExecutionEngine(
                    ICTCDBUtil.getInstance().getGraphDB(), StringLogger.SYSTEM);
            result = engine.execute(q);

            n_column = result.columnAs("l");

            while (n_column.hasNext()) {
 try {
                 
                Node n = n_column.next();
                Biodata b = new Biodata(n);
                bdata.add(b);
                System.out.println("Node  n : " + n.getId());
//                 String maritalStatus, String numberOfChildren, String numberOfDependants, String education/

               
                BiodataWrapper bw = (new BiodataWrapper(b.getFirstname(), b.getLastname(), b.getNickname(), b.getCommunity(), b.getVillage(), b.getDistrict(), b.getRegion(), b.getAge(), b.getGender(),
                        b.getMaritalstatus(), b.getNumberofchildren(), b.getNumberofdependants(), b.getEducation(), String.valueOf((n.getId() % 2)), String.valueOf(b.getId()), b.getMajorCrop()));

                TechnicalNeed technicalNeed = b.getTechNeeds();
                if(null!=technicalNeed)
               bw.setTechNeeds(new TechnicalNeedsWrapper(technicalNeed.getFarmPlanning(),technicalNeed.getCropVarietyAndSeed(),technicalNeed.getWeedControl(),technicalNeed.getCropEstablishment(),technicalNeed.getIntegratedSoilFertilityManagement(),technicalNeed.getHarvestAndPostHarvest()));
                Marketing market = b.getMarketing();
             if(null!=market)
                bw.setMarketing(new MarketingWrapper(market.getMainPointOfContact(),market.getMonthSellingBegins(),market.getPriceOfFirstHarvestProduce(),market.getMonthMostHarvestProduceSold(),market.getPriceMostHarvestProduceSold(),market.getMonthFinalBatchSold(),market.getPriceFinalBatchSold(),market.getMonthSellingDriedChipChicks(),market.getPriceFirstDriedChipChunk(),market.getMonthMostDriedChipsChunksSold(),market.getPriceMostDriedChipsChunksSold(),market.getMonthLastBatchDriedChipChunksSold(),market.getPriceFinalBatchDriedChipsChunksSold()));
         
                Operations opt = b.getFarmOperation();
               
                OperationsWrapper wr = new OperationsWrapper();
                //wr.set
               
               if(opt!=null){
                wr.setLandSize(opt.getLandSize());
              wr.setLandClearance(opt.getLandClearance());
               }
                bw.setOperation(wr);
                
                
                Harvest harvest = b.getHavest();
                HarvestWrapper  hWrapper = new HarvestWrapper();
                if(null!=hWrapper){
                hWrapper.setYieldPerAcre(harvest.getYieldPerAcre());
                }
                bw.setHarvest(hWrapper);
                
                PostHarvest postHarvest =b.getPostHavest();
                PostHarvestWrapper  phWrapper = new PostHarvestWrapper();
              if(null!=phWrapper)
                bw.setPostHarvest(phWrapper);
                
                Storage storeage = b.getStorage();
                
                FarmManagement fm = b.getFarmManagement();
                FarmManagementWrapper fmWrapper = new FarmManagementWrapper();
               if(null!=fm){
                fmWrapper.setLabourUse(fm.getLabourUse());
                fmWrapper.setFboName(fm.getFboName());
               } StorageWrapper  stWrapper = new StorageWrapper();
                bw.setStorage(stWrapper);
                FarmManagementPlan fmp =  b.getFMP();
                FarmManagementPlanWrapper fmpWrapper = new FarmManagementPlanWrapper();
                if(null!=fmp){
                fmpWrapper.setTargetareaofland(fmp.getTargetareaofland());
                fmpWrapper.setTargetproduction(fmp.getTargetproduction());
                fmpWrapper.setTargetyieldperacre(fmp.getTargetyieldperacre());
                fmpWrapper.setNameofvariety(fmp.getNameofvariety());
                fmpWrapper.setDateoflandidentification(fmp.getDateoflandidentification());
                fmpWrapper.setLocationofland(fmp.getLocationofland());
                fmpWrapper.setExpectedpriceperton(fmp.getExpectedpriceperton());
                fmpWrapper.setPlantingdate(fmp.getPlantingdate());
                }bw.setFmp(fmpWrapper);
               
                bdatac.add(bw);
              
                } catch (Exception e) {
                } }
            tx.success();
        } catch (Exception e) {
            System.out.println("Error creatingfindByLabel Executing Query : " + e.getLocalizedMessage());
            e.printStackTrace();
        }

        return bdatac;
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

    public static List<BiodataWrapper> findByLabel(ICTCRelationshipTypes primaryRel, String searchField, String searchValue) {
        String searchParam = (searchField.isEmpty()) ? "" : " where l." + searchField + "= '" + searchValue + "' ";

        String query = " match (l:" + primaryRel + ") " + searchParam + " return l ";
        System.out.println("Query : " + query);
        return getIterativeNode(query);

    }

    public static Iterator<Node> findAllByPrimaryRelation(ICTCRelationshipTypes primaryRel, List<QueryFieldValue> fieldVales) {

        String where = "";
        int cnt = 0;
        String quotes = "";
        if (null != fieldVales) {
            for (QueryFieldValue fieldValue : fieldVales) {
                quotes = "";
                if (fieldValue.getType().equals(QueryFieldValue.DataTypes.STRING)) {
                    quotes = "'";
                }

                if (cnt > 0) {
                    where += " and ";
                }
                where += fieldValue.getOperationOn() + "." + fieldValue.getName() + " ! = " + quotes + fieldValue.getValue() + quotes;
            }
            if (!where.isEmpty()) {
                where = " where  " + where;
            }
        }
        String q = "Start root=node(" + ICTCKonstants.ROOT_NODE_INDEX + ") "
                + " MATCH root-[:" + ICTCRelationshipTypes.ENTITY + "]->parent-[:" + primaryRel + "]->a "
                + "  " + where + " return a  ";
        System.out.println("Query  : " + q);
        log.info("Qry : " + q);
        try {
            ExecutionResult result = executeCypherQuery(q);
            Iterator<Node> n_column = result.columnAs("a");
            return n_column;
        } catch (Exception e) {
            log.warn("Unable to findAllBySecondaryRelation" + primaryRel);
        }
        return null;
    }

    public static Iterator<Node> findAllBySecondaryRelationPrimaryRelation(ICTCRelationshipTypes primaryRel, List<QueryFieldValue> fieldVales) {

        String where = "";
        int cnt = 0;
        String quotes = "";
        for (QueryFieldValue fieldValue : fieldVales) {
            quotes = "";
            if (fieldValue.getType().equals(QueryFieldValue.DataTypes.STRING)) {
                quotes = "'";
            }

            if (cnt > 0) {
                where += " and ";
            }
            where += fieldValue.getOperationOn() + "." + fieldValue.getName() + " ! = " + quotes + fieldValue.getValue() + quotes;
        }
        String q = "Start root=node(1) "
                + " MATCH root-[:" + ICTCRelationshipTypes.ENTITY + "]->parent-[:" + primaryRel + "]->a "
                + " where " + where + " return a  ";

        log.info("Qry : " + q);
        try {
            ExecutionResult result = executeCypherQuery(q);
            Iterator<Node> n_column = result.columnAs("a");
            return n_column;
        } catch (Exception e) {
            log.warn("Unable to findAllBySecondaryRelation" + primaryRel);
        }
        return null;
    }
    
    public static long getAggregatedValue(String q) {
        Iterator<Long> n_column = null;
        ExecutionResult result = null;
        // let's execute a query now
        try (Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            ExecutionEngine engine = new ExecutionEngine(
                    ICTCDBUtil.getInstance().getGraphDB(), StringLogger.SYSTEM);
            result = engine.execute(q);

            n_column = result.columnAs("l");
            while (n_column.hasNext()) {
                return n_column.next();
            }
        }

        return 0l;
    }
    
     public static List<String> getIterativeString(String q) {
        Iterator<String> n_column = null;
        List<String> bdata = new ArrayList<>();
        List<BiodataWrapper> bdatac = new ArrayList<>();
        ExecutionResult result = null;
      
        try (Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            ExecutionEngine engine = new ExecutionEngine(
                    ICTCDBUtil.getInstance().getGraphDB(), StringLogger.SYSTEM);
            result = engine.execute(q);

            n_column = result.columnAs("l");

            while (n_column.hasNext()) {

                String n = n_column.next();
                bdata.add(n);
            }
            tx.success();
        } catch (Exception e) {
            System.out.println("Error getIterativeString Executing Query : " + e.getLocalizedMessage());
            e.printStackTrace();
        }

        return bdata;
    }

 public static Iterator<Node> executeIteratorQuery(String query, String returnItem) {

        try (Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            ExecutionEngine engine = new ExecutionEngine(
                    ICTCDBUtil.getInstance().getGraphDB(), StringLogger.SYSTEM);
            ExecutionResult result = executeCypherQuery(query);
            return result.columnAs(returnItem);
        }
   
    }


    public static List<BiodataWrapper> findByLabel(Labels primaryRel, ICTCRelationshipTypes secondaryRel, String searchField, String searchValue) {
        String searchParam = (searchField.isEmpty()) ? "" : " where l." + searchField + "= '" + searchValue + "' ";

        String query = " match (k:" + primaryRel + ")-[:" + secondaryRel + "]->l" + searchParam + " return l ";
        System.out.println("Query : " + query);
        return getIterativeNode(query);

    }

}
