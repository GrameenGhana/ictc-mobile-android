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
 * @date Oct 13, 2015 11:25:24 AM
 * description:
 */
public class BaselinePostHarvestBudget extends Status implements GeneralInterface {
    
    Node underlyingNode;

    public BaselinePostHarvestBudget(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }
    
    
    public static String BAGS_FOR_STORAGE_BASE="bags_for_storage_base";
    public static String COST_OF_STORAGE_CHEMICAL_BASE="cost_of_storage_chemical_base";
    public static String DEHUSKINGPEELING_FAMILY_LABOR_BASE="dehuskingpeeling_family_labor_base";
    public static String DEHUSKINGPEELING_LABOR_BASE="dehuskingpeeling_labor_base";
    public static String FAMILY_LABOR_BAGGING_BASE="family_labor_bagging_base";
    public static String FAMILY_LABOR_DRYING_COBS_BASE="family_labor_drying_cobs_base";
    public static String FAMILY_LABOR_DRYING_GRAIN_BASE="family_labor_drying_grain_base";
    public static String FAMILY_LABOR_ENGAGED_WINNOWING_BASE="family_labor_engaged_winnowing_base";
    public static String FAMILY_LABOR_MANUAL_THRESHING_BASE="family_labor_manual_threshing_base";
    public static String GRAIN_DRYING_COST_BASE="grain_drying_cost_base";
    public static String LABOR_COST_DEHUSKINGPEELING_BASE="labor_cost_dehuskingpeeling_base";
    public static String LABOR_COST_DRYING_OF_COBS_BASE="labor_cost_drying_of_cobs_base";
    public static String LABOR_DRYING_GRAIN_BASE="labor_drying_grain_base";
    public static String LABOR_HANDS_DRYINGCOBS_BASE="labor_hands_dryingcobs_base";
    public static String LABOR_MANUAL_THRESHING_BASE="labor_manual_threshing_base";
    public static String LABOR_PERIOD_DRYING_COBS_BASE="labor_period_drying_cobs_base";
    public static String LABOR_PERIOD_MANUAL_THRESHING_BASE="labor_period_manual_threshing_base";
    public static String LABOUR_FOR_BAGGING_BASE="labour_for_bagging_base";
    public static String LABOUR_WINNOWING_BASE="labour_winnowing_base";
    public static String PERIOD_TO_COMPLETE_DEHUSKING_BASE="period_to_complete_dehusking_base";
    public static String TIME_COMPLETION_OF_BAGGING_BASE="time_completion_of_bagging_base";
    public static String TIME_INTERVAL_WINNOWING_BASE="time_interval_winnowing_base";
    public static String TIME_PERIOD_LABOR_DRYING_GRAIN_BASE="time_period_labor_drying_grain_base";
    public static String UNIT_COST_MACHINE_THRESHING_BASE="unit_cost_machine_threshing_base";
    public static String UNIT_COST_MANUAL_THRESHING_BASE="unit_cost_manual_threshing_base";
    public static String UNIT_COST_OF_STORAGE_BAGS_BASE="unit_cost_of_storage_bags_base";
    public static String UNIT_COST_OF_WAREHOUSE_BASE="unit_cost_of_warehouse_base";
    public static String UNIT_LABOR_COST_BAGGING_BASE="unit_labor_cost_bagging_base";
    public static String UNIT_LABOR_COST_WINNOWING_BASE="unit_labor_cost_winnowing_base";
    public static String CROP_TO_CULTIVATE_BASE = "crop_to_cultivate_base";
    public static String PROCESSINGCOSTS="processingcosts";
    public static String TRANSPORTCOSTHOME="transportcosthome";
    public static String TRANSPORTCOSTMARKET="transportcostmarket";
    
    
    
public void setTransportcostmarket(String transportcostmarket) {
underlyingNode.setProperty(TRANSPORTCOSTMARKET,transportcostmarket);
}

public String getTransportcostmarket(){
          try {
          return (String) underlyingNode.getProperty(TRANSPORTCOSTMARKET);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setTransportcosthome(String transportcosthome) {
underlyingNode.setProperty(TRANSPORTCOSTHOME,transportcosthome);
}

public String getTransportcosthome(){
          try {
          return (String) underlyingNode.getProperty(TRANSPORTCOSTHOME);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setProcessingcosts(String processingcosts) {
underlyingNode.setProperty(PROCESSINGCOSTS,processingcosts);
}

public String getProcessingcosts(){
          try {
          return (String) underlyingNode.getProperty(PROCESSINGCOSTS);

        } catch (Exception e) {
        }
        return null;
    }
    public void setCrop_to_cultivate_base(String crop_to_cultivate_base) {
        underlyingNode.setProperty(CROP_TO_CULTIVATE_BASE, crop_to_cultivate_base);
    }

    public String getCrop_to_cultivate_base() {
        try {
            return (String) underlyingNode.getProperty(CROP_TO_CULTIVATE_BASE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setUnit_labor_cost_winnowing_base(String unit_labor_cost_winnowing_base) {
        underlyingNode.setProperty(UNIT_LABOR_COST_WINNOWING_BASE, unit_labor_cost_winnowing_base);
    }

    public String getUnit_labor_cost_winnowing_base() {
        try {
          return (String) underlyingNode.getProperty(UNIT_LABOR_COST_WINNOWING_BASE);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setUnit_labor_cost_bagging_base(String unit_labor_cost_bagging_base) {
underlyingNode.setProperty(UNIT_LABOR_COST_BAGGING_BASE,unit_labor_cost_bagging_base);
}

public String getUnit_labor_cost_bagging_base(){
          try {
          return (String) underlyingNode.getProperty(UNIT_LABOR_COST_BAGGING_BASE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setUnit_cost_of_warehouse_base(String unit_cost_of_warehouse_base) {
underlyingNode.setProperty(UNIT_COST_OF_WAREHOUSE_BASE,unit_cost_of_warehouse_base);
}

public String getUnit_cost_of_warehouse_base(){
          try {
          return (String) underlyingNode.getProperty(UNIT_COST_OF_WAREHOUSE_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setUnit_cost_of_storage_bags_base(String unit_cost_of_storage_bags_base) {
underlyingNode.setProperty(UNIT_COST_OF_STORAGE_BAGS_BASE,unit_cost_of_storage_bags_base);
}

public String getUnit_cost_of_storage_bags_base(){
          try {
          return (String) underlyingNode.getProperty(UNIT_COST_OF_STORAGE_BAGS_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setUnit_cost_manual_threshing_base(String unit_cost_manual_threshing_base) {
underlyingNode.setProperty(UNIT_COST_MANUAL_THRESHING_BASE,unit_cost_manual_threshing_base);
}

public String getUnit_cost_manual_threshing_base(){
          try {
          return (String) underlyingNode.getProperty(UNIT_COST_MANUAL_THRESHING_BASE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setUnit_cost_machine_threshing_base(String unit_cost_machine_threshing_base) {
underlyingNode.setProperty(UNIT_COST_MACHINE_THRESHING_BASE,unit_cost_machine_threshing_base);
}

public String getUnit_cost_machine_threshing_base(){
          try {
          return (String) underlyingNode.getProperty(UNIT_COST_MACHINE_THRESHING_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setTime_period_labor_drying_grain_base(String time_period_labor_drying_grain_base) {
underlyingNode.setProperty(TIME_PERIOD_LABOR_DRYING_GRAIN_BASE,time_period_labor_drying_grain_base);
}

public String getTime_period_labor_drying_grain_base(){
          try {
          return (String) underlyingNode.getProperty(TIME_PERIOD_LABOR_DRYING_GRAIN_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setTime_interval_winnowing_base(String time_interval_winnowing_base) {
underlyingNode.setProperty(TIME_INTERVAL_WINNOWING_BASE,time_interval_winnowing_base);
}

public String getTime_interval_winnowing_base(){
          try {
          return (String) underlyingNode.getProperty(TIME_INTERVAL_WINNOWING_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setTime_completion_of_bagging_base(String time_completion_of_bagging_base) {
underlyingNode.setProperty(TIME_COMPLETION_OF_BAGGING_BASE,time_completion_of_bagging_base);
}

public String getTime_completion_of_bagging_base(){
          try {
          return (String) underlyingNode.getProperty(TIME_COMPLETION_OF_BAGGING_BASE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
    
public void setPeriod_to_complete_dehusking_base(String period_to_complete_dehusking_base) {
underlyingNode.setProperty(PERIOD_TO_COMPLETE_DEHUSKING_BASE,period_to_complete_dehusking_base);
}

public String getPeriod_to_complete_dehusking_base(){
          try {
          return (String) underlyingNode.getProperty(PERIOD_TO_COMPLETE_DEHUSKING_BASE);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setLabour_winnowing_base(String labour_winnowing_base) {
underlyingNode.setProperty(LABOUR_WINNOWING_BASE,labour_winnowing_base);
}

public String getLabour_winnowing_base(){
          try {
          return (String) underlyingNode.getProperty(LABOUR_WINNOWING_BASE);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setLabour_for_bagging_base(String labour_for_bagging_base) {
underlyingNode.setProperty(LABOUR_FOR_BAGGING_BASE,labour_for_bagging_base);
}

public String getLabour_for_bagging_base(){
          try {
          return (String) underlyingNode.getProperty(LABOUR_FOR_BAGGING_BASE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setLabor_period_manual_threshing_base(String labor_period_manual_threshing_base) {
underlyingNode.setProperty(LABOR_PERIOD_MANUAL_THRESHING_BASE,labor_period_manual_threshing_base);
}

public String getLabor_period_manual_threshing_base(){
          try {
          return (String) underlyingNode.getProperty(LABOR_PERIOD_MANUAL_THRESHING_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setLabor_period_drying_cobs_base(String labor_period_drying_cobs_base) {
underlyingNode.setProperty(LABOR_PERIOD_DRYING_COBS_BASE,labor_period_drying_cobs_base);
}

public String getLabor_period_drying_cobs_base(){
          try {
          return (String) underlyingNode.getProperty(LABOR_PERIOD_DRYING_COBS_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setLabor_manual_threshing_base(String labor_manual_threshing_base) {
underlyingNode.setProperty(LABOR_MANUAL_THRESHING_BASE,labor_manual_threshing_base);
}

public String getLabor_manual_threshing_base(){
          try {
          return (String) underlyingNode.getProperty(LABOR_MANUAL_THRESHING_BASE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setLabor_hands_dryingcobs_base(String labor_hands_dryingcobs_base) {
underlyingNode.setProperty(LABOR_HANDS_DRYINGCOBS_BASE,labor_hands_dryingcobs_base);
}

public String getLabor_hands_dryingcobs_base(){
          try {
          return (String) underlyingNode.getProperty(LABOR_HANDS_DRYINGCOBS_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setLabor_drying_grain_base(String labor_drying_grain_base) {
underlyingNode.setProperty(LABOR_DRYING_GRAIN_BASE,labor_drying_grain_base);
}

public String getLabor_drying_grain_base(){
          try {
          return (String) underlyingNode.getProperty(LABOR_DRYING_GRAIN_BASE);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setLabor_cost_drying_of_cobs_base(String labor_cost_drying_of_cobs_base) {
underlyingNode.setProperty(LABOR_COST_DRYING_OF_COBS_BASE,labor_cost_drying_of_cobs_base);
}

public String getLabor_cost_drying_of_cobs_base(){
          try {
          return (String) underlyingNode.getProperty(LABOR_COST_DRYING_OF_COBS_BASE);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setLabor_cost_dehuskingpeeling_base(String labor_cost_dehuskingpeeling_base) {
underlyingNode.setProperty(LABOR_COST_DEHUSKINGPEELING_BASE,labor_cost_dehuskingpeeling_base);
}

public String getLabor_cost_dehuskingpeeling_base(){
          try {
          return (String) underlyingNode.getProperty(LABOR_COST_DEHUSKINGPEELING_BASE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setGrain_drying_cost_base(String grain_drying_cost_base) {
underlyingNode.setProperty(GRAIN_DRYING_COST_BASE,grain_drying_cost_base);
}

public String getGrain_drying_cost_base(){
          try {
          return (String) underlyingNode.getProperty(GRAIN_DRYING_COST_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setFamily_labor_manual_threshing_base(String family_labor_manual_threshing_base) {
underlyingNode.setProperty(FAMILY_LABOR_MANUAL_THRESHING_BASE,family_labor_manual_threshing_base);
}

public String getFamily_labor_manual_threshing_base(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_MANUAL_THRESHING_BASE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setFamily_labor_engaged_winnowing_base(String family_labor_engaged_winnowing_base) {
underlyingNode.setProperty(FAMILY_LABOR_ENGAGED_WINNOWING_BASE,family_labor_engaged_winnowing_base);
}

public String getFamily_labor_engaged_winnowing_base(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_ENGAGED_WINNOWING_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setFamily_labor_drying_grain_base(String family_labor_drying_grain_base) {
underlyingNode.setProperty(FAMILY_LABOR_DRYING_GRAIN_BASE,family_labor_drying_grain_base);
}

public String getFamily_labor_drying_grain_base(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_DRYING_GRAIN_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setFamily_labor_drying_cobs_base(String family_labor_drying_cobs_base) {
underlyingNode.setProperty(FAMILY_LABOR_DRYING_COBS_BASE,family_labor_drying_cobs_base);
}

public String getFamily_labor_drying_cobs_base(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_DRYING_COBS_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setFamily_labor_bagging_base(String family_labor_bagging_base) {
underlyingNode.setProperty(FAMILY_LABOR_BAGGING_BASE,family_labor_bagging_base);
}

public String getFamily_labor_bagging_base(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_BAGGING_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setDehuskingpeeling_labor_base(String dehuskingpeeling_labor_base) {
underlyingNode.setProperty(DEHUSKINGPEELING_LABOR_BASE,dehuskingpeeling_labor_base);
}

public String getDehuskingpeeling_labor_base(){
          try {
          return (String) underlyingNode.getProperty(DEHUSKINGPEELING_LABOR_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setDehuskingpeeling_family_labor_base(String dehuskingpeeling_family_labor_base) {
underlyingNode.setProperty(DEHUSKINGPEELING_FAMILY_LABOR_BASE,dehuskingpeeling_family_labor_base);
}

public String getDehuskingpeeling_family_labor_base(){
          try {
          return (String) underlyingNode.getProperty(DEHUSKINGPEELING_FAMILY_LABOR_BASE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setCost_of_storage_chemical_base(String cost_of_storage_chemical_base) {
underlyingNode.setProperty(COST_OF_STORAGE_CHEMICAL_BASE,cost_of_storage_chemical_base);
}

public String getCost_of_storage_chemical_base(){
          try {
          return (String) underlyingNode.getProperty(COST_OF_STORAGE_CHEMICAL_BASE);

        } catch (Exception e) {
        }
        return null;
    }

public void setBags_for_storage_base(String bags_for_storage_base) {
underlyingNode.setProperty(BAGS_FOR_STORAGE_BASE,bags_for_storage_base);
}

public String getBags_for_storage_base(){
          try {
          return (String) underlyingNode.getProperty(BAGS_FOR_STORAGE_BASE);

        } catch (Exception e) {
        }
        return null;
    }

}
