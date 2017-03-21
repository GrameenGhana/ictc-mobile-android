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
import com.grameenfoundation.ictc.domains.Ouestion;
import com.grameenfoundation.ictc.domains.PostHarvest;
import com.grameenfoundation.ictc.domains.Profiling;
import com.grameenfoundation.ictc.domains.Storage;
import com.grameenfoundation.ictc.domains.TechnicalNeed;
import com.grameenfoundation.ictc.models.AgentModel;
import com.grameenfoundation.ictc.models.BiodataModel;
import com.grameenfoundation.ictc.models.FarmManagementModel;
import com.grameenfoundation.ictc.models.HarvestModel;
import com.grameenfoundation.ictc.models.MarketingModel;
import com.grameenfoundation.ictc.models.PostHarvestModel;
import com.grameenfoundation.ictc.models.ProfilingModel;
import com.grameenfoundation.ictc.models.QuestionModel;
import com.grameenfoundation.ictc.models.StorageModel;
import com.grameenfoundation.ictc.models.TechnicalNeedsModel;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.utils.XMLParser;
import com.grameenfoundation.ictc.wrapper.AgentWrapper;
import com.grameenfoundation.ictc.wrapper.BiodataWrapper;
import com.grameenfoundation.ictc.wrapper.FarmManagementWrapper;
import com.grameenfoundation.ictc.wrapper.HarvestWrapper;
import com.grameenfoundation.ictc.wrapper.MarketingWrapper;
import com.grameenfoundation.ictc.wrapper.PostHarvestWrapper;
import com.grameenfoundation.ictc.wrapper.QuestionWrapper;
import com.grameenfoundation.ictc.wrapper.StorageWrapper;
import com.grameenfoundation.ictc.wrapper.TechnicalNeedsWrapper;
import com.sun.jersey.core.util.Base64;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.json.JSONArray;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.neo4j.graphdb.Transaction;


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
            throws ServletException, IOException, SAXException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet TestServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet TestServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
            //String theString = IOUtils.toString(request.getInputStream(), "UTF-8");
            
            //out.println("<h1>Servlet TestServlet at " +theString + "</h1>");
            //System.out.println(theString);a
             QuestionModel qu = new QuestionModel();
            
            QuestionWrapper qw = new QuestionWrapper();
            qw.setQuestion("farmrecordkeepingstatus");
            qw.setAnswer("yes");
            qw.setScore("5");
             
            QuestionWrapper qwa = new QuestionWrapper();
            qwa.setQuestion("farmrecordkeepingstatus");
            qwa.setAnswer("no");
            qw.setScore("0");
             
            
            QuestionWrapper q5 = new QuestionWrapper();
            q5.setQuestion("operatebankaccount");
            q5.setAnswer("no");
            q5.setScore("0");
            qu.createQuestion(q5);
            
            QuestionWrapper q5a = new QuestionWrapper();
            q5a.setQuestion("operatebankaccount");
            q5a.setAnswer("yes");
            q5a.setScore("5");
            qu.createQuestion(q5a);
            
            QuestionWrapper q2 = new QuestionWrapper();
            q2.setQuestion("fbomembership");
            q2.setAnswer("no");
            q2.setScore("0");
            qu.createQuestion(q2);

            QuestionWrapper q2a = new QuestionWrapper();
            q2a.setQuestion("fbomembership");
            q2a.setAnswer("yes");
            q2a.setScore("5");
            qu.createQuestion(q2a);

            
            QuestionWrapper q7 = new QuestionWrapper();
            q7.setQuestion("producesoldproportion");
            q7.setAnswer("Sells nearly all produce (more than 80%)");
            q7.setScore("1");
            qu.createQuestion(q7);
            
            QuestionWrapper q7a = new QuestionWrapper();
            q7a.setQuestion("producesoldproportion");
            q7a.setAnswer("Sells about 50% of produce.");
            q7a.setScore("3");
            qu.createQuestion(q7a);
            
            QuestionWrapper q7b = new QuestionWrapper();
            q7b.setQuestion("producesoldproportion");
            q7b.setAnswer("Sell less than 30% of produce");
            q7b.setScore("5");
            qu.createQuestion(q7b);
            
            
            QuestionWrapper q8 = new QuestionWrapper();
            q8.setQuestion("riskdispositionborrow");
            q8.setAnswer("Annually");
            q8.setScore("7");
            qu.createQuestion(q8);
            
            QuestionWrapper q8a = new QuestionWrapper();
            q8a.setQuestion("riskdispositionborrow");
            q8a.setAnswer("About every other year");
            q8a.setScore("5");
            qu.createQuestion(q8a);
            
            QuestionWrapper q8b = new QuestionWrapper();
            q8b.setQuestion("riskdispositionborrow");
            q8b.setAnswer("Occasionally (more than 2 years interval)");
            q8b.setScore("3");
            qu.createQuestion(q8b);
             
            
            QuestionWrapper q8c = new QuestionWrapper();
            q8c.setQuestion("riskdispositionborrow");
            q8c.setAnswer("I never borrow money for my farming.)");
            q8c.setScore("1");
            qu.createQuestion(q8c);
            
            
            QuestionWrapper q9 = new QuestionWrapper();
            q9.setQuestion("innovativenessbytrying");
            q9.setAnswer("Every year or season");
            q9.setScore("10");
            qu.createQuestion(q9);
            
            QuestionWrapper q9a = new QuestionWrapper();
            q9a.setQuestion("innovativenessbytrying");
            q9a.setAnswer("Every other year");
            q9a.setScore("7");
            qu.createQuestion(q9a);
            
            QuestionWrapper q9b = new QuestionWrapper();
            q9b.setQuestion("innovativenessbytrying");
            q9b.setAnswer("Every 5 years");
            q9b.setScore("3");
            qu.createQuestion(q9b);
            
            QuestionWrapper q9c = new QuestionWrapper();
            q9c.setQuestion("innovativenessbytrying");
            q9c.setAnswer("Every 10 years");
            q9c.setScore("1");
            qu.createQuestion(q9c);
            
            
            QuestionWrapper q10 = new QuestionWrapper();
            q10.setQuestion("soilfertilitypractices");
            q10.setAnswer("I regularly apply farmyard manure/compost, inorganic fertilizer and leave crop residues on the field");
            q10.setScore("10");
            qu.createQuestion(q10);
            
            QuestionWrapper q10a = new QuestionWrapper();
            q10a.setQuestion("soilfertilitypractices");
            q10a.setAnswer("I regularly apply inorganic fertilizer and leave crop residues on the farm");
            q10a.setScore("7");
            qu.createQuestion(q10a);
            
            
            QuestionWrapper q10b = new QuestionWrapper();
            q10b.setQuestion("soilfertilitypractices");
            q10b.setAnswer("I regularly apply inorganic fertilizer");
            q10b.setScore("5");
            qu.createQuestion(q10b);
            
            
            QuestionWrapper q10c = new QuestionWrapper();
            q10c.setQuestion("soilfertilitypractices");
            q10c.setAnswer("I regularly apply farmyard manure/compost");
            q10c.setScore("3");
            qu.createQuestion(q10c);
            
             
            QuestionWrapper q10d = new QuestionWrapper();
            q10d.setQuestion("soilfertilitypractices");
            q10d.setAnswer("I regularly leave resdiue on the field");
            q10d.setScore("1");
            qu.createQuestion(q10d);
            
            
            QuestionWrapper q10e = new QuestionWrapper();
            q10e.setQuestion("soilfertilitypractices");
            q10e.setAnswer("I dont practice any of these");
            q10e.setScore("0");
            qu.createQuestion(q10e);
            
            
            
            QuestionWrapper q11 = new QuestionWrapper();
            q11.setQuestion("postharvestlosses");
            q11.setAnswer("No or very little loss");
            q11.setScore("10");
            qu.createQuestion(q11);
            
            
            QuestionWrapper q11a = new QuestionWrapper();
            q11a.setQuestion("postharvestlosses");
            q11a.setAnswer("up to 10% loss");
            q11a.setScore("7");
            qu.createQuestion(q11a);
            
            QuestionWrapper q11b = new QuestionWrapper();
            q11b.setQuestion("postharvestlosses");
            q11b.setAnswer("10 to 20% loss");
            q11b.setScore("5");
            qu.createQuestion(q11b);
            
            
            QuestionWrapper q11c = new QuestionWrapper();
            q11c.setQuestion("postharvestlosses");
            q11c.setAnswer("20 to 30% loss");
            q11c.setScore("3");
            qu.createQuestion(q11c);
            
            
            QuestionWrapper q11d = new QuestionWrapper();
            q11d.setQuestion("postharvestlosses");
            q11d.setAnswer("More than 30% loss");
            q11d.setScore("1");
            qu.createQuestion(q11d);
            
            
            QuestionWrapper q4a = new QuestionWrapper();
            q4a.setQuestion("borrowmoney");
            q4a.setAnswer("Annually or seasonally");
            q4a.setScore("7");
            qu.createQuestion(q4a);
            
            QuestionWrapper q4b = new QuestionWrapper();
            q4b.setQuestion("borrowmoney");
            q4b.setAnswer("Every two years");
            q4b.setScore("5");
            qu.createQuestion(q4b);
            
            QuestionWrapper q4c = new QuestionWrapper();
            q4c.setQuestion("borrowmoney");
            q4c.setAnswer("Occasionally (more than 2 years interval)");
            q4c.setScore("3");
            qu.createQuestion(q4c);
            
            QuestionWrapper q4d = new QuestionWrapper();
            q4d.setQuestion("borrowmoney");
            q4d.setAnswer("I never borrow money for my farming.");
            q4d.setScore("1");
            qu.createQuestion(q4d);
            
            QuestionWrapper q6a = new QuestionWrapper();
            q6a.setQuestion("familylabor");
            q6a.setAnswer("All my farm labor come from my family or voluntary labor group");
            q6a.setScore("1");
            qu.createQuestion(q6a);
            
            
            QuestionWrapper q6b = new QuestionWrapper();
            q6b.setQuestion("familylabor");
            q6b.setAnswer("More than 50% but less than 100%");
            q6b.setScore("3");
            qu.createQuestion(q6b);
            
            QuestionWrapper q6c = new QuestionWrapper();
            q6c.setQuestion("familylabor");
            q6c.setAnswer("About 50%");
            q6c.setScore("5");
            qu.createQuestion(q6c);
            
            QuestionWrapper q6d = new QuestionWrapper();
            q6d.setQuestion("familylabor");
            q6d.setAnswer("About 20% or less");
            q6d.setScore("7");
            qu.createQuestion(q6d);
            
            QuestionWrapper q6e = new QuestionWrapper();
            q6e.setQuestion("familylabor");
            q6e.setAnswer("None");
            q6e.setScore("10");
            qu.createQuestion(q6e);
            
            
            
            QuestionWrapper q7na = new QuestionWrapper();
            q7na.setQuestion("proportion sold");
            q7na.setAnswer("Almost all my produce is sold");
            q7na.setScore("10");
            qu.createQuestion(q7na);
            
            QuestionWrapper q7nb = new QuestionWrapper();
            q7nb.setQuestion("proportion sold");
            q7nb.setAnswer("About 75%.is sold");
            q7nb.setScore("7");
            qu.createQuestion(q7nb);
            
            QuestionWrapper q7nc = new QuestionWrapper();
            q7nc.setQuestion("proportion sold");
            q7nc.setAnswer("About 50% is sold");
            q7nc.setScore("5");
            qu.createQuestion(q7nc);
            
            
            QuestionWrapper q7nd = new QuestionWrapper();
            q7nd.setQuestion("proportion sold");
            q7nd.setAnswer("About 25% is sold");
            q7nd.setScore("3");
            qu.createQuestion(q7nd);
            
            QuestionWrapper q7ne = new QuestionWrapper();
            q7ne.setQuestion("proportion sold");
            q7ne.setAnswer("Very little is sold");
            q7ne.setScore("1");
            qu.createQuestion(q7ne);
            
            
            QuestionWrapper q8na = new QuestionWrapper();
            q8na.setQuestion("new idea");
            q8na.setAnswer("Every year or season");
            q8na.setScore("10");
            qu.createQuestion(q8na);
            
            QuestionWrapper q8nb = new QuestionWrapper();
            q8nb.setQuestion("new idea");
            q8nb.setAnswer("About every 2 years");
            q8nb.setScore("7");
            qu.createQuestion(q8nb);
            
            QuestionWrapper q8nc = new QuestionWrapper();
            q8nc.setQuestion("new idea");
            q8nc.setAnswer("About every 5 years");
            q8nc.setScore("3");
            qu.createQuestion(q8nc);
            
            
            QuestionWrapper q8nd = new QuestionWrapper();
            q8nd.setQuestion("new idea");
            q8nd.setAnswer("About every 10 years");
            q8nd.setScore("1");
            qu.createQuestion(q8nd); 
            
            QuestionWrapper q9na = new QuestionWrapper();
            q9na.setQuestion("regular practice");
            q9na.setAnswer("Leaving residues of harvested crops");
            q9na.setScore("1");
            qu.createQuestion(q9na); 
            
            QuestionWrapper q9nb = new QuestionWrapper();
            q9nb.setQuestion("regular practice");
            q9nb.setAnswer("Crop rotation with beans");
            q9nb.setScore("3");
            qu.createQuestion(q9nb);
            
            
            QuestionWrapper q9nc = new QuestionWrapper();
            q9nc.setQuestion("regular practice");
            q9nc.setAnswer("Application of animal manure");
            q9nc.setScore("5");
            qu.createQuestion(q9nc);
            
            QuestionWrapper q9nd = new QuestionWrapper();
            q9nd.setQuestion("regular practice");
            q9nd.setAnswer("Application of compost");
            q9nd.setScore("7");
            qu.createQuestion(q9nd);
            
            
            QuestionWrapper q10na = new QuestionWrapper();
            q10na.setQuestion("regular practice");
            q10na.setAnswer("None or very little loss");
            q10na.setScore("10");
            qu.createQuestion(q10na);
            
            QuestionWrapper q10nb = new QuestionWrapper();
            q10nb.setQuestion("regular practice");
            q10nb.setAnswer("up to 10% loss");
            q10nb.setScore("7");
            qu.createQuestion(q10nb);
            
            QuestionWrapper q10nc = new QuestionWrapper();
            q10nc.setQuestion("regular practice");
            q10nc.setAnswer("10 to 20% loss");
            q10nc.setScore("5");
            qu.createQuestion(q10nc);
            
            QuestionWrapper q10nd = new QuestionWrapper();
            q10nd.setQuestion("regular practice");
            q10nd.setAnswer("20 to 30% loss");
            q10nd.setScore("3");
            qu.createQuestion(q10nd);
            
            
            QuestionWrapper q10ne = new QuestionWrapper();
            q10ne.setQuestion("regular practice");
            q10ne.setAnswer("More than 30% loss");
            q10ne.setScore("1");
            qu.createQuestion(q10ne);
