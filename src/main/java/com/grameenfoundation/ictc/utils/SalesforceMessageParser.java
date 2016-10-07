package com.grameenfoundation.ictc.utils;

import com.grameenfoundation.ictc.controllers.SalesforceHttpClient;
import com.grameenfoundation.ictc.domains.*;
import com.grameenfoundation.ictc.models.*;
import com.grameenfoundation.ictc.wrapper.MeetingWrapper;
import com.sun.jersey.core.util.Base64;
import org.json.JSONArray;
import org.json.JSONObject;
import org.neo4j.graphdb.Transaction;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by David on 6/9/2016.
 * @edited by Davis 
 *
 * Parses the Salesforce XML object and saves data in NEO JS
 */
public class SalesforceMessageParser {

    public static String TAG =  SalesforceMessageParser.class.getName();
    public static Logger log = Logger.getLogger(TAG);

    public static void processXMLString(String theString) {

        try (Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

            // File xmlFile = new File("/home/grameen/test.xml");
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(theString));

            Document doc = db.parse(is);
            doc.getDocumentElement().normalize();

            Element ele = doc.getDocumentElement();
            NodeList sObject = doc.getElementsByTagName("sObject");
            String farmerID = null;
            String imageurl = null;
            String agentId  = null;
            String majorcrop = null;
             
            try {
                  farmerID = getXmlNodeValue("sf:Farmer_Biodata__c", ele);
                  
               if(null == farmerID || farmerID.isEmpty())
               {
                  farmerID = getXmlNodeValue("sf:Farmer_Biodata_X__c",ele);  
                  
               }
            } catch (Exception e) {
              farmerID = getXmlNodeValue("sf:Farmer_Biodata_X__c",ele);
               
            }
            
            for (int j = 0; j < sObject.getLength(); j++) {

                Node rowNode = sObject.item(j);
                String sfObj = rowNode.getAttributes().getNamedItem("xsi:type").getNodeValue();
                //System.out.println(sfObj);

                switch(sfObj) {
                    case "sf:Farmer_Biodata__c": 
                        farmerID = getXmlNodeValue("sf:Id",ele);
                        agentId = getXmlNodeValue("sf:CreatedById", ele);
                        majorcrop = getXmlNodeValue("sf:majorcrop__c", ele);
                        if (processFarmer(rowNode, farmerID, agentId, majorcrop)) { tx.success(); }
                        break;
                   case "sf:Farmer_Biodata_X__c":
                        log.info("In Farmer Biodata x");
                        farmerID = getXmlNodeValue("sf:Id",ele);
                        agentId = getXmlNodeValue("sf:CreatedById", ele);
                        majorcrop = getXmlNodeValue("sf:majorcrop__c", ele);
                        if (processFarmerX(rowNode, farmerID, agentId, majorcrop)) { tx.success(); }
                        break;

                    case "sf:FMP_Production_New__c": case "sf:FMP_Production_NewX__c": if (processProduction(rowNode, farmerID)) { tx.success(); } break;
                    case "sf:FMP_Production_Update__c": case "sf:FMP_Production_Update_X__c": if (processProductionUpdate(rowNode, farmerID)) { tx.success(); } break;
                    case "sf:FMP_PRODUCTION_BUDGET__c": case "sf:FMP_PRODUCTION_BUDGET_X__c": if (processProductionBudget(rowNode, farmerID)) { tx.success(); } break;
                    case "sf:FMP_PRODUCTION_BUDGET_UPDATE__c": case "sf:FMP_PRODUCTION_BUDGET_UPDATE_X__c": if (processProductionBudgetUpdate(rowNode, farmerID)) { tx.success(); } break;

                    case "sf:FMP_PostHarvest_New__c": case "FMP_PostHarvest_New_X__c":if (processPostHarvest(rowNode, farmerID)) { tx.success(); } break;
                    case "sf:FMP_PostHarvest_update__c": case "FMP_PostHarvest_update_X__c": if (processPostHarvestUpdate(rowNode, farmerID)) { tx.success(); } break;
                    case "sf:FMP_PH_Budget__c": case "FMP_PH_Budget_X__c": if (processPostHarvestBudget(rowNode, farmerID)) { tx.success(); } break;
                    case "sf:FMP_PH_Budget_update__c": case "FMP_PH_Budget_update_X__c":if (processPostHarvestBudgetUpdate(rowNode, farmerID)) { tx.success(); } break;

                    case "sf:Profiling__c" :case "sf:Profiling_X__c": if (processProfile(rowNode, farmerID)) { tx.success(); } break;
                    
                         
                     
                    case "sf:TechnicalNeeds__c": if (processTechnicalNeeds(rowNode, farmerID)) { tx.success(); } break;
                    case "sf:FIELD_CROP_ASSESSMENT__c": case "sf:FIELD_CROP_ASSESSMENT_X__c":  if (processFieldCropAssessment(rowNode, farmerID)) { tx.success(); } break;
                    case "sf:FarmCreditPlan__c": case "FarmCreditPlan_X__c": if (processFarmCreditPlan(rowNode, farmerID)) { tx.success(); } break;
                    case "sf:FarmCreditPrevious__c": case "farmcreditprevious_X__c": if (processFarmCreditPrevious(rowNode, farmerID)) { tx.success(); } break;
                    case "sf:FarmCreditUpdate__c": case "FarmCreditUpdate_X__c":if (processFarmCreditUpdate(rowNode, farmerID)) { tx.success(); } break;

                    case "sf:BASELINE_PRODUCTION__c": if (processBaselineProduction(rowNode, farmerID)) { tx.success(); } break;
                    case "sf:BASELINE_PRODUCTION_BUDGET__c": if (processBaselineProductionBudget(rowNode, farmerID)) { tx.success(); } break;
                    case "sf:BASELINE_POST_HARVEST__c": if (processBaselinePostHarvest(rowNode, farmerID)) { tx.success(); } break;
                    case "sf:BASELINE_POST_HARVEST_BUDGET__c": if (processBaselinePostHarvestBudget(rowNode, farmerID)) { tx.success(); } break;

                    default: tx.success();
                }
            }

            log.info("Root element " + doc.getDocumentElement());
            log.info("-----------------Transaction Completed-------------------------");
          //  tx.success();

        } catch (Exception ex) {
            
            Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Object Processing Methods">

    public static boolean processFarmer(Node rowNode, String farmerID, String agentId, String majorcrop) {
        System.out.println("Farmer " + farmerID);
       
        BiodataModel biodataModel = new BiodataModel();
        Biodata bb = biodataModel.getBiodata("Id", farmerID);

        MeetingModel meetingModel = new MeetingModel();
        MeetingSchedule meetingSchedule = new MeetingSchedule();
        Map<String, String> update = new HashMap<>();
        Map<String, MeetingWrapper> meetingMap;

        if (null != bb) {
           
            //update.put(Biodata.CREATED_BY, agentId);
              System.out.println("Farmer Already Exist Id " + farmerID);
              System.out.println("Agent Id" + agentId);
            //System.out.println("Agent Id" + agentId);
            
           // biodataModel.BiodataUpdate(bb.getFarmerID(), update);
        } else {
            try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
                Map<String, String> imageUpdate = new HashMap<>();
                org.neo4j.graphdb.Node biodataNode = ICTCDBUtil.getInstance().getGraphDB().createNode();
                biodataNode.addLabel(Labels.FARMER);

                for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {
                    // System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                    if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") || rowNode.getChildNodes().item(k).getNodeName().equals("sf:CreatedById")) {
                        System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                        biodataNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                    }

                    if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text") && !rowNode.getChildNodes().item(k).getNodeName().equals("sf:CreatedById")) {
                        System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                        biodataNode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                    }
                }

                biodataNode.setProperty(Biodata.LAST_MODIFIED, new Date().getTime());
                log.log(Level.INFO, "new node created {0}", biodataNode.getId());

                Biodata farmer = new Biodata(biodataNode);

                JSONObject json = new JSONObject();
                json.put("requestType", "farmer");
                json.put("farmerId", farmer.getFarmerID());

                //get farmer image from salesforce and saves it
                String imageUrl = getFarmerImage(farmer.getFarmerID(), ICTCKonstants.SALESFORCEURL_PRODUCTION + ICTCKonstants.GET_IMAGES, json.toString());

                imageUpdate.put(Biodata.IMAGE_URL, imageUrl);
                biodataModel.BiodataUpdate(farmer.getFarmerID(), imageUpdate);

                //create farmer meeting schedule
                if (majorcrop.equalsIgnoreCase("Maize")) {
                    meetingMap = meetingSchedule.maizeFarmerMeeting("1");
                    for (Map.Entry<String, MeetingWrapper> entrySet : meetingMap.entrySet()) {
                        MeetingWrapper value = entrySet.getValue();
                        value.setAttended("0");
                        biodataModel.BiodataToMeeting(farmer.getId(), meetingModel.create(value).getUnderlyingNode());
                    }
                }

                if (majorcrop.equalsIgnoreCase("Yam")) {

                    meetingMap = meetingSchedule.yamFarmerMeeting("1");
                    for (Map.Entry<String, MeetingWrapper> entrySet : meetingMap.entrySet()) {

                        MeetingWrapper value = entrySet.getValue();
                        value.setAttended("0");
                        biodataModel.BiodataToMeeting(farmer.getId(), meetingModel.create(value).getUnderlyingNode());
                    }
                }

                if (majorcrop.equalsIgnoreCase("Rice")) {
                    meetingMap = meetingSchedule.riceFarmerMeeting("1");
                    for (Map.Entry<String, MeetingWrapper> entrySet : meetingMap.entrySet()) {
                        MeetingWrapper value = entrySet.getValue();
                        value.setAttended("0");
                        biodataModel.BiodataToMeeting(farmer.getId(), meetingModel.create(value).getUnderlyingNode());
                    }
                }

                if (majorcrop.equalsIgnoreCase("Cassava")) {
                    meetingMap = meetingSchedule.cassavaFarmerMeeting("1");
                    for (Map.Entry<String, MeetingWrapper> entrySet : meetingMap.entrySet()) {
                        MeetingWrapper value = entrySet.getValue();
                        value.setAttended("0");
                        biodataModel.BiodataToMeeting(farmer.getId(), meetingModel.create(value).getUnderlyingNode());
                    }
                }

                trx.success();
            }
        }
        return true;
    }
    
    public static boolean processFarmerX(Node rowNode, String farmerID, String agentId, String majorcrop) {
        System.out.println("Farmerx " + farmerID);
       
        BiodataModel biodataModel = new BiodataModel();
        Biodata bb = biodataModel.getBiodata("Id", farmerID);

        MeetingModel meetingModel = new MeetingModel();
        MeetingSchedule meetingSchedule = new MeetingSchedule();
        Map<String, String> update = new HashMap<>();
        Map<String, MeetingWrapper> meetingMap;

        if (null != bb) {
           
            //update.put(Biodata.CREATED_BY, agentId);
              System.out.println("Farmer Already Exist Id " + farmerID);
              System.out.println("Agent Id" + agentId);
            //System.out.println("Agent Id" + agentId);
            
           // biodataModel.BiodataUpdate(bb.getFarmerID(), update);
        } else {
            try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
                Map<String, String> imageUpdate = new HashMap<>();
                org.neo4j.graphdb.Node biodataNode = ICTCDBUtil.getInstance().getGraphDB().createNode();
                biodataNode.addLabel(Labels.FARMER);

                for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {
                    // System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                    if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") || rowNode.getChildNodes().item(k).getNodeName().equals("sf:CreatedById")) {
                        System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                        biodataNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                    }

                    if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text") && !rowNode.getChildNodes().item(k).getNodeName().equals("sf:CreatedById")) {
                        System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                        biodataNode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                    }
                }

                biodataNode.setProperty(Biodata.LAST_MODIFIED, new Date().getTime());
                log.log(Level.INFO, "new node created {0}", biodataNode.getId());

                Biodata farmer = new Biodata(biodataNode);

                JSONObject json = new JSONObject();
                json.put("requestType", "farmer");
                json.put("farmerId", farmer.getFarmerID());

                //get farmer image from salesforce and saves it
                String imageUrl = getFarmerImage(farmer.getFarmerID(), ICTCKonstants.SALESFORCEURL_PRODUCTION + ICTCKonstants.GET_IMAGESX, json.toString());

                imageUpdate.put(Biodata.IMAGE_URL, imageUrl);
                biodataModel.BiodataUpdate(farmer.getFarmerID(), imageUpdate);

                //create farmer meeting schedule
                if (majorcrop.equalsIgnoreCase("Maize")) {
                    meetingMap = meetingSchedule.maizeFarmerMeeting("1");
                    for (Map.Entry<String, MeetingWrapper> entrySet : meetingMap.entrySet()) {
                        MeetingWrapper value = entrySet.getValue();
                        value.setAttended("0");
                        biodataModel.BiodataToMeeting(farmer.getId(), meetingModel.create(value).getUnderlyingNode());
                    }
                }

                if (majorcrop.equalsIgnoreCase("Yam")) {

                    meetingMap = meetingSchedule.yamFarmerMeeting("1");
                    for (Map.Entry<String, MeetingWrapper> entrySet : meetingMap.entrySet()) {

                        MeetingWrapper value = entrySet.getValue();
                        value.setAttended("0");
                        biodataModel.BiodataToMeeting(farmer.getId(), meetingModel.create(value).getUnderlyingNode());
                    }
                }

                if (majorcrop.equalsIgnoreCase("Rice")) {
                    meetingMap = meetingSchedule.riceFarmerMeeting("1");
                    for (Map.Entry<String, MeetingWrapper> entrySet : meetingMap.entrySet()) {
                        MeetingWrapper value = entrySet.getValue();
                        value.setAttended("0");
                        biodataModel.BiodataToMeeting(farmer.getId(), meetingModel.create(value).getUnderlyingNode());
                    }
                }

                if (majorcrop.equalsIgnoreCase("Cassava")) {
                    meetingMap = meetingSchedule.cassavaFarmerMeeting("1");
                    for (Map.Entry<String, MeetingWrapper> entrySet : meetingMap.entrySet()) {
                        MeetingWrapper value = entrySet.getValue();
                        value.setAttended("0");
                        biodataModel.BiodataToMeeting(farmer.getId(), meetingModel.create(value).getUnderlyingNode());
                    }
                }

                trx.success();
            }
        }
        return true;
    }

    public static boolean processProduction(Node rowNode, String farmerID) {
        Boolean status = false;
        BiodataModel biodataModel = new BiodataModel();

        if (null != new ProductionModel().getProduction("Id", farmerID)) {
            System.out.println("Production already exist");
        } else {
            org.neo4j.graphdb.Node productionNewNode = ICTCDBUtil.getInstance().getGraphDB().createNode();
            productionNewNode.addLabel(Labels.PRODUCTION);
            productionNewNode = setNodeProperty(rowNode, productionNewNode);
            productionNewNode.setProperty(ProductionNew.LAST_MODIFIED, new Date().getTime());

            log.log(Level.INFO, "new node created {0}", productionNewNode.getId());

            Biodata b = biodataModel.getBiodata("Id", farmerID);
            biodataModel.BiodataToProduction(b.getId(), productionNewNode);

            if (modified(biodataModel, farmerID))
                System.out.println("Last modified done");

            status = true;
        }
        return status;
    }

    public static boolean processPostHarvest(Node rowNode, String farmerID) {
        Boolean status = false;
        BiodataModel biodataModel = new BiodataModel();

        if (null != new PostHarvestModel().getPostHarvest("Id", farmerID)) {
            System.out.println("PostHarvest already exist");
        } else {
            org.neo4j.graphdb.Node postHarvestNewNode = ICTCDBUtil.getInstance().getGraphDB().createNode();
            postHarvestNewNode.addLabel(Labels.POSTHARVEST);
            postHarvestNewNode = setNodeProperty(rowNode, postHarvestNewNode);
            postHarvestNewNode.setProperty(PostHarvest2.LAST_MODIFIED, new Date().getTime());

            // org.neo4j.graphdb.Node PostHarvestNewParent;
            // PostHarvestNewParent = ParentNode.PostHarvestParentNode();
            // PostHarvestNewParent.createRelationshipTo(postHarvestNewNode, ICTCRelationshipTypes.POST_HARVEST);

            log.log(Level.INFO, "new node created {0}", postHarvestNewNode.getId());

            Biodata b = biodataModel.getBiodata("Id", farmerID);
            biodataModel.BiodataToPostHarvest(b.getId(), postHarvestNewNode);
            if (modified(biodataModel, farmerID))
                System.out.println("Last modified done");

            status = true;
        }

        return status;
    }

    public static boolean processProductionUpdate(Node rowNode, String farmerID) {
        BiodataModel biodataModel = new BiodataModel();

        ProductionModel product = new ProductionModel();
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            org.neo4j.graphdb.Node productionUpdateNode = ICTCDBUtil.getInstance().getGraphDB().createNode();
            productionUpdateNode.addLabel(Labels.PRODUCTION_UPDATE);
            productionUpdateNode = setNodeProperty(rowNode, productionUpdateNode);
            productionUpdateNode.setProperty(ProductionUpdate.LAST_MODIFIED, new Date().getTime());

            log.log(Level.INFO, "new node created {0}", productionUpdateNode.getId());

           // ProductionNew p = product.getProduction("Id", farmerID);
           // product.ProductionToUpdate(p, productionUpdateNode);
             Biodata b = biodataModel.getBiodata("Id", farmerID);
           // product.ProductionToUpdate(p, productionUpdateNode);
             b.setProductionUpdate(productionUpdateNode);

            if (modified(biodataModel, farmerID)) {
                System.out.println("Last modified done");
            }
            
            trx.success();
        }

        return true;
    }

    public static boolean processPostHarvestUpdate(Node rowNode, String farmerID) {
        BiodataModel biodataModel = new BiodataModel();
        PostHarvestModel ph = new PostHarvestModel();
        try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            org.neo4j.graphdb.Node postHarvestUpdateNode = ICTCDBUtil.getInstance().getGraphDB().createNode();
            postHarvestUpdateNode.addLabel(Labels.POSTHARVEST_UPATE);
            postHarvestUpdateNode = setNodeProperty(rowNode, postHarvestUpdateNode);
            postHarvestUpdateNode.setProperty(PostHarvest2.LAST_MODIFIED, new Date().getTime());

            log.log(Level.INFO, "new node created {0}", postHarvestUpdateNode.getId());

//            PostHarvest2 p = ph.getPostHarvest("Id", farmerID);
//            ph.PostHarvestToUpdate(p, postHarvestUpdateNode);
              Biodata b = biodataModel.getBiodata("Id", farmerID);
                         b.setPostHarvestUpdate(postHarvestUpdateNode);
            if (modified(biodataModel, farmerID)) {
                System.out.println("Last modified done");
            }
        }

        return true;
    }

    public static boolean processProfile(Node rowNode, String farmerID) {
        BiodataModel biodataModel = new BiodataModel();
        Map<String, String> update = new HashMap<>();

        if (null != new ProfilingModel().getProfile("Id", farmerID)) {
            System.out.println("Profiling already exist");
        } else {
            try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
                org.neo4j.graphdb.Node profilingNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.PROFILE);
                profilingNode = setNodeProperty(rowNode, profilingNode);
                profilingNode.setProperty(Profiling.LAST_MODIFIED, new Date().getTime());

                log.log(Level.INFO, "new node created {0}", profilingNode.getId());

                Biodata b = biodataModel.getBiodata("Id", farmerID);
                biodataModel.BiodataToProfiling(b.getId(), profilingNode);
                //System.out.println("link created " + created);

                update.put(Biodata.CLUSTER, getCluster(getUserScore(farmerID)));
                update.put(Biodata.LAST_MODIFIED, String.valueOf(new Date().getTime()));
                biodataModel.BiodataUpdate(farmerID, update);
                trx.success();
            }
        }

        return true;
    }

    public static boolean processTechnicalNeeds(Node rowNode, String farmerID) {
        Boolean status = false;
        BiodataModel biodataModel = new BiodataModel();

        if (null != new TechnicalNeedsModel().getTechnicalNeed("Id", farmerID)) {
            System.out.println("Technical Needs already exist");
        } else {
            org.neo4j.graphdb.Node TNNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.TECHNICAL_NEEDS);
            TNNode = setNodeProperty(rowNode, TNNode);
            TNNode.setProperty(TechnicalNeed.LAST_MODIFIED, new Date().getTime());

            // org.neo4j.graphdb.Node TNParent;
            // TNParent = ParentNode.TechNeedParentNode();
            // TNParent.createRelationshipTo(TNNode, ICTCRelationshipTypes.TECHNICAL_NEED);

            log.log(Level.INFO, "new node created {0}", TNNode.getId());

            Biodata b = biodataModel.getBiodata("Id", farmerID);
            biodataModel.BiodataToTechNeeds(b.getId(), TNNode);

            if (modified(biodataModel, farmerID))
                System.out.println("Last modified done");

            status = true;
        }
        return status;
    }

    public static boolean processBaselineProductionBudget(Node rowNode, String farmerID) {
        boolean status = false;
        BiodataModel biodataModel = new BiodataModel();

        if (null != new BaselineProductionBudgetModel().getBaselineProductionBudget("Id", farmerID)) {
            System.out.println("Baseline Production Budget already exist");
        } else {

            try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
                org.neo4j.graphdb.Node BPBNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.BASELINE_PRODUCTION_BUDGET);
                BPBNode = setNodeProperty(rowNode, BPBNode);
                BPBNode.setProperty(BaselineProductionBudget.LAST_MODIFIED, new Date().getTime());

                // org.neo4j.graphdb.Node BPBParent;
                // BPBParent = ParentNode.BPBParentNode();
                // BPBParent.createRelationshipTo(BPBNode, ICTCRelationshipTypes.BASELINE_PRODUCTION_BUDGET);

                log.log(Level.INFO, "new node created {0}", BPBNode.getId());

                Biodata b = biodataModel.getBiodata("Id", farmerID);
                biodataModel.BiodataToBPB(b.getId(), BPBNode);

                if (modified(biodataModel, farmerID))
                    System.out.println("Last modified done");

                trx.success();
                status = true;
            }
        }

        return status;
    }

    public static boolean processBaselineProduction(Node rowNode, String farmerID) {
        boolean status = false;
        BiodataModel biodataModel = new BiodataModel();

        if (null != new BaselineProductionModel().getProduction("Id", farmerID)) {
            System.out.println("Baseline Production already exist");
        } else {
            try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
                org.neo4j.graphdb.Node BPNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.BASELINE_PRODUCTION);
                BPNode = setNodeProperty(rowNode, BPNode);
                BPNode.setProperty(BaselineProduction.LAST_MODIFIED, new Date().getTime());

                // org.neo4j.graphdb.Node BPBParent;
                // BPBParent = ParentNode.BPParentNode();
                // BPBParent.createRelationshipTo(BPNode, ICTCRelationshipTypes.BASELINE_PRODUCTION);

                log.log(Level.INFO, "new node created {0}", BPNode.getId());

                Biodata b = biodataModel.getBiodata("Id", farmerID);
                biodataModel.BiodataToBP(b.getId(), BPNode);

                if (modified(biodataModel, farmerID))
                    System.out.println("Last modified done");
                trx.success();
            }
            status = true;
        }
        return status;
    }

    public static boolean processBaselinePostHarvestBudget(Node rowNode, String farmerID) {
        BiodataModel biodataModel = new BiodataModel();

        if (null != new BaselinePostHarvestBudgetModel().getBaselinePostHarvestBudget("Id", farmerID)) {
            System.out.println("Baseline Post Harvest already exist");
        } else {
            try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
                org.neo4j.graphdb.Node BPHBNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.BASELINE_POST_HARVEST_BUDGET);
                BPHBNode = setNodeProperty(rowNode, BPHBNode);

                log.log(Level.INFO, "new node created {0}", BPHBNode.getId());

                Biodata b = biodataModel.getBiodata("Id", farmerID);
                biodataModel.BiodataToBPHB(b.getId(), BPHBNode);

                if (modified(biodataModel, farmerID)) { System.out.println("Last modified done"); }
                trx.success();
            }
        }
        return true;
    }

    public static boolean processBaselinePostHarvest(Node rowNode, String farmerID) {
        boolean status = false;
        BiodataModel biodataModel = new BiodataModel();

        if (null != new BaselinePostHarvestModel().getBaselinePostHarvest("Id", farmerID)) {
            System.out.println("Baseline Post Harvest already exist");
        } else {
            try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
                org.neo4j.graphdb.Node BPHNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.BASELINE_POST_HARVEST);

                BPHNode = setNodeProperty(rowNode, BPHNode);
                BPHNode.setProperty(BaselinePostHarvest.LAST_MODIFIED, new Date().getTime());

                // org.neo4j.graphdb.Node BPHParent;
                // BPHParent = ParentNode.BPHParentNode();
                // BPHParent.createRelationshipTo(BPHNode, ICTCRelationshipTypes.BASELINE_POSTHARVEST);

                log.log(Level.INFO, "new node created {0}", BPHNode.getId());

                Biodata b = biodataModel.getBiodata("Id", farmerID);
                biodataModel.BiodataToBPH(b.getId(), BPHNode);

                if (modified(biodataModel, farmerID))
                    System.out.println("Last modified done");

                trx.success();
            }
            status = true;
        }
        return status;
    }

    public static boolean processProductionBudget(Node rowNode, String farmerID) {
        boolean status = false;
        BiodataModel biodataModel = new BiodataModel();

        if (null != new FmpProductionBudgetModel().getFmpProductionBudget("Id", farmerID)) {
            System.out.println("FMP Production Budget already exist");
        } else {
            
            org.neo4j.graphdb.Node FMPPBNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.FMP_PRODUCTION_BUDGET);
            FMPPBNode = setNodeProperty(rowNode, FMPPBNode);

            // org.neo4j.graphdb.Node FMPPBParent;
            // FMPPBParent = ParentNode.FMPPBparentNode();
            // FMPPBParent.createRelationshipTo(FMPPBNode, ICTCRelationshipTypes.FMP_PRODUCTION_BUDGET);

            log.log(Level.INFO, "new node created {0}", FMPPBNode.getId());

            Biodata b = biodataModel.getBiodata("Id", farmerID);
            biodataModel.BiodataToFMPPB(b.getId(), FMPPBNode);

            if (modified(biodataModel, farmerID))
                System.out.println("Last modified done");

            status = true;
        }
        return status;
    }

    public static boolean processProductionBudgetUpdate(Node rowNode, String farmerID) {
        BiodataModel biodataModel = new BiodataModel();

        org.neo4j.graphdb.Node FMPPBUNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.PRODUCTION_BUDGET_UPDATE);
        FmpProductionBudgetModel fmp = new FmpProductionBudgetModel();

        System.out.println("farmerid " + farmerID);
        FMPPBUNode = setNodeProperty(rowNode, FMPPBUNode);
        FMPPBUNode.setProperty(FmpProductionBudgetUpdate.LAST_MODIFIED, new Date().getTime());

        log.log(Level.INFO, "new node created {0}", FMPPBUNode.getId());
