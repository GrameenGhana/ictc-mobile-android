package com.grameenfoundation.ictc.utils;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by David on 8/22/2016.
 * Utility file for BI
 */
public class BIUtil {

    protected final static String OK = "Ok";
    protected final static String FAILED = "Failed";
    protected final static int START_YEAR = 2016;
    protected final static Long DEFAULT_TIME = 1457518321908L;

    // <editor-fold defaultstate="collapsed" desc="Table Names">
    protected final static String TABLE_AGENT  = "bi_agent";
    protected final static String TABLE_COMMUNITY  = "bi_community";
    protected final static String TABLE_FARMER = "bi_farmer";
    protected final static String TABLE_FARM = "bi_farm";
    protected final static ArrayList<String> TABLES = new ArrayList<>(Arrays.asList(TABLE_AGENT , TABLE_COMMUNITY , TABLE_FARMER, TABLE_FARM));
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Data Set Names">
    protected final static String DATA_SET_AGENT = "agent_data";
    protected final static String DATA_SET_COMMUNITY = "community_data";
    protected final static String DATA_SET_FARMER = "farmer_data";
    protected final static String DATA_SET_FARM = "farm_data";

    protected String getIndicatorTable(String data_set) throws Exception {
        switch (data_set) {
            case DATA_SET_AGENT: return TABLE_AGENT;
            case DATA_SET_COMMUNITY: return TABLE_COMMUNITY;
            case DATA_SET_FARMER: return TABLE_FARMER;
            case DATA_SET_FARM: return TABLE_FARM;
            default:
                throw new Exception("Invalid data set");
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Partner Names">
    protected final static String PARTNER_ACDI = "ACDIVOCA";
    protected final static String PARTNER_MOFA = "MOFA";
    protected final static String PARTNER_GF = "GRAMEEN";
    protected final static String PARTNER_CIF = "CIFCSF";
    protected final static String PARTNER_AIS_BA = "AIS_BA";
    protected final static String PARTNER_AIS_UE = "AIS_UE";
    protected final static String PARTNER_AIS_UW = "AIS_UW";
    protected final static String PARTNER_AIS_NR = "AIS_NR";
    protected final static String PARTNER_AIS_VR = "AIS_VR";
    protected final static String[] PARTNERS = {PARTNER_ACDI, PARTNER_MOFA, PARTNER_CIF, PARTNER_GF,
                                                PARTNER_AIS_BA, PARTNER_AIS_UE, PARTNER_AIS_UW,
                                                PARTNER_AIS_NR, PARTNER_AIS_VR};
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Date/time Helpers">
    protected static int getCurrentYear() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR);
    }

    public List<String> getYears() {
        List<String> years = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        for(int i=year; i >= START_YEAR; i--) {
            years.add(String.valueOf(i));
        }
        return years;
    }

    protected static int getNumOfAxisMonths() {
        int year = getCurrentYear();
        int start_year = (year-1 < START_YEAR) ? START_YEAR : (year-1);
        return ((year-start_year)+1) * 12;
    }

    protected static String[] getYearMonthAxisValues() {
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

    protected static int getYearMonthIdx(int year, int month) {
        return ((year-START_YEAR) * 12) + (month-1);
    }

    protected static ArrayList<Integer> getDateFromCode(String code) {
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

    protected static ArrayList<Integer> getDateFromTime(Long time) {
        ArrayList<Integer> dates = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        Long t = (time==null) ? DEFAULT_TIME : time;
        cal.setTimeInMillis(t);
        dates.add(cal.get(Calendar.YEAR));
        dates.add(cal.get(Calendar.MONTH));
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
            String common = "actual INTEGER, " + time;
            String partner = ", partner VARCHAR(50)";
            String community = ", community VARCHAR(50)";

            String farmMeta = ", acres_planned INTEGER, acres_actual INTEGER, yield_planned INTEGER, yield_actual INTEGER"
                    + ", price_planned INTEGER, price_actual INTEGER, crop VARCHAR(50), season VARCHAR(20)"
                    + ", partner VARCHAR(50), `agent_id` VARCHAR(100) NOT NULL, farmer_id VARCHAR(50)"
                    + ", `gender` VARCHAR(10) NULL , `age` INT NULL , `latitude` VARCHAR(50) NULL "
                    + ", `longitude` VARCHAR(50) NULL , `location` VARCHAR(100) NULL , `pp` INT NOT NULL DEFAULT '0' DEFAULT '0' , `fmp` INT NOT NULL DEFAULT '0' DEFAULT '0' , `fmp_update` INT NOT NULL DEFAULT '0' DEFAULT '0' , `measured` INT NOT NULL DEFAULT '0' DEFAULT '0' , `assessed` INT NOT NULL DEFAULT '0' DEFAULT '0'"
                    + ", `credit_planned` INT NOT NULL DEFAULT '0' , `credit_actual` INT NOT NULL DEFAULT '0', `credit_type` VARCHAR(255) NOT NULL , `ob` INT NOT NULL DEFAULT '0' , `cash_planned` INT NOT NULL DEFAULT '0' , `cash_actual` INT NOT NULL DEFAULT '0' , `cash_amount_planned` FLOAT NOT NULL , `cash_amount_actual` FLOAT NOT NULL , `cash_payback_planned` FLOAT NOT NULL , `cash_payback_actual` FLOAT NOT NULL , `input_planned` INT NOT NULL DEFAULT '0' , `input_actual` INT NOT NULL DEFAULT '0' , `input_payback_planned` FLOAT NOT NULL , `input_payback_actual` FLOAT NOT NULL , `seed_planned` INT NOT NULL DEFAULT '0' , `seed_actual` INT NOT NULL DEFAULT '0' , `fertilizer_planned` INT NOT NULL DEFAULT '0' , `fertilizer_actual` INT NOT NULL DEFAULT '0' , `preplanh_planned` INT NOT NULL DEFAULT '0' , `preplanh_actual` INT NOT NULL DEFAULT '0' , `postplanh_planned` INT NOT NULL DEFAULT '0' , `postplanh_actual` INT NOT NULL DEFAULT '0' , `plough_planned` INT NOT NULL DEFAULT '0' , `plough_actual` INT NOT NULL DEFAULT '0' , `handling_planned` INT NOT NULL DEFAULT '0' , `handling_actual` INT NOT NULL DEFAULT '0' , `transport_planned` INT NOT NULL DEFAULT '0' , `transport_actual` INT NOT NULL DEFAULT '0' , `storage_planned` INT NOT NULL DEFAULT '0' , `storage_actual` INT NOT NULL DEFAULT '0'";

            ICTCDBUtil.getInstance().createTable(TABLE_AGENT, common + partner);
            ICTCDBUtil.getInstance().createTable(TABLE_COMMUNITY, common);
            ICTCDBUtil.getInstance().createTable(TABLE_FARMER, common + partner + community);
            ICTCDBUtil.getInstance().createTable(TABLE_FARM, time + farmMeta);

            if (fillTables) { BIDataManager.getInstance().update(); }
        } catch (Exception e) {
            throw(e);
        }
    }

    // </editor-fold>
}
