/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grameenfoundation.ictc.utils;

import com.grameenfoundation.ictc.models.BiodataModel;
import java.text.DecimalFormat;
import java.util.logging.Logger;

/**
 *
 * @author Joseph George Davis
 * @date Sep 20, 2016 11:56:12 AM
 * description:
 */
public class TempReport extends BIUtil{
    
      Logger log = Logger.getLogger(TempReport.class.getName());
      BiodataModel bio = new BiodataModel();
      
 //<editor-fold defaultstate="collapsed" desc="ACDIVOCA Dashboard ">    
   public static Object getImprovedSeed(String partner)
    {
       
        String q = "match (n:AGENT) where n.agenttype ='"+partner+"' WITH n match (f:FARMER)-[:HAS_PRODUCTION_UPDATE]->(u) where f.CreatedById=n.Id return SUM(CASE u.nameofvarietymz WHEN NULL THEN 0  "
                + " WHEN \"local variety\" THEN 0 WHEN \"other\" THEN 0 ELSE 1 END) +"
                + " SUM(CASE u.nameofhybridmz WHEN NULL THEN 0    WHEN \"local variety\" THEN 0  WHEN \"other\" THEN 0 ELSE 1 END)+"
                + "SUM(CASE u.nameofvarietyrice WHEN NULL THEN 0 WHEN \"local variety\" THEN 0  WHEN \"other\" THEN 0 ELSE 1 END) as l"; 
        
        return Neo4jServices.getAggregateItem(q);
    }
   
   public static Object getCropDensity(String partner)
   {
        String q = "match (n:AGENT) where n.agenttype ='"+partner+"' WITH n match (f:FARMER)-[:HAS_PRODUCTION_UPDATE]->(u) where f.CreatedById=n.Id return "
                + "SUM(CASE u.croparrangeupdate WHEN NULL THEN 0 "
                + "WHEN \"Arranged rows with specific ditance between rows and also between plants\" THEN 1  END)  as l"; 
        
        return Neo4jServices.getAggregateItem(q); 
   }
   
   public static Object getPrePlantHerbiceide(String partner)
   {
       String q = "match (n:AGENT) where n.agenttype ='"+partner+"' WITH n match (f:FARMER)-[:HAS_PRODUCTION_UPDATE]->(u) where f.CreatedById=n.Id return "
               + "SUM(CASE u.methodoflandclearing WHEN NULL THEN 0"
               + " WHEN \"Slashing and application of herbicide\" THEN 1 WHEN \"Herbicide application\" THEN 1  END)  as l"; 
        
        return Neo4jServices.getAggregateItem(q); 
   }
   
    public static Object getPostPlantHerbiceide(String partner)
   {
       String q = "match (n:AGENT) where n.agenttype ='"+partner+"' WITH n match (f:FARMER)-[:HAS_PRODUCTION_UPDATE]->(u)"
               + " where f.CreatedById=n.Id return SUM(CASE u.postplantherbicidefrequency WHEN NULL THEN 0"
               + "   WHEN '0' THEN 0 ELSE 1  END)  as l"; 
        
        return Neo4jServices.getAggregateItem(q); 
   }

     public static Object getOrganicFertilizer(String partner)
   {
       String q = "match (n:AGENT) where n.agenttype ='"+partner+"' WITH n match (f:FARMER)-[:HAS_PRODUCTION_UPDATE]->(u) "
               + "where f.CreatedById=n.Id return SUM(CASE u.applicationofbasalfertilizer WHEN NULL THEN 0 WHEN 'NO' THEN 0 ELSE 1  END) + "
               + "SUM(CASE u.applicationoftopdressfertilizer WHEN NULL THEN 0 WHEN 'NO' THEN 0 ELSE 1  END)  as l"; 
        
        return Neo4jServices.getAggregateItem(q); 
   }
     
       public static Object getPostHarvestThresher(String partner)
   {
       String q = "match (n:AGENT) where n.agenttype ='"+partner+"' WITH n match (f:FARMER)-[:HAS_PRODUCTION_UPDATE]->(u) "
               + "where f.CreatedById=n.Id return SUM(CASE u.applicationofbasalfertilizer WHEN NULL THEN 0 "
               + "WHEN 'NO' THEN 0 ELSE 1  END) + SUM(CASE u.applicationoftopdressfertilizer WHEN NULL THEN 0 WHEN 'NO' THEN 0 ELSE 1  END)  as l"; 
        
        return Neo4jServices.getAggregateItem(q); 
   }
     
