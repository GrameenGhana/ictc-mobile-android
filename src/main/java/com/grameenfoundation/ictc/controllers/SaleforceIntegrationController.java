/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;

import static com.grameenfoundation.ictc.controllers.ictc.getObjectFieldId;
import static com.grameenfoundation.ictc.controllers.ictc.getObjectFieldName;
import com.grameenfoundation.ictc.domains.Biodata;
import com.grameenfoundation.ictc.models.BiodataModel;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.ParentNode;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
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
@WebServlet(name = "SaleforceIntegrationController", urlPatterns = {"/SaleforceIntegrationController"})
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
//                input = getInputSource("text/xml", in);
//                System.out.println("input " + input.toString());

//                File xmlFile = new File("/home/grameen/test.xml");
//                DocumentBuilderFactory db = DocumentBuilderFactory.newInstance();
//                DocumentBuilder builder = null;
//                
//                  try {
//                    builder = db.newDocumentBuilder();
//                } catch (ParserConfigurationException ex) {
//                    Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
//                }
                System.out.println(" " + request.getContentType());

                DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                InputSource is = new InputSource();
                is.setCharacterStream(new StringReader(theString));
                System.out.println("After parsing XML");
                Document doc = db.parse(is);
              //Get parsed xml
                //Document doc = parseXmlText(input);
//                Document doc = parseXmlText(input);
                // Document doc = builder.parse(xmlFile);
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

                    if (salesforceObj.equalsIgnoreCase("sf:FarmerBiodata__c")) {
                        org.neo4j.graphdb.Node biodataNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.FARMER);
                        for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {

                            System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
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
                        tx.success();

                        out.println(sendAck());
                    }
                    else if(salesforceObj.equals("sf:Harvest__c"))
                    {
                         org.neo4j.graphdb.Node HarvestParent;
                        org.neo4j.graphdb.Node harvestNode = ICTCDBUtil.getInstance().getGraphDB().createNode(Labels.HARVEST);
                        
                        String farmerID = getXmlNodeValue("sf:Farmer_Biodata__c",ele);
                        System.out.println("farmerid " + farmerID);
                        for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {

                            System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
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
                        
                        Biodata b = new BiodataModel().getBiodata("Id",farmerID);
                        
                        new  BiodataModel().BiodataToHarvest(b.getId(),harvestNode);
                        
                        
                        tx.success();

                        out.println(sendAck());
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

}
