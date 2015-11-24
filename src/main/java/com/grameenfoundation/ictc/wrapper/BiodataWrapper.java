/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.wrapper;

import com.grameenfoundation.ictc.domains.FarmManagementPlan;
import java.util.List;

/**
 *
 * @author Joseph George Davis
 * @date Jul 16, 2015 1:58:44 PM description:
 */
public class BiodataWrapper {

    private String firstName = "firstname";
    private String lastName = "lastname";
    private String nickname = "nickname";
    private String community = "community";
    private String village = "village";
    private String district = "district";
    private String region = "region";
    private String age = "age";
    private String gender = "gender";
    private String maritalStatus = "maritalstatus";
    private String numberOfChildren = "numberofchildren";
    private String numberOfDependants = "numberofdependants";
    private String education = "education";
    private String cluster = "cluster";
    private String farmID = "farmerid";
    private String majorCrop = "majorcrop";
    private String farmarea = "farmarea";
    private String farmperimeter = "farmperimeter";
    String farmerimage="farmerimage";
    String telephonenumber="telephonenumber";
    String Districts_Ashanti="Districts_Ashanti";
    String Districts_BrongAhafo="Districts_BrongAhafo";
    String Districts_Volta="Districts_Volta";
    
 public  void setDistricts_Volta(String Districts_Volta) {
      this.Districts_Volta=Districts_Volta;
    }
 public  String getDistricts_Volta() {
        return Districts_Volta;

    }
    
    
 public  void setDistricts_BrongAhafo(String Districts_BrongAhafo) {
      this.Districts_BrongAhafo=Districts_BrongAhafo;
    }
 public  String getDistricts_BrongAhafo() {
        return Districts_BrongAhafo;

    }
    
 public  void setDistricts_Ashanti(String Districts_Ashanti) {
      this.Districts_Ashanti=Districts_Ashanti;
    }
 public  String getDistricts_Ashanti() {
        return Districts_Ashanti;

    }
 public  void setFarmerimage(String farmerimage) {
      this.farmerimage=farmerimage;
    }
 public  String getFarmerimage() {
        return farmerimage;

    }
    
    
 public  void setTelephonenumber(String telephonenumber) {
      this.telephonenumber=telephonenumber;
    }
 public  String getTelephonenumber() {
        return telephonenumber;

    }

    public String getFarmarea() {
        return farmarea;
    }

    public void setFarmarea(String farmarea) {
        this.farmarea = farmarea;
    }

    public String getFarmperimeter() {
        return farmperimeter;
    }

    public void setFarmperimeter(String farmperimeter) {
        this.farmperimeter = farmperimeter;
    }
    
    
    

    private TechnicalNeedsWrapper techNeeds;
    private MarketingWrapper marketing;
    private HarvestWrapper harvest;
    private OperationsWrapper operation;
    private PostHarvestWrapper postHarvest;
    private StorageWrapper storage;
    FarmManagementPlanWrapper fmp ;
private FarmManagementWrapper farmManagement;
private List<FieldObject> fmpValues;

    public FarmManagementPlanWrapper getFmp() {
        return fmp;
    }

    public void setFmp(FarmManagementPlanWrapper fmp) {
        this.fmp = fmp;
    }
    public BiodataWrapper(String firstName, String lastName, String nickname, String community, String village, String district, String region, String age, String gender, String maritalStatus, String numberOfChildren, String numberOfDependants, String education) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.community = community;
        this.village = village;
        this.district = district;
        this.region = region;
        this.age = age;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.numberOfChildren = numberOfChildren;
        this.numberOfDependants = numberOfDependants;
        this.education = education;
    }

    public BiodataWrapper(String firstName, String lastName, String nickname, String community, String village, String district, String region, String age, String gender, String maritalStatus, String numberOfChildren, String numberOfDependants, String education, String cluster, String farmID, String majorCrop) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.community = community;
        this.village = village;
        this.district = district;
        this.region = region;
        this.age = age;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.numberOfChildren = numberOfChildren;
        this.numberOfDependants = numberOfDependants;
        this.education = education;
        this.cluster = cluster;
        this.farmID = farmID;
        this.majorCrop = majorCrop;
        
        this.marketing =  new MarketingWrapper();
        this.operation = new OperationsWrapper();
        this.farmManagement = new FarmManagementWrapper();
        this.marketing = new MarketingWrapper();
        this.storage = new StorageWrapper();
        this.fmp = new FarmManagementPlanWrapper();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(String numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public String getNumberOfDependants() {
        return numberOfDependants;
    }

    public void setNumberOfDependants(String numberOfDependants) {
        this.numberOfDependants = numberOfDependants;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * @return the cluster
     */
    public String getCluster() {
        return cluster;
    }

    /**
     * @param cluster the cluster to set
     */
    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    /**
     * @return the farmID
     */
    public String getFarmID() {
        return farmID;
    }

    /**
     * @param farmID the farmID to set
     */
    public void setFarmID(String farmID) {
        this.farmID = farmID;
    }

    public String getMajorCrop() {
        return majorCrop;
    }

    public void setMajorCrop(String majorCrop) {
        this.majorCrop = majorCrop;
    }

    /**
     * @return the techNeeds
     */
    public TechnicalNeedsWrapper getTechNeeds() {
        return techNeeds;
    }

    /**
     * @param techNeeds the techNeeds to set
     */
    public void setTechNeeds(TechnicalNeedsWrapper techNeeds) {
        this.techNeeds = techNeeds;
    }

    /**
     * @return the marketing
     */
    public MarketingWrapper getMarketing() {
        return marketing;
    }

    /**
     * @param marketing the marketing to set
     */
    public void setMarketing(MarketingWrapper marketing) {
        this.marketing = marketing;
    }

    /**
     * @return the harvest
     */
    public HarvestWrapper getHarvest() {
        return harvest;
    }

    /**
     * @param harvest the harvest to set
     */
    public void setHarvest(HarvestWrapper harvest) {
        this.harvest = harvest;
    }

    /**
     * @return the operation
     */
    public OperationsWrapper getOperation() {
        return operation;
    }

    /**
     * @param operation the operation to set
     */
    public void setOperation(OperationsWrapper operation) {
        this.operation = operation;
    }

    /**
     * @return the postHarvest
     */
    public PostHarvestWrapper getPostHarvest() {
        return postHarvest;
    }

    /**
     * @param postHarvest the postHarvest to set
     */
    public void setPostHarvest(PostHarvestWrapper postHarvest) {
        this.postHarvest = postHarvest;
    }

    /**
     * @return the storage
     */
    public StorageWrapper getStorage() {
        return storage;
    }

    /**
     * @param storage the storage to set
     */
    public void setStorage(StorageWrapper storage) {
        this.storage = storage;
    }

    /**
     * @return the farmManagement
     */
    public FarmManagementWrapper getFarmManagement() {
        return farmManagement;
    }

    /**
     * @param farmManagement the farmManagement to set
     */
    public void setFarmManagement(FarmManagementWrapper farmManagement) {
        this.farmManagement = farmManagement;
    }

    /**
     * @return the fmpValues
     */
    public List<FieldObject> getFmpValues() {
        return fmpValues;
    }

    /**
     * @param fmpValues the fmpValues to set
     */
    public void setFmpValues(List<FieldObject> fmpValues) {
        this.fmpValues = fmpValues;
    }

}
