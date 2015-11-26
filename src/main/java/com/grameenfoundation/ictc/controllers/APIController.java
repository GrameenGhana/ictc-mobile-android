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
import com.grameenfoundation.ictc.domains.FmpPostHarvestBudget;
import com.grameenfoundation.ictc.domains.FmpPostHarvestBudgetUpdate;
import com.grameenfoundation.ictc.domains.FmpProductionBudget;
import com.grameenfoundation.ictc.domains.FmpProductionBudgetUpdate;
import com.grameenfoundation.ictc.domains.MeetingSetting;
import com.grameenfoundation.ictc.domains.PostHarvest2;
import com.grameenfoundation.ictc.domains.PostHarvestUpdate;
import com.grameenfoundation.ictc.domains.ProductionNew;
import com.grameenfoundation.ictc.domains.ProductionUpdate;
import com.grameenfoundation.ictc.domains.Profiling;
import com.grameenfoundation.ictc.domains.TechnicalNeed;
import com.grameenfoundation.ictc.models.BaselinePostHarvestBudgetModel;
import com.grameenfoundation.ictc.models.BaselinePostHarvestModel;
import com.grameenfoundation.ictc.models.BaselineProductionBudgetModel;
import com.grameenfoundation.ictc.models.BaselineProductionModel;
import com.grameenfoundation.ictc.models.BiodataModel;
import com.grameenfoundation.ictc.models.FarmerGPSModel;
import com.grameenfoundation.ictc.models.FarmerInputModel;
import com.grameenfoundation.ictc.models.FieldCropAssessmentModel;
import com.grameenfoundation.ictc.models.FmpPostHarvestBudgetModel;
import com.grameenfoundation.ictc.models.FmpPostHarvestBudgetUpdateModel;
import com.grameenfoundation.ictc.models.FmpProductionBudgetModel;
import com.grameenfoundation.ictc.models.FmpProductionBudgetUpdateModel;
import com.grameenfoundation.ictc.models.MeetingModel;
import com.grameenfoundation.ictc.models.MeetingSettingModel;
import com.grameenfoundation.ictc.models.MobileTrackerModel;
import com.grameenfoundation.ictc.models.PostHarvestModel;
import com.grameenfoundation.ictc.models.PostHarvestUpdateModel;
import com.grameenfoundation.ictc.models.ProductionModel;
import com.grameenfoundation.ictc.models.ProductionUpdateModel;
import com.grameenfoundation.ictc.models.ProfilingModel;
import com.grameenfoundation.ictc.models.TechnicalNeedsModel;
import com.grameenfoundation.ictc.utils.ICTCDBUtil;
import com.grameenfoundation.ictc.wrapper.BiodataWrapper;
import com.grameenfoundation.ictc.wrapper.FarmGPSLocationWrapper;
import com.grameenfoundation.ictc.wrapper.FarmerInputReceivedWrapper;
import com.grameenfoundation.ictc.wrapper.MeetingActivityWrapper;
import com.grameenfoundation.ictc.wrapper.MeetingSettingWrapper;
import com.grameenfoundation.ictc.wrapper.MeetingWrapper;
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
import org.neo4j.graphdb.Transaction;

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

                    if (trackerModel.create(mobileTracker)) {
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

            }else if("fdetails".equalsIgnoreCase(serviceCode))
            {
                 Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx(); 
                 List<BiodataWrapper> bw = new BiodataModel().getBioData("","");
                 System.out.println("Farmer count " + bw.size());
                 BiodataModel biodataModel = new BiodataModel();
                 ProductionModel productionModel = new ProductionModel();
                 PostHarvestModel postHarvestModel = new PostHarvestModel();
                 BaselineProductionModel baselineProductionModel = new BaselineProductionModel();
                 BaselineProductionBudgetModel  baselineProductionBudgetModel = new BaselineProductionBudgetModel();
                 BaselinePostHarvestModel baselinePostHarvestModel = new BaselinePostHarvestModel();
                 BaselinePostHarvestBudgetModel baselinePostHarvestBudgetModel = new BaselinePostHarvestBudgetModel();
                 FmpProductionBudgetModel fmpProductionBudgetModel = new FmpProductionBudgetModel();
                 TechnicalNeedsModel technicalNeedsModel = new TechnicalNeedsModel();
                 ProfilingModel profilingModel = new ProfilingModel();
                 FieldCropAssessmentModel fieldCropAssessmentModel = new FieldCropAssessmentModel();
                 FmpPostHarvestBudgetModel fmpPostHarvestBudgetModel = new FmpPostHarvestBudgetModel();
                 
                 
               
                 
                 JSONArray fa = new JSONArray();
                 
       if (null != bw) {
                                
               for(BiodataWrapper bb :bw)
                {
                    
                    JSONObject production = new JSONObject();
                    JSONObject postHarvest = new JSONObject();
                    JSONObject farmer = new JSONObject();
                    JSONObject details = new JSONObject();
                    JSONObject meetng = new JSONObject();
                    JSONObject baselineproduction = new JSONObject();
                    JSONObject baselineproductionbudget = new JSONObject();
                    JSONObject baselinepostharvest = new JSONObject();
                    JSONObject technicalNeeds = new JSONObject();
                    JSONObject profiling = new JSONObject();
                    JSONObject baselinepostharvestbudget = new JSONObject();
                    JSONObject fmpproductionbudget = new JSONObject();
                    JSONObject fieldcropassessment = new JSONObject();
                    JSONObject fmppostharvestbudget = new JSONObject();
                    
                    
                    
                    
                JSONArray meetingArray = new JSONArray();
                List<MeetingWrapper> meetings = new MeetingModel().findFarmerMeeting(bb.getFarmID());
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
                
                
                  JSONArray inputArray = new JSONArray();
                List<FarmerInputReceivedWrapper> fi = new FarmerInputModel().getFarmerInputs(bb.getFarmID());
                for(FarmerInputReceivedWrapper f :fi)
                {
                    JSONObject inputObj = new JSONObject();
                    inputObj.put("nm",f.getName());
                    inputObj.put("qty",f.getQty());
                    inputObj.put("st", f.getStatus());
                    inputArray.put(inputObj);
                }
                 
                
                     //biodata
                Biodata b = biodataModel.getBiodata("Id", bb.getFarmID());
                
                 if(null!=b)
                {
              
                farmer.put(Biodata.FIRST_NAME,b.getFirstname());
                farmer.put(Biodata.LAST_NAME, b.getLastname());
                farmer.put(Biodata.AGE,b.getAge());
                farmer.put(Biodata.COMMUNITY,b.getCommunity());
                farmer.put(Biodata.GENDER, b.getGender());
                farmer.put(Biodata.EDUCATION,b.getEducation());
                farmer.put(Biodata.FARMERID, b.getId());
                farmer.put(Biodata.FARMERIMAGE ,b.getFarmerimage());
                farmer.put(Biodata.MAJOR_CROP,b.getMajorCrop());
                farmer.put(Biodata.MARITAL_STATUS,b.getMaritalstatus());
                farmer.put(Biodata.NICKNAME, b.getNickname());
                farmer.put(Biodata.NUMBER_OF_CHILDREN,b.getNumberofchildren());
                farmer.put(Biodata.NUMBER_OF_DEPENDANTS,b.getNumberofdependants());
                farmer.put(Biodata.REGION,b.getRegion());
                farmer.put(Biodata.VILLAGE,b.getVillage());
                
                farmer.put(Biodata.FARM_PERIMETER,b.getFarmperimeter());
                             
                if(null!=b.getCluster())
                farmer.put(Biodata.CLUSTER,b.getCluster());
                else
                {
                  farmer.put(Biodata.CLUSTER,"");
                }
                
                if(null!=b.getFarmarea())
                farmer.put(Biodata.FARM_AREA,b.getCluster());
                else
                {
                  farmer.put(Biodata.FARM_AREA,"0");
                }
                
                
                }
                 
                   //Production
                ProductionNew  p =  productionModel.getProduction("Id", bb.getFarmID());
                
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
                    
                  PostHarvest2 ph = postHarvestModel.getPostHarvest("Id", bb.getFarmID());
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
                 
                 BaselineProduction bp = baselineProductionModel.getProduction("Id",bb.getFarmID());
                 
                 if(null!=bp)
                 {
                     baselineproduction.put(BaselineProduction.APPLIC_BASAL_FERT_BASE, bp.getApplic_basal_fert_base());
                     baselineproduction.put(BaselineProduction.APPLIC_POSTPLANT_HERB_DATE_BASE, bp.getApplic_postplant_herb_date_base());
                     baselineproduction.put(BaselineProduction.APPLIC_TOPDRESS_FERT_BASE, bp.getApplic_topdress_fert_base());
                     baselineproduction.put(BaselineProduction.AREA_CULTIVATED_BASE, bp.getArea_cultivated_base());
                     baselineproduction.put(BaselineProduction.CROP_TO_CULTIVATE_BASE, bp.getCrop_to_cultivate_base());
                     baselineproduction.put(BaselineProduction.DATE_FIFTH_MANUAL_WEED_BASE, bp.getDate_fifth_manual_weed_base());
                     baselineproduction.put(BaselineProduction.DATE_FIRST_MANUAL_WEED_BASE, bp.getDate_first_manual_weed_base());
                     baselineproduction.put(BaselineProduction.DATE_FOURTH_MANUAL_WEED_BASE, bp.getDate_fourth_manual_weed_base());
                     baselineproduction.put(BaselineProduction.DATE_OF_HARVEST_BASE,bp.getDate_of_harvest_base());
                     baselineproduction.put(BaselineProduction.DATE_SECOND_MANUAL_WEED_BASE,bp.getDate_second_manual_weed_base());
                     baselineproduction.put(BaselineProduction.DATE_THIRD_MANUAL_WEED_BASE,bp.getDate_third_manual_weed_base());
                     baselineproduction.put(BaselineProduction.DISTANCE_BETWEEN_PLANTS_BASE,bp.getDistance_between_plants_base());
                     baselineproduction.put(BaselineProduction.DISTANCE_BETWEEN_ROWS_BASE,bp.getDistance_between_rows_base());
                     baselineproduction.put(BaselineProduction.LAND_CLEARING_DATE_BASE,bp.getLand_clearing_date_base());
                     baselineproduction.put(BaselineProduction.METHOD_BFERT_APPLIC_BASE,bp.getMethod_bfert_applic_base());
                     baselineproduction.put(BaselineProduction.METHOD_OF_LAND_CLEARING_BASE,bp.getMethod_of_land_clearing_base());
                     baselineproduction.put(BaselineProduction.METHOD_OF_LAND_PREPARATION_BASE,bp.getMethod_of_land_preparation_base());
                     baselineproduction.put(BaselineProduction.METHOD_TOPDRESS_FERT_BASE,bp.getMethod_topdress_fert_base());
                     baselineproduction.put(BaselineProduction.NAME_OF_CROP_VARIETY_CULTIVATED_BASE,bp.getName_of_crop_variety_cultivated_base());
                     baselineproduction.put(BaselineProduction.NAME_OF_OTHER_VARIETY_BASE,bp.getName_of_other_variety_base());
                     baselineproduction.put(BaselineProduction.NAME_OF_VARIETY_CASS_BASE,bp.getName_of_variety_cass_base());
                     baselineproduction.put(BaselineProduction.NAME_OF_VARIETY_RICE_BASE,bp.getName_of_variety_rice_base());
                     baselineproduction.put(BaselineProduction.NAME_OF_VARIETY_YAM,bp.getName_of_variety_yam());
                     baselineproduction.put(BaselineProduction.NO_OCCASIONS_MANUAL_WEED_BASE,bp.getNo_occasions_manual_weed_base());
                     baselineproduction.put(BaselineProduction.OTHER_BASAL_FERT_BASE,bp.getOther_basal_fert_base());
                     baselineproduction.put(BaselineProduction.OTHER_METHOD_BFERT_APPLIC_BASE,bp.getOther_basal_fert_base());
                     baselineproduction.put(BaselineProduction.OTHER_SOURCES_SEED_BASE,bp.getOther_sources_seed_base());
                     baselineproduction.put(BaselineProduction.OTHER_TOPDRESS_FERTILIZER_TYPE_BASE,bp.getOther_topdress_fertilizer_type_base());
                     baselineproduction.put(BaselineProduction.PLANTING_DATE_BASE,bp.getPlanting_date_base());
                     baselineproduction.put(BaselineProduction.PLOUGHING_DATE_BASE,bp.getPloughing_date_base());
                     baselineproduction.put(BaselineProduction.POSTPLANT_HERBICIDE_USE_BASE,bp.getPostplant_herbicide_use_base());
                     baselineproduction.put(BaselineProduction.QTY_OF_BFERT_APPLIED_BASE,bp.getQuantity_postplant_herbicide_base());
                     baselineproduction.put(BaselineProduction.QUANTITY_POSTPLANT_HERBICIDE_BASE,bp.getQuantity_postplant_herbicide_base());
                     baselineproduction.put(BaselineProduction.QUANTITY_TOPDRESS_FERTILIZER_BASE,bp.getQuantity_topdress_fertilizer_base());
                     baselineproduction.put(BaselineProduction.REFILLING_GAPS_OCCURRENCE_BASE,bp.getRefilling_gaps_occurrence_base());
                     baselineproduction.put(BaselineProduction.REFILLING_PROPORTION_BASE,bp.getRefilling_proportion_base());
                     baselineproduction.put(BaselineProduction.SEEDBED_TYPE_BASE,bp.getSeed_bed_preparation_date_base());
                     baselineproduction.put(BaselineProduction.SEED_BED_PREPARATION_DATE_BASE,bp.getSeed_bed_preparation_date_base());
                     baselineproduction.put(BaselineProduction.SOURCE_OF_SEED_BASE,bp.getSource_of_seed_base());
                     baselineproduction.put(BaselineProduction.TARGETED_YIELD_BASE,bp.getTargeted_yield_base());
                     baselineproduction.put(BaselineProduction.TIME_BASAL_FERT_APPL_BASE,bp.getTime_basal_fert_appl_base());
                     baselineproduction.put(BaselineProduction.TIME_TOPDRESS_APPL_BASE,bp.getTime_topdress_appl_base());
                     baselineproduction.put(BaselineProduction.TYPE_BASAL_FERT_BASE,bp.getType_basal_fert_base());
                     baselineproduction.put(BaselineProduction.TYPE_FERTILIZER_TOPDRESS_BASE,bp.getType_fertilizer_topdress_base());
                     baselineproduction.put(BaselineProduction.TYPE_OF_HERBICIDE_POSTPLANT_BASE,bp.getType_of_herbicide_postplant_base());
                     baselineproduction.put(BaselineProduction.TYPE_OF_VARIETY_CULTIVATED_BASE,bp.getType_of_variety_cultivated_base());
                     
                     
                     
                     
                 }
                 
                 
                 BaselineProductionBudget bpb =  baselineProductionBudgetModel.getBaselineProductionBudget("Id",bb.getFarmID());
                 
                 
                 if(bpb!=null)
                 {
                     System.out.println("budget " + bpb.getBasal_fert_labor_period_base());
                     baselineproductionbudget.put(BaselineProductionBudget.BASAL_FERTILIZER_APPL_LAB_BASE, bpb.getBasal_fertilizer_appl_lab_base());
                     baselineproductionbudget.put(BaselineProductionBudget.BASAL_FERT_LABOR_PERIOD_BASE, bpb.getBasal_fert_labor_period_base());
                     baselineproductionbudget.put(BaselineProductionBudget.COST_OF_APPLICATIONTOPDRESS_BASE, bpb.getCost_of_applicationtopdress_base());
                     baselineproductionbudget.put(BaselineProductionBudget.FAMILY_LABOR_BASAL_FERT_BASE,bpb.getFamily_labor_basal_fert_base());
                     baselineproductionbudget.put(BaselineProductionBudget.FAMILY_LABOR_FIFTH_WEED_CONTROL_BASE,bpb.getFamily_labor_fifth_weed_control_base());
                     baselineproductionbudget.put(BaselineProductionBudget.FAMILY_LABOR_FIRST_MANUAL_WEED_BASE,bpb.getFamily_labor_first_manual_weed_base());
                     baselineproductionbudget.put(BaselineProductionBudget.FAMILY_LABOR_THIRD_WEED_BASE,bpb.getFamily_labor_third_weed_base());
                     baselineproductionbudget.put(BaselineProductionBudget.FAMILY_LABOR_SECOND_WEED_BASE,bpb.getFamily_labor_second_weed_base());
                     baselineproductionbudget.put(BaselineProductionBudget.FAMILY_LABOR_TOPDRESS_BASE,bpb.getFamily_labor_topdress_base());
                     baselineproductionbudget.put(BaselineProductionBudget.FERTILIZER_APP_LABOUR_COST_BASE,bpb.getFertilizer_app_labour_cost_base());
                     baselineproductionbudget.put(BaselineProductionBudget.FIFTH_WEEDING_LABOR_PERIOD_BASE,bpb.getFifth_weeding_labor_period_base());
                     baselineproductionbudget.put(BaselineProductionBudget.FINAL_HARVEST_FAMILY_LABOR_BASE,bpb.getFinal_harvest_family_labor_base());
                     baselineproductionbudget.put(BaselineProductionBudget.FINAL_HARVEST_LABOR_NO_BASE,bpb.getFinal_harvest_labor_no_base());
                     baselineproductionbudget.put(BaselineProductionBudget.FIRST_WEEDING_PERIOD_BASE,bpb.getFirst_weeding_period_base());
                     baselineproductionbudget.put(BaselineProductionBudget.FOURTH_WEEDING_LABOR_PERIOD_BASE,bpb.getFourth_weeding_labor_period_base());
                     baselineproductionbudget.put(BaselineProductionBudget.FOURTH_WEEDING_FAMILY_LAB,bpb.getFourth_weeding_family_lab());
                     baselineproductionbudget.put(BaselineProductionBudget.HARROWING_COST_PER_ACRE_BASE,bpb.getHarrowing_cost_per_acre_base());
                     baselineproductionbudget.put(BaselineProductionBudget.HARVEST_LABOR_COSTS_PER_ACRE_BASE,bpb.getHarvest_labor_costs_per_acre_base());
                     baselineproductionbudget.put(BaselineProductionBudget.HERBICIDE_APPLICATION_COST_BASE,bpb.getHerbicide_application_cost_base());
                     baselineproductionbudget.put(BaselineProductionBudget.HERBICIDE_APP_LABOR_PERIOD_BASE,bpb.getHerbicide_app_labor_period_base());
                     baselineproductionbudget.put(BaselineProductionBudget.HOE_PLOUGHING_LABOUR_FAMILY_BASE,bpb.getHoe_ploughing_labour_family_base());
                     baselineproductionbudget.put(BaselineProductionBudget.HOE_PLOUGHING_LABOUR_HOW_MANY_BASE,bpb.getHoe_ploughing_labour_how_many_base());
                     baselineproductionbudget.put(BaselineProductionBudget.HOE_PLOUGHING_LABOUR_PERIOD_BASE,bpb.getHoe_ploughing_labour_period_base());
                     baselineproductionbudget.put(BaselineProductionBudget.LABOR_FIFTH_WEED_CONTROL_BASE ,bpb.getLabor_fifth_weed_control_base());
                     baselineproductionbudget.put(BaselineProductionBudget.LABOR_FOR_PLANTINGFAMILY_BASE, bpb.getLabor_for_plantingfamily_base());
                     baselineproductionbudget.put(BaselineProductionBudget.LABOR_FOR_PLANTING_NUMBER_BASE  ,bpb.getLabor_for_planting_number_base());                      
                     baselineproductionbudget.put(BaselineProductionBudget.LABOR_FOURTH_WEED_CONTROL_BASE, bpb.getLabor_fourth_weed_control_base());
                     baselineproductionbudget.put(BaselineProductionBudget.LABOR_NO_FIRST_MANUAL_WEED_BASE, bpb.getLabor_no_first_manual_weed_base());
                     baselineproductionbudget.put(BaselineProductionBudget.LABOR_FOR_PLANTINGFAMILY_BASE, bpb.getLabor_for_plantingfamily_base());
                     baselineproductionbudget.put(BaselineProductionBudget.LABOR_THIRD_WEED_CONTROL_BASE, bpb.getLabor_third_weed_control_base());
                     baselineproductionbudget.put(BaselineProductionBudget.LAND_RENT_BASE, bpb.getLand_rent_base());
                     baselineproductionbudget.put(BaselineProductionBudget.LABOR_FOR_PLANTINGFAMILY_BASE, bpb.getLabor_for_plantingfamily_base());
                     baselineproductionbudget.put(BaselineProductionBudget.PERIOD_FOR_COMPLETION_OF_HARVEST_BASE, bpb.getPeriod_for_completion_of_harvest_base());
                     baselineproductionbudget.put(BaselineProductionBudget.PLANTING_PERIOD2_BASE, bpb.getPlanting_period2_base());
                     baselineproductionbudget.put(BaselineProductionBudget.PLOUGHING_COST_PER_ACRE_BASE, bpb.getPloughing_cost_per_acre_base());
                     baselineproductionbudget.put(BaselineProductionBudget.POST_HERBICIDE_APPLICATION_COST_BASE, bpb.getPost_herbicide_application_cost_base());
                     baselineproductionbudget.put(BaselineProductionBudget.POST_PLANT_HERBICIDE_COST_BASE, bpb.getPost_plant_herbicide_cost_base());
                     baselineproductionbudget.put(BaselineProductionBudget.PRICE_OF_BASAL_FERTILIZER_BASE, bpb.getPrice_of_basal_fertilizer_base());
                     baselineproductionbudget.put(BaselineProductionBudget.PRICE_OF_HERBICIDE_BASE, bpb.getPrice_of_herbicide_base());
                     baselineproductionbudget.put(BaselineProductionBudget.PRICE_OF_TOPDRESS_FERTILIZER_BASE, bpb.getPrice_of_topdress_fertilizer_base());
                     baselineproductionbudget.put(BaselineProductionBudget.QUANTITY_OF_PREPLANT_HERBICIDE_BASE, bpb.getQuantity_of_preplant_herbicide_base());
                     baselineproductionbudget.put(BaselineProductionBudget.REFILLING_LABOR_FAMILY_BASE, bpb.getRefilling_labor_family_base());
                     baselineproductionbudget.put(BaselineProductionBudget.REFILLING_LABOR_PERIOD_BASE, bpb.getRefilling_labor_period_base());
                     baselineproductionbudget.put(BaselineProductionBudget.REFILLING_LABOUR_COST_BASE, bpb.getRefilling_labour_cost_base());
                     baselineproductionbudget.put(BaselineProductionBudget.REFILLING_LABOUR_NO_BASE, bpb.getRefilling_labour_no_base());
                     baselineproductionbudget.put(BaselineProductionBudget.SECOND_WEED_LABOR_BASE, bpb.getSecond_weed_labor_base());
                     baselineproductionbudget.put(BaselineProductionBudget.SECOND_WEED_PERIOD_BASE, bpb.getSecond_weed_period_base());
                     baselineproductionbudget.put(BaselineProductionBudget.SEEDBED_LABOR_COST_BASE, bpb.getSeedbed_labor_cost_base());
                     baselineproductionbudget.put(BaselineProductionBudget.SEEDBED_LABOR_NUMBER_BASE, bpb.getSeedbed_labor_number_base());
                     baselineproductionbudget.put(BaselineProductionBudget.SEEDBED_LABOUR_FAMILY_BASE, bpb.getSeedbed_labour_family_base());
                     baselineproductionbudget.put(BaselineProductionBudget.SEEDPLANTING_MATERIAL_COST_BASE, bpb.getSeedplanting_material_cost_base());
                     baselineproductionbudget.put(BaselineProductionBudget.SEED_BED_PREPARATION_PERIOD_BASE, bpb.getSeed_bed_preparation_period_base());
                     baselineproductionbudget.put(BaselineProductionBudget.THIRD_WEEDING_PERIOD_BASE, bpb.getThird_weeding_period_base());
                     baselineproductionbudget.put(BaselineProductionBudget.TOPDRESS_FERT_LABOR_PERIOD_BASE, bpb.getTopdress_fert_labor_period_base());
                     baselineproductionbudget.put(BaselineProductionBudget.TOTAL_COST_FIFTH_WEED_BASE, bpb.getTotal_cost_fifth_weed_base());
                     baselineproductionbudget.put(BaselineProductionBudget.TOTAL_COST_FIRST_MANUAL_WEED_BASE, bpb.getTotal_cost_first_manual_weed_base());
                     baselineproductionbudget.put(BaselineProductionBudget.TOTAL_COST_SECOND_WEED_BASE, bpb.getTotal_cost_second_weed_base());
                     baselineproductionbudget.put(BaselineProductionBudget.TOTAL_COST_THIRD_WEED_BASE, bpb.getTotal_cost_third_weed_base());
                     baselineproductionbudget.put(BaselineProductionBudget.TOTAL_NUMBER_OF_LABOR_TOPDRESS_BASE, bpb.getTotal_number_of_labor_topdress_base());
                     baselineproductionbudget.put(BaselineProductionBudget.UNIT_COST_HOE_PLOUGHING_BASE, bpb.getUnit_cost_hoe_ploughing_base());
                     
                     System.out.println("After Json : BaseProduction");
                     
                     
                     
                 }else{
                     System.out.println("BaseProduction Budge");
                 }
                 
                 
                 BaselinePostHarvest bph = baselinePostHarvestModel.getBaselinePostHarvest("Id",bb.getFarmID());
                 
                 if(null!=bph)
                 {
                   baselinepostharvest.put(BaselinePostHarvest.APPLICATIONRATEOFSTORAGECHEMICAL,bph.getApplicationrateofstoragechemical());
                   baselinepostharvest.put(BaselinePostHarvest.COMPLETIONOFPRODUCEMARKETING,bph.getCompletionofproducemarketing());
                   baselinepostharvest.put(BaselinePostHarvest.COMPLETIONOFTHRESHING,bph.getCompletionofthreshing());
                   baselinepostharvest.put(BaselinePostHarvest.DATEOFCOMPLETINGDRYING,bph.getDateofcompletingdrying());
                   baselinepostharvest.put(BaselinePostHarvest.DATETOCOMPLETEDRYING,bph.getDatetocompletedrying());
                   baselinepostharvest.put(BaselinePostHarvest.DEHUSKINGDATE,bph.getDehuskingdate());
                   baselinepostharvest.put(BaselinePostHarvest.FIRSTSALEDATE,bph.getFirstsaledate());
                   baselinepostharvest.put(BaselinePostHarvest.MAINPOINTOFSALEORCONTACT,bph.getMainpointofsaleorcontact());
                   baselinepostharvest.put(BaselinePostHarvest.MANUALTHRESHING,bph.getManualthreshing());
                   baselinepostharvest.put(BaselinePostHarvest.MANUALWINNOWING,bph.getManualwinnowing());
                   baselinepostharvest.put(BaselinePostHarvest.MARKETINGOCCASIONS,bph.getMarketingoccasions());
                   baselinepostharvest.put(BaselinePostHarvest.METHODOFDRYINGCOBSPANICLESCHIPSCHU,bph.getMethodofdryingcobspanicleschipschu());
                   baselinepostharvest.put(BaselinePostHarvest.METHODOFDRYINGGRAIN,bph.getMethodofdryinggrain());
                   baselinepostharvest.put(BaselinePostHarvest.METHODOFPROCESSINGDEHUSKING,bph.getMethodofprocessingdehusking());
                   baselinepostharvest.put(BaselinePostHarvest.METHODOFTHRESHING,bph.getMethodofthreshing());
                   baselinepostharvest.put(BaselinePostHarvest.METHODOFWINNOWING,bph.getMethodofwinnowing());
                   baselinepostharvest.put(BaselinePostHarvest.MOSTPRODUCESALEDATE,bph.getMostproducesaledate());
                   baselinepostharvest.put(BaselinePostHarvest.OTHERAPPLICATIONRATEOFSTORAGECHEMICA,bph.getOtherapplicationrateofstoragechemica());
                   baselinepostharvest.put(BaselinePostHarvest.OTHERMETHODFORDRYING,bph.getOthermethodfordrying());
                   baselinepostharvest.put(BaselinePostHarvest.OTHERMETHODOFDRYINGGRAIN,bph.getOthermethodofdryinggrain());
                   baselinepostharvest.put(BaselinePostHarvest.OTHERMETHODSOFDEHUSKING,bph.getOthermethodsofdehusking());
                   baselinepostharvest.put(BaselinePostHarvest.OTHERSALECONTACT,bph.getOthersalecontact());
                   baselinepostharvest.put(BaselinePostHarvest.OTHERSTORAGECHEMICAL,bph.getOtherstoragechemical());
                   baselinepostharvest.put(BaselinePostHarvest.OWNERSHIPORCONDITIONSFORSTORAGE,bph.getOwnershiporconditionsforstorage());
                   baselinepostharvest.put(BaselinePostHarvest.POSTHARVESTLOSSES,bph.getPostharvestlosses());
                   baselinepostharvest.put(BaselinePostHarvest.PRICEATFIRSTSALEDATE,bph.getPriceatfirstsaledate());
                   baselinepostharvest.put(BaselinePostHarvest.PRICEATMOSTSALEDATE,bph.getPriceatmostsaledate());
                   baselinepostharvest.put(BaselinePostHarvest.PROCESSINGOFCASSAVA,bph.getProcessingofcassava());
                   baselinepostharvest.put(BaselinePostHarvest.PROPORTIONOFCASSAVA,bph.getProportionofcassava());
                   baselinepostharvest.put(BaselinePostHarvest.PROPORTIONOFPRODUCESOLD,bph.getProportionofproducesold());
                   baselinepostharvest.put(BaselinePostHarvest.TYPEOFBAGCONTAINERUSED,bph.getTypeofbagcontainerused());
                   baselinepostharvest.put(BaselinePostHarvest.TYPEOFMACHINE,bph.getTypeofmachine());
                   baselinepostharvest.put(BaselinePostHarvest.TYPEOFMACHINEWINONOWING,bph.getTypeofmachinewinonowing());
                   baselinepostharvest.put(BaselinePostHarvest.TYPEOFSTORAGECHEMICAL,bph.getTypeofstoragechemical());
                   baselinepostharvest.put(BaselinePostHarvest.TYPEOFSTORAGESTRUCTURE,bph.getTypeofstoragestructure());
                   baselinepostharvest.put(BaselinePostHarvest.WHATCROPAREYOUPLANNINGTOCULTIVATE,bph.getWhatcropareyouplanningtocultivate());
                   
           
                   
                 }
                 
                  TechnicalNeed techNeed = technicalNeedsModel.getTechnicalNeed("Id", bb.getFarmID());
                    
                 if(null!=techNeed)
                 {
                     technicalNeeds.put(TechnicalNeed.CROPESTABLISHMENT,techNeed.getCropEstablishment());
                     technicalNeeds.put(TechnicalNeed.CROPVARIETYANDSEED,techNeed.getCropVarietyAndSeed());
                     technicalNeeds.put(TechnicalNeed.CROPVARIETYANDSEEDCASSAVA,techNeed.getCropvarietyandseedcassava());
                     technicalNeeds.put(TechnicalNeed.CROVARIETYANDSEEDSYAM,techNeed.getCrovarietyandseedsyam());
                     technicalNeeds.put(TechnicalNeed.FARMPLANNING,techNeed.getFarmPlanning());
                     technicalNeeds.put(TechnicalNeed.HARVESTANDPOSTHARVEST,techNeed.getHarvestAndPostHarvest());
                     technicalNeeds.put(TechnicalNeed.INTEGRATEDSOILFERTILITYMANAGEMENT,techNeed.getIntegratedSoilFertilityManagement());
                     technicalNeeds.put(TechnicalNeed.WEEDCONTROL,techNeed.getWeedControl());     
                 }
                 
                 Profiling pr = profilingModel.getProfile("Id", bb.getFarmID());
                 
                 if(null!=pr)
                 {
                     profiling.put(Profiling.FARMRECORDKEEPINGSTATUS,pr.getFarmrecordkeepingstatus());
                     profiling.put(Profiling.FBOMEMBERSHIP,pr.getFbomembership());
                     profiling.put(Profiling.FBONAME,pr.getFboname());
                     profiling.put(Profiling.INNOVATIVENESSBYTRYING,pr.getInnovativenessbytrying());
                     profiling.put(Profiling.NAMETRUSTEDMENTOR,pr.getNametrustedmentor());
                     profiling.put(Profiling.OPERATEBANKACCOUNT,pr.getOperatebankaccount());
                     profiling.put(Profiling.POSTHARVESTLOSSES,pr.getPostharvestlosses());
                     profiling.put(Profiling.PRODUCESOLDPROPORTION,pr.getProducesoldproportion());
                     profiling.put(Profiling.REGFAMILYLABOR_NO,pr.getRegfamilylabor_No());
                     profiling.put(Profiling.RISKDISPOSITIONBORROW,pr.getRiskdispositionborrow());
                     profiling.put(Profiling.SOILFERTILITYPRACTICES,pr.getSoilfertilitypractices());
                 }
                 
                 BaselinePostHarvestBudget bphb = baselinePostHarvestBudgetModel.getBaselinePostHarvestBudget("Id",bb.getFarmID());
                   
                 if(null!=bphb)
                 {
                     baselinepostharvestbudget.put(BaselinePostHarvestBudget.BAGS_FOR_STORAGE_BASE,bphb.getBags_for_storage_base());
                     baselinepostharvestbudget.put(BaselinePostHarvestBudget.COST_OF_STORAGE_CHEMICAL_BASE,bphb.getCost_of_storage_chemical_base());
                     baselinepostharvestbudget.put(BaselinePostHarvestBudget.DEHUSKINGPEELING_FAMILY_LABOR_BASE,bphb.getDehuskingpeeling_family_labor_base());
                     baselinepostharvestbudget.put(BaselinePostHarvestBudget.DEHUSKINGPEELING_LABOR_BASE,bphb.getDehuskingpeeling_family_labor_base());
                     baselinepostharvestbudget.put(BaselinePostHarvestBudget.DEHUSKINGPEELING_LABOR_BASE,bphb.getDehuskingpeeling_labor_base());
                     baselinepostharvestbudget.put(BaselinePostHarvestBudget.FAMILY_LABOR_BAGGING_BASE,bphb.getFamily_labor_bagging_base());
                     baselinepostharvestbudget.put(BaselinePostHarvestBudget.FAMILY_LABOR_DRYING_COBS_BASE,bphb.getFamily_labor_drying_cobs_base());
                     baselinepostharvestbudget.put(BaselinePostHarvestBudget.FAMILY_LABOR_DRYING_GRAIN_BASE,bphb.getFamily_labor_drying_grain_base());
                     baselinepostharvestbudget.put(BaselinePostHarvestBudget.FAMILY_LABOR_ENGAGED_WINNOWING_BASE,bphb.getFamily_labor_engaged_winnowing_base());
                     baselinepostharvestbudget.put(BaselinePostHarvestBudget.FAMILY_LABOR_MANUAL_THRESHING_BASE,bphb.getFamily_labor_manual_threshing_base());
                     baselinepostharvestbudget.put(BaselinePostHarvestBudget.GRAIN_DRYING_COST_BASE,bphb.getGrain_drying_cost_base());
                     baselinepostharvestbudget.put(BaselinePostHarvestBudget.LABOR_COST_DEHUSKINGPEELING_BASE,bphb.getLabor_cost_dehuskingpeeling_base());
                     baselinepostharvestbudget.put(BaselinePostHarvestBudget.LABOR_COST_DRYING_OF_COBS_BASE,bphb.getLabor_cost_drying_of_cobs_base());
                     baselinepostharvestbudget.put(BaselinePostHarvestBudget.LABOR_HANDS_DRYINGCOBS_BASE,bphb.getLabor_hands_dryingcobs_base());
                     baselinepostharvestbudget.put(BaselinePostHarvestBudget.LABOR_MANUAL_THRESHING_BASE,bphb.getLabor_manual_threshing_base());
                     baselinepostharvestbudget.put(BaselinePostHarvestBudget.LABOR_PERIOD_DRYING_COBS_BASE,bphb.getLabor_period_drying_cobs_base());
                     baselinepostharvestbudget.put(BaselinePostHarvestBudget.LABOR_PERIOD_MANUAL_THRESHING_BASE,bphb.getLabor_period_manual_threshing_base());
                     baselinepostharvestbudget.put(BaselinePostHarvestBudget.LABOUR_FOR_BAGGING_BASE,bphb.getFamily_labor_bagging_base());
                     baselinepostharvestbudget.put(BaselinePostHarvestBudget.LABOUR_WINNOWING_BASE,bphb.getLabour_winnowing_base());
                     baselinepostharvestbudget.put(BaselinePostHarvestBudget.PERIOD_TO_COMPLETE_DEHUSKING_BASE,bphb.getPeriod_to_complete_dehusking_base());
                     baselinepostharvestbudget.put(BaselinePostHarvestBudget.TIME_COMPLETION_OF_BAGGING_BASE,bphb.getTime_completion_of_bagging_base());
                     baselinepostharvestbudget.put(BaselinePostHarvestBudget.TIME_INTERVAL_WINNOWING_BASE,bphb.getTime_interval_winnowing_base());
                     baselinepostharvestbudget.put(BaselinePostHarvestBudget.UNIT_COST_MACHINE_THRESHING_BASE,bphb.getUnit_cost_machine_threshing_base());
                     baselinepostharvestbudget.put(BaselinePostHarvestBudget.UNIT_COST_MANUAL_THRESHING_BASE,bphb.getUnit_cost_manual_threshing_base());
                     baselinepostharvestbudget.put(BaselinePostHarvestBudget.UNIT_COST_OF_STORAGE_BAGS_BASE,bphb.getUnit_cost_of_storage_bags_base());
                     baselinepostharvestbudget.put(BaselinePostHarvestBudget.UNIT_COST_OF_WAREHOUSE_BASE,bphb.getUnit_cost_of_warehouse_base());
                     baselinepostharvestbudget.put(BaselinePostHarvestBudget.UNIT_LABOR_COST_BAGGING_BASE,bphb.getUnit_labor_cost_bagging_base());
                     
                     
                 }
                 
                 FmpProductionBudget fmppb = fmpProductionBudgetModel.getFmpProductionBudget("Id",bb.getFarmID());
                 
                 if(fmppb!=null)
                 {
                     fmpproductionbudget.put(FmpProductionBudget.BASAL_FERTILIZER_APPLICATION_TOTAL_LABOU,fmppb.getBasal_fert_labor_period());
                     fmpproductionbudget.put(FmpProductionBudget.BASAL_FERTILIZER_APPL_LABOUR_COST,fmppb.getBasal_fertilizer_appl_labour_cost());
                     fmpproductionbudget.put(FmpProductionBudget.BASAL_FERT_LABOR_PERIOD,fmppb.getBasal_fert_labor_period());
                     fmpproductionbudget.put(FmpProductionBudget.COST_OF_APPLICATIONTOPDRESS,fmppb.getCost_of_applicationtopdress());
                     fmpproductionbudget.put(FmpProductionBudget.FAMILY_LABOR_BASAL_FERTILIZER_APPLICATIO,fmppb.getFamily_labor_basal_fertilizer_applicatio());
                     fmpproductionbudget.put(FmpProductionBudget.FAMILY_LABOR_FIFTH_WEED_CONTROL,fmppb.getFamily_labor_fifth_weed_control());
                     fmpproductionbudget.put(FmpProductionBudget.FAMILY_LABOR_FIRST_MANUAL_WEED_CONTROL,fmppb.getFamily_labor_first_manual_weed_control());
                     fmpproductionbudget.put(FmpProductionBudget.FAMILY_LABOR_FOURTH_WEEDING,fmppb.getFamily_labor_fourth_weeding());
                     fmpproductionbudget.put(FmpProductionBudget.FAMILY_LABOR_SECOND_MANUAL_WEED_CONTROL,fmppb.getFamily_labor_second_manual_weed_control());
                     fmpproductionbudget.put(FmpProductionBudget.FAMILY_LABOR_THIRD_WEED_CONTROL,fmppb.getFamily_labor_third_weed_control());
                     fmpproductionbudget.put(FmpProductionBudget.FAMILY_LABOR_TOPDRESS_FERTILIZER_APPLICA,fmppb.getFamily_labor_topdress_fertilizer_applica());
                     fmpproductionbudget.put(FmpProductionBudget.FIFTH_MANUAL_WEEDING_LABOR_PERIOD,fmppb.getFifth_manual_weeding_labor_period());
                     fmpproductionbudget.put(FmpProductionBudget.FINAL_HARVEST_FAMILY_LABOR,fmppb.getFinal_harvest_family_labor());
                     fmpproductionbudget.put(FmpProductionBudget.FINAL_HARVEST_LABOR_HOW_MANY_LABOR_HANDS,fmppb.getFinal_harvest_labor_how_many_labor_hands());
                     fmpproductionbudget.put(FmpProductionBudget.FIRST_MANUAL_WEEDING_LABOR_PERIOD,fmppb.getFirst_manual_weeding_labor_period());
                     fmpproductionbudget.put(FmpProductionBudget.FOURTH_MANUAL_WEEDING_LABOR_PERIOD,fmppb.getFourth_manual_weeding_labor_period());
                     fmpproductionbudget.put(FmpProductionBudget.HARROWING_COST_PER_ACRE,fmppb.getHarrowing_cost_per_acre());
                     fmpproductionbudget.put(FmpProductionBudget.HARVEST_LABOR_COSTSPER_ACRE,fmppb.getHarvest_labor_costsper_acre());
                     fmpproductionbudget.put(FmpProductionBudget.HERBICIDE_APPLICATION_COST,fmppb.getHerbicide_application_cost());
                     fmpproductionbudget.put(FmpProductionBudget.HERBICIDE_APPLICATION_COST_POST_PLANT,fmppb.getHerbicide_application_cost_post_plant());
                     fmpproductionbudget.put(FmpProductionBudget.HERBICIDE_APPLICATION_LABOR_PERIOD_HOW_L,fmppb.getHerbicide_application_labor_period_how_l());
                     fmpproductionbudget.put(FmpProductionBudget.HOE_PLOUGHING_LABOUR_FAMILY_HOW_MANY_FAM,fmppb.getHoe_ploughing_labour_family_how_many_fam());
                     fmpproductionbudget.put(FmpProductionBudget.HOE_PLOUGHING_LABOUR_HOW_MANY_PEOPLE,fmppb.getHoe_ploughing_labour_how_many_people());
                     fmpproductionbudget.put(FmpProductionBudget.HOE_PLOUGHING_LABOUR_PERIOD,fmppb.getHoe_ploughing_labour_period());
                     fmpproductionbudget.put(FmpProductionBudget.LABOR_FIFTH_WEED_CONTROL,fmppb.getLabor_fifth_weed_control());
                     fmpproductionbudget.put(FmpProductionBudget.LABOR_FOR_PLANTINGFAMILY,fmppb.getLabor_for_plantingfamily());
                     fmpproductionbudget.put(FmpProductionBudget.LABOR_FOR_PLANTING_NUMBER,fmppb.getLabor_for_planting_number());
                     fmpproductionbudget.put(FmpProductionBudget.LABOR_FOURTH_WEED_CONTROL,fmppb.getLabor_fourth_weed_control());
                     fmpproductionbudget.put(FmpProductionBudget.LABOR_THIRD_WEED_CONTROL,fmppb.getLabor_third_weed_control());
                     fmpproductionbudget.put(FmpProductionBudget.LAND_RENT,fmppb.getLand_rent());
                     fmpproductionbudget.put(FmpProductionBudget.PERIOD_FOR_COMPLETION_OF_HARVEST,fmppb.getPeriod_for_completion_of_harvest());
                     fmpproductionbudget.put(FmpProductionBudget.PLANTING_LABOR_COST,fmppb.getPlanting_labor_cost());
                     fmpproductionbudget.put(FmpProductionBudget.PLANTING_PERIOD2,fmppb.getPlanting_period2());
                     fmpproductionbudget.put(FmpProductionBudget.PLOUGHING_COST_PER_ACRE,fmppb.getPloughing_cost_per_acre());
                     fmpproductionbudget.put(FmpProductionBudget.POST_PLANT_HERBICIDE_COST,fmppb.getPost_plant_herbicide_cost());
                     fmpproductionbudget.put(FmpProductionBudget.PRICE_OF_BASAL_FERTILIZER,fmppb.getPrice_of_basal_fertilizer());
                     fmpproductionbudget.put(FmpProductionBudget.PRICE_OF_HERBICIDE_GHC,fmppb.getPrice_of_herbicide_ghc());
                     fmpproductionbudget.put(FmpProductionBudget.PRICE_OF_TOPDRESS_FERTILIZER,fmppb.getPrice_of_topdress_fertilizer());
                     fmpproductionbudget.put(FmpProductionBudget.QUANTITY_OF_PREPLANT_HERBICIDE_LITERS,fmppb.getQuantity_of_preplant_herbicide_liters());
                     fmpproductionbudget.put(FmpProductionBudget.REFILLING_LABOR_PERIOD,fmppb.getRefilling_labor_period());
                     fmpproductionbudget.put(FmpProductionBudget.REFILLING_LABOUR_COST,fmppb.getRefilling_labour_cost());
                     fmpproductionbudget.put(FmpProductionBudget.REFILLING_LABOUR_NO,fmppb.getRefilling_labour_no());
                     fmpproductionbudget.put(FmpProductionBudget.SECOND_MANUAL_WEEDING_LABOR_PERIOD,fmppb.getSecond_manual_weeding_labor_period());
                     fmpproductionbudget.put(FmpProductionBudget.SECOND_WEED_CONTROL_LABOR,fmppb.getSecond_weed_control_labor());
                     fmpproductionbudget.put(FmpProductionBudget.SEEDBED_LABOR_COST,fmppb.getSeedbed_labor_cost());
                     fmpproductionbudget.put(FmpProductionBudget.SEEDBED_LABOR_NUMBER,fmppb.getSeedbed_labor_number());
                     fmpproductionbudget.put(FmpProductionBudget.SEEDBED_LABOUR_FAMILY,fmppb.getSeedbed_labour_family());
                     fmpproductionbudget.put(FmpProductionBudget.SEEDPLANTING_MATERIAL_COST,fmppb.getSeedplanting_material_cost());
                     fmpproductionbudget.put(FmpProductionBudget.SEEDPLANTING_MATERIAL_COST,fmppb.getSeedplanting_material_cost());
                     fmpproductionbudget.put(FmpProductionBudget.SEED_BED_PREPARATION_PERIOD,fmppb.getSeed_bed_preparation_period());
                     fmpproductionbudget.put(FmpProductionBudget.TOPDRESS_FERT_LABOR_PERIOD,fmppb.getTopdress_fert_labor_period());
                     fmpproductionbudget.put(FmpProductionBudget.TOTAL_COST_OF_LABOR_FIFTH_MANUAL_WEED,fmppb.getTotal_cost_of_labor_fifth_manual_weed());
                     fmpproductionbudget.put(FmpProductionBudget.TOTAL_COST_OF_LABOR_FIRST_MANUAL_WEED,fmppb.getTotal_cost_of_labor_fifth_manual_weed());
                     fmpproductionbudget.put(FmpProductionBudget.TOTAL_COST_OF_LABOR_FOURTH_MANUAL_WEED,fmppb.getTotal_cost_of_labor_fourth_manual_weed());
                     fmpproductionbudget.put(FmpProductionBudget.TOTAL_COST_OF_LABOR_SECOND_MANUAL_WEED,fmppb.getTotal_cost_of_labor_second_manual_weed());
                     fmpproductionbudget.put(FmpProductionBudget.TOTAL_COST_OF_LABOR_THIRD_MANUAL_WEED_CO,fmppb.getTotal_cost_of_labor_third_manual_weed_co());
                     fmpproductionbudget.put(FmpProductionBudget.TOTAL_NUMBER_OF_LABOR_TOPDRESS,fmppb.getTotal_number_of_labor_topdress());
                     fmpproductionbudget.put(FmpProductionBudget.UNIT_COST_HOE_PLOUGHING,fmppb.getUnit_cost_hoe_ploughing());
                         
                 }
                 
                 
                 FieldCropAssessment fca = fieldCropAssessmentModel.getFieldCropAssessment("Id",bb.getFarmID());
                 
                 if(null!=fca)
                 {
                     fieldcropassessment.put(FieldCropAssessment.CROP_ESTABLISHMENT_SCORE, fca.getCrop_establishment_score());
                     fieldcropassessment.put(FieldCropAssessment.DISEASE_MANAGEMENT_SCORES, fca.getDisease_management_scores());
                     fieldcropassessment.put(FieldCropAssessment.GPS_LOCATION, fca.getGPS_Location());
                     fieldcropassessment.put(FieldCropAssessment.PEST_MANAGEMENT_SCORE, fca.getPest_management_score());
                     fieldcropassessment.put(FieldCropAssessment.PHOTO_CROP_ESTABLISHMENT_STATUS, fca.getCrop_establishment_score());
                     fieldcropassessment.put(FieldCropAssessment.PHOTO_DISEASE_MANGEMENT_STATUS, fca.getPhoto_disease_mangement_status());
                     fieldcropassessment.put(FieldCropAssessment.PHOTO_PEST_MANAGEMENT_STATUS, fca.getPhoto_pest_management_status());
                     fieldcropassessment.put(FieldCropAssessment.PHOTO_SOIL_FERTILITY_STATUS, fca.getPhoto_soil_fertility_status());
                     fieldcropassessment.put(FieldCropAssessment.PHOTO_WEED_MANAGEMENT_STATUS, fca.getPhoto_weed_management_status());
                     fieldcropassessment.put(FieldCropAssessment.SOIL_FERTILITY_SCORE, fca.getSoil_fertility_score());
                     fieldcropassessment.put(FieldCropAssessment.WEED_MANAGEMENT_SCORE_, fca.getWeed_management_score_());
                     
                     
                 }
                 
                 FmpPostHarvestBudget fmpphb = fmpPostHarvestBudgetModel.getFmpPostHarvestBudget("Id",bb.getFarmID());
                 
                 
                 if(null!=fmpphb)
                 {
                     fmppostharvestbudget.put(FmpPostHarvestBudget.BAGS_FOR_STORAGE_, fmpphb.getBags_for_storage_());
                     fmppostharvestbudget.put(FmpPostHarvestBudget.COST_OF_STORAGE_CHEMICAL, fmpphb.getCost_of_storage_chemical());
                     fmppostharvestbudget.put(FmpPostHarvestBudget.COST_OF_WAREHOUSE, fmpphb.getCost_of_warehouse());
                     fmppostharvestbudget.put(FmpPostHarvestBudget.DEHUSKINGPEELING_FAMILY_LABOR, fmpphb.getDehuskingpeeling_family_labor());
                     fmppostharvestbudget.put(FmpPostHarvestBudget.DEHUSKINGPEELING_LABOR, fmpphb.getDehuskingpeeling_labor());
                     fmppostharvestbudget.put(FmpPostHarvestBudget.FAMILY_LABOR_BAGGING, fmpphb.getFamily_labor_bagging());
                     fmppostharvestbudget.put(FmpPostHarvestBudget.FAMILY_LABOR_DRYINGCOBS_, fmpphb.getFamily_labor_dryingcobs_());
                     fmppostharvestbudget.put(FmpPostHarvestBudget.FAMILY_LABOR_DRYING_GRAIN, fmpphb.getFamily_labor_drying_grain());
                     fmppostharvestbudget.put(FmpPostHarvestBudget.FAMILY_LABOR_ENGAGED_WINNOWING, fmpphb.getFamily_labor_engaged_winnowing());
                     fmppostharvestbudget.put(FmpPostHarvestBudget.FAMILY_LABOR_MANUAL_THRESHING, fmpphb.getFamily_labor_manual_threshing());
                     fmppostharvestbudget.put(FmpPostHarvestBudget.GRAIN_DRYING_COST, fmpphb.getGrain_drying_cost());
                     fmppostharvestbudget.put(FmpPostHarvestBudget.LABOR_COST_DEHUSKINGPEELING, fmpphb.getLabor_cost_dehuskingpeeling());
                     fmppostharvestbudget.put(FmpPostHarvestBudget.LABOR_COST_DRYING_OF_COBS, fmpphb.getLabor_cost_drying_of_cobs());
                     fmppostharvestbudget.put(FmpPostHarvestBudget.LABOR_DRYING_GRAIN, fmpphb.getLabor_drying_grain());
                     fmppostharvestbudget.put(FmpPostHarvestBudget.LABOR_MANUAL_THRESHING, fmpphb.getLabor_manual_threshing());
                     fmppostharvestbudget.put(FmpPostHarvestBudget.LABOUR_FOR_BAGGING, fmpphb.getLabour_for_bagging());
                     fmppostharvestbudget.put(FmpPostHarvestBudget.LABOUR_WINNOWING, fmpphb.getLabour_winnowing());
                     fmppostharvestbudget.put(FmpPostHarvestBudget.TIME_INTERVAL_FOR_COMPLETION_OF_BAGGING, fmpphb.getTime_interval_for_completion_of_bagging());
                     fmppostharvestbudget.put(FmpPostHarvestBudget.TIME_INTERVAL_FOR_WINNOWING, fmpphb.getTime_interval_for_winnowing());
                     fmppostharvestbudget.put(FmpPostHarvestBudget.TIME_PERIOD_LABOR_DRYING_GRAIN, fmpphb.getTime_period_labor_drying_grain());
                     fmppostharvestbudget.put(FmpPostHarvestBudget.UNIT_COST_MACHINE_THRESHING, fmpphb.getUnit_cost_machine_threshing());
                     fmppostharvestbudget.put(FmpPostHarvestBudget.UNIT_LABOR_COST_BAGGING, fmpphb.getUnit_labor_cost_bagging());
                     
                     
                     
                     
                 }
                 
                 
                 JSONArray farmGps = new JSONArray();
                 List<FarmGPSLocationWrapper> wr = new FarmerGPSModel().findPerUser(bb.getFarmID());
                    for (FarmGPSLocationWrapper gps : wr) {
                        JSONObject jsob = new JSONObject();
                        jsob.put("x", gps.getLatitude());
                        jsob.put("y", gps.getLongitude());
                        farmGps.put(jsob);
                 }
                 
                 
                  
                 farmer.put("production",production);
                 farmer.put("postharvest",postHarvest);
                 farmer.put("baselineproduction",baselineproduction);
                 farmer.put("baselineproductionbudget",baselineproductionbudget);
                 farmer.put("baselinepostharvest",baselinepostharvest);
                 farmer.put("baselinepostharvestbudget",baselinepostharvestbudget);
                // farmer.put("baselinepostharvestbudget",baselinepostharvestbudget);
                 farmer.put("fmpproductionbudget",fmpproductionbudget);
                 farmer.put("fieldcropassessment",fieldcropassessment);
                 farmer.put("fmppostharvestbudget",fmppostharvestbudget);
                 farmer.put("technicalneeds",technicalNeeds);
                 farmer.put("profiling",profiling);
                 farmer.put("farmgps",farmGps);
                 
                 
                 
                  if (meetingArray.length() > 0) {
                    farmer.put("meeting", meetingArray);
                }
                  if (inputArray.length() > 0) {
                    farmer.put("inputs", inputArray);
                }
                 
                 
                 
  
                 details.put("farmer",farmer);
                 
                 fa.put(details);
                    
                }
                 tx.success();
                 out.print(fa);
                 //System.out.println("Output " + fa);
               
                } else {

                    JSONObject obj = new JSONObject();
                    obj.put("rc", "05");
                    obj.put("msg", "Invalid Action");
                    out.print(obj);
                }
            }
            else if("fupdate".equalsIgnoreCase(serviceCode))
            {
                Transaction tx = ICTCDBUtil.getInstance().getGraphDB().beginTx(); 
                List<BiodataWrapper> bw = new BiodataModel().getBioData("", "");
                BiodataModel biodataModel = new BiodataModel();
                ProductionUpdateModel productionUpdateModel = new ProductionUpdateModel();
                PostHarvestUpdateModel postHarvestUpdateModel = new PostHarvestUpdateModel();
                FmpProductionBudgetUpdateModel fmpProductionBudgetUpdateModel = new FmpProductionBudgetUpdateModel();
                FmpPostHarvestBudgetUpdateModel fmpPostHarvestBudgetUpdateModel = new FmpPostHarvestBudgetUpdateModel();
                        
                
                
                 JSONArray fa = new JSONArray();

                if (null != bw) {

                    for (BiodataWrapper bb : bw) {
                        JSONObject farmer = new JSONObject();
                        JSONObject productionupdate = new JSONObject();
                        JSONObject details = new JSONObject();
                        JSONObject postharvestupdate = new JSONObject();
                        JSONObject productionbudgetupdate = new JSONObject();
                        JSONObject postharvestbudgetupdate = new JSONObject();
                        
                        //biodata
                        Biodata b = biodataModel.getBiodata("Id", bb.getFarmID());

                        if (null != b) {

                            farmer.put(Biodata.FIRST_NAME, b.getFirstname());
                            farmer.put(Biodata.LAST_NAME, b.getLastname());
                            farmer.put(Biodata.FARMERID, b.getId());
                        }
                        
                        ProductionUpdate pu = productionUpdateModel.getProductionUpdate("Id", bb.getFarmID());
                        
                        
                        if(null!=pu)
                        {
                            productionupdate.put(ProductionUpdate.APPLICATIONOFBASALFERTILIZER,pu.getApplicationofbasalfertilizer());
                            productionupdate.put(ProductionUpdate.APPLICATIONOFHERBICIDEDATE,pu.getApplicationofherbicidedate());
                            productionupdate.put(ProductionUpdate.APPLICATIONOFTOPDRESSFERTILIZER,pu.getApplicationoftopdressfertilizer());
                            productionupdate.put(ProductionUpdate.CROPYIELD,pu.getCropyield());
                            productionupdate.put(ProductionUpdate.DATEFIRSTMANUALWEEDCONTROL,pu.getDatefirstmanualweedcontrol());
                            productionupdate.put(ProductionUpdate.DATEOFSECONDMANUALWEEDCONTROL,pu.getDateofsecondmanualweedcontrol());
                            productionupdate.put(ProductionUpdate.DATETOPDRESSINGWASCOMPLETED,pu.getDatetopdressingwascompleted());
                            productionupdate.put(ProductionUpdate.FIRSTMANUALWEEDCONTROLDATE,pu.getFirstmanualweedcontroldate());
                            productionupdate.put(ProductionUpdate.FOURTHWEEDCONTROLDATE,pu.getFourthweedcontroldate());
                            productionupdate.put(ProductionUpdate.HAVEYOUPLANTEDYOURCROP,pu.getHaveyouplantedyourcrop());
                            productionupdate.put(ProductionUpdate.LANDCLEARINGDATE,pu.getLandclearingdate());
                            productionupdate.put(ProductionUpdate.METHODOFBASALFERTILIZERAPPLICATION,pu.getMethodofbasalfertilizerapplication());
                            productionupdate.put(ProductionUpdate.METHODOFBASALFERTILIZERAPPLICATIONOTHER,pu.getMethodofbasalfertilizerapplicationother());
                            productionupdate.put(ProductionUpdate.METHODOFLANDCLEARING,pu.getMethodoflandclearing());
                            productionupdate.put(ProductionUpdate.METHODOFLANDPREPARATION,pu.getMethodoflandpreparation());
                            productionupdate.put(ProductionUpdate.METHODOFTOPDRESSERFERTILIZERAPPLICATION,pu.getMethodoftopdresserfertilizerapplication());
                            productionupdate.put(ProductionUpdate.NUMBERMANUALWEEDCONTROLOCCASIONS,pu.getNumbermanualweedcontroloccasions());
                            productionupdate.put(ProductionUpdate.OTHERFERTILIZER,pu.getOtherfertilizer());
                            productionupdate.put(ProductionUpdate.OTHERTOPDRESSERFERTILIZERTYPE,pu.getOthertopdresserfertilizertype());
                            productionupdate.put(ProductionUpdate.PLANTINGDATE,pu.getPlantingdate());
                            productionupdate.put(ProductionUpdate.PLANTINGDISTANCEANDPOPULATION,pu.getPlantingdistanceandpopulation());
                            productionupdate.put(ProductionUpdate.PLOUGHINGDATE,pu.getPloughingdate());
                            productionupdate.put(ProductionUpdate.POSTPLANTHERBICIDEUSE,pu.getPostplantherbicideuse());
                            productionupdate.put(ProductionUpdate.QUANTITYOFBASALFERTILIZERAPPLIED,pu.getQuantityofbasalfertilizerapplied());
                            productionupdate.put(ProductionUpdate.QUANTITYOFTOPDRESSERFERTILIZERAPPLIED,pu.getQuantityoftopdresserfertilizerapplied());
                            productionupdate.put(ProductionUpdate.QUANTITYPOSTPLANTHERBICIDE,pu.getQuantitypostplantherbicide());
                            productionupdate.put(ProductionUpdate.REASONFORCHANGEOFLANDCLEARING,pu.getReasonforchangeoflandclearing());
                            productionupdate.put(ProductionUpdate.REASONFORCHANGEOFLANDPREPARATION,pu.getReasonforchangeoflandpreparation());
                            productionupdate.put(ProductionUpdate.REASONFORCHANGEOFVARIETY,pu.getReasonforchangeofvariety());
                            productionupdate.put(ProductionUpdate.REASONFORDEVIATION,pu.getReasonfordeviation());
                            productionupdate.put(ProductionUpdate.REASONFORNOTPLANTING,pu.getReasonfornotplanting());
                            productionupdate.put(ProductionUpdate.REFILLINGGAPSOCCURENCE,pu.getRefillinggapsoccurence());
                            productionupdate.put(ProductionUpdate.SOURCEOFPLANTING,pu.getSourceofplanting());
                            productionupdate.put(ProductionUpdate.THIRDMANUALWEEDCONTROLDATE,pu.getThirdmanualweedcontroldate());
                            productionupdate.put(ProductionUpdate.TIMEOFHARVEST,pu.getTimeofharvest());
                            productionupdate.put(ProductionUpdate.TYPEOFBASALFERTILIZER,pu.getTypeofbasalfertilizer());
                            productionupdate.put(ProductionUpdate.TYPEOFCROPVARIETYCULTIVATED,pu.getTypeofcropvarietycultivated());
                            productionupdate.put(ProductionUpdate.TYPEOFHERBICIDEFORPOSTPLANTWEEDCONTROL,pu.getTypeofherbicideforpostplantweedcontrol());
                            productionupdate.put(ProductionUpdate.TYPEOFTOPDRESSFERTILIZER,pu.getTypeoftopdressfertilizer());
                            productionupdate.put(ProductionUpdate.LAST_MODIFIED,pu.getLastModifiedDate());
                            productionupdate.put(ProductionUpdate.WHENDIDYOUFININSHPALNTINGYOURCROP,pu.getWhendidyoufininshpalntingyourcrop());
                    
                        }
                        
                        
                        PostHarvestUpdate phu = postHarvestUpdateModel.getPostHarvestUpdate("Id",bb.getFarmID());
                        
                        if(null!=phu)
                        {
                            postharvestupdate.put(PostHarvestUpdate.APPLICATIONRATEOFSTORAGECHEMICAL,phu.getApplicationrateofstoragechemical());
                            postharvestupdate.put(PostHarvestUpdate.COMPLETIONOFPRODUCEMARKETING,phu.getCompletionofproducemarketing());
                            postharvestupdate.put(PostHarvestUpdate.COMPLETIONOFTHRESHING,phu.getCompletionofthreshing());
                            postharvestupdate.put(PostHarvestUpdate.DATEOFCOMPLETINGDRYING,phu.getDateofcompletingdrying());
                            postharvestupdate.put(PostHarvestUpdate.DATETOCOMPLETEDRYING,phu.getDatetocompletedrying());
                            postharvestupdate.put(PostHarvestUpdate.DRYINGOFCOBSCHUNKSPANICLES,phu.getDryingofcobschunkspanicles());
                            postharvestupdate.put(PostHarvestUpdate.FIRSTSALEDATE,phu.getFirstsaledate());
                            postharvestupdate.put(PostHarvestUpdate.MAINPOINTOFSALEORCONTACT,phu.getMainpointofsaleorcontact());
                            postharvestupdate.put(PostHarvestUpdate.METHODOFDRYINGCOBSPANICLESCHIPSCHUNKS,phu.getMethodofdryingcobspanicleschipschunks());
                            postharvestupdate.put(PostHarvestUpdate.METHODOFDRYINGGRAIN,phu.getMethodofdryinggrain());
                            postharvestupdate.put(PostHarvestUpdate.MOSTPRODUCESALEDATE,phu.getMostproducesaledate());
                            postharvestupdate.put(PostHarvestUpdate.OTHERAPPLICATIONRATEOFSTORAGECHEMIC,phu.getOtherapplicationrateofstoragechemic());
                            postharvestupdate.put(PostHarvestUpdate.OTHERMETHODFORDRYING,phu.getOthermethodfordrying());
                            postharvestupdate.put(PostHarvestUpdate.OTHERMETHODOFDRYINGGRAIN,phu.getOthermethodofdryinggrain());
                            postharvestupdate.put(PostHarvestUpdate.OTHERSALECONTACT,phu.getOthersalecontact());
                            postharvestupdate.put(PostHarvestUpdate.OTHERSTORAGECHEMICAL,phu.getOtherstoragechemical());
                            postharvestupdate.put(PostHarvestUpdate.OWNERSHIPCONDITIONSFORSTORAGE,phu.getOwnershipconditionsforstorage());
                            postharvestupdate.put(PostHarvestUpdate.POSTHARVESTLOSSES,phu.getPostharvestlosses());
                            postharvestupdate.put(PostHarvestUpdate.PRICEATFIRSTSALEDATE,phu.getPriceatfirstsaledate());
                            postharvestupdate.put(PostHarvestUpdate.PRICEATMOSTSALEDATE,phu.getPriceatmostsaledate());
                            postharvestupdate.put(PostHarvestUpdate.PROPORTIONFORMARKET,phu.getProportionformarket());
                            postharvestupdate.put(PostHarvestUpdate.THRESHING,phu.getThreshing());
                            postharvestupdate.put(PostHarvestUpdate.TYPEOFBAGUSEDINBULKINGPRODUCE,phu.getTypeofbagusedinbulkingproduce());
                            postharvestupdate.put(PostHarvestUpdate.TYPEOFSTORAGECHEMICAL,phu.getTypeofstoragechemical());
                            postharvestupdate.put(PostHarvestUpdate.TYPEOFSTORAGESTRUCTURE,phu.getTypeofstoragestructure());
                            postharvestupdate.put(PostHarvestUpdate.WINNOWING,phu.getWinnowing());
                        }
                        
                        
                        FmpProductionBudgetUpdate pbu = fmpProductionBudgetUpdateModel.getFmpProductionBudgetUpdate("Id",bb.getFarmID());
                        
                        
                        if(null!=pbu)
                        {
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.BASAL_FERTILIZER_APPL_LAB_UPDATE, pbu.getBasal_fert_labor_period_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.BASAL_FERT_LABOR_PERIOD_UPDATE, pbu.getBasal_fert_labor_period_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.COST_OF_APPLICATIONTOPDRESS_UPDATE, pbu.getCost_of_applicationtopdress_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.FAMILY_LABOR_BASAL_FERT_UPDATE, pbu.getFamily_labor_basal_fert_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.FAMILY_LABOR_FIFTH_WEED_CONTROL_UPDATE, pbu.getFamily_labor_fifth_weed_control_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.FAMILY_LABOR_FIRST_MANUAL_WEED_UPDATE, pbu.getFamily_labor_first_manual_weed_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.FAMILY_LABOR_SECOND_WEED_UPDATE, pbu.getFamily_labor_second_weed_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.FAMILY_LABOR_THIRD_WEED_UPDATE, pbu.getFamily_labor_third_weed_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.FAMILY_LABOR_TOPDRESS_FERTILIZER_APPLICA, pbu.getFamily_labor_topdress_fertilizer_applica());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.FERTILIZER_APP_LABOUR_COST_UPDATE, pbu.getFertilizer_app_labour_cost_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.FIFTH_WEEDING_LABOR_PERIOD_UPDATE, pbu.getFifth_weeding_labor_period_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.FINAL_HARVEST_LABOR_NO_UPDATE, pbu.getFinal_harvest_labor_no_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.FIRST_WEEDING_PERIOD_UPDATE, pbu.getFirst_weeding_period_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.FOURTH_WEEDING_LABOR_PERIOD_UPDATE, pbu.getFourth_weeding_labor_period_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.FOURTH_WEED_CONTROL_LABOR_UPDATE, pbu.getBasal_fert_labor_period_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.HARROWING_COST_PER_ACRE_UPDATE, pbu.getHarrowing_cost_per_acre_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.HARVEST_LABOR_COSTS_PER_ACRE_UPDATE, pbu.getHarrowing_cost_per_acre_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.HERBICIDE_APP_LABOR_PERIOD_UPDATE, pbu.getHerbicide_app_labor_period_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.HOE_PLOUGHING_LABOUR_FAMILY_UPDATE, pbu.getHoe_ploughing_labour_family_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.HOE_PLOUGHING_LABOUR_HOW_MANY_UPDATE,pbu.getHoe_ploughing_labour_family_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.HOE_PLOUGHING_LABOUR_PERIOD_UPDATE, pbu.getHoe_ploughing_labour_period_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.LABOR_FIFTH_WEED_CONTROL_UPDATE, pbu.getLabor_fifth_weed_control_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.LABOR_FOR_PLANTINGFAMILY_UPDATE, pbu.getLabor_for_plantingfamily_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.LABOR_FOURTH_WEED_CONTROL_UPDATE, pbu.getLabor_fourth_weed_control_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.LABOR_NO_FIRST_MANUAL_WEED_UPDATE,pbu.getLabor_no_first_manual_weed_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.LABOR_FOR_PLANTING_NUMBER_UPDATE,pbu.getLabor_for_planting_number_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.LABOR_THIRD_WEED_CONTROL_UPDATE,pbu.getLabor_third_weed_control_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.LAND_RENT_UPDATE,pbu.getLand_rent_update()); 
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.PERIOD_FOR_COMPLETION_OF_HARVEST_UPDATE,pbu.getPeriod_for_completion_of_harvest_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.PLANTING_LABOR_COST_UPDATE,pbu.getPlanting_labor_cost_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.PLANTING_PERIOD2_UPDATE,pbu.getPlanting_period2_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.PLOUGHING_COST_PER_ACRE_UPDATE,pbu.getPloughing_cost_per_acre_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.POST_HERBICIDE_APPLICATION_COST_UPDATE,pbu.getPost_herbicide_application_cost_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.POST_PLANT_HERBICIDE_COST_UPDATE, pbu.getPost_plant_herbicide_cost_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.PRICE_OF_BASAL_FERTILIZER_UPDATE, pbu.getPrice_of_basal_fertilizer_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.PRICE_OF_HERBICIDE_UPDATE, pbu.getPrice_of_herbicide_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.PRICE_OF_BASAL_FERTILIZER_UPDATE,pbu.getPrice_of_basal_fertilizer_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.PRICE_OF_TOPDRESS_FERTILIZER_UPDATE,pbu.getPrice_of_topdress_fertilizer_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.QUANTITY_OF_PREPLANT_HERBICIDE_UPDATE,pbu.getQuantity_of_preplant_herbicide_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.REFILLING_LABOR_FAMILY_UPDATE,pbu.getRefilling_labor_family_update());  
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.REFILLING_LABOR_PERIOD_UPDATE, pbu.getRefilling_labor_period_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.REFILLING_LABOUR_COST, pbu.getRefilling_labour_cost());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.REFILLING_LABOUR_NO_UPDATE, pbu.getRefilling_labour_no_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.SECOND_WEED_LABOR_UPDATE, pbu.getSecond_weed_labor_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.SECOND_WEED_PERIOD_UPDATE,pbu.getSecond_weed_period_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.SEEDBED_LABOR_COST_UPDATE,pbu.getSeedbed_labor_cost_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.SEEDBED_LABOR_NUMBER_UPDATE,pbu.getSeedbed_labor_number_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.SEEDBED_LABOUR_FAMILY_UPDATE,pbu.getSeedbed_labour_family_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.SEEDPLANTING_MATERIAL_COST_UPDATE,pbu.getSeedplanting_material_cost_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.SEED_BED_PREPARATION_PERIOD_UPDATE,pbu.getSeed_bed_preparation_period_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.THIRD_WEEDING_PERIOD_UPDATE,pbu.getThird_weeding_period_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.TOPDRESS_FERT_LABOR_PERIOD_UPDATE,pbu.getTopdress_fert_labor_period_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.TOTAL_COST_FIFTH_WEED_UPDATE,pbu.getTotal_cost_fifth_weed_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.TOTAL_COST_FIRST_MANUAL_WEED_UPDATE,pbu.getTotal_cost_first_manual_weed_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.TOTAL_COST_FOURTH_WEED_UPDATE,pbu.getTotal_cost_fourth_weed_update()); 
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.TOTAL_COST_SECOND_WEED_UPDATE,pbu.getTotal_cost_second_weed_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.TOTAL_COST_THIRD_WEED_UPDATE,pbu.getTotal_cost_third_weed_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.TOTAL_NUMBER_OF_LABOR_TOPDRESS_UPDATE,pbu.getTotal_number_of_labor_topdress_update());
                            productionbudgetupdate.put(FmpProductionBudgetUpdate.LAST_MODIFIED,pbu.getLastModifiedDate()); 
                    
                              
                        }
                        
                        FmpPostHarvestBudgetUpdate phbu  = fmpPostHarvestBudgetUpdateModel.getFmpProductionBudgetUpdate("Id",bb.getFarmID());
                        
                        
                        if(null!=phbu)
                        {
                            postharvestbudgetupdate.put(FmpPostHarvestBudgetUpdate.BAGS_FOR_STORAGE_UPDATE, phbu.getBags_for_storage_update());
                            postharvestbudgetupdate.put(FmpPostHarvestBudgetUpdate.COST_OF_STORAGE_CHEMICAL_UPDATE, phbu.getCost_of_storage_chemical_update());
                            postharvestbudgetupdate.put(FmpPostHarvestBudgetUpdate.DEHUSKING_FAMILY_LABOR_UPDATE, phbu.getDehusking_family_labor_update());
                            postharvestbudgetupdate.put(FmpPostHarvestBudgetUpdate.FAMILY_LABOR_BAGGING_UPDATE, phbu.getFamily_labor_bagging_update());
                            postharvestbudgetupdate.put(FmpPostHarvestBudgetUpdate.FAMILY_LABOR_DRYING_COBS_UPDATE, phbu.getFamily_labor_drying_cobs_update());
                            postharvestbudgetupdate.put(FmpPostHarvestBudgetUpdate.FAMILY_LABOR_DRYING_GRAIN_UPDATE, phbu.getFamily_labor_drying_grain_update());
                            postharvestbudgetupdate.put(FmpPostHarvestBudgetUpdate.FAMILY_LABOR_ENGAGED_WINNOWING_UPDATE, phbu.getFamily_labor_engaged_winnowing_update());
                            postharvestbudgetupdate.put(FmpPostHarvestBudgetUpdate.FAMILY_LABOR_MANUAL_THRESHING_UPDATE, phbu.getFamily_labor_manual_threshing_update());
                            postharvestbudgetupdate.put(FmpPostHarvestBudgetUpdate.GRAIN_DRYING_COST_UPDATE, phbu.getGrain_drying_cost_update());
                            postharvestbudgetupdate.put(FmpPostHarvestBudgetUpdate.LABOR_COST_DEHUSK_UPDATE,phbu.getLabor_cost_dehusk_update());
                            postharvestbudgetupdate.put(FmpPostHarvestBudgetUpdate.LABOR_COST_DRYING_OF_COBS_UPDATE,phbu.getLabor_cost_drying_of_cobs_update());
                            postharvestbudgetupdate.put(FmpPostHarvestBudgetUpdate.LABOR_HANDS_DRYINGCOBS_UPDATE,phbu.getLabor_hands_dryingcobs_update());
                            postharvestbudgetupdate.put(FmpPostHarvestBudgetUpdate.LABOR_MANUAL_THRESHING_UPDATE,phbu.getLabor_manual_threshing_update());
                            postharvestbudgetupdate.put(FmpPostHarvestBudgetUpdate.LABOR_PERIOD_DRYING_COBS_UPDATE,phbu.getLabor_period_drying_cobs_update());
                            postharvestbudgetupdate.put(FmpPostHarvestBudgetUpdate.LABOR_PERIOD_MANUAL_THRESH,phbu.getLabor_period_manual_thresh());
                            postharvestbudgetupdate.put(FmpPostHarvestBudgetUpdate.LABOUR_WINNOWING_UPDATE,phbu.getLabour_winnowing_update());
                            postharvestbudgetupdate.put(FmpPostHarvestBudgetUpdate.LABOUR_FOR_BAGGING_UPDATE,phbu.getLabour_for_bagging_update());
                            postharvestbudgetupdate.put(FmpPostHarvestBudgetUpdate.LAST_MODIFIED,phbu.getLastModifiedDate());
                            postharvestbudgetupdate.put(FmpPostHarvestBudgetUpdate.PERIOD_DEHUSK_UPDATE,phbu.getPeriod_dehusk_update());
                            postharvestbudgetupdate.put(FmpPostHarvestBudgetUpdate.TIME_COMPLETION_OF_BAGGING_UPDATE,phbu.getTime_completion_of_bagging_update());
                            postharvestbudgetupdate.put(FmpPostHarvestBudgetUpdate.TIME_INTERVAL_WINNOWING_UPDATE,phbu.getTime_interval_winnowing_update());
                            postharvestbudgetupdate.put(FmpPostHarvestBudgetUpdate.TIME_PERIOD_LABOR_DRYING_GRAIN_UPDATE,phbu.getTime_period_labor_drying_grain_update());
                            postharvestbudgetupdate.put(FmpPostHarvestBudgetUpdate.UNIT_COST_MACHINE_THRESHING_UPDATE,phbu.getUnit_cost_machine_threshing_update());
                            postharvestbudgetupdate.put(FmpPostHarvestBudgetUpdate.UNIT_COST_MANUAL_THRESHING_UPDATE,phbu.getLabor_manual_threshing_update());
                            postharvestbudgetupdate.put(FmpPostHarvestBudgetUpdate.UNIT_COST_OF_STORAGE_BAGS_UPDATE,phbu.getUnit_cost_of_storage_bags_update());
                            postharvestbudgetupdate.put(FmpPostHarvestBudgetUpdate.UNIT_COST_OF_WAREHOUSE_UPDATE,phbu.getUnit_cost_of_warehouse_update());
                            postharvestbudgetupdate.put(FmpPostHarvestBudgetUpdate.UNIT_LABOR_COST_BAGGING_UPDATE,phbu.getUnit_labor_cost_bagging_update());
                            postharvestbudgetupdate.put(FmpPostHarvestBudgetUpdate.UNIT_LABOR_COST_WINNOWING_UPDATE,phbu.getUnit_labor_cost_winnowing_update());
                            
                           
                        }
                        
                        
                        
                        farmer.put("productionupdate",productionupdate);
                        farmer.put("postharvestupdate", postharvestupdate);
                        farmer.put("productionbudgetupdate", productionbudgetupdate);
                        farmer.put("postharvestbudgetupdate",postharvestbudgetupdate);
                        
                        details.put("farmerupdate", farmer);
                        fa.put(details);
                    }
                    tx.success();
                    out.print(fa);
                    System.out.println("Output " + fa);
                   
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

