package com.grameenfoundation.ictc.utils;

import org.apache.commons.lang.WordUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by David on 6/9/2016.
 *
 * Update BI database with latest figures. Scheduled to run once a day
 */
public class ICTCBIUtil {

    private final static String TAG = ICTCBIUtil.class.getName();

    private final static int START_YEAR = 2016;
    private final static String OK = "Ok";
    private final static String FAILED = "Failed";

    // <editor-fold defaultstate="collapsed" desc="Table Names">

    private final static String TABLE_AGENT  = "bi_agent";
    private final static String TABLE_COMMUNITY  = "bi_community";
    private final static String TABLE_FARMER = "bi_farmer";
    private final static String TABLE_FARM = "bi_farm";
    private final static String TABLE_FIN_COST = "bi_fin_cost";
    private final static String TABLE_FIN_CREDIT = "bi_fin_credit";
    private final static String TABLE_FIN_PAYMENT = "bi_fin_payment";
    private final static String TABLE_FIN_REVENUE = "bi_fin_revenue";
    private final static ArrayList<String> TABLES = new ArrayList<>(Arrays.asList(
            TABLE_AGENT , TABLE_COMMUNITY , TABLE_FARMER, TABLE_FIN_COST,
            TABLE_FIN_CREDIT, TABLE_FIN_PAYMENT, TABLE_FIN_REVENUE, TABLE_FARM));

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Update Keys">
    private final static String UPDATE_AGENT_INFO = "update_agent_info";
    private final static String UPDATE_COMMUNITY_INFO = "update_community_info";
    private final static String UPDATE_FARMER_INFO = "update_farmer_info";
    private final static String UPDATE_FINANCIAL_INFO = "update_financial_info";
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Indicator Names">

    private final static String INDICATOR_AGENT = "count_agent";
    private final static String INDICATOR_COMMUNITY = "count_community";
    private final static String INDICATOR_FARMER = "count_farmer";
    private final static String INDICATOR_FARM = "count_farm";
    private final static String INDICATOR_COSTS = "count_costs";
    private final static String INDICATOR_CREDIT = "count_credit";
    private final static String INDICATOR_PAYMENT = "count_payment";
    private final static String INDICATOR_REVENUE = "count_revenue";

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Partner Names">

    private final static String PARTNER_ACDI = "ACDIVOCA";
    private final static String PARTNER_MOFA = "MOFA";
    private final static String PARTNER_GF = "GRAMEEN";
    private final static String PARTNER_CIF = "CIFCSF";
    private final static String PARTNER_AIS_BA = "AIS_BA";
    private final static String PARTNER_AIS_UE = "AIS_UE";
    private final static String PARTNER_AIS_UW = "AIS_UW";
    private final static String PARTNER_AIS_NR = "AIS_NR";
    private final static String PARTNER_AIS_VR = "AIS_VR";
    private final static String[] PARTNERS = {PARTNER_ACDI, PARTNER_MOFA, PARTNER_CIF, PARTNER_GF,
                                              PARTNER_AIS_BA, PARTNER_AIS_UE, PARTNER_AIS_UW,
                                              PARTNER_AIS_NR, PARTNER_AIS_VR};
    // </editor-fold>

    public static DashboardData getDashboardDataAsObject(String dashboard) {
        return new DashboardData(getDashboardData(dashboard));
    }

