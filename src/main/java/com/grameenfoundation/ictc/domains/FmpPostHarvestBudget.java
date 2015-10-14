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
 * @date Oct 14, 2015 4:10:47 PM
 * description:
 */
public class FmpPostHarvestBudget extends Status implements GeneralInterface {

    Node underlyingNode = null;
    
    public FmpPostHarvestBudget(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }
    
    public static String BASALFERTILIZERAPPLICATIONLABOR="basalfertilizerapplicationlabor";
    public static String BASALFERTILIZERAPPLICATIONLABORCOST="basalfertilizerapplicationlaborcost";
    public static String BASALFERTLABORPERIOD="basalfertlaborperiod";
    public static String FAMILYLABORBASALFERTILIZERAPPLICATION="familylaborbasalfertilizerapplication";
    public static String HARROWINGCOST="harrowingcost";
    public static String HERBICIDEAPPLICATIONCOST="herbicideapplicationcost";
    public static String HERBICIDEAPPLICATIONLABORPERIOD="herbicideapplicationlaborperiod";
    public static String HOEPLOUGHINGLABORPERIOD="hoeploughinglaborperiod";
    public static String HOEPLOUGHINGLABOUR="hoeploughinglabour";
    public static String HOEPLOUGHINGLABOURFAMILY="hoeploughinglabourfamily";
    public static String ABORFORPLANTINGFAMILY="aborforplantingfamily";
    public static String LABORFORPLANTINGNUMBER="laborforplantingnumber";
    public static String LANDRENT="landrent";
    public static String REFILLINGLABORFAMILY="refillinglaborfamily";
    public static String REFILLINGLABORPERIOD="refillinglaborperiod";
    public static String REFILLINGLABOURCOST="refillinglabourcost";
    public static String SEEDBEDLABORCOST="seedbedlaborcost";
    public static String SEEDBEDLABORFAMILY="seedbedlaborfamily";
    public static String SEEDBEDPREPARATIONPERIOD="seedbedpreparationperiod";
    public static String SEEDPLANTINGMATERIALCOST="seedplantingmaterialcost";
    public static String UNITCOSTHOEPLOUGHING="unitcosthoeploughing";
    
    
public void setUnitcosthoeploughing(String unitcosthoeploughing) {
underlyingNode.setProperty(UNITCOSTHOEPLOUGHING,unitcosthoeploughing);
}

public String getUnitcosthoeploughing(){
          try {
          return (String) underlyingNode.getProperty(UNITCOSTHOEPLOUGHING);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setSeedplantingmaterialcost(String seedplantingmaterialcost) {
underlyingNode.setProperty(SEEDPLANTINGMATERIALCOST,seedplantingmaterialcost);
}

public String getSeedplantingmaterialcost(){
          try {
          return (String) underlyingNode.getProperty(SEEDPLANTINGMATERIALCOST);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setSeedbedpreparationperiod(String seedbedpreparationperiod) {
underlyingNode.setProperty(SEEDBEDPREPARATIONPERIOD,seedbedpreparationperiod);
}

public String getSeedbedpreparationperiod(){
          try {
          return (String) underlyingNode.getProperty(SEEDBEDPREPARATIONPERIOD);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setSeedbedlaborfamily(String seedbedlaborfamily) {
underlyingNode.setProperty(SEEDBEDLABORFAMILY,seedbedlaborfamily);
}

public String getSeedbedlaborfamily(){
          try {
          return (String) underlyingNode.getProperty(SEEDBEDLABORFAMILY);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setSeedbedlaborcost(String seedbedlaborcost) {
underlyingNode.setProperty(SEEDBEDLABORCOST,seedbedlaborcost);
}

public String getSeedbedlaborcost(){
          try {
          return (String) underlyingNode.getProperty(SEEDBEDLABORCOST);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setRefillinglabourcost(String refillinglabourcost) {
underlyingNode.setProperty(REFILLINGLABOURCOST,refillinglabourcost);
}

public String getRefillinglabourcost(){
          try {
          return (String) underlyingNode.getProperty(REFILLINGLABOURCOST);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setRefillinglaborperiod(String refillinglaborperiod) {
underlyingNode.setProperty(REFILLINGLABORPERIOD,refillinglaborperiod);
}

public String getRefillinglaborperiod(){
          try {
          return (String) underlyingNode.getProperty(REFILLINGLABORPERIOD);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setRefillinglaborfamily(String refillinglaborfamily) {
underlyingNode.setProperty(REFILLINGLABORFAMILY,refillinglaborfamily);
}

public String getRefillinglaborfamily(){
          try {
          return (String) underlyingNode.getProperty(REFILLINGLABORFAMILY);

        } catch (Exception e) {
        }
        return null;
    }
public void setLandrent(String landrent) {
underlyingNode.setProperty(LANDRENT,landrent);
}

public String getLandrent(){
          try {
          return (String) underlyingNode.getProperty(LANDRENT);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setLaborforplantingnumber(String laborforplantingnumber) {
underlyingNode.setProperty(LABORFORPLANTINGNUMBER,laborforplantingnumber);
}

public String getLaborforplantingnumber(){
          try {
          return (String) underlyingNode.getProperty(LABORFORPLANTINGNUMBER);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setAborforplantingfamily(String aborforplantingfamily) {
underlyingNode.setProperty(ABORFORPLANTINGFAMILY,aborforplantingfamily);
}

public String getAborforplantingfamily(){
          try {
          return (String) underlyingNode.getProperty(ABORFORPLANTINGFAMILY);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setHoeploughinglabourfamily(String hoeploughinglabourfamily) {
underlyingNode.setProperty(HOEPLOUGHINGLABOURFAMILY,hoeploughinglabourfamily);
}

public String getHoeploughinglabourfamily(){
          try {
          return (String) underlyingNode.getProperty(HOEPLOUGHINGLABOURFAMILY);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setHoeploughinglabour(String hoeploughinglabour) {
underlyingNode.setProperty(HOEPLOUGHINGLABOUR,hoeploughinglabour);
}

public String getHoeploughinglabour(){
          try {
          return (String) underlyingNode.getProperty(HOEPLOUGHINGLABOUR);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setHoeploughinglaborperiod(String hoeploughinglaborperiod) {
underlyingNode.setProperty(HOEPLOUGHINGLABORPERIOD,hoeploughinglaborperiod);
}

public String getHoeploughinglaborperiod(){
          try {
          return (String) underlyingNode.getProperty(HOEPLOUGHINGLABORPERIOD);

        } catch (Exception e) {
        }
        return null;
    }

    
    
    
public void setHerbicideapplicationlaborperiod(String herbicideapplicationlaborperiod) {
underlyingNode.setProperty(HERBICIDEAPPLICATIONLABORPERIOD,herbicideapplicationlaborperiod);
}

public String getHerbicideapplicationlaborperiod(){
          try {
          return (String) underlyingNode.getProperty(HERBICIDEAPPLICATIONLABORPERIOD);

        } catch (Exception e) {
        }
        return null;
    }

    
public void setHerbicideapplicationcost(String herbicideapplicationcost) {
underlyingNode.setProperty(HERBICIDEAPPLICATIONCOST,herbicideapplicationcost);
}

public String getHerbicideapplicationcost(){
          try {
          return (String) underlyingNode.getProperty(HERBICIDEAPPLICATIONCOST);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setHarrowingcost(String harrowingcost) {
underlyingNode.setProperty(HARROWINGCOST,harrowingcost);
}

public String getHarrowingcost(){
          try {
          return (String) underlyingNode.getProperty(HARROWINGCOST);

        } catch (Exception e) {
        }
        return null;
    }

    
    
public void setFamilylaborbasalfertilizerapplication(String familylaborbasalfertilizerapplication) {
underlyingNode.setProperty(FAMILYLABORBASALFERTILIZERAPPLICATION,familylaborbasalfertilizerapplication);
}

public String getFamilylaborbasalfertilizerapplication(){
          try {
          return (String) underlyingNode.getProperty(FAMILYLABORBASALFERTILIZERAPPLICATION);

        } catch (Exception e) {
        }
        return null;
    }
    
    
public void setBasalfertlaborperiod(String basalfertlaborperiod) {
underlyingNode.setProperty(BASALFERTLABORPERIOD,basalfertlaborperiod);
}

public String getBasalfertlaborperiod(){
          try {
          return (String) underlyingNode.getProperty(BASALFERTLABORPERIOD);

        } catch (Exception e) {
        }
        return null;
    }
    
public void setBasalfertilizerapplicationlaborcost(String basalfertilizerapplicationlaborcost) {
underlyingNode.setProperty(BASALFERTILIZERAPPLICATIONLABORCOST,basalfertilizerapplicationlaborcost);
}

public String getBasalfertilizerapplicationlaborcost(){
          try {
          return (String) underlyingNode.getProperty(BASALFERTILIZERAPPLICATIONLABORCOST);

        } catch (Exception e) {
        }
        return null;
    }
public void setBasalfertilizerapplicationlabor(String basalfertilizerapplicationlabor) {
underlyingNode.setProperty(BASALFERTILIZERAPPLICATIONLABOR,basalfertilizerapplicationlabor);
}

public String getBasalfertilizerapplicationlabor(){
          try {
          return (String) underlyingNode.getProperty(BASALFERTILIZERAPPLICATIONLABOR);

        } catch (Exception e) {
        }
        return null;
    }
    

}
