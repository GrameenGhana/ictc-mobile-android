/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;

import static com.grameenfoundation.ictc.controllers.SaleforceIntegrationController.getObjectFieldId;
import static com.grameenfoundation.ictc.controllers.SaleforceIntegrationController.getObjectFieldName;
import com.grameenfoundation.ictc.domain.commons.Generalimpl;
import com.grameenfoundation.ictc.domains.BaselineProductionBudget;
import com.grameenfoundation.ictc.domains.Biodata;
import com.grameenfoundation.ictc.domains.FmpPostHarvestBudget;
import com.grameenfoundation.ictc.domains.FmpProductionBudget;
import com.grameenfoundation.ictc.domains.FmpProductionBudgetUpdate;
import com.grameenfoundation.ictc.domains.Ouestion;
import com.grameenfoundation.ictc.domains.PostHarvest2;
import com.grameenfoundation.ictc.domains.ProductionNew;
import com.grameenfoundation.ictc.domains.ProductionUpdate;
import com.grameenfoundation.ictc.domains.Profiling;
import com.grameenfoundation.ictc.models.BaselinePostHarvestBudgetModel;
import com.grameenfoundation.ictc.models.BaselinePostHarvestModel;
import com.grameenfoundation.ictc.models.BaselineProductionBudgetModel;
import com.grameenfoundation.ictc.models.BaselineProductionModel;
import com.grameenfoundation.ictc.models.BiodataModel;
import com.grameenfoundation.ictc.models.FieldCropAssessmentModel;
import com.grameenfoundation.ictc.models.FmpPostHarvestBudgetModel;
import com.grameenfoundation.ictc.models.FmpPostHarvestBudgetUpdateModel;
import com.grameenfoundation.ictc.models.FmpProductionBudgetModel;
import com.grameenfoundation.ictc.models.FmpProductionBudgetUpdateModel;
import com.grameenfoundation.ictc.models.MeetingModel;
import com.grameenfoundation.ictc.models.PostHarvestModel;
import com.grameenfoundation.ictc.models.PostHarvestUpdateModel;
import com.grameenfoundation.ictc.models.ProductionModel;
import com.grameenfoundation.ictc.models.ProductionUpdateModel;
import com.grameenfoundation.ictc.models.ProfilingModel;
import com.grameenfoundation.ictc.models.TechnicalNeedsModel;
import com.grameenfoundation.ictc.models.UserModel;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCKonstants;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.MeetingSchedule;
import com.grameenfoundation.ictc.utils.ParentNode;
import com.grameenfoundation.ictc.wrapper.BiodataWrapper;
import com.grameenfoundation.ictc.wrapper.MeetingWrapper;
import com.sun.jersey.core.util.Base64;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.neo4j.graphdb.Transaction;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author grameen
 */
@WebServlet(name = "SalesforceSyncServlet", urlPatterns = {"/sf/SalesforceSyncServlet"})
public class SalesforceSyncServlet extends HttpServlet {

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
        response.setContentType("text/xml;charset=UTF-8");
        Logger log = Logger.getLogger(SalesforceSyncServlet.class.getName());
        BiodataModel biodataModel = new BiodataModel();
        Biodata bb = null;
        MeetingSchedule meetingSchedule = new MeetingSchedule();
        MeetingModel  meetingModel = new MeetingModel();
        UserModel user = new UserModel();
        Map<String,MeetingWrapper> meetingMap = new HashMap<>();
        
