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
 * @date Oct 14, 2015 10:43:32 AM
 * description:
 */
public class FmpProductionBudgetUpdate extends Status implements GeneralInterface  {
  Node underlyingNode = null;  
  
    public FmpProductionBudgetUpdate(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }
    
    
    public static String BASAL_FERT_LABOR_PERIOD_UPDATE="basal_fert_labor_period_update";
    public static String BASAL_FERTILIZER_APPL_LAB_UPDATE="basal_fertilizer_appl_lab_update";
    public static String COST_OF_APPLICATIONTOPDRESS_UPDATE="cost_of_applicationtopdress_update";
    public static String FAMILY_LABOR_BASAL_FERT_UPDATE="family_labor_basal_fert_update";
    public static String FAMILY_LABOR_FIFTH_WEED_CONTROL_UPDATE="family_labor_fifth_weed_control_update";
    public static String FAMILY_LABOR_FIRST_MANUAL_WEED_UPDATE="family_labor_first_manual_weed_update";
    public static String FAMILY_LABOR_SECOND_WEED_UPDATE="family_labor_second_weed_update";
    public static String FAMILY_LABOR_THIRD_WEED_UPDATE="family_labor_third_weed_update";
    public static String FAMILY_LABOR_TOPDRESS_FERTILIZER_APPLICA="family_labor_topdress_fertilizer_applica";
    public static String FERTILIZER_APP_LABOUR_COST_UPDATE="fertilizer_app_labour_cost_update";
    public static String FIFTH_WEEDING_LABOR_PERIOD_UPDATE="fifth_weeding_labor_period_update";
    public static String FINAL_HARVEST_LABOR_NO_UPDATE="final_harvest_labor_no_update";
    public static String FIRST_WEEDING_PERIOD_UPDATE="first_weeding_period_update";
    public static String FOURTH_WEED_CONTROL_LABOR_UPDATE="fourth_weed_control_labor_update";
    public static String FOURTH_WEEDING_LABOR_PERIOD_UPDATE="fourth_weeding_labor_period_update";
    public static String HARROWING_COST_PER_ACRE_UPDATE="harrowing_cost_per_acre_update";
    public static String HARVEST_LABOR_COSTS_PER_ACRE_UPDATE="harvest_labor_costs_per_acre_update";
    public static String HERBICIDE_APP_LABOR_PERIOD_UPDATE="herbicide_app_labor_period_update";
    public static String HERBICIDE_APPLICATION_COST_UPDATE="herbicide_application_cost_update";
    public static String HOE_PLOUGHING_LABOUR_FAMILY_UPDATE="hoe_ploughing_labour_family_update";
    public static String HOE_PLOUGHING_LABOUR_HOW_MANY_UPDATE="hoe_ploughing_labour_how_many_update";
    public static String HOE_PLOUGHING_LABOUR_PERIOD_UPDATE="hoe_ploughing_labour_period_update";
    public static String LABOR_FIFTH_WEED_CONTROL_UPDATE="labor_fifth_weed_control_update";
    public static String LABOR_FOR_PLANTING_NUMBER_UPDATE="labor_for_planting_number_update";
    public static String LABOR_FOR_PLANTINGFAMILY_UPDATE="labor_for_plantingfamily_update";
    public static String LABOR_FOURTH_WEED_CONTROL_UPDATE="labor_fourth_weed_control_update";
    public static String LABOR_NO_FIRST_MANUAL_WEED_UPDATE="labor_no_first_manual_weed_update";
    public static String LABOR_THIRD_WEED_CONTROL_UPDATE="labor_third_weed_control_update";
    public static String LAND_RENT_UPDATE="land_rent_update";
    public static String PERIOD_FOR_COMPLETION_OF_HARVEST_UPDATE="period_for_completion_of_harvest_update";
    public static String PLANTING_LABOR_COST_UPDATE="planting_labor_cost_update";
    public static String PLANTING_PERIOD2_UPDATE="planting_period2_update";
    public static String PLOUGHING_COST_PER_ACRE_UPDATE="ploughing_cost_per_acre_update";
    public static String POST_HERBICIDE_APPLICATION_COST_UPDATE="post_herbicide_application_cost_update";
    public static String POST_PLANT_HERBICIDE_COST_UPDATE="post_plant_herbicide_cost_update"; 
    public static String PRICE_OF_BASAL_FERTILIZER_UPDATE="price_of_basal_fertilizer_update";
    public static String PRICE_OF_HERBICIDE_UPDATE="price_of_herbicide_update";
    public static String PRICE_OF_TOPDRESS_FERTILIZER_UPDATE="price_of_topdress_fertilizer_update";
    public static String QUANTITY_OF_PREPLANT_HERBICIDE_UPDATE="quantity_of_preplant_herbicide_update";
    public static String REFILLING_LABOR_FAMILY_UPDATE="refilling_labor_family_update";
    public static String REFILLING_LABOR_PERIOD_UPDATE="refilling_labor_period_update";
    public static String REFILLING_LABOUR_COST="refilling_labour_cost";
    public static String REFILLING_LABOUR_NO_UPDATE="refilling_labour_no_update";
    public static String SECOND_WEED_LABOR_UPDATE="second_weed_labor_update";
    public static String SECOND_WEED_PERIOD_UPDATE="second_weed_period_update";
    public static String SEED_BED_PREPARATION_PERIOD_UPDATE="seed_bed_preparation_period_update";
    public static String SEEDBED_LABOR_COST_UPDATE="seedbed_labor_cost_update";
    public static String SEEDBED_LABOR_NUMBER_UPDATE="seedbed_labor_number_update";
    public static String SEEDBED_LABOUR_FAMILY_UPDATE="seedbed_labour_family_update";
    public static String SEEDPLANTING_MATERIAL_COST_UPDATE="seedplanting_material_cost_update";
    public static String THIRD_WEEDING_PERIOD_UPDATE="third_weeding_period_update";
    public static String TOPDRESS_FERT_LABOR_PERIOD_UPDATE="topdress_fert_labor_period_update";
    public static String TOTAL_COST_FIFTH_WEED_UPDATE="total_cost_fifth_weed_update";
    public static String TOTAL_COST_FIRST_MANUAL_WEED_UPDATE="total_cost_first_manual_weed_update";
    public static String TOTAL_COST_FOURTH_WEED_UPDATE="total_cost_fourth_weed_update";
    public static String TOTAL_COST_SECOND_WEED_UPDATE="total_cost_second_weed_update";
    public static String TOTAL_COST_THIRD_WEED_UPDATE="total_cost_third_weed_update";
    public static String TOTAL_NUMBER_OF_LABOR_TOPDRESS_UPDATE="total_number_of_labor_topdress_update";
    public static String UNIT_COST_HOE_PLOUGHING_UPDATE="unit_cost_hoe_ploughing_update";
    public static String BASALFERTAPPLICATIONCOSTUPDATE="basalfertapplicationcostupdate";
    public static String FAMILY_LABOR_FOURTH_WEEDING_UPDATE="family_labor_fourth_weeding_update";
    public static String HERBICIDEPOSTPLANT1QUANTITY="herbicidepostplant1quantity";
    public static String HERBICIDEPOSTPLANT2QUANTITY="herbicidepostplant2quantity";
    public static String POSTPLANTHERBICIDE2APPLICATIONCOST="postplantherbicide2applicationcost";
    public static String POSTPLANTHERBICIDE2APPLICATIONPERIOD="postplantherbicide2applicationperiod";
    public static String POSTPLANTHERBICIDE2PRICE="postplantherbicide2price";
    public static String QTYOFBASALFERTILIZERUPDATE="qtyofbasalfertilizerupdate";
    public static String QTYTOPDRESSFERTILIZERUPDATE="qtytopdressfertilizerupdate";
    
    
public void setQtytopdressfertilizerupdate(String qtytopdressfertilizerupdate) {
underlyingNode.setProperty(QTYTOPDRESSFERTILIZERUPDATE,qtytopdressfertilizerupdate);
}

public String getQtytopdressfertilizerupdate(){
          try {
          return (String) underlyingNode.getProperty(QTYTOPDRESSFERTILIZERUPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setQtyofbasalfertilizerupdate(String qtyofbasalfertilizerupdate) {
underlyingNode.setProperty(QTYOFBASALFERTILIZERUPDATE,qtyofbasalfertilizerupdate);
}

public String getQtyofbasalfertilizerupdate(){
          try {
          return (String) underlyingNode.getProperty(QTYOFBASALFERTILIZERUPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setPostplantherbicide2price(String postplantherbicide2price) {
underlyingNode.setProperty(POSTPLANTHERBICIDE2PRICE,postplantherbicide2price);
}

public String getPostplantherbicide2price(){
          try {
          return (String) underlyingNode.getProperty(POSTPLANTHERBICIDE2PRICE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setPostplantherbicide2applicationperiod(String postplantherbicide2applicationperiod) {
underlyingNode.setProperty(POSTPLANTHERBICIDE2APPLICATIONPERIOD,postplantherbicide2applicationperiod);
}

public String getPostplantherbicide2applicationperiod(){
          try {
          return (String) underlyingNode.getProperty(POSTPLANTHERBICIDE2APPLICATIONPERIOD);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setPostplantherbicide2applicationcost(String postplantherbicide2applicationcost) {
underlyingNode.setProperty(POSTPLANTHERBICIDE2APPLICATIONCOST,postplantherbicide2applicationcost);
}

public String getPostplantherbicide2applicationcost(){
          try {
          return (String) underlyingNode.getProperty(POSTPLANTHERBICIDE2APPLICATIONCOST);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setHerbicidepostplant2quantity(String herbicidepostplant2quantity) {
underlyingNode.setProperty(HERBICIDEPOSTPLANT2QUANTITY,herbicidepostplant2quantity);
}

public String getHerbicidepostplant2quantity(){
          try {
          return (String) underlyingNode.getProperty(HERBICIDEPOSTPLANT2QUANTITY);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setHerbicidepostplant1quantity(String herbicidepostplant1quantity) {
underlyingNode.setProperty(HERBICIDEPOSTPLANT1QUANTITY,herbicidepostplant1quantity);
}

public String getHerbicidepostplant1quantity(){
          try {
          return (String) underlyingNode.getProperty(HERBICIDEPOSTPLANT1QUANTITY);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setFamily_labor_fourth_weeding_update(String family_labor_fourth_weeding_update) {
underlyingNode.setProperty(FAMILY_LABOR_FOURTH_WEEDING_UPDATE,family_labor_fourth_weeding_update);
}

public String getFamily_labor_fourth_weeding_update(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_FOURTH_WEEDING_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setBasalfertapplicationcostupdate(String basalfertapplicationcostupdate) {
underlyingNode.setProperty(BASALFERTAPPLICATIONCOSTUPDATE,basalfertapplicationcostupdate);
}

public String getBasalfertapplicationcostupdate(){
          try {
          return (String) underlyingNode.getProperty(BASALFERTAPPLICATIONCOSTUPDATE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setUnit_cost_hoe_ploughing_update(String unit_cost_hoe_ploughing_update) {
underlyingNode.setProperty(UNIT_COST_HOE_PLOUGHING_UPDATE,unit_cost_hoe_ploughing_update);
}

public String getUnit_cost_hoe_ploughing_update(){
          try {
          return (String) underlyingNode.getProperty(UNIT_COST_HOE_PLOUGHING_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setTotal_number_of_labor_topdress_update(String total_number_of_labor_topdress_update) {
underlyingNode.setProperty(TOTAL_NUMBER_OF_LABOR_TOPDRESS_UPDATE,total_number_of_labor_topdress_update);
}

public String getTotal_number_of_labor_topdress_update(){
          try {
          return (String) underlyingNode.getProperty(TOTAL_NUMBER_OF_LABOR_TOPDRESS_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setTotal_cost_third_weed_update(String total_cost_third_weed_update) {
underlyingNode.setProperty(TOTAL_COST_THIRD_WEED_UPDATE,total_cost_third_weed_update);
}

public String getTotal_cost_third_weed_update(){
          try {
          return (String) underlyingNode.getProperty(TOTAL_COST_THIRD_WEED_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setTotal_cost_second_weed_update(String total_cost_second_weed_update) {
underlyingNode.setProperty(TOTAL_COST_SECOND_WEED_UPDATE,total_cost_second_weed_update);
}

public String getTotal_cost_second_weed_update(){
          try {
          return (String) underlyingNode.getProperty(TOTAL_COST_SECOND_WEED_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setTotal_cost_fourth_weed_update(String total_cost_fourth_weed_update) {
underlyingNode.setProperty(TOTAL_COST_FOURTH_WEED_UPDATE,total_cost_fourth_weed_update);
}

public String getTotal_cost_fourth_weed_update(){
          try {
          return (String) underlyingNode.getProperty(TOTAL_COST_FOURTH_WEED_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setTotal_cost_first_manual_weed_update(String total_cost_first_manual_weed_update) {
underlyingNode.setProperty(TOTAL_COST_FIRST_MANUAL_WEED_UPDATE,total_cost_first_manual_weed_update);
}

public String getTotal_cost_first_manual_weed_update(){
          try {
          return (String) underlyingNode.getProperty(TOTAL_COST_FIRST_MANUAL_WEED_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setTotal_cost_fifth_weed_update(String total_cost_fifth_weed_update) {
underlyingNode.setProperty(TOTAL_COST_FIFTH_WEED_UPDATE,total_cost_fifth_weed_update);
}

public String getTotal_cost_fifth_weed_update(){
          try {
          return (String) underlyingNode.getProperty(TOTAL_COST_FIFTH_WEED_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setTopdress_fert_labor_period_update(String topdress_fert_labor_period_update) {
underlyingNode.setProperty(TOPDRESS_FERT_LABOR_PERIOD_UPDATE,topdress_fert_labor_period_update);
}

public String getTopdress_fert_labor_period_update(){
          try {
          return (String) underlyingNode.getProperty(TOPDRESS_FERT_LABOR_PERIOD_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setThird_weeding_period_update(String third_weeding_period_update) {
underlyingNode.setProperty(THIRD_WEEDING_PERIOD_UPDATE,third_weeding_period_update);
}

public String getThird_weeding_period_update(){
          try {
          return (String) underlyingNode.getProperty(THIRD_WEEDING_PERIOD_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setSeedplanting_material_cost_update(String seedplanting_material_cost_update) {
underlyingNode.setProperty(SEEDPLANTING_MATERIAL_COST_UPDATE,seedplanting_material_cost_update);
}

public String getSeedplanting_material_cost_update(){
          try {
          return (String) underlyingNode.getProperty(SEEDPLANTING_MATERIAL_COST_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setSeedbed_labour_family_update(String seedbed_labour_family_update) {
underlyingNode.setProperty(SEEDBED_LABOUR_FAMILY_UPDATE,seedbed_labour_family_update);
}

public String getSeedbed_labour_family_update(){
          try {
          return (String) underlyingNode.getProperty(SEEDBED_LABOUR_FAMILY_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setSeedbed_labor_number_update(String seedbed_labor_number_update) {
underlyingNode.setProperty(SEEDBED_LABOR_NUMBER_UPDATE,seedbed_labor_number_update);
}

public String getSeedbed_labor_number_update(){
          try {
          return (String) underlyingNode.getProperty(SEEDBED_LABOR_NUMBER_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setSeedbed_labor_cost_update(String seedbed_labor_cost_update) {
underlyingNode.setProperty(SEEDBED_LABOR_COST_UPDATE,seedbed_labor_cost_update);
}

public String getSeedbed_labor_cost_update(){
          try {
          return (String) underlyingNode.getProperty(SEEDBED_LABOR_COST_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setSeed_bed_preparation_period_update(String seed_bed_preparation_period_update) {
underlyingNode.setProperty(SEED_BED_PREPARATION_PERIOD_UPDATE,seed_bed_preparation_period_update);
}

public String getSeed_bed_preparation_period_update(){
          try {
          return (String) underlyingNode.getProperty(SEED_BED_PREPARATION_PERIOD_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setSecond_weed_period_update(String second_weed_period_update) {
underlyingNode.setProperty(SECOND_WEED_PERIOD_UPDATE,second_weed_period_update);
}

public String getSecond_weed_period_update(){
          try {
          return (String) underlyingNode.getProperty(SECOND_WEED_PERIOD_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setSecond_weed_labor_update(String second_weed_labor_update) {
underlyingNode.setProperty(SECOND_WEED_LABOR_UPDATE,second_weed_labor_update);
}

public String getSecond_weed_labor_update(){
          try {
          return (String) underlyingNode.getProperty(SECOND_WEED_LABOR_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setRefilling_labour_no_update(String refilling_labour_no_update) {
underlyingNode.setProperty(REFILLING_LABOUR_NO_UPDATE,refilling_labour_no_update);
}

public String getRefilling_labour_no_update(){
          try {
          return (String) underlyingNode.getProperty(REFILLING_LABOUR_NO_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setRefilling_labour_cost(String refilling_labour_cost) {
underlyingNode.setProperty(REFILLING_LABOUR_COST,refilling_labour_cost);
}

public String getRefilling_labour_cost(){
          try {
          return (String) underlyingNode.getProperty(REFILLING_LABOUR_COST);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setRefilling_labor_period_update(String refilling_labor_period_update) {
underlyingNode.setProperty(REFILLING_LABOR_PERIOD_UPDATE,refilling_labor_period_update);
}

public String getRefilling_labor_period_update(){
          try {
          return (String) underlyingNode.getProperty(REFILLING_LABOR_PERIOD_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setRefilling_labor_family_update(String refilling_labor_family_update) {
underlyingNode.setProperty(REFILLING_LABOR_FAMILY_UPDATE,refilling_labor_family_update);
}

public String getRefilling_labor_family_update(){
          try {
          return (String) underlyingNode.getProperty(REFILLING_LABOR_FAMILY_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setQuantity_of_preplant_herbicide_update(String quantity_of_preplant_herbicide_update) {
underlyingNode.setProperty(QUANTITY_OF_PREPLANT_HERBICIDE_UPDATE,quantity_of_preplant_herbicide_update);
}

public String getQuantity_of_preplant_herbicide_update(){
          try {
          return (String) underlyingNode.getProperty(QUANTITY_OF_PREPLANT_HERBICIDE_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setPrice_of_topdress_fertilizer_update(String price_of_topdress_fertilizer_update) {
underlyingNode.setProperty(PRICE_OF_TOPDRESS_FERTILIZER_UPDATE,price_of_topdress_fertilizer_update);
}

public String getPrice_of_topdress_fertilizer_update(){
          try {
          return (String) underlyingNode.getProperty(PRICE_OF_TOPDRESS_FERTILIZER_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setPrice_of_herbicide_update(String price_of_herbicide_update) {
underlyingNode.setProperty(PRICE_OF_HERBICIDE_UPDATE,price_of_herbicide_update);
}

public String getPrice_of_herbicide_update(){
          try {
          return (String) underlyingNode.getProperty(PRICE_OF_HERBICIDE_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setPrice_of_basal_fertilizer_update(String price_of_basal_fertilizer_update) {
underlyingNode.setProperty(PRICE_OF_BASAL_FERTILIZER_UPDATE,price_of_basal_fertilizer_update);
}

public String getPrice_of_basal_fertilizer_update(){
          try {
          return (String) underlyingNode.getProperty(PRICE_OF_BASAL_FERTILIZER_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setPost_plant_herbicide_cost_update(String post_plant_herbicide_cost_update) {
underlyingNode.setProperty(POST_PLANT_HERBICIDE_COST_UPDATE,post_plant_herbicide_cost_update);
}

public String getPost_plant_herbicide_cost_update(){
          try {
          return (String) underlyingNode.getProperty(POST_PLANT_HERBICIDE_COST_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setPost_herbicide_application_cost_update(String post_herbicide_application_cost_update) {
underlyingNode.setProperty(POST_HERBICIDE_APPLICATION_COST_UPDATE,post_herbicide_application_cost_update);
}

public String getPost_herbicide_application_cost_update(){
          try {
          return (String) underlyingNode.getProperty(POST_HERBICIDE_APPLICATION_COST_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setPloughing_cost_per_acre_update(String ploughing_cost_per_acre_update) {
underlyingNode.setProperty(PLOUGHING_COST_PER_ACRE_UPDATE,ploughing_cost_per_acre_update);
}

public String getPloughing_cost_per_acre_update(){
          try {
          return (String) underlyingNode.getProperty(PLOUGHING_COST_PER_ACRE_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setPlanting_period2_update(String planting_period2_update) {
underlyingNode.setProperty(PLANTING_PERIOD2_UPDATE,planting_period2_update);
}

public String getPlanting_period2_update(){
          try {
          return (String) underlyingNode.getProperty(PLANTING_PERIOD2_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setPlanting_labor_cost_update(String planting_labor_cost_update) {
underlyingNode.setProperty(PLANTING_LABOR_COST_UPDATE,planting_labor_cost_update);
}

public String getPlanting_labor_cost_update(){
          try {
          return (String) underlyingNode.getProperty(PLANTING_LABOR_COST_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setPeriod_for_completion_of_harvest_update(String period_for_completion_of_harvest_update) {
underlyingNode.setProperty(PERIOD_FOR_COMPLETION_OF_HARVEST_UPDATE,period_for_completion_of_harvest_update);
}

public String getPeriod_for_completion_of_harvest_update(){
          try {
          return (String) underlyingNode.getProperty(PERIOD_FOR_COMPLETION_OF_HARVEST_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
    
public void setLand_rent_update(String land_rent_update) {
underlyingNode.setProperty(LAND_RENT_UPDATE,land_rent_update);
}

public String getLand_rent_update(){
          try {
          return (String) underlyingNode.getProperty(LAND_RENT_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setLabor_third_weed_control_update(String labor_third_weed_control_update) {
underlyingNode.setProperty(LABOR_THIRD_WEED_CONTROL_UPDATE,labor_third_weed_control_update);
}

public String getLabor_third_weed_control_update(){
          try {
          return (String) underlyingNode.getProperty(LABOR_THIRD_WEED_CONTROL_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
    
public void setLabor_no_first_manual_weed_update(String labor_no_first_manual_weed_update) {
underlyingNode.setProperty(LABOR_NO_FIRST_MANUAL_WEED_UPDATE,labor_no_first_manual_weed_update);
}

public String getLabor_no_first_manual_weed_update(){
          try {
          return (String) underlyingNode.getProperty(LABOR_NO_FIRST_MANUAL_WEED_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setLabor_fourth_weed_control_update(String labor_fourth_weed_control_update) {
underlyingNode.setProperty(LABOR_FOURTH_WEED_CONTROL_UPDATE,labor_fourth_weed_control_update);
}

public String getLabor_fourth_weed_control_update(){
          try {
          return (String) underlyingNode.getProperty(LABOR_FOURTH_WEED_CONTROL_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setLabor_for_plantingfamily_update(String labor_for_plantingfamily_update) {
underlyingNode.setProperty(LABOR_FOR_PLANTINGFAMILY_UPDATE,labor_for_plantingfamily_update);
}

public String getLabor_for_plantingfamily_update(){
          try {
          return (String) underlyingNode.getProperty(LABOR_FOR_PLANTINGFAMILY_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
    
public void setLabor_for_planting_number_update(String labor_for_planting_number_update) {
underlyingNode.setProperty(LABOR_FOR_PLANTING_NUMBER_UPDATE,labor_for_planting_number_update);
}

public String getLabor_for_planting_number_update(){
          try {
          return (String) underlyingNode.getProperty(LABOR_FOR_PLANTING_NUMBER_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setLabor_fifth_weed_control_update(String labor_fifth_weed_control_update) {
underlyingNode.setProperty(LABOR_FIFTH_WEED_CONTROL_UPDATE,labor_fifth_weed_control_update);
}

public String getLabor_fifth_weed_control_update(){
          try {
          return (String) underlyingNode.getProperty(LABOR_FIFTH_WEED_CONTROL_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setHoe_ploughing_labour_period_update(String hoe_ploughing_labour_period_update) {
underlyingNode.setProperty(HOE_PLOUGHING_LABOUR_PERIOD_UPDATE,hoe_ploughing_labour_period_update);
}

public String getHoe_ploughing_labour_period_update(){
          try {
          return (String) underlyingNode.getProperty(HOE_PLOUGHING_LABOUR_PERIOD_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setHoe_ploughing_labour_how_many_update(String hoe_ploughing_labour_how_many_update) {
underlyingNode.setProperty(HOE_PLOUGHING_LABOUR_HOW_MANY_UPDATE,hoe_ploughing_labour_how_many_update);
}

public String getHoe_ploughing_labour_how_many_update(){
          try {
          return (String) underlyingNode.getProperty(HOE_PLOUGHING_LABOUR_HOW_MANY_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setHoe_ploughing_labour_family_update(String hoe_ploughing_labour_family_update) {
underlyingNode.setProperty(HOE_PLOUGHING_LABOUR_FAMILY_UPDATE,hoe_ploughing_labour_family_update);
}

public String getHoe_ploughing_labour_family_update(){
          try {
          return (String) underlyingNode.getProperty(HOE_PLOUGHING_LABOUR_FAMILY_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setHerbicide_application_cost_update(String herbicide_application_cost_update) {
underlyingNode.setProperty(HERBICIDE_APPLICATION_COST_UPDATE,herbicide_application_cost_update);
}

public String getHerbicide_application_cost_update(){
          try {
          return (String) underlyingNode.getProperty(HERBICIDE_APPLICATION_COST_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setHerbicide_app_labor_period_update(String herbicide_app_labor_period_update) {
underlyingNode.setProperty(HERBICIDE_APP_LABOR_PERIOD_UPDATE,herbicide_app_labor_period_update);
}

public String getHerbicide_app_labor_period_update(){
          try {
          return (String) underlyingNode.getProperty(HERBICIDE_APP_LABOR_PERIOD_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setHarvest_labor_costs_per_acre_update(String harvest_labor_costs_per_acre_update) {
underlyingNode.setProperty(HARVEST_LABOR_COSTS_PER_ACRE_UPDATE,harvest_labor_costs_per_acre_update);
}

public String getHarvest_labor_costs_per_acre_update(){
          try {
          return (String) underlyingNode.getProperty(HARVEST_LABOR_COSTS_PER_ACRE_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setHarrowing_cost_per_acre_update(String harrowing_cost_per_acre_update) {
underlyingNode.setProperty(HARROWING_COST_PER_ACRE_UPDATE,harrowing_cost_per_acre_update);
}

public String getHarrowing_cost_per_acre_update(){
          try {
          return (String) underlyingNode.getProperty(HARROWING_COST_PER_ACRE_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setFourth_weeding_labor_period_update(String fourth_weeding_labor_period_update) {
underlyingNode.setProperty(FOURTH_WEEDING_LABOR_PERIOD_UPDATE,fourth_weeding_labor_period_update);
}

public String getFourth_weeding_labor_period_update(){
          try {
          return (String) underlyingNode.getProperty(FOURTH_WEEDING_LABOR_PERIOD_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setFourth_weed_control_labor_update(String fourth_weed_control_labor_update) {
underlyingNode.setProperty(FOURTH_WEED_CONTROL_LABOR_UPDATE,fourth_weed_control_labor_update);
}

public String getFourth_weed_control_labor_update(){
          try {
          return (String) underlyingNode.getProperty(FOURTH_WEED_CONTROL_LABOR_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setFirst_weeding_period_update(String first_weeding_period_update) {
underlyingNode.setProperty(FIRST_WEEDING_PERIOD_UPDATE,first_weeding_period_update);
}

public String getFirst_weeding_period_update(){
          try {
          return (String) underlyingNode.getProperty(FIRST_WEEDING_PERIOD_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setFinal_harvest_labor_no_update(String final_harvest_labor_no_update) {
underlyingNode.setProperty(FINAL_HARVEST_LABOR_NO_UPDATE,final_harvest_labor_no_update);
}

public String getFinal_harvest_labor_no_update(){
          try {
          return (String) underlyingNode.getProperty(FINAL_HARVEST_LABOR_NO_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setFifth_weeding_labor_period_update(String fifth_weeding_labor_period_update) {
underlyingNode.setProperty(FIFTH_WEEDING_LABOR_PERIOD_UPDATE,fifth_weeding_labor_period_update);
}

public String getFifth_weeding_labor_period_update(){
          try {
          return (String) underlyingNode.getProperty(FIFTH_WEEDING_LABOR_PERIOD_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setFertilizer_app_labour_cost_update(String fertilizer_app_labour_cost_update) {
underlyingNode.setProperty(FERTILIZER_APP_LABOUR_COST_UPDATE,fertilizer_app_labour_cost_update);
}

public String getFertilizer_app_labour_cost_update(){
          try {
          return (String) underlyingNode.getProperty(FERTILIZER_APP_LABOUR_COST_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setFamily_labor_topdress_fertilizer_applica(String family_labor_topdress_fertilizer_applica) {
underlyingNode.setProperty(FAMILY_LABOR_TOPDRESS_FERTILIZER_APPLICA,family_labor_topdress_fertilizer_applica);
}

public String getFamily_labor_topdress_fertilizer_applica(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_TOPDRESS_FERTILIZER_APPLICA);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setFamily_labor_third_weed_update(String family_labor_third_weed_update) {
underlyingNode.setProperty(FAMILY_LABOR_THIRD_WEED_UPDATE,family_labor_third_weed_update);
}

public String getFamily_labor_third_weed_update(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_THIRD_WEED_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setFamily_labor_second_weed_update(String family_labor_second_weed_update) {
underlyingNode.setProperty(FAMILY_LABOR_SECOND_WEED_UPDATE,family_labor_second_weed_update);
}

public String getFamily_labor_second_weed_update(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_SECOND_WEED_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setFamily_labor_first_manual_weed_update(String family_labor_first_manual_weed_update) {
underlyingNode.setProperty(FAMILY_LABOR_FIRST_MANUAL_WEED_UPDATE,family_labor_first_manual_weed_update);
}

public String getFamily_labor_first_manual_weed_update(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_FIRST_MANUAL_WEED_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setFamily_labor_fifth_weed_control_update(String family_labor_fifth_weed_control_update) {
underlyingNode.setProperty(FAMILY_LABOR_FIFTH_WEED_CONTROL_UPDATE,family_labor_fifth_weed_control_update);
}

public String getFamily_labor_fifth_weed_control_update(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_FIFTH_WEED_CONTROL_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setFamily_labor_basal_fert_update(String family_labor_basal_fert_update) {
underlyingNode.setProperty(FAMILY_LABOR_BASAL_FERT_UPDATE,family_labor_basal_fert_update);
}

public String getFamily_labor_basal_fert_update(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_BASAL_FERT_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setCost_of_applicationtopdress_update(String cost_of_applicationtopdress_update) {
underlyingNode.setProperty(COST_OF_APPLICATIONTOPDRESS_UPDATE,cost_of_applicationtopdress_update);
}

public String getCost_of_applicationtopdress_update(){
          try {
          return (String) underlyingNode.getProperty(COST_OF_APPLICATIONTOPDRESS_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setBasal_fertilizer_appl_lab_update(String basal_fertilizer_appl_lab_update) {
underlyingNode.setProperty(BASAL_FERTILIZER_APPL_LAB_UPDATE,basal_fertilizer_appl_lab_update);
}

public String getBasal_fertilizer_appl_lab_update(){
          try {
          return (String) underlyingNode.getProperty(BASAL_FERTILIZER_APPL_LAB_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setBasal_fert_labor_period_update(String basal_fert_labor_period_update) {
underlyingNode.setProperty(BASAL_FERT_LABOR_PERIOD_UPDATE,basal_fert_labor_period_update);
}

public String getBasal_fert_labor_period_update(){
          try {
          return (String) underlyingNode.getProperty(BASAL_FERT_LABOR_PERIOD_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }

}