    public static Long getImprovedTechnologies(String partner)
    {
        long sum = Long.valueOf((long)getCropDensity(partner))+Long.valueOf((long) getImprovedSeed(partner) +Long.valueOf((long) getOrganicFertilizer(partner)))
                   +Long.valueOf((long) getPostHarvestThresher(partner))+ Long.valueOf((long) getPostPlantHerbiceide(partner)+Long.valueOf((long) getPrePlantHerbiceide(partner)));
        return sum;
    }
    
    public String getFarmerRegistrationProgressForACDI()
    {
        return toTwoDecimalPlaces((bio.getACDIVOCAFarmerCount()/ICTCKonstants.ACDIVOCA_TARGET)*100);
    }
    
    public String getFarmerPPProgressForACDI()
    {
        return toTwoDecimalPlaces((bio.getACDIVOCABaselineProductionCount()/ICTCKonstants.ACDIVOCA_TARGET)*100);
    }
    
    public String getFarmerPHProgressForACDI()
    {
        return toTwoDecimalPlaces((bio.getACDIVOCABaselinePostHarvestCount()/ICTCKonstants.ACDIVOCA_TARGET)*100);
    }
    
     public String getFarmerCRProgressForACDI()
    {
        return toTwoDecimalPlaces((bio.getACDIVOCAFarmCreditPreviousCount()/ICTCKonstants.ACDIVOCA_TARGET)*100);
    }
     
     
    public String getFarmerFMPPProgressForACDI()
    {
       return toTwoDecimalPlaces((bio.getACDIVOCAFMPProductionCount()/ICTCKonstants.ACDIVOCA_TARGET)*100);
    }
    
     public String getFarmerFMPPHProgressForACDI()
    {
       return toTwoDecimalPlaces((bio.getACDIVOCAFMPPostHarvestCount()/ICTCKonstants.ACDIVOCA_TARGET)*100);
    }
     
     public String getFarmerFCPPHProgressForACDI()
    {
       return toTwoDecimalPlaces((bio.getACDIVOCAFFarmCreditPlanCount()/ICTCKonstants.ACDIVOCA_TARGET)*100);
    } 
     public String getFarmerPUProgressForACDI()
    {
       return toTwoDecimalPlaces((bio.getACDIVOCAFFMPProductionUpdateCount()/ICTCKonstants.ACDIVOCA_TARGET)*100);
    } 
     
    public String getFarmerFCAProgressForACDI()
    {
       return toTwoDecimalPlaces((bio.getACDIVOCAFCPCount()/ICTCKonstants.ACDIVOCA_TARGET)*100);
    } 
     
     public String getFarmerPHUProgressForACDI()
    {
       return toTwoDecimalPlaces((bio.getACDIVOCAPostHarvestUpdateCount()/ICTCKonstants.ACDIVOCA_TARGET)*100);
    } 
     
     
      public String getFarmerFCUProgressForACDI()
    {
       return toTwoDecimalPlaces((bio.getACDIVOCAFarmCreditUpdateCount()/ICTCKonstants.ACDIVOCA_TARGET)*100);
    } 
     //</editor-fold>
      
 //<editor-fold defaultstate="collapsed" desc="GF Dashboard ">    
      
      public static Object getImprovedSeedGF()
    {
       
        String q = "match (n:AGENT) where n.agenttype =~'MOFA' WITH n match (f:FARMER)-[HAS_PRODUCTION_UPDATE]-(u) where f.CreatedById=n.Id "
                + "return SUM(CASE u.nameofvarietymz WHEN NULL THEN 0 "
                + " WHEN \"local variety\" THEN 0 WHEN \"other\" THEN 0 ELSE 1 END) + "
                + "SUM(CASE u.nameofhybridmz WHEN NULL THEN 0    WHEN \"local variety\" THEN 0  WHEN \"other\" THEN 0 ELSE 1 END)"
                + "+SUM(CASE u.nameofvarietyrice WHEN NULL THEN 0 WHEN \"local variety\" THEN 0  WHEN \"other\" THEN 0 ELSE 1 END) as l"; 
        
        return Neo4jServices.getAggregateItem(q);
    }
      
    
      
      
      
      
      
   // </editor-fold>  
  //<editor-fold defaultstate="collapsed" desc=" MOFA Dashboard ">    
     
        public static Object getCropDensityMOFA()
   {
        String q = "match (n:AGENT) where n.agenttype = 'MOFA' WITH n match (f:FARMER)-[HAS_PRODUCTION_UPDATE]-(u) where f.CreatedById=n.Id return "
                + "SUM(CASE u.croparrangeupdate WHEN NULL THEN 0 "
                + "WHEN \"Arranged rows with specific ditance between rows and also between plants\" THEN 1  END)  as l"; 
        
        return Neo4jServices.getAggregateItem(q); 
   }
        
