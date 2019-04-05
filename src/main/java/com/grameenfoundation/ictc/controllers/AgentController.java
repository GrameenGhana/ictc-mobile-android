/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;

import com.grameenfoundation.ictc.domains.Agent;
import com.grameenfoundation.ictc.models.AgentModel;
import com.grameenfoundation.ictc.models.UserModel;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.ICTCUtil;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import com.grameenfoundation.ictc.wrapper.AgentWrapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.neo4j.graphdb.Transaction;

/**
 *
 * @author grameen
 */
@WebServlet(name = "AgentController", urlPatterns = {"/agent/add"})
public class AgentController extends HttpServlet {

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
           //String url = "http://sandbox-ictchallenge.cs80.force.com/AgentRequest";
            
            
              String action = request.getParameter("action");
               Map<String, String> generalResponse = new HashMap<>();
                
                AgentModel agentModel = new AgentModel();
                
         if (action.equalsIgnoreCase("add")) {

                String url = "http://ictchallenge.force.com/agentRequest";
                String firstname = request.getParameter("fn");
                String lastname = request.getParameter("ln");
                String email = request.getParameter("email");
                String username = request.getParameter("un");
                String agenttype = request.getParameter("at");
                String phonenumber = request.getParameter("pn");
                String agentcode = request.getParameter("ac");
                String password = request.getParameter("password");
                String region = request.getParameter("rg");

                String formattedResponse = null;
                String jsonformat = null;
                String fullusername = null;
                String userId = null;
              

              AgentWrapper agentWrapper = new AgentWrapper();

             agentWrapper.setAgentcode(agentcode);
             agentWrapper.setAgenttype(agenttype);
             agentWrapper.setEmail(email);
             agentWrapper.setFirstname(firstname);
             agentWrapper.setLastname(lastname);
             agentWrapper.setUsername(username);
             agentWrapper.setPassword(password);
             agentWrapper.setPhonenumber(phonenumber);
             agentWrapper.setRegion(region);

            boolean created = agentModel.createAgent(agentWrapper);
            System.out.println("created " + created);
            if (created) {

                String serverResponse = "";
               
                System.out.println("Agent Created");
               

                JSONObject j = new JSONObject();
                j.put("agenttype", agenttype);
                j.put("firstname", firstname);
                j.put("lastname", lastname);
                j.put("email", email);
                j.put("username", username + "@ictc.org");
                j.put("phonenumber", phonenumber);

                HttpClient client = new DefaultHttpClient();
                HttpPost post = new HttpPost(url);

                System.out.println("data " + j.toString());

                List<NameValuePair> nameValuePairs = new ArrayList<>(1);
                nameValuePairs.add(new BasicNameValuePair("data",
                        j.toString()));
                post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                HttpResponse resp = client.execute(post);
             BufferedReader rd = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()));
                String line = "";
                while ((line = rd.readLine()) != null) {
                    System.out.println(line);
                  // out.println(line);
                    serverResponse += line;

                }

                // serverResponse ="saved";
                
                
                
                System.out.println(serverResponse);
                
                if(null!=serverResponse)
                {
                    System.out.println("Agent Created");
                   generalResponse.put(ICTCUtil.SUCCESS, "Agent Created");
                   
                   formattedResponse = serverResponse.substring(serverResponse.indexOf("'"), serverResponse.indexOf(";"));
                   
                   jsonformat =formattedResponse.substring(formattedResponse.indexOf("'")+1, formattedResponse.lastIndexOf("'"));
                    System.out.println("Converted to JSON format " + jsonformat);
                   
                    try {
                        JSONObject  js = new JSONObject(jsonformat);
                        System.out.println(js.toString());
                        
                        //fullusername = js.getString("username");
                        //String user = fullusername.substring(0,fullusername.indexOf("@"));
                        userId  = js.getString("userId");
                        System.out.println("userId" + userId);
                       // Agent agent = agentModel.getAgent(Agent.USERNAME,agentWrapper.getUsername());
                        Map<String,String> update = new HashMap<String,String>();
                        update.put(Agent.AGENTID,userId);
                        
                        agentModel.AgentUpdate(agentWrapper.getUsername(),update);
                        System.out.println("Agent updated");
                        
                    } catch (Exception e) {
                        
                        System.out.println("couldnt pass response from salesforce");
                    }
                   
                   
                }
                
            }
            else
            {
                System.out.println("Could not send to salesforce");
                generalResponse.put(ICTCUtil.ERROR, "Agent not created");
                ICTCUtil.redirect(request, response,"/agent/add_agent.jsp", "");
            } 
            }
            if(action.equals("edit"))
            {
                String firstname = request.getParameter("fn");
                String lastname = request.getParameter("ln");
                String username = request.getParameter("un");
                String agenttype = request.getParameter("at");
                String region = request.getParameter("rg");
                
                System.out.println("username " + username);
                System.out.println("user type " + agenttype);
                
                Map<String,String> update = new HashMap<String,String>();
                update.put(Agent.AGENTTYPE,agenttype);
                update.put(Agent.FIRSTNAME,firstname);
                update.put(Agent.LASTNAME, lastname);
                update.put(Agent.REGION, region);
                        
                 agentModel.AgentUpdate(username, update);
                        System.out.println("Agent updated");
            }
            if(action.equalsIgnoreCase("delete"))
            {
                 Agent  ag  = agentModel.getAgent(Agent.USERNAME, request.getParameter("un"));
               try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {

                
                 
                 if(Neo4jServices.deleteAgentNode(ag.getUnderlyingNode()))
                 {
                     System.out.println("Node deleted");
                 }
                 else 
                 {
                     System.out.println("Node not deleted");
                 }
                 
                 trx.success();
               }
                 
                 
            }
            if(action.equals("ob"))
            {
                UserModel user = new UserModel();
                
              
                String ob = request.getParameter("ob");
                Agent  ag  = agentModel.getAgent(Agent.AGENTID, request.getParameter("at"));
                
                if(null!=ag)
                {
                    System.out.println("ob attached to agent " + user.ObToAggent(ob,ag.getUnderlyingNode())); 
                     ICTCUtil.redirect(request, response,"/users/viewobtoag.jsp");
                }
                else
                {
                    System.out.println("Agent not Available");
                }
                
              
                
                
                
            }
            
            if(action.equals("sapo"))
            {
                  UserModel user = new UserModel();
                
              
                String ob = request.getParameter("apo");
                Agent  ag  = agentModel.getAgent(Agent.AGENTID, request.getParameter("at"));
                
                if(null!=ag)
                {
                    System.out.println("apo attached to agent " + user.APOToAggent(ob,ag.getUnderlyingNode())); 
                     ICTCUtil.redirect(request, response,"/v2/users/viewapotoag.jsp");
                }
                else
                {
                    System.out.println("Agent not Available");
                }
                
            }
              request.setAttribute(ICTCUtil.GENERAL_RESPONSE, generalResponse);
              ICTCUtil.redirect(request, response,"/agent/view_agent.jsp");
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
