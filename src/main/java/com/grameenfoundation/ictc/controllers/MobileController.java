/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;

import com.grameenfoundation.ictc.domains.Biodata;
import com.grameenfoundation.ictc.models.BiodataModel;
import com.grameenfoundation.ictc.wrapper.BiodataWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author skwakwa
 */
@WebServlet(name = "MobileController", urlPatterns = {"/MobileController"})
public class MobileController extends HttpServlet {

        private final static Logger log = Logger.getRootLogger();

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
        // Set the header response type

        try (PrintWriter out = response.getWriter()) {
            response.setContentType("application/json");
            
            String serviceCode = request.getParameter("action");
            JSONObject jSONObject = new JSONObject();
            
            if ("details".equals(serviceCode)) {

                BiodataModel bModel = new BiodataModel();
                List<BiodataWrapper> farmers = bModel.getBioData("a", "");
                JSONArray farmerArray = new JSONArray();
                for (BiodataWrapper farmer : farmers) {
                    JSONObject obj = new JSONObject();
                    try {
                          obj.put("fname",farmer.getFirstName());
                    System.out.println("Fname : "+farmer.getFirstName());
                    System.out.println("lname : "+farmer.getLastName());
                    obj.put("lname",farmer.getLastName());
                    obj.put("age",farmer.getAge());
                    obj.put("community",farmer.getCommunity());
                    obj.put("district",farmer.getDistrict());
                    obj.put("edu",farmer.getEducation());
                    obj.put("gender",farmer.getGender());
                    obj.put("nickname",farmer.getNickname());
                    obj.put("village",farmer.getVillage());
                    obj.put("region",farmer.getRegion());
                    obj.put("noc",farmer.getNumberOfChildren());
                    obj.put("ms",farmer.getMaritalStatus());
                    obj.put("nod",farmer.getNumberOfDependants());
                    
                    
                    obj.put("id",farmer.getFarmID());
                    obj.put("cluster",farmer.getCluster());
                    farmerArray.put(obj);
                    } catch (Exception e) {
                    }
                  
                }

                jSONObject.put("farmer", farmerArray);
                jSONObject.put("rc", "00");
                out.print(jSONObject);
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
