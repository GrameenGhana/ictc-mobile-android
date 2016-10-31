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
    
    public String getProgress(Long indicatorCount,double target)
    {
        return toTwoDecimalPlaces((indicatorCount/target)*100);
    }
    
    public String getFarmerRegistrationProgressForACDI()
    {
        return toTwoDecimalPlaces((bio.getACDIVOCAFarmerCount()/ICTCKonstants.ACDIVOCA_TARGET)*100);
    }
    
     public String getFarmerRegistrationProgressForMOFA()
    {
        return toTwoDecimalPlaces((bio.getMOFAFarmerCount()/ICTCKonstants.MOFA_TARGET)*100);
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
   
   public static Object getOBPlanTotalAcres(String agentId) 
   {
    String q = "MATCH (f:FARMER)-[:HAS_PRODUCTION]-(pc) WHERE f.CreatedById='"+agentId+"' return sum(toInt(pc.acresofland))  as l"; 
        
       return Neo4jServices.getAggregateItem(q); 
//      String value= "0";
//       System.out.println("value " + Neo4jServices.getAggregateItem(q));
//       try{
//          if(null==Neo4jServices.getAggregateItem(q))
//            value ="0";
//        else
//            value = (String)Neo4jServices.getAggregateItem(q);
//              
//       } 
//       catch(Exception e )
//       {
//           value="0";
//             e.printStackTrace();
//       }
//       
//        return value; 
   
   }
   
   
  public static int getOBActualTotalAcres(String agentId) 
   {
       
       
    String q = "MATCH (f:FARMER)-[:HAS_PRODUCTION_UPDATE]-(pc) WHERE f.CreatedById='"+agentId+"' return sum(toInt(pc.landareacultivaredupdate))  as l"; 
    System.out.println("value " + Neo4jServices.getAggregateItem(q));
       int value= 0;
       System.out.println("value " + Neo4jServices.getAggregateItem(q));
       try{
          if(null==Neo4jServices.getAggregateItem(q))
            value =0;
        else
            value = (int)Neo4jServices.getAggregateItem(q);
              
       } 
       catch(Exception e )
       {
           value=0;
             e.printStackTrace();
       }
       
        return value; 
   
   }
  
  
   public static String getOBPlanMaxAcres(String agentId) 
   {
    String q = "MATCH (f:FARMER)-[:HAS_PRODUCTION]-(pc) WHERE f.CreatedById='"+agentId+"' return max(pc.acresofland)  as l"; 
        
       // return  (long)Neo4jServices.getAggregatedValue(q); 
       String value= "0";
       System.out.println("value " + Neo4jServices.getAggregateItem(q));
       try{
          if(null==Neo4jServices.getAggregateItem(q))
            value ="0";
        else
            value = (String)Neo4jServices.getAggregateItem(q);
              
       } 
       catch(Exception e )
       {
           value="0";
             e.printStackTrace();
       }
       
        return value; 
   
   }
   
  
  public static String getOBActualMaxAcres(String agentId) 
   {
    String q = "MATCH (f:FARMER)-[:HAS_PRODUCTION_UPDATE]-(pc) WHERE f.CreatedById='"+agentId+"' return max(pc.landareacultivaredupdate)  as l"; 
        
        //return Neo4jServices.getAggregatedValue(q); 
     
      String value= "0";
       System.out.println("value " + Neo4jServices.getAggregateItem(q));
       try{
          if(null==Neo4jServices.getAggregateItem(q))
            value ="0";
        else
            value = (String)Neo4jServices.getAggregateItem(q);
              
       } 
       catch(Exception e )
       {
           value="0";
             e.printStackTrace();
       }
       
        return value; 
   
   
   }
  
   public static String getOBPlanMinAcres(String agentId) 
   {
    String q = "MATCH (f:FARMER)-[:HAS_PRODUCTION]-(pc) WHERE f.CreatedById='"+agentId+"' return min(pc.acresofland)  as l"; 
        
        // return Neo4jServices.getAggregatedValue(q); 
     String value= "0";
       System.out.println("value " + Neo4jServices.getAggregateItem(q));
       try{
          if(null==Neo4jServices.getAggregateItem(q))
            value ="0";
        else
            value = (String)Neo4jServices.getAggregateItem(q);
              
       } 
       catch(Exception e )
       {
           value="0";
             e.printStackTrace();
       }
       
        return value; 
   
   }
   
    public static String getOBActualMinAcres(String agentId) 
   {
    String q = "MATCH (f:FARMER)-[:HAS_PRODUCTION_UPDATE]-(pc) WHERE f.CreatedById='"+agentId+"' return min(pc.landareacultivaredupdate)  as l"; 
        
        //return Neo4jServices.getAggregateItem(q); 
      String value= "0";
       System.out.println("value " + Neo4jServices.getAggregateItem(q));
       try{
          if(null==Neo4jServices.getAggregateItem(q))
            value ="0";
        else
            value = (String)Neo4jServices.getAggregateItem(q);
              
       } 
       catch(Exception e )
       {
           value="0";
             e.printStackTrace();
       }
       
        return value; 
   
   }
    
    
    public static double getOBPlanAvgAcres(String agentId) 
   {
    String q = "MATCH (f:FARMER)-[:HAS_PRODUCTION]-(pc) WHERE f.CreatedById='"+agentId+"' return avg(toInt(pc.acresofland))  as l"; 
        
       // return Neo4jServices.getAggregateItem(q); 
      double value= 0;
       System.out.println("value " + Neo4jServices.getAggregateItem(q));
       try{
          if(null==Neo4jServices.getAggregateItem(q))
            value =0;
        else
            value = (double)Neo4jServices.getAggregateItem(q);
              
       } 
       catch(Exception e )
       {
           value=0;
             e.printStackTrace();
       }
       
        return value; 
   
   }
   
    
   public static String getOBActualAvgAcres(String agentId) 
   {
    String q = "MATCH (f:FARMER)-[:HAS_PRODUCTION_UPDATE]-(pc) WHERE f.CreatedById='"+agentId+"' return avg(toInt(pc.landareacultivaredupdate))  as l"; 
        
        //return Neo4jServices.getAggregateItem(q); 
     String value= "0";
       System.out.println("value " + Neo4jServices.getAggregateItem(q));
       try{
          if(null==Neo4jServices.getAggregateItem(q))
            value ="0";
        else
            value = (String)Neo4jServices.getAggregateItem(q);
              
       } 
       catch(Exception e )
       {
           value="0";
             e.printStackTrace();
       }
       
        return value; 
   }
   
   
    public static double getOBPlanAvgYieldAcre(String agentId) 
   {
    String q = "MATCH (f:FARMER)-[:HAS_PRODUCTION]-(pc) WHERE f.CreatedById='"+agentId+"' return avg(toInt(pc.targetyieldperacre)) as l"; 
        
        //return Neo4jServices.getAggregateItem(q); 
     double value= 0;
       System.out.println("value " + Neo4jServices.getAggregateItem(q));
       try{
          if(null==Neo4jServices.getAggregateItem(q))
            value =0;
        else
            value = (double)Neo4jServices.getAggregateItem(q);
              
       } 
       catch(Exception e )
       {
           value=0;
             e.printStackTrace();
       }
       
        return value; 
   
   }
   
    
  public static double getOBActualAvgYieldAcre(String agentId) 
   {
    String q = "MATCH (f:FARMER)-[:HAS_POSTHARVEST_UPDATE]-(pc) WHERE f.CreatedById='"+agentId+"' return avg(toInt(pc.total_yield_update)) as l"; 
        
       // return Neo4jServices.getAggregateItem(q); 
     double value= 0;
       System.out.println("value " + Neo4jServices.getAggregateItem(q));
       try{
          if(null==Neo4jServices.getAggregateItem(q))
            value =0;
        else
            value = (double)Neo4jServices.getAggregateItem(q);
              
       } 
       catch(Exception e )
       {
           value=0;
             e.printStackTrace();
       }
       
        return value; 
   
   }
   
   public static long  getOBPlanTotalProduction(String agentId) 
   {
    String q = "MATCH (f:FARMER)-[:HAS_PRODUCTION]-(pc) WHERE f.CreatedById='"+agentId+"'"
            + " return sum(toInt(pc.targetyieldperacre) * toInt(pc.acresofland)) as l"; 
        
        //return Neo4jServices.getAggregateItem(q); 
     long value= 0;
       System.out.println("value " + Neo4jServices.getAggregateItem(q));
       try{
          if(null==Neo4jServices.getAggregateItem(q))
            value =0;
        else
            value = (long)Neo4jServices.getAggregateItem(q);
              
       } 
       catch(Exception e )
       {
           value=0;
             e.printStackTrace();
       }
       
        return value; 
   
   }
   
     public static long  getOBActualTotalProduction(String agentId) 
   {
       String q = "MATCH (f:FARMER)-[:HAS_POSTHARVEST_UPDATE]-(pc) WHERE f.CreatedById='" + agentId + "'"
               + " return sum(toInt(pc.landareacultivaredupdate) * toInt(pc.total_yield_update)) as l";

       //return Neo4jServices.getAggregateItem(q);
       long value= 0;
       System.out.println("value " + Neo4jServices.getAggregateItem(q));
       try{
          if(null==Neo4jServices.getAggregateItem(q))
            value =0;
        else
            value = (long)Neo4jServices.getAggregateItem(q);
              
       } 
       catch(Exception e )
       {
           value=0;
             e.printStackTrace();
       }
       
        return value; 
   
              

   }
     
     
   //Farm Credit Plan
     public static Object getOBPlanFarmersCredit(String agentId)
     {
         String q = "MATCH (f:FARMER)-[:HAS_FARMCREDIT_PLAN]-(pc) WHERE f.CreatedById='" + agentId + "' "
                 + " return SUM(CASE pc.credittypec  WHEN NULL THEN 0 WHEN 'Regular produce buyer' THEN 1 WHEN 'Regular buyer and others' THEN 1 ELSE 0  END) as l";

         return Neo4jServices.getAggregateItem(q);
     }
   
     public static Object getOBActualFarmersCredit(String agentId)
     {
         String q = "MATCH (f:FARMER)-[:HAS_FARMCREDIT_UPDATE]-(pc) WHERE f.CreatedById='"+agentId+"' "
                 + " return SUM(CASE pc.creditortypeupdate  WHEN NULL THEN 0 WHEN 'Regular produce buyer' THEN 1 WHEN 'Regular produce buyer and other creditors' THEN 1 ELSE 0  END) as l";

         return Neo4jServices.getAggregateItem(q);
     }
  
     
   public static Object getOBPlanCashCredit(String agentId)
     {
         String q = "MATCH (f:FARMER)-[:HAS_FARMCREDIT_PLAN]-(pc) "
                 + "WHERE f.CreatedById='"+agentId +"' AND (pc.credittypec='Regular produce buyer' OR pc.credittypec='Regular buyer and others') "
                 + " return SUM(CASE pc.creditmodec  WHEN NULL THEN 0 WHEN 'Cash only' THEN 1 WHEN 'Cash and inputs only' THEN 1 WHEN 'Cash and services only' THEN 1 WHEN 'Cash,inputs and services' THEN 1 ELSE 0  END) as l";

         return Neo4jServices.getAggregateItem(q);
     }
   
   
    public static Object getOBActualCashCredit(String agentId)
     {
         String q = "MATCH (f:FARMER)-[:HAS_FARMCREDIT_UPDATE]-(pc) "
                 + "WHERE f.CreatedById='"+agentId+"' AND (pc.creditortypeupdate='Regular produce buyer' OR pc.creditortypeupdate='Regular produce buyer and other creditors') "
                 + " return SUM(CASE pc.creditmodeupdate  WHEN NULL THEN 0 WHEN 'Cash only' THEN 1 WHEN 'Cash and inputs only' THEN 1 WHEN 'Cash and services only' THEN 1 WHEN 'Cash,inputs and services' THEN 1 ELSE 0  END) as l";

         return Neo4jServices.getAggregateItem(q);
     }
   
   public static Object getOBPlanInputCredit(String agentId)
     {
         String q = "MATCH (f:FARMER)-[:HAS_FARMCREDIT_PLAN]-(pc)"
                 + " WHERE f.CreatedById='"+agentId+"' AND (pc.credittypec='Regular produce buyer' OR pc.credittypec='Regular buyer and others') "
                 + " return SUM(CASE pc.creditmodec  WHEN NULL THEN 0 WHEN 'Input only' THEN 1 WHEN 'Cash and inputs only' THEN 1 WHEN 'Input and services only' THEN 1 WHEN 'Cash,inputs and services' THEN 1 ELSE 0  END) as l";

         return Neo4jServices.getAggregateItem(q);
     }
    
    public static Object getOBActualInputCredit(String agentId)
     {
         String q = "MATCH (f:FARMER)-[:HAS_FARMCREDIT_UPDATE]-(pc)"
                 + " WHERE f.CreatedById='"+agentId+"' AND (pc.creditortypeupdate='Regular produce buyer' OR pc.creditortypeupdate='Regular produce buyer and other creditors') "
                 + " return SUM(CASE  pc.creditmodeupdate  WHEN NULL THEN 0 WHEN 'Input only' THEN 1 WHEN 'Cash and inputs only' THEN 1 WHEN 'Input and services only' THEN 1 WHEN 'Cash,inputs and services' THEN 1 ELSE 0  END) as l";

         return Neo4jServices.getAggregateItem(q);
     }
   
     public static Object getOBPlanTotalCashCredit(String agentId)
     {
         String q = "MATCH (f:FARMER)-[:HAS_FARMCREDIT_PLAN]-(pc) WHERE f.CreatedById='"+agentId+"' "
                 + " return SUM(toInt(pc.creditcashrecievedquantumc)) as l";

         return Neo4jServices.getAggregateItem(q);
     }
     
      public static Object getOBActualTotalCashCredit(String agentId)
     {
         String q = "MATCH (f:FARMER)-[:HAS_FARMCREDIT_UPDATE]-(pc) WHERE f.CreatedById='"+agentId+"'  "
                 + "return SUM(toInt(pc.creditcashreceivedquantum)) as l";

         return Neo4jServices.getAggregateItem(q);
     }
      
      public static Object getOBPlanTotalCashCreditBack(String agentId)
      {
          String q = "MATCH (f:FARMER)-[:HAS_FARMCREDIT_PLAN]-(pc) WHERE f.CreatedById='"+agentId+"' "
                  + "AND (pc.credittypec='Regular produce buyer' OR pc.credittypec='Regular buyer and others')  "
                  + "return SUM(toInt(pc.creditcashpaybackexpectedc)) as l";

         return Neo4jServices.getAggregateItem(q);
      }
      
      public static Object getOBActualTotalCashCreditBack(String agentId)
      {
          String q = "MATCH (f:FARMER)-[:HAS_FARMCREDIT_UPDATE]-(pc) WHERE f.CreatedById='"+agentId+"'"
                  + " AND (pc.creditortypeupdate='Regular produce buyer' OR pc.creditortypeupdate='Regular produce buyer and other creditors') "
                  + " return SUM(pc.creditcashpaybackactualu) as l";

         return Neo4jServices.getAggregateItem(q);
      }
      
      
      public static Object getOBPlanTotalQtyProduceBack(String agentId)
      {
          String q = "MATCH (f:FARMER)-[:HAS_FARMCREDIT_PLAN]-(pc) WHERE f.CreatedById='"+agentId+"' "
                  + "AND (pc.credittypec='Regular produce buyer' OR pc.credittypec='Regular buyer and others')  "
                  + "return SUM(toInt(pc.creditproducepaybackexpectedc)) as l";

         return Neo4jServices.getAggregateItem(q);
      }
      
        public static Object getOBActualTotalQtyProduceBack(String agentId)
      {
          String q = "MATCH (f:FARMER)-[:HAS_FARMCREDIT_UPDATE]-(pc) WHERE f.CreatedById='"+agentId+"' "
                  + "AND (pc.creditortypeupdate='Regular produce buyer' OR pc.creditortypeupdate='Regular produce buyer and other creditors') "
                  + " return SUM(toInt(pc.creditproducepaybackquantumu)) as l";

         return Neo4jServices.getAggregateItem(q);
      }
        
       public static Object getOBPlanSeedOnCredit(String agentId)
      {
       String q = "MATCH (f:FARMER)-[:HAS_FARMCREDIT_PLAN]-(pc) WHERE f.CreatedById='"+agentId+"'"
               + " AND (pc.credittypec='Regular produce buyer' OR pc.credittypec='Regular buyer and others') "
               + " return SUM(toInt(pc.creditseedc)) as l";

         return Neo4jServices.getAggregateItem(q);
      } 
      
        public static Object getOBActualSeedOnCredit(String agentId)
      {
       String q = "MATCH (f:FARMER)-[:HAS_FARMCREDIT_UPDATE]-(pc) WHERE f.CreatedById='"+agentId+"' "
               + "AND (pc.creditortypeupdate='Regular produce buyer' OR pc.creditortypeupdate='Regular produce buyer and other creditors') "
               + " return SUM(toInt(pc.creditseedu)) as l";

         return Neo4jServices.getAggregateItem(q);
      } 
   
      public static Object getOBPlanFertilizerOnCredit(String agentId)
      {
       String q = "MATCH (f:FARMER)-[:HAS_FARMCREDIT_PLAN]-(pc) WHERE f.CreatedById='"+agentId+"' "
               + "AND (pc.credittypec='Regular produce buyer' OR pc.credittypec='Regular buyer and others')"
               + "  return SUM(toInt(pc.creditinorganicfertilizerc)) as l";

         return Neo4jServices.getAggregateItem(q);
      } 
      
      public static Object getOBActualFertilizereOnCredit(String agentId)
      {
       String q = "MATCH (f:FARMER)-[:HAS_FARMCREDIT_UPDATE]-(pc) WHERE f.CreatedById='"+agentId+"'"
               + " AND (pc.creditortypeupdate='Regular produce buyer' OR pc.creditortypeupdate='Regular produce buyer and other creditors')"
               + " return SUM(toInt(pc.creditinorganicfertilizer)) as l";

         return Neo4jServices.getAggregateItem(q);
      } 
      
      public static Object getOBPlanPrePHerbicideOnCredit(String agentId)
      {
       String q = "MATCH (f:FARMER)-[:HAS_FARMCREDIT_PLAN]-(pc) WHERE f.CreatedById='"+agentId+"' "
               + "AND (pc.credittypec='Regular produce buyer' OR pc.credittypec='Regular buyer and others') "
               + " return SUM(toInt(pc.creditpreplantherbicidec)) as l";

         return Neo4jServices.getAggregateItem(q);
      } 
      
      public static Object getOBActualPrePHerbicideOnCredit(String agentId)
      {
       String q = "MATCH (f:FARMER)-[:HAS_FARMCREDIT_UPDATE]-(pc) WHERE f.CreatedById='"+agentId+"'"
               + " AND (pc.creditortypeupdate='Regular produce buyer' OR pc.creditortypeupdate='Regular produce buyer and other creditors') "
               + " return SUM(toInt(pc.creditpreplantherbicide)) as l";

         return Neo4jServices.getAggregateItem(q);
      } 
      
       public static Object getOBPlanPostPHerbicideOnCredit(String agentId)
      {
       String q = "MATCH (f:FARMER)-[:HAS_FARMCREDIT_PLAN]-(pc) WHERE f.CreatedById='"+agentId+"' "
               + "AND (pc.credittypec='Regular produce buyer' OR pc.credittypec='Regular buyer and others') "
               + " return SUM(CASE pc.creditpostplantherbicidec WHEN NULL THEN 0 WHEN 'Yes' THEN 1 ELSE 0 END ) as l";

         return Neo4jServices.getAggregateItem(q);
      } 
      
       public static Object getOBActualPostPHerbicideOnCredit(String agentId)
      {
       String q = "MATCH (f:FARMER)-[:HAS_FARMCREDIT_UPDATE]-(pc) WHERE f.CreatedById='"+agentId+"' "
               + "AND (pc.creditortypeupdate='Regular produce buyer' OR pc.creditortypeupdate='Regular produce buyer and other creditors')  "
               + "return SUM(CASE pc.creditpostplantherbicideu WHEN NULL THEN 0 WHEN 'Yes' THEN 1 ELSE 0 END) as l";

         return Neo4jServices.getAggregateItem(q);
      } 
       
        public static Object getOBPlanPloughingOnCredit(String agentId)
      {
       String q = "MATCH (f:FARMER)-[:HAS_FARMCREDIT_PLAN]-(pc) WHERE f.CreatedById='"+agentId+"'"
               + " AND (pc.credittypec='Regular produce buyer' OR pc.credittypec='Regular buyer and others') "
               + " return SUM(CASE pc.creditploughingc WHEN NULL THEN 0 WHEN 'Yes' THEN 1 ELSE 0 END ) as l";

         return Neo4jServices.getAggregateItem(q);
      } 
        
        public static Object getOBActualPloughingOnCredit(String agentId)
      {
       String q = "MATCH (f:FARMER)-[:HAS_FARMCREDIT_UPDATE]-(pc) WHERE f.CreatedById='"+agentId+"' "
               + "AND (pc.creditortypeupdate='Regular produce buyer' OR pc.creditortypeupdate='Regular produce buyer and other creditors')  "
               + "return SUM(CASE pc.creditploughing WHEN NULL THEN 0 WHEN 'Yes' THEN 1 ELSE 0 END) as l";

         return Neo4jServices.getAggregateItem(q);
      } 
        
       public static Object getOBPlanThreshingOnCredit(String agentId)
      {
       String q = "MATCH (f:FARMER)-[:HAS_FARMCREDIT_PLAN]-(pc) WHERE f.CreatedById='"+agentId+"' "
               + "AND (pc.credittypec='Regular produce buyer' OR pc.credittypec='Regular buyer and others')  "
               + "return SUM(CASE pc.creditthreshingc WHEN NULL THEN 0 WHEN 'Yes' THEN 1 ELSE 0 END ) as l";

         return Neo4jServices.getAggregateItem(q);
      }   
        
       
        public static Object getOBActualThreshingOnCredit(String agentId)
      {
       String q = "MATCH (f:FARMER)-[:HAS_FARMCREDIT_UPDATE]-(pc) WHERE f.CreatedById='"+agentId+"' "
               + "AND (pc.creditortypeupdate='Regular produce buyer' OR pc.creditortypeupdate='Regular produce buyer and other creditors') "
               + " return SUM(CASE pc.creditthreshing WHEN NULL THEN 0 WHEN 'Yes' THEN 1 ELSE 0 END) as l";

         return Neo4jServices.getAggregateItem(q);
      }
        
         public static Object getOBPlanTransportOnCredit(String agentId)
      {
       String q = "MATCH (f:FARMER)-[:HAS_FARMCREDIT_PLAN]-(pc) WHERE f.CreatedById='"+agentId+"' AND"
               + " (pc.credittypec='Regular produce buyer' OR pc.credittypec='Regular buyer and others') "
               + " return SUM(CASE pc.credittransportc WHEN NULL THEN 0 WHEN 'Yes' THEN 1 ELSE 0 END ) as l";

         return Neo4jServices.getAggregateItem(q);
      }   
         
       public static Object getOBActualTransportOnCredit(String agentId)
      {
       String q = "MATCH (f:FARMER)-[:HAS_FARMCREDIT_UPDATE]-(pc) WHERE f.CreatedById='"+agentId+"' "
               + "AND (pc.creditortypeupdate='Regular produce buyer' OR pc.creditortypeupdate='Regular produce buyer and other creditors') "
               + " return SUM(CASE pc.credittransportupdate WHEN NULL THEN 0 WHEN 'Yes' THEN 1 ELSE 0 END) as l";

         return Neo4jServices.getAggregateItem(q);
      }   
      
       
       
       public static Object getOBPlanStorageOnCredit(String agentId)
      {
       String q = "MATCH (f:FARMER)-[:HAS_FARMCREDIT_PLAN]-(pc) WHERE f.CreatedById='"+agentId+"' "
               + "AND (pc.credittypec='Regular produce buyer' OR pc.credittypec='Regular buyer and others')  "
               + "return SUM(CASE pc.creditproducestoragec WHEN NULL THEN 0 WHEN 'Yes' THEN 1 ELSE 0 END ) as l";

         return Neo4jServices.getAggregateItem(q);
      } 
       
       public static Object getOBActualStorageOnCredit(String agentId)
      {
       String q = "MATCH (f:FARMER)-[:HAS_FARMCREDIT_UPDATE]-(pc) WHERE f.CreatedById='"+agentId+"' "
               + "AND (pc.creditortypeupdate='Regular produce buyer' OR pc.creditortypeupdate='Regular produce buyer and other creditors') "
               + " return SUM(CASE pc.creditproducestorage WHEN NULL THEN 0 WHEN 'Yes' THEN 1 ELSE 0 END) as l";

         return Neo4jServices.getAggregateItem(q);
      }  
       
   //</editor-fold>
   
   
   public static String toTwoDecimalPlaces(double value)
   {
       DecimalFormat df = new DecimalFormat("#.##");
       return df.format(value);
   }
}
