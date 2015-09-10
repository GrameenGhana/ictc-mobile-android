/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;

import static com.grameenfoundation.ictc.controllers.ictc.getObjectFieldId;
import static com.grameenfoundation.ictc.controllers.ictc.getObjectFieldName;
import com.grameenfoundation.ictc.domains.Biodata;
import com.grameenfoundation.ictc.domains.FarmManagement;
import com.grameenfoundation.ictc.domains.Harvest;
import com.grameenfoundation.ictc.domains.Operations;
import com.grameenfoundation.ictc.domains.Storage;
import com.grameenfoundation.ictc.domains.User;
import com.grameenfoundation.ictc.models.BiodataModel;
import com.grameenfoundation.ictc.models.FarmManagementModel;
import com.grameenfoundation.ictc.models.HarvestModel;
import com.grameenfoundation.ictc.models.MeetingModel;
import com.grameenfoundation.ictc.models.OperationsModel;
import com.grameenfoundation.ictc.models.StorageModel;
import com.grameenfoundation.ictc.models.UserModel;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.MeetingSchedule;
import com.grameenfoundation.ictc.utils.ParentNode;
import com.grameenfoundation.ictc.wrapper.MeetingWrapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.mail.internet.ContentType;
import org.apache.commons.io.IOUtils;
import org.neo4j.graphdb.Transaction;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import java.util.logging.Level;
import org.w3c.dom.Element;

/**
 *
 * @author grameen
 */
