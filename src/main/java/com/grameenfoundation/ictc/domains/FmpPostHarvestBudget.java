/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.domains;

import com.grameenfoundation.ictc.domain.commons.GeneralInterface;
import com.grameenfoundation.ictc.domain.commons.Status;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Joseph George Davis
 * @date Oct 14, 2015 4:10:47 PM
 * description:
 */
public class FmpPostHarvestBudget extends Status implements GeneralInterface {

    Node underlyingNode = null;
    
    public FmpPostHarvestBudget(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }
    
 public static String BAGS_FOR_STORAGE_="bags_for_storage_";
 public static String COST_OF_STORAGE_CHEMICAL="cost_of_storage_chemical";
 public static String COST_OF_WAREHOUSE="cost_of_warehouse";
 public static String DEHUSKINGPEELING_FAMILY_LABOR="dehuskingpeeling_family_labor";
 public static String DEHUSKINGPEELING_LABOR="dehuskingpeeling_labor";
 public static String FAMILY_LABOR_BAGGING="family_labor_bagging";
 public static String FAMILY_LABOR_DRYING_GRAIN="family_labor_drying_grain";
 public static String FAMILY_LABOR_DRYINGCOBS_="family_labor_dryingcobs_";
 public static String FAMILY_LABOR_MANUAL_THRESHING="family_labor_manual_threshing";
 public static String FAMILY_LABOR_ENGAGED_WINNOWING="family_labor_engaged_winnowing";
 public static String GRAIN_DRYING_COST="grain_drying_cost";
 public static String LABOR_COST_DEHUSKINGPEELING="labor_cost_dehuskingpeeling";
 public static String LABOR_COST_DRYING_OF_COBS="labor_cost_drying_of_cobs";
 public static String LABOR_DRYING_GRAIN="labor_drying_grain";
 public static String LABOR_HANDS_DRYINGCOBS="labor_hands_dryingcobs";
 public static String LABOR_MANUAL_THRESHING="labor_manual_threshing";
 public static String LABOR_PERIOD_DRYING_COBS="labor_period_drying_cobs";
 public static String LABOR_PERIOD_MANUAL_THRESHING="labor_period_manual_threshing";
 public static String LABOUR_FOR_BAGGING="labour_for_bagging";
 public static String LABOUR_WINNOWING="labour_winnowing";
 public static String TIME_INTERVAL_FOR_COMPLETION_OF_BAGGING="time_interval_for_completion_of_bagging";
 public static String TIME_INTERVAL_FOR_WINNOWING="time_interval_for_winnowing";
 public static String TIME_PERIOD_LABOR_DRYING_GRAIN="time_period_labor_drying_grain";
 public static String UNIT_COST_MACHINE_THRESHING="unit_cost_machine_threshing";
 public static String UNIT_COST_MANUAL_THRESHING="unit_cost_manual_threshing";
 public static String UNIT_COST_OF_STORAGE_BAGS="unit_cost_of_storage_bags";
 public static String UNIT_LABOR_COST_BAGGING="unit_labor_cost_bagging";
 public static String LABOR_PERIOD_DEHUSKING="labor_period_dehusking";
 public static String REFERENCE_SEASON_CURRENT="reference_season_current";
 public static String REFERENCE_YEAR_CURRENT="reference_year_current";
 public static String PROCESSINGCOSTS1="processingcosts1";
 public static String TRANSPORTCOSTHOME1="transportcosthome1";
 public static String TRANSPORTCOSTMARKET1="transportcostmarket1";
 
 
public void setTransportcostmarket1(String transportcostmarket1) {
underlyingNode.setProperty(TRANSPORTCOSTMARKET1,transportcostmarket1);
}

public String getTransportcostmarket1(){
          try {
          return (String) underlyingNode.getProperty(TRANSPORTCOSTMARKET1);

        } catch (Exception e) {
        }
        return null;
    }

 
 
 
public void setTransportcosthome1(String transportcosthome1) {
underlyingNode.setProperty(TRANSPORTCOSTHOME1,transportcosthome1);
}

public String getTransportcosthome1(){
          try {
          return (String) underlyingNode.getProperty(TRANSPORTCOSTHOME1);

        } catch (Exception e) {
        }
        return null;
    }

 
public void setProcessingcosts1(String processingcosts1) {
underlyingNode.setProperty(PROCESSINGCOSTS1,processingcosts1);
}

public String getProcessingcosts1(){
          try {
          return (String) underlyingNode.getProperty(PROCESSINGCOSTS1);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setReference_year_current(String reference_year_current) {
underlyingNode.setProperty(REFERENCE_YEAR_CURRENT,reference_year_current);
}

public String getReference_year_current(){
          try {
          return (String) underlyingNode.getProperty(REFERENCE_YEAR_CURRENT);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setReference_season_current(String reference_season_current) {
underlyingNode.setProperty(REFERENCE_SEASON_CURRENT,reference_season_current);
}

public String getReference_season_current(){
          try {
          return (String) underlyingNode.getProperty(REFERENCE_SEASON_CURRENT);

        } catch (Exception e) {
        }
        return null;
    }
 
public void setLabor_period_dehusking(String labor_period_dehusking) {
underlyingNode.setProperty(LABOR_PERIOD_DEHUSKING,labor_period_dehusking);
}

public String getLabor_period_dehusking(){
          try {
          return (String) underlyingNode.getProperty(LABOR_PERIOD_DEHUSKING);

        } catch (Exception e) {
        }
        return null;
    }
 
public void setUnit_labor_cost_bagging(String unit_labor_cost_bagging) {
underlyingNode.setProperty(UNIT_LABOR_COST_BAGGING,unit_labor_cost_bagging);
}

public String getUnit_labor_cost_bagging(){
          try {
          return (String) underlyingNode.getProperty(UNIT_LABOR_COST_BAGGING);

        } catch (Exception e) {
        }
        return null;
    }

 
public void setUnit_cost_of_storage_bags(String unit_cost_of_storage_bags) {
underlyingNode.setProperty(UNIT_COST_OF_STORAGE_BAGS,unit_cost_of_storage_bags);
}

public String getUnit_cost_of_storage_bags(){
          try {
          return (String) underlyingNode.getProperty(UNIT_COST_OF_STORAGE_BAGS);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setUnit_cost_manual_threshing(String unit_cost_manual_threshing) {
underlyingNode.setProperty(UNIT_COST_MANUAL_THRESHING,unit_cost_manual_threshing);
}

public String getUnit_cost_manual_threshing(){
          try {
          return (String) underlyingNode.getProperty(UNIT_COST_MANUAL_THRESHING);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setUnit_cost_machine_threshing(String unit_cost_machine_threshing) {
underlyingNode.setProperty(UNIT_COST_MACHINE_THRESHING,unit_cost_machine_threshing);
}

public String getUnit_cost_machine_threshing(){
          try {
          return (String) underlyingNode.getProperty(UNIT_COST_MACHINE_THRESHING);

        } catch (Exception e) {
        }
        return null;
    }
 
public void setTime_period_labor_drying_grain(String time_period_labor_drying_grain) {
underlyingNode.setProperty(TIME_PERIOD_LABOR_DRYING_GRAIN,time_period_labor_drying_grain);
}

public String getTime_period_labor_drying_grain(){
          try {
          return (String) underlyingNode.getProperty(TIME_PERIOD_LABOR_DRYING_GRAIN);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setTime_interval_for_winnowing(String time_interval_for_winnowing) {
underlyingNode.setProperty(TIME_INTERVAL_FOR_WINNOWING,time_interval_for_winnowing);
}

public String getTime_interval_for_winnowing(){
          try {
          return (String) underlyingNode.getProperty(TIME_INTERVAL_FOR_WINNOWING);

        } catch (Exception e) {
        }
        return null;
    }
 
public void setTime_interval_for_completion_of_bagging(String time_interval_for_completion_of_bagging) {
underlyingNode.setProperty(TIME_INTERVAL_FOR_COMPLETION_OF_BAGGING,time_interval_for_completion_of_bagging);
}

public String getTime_interval_for_completion_of_bagging(){
          try {
          return (String) underlyingNode.getProperty(TIME_INTERVAL_FOR_COMPLETION_OF_BAGGING);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setLabour_winnowing(String labour_winnowing) {
underlyingNode.setProperty(LABOUR_WINNOWING,labour_winnowing);
}

public String getLabour_winnowing(){
          try {
          return (String) underlyingNode.getProperty(LABOUR_WINNOWING);

        } catch (Exception e) {
        }
        return null;
    }
 
public void setLabour_for_bagging(String labour_for_bagging) {
underlyingNode.setProperty(LABOUR_FOR_BAGGING,labour_for_bagging);
}

public String getLabour_for_bagging(){
          try {
          return (String) underlyingNode.getProperty(LABOUR_FOR_BAGGING);

        } catch (Exception e) {
        }
        return null;
    }
 
public void setLabor_period_manual_threshing(String labor_period_manual_threshing) {
underlyingNode.setProperty(LABOR_PERIOD_MANUAL_THRESHING,labor_period_manual_threshing);
}

public String getLabor_period_manual_threshing(){
          try {
          return (String) underlyingNode.getProperty(LABOR_PERIOD_MANUAL_THRESHING);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setLabor_period_drying_cobs(String labor_period_drying_cobs) {
underlyingNode.setProperty(LABOR_PERIOD_DRYING_COBS,labor_period_drying_cobs);
}

public String getLabor_period_drying_cobs(){
          try {
          return (String) underlyingNode.getProperty(LABOR_PERIOD_DRYING_COBS);

        } catch (Exception e) {
        }
        return null;
    }

 
public void setLabor_manual_threshing(String labor_manual_threshing) {
underlyingNode.setProperty(LABOR_MANUAL_THRESHING,labor_manual_threshing);
}

public String getLabor_manual_threshing(){
          try {
          return (String) underlyingNode.getProperty(LABOR_MANUAL_THRESHING);

        } catch (Exception e) {
        }
        return null;
    }
 
public void setLabor_hands_dryingcobs(String labor_hands_dryingcobs) {
underlyingNode.setProperty(LABOR_HANDS_DRYINGCOBS,labor_hands_dryingcobs);
}

public String getLabor_hands_dryingcobs(){
          try {
          return (String) underlyingNode.getProperty(LABOR_HANDS_DRYINGCOBS);

        } catch (Exception e) {
        }
        return null;
    }
 
public void setLabor_drying_grain(String labor_drying_grain) {
underlyingNode.setProperty(LABOR_DRYING_GRAIN,labor_drying_grain);
}

public String getLabor_drying_grain(){
          try {
          return (String) underlyingNode.getProperty(LABOR_DRYING_GRAIN);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setLabor_cost_drying_of_cobs(String labor_cost_drying_of_cobs) {
underlyingNode.setProperty(LABOR_COST_DRYING_OF_COBS,labor_cost_drying_of_cobs);
}

public String getLabor_cost_drying_of_cobs(){
          try {
          return (String) underlyingNode.getProperty(LABOR_COST_DRYING_OF_COBS);

        } catch (Exception e) {
        }
        return null;
    }

 
public void setLabor_cost_dehuskingpeeling(String labor_cost_dehuskingpeeling) {
underlyingNode.setProperty(LABOR_COST_DEHUSKINGPEELING,labor_cost_dehuskingpeeling);
}

public String getLabor_cost_dehuskingpeeling(){
          try {
          return (String) underlyingNode.getProperty(LABOR_COST_DEHUSKINGPEELING);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setGrain_drying_cost(String grain_drying_cost) {
underlyingNode.setProperty(GRAIN_DRYING_COST,grain_drying_cost);
}

public String getGrain_drying_cost(){
          try {
          return (String) underlyingNode.getProperty(GRAIN_DRYING_COST);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setFamily_labor_engaged_winnowing(String family_labor_engaged_winnowing) {
underlyingNode.setProperty(FAMILY_LABOR_ENGAGED_WINNOWING,family_labor_engaged_winnowing);
}

public String getFamily_labor_engaged_winnowing(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_ENGAGED_WINNOWING);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setFamily_labor_manual_threshing(String family_labor_manual_threshing) {
underlyingNode.setProperty(FAMILY_LABOR_MANUAL_THRESHING,family_labor_manual_threshing);
}

public String getFamily_labor_manual_threshing(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_MANUAL_THRESHING);

        } catch (Exception e) {
        }
        return null;
    }
 
public void setFamily_labor_dryingcobs_(String family_labor_dryingcobs_) {
underlyingNode.setProperty(FAMILY_LABOR_DRYINGCOBS_,family_labor_dryingcobs_);
}

public String getFamily_labor_dryingcobs_(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_DRYINGCOBS_);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setFamily_labor_drying_grain(String family_labor_drying_grain) {
underlyingNode.setProperty(FAMILY_LABOR_DRYING_GRAIN,family_labor_drying_grain);
}

public String getFamily_labor_drying_grain(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_DRYING_GRAIN);

        } catch (Exception e) {
        }
        return null;
    }
 
public void setFamily_labor_bagging(String family_labor_bagging) {
underlyingNode.setProperty(FAMILY_LABOR_BAGGING,family_labor_bagging);
}

public String getFamily_labor_bagging(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_BAGGING);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setDehuskingpeeling_labor(String dehuskingpeeling_labor) {
underlyingNode.setProperty(DEHUSKINGPEELING_LABOR,dehuskingpeeling_labor);
}

public String getDehuskingpeeling_labor(){
          try {
          return (String) underlyingNode.getProperty(DEHUSKINGPEELING_LABOR);

        } catch (Exception e) {
        }
        return null;
    }

 
public void setDehuskingpeeling_family_labor(String dehuskingpeeling_family_labor) {
underlyingNode.setProperty(DEHUSKINGPEELING_FAMILY_LABOR,dehuskingpeeling_family_labor);
}

public String getDehuskingpeeling_family_labor(){
          try {
          return (String) underlyingNode.getProperty(DEHUSKINGPEELING_FAMILY_LABOR);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setCost_of_warehouse(String cost_of_warehouse) {
underlyingNode.setProperty(COST_OF_WAREHOUSE,cost_of_warehouse);
}

public String getCost_of_warehouse(){
          try {
          return (String) underlyingNode.getProperty(COST_OF_WAREHOUSE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setCost_of_storage_chemical(String cost_of_storage_chemical) {
underlyingNode.setProperty(COST_OF_STORAGE_CHEMICAL,cost_of_storage_chemical);
}

public String getCost_of_storage_chemical(){
          try {
          return (String) underlyingNode.getProperty(COST_OF_STORAGE_CHEMICAL);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setBags_for_storage_(String bags_for_storage_) {
underlyingNode.setProperty(BAGS_FOR_STORAGE_,bags_for_storage_);
}

public String getBags_for_storage_(){
          try {
          return (String) underlyingNode.getProperty(BAGS_FOR_STORAGE_);

        } catch (Exception e) {
        }
        return null;
    }


public void setUpdate(Node FMPPHBU) {
        underlyingNode.createRelationshipTo(FMPPHBU, ICTCRelationshipTypes.UPDATE);
    }

    public FmpPostHarvestBudgetUpdate getUpdate() {
        return new FmpPostHarvestBudgetUpdate(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.UPDATE));
    }

}
