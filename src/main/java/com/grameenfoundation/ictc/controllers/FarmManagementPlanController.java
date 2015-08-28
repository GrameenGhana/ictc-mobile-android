/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;

import static com.grameenfoundation.ictc.controllers.SaleforceIntegrationController.getObjectFieldId;
import static com.grameenfoundation.ictc.controllers.SaleforceIntegrationController.getObjectFieldName;
import com.grameenfoundation.ictc.domains.Biodata;
import com.grameenfoundation.ictc.models.BiodataModel;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.ParentNode;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.io.IOUtils;
import org.neo4j.graphdb.Transaction;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author grameen
 */
@WebServlet(name = "FarmManagementPlanController", urlPatterns = {"/FarmManagementPlanController"})
public class FarmManagementPlanController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        Logger log = Logger.getLogger(FarmManagementPlanController.class.getName());
        BiodataModel biodataModel = new BiodataModel();
        String theString = IOUtils.toString(request.getInputStream(), "UTF-8");
        System.out.println("Salesforce data/n " + theString);
        Transaction tx;
        tx = ICTCDBUtil.getInstance().getGraphDB().beginTx();
        org.neo4j.graphdb.Node farmManagementPlanParent;
        try (PrintWriter out = response.getWriter()) {
           
           System.out.println(" " + request.getContentType());

                DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                InputSource is = new InputSource();
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
                // String farmerID = getXmlNodeValue("sf:Farmer_name__c",ele);
               
                
                  
                 for (int j = 0; j < sObject.getLength(); j++) {

                    Node rowNode = sObject.item(j);
                    //  Map<String,String> m = (Map<String,String>) rowNode.getAttributes();
                    String salesforceObj = rowNode.getAttributes().getNamedItem("xsi:type").getNodeValue();
                    System.out.println(salesforceObj);
                    String farmerID = getXmlNodeValue("sf:Farmer_Biodata__c",ele);
                    System.out.println("farmerid " + farmerID);
                     org.neo4j.graphdb.Node FMPNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.FARM_MANAGEMENT_PLAN);
                        for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {
                            
                            
                            //System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                            if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id")) {
                                System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));
                                FMPNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                            }

                            if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text")) {

                                System.out.println(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()));
                                FMPNode.setProperty(getObjectFieldName(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());

                            }
                        }

                        farmManagementPlanParent = ParentNode.FMPlanParentNode();
                        farmManagementPlanParent.createRelationshipTo(FMPNode, ICTCRelationshipTypes.FARM_MANAGEMENT_PLAN);

                        log.log(Level.INFO, "new node created {0}", FMPNode.getId());
                        Biodata b = biodataModel.getBiodata("Id",farmerID);
                        
                        biodataModel.BiodataToFMP(b.getId(),FMPNode);
                        
                        tx.success();

                       out.println(sendAck());
                    
                    
                 }
            
            
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(FarmManagementPlanController.class.getName()).log(Level.SEVERE, null, ex);
            tx.failure();
        } catch (SAXException ex) {
            tx.failure();
            Logger.getLogger(FarmManagementPlanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            
            tx.finish();
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
    
    
    

}
