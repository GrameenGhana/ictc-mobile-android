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
    String image_url = "image_url";
    String disrictresidenceash="disrictresidenceash";
    String districtresidenceba="districtresidenceba";
    String districtresidencevolta="districtresidencevolta";
    String numberofdependantsmale="numberofdependantsmale";
    String numberofdependentsfemale="numberofdependentsfemale";
    String regionresidence="regionresidence";
    String DataCollectedBy=" DataCollectedBy";
    String acdivocafarmerid="ACDIVOCAFARMERID";
    String maidename="maidename";
    String Famer_type="Famer_type";
    String marriage_name="marriage_name";
    String WorkingWithList="WorkingWithList";
    String dateofbirth="dateofbirth";
    String NoMaleEmployees="NoMaleEmployees";
    String NoFemaleEmployees="nofemaleemployees";
    String MSMEType="MSMEType";
    String fkFarmerHHProfile="fkFarmerHHProfile";
    String isWithFBO="isWithFBO";
    String fkFBOProfile="fkFBOProfile";
    String FBOPosition="FBOPosition";
    String isOutGrower="isOutGrower";
    String fkNucleusFarmerProfile="fkNucleusFarmerProfile";
    String isWithPA="isWithPA";
    String PAName="PAName";
    String PAOffice="PAOffice";
    String Remarks="Remarks";
    String Status="Status";
    String DataCollcetedBy="DataCollcetedBy";
    String DataReviewedBy="DataReviewedBy";
    String DateCollected="DateCollected";
    String DateReviewed="DateReviewed";
    String fkFYName="fkFYName";
 public  void setFkFYName(String fkFYName) {
      this.fkFYName=fkFYName;
    }
 public  String getFkFYName() {
        return fkFYName;

    }
    
 public  void setDateReviewed(String DateReviewed) {
      this.DateReviewed=DateReviewed;
    }
 public  String getDateReviewed() {
        return DateReviewed;

    }
    
 public  void setDateCollected(String DateCollected) {
      this.DateCollected=DateCollected;
    }
 public  String getDateCollected() {
        return DateCollected;

    }
    
 public  void setDataReviewedBy(String DataReviewedBy) {
      this.DataReviewedBy=DataReviewedBy;
    }
 public  String getDataReviewedBy() {
        return DataReviewedBy;

    }
    
 public  void setDataCollcetedBy(String DataCollcetedBy) {
      this.DataCollcetedBy=DataCollcetedBy;
    }
 public  String getDataCollcetedBy() {
        return DataCollcetedBy;

    }
    
 public  void setStatus(String Status) {
      this.Status=Status;
    }
 public  String getStatus() {
        return Status;

    }
    
 public  void setRemarks(String Remarks) {
      this.Remarks=Remarks;
    }
 public  String getRemarks() {
        return Remarks;

    }
 public  void setPAOffice(String PAOffice) {
      this.PAOffice=PAOffice;
    }
 public  String getPAOffice() {
        return PAOffice;

    }
    
    
    
 public  void setPAName(String PAName) {
      this.PAName=PAName;
    }
 public  String getPAName() {
        return PAName;

    }
    
    
    
 public  void setIsWithPA(String isWithPA) {
      this.isWithPA=isWithPA;
    }
 public  String getIsWithPA() {
        return isWithPA;

    }
 String fkAggregatorProfile="fkAggregatorProfile";
    String OutgrowerGroupName="OutgrowerGroupName";
    
    
 public  void setOutgrowerGroupName(String OutgrowerGroupName) {
      this.OutgrowerGroupName=OutgrowerGroupName;
    }
 public  String getOutgrowerGroupName() {
        return OutgrowerGroupName;

    }
 public  void setFkAggregatorProfile(String fkAggregatorProfile) {
      this.fkAggregatorProfile=fkAggregatorProfile;
    }
 public  String getFkAggregatorProfile() {
        return fkAggregatorProfile;

    }
    
    
 public  void setFkNucleusFarmerProfile(String fkNucleusFarmerProfile) {
      this.fkNucleusFarmerProfile=fkNucleusFarmerProfile;
    }
 public  String getFkNucleusFarmerProfile() {
        return fkNucleusFarmerProfile;

    }
 public  void setIsOutGrower(String isOutGrower) {
      this.isOutGrower=isOutGrower;
    }
 public  String getIsOutGrower() {
        return isOutGrower;

    }
    
 public  void setFBOPosition(String FBOPosition) {
      this.FBOPosition=FBOPosition;
    }
 public  String getFBOPosition() {
        return FBOPosition;

    }
 public  void setFkFBOProfile(String fkFBOProfile) {
      this.fkFBOProfile=fkFBOProfile;
    }
 public  String getFkFBOProfile() {
        return fkFBOProfile;

    }
    
 public  void setIsWithFBO(String isWithFBO) {
      this.isWithFBO=isWithFBO;
    }
 public  String getIsWithFBO() {
        return isWithFBO;

    }
    
 public  void setFkFarmerHHProfile(String fkFarmerHHProfile) {
      this.fkFarmerHHProfile=fkFarmerHHProfile;
    }
 public  String getFkFarmerHHProfile() {
        return fkFarmerHHProfile;

    }
    
 public  void setMSMEType(String MSMEType) {
      this.MSMEType=MSMEType;
    }
 public  String getMSMEType() {
        return MSMEType;

    }
    
    
 public  void setNoFemaleEmployees(String NoFemaleEmployees) {
      this.NoFemaleEmployees=NoFemaleEmployees;
    }
 public  String getNoFemaleEmployees() {
        return NoFemaleEmployees;

    }
    
 public  void setNoMaleEmployees(String NoMaleEmployees) {
      this.NoMaleEmployees=NoMaleEmployees;
    }
 public  String getNoMaleEmployees() {
        return NoMaleEmployees;

    }
    
 public  void setDateofbirth(String dateofbirth) {
      this.dateofbirth=dateofbirth;
    }
 public  String getDateofbirth() {
        return dateofbirth;

    }
    
 public  void setWorkingWithList(String WorkingWithList) {
      this.WorkingWithList=WorkingWithList;
    }
 public  String getWorkingWithList() {
        return WorkingWithList;

    }
    
    
 public  void setMarriage_name(String marriage_name) {
      this.marriage_name=marriage_name;
    }
 public  String getMarriage_name() {
        return marriage_name;

    }
    
    
 public  void setFamer_type(String Famer_type) {
      this.Famer_type=Famer_type;
    }
 public  String getFamer_type() {
        return Famer_type;

    }
    
 public  void setMaidename(String maidename) {
      this.maidename=maidename;
    }
 public  String getMaidename() {
        return maidename;

    }
    
 public  void setACDIVOCAFARMERID(String acdivocafarmerid) {
      this.acdivocafarmerid=acdivocafarmerid;
    }
 public  String getACDIVOCAFARMERID() {
        return acdivocafarmerid;

    }
    
    
    
 public  void setDataCollectedBy(String DataCollectedBy) {
      this.DataCollectedBy=DataCollectedBy;
    }
 public  String getDataCollectedBy() {
        return DataCollectedBy;

    }
    
    
 public  void setRegionresidence(String regionresidence) {
      this.regionresidence=regionresidence;
    }
 public  String getRegionresidence() {
        return regionresidence;

    }
    
 public  void setNumberofdependentsfemale(String numberofdependentsfemale) {
      this.numberofdependentsfemale=numberofdependentsfemale;
    }
 public  String getNumberofdependentsfemale() {
        return numberofdependentsfemale;

    }
    
 public  void setNumberofdependantsmale(String numberofdependantsmale) {
      this.numberofdependantsmale=numberofdependantsmale;
    }
 public  String getNumberofdependantsmale() {
        return numberofdependantsmale;

    }
    
 public  void setDistrictresidencevolta(String districtresidencevolta) {
      this.districtresidencevolta=districtresidencevolta;
    }
 public  String getDistrictresidencevolta() {
        return districtresidencevolta;

    }
    
 public  void setDistrictresidenceba(String districtresidenceba) {
      this.districtresidenceba=districtresidenceba;
    }
 public  String getDistrictresidenceba() {
        return districtresidenceba;

    }
    
 public  void setDisrictresidenceash(String disrictresidenceash) {
      this.disrictresidenceash=disrictresidenceash;
    }
 public  String getDisrictresidenceash() {
        return disrictresidenceash;

    }
    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
    
    
    
    
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

    public BiodataWrapper() {
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