    public static JSONObject getDashboardData(String dashboard) {
        JSONObject x =  new JSONObject();

        try {
            x.put("farmers", new JSONObject());
            x.getJSONObject("farmers").put("registration", new JSONObject());
            x.getJSONObject("farmers").getJSONObject("registration").put("total", IndicatorManager.getInstance(INDICATOR_FARMER).getTotalData());

            x.put("agents", new JSONObject());
            x.getJSONObject("agents").put("registration", new JSONObject());
            x.getJSONObject("agents").getJSONObject("registration").put("total", IndicatorManager.getInstance(INDICATOR_AGENT).getTotalData());

            for(String p : PARTNERS ) {
                x.getJSONObject("farmers").getJSONObject("registration").put(p, IndicatorManager.getInstance(INDICATOR_FARMER).getPartnerRegistrationData(p));
                x.getJSONObject("agents").getJSONObject("registration").put(p, IndicatorManager.getInstance(INDICATOR_AGENT).getPartnerRegistrationData(p));
            }

            if (dashboard.equalsIgnoreCase("gf")) {
                x.getJSONObject("farmers").put("previous_performance", new JSONObject());
                x.getJSONObject("farmers").put("fmp", new JSONObject());
                x.getJSONObject("farmers").put("fmp_update", new JSONObject());
                x.getJSONObject("farmers").put("farms", new JSONObject());

                x.getJSONObject("agents").put("previous_performance", new JSONObject());
                x.getJSONObject("agents").put("fmp", new JSONObject());
                x.getJSONObject("agents").put("fmp_update", new JSONObject());
                x.getJSONObject("agents").put("farms", new JSONObject());

                for(String p : PARTNERS ) {
                    x.getJSONObject("farmers").getJSONObject("previous_performance").put(p, IndicatorManager.getInstance(INDICATOR_FARMER).getPartnerPPData(p));
                    x.getJSONObject("farmers").getJSONObject("fmp").put(p, IndicatorManager.getInstance(INDICATOR_FARMER).getPartnerFMPData(p));
                    x.getJSONObject("farmers").getJSONObject("fmp_update").put(p, IndicatorManager.getInstance(INDICATOR_FARMER).getPartnerFMPUpdateData(p));
                    x.getJSONObject("farmers").getJSONObject("farms").put(p, IndicatorManager.getInstance(INDICATOR_FARMER).getPartnerFarmsData(p));

                    x.getJSONObject("agents").getJSONObject("previous_performance").put(p, IndicatorManager.getInstance(INDICATOR_AGENT).getPartnerPPData(p));
                    x.getJSONObject("agents").getJSONObject("fmp").put(p, IndicatorManager.getInstance(INDICATOR_AGENT).getPartnerFMPData(p));
                    x.getJSONObject("agents").getJSONObject("fmp_update").put(p, IndicatorManager.getInstance(INDICATOR_AGENT).getPartnerFMPUpdateData(p));
                    x.getJSONObject("agents").getJSONObject("farms").put(p, IndicatorManager.getInstance(INDICATOR_AGENT).getPartnerFarmsData(p));
                }

            } else if (dashboard.equalsIgnoreCase("general")) {
                x.getJSONObject("agents").getJSONObject("registration").put("sparkline", IndicatorManager.getInstance(INDICATOR_AGENT).getSparkLineData());
                x.getJSONObject("farmers").getJSONObject("registration").put("sparkline", IndicatorManager.getInstance(INDICATOR_FARMER).getSparkLineData());
                x.getJSONObject("farmers").getJSONObject("registration").put("chart_line", IndicatorManager.getInstance(INDICATOR_FARMER).getEChartLineData());

                x.put("communities", new JSONObject());
                x.getJSONObject("communities").put("registration", new JSONObject());
                x.getJSONObject("communities").getJSONObject("registration").put("total", IndicatorManager.getInstance(INDICATOR_COMMUNITY).getTotalData());
                x.getJSONObject("communities").getJSONObject("registration").put("sparkline", IndicatorManager.getInstance(INDICATOR_COMMUNITY).getSparkLineData());
            }
        } catch (Exception ex) {
            x.put("error",ex.getLocalizedMessage());
            Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return x;
    }

    public static JSONObject getIndicator(String indicator, HashMap params) {
        List<String> data = new ArrayList();

        if (indicator.equals("gf-get-output-table")) {
            data.add("{ \"indicator\": \"Using improved practices and technologies\", \"farmers\": \"0\", \"area\": \"0\" }");
            data.add("{ \"indicator\": \"Using improved seed\", \"farmers\": \"0\", \"area\": \"0\" }");
            data.add("{ \"indicator\": \"Using recommended crop density and arrangement\", \"farmers\": \"0\", \"area\": \"0\" }");
            data.add("{ \"indicator\": \"Using inorganic fertilizer\", \"farmers\": \"0\", \"area\": \"0\" }");
            data.add("{ \"indicator\": \"Using pre-plant herbicide\", \"farmers\": \"0\", \"area\": \"0\" }");
            data.add("{ \"indicator\": \"Using post-plant herbicide\", \"farmers\": \"0\", \"area\": \"0\" }");
            data.add("{ \"indicator\": \"Using post-harvest thresher\", \"farmers\": \"0\", \"area\": \"0\" }");

        } else if (indicator.equals("gf-get-activity-table")) {
            DashboardData d = getDashboardDataAsObject("gf");

            String v = d.getFarmerRegistrationTotal();
            data.add("{ \"indicator\": \"Number of farmers with access to Agent (registered)\", \"farmers\": \""+v+"\" }");

            v = d.getFarmMeasuredTotal();
            data.add("{ \"indicator\": \"Number of farmers with farms measured\", \"farmers\": \""+v+"\" }");

            v = d.getFarmAssessedTotal();
            data.add("{ \"indicator\": \"Number of farmers with farms assessed\", \"farmers\": \""+v+"\" }");

            v = "0";
            data.add("{ \"indicator\": \"Number of farmers receiving advice on activities from farm planning to planting\", \"farmers\": \""+v+"\" }");
            data.add("{ \"indicator\": \"Number of farmers receiving advice on activities from farm planning to planting (video)\", \"farmers\": \""+v+"\" }");

            data.add("{ \"indicator\": \"Number of farmers receiving advice on activities from planting to harvest\", \"farmers\": \""+v+"\" }");
            data.add("{ \"indicator\": \"Number of farmers receiving advice on activities from planting to harvest (video)\", \"farmers\": \""+v+"\" }");

            data.add("{ \"indicator\": \"Number of farmers receiving advice on post-harvest activities\", \"farmers\": \""+v+"\" }");
            data.add("{ \"indicator\": \"Number of farmers receiving advice on post-harvest activities (video)\", \"farmers\": \""+v+"\" }");

            data.add("{ \"indicator\": \"Number of farmers receiving advice on marketing activities\", \"farmers\": \""+v+"\" }");
            data.add("{ \"indicator\": \"Number of farmers receiving advice on marketing activities (video)\", \"farmers\": \""+v+"\" }");
        } else {
        }

        JSONObject response = new JSONObject();
        response.put("data",new JSONArray());
        for (String s : data) { response.getJSONArray("data").put(new JSONObject(s)); }
        return response;
    }

    public static HashMap updateIndicators(String indicator) {
        HashMap<String, String> response = new HashMap<>();
        try {
            response = IndicatorManager.getInstance(indicator).update();
        } catch (Exception ex) {
            response.put("error",ex.getLocalizedMessage());
            Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return response;
    }

    // <editor-fold defaultstate="collapsed" desc="Indicator Get/Update Methods">

    public static class DashboardData {
        protected JSONObject data;

        public DashboardData(JSONObject o) { data = o; }

        // <editor-fold defaultstate="collapsed" desc="Farmer Info">
        public String getFarmerRegistrationSparkline() { return getRegistrationSparkline("farmers"); }
        public String getFarmerRegistrationEChartLegend() { return getRegistrationEChartLineData("farmers","legend"); }
        public String getFarmerRegistrationEChartAxis() { return getRegistrationEChartLineData("farmers","xAxis"); }
        public String getFarmerRegistrationEChartSeries() { return getRegistrationEChartLineData("farmers","series"); }

        public String getFarmerRegistrationTotal() { return getRegistrationTotal("farmers"); }
        public String getFarmerRegistrationProgressForACDI() { return getRegistrationProgress("farmers", PARTNER_ACDI); }
        public String getFarmerRegistrationProgressForMOFA() { return getRegistrationProgress("farmers", PARTNER_MOFA); }
        public String getFarmerRegistrationProgressForCIF() { return getRegistrationProgress("farmers", PARTNER_CIF); }
        public String getFarmerRegistrationProgressForGF() { return getRegistrationProgress("farmers", PARTNER_GF); }
        public String getFarmerRegistrationProgressForAISBA() { return getRegistrationProgress("farmers", PARTNER_AIS_BA); }
        public String getFarmerRegistrationProgressForAISUE() { return getRegistrationProgress("farmers", PARTNER_AIS_UE); }
        public String getFarmerRegistrationProgressForAISUW() { return getRegistrationProgress("farmers", PARTNER_AIS_UW); }
        public String getFarmerRegistrationProgressForAISNR() { return getRegistrationProgress("farmers", PARTNER_AIS_NR); }
        public String getFarmerRegistrationProgressForAISVR() { return getRegistrationProgress("farmers", PARTNER_AIS_VR); }

        public String getFarmerRegistrationTargetForACDI() { return getRegistrationTarget("farmers", PARTNER_ACDI); }
        public String getFarmerRegistrationTargetForMOFA() { return getRegistrationTarget("farmers", PARTNER_MOFA); }
        public String getFarmerRegistrationTargetForCIF() { return getRegistrationTarget("farmers", PARTNER_CIF); }
        public String getFarmerRegistrationTargetForGF() { return getRegistrationTarget("farmers", PARTNER_GF); }
        public String getFarmerRegistrationTargetForAISBA() { return getRegistrationTarget("farmers", PARTNER_AIS_BA); }
        public String getFarmerRegistrationTargetForAISUE() { return getRegistrationTarget("farmers", PARTNER_AIS_UE); }
        public String getFarmerRegistrationTargetForAISUW() { return getRegistrationTarget("farmers", PARTNER_AIS_UW); }
        public String getFarmerRegistrationTargetForAISNR() { return getRegistrationTarget("farmers", PARTNER_AIS_NR); }
        public String getFarmerRegistrationTargetForAISVR() { return getRegistrationTarget("farmers", PARTNER_AIS_VR); }

        public String getFarmerRegistrationTotalForACDI() { return getRegistrationTotal("farmers", PARTNER_ACDI); }
        public String getFarmerRegistrationTotalForMOFA() { return getRegistrationTotal("farmers", PARTNER_MOFA); }
        public String getFarmerRegistrationTotalForCIF() { return getRegistrationTotal("farmers", PARTNER_CIF); }
        public String getFarmerRegistrationTotalForGF() { return getRegistrationTotal("farmers", PARTNER_GF); }
        public String getFarmerRegistrationTotalForAISBA() { return getRegistrationTotal("farmers", PARTNER_AIS_BA); }
        public String getFarmerRegistrationTotalForAISUE() { return getRegistrationTotal("farmers", PARTNER_AIS_UE); }
        public String getFarmerRegistrationTotalForAISUW() { return getRegistrationTotal("farmers", PARTNER_AIS_UW); }
        public String getFarmerRegistrationTotalForAISNR() { return getRegistrationTotal("farmers", PARTNER_AIS_NR); }
        public String getFarmerRegistrationTotalForAISVR() { return getRegistrationTotal("farmers", PARTNER_AIS_VR); }

        public String getFarmerPPTotalForACDI() { return getPPTotal("farmers", PARTNER_ACDI); }
        public String getFarmerPPTotalForMOFA() { return getPPTotal("farmers", PARTNER_MOFA); }
        public String getFarmerPPTotalForCIF() { return getPPTotal("farmers", PARTNER_CIF); }
        public String getFarmerPPTotalForGF() { return getPPTotal("farmers", PARTNER_GF); }
        public String getFarmerPPTotalForAISBA() { return getPPTotal("farmers", PARTNER_AIS_BA); }
        public String getFarmerPPTotalForAISUE() { return getPPTotal("farmers", PARTNER_AIS_UE); }
        public String getFarmerPPTotalForAISUW() { return getPPTotal("farmers", PARTNER_AIS_UW); }
        public String getFarmerPPTotalForAISNR() { return getPPTotal("farmers", PARTNER_AIS_NR); }
        public String getFarmerPPTotalForAISVR() { return getPPTotal("farmers", PARTNER_AIS_VR); }

        public String getFarmerFMPTotalForACDI() { return getFMPTotal("farmers", PARTNER_ACDI); }
        public String getFarmerFMPTotalForMOFA() { return getFMPTotal("farmers", PARTNER_MOFA); }
        public String getFarmerFMPTotalForCIF() { return getFMPTotal("farmers", PARTNER_CIF); }
        public String getFarmerFMPTotalForGF() { return getFMPTotal("farmers", PARTNER_GF); }
        public String getFarmerFMPTotalForAISBA() { return getFMPTotal("farmers", PARTNER_AIS_BA); }
        public String getFarmerFMPTotalForAISUE() { return getFMPTotal("farmers", PARTNER_AIS_UE); }
        public String getFarmerFMPTotalForAISUW() { return getFMPTotal("farmers", PARTNER_AIS_UW); }
        public String getFarmerFMPTotalForAISNR() { return getFMPTotal("farmers", PARTNER_AIS_NR); }
        public String getFarmerFMPTotalForAISVR() { return getFMPTotal("farmers", PARTNER_AIS_VR); }

        public String getFarmerFMPUpdateTotalForACDI() { return getFMPUpdateTotal("farmers", PARTNER_ACDI); }
        public String getFarmerFMPUpdateTotalForMOFA() { return getFMPUpdateTotal("farmers", PARTNER_MOFA); }
        public String getFarmerFMPUpdateTotalForCIF() { return getFMPUpdateTotal("farmers", PARTNER_CIF); }
        public String getFarmerFMPUpdateTotalForGF() { return getFMPUpdateTotal("farmers", PARTNER_GF); }
        public String getFarmerFMPUpdateTotalForAISBA() { return getFMPUpdateTotal("farmers", PARTNER_AIS_BA); }
        public String getFarmerFMPUpdateTotalForAISUE() { return getFMPUpdateTotal("farmers", PARTNER_AIS_UE); }
        public String getFarmerFMPUpdateTotalForAISUW() { return getFMPUpdateTotal("farmers", PARTNER_AIS_UW); }
        public String getFarmerFMPUpdateTotalForAISNR() { return getFMPUpdateTotal("farmers", PARTNER_AIS_NR); }
        public String getFarmerFMPUpdateTotalForAISVR() { return getFMPUpdateTotal("farmers", PARTNER_AIS_VR); }

        public String getFarmerFarmsMeasuredTotalForACDI() { return getFarmsMeasuredTotal("farmers", PARTNER_ACDI); }
        public String getFarmerFarmsMeasuredTotalForMOFA() { return getFarmsMeasuredTotal("farmers", PARTNER_MOFA); }
        public String getFarmerFarmsMeasuredTotalForCIF() { return getFarmsMeasuredTotal("farmers", PARTNER_CIF); }
        public String getFarmerFarmsMeasuredTotalForGF() { return getFarmsMeasuredTotal("farmers", PARTNER_GF); }
        public String getFarmerFarmsMeasuredTotalForAISBA() { return getFarmsMeasuredTotal("farmers", PARTNER_AIS_BA); }
        public String getFarmerFarmsMeasuredTotalForAISUE() { return getFarmsMeasuredTotal("farmers", PARTNER_AIS_UE); }
        public String getFarmerFarmsMeasuredTotalForAISUW() { return getFarmsMeasuredTotal("farmers", PARTNER_AIS_UW); }
        public String getFarmerFarmsMeasuredTotalForAISNR() { return getFarmsMeasuredTotal("farmers", PARTNER_AIS_NR); }
        public String getFarmerFarmsMeasuredTotalForAISVR() { return getFarmsMeasuredTotal("farmers", PARTNER_AIS_VR); }

        public String getFarmerFarmsAssessedTotalForACDI() { return getFarmsAssessedTotal("farmers", PARTNER_ACDI); }
        public String getFarmerFarmsAssessedTotalForMOFA() { return getFarmsAssessedTotal("farmers", PARTNER_MOFA); }
        public String getFarmerFarmsAssessedTotalForCIF() { return getFarmsAssessedTotal("farmers", PARTNER_CIF); }
        public String getFarmerFarmsAssessedTotalForGF() { return getFarmsAssessedTotal("farmers", PARTNER_GF); }
        public String getFarmerFarmsAssessedTotalForAISBA() { return getFarmsAssessedTotal("farmers", PARTNER_AIS_BA); }
        public String getFarmerFarmsAssessedTotalForAISUE() { return getFarmsAssessedTotal("farmers", PARTNER_AIS_UE); }
        public String getFarmerFarmsAssessedTotalForAISUW() { return getFarmsAssessedTotal("farmers", PARTNER_AIS_UW); }
        public String getFarmerFarmsAssessedTotalForAISNR() { return getFarmsAssessedTotal("farmers", PARTNER_AIS_NR); }
        public String getFarmerFarmsAssessedTotalForAISVR() { return getFarmsAssessedTotal("farmers", PARTNER_AIS_VR); }

        public String getFarmerPPProgressForACDI() { return getPPProgress("farmers", PARTNER_ACDI); }
        public String getFarmerPPProgressForMOFA() { return getPPProgress("farmers", PARTNER_MOFA); }
        public String getFarmerPPProgressForCIF() { return getPPProgress("farmers", PARTNER_CIF); }
        public String getFarmerPPProgressForGF() { return getPPProgress("farmers", PARTNER_GF); }
        public String getFarmerPPProgressForAISBA() { return getPPProgress("farmers", PARTNER_AIS_BA); }
        public String getFarmerPPProgressForAISUE() { return getPPProgress("farmers", PARTNER_AIS_UE); }
        public String getFarmerPPProgressForAISUW() { return getPPProgress("farmers", PARTNER_AIS_UW); }
        public String getFarmerPPProgressForAISNR() { return getPPProgress("farmers", PARTNER_AIS_NR); }
        public String getFarmerPPProgressForAISVR() { return getPPProgress("farmers", PARTNER_AIS_VR); }

        public String getFarmerFMPProgressForACDI() { return getFMPProgress("farmers", PARTNER_ACDI); }
        public String getFarmerFMPProgressForMOFA() { return getFMPProgress("farmers", PARTNER_MOFA); }
        public String getFarmerFMPProgressForCIF() { return getFMPProgress("farmers", PARTNER_CIF); }
        public String getFarmerFMPProgressForGF() { return getFMPProgress("farmers", PARTNER_GF); }
        public String getFarmerFMPProgressForAISBA() { return getFMPProgress("farmers", PARTNER_AIS_BA); }
        public String getFarmerFMPProgressForAISUE() { return getFMPProgress("farmers", PARTNER_AIS_UE); }
        public String getFarmerFMPProgressForAISUW() { return getFMPProgress("farmers", PARTNER_AIS_UW); }
        public String getFarmerFMPProgressForAISNR() { return getFMPProgress("farmers", PARTNER_AIS_NR); }
        public String getFarmerFMPProgressForAISVR() { return getFMPProgress("farmers", PARTNER_AIS_VR); }

        public String getFarmerFMPUpdateProgressForACDI() { return getFMPUpdateProgress("farmers", PARTNER_ACDI); }
        public String getFarmerFMPUpdateProgressForMOFA() { return getFMPUpdateProgress("farmers", PARTNER_MOFA); }
        public String getFarmerFMPUpdateProgressForCIF() { return getFMPUpdateProgress("farmers", PARTNER_CIF); }
        public String getFarmerFMPUpdateProgressForGF() { return getFMPUpdateProgress("farmers", PARTNER_GF); }
        public String getFarmerFMPUpdateProgressForAISBA() { return getFMPUpdateProgress("farmers", PARTNER_AIS_BA); }
        public String getFarmerFMPUpdateProgressForAISUE() { return getFMPUpdateProgress("farmers", PARTNER_AIS_UE); }
        public String getFarmerFMPUpdateProgressForAISUW() { return getFMPUpdateProgress("farmers", PARTNER_AIS_UW); }
        public String getFarmerFMPUpdateProgressForAISNR() { return getFMPUpdateProgress("farmers", PARTNER_AIS_NR); }
        public String getFarmerFMPUpdateProgressForAISVR() { return getFMPUpdateProgress("farmers", PARTNER_AIS_VR); }

        public String getFarmerFarmsMeasuredProgressForACDI() { return getFarmsMeasuredProgress("farmers", PARTNER_ACDI); }
        public String getFarmerFarmsMeasuredProgressForMOFA() { return getFarmsMeasuredProgress("farmers", PARTNER_MOFA); }
        public String getFarmerFarmsMeasuredProgressForCIF() { return getFarmsMeasuredProgress("farmers", PARTNER_CIF); }
        public String getFarmerFarmsMeasuredProgressForGF() { return getFarmsMeasuredProgress("farmers", PARTNER_GF); }
        public String getFarmerFarmsMeasuredProgressForAISBA() { return getFarmsMeasuredProgress("farmers", PARTNER_AIS_BA); }
        public String getFarmerFarmsMeasuredProgressForAISUE() { return getFarmsMeasuredProgress("farmers", PARTNER_AIS_UE); }
        public String getFarmerFarmsMeasuredProgressForAISUW() { return getFarmsMeasuredProgress("farmers", PARTNER_AIS_UW); }
        public String getFarmerFarmsMeasuredProgressForAISNR() { return getFarmsMeasuredProgress("farmers", PARTNER_AIS_NR); }
        public String getFarmerFarmsMeasuredProgressForAISVR() { return getFarmsMeasuredProgress("farmers", PARTNER_AIS_VR); }

        public String getFarmerFarmsAssessedProgressForACDI() { return getFarmsAssessedProgress("farmers", PARTNER_ACDI); }
        public String getFarmerFarmsAssessedProgressForMOFA() { return getFarmsAssessedProgress("farmers", PARTNER_MOFA); }
        public String getFarmerFarmsAssessedProgressForCIF() { return getFarmsAssessedProgress("farmers", PARTNER_CIF); }
        public String getFarmerFarmsAssessedProgressForGF() { return getFarmsAssessedProgress("farmers", PARTNER_GF); }
        public String getFarmerFarmsAssessedProgressForAISBA() { return getFarmsAssessedProgress("farmers", PARTNER_AIS_BA); }
        public String getFarmerFarmsAssessedProgressForAISUE() { return getFarmsAssessedProgress("farmers", PARTNER_AIS_UE); }
        public String getFarmerFarmsAssessedProgressForAISUW() { return getFarmsAssessedProgress("farmers", PARTNER_AIS_UW); }
        public String getFarmerFarmsAssessedProgressForAISNR() { return getFarmsAssessedProgress("farmers", PARTNER_AIS_NR); }
        public String getFarmerFarmsAssessedProgressForAISVR() { return getFarmsAssessedProgress("farmers", PARTNER_AIS_VR); }
        //</editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Agent Info">
        public String getAgentRegistrationTotal() { return getRegistrationTotal("agents"); }
        public String getAgentRegistrationSparkline() { return getRegistrationSparkline("agents"); }
        public String getAgentRegistrationProgressForACDI() { return getRegistrationProgress("agents", PARTNER_ACDI); }
        public String getAgentRegistrationProgressForMOFA() { return getRegistrationProgress("agents", PARTNER_MOFA); }
        public String getAgentRegistrationProgressForCIF() { return getRegistrationProgress("agents", PARTNER_CIF); }
        public String getAgentRegistrationProgressForGF() { return getRegistrationProgress("agents", PARTNER_GF); }
        public String getAgentRegistrationProgressForAISBA() { return getRegistrationProgress("agents", PARTNER_AIS_BA); }
        public String getAgentRegistrationProgressForAISUE() { return getRegistrationProgress("agents", PARTNER_AIS_UE); }
        public String getAgentRegistrationProgressForAISUW() { return getRegistrationProgress("agents", PARTNER_AIS_UW); }
        public String getAgentRegistrationProgressForAISNR() { return getRegistrationProgress("agents", PARTNER_AIS_NR); }
        public String getAgentRegistrationProgressForAISVR() { return getRegistrationProgress("agents", PARTNER_AIS_VR); }

        public String getAgentRegistrationTargetForACDI() { return getRegistrationTarget("agents", PARTNER_ACDI); }
        public String getAgentRegistrationTargetForMOFA() { return getRegistrationTarget("agents", PARTNER_MOFA); }
        public String getAgentRegistrationTargetForCIF() { return getRegistrationTarget("agents", PARTNER_CIF); }
        public String getAgentRegistrationTargetForGF() { return getRegistrationTarget("agents", PARTNER_GF); }
        public String getAgentRegistrationTargetForAISBA() { return getRegistrationTarget("agents", PARTNER_AIS_BA); }
        public String getAgentRegistrationTargetForAISUE() { return getRegistrationTarget("agents", PARTNER_AIS_UE); }
        public String getAgentRegistrationTargetForAISUW() { return getRegistrationTarget("agents", PARTNER_AIS_UW); }
        public String getAgentRegistrationTargetForAISNR() { return getRegistrationTarget("agents", PARTNER_AIS_NR); }
        public String getAgentRegistrationTargetForAISVR() { return getRegistrationTarget("agents", PARTNER_AIS_VR); }

        public String getAgentRegistrationTotalForACDI() { return getRegistrationTotal("agents", PARTNER_ACDI); }
        public String getAgentRegistrationTotalForMOFA() { return getRegistrationTotal("agents", PARTNER_MOFA); }
        public String getAgentRegistrationTotalForCIF() { return getRegistrationTotal("agents", PARTNER_CIF); }
        public String getAgentRegistrationTotalForGF() { return getRegistrationTotal("agents", PARTNER_GF); }
        public String getAgentRegistrationTotalForAISBA() { return getRegistrationTotal("agents", PARTNER_AIS_BA); }
        public String getAgentRegistrationTotalForAISUE() { return getRegistrationTotal("agents", PARTNER_AIS_UE); }
        public String getAgentRegistrationTotalForAISUW() { return getRegistrationTotal("agents", PARTNER_AIS_UW); }
        public String getAgentRegistrationTotalForAISNR() { return getRegistrationTotal("agents", PARTNER_AIS_NR); }
        public String getAgentRegistrationTotalForAISVR() { return getRegistrationTotal("agents", PARTNER_AIS_VR); }

        public String getAgentPPTotalForACDI() { return getPPTotal("agents", PARTNER_ACDI); }
        public String getAgentPPTotalForMOFA() { return getPPTotal("agents", PARTNER_MOFA); }
        public String getAgentPPTotalForCIF() { return getPPTotal("agents", PARTNER_CIF); }
        public String getAgentPPTotalForGF() { return getPPTotal("agents", PARTNER_GF); }
        public String getAgentPPTotalForAISBA() { return getPPTotal("agents", PARTNER_AIS_BA); }
        public String getAgentPPTotalForAISUE() { return getPPTotal("agents", PARTNER_AIS_UE); }
        public String getAgentPPTotalForAISUW() { return getPPTotal("agents", PARTNER_AIS_UW); }
        public String getAgentPPTotalForAISNR() { return getPPTotal("agents", PARTNER_AIS_NR); }
        public String getAgentPPTotalForAISVR() { return getPPTotal("agents", PARTNER_AIS_VR); }

        public String getAgentFMPTotalForACDI() { return getFMPTotal("agents", PARTNER_ACDI); }
        public String getAgentFMPTotalForMOFA() { return getFMPTotal("agents", PARTNER_MOFA); }
        public String getAgentFMPTotalForCIF() { return getFMPTotal("agents", PARTNER_CIF); }
        public String getAgentFMPTotalForGF() { return getFMPTotal("agents", PARTNER_GF); }
        public String getAgentFMPTotalForAISBA() { return getFMPTotal("agents", PARTNER_AIS_BA); }
        public String getAgentFMPTotalForAISUE() { return getFMPTotal("agents", PARTNER_AIS_UE); }
        public String getAgentFMPTotalForAISUW() { return getFMPTotal("agents", PARTNER_AIS_UW); }
        public String getAgentFMPTotalForAISNR() { return getFMPTotal("agents", PARTNER_AIS_NR); }
        public String getAgentFMPTotalForAISVR() { return getFMPTotal("agents", PARTNER_AIS_VR); }

        public String getAgentFMPUpdateTotalForACDI() { return getFMPUpdateTotal("agents", PARTNER_ACDI); }
        public String getAgentFMPUpdateTotalForMOFA() { return getFMPUpdateTotal("agents", PARTNER_MOFA); }
        public String getAgentFMPUpdateTotalForCIF() { return getFMPUpdateTotal("agents", PARTNER_CIF); }
        public String getAgentFMPUpdateTotalForGF() { return getFMPUpdateTotal("agents", PARTNER_GF); }
        public String getAgentFMPUpdateTotalForAISBA() { return getFMPUpdateTotal("agents", PARTNER_AIS_BA); }
        public String getAgentFMPUpdateTotalForAISUE() { return getFMPUpdateTotal("agents", PARTNER_AIS_UE); }
        public String getAgentFMPUpdateTotalForAISUW() { return getFMPUpdateTotal("agents", PARTNER_AIS_UW); }
        public String getAgentFMPUpdateTotalForAISNR() { return getFMPUpdateTotal("agents", PARTNER_AIS_NR); }
        public String getAgentFMPUpdateTotalForAISVR() { return getFMPUpdateTotal("agents", PARTNER_AIS_VR); }

        public String getAgentFarmsMeasuredTotalForACDI() { return getFarmsMeasuredTotal("agents", PARTNER_ACDI); }
        public String getAgentFarmsMeasuredTotalForMOFA() { return getFarmsMeasuredTotal("agents", PARTNER_MOFA); }
        public String getAgentFarmsMeasuredTotalForCIF() { return getFarmsMeasuredTotal("agents", PARTNER_CIF); }
        public String getAgentFarmsMeasuredTotalForGF() { return getFarmsMeasuredTotal("agents", PARTNER_GF); }
        public String getAgentFarmsMeasuredTotalForAISBA() { return getFarmsMeasuredTotal("agents", PARTNER_AIS_BA); }
        public String getAgentFarmsMeasuredTotalForAISUE() { return getFarmsMeasuredTotal("agents", PARTNER_AIS_UE); }
        public String getAgentFarmsMeasuredTotalForAISUW() { return getFarmsMeasuredTotal("agents", PARTNER_AIS_UW); }
        public String getAgentFarmsMeasuredTotalForAISNR() { return getFarmsMeasuredTotal("agents", PARTNER_AIS_NR); }
        public String getAgentFarmsMeasuredTotalForAISVR() { return getFarmsMeasuredTotal("agents", PARTNER_AIS_VR); }

        public String getAgentFarmsAssessedTotalForACDI() { return getFarmsAssessedTotal("agents", PARTNER_ACDI); }
        public String getAgentFarmsAssessedTotalForMOFA() { return getFarmsAssessedTotal("agents", PARTNER_MOFA); }
        public String getAgentFarmsAssessedTotalForCIF() { return getFarmsAssessedTotal("agents", PARTNER_CIF); }
        public String getAgentFarmsAssessedTotalForGF() { return getFarmsAssessedTotal("agents", PARTNER_GF); }
        public String getAgentFarmsAssessedTotalForAISBA() { return getFarmsAssessedTotal("agents", PARTNER_AIS_BA); }
        public String getAgentFarmsAssessedTotalForAISUE() { return getFarmsAssessedTotal("agents", PARTNER_AIS_UE); }
        public String getAgentFarmsAssessedTotalForAISUW() { return getFarmsAssessedTotal("agents", PARTNER_AIS_UW); }
        public String getAgentFarmsAssessedTotalForAISNR() { return getFarmsAssessedTotal("agents", PARTNER_AIS_NR); }
        public String getAgentFarmsAssessedTotalForAISVR() { return getFarmsAssessedTotal("agents", PARTNER_AIS_VR); }

        public String getAgentPPProgressForACDI() { return getPPProgress("agents", PARTNER_ACDI); }
        public String getAgentPPProgressForMOFA() { return getPPProgress("agents", PARTNER_MOFA); }
        public String getAgentPPProgressForCIF() { return getPPProgress("agents", PARTNER_CIF); }
        public String getAgentPPProgressForGF() { return getPPProgress("agents", PARTNER_GF); }
        public String getAgentPPProgressForAISBA() { return getPPProgress("agents", PARTNER_AIS_BA); }
        public String getAgentPPProgressForAISUE() { return getPPProgress("agents", PARTNER_AIS_UE); }
        public String getAgentPPProgressForAISUW() { return getPPProgress("agents", PARTNER_AIS_UW); }
        public String getAgentPPProgressForAISNR() { return getPPProgress("agents", PARTNER_AIS_NR); }
        public String getAgentPPProgressForAISVR() { return getPPProgress("agents", PARTNER_AIS_VR); }

        public String getAgentFMPProgressForACDI() { return getFMPProgress("agents", PARTNER_ACDI); }
        public String getAgentFMPProgressForMOFA() { return getFMPProgress("agents", PARTNER_MOFA); }
        public String getAgentFMPProgressForCIF() { return getFMPProgress("agents", PARTNER_CIF); }
        public String getAgentFMPProgressForGF() { return getFMPProgress("agents", PARTNER_GF); }
        public String getAgentFMPProgressForAISBA() { return getFMPProgress("agents", PARTNER_AIS_BA); }
        public String getAgentFMPProgressForAISUE() { return getFMPProgress("agents", PARTNER_AIS_UE); }
        public String getAgentFMPProgressForAISUW() { return getFMPProgress("agents", PARTNER_AIS_UW); }
        public String getAgentFMPProgressForAISNR() { return getFMPProgress("agents", PARTNER_AIS_NR); }
        public String getAgentFMPProgressForAISVR() { return getFMPProgress("agents", PARTNER_AIS_VR); }

        public String getAgentFMPUpdateProgressForACDI() { return getFMPUpdateProgress("agents", PARTNER_ACDI); }
        public String getAgentFMPUpdateProgressForMOFA() { return getFMPUpdateProgress("agents", PARTNER_MOFA); }
        public String getAgentFMPUpdateProgressForCIF() { return getFMPUpdateProgress("agents", PARTNER_CIF); }
        public String getAgentFMPUpdateProgressForGF() { return getFMPUpdateProgress("agents", PARTNER_GF); }
        public String getAgentFMPUpdateProgressForAISBA() { return getFMPUpdateProgress("agents", PARTNER_AIS_BA); }
        public String getAgentFMPUpdateProgressForAISUE() { return getFMPUpdateProgress("agents", PARTNER_AIS_UE); }
        public String getAgentFMPUpdateProgressForAISUW() { return getFMPUpdateProgress("agents", PARTNER_AIS_UW); }
        public String getAgentFMPUpdateProgressForAISNR() { return getFMPUpdateProgress("agents", PARTNER_AIS_NR); }
        public String getAgentFMPUpdateProgressForAISVR() { return getFMPUpdateProgress("agents", PARTNER_AIS_VR); }

        public String getAgentFarmsMeasuredProgressForACDI() { return getFarmsMeasuredProgress("agents", PARTNER_ACDI); }
        public String getAgentFarmsMeasuredProgressForMOFA() { return getFarmsMeasuredProgress("agents", PARTNER_MOFA); }
        public String getAgentFarmsMeasuredProgressForCIF() { return getFarmsMeasuredProgress("agents", PARTNER_CIF); }
        public String getAgentFarmsMeasuredProgressForGF() { return getFarmsMeasuredProgress("agents", PARTNER_GF); }
        public String getAgentFarmsMeasuredProgressForAISBA() { return getFarmsMeasuredProgress("agents", PARTNER_AIS_BA); }
        public String getAgentFarmsMeasuredProgressForAISUE() { return getFarmsMeasuredProgress("agents", PARTNER_AIS_UE); }
        public String getAgentFarmsMeasuredProgressForAISUW() { return getFarmsMeasuredProgress("agents", PARTNER_AIS_UW); }
        public String getAgentFarmsMeasuredProgressForAISNR() { return getFarmsMeasuredProgress("agents", PARTNER_AIS_NR); }
        public String getAgentFarmsMeasuredProgressForAISVR() { return getFarmsMeasuredProgress("agents", PARTNER_AIS_VR); }

        public String getAgentFarmsAssessedProgressForACDI() { return getFarmsAssessedProgress("agents", PARTNER_ACDI); }
        public String getAgentFarmsAssessedProgressForMOFA() { return getFarmsAssessedProgress("agents", PARTNER_MOFA); }
        public String getAgentFarmsAssessedProgressForCIF() { return getFarmsAssessedProgress("agents", PARTNER_CIF); }
        public String getAgentFarmsAssessedProgressForGF() { return getFarmsAssessedProgress("agents", PARTNER_GF); }
        public String getAgentFarmsAssessedProgressForAISBA() { return getFarmsAssessedProgress("agents", PARTNER_AIS_BA); }
        public String getAgentFarmsAssessedProgressForAISUE() { return getFarmsAssessedProgress("agents", PARTNER_AIS_UE); }
        public String getAgentFarmsAssessedProgressForAISUW() { return getFarmsAssessedProgress("agents", PARTNER_AIS_UW); }
        public String getAgentFarmsAssessedProgressForAISNR() { return getFarmsAssessedProgress("agents", PARTNER_AIS_NR); }
        public String getAgentFarmsAssessedProgressForAISVR() { return getFarmsAssessedProgress("agents", PARTNER_AIS_VR); }
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Community Info">
        public String getCommunityRegistrationSparkline() { return getRegistrationSparkline("communities"); }
        public String getCommunityRegistrationTotal() { return getRegistrationTotal("communities"); }
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Other Info">
        public String getFarmMeasuredTotal() {
            int sum = Integer.valueOf(getFarmerFarmsMeasuredTotalForACDI())
                    + Integer.valueOf(getFarmerFarmsMeasuredTotalForMOFA())
                    + Integer.valueOf(getFarmerFarmsMeasuredTotalForCIF())
                    + Integer.valueOf(getFarmerFarmsMeasuredTotalForGF())
                    + Integer.valueOf(getFarmerFarmsMeasuredTotalForAISBA())
                    + Integer.valueOf(getFarmerFarmsMeasuredTotalForAISUE())
                    + Integer.valueOf(getFarmerFarmsMeasuredTotalForAISUW())
                    + Integer.valueOf(getFarmerFarmsMeasuredTotalForAISNR())
                    + Integer.valueOf(getFarmerFarmsMeasuredTotalForAISVR());
            return String.valueOf(sum);
        }

        public String getFarmAssessedTotal() {
            int sum = Integer.valueOf(getFarmerFarmsAssessedTotalForACDI())
                    + Integer.valueOf(getFarmerFarmsAssessedTotalForMOFA())
                    + Integer.valueOf(getFarmerFarmsAssessedTotalForCIF())
                    + Integer.valueOf(getFarmerFarmsAssessedTotalForGF())
                    + Integer.valueOf(getFarmerFarmsAssessedTotalForAISBA())
                    + Integer.valueOf(getFarmerFarmsAssessedTotalForAISUE())
                    + Integer.valueOf(getFarmerFarmsAssessedTotalForAISUW())
                    + Integer.valueOf(getFarmerFarmsAssessedTotalForAISNR())
                    + Integer.valueOf(getFarmerFarmsAssessedTotalForAISVR());
            return String.valueOf(sum);
        }

        public List<String> getCrops() {
            String cql = "MATCH (f:FARMER) MATCH (f)-[:HAS_PRODUCTION]-(p) RETURN DISTINCT p.crop_to_cultivate_current AS c ORDER BY c";
            List<String> crops = new ArrayList<>();

            try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
                Result result = Neo4jServices.executeCypherQuery(cql);
                while (result.hasNext()) {
                    Map<String, Object> c = result.next();
                    crops.add(WordUtils.capitalizeFully((String) c.get("c")));
                }
                trx.success();
            } catch (Exception e) {
                System.out.println("Error pulling crops data from Neo4j: " + e.getMessage());
                e.printStackTrace();
            }

            return crops;
        }

        public List<String> getLocations() {
            String cql = "MATCH (f:FARMER) WHERE f.region is not null RETURN DISTINCT lower(f.region) AS r ORDER BY r";
            List<String> locations = new ArrayList<>();

            try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
                Result result = Neo4jServices.executeCypherQuery(cql);
                while (result.hasNext()) {
                    Map<String, Object> r = result.next();
                    locations.add(WordUtils.capitalizeFully((String) r.get("r")));
                }
                trx.success();
            } catch (Exception e) {
                System.out.println("Error pulling locations data from Neo4j: " + e.getMessage());
                e.printStackTrace();
            }

            return locations;
        }
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Helpers">
        private String getRegistrationTotal(String o) {
            return (String) data.getJSONObject(o).getJSONObject("registration").get("total");
        }
        private String getRegistrationTotal(String o, String partner) {
            return (String) data.getJSONObject(o).getJSONObject("registration").getJSONObject(partner).get("total");
        }
        private String getRegistrationProgress(String o, String partner) {
            return (String) data.getJSONObject(o).getJSONObject("registration").getJSONObject(partner).get("progress");
        }
        private String getRegistrationTarget(String o, String partner) {
            return (String) data.getJSONObject(o).getJSONObject("registration").getJSONObject(partner).get("target");
        }
        private String getRegistrationSparkline(String o) {
            return (String) data.getJSONObject(o).getJSONObject("registration").get("sparkline");
        }
        private String getRegistrationEChartLineData(String o, String attr) {
            return (String) data.getJSONObject(o).getJSONObject("registration").getJSONObject("chart_line").get(attr);
        }

        private String getPPTotal(String o, String partner) {
            return (String) data.getJSONObject(o).getJSONObject("previous_performance").getJSONObject(partner).get("total");
        }
        private String getPPProgress(String o, String partner) {
            return (String) data.getJSONObject(o).getJSONObject("previous_performance").getJSONObject(partner).get("progress");
        }
        private String getFMPTotal(String o, String partner) {
            return (String) data.getJSONObject(o).getJSONObject("fmp").getJSONObject(partner).get("total");
        }
        private String getFMPProgress(String o, String partner) {
            return (String) data.getJSONObject(o).getJSONObject("fmp").getJSONObject(partner).get("progress");
        }
        private String getFMPUpdateTotal(String o, String partner) {
            return (String) data.getJSONObject(o).getJSONObject("fmp_update").getJSONObject(partner).get("total");
        }
        private String getFMPUpdateProgress(String o, String partner) {
            return (String) data.getJSONObject(o).getJSONObject("fmp_update").getJSONObject(partner).get("progress");
        }
        private String getFarmsMeasuredTotal(String o, String partner) {
            return (String) data.getJSONObject(o).getJSONObject("farms").getJSONObject(partner).get("measured_total");
        }
        private String getFarmsMeasuredProgress(String o, String partner) {
            return (String) data.getJSONObject(o).getJSONObject("farms").getJSONObject(partner).get("measured_progress");
        }
        private String getFarmsAssessedTotal(String o, String partner) {
            return (String) data.getJSONObject(o).getJSONObject("farms").getJSONObject(partner).get("assessed_total");
        }
        private String getFarmsAssessedProgress(String o, String partner) {
            return (String) data.getJSONObject(o).getJSONObject("farms").getJSONObject(partner).get("assessed_progress");
        }

        // </editor-fold>
    }

