/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.controllers;


/**
 * represent a farmer record
 *
 * Copyright (c) 2014 AppLab, Grameen Foundation
 * Created by: David
 */
public class Farmer{
    //private String farmerId;
    private String firstName;
    private String lastName;
    private String creationDate;
    private String subcounty;
    private String village;
    private String nickname;
    private String community;
    private String district;
    private String region;
    private String age;
    private String gender;
    private String maritalStatus;
    private String numberOfChildren;
    private String numberOfDependants;
    private String education;
    private String cluster;
    private String farmID;

    private String sizePlot;
    private String labour;
    private String dateOfLandIdentification ;
    private String locationOfLand;
    private String targetArea;
    private String expectedPriceInTon ;
    private String variety;
    private String targetNextSeason ;
    private String techNeeds1;
    private String techNeeds2 ;
    private String farmerBasedOrg;
    //    String REGION,
    private String plantingDate;
    private String landArea ;
    private String dateManualWeeding ;
    private String posContact ;   private String monthSellingStarts;
    private String monthFinalProductSold;

    public Farmer(String firstName, String lastName, String creationDate, String subcounty, String village, String nickname, String community, String district, String region, String age, String gender, String maritalStatus, String numberOfChildren, String numberOfDependants, String education, String cluster, String farmID, String sizePlot, String labour, String dateOfLandIdentification, String locationOfLand, String targetArea, String expectedPriceInTon, String variety, String targetNextSeason, String techNeeds1, String techNeeds2, String farmerBasedOrg, String plantingDate, String landArea, String dateManualWeeding, String posContact, String monthSellingStarts, String monthFinalProductSold) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.creationDate = creationDate;
        this.subcounty = subcounty;
        this.village = village;
        this.nickname = nickname;
        this.community = community;
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
        this.sizePlot = sizePlot;
        this.labour = labour;
        this.dateOfLandIdentification = dateOfLandIdentification;
        this.locationOfLand = locationOfLand;
        this.targetArea = targetArea;
        this.expectedPriceInTon = expectedPriceInTon;
        this.variety = variety;
        this.targetNextSeason = targetNextSeason;
        this.techNeeds1 = techNeeds1;
        this.techNeeds2 = techNeeds2;
        this.farmerBasedOrg = farmerBasedOrg;
        this.plantingDate = plantingDate;
        this.landArea = landArea;
        this.dateManualWeeding = dateManualWeeding;
        this.posContact = posContact;
        this.monthSellingStarts = monthSellingStarts;
        this.monthFinalProductSold = monthFinalProductSold;
    }



    /*public String getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(String farmerId) {
        this.farmerId = farmerId;
    }*/
    public Farmer(){

    }
    public Farmer(String firstName, String lastName, String nickname, String community, String village, String district, String region, String age, String gender, String maritalStatus, String numberOfChildren, String numberOfDependants, String education) {
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

    public Farmer(String firstName, String lastName, String nickname, String community, String village, String district, String region, String age, String gender, String maritalStatus, String numberOfChildren, String numberOfDependants, String education, String cluster, String farmID) {
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

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getSubcounty() {
        return subcounty;
    }

    public void setSubcounty(String subcounty) {
        this.subcounty = subcounty;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
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
    @Override
    public String toString(){
        return getFirstName() + " " + getLastName();
    }

    public String getSizePlot() {
        return sizePlot;
    }

    public void setSizePlot(String sizePlot) {
        this.sizePlot = sizePlot;
    }

    public String getLabour() {
        return labour;
    }

    public void setLabour(String labour) {
        this.labour = labour;
    }

    public String getDateOfLandIdentification() {
        return dateOfLandIdentification;
    }

    public void setDateOfLandIdentification(String dateOfLandIdentification) {
        this.dateOfLandIdentification = dateOfLandIdentification;
    }

    public String getLocationOfLand() {
        return locationOfLand;
    }

    public void setLocationOfLand(String locationOfLand) {
        this.locationOfLand = locationOfLand;
    }

    public String getTargetArea() {
        return targetArea;
    }

    public void setTargetArea(String targetArea) {
        this.targetArea = targetArea;
    }

    public String getExpectedPriceInTon() {
        return expectedPriceInTon;
    }

    public void setExpectedPriceInTon(String expectedPriceInTon) {
        this.expectedPriceInTon = expectedPriceInTon;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getTargetNextSeason() {
        return targetNextSeason;
    }

    public void setTargetNextSeason(String targetNextSeason) {
        this.targetNextSeason = targetNextSeason;
    }

    public String getTechNeeds1() {
        return techNeeds1;
    }

    public void setTechNeeds1(String techNeeds1) {
        this.techNeeds1 = techNeeds1;
    }

    public String getTechNeeds2() {
        return techNeeds2;
    }

    public void setTechNeeds2(String techNeeds2) {
        this.techNeeds2 = techNeeds2;
    }

    public String getFarmerBasedOrg() {
        return farmerBasedOrg;
    }

    public void setFarmerBasedOrg(String farmerBasedOrg) {
        this.farmerBasedOrg = farmerBasedOrg;
    }

    public String getPlantingDate() {
        return plantingDate;
    }

    public void setPlantingDate(String plantingDate) {
        this.plantingDate = plantingDate;
    }

    public String getLandArea() {
        return landArea;
    }

    public void setLandArea(String landArea) {
        this.landArea = landArea;
    }

    public String getDateManualWeeding() {
        return dateManualWeeding;
    }

    public void setDateManualWeeding(String dateManualWeeding) {
        this.dateManualWeeding = dateManualWeeding;
    }

    public String getPosContact() {
        return posContact;
    }

    public void setPosContact(String posContact) {
        this.posContact = posContact;
    }

    public String getMonthSellingStarts() {
        return monthSellingStarts;
    }

    public void setMonthSellingStarts(String monthSellingStarts) {
        this.monthSellingStarts = monthSellingStarts;
    }

    public String getMonthFinalProductSold() {
        return monthFinalProductSold;
    }

    public void setMonthFinalProductSold(String monthFinalProductSold) {
        this.monthFinalProductSold = monthFinalProductSold;
    }
}
