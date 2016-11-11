/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import org.json.*;


/**
 *
 * @author grameen
 */
public class acditest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         try (BufferedReader br = new BufferedReader(new FileReader("/home/grameen/acdivoca/test.a2")))
		{

			String sCurrentLine;
                     
                        JSONArray ja = new JSONArray();
                        JSONArray jw = new JSONArray();
                        JSONObject x = null;
                        JSONObject y = null;
                        JSONObject ob = new JSONObject();
                        String json ="";
                        String replace = null;
                        int i =0;

			while ((sCurrentLine = br.readLine()) != null) {
			
                             if(sCurrentLine.contains("DATASET"))
                             {
                                  sCurrentLine = sCurrentLine.replace("~", "\":\"").replace("\t","\",\"");
                                  sCurrentLine +="\"" ;
                                  sCurrentLine ="{\""+sCurrentLine+"}";
                                 // System.out.println(sCurrentLine);
                                  x = new JSONObject(sCurrentLine);
                                  ja.put(x);
                             }
                             else
                             {
                                sCurrentLine = sCurrentLine.replace("~", "\":\"").replace("\t","\",\"");
                                sCurrentLine = sCurrentLine.replace("\\", "\\\\");
                                sCurrentLine = sCurrentLine.substring(0, sCurrentLine.lastIndexOf(","));
                                sCurrentLine ="{\""+sCurrentLine+"}";
                               // System.out.println(sCurrentLine);
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
        
    }
    
}