//            
           System.out.println("Question done");
           
//           
//           BiodataWrapper wr = new BiodataWrapper();
//           BiodataModel b  = new BiodataModel();
//           
           
//           for(int i=0;i<100;i++)
//           {
//               wr.setAge(String.valueOf(i));
//               wr.setFirstName("name"+i);
//               wr.setLastName("lname" + i);
//               
//               b.createBiodata(wr);
//           }
//           
//           for(int i=100;i<1000;i++)
//           {
//               wr.setAge(String.valueOf(i));
//               wr.setFirstName("name"+i);
//               wr.setLastName("lname" + i);
//               
//               b.createBiodata(wr);
//           }
           
           
////            
//                         ProfilingModel pm = new ProfilingModel();
//                          Map<String,String> update = new HashMap<>();
//                          BiodataModel biodataModel = new BiodataModel();
//                         
//                         Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx();
//                         
//                          Profiling p =  pm.getProfile("Id", "a0m24000004iqGiAAI");
//                          
//                          System.out.println("Profile " + p.getFarmrecordkeepingstatus());
//                          String q2 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getFbomembership().toLowerCase()).getScore();
//                          String q6 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getFarmrecordkeepingstatus().toLowerCase()).getScore();
//                          String q5 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getOperatebankaccount().toLowerCase()).getScore();
//                          String q7 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getProducesoldproportion()).getScore();
//                          String q8 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getRiskdispositionborrow()).getScore();
//                          String q9 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getInnovativenessbytrying()).getScore();
//                          String q10 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getSoilfertilitypractices()).getScore();
//                          String q11 = pm.getScoreByAnswer(Ouestion.ANSWER, p.getPostharvestlosses()).getScore();
//
//                          
//                          System.out.println("results"+ q2+" "+" "+q6+" "+q5+" "+q7+" "+q8+" "+q9+" "+q10+" "+q11);
//                          
//                         
//                          int score = Integer.valueOf(q2)+Integer.valueOf(q5)+Integer.valueOf(q6)+Integer.valueOf(q7)+
//                                  Integer.valueOf(q8)+Integer.valueOf(q9)+Integer.valueOf(q10)+Integer.valueOf(q11);
//                          
//                          System.out.println("score" + score);
//                          
//                          
//                          System.out.println("Cluster " + getCluster(score));
//                          
//                           update.put(Biodata.CLUSTER, getCluster(score));
//                           biodataModel.BiodataUpdate("a0m24000004iqGiAAI", update);
//                          
//                          
//                          trx.success();
//                          
//            
//        }
//    }
//
//    
//    public String getCluster(int score)
//    {
//        System.out.println("score is " + score);
//        if (score >= 45 && score <= 60) {
//            return "1";
//        } 
//        else if (score >=30 && score <=45) {
//            return "2";
//        } else if (score >=16 && score <=29) {
//            return "3";
//        }
//        else {
//            return "4";
//        }
//     String serverResponse = "";
//
//     String url = "http://sandbox-ictchallenge.cs80.force.com/getMeasurement";
//     
//           JSONArray m = new JSONArray();
//           
//          m.put("00P25000000wJHJEA2");
//         // m.put("00P25000000gLqwEAE");
//          //m.put("00P25000000gLr1EAE");
//     
//            JSONObject j = new JSONObject();
//            j.put("requestType", "measure");
//            j.put("farmerId", "a1O25000000B5gJEAS");
//            j.put("area","23.0987");
//            j.put("perimeter","180.0987");
//            
//            
//            Map<String, String> parameters = new HashMap<String, String>();
//            System.out.println(j.toString());
//
//            parameters.put("data", j.toString());
//            parameters.put("method","measurement");
//
//            String result = SalesforceHttpClient.getSalesforceData(url, parameters);
//            System.out.println(result);
//            out.println(result);

