/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.wrapper;

import com.grameenfoundation.ictc.domain.commons.GeneralInterface;
import com.grameenfoundation.ictc.domain.commons.Status;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Joseph George Davis
 * @date Sep 23, 2015 2:39:03 PM
 * description:
 */
public class ProductionNewWrapper  
{
    
     String acresofland="acresofland";
     String applicationmonthofherbicidedate="applicationmonthofherbicidedate";
     String applicationofbasalfertilizer="applicationofbasalfertilizer";
     String applicationofbasalfertilizerdate="applicationofbasalfertilizerdate";
     String applicationoftopdressfertilizer="applicationoftopdressfertilizer";
     String datefifthpostgemweedcontrol="datefifthpostgemweedcontrol";
     String datefirstmanualweedcontrol="datefirstmanualweedcontrol";
     String datefourthpostgemweedcontrol="datefourthpostgemweedcontrol";
     String dateofsecondmanualweedcontrol="dateofsecondmanualweedcontrol";
     String datethirdmanualweedcontrol="datethirdmanualweedcontrol";
     String landclearingdate="landclearingdate";
     String methodofbasalfertilizerapplication="methodofbasalfertilizerapplication";
     String methodofbasalfertilizerapplicationother="methodofbasalfertilizerapplicationother";
     String methodoflandclearing="methodoflandclearing";
     String methodoflandpreparation="methodoflandpreparation";
     String methodtopdressfertilizerapp="methodtopdressfertilizerapp";
     String nameofcropvariety="nameofcropvariety";
     String nameofcropvarietycassava="nameofcropvarietycassava";
     String nameofcropvarietyrice="nameofcropvarietyrice";
     String nameofcropvarietyyam="nameofcropvarietyyam";
     String nameofvarietynotinlist="nameofvarietynotinlist";
     String numberofocassionsmanualweedcontrol="numberofocassionsmanualweedcontrol";
     String otherfertilizer="otherfertilizer";
     String plantingdate="plantingdate";
     String plantingdistancebetweenplantsmaize="plantingdistancebetweenplantsmaize";
     String plantingdistancebetweenplantsmaizeyc="plantingdistancebetweenplantsmaizeyc";
     String plantingdistancebetweenplantsrice="plantingdistancebetweenplantsrice";
     String plantingdistancebetweenrowsmaize="plantingdistancebetweenrowsmaize";
     String plantingdistancebetweenrowsrice="plantingdistancebetweenrowsrice";
     String plantingdistancebetweenrowsyc="plantingdistancebetweenrowsyc";
     String ploughingdate="ploughingdate";
     String postplantherbicideuse="postplantherbicideuse";
     String quantityofbasalfertilizerpurchasedapply="quantityofbasalfertilizerpurchasedapply";
     String quantityoftopdresserfertilizerpurchased="quantityoftopdresserfertilizerpurchased";
     String quantitypostplantherbicide="quantitypostplantherbicide";
     String refillinggapsoccurence="refillinggapsoccurence";
     String refillinggapsproportion="refillinggapsproportion";
     String seedbedformtype="seedbedformtype";
     String seedbedpreparationdate="seedbedpreparationdate";
     String sourceofseedorplantingmaterial="sourceofseedorplantingmaterial";
     String sourceofseedorplantingmaterialother="sourceofseedorplantingmaterialother";
     String targetyieldperacre="targetyieldperacre";
     String timeofapplicationtopdressing="timeofapplicationtopdressing";
     String timeofharvest="timeofharvest";
     String topdressfertilizerother="topdressfertilizerother";
     String typeofbasalfertilizer="typeofbasalfertilizer";
     String typeoffertilizertopdressing="typeoffertilizertopdressing";
     String typeofherbicidepostplantweed="typeofherbicidepostplantweed";
     String Expected_produce_sale_proportion="expected_produce_sale_proportion";
     String Expected_revenue_from_sale="expected_revenue_from_sale";
     String crop_to_cultivate_current="crop_to_cultivate_current";
     String date_postplant_herb_second_current="date_postplant_herb_second_current";
     String date_postplant_herb_third_current="date_postplant_herb_third_current";
     String nameoflocalvariety="nameoflocalvariety";
     String qtyofpreplantherbicide="qtyofpreplantherbicide";
     String reference_season_current="reference_season_current";
     String reference_year_current="reference_year_current";
     String Name_of_hybrid_variety="name_of_hybrid_variety";
     String landhistorycurrent="landhistorycurrent";
    String localcropvarietycassava="localcropvarietycassava";
    String localcropvarietyrice="localcropvarietyrice";
    String localcropvarietyyam="localcropvarietyyam";
    String organicfertilizerapplicationcurrent="organicfertilizerapplicationcurrent";
    String organicfertilizerdatecurrent="organicfertilizerdatecurrent";
    String organicresiduecurrent="organicresiduecurrent";
     