    private static class IndicatorManager {

        protected String indicator;
        public static IndicatorManager instance;

        public static IndicatorManager getInstance (String indicator) {
            instance = new IndicatorManager(indicator);
            return instance;
        }
        protected IndicatorManager(String i) {
            indicator = (i==null) ? "all" : i;
        }

        public HashMap<String, String> update() throws Exception {
            HashMap<String, String> response = new HashMap<>();
            try {
                if (indicator.equals("all")) {
                    response.put(UPDATE_AGENT_INFO, ((updateTables(UPDATE_AGENT_INFO) ? OK : FAILED)));
                    response.put(UPDATE_COMMUNITY_INFO, ((updateTables(UPDATE_COMMUNITY_INFO) ? OK : FAILED)));
                    response.put(UPDATE_FARMER_INFO, ((updateTables(UPDATE_FARMER_INFO) ? OK : FAILED)));
                    response.put(UPDATE_FINANCIAL_INFO, ((updateTables(UPDATE_FINANCIAL_INFO) ? OK : FAILED)));
                } else {
                    response.put(indicator, ((updateTables(indicator) ? OK : FAILED)));
                }
            } catch (Exception e) {
                throw(e);
            }

            return response;
        }

        public String getTotalData() throws Exception {
            String total = "0";

            try {
                String sql = "SELECT SUM(actual) AS total FROM " + getIndicatorTable(indicator);
                ResultSet rs = ICTCDBUtil.getInstance().runSQLSelect(sql);
                rs.next();
                total =  rs.getString(rs.findColumn("total"));
            } catch (Exception e) {
                throw(e);
            }

            return total;
        }

