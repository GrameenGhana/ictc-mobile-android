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
 * @date Oct 12, 2015 10:08:34 AM
 * description:
 */
public class BaselineProductionBudget extends Status implements GeneralInterface{
    
    Node underlyingNode = null;

    public BaselineProductionBudget(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }
    
 public static String BASAL_FERT_LABOR_PERIOD_BASE="basal_fert_labor_period_base";
 public static String BASAL_FERTILIZER_APPL_LAB_BASE="basal_fertilizer_appl_lab_base";
 public static String COST_OF_APPLICATIONTOPDRESS_BASE="cost_of_applicationtopdress_base";
 public static String FAMILY_LABOR_BASAL_FERT_BASE="family_labor_basal_fert_base";
 public static String FAMILY_LABOR_FIFTH_WEED_CONTROL_BASE="family_labor_fifth_weed_control_base";
 public static String FAMILY_LABOR_FIRST_MANUAL_WEED_BASE="family_labor_first_manual_weed_base";
 public static String FAMILY_LABOR_SECOND_WEED_BASE="family_labor_second_weed_base";
 public static String FAMILY_LABOR_THIRD_WEED_BASE="family_labor_third_weed_base";
 public static String FAMILY_LABOR_TOPDRESS_BASE="family_labor_topdress_base";
 public static String FERTILIZER_APP_LABOUR_COST_BASE="fertilizer_app_labour_cost_base";
 public static String FIFTH_WEEDING_LABOR_PERIOD_BASE="fifth_weeding_labor_period_base";
 public static String FINAL_HARVEST_FAMILY_LABOR_BASE="final_harvest_family_labor_base";
 public static String FINAL_HARVEST_LABOR_NO_BASE="final_harvest_labor_no_base";
 public static String FIRST_WEEDING_PERIOD_BASE="first_weeding_period_base";
 public static String FOURTH_WEEDING_FAMILY_LAB="fourth_weeding_family_lab";
 public static String FOURTH_WEEDING_LABOR_PERIOD_BASE="fourth_weeding_labor_period_base";
 public static String HARROWING_COST_PER_ACRE_BASE="harrowing_cost_per_acre_base";
 public static String HARVEST_LABOR_COSTS_PER_ACRE_BASE="harvest_labor_costs_per_acre_base";
 public static String HERBICIDE_APP_LABOR_PERIOD_BASE="herbicide_app_labor_period_base";
 public static String HERBICIDE_APPLICATION_COST_BASE="herbicide_application_cost_base";
 public static String HOE_PLOUGHING_LABOUR_FAMILY_BASE="hoe_ploughing_labour_family_base";
 public static String HOE_PLOUGHING_LABOUR_HOW_MANY_BASE="hoe_ploughing_labour_how_many_base";
 public static String HOE_PLOUGHING_LABOUR_PERIOD_BASE="hoe_ploughing_labour_period_base";
 public static String LABOR_FIFTH_WEED_CONTROL_BASE="labor_fifth_weed_control_base";
 public static String LABOR_FOR_PLANTING_NUMBER_BASE="labor_for_planting_number_base";
 public static String LABOR_FOR_PLANTINGFAMILY_BASE="labor_for_plantingfamily_base";
 public static String LABOR_FOURTH_WEED_CONTROL_BASE="labor_fourth_weed_control_base";
 public static String LABOR_NO_FIRST_MANUAL_WEED_BASE="labor_no_first_manual_weed_base";
 public static String LABOR_THIRD_WEED_CONTROL_BASE="labor_third_weed_control_base";
 public static String LAND_RENT_BASE="land_rent_base";
 public static String PERIOD_FOR_COMPLETION_OF_HARVEST_BASE="period_for_completion_of_harvest_base";
 public static String PLANTING_PERIOD2_BASE="planting_period2_base";
 public static String PLOUGHING_COST_PER_ACRE_BASE="ploughing_cost_per_acre_base";
 public static String POST_HERBICIDE_APPLICATION_COST_BASE="post_herbicide_application_cost_base";
 public static String POST_PLANT_HERBICIDE_COST_BASE="post_plant_herbicide_cost_base";
 public static String PRICE_OF_BASAL_FERTILIZER_BASE="price_of_basal_fertilizer_base";
 public static String PRICE_OF_HERBICIDE_BASE="price_of_herbicide_base";
 public static String PRICE_OF_TOPDRESS_FERTILIZER_BASE="price_of_topdress_fertilizer_base";
 public static String QUANTITY_OF_PREPLANT_HERBICIDE_BASE="quantity_of_preplant_herbicide_base";
 public static String REFILLING_LABOR_FAMILY_BASE="refilling_labor_family_base";
 public static String REFILLING_LABOR_PERIOD_BASE="refilling_labor_period_base";
 public static String REFILLING_LABOUR_COST_BASE="refilling_labour_cost_base";
 public static String REFILLING_LABOUR_NO_BASE="refilling_labour_no_base";
 public static String SECOND_WEED_LABOR_BASE="second_weed_labor_base";
 public static String SECOND_WEED_PERIOD_BASE="second_weed_period_base";
 public static String SEED_BED_PREPARATION_PERIOD_BASE="seed_bed_preparation_period_base";
 public static String SEEDBED_LABOR_COST_BASE="seedbed_labor_cost_base";
 public static String SEEDBED_LABOR_NUMBER_BASE="seedbed_labor_number_base";
 public static String SEEDBED_LABOUR_FAMILY_BASE="seedbed_labour_family_base";
 public static String SEEDPLANTING_MATERIAL_COST_BASE="seedplanting_material_cost_base";
 public static String THIRD_WEEDING_PERIOD_BASE="third_weeding_period_base";
 public static String TOPDRESS_FERT_LABOR_PERIOD_BASE="topdress_fert_labor_period_base";
 public static String TOTAL_COST_FIFTH_WEED_BASE="total_cost_fifth_weed_base";
 public static String TOTAL_COST_FIRST_MANUAL_WEED_BASE="total_cost_first_manual_weed_base";
 public static String TOTAL_COST_SECOND_WEED_BASE="total_cost_second_weed_base";
 public static String TOTAL_COST_THIRD_WEED_BASE="total_cost_third_weed_base";
 public static String TOTAL_NUMBER_OF_LABOR_TOPDRESS_BASE="total_number_of_labor_topdress_base";
 public static String UNIT_COST_HOE_PLOUGHING_BASE="unit_cost_hoe_ploughing_base";
 
 
 
 
public void setUnit_cost_hoe_ploughing_base(String unit_cost_hoe_ploughing_base) {
underlyingNode.setProperty(UNIT_COST_HOE_PLOUGHING_BASE,unit_cost_hoe_ploughing_base);
}

public String getUnit_cost_hoe_ploughing_base(){
          try {
          return (String) underlyingNode.getProperty(UNIT_COST_HOE_PLOUGHING_BASE);

        } catch (Exception e) {
        }
        return null;
    }

 
 
public void setTotal_number_of_labor_topdress_base(String total_number_of_labor_topdress_base) {
underlyingNode.setProperty(TOTAL_NUMBER_OF_LABOR_TOPDRESS_BASE,total_number_of_labor_topdress_base);
}

public String getTotal_number_of_labor_topdress_base(){
          try {
          return (String) underlyingNode.getProperty(TOTAL_NUMBER_OF_LABOR_TOPDRESS_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
public void setTotal_cost_third_weed_base(String total_cost_third_weed_base) {
underlyingNode.setProperty(TOTAL_COST_THIRD_WEED_BASE,total_cost_third_weed_base);
}

public String getTotal_cost_third_weed_base(){
          try {
          return (String) underlyingNode.getProperty(TOTAL_COST_THIRD_WEED_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setTotal_cost_second_weed_base(String total_cost_second_weed_base) {
underlyingNode.setProperty(TOTAL_COST_SECOND_WEED_BASE,total_cost_second_weed_base);
}

public String getTotal_cost_second_weed_base(){
          try {
          return (String) underlyingNode.getProperty(TOTAL_COST_SECOND_WEED_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setTotal_cost_first_manual_weed_base(String total_cost_first_manual_weed_base) {
underlyingNode.setProperty(TOTAL_COST_FIRST_MANUAL_WEED_BASE,total_cost_first_manual_weed_base);
}

public String getTotal_cost_first_manual_weed_base(){
          try {
          return (String) underlyingNode.getProperty(TOTAL_COST_FIRST_MANUAL_WEED_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setTotal_cost_fifth_weed_base(String total_cost_fifth_weed_base) {
underlyingNode.setProperty(TOTAL_COST_FIFTH_WEED_BASE,total_cost_fifth_weed_base);
}

public String getTotal_cost_fifth_weed_base(){
          try {
          return (String) underlyingNode.getProperty(TOTAL_COST_FIFTH_WEED_BASE);

        } catch (Exception e) {
        }
        return null;
    }

 
 
public void setTopdress_fert_labor_period_base(String topdress_fert_labor_period_base) {
underlyingNode.setProperty(TOPDRESS_FERT_LABOR_PERIOD_BASE,topdress_fert_labor_period_base);
}

public String getTopdress_fert_labor_period_base(){
          try {
          return (String) underlyingNode.getProperty(TOPDRESS_FERT_LABOR_PERIOD_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setThird_weeding_period_base(String third_weeding_period_base) {
underlyingNode.setProperty(THIRD_WEEDING_PERIOD_BASE,third_weeding_period_base);
}

public String getThird_weeding_period_base(){
          try {
          return (String) underlyingNode.getProperty(THIRD_WEEDING_PERIOD_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setSeedplanting_material_cost_base(String seedplanting_material_cost_base) {
underlyingNode.setProperty(SEEDPLANTING_MATERIAL_COST_BASE,seedplanting_material_cost_base);
}

public String getSeedplanting_material_cost_base(){
          try {
          return (String) underlyingNode.getProperty(SEEDPLANTING_MATERIAL_COST_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setSeedbed_labour_family_base(String seedbed_labour_family_base) {
underlyingNode.setProperty(SEEDBED_LABOUR_FAMILY_BASE,seedbed_labour_family_base);
}

public String getSeedbed_labour_family_base(){
          try {
          return (String) underlyingNode.getProperty(SEEDBED_LABOUR_FAMILY_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
public void setSeedbed_labor_number_base(String seedbed_labor_number_base) {
underlyingNode.setProperty(SEEDBED_LABOR_NUMBER_BASE,seedbed_labor_number_base);
}

public String getSeedbed_labor_number_base(){
          try {
          return (String) underlyingNode.getProperty(SEEDBED_LABOR_NUMBER_BASE);

        } catch (Exception e) {
        }
        return null;
    }

 
 
public void setSeedbed_labor_cost_base(String seedbed_labor_cost_base) {
underlyingNode.setProperty(SEEDBED_LABOR_COST_BASE,seedbed_labor_cost_base);
}

public String getSeedbed_labor_cost_base(){
          try {
          return (String) underlyingNode.getProperty(SEEDBED_LABOR_COST_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
public void setSeed_bed_preparation_period_base(String seed_bed_preparation_period_base) {
underlyingNode.setProperty(SEED_BED_PREPARATION_PERIOD_BASE,seed_bed_preparation_period_base);
}

public String getSeed_bed_preparation_period_base(){
          try {
          return (String) underlyingNode.getProperty(SEED_BED_PREPARATION_PERIOD_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setSecond_weed_period_base(String second_weed_period_base) {
underlyingNode.setProperty(SECOND_WEED_PERIOD_BASE,second_weed_period_base);
}

public String getSecond_weed_period_base(){
          try {
          return (String) underlyingNode.getProperty(SECOND_WEED_PERIOD_BASE);

        } catch (Exception e) {
        }
        return null;
    }

 
public void setSecond_weed_labor_base(String second_weed_labor_base) {
underlyingNode.setProperty(SECOND_WEED_LABOR_BASE,second_weed_labor_base);
}

public String getSecond_weed_labor_base(){
          try {
          return (String) underlyingNode.getProperty(SECOND_WEED_LABOR_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
public void setRefilling_labour_no_base(String refilling_labour_no_base) {
underlyingNode.setProperty(REFILLING_LABOUR_NO_BASE,refilling_labour_no_base);
}

public String getRefilling_labour_no_base(){
          try {
          return (String) underlyingNode.getProperty(REFILLING_LABOUR_NO_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
 
public void setRefilling_labour_cost_base(String refilling_labour_cost_base) {
underlyingNode.setProperty(REFILLING_LABOUR_COST_BASE,refilling_labour_cost_base);
}

public String getRefilling_labour_cost_base(){
          try {
          return (String) underlyingNode.getProperty(REFILLING_LABOUR_COST_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setRefilling_labor_period_base(String refilling_labor_period_base) {
underlyingNode.setProperty(REFILLING_LABOR_PERIOD_BASE,refilling_labor_period_base);
}

public String getRefilling_labor_period_base(){
          try {
          return (String) underlyingNode.getProperty(REFILLING_LABOR_PERIOD_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setRefilling_labor_family_base(String refilling_labor_family_base) {
underlyingNode.setProperty(REFILLING_LABOR_FAMILY_BASE,refilling_labor_family_base);
}

public String getRefilling_labor_family_base(){
          try {
          return (String) underlyingNode.getProperty(REFILLING_LABOR_FAMILY_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setQuantity_of_preplant_herbicide_base(String quantity_of_preplant_herbicide_base) {
underlyingNode.setProperty(QUANTITY_OF_PREPLANT_HERBICIDE_BASE,quantity_of_preplant_herbicide_base);
}

public String getQuantity_of_preplant_herbicide_base(){
          try {
          return (String) underlyingNode.getProperty(QUANTITY_OF_PREPLANT_HERBICIDE_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setPrice_of_topdress_fertilizer_base(String price_of_topdress_fertilizer_base) {
underlyingNode.setProperty(PRICE_OF_TOPDRESS_FERTILIZER_BASE,price_of_topdress_fertilizer_base);
}

public String getPrice_of_topdress_fertilizer_base(){
          try {
          return (String) underlyingNode.getProperty(PRICE_OF_TOPDRESS_FERTILIZER_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
 
 
public void setPrice_of_herbicide_base(String price_of_herbicide_base) {
underlyingNode.setProperty(PRICE_OF_HERBICIDE_BASE,price_of_herbicide_base);
}

public String getPrice_of_herbicide_base(){
          try {
          return (String) underlyingNode.getProperty(PRICE_OF_HERBICIDE_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setPrice_of_basal_fertilizer_base(String price_of_basal_fertilizer_base) {
underlyingNode.setProperty(PRICE_OF_BASAL_FERTILIZER_BASE,price_of_basal_fertilizer_base);
}

public String getPrice_of_basal_fertilizer_base(){
          try {
          return (String) underlyingNode.getProperty(PRICE_OF_BASAL_FERTILIZER_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
 
public void setPost_plant_herbicide_cost_base(String post_plant_herbicide_cost_base) {
underlyingNode.setProperty(POST_PLANT_HERBICIDE_COST_BASE,post_plant_herbicide_cost_base);
}

public String getPost_plant_herbicide_cost_base(){
          try {
          return (String) underlyingNode.getProperty(POST_PLANT_HERBICIDE_COST_BASE);

        } catch (Exception e) {
        }
        return null;
    }

 
 
public void setPost_herbicide_application_cost_base(String post_herbicide_application_cost_base) {
underlyingNode.setProperty(POST_HERBICIDE_APPLICATION_COST_BASE,post_herbicide_application_cost_base);
}

public String getPost_herbicide_application_cost_base(){
          try {
          return (String) underlyingNode.getProperty(POST_HERBICIDE_APPLICATION_COST_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
 
public void setPloughing_cost_per_acre_base(String ploughing_cost_per_acre_base) {
underlyingNode.setProperty(PLOUGHING_COST_PER_ACRE_BASE,ploughing_cost_per_acre_base);
}

public String getPloughing_cost_per_acre_base(){
          try {
          return (String) underlyingNode.getProperty(PLOUGHING_COST_PER_ACRE_BASE);

        } catch (Exception e) {
        }
        return null;
    }

 
public void setPlanting_period2_base(String planting_period2_base) {
underlyingNode.setProperty(PLANTING_PERIOD2_BASE,planting_period2_base);
}

public String getPlanting_period2_base(){
          try {
          return (String) underlyingNode.getProperty(PLANTING_PERIOD2_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setPeriod_for_completion_of_harvest_base(String period_for_completion_of_harvest_base) {
underlyingNode.setProperty(PERIOD_FOR_COMPLETION_OF_HARVEST_BASE,period_for_completion_of_harvest_base);
}

public String getPeriod_for_completion_of_harvest_base(){
          try {
          return (String) underlyingNode.getProperty(PERIOD_FOR_COMPLETION_OF_HARVEST_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setLand_rent_base(String land_rent_base) {
underlyingNode.setProperty(LAND_RENT_BASE,land_rent_base);
}

public String getLand_rent_base(){
          try {
          return (String) underlyingNode.getProperty(LAND_RENT_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
public void setLabor_third_weed_control_base(String labor_third_weed_control_base) {
underlyingNode.setProperty(LABOR_THIRD_WEED_CONTROL_BASE,labor_third_weed_control_base);
}

public String getLabor_third_weed_control_base(){
          try {
          return (String) underlyingNode.getProperty(LABOR_THIRD_WEED_CONTROL_BASE);

        } catch (Exception e) {
        }
        return null;
    }

 
 
public void setLabor_no_first_manual_weed_base(String labor_no_first_manual_weed_base) {
underlyingNode.setProperty(LABOR_NO_FIRST_MANUAL_WEED_BASE,labor_no_first_manual_weed_base);
}

public String getLabor_no_first_manual_weed_base(){
          try {
          return (String) underlyingNode.getProperty(LABOR_NO_FIRST_MANUAL_WEED_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
public void setLabor_fourth_weed_control_base(String labor_fourth_weed_control_base) {
underlyingNode.setProperty(LABOR_FOURTH_WEED_CONTROL_BASE,labor_fourth_weed_control_base);
}

public String getLabor_fourth_weed_control_base(){
          try {
          return (String) underlyingNode.getProperty(LABOR_FOURTH_WEED_CONTROL_BASE);

        } catch (Exception e) {
        }
        return null;
    }

 
public void setLabor_for_plantingfamily_base(String labor_for_plantingfamily_base) {
underlyingNode.setProperty(LABOR_FOR_PLANTINGFAMILY_BASE,labor_for_plantingfamily_base);
}

public String getLabor_for_plantingfamily_base(){
          try {
          return (String) underlyingNode.getProperty(LABOR_FOR_PLANTINGFAMILY_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setLabor_for_planting_number_base(String labor_for_planting_number_base) {
underlyingNode.setProperty(LABOR_FOR_PLANTING_NUMBER_BASE,labor_for_planting_number_base);
}

public String getLabor_for_planting_number_base(){
          try {
          return (String) underlyingNode.getProperty(LABOR_FOR_PLANTING_NUMBER_BASE);

        } catch (Exception e) {
        }
        return null;
    }

 
 
public void setLabor_fifth_weed_control_base(String labor_fifth_weed_control_base) {
underlyingNode.setProperty(LABOR_FIFTH_WEED_CONTROL_BASE,labor_fifth_weed_control_base);
}

public String getLabor_fifth_weed_control_base(){
          try {
          return (String) underlyingNode.getProperty(LABOR_FIFTH_WEED_CONTROL_BASE);

        } catch (Exception e) {
        }
        return null;
    }

 
public void setHoe_ploughing_labour_period_base(String hoe_ploughing_labour_period_base) {
underlyingNode.setProperty(HOE_PLOUGHING_LABOUR_PERIOD_BASE,hoe_ploughing_labour_period_base);
}

public String getHoe_ploughing_labour_period_base(){
          try {
          return (String) underlyingNode.getProperty(HOE_PLOUGHING_LABOUR_PERIOD_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setHoe_ploughing_labour_how_many_base(String hoe_ploughing_labour_how_many_base) {
underlyingNode.setProperty(HOE_PLOUGHING_LABOUR_HOW_MANY_BASE,hoe_ploughing_labour_how_many_base);
}

public String getHoe_ploughing_labour_how_many_base(){
          try {
          return (String) underlyingNode.getProperty(HOE_PLOUGHING_LABOUR_HOW_MANY_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setHoe_ploughing_labour_family_base(String hoe_ploughing_labour_family_base) {
underlyingNode.setProperty(HOE_PLOUGHING_LABOUR_FAMILY_BASE,hoe_ploughing_labour_family_base);
}

public String getHoe_ploughing_labour_family_base(){
          try {
          return (String) underlyingNode.getProperty(HOE_PLOUGHING_LABOUR_FAMILY_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setHerbicide_application_cost_base(String herbicide_application_cost_base) {
underlyingNode.setProperty(HERBICIDE_APPLICATION_COST_BASE,herbicide_application_cost_base);
}

public String getHerbicide_application_cost_base(){
          try {
          return (String) underlyingNode.getProperty(HERBICIDE_APPLICATION_COST_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
public void setHerbicide_app_labor_period_base(String herbicide_app_labor_period_base) {
underlyingNode.setProperty(HERBICIDE_APP_LABOR_PERIOD_BASE,herbicide_app_labor_period_base);
}

public String getHerbicide_app_labor_period_base(){
          try {
          return (String) underlyingNode.getProperty(HERBICIDE_APP_LABOR_PERIOD_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
public void setHarvest_labor_costs_per_acre_base(String harvest_labor_costs_per_acre_base) {
underlyingNode.setProperty(HARVEST_LABOR_COSTS_PER_ACRE_BASE,harvest_labor_costs_per_acre_base);
}

public String getHarvest_labor_costs_per_acre_base(){
          try {
          return (String) underlyingNode.getProperty(HARVEST_LABOR_COSTS_PER_ACRE_BASE);

        } catch (Exception e) {
        }
        return null;
    }

 
 
public void setHarrowing_cost_per_acre_base(String harrowing_cost_per_acre_base) {
underlyingNode.setProperty(HARROWING_COST_PER_ACRE_BASE,harrowing_cost_per_acre_base);
}

public String getHarrowing_cost_per_acre_base(){
          try {
          return (String) underlyingNode.getProperty(HARROWING_COST_PER_ACRE_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setFourth_weeding_labor_period_base(String fourth_weeding_labor_period_base) {
underlyingNode.setProperty(FOURTH_WEEDING_LABOR_PERIOD_BASE,fourth_weeding_labor_period_base);
}

public String getFourth_weeding_labor_period_base(){
          try {
          return (String) underlyingNode.getProperty(FOURTH_WEEDING_LABOR_PERIOD_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setFourth_weeding_family_lab(String fourth_weeding_family_lab) {
underlyingNode.setProperty(FOURTH_WEEDING_FAMILY_LAB,fourth_weeding_family_lab);
}

public String getFourth_weeding_family_lab(){
          try {
          return (String) underlyingNode.getProperty(FOURTH_WEEDING_FAMILY_LAB);

        } catch (Exception e) {
        }
        return null;
    }
 
public void setFirst_weeding_period_base(String first_weeding_period_base) {
underlyingNode.setProperty(FIRST_WEEDING_PERIOD_BASE,first_weeding_period_base);
}

public String getFirst_weeding_period_base(){
          try {
          return (String) underlyingNode.getProperty(FIRST_WEEDING_PERIOD_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
public void setFinal_harvest_labor_no_base(String final_harvest_labor_no_base) {
underlyingNode.setProperty(FINAL_HARVEST_LABOR_NO_BASE,final_harvest_labor_no_base);
}

public String getFinal_harvest_labor_no_base(){
          try {
          return (String) underlyingNode.getProperty(FINAL_HARVEST_LABOR_NO_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setFinal_harvest_family_labor_base(String final_harvest_family_labor_base) {
underlyingNode.setProperty(FINAL_HARVEST_FAMILY_LABOR_BASE,final_harvest_family_labor_base);
}

public String getFinal_harvest_family_labor_base(){
          try {
          return (String) underlyingNode.getProperty(FINAL_HARVEST_FAMILY_LABOR_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setFifth_weeding_labor_period_base(String fifth_weeding_labor_period_base) {
underlyingNode.setProperty(FIFTH_WEEDING_LABOR_PERIOD_BASE,fifth_weeding_labor_period_base);
}

public String getFifth_weeding_labor_period_base(){
          try {
          return (String) underlyingNode.getProperty(FIFTH_WEEDING_LABOR_PERIOD_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setFertilizer_app_labour_cost_base(String fertilizer_app_labour_cost_base) {
underlyingNode.setProperty(FERTILIZER_APP_LABOUR_COST_BASE,fertilizer_app_labour_cost_base);
}

public String getFertilizer_app_labour_cost_base(){
          try {
          return (String) underlyingNode.getProperty(FERTILIZER_APP_LABOUR_COST_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
 
 
public void setFamily_labor_topdress_base(String family_labor_topdress_base) {
underlyingNode.setProperty(FAMILY_LABOR_TOPDRESS_BASE,family_labor_topdress_base);
}

public String getFamily_labor_topdress_base(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_TOPDRESS_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setFamily_labor_third_weed_base(String family_labor_third_weed_base) {
underlyingNode.setProperty(FAMILY_LABOR_THIRD_WEED_BASE,family_labor_third_weed_base);
}

public String getFamily_labor_third_weed_base(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_THIRD_WEED_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setFamily_labor_second_weed_base(String family_labor_second_weed_base) {
underlyingNode.setProperty(FAMILY_LABOR_SECOND_WEED_BASE,family_labor_second_weed_base);
}

public String getFamily_labor_second_weed_base(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_SECOND_WEED_BASE);

        } catch (Exception e) {
        }
        return null;
    }

 
 
public void setFamily_labor_first_manual_weed_base(String family_labor_first_manual_weed_base) {
underlyingNode.setProperty(FAMILY_LABOR_FIRST_MANUAL_WEED_BASE,family_labor_first_manual_weed_base);
}

public String getFamily_labor_first_manual_weed_base(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_FIRST_MANUAL_WEED_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setFamily_labor_fifth_weed_control_base(String family_labor_fifth_weed_control_base) {
underlyingNode.setProperty(FAMILY_LABOR_FIFTH_WEED_CONTROL_BASE,family_labor_fifth_weed_control_base);
}

public String getFamily_labor_fifth_weed_control_base(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_FIFTH_WEED_CONTROL_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
 
public void setFamily_labor_basal_fert_base(String family_labor_basal_fert_base) {
underlyingNode.setProperty(FAMILY_LABOR_BASAL_FERT_BASE,family_labor_basal_fert_base);
}

public String getFamily_labor_basal_fert_base(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_BASAL_FERT_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
public void setCost_of_applicationtopdress_base(String cost_of_applicationtopdress_base) {
underlyingNode.setProperty(COST_OF_APPLICATIONTOPDRESS_BASE,cost_of_applicationtopdress_base);
}

public String getCost_of_applicationtopdress_base(){
          try {
          return (String) underlyingNode.getProperty(COST_OF_APPLICATIONTOPDRESS_BASE);

        } catch (Exception e) {
        }
        return null;
    }
 
 
public void setBasal_fertilizer_appl_lab_base(String basal_fertilizer_appl_lab_base) {
underlyingNode.setProperty(BASAL_FERTILIZER_APPL_LAB_BASE,basal_fertilizer_appl_lab_base);
}

public String getBasal_fertilizer_appl_lab_base(){
          try {
          return (String) underlyingNode.getProperty(BASAL_FERTILIZER_APPL_LAB_BASE);

        } catch (Exception e) {
        }
        return null;
    }
public void setBasal_fert_labor_period_base(String basal_fert_labor_period_base) {
underlyingNode.setProperty(BASAL_FERT_LABOR_PERIOD_BASE,basal_fert_labor_period_base);
}

public String getBasal_fert_labor_period_base(){
          try {
          return (String) underlyingNode.getProperty(BASAL_FERT_LABOR_PERIOD_BASE);

        } catch (Exception e) {
        }
        return null;
    }

    

}