//        FmpProductionBudget p = fmp.getFmpProductionBudget("Id", farmerID);
//        System.out.println("updated" + fmp.FmpProductionBudgetToUpdate(p, FMPPBUNode));
          Biodata b = biodataModel.getBiodata("Id", farmerID);           
         b.setProductionBudgetUpdate(FMPPBUNode);
        if (modified(biodataModel, farmerID))
            System.out.println("Last modified done");

        return true;
    }

    public static boolean processPostHarvestBudget(Node rowNode, String farmerID) {
        boolean status = false;
        BiodataModel biodataModel = new BiodataModel();

        if (null != new FmpPostHarvestBudgetModel().getFmpPostHarvestBudget("Id", farmerID)) {
            System.out.println("Baseline Post Harvest Budget already exist");
        } else {
            org.neo4j.graphdb.Node FMPPBHNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.FMP_POSTHARVEST_BUDGET);

            System.out.println("farmerid " + farmerID);
            FMPPBHNode = setNodeProperty(rowNode, FMPPBHNode);
            log.log(Level.INFO, "new node created {0}", FMPPBHNode.getId());

            Biodata b = biodataModel.getBiodata("Id", farmerID);
            biodataModel.BiodataToFMPPHB(b.getId(), FMPPBHNode);
            if (modified(biodataModel, farmerID))
                System.out.println("Last modified done");

            status = true;
        }

        return status;
    }

    public static boolean processPostHarvestBudgetUpdate(Node rowNode, String farmerID) {
        BiodataModel biodataModel = new BiodataModel();

          try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
        org.neo4j.graphdb.Node FMPPHBUNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.POSTHARVEST_BUDGET_UPDATE);
        FmpPostHarvestBudgetModel fmp = new FmpPostHarvestBudgetModel();

        System.out.println("farmerid " + farmerID);
        FMPPHBUNode = setNodeProperty(rowNode, FMPPHBUNode);
        FMPPHBUNode.setProperty(FmpProductionBudgetUpdate.LAST_MODIFIED, new Date().getTime());

        log.log(Level.INFO, "new node created {0}", FMPPHBUNode.getId());

        //FmpPostHarvestBudget p = fmp.getFmpPostHarvestBudget("Id", farmerID);

        //System.out.println("updated" + fmp.FmpPostHarvestBudgetToUpdate(p, FMPPHBUNode));
          Biodata b = biodataModel.getBiodata("Id", farmerID);
         b.setPostHarvestBudgetUpdate(FMPPHBUNode);

        if (modified(biodataModel, farmerID))
            System.out.println("Last modified done");
        trx.success();
          }
        return true;
    }

    public static boolean processFieldCropAssessment(Node rowNode, String farmerID) {
        BiodataModel biodataModel = new BiodataModel();
         Boolean status = false;
           if (null != new FieldCropAssessmentModel().getFieldCropAssessment("Id", farmerID)) {
                            
                  System.out.println("Field Crop Asessment already exist");
          }
           else
           {
        org.neo4j.graphdb.Node FCANode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.FIELD_CROP_ASSESSMENT);
        FCANode = setNodeProperty(rowNode, FCANode);
        FCANode.setProperty(FieldCropAssessment.LAST_MODIFIED, currentTimestamp());

        log.log(Level.INFO, "new node created {0}", FCANode.getId());

        Biodata b = biodataModel.getBiodata("Id", farmerID);
        biodataModel.BiodataToFCA(b.getId(), FCANode);

        CropAssessmentImage img;
        FieldCropAssessment fca = new FieldCropAssessment(FCANode);

        JSONArray m = new JSONArray();
        m.put(getImageId(fca.getPhoto_crop_establishment_status()));
        m.put(getImageId(fca.getPhoto_disease_mangement_status()));
        m.put(getImageId(fca.getPhoto_pest_management_status()));
        m.put(getImageId(fca.getPhoto_weed_management_status()));
        m.put(getImageId(fca.getPhoto_soil_fertility_status()));
        m.put(getImageId(fca.getPhotocropestablishment3()));
        m.put(getImageId(fca.getPhotocropestablisment2()));
        m.put(getImageId(fca.getPhotodisease2()));
        m.put(getImageId(fca.getPhotodisease3()));
        m.put(getImageId(fca.getPhotopestmanagement2()));
        m.put(getImageId(fca.getPhotopestmanagement3()));
        m.put(getImageId(fca.getPhotosoilfertility2()));
        m.put(getImageId(fca.getPhotosoilfertility3()));
        m.put(getImageId(fca.getPhotoweedstatus2()));

        JSONObject fc = new JSONObject();
        fc.put("requestType", "cropassessment");
        fc.put("farmerId", farmerID);
        fc.put("imageIds", m);

        Map<String, String> image_url = getCropAssessmentImage(ICTCKonstants.SALESFORCEURL_PRODUCTION + ICTCKonstants.GET_ASSESSMENT, fc.toString());

        for (Map.Entry<String, String> entrySet : image_url.entrySet()) {
            org.neo4j.graphdb.Node imageNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.IMAGE);
            String key = entrySet.getKey();
            String value = entrySet.getValue();

            if (getImageId(fca.getPhoto_crop_establishment_status()).equalsIgnoreCase(key)) {
                imageNode.setProperty(CropAssessmentImage.TAG, FieldCropAssessment.PHOTO_CROP_ESTABLISHMENT_STATUS);
                imageNode.setProperty(CropAssessmentImage.IMAGE, value);
            }
            if (getImageId(fca.getPhoto_disease_mangement_status()).equalsIgnoreCase(key)) {
                imageNode.setProperty(CropAssessmentImage.TAG, FieldCropAssessment.PHOTO_DISEASE_MANGEMENT_STATUS);
                imageNode.setProperty(CropAssessmentImage.IMAGE, value);
            }
            if (getImageId(fca.getPhoto_pest_management_status()).equalsIgnoreCase(key)) {
                imageNode.setProperty(CropAssessmentImage.TAG, FieldCropAssessment.PHOTO_PEST_MANAGEMENT_STATUS);
                imageNode.setProperty(CropAssessmentImage.IMAGE, value);
            }
            if (getImageId(fca.getPhoto_soil_fertility_status()).equalsIgnoreCase(key)) {
                imageNode.setProperty(CropAssessmentImage.TAG, FieldCropAssessment.PHOTO_SOIL_FERTILITY_STATUS);
                imageNode.setProperty(CropAssessmentImage.IMAGE, value);
            }

            if (getImageId(fca.getPhoto_weed_management_status()).equalsIgnoreCase(key)) {
                imageNode.setProperty(CropAssessmentImage.TAG, FieldCropAssessment.PHOTO_WEED_MANAGEMENT_STATUS);
                imageNode.setProperty(CropAssessmentImage.IMAGE, value);
            }
            if (getImageId(fca.getPhotocropestablishment3()).equalsIgnoreCase(key)) {
                imageNode.setProperty(CropAssessmentImage.TAG, FieldCropAssessment.PHOTOCROPESTABLISHMENT3);
                imageNode.setProperty(CropAssessmentImage.IMAGE, value);
            }
            if (getImageId(fca.getPhotocropestablisment2()).equalsIgnoreCase(key)) {
                imageNode.setProperty(CropAssessmentImage.TAG, FieldCropAssessment.PHOTOCROPESTABLISMENT2);
                imageNode.setProperty(CropAssessmentImage.IMAGE, value);
            }

            if (getImageId(fca.getPhotodisease2()).equalsIgnoreCase(key)) {
                imageNode.setProperty(CropAssessmentImage.TAG, FieldCropAssessment.PHOTODISEASE2);
                imageNode.setProperty(CropAssessmentImage.IMAGE, value);
            }
            if (getImageId(fca.getPhotodisease3()).equalsIgnoreCase(key)) {
                imageNode.setProperty(CropAssessmentImage.TAG, FieldCropAssessment.PHOTODISEASE3);
                imageNode.setProperty(CropAssessmentImage.IMAGE, value);
            }
            if (getImageId(fca.getPhotopestmanagement2()).equalsIgnoreCase(key)) {
                imageNode.setProperty(CropAssessmentImage.TAG, FieldCropAssessment.PHOTOPESTMANAGEMENT2);
                imageNode.setProperty(CropAssessmentImage.IMAGE, value);
            }
            if (getImageId(fca.getPhotopestmanagement3()).equalsIgnoreCase(key)) {
                imageNode.setProperty(CropAssessmentImage.TAG, FieldCropAssessment.PHOTOPESTMANAGEMENT3);
                imageNode.setProperty(CropAssessmentImage.IMAGE, value);
            }
            if (getImageId(fca.getPhotosoilfertility2()).equalsIgnoreCase(key)) {
                imageNode.setProperty(CropAssessmentImage.TAG, FieldCropAssessment.PHOTOSOILFERTILITY2);
                imageNode.setProperty(CropAssessmentImage.IMAGE, value);
            }
            if (getImageId(fca.getPhotosoilfertility3()).equalsIgnoreCase(key)) {
                imageNode.setProperty(CropAssessmentImage.TAG, FieldCropAssessment.PHOTOSOILFERTILITY3);
                imageNode.setProperty(CropAssessmentImage.IMAGE, value);
            }
            if (getImageId(fca.getPhotoweedstatus2()).equalsIgnoreCase(key)) {
                imageNode.setProperty(CropAssessmentImage.TAG, FieldCropAssessment.PHOTOWEEDSTATUS2);
                imageNode.setProperty(CropAssessmentImage.IMAGE, value);
            }
            img = new CropAssessmentImage(imageNode);
            fca.setImage(img);
        }

        if (modified(biodataModel, farmerID))
            System.out.println("Last modified done");
        
         status = true;
         }

        return status;
    }

    public static boolean processFarmCreditPlan(Node rowNode, String farmerID) {
        Boolean status = false;
        BiodataModel biodataModel = new BiodataModel();

        if (null != new FarmCreditPlanModel().getFarmCreditPlan("Id", farmerID)) {
            System.out.println("Farm Credit Plan already exist");
        } else {
            
           try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
            org.neo4j.graphdb.Node FCNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.FARM_CREDIT_PLAN);

            FCNode = setNodeProperty(rowNode, FCNode);
            FCNode.setProperty(FarmCreditPlan.LAST_MODIFIED, new Date().getTime());

           // org.neo4j.graphdb.Node FCParent;
           // FCParent = ParentNode.TechNeedParentNode();
           // FCParent.createRelationshipTo(FCNode, ICTCRelationshipTypes.HAS_FARMCREDIT_PLAN);

            log.log(Level.INFO, "new node created {0}", FCNode.getId());

            Biodata b = biodataModel.getBiodata("Id", farmerID);
            biodataModel.BiodataToFarmCreditPlan(b, FCNode);

            if (modified(biodataModel, farmerID))
                System.out.println("Last modified done");

            status = true;
              trx.success();
              }
         
        }
        return status;
    }

    public static boolean processFarmCreditPrevious(Node rowNode, String farmerID) {
        Boolean status = false;
        BiodataModel biodataModel = new BiodataModel();

        if (null != new FarmCreditPreviousModel().getFarmCreditPrevious("Id", farmerID)) {
            System.out.println("Farm Credit Previous already exist");
        } else {
            org.neo4j.graphdb.Node FCNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.FARM_CREDIT_PREVIOUS);
            FCNode = setNodeProperty(rowNode, FCNode);
            FCNode.setProperty(FarmCreditPlan.LAST_MODIFIED, new Date().getTime());

            org.neo4j.graphdb.Node FCParent;
          //  FCParent = ParentNode.TechNeedParentNode();
           // FCParent.createRelationshipTo(FCNode, ICTCRelationshipTypes.HAS_FARMCREDIT_PLAN);

            log.log(Level.INFO, "new node created {0}", FCNode.getId());

            Biodata b = biodataModel.getBiodata("Id", farmerID);
            biodataModel.BiodataToFarmCreditPlan(b, FCNode);

            if (modified(biodataModel, farmerID))
                System.out.println("Last modified done");

            status = true;
        }

        return status;
    }
    
    
    
      public static boolean processFarmCreditUpdate(Node rowNode, String farmerID) {
        Boolean status = false;
      //  FarmCreditPlanModel fm = new FarmCreditPlanModel();
         BiodataModel biodataModel = new BiodataModel();

      
            org.neo4j.graphdb.Node FCNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.FARM_CREDIT_UPDATE);
            FCNode = setNodeProperty(rowNode, FCNode);
            FCNode.setProperty(FarmCreditPlan.LAST_MODIFIED, new Date().getTime());

         

            log.log(Level.INFO, "new node created {0}", FCNode.getId());
             
            
