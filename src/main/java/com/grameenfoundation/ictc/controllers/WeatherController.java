/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;

import com.grameenfoundation.ictc.models.WeatherModel;
import com.grameenfoundation.ictc.utils.ICTCUtil;
import com.grameenfoundation.ictc.wrapper.WeatherWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author skwakwa
 */
@WebServlet(name = "WeatherController", urlPatterns = {"/api/v1/weather"})
public class WeatherController extends HttpServlet {

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
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, HEAD, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");

        try (PrintWriter out = response.getWriter()) {
                        response.setContentType("application/json;charset=UTF-8");

            WeatherModel weatherModel = new  WeatherModel();
            List<WeatherWrapper>  weathers = weatherModel.getWeatherPerCommunity();
            JSONArray weatherArray = new JSONArray();
            for (WeatherWrapper weather : weathers) {
                JSONObject jobject = new JSONObject();
                jobject.put("city", weather.getLocation());
                jobject.put("temp", ICTCUtil.formatToDecimal(weather.getTemprature(),1));
                jobject.put("max_temp", ICTCUtil.formatToDecimal(weather.getMaxTemprature(),1));
                jobject.put("min_temp", ICTCUtil.formatToDecimal(weather.getMinTemprature(),1));
                jobject.put("detail",weather.getDetail());
                jobject.put("icon", weather.getIcon());
                
                weatherArray.put(jobject);
                        
            }
            
            out.print(weatherArray.toString());
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
