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
 * @date Oct 12, 2015 2:42:19 PM
 * description:
 */
public class BaselineProduction extends Status implements GeneralInterface{

    Node underlyingNode = null;
    
    
    public BaselineProduction(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }
    
    
    public static String APPLIC_BASAL_FERT_BASE = "applic_basal_fert_base";
    public static String APPLIC_POSTPLANT_HERB_DATE_BASE = "applic_postplant_herb_date_base";
    public static String APPLIC_TOPDRESS_FERT_BASE = "applic_topdress_fert_base";
    public static String AREA_CULTIVATED_BASE = "area_cultivated_base";
    public static String CROP_TO_CULTIVATE_BASE = "crop_to_cultivate_base";
    public static String DATE_FIFTH_MANUAL_WEED_BASE = "date_fifth_manual_weed_base";
    public static String DATE_FIRST_MANUAL_WEED_BASE = "date_first_manual_weed_base";
    public static String DATE_FOURTH_MANUAL_WEED_BASE = "date_fourth_manual_weed_base";
    public static String DATE_OF_HARVEST_BASE = "date_of_harvest_base";
    public static String DATE_SECOND_MANUAL_WEED_BASE = "date_second_manual_weed_base";
    public static String DATE_THIRD_MANUAL_WEED_BASE = "date_third_manual_weed_base";
    public static String DISTANCE_BETWEEN_PLANTS_BASE = "distance_between_plants_base";
    public static String DISTANCE_BETWEEN_ROWS_BASE = "distance_between_rows_base";
    public static String LAND_CLEARING_DATE_BASE = "land_clearing_date_base";
    public static String METHOD_BFERT_APPLIC_BASE = "method_bfert_applic_base";
    public static String METHOD_OF_LAND_CLEARING_BASE = "method_of_land_clearing_base";
    public static String METHOD_OF_LAND_PREPARATION_BASE = "method_of_land_preparation_base";
    public static String METHOD_TOPDRESS_FERT_BASE = "method_topdress_fert_base";
    public static String NAME_OF_CROP_VARIETY_CULTIVATED_BASE = "name_of_crop_variety_cultivated_base";
    public static String NAME_OF_OTHER_VARIETY_BASE = "name_of_other_variety_base";
    public static String NAME_OF_VARIETY_CASS_BASE = "name_of_variety_cass_base";
    public static String NAME_OF_VARIETY_RICE_BASE = "name_of_variety_rice_base";
    public static String NAME_OF_VARIETY_YAM = "name_of_variety_yam";
    public static String NO_OCCASIONS_MANUAL_WEED_BASE = "no_occasions_manual_weed_base";
    public static String OTHER_BASAL_FERT_BASE = "other_basal_fert_base";
    public static String OTHER_METHOD_BFERT_APPLIC_BASE = "other_method_bfert_applic_base";
    public static String OTHER_SOURCES_SEED_BASE = "other_sources_seed_base";
    public static String OTHER_TOPDRESS_FERTILIZER_TYPE_BASE = "other_topdress_fertilizer_type_base";
    public static String PLANTING_DATE_BASE = "planting_date_base";
    public static String PLOUGHING_DATE_BASE = "ploughing_date_base";
    public static String POSTPLANT_HERBICIDE_USE_BASE = "postplant_herbicide_use_base";
    public static String QTY_OF_BFERT_APPLIED_BASE = "qty_of_bfert_applied_base";
    public static String QUANTITY_POSTPLANT_HERBICIDE_BASE = "quantity_postplant_herbicide_base";
    public static String QUANTITY_TOPDRESS_FERTILIZER_BASE = "quantity_topdress_fertilizer_base";
    public static String REFILLING_GAPS_OCCURRENCE_BASE = "refilling_gaps_occurrence_base";
    public static String REFILLING_PROPORTION_BASE = "refilling_proportion_base";
    public static String SEED_BED_PREPARATION_DATE_BASE = "seed_bed_preparation_date_base";
    public static String SEEDBED_TYPE_BASE = "seedbed_type_base";
    public static String SOURCE_OF_SEED_BASE = "source_of_seed_base";
    public static String TARGETED_YIELD_BASE = "targeted_yield_base";
    public static String TIME_BASAL_FERT_APPL_BASE = "time_basal_fert_appl_base";
    public static String TIME_TOPDRESS_APPL_BASE = "time_topdress_appl_base";
    public static String TYPE_BASAL_FERT_BASE = "type_basal_fert_base";
    public static String TYPE_FERTILIZER_TOPDRESS_BASE = "type_fertilizer_topdress_base";
    public static String TYPE_OF_HERBICIDE_POSTPLANT_BASE = "type_of_herbicide_postplant_base";
    public static String TYPE_OF_VARIETY_CULTIVATED_BASE = "type_of_variety_cultivated_base";
   
   
public void setType_of_variety_cultivated_base(String type_of_variety_cultivated_base) {
underlyingNode.setProperty(TYPE_OF_VARIETY_CULTIVATED_BASE,type_of_variety_cultivated_base);
}

public String getType_of_variety_cultivated_base(){
          try {
          return (String) underlyingNode.getProperty(TYPE_OF_VARIETY_CULTIVATED_BASE);

        } catch (Exception e) {
        }
        return null;
    }

   
   
public void setType_of_herbicide_postplant_base(String type_of_herbicide_postplant_base) {
underlyingNode.setProperty(TYPE_OF_HERBICIDE_POSTPLANT_BASE,type_of_herbicide_postplant_base);
}

public String getType_of_herbicide_postplant_base(){
          try {
          return (String) underlyingNode.getProperty(TYPE_OF_HERBICIDE_POSTPLANT_BASE);

        } catch (Exception e) {
        }
        return null;
    }
   
   
public void setType_fertilizer_topdress_base(String type_fertilizer_topdress_base) {
underlyingNode.setProperty(TYPE_FERTILIZER_TOPDRESS_BASE,type_fertilizer_topdress_base);
}

public String getType_fertilizer_topdress_base(){
          try {
          return (String) underlyingNode.getProperty(TYPE_FERTILIZER_TOPDRESS_BASE);

        } catch (Exception e) {
        }
        return null;
    }

   
   
public void setType_basal_fert_base(String type_basal_fert_base) {
underlyingNode.setProperty(TYPE_BASAL_FERT_BASE,type_basal_fert_base);
}

public String getType_basal_fert_base(){
          try {
          return (String) underlyingNode.getProperty(TYPE_BASAL_FERT_BASE);

        } catch (Exception e) {
        }
        return null;
    }
   
public void setTime_topdress_appl_base(String time_topdress_appl_base) {
underlyingNode.setProperty(TIME_TOPDRESS_APPL_BASE,time_topdress_appl_base);
}

public String getTime_topdress_appl_base(){
          try {
          return (String) underlyingNode.getProperty(TIME_TOPDRESS_APPL_BASE);

        } catch (Exception e) {
        }
        return null;
    }
   
   
public void setTime_basal_fert_appl_base(String time_basal_fert_appl_base) {
underlyingNode.setProperty(TIME_BASAL_FERT_APPL_BASE,time_basal_fert_appl_base);
}

public String getTime_basal_fert_appl_base(){
          try {
          return (String) underlyingNode.getProperty(TIME_BASAL_FERT_APPL_BASE);

        } catch (Exception e) {
        }
        return null;
    }
   
   
public void setTargeted_yield_base(String targeted_yield_base) {
underlyingNode.setProperty(TARGETED_YIELD_BASE,targeted_yield_base);
}

public String getTargeted_yield_base(){
          try {
          return (String) underlyingNode.getProperty(TARGETED_YIELD_BASE);

        } catch (Exception e) {
        }
        return null;
    }

   
   
public void setSource_of_seed_base(String source_of_seed_base) {
underlyingNode.setProperty(SOURCE_OF_SEED_BASE,source_of_seed_base);
}

public String getSource_of_seed_base(){
          try {
          return (String) underlyingNode.getProperty(SOURCE_OF_SEED_BASE);

        } catch (Exception e) {
        }
        return null;
    }
   
   
public void setSeedbed_type_base(String seedbed_type_base) {
underlyingNode.setProperty(SEEDBED_TYPE_BASE,seedbed_type_base);
}

public String getSeedbed_type_base(){
          try {
          return (String) underlyingNode.getProperty(SEEDBED_TYPE_BASE);

        } catch (Exception e) {
        }
        return null;
    }

   
   
public void setSeed_bed_preparation_date_base(String seed_bed_preparation_date_base) {
underlyingNode.setProperty(SEED_BED_PREPARATION_DATE_BASE,seed_bed_preparation_date_base);
}

public String getSeed_bed_preparation_date_base(){
          try {
          return (String) underlyingNode.getProperty(SEED_BED_PREPARATION_DATE_BASE);

        } catch (Exception e) {
        }
        return null;
    }
   
   
public void setRefilling_proportion_base(String refilling_proportion_base) {
underlyingNode.setProperty(REFILLING_PROPORTION_BASE,refilling_proportion_base);
}

public String getRefilling_proportion_base(){
          try {
          return (String) underlyingNode.getProperty(REFILLING_PROPORTION_BASE);

        } catch (Exception e) {
        }
        return null;
    }
   
   
public void setRefilling_gaps_occurrence_base(String refilling_gaps_occurrence_base) {
underlyingNode.setProperty(REFILLING_GAPS_OCCURRENCE_BASE,refilling_gaps_occurrence_base);
}

public String getRefilling_gaps_occurrence_base(){
          try {
          return (String) underlyingNode.getProperty(REFILLING_GAPS_OCCURRENCE_BASE);

        } catch (Exception e) {
        }
        return null;
    }
   
public void setQuantity_topdress_fertilizer_base(String quantity_topdress_fertilizer_base) {
underlyingNode.setProperty(QUANTITY_TOPDRESS_FERTILIZER_BASE,quantity_topdress_fertilizer_base);
}

public String getQuantity_topdress_fertilizer_base(){
          try {
          return (String) underlyingNode.getProperty(QUANTITY_TOPDRESS_FERTILIZER_BASE);

        } catch (Exception e) {
        }
        return null;
    }
   
public void setQuantity_postplant_herbicide_base(String quantity_postplant_herbicide_base) {
underlyingNode.setProperty(QUANTITY_POSTPLANT_HERBICIDE_BASE,quantity_postplant_herbicide_base);
}

public String getQuantity_postplant_herbicide_base(){
          try {
          return (String) underlyingNode.getProperty(QUANTITY_POSTPLANT_HERBICIDE_BASE);

        } catch (Exception e) {
        }
        return null;
    }
   
   
public void setQty_of_bfert_applied_base(String qty_of_bfert_applied_base) {
underlyingNode.setProperty(QTY_OF_BFERT_APPLIED_BASE,qty_of_bfert_applied_base);
}

public String getQty_of_bfert_applied_base(){
          try {
          return (String) underlyingNode.getProperty(QTY_OF_BFERT_APPLIED_BASE);

        } catch (Exception e) {
        }
        return null;
    }
   
   
public void setPostplant_herbicide_use_base(String postplant_herbicide_use_base) {
underlyingNode.setProperty(POSTPLANT_HERBICIDE_USE_BASE,postplant_herbicide_use_base);
}

public String getPostplant_herbicide_use_base(){
          try {
          return (String) underlyingNode.getProperty(POSTPLANT_HERBICIDE_USE_BASE);

        } catch (Exception e) {
        }
        return null;
    }

   
   
public void setPloughing_date_base(String ploughing_date_base) {
underlyingNode.setProperty(PLOUGHING_DATE_BASE,ploughing_date_base);
}

public String getPloughing_date_base(){
          try {
          return (String) underlyingNode.getProperty(PLOUGHING_DATE_BASE);

        } catch (Exception e) {
        }
        return null;
    }
   
   
public void setPlanting_date_base(String planting_date_base) {
underlyingNode.setProperty(PLANTING_DATE_BASE,planting_date_base);
}

public String getPlanting_date_base(){
          try {
          return (String) underlyingNode.getProperty(PLANTING_DATE_BASE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setOther_topdress_fertilizer_type_base(String other_topdress_fertilizer_type_base) {
underlyingNode.setProperty(OTHER_TOPDRESS_FERTILIZER_TYPE_BASE,other_topdress_fertilizer_type_base);
}

public String getOther_topdress_fertilizer_type_base(){
          try {
          return (String) underlyingNode.getProperty(OTHER_TOPDRESS_FERTILIZER_TYPE_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setOther_sources_seed_base(String other_sources_seed_base) {
underlyingNode.setProperty(OTHER_SOURCES_SEED_BASE,other_sources_seed_base);
}

public String getOther_sources_seed_base(){
          try {
          return (String) underlyingNode.getProperty(OTHER_SOURCES_SEED_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setOther_method_bfert_applic_base(String other_method_bfert_applic_base) {
underlyingNode.setProperty(OTHER_METHOD_BFERT_APPLIC_BASE,other_method_bfert_applic_base);
}

public String getOther_method_bfert_applic_base(){
          try {
          return (String) underlyingNode.getProperty(OTHER_METHOD_BFERT_APPLIC_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setOther_basal_fert_base(String other_basal_fert_base) {
underlyingNode.setProperty(OTHER_BASAL_FERT_BASE,other_basal_fert_base);
}

public String getOther_basal_fert_base(){
          try {
          return (String) underlyingNode.getProperty(OTHER_BASAL_FERT_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setNo_occasions_manual_weed_base(String no_occasions_manual_weed_base) {
underlyingNode.setProperty(NO_OCCASIONS_MANUAL_WEED_BASE,no_occasions_manual_weed_base);
}

public String getNo_occasions_manual_weed_base(){
          try {
          return (String) underlyingNode.getProperty(NO_OCCASIONS_MANUAL_WEED_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setName_of_variety_yam(String name_of_variety_yam) {
underlyingNode.setProperty(NAME_OF_VARIETY_YAM,name_of_variety_yam);
}

public String getName_of_variety_yam(){
          try {
          return (String) underlyingNode.getProperty(NAME_OF_VARIETY_YAM);

        } catch (Exception e) {
        }
        return null;
    }

    
    
    
public void setName_of_variety_rice_base(String name_of_variety_rice_base) {
underlyingNode.setProperty(NAME_OF_VARIETY_RICE_BASE,name_of_variety_rice_base);
}

public String getName_of_variety_rice_base(){
          try {
          return (String) underlyingNode.getProperty(NAME_OF_VARIETY_RICE_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setName_of_variety_cass_base(String name_of_variety_cass_base) {
underlyingNode.setProperty(NAME_OF_VARIETY_CASS_BASE,name_of_variety_cass_base);
}

public String getName_of_variety_cass_base(){
          try {
          return (String) underlyingNode.getProperty(NAME_OF_VARIETY_CASS_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setName_of_other_variety_base(String name_of_other_variety_base) {
underlyingNode.setProperty(NAME_OF_OTHER_VARIETY_BASE,name_of_other_variety_base);
}

public String getName_of_other_variety_base(){
          try {
          return (String) underlyingNode.getProperty(NAME_OF_OTHER_VARIETY_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setName_of_crop_variety_cultivated_base(String name_of_crop_variety_cultivated_base) {
underlyingNode.setProperty(NAME_OF_CROP_VARIETY_CULTIVATED_BASE,name_of_crop_variety_cultivated_base);
}

public String getName_of_crop_variety_cultivated_base(){
          try {
          return (String) underlyingNode.getProperty(NAME_OF_CROP_VARIETY_CULTIVATED_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setMethod_topdress_fert_base(String method_topdress_fert_base) {
underlyingNode.setProperty(METHOD_TOPDRESS_FERT_BASE,method_topdress_fert_base);
}

public String getMethod_topdress_fert_base(){
          try {
          return (String) underlyingNode.getProperty(METHOD_TOPDRESS_FERT_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setMethod_of_land_preparation_base(String method_of_land_preparation_base) {
underlyingNode.setProperty(METHOD_OF_LAND_PREPARATION_BASE,method_of_land_preparation_base);
}

public String getMethod_of_land_preparation_base(){
          try {
          return (String) underlyingNode.getProperty(METHOD_OF_LAND_PREPARATION_BASE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setMethod_of_land_clearing_base(String method_of_land_clearing_base) {
underlyingNode.setProperty(METHOD_OF_LAND_CLEARING_BASE,method_of_land_clearing_base);
}

public String getMethod_of_land_clearing_base(){
          try {
          return (String) underlyingNode.getProperty(METHOD_OF_LAND_CLEARING_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setMethod_bfert_applic_base(String method_bfert_applic_base) {
underlyingNode.setProperty(METHOD_BFERT_APPLIC_BASE,method_bfert_applic_base);
}

public String getMethod_bfert_applic_base(){
          try {
          return (String) underlyingNode.getProperty(METHOD_BFERT_APPLIC_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setLand_clearing_date_base(String land_clearing_date_base) {
underlyingNode.setProperty(LAND_CLEARING_DATE_BASE,land_clearing_date_base);
}

public String getLand_clearing_date_base(){
          try {
          return (String) underlyingNode.getProperty(LAND_CLEARING_DATE_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setDistance_between_rows_base(String distance_between_rows_base) {
underlyingNode.setProperty(DISTANCE_BETWEEN_ROWS_BASE,distance_between_rows_base);
}

public String getDistance_between_rows_base(){
          try {
          return (String) underlyingNode.getProperty(DISTANCE_BETWEEN_ROWS_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setDistance_between_plants_base(String distance_between_plants_base) {
underlyingNode.setProperty(DISTANCE_BETWEEN_PLANTS_BASE,distance_between_plants_base);
}

public String getDistance_between_plants_base(){
          try {
          return (String) underlyingNode.getProperty(DISTANCE_BETWEEN_PLANTS_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setDate_third_manual_weed_base(String date_third_manual_weed_base) {
underlyingNode.setProperty(DATE_THIRD_MANUAL_WEED_BASE,date_third_manual_weed_base);
}

public String getDate_third_manual_weed_base(){
          try {
          return (String) underlyingNode.getProperty(DATE_THIRD_MANUAL_WEED_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setDate_second_manual_weed_base(String date_second_manual_weed_base) {
underlyingNode.setProperty(DATE_SECOND_MANUAL_WEED_BASE,date_second_manual_weed_base);
}

public String getDate_second_manual_weed_base(){
          try {
          return (String) underlyingNode.getProperty(DATE_SECOND_MANUAL_WEED_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setDate_of_harvest_base(String date_of_harvest_base) {
underlyingNode.setProperty(DATE_OF_HARVEST_BASE,date_of_harvest_base);
}

public String getDate_of_harvest_base(){
          try {
          return (String) underlyingNode.getProperty(DATE_OF_HARVEST_BASE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setDate_fourth_manual_weed_base(String date_fourth_manual_weed_base) {
underlyingNode.setProperty(DATE_FOURTH_MANUAL_WEED_BASE,date_fourth_manual_weed_base);
}

public String getDate_fourth_manual_weed_base(){
          try {
          return (String) underlyingNode.getProperty(DATE_FOURTH_MANUAL_WEED_BASE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setDate_first_manual_weed_base(String date_first_manual_weed_base) {
underlyingNode.setProperty(DATE_FIRST_MANUAL_WEED_BASE,date_first_manual_weed_base);
}

public String getDate_first_manual_weed_base(){
          try {
          return (String) underlyingNode.getProperty(DATE_FIRST_MANUAL_WEED_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setDate_fifth_manual_weed_base(String date_fifth_manual_weed_base) {
underlyingNode.setProperty(DATE_FIFTH_MANUAL_WEED_BASE,date_fifth_manual_weed_base);
}

public String getDate_fifth_manual_weed_base(){
          try {
          return (String) underlyingNode.getProperty(DATE_FIFTH_MANUAL_WEED_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setCrop_to_cultivate_base(String crop_to_cultivate_base) {
underlyingNode.setProperty(CROP_TO_CULTIVATE_BASE,crop_to_cultivate_base);
}

public String getCrop_to_cultivate_base(){
          try {
          return (String) underlyingNode.getProperty(CROP_TO_CULTIVATE_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setArea_cultivated_base(String area_cultivated_base) {
underlyingNode.setProperty(AREA_CULTIVATED_BASE,area_cultivated_base);
}

public String getArea_cultivated_base(){
          try {
          return (String) underlyingNode.getProperty(AREA_CULTIVATED_BASE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setApplic_topdress_fert_base(String applic_topdress_fert_base) {
underlyingNode.setProperty(APPLIC_TOPDRESS_FERT_BASE,applic_topdress_fert_base);
}

public String getApplic_topdress_fert_base(){
          try {
          return (String) underlyingNode.getProperty(APPLIC_TOPDRESS_FERT_BASE);

        } catch (Exception e) {
        }
        return null;
    }
public void setApplic_postplant_herb_date_base(String applic_postplant_herb_date_base) {
underlyingNode.setProperty(APPLIC_POSTPLANT_HERB_DATE_BASE,applic_postplant_herb_date_base);
}

public String getApplic_postplant_herb_date_base(){
          try {
          return (String) underlyingNode.getProperty(APPLIC_POSTPLANT_HERB_DATE_BASE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setApplic_basal_fert_base(String applic_basal_fert_base) {
underlyingNode.setProperty(APPLIC_BASAL_FERT_BASE,applic_basal_fert_base);
}

public String getApplic_basal_fert_base(){
          try {
          return (String) underlyingNode.getProperty(APPLIC_BASAL_FERT_BASE);

        } catch (Exception e) {
        }
        return null;
    }

}
