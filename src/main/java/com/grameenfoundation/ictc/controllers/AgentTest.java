package com.grameenfoundation.ictc.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static com.grameenfoundation.ictc.controllers.SaleforceIntegrationController.getObjectFieldId;
import static com.grameenfoundation.ictc.controllers.SaleforceIntegrationController.getObjectFieldName;
import com.grameenfoundation.ictc.domains.Agent;
import com.grameenfoundation.ictc.domains.Biodata;
import com.grameenfoundation.ictc.models.AgentModel;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Labels;
import com.grameenfoundation.ictc.utils.ParentNode;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
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
import org.json.JSONObject;
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
@WebServlet(urlPatterns = {"/AgentTest"})
public class AgentTest extends HttpServlet {

      Logger log = Logger.getLogger(AgentTest.class.getName());
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
          //  AgentModel agentModel = new AgentModel();
            
          String theString = IOUtils.toString(request.getInputStream(), "UTF-8");
          System.out.println("Salesforce data/n " + theString);

            try(Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx())
            {
               System.out.println(" " + request.getContentType());
                //File xmlFile = new File("/home/grameen/test2.xml");
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
                Date now = new Date();
                  for (int j = 0; j < sObject.getLength(); j++) {
                      
                  Node rowNode = sObject.item(j);
                    //  Map<String,String> m = (Map<String,String>) rowNode.getAttributes();
                    String salesforceObj = rowNode.getAttributes().getNamedItem("xsi:type").getNodeValue();
                    System.out.println(salesforceObj);
                    
                   org.neo4j.graphdb.Node AgentParent = ICTCDBUtil.getInstance().getGraphDB().createNode();
                       if (salesforceObj.equalsIgnoreCase("sf:User"))
                       {
                          
                           String agentId = getXmlNodeValue("sf:Id", ele);
                           String username = getXmlNodeValue("sf:Username", ele);
                           
                           String user = username.substring(0, username.indexOf("@"));
                          // agentModel.AgentUpdate(user, update)
//                           if(null!=agentModel.findUser(user))
//                           {
////                            update.put(Agent.AGENTID,agentId);
////                            agentModel.AgentUpdate(user, update);
//                               System.out.println("user already exists");
//                           }
                           if(true)
                           {
                               org.neo4j.graphdb.Node biodataNode = ICTCDBUtil.getInstance().getGraphDB().createNode();
                               biodataNode.addLabel(Labels.AGENT);
                               for (int k = 0; k < rowNode.getChildNodes().getLength(); k++) {

                                   // System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                                   if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") || rowNode.getChildNodes().item(k).getNodeName().equals("sf:CreatedById")) {
                                       System.out.println("id : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()));

                                       biodataNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName()), rowNode.getChildNodes().item(k).getTextContent());
                                   }

                                   if (!rowNode.getChildNodes().item(k).getNodeName().equals("sf:Id") && !rowNode.getChildNodes().item(k).getNodeName().equals("#text") && 
                                           !rowNode.getChildNodes().item(k).getNodeName().equals("sf:CreatedById")&& !rowNode.getChildNodes().item(k).getNodeName().equals("sf:Username") ) {

                                       System.out.println(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName().toLowerCase()));
                                       biodataNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName().toLowerCase()), rowNode.getChildNodes().item(k).getTextContent());

                                   }
                                    // System.out.println("node: " + rowNode.getChildNodes().item(k).getNodeName() + ": " + rowNode.getChildNodes().item(k).getTextContent());
                                   if (rowNode.getChildNodes().item(k).getNodeName().equals("sf:Username")) {
                                       System.out.println("username : " + getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName().toLowerCase()));

                                       biodataNode.setProperty(getObjectFieldId(rowNode.getChildNodes().item(k).getNodeName().toLowerCase()),user);
                                   }
                                   
                                   
                        }
                        
                        biodataNode.setProperty(Biodata.LAST_MODIFIED,new Date().getTime());
                        biodataNode.setProperty(Agent.PASSWORD,"test1234");
                        biodataNode.setProperty(Agent.AGENTCODE,"AG"+now.toString().substring(2));
                        biodataNode.setProperty(Agent.AGENTTYPE,"ACDIVOCA");
                        
                     //  AgentParent= ParentNode.AgentParentNode();
                       AgentParent.createRelationshipTo(biodataNode, ICTCRelationshipTypes.AGENT);

                        log.log(Level.INFO, "new node created {0}", biodataNode.getId() + " ");
                      
                        log.log(Level.INFO, "new node created {0}", new Agent(biodataNode).getAgentId() + " ");
                        
                        
                       
                         out.println(sendAck());
                           }
                           
                       }
                    
                    
                  }
                  
                  tx.success();
            }
             
           
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(AgentTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(AgentTest.class.getName()).log(Level.SEVERE, null, ex);
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
    
    
    
     public String getXmlNodeValue(String node, Element element) {
        NodeList nlist = element.getElementsByTagName(node).item(0).getChildNodes();
        try {
            Node nValue = (Node) nlist.item(0);
            return nValue.getNodeValue();
        } catch (Exception e) {
            return "";
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
