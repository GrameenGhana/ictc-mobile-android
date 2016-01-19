/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.models;

import com.grameenfoundation.ictc.domains.Biodata;
import com.grameenfoundation.ictc.utils.CRUDServices;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import com.grameenfoundation.ictc.utils.ParentNode;
import com.grameenfoundation.ictc.wrapper.BiodataWrapper;
import com.grameenfoundation.ictc.wrapper.CommunityCounterWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.neo4j.cypher.ExecutionEngine;
import org.neo4j.cypher.ExecutionResult;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Transaction;
import org.neo4j.helpers.collection.IteratorUtil;
import org.neo4j.kernel.impl.util.StringLogger;
import scala.collection.Iterator;
import scala.sys.process.processInternal;

/**
 *
 * @author Joseph George Davis
 * @date Jul 16, 2015 1:49:34 PM description:
 */
public class BiodataModel {

    Logger log = Logger.getLogger(BiodataModel.class.getName());
    Node FarmerParent;

    public boolean createBiodata(BiodataWrapper biodataWrapper) {
        boolean created = true;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Node farmerNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.FARMER);

            Biodata biodata = new Biodata(farmerNode);

            if (null == biodataWrapper) {
                log.info("Biodata is invalid");
                created = false;
            } else {
                FarmerParent = ParentNode.FarmerParentNode();

                biodata.setFirstname(biodataWrapper.getFirstName());
                biodata.setLastname(biodataWrapper.getLastName());
                biodata.setAge(biodataWrapper.getAge());
                biodata.setVillage(biodataWrapper.getVillage());
                biodata.setDistrict(biodataWrapper.getDistrict());
                biodata.setCommunity(biodataWrapper.getCommunity());
                biodata.setGender(biodataWrapper.getGender());
                biodata.setMaritalstatus(biodataWrapper.getMaritalStatus());
                biodata.setNickname(biodataWrapper.getNickname());
                biodata.setNumberofchildren(biodataWrapper.getNumberOfChildren());
                biodata.setNumberofdependants(biodataWrapper.getNumberOfDependants());
                biodata.setEducation(biodataWrapper.getEducation());
                biodata.setLastModifiedDate(new Date());

                FarmerParent.createRelationshipTo(farmerNode, ICTCRelationshipTypes.FARMER);

                log.log(Level.INFO, "new node created {0}", biodata.getUnderlyingNode().getId());
                trx.success();

            }

        } catch (Exception e) {

            created = false;
            log.severe("Creation of Farmer Failed");
            e.printStackTrace();
        }

        return created;
    }

    public boolean createBiodata(Node node) {
        boolean created = true;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            if (null == node) {
                log.info("Biodata is invalid");
                created = false;
            } else {
                FarmerParent = ParentNode.FarmerParentNode();
                FarmerParent.createRelationshipTo(node, ICTCRelationshipTypes.FARMER);

                log.log(Level.INFO, "new node created {0}", node.getId());
                trx.success();

            }

        } catch (Exception e) {

            created = false;
            log.severe("Creation of Farmer Failed");
            e.printStackTrace();
        }

        return created;
    }

    public Biodata getBiodata(String field, String value) {
        String q = "Start root=node(0) "
                + " MATCH root-[:" + ICTCRelationshipTypes.ENTITY + "]->parent-[:" + ICTCRelationshipTypes.FARMER + "]->p"
                + " where p." + field + "='" + value + "'"
                + " return p";

        System.out.println("Query " + q);
        try {
            Node node = Neo4jServices.executeCypherQuerySingleResult(q, "p");
            if (null != node) {
                return new Biodata(node);
            }
        } catch (Exception e) {
            System.out.println("Unable to Find Biodata");
        }

        return null;
    }

    public List<BiodataWrapper> getBioData(String field, String value) {
        List<Biodata> bioData = new ArrayList<>();
        try {

            return Neo4jServices.findByLabel(ICTCRelationshipTypes.FARMER, "", "");
//            Iterator<Node> n_column = Neo4jServices.findAllByPrimaryRelation(ICTCRelationshipTypes.FARMER, null);
//            while (n_column.hasNext()) {
//                Node node = n_column.next();
//                try {
//                    System.out.println("Node I : "+node.getId());
//                    System.out.println("Node I I: "+(String)node.getProperty(Biodata.FIRST_NAME));
//                } catch (Exception e) {
//                    System.out.println("Exception e : "+e.getLocalizedMessage());
//                }
//                Biodata bd = new Biodata(node);
//                try {
//                    System.out.println("NDII : "+bd.getFirstname());
//                } catch (Exception e) {
//                }
//                bioData.add(bd);
//            }

        } catch (Exception e) {
            System.out.println("Unable to Find Bio Data List  : " + e.getLocalizedMessage());
            e.printStackTrace();
        }

        return null;
    }

    public List<BiodataWrapper> getBioDataSearch(String field, String value) {
        List<Biodata> bioData = new ArrayList<>();
        try {

            return Neo4jServices.findByLabel(ICTCRelationshipTypes.FARMER, field, value);
//            Iterator<Node> n_column = Neo4jServices.findAllByPrimaryRelation(ICTCRelationshipTypes.FARMER, null);
//            while (n_column.hasNext()) {
//                Node node = n_column.next();
//                try {
//                    System.out.println("Node I : "+node.getId());
//                    System.out.println("Node I I: "+(String)node.getProperty(Biodata.FIRST_NAME));
//                } catch (Exception e) {
//                    System.out.println("Exception e : "+e.getLocalizedMessage());
//                }
//                Biodata bd = new Biodata(node);
//                try {
//                    System.out.println("NDII : "+bd.getFirstname());
//                } catch (Exception e) {
//                }
//                bioData.add(bd);
//            }

        } catch (Exception e) {
            System.out.println("Unable to Find Bio Data List  : " + e.getLocalizedMessage());
            e.printStackTrace();
        }

        return null;
    }

    public boolean BiodataToFarmManagement(String biodata, Node farmManagement) {
        boolean created = false;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Biodata b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setFarmManagement(farmManagement);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToHarvest(String biodata, Node harvest) {
        boolean created = false;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Biodata b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setHarvest(harvest);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToPostHarvest(String biodata, Node postHarvest) {
        boolean created = false;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Biodata b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setPostHarvest(postHarvest);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToStorage(String biodata, Node storage) {
        boolean created = false;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Biodata b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setStorage(storage);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToMarketing(String biodata, Node marketing) {
        boolean created = false;

        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Biodata b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setMarketing(marketing);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToTechNeeds(String biodata, Node techNeeds) {

        boolean created = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Biodata b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setTechNeeds(techNeeds);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToOperations(String biodata, Node operations) {

        boolean created = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Biodata b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setFarmOperation(operations);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToFMP(String biodata, Node fmp) {

        boolean created = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Biodata b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setFMP(fmp);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToMeeting(String biodata, Node meeting) {

        boolean created = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Biodata b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setFarmerMeeting(meeting);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToProduction(String biodata, Node production) {

        boolean created = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            Biodata b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setProduction(production);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToProfiling(String biodata, Node profile) {

        Biodata b = null;
        boolean created = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setProfiling(profile);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public BiodataWrapper getBiodataByFieldValue(String field, String value) {
//        String q = "Start root=node(0) "
//                + " MATCH root-[:" + ICTCRelationshipTypes.ENTITY + "]->parent-[:" + ICTCRelationshipTypes.FARMER + "]->p"
//                + " where p." + field + "='" + value + "'"
//                + " return p";
        String q = "match (l:FARMER) WHERE l." + field + "='" + value + "' return  l ";
        System.out.println("Query " + q);
        try {
            List<BiodataWrapper> wrappers = Neo4jServices.getIterativeNode(q);
            System.out.println("Received : wrapp " + wrappers.size());
            if (wrappers.isEmpty()) {
                return null;
            } else {
                System.out.println("Returned 111");
                return wrappers.get(0);
            }
        } catch (Exception e) {
            System.out.println("Unable to Find geofence");
        }

        return null;
    }

    public List<String> getCommunitiesList() {

        try {
            return Neo4jServices.getIterativeString("match (n:FARMER) RETURN DISTINCT n.community as l");
        } catch (Exception e) {
            System.out.println("Unable to Find Bio Data List  : " + e.getLocalizedMessage());
            e.printStackTrace();
        }

        return null;
    }

    public List<String> getVillageList() {

        try {
            return Neo4jServices.getIterativeString("match (n:FARMER) RETURN DISTINCT n.village as l");
        } catch (Exception e) {
            System.out.println("Unable to Find Bio Data List  : " + e.getLocalizedMessage());
            e.printStackTrace();
        }

        return null;
    }

    public Long getFarmerCount() {

        return Neo4jServices.getAggregatedValue(" match (n:FARMER) RETURN count(n) as l");
    }

    public Long getCommunityCount() {

        return Neo4jServices.getAggregatedValue(" match (n:FARMER) RETURN count(DISTINCT n.community) as l");
    }

    public Long getAgentCount() {

        return Neo4jServices.getAggregatedValue(" match (n:AGENT) RETURN count(n) as l");
    }

    public List<CommunityCounterWrapper> getCommunityWrapper() {
 List<CommunityCounterWrapper>  ccw= new ArrayList<>();
        String q = "match (n:FARMER) RETURN n.community as c, count(n.community) as s order by n.community";

        Iterator<Long> n_column = null;
        org.neo4j.cypher.javacompat.ExecutionResult result = null;
        // let's execute a query now
        try (Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            org.neo4j.cypher.javacompat.ExecutionEngine engine = new org.neo4j.cypher.javacompat.ExecutionEngine(
                    ICTCDBUtil.getInstance().getGraphDB(), StringLogger.SYSTEM);
            result = engine.execute(q);

            ResourceIterator<Object> communities = result.columnAs("c");
	ResourceIterator<Object> sumations = result.columnAs("s");
         String com =""; long l =0;
        while(communities.hasNext())
        {
            try {
                
            
            try {
                  com = (String)communities.next();
            } catch (Exception e) {
                 System.out.println("Error comm: "+e.getLocalizedMessage());
                com="Null";
            }
           
            try {
                Object sums = sumations.next();
                System.out.println("Sum: "+sums.toString());
                l = (Long)sumations.next();
            } catch (Exception e) {
                 System.out.println("Error l: "+e.getLocalizedMessage());
                l=0;
            }
            
            ccw.add(new CommunityCounterWrapper(com, l));} catch (Exception e) {
                System.out.println("Error: "+e.getLocalizedMessage());
            }
        }
        
//            while (result.hasNext()) {
//                CommunityCounterWrapper  communityWrapper = new CommunityCounterWrapper();
//                
//                Map<String, Object> row = (Map<String, Object>) result.next();
//                for (Entry<String, Object> column : row.entrySet()) {
//                    if(column.getKey().equalsIgnoreCase("c"))
//                        communityWrapper.setCommunity((String)column.getValue());
//                    else
//                        communityWrapper.setNoOfFarmers((Long)column.getValue());
//                        
//                    
//                }
//                ccw.add(communityWrapper);
//            }

        }

        return ccw;
    }
    
    
    public boolean lastmodifiedUpdate(String id,long lastmodified)
    {
         boolean updated = false;
         try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
         Biodata bio = getBiodata(Biodata.ID, id);
         
             if (null != bio) {

                 bio.setLastModifiedDate(lastmodified);
                 trx.success();
                 updated = true;
                 log.log(Level.INFO, "Bio Data Successfully Updated with lastmodified date {0}", updated);
             } else {
                  log.log(Level.INFO, "Farmer not available");
             }
        }
         
         return updated;
    }

    public boolean BiodataUpdate(String id, Map<String, String> data) {

        Biodata bio = getBiodata(Biodata.ID, id);
        boolean updated = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            //If the setting is not null
            if (null != bio) {

                for (Map.Entry<String, String> dataEntry : data.entrySet()) {

                    // get the field name
                    String fieldName = dataEntry.getKey();
                    // get the field value
                    String fieldValue = dataEntry.getValue();
                    System.out.println("Updating : " + fieldName + " <> " + fieldValue);
                    // Assigning the alias
                    if (fieldName.equalsIgnoreCase(Biodata.CLUSTER)) {
                        if (null != fieldValue) {
                            bio.setCluster(fieldValue);
                        }
                    }
                    if (fieldName.equalsIgnoreCase(Biodata.FARM_AREA)) {
                        if (null != fieldValue) {
                            bio.setFarmarea(fieldValue);
                        }
                    }
                    if (fieldName.equalsIgnoreCase(Biodata.FARM_PERIMETER)) {
                        if (null != fieldValue) {
                            bio.setFarmperimeter(fieldValue);
                        }
                    }

                    if (fieldName.equalsIgnoreCase(Biodata.IMAGE_URL)) {
                        if (null != fieldValue) {
                            bio.setImage_Url(fieldValue);
                        }
                    }

                    if (fieldName.equalsIgnoreCase(Biodata.CREATED_BY)) {

                        if (null != fieldValue) {

                            bio.setCreatedById(fieldValue);
                        }
                    }
                   

                }
                trx.success();

                updated = true;
                log.log(Level.INFO, "Bio Data Successfully Updated {0}", updated);

            } else {

                log.info("Unable to update Bio Data");
            }
        }
        return updated;
    }

    public boolean BiodataToBP(String biodata, Node BPBNode) {

        Biodata b = null;
        boolean created = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setBP(BPBNode);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToBPB(String biodata, Node BPBNode) {

        Biodata b = null;
        boolean created = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setBPB(BPBNode);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToBPHB(String biodata, Node BPBNode) {

        Biodata b = null;
        boolean created = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setBPHB(BPBNode);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToBPH(String biodata, Node BPBNode) {

        Biodata b = null;
        boolean created = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setBPH(BPBNode);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToFMPPB(String biodata, Node BPBNode) {

        Biodata b = null;
        boolean created = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setFMPPB(BPBNode);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToFMPPHB(String biodata, Node BPBNode) {

        Biodata b = null;
        boolean created = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setFMPPHB(BPBNode);
                created = true;
                trx.success();

            }
        } catch (Exception e) {
            System.out.println("error");
            //created = false;

        }

        return created;
    }

    public boolean BiodataToFCA(String biodata, Node BPBNode) {

        Biodata b = null;
        boolean created = false;
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            b = new BiodataModel().getBiodata(Biodata.ID, biodata);

            System.out.println("biodata :" + b.getUnderlyingNode().getId());
            if (null != biodata) {

                b.setFCA(BPBNode);
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
