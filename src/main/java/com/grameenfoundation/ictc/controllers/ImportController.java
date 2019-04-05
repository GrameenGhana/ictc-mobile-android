/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;

import com.grameenfoundation.ictc.models.BiodataModel;
import com.grameenfoundation.ictc.wrapper.BiodataWrapper;
import com.sun.jersey.core.util.Base64;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.*;

/**
 *
 * @author grameen
 */
@WebServlet(name = "ImportController", urlPatterns = {"/ImportController"})
public class ImportController extends HttpServlet {

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
             JSONObject ob = new JSONObject();
             BiodataModel bio = new BiodataModel();
             BiodataWrapper bi = new BiodataWrapper();
             JSONArray farmers = new JSONArray();
             ob = convertFileToJSON("/home/grameen/acdivoca/test.a2");
             
             farmers = ob.getJSONArray("farmer");
             
             for(int i=0;i< farmers.length();i++)
             {
                 ob = farmers.getJSONObject(i);
                 bi.setACDIVOCAFARMERID(ob.getString("FarmerID"));
                 bi.setAge(ob.getString("Age"));
                 bi.setCommunity(ob.getString("Community"));
                 bi.setDataCollcetedBy(ob.getString("DataCollectedBy"));
                 bi.setDataReviewedBy(ob.getString("DataReviewedBy"));
                 bi.setDateCollected(ob.getString("DateCollected"));
                 bi.setDateReviewed(ob.getString("DateReviewed"));
                 bi.setDateofbirth(ob.getString("DoB"));
                 bi.setDistrict("");
                 bi.setEducation(ob.getString("HighestEducation"));
                 bi.setFBOPosition(ob.getString("FBOPosition"));
                 bi.setFamer_type(ob.getString("FarmerType"));
                 bi.setFirstName(ob.getString("FirstNames"));
                 bi.setFkAggregatorProfile(ob.getString("fkAggregatorProfile"));
                 bi.setFkFBOProfile(ob.getString("fkFBOProfile"));
                 bi.setFkFYName(ob.getString("fkFYName"));
                 bi.setFkFarmerHHProfile(ob.getString("fkFarmerHHProfile"));
                 bi.setFkNucleusFarmerProfile(ob.getString("fkNucleusFarmerProfile"));
                 if(ob.getString("IsMale").equals("0"))
                   bi.setGender("Female");
                 else
                     bi.setGender("Male");
                 bi.setImage_url(getFarmerImage(ob.getString("FarmerID"),ob.getString("IDPicture")));
                 bi.setLastName(ob.getString("LastName"));
                 if(ob.getString("isOutGrower").equals("0"))
                     bi.setIsOutGrower("No");
                 else
                     bi.setIsOutGrower("Yes");
                  if(ob.getString("isWithFBO").equals("0"))
                       bi.setIsWithFBO("No");
                 else
                     bi.setIsWithFBO("Yes");
                  if(ob.getString("isWithPA").equals("0"))
                       bi.setIsWithFBO("No");
                 else
                     bi.setIsWithFBO("Yes");
                  
                  bi.setIsWithPA(ob.getString("isWithPA"));
                  bi.setNickname(ob.getString("PopularName"));
                  bi.setTelephonenumber(ob.getString("ContactPhone"));
                  bi.setNoMaleEmployees(ob.getString("NoMaleEmployees"));
                  bi.setNoFemaleEmployees(ob.getString("NoFemaleEmployees"));
                  
                 System.out.println("Created " + bio.createBiodata(bi)); 
                 
               
                 
                 System.out.println("Farmer "+i+" "+bi.getACDIVOCAFARMERID() + " " + bi.getImage_url()); 
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
    
    
      private JSONObject  convertFileToJSON(String file)
        {
              JSONArray ja = new JSONArray();
                        JSONArray jw = new JSONArray();
                        JSONObject x = null;
                        JSONObject y = null;
                        JSONObject ob = new JSONObject();
            
              try (BufferedReader br = new BufferedReader(new FileReader(file)))
		{

			String sCurrentLine;
                     
                      
                        String json ="";
                        String replace = null;
                        int i =0;

			while ((sCurrentLine = br.readLine()) != null) {
			
                             if(sCurrentLine.contains("DATASET"))
                             {
                                  sCurrentLine = sCurrentLine.replace("~", "\":\"").replace("\t","\",\"");
                                  sCurrentLine +="\"" ;
                                  sCurrentLine ="{\""+sCurrentLine+"}";
                                  x = new JSONObject(sCurrentLine);
                                  ja.put(x);
                             }
                             else
                             {
                                sCurrentLine = sCurrentLine.replace("~", "\":\"").replace("\t","\",\"");
                                sCurrentLine = sCurrentLine.replace("\\", "\\\\");
                                sCurrentLine = sCurrentLine.substring(0, sCurrentLine.lastIndexOf(","));
                                sCurrentLine ="{\""+sCurrentLine+"}";
                                y = new JSONObject(sCurrentLine);
                                jw.put(y);
                                
                             }
                           
                              
			}
                        
                    
                    ob.put("info",ja);
                    ob.put("farmer", jw);
                    System.out.println("data2-----------------------------------------------------------------------------------------\n");
                    System.out.println(ob.toString());

		} catch (Exception e) {
                         
                    System.out.println("ththh " + e.getMessage());
	             e.printStackTrace();
                        
		}
              
              return ob;
        }
      
      
     String getFarmerImage(String farmer,String image)
    {
         String image_url =""; 
         
       

            String res = image;

            String root = "com.sun.aas.instanceRoot";
           
            String path = "";

            File f = new File(System.getProperty(root) + "/docroot/images");

            if (!f.exists()) {
                f.mkdirs();
            } 
            path = f.getPath() + File.separator +farmer +".png";
            System.out.println("path " + path);
            image_url = "/images"+File.separator +farmer +".png";
            byte[] data = Base64.decode(res);
            try (OutputStream stream = new FileOutputStream(path)) {
                stream.write(data);
            } catch (FileNotFoundException ex) {
            Logger.getLogger(SalesforceSyncServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SalesforceSyncServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       return image_url;     
    }

}
