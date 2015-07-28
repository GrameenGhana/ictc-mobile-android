/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;

import com.grameenfoundation.ictc.domains.Biodata;
import com.grameenfoundation.ictc.domains.FarmManagement;
import com.grameenfoundation.ictc.domains.Harvest;
import com.grameenfoundation.ictc.domains.Marketing;
import com.grameenfoundation.ictc.domains.PostHarvest;
import com.grameenfoundation.ictc.domains.Storage;
import com.grameenfoundation.ictc.domains.TechnicalNeed;
import com.grameenfoundation.ictc.models.BiodataModel;
import com.grameenfoundation.ictc.models.FarmManagementModel;
import com.grameenfoundation.ictc.models.HarvestModel;
import com.grameenfoundation.ictc.models.MarketingModel;
import com.grameenfoundation.ictc.models.PostHarvestModel;
import com.grameenfoundation.ictc.models.StorageModel;
import com.grameenfoundation.ictc.models.TechnicalNeedsModel;
import com.grameenfoundation.ictc.wrapper.BiodataWrapper;
import com.grameenfoundation.ictc.wrapper.FarmManagementWrapper;
import com.grameenfoundation.ictc.wrapper.HarvestWrapper;
import com.grameenfoundation.ictc.wrapper.MarketingWrapper;
import com.grameenfoundation.ictc.wrapper.PostHarvestWrapper;
import com.grameenfoundation.ictc.wrapper.StorageWrapper;
import com.grameenfoundation.ictc.wrapper.TechnicalNeedsWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author grameen
 */
@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})
public class TestServlet extends HttpServlet {

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
            out.println("<title>Servlet TestServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
//            BiodataWrapper b = new BiodataWrapper();
//            
//            b.setFirstName("Kwesi ");
//            b.setLastName("Asera");
//            b.setCommunity("Akumadan");
//            b.setDistrict("Akumadan");
//            b.setVillage("Akumadan");
//            b.setRegion("Brong Ahafo Region");
//            b.setGender("Male");
//            b.setMaritalStatus("Divorced");
//            b.setNickname("Ratata");
//            b.setNumberOfChildren("2");
//            b.setNumberOfDependants("3");
//            b.setAge("45");
//            b.setDistrict("Akumadan");
//            b.setEducation("Secondary School");
//            
//            
//            new BiodataModel().createBiodata(b);
            
            
//            Biodata bi = new BiodataModel().getBiodata(Biodata.LAST_NAME,"Asera");
//            
//            FarmManagementWrapper fmw = new FarmManagementWrapper();
//            fmw.setFamilyLabor("2");
//            fmw.setFboMember("yes");
//            fmw.setFboName("Cool FBO");
//            fmw.setReferenceLeadFarmer("Kwame Abakah");
//            fmw.setBankAccount("yes");
//            fmw.setFarmRecordKeeping("yes");
//            fmw.setProductionObjective("2. Sells about 50% of produce.");
//            fmw.setDispostionToRisk("Annually");
//            fmw.setEntrepreneurship("1.At least every other year");
//            fmw.setLabourUse("1.My family manage the farm, no contribution to manual labor.");
//            
//            
//            
//            
//            FarmManagement fm = new FarmManagementModel().createFM(fmw);
//            HarvestWrapper hw = new HarvestWrapper();
//            hw.setTimeCropReadyToHarvest("2.Middle of July");
//            hw.setTimeCropHarvested("February");
//            hw.setNoLabourtotal("5");
//            hw.setNoFamilyLabour("2");
//            hw.setNoHiredLabour("3");
//            hw.setCostOfHiredLabour("150");
//            hw.setTimeCompletionHarvest("4");
//            
//            
//            Harvest hv = new HarvestModel().createFM(hw);
            
           // PostHarvestWrapper p = new PostHarvestWrapper();
           // PostHarvest ph = new PostHarvestModel().createPostHarvest(p);
           // StorageWrapper s =  new StorageWrapper();
           // Storage storage = new StorageModel().createFM(s);
            //MarketingWrapper m = new MarketingWrapper();
            //Marketing mk = new MarketingModel().createMarketing(m);
           TechnicalNeedsWrapper tech = new TechnicalNeedsWrapper();
           TechnicalNeed t = new TechnicalNeedsModel().createTechNeeds(tech);
            
            
            BiodataModel bio = new BiodataModel();
            
            //new BiodataModel().BiodataToHarvest("Asera",hv.getUnderlyingNode());
            
            //bio.BiodataToPostHarvest("Asera",ph.getUnderlyingNode());
            //bio.BiodataToStorage("Asera",storage.getUnderlyingNode());
           // bio.BiodataToMarketing("Asera",mk.getUnderlyingNode());
            bio.BiodataToTechNeeds("Asera",t.getUnderlyingNode());
            
            
            
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