    public  void setOrganicresiduecurrent(String organicresiduecurrent) {
      this.organicresiduecurrent=organicresiduecurrent;
    }
 public  String getOrganicresiduecurrent() {
        return organicresiduecurrent;

    }
 public  void setOrganicfertilizerdatecurrent(String organicfertilizerdatecurrent) {
      this.organicfertilizerdatecurrent=organicfertilizerdatecurrent;
    }
 public  String getOrganicfertilizerdatecurrent() {
        return organicfertilizerdatecurrent;

    }
    
 public  void setOrganicfertilizerapplicationcurrent(String organicfertilizerapplicationcurrent) {
      this.organicfertilizerapplicationcurrent=organicfertilizerapplicationcurrent;
    }
 public  String getOrganicfertilizerapplicationcurrent() {
        return organicfertilizerapplicationcurrent;

    }
    
 public  void setLocalcropvarietyyam(String localcropvarietyyam) {
      this.localcropvarietyyam=localcropvarietyyam;
    }
 public  String getLocalcropvarietyyam() {
        return localcropvarietyyam;

    }
    
 public  void setLocalcropvarietyrice(String localcropvarietyrice) {
      this.localcropvarietyrice=localcropvarietyrice;
    }
 public  String getLocalcropvarietyrice() {
        return localcropvarietyrice;

    }
    
 public  void setLocalcropvarietycassava(String localcropvarietycassava) {
      this.localcropvarietycassava=localcropvarietycassava;
    }
 public  String getLocalcropvarietycassava() {
        return localcropvarietycassava;

    }
    
 public  void setLandhistorycurrent(String landhistorycurrent) {
      this.landhistorycurrent=landhistorycurrent;
    }
 public  String getLandhistorycurrent() {
        return landhistorycurrent;

    }
    
    
 public  void setName_of_hybrid_variety(String Name_of_hybrid_variety) {
      this.Name_of_hybrid_variety=Name_of_hybrid_variety;
    }
 public  String getName_of_hybrid_variety() {
        return Name_of_hybrid_variety;

    }
     
 public  void setReference_year_current(String reference_year_current) {
      this.reference_year_current=reference_year_current;
    }
 public  String getReference_year_current() {
        return reference_year_current;

    }
     
 public  void setReference_season_current(String reference_season_current) {
      this.reference_season_current=reference_season_current;
    }
 public  String getReference_season_current() {
        return reference_season_current;

    }
     
 public  void setQtyofpreplantherbicide(String qtyofpreplantherbicide) {
      this.qtyofpreplantherbicide=qtyofpreplantherbicide;
    }
 public  String getQtyofpreplantherbicide() {
        return qtyofpreplantherbicide;

    }
     
 public  void setNameoflocalvariety(String nameoflocalvariety) {
      this.nameoflocalvariety=nameoflocalvariety;
    }
 public  String getNameoflocalvariety() {
        return nameoflocalvariety;

    }
     
     
 public  void setDate_postplant_herb_third_current(String date_postplant_herb_third_current) {
      this.date_postplant_herb_third_current=date_postplant_herb_third_current;
    }
 public  String getDate_postplant_herb_third_current() {
        return date_postplant_herb_third_current;

    }
     
 public  void setDate_postplant_herb_second_current(String date_postplant_herb_second_current) {
      this.date_postplant_herb_second_current=date_postplant_herb_second_current;
    }
 public  String getDate_postplant_herb_second_current() {
        return date_postplant_herb_second_current;

    }
     
 public  void setCrop_to_cultivate_current(String crop_to_cultivate_current) {
      this.crop_to_cultivate_current=crop_to_cultivate_current;
    }
 public  String getCrop_to_cultivate_current() {
        return crop_to_cultivate_current;

    }
     
 public  void setExpected_revenue_from_sale(String Expected_revenue_from_sale) {
      this.Expected_revenue_from_sale=Expected_revenue_from_sale;
    }
 public  String getExpected_revenue_from_sale() {
        return Expected_revenue_from_sale;

    }
     



