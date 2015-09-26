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

