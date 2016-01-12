/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.domains;

import com.grameenfoundation.ictc.domain.commons.GeneralInterface;
import com.grameenfoundation.ictc.domain.commons.Status;
import com.grameenfoundation.ictc.models.FarmerGPSModel;
import com.grameenfoundation.ictc.utils.ICTCRelationshipTypes;
import com.grameenfoundation.ictc.utils.Neo4jServices;
import com.grameenfoundation.ictc.wrapper.FarmGPSLocationWrapper;
import com.grameenfoundation.ictc.wrapper.FarmerInputReceivedWrapper;
import com.grameenfoundation.ictc.wrapper.MeetingWrapper;
import java.util.ArrayList;
import java.util.List;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;

/**
 *
 * @author Joseph George Davis
 * @date Jul 16, 2015 12:08:21 PM description:
 */
public class Biodata extends Status implements GeneralInterface {

    public static String FIRST_NAME = "firstname";
    public static String LAST_NAME = "lastname";
    public static String NICKNAME = "nickname";
    public static String COMMUNITY = "community";
    public static String VILLAGE = "village";
    public static String DISTRICT = "district";
    public static String REGION = "region";
    public static String AGE = "age";
    public static String GENDER = "gender";
    public static String MARITAL_STATUS = "maritalstatus";
    public static String NUMBER_OF_CHILDREN = "numberofchildren";
    public static String NUMBER_OF_DEPENDANTS = "numberofdependants";
    public static String EDUCATION = "education";
    public static String MAJOR_CROP = "majorcrop";
    public static String CLUSTER = "cluster";
    public static String FARMERID = "Id";
    public static String FARM_AREA = "farmarea";
    public static String FARM_PERIMETER = "farmperimeter";
    public static String TELEPHONENUMBER = "telephonenumber";
    public static String FARMERIMAGE = "farmerimage";
    public static String DISTRICTS_ASHANTI = "Districts_Ashanti";
    public static String DISTRICTS_BRONGAHAFO = "Districts_BrongAhafo";
    public static String DISTRICTS_VOLTA = "Districts_Volta";
    public static String IMAGE_URL = "image_url";
    public static String CREATED_BY = "createdBy";
    
    
     public void setCreatedById(String createBy) {
        underlyingNode.setProperty(CREATED_BY, createBy);
    }

    public String getCreatedById() {
        try {
            return (String) underlyingNode.getProperty(CREATED_BY);

        } catch (Exception e) {
        }
        return null;
    }
    

    public void setImage_Url(String image_url) {
        underlyingNode.setProperty(IMAGE_URL, image_url);
    }

    public String getImage_Url() {
        try {
            return (String) underlyingNode.getProperty(IMAGE_URL);

        } catch (Exception e) {
        }
        return null;
    }

    public void setDistricts_Volta(String districts_volta) {
        underlyingNode.setProperty(DISTRICTS_VOLTA, districts_volta);
    }

    public String getDistricts_Volta() {
        try {
            return (String) underlyingNode.getProperty(DISTRICTS_VOLTA);

        } catch (Exception e) {
        }
        return null;
    }

    public void setDistricts_BrongAhafo(String districts_brongahafo) {
        underlyingNode.setProperty(DISTRICTS_BRONGAHAFO, districts_brongahafo);
    }

    public String getDistricts_BrongAhafo() {
        try {
            return (String) underlyingNode.getProperty(DISTRICTS_BRONGAHAFO);

        } catch (Exception e) {
        }
        return null;
    }

    public void setDistricts_Ashanti(String districts_ashanti) {
        underlyingNode.setProperty(DISTRICTS_ASHANTI, districts_ashanti);
    }

    public String getDistricts_Ashanti() {
        try {
            return (String) underlyingNode.getProperty(DISTRICTS_ASHANTI);

        } catch (Exception e) {
        }
        return null;
    }