  public static Object getPrePlantHerbiceideMOFA()
   {
       String q = "match (n:AGENT) where n.agenttype ='MOFA' WITH n match (f:FARMER)-[:HAS_PRODUCTION_UPDATE]->(u) where f.CreatedById=n.Id return "
               + "SUM(CASE u.methodoflandclearing WHEN NULL THEN 0"
               + " WHEN \"Slashing and application of herbicide\" THEN 1 WHEN \"Herbicide application\" THEN 1  END)  as l"; 
        
        return Neo4jServices.getAggregateItem(q); 
   }   
        
 
   public static Object getPostPlantHerbiceideMOFA()
   {
       String q = "match (n:AGENT) where n.agenttype ='MOFA WITH n match (f:FARMER)-[:HAS_PRODUCTION_UPDATE]->(u)"
               + " where f.CreatedById=n.Id return SUM(CASE u.postplantherbicidefrequency WHEN NULL THEN 0"
               + "   WHEN '0' THEN 0 ELSE 1  END)  as l"; 
        
        return Neo4jServices.getAggregateItem(q); 
   }  
    
      // </editor-fold> 
   
   //<editor-fold defaultstate="collapsed" desc=" OB Dashboard ">  
   
   public Object getOBPlanTotalAcres(String agentId) 
   {
    String q = "MATCH (f:FARMER)-[:HAS_PRODUCTION]-(pc) WHERE f.CreatedById='"+agentId+"' return sum(toInt(pc.acresofland))  as l"; 
        
        return Neo4jServices.getAggregateItem(q); 
   
   }
   
   
  public Object getOBActualTotalAcres(String agentId) 
   {
    String q = "MATCH (f:FARMER)-[:HAS_PRODUCTION_UPDATE]-(pc) WHERE f.CreatedById='"+agentId+"' return sum(toInt(pc.landareacultivaredupdate))  as l"; 
        
        return Neo4jServices.getAggregateItem(q); 
   
   }
  
  
   public Object getOBPlanMaxAcres(String agentId) 
   {
    String q = "MATCH (f:FARMER)-[:HAS_PRODUCTION]-(pc) WHERE f.CreatedById='"+agentId+"' return max(pc.acresofland)  as l"; 
        
        return Neo4jServices.getAggregateItem(q); 
   
   }
   
  
  public Object getOBActualMaxAcres(String agentId) 
   {
    String q = "MATCH (f:FARMER)-[:HAS_PRODUCTION_UPDATE]-(pc) WHERE f.CreatedById='"+agentId+"' return max(pc.landareacultivaredupdate)  as l"; 
        
        return Neo4jServices.getAggregateItem(q); 
   
   }
  
   public Object getOBPlanMinAcres(String agentId) 
   {
    String q = "MATCH (f:FARMER)-[:HAS_PRODUCTION]-(pc) WHERE f.CreatedById='"+agentId+"' return min(pc.acresofland)  as l"; 
        
        return Neo4jServices.getAggregateItem(q); 
   
   }
   
    public Object getOBActualMinAcres(String agentId) 
   {
    String q = "MATCH (f:FARMER)-[:HAS_PRODUCTION_UPDATE]-(pc) WHERE f.CreatedById='"+agentId+"' return min(pc.landareacultivaredupdate)  as l"; 
        
        return Neo4jServices.getAggregateItem(q); 
   
   }
    
    
    public Object getOBPlanAvgAcres(String agentId) 
   {
    String q = "MATCH (f:FARMER)-[:HAS_PRODUCTION]-(pc) WHERE f.CreatedById='"+agentId+"' return avg(toInt(pc.acresofland))  as l"; 
        
        return Neo4jServices.getAggregateItem(q); 
   
   }
   
    
   public Object getOBActualAvgAcres(String agentId) 
   {
    String q = "MATCH (f:FARMER)-[:HAS_PRODUCTION_UPDATE]-(pc) WHERE f.CreatedById='"+agentId+"' return avg(toInt(pc.landareacultivaredupdate))  as l"; 
        
        return Neo4jServices.getAggregateItem(q); 
   
   }
   //</editor-fold>
   
   
   private String toTwoDecimalPlaces(double value)
   {
       DecimalFormat df = new DecimalFormat("#.##");
       return df.format(value);
   }
}