//            JSONObject json = new JSONObject(result);
//            
//
//         // String res = json.getString("image");
//            JSONArray ja = json.getJSONArray("imageResults");
//            
//            String root = "com.sun.aas.instanceRoot";
//           
//       
//           
//            String path = "";
//
//            File f = new File(System.getProperty(root) + "/docroot/newimages");
//             if (!f.exists()) {
//                f.mkdirs();
//            } 
//            
//           for(int i =0;i<ja.length();i++)
//           {
//               JSONObject o = (JSONObject) ja.get(i);
//           
//            path = f.getPath() + File.separator + i+"n.jpg";
//            System.out.println("path " + path);
//            byte[] data = Base64.decode(o.getString("imageData"));
//            try (OutputStream stream = new FileOutputStream(path)) {
//                stream.write(data);
//            }
//           }
//            HttpCliSent client = new DefaultHttpClient();
//            HttpPost post = new HttpPost(url);
//            
//            System.out.println("data " + j.toString());
//            
//            List<NameValuePair> nameValuePairs = new ArrayList<>(1);
//            nameValuePairs.add(new BasicNameValuePair("data",
//                    j.toString()));
//            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//
//            HttpResponse resp = client.execute(post);
//            BufferedReader rd = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()));
//            String line = "";
//            while ((line = rd.readLine()) != null) {
//                System.out.println(line);
//                out.println(line);
//                serverResponse += line;
//
//            }
//            
//             System.out.println(serverResponse);
            
