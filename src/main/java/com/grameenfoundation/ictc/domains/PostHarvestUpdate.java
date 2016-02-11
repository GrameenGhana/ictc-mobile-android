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
 * @date Sep 24, 2015 4:08:34 PM
 * description:
 */
public class PostHarvestUpdate extends Status implements GeneralInterface {
    
    Node underlyingNode ;
    
    
    public static String APPLICATIONRATEOFSTORAGECHEMICAL="applicationrateofstoragechemical";
    public static String COMPLETIONOFPRODUCEMARKETING="completionofproducemarketing";
    public static String COMPLETIONOFTHRESHING="completionofthreshing";
    public static String DATEOFCOMPLETINGDRYING="dateofcompletingdrying";
    public static String DATETOCOMPLETEDRYING="datetocompletedrying";
    public static String DRYINGOFCOBSCHUNKSPANICLES="dryingofcobschunkspanicles";
    public static String FIRSTSALEDATE="firstsaledate";
    public static String METHODOFDRYINGCOBSPANICLESCHIPSCHUNKS="methodofdryingcobspanicleschipschunks";
    public static String METHODOFDRYINGGRAIN="methodofdryinggrain";
    public static String MOSTPRODUCESALEDATE="mostproducesaledate";
    public static String OTHERAPPLICATIONRATEOFSTORAGECHEMIC="otherapplicationrateofstoragechemic";
    public static String OTHERMETHODFORDRYING="othermethodfordrying";
    public static String OTHERMETHODOFDRYINGGRAIN="othermethodofdryinggrain";
    public static String OTHERSALECONTACT="othersalecontact";
    public static String OTHERSTORAGECHEMICAL="otherstoragechemical";
    public static String OWNERSHIPCONDITIONSFORSTORAGE="ownershipconditionsforstorage";
    public static String POSTHARVESTLOSSES="postharvestlosses";
    public static String PRICEATFIRSTSALEDATE="priceatfirstsaledate";
    public static String PRICEATMOSTSALEDATE="priceatmostsaledate";
    public static String PROPORTIONFORMARKET="proportionformarket";
    public static String THRESHING="threshing";
    public static String TYPEOFBAGUSEDINBULKINGPRODUCE="typeofbagusedinbulkingproduce";
    public static String TYPEOFSTORAGECHEMICAL="typeofstoragechemical";
    public static String TYPEOFSTORAGESTRUCTURE="typeofstoragestructure";
    public static String WINNOWING="winnowing";
    public static String DATE_OF_COMPLETING_DEHUSKING="date_of_completing_dehusking";
    public static String DATECOMPLETIONWINNOWING="datecompletionwinnowing";
    public static String METHOD_OF_DEHUSKING_UPDATE="method_of_dehusking_update";
    public static String NOSALEOCCASIONS="nosaleoccasions";
    public static String OTHER_METHOD_DEHUSKING="other_method_dehusking";
    public static String PROPORTION_STORED_WITH_CHEMICAL_UPDATE="proportion_stored_with_chemical_update";
    public static String REFERENCE_SEASON_UPDATE="reference_season_update";
    public static String REFERENCE_YEAR_UPDATE="reference_year_update";
    public static String TOTAL_REVENUE_UPDATE="total_revenue_update";
    public static String TYPE_OF_CROP="type_of_crop";
    public static String UNIT_OF_CHEMICAL_APPLICATION_UPDATE="unit_of_chemical_application_update";
    
    
    
public void setUnit_of_chemical_application_update(String unit_of_chemical_application_update) {
underlyingNode.setProperty(UNIT_OF_CHEMICAL_APPLICATION_UPDATE,unit_of_chemical_application_update);
}

public String getUnit_of_chemical_application_update(){
          try {
          return (String) underlyingNode.getProperty(UNIT_OF_CHEMICAL_APPLICATION_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setType_of_crop(String type_of_crop) {
underlyingNode.setProperty(TYPE_OF_CROP,type_of_crop);
}

public String getType_of_crop(){
          try {
          return (String) underlyingNode.getProperty(TYPE_OF_CROP);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setTotal_revenue_update(String total_revenue_update) {
underlyingNode.setProperty(TOTAL_REVENUE_UPDATE,total_revenue_update);
}

public String getTotal_revenue_update(){
          try {
          return (String) underlyingNode.getProperty(TOTAL_REVENUE_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setReference_year_update(String reference_year_update) {
underlyingNode.setProperty(REFERENCE_YEAR_UPDATE,reference_year_update);
}

public String getReference_year_update(){
          try {
          return (String) underlyingNode.getProperty(REFERENCE_YEAR_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setReference_season_update(String reference_season_update) {
underlyingNode.setProperty(REFERENCE_SEASON_UPDATE,reference_season_update);
}

public String getReference_season_update(){
          try {
          return (String) underlyingNode.getProperty(REFERENCE_SEASON_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setProportion_stored_with_chemical_update(String proportion_stored_with_chemical_update) {
underlyingNode.setProperty(PROPORTION_STORED_WITH_CHEMICAL_UPDATE,proportion_stored_with_chemical_update);
}

public String getProportion_stored_with_chemical_update(){
          try {
          return (String) underlyingNode.getProperty(PROPORTION_STORED_WITH_CHEMICAL_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setOther_method_dehusking(String other_method_dehusking) {
underlyingNode.setProperty(OTHER_METHOD_DEHUSKING,other_method_dehusking);
}

public String getOther_method_dehusking(){
          try {
          return (String) underlyingNode.getProperty(OTHER_METHOD_DEHUSKING);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setNosaleoccasions(String nosaleoccasions) {
underlyingNode.setProperty(NOSALEOCCASIONS,nosaleoccasions);
}

public String getNosaleoccasions(){
          try {
          return (String) underlyingNode.getProperty(NOSALEOCCASIONS);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setMethod_of_dehusking_update(String method_of_dehusking_update) {
underlyingNode.setProperty(METHOD_OF_DEHUSKING_UPDATE,method_of_dehusking_update);
}

public String getMethod_of_dehusking_update(){
          try {
          return (String) underlyingNode.getProperty(METHOD_OF_DEHUSKING_UPDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setDatecompletionwinnowing(String datecompletionwinnowing) {
underlyingNode.setProperty(DATECOMPLETIONWINNOWING,datecompletionwinnowing);
}

public String getDatecompletionwinnowing(){
          try {
          return (String) underlyingNode.getProperty(DATECOMPLETIONWINNOWING);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setDate_of_completing_dehusking(String date_of_completing_dehusking) {
underlyingNode.setProperty(DATE_OF_COMPLETING_DEHUSKING,date_of_completing_dehusking);
}

public String getDate_of_completing_dehusking(){
          try {
          return (String) underlyingNode.getProperty(DATE_OF_COMPLETING_DEHUSKING);

        } catch (Exception e) {
        }
        return null;
    }

    

    public PostHarvestUpdate(Node underlyingNode) {
        super(underlyingNode);
         this.underlyingNode = underlyingNode;
    }
    
   
    
    
    public void setWinnowing(String winnowing) {
        underlyingNode.setProperty(WINNOWING, winnowing);
    }

    public String getWinnowing() {
        try {
            return (String) underlyingNode.getProperty(WINNOWING);

        } catch (Exception e) {
        }
        return null;
    }

public void setTypeofstoragestructure(String typeofstoragestructure) {
underlyingNode.setProperty(TYPEOFSTORAGESTRUCTURE,typeofstoragestructure);
}

public String getTypeofstoragestructure(){
          try {
          return (String) underlyingNode.getProperty(TYPEOFSTORAGESTRUCTURE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setTypeofstoragechemical(String typeofstoragechemical) {
underlyingNode.setProperty(TYPEOFSTORAGECHEMICAL,typeofstoragechemical);
}

public String getTypeofstoragechemical(){
          try {
          return (String) underlyingNode.getProperty(TYPEOFSTORAGECHEMICAL);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setTypeofbagusedinbulkingproduce(String typeofbagusedinbulkingproduce) {
underlyingNode.setProperty(TYPEOFBAGUSEDINBULKINGPRODUCE,typeofbagusedinbulkingproduce);
}

public String getTypeofbagusedinbulkingproduce(){
          try {
          return (String) underlyingNode.getProperty(TYPEOFBAGUSEDINBULKINGPRODUCE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setThreshing(String threshing) {
underlyingNode.setProperty(THRESHING,threshing);
}

public String getThreshing(){
          try {
          return (String) underlyingNode.getProperty(THRESHING);

        } catch (Exception e) {
        }
        return null;
    }
    
    
    
public void setProportionformarket(String proportionformarket) {
underlyingNode.setProperty(PROPORTIONFORMARKET,proportionformarket);
}

public String getProportionformarket(){
          try {
          return (String) underlyingNode.getProperty(PROPORTIONFORMARKET);

        } catch (Exception e) {
        }
        return null;
    }

    
    
    
public void setPriceatmostsaledate(String priceatmostsaledate) {
underlyingNode.setProperty(PRICEATMOSTSALEDATE,priceatmostsaledate);
}

public String getPriceatmostsaledate(){
          try {
          return (String) underlyingNode.getProperty(PRICEATMOSTSALEDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setPriceatfirstsaledate(String priceatfirstsaledate) {
underlyingNode.setProperty(PRICEATFIRSTSALEDATE,priceatfirstsaledate);
}

public String getPriceatfirstsaledate(){
          try {
          return (String) underlyingNode.getProperty(PRICEATFIRSTSALEDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setPostharvestlosses(String postharvestlosses) {
underlyingNode.setProperty(POSTHARVESTLOSSES,postharvestlosses);
}

public String getPostharvestlosses(){
          try {
          return (String) underlyingNode.getProperty(POSTHARVESTLOSSES);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setOwnershipconditionsforstorage(String ownershipconditionsforstorage) {
underlyingNode.setProperty(OWNERSHIPCONDITIONSFORSTORAGE,ownershipconditionsforstorage);
}

public String getOwnershipconditionsforstorage(){
          try {
          return (String) underlyingNode.getProperty(OWNERSHIPCONDITIONSFORSTORAGE);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setOtherstoragechemical(String otherstoragechemical) {
underlyingNode.setProperty(OTHERSTORAGECHEMICAL,otherstoragechemical);
}

public String getOtherstoragechemical(){
          try {
          return (String) underlyingNode.getProperty(OTHERSTORAGECHEMICAL);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setOthersalecontact(String othersalecontact) {
underlyingNode.setProperty(OTHERSALECONTACT,othersalecontact);
}

public String getOthersalecontact(){
          try {
          return (String) underlyingNode.getProperty(OTHERSALECONTACT);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setOthermethodofdryinggrain(String othermethodofdryinggrain) {
underlyingNode.setProperty(OTHERMETHODOFDRYINGGRAIN,othermethodofdryinggrain);
}

public String getOthermethodofdryinggrain(){
          try {
          return (String) underlyingNode.getProperty(OTHERMETHODOFDRYINGGRAIN);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setOthermethodfordrying(String othermethodfordrying) {
underlyingNode.setProperty(OTHERMETHODFORDRYING,othermethodfordrying);
}

public String getOthermethodfordrying(){
          try {
          return (String) underlyingNode.getProperty(OTHERMETHODFORDRYING);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setOtherapplicationrateofstoragechemic(String otherapplicationrateofstoragechemic) {
underlyingNode.setProperty(OTHERAPPLICATIONRATEOFSTORAGECHEMIC,otherapplicationrateofstoragechemic);
}

public String getOtherapplicationrateofstoragechemic(){
          try {
          return (String) underlyingNode.getProperty(OTHERAPPLICATIONRATEOFSTORAGECHEMIC);

        } catch (Exception e) {
        }
        return null;
    }
public void setMostproducesaledate(String mostproducesaledate) {
underlyingNode.setProperty(MOSTPRODUCESALEDATE,mostproducesaledate);
}

public String getMostproducesaledate(){
          try {
          return (String) underlyingNode.getProperty(MOSTPRODUCESALEDATE);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setMethodofdryinggrain(String methodofdryinggrain) {
underlyingNode.setProperty(METHODOFDRYINGGRAIN,methodofdryinggrain);
}

public String getMethodofdryinggrain(){
          try {
          return (String) underlyingNode.getProperty(METHODOFDRYINGGRAIN);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setMethodofdryingcobspanicleschipschunks(String methodofdryingcobspanicleschipschunks) {
underlyingNode.setProperty(METHODOFDRYINGCOBSPANICLESCHIPSCHUNKS,methodofdryingcobspanicleschipschunks);
}

public String getMethodofdryingcobspanicleschipschunks(){
          try {
          return (String) underlyingNode.getProperty(METHODOFDRYINGCOBSPANICLESCHIPSCHUNKS);

        } catch (Exception e) {
        }
        return null;
    }
    
    
    public static String MAINPOINTOFSALEORCONTACT="mainpointofsaleorcontact";
public void setMainpointofsaleorcontact(String mainpointofsaleorcontact) {
underlyingNode.setProperty(MAINPOINTOFSALEORCONTACT,mainpointofsaleorcontact);
}

public String getMainpointofsaleorcontact(){
          try {
          return (String) underlyingNode.getProperty(MAINPOINTOFSALEORCONTACT);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setFirstsaledate(String firstsaledate) {
underlyingNode.setProperty(FIRSTSALEDATE,firstsaledate);
}

public String getFirstsaledate(){
          try {
          return (String) underlyingNode.getProperty(FIRSTSALEDATE);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setDryingofcobschunkspanicles(String dryingofcobschunkspanicles) {
underlyingNode.setProperty(DRYINGOFCOBSCHUNKSPANICLES,dryingofcobschunkspanicles);
}

public String getDryingofcobschunkspanicles(){
          try {
          return (String) underlyingNode.getProperty(DRYINGOFCOBSCHUNKSPANICLES);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setDatetocompletedrying(String datetocompletedrying) {
underlyingNode.setProperty(DATETOCOMPLETEDRYING,datetocompletedrying);
}

public String getDatetocompletedrying(){
          try {
          return (String) underlyingNode.getProperty(DATETOCOMPLETEDRYING);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setDateofcompletingdrying(String dateofcompletingdrying) {
underlyingNode.setProperty(DATEOFCOMPLETINGDRYING,dateofcompletingdrying);
}

public String getDateofcompletingdrying(){
          try {
          return (String) underlyingNode.getProperty(DATEOFCOMPLETINGDRYING);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setCompletionofthreshing(String completionofthreshing) {
underlyingNode.setProperty(COMPLETIONOFTHRESHING,completionofthreshing);
}

public String getCompletionofthreshing(){
          try {
          return (String) underlyingNode.getProperty(COMPLETIONOFTHRESHING);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setCompletionofproducemarketing(String completionofproducemarketing) {
underlyingNode.setProperty(COMPLETIONOFPRODUCEMARKETING,completionofproducemarketing);
}

public String getCompletionofproducemarketing(){
          try {
          return (String) underlyingNode.getProperty(COMPLETIONOFPRODUCEMARKETING);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setApplicationrateofstoragechemical(String applicationrateofstoragechemical) {
underlyingNode.setProperty(APPLICATIONRATEOFSTORAGECHEMICAL,applicationrateofstoragechemical);
}

public String getApplicationrateofstoragechemical(){
          try {
          return (String) underlyingNode.getProperty(APPLICATIONRATEOFSTORAGECHEMICAL);

        } catch (Exception e) {
        }
        return null;
    }


  
    
    
    

}

