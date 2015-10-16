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
 * @date Jul 16, 2015 12:08:21 PM
 * description:
 */
public class Biodata extends Status implements GeneralInterface {
    
    
    public static String FIRST_NAME = "firstname";
    public static String LAST_NAME = "lastname";
    public static String NICKNAME ="nickname";
    public static String COMMUNITY="community";
    public static String VILLAGE ="village";
    public static String DISTRICT ="district";
    public static String REGION ="region";
    public static String AGE = "age";
    public static String GENDER ="gender";
    public static String MARITAL_STATUS ="maritalstatus";
    public static String NUMBER_OF_CHILDREN = "numberofchildren";
    public static String NUMBER_OF_DEPENDANTS ="numberofdependants";
    public static String EDUCATION ="education";
    public static String MAJOR_CROP ="majorcrop";
    public static String CLUSTER = "cluster";
    public static String FARMERID = "farmerid";
    public static String FARM_AREA ="farmarea";
    public static String FARM_PERIMETER = "farmperimeter";
    //public static String ID ="id";
    
    Node underlyingNode;
   
   

    

    public Biodata(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }
    
      public String getFarmperimeter() {
       try {
            return (String) underlyingNode.getProperty(FARM_PERIMETER);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public void setFarmperimeter(String farmperimeter) {
        underlyingNode.setProperty(FARM_PERIMETER,farmperimeter);
    }
    
    
    public String getFarmarea() {
         try {
            return (String) underlyingNode.getProperty(FARM_AREA);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public void setFarmarea(String farmarea) {
       underlyingNode.setProperty(FARM_AREA,farmarea);
    }
    

    public String getFirstname() {
        try {
            return (String) underlyingNode.getProperty(FIRST_NAME);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public void setFirstname(String firstname) {
        underlyingNode.setProperty(FIRST_NAME,firstname);
    }

    public String getLastname() {
          try {
            return (String) underlyingNode.getProperty(LAST_NAME);

        } catch (Exception e) {
        }
        return "";
    }

    public void setLastname(String lastname) {
        underlyingNode.setProperty(LAST_NAME,lastname);
    }

    public String getNickname() {
         try {
            return (String) underlyingNode.getProperty(NICKNAME);

        } catch (Exception e) {
        }
        return "";
    }

    public void setNickname(String nickname) {
        underlyingNode.setProperty(NICKNAME,nickname);
    }

    public String getCommunity() {
         try {
            return (String) underlyingNode.getProperty(COMMUNITY);

        } catch (Exception e) {
        }
        return "";
    }
    

    public void setCommunity(String community) {
         underlyingNode.setProperty(COMMUNITY,community);
    }

    
    public String getDistrict() {
        try {
            return (String) underlyingNode.getProperty(DISTRICT);

        } catch (Exception e) {
        }
        return "";
    }

    public void setDistrict(String district) {
        underlyingNode.setProperty(DISTRICT,district);
    }
    public String getVillage() {
          try {
            return (String) underlyingNode.getProperty(VILLAGE);

        } catch (Exception e) {
        }
        return "";
    }

    public void setVillage(String village) {
       underlyingNode.setProperty(VILLAGE,village);
    }

    public String getRegion() {
        try {
            return (String) underlyingNode.getProperty(REGION);

        } catch (Exception e) {
        }
        return "";
    }

    public void setRegion(String region) {
        underlyingNode.setProperty(REGION,region);
    }

    public String getAge() {
           try {
            return (String) underlyingNode.getProperty(AGE);

        } catch (Exception e) {
        }
        return "";
    }

    public void setAge(String age) {
        underlyingNode.setProperty(AGE,age);
    }

    public String getGender() {
        try {
            return (String) underlyingNode.getProperty(GENDER);

        } catch (Exception e) {
        }
        return "";
    }

    public void setGender(String gender) {
         underlyingNode.setProperty(GENDER,gender);
    }

    public String getMaritalstatus() {
       try {
            return (String) underlyingNode.getProperty(MARITAL_STATUS);

        } catch (Exception e) {
        }
        return "";
    }

    public void setMaritalstatus(String maritalstatus) {
         underlyingNode.setProperty(MARITAL_STATUS,maritalstatus);
    }

    public String getNumberofchildren() {
          try {
            return (String) underlyingNode.getProperty(NUMBER_OF_CHILDREN);

        } catch (Exception e) {
        }
        return "";
    }
 
    public void setNumberofchildren(String numberofchildren) {
          underlyingNode.setProperty(NUMBER_OF_CHILDREN,numberofchildren);
    }

    public String getNumberofdependants() {
        try {
            return (String) underlyingNode.getProperty(NUMBER_OF_DEPENDANTS);

        } catch (Exception e) {
        }
        return "";
    }

    public void setNumberofdependants(String numberofdependants) {
        underlyingNode.setProperty(NUMBER_OF_DEPENDANTS,numberofdependants);
    }
    
     public String getMajorCrop() {
        try {
            return (String) underlyingNode.getProperty(MAJOR_CROP);

        } catch (Exception e) {
        }
        return "";
    }

    public void setMajorCrop(String majorcrop) {
        underlyingNode.setProperty(MAJOR_CROP,majorcrop);
    }

    public String getEducation() {
        try {
            return (String) underlyingNode.getProperty(EDUCATION);

        } catch (Exception e) {
        }
        return "";
    }

    public void setCluster(String cluster) {
         underlyingNode.setProperty(CLUSTER,cluster);
    }
    
     public void setEducation(String education) {
         underlyingNode.setProperty(EDUCATION,education);
    }
    
     public String getCluster() {
        try {
            return (String) underlyingNode.getProperty(CLUSTER);

        } catch (Exception e) {
        }
        return "";
    }
     
      public void setFarmerID(String farmerID) {
         underlyingNode.setProperty(FARMERID,farmerID);
    }
     
     public String getFarmerID() {
        try {
            return (String) underlyingNode.getProperty(FARMERID);

        } catch (Exception e) {
        }
        return "";
    }
     
    
    public void setFarmManagement(Node farmManagement)
   {
       underlyingNode.createRelationshipTo(farmManagement, ICTCRelationshipTypes.HAS_FARM_MANAGEMENT);
   }
   
   public FarmManagement getFarmManagement()
   {
       return new FarmManagement(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_FARM_MANAGEMENT));
   }
   
    public void setFarmOperation(Node farmOperation)
   {
       underlyingNode.createRelationshipTo(farmOperation, ICTCRelationshipTypes.HAS_FARM_OPERATION);
   }
   
    public Operations getFarmOperation()
   {
       return new Operations(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_FARM_OPERATION));
   }
    
   public void setHarvest(Node harvest)
   {
       underlyingNode.createRelationshipTo(harvest, ICTCRelationshipTypes.HAS_HARVEST);
   }
   
    public Harvest getHavest()
   {
       return new Harvest(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_HARVEST));
   }
    
    public void setPostHarvest(Node postHarvest)
   {
       underlyingNode.createRelationshipTo(postHarvest, ICTCRelationshipTypes.HAS_POSTHARVEST);
   }
    
     public PostHarvest getPostHavest()
   {
       return new PostHarvest(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_POSTHARVEST));
   }
     
      public void setStorage(Node storage)
   {
       underlyingNode.createRelationshipTo(storage, ICTCRelationshipTypes.HAS_STORAGE);
   }
     
    public Storage getStorage()
   {
       return new Storage(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_STORAGE));
   }
    
     public void setMarketing(Node marketing)
   {
       underlyingNode.createRelationshipTo(marketing, ICTCRelationshipTypes.HAS_MARKETING);
   } 
     
    public Marketing getMarketing()
   {
       return new Marketing(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_MARKETING));
   }
    