//             AgentModel agentModel = new AgentModel();
//            BiodataModel biodataModel = new BiodataModel();
//
//            Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx();
//            List<AgentWrapper> agent = agentModel.findAllAgents();
//            int sum = 0;
//            
//            
//              for (AgentWrapper a :agent) {
//
//            
//                  System.out.println(a.getFirstname() + " " +a.getLastname());  
//                  sum+= Integer.valueOf(String.valueOf( biodataModel.getFarmerCountByAgent(a.getAgentId()))).intValue();
////                 biodataModel.getFarmerProfileCountByAgent(a.getAgentId());
////                 biodataModel.getFarmerBaselinProductionCountByAgent(a.getAgentId()) 
////                 biodataModel.getFarmerBaselineProductionBudgetCountByAgent(a.getAgentId())
////                 biodataModel.getFarmerBaselinePostHarvestCountByAgent(a.getAgentId())
////                 biodataModel.getFarmerBaselinePostHarvestBudgetCountByAgent(a.getAgentId())
////                 biodataModel.getFarmerFMPProductionCountByAgent(a.getAgentId()) 
////                 biodataModel.getFarmerFMPPostHarvestCountByAgent(a.getAgentId())
//                
//            
//             }
//            System.out.println("Sum farmer " + sum);
          ///  tx.success();
            
            

    
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
        try {
            processRequest(request, response);
        } catch (SAXException ex) {
            Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SAXException ex) {
            Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
