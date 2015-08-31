/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;

import com.grameenfoundation.ictc.domains.Biodata;
import com.grameenfoundation.ictc.models.BiodataModel;
import com.grameenfoundation.ictc.models.UserModel;
import com.grameenfoundation.ictc.wrapper.BiodataWrapper;
import com.grameenfoundation.ictc.wrapper.UserWrapper;
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
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, HEAD, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");

        // Set the header response type
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("application/json;charset=UTF-8");

            String serviceCode = request.getParameter("action");
            JSONObject jSONObject = new JSONObject();

            BiodataModel bModel = new BiodataModel();
            if ("login".equals(serviceCode)) {

                String username = request.getParameter("us");
                String pwd = request.getParameter("pwd");
                UserWrapper user = new UserModel().findUser(username, pwd);
                if (null == user) {
                    jSONObject.put("rc", "01");
                    jSONObject.put("msg", "Unable to Login");
                } else {
                    //do as details action   
                    List<BiodataWrapper> farmers = bModel.getBioData("a", "");
                    JSONArray farmerArray = getFarmers(farmers);

                    jSONObject.put("rc", "00");

//                    jSONObject.put("farmer", farmerArray);
                    jSONObject.put("org", user.getOrganisation());
                    jSONObject.put("lname", user.getLastName());
                    jSONObject.put("fname", user.getFirstName());
                    jSONObject.put("type", user.getAgentType());
                    
                    out.print(jSONObject);
                }

            } else if ("details".equals(serviceCode)) {

                List<BiodataWrapper> farmers = bModel.getBioData("a", "");

                JSONArray farmerArray = getFarmers(farmers);

                jSONObject.put("farmer", farmerArray);
                jSONObject.put("rc", "00");
                out.print(jSONObject);
                
            } else if ("fp".equalsIgnoreCase(serviceCode)) {
                System.out.println("ServiceCode  :" + serviceCode);
                JSONObject obj = new JSONObject();
                String id = request.getParameter("fid");
                List<BiodataWrapper> farmer = bModel.getBioDataSearch(Biodata.ID, id);
                if (null == farmer || farmer.isEmpty()) {
                    obj.put("rc", "03");
                    obj.put("msg", "Farm Not Found");
                } else {

                    BiodataWrapper bd = farmer.get(0);
                    String[] fieldNames
                            = {"id", "ms", "gender", "community", "district", "region", "village", "nod", "noc",
                                "lname", "fname", "nickname", "sizeplot", "maincrop", "labour",
                                "date_land_ident", "loc_land", "target_area",
                                "exp_price_ton", "variety", "target_nxt_season", "techneed1", "techneed2",
                                "fbo", "cluster",
                                "landarea", "date_plant", "plant", "date_man_weed", "pos_contact", "mon_sell_start", "mon_fin_pro_sold",
                                "price_fin_sold"};
                    String[] fieldVaules
                            = {bd.getFarmID(), bd.getMaritalStatus(), bd.getGender(), bd.getCommunity(), bd.getDistrict(), bd.getRegion(), bd.getVillage(), bd.getNumberOfChildren(), bd.getNumberOfDependants(), bd.getLastName(), bd.getFirstName(), bd.getNickname(), "", bd.getMajorCrop(), bd.getFarmManagement().getLabourUse(),
                                bd.getFmp().getDateoflandidentification(), bd.getFmp().getLocationofland(), bd.getFmp().getTargetareaofland(),
                                bd.getFmp().getExpectedpriceperton(), bd.getFmp().getNameofvariety(), "",
                                bd.getTechNeeds().getCropEstablishment(), "TechNeeds2", bd.getFarmManagement().getFboName(), bd.getCluster(), bd.getFmp().getTargetareaofland(), bd.getFmp().getPlantingdate(), "", "Date Man Weed",
                                bd.getFmp().getMainpointofsaleorcontact(), bd.getMarketing().getMonthSellingBegins(), bd.getMarketing().getMonthFinalBatchSold(), bd.getMarketing().getPriceFinalBatchSold()
                            };
                    int ct = 0;
                    for (String name : fieldNames) {
                        try {
                            obj.put(name, fieldVaules[ct]);
                        } catch (Exception e) {

                            obj.put(name, "Not Set");
                        }
                        ct++;
                    }
                }

                out.print(obj);
            } else {

                JSONObject obj = new JSONObject();
                obj.put("rc", "05");
                obj.put("msg", "Invalid Action");
                out.print(obj);
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

    public JSONArray getFarmers(List<BiodataWrapper> farmers) {

        JSONArray farmerArray = new JSONArray();
        for (BiodataWrapper farmer : farmers) {
            JSONObject obj = new JSONObject();
            BiodataWrapper bd = farmer;
            String[] fieldNames
                    = {"id", "ms", "gender", "communy", "district", "region", "village", "nod", "noc",
                        "lname", "fname", "nickname", "sizeplot", "maincrop", "labour",
                        "date_land_ident", "loc_land", "target_area",
                        "exp_price_ton", "variety", "target_nxt_season", "techneed1", "techneed2",
                        "fbo", "cluster",
                        "landarea", "date_plant", "plant", "date_man_weed", "pos_contact", "mon_sell_start", "mon_fin_pro_sold",
                        "price_fin_sold"};
            String[] fieldVaules
                    = {bd.getFarmID(), bd.getMaritalStatus(), bd.getGender(), bd.getCommunity(), bd.getDistrict(), bd.getRegion(), bd.getVillage(), bd.getNumberOfChildren(), bd.getNumberOfDependants(), bd.getLastName(), bd.getFirstName(), bd.getNickname(), "", bd.getMajorCrop(), bd.getFarmManagement().getLabourUse(),
                        bd.getFmp().getDateoflandidentification(), bd.getFmp().getLocationofland(), bd.getFmp().getTargetareaofland(),
                        bd.getFmp().getExpectedpriceperton(), bd.getFmp().getNameofvariety(), "",
                        bd.getTechNeeds().getCropEstablishment(), "TechNeeds2", bd.getFarmManagement().getFboName(), bd.getCluster(), bd.getFmp().getTargetareaofland(), bd.getFmp().getPlantingdate(), "", "Date Man Weed",
                        bd.getFmp().getMainpointofsaleorcontact(), bd.getMarketing().getMonthSellingBegins(), bd.getMarketing().getMonthFinalBatchSold(), bd.getMarketing().getPriceFinalBatchSold()
                    };
            try {
//                          obj.put("fname",farmer.getFirstName());
//                    System.out.println("Fname : "+farmer.getFirstName());
//                    System.out.println("lname : "+farmer.getLastName());
//                    obj.put("lname",farmer.getLastName());
//                    obj.put("age",farmer.getAge());
//                    obj.put("community",farmer.getCommunity());
//                    obj.put("district",farmer.getDistrict());
//                    obj.put("edu",farmer.getEducation());
//                    obj.put("gender",farmer.getGender());
//                    obj.put("nickname",farmer.getNickname());
//                    obj.put("village",farmer.getVillage());
//                    obj.put("region",farmer.getRegion());
//                    obj.put("noc",farmer.getNumberOfChildren());
//                    obj.put("ms",farmer.getMaritalStatus());
//                    obj.put("nod",farmer.getNumberOfDependants());
//                    
//                    
//                    obj.put("id",farmer.getFarmID());
//                    obj.put("cluster",farmer.getCluster());
//                    

                int ct = 0;
                for (String name : fieldNames) {
                    try {
                        obj.put(name, fieldVaules[ct]);
                    } catch (Exception e) {
                        obj.put(name, "Not Set");
                    }
                    ct++;
                }
                farmerArray.put(obj);
            } catch (Exception e) {
            }

        }
        return farmerArray;

    }
}
