/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;

import com.grameenfoundation.ictc.domains.User;
import com.grameenfoundation.ictc.models.AgentModel;
import com.grameenfoundation.ictc.models.UserModel;
import com.grameenfoundation.ictc.utils.ICTCUtil;
import com.grameenfoundation.ictc.wrapper.UserWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author grameen
 */
@WebServlet(name = "UserController", urlPatterns = {"/user/add"})
public class UserController extends HttpServlet {

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
            String firstname = request.getParameter("fn");
            String lastname = request.getParameter("ln");
            String username = request.getParameter("un");
            String agenttype = request.getParameter("at");
          //  String agentcode = request.getParameter("ac");
            String organisation = request.getParameter("org");
            String password = request.getParameter("password");
            
            
            Map<String, String> generalResponse = new HashMap<>();
            UserModel userModel = new UserModel();
            

           UserWrapper userWrapper = new UserWrapper();
            

            userWrapper.setAgentType(agenttype);
            userWrapper.setLastName(agenttype);
            userWrapper.setFirstName(firstname);
            userWrapper.setLastName(lastname);
          //  userWrapper.setAgentCode(agentcode);
            userWrapper.setOrganisation(organisation);
            userWrapper.setUsername(username);
            userWrapper.setPassword(password);
            userWrapper.setID(String.valueOf(new Date().getTime()));
            
            
            User user = userModel.create(userWrapper);
            
            if(null!= user)
            {
               System.out.println("User Created");
                
            }
            else
            {
                System.out.println("Could not create User");
                generalResponse.put(ICTCUtil.ERROR, "User not created");
                ICTCUtil.redirect(request, response,"/users/adduser.jsp", "");
            }
            
            
               generalResponse.put(ICTCUtil.SUCCESS, "User Created"); 
               ICTCUtil.redirect(request, response,"/users/viewuser.jsp", "");

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
