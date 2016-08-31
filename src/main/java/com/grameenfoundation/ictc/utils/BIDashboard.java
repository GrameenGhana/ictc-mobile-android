package com.grameenfoundation.ictc.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by David on 8/19/2016.
 * Main interface file for dashboards
 */
public class BIDashboard extends BIUtil {

    private final static String TAG = BIDashboard.class.getName();

    private JSONObject data;

    public BIDashboard() { setData(""); }
    public BIDashboard(String dashboard) { setData(dashboard); }

    public JSONObject getData(String data_set, HashMap params) {
        List<String> data = new ArrayList();
        JSONObject response = new JSONObject();
        response.put("data",new JSONArray());

        try {
            if (data_set.equals("gf-get-output-table")) {
                String crop = (String) params.get("crop");
                String gender = (String) params.get("gender");
                String location = (String) params.get("location");
                String partner = (String) params.get("partner");

                JSONObject x = BIDataManager.getInstance().getBehaviourChangeInfo(crop, gender, location, partner);

                data.add("{ \"indicator\": \"Using improved practices and technologies\", \"farmers\": \""+x.get("ipt")+"\", \"area\": \""+x.get("ipt_area")+"\" }");
                data.add("{ \"indicator\": \"Using improved seed\", \"farmers\": \""+x.get("is")+"\", \"area\": \""+x.get("is_area")+"\" }");
                data.add("{ \"indicator\": \"Using recommended crop density and arrangement\", \"farmers\": \""+x.get("cda")+"\", \"area\": \""+x.get("cda_area")+"\" }");
                data.add("{ \"indicator\": \"Using inorganic fertilizer\", \"farmers\": \""+x.get("if")+"\", \"area\": \""+x.get("if_area")+"\" }");
                data.add("{ \"indicator\": \"Using pre-plant herbicide\", \"farmers\": \""+x.get("preh")+"\", \"area\": \""+x.get("preh_area")+"\" }");
                data.add("{ \"indicator\": \"Using post-plant herbicide\", \"farmers\": \""+x.get("posth")+"\", \"area\": \""+x.get("posth_area")+"\" }");
                data.add("{ \"indicator\": \"Using post-harvest thresher\", \"farmers\": \""+x.get("pht")+"\", \"area\": \""+x.get("pht_area")+"\" }");

            } else if (data_set.equals("gf-get-activity-table")) {
                String crop = (String) params.get("crop");
                String gender = (String) params.get("gender");
                String location = (String) params.get("location");

                JSONObject x = BIDataManager.getInstance().getAdvisoryInfo(crop, gender, location);

                data.add("{ \"indicator\": \"Number of farmers receiving advice on activities from farm planning to planting\", \"farmers\": \"" + x.get("app") + "\" }");
                data.add("{ \"indicator\": \"Number of farmers receiving advice on activities from farm planning to planting (video)\", \"farmers\": \"" + x.get("appv") + "\" }");

                data.add("{ \"indicator\": \"Number of farmers receiving advice on activities from planting to harvest\", \"farmers\": \"" + x.get("aph") + "\" }");
                data.add("{ \"indicator\": \"Number of farmers receiving advice on activities from planting to harvest (video)\", \"farmers\": \"" + x.get("aphv") + "\" }");

                data.add("{ \"indicator\": \"Number of farmers receiving advice on post-harvest activities\", \"farmers\": \"" + x.get("apost") + "\" }");
                data.add("{ \"indicator\": \"Number of farmers receiving advice on post-harvest activities (video)\", \"farmers\": \"" + x.get("apostv") + "\" }");

                data.add("{ \"indicator\": \"Number of farmers receiving advice on marketing activities\", \"farmers\": \"" + x.get("ama") + "\" }");
                data.add("{ \"indicator\": \"Number of farmers receiving advice on marketing activities (video)\", \"farmers\": \"" + x.get("amav") + "\" }");

                data.add("{ \"indicator\": \"Number of farmers with access to Agent (registered)\", \"farmers\": \"" + x.get("aa") + "\" }");
                data.add("{ \"indicator\": \"Number of farmers with farms assessed\", \"farmers\": \"" + x.get("fa") + "\" }");
                data.add("{ \"indicator\": \"Number of farmers with farms measured\", \"farmers\": \"" + x.get("fm") + "\" }");

            } else if (data_set.equals("obo-get-yield-table")) {
                String year = (String) params.get("year");
                String season = (String) params.get("season");

                JSONObject x = BIDataManager.getInstance(DATA_SET_FARMER).getFarmAreaInfo(PARTNER_ACDI, season, year);

                data.add("{ \"indicator\": \"Total area under registered farmers (acres)\", \"planned\": \""+x.get("total_acres_planned")+"\", \"actual\": \""+x.get("total_acres_actual")+"\" }");
                data.add("{ \"indicator\": \"Largest area (acres)\", \"planned\": \""+x.get("largest_acre_planned")+"\", \"actual\": \""+x.get("largest_acre_actual")+"\" }");
                data.add("{ \"indicator\": \"Smallest area cultivated (acres)\", \"planned\": \""+x.get("smallest_acre_planned")+"\", \"actual\": \""+x.get("smallest_acre_actual")+"\" }");
                data.add("{ \"indicator\": \"Average area cultivated (acres)\", \"planned\": \""+x.get("average_acre_planned")+"\", \"actual\": \""+x.get("average_acre_actual")+"\" }");
                data.add("{ \"indicator\": \"Average yield per acres\", \"planned\": \""+x.get("average_yield_planned")+"\", \"actual\": \""+x.get("average_yield_actual")+"\" }");
                data.add("{ \"indicator\": \"Total production from registered farmers\", \"planned\": \""+x.get("total_production_planned")+"\", \"actual\": \""+x.get("total_production_actual")+"\" }");
                data.add("{ \"indicator\": \"Value of total production from registered farmers\", \"planned\": \""+x.get("total_value_planned")+"\", \"actual\": \""+x.get("total_value_actual")+"\" }");

            } else if (data_set.equals("obo-get-ciob-table")) {
                String year = (String) params.get("year");
                String season = (String) params.get("season");

                JSONObject x = BIDataManager.getInstance(DATA_SET_FARMER).getFarmCreditInfo(PARTNER_ACDI, season, year, true);

                data.add("{ \"indicator\": \"Total number of farmers taking credit\", \"planned\": \""+x.get("credit_planned")+"\", \"actual\": \""+x.get("credit_actual")+"\" }");
                data.add("{ \"indicator\": \"Total number of farmers taking cash credit\", \"planned\": \""+x.get("cash_planned")+"\", \"actual\": \""+x.get("cash_actual")+"\" }");
                data.add("{ \"indicator\": \"Total number of farmers taking input credit from OB\", \"planned\": \""+x.get("input_planned")+"\", \"actual\": \""+x.get("input_actual")+"\" }");
                data.add("{ \"indicator\": \"Total amount of cash credit from OB\", \"planned\": \""+x.get("cash_amount_planned")+"\", \"actual\": \""+x.get("cash_amount_actual")+"\" }");
                data.add("{ \"indicator\": \"Total value of cash credit payback due to OB\", \"planned\": \""+x.get("cash_payback_planned")+"\", \"actual\": \""+x.get("cash_payback_actual")+"\" }");
                data.add("{ \"indicator\": \"Total quantity of produce as payback due to OB (bags)\", \"planned\": \""+x.get("input_payback_planned")+"\", \"actual\": \""+x.get("input_payback_actual")+"\" }");
                data.add("{ \"indicator\": \"Total number of farmers taking seed on credit from OB\", \"planned\": \""+x.get("seed_planned")+"\", \"actual\": \""+x.get("seed_actual")+"\" }");
                data.add("{ \"indicator\": \"Total number of farmers taking fertilizer on credit from OB\", \"planned\": \""+x.get("fertilizer_planned")+"\", \"actual\": \""+x.get("fertilizer_actual")+"\" }");
                data.add("{ \"indicator\": \"Total number of farmers taking pre-plant herbicide on credit from OB\", \"planned\": \""+x.get("preplanh_planned")+"\", \"actual\": \""+x.get("preplanh_actual")+"\" }");
                data.add("{ \"indicator\": \"Total number of farmers taking post-plant herbicide on credit from OB\", \"planned\": \""+x.get("postplanh_planned")+"\", \"actual\": \""+x.get("postplanh_actual")+"\" }");
                data.add("{ \"indicator\": \"Total number of farmers taking ploughing on credit from OB\", \"planned\": \""+x.get("plough_planned")+"\", \"actual\": \""+x.get("plough_actual")+"\" }");
                data.add("{ \"indicator\": \"Total number of farmers taking post-harvest handling services on credit from OB\", \"planned\": \""+x.get("handling_planned")+"\", \"actual\": \""+x.get("handling_actual")+"\" }");
                data.add("{ \"indicator\": \"Total number of farmers taking transport services on credit from OB\", \"planned\": \""+x.get("transport_planned")+"\", \"actual\": \""+x.get("transport_actual")+"\" }");
                data.add("{ \"indicator\": \"Total number of farmers taking warehouse storage services on credit from OB\", \"planned\": \""+x.get("storage_planned")+"\", \"actual\": \""+x.get("storage_actual")+"\" }");

            } else if (data_set.equals("obo-get-cif-table")) {
                String year = (String) params.get("year");
                String season = (String) params.get("season");

                JSONObject x = BIDataManager.getInstance(DATA_SET_FARMER).getFarmCreditInfo(PARTNER_ACDI, season, year, false);

                data.add("{ \"indicator\": \"Total number of farmers taking credit\", \"planned\": \""+x.get("credit_planned")+"\", \"actual\": \""+x.get("credit_actual")+"\" }");
                data.add("{ \"indicator\": \"Total number of farmers taking cash credit\", \"planned\": \""+x.get("cash_planned")+"\", \"actual\": \""+x.get("cash_actual")+"\" }");
                data.add("{ \"indicator\": \"Total number of farmers taking input credit from OB\", \"planned\": \""+x.get("input_planned")+"\", \"actual\": \""+x.get("input_actual")+"\" }");
                data.add("{ \"indicator\": \"Total amount of cash credit\", \"planned\": \""+x.get("cash_amount_planned")+"\", \"actual\": \""+x.get("cash_amount_actual")+"\" }");
                data.add("{ \"indicator\": \"Total value of cash credit payback\", \"planned\": \""+x.get("cash_payback_planned")+"\", \"actual\": \""+x.get("cash_payback_actual")+"\" }");
                data.add("{ \"indicator\": \"Total quantity of produce as payback (bags)\", \"planned\": \""+x.get("input_payback_planned")+"\", \"actual\": \""+x.get("input_payback_actual")+"\" }");
                data.add("{ \"indicator\": \"Total number of farmers taking seed on credit\", \"planned\": \""+x.get("seed_planned")+"\", \"actual\": \""+x.get("seed_actual")+"\" }");
                data.add("{ \"indicator\": \"Total number of farmers taking fertilizer on credit\", \"planned\": \""+x.get("fertilizer_planned")+"\", \"actual\": \""+x.get("fertilizer_actual")+"\" }");
                data.add("{ \"indicator\": \"Total number of farmers taking pre-plant herbicide on credit\", \"planned\": \""+x.get("preplanh_planned")+"\", \"actual\": \""+x.get("preplanh_actual")+"\" }");
                data.add("{ \"indicator\": \"Total number of farmers taking post-plant herbicide on credit\", \"planned\": \""+x.get("postplanh_planned")+"\", \"actual\": \""+x.get("postplanh_actual")+"\" }");
                data.add("{ \"indicator\": \"Total number of farmers taking ploughing on credit\", \"planned\": \""+x.get("plough_planned")+"\", \"actual\": \""+x.get("plough_actual")+"\" }");
                data.add("{ \"indicator\": \"Total number of farmers taking post-harvest handling services on credit\", \"planned\": \""+x.get("handling_planned")+"\", \"actual\": \""+x.get("handling_actual")+"\" }");
                data.add("{ \"indicator\": \"Total number of farmers taking transport services on credit\", \"planned\": \""+x.get("transport_planned")+"\", \"actual\": \""+x.get("transport_actual")+"\" }");
                data.add("{ \"indicator\": \"Total number of farmers taking warehouse storage services on credit\", \"planned\": \""+x.get("storage_planned")+"\", \"actual\": \""+x.get("storage_actual")+"\" }");
            }

            for (String s : data) { response.getJSONArray("data").put(new JSONObject(s)); }

        } catch (Exception e) {
            Logger.getLogger(TAG).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }

        return response;
    }

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