    public void setFarmerimage(String farmerimage) {
        underlyingNode.setProperty(FARMERIMAGE, farmerimage);
    }

    public String getFarmerimage() {
        try {
            return (String) underlyingNode.getProperty(FARMERIMAGE);

        } catch (Exception e) {
        }
        return null;
    }

    //public static String ID ="id";
    Node underlyingNode;

    public Biodata(Node underlyingNode) {
        super(underlyingNode);
        this.underlyingNode = underlyingNode;
    }

    public void setTelephonenumber(String telephonenumber) {
        underlyingNode.setProperty(TELEPHONENUMBER, telephonenumber);
    }

    public String getTelephonenumber() {
        try {
            return (String) underlyingNode.getProperty(TELEPHONENUMBER);

        } catch (Exception e) {
        }
        return null;
    }

    public String getFarmperimeter() {
        try {
            return (String) underlyingNode.getProperty(FARM_PERIMETER);

        } catch (Exception e) {
//            e.printStackTrace();
        }
        return "";
    }

    public void setFarmperimeter(String farmperimeter) {
        underlyingNode.setProperty(FARM_PERIMETER, farmperimeter);
    }

    public String getFarmarea() {
        try {
            return (String) underlyingNode.getProperty(FARM_AREA);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return "";
    }

    public void setFarmarea(String farmarea) {
        underlyingNode.setProperty(FARM_AREA, farmarea);
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
        underlyingNode.setProperty(FIRST_NAME, firstname);
    }

    public String getLastname() {
        try {
            return (String) underlyingNode.getProperty(LAST_NAME);

        } catch (Exception e) {
        }
        return "";
    }

    public void setLastname(String lastname) {
        underlyingNode.setProperty(LAST_NAME, lastname);
    }

    public String getNickname() {
        try {
            return (String) underlyingNode.getProperty(NICKNAME);

        } catch (Exception e) {
        }
        return "";
    }

    public void setNickname(String nickname) {
        underlyingNode.setProperty(NICKNAME, nickname);
    }

    public String getCommunity() {
        try {
            return (String) underlyingNode.getProperty(COMMUNITY);

        } catch (Exception e) {
        }
        return "";
    }

    public void setCommunity(String community) {
        underlyingNode.setProperty(COMMUNITY, community);
    }

    public String getDistrict() {
        try {
            return (String) underlyingNode.getProperty(DISTRICT);

        } catch (Exception e) {
        }
        return "";
    }

    public void setDistrict(String district) {
        underlyingNode.setProperty(DISTRICT, district);
    }

    public String getVillage() {
        try {
            return (String) underlyingNode.getProperty(VILLAGE);

        } catch (Exception e) {
        }
        return "";
    }

    public void setVillage(String village) {
        underlyingNode.setProperty(VILLAGE, village);
    }

    public String getRegion() {
        try {
            return (String) underlyingNode.getProperty(REGION);

        } catch (Exception e) {
        }
        return "";
    }

    public void setRegion(String region) {
        underlyingNode.setProperty(REGION, region);
    }

    public String getAge() {
        try {
            return (String) underlyingNode.getProperty(AGE);

        } catch (Exception e) {
        }
        return "";
    }

    public void setAge(String age) {
        underlyingNode.setProperty(AGE, age);
    }

    public String getGender() {
        try {
            return (String) underlyingNode.getProperty(GENDER);

        } catch (Exception e) {
        }
        return "";
    }

    public void setGender(String gender) {
        underlyingNode.setProperty(GENDER, gender);
    }

    public String getMaritalstatus() {
        try {
            return (String) underlyingNode.getProperty(MARITAL_STATUS);

        } catch (Exception e) {
        }
        return "";
    }

    public void setMaritalstatus(String maritalstatus) {
        underlyingNode.setProperty(MARITAL_STATUS, maritalstatus);
    }

    public String getNumberofchildren() {
        try {
            return (String) underlyingNode.getProperty(NUMBER_OF_CHILDREN);

        } catch (Exception e) {
        }
        return "";
    }

    public void setNumberofchildren(String numberofchildren) {
        underlyingNode.setProperty(NUMBER_OF_CHILDREN, numberofchildren);
    }

    public String getNumberofdependants() {
        try {
            return (String) underlyingNode.getProperty(NUMBER_OF_DEPENDANTS);

        } catch (Exception e) {
        }
        return "";
    }

    public void setNumberofdependants(String numberofdependants) {
        underlyingNode.setProperty(NUMBER_OF_DEPENDANTS, numberofdependants);
    }

    public String getMajorCrop() {
        try {
            return (String) underlyingNode.getProperty(MAJOR_CROP);

        } catch (Exception e) {
        }
        return "";
    }

    public void setMajorCrop(String majorcrop) {
        underlyingNode.setProperty(MAJOR_CROP, majorcrop);
    }

    public String getEducation() {
        try {
            return (String) underlyingNode.getProperty(EDUCATION);

        } catch (Exception e) {
        }
        return "";
    }

    public void setCluster(String cluster) {
        underlyingNode.setProperty(CLUSTER, cluster);
    }

    public void setEducation(String education) {
        underlyingNode.setProperty(EDUCATION, education);
    }

    public String getCluster() {
        try {
            return (String) underlyingNode.getProperty(CLUSTER);

        } catch (Exception e) {
        }
        return "";
    }

    public void setFarmerID(String farmerID) {
        underlyingNode.setProperty(FARMERID, farmerID);
    }

    public String getFarmerID() {
        try {
            return (String) underlyingNode.getProperty(FARMERID);

        } catch (Exception e) {
        }
        return "";
    }

    public void setFarmManagement(Node farmManagement) {
        underlyingNode.createRelationshipTo(farmManagement, ICTCRelationshipTypes.HAS_FARM_MANAGEMENT);
    }

    public FarmManagement getFarmManagement() {
        return new FarmManagement(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_FARM_MANAGEMENT));
    }

