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
 * @date Oct 13, 2015 3:08:08 PM
 * description:
 */
public class FmpProductionBudget extends Status implements GeneralInterface {

    Node underlyingNode = null;
            
    public FmpProductionBudget(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }
    
    
    public static String BASAL_FERT_LABOR_PERIOD="basal_fert_labor_period";
    public static String BASAL_FERTILIZER_APPL_LABOUR_COST="basal_fertilizer_appl_labour_cost";
    public static String BASAL_FERTILIZER_APPLICATION_TOTAL_LABOU="basal_fertilizer_application_total_labou";
    public static String COST_OF_APPLICATIONTOPDRESS="cost_of_applicationtopdress";
    public static String FAMILY_LABOR_BASAL_FERTILIZER_APPLICATIO="family_labor_basal_fertilizer_applicatio";
    public static String FAMILY_LABOR_FIFTH_WEED_CONTROL="family_labor_fifth_weed_control";
    public static String FAMILY_LABOR_FIRST_MANUAL_WEED_CONTROL="family_labor_first_manual_weed_control";
    public static String FAMILY_LABOR_FOURTH_WEEDING="family_labor_fourth_weeding";
    public static String FAMILY_LABOR_SECOND_MANUAL_WEED_CONTROL="family_labor_second_manual_weed_control";
    public static String FAMILY_LABOR_THIRD_WEED_CONTROL="family_labor_third_weed_control";
    public static String FAMILY_LABOR_TOPDRESS_FERTILIZER_APPLICA="family_labor_topdress_fertilizer_applica";
    public static String FIFTH_MANUAL_WEEDING_LABOR_PERIOD="fifth_manual_weeding_labor_period";
    public static String FINAL_HARVEST_FAMILY_LABOR="final_harvest_family_labor";
    public static String FINAL_HARVEST_LABOR_HOW_MANY_LABOR_HANDS="final_harvest_labor_how_many_labor_hands";
    public static String FIRST_MANUAL_WEED_CONTROL_LABOR="first_manual_weed_control_labor";
    public static String FIRST_MANUAL_WEEDING_LABOR_PERIOD="first_manual_weeding_labor_period";
    public static String FOURTH_MANUAL_WEEDING_LABOR_PERIOD="fourth_manual_weeding_labor_period";
    public static String HARROWING_COST_PER_ACRE="harrowing_cost_per_acre";
    public static String HARVEST_LABOR_COSTSPER_ACRE="harvest_labor_costsper_acre";
    public static String HERBICIDE_APPLICATION_COST="herbicide_application_cost";
    public static String HERBICIDE_APPLICATION_COST_POST_PLANT="herbicide_application_cost_post_plant";
    public static String HERBICIDE_APPLICATION_LABOR_PERIOD_HOW_L="herbicide_application_labor_period_how_l";
    public static String HOE_PLOUGHING_LABOUR_FAMILY_HOW_MANY_FAM="hoe_ploughing_labour_family_how_many_fam";
    public static String HOE_PLOUGHING_LABOUR_HOW_MANY_PEOPLE="hoe_ploughing_labour_how_many_people";
    public static String HOE_PLOUGHING_LABOUR_PERIOD="hoe_ploughing_labour_period";
    public static String LABOR_FIFTH_WEED_CONTROL="labor_fifth_weed_control";
    public static String LABOR_FOR_PLANTING_NUMBER="labor_for_planting_number";
    public static String LABOR_FOR_PLANTINGFAMILY="labor_for_plantingfamily";
    public static String LABOR_FOURTH_WEED_CONTROL="labor_fourth_weed_control";
    public static String LABOR_THIRD_WEED_CONTROL="labor_third_weed_control";
    public static String LAND_RENT="land_rent";
    public static String PERIOD_FOR_COMPLETION_OF_HARVEST="period_for_completion_of_harvest";
    public static String PLANTING_LABOR_COST="planting_labor_cost";
    public static String PLANTING_PERIOD2="planting_period2";
    public static String PLOUGHING_COST_PER_ACRE="ploughing_cost_per_acre";
    public static String POST_PLANT_HERBICIDE_COST="post_plant_herbicide_cost";
    public static String PRICE_OF_BASAL_FERTILIZER="price_of_basal_fertilizer";
    public static String PRICE_OF_HERBICIDE_GHC="price_of_herbicide_ghc";
    public static String PRICE_OF_TOPDRESS_FERTILIZER="price_of_topdress_fertilizer";
    public static String QUANTITY_OF_PREPLANT_HERBICIDE_LITERS="quantity_of_preplant_herbicide_liters";
    public static String REFILLING_LABOR_PERIOD="refilling_labor_period";
    public static String REFILLING_LABOUR_COST="refilling_labour_cost";
    public static String REFILLING_LABOUR_NO="refilling_labour_no";
    public static String SECOND_MANUAL_WEEDING_LABOR_PERIOD="second_manual_weeding_labor_period";
    public static String SECOND_WEED_CONTROL_LABOR="second_weed_control_labor";
    public static String SEED_BED_PREPARATION_PERIOD="seed_bed_preparation_period";
    public static String SEEDBED_LABOR_COST="seedbed_labor_cost";
    public static String SEEDBED_LABOR_NUMBER="seedbed_labor_number";
    public static String SEEDBED_LABOUR_FAMILY="seedbed_labour_family";
    public static String SEEDPLANTING_MATERIAL_COST="seedplanting_material_cost";
    public static String HIRD_MANUAL_WEEDING_LABOR_PERIOD="hird_manual_weeding_labor_period";
    public static String TOPDRESS_FERT_LABOR_PERIOD="topdress_fert_labor_period";
    public static String TOTAL_COST_OF_LABOR_FIFTH_MANUAL_WEED="total_cost_of_labor_fifth_manual_weed";
    public static String TOTAL_COST_OF_LABOR_FIRST_MANUAL_WEED="total_cost_of_labor_first_manual_weed";
    public static String TOTAL_COST_OF_LABOR_FOURTH_MANUAL_WEED="total_cost_of_labor_fourth_manual_weed";
    public static String TOTAL_COST_OF_LABOR_SECOND_MANUAL_WEED="total_cost_of_labor_second_manual_weed";
    public static String TOTAL_COST_OF_LABOR_THIRD_MANUAL_WEED_CO="total_cost_of_labor_third_manual_weed_co";
    public static String TOTAL_NUMBER_OF_LABOR_TOPDRESS="total_number_of_labor_topdress";
    public static String UNIT_COST_HOE_PLOUGHING="unit_cost_hoe_ploughing";
    
    
public void setUnit_cost_hoe_ploughing(String unit_cost_hoe_ploughing) {
underlyingNode.setProperty(UNIT_COST_HOE_PLOUGHING,unit_cost_hoe_ploughing);
}

public String getUnit_cost_hoe_ploughing(){
          try {
          return (String) underlyingNode.getProperty(UNIT_COST_HOE_PLOUGHING);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setTotal_number_of_labor_topdress(String total_number_of_labor_topdress) {
underlyingNode.setProperty(TOTAL_NUMBER_OF_LABOR_TOPDRESS,total_number_of_labor_topdress);
}

public String getTotal_number_of_labor_topdress(){
          try {
          return (String) underlyingNode.getProperty(TOTAL_NUMBER_OF_LABOR_TOPDRESS);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setTotal_cost_of_labor_third_manual_weed_co(String total_cost_of_labor_third_manual_weed_co) {
underlyingNode.setProperty(TOTAL_COST_OF_LABOR_THIRD_MANUAL_WEED_CO,total_cost_of_labor_third_manual_weed_co);
}

public String getTotal_cost_of_labor_third_manual_weed_co(){
          try {
          return (String) underlyingNode.getProperty(TOTAL_COST_OF_LABOR_THIRD_MANUAL_WEED_CO);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setTotal_cost_of_labor_second_manual_weed(String total_cost_of_labor_second_manual_weed) {
underlyingNode.setProperty(TOTAL_COST_OF_LABOR_SECOND_MANUAL_WEED,total_cost_of_labor_second_manual_weed);
}

public String getTotal_cost_of_labor_second_manual_weed(){
          try {
          return (String) underlyingNode.getProperty(TOTAL_COST_OF_LABOR_SECOND_MANUAL_WEED);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setTotal_cost_of_labor_fourth_manual_weed(String total_cost_of_labor_fourth_manual_weed) {
underlyingNode.setProperty(TOTAL_COST_OF_LABOR_FOURTH_MANUAL_WEED,total_cost_of_labor_fourth_manual_weed);
}

public String getTotal_cost_of_labor_fourth_manual_weed(){
          try {
          return (String) underlyingNode.getProperty(TOTAL_COST_OF_LABOR_FOURTH_MANUAL_WEED);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setTotal_cost_of_labor_first_manual_weed(String total_cost_of_labor_first_manual_weed) {
underlyingNode.setProperty(TOTAL_COST_OF_LABOR_FIRST_MANUAL_WEED,total_cost_of_labor_first_manual_weed);
}

public String getTotal_cost_of_labor_first_manual_weed(){
          try {
          return (String) underlyingNode.getProperty(TOTAL_COST_OF_LABOR_FIRST_MANUAL_WEED);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setTotal_cost_of_labor_fifth_manual_weed(String total_cost_of_labor_fifth_manual_weed) {
underlyingNode.setProperty(TOTAL_COST_OF_LABOR_FIFTH_MANUAL_WEED,total_cost_of_labor_fifth_manual_weed);
}

public String getTotal_cost_of_labor_fifth_manual_weed(){
          try {
          return (String) underlyingNode.getProperty(TOTAL_COST_OF_LABOR_FIFTH_MANUAL_WEED);

        } catch (Exception e) {
        }
        return null;
    }
    
    
    
public void setTopdress_fert_labor_period(String topdress_fert_labor_period) {
underlyingNode.setProperty(TOPDRESS_FERT_LABOR_PERIOD,topdress_fert_labor_period);
}

public String getTopdress_fert_labor_period(){
          try {
          return (String) underlyingNode.getProperty(TOPDRESS_FERT_LABOR_PERIOD);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setHird_manual_weeding_labor_period(String hird_manual_weeding_labor_period) {
underlyingNode.setProperty(HIRD_MANUAL_WEEDING_LABOR_PERIOD,hird_manual_weeding_labor_period);
}

public String getHird_manual_weeding_labor_period(){
          try {
          return (String) underlyingNode.getProperty(HIRD_MANUAL_WEEDING_LABOR_PERIOD);

        } catch (Exception e) {
        }
        return null;
    }
    
    
    
public void setSeedplanting_material_cost(String seedplanting_material_cost) {
underlyingNode.setProperty(SEEDPLANTING_MATERIAL_COST,seedplanting_material_cost);
}

public String getSeedplanting_material_cost(){
          try {
          return (String) underlyingNode.getProperty(SEEDPLANTING_MATERIAL_COST);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setSeedbed_labour_family(String seedbed_labour_family) {
underlyingNode.setProperty(SEEDBED_LABOUR_FAMILY,seedbed_labour_family);
}

public String getSeedbed_labour_family(){
          try {
          return (String) underlyingNode.getProperty(SEEDBED_LABOUR_FAMILY);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setSeedbed_labor_number(String seedbed_labor_number) {
underlyingNode.setProperty(SEEDBED_LABOR_NUMBER,seedbed_labor_number);
}

public String getSeedbed_labor_number(){
          try {
          return (String) underlyingNode.getProperty(SEEDBED_LABOR_NUMBER);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setSeedbed_labor_cost(String seedbed_labor_cost) {
underlyingNode.setProperty(SEEDBED_LABOR_COST,seedbed_labor_cost);
}

public String getSeedbed_labor_cost(){
          try {
          return (String) underlyingNode.getProperty(SEEDBED_LABOR_COST);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setSeed_bed_preparation_period(String seed_bed_preparation_period) {
underlyingNode.setProperty(SEED_BED_PREPARATION_PERIOD,seed_bed_preparation_period);
}

public String getSeed_bed_preparation_period(){
          try {
          return (String) underlyingNode.getProperty(SEED_BED_PREPARATION_PERIOD);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setSecond_weed_control_labor(String second_weed_control_labor) {
underlyingNode.setProperty(SECOND_WEED_CONTROL_LABOR,second_weed_control_labor);
}

public String getSecond_weed_control_labor(){
          try {
          return (String) underlyingNode.getProperty(SECOND_WEED_CONTROL_LABOR);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setSecond_manual_weeding_labor_period(String second_manual_weeding_labor_period) {
underlyingNode.setProperty(SECOND_MANUAL_WEEDING_LABOR_PERIOD,second_manual_weeding_labor_period);
}

public String getSecond_manual_weeding_labor_period(){
          try {
          return (String) underlyingNode.getProperty(SECOND_MANUAL_WEEDING_LABOR_PERIOD);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setRefilling_labour_no(String refilling_labour_no) {
underlyingNode.setProperty(REFILLING_LABOUR_NO,refilling_labour_no);
}

public String getRefilling_labour_no(){
          try {
          return (String) underlyingNode.getProperty(REFILLING_LABOUR_NO);

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
    
    
public void setRefilling_labor_period(String refilling_labor_period) {
underlyingNode.setProperty(REFILLING_LABOR_PERIOD,refilling_labor_period);
}

public String getRefilling_labor_period(){
          try {
          return (String) underlyingNode.getProperty(REFILLING_LABOR_PERIOD);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setQuantity_of_preplant_herbicide_liters(String quantity_of_preplant_herbicide_liters) {
underlyingNode.setProperty(QUANTITY_OF_PREPLANT_HERBICIDE_LITERS,quantity_of_preplant_herbicide_liters);
}

public String getQuantity_of_preplant_herbicide_liters(){
          try {
          return (String) underlyingNode.getProperty(QUANTITY_OF_PREPLANT_HERBICIDE_LITERS);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setPrice_of_topdress_fertilizer(String price_of_topdress_fertilizer) {
underlyingNode.setProperty(PRICE_OF_TOPDRESS_FERTILIZER,price_of_topdress_fertilizer);
}

public String getPrice_of_topdress_fertilizer(){
          try {
          return (String) underlyingNode.getProperty(PRICE_OF_TOPDRESS_FERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setPrice_of_herbicide_ghc(String price_of_herbicide_ghc) {
underlyingNode.setProperty(PRICE_OF_HERBICIDE_GHC,price_of_herbicide_ghc);
}

public String getPrice_of_herbicide_ghc(){
          try {
          return (String) underlyingNode.getProperty(PRICE_OF_HERBICIDE_GHC);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setPrice_of_basal_fertilizer(String price_of_basal_fertilizer) {
underlyingNode.setProperty(PRICE_OF_BASAL_FERTILIZER,price_of_basal_fertilizer);
}

public String getPrice_of_basal_fertilizer(){
          try {
          return (String) underlyingNode.getProperty(PRICE_OF_BASAL_FERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }
    
    
    
public void setPost_plant_herbicide_cost(String post_plant_herbicide_cost) {
underlyingNode.setProperty(POST_PLANT_HERBICIDE_COST,post_plant_herbicide_cost);
}

public String getPost_plant_herbicide_cost(){
          try {
          return (String) underlyingNode.getProperty(POST_PLANT_HERBICIDE_COST);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setPloughing_cost_per_acre(String ploughing_cost_per_acre) {
underlyingNode.setProperty(PLOUGHING_COST_PER_ACRE,ploughing_cost_per_acre);
}

public String getPloughing_cost_per_acre(){
          try {
          return (String) underlyingNode.getProperty(PLOUGHING_COST_PER_ACRE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setPlanting_period2(String planting_period2) {
underlyingNode.setProperty(PLANTING_PERIOD2,planting_period2);
}

public String getPlanting_period2(){
          try {
          return (String) underlyingNode.getProperty(PLANTING_PERIOD2);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setPlanting_labor_cost(String planting_labor_cost) {
underlyingNode.setProperty(PLANTING_LABOR_COST,planting_labor_cost);
}

public String getPlanting_labor_cost(){
          try {
          return (String) underlyingNode.getProperty(PLANTING_LABOR_COST);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setPeriod_for_completion_of_harvest(String period_for_completion_of_harvest) {
underlyingNode.setProperty(PERIOD_FOR_COMPLETION_OF_HARVEST,period_for_completion_of_harvest);
}

public String getPeriod_for_completion_of_harvest(){
          try {
          return (String) underlyingNode.getProperty(PERIOD_FOR_COMPLETION_OF_HARVEST);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setLand_rent(String land_rent) {
underlyingNode.setProperty(LAND_RENT,land_rent);
}

public String getLand_rent(){
          try {
          return (String) underlyingNode.getProperty(LAND_RENT);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setLabor_third_weed_control(String labor_third_weed_control) {
underlyingNode.setProperty(LABOR_THIRD_WEED_CONTROL,labor_third_weed_control);
}

public String getLabor_third_weed_control(){
          try {
          return (String) underlyingNode.getProperty(LABOR_THIRD_WEED_CONTROL);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setLabor_fourth_weed_control(String labor_fourth_weed_control) {
underlyingNode.setProperty(LABOR_FOURTH_WEED_CONTROL,labor_fourth_weed_control);
}

public String getLabor_fourth_weed_control(){
          try {
          return (String) underlyingNode.getProperty(LABOR_FOURTH_WEED_CONTROL);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setLabor_for_plantingfamily(String labor_for_plantingfamily) {
underlyingNode.setProperty(LABOR_FOR_PLANTINGFAMILY,labor_for_plantingfamily);
}

public String getLabor_for_plantingfamily(){
          try {
          return (String) underlyingNode.getProperty(LABOR_FOR_PLANTINGFAMILY);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setLabor_for_planting_number(String labor_for_planting_number) {
underlyingNode.setProperty(LABOR_FOR_PLANTING_NUMBER,labor_for_planting_number);
}

public String getLabor_for_planting_number(){
          try {
          return (String) underlyingNode.getProperty(LABOR_FOR_PLANTING_NUMBER);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setLabor_fifth_weed_control(String labor_fifth_weed_control) {
underlyingNode.setProperty(LABOR_FIFTH_WEED_CONTROL,labor_fifth_weed_control);
}

public String getLabor_fifth_weed_control(){
          try {
          return (String) underlyingNode.getProperty(LABOR_FIFTH_WEED_CONTROL);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setHoe_ploughing_labour_period(String hoe_ploughing_labour_period) {
underlyingNode.setProperty(HOE_PLOUGHING_LABOUR_PERIOD,hoe_ploughing_labour_period);
}

public String getHoe_ploughing_labour_period(){
          try {
          return (String) underlyingNode.getProperty(HOE_PLOUGHING_LABOUR_PERIOD);

        } catch (Exception e) {
        }
        return null;
    }
    
    
    
public void setHoe_ploughing_labour_how_many_people(String hoe_ploughing_labour_how_many_people) {
underlyingNode.setProperty(HOE_PLOUGHING_LABOUR_HOW_MANY_PEOPLE,hoe_ploughing_labour_how_many_people);
}

public String getHoe_ploughing_labour_how_many_people(){
          try {
          return (String) underlyingNode.getProperty(HOE_PLOUGHING_LABOUR_HOW_MANY_PEOPLE);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setHoe_ploughing_labour_family_how_many_fam(String hoe_ploughing_labour_family_how_many_fam) {
underlyingNode.setProperty(HOE_PLOUGHING_LABOUR_FAMILY_HOW_MANY_FAM,hoe_ploughing_labour_family_how_many_fam);
}

public String getHoe_ploughing_labour_family_how_many_fam(){
          try {
          return (String) underlyingNode.getProperty(HOE_PLOUGHING_LABOUR_FAMILY_HOW_MANY_FAM);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setHerbicide_application_labor_period_how_l(String herbicide_application_labor_period_how_l) {
underlyingNode.setProperty(HERBICIDE_APPLICATION_LABOR_PERIOD_HOW_L,herbicide_application_labor_period_how_l);
}

public String getHerbicide_application_labor_period_how_l(){
          try {
          return (String) underlyingNode.getProperty(HERBICIDE_APPLICATION_LABOR_PERIOD_HOW_L);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setHerbicide_application_cost_post_plant(String herbicide_application_cost_post_plant) {
underlyingNode.setProperty(HERBICIDE_APPLICATION_COST_POST_PLANT,herbicide_application_cost_post_plant);
}

public String getHerbicide_application_cost_post_plant(){
          try {
          return (String) underlyingNode.getProperty(HERBICIDE_APPLICATION_COST_POST_PLANT);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setHerbicide_application_cost(String herbicide_application_cost) {
underlyingNode.setProperty(HERBICIDE_APPLICATION_COST,herbicide_application_cost);
}

public String getHerbicide_application_cost(){
          try {
          return (String) underlyingNode.getProperty(HERBICIDE_APPLICATION_COST);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setHarvest_labor_costsper_acre(String harvest_labor_costsper_acre) {
underlyingNode.setProperty(HARVEST_LABOR_COSTSPER_ACRE,harvest_labor_costsper_acre);
}

public String getHarvest_labor_costsper_acre(){
          try {
          return (String) underlyingNode.getProperty(HARVEST_LABOR_COSTSPER_ACRE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setHarrowing_cost_per_acre(String harrowing_cost_per_acre) {
underlyingNode.setProperty(HARROWING_COST_PER_ACRE,harrowing_cost_per_acre);
}

public String getHarrowing_cost_per_acre(){
          try {
          return (String) underlyingNode.getProperty(HARROWING_COST_PER_ACRE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setFourth_manual_weeding_labor_period(String fourth_manual_weeding_labor_period) {
underlyingNode.setProperty(FOURTH_MANUAL_WEEDING_LABOR_PERIOD,fourth_manual_weeding_labor_period);
}

public String getFourth_manual_weeding_labor_period(){
          try {
          return (String) underlyingNode.getProperty(FOURTH_MANUAL_WEEDING_LABOR_PERIOD);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setFirst_manual_weeding_labor_period(String first_manual_weeding_labor_period) {
underlyingNode.setProperty(FIRST_MANUAL_WEEDING_LABOR_PERIOD,first_manual_weeding_labor_period);
}

public String getFirst_manual_weeding_labor_period(){
          try {
          return (String) underlyingNode.getProperty(FIRST_MANUAL_WEEDING_LABOR_PERIOD);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setFirst_manual_weed_control_labor(String first_manual_weed_control_labor) {
underlyingNode.setProperty(FIRST_MANUAL_WEED_CONTROL_LABOR,first_manual_weed_control_labor);
}

public String getFirst_manual_weed_control_labor(){
          try {
          return (String) underlyingNode.getProperty(FIRST_MANUAL_WEED_CONTROL_LABOR);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setFinal_harvest_labor_how_many_labor_hands(String final_harvest_labor_how_many_labor_hands) {
underlyingNode.setProperty(FINAL_HARVEST_LABOR_HOW_MANY_LABOR_HANDS,final_harvest_labor_how_many_labor_hands);
}

public String getFinal_harvest_labor_how_many_labor_hands(){
          try {
          return (String) underlyingNode.getProperty(FINAL_HARVEST_LABOR_HOW_MANY_LABOR_HANDS);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setFinal_harvest_family_labor(String final_harvest_family_labor) {
underlyingNode.setProperty(FINAL_HARVEST_FAMILY_LABOR,final_harvest_family_labor);
}

public String getFinal_harvest_family_labor(){
          try {
          return (String) underlyingNode.getProperty(FINAL_HARVEST_FAMILY_LABOR);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setFifth_manual_weeding_labor_period(String fifth_manual_weeding_labor_period) {
underlyingNode.setProperty(FIFTH_MANUAL_WEEDING_LABOR_PERIOD,fifth_manual_weeding_labor_period);
}

public String getFifth_manual_weeding_labor_period(){
          try {
          return (String) underlyingNode.getProperty(FIFTH_MANUAL_WEEDING_LABOR_PERIOD);

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

    
public void setFamily_labor_third_weed_control(String family_labor_third_weed_control) {
underlyingNode.setProperty(FAMILY_LABOR_THIRD_WEED_CONTROL,family_labor_third_weed_control);
}

public String getFamily_labor_third_weed_control(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_THIRD_WEED_CONTROL);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setFamily_labor_second_manual_weed_control(String family_labor_second_manual_weed_control) {
underlyingNode.setProperty(FAMILY_LABOR_SECOND_MANUAL_WEED_CONTROL,family_labor_second_manual_weed_control);
}

public String getFamily_labor_second_manual_weed_control(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_SECOND_MANUAL_WEED_CONTROL);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setFamily_labor_fourth_weeding(String family_labor_fourth_weeding) {
underlyingNode.setProperty(FAMILY_LABOR_FOURTH_WEEDING,family_labor_fourth_weeding);
}

public String getFamily_labor_fourth_weeding(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_FOURTH_WEEDING);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setFamily_labor_first_manual_weed_control(String family_labor_first_manual_weed_control) {
underlyingNode.setProperty(FAMILY_LABOR_FIRST_MANUAL_WEED_CONTROL,family_labor_first_manual_weed_control);
}

public String getFamily_labor_first_manual_weed_control(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_FIRST_MANUAL_WEED_CONTROL);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setFamily_labor_fifth_weed_control(String family_labor_fifth_weed_control) {
underlyingNode.setProperty(FAMILY_LABOR_FIFTH_WEED_CONTROL,family_labor_fifth_weed_control);
}

public String getFamily_labor_fifth_weed_control(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_FIFTH_WEED_CONTROL);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setFamily_labor_basal_fertilizer_applicatio(String family_labor_basal_fertilizer_applicatio) {
underlyingNode.setProperty(FAMILY_LABOR_BASAL_FERTILIZER_APPLICATIO,family_labor_basal_fertilizer_applicatio);
}

public String getFamily_labor_basal_fertilizer_applicatio(){
          try {
          return (String) underlyingNode.getProperty(FAMILY_LABOR_BASAL_FERTILIZER_APPLICATIO);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setCost_of_applicationtopdress(String cost_of_applicationtopdress) {
underlyingNode.setProperty(COST_OF_APPLICATIONTOPDRESS,cost_of_applicationtopdress);
}

public String getCost_of_applicationtopdress(){
          try {
          return (String) underlyingNode.getProperty(COST_OF_APPLICATIONTOPDRESS);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setBasal_fertilizer_application_total_labou(String basal_fertilizer_application_total_labou) {
underlyingNode.setProperty(BASAL_FERTILIZER_APPLICATION_TOTAL_LABOU,basal_fertilizer_application_total_labou);
}

public String getBasal_fertilizer_application_total_labou(){
          try {
          return (String) underlyingNode.getProperty(BASAL_FERTILIZER_APPLICATION_TOTAL_LABOU);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setBasal_fertilizer_appl_labour_cost(String basal_fertilizer_appl_labour_cost) {
underlyingNode.setProperty(BASAL_FERTILIZER_APPL_LABOUR_COST,basal_fertilizer_appl_labour_cost);
}

public String getBasal_fertilizer_appl_labour_cost(){
          try {
          return (String) underlyingNode.getProperty(BASAL_FERTILIZER_APPL_LABOUR_COST);

        } catch (Exception e) {
        }
        return null;
    }
public void setBasal_fert_labor_period(String basal_fert_labor_period) {
underlyingNode.setProperty(BASAL_FERT_LABOR_PERIOD,basal_fert_labor_period);
}

public String getBasal_fert_labor_period(){
          try {
          return (String) underlyingNode.getProperty(BASAL_FERT_LABOR_PERIOD);

        } catch (Exception e) {
        }
        return null;
    }


 public void setUpdate(Node FMPPBU) {
        underlyingNode.createRelationshipTo(FMPPBU, ICTCRelationshipTypes.UPDATE);
    }

    public FmpProductionBudgetUpdate getUpdate() {
        return new FmpProductionBudgetUpdate(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.UPDATE));
    }

}