        String farmerID = null ;
        
        
         try (PrintWriter out = response.getWriter()) {
             
            String theString = IOUtils.toString(request.getInputStream(), "UTF-8");
            System.out.println("Salesforce data/n " + theString);
            //gets request input stream
            InputStream in = request.getInputStream();
            InputSource input = null;
             
           // tx = ICTCDBUtil.getInstance().getGraphDB().beginTx();
            org.neo4j.graphdb.Node FarmerParent;
            
            
             try(Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

                System.out.println(" " + request.getContentType());
                //File xmlFile = new File("/home/grameen/test.xml");
                DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                InputSource is = new InputSource();
                Map<String,String> update = new HashMap<>();
                is.setCharacterStream(new StringReader(theString));
                System.out.println("After parsing XML");
                Document doc = db.parse(is);
               // Document doc = db.parse(xmlFile);   
                System.out.println("Should be normalised now");
                doc.getDocumentElement().normalize();
          
                Element ele = doc.getDocumentElement();
                //System.out.println("Root element :" + doc.getDocumentElement());
                Node node = doc.getDocumentElement();
                JSONObject json = new JSONObject();
                 //get fields from objects
                NodeList sObject = doc.getElementsByTagName("sObject");
                
                 for (int j = 0; j < sObject.getLength(); j++) {
                     
                     
                    Node rowNode = sObject.item(j);
                    //  Map<String,String> m = (Map<String,String>) rowNode.getAttributes();
                    String salesforceObj = rowNode.getAttributes().getNamedItem("xsi:type").getNodeValue();
                    System.out.println(salesforceObj);
                    
                    
                    
                     if (salesforceObj.equalsIgnoreCase("sf:Farmer_Biodata__c")) {
                        farmerID = getXmlNodeValue("sf:CreatedById",ele);
                        bb = biodataModel.getBiodata("Id", farmerID);
                       
                        
                        if(null!=bb )
                        {
                            update.put(Biodata.CREATED_BY,farmerID);
                            biodataModel.BiodataUpdate(bb.getFarmerID(), update);
                            out.println(sendAck());
                        
                        }
                        
                       else
                       {
                        Map<String,String> imageUpdate = new HashMap<>();
                        org.neo4j.graphdb.Node biodataNode = ICTCDBUtil.getInstance().getGraphDB().createNode();
                        biodataNode.addLabel(Labels.FARMER);
                        for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {
                            
                           // System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                            if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") ||rowNode.getChildNodes().item(k).getNodeName().equals("sf:CreatedById") ) {
                                System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
 
                                biodataNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                            }

                            if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text") && !rowNode.getChildNodes().item(k).getNodeName().equals("sf:CreatedById")) {

                                 System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                                biodataNode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());

                            }
                        }
                        
                        biodataNode.setProperty(Biodata.LAST_MODIFIED,new Date().getTime());
                        
                        FarmerParent = ParentNode.FarmerParentNode();
                        FarmerParent.createRelationshipTo(biodataNode, ICTCRelationshipTypes.FARMER);

                        log.log(Level.INFO, "new node created {0}", biodataNode.getId());
                      
                        
                        
                       
                        out.println(sendAck());
                        
                       // user.AgentToPostFarmer(agentID,biodataNode);
                        
                        
                        String majorcrop = getXmlNodeValue("sf:majorcrop__c", ele);
                        Biodata farmer = new Biodata(biodataNode);
                        
                        json.put("requestType","farmer");
                        json.put("farmerId", farmer.getFarmerID());
                        
                        //get farmer image from salesforce and saves it
                       //
                     String image_url = getFarmerImage(farmer.getFarmerID(),ICTCKonstants.SALESFORCEURL_PRODUCTION+ICTCKonstants.GET_IMAGES,json.toString());
                      //String image_url = getFarmerImage(farmer.getFarmerID(),ICTCKonstants.SALESFORCEURL_SANDBOX+ICTCKonstants.GET_IMAGES,json.toString());
                        
                        imageUpdate.put(Biodata.IMAGE_URL,image_url);
                        biodataModel.BiodataUpdate(farmer.getFarmerID(),imageUpdate);
                        
                        
                        
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
                     }
                    else if(salesforceObj.equalsIgnoreCase("sf:FMP_Production_New__c"))
                     {
                          farmerID = getXmlNodeValue("sf:Farmer_Biodata__c",ele);
                          
                         if (null != new ProductionModel().getProduction("Id", farmerID)) {
                               out.println(sendAck());
                             System.out.println("Production already exist");
                         } else {
                             org.neo4j.graphdb.Node ProductionNewParent;
                             org.neo4j.graphdb.Node productionNewNode = ICTCDBUtil.getInstance().getGraphDB().createNode();
                             productionNewNode.addLabel(Labels.PRODUCTION);

                             System.out.println("farmerid " + farmerID);
                             for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {

                                 //System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                                 if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id")) {
                                     System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                                     productionNewNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                                 }

                                 if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text") && !rowNode.getChildNodes().item(k).getNodeName().equals("sf:Farmer_Biodata__c")) {

                                     System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                                     productionNewNode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());

                                 }
                             }

