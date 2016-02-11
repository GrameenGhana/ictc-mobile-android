/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;

import com.grameenfoundation.ictc.models.WeatherModel;
import com.grameenfoundation.ictc.utils.JSONWeatherParser;
import com.grameenfoundation.ictc.wrapper.WeatherHttpClient;
import com.grameenfoundation.ictc.wrapper.WeatherWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author skwakwa
 */
@WebServlet(name = "WeatherUpdaterController", urlPatterns = {"/api/v1/weather/update"})
public class WeatherUpdaterController extends HttpServlet {

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
            List<String> communities = new ArrayList<>();
            communities.add("Mampong");
            communities.add("Techiman");
            communities.add("Sunyani");
            communities.add("Hohoe");

            WeatherModel m = new WeatherModel();
            WeatherHttpClient weatherClient = new WeatherHttpClient();
            JSONWeatherParser weatherparser = new JSONWeatherParser();
            for (String community : communities) {
                try {
                    String weatherReport = weatherClient.getWeatherData(community);
                    if (null == weatherReport || weatherReport.isEmpty()) {
                    } else {
                        List<WeatherWrapper> weathersItem = JSONWeatherParser.getWeather(weatherReport);
                        m.createBulk(weathersItem);
                    }
                } catch (Exception e) {
                    System.out.println("Exception " + community + " : " + e.getLocalizedMessage());
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
        return "Updates weather Information of all Communities";
    }// </editor-fold>

}