 public  void setExpected_produce_sale_proportion(String Expected_produce_sale_proportion) {
      this.Expected_produce_sale_proportion=Expected_produce_sale_proportion;
    }
 public  String getExpected_produce_sale_proportion() {
        return Expected_produce_sale_proportion;

    }

     
     
 public  void setTypeofherbicidepostplantweed(String typeofherbicidepostplantweed) {
      this.typeofherbicidepostplantweed=typeofherbicidepostplantweed;
    }
 public  String getTypeofherbicidepostplantweed() {
        return typeofherbicidepostplantweed;

    }
     
     
 public  void setTypeoffertilizertopdressing(String typeoffertilizertopdressing) {
      this.typeoffertilizertopdressing=typeoffertilizertopdressing;
    }
 public  String getTypeoffertilizertopdressing() {
        return typeoffertilizertopdressing;

    }
     
     
 public  void setTypeofbasalfertilizer(String typeofbasalfertilizer) {
      this.typeofbasalfertilizer=typeofbasalfertilizer;
    }
 public  String getTypeofbasalfertilizer() {
        return typeofbasalfertilizer;

    }
     
     
 public  void setTopdressfertilizerother(String topdressfertilizerother) {
      this.topdressfertilizerother=topdressfertilizerother;
    }
 public  String getTopdressfertilizerother() {
        return topdressfertilizerother;

    }
     
 public  void setTimeofharvest(String timeofharvest) {
      this.timeofharvest=timeofharvest;
    }
 public  String getTimeofharvest() {
        return timeofharvest;

    }
     
     
 public  void setTimeofapplicationtopdressing(String timeofapplicationtopdressing) {
      this.timeofapplicationtopdressing=timeofapplicationtopdressing;
    }
 public  String getTimeofapplicationtopdressing() {
        return timeofapplicationtopdressing;

    }
     
     
 public  void setTargetyieldperacre(String targetyieldperacre) {
      this.targetyieldperacre=targetyieldperacre;
    }
 public  String getTargetyieldperacre() {
        return targetyieldperacre;

    }
     
     
 public  void setSourceofseedorplantingmaterialother(String sourceofseedorplantingmaterialother) {
      this.sourceofseedorplantingmaterialother=sourceofseedorplantingmaterialother;
    }
 public  String getSourceofseedorplantingmaterialother() {
        return sourceofseedorplantingmaterialother;

    }
     
     
 public  void setSourceofseedorplantingmaterial(String sourceofseedorplantingmaterial) {
      this.sourceofseedorplantingmaterial=sourceofseedorplantingmaterial;
    }
 public  String getSourceofseedorplantingmaterial() {
        return sourceofseedorplantingmaterial;

    }
     
     
 public  void setSeedbedpreparationdate(String seedbedpreparationdate) {
      this.seedbedpreparationdate=seedbedpreparationdate;
    }
 public  String getSeedbedpreparationdate() {
        return seedbedpreparationdate;

    }
     
 public  void setSeedbedformtype(String seedbedformtype) {
      this.seedbedformtype=seedbedformtype;
    }
 public  String getSeedbedformtype() {
        return seedbedformtype;

    }
     
 public  void setRefillinggapsproportion(String refillinggapsproportion) {
      this.refillinggapsproportion=refillinggapsproportion;
    }
 public  String getRefillinggapsproportion() {
        return refillinggapsproportion;

    }
     
     
 public  void setRefillinggapsoccurence(String refillinggapsoccurence) {
      this.refillinggapsoccurence=refillinggapsoccurence;
    }
 public  String getRefillinggapsoccurence() {
        return refillinggapsoccurence;

    }
     
 public  void setQuantitypostplantherbicide(String quantitypostplantherbicide) {
      this.quantitypostplantherbicide=quantitypostplantherbicide;
    }
 public  String getQuantitypostplantherbicide() {
        return quantitypostplantherbicide;

    }
     
 public  void setQuantityoftopdresserfertilizerpurchased(String quantityoftopdresserfertilizerpurchased) {
      this.quantityoftopdresserfertilizerpurchased=quantityoftopdresserfertilizerpurchased;
    }
 public  String getQuantityoftopdresserfertilizerpurchased() {
        return quantityoftopdresserfertilizerpurchased;

    }
     
 public  void setQuantityofbasalfertilizerpurchasedapply(String quantityofbasalfertilizerpurchasedapply) {
      this.quantityofbasalfertilizerpurchasedapply=quantityofbasalfertilizerpurchasedapply;
    }
 public  String getQuantityofbasalfertilizerpurchasedapply() {
        return quantityofbasalfertilizerpurchasedapply;

    }
     
