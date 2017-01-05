/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;

import com.grameenfoundation.ictc.domains.Aisdashboard;
import com.grameenfoundation.ictc.models.AisDashboardModel;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
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
@WebServlet(name = "NorthDataServlet", urlPatterns = {"/NorthDataServlet"})
public class NorthDataServlet extends HttpServlet {

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
        String output = "outputindicator";
        String farm = "farmmonitoring";
        String agent = "agentactivity";
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
            AisDashboardModel ais = new AisDashboardModel();
            String result = null;
            String action = request.getParameter("action");
       
            if(action.equalsIgnoreCase("all"))
            {
            
          
            result = getIndicator(output);
            if(null==ais.getIndicator(Aisdashboard.TYPE,output))
                ais.createIndicator(result,output);
            else
            {
             
                Map<String,String> update = new HashMap<>();
                update.put(Aisdashboard.DATA, result);
                
                ais.IndicatorUpdate(output, update);
                  
            }
         
            
           
            result = getIndicator(farm);
           if(null==ais.getIndicator(Aisdashboard.TYPE,farm))
            ais.createIndicator(result,farm);
            else
            {
                Map<String,String> update = new HashMap<>();
                update.put(Aisdashboard.DATA, result);
              
                    ais.IndicatorUpdate(farm, update);
                  
            }
          
            result = getIndicator(agent);
            if(null==ais.getIndicator(Aisdashboard.TYPE,agent))
            ais.createIndicator(result,agent);
            else
            {
                Map<String,String> update = new HashMap<>();
                update.put(Aisdashboard.DATA, result);
              
                    ais.IndicatorUpdate(agent, update);
                
            }
//           
          System.out.println("result " + result);
//   
          
           
            
           // trx.success();
           } 
            out.println(result);
         //JSONObject json = new JSONObject(result);
        }
        
        
        
        
    }
    
    public static String getIndicator(String parameter) {
        String result = null;
        Map<String, String> parameters = new HashMap<String, String>();

        parameters.put("action", parameter);

       // result = SalesforceHttpClient.getSalesforceData("http://188.166.30.140:8080/ICTC/DashboardServlet", parameters);
      result = SalesforceHttpClient.getSalesforceData("http://localhost:8080/ictc-webappbapptest/DashboardServlet", parameters);

        return result;
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