    // <editor-fold defaultstate="collapsed" desc="Helpers">
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
        return BIDataManager.getInstance().getCrops();
    }

    public List<String> getLocations() {
        return BIDataManager.getInstance().getLocations();
    }

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

    private void setData(String dashboard) {
        try {
            data = new JSONObject();
            data.put("farmers", new JSONObject());
            data.getJSONObject("farmers").put("registration", new JSONObject());
            data.getJSONObject("farmers").getJSONObject("registration").put("total", BIDataManager.getInstance(DATA_SET_FARMER).getTotalData());

            data.put("agents", new JSONObject());
            data.getJSONObject("agents").put("registration", new JSONObject());
            data.getJSONObject("agents").getJSONObject("registration").put("total", BIDataManager.getInstance(DATA_SET_AGENT).getTotalData());

            for(String p : PARTNERS ) {
                data.getJSONObject("farmers").getJSONObject("registration").put(p, BIDataManager.getInstance(DATA_SET_FARMER).getPartnerRegistrationData(p));
                data.getJSONObject("agents").getJSONObject("registration").put(p, BIDataManager.getInstance(DATA_SET_AGENT).getPartnerRegistrationData(p));
            }

            if (dashboard.equalsIgnoreCase("gf") || dashboard.equalsIgnoreCase("acdivoca") || dashboard.equalsIgnoreCase("mofa")) {
                data.getJSONObject("farmers").put("previous_performance", new JSONObject());
                data.getJSONObject("farmers").put("fmp", new JSONObject());
                data.getJSONObject("farmers").put("fmp_update", new JSONObject());
                data.getJSONObject("farmers").put("farms", new JSONObject());

                data.getJSONObject("agents").put("previous_performance", new JSONObject());
                data.getJSONObject("agents").put("fmp", new JSONObject());
                data.getJSONObject("agents").put("fmp_update", new JSONObject());
                data.getJSONObject("agents").put("farms", new JSONObject());

                for(String p : PARTNERS ) {
                    data.getJSONObject("farmers").getJSONObject("previous_performance").put(p, BIDataManager.getInstance(DATA_SET_FARMER).getPartnerPPData(p));
                    data.getJSONObject("farmers").getJSONObject("fmp").put(p, BIDataManager.getInstance(DATA_SET_FARMER).getPartnerFMPData(p));
                    data.getJSONObject("farmers").getJSONObject("fmp_update").put(p, BIDataManager.getInstance(DATA_SET_FARMER).getPartnerFMPUpdateData(p));
                    data.getJSONObject("farmers").getJSONObject("farms").put(p, BIDataManager.getInstance(DATA_SET_FARMER).getPartnerFarmsData(p));

                    data.getJSONObject("agents").getJSONObject("previous_performance").put(p, BIDataManager.getInstance(DATA_SET_AGENT).getPartnerPPData(p));
                    data.getJSONObject("agents").getJSONObject("fmp").put(p, BIDataManager.getInstance(DATA_SET_AGENT).getPartnerFMPData(p));
                    data.getJSONObject("agents").getJSONObject("fmp_update").put(p, BIDataManager.getInstance(DATA_SET_AGENT).getPartnerFMPUpdateData(p));
                    data.getJSONObject("agents").getJSONObject("farms").put(p, BIDataManager.getInstance(DATA_SET_AGENT).getPartnerFarmsData(p));
                }

            } else if (dashboard.equalsIgnoreCase("obo")) {
                data.getJSONObject("farmers").getJSONObject("registration").put("chart_line", BIDataManager.getInstance(DATA_SET_FARMER).getEChartLineDataByCommunityForPartner(PARTNER_ACDI));

            } else if (dashboard.equalsIgnoreCase("general")) {
                data.getJSONObject("agents").getJSONObject("registration").put("sparkline", BIDataManager.getInstance(DATA_SET_AGENT).getSparkLineData());
                data.getJSONObject("farmers").getJSONObject("registration").put("sparkline", BIDataManager.getInstance(DATA_SET_FARMER).getSparkLineData());
                data.getJSONObject("farmers").getJSONObject("registration").put("chart_line", BIDataManager.getInstance(DATA_SET_FARMER).getEChartLineData());

                data.put("communities", new JSONObject());
                data.getJSONObject("communities").put("registration", new JSONObject());
                data.getJSONObject("communities").getJSONObject("registration").put("total", BIDataManager.getInstance(DATA_SET_COMMUNITY).getTotalData());
                data.getJSONObject("communities").getJSONObject("registration").put("sparkline", BIDataManager.getInstance(DATA_SET_COMMUNITY).getSparkLineData());
            }
        } catch (Exception ex) {
            data.put("error",ex.getLocalizedMessage());
            Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

}
