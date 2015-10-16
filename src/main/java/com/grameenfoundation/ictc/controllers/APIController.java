/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;

import com.grameenfoundation.ictc.domains.MeetingSetting;
import com.grameenfoundation.ictc.models.MeetingSettingModel;
import com.grameenfoundation.ictc.models.MobileTrackerModel;
import com.grameenfoundation.ictc.wrapper.MeetingActivityWrapper;
import com.grameenfoundation.ictc.wrapper.MeetingSettingWrapper;
import com.grameenfoundation.ictc.wrapper.MobileTrackerWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "APIController", urlPatterns = {"/api/v1"})
public class APIController extends HttpServlet {

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

        // Set the header response type
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("application/json;charset=UTF-8");

            String serviceCode = request.getParameter("action");
            JSONObject jSONObject = new JSONObject();
            System.out.println("action " + serviceCode);
            //<editor-fold desc="Meetings API">
            if (serviceCode.equalsIgnoreCase("cmeeting")) {
                MeetingSettingModel msm = new MeetingSettingModel();
                String crop = request.getParameter("crop");
                List<MeetingSettingWrapper> meetingSettings = new ArrayList<MeetingSettingWrapper>();
                if (crop.isEmpty()) {
                    String[] crops = new String[]{"Maize", "Cassava", "Yam", "Rice"};
                    JSONArray cropArray = new JSONArray();
                    for (String crop1 : crops) {
                        JSONObject object = new JSONObject();
                        object.put("name", crop1);
                        meetingSettings = msm.findPerCrop(crop1);
                        JSONArray meetSet = new JSONArray();
                        System.out.println("Crops :" + crop1);
                        for (MeetingSettingWrapper meetingSetting : meetingSettings) {
                            JSONObject obj = new JSONObject();
//                            obj.put(MeetingSetting.CROP, meetingSetting.getCrop());
                            obj.put(MeetingSetting.START_DATE, meetingSetting.getStartDate());
                            obj.put(MeetingSetting.END_DATE, meetingSetting.getEndDate());
                            obj.put(MeetingSetting.MEETING_INDEX, meetingSetting.getMeetingIndex());
                            obj.put(MeetingSetting.TYPE, meetingSetting.getType());
                            JSONArray jarray = new JSONArray();
                            for (MeetingActivityWrapper aw : meetingSetting.getMeetingActivities()) {
                                JSONObject job = new JSONObject();
                                job.put("idx", aw.getIndex());
                                job.put("name", aw.getName());
                                jarray.put(job);
                            }
                            obj.put("activity", jarray);
                            meetSet.put(obj);
                        }
                        object.put("meeting", meetSet);
                        cropArray.put(object);
                    }
                    jSONObject.put("rc", "00");
                    jSONObject.put("crops", cropArray);
                    out.print(jSONObject);
                } else {
                    meetingSettings = msm.findPerCrop(crop);

                    JSONArray meetSet = new JSONArray();
                    for (MeetingSettingWrapper meetingSetting : meetingSettings) {
                        JSONObject obj = new JSONObject();
                        obj.put(MeetingSetting.CROP, meetingSetting.getCrop());
                        obj.put(MeetingSetting.START_DATE, meetingSetting.getStartDate());
                        obj.put(MeetingSetting.END_DATE, meetingSetting.getEndDate());
                        obj.put(MeetingSetting.MEETING_INDEX, meetingSetting.getMeetingIndex());
                        obj.put(MeetingSetting.TYPE, meetingSetting.getType());
                        JSONArray jarray = new JSONArray();
                        for (MeetingActivityWrapper aw : meetingSetting.getMeetingActivities()) {
                            JSONObject job = new JSONObject();
                            job.put("idx", aw.getIndex());
                            job.put("name", aw.getName());
                            jarray.put(job);
                        }
                        obj.put("activity", jarray);
                        meetSet.put(obj);
                    }
                    jSONObject.put("rc", "00");
                    jSONObject.put("meeting", meetSet);
                    out.print(jSONObject);
                }
            } //</editor-fold>
            else if (serviceCode.equalsIgnoreCase("sync")) {
                String data = request.getParameter("data");
                JSONArray jsonArray = new JSONArray(data);
                int length = jsonArray.length();

                String validIds = "";
                MobileTrackerModel trackerModel = new MobileTrackerModel();
                for (int i = 0; i < length; i++) {
                    JSONObject j = jsonArray.getJSONObject(i);
                    String userId = j.getString("user_id");
                    String id = j.getString("id");
                    long startTime = j.getLong("start_time");
                    long endTime = j.getLong("end_time");
                    String module = j.getString("module");
                    String dt = j.getString("data");

                    MobileTrackerWrapper mobileTracker = new MobileTrackerWrapper(id, userId, module, dt, startTime, endTime);

                    if (trackerModel.create(mobileTracker) != null) {
                        validIds += id + ",";
                    }
                }
                if (!validIds.isEmpty()) {
                    validIds = validIds.substring(0, validIds.length() - 2);
                }
                JSONObject js = new JSONObject();
                js.put("rc", "00");
                js.put("ids", validIds);
                
                out.print(js);

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