                             productionNewNode.setProperty(ProductionNew.LAST_MODIFIED, new Date().getTime());

                             ProductionNewParent = ParentNode.ProductionParentNode();
                             ProductionNewParent.createRelationshipTo(productionNewNode, ICTCRelationshipTypes.PRODUCTION);

                             log.log(Level.INFO, "new node created {0}", productionNewNode.getId());

                             Biodata b = biodataModel.getBiodata("Id", farmerID);

                             biodataModel.BiodataToProduction(b.getId(), productionNewNode);

                             tx.success();

                             out.println(sendAck());

                         }

                     }
                      else if(salesforceObj.equalsIgnoreCase("sf:FMP_PostHarvest_New__c"))
                     {
                         farmerID = getXmlNodeValue("sf:Farmer_Biodata__c", ele);
                         
                         if (null != new PostHarvestModel().getPostHarvest("Id", farmerID)) {
                             out.println(sendAck());
                             System.out.println("PostHarvest already exist");
                         } else {
                             
                             org.neo4j.graphdb.Node PostHarvestNewParent;
                             org.neo4j.graphdb.Node postHarvestNewNode = ICTCDBUtil.getInstance().getGraphDB().createNode();
                             postHarvestNewNode.addLabel(Labels.POSTHARVEST);
                             
                             System.out.println("farmerid " + farmerID);
                             for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {

                                 //System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                                 if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id")) {
                                     System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                                     postHarvestNewNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                                 }
                                 
                                 if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text") && !rowNode.getChildNodes().item(k).getNodeName().equals("sf:Farmer_Biodata__c")) {
                                     
                                     System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                                     postHarvestNewNode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                                     
                                 }
                             }
                             
                             postHarvestNewNode.setProperty(PostHarvest2.LAST_MODIFIED, new Date().getTime());
                             
                             PostHarvestNewParent = ParentNode.PostHarvestParentNode();
                             PostHarvestNewParent.createRelationshipTo(postHarvestNewNode, ICTCRelationshipTypes.POST_HARVEST);
                             
                             log.log(Level.INFO, "new node created {0}", postHarvestNewNode.getId());
                             
                             Biodata b = biodataModel.getBiodata("Id", farmerID);
                             
                             biodataModel.BiodataToPostHarvest(b.getId(), postHarvestNewNode);
                             
                             tx.success();
                             
                             out.println(sendAck());
                         }

                         
                     }
                     
                      else if(salesforceObj.equalsIgnoreCase("sf:FMP_Production_Update__c"))
                      {
                          
                           farmerID = getXmlNodeValue("sf:Farmer_Biodata__c",ele);
                           
                           if (null != new ProductionUpdateModel().getProductionUpdate("Id", farmerID)) {
                              out.println(sendAck());
                              System.out.println("Production Update already exist");
                          } else {
                              
                              ProductionModel product = new ProductionModel();
                              
                              org.neo4j.graphdb.Node productionUpdateNode = ICTCDBUtil.getInstance().getGraphDB().createNode();
                              productionUpdateNode.addLabel(Labels.UPDATE);
                              
                              System.out.println("farmerid " + farmerID);
                              for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {

                                  //System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                                  if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id")) {
                                      System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                                      productionUpdateNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                                  }
                                  
                                  if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text") && !rowNode.getChildNodes().item(k).getNodeName().equals("sf:Farmer_Biodata__c")) {
                                      
                                      System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                                      productionUpdateNode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                                      
                                  }
                              }
                              
                              productionUpdateNode.setProperty(ProductionUpdate.LAST_MODIFIED, new Date().getTime());
                         // PostHarvestUpdateParent = ParentNode.PoostHarvestParentNode();
                              // PostHarvestUpdateParent.createRelationshipTo(postHarvestUpdateNode, ICTCRelationshipTypes.UPDATE);

                              log.log(Level.INFO, "new node created {0}", productionUpdateNode.getId());
                              
                              ProductionNew p = product.getProduction("Id", farmerID);
                              
                              product.ProductionToUpdate(p, productionUpdateNode);
                              
                              tx.success();
                              
                              out.println(sendAck());
                          }
                      }
                  else if(salesforceObj.equalsIgnoreCase("sf:FMP_PostHarvest_update__c"))
                      {
                         PostHarvestModel ph = new PostHarvestModel();
                         
                          farmerID = getXmlNodeValue("sf:Farmer_Biodata__c",ele);
                          if (null != new PostHarvestUpdateModel().getPostHarvestUpdate("Id", farmerID)) {
                             out.println(sendAck());
                             System.out.println("PostHarvest Update already exist");
                         } else {
                             
                          
                        org.neo4j.graphdb.Node postHarvestUpdateNode = ICTCDBUtil.getInstance().getGraphDB().createNode();
                        postHarvestUpdateNode .addLabel(Labels.UPDATE);
                      
                        System.out.println("farmerid " + farmerID);
                        for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {

                            //System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                            if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id")) {
                                System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                                 postHarvestUpdateNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                            }

                            if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text")&& !rowNode.getChildNodes().item(k).getNodeName().equals("sf:Farmer_Biodata__c")) {

                                System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                                postHarvestUpdateNode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());

                            }
                        }
                            
                          postHarvestUpdateNode.setProperty(PostHarvest2.LAST_MODIFIED, new Date().getTime());
                         // PostHarvestUpdateParent = ParentNode.PostHarvestParentNode();
                         // PostHarvestUpdateParent.createRelationshipTo(postHarvestUpdateNode, ICTCRelationshipTypes.UPDATE);

                        log.log(Level.INFO, "new node created {0}", postHarvestUpdateNode.getId());
                        
                        PostHarvest2 p   = ph.getPostHarvest("Id",farmerID);
                         
                         ph.PostHarvestToUpdate(p,postHarvestUpdateNode);
                            
                        
                         tx.success();

                        out.println(sendAck());
                          }
                         
                      }
                     else if(salesforceObj.equalsIgnoreCase("sf:Profiling__c"))
                      {
                          farmerID = getXmlNodeValue("sf:Farmer_Biodata__c",ele);
                         
                            if (null != new ProfilingModel().getProfile("Id", farmerID)) {
                             out.println(sendAck());
                             System.out.println("Profiling already exist");
                         } else {
                          org.neo4j.graphdb.Node profilingNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.PROFILE);
                          
                         
                          System.out.println("farmerid " + farmerID);
                           
                            for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {

                            //System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                            if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id")) {
                                System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                                 profilingNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                            }

                            if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text")&& !rowNode.getChildNodes().item(k).getNodeName().equals("sf:Farmer_Biodata__c")) {

                                System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                                profilingNode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());

                            }
                        }
                           
                          profilingNode.setProperty(Profiling.LAST_MODIFIED, new Date().getTime());

                          log.log(Level.INFO, "new node created {0}", profilingNode.getId());

                          Biodata b = biodataModel.getBiodata("Id", farmerID);

                          boolean created = biodataModel.BiodataToProfiling(b.getId(), profilingNode);

                          System.out.println("link created " + created);

                          

                          out.println(sendAck());        
                          
                          update.put(Biodata.CLUSTER, getCluster(getUserScore(farmerID)));
                          biodataModel.BiodataUpdate(farmerID, update);
                          
                           tx.success();
                            }
                      } 
                       else if(salesforceObj.equals("sf:TechnicalNeeds__c"))
                    {
                         farmerID = getXmlNodeValue("sf:Farmer_Biodata__c",ele);
                          if (null != new TechnicalNeedsModel().getTechnicalNeed("Id", farmerID)) {
                             out.println(sendAck());
                             System.out.println("Technical Needs already exist");
                         } else {
                        
                        
                        
                        
                        org.neo4j.graphdb.Node TNParent;
                        org.neo4j.graphdb.Node TNNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.TECHNICAL_NEEDS);
                        
                       
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
                    
                       tx.success();
                     
                          }
                    }
               else if(salesforceObj.equals("sf:BASELINE_PRODUCTION_BUDGET__c"))
                    {
                     
                        if (null != new BaselineProductionBudgetModel().getBaselineProductionBudget("Id", farmerID)) {
                            out.println(sendAck());
                            System.out.println("Baseline Production Budget already exist");
                        } else {

                            org.neo4j.graphdb.Node BPBParent;
                            org.neo4j.graphdb.Node BPBNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.BASELINE_PRODUCTION_BUDGET);

                            farmerID = getXmlNodeValue("sf:Farmer_Biodata__c", ele);
                            System.out.println("farmerid " + farmerID);
                            for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {

                                System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                                if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id")) {
                                    System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                                    BPBNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                                }

                                if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text") && !rowNode.getChildNodes().item(k).getNodeName().equals("sf:Farmer_Biodata__c")) {

                                    System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                                    BPBNode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());

                                }
                            }

                            BPBParent = ParentNode.BPBParentNode();
                            BPBParent.createRelationshipTo(BPBNode, ICTCRelationshipTypes.BASELINE_PRODUCTION_BUDGET);

                            log.log(Level.INFO, "new node created {0}", BPBNode.getId());

                            Biodata b = biodataModel.getBiodata("Id", farmerID);

                            biodataModel.BiodataToBPB(b.getId(), BPBNode);

                            out.println(sendAck());

                            tx.success();
                        }
                    }
                      else if(salesforceObj.equals("sf:BASELINE_PRODUCTION__c"))
                    {
                        
                        farmerID = getXmlNodeValue("sf:Farmer_Biodata__c",ele);
                        
                        if (null != new BaselineProductionModel().getProduction("Id", farmerID)) {
                            out.println(sendAck());
                            System.out.println("Baseline Production already exist");
                        } else {
                            org.neo4j.graphdb.Node BPBParent;
                            org.neo4j.graphdb.Node BPNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.BASELINE_PRODUCTION);
                            
                            System.out.println("farmerid " + farmerID);
                            for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {
                                
                                System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                                if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id")) {
                                    System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                                    BPNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                                }
                                
                                if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text") && !rowNode.getChildNodes().item(k).getNodeName().equals("sf:Farmer_Biodata__c")) {
                                    
                                    System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                                    BPNode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                                    
                                }
                            }
                            
                            BPBParent = ParentNode.BPParentNode();
                            BPBParent.createRelationshipTo(BPNode, ICTCRelationshipTypes.BASELINE_PRODUCTION);
                            
                            log.log(Level.INFO, "new node created {0}", BPNode.getId());
                            
                            Biodata b = biodataModel.getBiodata("Id", farmerID);
                            
                            biodataModel.BiodataToBP(b.getId(), BPNode);
                            
                            out.println(sendAck());
                            
                            tx.success();
                        }
                    }
                     
                    else if(salesforceObj.equals("sf:BASELINE_POST_HARVEST_BUDGET__c"))
                    {
                        farmerID = getXmlNodeValue("sf:Farmer_Biodata__c", ele);
                    
                          if (null != new BaselinePostHarvestBudgetModel().getBaselinePostHarvestBudget("Id", farmerID)) {
                            out.println(sendAck());
                            System.out.println("Baseline Post Harvest already exist");
                        } else {
                        
                        org.neo4j.graphdb.Node BPHBParent;
                        org.neo4j.graphdb.Node BPHBNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.BASELINE_POST_HARVEST_BUDGET);

                        
                        System.out.println("farmerid " + farmerID);
                        for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {

                            System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                            if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id")) {
                                System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                                BPHBNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                            }

                            if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text") && !rowNode.getChildNodes().item(k).getNodeName().equals("sf:Farmer_Biodata__c")) {

                                System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                                BPHBNode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());

                            }
                        }

                        BPHBParent = ParentNode.BPHBParentNode();
                        BPHBParent.createRelationshipTo(BPHBNode, ICTCRelationshipTypes.BASELINE_POSTHARVEST_BUDGET);

                        log.log(Level.INFO, "new node created {0}", BPHBNode.getId());

                        Biodata b = biodataModel.getBiodata("Id", farmerID);

                        biodataModel.BiodataToBPHB(b.getId(), BPHBNode);

                        out.println(sendAck());

                        tx.success();
                          }
                    }  else if(salesforceObj.equals("sf:BASELINE_POST_HARVEST__c"))
                    {
                        
                          farmerID = getXmlNodeValue("sf:Farmer_Biodata__c", ele);
                          if (null != new BaselinePostHarvestModel().getBaselinePostHarvest("Id", farmerID)) {
                            out.println(sendAck());
                            System.out.println("Baseline Post Harvest already exist");
                        } else {
                        org.neo4j.graphdb.Node BPHParent;
                        org.neo4j.graphdb.Node BPHNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.BASELINE_POST_HARVEST);

                      
                        System.out.println("farmerid " + farmerID);
                        for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {

                            System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                            if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id")) {
                                System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                                BPHNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                            }

                            if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text") && !rowNode.getChildNodes().item(k).getNodeName().equals("sf:Farmer_Biodata__c")) {

                                System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                                BPHNode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());

                            }
                        }

                        BPHParent = ParentNode.BPHParentNode();
                        BPHParent.createRelationshipTo(BPHNode, ICTCRelationshipTypes.BASELINE_POSTHARVEST);

                        log.log(Level.INFO, "new node created {0}", BPHNode.getId());

                        Biodata b = biodataModel.getBiodata("Id", farmerID);

                        biodataModel.BiodataToBPH(b.getId(), BPHNode);

                        out.println(sendAck());

                        tx.success();
                          }
                    }
               else if(salesforceObj.equals("sf:FMP_PRODUCTION_BUDGET__c"))
                    {
                        farmerID = getXmlNodeValue("sf:Farmer_Biodata__c", ele);
                        if (null != new FmpProductionBudgetModel().getFmpProductionBudget("Id", farmerID)) {
                            out.println(sendAck());
                            System.out.println("FMP Production Budget already exist");
                        } else {
                            org.neo4j.graphdb.Node FMPPBParent;
                            org.neo4j.graphdb.Node FMPPBNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.FMP_PRODUCTION_BUDGET);
                            
                            System.out.println("farmerid " + farmerID);
                            for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {
                                
                                System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                                if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id")) {
                                    System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                                    FMPPBNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                                }
                                
                                if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text") && !rowNode.getChildNodes().item(k).getNodeName().equals("sf:Farmer_Biodata__c")) {
                                    
                                    System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                                    FMPPBNode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                                    
                                }
                            }
                            
                            FMPPBParent = ParentNode.FMPPBparentNode();
                            FMPPBParent.createRelationshipTo(FMPPBNode, ICTCRelationshipTypes.FMP_PRODUCTION_BUDGET);
                            
                            log.log(Level.INFO, "new node created {0}", FMPPBNode.getId());
                            
                            Biodata b = biodataModel.getBiodata("Id", farmerID);
                            
                            biodataModel.BiodataToFMPPB(b.getId(), FMPPBNode);
                            
                            out.println(sendAck());
                            
                            tx.success();
                        }
                    }
                      else if(salesforceObj.equals("sf:FMP_PRODUCTION_BUDGET_UPDATE__c"))
                    {
                       farmerID = getXmlNodeValue("sf:Farmer_Biodata__c", ele);
                       
                       if (null != new FmpProductionBudgetUpdateModel().getFmpProductionBudgetUpdate("Id", farmerID)) {
                            out.println(sendAck());
                            System.out.println("Fmp Production budget already exist");
                        } else {
                        org.neo4j.graphdb.Node FMPPBUNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.UPDATE);
                        
                        FmpProductionBudgetModel fmp = new FmpProductionBudgetModel();
                        
                        
                        System.out.println("farmerid " + farmerID);
                        for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {

                            System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                            if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id")) {
                                System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                               FMPPBUNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                            }

                            if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text") && !rowNode.getChildNodes().item(k).getNodeName().equals("sf:Farmer_Biodata__c")) {

                                System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                                FMPPBUNode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());

                            }
                        }
                        
                        FMPPBUNode.setProperty(FmpProductionBudgetUpdate.LAST_MODIFIED,new Date().getTime());


                        log.log(Level.INFO, "new node created {0}",FMPPBUNode.getId());

                        FmpProductionBudget  p  = fmp.getFmpProductionBudget("Id", farmerID);
                         
                        System.out.println("updated" + fmp.FmpProductionBudgetToUpdate(p, FMPPBUNode) ); 

                        out.println(sendAck());

                        tx.success();
                       }
                    }
                      else if(salesforceObj.equals("sf:FMP_PH_Budget__c"))
                    {
                        
                        farmerID = getXmlNodeValue("sf:Farmer_Biodata__c", ele);
                       
                       if (null != new FmpPostHarvestBudgetModel().getFmpPostHarvestBudget("Id", farmerID) ) {
                            out.println(sendAck());
                            System.out.println("Baseline Post Harvest Budget already exist");
                        } else {
                        org.neo4j.graphdb.Node FMPPBHParent;
                        org.neo4j.graphdb.Node FMPPBHNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.FMP_POSTHARVEST_BUDGET);

                        
                        System.out.println("farmerid " + farmerID);
                        for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {

                            System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                            if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id")) {
                                System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                                FMPPBHNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                            }

                            if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text") && !rowNode.getChildNodes().item(k).getNodeName().equals("sf:Farmer_Biodata__c")) {

                                System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                                FMPPBHNode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());

                            }
                        }

                        FMPPBHParent = ParentNode.FMPPHBparentNode();
                        FMPPBHParent.createRelationshipTo(FMPPBHNode, ICTCRelationshipTypes.FMP_POSTHARVEST_BUDGET);

                        log.log(Level.INFO, "new node created {0}", FMPPBHNode.getId());

                        Biodata b = biodataModel.getBiodata("Id", farmerID);

                        biodataModel.BiodataToFMPPHB(b.getId(), FMPPBHNode);

                        out.println(sendAck());

                        tx.success();
                       }
                    }
                     
                       else if(salesforceObj.equals("sf:FMP_PH_Budget_update__c"))
                    {
                         farmerID = getXmlNodeValue("sf:Farmer_Biodata__c", ele);
                       
                       if (null != new FmpPostHarvestBudgetUpdateModel().getFmpPostHarvestBudgetUpdate("Id", farmerID) ) {
                            out.println(sendAck());
                            System.out.println("Baseline Post Harvest Budget Update already exist");
                        } else {
                        
                        org.neo4j.graphdb.Node FMPPHBUNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.UPDATE);
                        
                        FmpPostHarvestBudgetModel fmp = new FmpPostHarvestBudgetModel();
                        
                        System.out.println("farmerid " + farmerID);
                        for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {

                            System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                            if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id")) {
                                System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                              FMPPHBUNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                            }

                            if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text") && !rowNode.getChildNodes().item(k).getNodeName().equals("sf:Farmer_Biodata__c")) {

                                System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                               FMPPHBUNode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());

                            }
                        }
                        
                        FMPPHBUNode.setProperty(FmpProductionBudgetUpdate.LAST_MODIFIED,new Date().getTime());


                        log.log(Level.INFO, "new node created {0}",FMPPHBUNode.getId());

                        FmpPostHarvestBudget  p  = fmp.getFmpPostHarvestBudget("Id", farmerID);
                         
                        System.out.println("updated" + fmp.FmpPostHarvestBudgetToUpdate(p, FMPPHBUNode) ); 

                        out.println(sendAck());

                        tx.success();
                       }
                    }
                     else if(salesforceObj.equals("sf:FIELD_CROP_ASSESSMENT__c"))
                    {
                        
                        farmerID = getXmlNodeValue("sf:Farmer_Biodata__c", ele);
                       
                         if (null != new FieldCropAssessmentModel().getFieldCropAssessment("Id", farmerID)) {
                             out.println(sendAck());
                             System.out.println("Field Crop Asessment already exist");
                         } else {

                             org.neo4j.graphdb.Node FCAParent;
                             org.neo4j.graphdb.Node FCANode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.FIELD_CROP_ASSESSMENT);

                             System.out.println("farmerid " + farmerID + " " + FCANode.getId());
                             for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {

                                 System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                                 if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id")) {
                                     System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                                     FCANode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                                 }

                                 if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text") && !rowNode.getChildNodes().item(k).getNodeName().equals("sf:Farmer_Biodata__c")) {

                                     System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                                     FCANode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());

                                 }
                             }

                             FCAParent = ParentNode.FCAparentNode();
                             FCAParent.createRelationshipTo(FCANode, ICTCRelationshipTypes.FIELD_CROP_ASSESSMENT);

                             log.log(Level.INFO, "new node created {0}", FCANode.getId());

                             Biodata b = biodataModel.getBiodata("Id", farmerID);

                             biodataModel.BiodataToFCA(b.getId(), FCANode);

                             out.println(sendAck());

                             tx.success();
                         }
                     }
                    
                 }
                 

                System.out.println("Root element " + doc.getDocumentElement());
             }
            catch (Exception ex) {
              Logger.getLogger(SalesforceSyncServlet.class.getName()).log(Level.SEVERE, null, ex);
               ex.printStackTrace();
             // tx.failure();
          }
