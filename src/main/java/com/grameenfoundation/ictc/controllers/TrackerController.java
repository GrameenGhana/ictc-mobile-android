/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;

import com.grameenfoundation.ictc.domains.Biodata;
import com.grameenfoundation.ictc.models.BiodataModel;
import com.grameenfoundation.ictc.models.FarmerGPSModel;
import com.grameenfoundation.ictc.models.FarmerInputModel;
import com.grameenfoundation.ictc.models.MeetingModel;
import com.grameenfoundation.ictc.models.MobileTrackerModel;
import com.grameenfoundation.ictc.wrapper.FarmGPSLocationWrapper;
import com.grameenfoundation.ictc.wrapper.FarmManagementWrapper;
import com.grameenfoundation.ictc.wrapper.FarmerInputReceivedWrapper;
import com.grameenfoundation.ictc.wrapper.MobileTrackerWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;

import java.util.Map;
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
@WebServlet(name = "TrackerController", urlPatterns = {"/api/v1/tracker"})
public class TrackerController extends HttpServlet {

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
            System.out.println("Tracker Started @ " + new Date());

            for (Enumeration e = request.getParameterNames();
                    e.hasMoreElements();) {
                String param = (String) e.nextElement();
                System.out.println(param + ": " + request.getParameter(param));
            }
//            String serviceCode = request.getParameter("action");
//            JSONObject jSONObject = new JSONObject();
//            System.out.println("action " + serviceCode);

            String data = request.getParameter("data");

            System.out.println("Data Received : " + data);

            JSONObject jobj = new JSONObject(data);
            JSONArray jsonArray = jobj.getJSONArray("logs");

            int length = jsonArray.length();
            String rId = Calendar.getInstance().toString();
            System.out.println("TrackerLog Count : " + length);
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
                System.out.println(rId+"-"+i+"/"+length+"):::Data Item " + module + " DT [[[" + dt + "]]]");

                MobileTrackerWrapper mobileTracker = new MobileTrackerWrapper(id, userId, module, dt, startTime, endTime);