@WebServlet(name = "SaleforceIntegrationController", urlPatterns = {"/sf/SaleforceIntegrationController"})
public class SaleforceIntegrationController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Logger log = Logger.getLogger(SaleforceIntegrationController.class.getName());
        response.setContentType("text/xml;charset=UTF-8");
        BiodataModel biodataModel = new BiodataModel();
        MeetingSchedule meetingSchedule = new MeetingSchedule();
        MeetingModel  meetingModel = new MeetingModel();
        UserModel user = new UserModel();
        Map<String,MeetingWrapper> meetingMap = new HashMap<>();
        
        String farmerID = null ;
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String theString = IOUtils.toString(request.getInputStream(), "UTF-8");
            System.out.println("Salesforce data/n " + theString);
            //gets request input stream
            InputStream in = request.getInputStream();
            InputSource input = null;
            Transaction tx;
            tx = ICTCDBUtil.getInstance().getGraphDB().beginTx();
            org.neo4j.graphdb.Node FarmerParent;

            try {

                System.out.println(" " + request.getContentType());

                DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                InputSource is = new InputSource();
                Map<String,String> update = new HashMap<>();
                is.setCharacterStream(new StringReader(theString));
                System.out.println("After parsing XML");
                Document doc = db.parse(is);       
                System.out.println("Should be normalised now");
                doc.getDocumentElement().normalize();
          
                 Element ele = doc.getDocumentElement();
                //System.out.println("Root element :" + doc.getDocumentElement());
                Node node = doc.getDocumentElement();

                System.out.println("Root element " + doc.getDocumentElement());

                //get fields from objects
                NodeList sObject = doc.getElementsByTagName("sObject");
                
                for (int j = 0; j < sObject.getLength(); j++) {

                    Node rowNode = sObject.item(j);
                    //  Map<String,String> m = (Map<String,String>) rowNode.getAttributes();
                    String salesforceObj = rowNode.getAttributes().getNamedItem("xsi:type").getNodeValue();
                    System.out.println(salesforceObj);
                    
                    if (salesforceObj.equalsIgnoreCase("sf:Farmer_Biodata__c")) {
                        String agentID = getXmlNodeValue("sf:Agent__c", ele);
                        org.neo4j.graphdb.Node biodataNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.FARMER);
                        for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {
                            
                           // System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                            if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id")) {
                                System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                                biodataNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                            }

                            if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text")) {

                                System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                                biodataNode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());

                            }
                        }
                        
                        
                        FarmerParent = ParentNode.FarmerParentNode();
                        FarmerParent.createRelationshipTo(biodataNode, ICTCRelationshipTypes.FARMER);

                        log.log(Level.INFO, "new node created {0}", biodataNode.getId());
                      
                        
                       
                        out.println(sendAck());
                        
                        user.AgentToPostFarmer(agentID,biodataNode);
                        
                        
                        String majorcrop = getXmlNodeValue("sf:majorcrop__c", ele);
                        Biodata farmer = new Biodata(biodataNode);
                        
                        
                        
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

                        tx.success();
                    }
                    else if(salesforceObj.equals("sf:Agent__c"))
                    {
                        org.neo4j.graphdb.Node AgentParent;
                        org.neo4j.graphdb.Node userNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.AGENT);
                        for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {

                           // System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                            if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id")) {
                                System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                                userNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                            }
                             if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:agenttype")) {
                                System.out.println("agent type : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                                userNode.setProperty(User.AGENT_TYPE, rowNode.getChildNodes().item(k).getTextContent());
                            }
                            if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:agentcode")) {
                                System.out.println("agent code : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                                userNode.setProperty(User.USERNAME, rowNode.getChildNodes().item(k).getTextContent());
                                userNode.setProperty(User.PASSWORD, rowNode.getChildNodes().item(k).getTextContent());
                            }
                            if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text")&& !rowNode.getChildNodes().item(k).getNodeName().equals("sf:agenttype")) {

                                System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                                userNode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());

                            }
                        }

                        AgentParent = ParentNode.AgentParentNode();
                        AgentParent.createRelationshipTo(userNode, ICTCRelationshipTypes.AGENT);

                        log.log(Level.INFO, "new node created {0}", userNode.getId());
                        tx.success();

                        out.println(sendAck());
                    }
                    else if(salesforceObj.equals("sf:Harvest__c"))
                    {
                         org.neo4j.graphdb.Node HarvestParent;
                        org.neo4j.graphdb.Node harvestNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.HARVEST);
                        
                       farmerID = getXmlNodeValue("sf:Farmer_Biodata__c",ele);
                        System.out.println("farmerid " + farmerID);
                        for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {

                            //System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                            if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id")) {
                                System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                               harvestNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                            }

                            if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text")&& !rowNode.getChildNodes().item(k).getNodeName().equals("sf:Farmer_Biodata__c")) {

                                System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                               harvestNode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());

                            }
                        }

                        HarvestParent = ParentNode.HarvestParentNode();
                        HarvestParent.createRelationshipTo(harvestNode, ICTCRelationshipTypes.HARVEST);

                        log.log(Level.INFO, "new node created {0}", harvestNode.getId());
                        
                        Biodata b = biodataModel.getBiodata("Id",farmerID);
                        
                        biodataModel.BiodataToHarvest(b.getId(),harvestNode);
                        
                        
                        tx.success();

                        out.println(sendAck());
                    }
                     else if(salesforceObj.equals("sf:FarmManagement__c"))
                    {
                        org.neo4j.graphdb.Node FarmManagementParent;
                        org.neo4j.graphdb.Node FarmManagementNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.FARM_MANAGEMENT);
                        
                        farmerID = getXmlNodeValue("sf:Farmer_Biodata__c",ele);
                        System.out.println("farmerid " + farmerID);
                        for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {

                            //System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                            if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id")) {
                                System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                               FarmManagementNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                            }

                            if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text")&& !rowNode.getChildNodes().item(k).getNodeName().equals("sf:Farmer_Biodata__c")) {

                                System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                               FarmManagementNode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());

                            }
                        }

                       FarmManagementParent = ParentNode.FMParentNode();
                       FarmManagementParent.createRelationshipTo( FarmManagementNode, ICTCRelationshipTypes.FARM_MANAGEMENT);

                        log.log(Level.INFO, "new node created {0}", FarmManagementNode.getId());
                        
                        Biodata b = biodataModel.getBiodata("Id",farmerID);
                        
                        biodataModel.BiodataToFarmManagement(b.getId(), FarmManagementNode);
                        
                        
                        tx.success();

                        out.println(sendAck());
                    }
                     else if(salesforceObj.equals("sf:FarmOperations__c"))
                    {
                        org.neo4j.graphdb.Node FarmOperationParent;
                        org.neo4j.graphdb.Node FarmOperationNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.FARM_OPERATION);
                        
                        farmerID = getXmlNodeValue("sf:Farmer_Biodata__c",ele);
                        System.out.println("farmerid " + farmerID);
                        for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {

                            //System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                            if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id")) {
                                System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                               FarmOperationNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                            }

                            if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text")&& !rowNode.getChildNodes().item(k).getNodeName().equals("sf:Farmer_Biodata__c")) {

                                System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                               FarmOperationNode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());

                            }
                        }

                       FarmOperationParent = ParentNode.OperationsParentNode();
                      FarmOperationParent.createRelationshipTo( FarmOperationNode, ICTCRelationshipTypes.FARM_OPERATION);

                        log.log(Level.INFO, "new node created {0}", FarmOperationNode.getId());
                        
                        Biodata b = biodataModel.getBiodata("Id",farmerID);
                        
                        biodataModel.BiodataToOperations(b.getId(), FarmOperationNode);
                        
                        
                        tx.success();

                        out.println(sendAck());
                    }
                     else if(salesforceObj.equals("sf:Marketing__c"))
                    {
                        org.neo4j.graphdb.Node MarketingParent;
                        org.neo4j.graphdb.Node MarketingNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.MARKETING);
                        
                        farmerID = getXmlNodeValue("sf:Farmer_Biodata__c",ele);
                        System.out.println("farmerid " + farmerID);
                        for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {

                            //System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                            if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id")) {
                                System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                              MarketingNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                            }

                            if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text")&& !rowNode.getChildNodes().item(k).getNodeName().equals("sf:Farmer_Biodata__c")) {

                                System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                               MarketingNode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());

                            }
                        }

                       MarketingParent = ParentNode.MarketingParentNode();
                       MarketingParent.createRelationshipTo( MarketingNode, ICTCRelationshipTypes.MARKETING);

                        log.log(Level.INFO, "new node created {0}", MarketingNode.getId());
                        
                        Biodata b = biodataModel.getBiodata("Id",farmerID);
                        
                        biodataModel.BiodataToMarketing(b.getId(), MarketingNode);
                        
                        
                        tx.success();

                        out.println(sendAck());
                    }
                     else if(salesforceObj.equals("sf:PostHarvest__c"))
                    {
                        org.neo4j.graphdb.Node PostHarvestParent;
                        org.neo4j.graphdb.Node PostHarvestNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.POSTHARVEST);
                        
                        farmerID = getXmlNodeValue("sf:Farmer_Biodata__c",ele);
                        System.out.println("farmerid " + farmerID);
                        for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {

                           // System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                            if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id")) {
                                System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                              PostHarvestNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                            }

                            if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text")&& !rowNode.getChildNodes().item(k).getNodeName().equals("sf:Farmer_Biodata__c")) {

                                System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                               PostHarvestNode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());

                            }
                        }

                      PostHarvestParent = ParentNode.PostHarvestParentNode();
                       PostHarvestParent.createRelationshipTo( PostHarvestNode, ICTCRelationshipTypes.POST_HARVEST);

                        log.log(Level.INFO, "new node created {0}", PostHarvestNode.getId());
                        
                        Biodata b = biodataModel.getBiodata("Id",farmerID);
                        
                        biodataModel.BiodataToPostHarvest(b.getId(), PostHarvestNode);
                        
                        
                        tx.success();

                        out.println(sendAck());
                    }
                     else if(salesforceObj.equals("sf:Storage__c"))
                    {
                        org.neo4j.graphdb.Node StorageParent;
                        org.neo4j.graphdb.Node StorageNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.STORAGE);
                        
                        farmerID = getXmlNodeValue("sf:Farmer_Biodata__c",ele);
                        System.out.println("farmerid " + farmerID);
                        for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {

                            System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                            if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id")) {
                                System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                             StorageNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                            }

                            if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text")&& !rowNode.getChildNodes().item(k).getNodeName().equals("sf:Farmer_Biodata__c")) {

                                System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                               StorageNode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());

                            }
                        }

                       StorageParent = ParentNode.StorageParentNode();
                       StorageParent.createRelationshipTo( StorageNode, ICTCRelationshipTypes.STORAGE);

                        log.log(Level.INFO, "new node created {0}", StorageNode.getId());
                        
                        Biodata b = biodataModel.getBiodata("Id",farmerID);
                        
                        biodataModel.BiodataToStorage(b.getId(), StorageNode);
                        
                        
                        tx.success();
                        out.println(sendAck());
                       
                        
                    }
                    
                      else if(salesforceObj.equals("sf:TechnicalNeeds__c"))
                    {
                        org.neo4j.graphdb.Node TNParent;
                        org.neo4j.graphdb.Node TNNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.TECHNICAL_NEEDS);
                        
                        farmerID = getXmlNodeValue("sf:Farmer_Biodata__c",ele);
                        System.out.println("farmerid " + farmerID);
                        for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {

                            System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                            if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id")) {
                                System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                             TNNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                            }

                            if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text")&& !rowNode.getChildNodes().item(k).getNodeName().equals("sf:Farmer_Biodata__c")) {

                                System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                               TNNode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());

                            }
                        }

                        TNParent = ParentNode.TechNeedParentNode();
                        TNParent.createRelationshipTo(TNNode, ICTCRelationshipTypes.TECHNICAL_NEED);

                        log.log(Level.INFO, "new node created {0}", TNNode.getId());

                        Biodata b = biodataModel.getBiodata("Id", farmerID);

                        biodataModel.BiodataToTechNeeds(b.getId(), TNNode);
                       
                     
                        out.println(sendAck());
                       update.put(Biodata.CLUSTER, getCluster(getUserScore(farmerID)));
                       biodataModel.BiodataUpdate(farmerID, update);
                       tx.success();
                    }
                  
                }
                
                

            } catch (Exception ex) {
                Logger.getLogger(SaleforceIntegrationController.class.getName()).log(Level.SEVERE, null, ex);
                tx.failure();
            } finally {
                tx.finish();
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public static String getObjectFieldName(String field) {

        String nodeName = field.substring(3);
        System.out.println(nodeName);
        String finalField = nodeName.substring(0, nodeName.indexOf('_'));
        return finalField;

    }

    public static String getObjectFieldId(String id) {
        return id.substring(3);
    }
    
    public String getXmlNodeValue(String node, Element element) {
        NodeList nlist = element.getElementsByTagName(node).item(0).getChildNodes();
        try {
            Node nValue = (Node) nlist.item(0);
            return nValue.getNodeValue();
        } catch (Exception e) {
            return "";
        }
       }

    public static InputSource getInputSource(String ctype, InputStream in)
            throws Exception {

        // Creates ContentType
        ContentType contentType = null;
        try {
            contentType = new ContentType(ctype) {
            };
        } catch (Exception e) {
            System.out.println("Unexpected Error occured while creating content-type object. Reason: " + e.getMessage());
            throw new Exception(e.getMessage());
        }

        // Checks primitive type
        String primaryType = contentType.getPrimaryType();
        if (!"text".equals(primaryType)
                && !"application".equals(primaryType)) {
            System.out.println("Primary type received is " + primaryType + ". Only text or application primary type is expected");
            throw new Exception(ctype);
        }

        // Checks sub type
        String subType = contentType.getSubType();
        if (!"xml".equals(subType) && !subType.endsWith("+xml")) {
            System.out.println("sub type received is " + subType + ". Only xml sub type is expected");
            throw new Exception(ctype);
        }
        // Gets charset parameter
        String charset = contentType.getParameter("charset");
        if (charset == null) { // no charset
            // MIME type "text/*" omitted charset should be treated
            // as us-ascii
            if ("text".equals(contentType.getPrimaryType())) {
                charset = "us-ascii";
            }
        }

        InputSource input;
        if (charset == null) { // application/xml omitted charset

            input = new InputSource(in);

        } else {
            // Creats a reader with java charset
            Reader reader = null;
            try {
                reader = new InputStreamReader(in, charset);

            } catch (UnsupportedEncodingException e) {
                System.out.println("UnsupportedEncodingException. Reason: " + e.getMessage());
                throw new Exception(e.getMessage());
            }

            input = new InputSource(reader);
        }

        return input;
    }

    public static Document parseXmlText(InputSource input_data) {
        //get the factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            //Using factory get an instance of document builder
            DocumentBuilder db = dbf.newDocumentBuilder();

            //InputSource is = new InputSource();
            //is.setCharacterStream(new StringReader(data));
            //parse using builder to get DOM representation of the data
            Document doc = db.parse(input_data);
            // normalize text representation
            doc.getDocumentElement().normalize();
            System.out.println("Root element of the doc is " + doc.getDocumentElement().getNodeName());

            return doc;

        } catch (ParserConfigurationException pce) {
            System.out.println("Exception is " + pce.getLocalizedMessage());
            pce.printStackTrace();
            return null;
        } catch (SAXException se) {
            System.out.println("Exception is " + se.getLocalizedMessage());
            System.out.println("line " + se.getMessage());
            se.printStackTrace();
            return null;
        } catch (IOException ioe) {
            System.out.println("Exception is " + ioe.getLocalizedMessage());
            ioe.printStackTrace();
            return null;
        } catch (Exception ex) {
            System.out.println("Exception is " + ex.getLocalizedMessage());
            //    ioe.printStackTrace();
            return null;
        }
    }

    public String sendAck() {
        String ack = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\n"
                + "<soapenv:Body>\n"
                + "<notificationsResponse xmlns=\"http://soap.sforce.com/2005/09/outbound\">\n"
                + "<Ack>true</Ack>\n"
                + "</notificationsResponse>\n"
                + "</soapenv:Body>\n"
                + "</soapenv:Envelope>";

        return ack;
    }
    
    public int getUserScore(String user)
    {
        int score = 0;
        FarmManagement fm = new FarmManagementModel().getUserFarmManagent(user);
        Operations op = new OperationsModel().getUserOperations(user);
        Harvest ha = new HarvestModel().getUserHarvest(user);
        Storage st = new StorageModel().getUserStorage(user);
        System.out.println("In score method");
        System.out.println("user  " + user);
            //System.out.println("variety " + op.getTypeOfVariety());
            System.out.println("product objective " +fm.getProductionObjective().trim().charAt(0));
            System.out.println("Entrepreneurship "+fm.getEntrepreneurship().trim().charAt(0));
            System.out.println("Labour Use " + fm.getLabourUse().trim().charAt(0));
            System.out.println("Variety " + op.getTypeOfVariety().charAt(0));
            System.out.println("HerbicideUse " +op.getHerbicideUse().trim().charAt(0));
            System.out.println("Plantarrangement "+op.getPlantarrangement().trim().charAt(0));
            System.out.println("Maintenance of Fertility " +op.getMaintenanceofsoilfertility().trim().charAt(0));
            System.out.println("Regular application inorganic fertilizer " +op.getRegularappinorganicfertilizer().trim().charAt(0));
            System.out.println("Harvest " +ha.getYieldPerAcre().trim().charAt(0));
            System.out.println("Storage "+st.getPostHarvestLosses().trim().charAt(0));
        
        if(null!=fm && null!=op && null!=ha&& null!=st)
        {
            

            score =   Integer.parseInt(fm.getEntrepreneurship().substring(0,1))
                    + Integer.parseInt(fm.getProductionObjective().substring(0,1))
                    + Integer.parseInt(fm.getLabourUse().substring(0,1))
                    + Integer.parseInt(op.getTypeOfVariety().substring(0,1))
                    + Integer.parseInt(op.getHerbicideUse().substring(0,1))
                    + Integer.parseInt(op.getPlantarrangement().substring(0,1))
                    + Integer.parseInt(op.getMaintenanceofsoilfertility().substring(0,1))
                    + Integer.parseInt(op.getRegularappinorganicfertilizer().substring(0,1))
                    + Integer.parseInt(ha.getYieldPerAcre().substring(0,1))
                    + Integer.parseInt(st.getPostHarvestLosses().substring(0,1));
            System.out.println("Score is " + score);
        } else
            System.out.println("score not done");

        return score;
        
    }
    
    
    public String getCluster(int score)
    {
        if (score < 10) {
            System.out.println("Score is less than 10");
        };
        if (score >= 10 && score <= 12) {
            return "1";
        } else if (score >= 13 && score <= 22) {
            return "2";
        } else {
            return "3";
        }

    }
        
    }


