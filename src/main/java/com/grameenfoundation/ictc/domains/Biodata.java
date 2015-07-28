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
    //public static String ID ="id";
    
    Node underlyingNode;
   
   

    

    public Biodata(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }

    public String getFirstname() {
        try {
            return (String) underlyingNode.getProperty(FIRST_NAME);

        } catch (Exception e) {
        }
        return null;
    }

    public void setFirstname(String firstname) {
        underlyingNode.setProperty(FIRST_NAME,firstname);
    }

    public String getLastname() {
          try {
            return (String) underlyingNode.getProperty(LAST_NAME);

        } catch (Exception e) {
        }
        return null;
    }

    public void setLastname(String lastname) {
        underlyingNode.setProperty(LAST_NAME,lastname);
    }

    public String getNickname() {
         try {
            return (String) underlyingNode.getProperty(NICKNAME);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNickname(String nickname) {
        underlyingNode.setProperty(NICKNAME,nickname);
    }

    public String getCommunity() {
         try {
            return (String) underlyingNode.getProperty(COMMUNITY);

        } catch (Exception e) {
        }
        return null;
    }
    

    public void setCommunity(String community) {
         underlyingNode.setProperty(COMMUNITY,community);
    }

    
    public String getDistrict() {
        try {
            return (String) underlyingNode.getProperty(DISTRICT);

        } catch (Exception e) {
        }
        return null;
    }

    public void setDistrict(String district) {
        underlyingNode.setProperty(DISTRICT,district);
    }
    public String getVillage() {
          try {
            return (String) underlyingNode.getProperty(VILLAGE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setVillage(String village) {
       underlyingNode.setProperty(VILLAGE,village);
    }

    public String getRegion() {
        try {
            return (String) underlyingNode.getProperty(REGION);

        } catch (Exception e) {
        }
        return null;
    }

    public void setRegion(String region) {
        underlyingNode.setProperty(REGION,region);
    }

    public String getAge() {
           try {
            return (String) underlyingNode.getProperty(AGE);

        } catch (Exception e) {
        }
        return null;
    }

    public void setAge(String age) {
        underlyingNode.setProperty(AGE,age);
    }

    public String getGender() {
        try {
            return (String) underlyingNode.getProperty(GENDER);

        } catch (Exception e) {
        }
        return null;
    }

    public void setGender(String gender) {
         underlyingNode.setProperty(GENDER,gender);
    }

    public String getMaritalstatus() {
       try {
            return (String) underlyingNode.getProperty(MARITAL_STATUS);

        } catch (Exception e) {
        }
        return null;
    }

    public void setMaritalstatus(String maritalstatus) {
         underlyingNode.setProperty(MARITAL_STATUS,maritalstatus);
    }

    public String getNumberofchildren() {
          try {
            return (String) underlyingNode.getProperty(NUMBER_OF_CHILDREN);

        } catch (Exception e) {
        }
        return null;
    }
 
    public void setNumberofchildren(String numberofchildren) {
          underlyingNode.setProperty(NUMBER_OF_CHILDREN,numberofchildren);
    }

    public String getNumberofdependants() {
        try {
            return (String) underlyingNode.getProperty(NUMBER_OF_DEPENDANTS);

        } catch (Exception e) {
        }
        return null;
    }

    public void setNumberofdependants(String numberofdependants) {
        underlyingNode.setProperty(NUMBER_OF_DEPENDANTS,numberofdependants);
    }

    public String getEducation() {
        try {
            return (String) underlyingNode.getProperty(EDUCATION);

        } catch (Exception e) {
        }
        return null;
    }

    public void setEducation(String education) {
         underlyingNode.setProperty(EDUCATION,education);
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
   
    public Operations getHavest()
   {
       return new Operations(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_HARVEST));
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
   
    public Marketing getTechNeeds()
   {
       return new Marketing(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_TECHNEEDS));
   }
    
}