        public JSONObject getPartnerRegistrationData(String partner) throws Exception {
            JSONObject x = new JSONObject();
            x.put("target", 0);
            x.put("total", 0);
            x.put("progress", 0);

            try {
                String targetCol = partner + ((indicator.equals(INDICATOR_AGENT)) ? "_AGENT_TARGET" : "_FARMER_TARGET");
                String sql =  "SELECT IFNULL(SUM(actual), 0) as total "
                            + "       , IFNULL(i.value,0) as target"
                            + "       , CEILING(IF(i.value is null OR SUM(actual) is null,0,(SUM(actual) / i.value)*100)) as progress"
                            + "  FROM " + getIndicatorTable(indicator)
                            + " RIGHT JOIN bi_info i ON i.property = '"+ targetCol + "'"
                            + " WHERE partner = '"+ partner + "'";
                ResultSet rs = ICTCDBUtil.getInstance().runSQLSelect(sql);
                rs.next();
                x.put("target", rs.getString(rs.findColumn("target")));
                x.put("total", rs.getString(rs.findColumn("total")));
                x.put("progress", rs.getString(rs.findColumn("progress")));

            } catch(Exception e) {
                throw(e);
            }

            return x;
        }

        public JSONObject getPartnerFMPData(String partner) throws Exception {
            try {
                return getPartnerData(partner, "fmp");
            } catch(Exception e) {
                throw(e);
            }
        }