//            
              Biodata b = biodataModel.getBiodata("Id", farmerID);
              biodataModel.BiodataToFarmCreditUpdate(b, FCNode);
           // FarmCreditPlan fcp = fm.getFarmCreditPlan("Id", farmerID);
            
            // System.out.println("updated" + fm.CreditPlanToUpdate(fcp, FCNode));

            if (modified(biodataModel, farmerID))
                System.out.println("Last modified done");

            status = true;
        

        return status;
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Helper Methods">

    public static org.neo4j.graphdb.Node setNodeProperty(Node rowNode, org.neo4j.graphdb.Node node) {
        for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {
            if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id")) {
                System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                node.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
            }
            if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text") && !rowNode.getChildNodes().item(k).getNodeName().equals("sf:Farmer_Biodata__c")) {
                System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                node.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
            }
        }
        return node;
    }

    public static String getObjectFieldName(String field) {
        String nodeName = field.substring(3);
        return nodeName.substring(0, nodeName.lastIndexOf("__"));
    }

    public static String getObjectFieldId(String id) {
        return id.substring(3);
    }

    public static Map<String,String> getCropAssessmentImage(String url,String detail) {
        Map<String,String> images = new HashMap<>();
        Map<String, String> parameters = new HashMap<>();

        parameters.put("data", detail);
        String root = "com.sun.aas.instanceRoot";
        String result = SalesforceHttpClient.getSalesforceData(url, parameters);
        JSONObject json = new JSONObject(result);
        JSONArray ja = json.getJSONArray("imageResults");

        String path;

        File f = new File(System.getProperty(root) + "/docroot/assessmentimages");
        if (!f.exists()) {
            boolean x = f.mkdirs();
            if (!x) { System.out.println("Could not create directories in getFarmerImage"); }
        }
        System.out.println("length :" + ja.length() );
        for(int i =0;i<ja.length();i++)
        {
            JSONObject o = (JSONObject) ja.get(i);

            path = f.getPath() + File.separator + i + "_" + o.getString("imageId")+".jpg";
            System.out.println("path " + path);
            byte[] data = Base64.decode(o.getString("imageData"));
            try (OutputStream stream = new FileOutputStream(path)) {
                stream.write(data);
                images.put(o.getString("imageId"), "/assessmentimages"+File.separator + i + "_" + o.getString("imageId")+".jpg");
            } catch (IOException ex) {
                Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
            }
        }

        return images;
    }

    public static String getCluster(int score) {
        if (score >= 46 && score <= 70)    { return "1"; }
        else if (score >=31 && score <=45) { return "2"; }
        else if (score >=16 && score <=30) { return "3"; }
        else { return "4"; }
    }

    public static int getUserScore(String user) {
        int score;
        String q6a;
        ProfilingModel pm = new ProfilingModel();
        Profiling p = pm.getProfile("Id", user);

        //System.out.println("Profile " + p.getFarmrecordkeepingstatus());
        //System.out.println("Family labor " +p.getRegfamilylabor_No() );
        String q2 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getFbomembership().toLowerCase()).getScore();
        String q6 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getFarmrecordkeepingstatus().toLowerCase()).getScore();
        String q5 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getOperatebankaccount().toLowerCase()).getScore();
        String q7 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getProducesoldproportion()).getScore();
        String q8 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getRiskdispositionborrow()).getScore();
        String q9 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getInnovativenessbytrying()).getScore();
        String q10 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getSoilfertilitypractices()).getScore();
        String q11 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getPostharvestlosses()).getScore();

        if(p.getRegfamilylabor_No().trim().equals("About 20% or less".trim()))
            q6a  ="7";
        else
            q6a = pm.getScoreByAnswer(Ouestion.ANSWER, p.getRegfamilylabor_No()).getScore();

        //System.out.println("results" + q2 + " " + q6 + " "+q6a +" "+ q5 + " " + q7 +
        //         " " + q8 + " " + q9 + " " + q10 + " " + q11);

        score = Integer.valueOf(q2) + Integer.valueOf(q5) + Integer.valueOf(q6)
                + Integer.valueOf(q7)
                + Integer.valueOf(q8) + Integer.valueOf(q9) + Integer.valueOf(q10) + Integer.valueOf(q11)+Integer.valueOf(q6a);

        //System.out.println("score" + score);
        //System.out.println("Cluster " + getCluster(score));
        return score;
    }

    public static String getXmlNodeValue(String node, Element element) {
        try {
            NodeList nList = element.getElementsByTagName(node).item(0).getChildNodes();
            Node nValue = nList.item(0);
            return nValue.getNodeValue();
        } catch (Exception e) {
            return "";
        }
    }

    public static String getFarmerImage(String farmer,String url,String detail) {
        String image_url;
        Map<String, String> parameters = new HashMap<>();
        parameters.put("data", detail);

        String result = SalesforceHttpClient.getSalesforceData(url, parameters);
        JSONObject json = new JSONObject(result);
        String res = json.getString("image");
        String root = "com.sun.aas.instanceRoot";

        File f = new File(System.getProperty(root) + "/docroot/images");

        if (!f.exists()) {
            boolean x = f.mkdirs();
            if (!x) { System.out.println("Could not create directories in getFarmerImage"); }
        }

        String path = f.getPath() + File.separator +farmer +".jpg";
        image_url = "/images"+File.separator +farmer +".jpg";
        byte[] data = Base64.decode(res);
        try (OutputStream stream = new FileOutputStream(path)) {
            stream.write(data);
        } catch (IOException ex) {
            Logger.getLogger(SalesforceMessageParser.class.getName()).log(Level.SEVERE, null, ex);
        }

        return image_url;
    }

    public static boolean modified(BiodataModel bm, String farmerId){
        Date now = new Date();
        return bm.lastmodifiedUpdate(farmerId, now.getTime());
    }

    public static String getImageId(String url) {
        return url.substring(url.indexOf("=")+1);
    }

    public static long currentTimestamp() {
        return new Date().getTime();
    }

    //</editor-fold>
}