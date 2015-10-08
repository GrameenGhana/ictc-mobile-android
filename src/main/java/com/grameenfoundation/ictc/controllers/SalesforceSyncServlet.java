/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;

import static com.grameenfoundation.ictc.controllers.SaleforceIntegrationController.getObjectFieldId;
import static com.grameenfoundation.ictc.controllers.SaleforceIntegrationController.getObjectFieldName;
import com.grameenfoundation.ictc.domains.Biodata;
import com.grameenfoundation.ictc.domains.Ouestion;
import com.grameenfoundation.ictc.domains.PostHarvest2;
import com.grameenfoundation.ictc.domains.ProductionNew;
import com.grameenfoundation.ictc.domains.ProductionUpdate;
import com.grameenfoundation.ictc.domains.Profiling;
import com.grameenfoundation.ictc.models.BiodataModel;
import com.grameenfoundation.ictc.models.MeetingModel;
import com.grameenfoundation.ictc.models.PostHarvestModel;
import com.grameenfoundation.ictc.models.ProductionModel;
import com.grameenfoundation.ictc.models.ProfilingModel;
import com.grameenfoundation.ictc.models.UserModel;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.MeetingSchedule;
import com.grameenfoundation.ictc.utils.ParentNode;
import com.grameenfoundation.ictc.wrapper.MeetingWrapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
        MeetingSchedule meetingSchedule = new MeetingSchedule();
        MeetingModel  meetingModel = new MeetingModel();
        UserModel user = new UserModel();
        Map<String,MeetingWrapper> meetingMap = new HashMap<>();
        
        String farmerID = null ;
        
        
         try (PrintWriter out = response.getWriter()) {
             
           // String theString = IOUtils.toString(request.getInputStream(), "UTF-8");
           // System.out.println("Salesforce data/n " + theString);
            //gets request input stream
            InputStream in = request.getInputStream();
            InputSource input = null;
             
           // tx = ICTCDBUtil.getInstance().getGraphDB().beginTx();
            org.neo4j.graphdb.Node FarmerParent;
            
            
             try(Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

                System.out.println(" " + request.getContentType());
                File xmlFile = new File("/home/grameen/test.xml");
                DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                InputSource is = new InputSource();
                Map<String,String> update = new HashMap<>();
                //is.setCharacterStream(new StringReader(theString));
                System.out.println("After parsing XML");
                //Document doc = db.parse(is);
                Document doc = db.parse(xmlFile);   
                System.out.println("Should be normalised now");
                doc.getDocumentElement().normalize();
          
                 Element ele = doc.getDocumentElement();
                //System.out.println("Root element :" + doc.getDocumentElement());
                Node node = doc.getDocumentElement();
                
                 //get fields from objects
                NodeList sObject = doc.getElementsByTagName("sObject");
                
                 for (int j = 0; j < sObject.getLength(); j++) {
                     
                     
                    Node rowNode = sObject.item(j);
                    //  Map<String,String> m = (Map<String,String>) rowNode.getAttributes();
                    String salesforceObj = rowNode.getAttributes().getNamedItem("xsi:type").getNodeValue();
                    System.out.println(salesforceObj);
                    
                     if (salesforceObj.equalsIgnoreCase("sf:Farmer_Biodata__c")) {
                      
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
                        
                        biodataNode.setProperty(Biodata.LAST_MODIFIED,new Date().getTime());
                        
                        FarmerParent = ParentNode.FarmerParentNode();
                        FarmerParent.createRelationshipTo(biodataNode, ICTCRelationshipTypes.FARMER);

                        log.log(Level.INFO, "new node created {0}", biodataNode.getId());
                      
                        
                       
                        out.println(sendAck());
                        
                       // user.AgentToPostFarmer(agentID,biodataNode);
                        
                        
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
                    else if(salesforceObj.equalsIgnoreCase("sf:FMP_Production_New__c"))
                     {
                        org.neo4j.graphdb.Node ProductionNewParent;
                        org.neo4j.graphdb.Node productionNewNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.PRODUCTION);
                        
                       farmerID = getXmlNodeValue("sf:Farmer_Biodata__c",ele);
                        System.out.println("farmerid " + farmerID);
                        for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {

                            //System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                            if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id")) {
                                System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                                productionNewNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                            }

                            if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text")&& !rowNode.getChildNodes().item(k).getNodeName().equals("sf:Farmer_Biodata__c")) {

                                System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                               productionNewNode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());

                            }
                        }
                        
                        
                        productionNewNode.setProperty(ProductionNew.LAST_MODIFIED,new Date().getTime());

                        ProductionNewParent = ParentNode.ProductionParentNode();
                        ProductionNewParent.createRelationshipTo(productionNewNode, ICTCRelationshipTypes.PRODUCTION);

                        log.log(Level.INFO, "new node created {0}", productionNewNode.getId());
                        
                        Biodata b = biodataModel.getBiodata("Id",farmerID);
                        
                        biodataModel.BiodataToProduction(b.getId(),productionNewNode);
                        
                        
                        tx.success();

                        out.println(sendAck());
                         
                         
                         
                     }
                      else if(salesforceObj.equalsIgnoreCase("sf:FMP_PostHarvest_New__c"))
                     {
                        org.neo4j.graphdb.Node PostHarvestNewParent;
                        org.neo4j.graphdb.Node postHarvestNewNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.POSTHARVEST);
                        
                       farmerID = getXmlNodeValue("sf:Farmer_Biodata__c",ele);
                        System.out.println("farmerid " + farmerID);
                        for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {

                            //System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                            if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id")) {
                                System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                                postHarvestNewNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                            }

                            if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text")&& !rowNode.getChildNodes().item(k).getNodeName().equals("sf:Farmer_Biodata__c")) {

                                System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                               postHarvestNewNode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());

                            }
                        }
                        
                        
                        postHarvestNewNode.setProperty(PostHarvest2.LAST_MODIFIED,new Date().getTime());
                        
                        
                        PostHarvestNewParent = ParentNode.PostHarvestParentNode();
                        PostHarvestNewParent.createRelationshipTo(postHarvestNewNode, ICTCRelationshipTypes.POST_HARVEST);

                        log.log(Level.INFO, "new node created {0}", postHarvestNewNode.getId());
                        
                        Biodata b = biodataModel.getBiodata("Id",farmerID);
                        
                        biodataModel.BiodataToPostHarvest(b.getId(),postHarvestNewNode);
                        
                        
                        tx.success();

                        out.println(sendAck());
                         
                         
                         
                     }
                     
                      else if(salesforceObj.equalsIgnoreCase("sf:FMP_Production_Update__c"))
                      {
                          ProductionModel product = new ProductionModel();
                         
                        org.neo4j.graphdb.Node productionUpdateNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.UPDATE);
                        
                       farmerID = getXmlNodeValue("sf:Farmer_Biodata__c",ele);
                        System.out.println("farmerid " + farmerID);
                        for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {

                            //System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                            if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id")) {
                                System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                                 productionUpdateNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                            }

                            if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text")&& !rowNode.getChildNodes().item(k).getNodeName().equals("sf:Farmer_Biodata__c")) {

                                System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                                productionUpdateNode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());

                            }
                        }
                            
                          productionUpdateNode.setProperty(ProductionUpdate.LAST_MODIFIED, new Date().getTime());
                         // PostHarvestUpdateParent = ParentNode.PoostHarvestParentNode();
                         // PostHarvestUpdateParent.createRelationshipTo(postHarvestUpdateNode, ICTCRelationshipTypes.UPDATE);

                        log.log(Level.INFO, "new node created {0}", productionUpdateNode.getId());
                        
                         ProductionNew p  = product.getProduction("Id",farmerID);
                         
                         product.ProductionToUpdate(p,productionUpdateNode);
                            
                        
                       tx.success();

                        out.println(sendAck());
                         
                      }
                  else if(salesforceObj.equalsIgnoreCase("sf:FMP_PostHarvest_update__c"))
                      {
                         PostHarvestModel ph = new PostHarvestModel();
                          
                        org.neo4j.graphdb.Node postHarvestUpdateNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.UPDATE);
                        
                       farmerID = getXmlNodeValue("sf:Farmer_Biodata__c",ele);
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
                     else if(salesforceObj.equalsIgnoreCase("sf:Profiling__c"))
                      {
                         
                          ProfilingModel pm = new ProfilingModel();
                          
                          org.neo4j.graphdb.Node profilingNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.PROFILE);
                          
                          farmerID = getXmlNodeValue("sf:Farmer_Biodata__c",ele);
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

                          
                         
                          Profiling p =  pm.getProfile("Id", farmerID);
                          
                          System.out.println("Profile " + p.getFarmrecordkeepingstatus());
                          String q2 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getFbomembership().toLowerCase()).getScore();
                          String q6 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getFarmrecordkeepingstatus().toLowerCase()).getScore();
                          String q5 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getOperatebankaccount().toLowerCase()).getScore();
                          String q7 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getProducesoldproportion()).getScore();
                          String q8 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getRiskdispositionborrow()).getScore();
                          String q9 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getInnovativenessbytrying()).getScore();
                          String q10 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getSoilfertilitypractices()).getScore();
                          String q11 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getPostharvestlosses()).getScore();

                          
                          System.out.println("results"+ q2+" "+" "+q6+" "+q5+" "+q7+" "+q8+" "+q9+" "+q10+" "+q11);
                          
                         
                          int score = Integer.valueOf(q2)+Integer.valueOf(q5)+Integer.valueOf(q6)+Integer.valueOf(q7)+
                                  Integer.valueOf(q8)+Integer.valueOf(q9)+Integer.valueOf(q10)+Integer.valueOf(q11);
                          
                          System.out.println("score" + score);
                          
                          
                          System.out.println("Cluster " + getCluster(score));
                        
                         
                          
                          update.put(Biodata.CLUSTER, getCluster(score));
                          biodataModel.BiodataUpdate(farmerID, update);
                          
                           tx.success();
                      } 
                     
                    
                 }
                
                
                

                System.out.println("Root element " + doc.getDocumentElement());
             }
             catch (Exception ex) {
                Logger.getLogger(SalesforceSyncServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        if (score >= 45 && score <= 60) {
            return "1";
        } 
        else if (score >=30 && score <=45) {
            return "2";
        } else if (score >=16 && score <=29) {
            return "3";
        }
        else {
            return "4";
        }

    }

}