        public JSONObject getPartnerPPData(String partner) throws Exception {
            try {
                return getPartnerData(partner, "pp");
            } catch(Exception e) {
                throw(e);
            }
        }

        public JSONObject getPartnerFMPUpdateData(String partner) throws Exception {
            try {
                return getPartnerData(partner, "fmp_update");
            } catch(Exception e) {
                throw(e);
            }
        }

        public JSONObject getPartnerFarmsData(String partner) throws Exception {
            try {
                JSONObject m = getPartnerData(partner, "measured");
                JSONObject y = getPartnerData(partner, "assessed");
                JSONObject x = new JSONObject();
                x.put("measured_total", m.get("total"));
                x.put("measured_progress", m.get("progress"));
                x.put("assessed_total", y.get("total"));
                x.put("assessed_progress", y.get("progress"));
                return x;
            } catch(Exception e) {
                throw(e);
            }
        }

        public JSONObject getEChartLineData() throws Exception {
            JSONObject x = new JSONObject();
            x.put("legend", "[]");
            x.put("xAxis", "[]");
            x.put("series", "{}");

            HashMap<String, String[]> series_data = new HashMap<>();
            String series_tpl = "{name: 'PARTNER', type: 'line', smooth: true, itemStyle: { normal: { areaStyle: { type: 'default' } } }, data: [DATA] },";

            //String[] defValues = new String[getNumOfAxisMonths()];
            //Arrays.fill(defValues,"0");

            try {
                for(String p : PARTNERS) { series_data.put(p, new String[getNumOfAxisMonths()]); }

                String sql = "SELECT d.partner as p, d.y as `year` "
                        + ", SUM(IF(d.m=1,s,0)) as Jan"
                        + ", SUM(IF(d.m=2,s,0)) as Feb"
                        + ", SUM(IF(d.m=3,s,0)) as Mar"
                        + ", SUM(IF(d.m=4,s,0)) as Apr"
                        + ", SUM(IF(d.m=5,s,0)) as May"
                        + ", SUM(IF(d.m=6,s,0)) as Jun"
                        + ", SUM(IF(d.m=7,s,0)) as Jul"
                        + ", SUM(IF(d.m=8,s,0)) as Aug"
                        + ", SUM(IF(d.m=9,s,0)) as Sep"
                        + ", SUM(IF(d.m=10,s,0)) as Oct"
                        + ", SUM(IF(d.m=11,s,0)) as Nov"
                        + ", SUM(IF(d.m=12,s,0)) as `Dec`"
                        + " FROM (SELECT partner, `year` y, `month` m, sum(actual) s"
                        + "         FROM " + getIndicatorTable(indicator)
                        + "         WHERE `year` >= YEAR(NOW()) - 1"
                        + "         GROUP BY partner, `year`, `month`) d"
                        + " GROUP BY d.partner, d.y"
                        + " ORDER BY d.partner, d.y";
                ResultSet rs = ICTCDBUtil.getInstance().runSQLSelect(sql);

                while (rs.next()) {
                        String partner = rs.getString(rs.findColumn("p"));
                        int year = rs.getInt(rs.findColumn("year"));
                        String[] d = series_data.get(partner);
                        System.out.println("Feb for "+partner+" is currently "+ d[getYearMonthIdx(year, 2)]);
                        System.out.println("Feb for "+partner+" is updating to "+rs.getString(rs.findColumn("Feb")));
                        d[getYearMonthIdx(year, 1)] = rs.getString(rs.findColumn("Jan"));
                        //d[getYearMonthIdx(year, 2)] = rs.getString(rs.findColumn("Feb"));
                        d[getYearMonthIdx(year, 4)] = rs.getString(rs.findColumn("Mar"));
                        d[getYearMonthIdx(year, 5)] = rs.getString(rs.findColumn("Apr"));
                        d[getYearMonthIdx(year, 5)] = rs.getString(rs.findColumn("May"));
                        d[getYearMonthIdx(year, 6)] = rs.getString(rs.findColumn("Jun"));
                        d[getYearMonthIdx(year, 7)] = rs.getString(rs.findColumn("Jul"));
                        d[getYearMonthIdx(year, 8)] = rs.getString(rs.findColumn("Aug"));
                        d[getYearMonthIdx(year, 9)] = rs.getString(rs.findColumn("Sep"));
                        d[getYearMonthIdx(year, 10)] = rs.getString(rs.findColumn("Oct"));
                        d[getYearMonthIdx(year, 11)] = rs.getString(rs.findColumn("Nov"));
                        d[getYearMonthIdx(year, 12)] = rs.getString(rs.findColumn("Dec"));
                        series_data.put(partner, d);
                        series_data.get(partner)[getYearMonthIdx(year, 2)] = rs.getString(rs.findColumn("Feb"));
                        System.out.println("Feb for "+partner+" is now "+ (series_data.get(partner))[1]);
                }

                String series = "";
                Iterator it = series_data.entrySet().iterator();
                while(it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    series += series_tpl.replace("PARTNER", ((String)pair.getKey())).replace("DATA", String.join(",", ((String[])pair.getValue())));
                    it.remove();
                }
                x.put("legend", "['" + String.join("', '", PARTNERS) + "']");
                x.put("xAxis", "['"+String.join("','", getYearMonthAxisValues())+"']");
                x.put("series", "[" + series + "]");
            } catch(Exception e) {
                throw(e);
            }

            return x;
        }

