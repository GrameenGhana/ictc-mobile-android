/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/**
 *
 * @author grameen
 */
@WebServlet(name = "AgentController", urlPatterns = {"/agent/add"})
public class AgentController extends HttpServlet {

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
            String email = request.getParameter("email");
            String username = request.getParameter("un");
            String agenttype= request.getParameter("at");
            String phonenumber = request.getParameter("pn");
            String agentcode = request.getParameter("ac");
            
            
            
     String serverResponse = "";

     String url = "http://sandbox-ictchallenge.cs80.force.com/AgentRequest";
     
     
     
            JSONObject j = new JSONObject();
            j.put("agenttype", agenttype);
            j.put("firstname", firstname);
            j.put("lastname",lastname);
            j.put("email", email);
            j.put("username",username+"@ictc.org");
            j.put("phonenumber",phonenumber);
            
            

            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(url);
            
            System.out.println("data " + j.toString());
            
            List<NameValuePair> nameValuePairs = new ArrayList<>(1);
            nameValuePairs.add(new BasicNameValuePair("data",
                    j.toString()));
            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            HttpResponse resp = client.execute(post);
            BufferedReader rd = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
                out.println(line);
                serverResponse += line;

            }
            
             System.out.println(serverResponse);
    
            
            
            
            
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
