/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;

import com.grameenfoundation.ictc.domains.Biodata;
import com.grameenfoundation.ictc.domains.FarmManagement;
import com.grameenfoundation.ictc.domains.Harvest;
import com.grameenfoundation.ictc.domains.Marketing;
import com.grameenfoundation.ictc.domains.PostHarvest;
import com.grameenfoundation.ictc.domains.Storage;
import com.grameenfoundation.ictc.domains.TechnicalNeed;
import com.grameenfoundation.ictc.models.BiodataModel;
import com.grameenfoundation.ictc.models.FarmManagementModel;
import com.grameenfoundation.ictc.models.HarvestModel;
import com.grameenfoundation.ictc.models.MarketingModel;
import com.grameenfoundation.ictc.models.PostHarvestModel;
import com.grameenfoundation.ictc.models.StorageModel;
import com.grameenfoundation.ictc.models.TechnicalNeedsModel;
import com.grameenfoundation.ictc.utils.XMLParser;
import com.grameenfoundation.ictc.wrapper.BiodataWrapper;
import com.grameenfoundation.ictc.wrapper.FarmManagementWrapper;
import com.grameenfoundation.ictc.wrapper.HarvestWrapper;
import com.grameenfoundation.ictc.wrapper.MarketingWrapper;
import com.grameenfoundation.ictc.wrapper.PostHarvestWrapper;
import com.grameenfoundation.ictc.wrapper.StorageWrapper;
import com.grameenfoundation.ictc.wrapper.TechnicalNeedsWrapper;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author grameen
 */
@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})
public class TestServlet extends HttpServlet {

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
            throws ServletException, IOException, SAXException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            //String theString = IOUtils.toString(request.getInputStream(), "UTF-8");
            
            //out.println("<h1>Servlet TestServlet at " +theString + "</h1>");
            //System.out.println(theString);
            
