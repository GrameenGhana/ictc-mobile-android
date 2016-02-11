/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;

import com.grameenfoundation.ictc.domains.MobileTracker;
import com.grameenfoundation.ictc.models.BiodataModel;
import com.grameenfoundation.ictc.models.MobileTrackerModel;
import com.grameenfoundation.ictc.wrapper.BiodataWrapper;
import com.grameenfoundation.ictc.wrapper.MobileTrackerWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 *
 * @author skwakwa
 */
@WebServlet(name = "ReportControllerServlet", urlPatterns = {"/sys/report"})
public class ReportControllerServlet extends HttpServlet {

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

            String action = request.getParameter("action");
            if (action.equalsIgnoreCase("farmer")) {
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "attachment;filename=Farmer.xls");

                String nm = request.getParameter("nm");
                String community = request.getParameter("cm");
                String mainCrop = request.getParameter("mc");
                String age = request.getParameter("ag");

                System.out.println("Nm " + nm);
                System.out.println("Cm " + community);
                System.out.println("Mc " + mainCrop);
                System.out.println("ag " + age);
                BiodataModel biodataModel = new BiodataModel();
                List<BiodataWrapper> bios = biodataModel.getBioData("", "");

                WritableWorkbook writableWorkbook = Workbook.createWorkbook(response.getOutputStream());

