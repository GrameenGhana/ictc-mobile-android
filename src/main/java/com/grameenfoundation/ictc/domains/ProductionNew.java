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
 * @date Sep 23, 2015 2:20:17 PM
 * description:
 */
public class ProductionNew extends Status implements GeneralInterface {
  
    Node underlyingNode;
    
public static String ACRESOFLAND="acresofland";
public static String APPLICATIONMONTHOFHERBICIDEDATE="applicationmonthofherbicidedate";
public static String APPLICATIONOFBASALFERTILIZER="applicationofbasalfertilizer";
public static String APPLICATIONOFBASALFERTILIZERDATE="applicationofbasalfertilizerdate";
public static String APPLICATIONOFTOPDRESSFERTILIZER="applicationoftopdressfertilizer";
public static String DATEFIFTHPOSTGEMWEEDCONTROL="datefifthpostgemweedcontrol";
public static String DATEFIRSTMANUALWEEDCONTROL="datefirstmanualweedcontrol";
public static String DATEFOURTHPOSTGEMWEEDCONTROL="datefourthpostgemweedcontrol";
public static String DATEOFSECONDMANUALWEEDCONTROL="dateofsecondmanualweedcontrol";
public static String DATETHIRDMANUALWEEDCONTROL="datethirdmanualweedcontrol";
public static String LANDCLEARINGDATE="landclearingdate";
public static String METHODOFBASALFERTILIZERAPPLICATION="methodofbasalfertilizerapplication";
public static String METHODOFBASALFERTILIZERAPPLICATIONOTHER="methodofbasalfertilizerapplicationother";
public static String METHODOFLANDCLEARING="methodoflandclearing";
public static String METHODOFLANDPREPARATION="methodoflandpreparation";
public static String METHODTOPDRESSFERTILIZERAPP="methodtopdressfertilizerapp";
public static String NAMEOFCROPVARIETY="nameofcropvariety";
public static String NAMEOFCROPVARIETYCASSAVA="nameofcropvarietycassava";
public static String NAMEOFCROPVARIETYRICE="nameofcropvarietyrice";
public static String NAMEOFCROPVARIETYYAM="nameofcropvarietyyam";
public static String NAMEOFVARIETYNOTINLIST="nameofvarietynotinlist";
public static String OTHERFERTILIZER="otherfertilizer";
public static String PLANTINGDATE="plantingdate";
public static String PLANTINGDISTANCEBETWEENPLANTSMAIZE="plantingdistancebetweenplantsmaize";
public static String PLANTINGDISTANCEBETWEENPLANTSMAIZEYC="plantingdistancebetweenplantsmaizeyc";
public static String PLANTINGDISTANCEBETWEENPLANTSRICE="plantingdistancebetweenplantsrice";
public static String PLANTINGDISTANCEBETWEENROWSMAIZE="plantingdistancebetweenrowsmaize";
public static String PLANTINGDISTANCEBETWEENROWSRICE="plantingdistancebetweenrowsrice";
public static String PLANTINGDISTANCEBETWEENROWSYC="plantingdistancebetweenrowsyc";
public static String PLOUGHINGDATE="ploughingdate";
public static String POSTPLANTHERBICIDEUSE="postplantherbicideuse";
public static String QUANTITYOFBASALFERTILIZERPURCHASEDAPPLY="quantityofbasalfertilizerpurchasedapply";
public static String QUANTITYOFTOPDRESSERFERTILIZERPURCHASED="quantityoftopdresserfertilizerpurchased";
public static String QUANTITYPOSTPLANTHERBICIDE="quantitypostplantherbicide";
public static String REFILLINGGAPSOCCURENCE="refillinggapsoccurence";
public static String REFILLINGGAPSPROPORTION="refillinggapsproportion";
public static String SEEDBEDFORMTYPE="seedbedformtype";
public static String SEEDBEDPREPARATIONDATE="seedbedpreparationdate";
public static String SOURCEOFSEEDORPLANTINGMATERIAL="sourceofseedorplantingmaterial";
public static String SOURCEOFSEEDORPLANTINGMATERIALOTHER="sourceofseedorplantingmaterialother";
public static String TARGETYIELDPERACRE="targetyieldperacre";
public static String TIMEOFAPPLICATIONTOPDRESSING="timeofapplicationtopdressing";
public static String TIMEOFHARVEST="timeofharvest";
public static String TOPDRESSFERTILIZEROTHER="topdressfertilizerother";
public static String TYPEOFBASALFERTILIZER="typeofbasalfertilizer";
public static String TYPEOFFERTILIZERTOPDRESSING="typeoffertilizertopdressing";
public static String TYPEOFHERBICIDEPOSTPLANTWEED="typeofherbicidepostplantweed";



public void setTypeofherbicidepostplantweed(String typeofherbicidepostplantweed) {
underlyingNode.setProperty(TYPEOFHERBICIDEPOSTPLANTWEED,typeofherbicidepostplantweed);
}

public String getTypeofherbicidepostplantweed(){
          try {
          return (String) underlyingNode.getProperty(TYPEOFHERBICIDEPOSTPLANTWEED);

        } catch (Exception e) {
        }
        return null;
    }


public void setTypeoffertilizertopdressing(String typeoffertilizertopdressing) {
underlyingNode.setProperty(TYPEOFFERTILIZERTOPDRESSING,typeoffertilizertopdressing);
}

public String getTypeoffertilizertopdressing(){
          try {
          return (String) underlyingNode.getProperty(TYPEOFFERTILIZERTOPDRESSING);

        } catch (Exception e) {
        }
        return null;
    }



public void setTypeofbasalfertilizer(String typeofbasalfertilizer) {
underlyingNode.setProperty(TYPEOFBASALFERTILIZER,typeofbasalfertilizer);
}

public String getTypeofbasalfertilizer(){
          try {
          return (String) underlyingNode.getProperty(TYPEOFBASALFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }


public void setTopdressfertilizerother(String topdressfertilizerother) {
underlyingNode.setProperty(TOPDRESSFERTILIZEROTHER,topdressfertilizerother);
}

public String getTopdressfertilizerother(){
          try {
          return (String) underlyingNode.getProperty(TOPDRESSFERTILIZEROTHER);

        } catch (Exception e) {
        }
        return null;
    }



public void setTimeofharvest(String timeofharvest) {
underlyingNode.setProperty(TIMEOFHARVEST,timeofharvest);
}

public String getTimeofharvest(){
          try {
          return (String) underlyingNode.getProperty(TIMEOFHARVEST);

        } catch (Exception e) {
        }
        return null;
    }

public void setTimeofapplicationtopdressing(String timeofapplicationtopdressing) {
underlyingNode.setProperty(TIMEOFAPPLICATIONTOPDRESSING,timeofapplicationtopdressing);
}

public String getTimeofapplicationtopdressing(){
          try {
          return (String) underlyingNode.getProperty(TIMEOFAPPLICATIONTOPDRESSING);

        } catch (Exception e) {
        }
        return null;
    }


public void setTargetyieldperacre(String targetyieldperacre) {
underlyingNode.setProperty(TARGETYIELDPERACRE,targetyieldperacre);
}

public String getTargetyieldperacre(){
          try {
          return (String) underlyingNode.getProperty(TARGETYIELDPERACRE);

        } catch (Exception e) {
        }
        return null;
    }


public void setSourceofseedorplantingmaterialother(String sourceofseedorplantingmaterialother) {
underlyingNode.setProperty(SOURCEOFSEEDORPLANTINGMATERIALOTHER,sourceofseedorplantingmaterialother);
}

public String getSourceofseedorplantingmaterialother(){
          try {
          return (String) underlyingNode.getProperty(SOURCEOFSEEDORPLANTINGMATERIALOTHER);

        } catch (Exception e) {
        }
        return null;
    }



public void setSourceofseedorplantingmaterial(String sourceofseedorplantingmaterial) {
underlyingNode.setProperty(SOURCEOFSEEDORPLANTINGMATERIAL,sourceofseedorplantingmaterial);
}

public String getSourceofseedorplantingmaterial(){
          try {
          return (String) underlyingNode.getProperty(SOURCEOFSEEDORPLANTINGMATERIAL);

        } catch (Exception e) {
        }
        return null;
    }



public void setSeedbedpreparationdate(String seedbedpreparationdate) {
underlyingNode.setProperty(SEEDBEDPREPARATIONDATE,seedbedpreparationdate);
}

public String getSeedbedpreparationdate(){
          try {
          return (String) underlyingNode.getProperty(SEEDBEDPREPARATIONDATE);

        } catch (Exception e) {
        }
        return null;
    }


public void setSeedbedformtype(String seedbedformtype) {
underlyingNode.setProperty(SEEDBEDFORMTYPE,seedbedformtype);
}

public String getSeedbedformtype(){
          try {
          return (String) underlyingNode.getProperty(SEEDBEDFORMTYPE);

        } catch (Exception e) {
        }
        return null;
    }



public void setRefillinggapsproportion(String refillinggapsproportion) {
underlyingNode.setProperty(REFILLINGGAPSPROPORTION,refillinggapsproportion);
}

public String getRefillinggapsproportion(){
          try {
          return (String) underlyingNode.getProperty(REFILLINGGAPSPROPORTION);

        } catch (Exception e) {
        }
        return null;
    }


public void setRefillinggapsoccurence(String refillinggapsoccurence) {
underlyingNode.setProperty(REFILLINGGAPSOCCURENCE,refillinggapsoccurence);
}

public String getRefillinggapsoccurence(){
          try {
          return (String) underlyingNode.getProperty(REFILLINGGAPSOCCURENCE);

        } catch (Exception e) {
        }
        return null;
    }


public void setQuantitypostplantherbicide(String quantitypostplantherbicide) {
underlyingNode.setProperty(QUANTITYPOSTPLANTHERBICIDE,quantitypostplantherbicide);
}

public String getQuantitypostplantherbicide(){
          try {
          return (String) underlyingNode.getProperty(QUANTITYPOSTPLANTHERBICIDE);

        } catch (Exception e) {
        }
        return null;
    }



public void setQuantityoftopdresserfertilizerpurchased(String quantityoftopdresserfertilizerpurchased) {
underlyingNode.setProperty(QUANTITYOFTOPDRESSERFERTILIZERPURCHASED,quantityoftopdresserfertilizerpurchased);
}

public String getQuantityoftopdresserfertilizerpurchased(){
          try {
          return (String) underlyingNode.getProperty(QUANTITYOFTOPDRESSERFERTILIZERPURCHASED);

        } catch (Exception e) {
        }
        return null;
    }


public void setQuantityofbasalfertilizerpurchasedapply(String quantityofbasalfertilizerpurchasedapply) {
underlyingNode.setProperty(QUANTITYOFBASALFERTILIZERPURCHASEDAPPLY,quantityofbasalfertilizerpurchasedapply);
}

public String getQuantityofbasalfertilizerpurchasedapply(){
          try {
          return (String) underlyingNode.getProperty(QUANTITYOFBASALFERTILIZERPURCHASEDAPPLY);

        } catch (Exception e) {
        }
        return null;
    }


public void setPostplantherbicideuse(String postplantherbicideuse) {
underlyingNode.setProperty(POSTPLANTHERBICIDEUSE,postplantherbicideuse);
}

public String getPostplantherbicideuse(){
          try {
          return (String) underlyingNode.getProperty(POSTPLANTHERBICIDEUSE);

        } catch (Exception e) {
        }
        return null;
    }



public void setPloughingdate(String ploughingdate) {
underlyingNode.setProperty(PLOUGHINGDATE,ploughingdate);
}

public String getPloughingdate(){
          try {
          return (String) underlyingNode.getProperty(PLOUGHINGDATE);

        } catch (Exception e) {
        }
        return null;
    }


public void setPlantingdistancebetweenrowsyc(String plantingdistancebetweenrowsyc) {
underlyingNode.setProperty(PLANTINGDISTANCEBETWEENROWSYC,plantingdistancebetweenrowsyc);
}

public String getPlantingdistancebetweenrowsyc(){
          try {
          return (String) underlyingNode.getProperty(PLANTINGDISTANCEBETWEENROWSYC);

        } catch (Exception e) {
        }
        return null;
    }


public void setPlantingdistancebetweenrowsrice(String plantingdistancebetweenrowsrice) {
underlyingNode.setProperty(PLANTINGDISTANCEBETWEENROWSRICE,plantingdistancebetweenrowsrice);
}

public String getPlantingdistancebetweenrowsrice(){
          try {
          return (String) underlyingNode.getProperty(PLANTINGDISTANCEBETWEENROWSRICE);

        } catch (Exception e) {
        }
        return null;
    }

public void setPlantingdistancebetweenrowsmaize(String plantingdistancebetweenrowsmaize) {
underlyingNode.setProperty(PLANTINGDISTANCEBETWEENROWSMAIZE,plantingdistancebetweenrowsmaize);
}

public String getPlantingdistancebetweenrowsmaize(){
          try {
          return (String) underlyingNode.getProperty(PLANTINGDISTANCEBETWEENROWSMAIZE);

        } catch (Exception e) {
        }
        return null;
    }


public void setPlantingdistancebetweenplantsrice(String plantingdistancebetweenplantsrice) {
underlyingNode.setProperty(PLANTINGDISTANCEBETWEENPLANTSRICE,plantingdistancebetweenplantsrice);
}

public String getPlantingdistancebetweenplantsrice(){
          try {
          return (String) underlyingNode.getProperty(PLANTINGDISTANCEBETWEENPLANTSRICE);

        } catch (Exception e) {
        }
        return null;
    }


public void setPlantingdistancebetweenplantsmaizeyc(String plantingdistancebetweenplantsmaizeyc) {
underlyingNode.setProperty(PLANTINGDISTANCEBETWEENPLANTSMAIZEYC,plantingdistancebetweenplantsmaizeyc);
}

public String getPlantingdistancebetweenplantsmaizeyc(){
          try {
          return (String) underlyingNode.getProperty(PLANTINGDISTANCEBETWEENPLANTSMAIZEYC);

        } catch (Exception e) {
        }
        return null;
    }



public void setPlantingdistancebetweenplantsmaize(String plantingdistancebetweenplantsmaize) {
underlyingNode.setProperty(PLANTINGDISTANCEBETWEENPLANTSMAIZE,plantingdistancebetweenplantsmaize);
}

public String getPlantingdistancebetweenplantsmaize(){
          try {
          return (String) underlyingNode.getProperty(PLANTINGDISTANCEBETWEENPLANTSMAIZE);

        } catch (Exception e) {
        }
        return "";
    }


public void setPlantingdate(String plantingdate) {
underlyingNode.setProperty(PLANTINGDATE,plantingdate);
}

public String getPlantingdate(){
          try {
          return (String) underlyingNode.getProperty(PLANTINGDATE);

        } catch (Exception e) {
        }
        return "";
    }



public void setOtherfertilizer(String otherfertilizer) {
underlyingNode.setProperty(OTHERFERTILIZER,otherfertilizer);
}

public String getOtherfertilizer(){
          try {
          return (String) underlyingNode.getProperty(OTHERFERTILIZER);

        } catch (Exception e) {
        }
        return "";
    }



public void setNameofvarietynotinlist(String nameofvarietynotinlist) {
underlyingNode.setProperty(NAMEOFVARIETYNOTINLIST,nameofvarietynotinlist);
}

public String getNameofvarietynotinlist(){
          try {
          return (String) underlyingNode.getProperty(NAMEOFVARIETYNOTINLIST);

        } catch (Exception e) {
        }
        return "";
    }


public void setNameofcropvarietyyam(String nameofcropvarietyyam) {
underlyingNode.setProperty(NAMEOFCROPVARIETYYAM,nameofcropvarietyyam);
}

public String getNameofcropvarietyyam(){
          try {
          return (String) underlyingNode.getProperty(NAMEOFCROPVARIETYYAM);

        } catch (Exception e) {
        }
        return "";
    }



public void setNameofcropvarietyrice(String nameofcropvarietyrice) {
underlyingNode.setProperty(NAMEOFCROPVARIETYRICE,nameofcropvarietyrice);
}

public String getNameofcropvarietyrice(){
          try {
          return (String) underlyingNode.getProperty(NAMEOFCROPVARIETYRICE);

        } catch (Exception e) {
        }
        return "";
    }

public void setNameofcropvarietycassava(String nameofcropvarietycassava) {
underlyingNode.setProperty(NAMEOFCROPVARIETYCASSAVA,nameofcropvarietycassava);
}

public String getNameofcropvarietycassava(){
          try {
          return (String) underlyingNode.getProperty(NAMEOFCROPVARIETYCASSAVA);

        } catch (Exception e) {
        }
        return "";
    }



public void setNameofcropvariety(String nameofcropvariety) {
underlyingNode.setProperty(NAMEOFCROPVARIETY,nameofcropvariety);
}

public String getNameofcropvariety(){
          try {
          return (String) underlyingNode.getProperty(NAMEOFCROPVARIETY);

        } catch (Exception e) {
        }
        return "";
    }



public void setMethodtopdressfertilizerapp(String methodtopdressfertilizerapp) {
underlyingNode.setProperty(METHODTOPDRESSFERTILIZERAPP,methodtopdressfertilizerapp);
}

public String getMethodtopdressfertilizerapp(){
          try {
          return (String) underlyingNode.getProperty(METHODTOPDRESSFERTILIZERAPP);

        } catch (Exception e) {
        }
        return null;
    }



public void setMethodoflandpreparation(String methodoflandpreparation) {
underlyingNode.setProperty(METHODOFLANDPREPARATION,methodoflandpreparation);
}

public String getMethodoflandpreparation(){
          try {
          return (String) underlyingNode.getProperty(METHODOFLANDPREPARATION);

        } catch (Exception e) {
        }
        return null;
    }


public void setMethodoflandclearing(String methodoflandclearing) {
underlyingNode.setProperty(METHODOFLANDCLEARING,methodoflandclearing);
}

public String getMethodoflandclearing(){
          try {
          return (String) underlyingNode.getProperty(METHODOFLANDCLEARING);

        } catch (Exception e) {
        }
        return null;
    }


public void setMethodofbasalfertilizerapplicationother(String methodofbasalfertilizerapplicationother) {
underlyingNode.setProperty(METHODOFBASALFERTILIZERAPPLICATIONOTHER,methodofbasalfertilizerapplicationother);
}

public String getMethodofbasalfertilizerapplicationother(){
          try {
          return (String) underlyingNode.getProperty(METHODOFBASALFERTILIZERAPPLICATIONOTHER);

        } catch (Exception e) {
        }
        return null;
    }


public void setMethodofbasalfertilizerapplication(String methodofbasalfertilizerapplication) {
underlyingNode.setProperty(METHODOFBASALFERTILIZERAPPLICATION,methodofbasalfertilizerapplication);
}

public String getMethodofbasalfertilizerapplication(){
          try {
          return (String) underlyingNode.getProperty(METHODOFBASALFERTILIZERAPPLICATION);

        } catch (Exception e) {
        }
        return null;
    }


public void setLandclearingdate(String landclearingdate) {
underlyingNode.setProperty(LANDCLEARINGDATE,landclearingdate);
}

public String getLandclearingdate(){
          try {
          return (String) underlyingNode.getProperty(LANDCLEARINGDATE);

        } catch (Exception e) {
        }
        return null;
    }


public void setDatethirdmanualweedcontrol(String datethirdmanualweedcontrol) {
underlyingNode.setProperty(DATETHIRDMANUALWEEDCONTROL,datethirdmanualweedcontrol);
}

public String getDatethirdmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(DATETHIRDMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

public void setDateofsecondmanualweedcontrol(String dateofsecondmanualweedcontrol) {
underlyingNode.setProperty(DATEOFSECONDMANUALWEEDCONTROL,dateofsecondmanualweedcontrol);
}

public String getDateofsecondmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(DATEOFSECONDMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

public void setDatefourthpostgemweedcontrol(String datefourthpostgemweedcontrol) {
underlyingNode.setProperty(DATEFOURTHPOSTGEMWEEDCONTROL,datefourthpostgemweedcontrol);
}

public String getDatefourthpostgemweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(DATEFOURTHPOSTGEMWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }

public void setDatefirstmanualweedcontrol(String datefirstmanualweedcontrol) {
underlyingNode.setProperty(DATEFIRSTMANUALWEEDCONTROL,datefirstmanualweedcontrol);
}

public String getDatefirstmanualweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(DATEFIRSTMANUALWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }



public void setDatefifthpostgemweedcontrol(String datefifthpostgemweedcontrol) {
underlyingNode.setProperty(DATEFIFTHPOSTGEMWEEDCONTROL,datefifthpostgemweedcontrol);
}

public String getDatefifthpostgemweedcontrol(){
          try {
          return (String) underlyingNode.getProperty(DATEFIFTHPOSTGEMWEEDCONTROL);

        } catch (Exception e) {
        }
        return null;
    }


public void setApplicationoftopdressfertilizer(String applicationoftopdressfertilizer) {
underlyingNode.setProperty(APPLICATIONOFTOPDRESSFERTILIZER,applicationoftopdressfertilizer);
}

public String getApplicationoftopdressfertilizer(){
          try {
          return (String) underlyingNode.getProperty(APPLICATIONOFTOPDRESSFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }



public void setApplicationofbasalfertilizerdate(String applicationofbasalfertilizerdate) {
underlyingNode.setProperty(APPLICATIONOFBASALFERTILIZERDATE,applicationofbasalfertilizerdate);
}

public String getApplicationofbasalfertilizerdate(){
          try {
          return (String) underlyingNode.getProperty(APPLICATIONOFBASALFERTILIZERDATE);

        } catch (Exception e) {
        }
        return null;
    }


public void setApplicationofbasalfertilizer(String applicationofbasalfertilizer) {
underlyingNode.setProperty(APPLICATIONOFBASALFERTILIZER,applicationofbasalfertilizer);
}

public String getApplicationofbasalfertilizer(){
          try {
          return (String) underlyingNode.getProperty(APPLICATIONOFBASALFERTILIZER);

        } catch (Exception e) {
        }
        return null;
    }




public void setApplicationmonthofherbicidedate(String applicationmonthofherbicidedate) {
underlyingNode.setProperty(APPLICATIONMONTHOFHERBICIDEDATE,applicationmonthofherbicidedate);
}

public String getApplicationmonthofherbicidedate(){
          try {
          return (String) underlyingNode.getProperty(APPLICATIONMONTHOFHERBICIDEDATE);

        } catch (Exception e) {
        }
        return null;
    }

public void setAcresofland(String acresofland) {
underlyingNode.setProperty(ACRESOFLAND,acresofland);
}

public String getAcresofland(){
          try {
          return (String) underlyingNode.getProperty(ACRESOFLAND);

        } catch (Exception e) {
        }
        return null;
    }


    public ProductionNew(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }

     public void setUpdate(Node production) {
        underlyingNode.createRelationshipTo(production, ICTCRelationshipTypes.UPDATE);
    }

    public ProductionUpdate getUpdate() {
        return new ProductionUpdate(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.UPDATE));
    }

}

