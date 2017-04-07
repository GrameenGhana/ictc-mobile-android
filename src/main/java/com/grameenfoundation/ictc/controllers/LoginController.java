/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;

import com.grameenfoundation.ictc.utils.ICTCUtil;
import com.grameenfoundation.ictc.utils.security.Authenticator;
import com.grameenfoundation.ictc.wrapper.UserWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author skwakwa
 */
@WebServlet(name = "LoginController", urlPatterns = {"/users/login"})
public class LoginController extends HttpServlet {

      public static String TAG =  LoginController.class.getName();
    public static Logger log = Logger.getLogger(TAG);
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
           String action = request.getParameter("action");
           if(action.equalsIgnoreCase("login")){
               String username = request.getParameter("username");
               String password = request.getParameter("password");
               Map<String,String> errors = new HashMap<String, String>();
               
               UserWrapper wr =  new  Authenticator().loginUser(username, password, action, request);       
               System.out.println("User logged in " + wr.getUsername());
               if(null== wr){
                   errors.put("login", "Invalid Credentials");
                   ICTCUtil.doRedirect("/login.jsp", request, response, errors);
               }else{
                   //ICTCUtil.doSuccessRedirect("/index.jsp", request, response, errors);
                   switch(wr.getAgentType())
                   {
                       case "grameen_admin":
                           log.info("Logged in as " + wr.getAgentType());
                        //ICTCUtil.redirect(request, response,"/index.jsp", "");
                         // response.sendRedirect(request.getContextPath()+"/v2/index.jsp");
                          response.sendRedirect(request.getContextPath()+"/v2/dashboards/gfsummary.jsp");
                           break;
                       case  "grameen_user":
                             log.info("Logged in as " + wr.getAgentType());
                        //ICTCUtil.redirect(request, response,"/index.jsp", ""); 
                             response.sendRedirect(request.getContextPath()+"/v2/dashboards/gfsummary.jsp");
                           break;
                       case  "acdivoca_admin":
                            log.info("Logged in as " + wr.getAgentType());
                             response.sendRedirect(request.getContextPath()+"/v2/top.jsp");
                             //  ICTCUtil.redirect(request, response,"/dashboard/acdivoca.jsp", ""); 
                           break;
                       case "acdivoca_ob":
                            log.info("Logged in as " + wr.getAgentType());
                               //ICTCUtil.redirect(request, response,"/v2/dashboards/obo.jsp", ""); 
                               response.sendRedirect(request.getContextPath()+"/v2/dashboards/obo.jsp");
                           break;
                       case "mofa_director":
                             log.info("Logged in as " + wr.getAgentType());
                              ICTCUtil.redirect(request, response,"/dashboard/mofa.jsp", ""); 
                             break;
                       default:
                       //ICTCUtil.redirect(request, response,"/login.jsp", "");
                            response.sendRedirect(request.getContextPath()+"/v2/login.jsp");
                   }
               }
           }
           else if(action.equalsIgnoreCase("logout")){
                
               if(Authenticator.logoutClient(request))
               {
                   log.info("user logged out");
                  // ICTCUtil.redirect(request, response,"/login.jsp", "");
                   response.sendRedirect(request.getContextPath()+"/v2/login.jsp");
               }
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
