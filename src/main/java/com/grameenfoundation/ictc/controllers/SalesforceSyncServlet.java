/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;

import com.grameenfoundation.ictc.utils.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.io.IOUtils;
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

        try (PrintWriter out = response.getWriter()) {
            String theString = IOUtils.toString(request.getInputStream(), "UTF-8");
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(theString));

            // throws an exception if the XML is malformed, in which case we discard this submission
            // and log an error
            db.parse(is);

            // insert in queue
            try {
                System.out.println("--- PUSHING item on QUEUE");
                QueueManager qm = new QueueManager();
                qm.createProducer("SalesforceSyncServlet");
                qm.send(theString);
                qm.closeConnection();
                out.println(sendAck());
            } catch (JMSException jmse) {
                Logger.getLogger(SalesforceSyncServlet.class.getName()).log(Level.SEVERE, null, jmse);
                jmse.printStackTrace();
            }

        } catch (Exception ex) {
            Logger.getLogger(SalesforceSyncServlet.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    public String sendAck() {
        return  "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\n"
                + "<soapenv:Body>\n"
                + "<notificationsResponse xmlns=\"http://soap.sforce.com/2005/09/outbound\">\n"
                + "<Ack>true</Ack>\n"
                + "</notificationsResponse>\n"
                + "</soapenv:Body>\n"
                + "</soapenv:Envelope>";
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
    }

    // </editor-fold>
    
}
              
                
