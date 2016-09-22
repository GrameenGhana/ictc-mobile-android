/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.utils;

import com.grameenfoundation.ictc.models.BiodataModel;
import java.util.logging.Logger;

/**
 *
 * @author Joseph George Davis
 * @date Sep 20, 2016 11:56:12 AM
 * description:
 */
public class TempReport {
    
      Logger log = Logger.getLogger(TempReport.class.getName());
      BiodataModel bio = new BiodataModel();
      
      
   public static Object getImprovedSeedACDIVOCA()
    {
       
        String q = "match (n:AGENT) where n.agenttype ='ACDIVOCA' WITH n match (f:FARMER)-[HAS_PRODUCTION_UPDATE]-(u) where f.CreatedById=n.Id return SUM(CASE u.nameofvarietymz WHEN NULL THEN 0  "
                + " WHEN \"local variety\" THEN 0 WHEN \"other\" THEN 0 ELSE 1 END) +"
                + " SUM(CASE u.nameofhybridmz WHEN NULL THEN 0    WHEN \"local variety\" THEN 0  WHEN \"other\" THEN 0 ELSE 1 END)+"
                + "SUM(CASE u.nameofvarietyrice WHEN NULL THEN 0 WHEN \"local variety\" THEN 0  WHEN \"other\" THEN 0 ELSE 1 END) as l"; 
        
        return Neo4jServices.getAggregateItem(q);
    }
   
   public static Object getCropDensityACDIVOCA()
   {
        String q = "match (n:AGENT) where n.agenttype = 'ACDIVOCA' WITH n match (f:FARMER)-[HAS_PRODUCTION_UPDATE]-(u) where f.CreatedById=n.Id return "
                + "SUM(CASE u.croparrangeupdate WHEN NULL THEN 0 "
                + "WHEN \"Arranged rows with specific ditance between rows and also between plants\" THEN 1  END)  as l"; 
        
        return Neo4jServices.getAggregateItem(q); 
   }
   
   public static Object getPrePlantHerbiceideACDIVOCA()
   {
       String q = "match (n:AGENT) where n.agenttype ='ACDIVOCA' WITH n match (f:FARMER)-[HAS_PRODUCTION_UPDATE]-(u) where f.CreatedById=n.Id return "
               + "SUM(CASE u.methodoflandclearing WHEN NULL THEN 0"
               + " WHEN \"Slashing and application of herbicide\" THEN 1 WHEN \"Herbicide application\" THEN 1  END)  as l"; 
        
        return Neo4jServices.getAggregateItem(q); 
   }
   
    public static Object getPostPlantHerbiceideACDIVOCA()
   {
       String q = "match (n:AGENT) where n.agenttype =~ 'ACDIVOCA' WITH n match (f:FARMER)-[:HAS_PRODUCTION_UPDATE]->(u)"
               + " where f.CreatedById=n.Id return SUM(CASE u.postplantherbicidefrequency WHEN NULL THEN 0"
               + "   WHEN '0' THEN 0 ELSE 1  END)  as l"; 
        
        return Neo4jServices.getAggregateItem(q); 
   }

     public static Object getOrganicFertilizerACDIVOCA()
   {
       String q = "match (n:AGENT) where n.agenttype =~ 'ACDIVOCA' WITH n match (f:FARMER)-[:HAS_PRODUCTION_UPDATE]->(u) "
               + "where f.CreatedById=n.Id return SUM(CASE u.applicationofbasalfertilizer WHEN NULL THEN 0 WHEN 'NO' THEN 0 ELSE 1  END) + "
               + "SUM(CASE u.applicationoftopdressfertilizer WHEN NULL THEN 0 WHEN 'NO' THEN 0 ELSE 1  END)  as l"; 
        
        return Neo4jServices.getAggregateItem(q); 
   }
     
       public static Object getPostHarvestThresherACDIVOCA()
   {
       String q = "match (n:AGENT) where n.agenttype =~ 'ACDIVOCA' WITH n match (f:FARMER)-[:HAS_PRODUCTION_UPDATE]->(u) "
               + "where f.CreatedById=n.Id return SUM(CASE u.applicationofbasalfertilizer WHEN NULL THEN 0 "
               + "WHEN 'NO' THEN 0 ELSE 1  END) + SUM(CASE u.applicationoftopdressfertilizer WHEN NULL THEN 0 WHEN 'NO' THEN 0 ELSE 1  END)  as l"; 
        
        return Neo4jServices.getAggregateItem(q); 
   }
     
    public static Long getImprovedTechnologies()
    {
        long sum = Long.valueOf((long) getCropDensityACDIVOCA())+Long.valueOf((long) getImprovedSeedACDIVOCA() +Long.valueOf((long) getOrganicFertilizerACDIVOCA()))
                   +Long.valueOf((long) getPostHarvestThresherACDIVOCA())+ Long.valueOf((long) getPostPlantHerbiceideACDIVOCA()+Long.valueOf((long) getPrePlantHerbiceideACDIVOCA()));
        return sum;
    }
    
    public double getFarmerRegistrationProgressForACDI()
    {
        return (bio.getACDIVOCAFarmerCount()/ICTCKonstants.ACDIVOCA_TARGET)*100;
    }
    
    public double getFarmerPPProgressForACDI()
    {
        return (bio.getACDIVOCABaselineProductionCount()/ICTCKonstants.ACDIVOCA_TARGET)*100;
    }
    
    public double getFarmerPHProgressForACDI()
    {
        return (bio.getACDIVOCABaselinePostHarvestCount()/ICTCKonstants.ACDIVOCA_TARGET)*100;
    }
    
     public double getFarmerCRProgressForACDI()
    {
        return (bio.getACDIVOCAFarmCreditPreviousCount()/ICTCKonstants.ACDIVOCA_TARGET)*100;
    }
     
     
    public double getFarmerFMPPProgressForACDI()
    {
       return (bio.getACDIVOCAFMPProductionCount()/ICTCKonstants.ACDIVOCA_TARGET)*100;
    }
    
     public double getFarmerFMPPHProgressForACDI()
    {
       return (bio.getACDIVOCAFMPPostHarvestCount()/ICTCKonstants.ACDIVOCA_TARGET)*100;
    }
     
     public double getFarmerFCPPHProgressForACDI()
    {
       return (bio.getACDIVOCAFFarmCreditPlanCount()/ICTCKonstants.ACDIVOCA_TARGET)*100;
    } 
     public double getFarmerPUProgressForACDI()
    {
       return (bio.getACDIVOCAFFMPProductionUpdateCount()/ICTCKonstants.ACDIVOCA_TARGET)*100;
    } 
     
    public double getFarmerFCAProgressForACDI()
    {
       return (bio.getACDIVOCAFCPCount()/ICTCKonstants.ACDIVOCA_TARGET)*100;
    } 
     
     public double getFarmerPHUProgressForACDI()
    {
       return (bio.getACDIVOCAPostHarvestUpdateCount()/ICTCKonstants.ACDIVOCA_TARGET)*100;
    } 
     
     
      public double getFarmerFCUProgressForACDI()
    {
       return (bio.getACDIVOCAFarmCreditUpdateCount()/ICTCKonstants.ACDIVOCA_TARGET)*100;
    } 
     
     
}