//           finally{
//                 tx.finish();
//             }
         
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
     
     
     
     public int getUserScore(String user) {
        ProfilingModel pm = new ProfilingModel();
        int score = 0;

        Profiling p = pm.getProfile("Id", user);

        System.out.println("Profile " + p.getFarmrecordkeepingstatus());
        String q2 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getFbomembership().toLowerCase()).getScore();
        String q6 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getFarmrecordkeepingstatus().toLowerCase()).getScore();
        String q5 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getOperatebankaccount().toLowerCase()).getScore();
        String q7 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getProducesoldproportion()).getScore();
        String q8 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getRiskdispositionborrow()).getScore();
        String q9 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getInnovativenessbytrying()).getScore();
        String q10 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getSoilfertilitypractices()).getScore();
        String q11 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getPostharvestlosses()).getScore();

        System.out.println("results" + q2 + " " + " " + q6 + " " + q5 + " " + q7 + " " + q8 + " " + q9 + " " + q10 + " " + q11);

        score = Integer.valueOf(q2) + Integer.valueOf(q5) + Integer.valueOf(q6) + Integer.valueOf(q7)
                + Integer.valueOf(q8) + Integer.valueOf(q9) + Integer.valueOf(q10) + Integer.valueOf(q11);

        System.out.println("score" + score);

        System.out.println("Cluster " + getCluster(score));

        return score;
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
      
      
       public String getCluster(int score)
    {
        System.out.println("score is " + score);
        if (score >= 46 && score <= 70) {
            return "1";
        } 
        else if (score >=31 && score <=45) {
            return "2";
        } else if (score >=16 && score <=20) {
            return "3";
        }
        else {
            return "4";
        }

    }
       
    public String getFarmerImage(String farmer,String url,String detail)
    {
         String image_url =""; 
         
         Map<String, String> parameters = new HashMap<String, String>();

            parameters.put("data", detail);

            String result = SalesforceHttpClient.getSalesforceData(url, parameters);
           // System.out.println(result);
            JSONObject json = new JSONObject(result);

            String res = json.getString("image");

            String root = "com.sun.aas.instanceRoot";
           
            String path = "";

            File f = new File(System.getProperty(root) + "/docroot/images");

            if (!f.exists()) {
                f.mkdirs();
            } 
            path = f.getPath() + File.separator +farmer +".jpg";
            System.out.println("path " + path);
            image_url = path;
            byte[] data = Base64.decode(res);
            try (OutputStream stream = new FileOutputStream(path)) {
                stream.write(data);
            } catch (FileNotFoundException ex) {
            Logger.getLogger(SalesforceSyncServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SalesforceSyncServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       return image_url;     
    }

}
