/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;

import com.grameenfoundation.ictc.models.BiodataModel;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.wrapper.BiodataWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.neo4j.graphdb.Transaction;

/**
 *
 * @author grameen
 */
@WebServlet(name = "AgentCreateTest", urlPatterns = {"/AgentCreateTest"})
public class AgentCreateTest extends HttpServlet {

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
          try(Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx()){
            BiodataModel bio = new BiodataModel();
            
            List<BiodataWrapper> bw = new ArrayList<BiodataWrapper>();
            
            
            
            int septcount=0;
            int octcount=0;
            int novcount=0;
            int deccount = 0;
            int jancount =0;
            int febcount =0;
            int marcount =0;
            
            bw = bio.getBioData("","");
              System.out.println("size " + bw.size());
            for (BiodataWrapper biodataWrapper : bw) {
                
                System.out.println("data " + biodataWrapper.getLastmodifield());
                
                if(null!=biodataWrapper.getLastmodifield())
                {
                 Calendar cal = Calendar.getInstance();
                 cal.setTime(biodataWrapper.getLastmodifield());
                  
                    if (cal.get(Calendar.MONTH) == 11) {
                        deccount++;
                    }
                    if (cal.get(Calendar.MONTH) == 10) {
                        novcount++;
                    }
                    if (cal.get(Calendar.MONTH) == 9) {
                        octcount++;
                    }
                     if (cal.get(Calendar.MONTH) == 8) {
                        septcount++;
                    }
                     if (cal.get(Calendar.MONTH) == 0) {
                        jancount++;
                    }
                     if (cal.get(Calendar.MONTH) == 1) {
                        febcount++;
                    }
                      if (cal.get(Calendar.MONTH) == 2) {
                        marcount++;
                    }
                    
                }
            }
              
              System.out.println("count september " + septcount);
              System.out.println("count october " + octcount);
              System.out.println("count november " + novcount);
              System.out.println("count december " + deccount);
              System.out.println("count january " + jancount);
              System.out.println("count february " + febcount);
              System.out.println("count march " + marcount);
             tx.success();
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

}