        File xmlFile = new File("/home/grameen/test.xml");
        DocumentBuilderFactory db = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
            try {
                builder = db.newDocumentBuilder();
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        
         Document doc = builder.parse(xmlFile);
         
         doc.getDocumentElement().normalize();;
       
       System.out.println("Root element :" + doc.getDocumentElement());
       
            Node node = doc.getDocumentElement();
       
            System.out.println(node.hasChildNodes());
            String nodeName= null;
            org.neo4j.graphdb.Node nid = null;
            NodeList n =  doc.getElementsByTagName("sObject");
             NodeList nlst = node.getChildNodes();
             //Node object = n.item(1);
            System.out.println("object " + node.getChildNodes().getLength());
            
            
            
//            for (int i = 1; i < n.getLength(); i++) {
//                
//                Node nd = n.item(i);
//                
//                nodeName = nd.getNodeName().substring(3);
//                System.out.println(nodeName);
//                String nnn = nodeName.substring(0,nodeName.indexOf('_') );
//                 nid.setProperty(nnn, nd.getNodeValue());
//                 
//                System.out.println(nnn);
//            
//            }
//            
           
            
//            BiodataWrapper b = new BiodataWrapper();
//            
//            b.setFirstName("Kwesi ");
//            b.setLastName("Asera");
//            b.setCommunity("Akumadan");
//            b.setDistrict("Akumadan");
//            b.setVillage("Akumadan");
//            b.setRegion("Brong Ahafo Region");
//            b.setGender("Male");
//            b.setMaritalStatus("Divorced");
//            b.setNickname("Ratata");
//            b.setNumberOfChildren("2");
//            b.setNumberOfDependants("3");
//            b.setAge("45");
//            b.setDistrict("Akumadan");
//            b.setEducation("Secondary School");
//            
//            
//            new BiodataModel().createBiodata(b);
            
            
//            Biodata bi = new BiodataModel().getBiodata(Biodata.LAST_NAME,"Asera");
//            
//            FarmManagementWrapper fmw = new FarmManagementWrapper();
//            fmw.setFamilyLabor("2");
//            fmw.setFboMember("yes");
//            fmw.setFboName("Cool FBO");
//            fmw.setReferenceLeadFarmer("Kwame Abakah");
//            fmw.setBankAccount("yes");
//            fmw.setFarmRecordKeeping("yes");
//            fmw.setProductionObjective("2. Sells about 50% of produce.");
//            fmw.setDispostionToRisk("Annually");
//            fmw.setEntrepreneurship("1.At least every other year");
//            fmw.setLabourUse("1.My family manage the farm, no contribution to manual labor.");
//            
//            
//            
//            
//            FarmManagement fm = new FarmManagementModel().createFM(fmw);
//            HarvestWrapper hw = new HarvestWrapper();
//            hw.setTimeCropReadyToHarvest("2.Middle of July");
//            hw.setTimeCropHarvested("February");
//            hw.setNoLabourtotal("5");
//            hw.setNoFamilyLabour("2");
//            hw.setNoHiredLabour("3");
//            hw.setCostOfHiredLabour("150");
//            hw.setTimeCompletionHarvest("4");
//            
//            
//            Harvest hv = new HarvestModel().createFM(hw);
            
           // PostHarvestWrapper p = new PostHarvestWrapper();
           // PostHarvest ph = new PostHarvestModel().createPostHarvest(p);
           // StorageWrapper s =  new StorageWrapper();
           // Storage storage = new StorageModel().createFM(s);
            //MarketingWrapper m = new MarketingWrapper();
            //Marketing mk = new MarketingModel().createMarketing(m);
//           TechnicalNeedsWrapper tech = new TechnicalNeedsWrapper();
//           TechnicalNeed t = new TechnicalNeedsModel().createTechNeeds(tech);
//            
//            
//            BiodataModel bio = new BiodataModel();
//            
//            //new BiodataModel().BiodataToHarvest("Asera",hv.getUnderlyingNode());
//            
//            //bio.BiodataToPostHarvest("Asera",ph.getUnderlyingNode());
//            //bio.BiodataToStorage("Asera",storage.getUnderlyingNode());
//           // bio.BiodataToMarketing("Asera",mk.getUnderlyingNode());
//            bio.BiodataToTechNeeds("Asera",t.getUnderlyingNode());
            
//   String doc = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
//"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
//" <soapenv:Body>\n" +
//"  <notifications xmlns=\"http://soap.sforce.com/2005/09/outbound\">\n" +
//"   <OrganizationId>00D25000000D1WMEA0</OrganizationId>\n" +
//"   <ActionId>04k25000000003FAAQ</ActionId>\n" +
//"   <SessionId>00D25000000D1WM!AQUAQJPhwqlIm5elOzluRMpKPTbpgb5enecFP2aawxYeqv.tHHXp6ooKOolfTsG76QMFBB7xY_LMjygKjw3.EAEu2liGA.ys</SessionId>\n" +
//"   <EnterpriseUrl>https://taroworks-6058--sandbox.cs80.cloudforce.com/services/Soap/c/34.0/00D25000000D1WM</EnterpriseUrl>\n" +
//"   <PartnerUrl>https://taroworks-6058--sandbox.cs80.cloudforce.com/services/Soap/u/34.0/00D25000000D1WM</PartnerUrl>\n" +
//"   <Notification>\n" +
//"    <Id>04l250000000Z3UAAU</Id>\n" +
//"    <sObject xsi:type=\"sf:Cluster1__c\" xmlns:sf=\"urn:sobject.enterprise.soap.sforce.com\">\n" +
//"     <sf:Id>a1G25000000A2j1EAC</sf:Id>\n" +
//"     <sf:Farmer_id__c>234556</sf:Farmer_id__c>\n" +
//"     <sf:farmer_name__c>Kuuku</sf:farmer_name__c>\n" +
//"    </sObject>\n" +
//"   </Notification>\n" +
//"  </notifications>\n" +
//" </soapenv:Body>\n" +
//"</soapenv:Envelope>"  ;
//          
//         Document docu =   XMLParser.parseXmlText(doc);
//            
//            System.out.println("document" + docu.toString());  
            
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
        try {
            processRequest(request, response);
        } catch (SAXException ex) {
            Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SAXException ex) {
            Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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

}