   public void setTechNeeds(Node techNeeds)
   {
       underlyingNode.createRelationshipTo(techNeeds, ICTCRelationshipTypes.HAS_TECHNEEDS);
   } 
   
    public TechnicalNeed getTechNeeds()
   {
       return new TechnicalNeed(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_TECHNEEDS));
   }
    
    public void setFMP(Node fmp)
   {
       underlyingNode.createRelationshipTo(fmp, ICTCRelationshipTypes.HAS_FARM_MANAGEMENT_PLAN);
   } 
    
     public FarmManagementPlan getFMP()
   {
       return new FarmManagementPlan(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_FARM_MANAGEMENT_PLAN));
   }
     
     public void setFarmerMeeting(Node Meeting)
     {
         underlyingNode.createRelationshipTo(Meeting, ICTCRelationshipTypes.HAS_MEETING); 
     }
     
       public Meeting getFarmerMeeting()
   {
       return new Meeting(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_MEETING));
   }
       
    public void setProduction(Node production) {
        underlyingNode.createRelationshipTo(production, ICTCRelationshipTypes.HAS_PRODUCTION);
    }

    public ProductionNew getProduction() {
        return new ProductionNew(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_PRODUCTION));
    }
    
    
    public void setProfiling(Node profiling) {
        underlyingNode.createRelationshipTo(profiling, ICTCRelationshipTypes.HAS_PROFILING);
    }

    public Profiling getProfiling() {
        return new Profiling(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_PROFILING));
    }
    
     public void setBPB(Node BPB) {
        underlyingNode.createRelationshipTo(BPB, ICTCRelationshipTypes.HAS_BASELINE_PRODUCTION_BUDGET);
    }

    public BaselineProductionBudget getBPB() {
        return new BaselineProductionBudget(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_BASELINE_PRODUCTION_BUDGET));
    }
    
    
    public void setBPHB(Node BPB) {
        underlyingNode.createRelationshipTo(BPB, ICTCRelationshipTypes.HAS_BASELINE_POSTHARVEST_BUDGET);
    }

    public BaselinePostHarvestBudget getBPHB() {
        return new BaselinePostHarvestBudget(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_BASELINE_POSTHARVEST_BUDGET));
    }
    
      public void setBPH(Node BPB) {
        underlyingNode.createRelationshipTo(BPB, ICTCRelationshipTypes.HAS_BASELINE_POSTHARVEST);
    }

    public BaselinePostHarvestBudget getBPH() {
        return new BaselinePostHarvestBudget(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_BASELINE_POSTHARVEST));
    }
    
    
      public void setFMPPB(Node BPB) {
        underlyingNode.createRelationshipTo(BPB, ICTCRelationshipTypes.HAS_PRODUCTION_BUDGET);
    }

    public FmpProductionBudget getFMPPB() {
        return new FmpProductionBudget(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_PRODUCTION_BUDGET));
    }

    public void setFMPPHB(Node BPBNode) {
        underlyingNode.createRelationshipTo(BPBNode, ICTCRelationshipTypes.HAS_POSTHARVEST_BUDGET);
    }
    
    public FmpPostHarvestBudget getFMPPHB() {
        return new FmpPostHarvestBudget(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_POSTHARVEST_BUDGET));
    }
}
