/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;

import com.grameenfoundation.ictc.domains.BaselinePostHarvest;
import com.grameenfoundation.ictc.domains.BaselinePostHarvestBudget;
import com.grameenfoundation.ictc.domains.BaselineProduction;
import com.grameenfoundation.ictc.domains.BaselineProductionBudget;
import com.grameenfoundation.ictc.domains.Biodata;
import com.grameenfoundation.ictc.domains.FieldCropAssessment;
import com.grameenfoundation.ictc.domains.FmpProductionBudget;
import com.grameenfoundation.ictc.domains.Meeting;
import com.grameenfoundation.ictc.domains.PostHarvest;
import com.grameenfoundation.ictc.domains.PostHarvest2;
import com.grameenfoundation.ictc.domains.ProductionNew;
import com.grameenfoundation.ictc.domains.Profiling;
import com.grameenfoundation.ictc.domains.TechnicalNeed;
import com.grameenfoundation.ictc.models.AgentModel;
import com.grameenfoundation.ictc.models.BaselinePostHarvestBudgetModel;
import com.grameenfoundation.ictc.models.BaselinePostHarvestModel;
import com.grameenfoundation.ictc.models.BaselineProductionBudgetModel;
import com.grameenfoundation.ictc.models.BaselineProductionModel;
import com.grameenfoundation.ictc.models.BiodataModel;
import com.grameenfoundation.ictc.models.FarmerInputModel;
import com.grameenfoundation.ictc.models.FieldCropAssessmentModel;
import com.grameenfoundation.ictc.models.FmpPostHarvestBudgetModel;
import com.grameenfoundation.ictc.models.FmpProductionBudgetModel;
import com.grameenfoundation.ictc.models.MeetingModel;
import com.grameenfoundation.ictc.models.PostHarvestModel;
import com.grameenfoundation.ictc.models.ProductionModel;
import com.grameenfoundation.ictc.models.ProfilingModel;
import com.grameenfoundation.ictc.models.TechnicalNeedsModel;
import com.grameenfoundation.ictc.models.UserModel;
import com.grameenfoundation.ictc.utils.HTTPCommunicator;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.wrapper.AgentWrapper;
import com.grameenfoundation.ictc.wrapper.BiodataWrapper;
import com.grameenfoundation.ictc.wrapper.FarmerInputReceivedWrapper;
import com.grameenfoundation.ictc.wrapper.MeetingWrapper;
import com.grameenfoundation.ictc.wrapper.UserWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.jboss.netty.handler.codec.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.neo4j.graphdb.Transaction;

/**
 *
 * @author skwakwa
 */
@WebServlet(name = "MobileController", urlPatterns = {"/MobileController"})
public class MobileController extends HttpServlet {