                if (module != "") {
                    if (mobileTracker.getPage().equalsIgnoreCase("Mark Group Attendance")) {

                        System.out.println("TrackerLog Group Attendance");
                        if (data.contains("attendees")) {

                            try {
                                System.out.println("TrackerLog Group Attendees");
                                JSONObject jObject = mobileTracker.getDataJSON();
                                String inAttendance = jObject.getString("attendees");
                                int mIndex = jObject.getInt("meeting_index");
                                String type = jObject.getString("type");
                                new MeetingModel().updateMeetings(String.valueOf(mIndex), type, inAttendance);
                            } catch (Exception e) {
                                System.out.println("Error with Attendees :"+e.getLocalizedMessage());
                            }
                            
                        }
                    } else if (mobileTracker.getPage().equalsIgnoreCase("Farmer Input")) {
                        if (data.contains("farm_inputs")) {
                            System.out.println("TrackerLog Farm Input");

                            JSONObject jObject = mobileTracker.getDataJSON();
                            JSONArray ja = jObject.getJSONArray("farm_inputs");

                            String farmer = jObject.getString("user_id");
                            FarmerInputModel fim = new FarmerInputModel();
                            List<FarmerInputReceivedWrapper> farmers = fim.getFarmerInputs(farmer);

                            FarmerInputReceivedWrapper seedsReceived = MobileController.searchNeeds(farmers, "seeds");
                            FarmerInputReceivedWrapper fertReceived = MobileController.searchNeeds(farmers, "fertiliser");
                            FarmerInputReceivedWrapper ploughReceived = MobileController.searchNeeds(farmers, "plough");
                            JSONObject seedObject;
                            JSONObject fertObj;
                            JSONObject ploughObj;

                            System.out.println("Farms Input Received :");
                            int l = ja.length();
                            for (i = 0; i < l; i++) {
                                JSONObject ji = ja.getJSONObject(i);
                                if (ji.getString("name").equals("seeds")) {
                                    seedObject = ji;
                                    if (null == seedsReceived) {
                                        seedsReceived = new FarmerInputReceivedWrapper();
                                        seedsReceived.setFarmer(farmer);
                                        seedsReceived.setName("seeds");
                                        seedsReceived.setQty(seedObject.getDouble("qty"));
                                        seedsReceived.setStatus("1");
                                        fim.create(seedsReceived);
                                    } else {
                                        boolean update = fim.update(farmer, "seeds", seedObject.getDouble("qty"));
//|
                                    }
                                } else if (ji.getString("name").equals("fertiliser")) {
                                    fertObj = ji;
                                    if (null == fertReceived) {
                                        fertReceived = new FarmerInputReceivedWrapper();
                                        fertReceived.setFarmer(farmer);
                                        fertReceived.setName("seeds");
                                        fertReceived.setQty(fertObj.getDouble("qty"));
                                        fertReceived.setStatus("1");
                                        fim.create(seedsReceived);
                                    } else {
                                        boolean update = fim.update(farmer, "fertiliser", fertObj.getDouble("qty"));
//|
                                    }
                                } else if (ji.getString("name").equals("plough")) {
                                    ploughObj = ji;
                                    if (null == fertReceived) {
                                        fertReceived = new FarmerInputReceivedWrapper();
                                        fertReceived.setFarmer(farmer);
                                        fertReceived.setName("seeds");
                                        fertReceived.setQty(ploughObj.getDouble("qty"));
                                        fertReceived.setStatus("1");
                                        fim.create(seedsReceived);
                                    } else {
                                        boolean update = fim.update(farmer, "plough", ploughObj.getDouble("qty"));
//|
                                    }
                                }

                            }
                        }
                    } else if (mobileTracker.getPage().equalsIgnoreCase("Farm Map Input")) {
                        if (data.contains("perimeter")) {
                            System.out.println("TrackerLog farm mapping");

                            System.out.println("Farm Map Input Received :");
                            JSONObject jObject = mobileTracker.getDataJSON();
                            /**
                             * objs.put("page","Farm Map Input");
                             * objs.put("area",String.valueOf(area));
                             * objs.put("perimeter",String.valueOf(perimeter));
                             * objs.put("section",farmer.getFullname());
                             * objs.put("coordinates",jsonCoordinate);
                             * objs.put("imei",IctcCKwUtil.getImei(getBaseContext()));
                             * objs.put("version",IctcCKwUtil.getAppVersion());
                             * objs.put("battery",IctcCKwUtil.getBatteryLevel(getBaseContext()));
                             */
                            String area = jObject.getString("area");
                            String farmerId = jObject.getString("user_id");
                            String perimeter = jObject.getString("perimeter");
                            JSONArray coordinates = jObject.getJSONArray("coordinates");

                            Map<String, String> mhap = new HashMap<String, String>();
                            mhap.put(Biodata.FARM_AREA, area);
                            mhap.put(Biodata.FARM_PERIMETER, perimeter);
                            new BiodataModel().BiodataUpdate(farmerId, mhap);

                            FarmerGPSModel gpsModel = new FarmerGPSModel();
                            int l = coordinates.length();
                            for (i = 0; i < l; i++) {
                                JSONObject cord = coordinates.getJSONObject(i);
                                gpsModel.create(new FarmGPSLocationWrapper(cord.getString("x"), cord.getString("y"), farmerId));

                            }
                        }
                    }
                }

                boolean tkr = trackerModel.create(mobileTracker);
                if (tkr) {
                    validIds += id + ",";
                }
                
                 System.out.println(rId+"-"+i+"/"+length+"):::Done");
            }
            if (!validIds.isEmpty()) {
                validIds = validIds.substring(0, validIds.length() - 2);
            }
            JSONObject js = new JSONObject();
            js.put("rc", "00");
            js.put("ids", validIds);

            System.out.println("tracker log response " + js.toString());
            out.print(js);
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