 public  void setPostplantherbicideuse(String postplantherbicideuse) {
      this.postplantherbicideuse=postplantherbicideuse;
    }
 public  String getPostplantherbicideuse() {
        return postplantherbicideuse;

    }
     
     
 public  void setPloughingdate(String ploughingdate) {
      this.ploughingdate=ploughingdate;
    }
 public  String getPloughingdate() {
        return ploughingdate;

    }
     
 public  void setPlantingdistancebetweenrowsyc(String plantingdistancebetweenrowsyc) {
      this.plantingdistancebetweenrowsyc=plantingdistancebetweenrowsyc;
    }
 public  String getPlantingdistancebetweenrowsyc() {
        return plantingdistancebetweenrowsyc;

    }
     
      public  void setPlantingdistancebetweenrowsrice(String plantingdistancebetweenrowsrice) {
      this.plantingdistancebetweenrowsrice=plantingdistancebetweenrowsrice;
    }
 public  String getPlantingdistancebetweenrowsrice() {
        return plantingdistancebetweenrowsrice;

    }
     
     
 public  void setPlantingdistancebetweenrowsmaize(String plantingdistancebetweenrowsmaize) {
      this.plantingdistancebetweenrowsmaize=plantingdistancebetweenrowsmaize;
    }
 public  String getPlantingdistancebetweenrowsmaize() {
        return plantingdistancebetweenrowsmaize;

    }
     
     
 public  void setPlantingdistancebetweenplantsrice(String plantingdistancebetweenplantsrice) {
      this.plantingdistancebetweenplantsrice=plantingdistancebetweenplantsrice;
    }
 public  String getPlantingdistancebetweenplantsrice() {
        return plantingdistancebetweenplantsrice;

    }
     
 public  void setPlantingdistancebetweenplantsmaizeyc(String plantingdistancebetweenplantsmaizeyc) {
      this.plantingdistancebetweenplantsmaizeyc=plantingdistancebetweenplantsmaizeyc;
    }
 public  String getPlantingdistancebetweenplantsmaizeyc() {
        return plantingdistancebetweenplantsmaizeyc;

    }
     
     
 public  void setPlantingdistancebetweenplantsmaize(String plantingdistancebetweenplantsmaize) {
      this.plantingdistancebetweenplantsmaize=plantingdistancebetweenplantsmaize;
    }
 public  String getPlantingdistancebetweenplantsmaize() {
        return plantingdistancebetweenplantsmaize;

    }
     
 public  void setPlantingdate(String plantingdate) {
      this.plantingdate=plantingdate;
    }
 public  String getPlantingdate() {
        return plantingdate;

    }
     
     
 public  void setOtherfertilizer(String otherfertilizer) {
      this.otherfertilizer=otherfertilizer;
    }
 public  String getOtherfertilizer() {
        return otherfertilizer;

    }
     
     
 public  void setNumberofocassionsmanualweedcontrol(String numberofocassionsmanualweedcontrol) {
      this.numberofocassionsmanualweedcontrol=numberofocassionsmanualweedcontrol;
    }
 public  String getNumberofocassionsmanualweedcontrol() {
        return numberofocassionsmanualweedcontrol;

    }
     
 public  void setNameofvarietynotinlist(String nameofvarietynotinlist) {
      this.nameofvarietynotinlist=nameofvarietynotinlist;
    }
 public  String getNameofvarietynotinlist() {
        return nameofvarietynotinlist;

    }
     
 public  void setNameofcropvarietyyam(String nameofcropvarietyyam) {
      this.nameofcropvarietyyam=nameofcropvarietyyam;
    }
 public  String getNameofcropvarietyyam() {
        return nameofcropvarietyyam;

    }
     
     
 public  void setNameofcropvarietyrice(String nameofcropvarietyrice) {
      this.nameofcropvarietyrice=nameofcropvarietyrice;
    }
 public  String getNameofcropvarietyrice() {
        return nameofcropvarietyrice;

    }
     
     
 public  void setNameofcropvarietycassava(String nameofcropvarietycassava) {
      this.nameofcropvarietycassava=nameofcropvarietycassava;
    }
 public  String getNameofcropvarietycassava() {
        return nameofcropvarietycassava;

    }
 public  void setNameofcropvariety(String nameofcropvariety) {
      this.nameofcropvariety=nameofcropvariety;
    }
 public  String getNameofcropvariety() {
        return nameofcropvariety;

    }
     