    public static String IVR_URL = "http://41.191.245.72/nymess/ictc.php?action=";

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
            System.out.println("action " + serviceCode);
            BiodataModel bModel = new BiodataModel();
            if ("login".equals(serviceCode)) {

                String username = request.getParameter("us");
                String pwd = request.getParameter("pwd");
                AgentWrapper user = new AgentModel().findUser(username, pwd);
                System.out.println("User: "+user);
                if (null == user) {
                    jSONObject.put("rc", "01");
                    jSONObject.put("msg", "Unable to Login");
                    out.print(jSONObject);
                } else {
                    //do as details action   
//                    List<BiodataWrapper> farmers = bModel.getBioData("a", "");
//                    JSONArray farmerArray = getFarmers(farmers);

                    jSONObject.put("rc", "00");

//                    jSONObject.put("farmer", farmerArray);
                    jSONObject.put("org", user.getAgenttype());
                    jSONObject.put("lname", user.getLastname());
                    jSONObject.put("fname", user.getFirstname());
                    jSONObject.put("userId", user.getAgentcode());
                    String agentId = user.getAgentId();
                    if(agentId.isEmpty())
                        agentId="00524000001xFMiAAM";
                    jSONObject.put("sfId", agentId);
                    
                    jSONObject.put("type", user.getAgenttype());

                    out.print(jSONObject);
                }

            } else if ("details".equals(serviceCode)) {

                List<BiodataWrapper> farmers = bModel.getBioData("a", "");

                JSONArray farmerArray = getFarmers(farmers);

                jSONObject.put("farmer", farmerArray);
                jSONObject.put("rc", "00");
                out.print(jSONObject);

            } 
                //Farm Inputs
            else if ("fi".equals(serviceCode)) {

                String farmer = request.getParameter("fid");
                String seeds = request.getParameter("s");
                String fertiliser = request.getParameter("f");
                String plough = request.getParameter("p");
                FarmerInputModel fim = new FarmerInputModel();
                List<FarmerInputReceivedWrapper> farmers = fim.getFarmerInputs(farmer);

                FarmerInputReceivedWrapper seedsReceived = searchNeeds(farmers, "seeds");
                FarmerInputReceivedWrapper fertReceived = searchNeeds(farmers, "fertiliser");
                FarmerInputReceivedWrapper ploughReceived = searchNeeds(farmers, "plough");

                if (null == fertReceived && !fertiliser.isEmpty()) {
                    fertReceived = new FarmerInputReceivedWrapper("fertiliser", null, "N", Double.parseDouble(fertiliser), farmer);
                    fim.create(fertReceived);
                }

                if (null == seedsReceived && !seeds.isEmpty()) {
                    seedsReceived = new FarmerInputReceivedWrapper("seeds", null, "N", Double.parseDouble(fertiliser), farmer);
                    fim.create(seedsReceived);
                }

                if (null == ploughReceived && !plough.isEmpty()) {
                    ploughReceived = new FarmerInputReceivedWrapper("plough", null, "N", 1, farmer);
                    fim.create(ploughReceived);
                }
                JSONObject obj = new JSONObject();
                obj.put("rc", "00");
                HTTPCommunicator.doGet(IVR_URL + "reg&fid=" + farmer + "&s=" + seeds + "&f=" + fertiliser + "&p=" + plough + "&msisdn="+farmer);
                out.print(obj);

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
            } else if ("markattendance".equalsIgnoreCase(serviceCode)) {
                Map<String,String> update = new HashMap<>();
                MeetingModel meetingModel = new MeetingModel();
                Meeting m = null;
                String[] farmer_id = request.getParameterValues("fid");
                String meetingIndex = request.getParameter("mtg");
                String crop = request.getParameter("cr");
                update.put(Meeting.ATTENDED,"1");
                for(String id : farmer_id)
                {
                   m=meetingModel.findMeetingByFarmerCrop(id,meetingIndex, crop).get(0);
                   meetingModel.MeetingUpdate(m.getId(), update);
                }
                

            }else if("fmap".equalsIgnoreCase(serviceCode.trim()))
            {
                
               
                String res = request.getParameter("l");
                String farmer = request.getParameter("fid");
                
                System.out.println("points " + res);
                System.out.println("Farmer " + farmer);

                JSONObject j = new JSONObject(res);

               
                double area = (double) j.get("area");
                double perimeter = j.getDouble("perimeter");
                
                
                System.out.println("Area " + area);
                System.out.println("Perimeter " + perimeter);
                
                JSONArray ja = new JSONArray();
                ja = (JSONArray) j.get("points");
                
                BiodataModel bdata = new BiodataModel();
                Map<String, String> m = new HashMap<String, String>();

                m.put(Biodata.FARM_AREA, String.valueOf(area));
                m.put(Biodata.FARM_PERIMETER, String.valueOf(perimeter));
                boolean updated = bdata.BiodataUpdate(farmer, m);
                
                if(updated)
                {
                    System.out.println("Farmer update done " + updated);

                    JSONObject obj = new JSONObject();
                    obj.put("rc", "00");
                    out.print(obj);
                 
                }
                else
                {
                    System.out.println("Update not done");
                }
            }
             else if("images".equals(serviceCode))
            {
                 String url = "http://sandbox-ictchallenge.cs80.force.com/AgentRequest";
                  //String url ="http://ictchallenge.force.com/agentRequest";
                 Map<String,String> parameters =  new HashMap<String,String>();
                
                 String farmer_id = request.getParameter("farmerid");
                 //dparameters.put("data", url)
                 
                 String result = SalesforceHttpClient.getSalesforceData(url, parameters);
                 
                 
                 
                
                 out.print(result);
                
                
            }
             else if ("fdetails".equalsIgnoreCase(serviceCode)) {
                
                 Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx();
                
                 JSONArray jay= new JSONArray();
                 
                 
                 List<BiodataWrapper> bw = new BiodataModel().getBioData("","");
                 System.out.println("Farmer count " + bw.size());
                 System.out.println("Farmer count " + bw.size());
                BiodataModel biodataModel = new BiodataModel();
                ProductionModel productionModel = new ProductionModel();
                PostHarvestModel postHarvestModel = new PostHarvestModel();
                BaselineProductionModel baselineProductionModel = new BaselineProductionModel();
                BaselineProductionBudgetModel baselineProductionBudgetModel = new BaselineProductionBudgetModel();
                BaselinePostHarvestModel baselinePostHarvestModel = new BaselinePostHarvestModel();
                BaselinePostHarvestBudgetModel baselinePostHarvestBudgetModel = new BaselinePostHarvestBudgetModel();
                FmpProductionBudgetModel fmpProductionBudgetModel = new FmpProductionBudgetModel();
                TechnicalNeedsModel technicalNeedsModel = new TechnicalNeedsModel();
                ProfilingModel profilingModel = new ProfilingModel();
                FieldCropAssessmentModel fieldCropAssessmentModel = new FieldCropAssessmentModel();
                FmpPostHarvestBudgetModel fmpPostHarvestBudgetModel = new FmpPostHarvestBudgetModel();
                 
                JSONArray fa = new JSONArray();
                
                
             if(null!=bw)
               {
               
                
                    JSONObject production = null;
                    JSONObject postHarvest = null;
                    JSONObject farmer = null;
                    JSONObject details = null;
                    JSONObject meetng = null;
                    JSONObject baselineproduction = null;
                    JSONObject baselineproductionbudget = null;
                    JSONObject baselinepostharvest = null;
                    JSONObject technicalNeeds = null;
                    JSONObject profiling = null;
                    JSONObject baselinepostharvestbudget = null;
                    JSONObject fmpproductionbudget = null;
                    JSONObject fieldcropassessment = null;
                    JSONObject fmppostharvestbudget = null;
                    Biodata b = null;
                    JSONArray meetingArray = null;
                    List<MeetingWrapper> meetings = null;
                    List<FarmerInputReceivedWrapper> fi = null;
                    JSONArray inputArray = null;
                    ProductionNew p = null;
                    PostHarvest2 ph = null;
                    BaselineProduction bp = null;
                    BaselineProductionBudget bpb = null;
                    BaselinePostHarvest bph = null;
                    TechnicalNeed techNeed = null;
                    Profiling pr = null;
                    BaselinePostHarvestBudget bphb = null;
                    FmpProductionBudget fmppb = null;
                    FieldCropAssessment fca = null;

                for(BiodataWrapper bb :bw)
                {
                    
                        production = new JSONObject();
                        postHarvest = new JSONObject();
                        farmer = new JSONObject();
                        details = new JSONObject();
                        meetng = new JSONObject();
                        baselineproduction = new JSONObject();
                        baselineproductionbudget = new JSONObject();
                        baselinepostharvest = new JSONObject();
                        technicalNeeds = new JSONObject();
                        profiling = new JSONObject();
                        baselinepostharvestbudget = new JSONObject();
                        fmpproductionbudget = new JSONObject();
                        fieldcropassessment = new JSONObject();
                        fmppostharvestbudget = new JSONObject();

                
                 
                 //biodata
                 b = new BiodataModel().getBiodata("Id", bb.getFarmID());
                
                if(null!=b)
                {
                            farmer.put(Biodata.FIRST_NAME, b.getFirstname());
                            farmer.put(Biodata.LAST_NAME, b.getLastname());
                            farmer.put(Biodata.AGE, b.getAge());
                            farmer.put(Biodata.COMMUNITY, b.getCommunity());
                            farmer.put(Biodata.GENDER, b.getGender());
                            farmer.put(Biodata.EDUCATION, b.getEducation());
                            farmer.put(Biodata.FARMERID, b.getId());
                            farmer.put(Biodata.FARMERIMAGE, b.getFarmerimage());
                            farmer.put(Biodata.MAJOR_CROP, b.getMajorCrop());
                            farmer.put(Biodata.MARITAL_STATUS, b.getMaritalstatus());
                            farmer.put(Biodata.NICKNAME, b.getNickname());
                            farmer.put(Biodata.NUMBER_OF_CHILDREN, b.getNumberofchildren());
                            farmer.put(Biodata.NUMBER_OF_DEPENDANTS, b.getNumberofdependants());
                            farmer.put(Biodata.REGION, b.getRegion());
                            farmer.put(Biodata.VILLAGE, b.getVillage());
                            farmer.put(Biodata.CREATED_BY,b.getCreatedById());
                            farmer.put(Biodata.TELEPHONENUMBER,b.getTelephonenumber());
                            farmer.put(Biodata.IMAGE_URL,b.getImage_Url());
                            
                          
                           if(null!=b.getDisrictresidenceash())
                           {
                               farmer.put(Biodata.DISRICTRESIDENCEASH,b.getDisrictresidenceash());
                           }
                           if(null!=b.getDistrictresidenceba())
                           {
                               farmer.put(Biodata.DISTRICTRESIDENCEBA,b.getDistrictresidenceba());
                           }
                           
                         if(null!=b.getDistrictresidenceba())
                           {
                               farmer.put(Biodata.DISTRICTRESIDENCEBA,b.getDistrictresidenceba());
                           }
                         
                          
  
                            if(null!=b.getDistricts_Ashanti())
                            {
                                farmer.put(Biodata.DISTRICTS_ASHANTI, b.getDistricts_Ashanti()); 
                            }
                            else if(null!=b.getDistricts_BrongAhafo())
                            {
                                farmer.put(Biodata.DISTRICTS_BRONGAHAFO, b.getDistricts_BrongAhafo()); 
                            }
                            else
                            {
                                farmer.put(Biodata.DISTRICTS_VOLTA, b.getDistricts_Volta()); 
                            }

                            farmer.put(Biodata.FARM_PERIMETER, b.getFarmperimeter());

                            if (null != b.getCluster()) {
                                farmer.put(Biodata.CLUSTER, b.getCluster());
                            } else {
                                farmer.put(Biodata.CLUSTER, "");
                            }

                            if (null != b.getFarmarea()) {
                                farmer.put(Biodata.FARM_AREA, b.getCluster());
                            } else {
                                farmer.put(Biodata.FARM_AREA, "0");
                            }


                            
                            
                            
                            meetingArray = new JSONArray();
                            meetings = b.getMeetingDetails();
                            for (MeetingWrapper meeting : meetings) {
                                JSONObject meetingObj = new JSONObject();
                                meetingObj.put("midx", meeting.getMeetingIndex());
                                meetingObj.put("ty", meeting.getType());
                                meetingObj.put("sea", meeting.getSeason());
                                meetingObj.put("sd", meeting.getStartDate());
                                meetingObj.put("ed", meeting.getEndDate());
                                meetingObj.put("at", meeting.getAttended());
                                meetingArray.put(meetingObj);
                            }

                            inputArray = new JSONArray();
                            fi = b.getFarmInputs();
                            for (FarmerInputReceivedWrapper f : fi) {
                                JSONObject inputObj = new JSONObject();
                                inputObj.put("nm", f.getName());
                                inputObj.put("qty", f.getQty());
                                inputObj.put("st", f.getStatus());
                                inputArray.put(inputObj);
                            }
                }
                
                
                //farmer.put
                
                 //Production
                 p =  b.getProduction();
                
                if(null!=p)
                {
                    
                 System.out.println("Production " + p.getAcresofland() + "farmer " + b.getFirstname());
                 production.put( ProductionNew.ACRESOFLAND,p.getAcresofland());
                 production.put( ProductionNew.APPLICATIONMONTHOFHERBICIDEDATE,p.getApplicationmonthofherbicidedate());
                 production.put(ProductionNew.APPLICATIONOFBASALFERTILIZER, p.getApplicationofbasalfertilizer());
                 production.put(ProductionNew.APPLICATIONOFBASALFERTILIZERDATE,p.getApplicationofbasalfertilizerdate());
                 production.put(ProductionNew.APPLICATIONOFTOPDRESSFERTILIZER, p.getApplicationoftopdressfertilizer());
                 production.put(ProductionNew.DATEFIFTHPOSTGEMWEEDCONTROL, p.getDatefifthpostgemweedcontrol());
                 production.put(ProductionNew.DATEFIRSTMANUALWEEDCONTROL,p.getDatefirstmanualweedcontrol());
                 production.put(ProductionNew.DATEFOURTHPOSTGEMWEEDCONTROL,p.getDatefourthpostgemweedcontrol());
                 production.put(ProductionNew.DATEOFSECONDMANUALWEEDCONTROL,p.getDateofsecondmanualweedcontrol());
                 production.put(ProductionNew.DATETHIRDMANUALWEEDCONTROL,p.getDatethirdmanualweedcontrol());
                 production.put(ProductionNew.LANDCLEARINGDATE,p.getLandclearingdate());
                 production.put(ProductionNew.METHODOFBASALFERTILIZERAPPLICATION,p.getMethodofbasalfertilizerapplication());
                 production.put(ProductionNew.METHODOFBASALFERTILIZERAPPLICATIONOTHER,p.getMethodofbasalfertilizerapplicationother());
                 production.put(ProductionNew.METHODOFLANDCLEARING,p.getMethodoflandclearing());
                 production.put(ProductionNew.METHODOFLANDPREPARATION,p.getMethodoflandpreparation());
                 production.put(ProductionNew.METHODTOPDRESSFERTILIZERAPP,p.getMethodtopdressfertilizerapp());
                 production.put(ProductionNew.NAMEOFCROPVARIETY,p.getNameofcropvariety());
                 production.put(ProductionNew.NAMEOFCROPVARIETYCASSAVA,p.getNameofcropvarietycassava());
                 production.put(ProductionNew.NAMEOFCROPVARIETYRICE,p.getNameofcropvarietyrice());
                 production.put(ProductionNew.NAMEOFCROPVARIETYYAM,p.getNameofcropvarietyyam());
                 production.put(ProductionNew.OTHERFERTILIZER,p.getOtherfertilizer());
                 production.put(ProductionNew.PLANTINGDATE,p.getPlantingdate());
                 production.put(ProductionNew.PLANTINGDISTANCEBETWEENPLANTSMAIZE,p.getPlantingdate());
                 production.put(ProductionNew.PLANTINGDISTANCEBETWEENPLANTSMAIZEYC,p.getPlantingdistancebetweenplantsmaizeyc());
                 production.put(ProductionNew.PLANTINGDISTANCEBETWEENPLANTSRICE,p.getPlantingdistancebetweenplantsrice());
                 production.put(ProductionNew.PLANTINGDISTANCEBETWEENROWSMAIZE,p.getPlantingdistancebetweenrowsmaize());
                 production.put(ProductionNew.PLANTINGDISTANCEBETWEENROWSYC,p.getPlantingdistancebetweenrowsyc());
                 production.put(ProductionNew.PLOUGHINGDATE,p.getPloughingdate());
                 production.put(ProductionNew.POSTPLANTHERBICIDEUSE,p.getPostplantherbicideuse());
                 production.put(ProductionNew.QUANTITYOFBASALFERTILIZERPURCHASEDAPPLY,p.getQuantityofbasalfertilizerpurchasedapply());
                 production.put(ProductionNew.QUANTITYOFTOPDRESSERFERTILIZERPURCHASED,p.getQuantityoftopdresserfertilizerpurchased());
                 production.put(ProductionNew.QUANTITYPOSTPLANTHERBICIDE,p.getQuantitypostplantherbicide());
                 production.put(ProductionNew.REFILLINGGAPSOCCURENCE,p.getRefillinggapsoccurence());
                 production.put(ProductionNew.REFILLINGGAPSPROPORTION,p.getRefillinggapsproportion());
                 production.put(ProductionNew.SEEDBEDFORMTYPE,p.getSeedbedformtype());
                 production.put(ProductionNew.SEEDBEDPREPARATIONDATE,p.getSeedbedformtype());
                 production.put(ProductionNew.SOURCEOFSEEDORPLANTINGMATERIAL,p.getSourceofseedorplantingmaterial());
                 production.put(ProductionNew.SOURCEOFSEEDORPLANTINGMATERIALOTHER,p.getSourceofseedorplantingmaterialother());
                 production.put(ProductionNew.TARGETYIELDPERACRE,p.getTargetyieldperacre());
                 production.put(ProductionNew.TIMEOFAPPLICATIONTOPDRESSING,p.getTimeofapplicationtopdressing());
                 production.put(ProductionNew.TIMEOFHARVEST,p.getTimeofharvest());
                 production.put(ProductionNew.TOPDRESSFERTILIZEROTHER,p.getTopdressfertilizerother());
                 production.put(ProductionNew.TYPEOFBASALFERTILIZER,p.getTypeofbasalfertilizer());
                 production.put(ProductionNew.TYPEOFFERTILIZERTOPDRESSING,p.getTypeoffertilizertopdressing());
                 production.put(ProductionNew.TYPEOFHERBICIDEPOSTPLANTWEED,p.getTypeofherbicidepostplantweed());
                 
                 
                }
                 
                
                //Post Harvest
                 ph = new PostHarvestModel().getPostHarvest("Id", bb.getFarmID());
                 if(null!=ph)
                {
                 System.out.println("Post Harvest " + ph.getApplicationrateofstoragechemical() + "farmer " + b.getFirstname());
                 postHarvest.put(PostHarvest2.APPLICATIONRATEOFSTORAGECHEMICAL,ph.getApplicationrateofstoragechemical());
                 postHarvest.put(PostHarvest2.COMPLETIONOFPRODUCEMARKETING,ph.getCompletionofproducemarketing());
                 postHarvest.put(PostHarvest2.COMPLETIONOFTHRESHING,ph.getCompletionofthreshing());
                 postHarvest.put(PostHarvest2.DATEOFCOMPLETINGDRYING,ph.getDateofcompletingdrying());
                 postHarvest.put(PostHarvest2.DATETOCOMPLETEDRYING,ph.getDatetocompletedrying());
                 postHarvest.put(PostHarvest2.DEHUSKINGDATE,ph.getDehuskingdate());
                 postHarvest.put(PostHarvest2.FIRSTSALEDATE,ph.getFirstsaledate());
                 postHarvest.put(PostHarvest2.MAINPOINTOFSALEORCONTACT,ph.getMainpointofsaleorcontact());
                 postHarvest.put(PostHarvest2.MANUALTHRESHING,ph.getManualthreshing());
                 postHarvest.put(PostHarvest2.MANUALWINNOWING,ph.getManualwinnowing());
                 postHarvest.put(PostHarvest2.MARKETINGOCCASIONS,ph.getMarketingoccasions());
                 postHarvest.put(PostHarvest2.METHODOFDRYINGCOBSPANICLESCHIPSCHU,ph.getMethodofdryingcobspanicleschipschu());
                 postHarvest.put(PostHarvest2.METHODOFDRYINGGRAIN,ph.getMethodofdryinggrain());
                 postHarvest.put(PostHarvest2.METHODOFTHRESHING,ph.getMethodofthreshing());
                 postHarvest.put(PostHarvest2.METHODOFWINNOWING,ph.getMethodofwinnowing());
                 postHarvest.put(PostHarvest2.MOSTPRODUCESALEDATE,ph.getMostproducesaledate());
                 postHarvest.put(PostHarvest2.OTHERAPPLICATIONRATE,ph.getOtherapplicationrate());
                 postHarvest.put(PostHarvest2.OTHERMETHODFORDRYING,ph.getOthermethodfordrying());
                 postHarvest.put(PostHarvest2.OTHERMETHODOFDRYINGGRAIN,ph.getOthermethodofdryinggrain());
                 postHarvest.put(PostHarvest2.OTHERMETHODSOFDEHUSKING,ph.getOthermethodsofdehusking());
                 postHarvest.put(PostHarvest2.OTHERSALECONTACT,ph.getOthersalecontact());
                 postHarvest.put(PostHarvest2.OTHERSTORAGECHEMICAL,ph.getOtherstoragechemical());
                 postHarvest.put(PostHarvest2.POSTHARVESTLOSSES,ph.getPostharvestlosses());
                 postHarvest.put(PostHarvest2.PRICEATFIRSTSALEDATE,ph.getPriceatfirstsaledate());
                 postHarvest.put(PostHarvest2.PRICEATMOSTSALEDATE,ph.getPriceatmostsaledate());
                 postHarvest.put(PostHarvest2.PROCESSINGOFCASSAVA,ph.getProcessingofcassava());
                 postHarvest.put(PostHarvest2.PROPORTIONFORMARKET,ph.getProportionformarket());
                 postHarvest.put(PostHarvest2.PROPORTIONOFCASSAVAPROCESSEDINTOCHIPS,ph.getProportionofcassavaprocessedintochips());
                 postHarvest.put(PostHarvest2.THERAPPLICATIONRATEOFSTORAGECHEMIC,ph.getTherapplicationrateofstoragechemic());
                 postHarvest.put(PostHarvest2.TYPEOFBAGUSEDINBULKINGPRODUCT,ph.getTypeofbagusedinbulkingproduct());
                 postHarvest.put(PostHarvest2.TYPEOFMACHINE,ph.getTypeofmachine());
                 postHarvest.put(PostHarvest2.TYPEOFMACHINEWINOWING,ph.getTypeofmachinewinowing());
                 postHarvest.put(PostHarvest2.TYPEOFSTORAGECHEMICAL,ph.getTypeofstoragechemical());
                 postHarvest.put(PostHarvest2.TYPEOFSTORAGESTRUCTURE,ph.getTypeofstoragestructure());
                } 
                 
                 
                 //farmer.put("production",production);
                 //farmer.put("postharvest",postHarvest);
                 details.put("farmer", farmer);

                 fa.put(details);
                
                 
                 
                }
                 
                 tx.success();
                    
                out.println(fa);
                 }
                 else
                 {
                     JSONObject obj = new JSONObject();
                     obj.put("rc", "05");
                     obj.put("msg", "Invalid Action");
                     out.print(obj);
                 }
                 
            }
            else
            {

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

                JSONArray meetingArray = new JSONArray();
                List<MeetingWrapper> meetings = new MeetingModel().findFarmerMeeting(bd.getFarmID());
                for (MeetingWrapper meeting : meetings) {
                    JSONObject meetingObj = new JSONObject();
                    meetingObj.put("midx", meeting.getMeetingIndex());
                    meetingObj.put("ty", meeting.getType());
                    meetingObj.put("sea", meeting.getSeason());
                    meetingObj.put("sd", meeting.getStartDate());
                    meetingObj.put("ed", meeting.getEndDate());
                    meetingObj.put("at",meeting.getAttended());
                    meetingArray.put(meetingObj);
                }
                if (meetingArray.length() > 0) {
                    obj.put("meeting", meetingArray);
                }
//                farmerArray.put(obj);
                JSONArray inputArray = new JSONArray();
                List<FarmerInputReceivedWrapper> fi = new FarmerInputModel().getFarmerInputs(bd.getFarmID());
                for(FarmerInputReceivedWrapper f :fi)
                {
                    JSONObject inputObj = new JSONObject();
                    inputObj.put("nm",f.getName());
                    inputObj.put("qty",f.getQty());
                    inputObj.put("st", f.getStatus());
                    inputArray.put(inputObj);
                }
                 
                  if (inputArray.length() > 0) {
                    obj.put("input", inputArray);
                }
                
                farmerArray.put(obj);
                
            } catch (Exception e) {
            }

        }
        return farmerArray;

    }

    public static FarmerInputReceivedWrapper searchNeeds(List<FarmerInputReceivedWrapper> farmers, String search) {

        for (FarmerInputReceivedWrapper farmer : farmers) {
            if (farmer.getName().equalsIgnoreCase(search)) {
                return farmer;
            }
        }

        return null;
    }
}