    public void setFarmOperation(Node farmOperation) {
        underlyingNode.createRelationshipTo(farmOperation, ICTCRelationshipTypes.HAS_FARM_OPERATION);
    }

    public Operations getFarmOperation() {
        return new Operations(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_FARM_OPERATION));
    }

    public void setHarvest(Node harvest) {
        underlyingNode.createRelationshipTo(harvest, ICTCRelationshipTypes.HAS_HARVEST);
    }

    public Harvest getHavest() {
        return new Harvest(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_HARVEST));
    }

    public void setPostHarvest(Node postHarvest) {
        underlyingNode.createRelationshipTo(postHarvest, ICTCRelationshipTypes.HAS_POSTHARVEST);
    }

    public PostHarvest2 getPostHavest2() {
        return new PostHarvest2(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_POSTHARVEST));
    } public PostHarvest getPostHavest() {
        return new PostHarvest(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_POSTHARVEST));
    }

    public void setStorage(Node storage) {
        underlyingNode.createRelationshipTo(storage, ICTCRelationshipTypes.HAS_STORAGE);
    }

    public Storage getStorage() {
        return new Storage(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_STORAGE));
    }

    public void setMarketing(Node marketing) {
        underlyingNode.createRelationshipTo(marketing, ICTCRelationshipTypes.HAS_MARKETING);
    }

    public Marketing getMarketing() {
        return new Marketing(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_MARKETING));
    }

    public void setTechNeeds(Node techNeeds) {
        underlyingNode.createRelationshipTo(techNeeds, ICTCRelationshipTypes.HAS_TECHNEEDS);
    }

    public TechnicalNeed getTechNeeds() {
        return new TechnicalNeed(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_TECHNEEDS));
    }

    public void setFMP(Node fmp) {
        underlyingNode.createRelationshipTo(fmp, ICTCRelationshipTypes.HAS_FARM_MANAGEMENT_PLAN);
    }

    public FarmManagementPlan getFMP() {
        return new FarmManagementPlan(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_FARM_MANAGEMENT_PLAN));
    }

    public void setFarmerMeeting(Node Meeting) {
        underlyingNode.createRelationshipTo(Meeting, ICTCRelationshipTypes.HAS_MEETING);
    }

    public Meeting getFarmerMeeting() {
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

    public void setBP(Node BP) {
        underlyingNode.createRelationshipTo(BP, ICTCRelationshipTypes.HAS_BASELINE_PRODUCTION);
    }

    public BaselineProduction getBP() {
        return new BaselineProduction(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_BASELINE_PRODUCTION));
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

    public BaselinePostHarvest getBPH() {
        return new BaselinePostHarvest(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_BASELINE_POSTHARVEST));
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

    public void setFCA(Node FCANode) {
        underlyingNode.createRelationshipTo(FCANode, ICTCRelationshipTypes.HAS_FIELD_CROP_ASSESSMENT);
    }

    public FieldCropAssessment getFCA() {
        return new FieldCropAssessment(Neo4jServices.findNodeFromRelation(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_FIELD_CROP_ASSESSMENT));
    }

    public List<Node> getNodeList(Direction direction, ICTCRelationshipTypes relType) {
//          List<Node> n= (Neo4jServices.findNodeFromRelations(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_MEETING));
        List<Node> n = (Neo4jServices.findNodeFromRelations(underlyingNode, direction, relType));
        return n;
    }

    public List<Node> getMeeting() {
//          List<Node> n= (Neo4jServices.findNodeFromRelations(underlyingNode, Direction.OUTGOING, ICTCRelationshipTypes.HAS_MEETING));
//          List<Node> n= (Neo4jServices.findNodeFromRelations(underlyingNode, direction, relType));
        return getNodeList(Direction.OUTGOING, ICTCRelationshipTypes.HAS_MEETING);
//          return  n;
    }

    public List<FarmerInputReceivedWrapper> getFarmInputs() {
        List<Node> nodes = getNodeList(Direction.OUTGOING, ICTCRelationshipTypes.HAS_FARM_INPUT);

        List<FarmerInputReceivedWrapper> received = new ArrayList<>();

        for (Node node : nodes) {
            FarmerInputReceived setting = new FarmerInputReceived(node);
            FarmerInputReceivedWrapper fic = new FarmerInputReceivedWrapper();

            fic.setStatus(setting.getStatus());
            fic.setName(setting.getName());
            fic.setQty(setting.getQty());
            received.add(fic);
        }
        return received;

    }

     public List<FarmGPSLocationWrapper> getFarmGps() {
        List<Node> nodes = getNodeList(Direction.OUTGOING, ICTCRelationshipTypes.HAS_FARM_GPS);

        List<FarmGPSLocationWrapper> received = new ArrayList<>();

        for (Node node : nodes) {
            FarmGPSLocation m = new FarmGPSLocation(node);
            FarmGPSLocationWrapper fic = new FarmGPSLocationWrapper();
//fic.setFarmerId(m.getFarmerId());
                fic.setId(m.getGPSId());
                fic.setLatitude(m.getLatitude());
                fic.setLongitude(m.getLongitude());
            received.add(fic);
        }
        return received;

    }

    public List<MeetingWrapper> getMeetingDetails() {
        List<Node> n = getMeeting();
        List<MeetingWrapper> met = new ArrayList<>();
        for (Node met1 : n) {
            Meeting m = new Meeting(met1);
            MeetingWrapper mr = new MeetingWrapper();

            mr.setType(m.getType());
            mr.setMeetingIndex(m.getMeetingIndex());
            mr.setSeason(m.getSeason());
            mr.setStartDate(m.getStartdate());
            mr.setEndDate(m.getEnddate());
            mr.setAttended(m.getAttended());

            met.add(mr);

        }
        return met;
    }
}
