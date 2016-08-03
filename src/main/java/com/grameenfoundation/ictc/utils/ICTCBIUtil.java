package com.grameenfoundation.ictc.utils;

import org.json.JSONObject;
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
    private final static String TABLE_FIN_COST = "bi_fin_cost";
    private final static String TABLE_FIN_CREDIT = "bi_fin_credit";
    private final static String TABLE_FIN_PAYMENT = "bi_fin_payment";
    private final static String TABLE_FIN_REVENUE = "bi_fin_revenue";
    private final static String TABLE_LAND_ACREAGE = "bi_land_acreage";
    private final static String TABLE_LAND_PRODUCTION = "bi_land_production";
    private final static String TABLE_LAND_YIELD = "bi_land_yeild";

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Indicator Names">

    private final static String INDICATOR_AGENT = "count_agent";
    private final static String INDICATOR_COMMUNITY = "count_community";
    private final static String INDICATOR_FARMER = "count_farmer";
    private final static String INDICATOR_COSTS = "count_costs";
    private final static String INDICATOR_CREDIT = "count_credit";
    private final static String INDICATOR_PAYMENT = "count_payment";
    private final static String INDICATOR_REVENUE = "count_revenue";
    private final static String INDICATOR_ACREAGE = "count_acreage";
    private final static String INDICATOR_PRODUCTION = "count_production";
    private final static String INDICATOR_YIELD = "count_yield";

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Partner Names">
    private final static String PARTNER_ACDI = "ACDIVOCA";
    private final static String PARTNER_MOFA = "MOFA";
    private final static String PARTNER_GF = "GRAMEEN";
    private final static String PARTNER_CIF = "CIFCSF";
    private final static String[] PARTNERS = {PARTNER_ACDI, PARTNER_MOFA, PARTNER_CIF, PARTNER_GF};
    // </editor-fold>

    public static JSONObject getIndicator(String indicator, HashMap params) {
        JSONObject response = new JSONObject();
        response.put("error","Not Implemented yet.");
        return response;
    }

    public static DashboardData getDashboardDataAsObject(String dashboard) {
        return new DashboardData(getDashboardData(dashboard));
    }

    public static JSONObject getDashboardData(String dashboard) {
        JSONObject x =  new JSONObject();

        try {
            if (dashboard.equalsIgnoreCase("general")) {

                x.put("farmers", new JSONObject());
                x.getJSONObject("farmers").put("registration", new JSONObject());
                x.getJSONObject("farmers").getJSONObject("registration").put("total", IndicatorManager.getInstance(INDICATOR_FARMER).getTotalData());
                x.getJSONObject("farmers").getJSONObject("registration").put("sparkline", IndicatorManager.getInstance(INDICATOR_FARMER).getSparkLineData());
                x.getJSONObject("farmers").getJSONObject("registration").put("chart_line", IndicatorManager.getInstance(INDICATOR_FARMER).getEChartLineData());
                for(String p : PARTNERS ) {
                    x.getJSONObject("farmers").getJSONObject("registration").put(p, IndicatorManager.getInstance(INDICATOR_FARMER).getPartnerFarmerRegData(p));
                }

                x.put("agents", new JSONObject());
                x.getJSONObject("agents").put("registration", new JSONObject());
                x.getJSONObject("agents").getJSONObject("registration").put("total", IndicatorManager.getInstance(INDICATOR_AGENT).getTotalData());
                x.getJSONObject("agents").getJSONObject("registration").put("sparkline", IndicatorManager.getInstance(INDICATOR_AGENT).getSparkLineData());

                x.put("communities", new JSONObject());
                x.getJSONObject("communities").put("registration", new JSONObject());
                x.getJSONObject("communities").getJSONObject("registration").put("total", IndicatorManager.getInstance(INDICATOR_COMMUNITY).getTotalData());
                x.getJSONObject("communities").getJSONObject("registration").put("sparkline", IndicatorManager.getInstance(INDICATOR_COMMUNITY).getSparkLineData());

                System.out.println(x.toString(4));
            }
        } catch (Exception ex) {
            x.put("error",ex.getLocalizedMessage());
            Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return x;
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

        public String getFarmerRegistrationTotal() { return getRegistrationTotal("farmers"); }
        public String getFarmerRegistrationSparkline() { return getRegistrationSparkline("farmers"); }
        public String getFarmerRegistrationProgressForACDI() { return getRegistrationProgress("farmers", PARTNER_ACDI); }
        public String getFarmerRegistrationProgressForMOFA() { return getRegistrationProgress("farmers", PARTNER_MOFA); }
        public String getFarmerRegistrationProgressForCIF() { return getRegistrationProgress("farmers", PARTNER_CIF); }
        public String getFarmerRegistrationProgressForGF() { return getRegistrationProgress("farmers", PARTNER_GF); }
        public String getFarmerRegistrationTargetForACDI() { return getRegistrationTarget("farmers", PARTNER_ACDI); }
        public String getFarmerRegistrationTargetForMOFA() { return getRegistrationTarget("farmers", PARTNER_MOFA); }
        public String getFarmerRegistrationTargetForCIF() { return getRegistrationTarget("farmers", PARTNER_CIF); }
        public String getFarmerRegistrationTargetForGF() { return getRegistrationTarget("farmers", PARTNER_GF); }
        public String getFarmerRegistrationTotalForACDI() { return getRegistrationTotal("farmers", PARTNER_ACDI); }
        public String getFarmerRegistrationTotalForMOFA() { return getRegistrationTotal("farmers", PARTNER_MOFA); }
        public String getFarmerRegistrationTotalForCIF() { return getRegistrationTotal("farmers", PARTNER_CIF); }
        public String getFarmerRegistrationTotalForGF() { return getRegistrationTotal("farmers", PARTNER_GF); }
        public String getFarmerRegistrationEChartLegend() { return getRegistrationEChartLineData("farmers","legend"); }
        public String getFarmerRegistrationEChartAxis() { return getRegistrationEChartLineData("farmers","xAxis"); }
        public String getFarmerRegistrationEChartSeries() { return getRegistrationEChartLineData("farmers","series"); }

        public String getAgentRegistrationTotal() { return getRegistrationTotal("agents"); }
        public String getAgentRegistrationSparkline() { return getRegistrationSparkline("agents"); }

        public String getCommunityRegistrationTotal() { return getRegistrationTotal("communities"); }
        public String getCommunityRegistrationSparkline() { return getRegistrationSparkline("communities"); }


        private String getRegistrationTotal(String o) {
            return (String) data.getJSONObject(o).getJSONObject("registration").get("total");
        }
        private String getRegistrationTotal(String o, String partner) {
            return (String) data.getJSONObject(o).getJSONObject("registration").getJSONObject(partner).get("total");
        }
        public String getRegistrationEChartLineData(String o, String attr) {
            return (String) data.getJSONObject(o).getJSONObject("registration").getJSONObject("chart_line").get(attr);
        }
        private String getRegistrationSparkline(String o) {
            return (String) data.getJSONObject(o).getJSONObject("registration").get("sparkline");
        }
        public String getRegistrationProgress(String o, String partner) {
            return (String) data.getJSONObject(o).getJSONObject("registration").getJSONObject(partner).get("progress");
        }
        public String getRegistrationTarget(String o, String partner) {
            return (String) data.getJSONObject(o).getJSONObject("registration").getJSONObject(partner).get("target");
        }
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

        public JSONObject getPartnerFarmerRegData(String partner) throws Exception {
            JSONObject x = new JSONObject();
            x.put("target", 0);
            x.put("total", 0);
            x.put("progress", 0);

            try {
                String targetCol = partner + "_FARMER_TARGET";
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

        public HashMap<String, String> update() throws Exception {
            HashMap<String, String> response = new HashMap<>();
            try {
                if (indicator.equals("all")) {
                    response.put(INDICATOR_AGENT, ((updateTable(TABLE_AGENT) ? OK : FAILED)));
                    response.put(INDICATOR_COMMUNITY, ((updateTable(TABLE_COMMUNITY) ? OK : FAILED)));
                    response.put(INDICATOR_FARMER, ((updateTable(TABLE_FARMER) ? OK : FAILED)));
                    response.put(INDICATOR_COSTS, ((updateTable(TABLE_FIN_COST) ? OK : FAILED)));
                    response.put(INDICATOR_CREDIT, ((updateTable(TABLE_FIN_CREDIT) ? OK : FAILED)));
                    response.put(INDICATOR_PAYMENT, ((updateTable(TABLE_FIN_PAYMENT) ? OK : FAILED)));
                    response.put(INDICATOR_REVENUE, ((updateTable(TABLE_FIN_REVENUE) ? OK : FAILED)));
                    response.put(INDICATOR_ACREAGE, ((updateTable(TABLE_LAND_ACREAGE) ? OK : FAILED)));
                    response.put(INDICATOR_PRODUCTION, ((updateTable(TABLE_LAND_PRODUCTION) ? OK : FAILED)));
                    response.put(INDICATOR_YIELD, ((updateTable(TABLE_LAND_YIELD) ? OK : FAILED)));
                } else {
                    response.put(indicator, ((updateTable(getIndicatorTable(indicator)) ? OK : FAILED)));
                }
            } catch (Exception e) {
                throw(e);
            }

            return response;
        }


        // Helpers
        private boolean updateTable(String tableName) {

            try {
                HashMap<String, SQLRowObj> data = new HashMap<>();
                String cql = getUpdateCQL(tableName);

                if (cql.equals("")) {
                    System.out.println("Error pulling data from Neo4j: invalid table name");
                    return false;

                } else {

                    try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
                        Result result = Neo4jServices.executeCypherQuery(cql);

                        while (result.hasNext()) {
                            Map<String, Object> row = result.next();

                            //System.out.println("Row object: "+row.toString());

                            SQLRowObj obj = new SQLRowObj();
                            ArrayList<Integer> yearMonthSeason = getDateFromTime((Long) row.get("lmd"));

                            if (tableName.equals(TABLE_AGENT)) {
                        /*
                           yearMonthSeason = ((String) row.get("code")).startsWith("AG")
                                ? getDateFromCode((String) row.get("code"))
                                : getDateFromTime((Long) row.get("lmd"));
                         */
                                obj.partner = (String) row.get("partner");
                            } else if (tableName.equals(TABLE_COMMUNITY)) {
                                obj.community = (String) row.get("community");
                            } else if (tableName.equals(TABLE_FARMER)) {
                                yearMonthSeason = getDateFromTime((Long) row.get("lmd"));
                                obj.community = (String) row.get("community");
                                obj.partner = (String) row.get("partner");
                            }

                            obj.year = yearMonthSeason.get(0);
                            obj.month = yearMonthSeason.get(1);
                            obj.season = yearMonthSeason.get(2);

                            if (data.containsKey(obj.id(tableName))) {
                                data.get(obj.id(tableName)).actual++;
                            } else {
                                obj.actual = 1;
                                data.put(obj.id(tableName), obj);
                            }
                        }

                        trx.success();
                    } catch (Exception e) {
                        System.out.println("Error pulling data from Neo4j: " + e.getMessage());
                        e.printStackTrace();
                    }

                    // Insert data into MySQL
                    if (data.size() > 0) {
                        ICTCDBUtil.getInstance().emptyTable(tableName);
                        for (SQLRowObj r : data.values()) {
                            String sql = "INSERT INTO " + tableName + " (" + r.fields(tableName) + ") VALUES " + r.values(tableName);
                            //System.out.println(sql);
                            ICTCDBUtil.getInstance().runSQLUpdate(sql);
                        }
                        return true;
                    }
                }

            } catch (SQLException e){
                System.out.println("Error updating table '" + tableName + "': " + e.getMessage());
                e.printStackTrace();
            } catch (Exception e){
                System.out.println("Error getting values for table '" + tableName + "': " + e.getMessage());
                e.printStackTrace();
            }
            return false;
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
                case INDICATOR_ACREAGE: return TABLE_LAND_ACREAGE;
                case INDICATOR_PRODUCTION: return TABLE_LAND_PRODUCTION;
                case INDICATOR_YIELD: return TABLE_LAND_YIELD;
                default:
                    throw new Exception("Invalid indicator");
            }
        }

        private String getUpdateCQL(String tableName) {
            switch(tableName) {
                case TABLE_AGENT:  return "match (n:AGENT) return n.agentcode as code, n.agenttype as partner, n.lastModifieddate as lmd";
                case TABLE_FARMER: return "match (n:FARMER) with n match (m:AGENT) where m.Id=n.CreatedById return n.Id, n.village as community, m.agenttype as partner, n.lastModifieddate as lmd";
                case TABLE_COMMUNITY: return "match (n:FARMER) with DISTINCT(n.village)as community match (m:FARMER) where m.village = community return community, MAX(m.lastModifieddate) as lmd";
                case TABLE_FIN_COST: return "";
                case TABLE_FIN_REVENUE: return "";
                case TABLE_FIN_CREDIT:  return "";
                case TABLE_FIN_PAYMENT: return "";
                case TABLE_LAND_ACREAGE: return "";
                case TABLE_LAND_PRODUCTION: return "";
                case TABLE_LAND_YIELD: return "";
                default: return "";
            }
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

    }

    private static class SQLRowObj {
        public int planned;
        public int actual;
        public int year;
        public int month;
        public int season;
        public int acres;
        public int farmer_id;
        public String farmer_type;
        public String credit_type;
        public String credit_mode;
        public String payment_type;
        public String payment_mode;
        public String partner;
        public String community;

        public String get_planned() { return String.valueOf(planned); }
        public String get_actual() { return String.valueOf(actual); }
        public String get_year() { return String.valueOf(year); }
        public String get_month() { return String.valueOf(month); }
        public String get_season() { return String.valueOf(season); }
        public String get_acres() { return String.valueOf(acres); }
        public String get_farmer_id() { return String.valueOf(farmer_id); }
        public String get_farmer_type() { return farmer_type; }
        public String get_credit_type() { return credit_type; }
        public String get_credit_mode() { return credit_mode; }
        public String get_payment_type() { return payment_type; }
        public String get_payment_mode() { return payment_mode; }
        public String get_community() { return community; }
        public String get_partner() { return partner; }

        public String id(String tableName) {
            String id = "";
            String common = get_year() + "-" + get_month() + "-" + get_season();
            switch(tableName) {
                case TABLE_AGENT: id = get_partner() + "-" + common; break;
                case TABLE_FARMER: id = get_community() + "-" + get_partner() + "-" + common; break;
                case TABLE_FIN_COST: id = get_farmer_id() + "-" + common ; break;
                case TABLE_FIN_REVENUE: id = get_farmer_id() + "-" + common; break;
                case TABLE_FIN_CREDIT: id = get_farmer_id() + "-" + get_credit_mode() + "-" + get_credit_type() + "-" + common; break;
                case TABLE_FIN_PAYMENT: id = get_farmer_id() + "-" + get_payment_mode() + "-" + get_payment_type() + "-" + common; break;
                case TABLE_LAND_ACREAGE: id = get_farmer_id() + "-" + common; break;
                case TABLE_LAND_PRODUCTION: id = get_farmer_id() + "-" + common; break;
                case TABLE_LAND_YIELD: id = get_farmer_id() + "-" + common; break;
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
            String fields = "planned, actual, year, month, season";
            String partner = ", partner";
            String community = ", community";
            String farmer = ", farmer_id";
            String acres = ", acres";
            String finc = ", farmer_type, credit_type, credit_mode";
            String finp = ", farmer_type, payment_type, payment_mode";

            switch(tableName) {
                case TABLE_AGENT: fields = fields + partner; break;
                case TABLE_FARMER: fields = fields + partner + community; break;
                case TABLE_FIN_COST: fields = fields + farmer + acres; break;
                case TABLE_FIN_REVENUE: fields = fields + farmer + acres; break;
                case TABLE_FIN_CREDIT: fields = fields + farmer + finc; break;
                case TABLE_FIN_PAYMENT: fields = fields + farmer + finp; break;
                case TABLE_LAND_ACREAGE: fields = fields + farmer; break;
                case TABLE_LAND_PRODUCTION: fields = fields + farmer; break;
                case TABLE_LAND_YIELD: fields = fields + farmer; break;
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

    private static int getSeasonFromMonth(int month) {
        return (month > 6) ? 2 : 1;
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
        dates.add(getSeasonFromMonth(cal.get(Calendar.MONTH)));
        return dates;
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
            ArrayList<String> tables = new ArrayList<>(Arrays.asList(
                TABLE_AGENT , TABLE_COMMUNITY , TABLE_FARMER, TABLE_FIN_COST,
                TABLE_FIN_CREDIT, TABLE_FIN_PAYMENT, TABLE_FIN_REVENUE,
                TABLE_LAND_ACREAGE, TABLE_LAND_PRODUCTION, TABLE_LAND_YIELD));

            int tblCount = 0;
            ResultSet rs = ICTCDBUtil.getInstance().getMysqlConnection().getMetaData().getTables(null, null, "%", null);
            while (rs.next()) {
                if (tables.contains(rs.getString(3))) { tblCount++; }
            }
            exists = (tblCount==tables.size());
        } catch (Exception e) {
            throw(e);
        }

        return exists;
    }

    public static void createTables(Boolean fillTables) throws Exception {
        try {
            String fields = "planned INTEGER, actual INTEGER, year INTEGER, month INTEGER, season INTEGER";
            String partner = ", partner VARCHAR(50)";
            String community = ", community VARCHAR(50)";
            String farmer = ", farmer_id INTEGER";
            String acres = ", acres INTEGER";
            String finc = ", farmer_type VARCHAR(10), credit_type VARCHAR(20), credit_mode VARCHAR(20)";
            String finp = ", farmer_type VARCHAR(10), payment_type VARCHAR(20), payment_mode VARCHAR(20)";

            ICTCDBUtil.getInstance().createTable(TABLE_AGENT, fields + partner);
            ICTCDBUtil.getInstance().createTable(TABLE_COMMUNITY, fields);
            ICTCDBUtil.getInstance().createTable(TABLE_FARMER, fields + partner + community);
            ICTCDBUtil.getInstance().createTable(TABLE_FIN_COST, fields + farmer + acres);
            ICTCDBUtil.getInstance().createTable(TABLE_FIN_REVENUE, fields + farmer + acres);
            ICTCDBUtil.getInstance().createTable(TABLE_FIN_CREDIT, fields + farmer + finc);
            ICTCDBUtil.getInstance().createTable(TABLE_FIN_PAYMENT, fields + farmer + finp);
            ICTCDBUtil.getInstance().createTable(TABLE_LAND_ACREAGE, fields + farmer);
            ICTCDBUtil.getInstance().createTable(TABLE_LAND_PRODUCTION, fields + farmer);
            ICTCDBUtil.getInstance().createTable(TABLE_LAND_YIELD, fields + farmer);

            if (fillTables) { IndicatorManager.getInstance("all").update(); }
        } catch (Exception e) {
            throw(e);
        }
    }

    // </editor-fold>
}