        public String getSparkLineData() throws Exception {
            String data = "0,0,0,0,0,0,0,0,0,0,0,0";

            try {
                String sql = "SELECT d.y as `year` "
                        + ", SUM(IF(d.m=1,s,0)) as Jan"
                        + ", SUM(IF(d.m=2,s,0)) as Feb"
                        + ", SUM(IF(d.m=3,s,0)) as Mar"
                        + ", SUM(IF(d.m=4,s,0)) as Apr"
                        + ", SUM(IF(d.m=5,s,0)) as May"
                        + ", SUM(IF(d.m=6,s,0)) as Jun"
                        + ", SUM(IF(d.m=7,s,0)) as Jul"
                        + ", SUM(IF(d.m=8,s,0)) as Aug"
                        + ", SUM(IF(d.m=9,s,0)) as Sep"
                        + ", SUM(IF(d.m=10,s,0)) as Oct"
                        + ", SUM(IF(d.m=11,s,0)) as Nov"
                        + ", SUM(IF(d.m=12,s,0)) as `Dec`"
                        + " FROM (SELECT `year` y, `month` m, sum(actual) s"
                        + "         FROM " + getIndicatorTable(indicator)
                        + "         WHERE `year` >= YEAR(NOW()) - 1"
                        + "         GROUP BY `year`, `month`) d"
                        + " GROUP BY d.y"
                        + " ORDER BY d.y";
                ResultSet rs = ICTCDBUtil.getInstance().runSQLSelect(sql);

                int year = getCurrentYear();
                while (rs.next()) {
                    if (year == rs.getInt(rs.findColumn("year"))) {
                        data = rs.getString(rs.findColumn("Jan")) + ",";
                        data += rs.getString(rs.findColumn("Feb")) + ",";
                        data += rs.getString(rs.findColumn("Mar")) + ",";
                        data += rs.getString(rs.findColumn("Apr")) + ",";
                        data += rs.getString(rs.findColumn("May")) + ",";
                        data += rs.getString(rs.findColumn("Jun")) + ",";
                        data += rs.getString(rs.findColumn("Jul")) + ",";
                        data += rs.getString(rs.findColumn("Aug")) + ",";
                        data += rs.getString(rs.findColumn("Sep")) + ",";
                        data += rs.getString(rs.findColumn("Oct")) + ",";
                        data += rs.getString(rs.findColumn("Nov")) + ",";
                        data += rs.getString(rs.findColumn("Dec"));
                        return data;
                    }
                }
            } catch (Exception e) {
                throw(e);
            }

            return data;
        }


        // Helpers
        private boolean updateTables(String updateKey) {

            try {
                String cql = getUpdateCQL(updateKey);

                if (cql.equals("")) {
                    System.out.println("Error pulling data from Neo4j: invalid update Key name");
                    return false;

                } else {
                    HashMap<String, SQLRowObj> farmers = new HashMap<>();
                    HashMap<String, SQLRowObj> agents = new HashMap<>();
                    HashMap<String, SQLRowObj> communities = new HashMap<>();
                    HashMap<String, SQLRowObj> farms = new HashMap<>();

                    try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
                        Result result = Neo4jServices.executeCypherQuery(cql);
                        ResourceIterator ri = result.columnAs("info");

                        int count = 0;

                        while (ri.hasNext()) {

                            if (updateKey.equals(UPDATE_AGENT_INFO)) {
                                CQLAgentRowObj row = convertResultToCQLAgentObj(ri.next());
                                ArrayList<Integer> yMS = (row.code.startsWith("AG"))
                                                        ? getDateFromCode(row.code)
                                                        : getDateFromTime(Long.valueOf(row.lmd));

                                SQLRowObj objAgents = new SQLRowObj();
                                objAgents.year = yMS.get(0);
                                objAgents.month = yMS.get(1);
                                objAgents.partner = row.partner;
                                agents = updateHashMap(agents, objAgents.id(TABLE_AGENT), objAgents);

                            } else if (updateKey.equals(UPDATE_COMMUNITY_INFO)) {
                                CQLCommunityRowObj row = convertResultToCQLCommunityObj(ri.next());
                                ArrayList<Integer> yMS = getDateFromTime(Long.valueOf(row.lmd));

                                SQLRowObj objComms = new SQLRowObj();
                                objComms.year = yMS.get(0);
                                objComms.month = yMS.get(1);
                                communities = updateHashMap(communities, objComms.id(TABLE_COMMUNITY), objComms);

                            } else if (updateKey.equals(UPDATE_FARMER_INFO)) {
                                CQLFarmerRowObj row = convertResultToCQLFarmerObj(ri.next());
                                ArrayList<Integer> yMS = getDateFromTime(Long.valueOf(row.lmd));

                                SQLRowObj objFarmer = new SQLRowObj();
                                objFarmer.year = yMS.get(0);
                                objFarmer.month = yMS.get(1);
                                objFarmer.partner = row.partner;
                                objFarmer.community = row.community;
                                farmers = updateHashMap(farmers, objFarmer.id(TABLE_FARMER),  objFarmer);

                                SQLRowObj objFarms = new SQLRowObj();
                                objFarms.year = yMS.get(0);
                                objFarms.month = yMS.get(1);
                                objFarms.season = row.planned_season; // season
                                objFarms.farmer_id = row.farmerId;
                                objFarms.acres_planned = row.planned_acres;
                                objFarms.acres_actual = row.actual_acres;
                                objFarms.yield_planned = row.planned_yield;
                                objFarms.yield_actual = row.actual_yield;
                                // TODO: get crop, year later
                                // TODO: get age, gender for later
                                // TODO: get lat, long later
                                farms.put(objFarms.id(TABLE_FARM), objFarms);

                                count++;

                            } else if (updateKey.equals(UPDATE_AGENT_INFO)) {
                            } else if (updateKey.equals(UPDATE_COMMUNITY_INFO)) {
                            } else if (updateKey.equals(UPDATE_FINANCIAL_INFO)) {
                            }
                        }
                        System.out.println("Number of farmers: "+ count);

                        trx.success();
                    } catch (Exception e) {
                        System.out.println("Error pulling data from Neo4j: " + e.getMessage());
                        e.printStackTrace();
                    }

                    // Insert data into MySQL
                    if (updateKey.equals(UPDATE_FARMER_INFO)) {
                        runUpdates(TABLE_FARMER, farmers);
                        runUpdates(TABLE_FARM, farms);
                    } else if (updateKey.equals(UPDATE_AGENT_INFO)) {
                        runUpdates(TABLE_AGENT, agents);
                    } else if (updateKey.equals(UPDATE_COMMUNITY_INFO)) {
                        runUpdates(TABLE_COMMUNITY, communities);
                    } else {
                    }

                    return true;
                }

            } catch (SQLException e){
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
            return false;
        }