                WritableSheet writableSheet = writableWorkbook.createSheet("Sheet1", 0);
                writableSheet.getSettings().setDefaultColumnWidth(25);
//                writableSheet.getSettings().setDefaultRowHeight(100 * 20);
                WritableFont cellFont = new WritableFont(WritableFont.TIMES, 12);
                WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
                /**
                 *
                 */
                try {
                    writableSheet.setRowView(0, 20 * 20);
                    writableSheet.addCell(new Label(0, 0, "ID"));
                    writableSheet.addCell(new Label(1, 0, "Surname"));
                    writableSheet.addCell(new Label(2, 0, "Othernames"));
                    writableSheet.addCell(new Label(3, 0, "Community"));
                    writableSheet.addCell(new Label(4, 0, "Village"));
                    writableSheet.addCell(new Label(5, 0, "Region"));
                    writableSheet.addCell(new Label(6, 0, "District"));
                    writableSheet.addCell(new Label(7, 0, "Education"));
                    writableSheet.addCell(new Label(8, 0, "Gender"));
                    writableSheet.addCell(new Label(9, 0, "Marital Status"));
                    writableSheet.addCell(new Label(10, 0, "Nickname"));
                    writableSheet.addCell(new Label(11, 0, "# Children"));
                    writableSheet.addCell(new Label(12, 0, "# Dependants"));
                    writableSheet.addCell(new Label(13, 0, "Cluster"));

//                    writableSheet.addCell(new Label(5, 0, "QR CODE"));
                    int i = 1;
                    for (BiodataWrapper bio : bios) {

                        writableSheet.addCell(new Label(0, i, bio.getFarmID()));
                        writableSheet.addCell(new Label(1, i, bio.getLastName()));
                        writableSheet.addCell(new Label(2, i, bio.getFirstName()));
                        writableSheet.addCell(new Label(3, i, bio.getCommunity()));
                        writableSheet.addCell(new Label(4, i, bio.getVillage()));
                        writableSheet.addCell(new Label(5, i, bio.getRegion()));

                        writableSheet.addCell(new Label(6, i, bio.getDistrict()));
                        writableSheet.addCell(new Label(7, i, bio.getEducation()));
                        writableSheet.addCell(new Label(8, i, bio.getGender()));
                        writableSheet.addCell(new Label(9, i, bio.getMaritalStatus()));
                        writableSheet.addCell(new Label(10, i, bio.getNickname()));
                        writableSheet.addCell(new Label(11, i, bio.getNumberOfChildren()));
                        writableSheet.addCell(new Label(12, i, bio.getNumberOfDependants()));
                        writableSheet.addCell(new Label(13, i, bio.getCluster()));
                        i++;
                    }

                    writableWorkbook.write();
                    writableWorkbook.close();
                } catch (Exception e) {
                }
            } else if (action.equalsIgnoreCase("logs")) {
                response.setContentType("application/vnd.ms-excel");


                MobileTrackerModel biodataModel = new MobileTrackerModel();
                String format = "dd-MM-yyyy HH:mm";

                SimpleDateFormat simpleDate = new SimpleDateFormat(format);

                String s = request.getParameter("s");
                String e = request.getParameter("d");
                SimpleDateFormat todateDate = new SimpleDateFormat(
                        "yyyy-MM-dd");
                SimpleDateFormat todateDates = new SimpleDateFormat(
                        "yyyy-MM-dd HH:mm:ss");
                if (s == null || s.isEmpty()) {
                    s = todateDate.format(new Date());
                }
                if (e == null || e.isEmpty()) {
                    e = todateDate.format(new Date());
                }

                System.out.println("Start s : " + s);
                System.out.println("Start s : " + e);
                Date startDate = new Date();
                Date endDate = new Date();
                
                response.setHeader("Content-Disposition", "attachment;filename=ICTCLogs_"+s+"_"+e+".xls");

                try {

                    endDate = todateDates.parse(e + " 23:59:59");
                    startDate = todateDates.parse(s + " 00:00:00");

                } catch (Exception k) {
                }
                List<MobileTrackerWrapper> logs = biodataModel.findAll(startDate, endDate);


                
                WritableWorkbook writableWorkbook = Workbook.createWorkbook(response.getOutputStream());

                WritableSheet writableSheet = writableWorkbook.createSheet("ICTCLogs_"+s+"_"+e, 0);
                writableSheet.getSettings().setDefaultColumnWidth(25);

//                writableSheet.getSettings().setDefaultRowHeight(100 * 20);
                WritableFont cellFont = new WritableFont(WritableFont.TIMES, 12);
                WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
                /**
                 *
                 */
                try {
                    writableSheet.setRowView(0, 20 * 20);
                    writableSheet.addCell(new Label(0, 0, "ID"));
                    writableSheet.addCell(new Label(1, 0, "Username"));
                    writableSheet.addCell(new Label(2, 0, "Module"));
                    writableSheet.addCell(new Label(3, 0, "Page"));
                    writableSheet.addCell(new Label(4, 0, "Section"));
                    writableSheet.addCell(new Label(5, 0, "Start time"));
                    writableSheet.addCell(new Label(6, 0, "End Time"));
                    writableSheet.addCell(new Label(7, 0, "Version"));
                    writableSheet.addCell(new Label(8, 0, "Battery"));
                    writableSheet.addCell(new Label(9, 0, "IMEI"));
                    writableSheet.addCell(new Label(10, 0, "Data"));

                    
                    int i = 1;
                    for (MobileTrackerWrapper log : logs) {

                        writableSheet.addCell(new Label(0, i, log.getId()));
                        writableSheet.addCell(new Label(1, i, log.getUserId()));
                        writableSheet.addCell(new Label(2, i, log.getModule()));
                        writableSheet.addCell(new Label(3, i, log.getPage()));
                        writableSheet.addCell(new Label(4, i, log.getSection()));
                        writableSheet.addCell(new Label(5, i, simpleDate.format(new Date(log.getStartTime()))));
                        writableSheet.addCell(new Label(6, i, simpleDate.format(new Date(log.getEndTime()))));
                        writableSheet.addCell(new Label(7, i, String.valueOf(log.getVersion())));          
                        writableSheet.addCell(new Label(8, i, String.valueOf(log.getTimeSpent()/1000)));

                        writableSheet.addCell(new Label(9, i, String.valueOf(log.getBattery())));
                        writableSheet.addCell(new Label(10, i, String.valueOf(log.getImei())));
                        writableSheet.addCell(new Label(11, i, String.valueOf(log.getData())));
                        
                        i++;
                    }

                    writableWorkbook.write();
                    writableWorkbook.close();
                }catch(Exception r){
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
        return "Short description";
    }// </editor-fold>

}
