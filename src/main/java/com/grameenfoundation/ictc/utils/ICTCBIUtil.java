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

    private final static String OK = "Ok";
    private final static String FAILED = "Failed";

    // <editor-fold defaultstate="collapsed" desc="Table Names">

    private final static String TABLE_AGENT  = "bi_agent";
    private final static String TABLE_COMMUNITY  = "bi_community";
    private final static String TABLE_FARMER = "bi_farmer";
    private final static String TABLE_FIN_COST = "bi_fin_cost";
    private final static String TABLE_FIN_CREDIT = "bi_fin_credit";
    private final static String TABLE_FIN_PAYBACK = "bi_fin_payback";
    private final static String TABLE_FIN_REVENUE = "bi_fin_revenue";
    private final static String TABLE_LAND_ACREAGE = "bi_land_acreage";
    private final static String TABLE_LAND_PRODUCTION = "bi_land_production";
    private final static String TABLE_LAND_YIELD = "bi_land_yeild";

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Indicator Names">

    private final static String INDICATOR_AGENT = "count_agent";
    private final static String INDICATOR_COMMUNITY = "count_community";
    private final static String INDICATOR_FARMER = "count_farmer";

    // </editor-fold>

    public static JSONObject getIndicator(String indicator, HashMap params) {
        JSONObject response = new JSONObject();

        try {
            switch (indicator) {
                case INDICATOR_AGENT: response = getAgentInfo(params); break;
                case INDICATOR_COMMUNITY: response = getCommunityInfo(params); break;
                case INDICATOR_FARMER: response = getFarmerInfo(params); break;
                default: response.put("error", "Unknown indicator "+ indicator);
            }
        } catch (Exception ex) {
            response.put("error",ex.getLocalizedMessage());
            Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return response;
    }

    public static HashMap updateIndicators(String indicator) {

        HashMap<String, String> response = new HashMap<>();

        indicator = (indicator==null) ? "all" : indicator;

        try {
            switch (indicator) {
                case INDICATOR_AGENT: response.put(indicator,((updateAgentInfo() ?  OK : FAILED))); break;
                case INDICATOR_COMMUNITY: response.put(indicator,((updateCommunityInfo() ?  OK : FAILED))); break;
                case INDICATOR_FARMER: response.put(indicator,((updateFarmerInfo() ?  OK : FAILED))); break;
                default:
                    response = updateAll();
            }

        } catch (Exception ex) {
            response.put("error",ex.getLocalizedMessage());
            Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return response;
    }

    // <editor-fold defaultstate="collapsed" desc="Indicator Get Methods">

    private static JSONObject getAgentInfo(HashMap params) {
        JSONObject x =  new JSONObject();
        x.put("Total",10);
        return x;
    }

    private static JSONObject getCommunityInfo(HashMap params) {
        JSONObject x =  new JSONObject();
        x.put("Total",10);
        return x;
    }

    private static JSONObject getFarmerInfo(HashMap params) {
        JSONObject x =  new JSONObject();
        x.put("Total",10);
        return x;
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Indicator Update Methods">

    private static HashMap<String, String> updateAll() {
        HashMap<String, String> resp = new HashMap<>();
        resp.put(INDICATOR_AGENT,((updateAgentInfo() ?  OK : FAILED)));
        resp.put(INDICATOR_COMMUNITY,((updateCommunityInfo() ?  OK : FAILED)));
        resp.put(INDICATOR_FARMER,((updateFarmerInfo() ?  OK : FAILED)));
        return resp;
    }

    private static boolean updateAgentInfo() {
        String cql = "match (n:AGENT) return n.agentcode as code, n.agenttype as partner, n.lastModifieddate as lmd";
        return updateTable(TABLE_AGENT, cql);
    }

    private static boolean updateCommunityInfo() {
        String cql = "match (n:FARMER) with DISTINCT(n.village)as community match (m:FARMER) where m.village = community return community, MAX(m.lastModifieddate) as lmd";
        return updateTable(TABLE_COMMUNITY, cql);
    }

    private static boolean updateFarmerInfo() {
        String cql = "match (n:FARMER) with n match (m:AGENT) where m.Id=n.CreatedById return n.Id, n.village as community, m.agenttype as partner, n.lastModifieddate as lmd";
        return updateTable(TABLE_FARMER, cql);
    }

    private static boolean updateTable(String tableName, String cql) {
        try {
            HashMap<String, SQLRowObj> data = new HashMap<>();

            try (Transaction trx = ICTCDBUtil.getInstance().getGraphDB().beginTx()) {
                Result result = Neo4jServices.executeCypherQuery(cql);

                while (result.hasNext()) {
                    Map<String, Object> row = result.next();


                    SQLRowObj obj = new SQLRowObj();
                    ArrayList<Integer> yearMonthSeason = new ArrayList<>();

                    if (tableName.equals(TABLE_AGENT)) {
                        System.out.println("Row object: "+row.toString());
                        yearMonthSeason = ((String) row.get("code")).startsWith("AG")
                                ? getDateFromCode((String) row.get("code"))
                                : getDateFromTime((Long) row.get("lmd"));
                        obj.partner = (String) row.get("partner");
                    } else if (tableName.equals(TABLE_COMMUNITY)) {
                        yearMonthSeason =  getDateFromTime((Long) row.get("lmd"));
                        obj.community = (String) row.get("community");
                    } else if (tableName.equals(TABLE_FARMER)) {
                        yearMonthSeason =  getDateFromTime((Long) row.get("lmd"));
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
            } catch(Exception e) {
                System.out.println("Error pulling data from Neo4j: "+e.getMessage());
                e.printStackTrace();
            }

            // Insert data into MySQL
            if (data.size()>0) {
                ICTCDBUtil.getInstance().emptyTable(tableName);
                for (SQLRowObj r : data.values()) {
                    String sql = "INSERT INTO " + tableName + " (" + r.fields(tableName) + ") VALUES " + r.values(tableName);
                    //System.out.println(sql);
                    ICTCDBUtil.getInstance().runSQLUpdate(sql);
                }
                return true;
            }

            return false;
        } catch (SQLException e) {
            System.out.println("Error updating table '"+tableName+"': "+e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error getting values for table '"+tableName+"': "+e.getMessage());
            e.printStackTrace();
        }

        return false;
    }


    // Helpers
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
                case TABLE_FIN_PAYBACK: id = get_farmer_id() + "-" + get_payment_mode() + "-" + get_payment_type() + "-" + common; break;
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
                case TABLE_FIN_PAYBACK: fields = fields + farmer + finp; break;
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
                TABLE_FIN_CREDIT, TABLE_FIN_PAYBACK, TABLE_FIN_REVENUE,
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
            ICTCDBUtil.getInstance().createTable(TABLE_FIN_PAYBACK, fields + farmer + finp);
            ICTCDBUtil.getInstance().createTable(TABLE_LAND_ACREAGE, fields + farmer);
            ICTCDBUtil.getInstance().createTable(TABLE_LAND_PRODUCTION, fields + farmer);
            ICTCDBUtil.getInstance().createTable(TABLE_LAND_YIELD, fields + farmer);

            if (fillTables) { updateAll(); }
        } catch (Exception e) {
            throw(e);
        }
    }

    // </editor-fold>
}