/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;

import com.grameenfoundation.ictc.domains.MeetingSetting;
import com.grameenfoundation.ictc.models.CropCalendarSettingModel;
import com.grameenfoundation.ictc.models.MeetingSettingModel;
import com.grameenfoundation.ictc.wrapper.CropCalendarSettingWrapper;
import com.grameenfoundation.ictc.wrapper.MeetingSettingWrapper;
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
@WebServlet(name = "TmpServlet", urlPatterns = {"/TmpServlet"})
public class TmpServlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TmpServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TmpServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            CropCalendarSettingModel cropCalendarModel = new CropCalendarSettingModel();
            List<CropCalendarSettingWrapper> settings = new ArrayList<>();
            CropCalendarSettingWrapper setting = new CropCalendarSettingWrapper("Maize", -3, -3, "Land Clearing");
            settings.add(setting);
            setting = new CropCalendarSettingWrapper("Maize", -1, -1, "Land preparation");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Maize", 0, 0, "Planting (Crop Establishment)");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Maize", 1, 1, "Refilling");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Maize", 4, 4, "First weed control");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Maize", 5, 5, "First Fertilizer application");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Maize", 8, 8, "Second Weed control");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Maize", 9, 9, "Second Fertilizer application");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Maize", 12, 15, "Final Harvest");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Rice", -4, -4, "Land Clearing");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Rice", -2, -2, "Land preparation");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Rice", -1, -1, "Seedbed preparation");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Rice", 0, 0, "Planting (Crop Establishment)");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Rice", 3, 3, "First weed control");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Rice", 4, 4, "First Fertilizer application");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Rice", 7, 7, "Second Fertilizer application");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Rice", 12, 15, "Final Harvest");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Yam", -6, -6, "Land Clearing");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Yam", -4, -4, "Land preparation");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Yam", -2, -2, "Seedbed preparation");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Yam", 0, 0, "Planting (Crop Establishment)");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Yam", 5, 5, "First weed control");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Yam", 8, 8, "Second Weed control");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Yam", 9, 9, "Fertilizer application");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Yam", 16, 16, "Third Weed control");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Yam", 28, 28, "First Harvest");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Yam", 40, 40, "Final Harvest");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Cassava", -4, -4, "Land Clearing");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Cassava", -2, 2, "land preparation");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Cassava", -1, -1, "Seedbed preparation");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Cassava", 0, 0, "Planting (Crop Establishment)");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Cassava", 3, 3, "Refilling");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Cassava", 4, 4, "First weed control");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Cassava", 6, 6, "First Fertilizer application");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Cassava", 8, 8, "Second Weed control");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Cassava", 15, 15, "Third Weed control");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Cassava", 24, 24, "Fourth Weed control (optional)");
            settings.add(setting);

            setting = new CropCalendarSettingWrapper("Cassava", 56, 56, "Final Harvest");
            settings.add(setting);

            for (CropCalendarSettingWrapper set : settings) {
//                cropCalendarModel.create(set);
            }

            /**
             *
             * public MeetingSettingWrapper(String type, String meetingIndex,
             * String season, String startDate, String endDate, String acts) {
             * this.type = type;
             *
             *
             */
            List<MeetingSettingWrapper> meetings = new ArrayList<MeetingSettingWrapper>();
            MeetingSettingWrapper meeting = new MeetingSettingWrapper("Maize", "Group", "1", "1", "02", "02", "Land Clearing,Land preparation (ploughing)");
            meetings.add(meeting);

            meeting = new MeetingSettingWrapper("Maize", "Individual", "1", "1", "03", "03", "Planting,First weed control (if no herbicide applied),Basal Fertilizer application");
            meetings.add(meeting);

            meeting = new MeetingSettingWrapper("Maize", "Group", "1", "2", "05", "05", "First/Second Weeding,Top-dress fertilizer application");
            meetings.add(meeting);

            meeting = new MeetingSettingWrapper("Maize", "Individual", "2", "1", "06", "06", "Harvesting ");
            meetings.add(meeting);

            meeting = new MeetingSettingWrapper("Maize", "Group", "1", "3", "07", "07", "Post-harvest processing");
            meetings.add(meeting);
            meeting = new MeetingSettingWrapper("Maize", "Group", "1", "4", "09", "09", "");
            meetings.add(meeting);

            meeting = new MeetingSettingWrapper("Cassava", "Group", "1", "1", "02-10", "02-01", "Land Clearing,Land preparation (ploughing)");
            meetings.add(meeting);

            meeting = new MeetingSettingWrapper("Cassava", "Individual", "1", "1", "02-10", "02-01", "Planting,First weed control (if no herbicide applied),Basal Fertilizer application");
            meetings.add(meeting);

            meeting = new MeetingSettingWrapper("Cassava", "Group", "1", "2", "02-10", "02-01", "First/Second Weeding,Third Weeding");
            meetings.add(meeting);

            meeting = new MeetingSettingWrapper("Cassava", "Individual", "2", "1", "02-10", "02-01", "Harvesting ");
            meetings.add(meeting);

            meeting = new MeetingSettingWrapper("Cassava", "Group", "1", "3", "02-10", "02-01", "Post-harvest processing");
            meetings.add(meeting);
            meeting = new MeetingSettingWrapper("Cassava", "Group", "1", "4", "02-10", "02-01", "");
            meetings.add(meeting);

            meeting = new MeetingSettingWrapper("Rice", "Group", "1", "1", "02-10", "02-01", "Land Clearing,Land preparation (ploughing)");
            meetings.add(meeting);

            meeting = new MeetingSettingWrapper("Rice", "Individual", "1", "1", "02-10", "02-01", "Planting,First weed control (if no herbicide applied),Basal Fertilizer application");
            meetings.add(meeting);

            meeting = new MeetingSettingWrapper("Rice", "Group", "1", "2", "02-10", "02-01", " First/Second Weeding,Top-dress fertilizer application");
            meetings.add(meeting);

            meeting = new MeetingSettingWrapper("Rice", "Individual", "2", "1", "02-10", "02-01", "Harvesting");
            meetings.add(meeting);

            meeting = new MeetingSettingWrapper("Rice", "Group", "1", "3", "02-10", "02-01", "Post-harvest processing");
            meetings.add(meeting);
            meeting = new MeetingSettingWrapper("Rice", "Group", "1", "4", "02-10", "02-01", "");
            meetings.add(meeting);

            meeting = new MeetingSettingWrapper("Yam", "Group", "1", "1", "02-10", "02-01", "Land Clearing,Land preparation (ploughing)");
            meetings.add(meeting);

            meeting = new MeetingSettingWrapper("Yam", "Individual", "1", "1", "02-10", "02-01", "Planting,First weed control (if no herbicide applied),Basal Fertilizer application");
            meetings.add(meeting);

            meeting = new MeetingSettingWrapper("Yam", "Group", "1", "2", "02-10", "02-01", "First/Second Weeding");
            meetings.add(meeting);

            meeting = new MeetingSettingWrapper("Yam", "Individual", "2", "1", "02-10", "02-01", "Second/Third weeding,Harvesting");
            meetings.add(meeting);

            meeting = new MeetingSettingWrapper("Yam", "Group", "1", "3", "02-10", "02-01", "Third/fourth weeding,Second HarvestingPost-harvest processing");
            meetings.add(meeting);
            
            meeting = new MeetingSettingWrapper("Yam", "Group", "1", "4", "02-10", "02-01", "");
            meetings.add(meeting);

            MeetingSettingModel msModel = new MeetingSettingModel();
            msModel.deleteAll();
            for (MeetingSettingWrapper meeting1 : meetings) {
                msModel.create(meeting1);
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
