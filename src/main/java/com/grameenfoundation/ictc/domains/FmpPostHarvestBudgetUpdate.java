/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.domains;

import com.grameenfoundation.ictc.domain.commons.GeneralInterface;
import com.grameenfoundation.ictc.domain.commons.Status;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Joseph George Davis
 * @date Oct 15, 2015 11:39:15 AM
 * description:
 */
public class FmpPostHarvestBudgetUpdate extends Status implements GeneralInterface {
    
    Node underlyingNode = null;

    public FmpPostHarvestBudgetUpdate(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }
    
    public static String BAGS_FOR_STORAGE_UPDATE="bags_for_storage_update";
    public static String COST_OF_STORAGE_CHEMICAL_UPDATE="cost_of_storage_chemical_update";
    public static String DEHUSKING_FAMILY_LABOR_UPDATE="dehusking_family_labor_update";
    public static String FAMILY_LABOR_BAGGING_UPDATE="family_labor_bagging_update";
    public static String FAMILY_LABOR_DRYING_COBS_UPDATE="family_labor_drying_cobs_update";
    public static String FAMILY_LABOR_DRYING_GRAIN_UPDATE="family_labor_drying_grain_update";
    public static String FAMILY_LABOR_ENGAGED_WINNOWING_UPDATE="family_labor_engaged_winnowing_update";
    public static String FAMILY_LABOR_MANUAL_THRESHING_UPDATE="family_labor_manual_threshing_update";
    public static String GRAIN_DRYING_COST_UPDATE="grain_drying_cost_update";
    public static String LABOR_COST_DEHUSK_UPDATE="labor_cost_dehusk_update";
    public static String LABOR_COST_DRYING_OF_COBS_UPDATE="labor_cost_drying_of_cobs_update";
    public static String LABOR_DRYING_GRAIN_UPDATE="labor_drying_grain_update";
    public static String LABOR_HANDS_DRYINGCOBS_UPDATE="labor_hands_dryingcobs_update";
    public static String LABOR_MANUAL_THRESHING_UPDATE="labor_manual_threshing_update";
    public static String LABOR_PERIOD_DRYING_COBS_UPDATE="labor_period_drying_cobs_update";
    public static String LABOR_PERIOD_MANUAL_THRESH="labor_period_manual_thresh";
    public static String LABOUR_FOR_BAGGING_UPDATE="labour_for_bagging_update";
    public static String LABOUR_WINNOWING_UPDATE="labour_winnowing_update";
    public static String PERIOD_DEHUSK_UPDATE="period_dehusk_update";
    public static String TIME_COMPLETION_OF_BAGGING_UPDATE="time_completion_of_bagging_update";
    public static String TIME_INTERVAL_WINNOWING_UPDATE="time_interval_winnowing_update";
    public static String TIME_PERIOD_LABOR_DRYING_GRAIN_UPDATE="time_period_labor_drying_grain_update";
    public static String UNIT_COST_MACHINE_THRESHING_UPDATE="unit_cost_machine_threshing_update";
    public static String UNIT_COST_MANUAL_THRESHING_UPDATE="unit_cost_manual_threshing_update";
    public static String UNIT_COST_OF_STORAGE_BAGS_UPDATE="unit_cost_of_storage_bags_update";
    public static String UNIT_COST_OF_WAREHOUSE_UPDATE="unit_cost_of_warehouse_update";
    public static String UNIT_LABOR_COST_BAGGING_UPDATE="unit_labor_cost_bagging_update";
    public static String UNIT_LABOR_COST_WINNOWING_UPDATE="unit_labor_cost_winnowing_update";
    
    
public void setUnit_labor_cost_winnowing_update(String unit_labor_cost_winnowing_update) {
underlyingNode.setProperty(UNIT_LABOR_COST_WINNOWING_UPDATE,unit_labor_cost_winnowing_update);
}

public String getUnit_labor_cost_winnowing_update(){
          try {
          return (String) underlyingNode.getProperty(UNIT_LABOR_COST_WINNOWING_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setUnit_labor_cost_bagging_update(String unit_labor_cost_bagging_update) {
underlyingNode.setProperty(UNIT_LABOR_COST_BAGGING_UPDATE,unit_labor_cost_bagging_update);
}

public String getUnit_labor_cost_bagging_update(){
          try {
          return (String) underlyingNode.getProperty(UNIT_LABOR_COST_BAGGING_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setUnit_cost_of_warehouse_update(String unit_cost_of_warehouse_update) {
underlyingNode.setProperty(UNIT_COST_OF_WAREHOUSE_UPDATE,unit_cost_of_warehouse_update);
}

public String getUnit_cost_of_warehouse_update(){
          try {
          return (String) underlyingNode.getProperty(UNIT_COST_OF_WAREHOUSE_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setUnit_cost_of_storage_bags_update(String unit_cost_of_storage_bags_update) {
underlyingNode.setProperty(UNIT_COST_OF_STORAGE_BAGS_UPDATE,unit_cost_of_storage_bags_update);
}

public String getUnit_cost_of_storage_bags_update(){
          try {
          return (String) underlyingNode.getProperty(UNIT_COST_OF_STORAGE_BAGS_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setUnit_cost_manual_threshing_update(String unit_cost_manual_threshing_update) {
underlyingNode.setProperty(UNIT_COST_MANUAL_THRESHING_UPDATE,unit_cost_manual_threshing_update);
}

public String getUnit_cost_manual_threshing_update(){
          try {
          return (String) underlyingNode.getProperty(UNIT_COST_MANUAL_THRESHING_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setUnit_cost_machine_threshing_update(String unit_cost_machine_threshing_update) {
underlyingNode.setProperty(UNIT_COST_MACHINE_THRESHING_UPDATE,unit_cost_machine_threshing_update);
}

public String getUnit_cost_machine_threshing_update(){
          try {
          return (String) underlyingNode.getProperty(UNIT_COST_MACHINE_THRESHING_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setTime_period_labor_drying_grain_update(String time_period_labor_drying_grain_update) {
underlyingNode.setProperty(TIME_PERIOD_LABOR_DRYING_GRAIN_UPDATE,time_period_labor_drying_grain_update);
}

public String getTime_period_labor_drying_grain_update(){
          try {
          return (String) underlyingNode.getProperty(TIME_PERIOD_LABOR_DRYING_GRAIN_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setTime_interval_winnowing_update(String time_interval_winnowing_update) {
underlyingNode.setProperty(TIME_INTERVAL_WINNOWING_UPDATE,time_interval_winnowing_update);
}

public String getTime_interval_winnowing_update(){
          try {
          return (String) underlyingNode.getProperty(TIME_INTERVAL_WINNOWING_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setTime_completion_of_bagging_update(String time_completion_of_bagging_update) {
underlyingNode.setProperty(TIME_COMPLETION_OF_BAGGING_UPDATE,time_completion_of_bagging_update);
}

public String getTime_completion_of_bagging_update(){
          try {
          return (String) underlyingNode.getProperty(TIME_COMPLETION_OF_BAGGING_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setPeriod_dehusk_update(String period_dehusk_update) {
underlyingNode.setProperty(PERIOD_DEHUSK_UPDATE,period_dehusk_update);
}

public String getPeriod_dehusk_update(){
          try {
          return (String) underlyingNode.getProperty(PERIOD_DEHUSK_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setLabour_winnowing_update(String labour_winnowing_update) {
underlyingNode.setProperty(LABOUR_WINNOWING_UPDATE,labour_winnowing_update);
}

public String getLabour_winnowing_update(){
          try {
          return (String) underlyingNode.getProperty(LABOUR_WINNOWING_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setLabour_for_bagging_update(String labour_for_bagging_update) {
underlyingNode.setProperty(LABOUR_FOR_BAGGING_UPDATE,labour_for_bagging_update);
}

public String getLabour_for_bagging_update(){
          try {
          return (String) underlyingNode.getProperty(LABOUR_FOR_BAGGING_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setLabor_period_manual_thresh(String labor_period_manual_thresh) {
underlyingNode.setProperty(LABOR_PERIOD_MANUAL_THRESH,labor_period_manual_thresh);
}

public String getLabor_period_manual_thresh(){
          try {
          return (String) underlyingNode.getProperty(LABOR_PERIOD_MANUAL_THRESH);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setLabor_period_drying_cobs_update(String labor_period_drying_cobs_update) {
underlyingNode.setProperty(LABOR_PERIOD_DRYING_COBS_UPDATE,labor_period_drying_cobs_update);
}

public String getLabor_period_drying_cobs_update(){
          try {
          return (String) underlyingNode.getProperty(LABOR_PERIOD_DRYING_COBS_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setLabor_manual_threshing_update(String labor_manual_threshing_update) {
underlyingNode.setProperty(LABOR_MANUAL_THRESHING_UPDATE,labor_manual_threshing_update);
}

public String getLabor_manual_threshing_update(){
          try {
          return (String) underlyingNode.getProperty(LABOR_MANUAL_THRESHING_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setLabor_hands_dryingcobs_update(String labor_hands_dryingcobs_update) {
underlyingNode.setProperty(LABOR_HANDS_DRYINGCOBS_UPDATE,labor_hands_dryingcobs_update);
}

public String getLabor_hands_dryingcobs_update(){
          try {
          return (String) underlyingNode.getProperty(LABOR_HANDS_DRYINGCOBS_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setLabor_drying_grain_update(String labor_drying_grain_update) {
underlyingNode.setProperty(LABOR_DRYING_GRAIN_UPDATE,labor_drying_grain_update);
}

public String getLabor_drying_grain_update(){
          try {
          return (String) underlyingNode.getProperty(LABOR_DRYING_GRAIN_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setLabor_cost_drying_of_cobs_update(String labor_cost_drying_of_cobs_update) {
underlyingNode.setProperty(LABOR_COST_DRYING_OF_COBS_UPDATE,labor_cost_drying_of_cobs_update);
}

public String getLabor_cost_drying_of_cobs_update(){
          try {
          return (String) underlyingNode.getProperty(LABOR_COST_DRYING_OF_COBS_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setLabor_cost_dehusk_update(String labor_cost_dehusk_update) {
underlyingNode.setProperty(LABOR_COST_DEHUSK_UPDATE,labor_cost_dehusk_update);
}

public String getLabor_cost_dehusk_update(){
          try {
          return (String) underlyingNode.getProperty(LABOR_COST_DEHUSK_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setGrain_drying_cost_update(String grain_drying_cost_update) {
underlyingNode.setProperty(GRAIN_DRYING_COST_UPDATE,grain_drying_cost_update);
}

public String getGrain_drying_cost_update(){
          try {
          return (String) underlyingNode.getProperty(GRAIN_DRYING_COST_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setFamily_labor_manual_threshing_update(String family_labor_manual_threshing_update) {
underlyingNode.setProperty(FAMILY_LABOR_MANUAL_THRESHING_UPDATE,family_labor_manual_threshing_update);
}

public String getFamily_labor_manual_threshing_update(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_MANUAL_THRESHING_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setFamily_labor_engaged_winnowing_update(String family_labor_engaged_winnowing_update) {
underlyingNode.setProperty(FAMILY_LABOR_ENGAGED_WINNOWING_UPDATE,family_labor_engaged_winnowing_update);
}

public String getFamily_labor_engaged_winnowing_update(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_ENGAGED_WINNOWING_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setFamily_labor_drying_grain_update(String family_labor_drying_grain_update) {
underlyingNode.setProperty(FAMILY_LABOR_DRYING_GRAIN_UPDATE,family_labor_drying_grain_update);
}

public String getFamily_labor_drying_grain_update(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_DRYING_GRAIN_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setFamily_labor_drying_cobs_update(String family_labor_drying_cobs_update) {
underlyingNode.setProperty(FAMILY_LABOR_DRYING_COBS_UPDATE,family_labor_drying_cobs_update);
}

public String getFamily_labor_drying_cobs_update(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_DRYING_COBS_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setFamily_labor_bagging_update(String family_labor_bagging_update) {
underlyingNode.setProperty(FAMILY_LABOR_BAGGING_UPDATE,family_labor_bagging_update);
}

public String getFamily_labor_bagging_update(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_BAGGING_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setDehusking_family_labor_update(String dehusking_family_labor_update) {
underlyingNode.setProperty(DEHUSKING_FAMILY_LABOR_UPDATE,dehusking_family_labor_update);
}

public String getDehusking_family_labor_update(){
          try {
          return (String) underlyingNode.getProperty(DEHUSKING_FAMILY_LABOR_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setCost_of_storage_chemical_update(String cost_of_storage_chemical_update) {
underlyingNode.setProperty(COST_OF_STORAGE_CHEMICAL_UPDATE,cost_of_storage_chemical_update);
}

public String getCost_of_storage_chemical_update(){
          try {
          return (String) underlyingNode.getProperty(COST_OF_STORAGE_CHEMICAL_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setBags_for_storage_update(String bags_for_storage_update) {
underlyingNode.setProperty(BAGS_FOR_STORAGE_UPDATE,bags_for_storage_update);
}

public String getBags_for_storage_update(){
          try {
          return (String) underlyingNode.getProperty(BAGS_FOR_STORAGE_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    

}