 public  void setMethodtopdressfertilizerapp(String methodtopdressfertilizerapp) {
      this.methodtopdressfertilizerapp=methodtopdressfertilizerapp;
    }
 public  String getMethodtopdressfertilizerapp() {
        return methodtopdressfertilizerapp;

    }
     
     
 public  void setMethodoflandpreparation(String methodoflandpreparation) {
      this.methodoflandpreparation=methodoflandpreparation;
    }
 public  String getMethodoflandpreparation() {
        return methodoflandpreparation;

    }
     
 public  void setMethodoflandclearing(String methodoflandclearing) {
      this.methodoflandclearing=methodoflandclearing;
    }
 public  String getMethodoflandclearing() {
        return methodoflandclearing;

    }
     
 public  void setMethodofbasalfertilizerapplicationother(String methodofbasalfertilizerapplicationother) {
      this.methodofbasalfertilizerapplicationother=methodofbasalfertilizerapplicationother;
    }
 public  String getMethodofbasalfertilizerapplicationother() {
        return methodofbasalfertilizerapplicationother;

    }
     
     
 public  void setMethodofbasalfertilizerapplication(String methodofbasalfertilizerapplication) {
      this.methodofbasalfertilizerapplication=methodofbasalfertilizerapplication;
    }
 public  String getMethodofbasalfertilizerapplication() {
        return methodofbasalfertilizerapplication;

    }
     
     
 public  void setLandclearingdate(String landclearingdate) {
      this.landclearingdate=landclearingdate;
    }
 public  String getLandclearingdate() {
        return landclearingdate;

    }
     
 public  void setDatethirdmanualweedcontrol(String datethirdmanualweedcontrol) {
      this.datethirdmanualweedcontrol=datethirdmanualweedcontrol;
    }
 public  String getDatethirdmanualweedcontrol() {
        return datethirdmanualweedcontrol;

    }
     
     
     
 public  void setDateofsecondmanualweedcontrol(String dateofsecondmanualweedcontrol) {
      this.dateofsecondmanualweedcontrol=dateofsecondmanualweedcontrol;
    }
 public  String getDateofsecondmanualweedcontrol() {
        return dateofsecondmanualweedcontrol;

    }
     
     
 public  void setDatefourthpostgemweedcontrol(String datefourthpostgemweedcontrol) {
      this.datefourthpostgemweedcontrol=datefourthpostgemweedcontrol;
    }
 public  String getDatefourthpostgemweedcontrol() {
        return datefourthpostgemweedcontrol;

    }
     
 public  void setDatefirstmanualweedcontrol(String datefirstmanualweedcontrol) {
      this.datefirstmanualweedcontrol=datefirstmanualweedcontrol;
    }
 public  String getDatefirstmanualweedcontrol() {
        return datefirstmanualweedcontrol;

    }
     
     
 public  void setDatefifthpostgemweedcontrol(String datefifthpostgemweedcontrol) {
      this.datefifthpostgemweedcontrol=datefifthpostgemweedcontrol;
    }
 public  String getDatefifthpostgemweedcontrol() {
        return datefifthpostgemweedcontrol;

    }
     
     
 public  void setApplicationoftopdressfertilizer(String applicationoftopdressfertilizer) {
      this.applicationoftopdressfertilizer=applicationoftopdressfertilizer;
    }
 public  String getApplicationoftopdressfertilizer() {
        return applicationoftopdressfertilizer;

    }
     
     
 public  void setApplicationofbasalfertilizerdate(String applicationofbasalfertilizerdate) {
      this.applicationofbasalfertilizerdate=applicationofbasalfertilizerdate;
    }
 public  String getApplicationofbasalfertilizerdate() {
        return applicationofbasalfertilizerdate;

    }
     
     
     
 public  void setApplicationofbasalfertilizer(String applicationofbasalfertilizer) {
      this.applicationofbasalfertilizer=applicationofbasalfertilizer;
    }
 public  String getApplicationofbasalfertilizer() {
        return applicationofbasalfertilizer;

    }
     
     
     
 public  void setApplicationmonthofherbicidedate(String applicationmonthofherbicidedate) {
      this.applicationmonthofherbicidedate=applicationmonthofherbicidedate;
    }
 public  String getApplicationmonthofherbicidedate() {
        return applicationmonthofherbicidedate;

    }
    
    
 public  void setAcresofland(String acresofland) {
      this.acresofland=acresofland;
    }
 public  String getAcresofland() {
        return acresofland;

    }
    
    
}