        private HashMap<String, SQLRowObj> updateHashMap(HashMap<String, SQLRowObj> data, String key, SQLRowObj object) {
            SQLRowObj obj = object;
            if (data.containsKey(key)) {
                data.get(key).actual++;
            } else {
                obj.actual = 1;
                data.put(key, obj);
            }
            return data;
        }

        private void runUpdates(String tableName, HashMap<String, SQLRowObj> data) throws Exception{
            try {
                if (data.size() > 0) {
                    System.out.println("Running updates for "+tableName);
                    ICTCDBUtil.getInstance().emptyTable(tableName);
                    for (SQLRowObj r : data.values()) {
                        String sql = "INSERT INTO " + tableName + " (" + r.fields(tableName) + ") VALUES " + r.values(tableName);
                        ICTCDBUtil.getInstance().runSQLUpdate(sql);
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error updating table '" + tableName + "': " + e.getMessage());
                throw(e);
            } catch (Exception e) {
                throw(e);
            }
        }

        private JSONObject getPartnerData(String partner, String field) throws Exception {
            JSONObject x = new JSONObject();
            x.put("total", 0);
            x.put("progress", 0);

            try {
                String targetCol = partner + ((indicator.equals(INDICATOR_AGENT)) ? "_AGENT_TARGET" : "_FARMER_TARGET");
                String sql =  (indicator.equals(INDICATOR_AGENT))
                        ?   "SELECT COUNT(t.agent_id) as total "
                           + "    , IFNULL(i.value,0) as target "
                           + "    , CEILING(IF(i.value is null or COUNT(t.agent_id)=0,0,((COUNT(t.agent_id) / i.value)*100))) as progress"
                           + " FROM (SELECT agent_id, IFNULL(SUM("+field+"), 0) as done FROM "+ TABLE_FARM +
                             "        WHERE partner = '"+partner+"' GROUP BY agent_id HAVING (done > 50 )) t "
                           + " JOIN bi_info i ON i.property = '"+ targetCol +"'"

                        : "SELECT IFNULL(SUM("+field+"), 0) as total "
                            + "       , IFNULL(i.value,0) as target"
                            + "       , CEILING(IF(i.value is null OR SUM("+field+") is null,0,(SUM("+field+") / i.value)*100)) as progress"
                            + "  FROM " + TABLE_FARM
                            + " RIGHT JOIN bi_info i ON i.property = '"+ targetCol + "'"
                            + " WHERE partner = '"+ partner + "'";
                ResultSet rs = ICTCDBUtil.getInstance().runSQLSelect(sql);
                rs.next();
                x.put("target", rs.getString(rs.findColumn("target")));
                x.put("total", rs.getString(rs.findColumn("total")));
                x.put("progress", rs.getString(rs.findColumn("progress")));

            } catch(Exception e) {
                throw(e);
            }

            return x;
        }

        private String getIndicatorTable(String ind) throws Exception {
            switch (ind) {
                case INDICATOR_AGENT: return TABLE_AGENT;
                case INDICATOR_COMMUNITY: return TABLE_COMMUNITY;
                case INDICATOR_FARMER: return TABLE_FARMER;
                case INDICATOR_COSTS: return TABLE_FIN_COST;
                case INDICATOR_CREDIT: return TABLE_FIN_CREDIT;
                case INDICATOR_PAYMENT: return TABLE_FIN_PAYMENT;
                case INDICATOR_REVENUE: return TABLE_FIN_REVENUE;
                case INDICATOR_FARM: return TABLE_FARM;
                default:
                    throw new Exception("Invalid indicator");
            }
        }

        private String getUpdateCQL(String indicator) {
            switch(indicator) {
                case UPDATE_AGENT_INFO: return "MATCH (a:AGENT) return { code: a.agentcode, partner: a.agenttype, lmd: a.lastModifieddate} as info;";
                case UPDATE_COMMUNITY_INFO: return "MATCH (f:FARMER) WITH lower(replace(f.village,\",\",\"\")) as v, MIN(f.lastModifieddate) as d RETURN { community: v, lmd: d} as info;";
                case UPDATE_FARMER_INFO: return
                "MATCH (f:FARMER) " +
                "OPTIONAL MATCH (f)-[:HAS_PRODUCTION]-(pc) " +
                "WITH f, MAX(pc.lastModifieddate) as maxp " +
                "OPTIONAL MATCH (f)-[:HAS_PRODUCTION]-(p) WHERE p.lastModifieddate >= maxp " +
                "WITH f,p " +
                "OPTIONAL MATCH (p)-[:UPDATE]-(u) " +
                "WITH f,p,MAX(u.lastModifieddate) as maxPUpdate " +
                "OPTIONAL MATCH (p)-[:UPDATE]-(u) WHERE u.lastModifieddate >= maxPUpdate " +
                "WITH f,p,u " +
                "OPTIONAL MATCH (f)-[:HAS_POSTHARVEST]-(h) " +
                "WITH f,p,u,MAX(h.lastModifieddate) as maxPH " +
                "OPTIONAL MATCH(f)-[:HAS_POSTHARVEST]-(h) WHERE h.lastModifieddate >= maxPH " +
                "OPTIONAL MATCH (h)-[:UPDATE]-(z) " +
                "WITH f,p,u,h,MAX(z.lastModifieddate) as maxPHdate " +
                "OPTIONAL MATCH (h)-[:UPDATE]-(z) WHERE z.lastModifieddate >= maxPHdate " +
                "WITH f,p,u,h,z " +
                "MATCH (a:AGENT) WHERE a.Id = f.CreatedById " +
                "RETURN {  lmd: f.lastModifieddate " +
                "        , farmerId: f.Id " +
                "        , demo: collect({gender: f.gender, age:f.age}) " +
                "        , community: lower(replace(f.village,\",\",\"\")) " +
                "        , agent: a.Id  " +
                "        , partner: a.agenttype  " +
                "        , planned: CASE WHEN p IS NOT NULL THEN collect({year: p.reference_year_current, " +
                "                                                         season: p.reference_season_current, " +
                "                                                         crop: p.crop_to_cultivate_current, " +
                "                                                         acres: p.acresofland, " +
                "                                                         yield:p.targetyieldperacre}) " +
                "                   ELSE NULL END " +
                "        , actual: CASE WHEN u IS NOT NULL THEN collect({acres: u.landareacultivatedupdate, " +
                "                                                        lat:u.gpslocationplanpdupdate__Latitude, " +
                "                                                        long:u.gpslocationplanpdupdate__Longitude}) " +
                "                  ELSE NULL END " +
                "        , postharvest: CASE WHEN z IS NOT NULL THEN collect({ yield: z.total_yield_update }) " +
                "                       ELSE NULL END " +
                "} as info";

                case UPDATE_FINANCIAL_INFO: return "";
                default: return "";
            }
        }

        private CQLAgentRowObj convertResultToCQLAgentObj(Object row) {
            CQLAgentRowObj y = null;
            JSONObject x = getJSONFromRow(row);
            if (x != null) {
                y = new CQLAgentRowObj();
                y.code = getValue(x, "", "code","");
                y.partner = getValue(x, "", "partner","");
                y.lmd = getValue(x, "", "lmd","1457518321908");
            }
            return y;
        }

        private CQLCommunityRowObj convertResultToCQLCommunityObj(Object row) {
            CQLCommunityRowObj y = null;
            JSONObject x = getJSONFromRow(row);
            if (x != null) {
                y = new CQLCommunityRowObj();
                y.community = getValue(x, "", "community","");
                y.lmd = getValue(x, "", "lmd","1457518321908");
            }
            return y;
        }

        private CQLFarmerRowObj convertResultToCQLFarmerObj(Object row) {
            CQLFarmerRowObj y = null;

            JSONObject x = getJSONFromRow(row);

            if (x != null) {
                y = new CQLFarmerRowObj();
                y.lmd = getValue(x, "", "lmd","1457518321908");
                y.agent = getValue(x, "", "agent","");
                y.farmerId = getValue(x, "", "farmerId","");
                y.partner = getValue(x, "", "partner","");
                y.community = getValue(x, "", "community","");

                y.planned_year = getValue(x, "planned", "year", "2016");
                y.planned_yield = getValue(x, "planned", "yield", "0");
                y.planned_season = getValue(x, "planned", "season", "");
                y.planned_acres = getValue(x, "planned", "acres", "0");
                y.planned_crop = getValue(x, "planned", "crop", "");

                y.actual_yield = getValue(x, "postharvest", "yield", "0");
                y.actual_acres = getValue(x, "actual", "acres", "0");
                y.actual_lat = getValue(x, "actual", "lat", "0");
                y.actual_long = getValue(x, "actual", "long", "0");

                y.demo_age = getValue(x, "demo", "age", "0");
                y.demo_gender = getValue(x, "demo", "gender", "");
            }

            return y;
        }

        private static JSONObject getJSONFromRow(Object row) {
                try {
                    String rowAsString = row.toString();
                    rowAsString = rowAsString.replace("=" , "\":\"").replace("," , "\",").replace("[" , "").replace("]" , "");
                    rowAsString = rowAsString.replace("{" , "{\"").replace("}" , "\"}").replace(", " , ", \"");
                    rowAsString = rowAsString.replace("\"{" , "{").replace("}\"" , "}");
                    rowAsString = rowAsString.replace("\"null\"" , "null");
                    rowAsString = rowAsString.replace(" {"," odd:{");
                    return new JSONObject(rowAsString);
                } catch (JSONException e) {
                    System.out.println("Row object: " + row.toString());
                    e.printStackTrace();
                }

                return null;
        }

        private static String getValue(JSONObject x, String parent, String child, String defValue) {
            String v=defValue;

            if (!parent.equals("")) {
                try {
                    if (x.has(parent)) {
                        JSONObject o = x.getJSONObject(parent);
                        if (o != null) {
                            return getValue(o, "" , child, defValue);
                        }
                    } else {
                        v = defValue;
                    }
                } catch(Exception e) {
                    v=defValue;
                }
            } else {
                try {
                    if (x.has(child)) {
                        v = (x.get(child) == null) ? defValue : (String) x.get(child);
                    } else {
                        v = defValue;
                    }
                } catch (Exception e) {
                    v = defValue;
                }
            }

            return v;
        }

        private static int getCurrentYear() {
            Calendar cal = Calendar.getInstance();
            return cal.get(Calendar.YEAR);
        }

        private static int getNumOfAxisMonths() {
            int year = getCurrentYear();
            int start_year = (year-1 < START_YEAR) ? START_YEAR : (year-1);
            return ((year-start_year)+1) * 12;
        }

        private static int getYearMonthIdx(int year, int month) {
            return ((year-START_YEAR) * 12) + (month-1);
        }

        private static String[] getYearMonthAxisValues() {
            int year = getCurrentYear();
            int start_year = (year-1 < START_YEAR) ? START_YEAR : (year-1);
            String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
            String[] values = new String[getNumOfAxisMonths()];

            int c=0;
            for(int y=start_year; y<=year; y++) {
                for(String m : months) { values[c] = m + " " + y; c++; }
            }
            return values;
        }

        private static ArrayList<Integer> getDateFromCode(String code) {
            ArrayList<Integer> dates = new ArrayList<>();

            try {
                DateFormat format = new SimpleDateFormat("MMM dd HH:mm:ss z yyyy");
                Date date = format.parse(code.substring(3).trim());
                dates = getDateFromTime(date.getTime());
                return dates;
            } catch (Exception e) {
                System.out.println(e);
            }
            return dates;
        }

        private static ArrayList<Integer> getDateFromTime(Long time) {
            ArrayList<Integer> dates = new ArrayList<>();
            Calendar cal = Calendar.getInstance();
            Long t = (time==null) ? 1457518321908L : time;
            cal.setTimeInMillis(t);
            dates.add(cal.get(Calendar.YEAR));
            dates.add(cal.get(Calendar.MONTH));
            return dates;
        }
    }

    private static class CQLAgentRowObj {
        public String lmd;
        public String partner;
        public String code;
    }

    private static class CQLCommunityRowObj {
        public String lmd;
        public String community;
    }

    private static class CQLFarmerRowObj {
        public String lmd;
        public String agent;
        public String community;
        public String farmerId;
        public String partner;
        public String demo_age;
        public String demo_gender;
        public String planned_acres;
        public String planned_yield;
        public String planned_crop;
        public String planned_season;
        public String planned_year;
        public String actual_lat;
        public String actual_long;
        public String actual_acres;
        public String actual_yield;
    }

    private static class SQLRowObj {
        public int year;
        public int month;
        public long actual;
        public String planned;
        public String acres;
        public String acres_planned;
        public String acres_actual;
        public String yield_actual;
        public String yield_planned;
        public String age;
        public String farmer_id;
        public String season;
        public String gender;
        public String farmer_type;
        public String credit_type;
        public String credit_mode;
        public String payment_type;
        public String payment_mode;
        public String partner;
        public String community;

        public String get_year() { return String.valueOf(year); }
        public String get_month() { return String.valueOf(month); }
        public String get_season() { return String.valueOf(season); }
        public String get_planned() { return String.valueOf(planned); }
        public String get_actual() { return String.valueOf(actual); }
        public String get_acres() { return String.valueOf(acres); }
        public String get_acres_planned() { return String.valueOf(acres_planned); }
        public String get_acres_actual() { return String.valueOf(acres_actual); }
        public String get_yield_planned() { return String.valueOf(yield_planned); }
        public String get_yield_actual() { return String.valueOf(yield_actual); }
        public String get_farmer_type() { return farmer_type; }
        public String get_farmer_id() { return String.valueOf(farmer_id); }
        public String get_credit_type() { return credit_type; }
        public String get_credit_mode() { return credit_mode; }
        public String get_payment_type() { return payment_type; }
        public String get_payment_mode() { return payment_mode; }
        public String get_community() { return community; }
        public String get_partner() { return partner; }

        public String id(String tableName) {
            String id = "";
            String common = get_year() + "-" + get_month();
            switch(tableName) {
                case TABLE_AGENT: id = get_partner() + "-" + common; break;
                case TABLE_COMMUNITY: id = common; break;
                case TABLE_FARMER: id = get_community().toLowerCase() + "-" + get_partner() + "-" + common; break;
                case TABLE_FARM: id = get_farmer_id() + "-" + get_season() + "-" + common; break;
                case TABLE_FIN_COST: id = get_farmer_id() + "-" + common ; break;
                case TABLE_FIN_REVENUE: id = get_farmer_id() + "-" + common; break;
                case TABLE_FIN_CREDIT: id = get_farmer_id() + "-" + get_credit_mode() + "-" + get_credit_type() + "-" + common; break;
                case TABLE_FIN_PAYMENT: id = get_farmer_id() + "-" + get_payment_mode() + "-" + get_payment_type() + "-" + common; break;
            }
            return id;
        }

        public String values(String tableName) throws Exception {
            try {
                String[] f = (fields(tableName)).split(",");
                String values = "(";
                for (int i=0; i < f.length; i++) {
                    boolean addComma = (i < f.length-1);
                    values += q(callMethod("get_" + f[i].trim()), addComma);
                }
                values += ");";
                return values;
            } catch (Exception e) {
                System.out.println("Error getting values for "+tableName+": "+e.getLocalizedMessage());
                e.printStackTrace();
                throw(e);
            }
        }

        public String fields(String tableName) {
            String time = "year, month";
            String fields = "actual, " + time;
            String partner = ", partner";
            String community = ", community";
            String farmer = ", farmer_id";
            String season = ", season";
            String acres = ", acres";
            String finc = ", farmer_type, credit_type, credit_mode";
            String finp = ", farmer_type, payment_type, payment_mode";
            String land = ", acres_planned, acres_actual";
            String yield = ", yield_planned, yield_actual";

            switch(tableName) {
                case TABLE_AGENT: fields = fields + partner; break;
                case TABLE_FARMER: fields = fields + partner + community; break;
                case TABLE_FARM: fields = time + land + yield + season + farmer; break;
                case TABLE_FIN_COST: fields = fields + farmer + acres; break;
                case TABLE_FIN_REVENUE: fields = fields + farmer + acres; break;
                case TABLE_FIN_CREDIT: fields = fields + farmer + finc; break;
                case TABLE_FIN_PAYMENT: fields = fields + farmer + finp; break;
            }

            return fields;
        }

        private String callMethod(String methodName) throws Exception {
            try { return (String) this.getClass().getMethod(methodName).invoke(this); }
            catch (SecurityException e) { throw(e); }
            catch (NoSuchMethodException e) { throw(e); }
            catch (IllegalArgumentException e) { throw(e); }
            catch (IllegalAccessException e) { throw(e); }
            catch (InvocationTargetException e) { throw(e); }
        }

        private String q(String val, boolean comma) { return "'" + val + "'" + ((comma) ? ", ":""); }
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="MySQL DB/Table Management">

    public static boolean databaseExist() throws Exception {
        return ICTCDBUtil.getInstance().checkDBExists(null);
    }

    public static void createDatabase() throws Exception {
        ICTCDBUtil.getInstance().createDatabase(null);
    }

    public static boolean tablesExist() throws Exception {
        boolean exists = false;

        try {
            int tblCount = 0;
            ResultSet rs = ICTCDBUtil.getInstance().getMysqlConnection().getMetaData().getTables(null, null, "%", null);
            while (rs.next()) {
                if (TABLES.contains(rs.getString(3))) { tblCount++; }
            }
            exists = (tblCount==TABLES.size());
        } catch (Exception e) {
            throw(e);
        }

        return exists;
    }

    public static void createTables(Boolean fillTables) throws Exception {
        try {
            String time = "year INTEGER, month INTEGER";
            String fields = "actual INTEGER, " + time;
            String partner = ", partner VARCHAR(50)";
            String community = ", community VARCHAR(50)";
            String farmer = ", farmer_id VARCHAR(50)";
            String agent = ", `agent_id` VARCHAR(100) NOT NULL";
            String finc = ", farmer_type VARCHAR(10), credit_type VARCHAR(20), credit_mode VARCHAR(20)";
            String finp = ", farmer_type VARCHAR(10), payment_type VARCHAR(20), payment_mode VARCHAR(20)";

            String crop = ", crop VARCHAR(50)";
            String season = ", season VARCHAR(20)";
            String acres = ", acres INTEGER";
            String land = ", acres_planned INTEGER, acres_actual INTEGER";
            String yield = ", yield_planned INTEGER, yield_actual INTEGER";
            String farmMeta = ", `gender` VARCHAR(10) NULL , `age` INT NULL , `lat` VARCHAR(50) NULL , `long` VARCHAR(50) NULL , `district` VARCHAR(100) NULL , `pp` INT NOT NULL DEFAULT '0' , `fmp` INT NOT NULL DEFAULT '0' , `fmp_update` INT NOT NULL DEFAULT '0' , `measured` INT NOT NULL DEFAULT '0' , `assessed` INT NOT NULL DEFAULT '0'";

            ICTCDBUtil.getInstance().createTable(TABLE_AGENT, fields + partner);
            ICTCDBUtil.getInstance().createTable(TABLE_COMMUNITY, fields);
            ICTCDBUtil.getInstance().createTable(TABLE_FARMER, fields + partner + community);
            ICTCDBUtil.getInstance().createTable(TABLE_FARM, time + land + yield + crop + season + farmer + agent + farmMeta);
            ICTCDBUtil.getInstance().createTable(TABLE_FIN_COST, fields + farmer + acres);
            ICTCDBUtil.getInstance().createTable(TABLE_FIN_REVENUE, fields + farmer + acres);
            ICTCDBUtil.getInstance().createTable(TABLE_FIN_CREDIT, fields + farmer + finc);
            ICTCDBUtil.getInstance().createTable(TABLE_FIN_PAYMENT, fields + farmer + finp);

            if (fillTables) { IndicatorManager.getInstance("all").update(); }
        } catch (Exception e) {
            throw(e);
        }
    }

    // </editor-fold>
}