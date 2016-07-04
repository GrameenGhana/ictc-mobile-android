/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;

import com.grameenfoundation.ictc.domains.Agent;
import com.grameenfoundation.ictc.domains.Biodata;
import com.grameenfoundation.ictc.models.AgentModel;
import com.grameenfoundation.ictc.models.BiodataModel;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.wrapper.AgentWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
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
@WebServlet(name = "TempServlet", urlPatterns = {"/TempServlet"})
public class TempServlet extends HttpServlet {

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
            
            
            
            String mofagents[] = {"AGd Mar 16 18:59:09 EDT 2016","AGd Mar 16 19:03:01 EDT 2016","AGd Mar 16 19:05:20 EDT 2016",
            "AGd Mar 16 19:10:47 EDT 2016","AGd Mar 16 19:11:56 EDT 2016","AGd Mar 16 19:14:04 EDT 2016",
            "AGd Mar 16 19:16:10 EDT 2016","AGd Mar 16 19:35:40 EDT 2016","AGd Mar 16 19:37:33 EDT 2016",
            "AGd Mar 16 19:46:29 EDT 2016"};
            
           try(Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx()){
            AgentModel ag = new AgentModel();
            BiodataModel b = new BiodataModel();
            Agent age = null;
           List<AgentWrapper> agg = ag.findAllACDIAgents();
           List<AgentWrapper> agm = ag.findAllMOFAAgents();
           String  ACDIVOCAProfiling =null;
           String  MOFAProfiling = null;
           int profileCount = 0;
           int mprofileCount = 0;
           
           
               for (AgentWrapper agg1 : agg) {
                   
                   ACDIVOCAProfiling = String.valueOf(b.getFarmerProfileCountByAgent(agg1.getAgentId()));
                   profileCount+= Integer.valueOf(ACDIVOCAProfiling).intValue();
               }
               
               for (AgentWrapper agm1 : agm) {
                   
                    MOFAProfiling = String.valueOf(b.getFarmerProfileCountByAgent(agm1.getAgentId()));
                   mprofileCount+= Integer.valueOf( MOFAProfiling).intValue();
                   
               }
               
               
               System.out.println("Profiling " + profileCount);
               System.out.println("Profiling Mofa " + mprofileCount);
           
//            for(String agent : mofagents)
//            {
//                Map<String,String> update = new HashMap<String,String>();
//                age = ag.getAgent(Agent.AGENTCODE, agent.trim());
//                
//                System.out.println("agent " +age.getLastname() );
//                update.put(Agent.AGENTTYPE,"MOFA");
//                
//                System.out.println(ag.AgentUpdate(age.getUsername(), update));
//                
//            }
//            
            
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
